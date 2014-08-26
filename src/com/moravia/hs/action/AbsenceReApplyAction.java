package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.AbsencerequestitemDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.dao.TokenAbsenceDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.Absencerequestlog;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.TokenAbsence;
import com.moravia.hs.base.entity.Vacationtype;
import com.moravia.hs.base.entity.other.AbsenceRequestEntity;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.util.SendNotificationMail;

@Controller("absenceReApplyAction")
public class AbsenceReApplyAction extends BaseAction {

	@Autowired
	private AbsencerecordDAO absencerecordDAO;
	
	@Autowired
	private AbsencerequestitemDAO absencerequestitemDAO;
	
	@Autowired
	private TokenAbsenceDAO tokenAbsenceDAO;
	
	@Autowired
	private VacationtypeDAO vacationtypeDAO;
	
	@Autowired
	private LoginviewDAO loginviewDAO;
	
	@Autowired
	private RequeststateDAO requeststateDAO;
	
	@Autowired
	private EmpDAO empDAO;
	
	public static Map<String, Object> session;
	
	private AbsenceRequestEntity absenceRequestEntity;
	
	
	public AbsenceRequestEntity getAbsenceRequestEntity() {
		return absenceRequestEntity;
	}

	public void setAbsenceRequestEntity(AbsenceRequestEntity absenceRequestEntity) {
		this.absenceRequestEntity = absenceRequestEntity;
	}
	
	
	/**
	 * ReApply
	 * @return
	 * @throws ParseException 
	 */
	public String reApply() throws ParseException {
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("请登录!");
			session.put("globalError", "请先登录！");
			return ERROR;
		}
		
		Timestamp ts = new Timestamp((new Date()).getTime());
		// 设置absenceRecord的状态 - RequestState
		List<Requeststate> rss = requeststateDAO.findAll();
		
		// 创建 找到之前存在的record
//		Absencerecord ar = new Absencerecord();
		Absencerecord ar = absencerecordDAO.findById(absenceRequestEntity.getId());
		
		// 创建log
		Absencerequestlog alog = new Absencerequestlog();
		
		alog.setAbsencerecord(ar);	//	关联absenceRecord
		alog.setChangeDate(ts);	// 变更日期
		alog.setChangePeople(login.getEmp().getEmpLoginId());	// 修改人
		alog.setLogDesc(login.getEmp().getEmpLoginId() + " reapplied a leave request.");	// 描述
		Set<Absencerequestlog> alogs = new HashSet<Absencerequestlog>();	// alog集合
		alogs.add(alog);
		
		for (Requeststate rs : rss) {
			if(rs.getStateName().equals("InProg")) {
				// 设置状态为In Progress
				ar.setRequeststate(rs);
				alog.setRequeststate(rs);
			}
		}
		
		// ar关联alogs
		ar.setAbsencerequestlogs(alogs);
		
		ar.setEmpLoginId(login.getEmp().getEmpLoginId()); // 请假申请人
		ar.setAbsenceReason(absenceRequestEntity.getReason().trim()); // Reason
		ar.setAbsenceApproverLineManager(absenceRequestEntity.getLm().trim()); // Line Manager
		ar.setAbsenceApproverPm(absenceRequestEntity.getPm().trim());  // PM
		
		/**
		 * 首先删除ar绑定的所有absenceRecordItem
		 */
		Set<Absencerequestitem> items = ar.getAbsencerequestitems();
		ar.setAbsencerequestitems(null);
		for (Absencerequestitem item : items) {
//			item.setAbsencerecord(null);
			absencerequestitemDAO.delete(item);
		}
		
		/**
		 *  然后重新 创建 AbsencerecordItems
		 */
		String[] types = absenceRequestEntity.getTypes().trim().split(";");
		String[] startTimes = absenceRequestEntity.getStarts().trim().split(";");
		String[] endTimes = absenceRequestEntity.getEnds().trim().split(";");
		
		// 获取所有假期类型信息
		List<Vacationtype> vacationtypes = vacationtypeDAO.findAll();
		
		// AbsencerequestItem 集合
		Set<Absencerequestitem> ais = new HashSet<Absencerequestitem>();
		Double totalHours = 0.0;	// AbsenceRecord total hours
		
		// 三个数组长度相等才正常
		if(types.length == startTimes.length && types.length == endTimes.length) {
			// System.out.println("三个数组长度相等");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			DecimalFormat df = new DecimalFormat("#.0");
			for(int i = 0; i < types.length; i++) {
				// 创建新的 Absencerequestitem
				Absencerequestitem ai = new Absencerequestitem();
				
				// 解析 startTime
				Date startDate = sdf.parse(startTimes[i].trim());
				Timestamp startTs = new Timestamp(startDate.getTime());
				
				// System.out.println("startTs: " + startTs);
				
				ai.setAbsenceStartTime(startTs);
				
				// 解析 endTime
				Date endDate = sdf.parse(endTimes[i].trim());
				Timestamp endTs = new Timestamp(endDate.getTime());
				ai.setAbsenceEndTime(endTs);
				
				double diff = (endDate.getTime() - startDate.getTime());
				// System.out.println("value of diff: " + diff);
				// diff 小于0， 抛出异常
				if(diff < 0) {
					return ERROR;
				}
				
				// 设置absencehours
				double d = diff / (1000 * 60 * 60);
				// System.out.println("value of d: " + d);
				d = Double.valueOf(df.format(d));
				// System.out.println("df.format(d): " + df.format(d));
				ai.setAbsenceHours(d);
				totalHours += d;
				
				// Item 关联absenceRecord对象
				ai.setAbsencerecord(ar);
				
				// absence Type 请假类型
				int typeId = Integer.parseInt(types[i].trim());
				for (Vacationtype vt : vacationtypes) {
					if(vt.getVacationTypeId() == typeId) {
						//关联vacationType
						ai.setVacationtype(vt);
						ai.setAbsenceType(vt.getVacationTypeName());
						break;
					}
				}
				// 关联 AbsenceRecord对象
				ai.setAbsencerecord(ar);
				
				// absencerequestItem 对象加入到集合中
				// System.out.println("absencerequestItem 对象加入到集合中...");
				ais.add(ai);
			}
			
			// ar关联ai集合
			// System.out.println("ar关联ai集合...");
			ar.setAbsenceTotalHours(totalHours);
			ar.setAbsencerequestitems(ais);

			
		} else {
			session.put("globalError", "types, startTimes 和 endTimes长度不一致");
			return ERROR;
		}
		
		/** 
		 * 改变token指向
		 */
		Set<TokenAbsence> tokens = ar.getTokenAbsences();
		for (TokenAbsence token : tokens) {
			token.setTokenState(1); 	// 激活token
			token.setTokenExecutor(absenceRequestEntity.getLm().trim());	// 再次传递给lm
		}
		
		// 保存更新
		System.out.println("伪save...");
		absencerecordDAO.saveOrUpdate(ar);
		
		
		//发邮件 提醒 LineManager
		String fromStr = login.getEmp().getEmpLoginId();
		Emp toEmp = empDAO.findByLoginName(ar.getAbsenceApproverLineManager());
		String toStr = toEmp.getEmail();
		
		SendNotificationMail snm = new SendNotificationMail();
		snm.setFrom(fromStr);
		snm.setTo(toStr);
		snm.setSubject(fromStr + " has reapplied an absence request.");
		snm.setTriggerBy(fromStr);
		snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
		snm.setLinkText("Link to Request Page.");
		snm.setType("Absence Request");
		snm.setRequestState(ar.getRequeststate().getStateName());
		snm.setTitle(fromStr + " reapplied an absence request to you.");
		snm.sendMail();
		// 发邮件提醒
		
		return SUCCESS;
	}
	
	
	/**
	 *	Load AbsenceRequestRejected 页面
	 */
	public String loadAbsenceRequestReject() {
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("请登录!");
			session.put("globalError", "请先登录！");
			return ERROR;
		}
		
		Absencerecord ar = absencerecordDAO.findById(absenceRequestEntity.getId());
		
		session.put("rejectabsencerecord", ar);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * Delete
	 * @param id
	 */
	public String cancelAbsenceRecord() {
		session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("请登录!");
			session.put("globalError", "请先登录！");
			return ERROR;
		}
		
		Timestamp ts = new Timestamp((new Date()).getTime());
		
		// ar 状态变为Cancelled
		Absencerecord ar = absencerecordDAO.findById(absenceRequestEntity.getId());
		Requeststate rs = requeststateDAO.findByStateName("Cancelled");		// 状态： 取消
		ar.setRequeststate(rs);
		
		// token 状态设置为0
		Set<TokenAbsence> tokens = ar.getTokenAbsences();
		
		for (TokenAbsence token : tokens) {
			token.setTokenState(0);
		}
		
		// 创建log
		Absencerequestlog alog = new Absencerequestlog();
		
		alog.setAbsencerecord(ar);	//	关联absenceRecord
		alog.setChangeDate(ts);	// 变更日期
		alog.setChangePeople(login.getEmp().getEmpLoginId());	// 修改人
		alog.setLogDesc(login.getEmp().getEmpLoginId() + " Cancelled a leave request.");	// 描述
		Set<Absencerequestlog> alogs = new HashSet<Absencerequestlog>();	// alog集合
		alogs.add(alog);
		alog.setRequeststate(rs);
		
		ar.setAbsencerequestlogs(alogs);
		
		absencerecordDAO.saveOrUpdate(ar);
		
		return SUCCESS;
	}
	
	
	
}
