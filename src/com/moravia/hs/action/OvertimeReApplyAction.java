package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.CostcenterDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.OvertimerecordDAO;
import com.moravia.hs.base.dao.OvertimerequestitemDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.dao.TokenOvertimeDAO;
import com.moravia.hs.base.entity.Absencerequestlog;
import com.moravia.hs.base.entity.Costcenter;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Overtimerecord;
import com.moravia.hs.base.entity.Overtimerequestitem;
import com.moravia.hs.base.entity.Overtimerequestlog;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.TokenAbsence;
import com.moravia.hs.base.entity.TokenOvertime;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.base.entity.other.OvertimeRequestEntity;
import com.moravia.hs.util.SendNotificationMail;

@Controller("overtimeReApplyAction")
public class OvertimeReApplyAction extends BaseAction {

	@Autowired
	private OvertimerecordDAO overtimerecordDAO;
	
	@Autowired
	private TokenOvertimeDAO tokenOvertimeDAO;
	
	@Autowired
	private RequeststateDAO requeststateDAO;
	
	@Autowired
	private CostcenterDAO costcenterDAO;
	
	@Autowired
	private EmpDAO empDAO;
	
	@Autowired
	private OvertimerequestitemDAO overtimerequestitemDAO;
	
	public static Map<String, Object> session;
	
	private OvertimeRequestEntity overtimeReApplyEntity;
	
	public OvertimeRequestEntity getOvertimeReApplyEntity() {
		return overtimeReApplyEntity;
	}

	public void setOvertimeReApplyEntity(OvertimeRequestEntity overtimeReApplyEntity) {
		this.overtimeReApplyEntity = overtimeReApplyEntity;
	}

	/**
	 * Absence Request reapply
	 * @return
	 * @throws ParseException 
	 */
	public String reApply() throws ParseException {
		System.out.println("进入 overtimeReApply reApply() 方法。。。");
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("请登录!");
			session.put("globalError", "请先登录！");
			return ERROR;
		}
		
		Timestamp ts = new Timestamp((new Date()).getTime());
		// 设置absenceRecord的状态 - RequestState
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");	// date format
		DecimalFormat df = new DecimalFormat("#.0");	// 四舍五入
		
		// 启动Token
//		TokenOvertime token = new TokenOvertime();
		
		Overtimerecord or = overtimerecordDAO.findById(overtimeReApplyEntity.getId());
		System.out.println("找到的or, or.getComments(): " + or.getComments());
		Set<TokenOvertime> tokens = or.getTokenOvertimes();
		
		for (TokenOvertime token : tokens) {
			token.setTokenState(1);
			token.setOvertimerecord(or);	// token 关联 or
			token.setTokenExecutor(overtimeReApplyEntity.getPm());	// 重新申请，再次转给 PM (先由PM通过，再由PM 转给 GM通过)
		}
		
//		or.setApplicant(login.getEmp().getEmpLoginId());
		or.setComments(overtimeReApplyEntity.getComments());
//		or.setCreatedate(ts);
		or.setGm(overtimeReApplyEntity.getGm());
		or.setPm(overtimeReApplyEntity.getPm());
		or.setProjectcode(overtimeReApplyEntity.getPcode());
		or.setProjectname(overtimeReApplyEntity.getPname());
		
		Requeststate rs = requeststateDAO.findByStateName("InProg");	// 设置RequestState
		or.setRequeststate(rs);	// 状态由 Reject 变成 Inprog
		
		/**
		 * 删除or绑定的所有overtimeRecordItem
		 */
		Set<Overtimerequestitem> items = or.getOvertimerequestitems();
		or.setOvertimerequestitems(null);
		for (Overtimerequestitem item : items) {
			// 删除 overtime request Item 对象
			overtimerequestitemDAO.delete(item);
		}
		
		/**
		 * 重新创建 OvertimerecordItem
		 */
		String[] startTimes = overtimeReApplyEntity.getStartTimes().split(";");
		String[] endTimes = overtimeReApplyEntity.getEndTimes().split(";");
		String[] loginIds = overtimeReApplyEntity.getEmps().split(";");
		
		if(startTimes.length != endTimes.length || startTimes.length != loginIds.length) {
			session.put("globalError", "时间跟用于名数量不一致");
			return ERROR;
		}
		
		Overtimerequestitem oi = null;
		Double totalHours = 0.0;	// 加班单总时间
		Set<Overtimerequestitem> ois = new HashSet<Overtimerequestitem>();
		for (int i = 0; i < loginIds.length; i++) {
			oi = new Overtimerequestitem();
			oi.setEmploginid(loginIds[i]);
			Emp emp = empDAO.findByLoginName(loginIds[i]);
			if(emp == null) {
				System.out.println("员工: " + loginIds[i] + "不存在，请查看");
				session.put("globalError", "员工: " + loginIds[i] + "不存在，请查看");
				return ERROR;
			}
			
			Costcenter costcenter = emp.getCostcenter();
			oi.setCostcenter(costcenter.getCostCenterName());
			
			Date startDate = sdf.parse(startTimes[i]);
			Date endDate = sdf.parse(endTimes[i]);
			double diff = endDate.getTime() - startDate.getTime();
			
			oi.setStarttime(new Timestamp(startDate.getTime()));
			oi.setEndtime(new Timestamp(endDate.getTime()));
			oi.setOvertimerecord(or);	// oi 关联 or
			
			double d = diff / (1000 * 60 * 60);
			d = Double.valueOf(df.format(d));
			oi.setHours(d);
			totalHours += d;
			
			ois.add(oi);
		}
		or.setTotalhours(totalHours);  // 加班单总小时数
		
		or.setOvertimerequestitems(ois);	// or 关联 oi
		
		// 创建Log
		Overtimerequestlog olog = new Overtimerequestlog();
		olog.setOvertimerecord(or);	// log 关联 or
		olog.setRequeststate(rs);
		olog.setChangeDate(ts);
		olog.setChangePeople(login.getEmp().getEmpLoginId());
		olog.setLogDesc(login.getEmp().getEmpLoginId() + " reapplied an overtime request."); 	// 描述
		Set<Overtimerequestlog> ologs = new HashSet<Overtimerequestlog>();
		ologs.add(olog);
		
		or.setOvertimerequestlogs(ologs);	// or 关联 log
		
		overtimerecordDAO.saveOrUpdate(or);
		
		//发邮件 提醒 Applicant
		String fromStr = login.getEmp().getEmpLoginId();
		Emp toEmp = empDAO.findByLoginName(or.getPm());	// 发邮件给PM
		String toStr = toEmp.getEmail();
		
		SendNotificationMail snm = new SendNotificationMail();
		snm.setFrom(fromStr);
		snm.setTo(toStr);
		snm.setSubject(fromStr + " has reapplied an overtime request.");
		snm.setTriggerBy(fromStr);
		snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
		snm.setLinkText("Link to Request Page.");
		snm.setType("Overtime Request");
		snm.setRequestState(or.getRequeststate().getStateName());
		snm.setTitle(fromStr + " reapplied an overtime request to you.");
		snm.sendMail();
		// 发邮件提醒

		return SUCCESS;
	}
	

	/**
	 * Load request reject page.
	 * @return
	 */
	public String loadOvertimeRequestReject() {
		System.out.println("进入 loadOvertimeRequestReject 方法");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("请登录!");
			session.put("globalError", "请先登录！");
			return ERROR;
		}
		
		Overtimerecord or = overtimerecordDAO.findById(overtimeReApplyEntity.getId());
		session.put("rejectovertimerecord", or);
		
		return SUCCESS;
	}
	
	
	public String cancelOvertimeRecord() {
		System.out.println("进入 cancelOvertimeRecord 方法");
		session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			System.out.println("请登录!");
			session.put("globalError", "请先登录！");
			return ERROR;
			
		}
		
		Timestamp ts = new Timestamp((new Date()).getTime());
		
		// or 状态设置为 Cancelled
		Overtimerecord or = overtimerecordDAO.findById(overtimeReApplyEntity.getId());
		Requeststate rs = requeststateDAO.findByStateName("Cancelled");
		or.setRequeststate(rs);
		
		// token 状态设置为0
		Set<TokenOvertime> tokens = or.getTokenOvertimes();
		
		for (TokenOvertime token : tokens) {
			token.setTokenState(0);
			System.out.println("set state 0, token.getTokenId(): " + token.getTokenId());
		}
		
		// 创建log
		Overtimerequestlog olog = new Overtimerequestlog();
		
		olog.setOvertimerecord(or);	// log 关联 or
		olog.setRequeststate(rs);
		olog.setChangeDate(ts);
		olog.setChangePeople(login.getEmp().getEmpLoginId());
		olog.setLogDesc(login.getEmp().getEmpLoginId() + " cancaled an overtime request."); 	// 描述
		Set<Overtimerequestlog> ologs = new HashSet<Overtimerequestlog>();
		ologs.add(olog);
		
		or.setOvertimerequestlogs(ologs);	// or 关联 log
		
		overtimerecordDAO.saveOrUpdate(or);
		
		return SUCCESS;
	}
	
	
}
