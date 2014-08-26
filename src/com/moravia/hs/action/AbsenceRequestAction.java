package com.moravia.hs.action;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;

import org.apache.coyote.RequestInfo;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.action.test.User;
import com.moravia.hs.base.dao.AbsencerecordDAO;
import com.moravia.hs.base.dao.AbsencerequestitemDAO;
import com.moravia.hs.base.dao.AbsencerequestlogDAO;
import com.moravia.hs.base.dao.CompensatoryleaveinfoDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.LoginviewDAO;
import com.moravia.hs.base.dao.OvertimerecordDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.dao.TokenAbsenceDAO;
import com.moravia.hs.base.dao.VacationchangerecordDAO;
import com.moravia.hs.base.dao.VacationtypeDAO;
import com.moravia.hs.base.entity.Absencerecord;
import com.moravia.hs.base.entity.Absencerequestitem;
import com.moravia.hs.base.entity.Absencerequestlog;
import com.moravia.hs.base.entity.Compensatoryleaveinfo;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.TokenAbsence;
import com.moravia.hs.base.entity.Vacationchangerecord;
import com.moravia.hs.base.entity.Vacationtype;
import com.moravia.hs.base.entity.other.AffairAbsence;
import com.moravia.hs.base.entity.other.HistoryAbsence;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.base.entity.other.PageBean;
import com.moravia.hs.base.entity.other.RequestInfoAbsence;
import com.moravia.hs.util.SendNotificationMail;

@Controller("absenceRequestAction")
public class AbsenceRequestAction extends BaseAction {
	
//	@Resource(name = "absencerecordDAO")
	@Autowired
	private AbsencerecordDAO absencerecordDAO;
	
	@Autowired
	private OvertimerecordDAO overtimerecordDAO;
	
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
	
	@Autowired
	private CompensatoryleaveinfoDAO compensatoryleaveinfoDAO;
	
	@Autowired
	private VacationchangerecordDAO vacationchangerecordDAO;
	
	@Autowired
	private AbsencerequestlogDAO absencerequestlogDAO;
	
	// 请假申请人 / 请假人
	private String request_absence_empLoginId;
	
	// 直线经理
	private String request_absence_lineManager;
	
	// 项目经理
	private String request_absence_pm;
	
	// 请假原因
	private String request_absence_reason;
	
	// Absencerequestitem related types
	private String request_absence_types;
	
	// Absencerequestitem related startTimes
	private String request_absence_startTimes;
		
	// Absencerequestitem related endTimes
	private String request_absence_endTimes;
		
	
	// Request Info executor
//	private String request_info_executor;
	
	// Request Info pageSize	
//	private String request_info_pageSize;
	
	// Request Info page
	private String request_info_page;
	
	
	// AbsenceRecord id
	private String request_handle_absenceid;
	
	// affairs handle type
	private String requestaffairs_handleFlag;
	
	// affaris handle agree
	private String requestaffairs_absencerecordid;
	
	private String request_info_lineManagerNote;
	
//	private List<Absencerecord> request_info_ars;
	
//	private PageBean pageBean;
	
//	private PageBean absenceHistoryPageBean;
	
	private int affairsNum;
	
	// Request Affairs
	private List<AffairAbsence> affairAbsences;
	
	private List<HistoryAbsence> historyAbsences;
	
	// AbsenceRecord for request handle
	private Absencerecord requesthandleabsencerecord;
	
	// absence info bean
	private RequestInfoAbsence absenceInfo;
	
	private List<Absencerequestitem> absenceitems;
	
	// History track
	private List absencerequestlogs;
	
//	// request items
//	private List<Absencerequestitem> requestItems;
	
//	public List<Absencerequestitem> getRequestItems() {
//		return requestItems;
//	}
//
//	public void setRequestItems(List<Absencerequestitem> requestItems) {
//		this.requestItems = requestItems;
//	}
	
	
	public List<Absencerequestitem> getAbsenceitems() {
		return absenceitems;
	}

	public int getAffairsNum() {
		return affairsNum;
	}

	public void setAffairsNum(int affairsNum) {
		this.affairsNum = affairsNum;
	}

	public List<AffairAbsence> getAffairAbsences() {
		return affairAbsences;
	}

	public void setAffairAbsences(List<AffairAbsence> affairAbsences) {
		this.affairAbsences = affairAbsences;
	}

	public List getAbsencerequestlogs() {
		return absencerequestlogs;
	}

	public void setAbsencerequestlogs(List absencerequestlogs) {
		this.absencerequestlogs = absencerequestlogs;
	}

	public String getRequest_info_lineManagerNote() {
		return request_info_lineManagerNote;
	}

	public void setRequest_info_lineManagerNote(String request_info_lineManagerNote) {
		this.request_info_lineManagerNote = request_info_lineManagerNote;
	}

	public String getRequestaffairs_handleFlag() {
		return requestaffairs_handleFlag;
	}

	public void setRequestaffairs_handleFlag(String requestaffairs_handleFlag) {
		this.requestaffairs_handleFlag = requestaffairs_handleFlag;
	}

	public void setAbsenceitems(List<Absencerequestitem> absenceitems) {
		this.absenceitems = absenceitems;
	}

	public RequestInfoAbsence getAbsenceInfo() {
		return absenceInfo;
	}

	public void setAbsenceInfo(RequestInfoAbsence absenceInfo) {
		this.absenceInfo = absenceInfo;
	}

//	public PageBean getPageBean() {
//		return pageBean;
//	}
//
//	public void setPageBean(PageBean pageBean) {
//		this.pageBean = pageBean;
//	}

	public Absencerecord getRequesthandleabsencerecord() {
		return requesthandleabsencerecord;
	}

	public void setRequesthandleabsencerecord(
			Absencerecord requesthandleabsencerecord) {
		this.requesthandleabsencerecord = requesthandleabsencerecord;
	}

	public void setRequest_absence_empLoginId(String request_absence_empLoginId) {
		this.request_absence_empLoginId = request_absence_empLoginId;
	}

	public void setRequest_absence_lineManager(String request_absence_lineManager) {
		this.request_absence_lineManager = request_absence_lineManager;
	}

	public void setRequest_absence_pm(String request_absence_pm) {
		this.request_absence_pm = request_absence_pm;
	}

	public void setRequest_absence_reason(String request_absence_reason) {
		this.request_absence_reason = request_absence_reason;
	}
	
	public void setRequest_absence_types(String request_absence_types) {
		this.request_absence_types = request_absence_types;
	}

	public void setRequest_absence_startTimes(String request_absence_startTimes) {
		this.request_absence_startTimes = request_absence_startTimes;
	}

	public void setRequest_absence_endTimes(String request_absence_endTimes) {
		this.request_absence_endTimes = request_absence_endTimes;
	}
	
	/*@Override
	public String execute() throws Exception {
		Map<String, Object> session = getSession();
		// 查询所有员工的loingId信息
		List<String> loginviewList = loginviewDAO.findAllLoginId();
		// 查询所有vacation type 信息
		List<Vacationtype> vacationtypeList = vacationtypeDAO.findAll();
		
		// System.out.println("vacationtypeList.size(): " + vacationtypeList.size());
		session.put("vacationtypeList", vacationtypeList);
		session.put("loginviewList", loginviewList);
		
		return SUCCESS;
	}*/

	public String getRequestaffairs_absencerecordid() {
		return requestaffairs_absencerecordid;
	}

	public List<HistoryAbsence> getHistoryAbsences() {
		return historyAbsences;
	}

	public void setHistoryAbsences(List<HistoryAbsence> historyAbsences) {
		this.historyAbsences = historyAbsences;
	}

	public void setRequestaffairs_absencerecordid(
			String requestaffairs_absencerecordid) {
		this.requestaffairs_absencerecordid = requestaffairs_absencerecordid;
	}

	public String getRequest_handle_absenceid() {
		return request_handle_absenceid;
	}

	public void setRequest_handle_absenceid(String request_handle_absenceid) {
		this.request_handle_absenceid = request_handle_absenceid;
	}

	/*public String getRequest_info_executor() {
		return request_info_executor;
	}

	public void setRequest_info_executor(String request_info_executor) {
		this.request_info_executor = request_info_executor;
	}*/

	/*public String getRequest_info_pageSize() {
		return request_info_pageSize;
	}

	public void setRequest_info_pageSize(String request_info_pageSize) {
		this.request_info_pageSize = request_info_pageSize;
	}*/

	public String getRequest_info_page() {
		return request_info_page;
	}

	public void setRequest_info_page(String request_info_page) {
		this.request_info_page = request_info_page;
	}

	/*public List<Absencerecord> getRequest_info_ars() {
		return request_info_ars;
	}

	public void setRequest_info_ars(List<Absencerecord> request_info_ars) {
		this.request_info_ars = request_info_ars;
	}*/

	/*public PageBean getAbsenceHistoryPageBean() {
		return absenceHistoryPageBean;
	}

	public void setAbsenceHistoryPageBean(PageBean absenceHistoryPageBean) {
		this.absenceHistoryPageBean = absenceHistoryPageBean;
	}*/

	/**
	 * Load Request Page
	 * @return
	 */
	public String loadRequestPage() throws Exception {
		// System.out.println("进入loadRequestPage...");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
//		Double comLeft = compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(login.getEmp());
		// System.out.println("调休假剩余。。。" + comLeft);
//		login.setCompensatoryLeft(comLeft);
		
		// 设置empLoginId = loginId, pageSize = 10, currentPage = 0
		PageBean absenceHistoryPageBean =  absencerecordDAO.findByEmpLoginId(login.getEmp().getEmpLoginId(), 10, 0);
		
		PageBean overtimeHistoryPageBean = overtimerecordDAO.findByApplicant(login.getEmp().getEmpLoginId(), 10, 0);
		
		login.setOvertimeHistoryPageBean(overtimeHistoryPageBean);
		// System.out.println("加载loadRequestPage方法， setOvertimeHistoryPageBean...");
		login.setAbsenceHistoryPageBean(absenceHistoryPageBean);
		// System.out.println("Set absenceHistoryPageBean...totalPage: " + absenceHistoryPageBean.getTotalPage());
		session.put("login", login);
		
		return SUCCESS;
	}
	
	/**
	 * 员工请假申请
	 * @return
	 * @throws ParseException
	 */
	public String requestApply() throws ParseException {
		Map<String, Object> session = getSession();
		
		Login login = (Login) session.get("login");
		
		if(login == null) {
			session.put("globalError", "请先登录");
			return ERROR;
		}

		Timestamp ts = new Timestamp((new Date()).getTime());
		// 设置absenceRecord的状态 - RequestState
		List<Requeststate> rss = requeststateDAO.findAll();
		
		// 创建 Absencerecord
		Absencerecord ar = new Absencerecord();
		// 创建log
		Absencerequestlog alog = new Absencerequestlog();
		
		alog.setAbsencerecord(ar);	//	关联absenceRecord
		alog.setChangeDate(ts);	// 变更日期
		alog.setChangePeople(request_absence_empLoginId.trim());	// 修改人
		alog.setLogDesc(request_absence_empLoginId.trim() + " applied a leave request.");	// 描述
		
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
		
		ar.setEmpLoginId(request_absence_empLoginId.trim()); // 请假申请人
		ar.setAbsenceReason(request_absence_reason); // Reason
		ar.setAbsenceApproverLineManager(request_absence_lineManager.trim()); // Line Manager
		ar.setAbsenceApproverPm(request_absence_pm.trim());  // PM
		
		ar.setCreateDate(ts); // Create Date
		
		// 创建 AbsencerecordItem
		String[] types = request_absence_types.trim().split(";");
		String[] startTimes = request_absence_startTimes.trim().split(";");
		String[] endTimes = request_absence_endTimes.trim().split(";");
		
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
				
				// 关联absenceRecord对象
				// System.out.println("关联absenceRecord对象...");
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
			
			for (Absencerequestitem item : ais) {
				if(item.getAbsenceType().equalsIgnoreCase("Compensatory_Leave")) {
					login.setUsableCompensatoryLeave((login.getUsableCompensatoryLeave() - item.getAbsenceHours()));	// 更新可用调休假
					login.getVacationUsedInfo().setAnnualLeave(login.getVacationUsedInfo().getAnnualLeave() + item.getAbsenceHours()); 	// 更新已用调休假
				} else if(item.getAbsenceType().equalsIgnoreCase("Annual_Leave")) {
					login.setUsableAnnualLeave(login.getUsableAnnualLeave() - item.getAbsenceHours());		// 更新可用年假
					login.getVacationUsedInfo().setCompensatory(login.getVacationUsedInfo().getCompensatory() + item.getAbsenceHours());	// 更新已用年假
				} else if(item.getAbsenceType().equalsIgnoreCase("Sick_Maternity_Breavement_Leave")) {
					login.getVacationUsedInfo().setSickMateryBreaveLeave(login.getVacationUsedInfo().getSickMateryBreaveLeave() + item.getAbsenceHours()); // 更新 已用病假
				} else if(item.getAbsenceType().equalsIgnoreCase("Long_Sick_Marriage_Leave")) {
					login.getVacationUsedInfo().setLongSickMarriageLeave(login.getVacationUsedInfo().getLongSickMarriageLeave() + item.getAbsenceHours()); 	// 更新已用长病假
				} else if(item.getAbsenceType().equalsIgnoreCase("Personal_Unpaid_Leave")) {
					login.getVacationUsedInfo().setPersonalLeave(login.getVacationUsedInfo().getPersonalLeave() + item.getAbsenceHours()); 	// 更新已用事假
				}
			}
			
			session.put("login", login);
			
		} else {
			session.put("globalError", "types, startTimes 和 endTimes长度不一致");
			return ERROR;
		}
		
		Set<TokenAbsence> tokens = new HashSet<TokenAbsence>();
		// 创建Token
		TokenAbsence token = new TokenAbsence();
		// 设置token状态为active (1)
		token.setTokenState(1);
		token.setAbsencerecord(ar);	// 关联AbsenceRecord对象
		token.setTokenExecutor(request_absence_lineManager.trim());	// 将token指向LineManager
		tokens.add(token);
	
		// absenceRecord对象关联token
		// System.out.println("absenceRecord对象关联token...");
		ar.setTokenAbsences(tokens);
		
		//发邮件 提醒 LineManager
		String fromStr = login.getEmp().getEmpLoginId();
		Emp toEmp = empDAO.findByLoginName(request_absence_lineManager.trim());
		String toStr = toEmp.getEmail();
		
		SendNotificationMail snm = new SendNotificationMail();
		snm.setFrom(fromStr);
		snm.setTo(toStr);
		snm.setSubject(fromStr + " has sent an absence request to you.");
		snm.setTriggerBy(fromStr);
		snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
		snm.setLinkText("Link to Request Page.");
		snm.setType("Absence Request");
		snm.setRequestState(ar.getRequeststate().getStateName());
		snm.setTitle("You have an Absence Request from " + fromStr);
		snm.sendMail();
		
		// 修改假期信息
		
		// 记录假期使用记录
		/*Vacationchangerecord vc = new Vacationchangerecord();
		vc.setEmp(emp);
		vc.setChangeDate(ts);
		vc.setChangeHours(item.getAbsenceHours());
		vc.setChangeReason(ar.getAbsenceReason() + "\t" + item.getVacationtype().getVacationTypeName() + "\tused: " + item.getAbsenceHours());
		vc.setVacationAddOrMinus(0); // 0表示减少，1表示增加
		vc.setCreateDate(ts);
		vacationchangerecords.add(vc);
		
		// System.out.println("员工: " + emp.getEmpLoginId() + "一共请了: " + annualLeaveUsed + "小时年假。。。");
		emp.setAnnualLeaveLeft(emp.getAnnualLeaveLeft() - annualLeaveUsed);
		// 更新员工信息
		emp.setVacationchangerecords(vacationchangerecords);*/
		
		absencerecordDAO.save(ar);	// 保存AbsenceRecord对象
		
		return SUCCESS;
	}
	
	/**
	 * Get Request Info Affairs
	 * @return
	 */
	public String requestInfoAffairs() {
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			/*session.put("globalError", "请先登录");
			return ERROR;*/
			System.out.println("##### Error && 请先登录！ ######");
		}
		
		// pageSize
		int pageSize = login.getPageBean().getPageSize();
		
		// page
		if(request_info_page == null && request_info_page == "") {
			/*session.put("globalError", "request_info_page 为空值");
			return ERROR;*/
			System.out.println("##### Error && requestInfoAffairs() ###### request_info_page is null");
		}
		
		// System.out.println("request_info_page for Affaris Info: " + request_info_page);
		
		int page = Integer.parseInt(request_info_page.trim());
		login.getPageBean().setCurrentPage(page);
		
		PageBean pageBean = tokenAbsenceDAO.findByTokenExecutorWithPageSize(login.getEmp().getEmpLoginId(), 1, pageSize, page);
		
		List<TokenAbsence> tokens = pageBean.getList();
//		request_info_ars = new ArrayList<Absencerecord>();
		
		affairAbsences = new ArrayList<AffairAbsence>();
		AffairAbsence afa = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (TokenAbsence token : tokens) {
			Absencerecord ar = token.getAbsencerecord();
			afa = new AffairAbsence();
			afa.setCreateDate(sdf.format(ar.getCreateDate()));
			afa.setEmpLoginId(ar.getEmpLoginId());
			afa.setHrs(ar.getAbsenceTotalHours());
			afa.setId(ar.getAbsenceRecordId());
			afa.setLineManager(ar.getAbsenceApproverLineManager());
			afa.setPm(ar.getAbsenceApproverPm());
			afa.setStateName(ar.getRequeststate().getStateName());
			affairAbsences.add(afa);
		}
		
		affairsNum = pageBean.getAllRow();
		
		return SUCCESS;
	}
	
	
	/**
	 * Get Info of AbsenceHistory
	 * @return
	 */
	public String getAbsenceHistoryInfo() {
		Map<String, Object> session = getSession();
		System.out.println("调用 getAbsenceHistoryInfo....");
		Login login = (Login) session.get("login");
		
		if(login == null) {
			/*session.put("globalError", "请先登录");
			return ERROR;*/
			System.out.println("##### Error && 请先登录！ ######");
		}
		
		// pageSize
		int pageSize = login.getAbsenceHistoryPageBean().getPageSize();
		
		// page
		if(request_info_page == null && request_info_page == "") {
//			session.put("globalError", "request_info_page 为空值");
//			return ERROR;
			System.out.println("##### Error && getAbsenceHistoryInfo() ###### request_info_page is null!");
		}
		
		// System.out.println("request by emp: " + login.getEmp().getEmpLoginId());
		// System.out.println("request_info_page for AbsenceHistory Info: " + request_info_page);
		
		
		int page = Integer.parseInt(request_info_page.trim());
		
//		login.getAbsenceHistoryPageBean().setCurrentPage(page);
		
		PageBean absenceHistoryPageBean = absencerecordDAO.findByEmpLoginId(login.getEmp().getEmpLoginId(), pageSize, page);
		
		List<Absencerecord> list = absenceHistoryPageBean.getList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		historyAbsences = new ArrayList<HistoryAbsence>();
		HistoryAbsence	ha = null;
		for (Absencerecord ar : list) {
			ha = new HistoryAbsence();
			ha.setCreateDate(sdf.format(ar.getCreateDate()));
			ha.setEmpLoginId(ar.getEmpLoginId());
			ha.setHrs(ar.getAbsenceTotalHours());
			ha.setId(ar.getAbsenceRecordId());
			ha.setLineManager(ar.getAbsenceApproverLineManager());
			ha.setPm(ar.getAbsenceApproverPm());
			ha.setReason(ar.getAbsenceReason());
			ha.setStateName(ar.getRequeststate().getStateName());
			ha.setLineManagerNote(ar.getAbsenceNoteLineManager());
			historyAbsences.add(ha);
		}
		
		System.out.println("historyAbsences.size(): " + historyAbsences.size());
		return SUCCESS;
	}
	
	/**
	 * Affaris, 查看具体AbsenceRecordItem信息
	 */
	public String requestInfoGetAbsenceRecord() {
//		Map<String, Object> session = getSession();
		// System.out.println("Method: requestInfoGetAbsenceRecord...");
		// System.out.println("request_handle_absenceid:" + request_handle_absenceid);
		int arid = Integer.parseInt(request_handle_absenceid.trim());
		Absencerecord ar = absencerecordDAO.findById(arid);
		
		Set<Absencerequestitem> ais = ar.getAbsencerequestitems();
		absenceitems = new ArrayList<Absencerequestitem>();
		for (Absencerequestitem item : ais) {
			// System.out.println(item.getAbsenceStartTime() + "\t" + item.getVacationtype().getVacationTypeName());
			absenceitems.add(item);
		}
		
		absenceInfo = new RequestInfoAbsence();
		
//		absenceInfo.setRequestItems(list_ais);
		
//		session.put("testrequestinfo_absencerecord", null);
//		// System.out.println("设置为null...");
//		session.put("testrequestinfo_absencerecord", ar);
		// json数据包装。。。
//		// System.out.println("json数据包装。。。");
//		requesthandleabsencerecord = ar;
		
		absenceInfo = new RequestInfoAbsence();
		absenceInfo.setRequestId(ar.getAbsenceRecordId());
		absenceInfo.setEmpLoginId(ar.getEmpLoginId());
		absenceInfo.setPm(ar.getAbsenceApproverPm());
		absenceInfo.setLineManager(ar.getAbsenceApproverLineManager());
		// System.out.println("ar.getAbsenceNoteLineManager()" + ar.getAbsenceNoteLineManager());
		absenceInfo.setReason(ar.getAbsenceReason());
		absenceInfo.setDepartment(""); 	// department
		
//		// System.out.println("size(): " + absenceInfo.getRequestItems().size());
		
		return SUCCESS;
	}
	
	
	public String historyInfoGetAbsencerequestLog() {
//		Map<String, Object> session = getSession();
		// System.out.println("进入: historyInfoGetAbsencerequestLog 方法");
		// System.out.println("request_handle_absenceid:" + request_handle_absenceid);
		int arid = Integer.parseInt(request_handle_absenceid.trim());
		absencerequestlogs = absencerequestlogDAO.findByAbsenceRecord(arid);
		// System.out.println("absencerequestlogs.size(): " + absencerequestlogs.size());
		
		return SUCCESS;
	}
	
	
	public String requestAffarisHandle() {
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		// System.out.println("欢迎进入requestAffarisHandle method... requestaffairs_handleFlag: " + requestaffairs_handleFlag);
		// System.out.println("requestaffairs_absencerecordid: " + requestaffairs_absencerecordid);
		int absenceId = Integer.parseInt(requestaffairs_absencerecordid.trim()); 
		Absencerecord ar = absencerecordDAO.findById(absenceId);
		
		if(request_info_lineManagerNote != null && request_info_lineManagerNote == "") {
			// System.out.println("request_info_lineManagerNote 为空");
		} else {
			ar.setAbsenceNoteLineManager(request_info_lineManagerNote.trim());
		}
		
		// 传递token
		Set<TokenAbsence> tokens = ar.getTokenAbsences();
		if(requestaffairs_handleFlag.trim().equals("Agree")) {
			for (TokenAbsence token : tokens) {
				// 设置token状态为inactive (0)
				// 流程终止 token executor 不变 
				token.setTokenState(0);
				// System.out.println("dispose token...");
				tokenAbsenceDAO.save(token);
				
				//发邮件 提醒 LineManager
				String fromStr = login.getEmp().getEmpLoginId();
				Emp toEmp = empDAO.findByLoginName(ar.getEmpLoginId());
				String toStr = toEmp.getEmail();
				
				SendNotificationMail snm = new SendNotificationMail();
				snm.setFrom(fromStr);
				snm.setTo(toStr);
				snm.setSubject(fromStr + " has approved your absence request.");
				snm.setTriggerBy(fromStr);
				snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm.setLinkText("Link to Request Page.");
				snm.setType("Absence Request");
				snm.setRequestState(ar.getRequeststate().getStateName());
				snm.setTitle("Your Absence Request has been approved by " + fromStr);
				snm.sendMail();
				// 发邮件提醒
				
			}
		} else if(requestaffairs_handleFlag.trim().equals("Reject")) {
			for (TokenAbsence token : tokens) {
				// 设置token executor 为request 申请人
				// token状态变为2
//				token.setTokenState(2);
				token.setTokenExecutor(ar.getEmpLoginId()); // token传递给发起人
				// System.out.println("reject token...");
				tokenAbsenceDAO.save(token);
				
				//发邮件 提醒 LineManager
				String fromStr = login.getEmp().getEmpLoginId();
				Emp toEmp = empDAO.findByLoginName(ar.getEmpLoginId());
				String toStr = toEmp.getEmail();
				
				SendNotificationMail snm = new SendNotificationMail();
				snm.setFrom(fromStr);
				snm.setTo(toStr);
				snm.setSubject(fromStr + " has rejected your absence request.");
				snm.setTriggerBy(fromStr);
				snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm.setLinkText("Link to Request Page.");
				snm.setType("Absence Request");
				snm.setRequestState(ar.getRequeststate().getStateName());
				snm.setTitle("Your Absence Request has been rejected by " + fromStr);
				snm.sendMail();
				// 发邮件提醒
				
			}
		}
		
		// 关联log
		Absencerequestlog alog = new Absencerequestlog();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		alog.setAbsencerecord(ar);	//	关联absenceRecord
		alog.setChangeDate(ts);	// 变更日期
		alog.setChangePeople(ar.getAbsenceApproverLineManager()); // 修改人
		alog.setLogDesc(login.getEmp().getEmpLoginId() + " " + requestaffairs_handleFlag + "ed a leave request. ID: " + ar.getAbsenceRecordId());	// 描述
		// System.out.println("Log 关联 absence record");
		alog.setAbsencerecord(ar);

		Set<Absencerequestlog> alogs = new HashSet<Absencerequestlog>(); // alog集合
		
		// 更改状态
		List<Requeststate> states = requeststateDAO.findAll();
		if(requestaffairs_handleFlag.trim().equals("Agree")) {
			for (Requeststate rs : states) {
				if(rs.getStateName().equals("Done")) {
					// 设置状态为Done
					ar.setRequeststate(rs);
					alog.setRequeststate(rs);
				}
			}
			
		} else if(requestaffairs_handleFlag.trim().equals("Reject")) {
			for (Requeststate rs : states) {
				if(rs.getStateName().equals("Rejected")) {
					// System.out.println("request has been rejected...");
					ar.setRequeststate(rs);
					alog.setRequeststate(rs);
				}
			}
		}
		
		alogs.add(alog);
		
		// ar关联alogs
		// System.out.println("absence record 关联 alogs...");
		ar.setAbsencerequestlogs(alogs);
		
		// 保存
		absencerecordDAO.saveOrUpdate(ar);
		// System.out.println("absencerecord saveOrUpdate...");
		
		// 流程终止之后，Absence Record 的状态为Done之后，才会扣除相应的假期
		if(ar.getRequeststate().getStateDesc().equals("Done")) {
			// 扣除相应假期
			Set<Absencerequestitem> items = ar.getAbsencerequestitems();
			Emp emp = empDAO.findByLoginName(ar.getEmpLoginId());
			// 按照Expiration由近到远的顺序得到compensatory leave records
			List<Compensatoryleaveinfo> compensatories = compensatoryleaveinfoDAO.findByEmp(emp);
	
			// 年假剩余总小时数
//			double totalannualLeft = emp.getAnnualLeaveLeft();
			double usableAnnualLeave = login.getUsableAnnualLeave();
			// System.out.println("年假剩余总小时数： " + totalannualLeft);
			
			// 调休假剩余总小时数
			/*Calendar cal = Calendar.getInstance();
			cal.setTime(ar.getCreateDate());
			cal.add(Calendar.MONTH, -1);*/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			double totalcompensatoryLeft = compensatoryleaveinfoDAO.findTotalCompensatoryLeaveLeft(emp, sdf.format(date));
			// System.out.println("调休假剩余总小时数： " + totalcompensatoryLeft);
	//		Set<Compensatoryleaveinfo> comleaves = emp.getCompensatoryleaveinfos();
			
			// 假期变化记录表（只针对61类型的年假和调休假）
			Set<Vacationchangerecord> vacationchangerecords = new HashSet<Vacationchangerecord>();
			
			boolean completeFlag = false; // 初始值为false，表示单条compensatory leave record 的剩余调休小时数被使用完了
			double annualLeaveUsed = 0.0;
			for (Absencerequestitem item : items) {
				completeFlag = false; // 初始值为false
				Vacationtype type = item.getVacationtype();
				// System.out.println("This is vacation type: " + type.getTimeSheetOrderId() + "\t" + type.getVacationTypeName());
				// 只针对61类型的年假和调休假做剩余假期管理
				if(type.getTimeSheetOrderId() == 61) {
					if(type.getVacationTypeName().equals("Annual_Leave") && usableAnnualLeave > item.getAbsenceHours()) {
						// 扣除年假
	//					emp.setAnnualLeaveLeft(totalannualLeft - item.getAbsenceHours());
						annualLeaveUsed += item.getAbsenceHours();
						// System.out.println("年假扣除： " + item.getAbsenceHours() + "小时");
						
					} else if (type.getVacationTypeName().equals("Compensatory_Leave")) {
						// 调休假使用情况
						// 扣除调休假
						if(compensatories.size() == 0) {
							session.put("globalError", emp.getEmpLoginId() + "已经没有调休假可用");
							return ERROR;
						}
						
						for (Compensatoryleaveinfo compeninfo : compensatories) {
							if(item.getAbsenceStartTime().compareTo(compeninfo.getExpirationDate()) > 0) {
								System.out.println("########Item： " + item.getItemId() + " 的开始时间大于调休假信息compensatoryleaveinfo 中最近的一条记录的过期日期。");
								System.out.println("######## 直接 continue");
								continue;
							}
							// 取出compensatory leave expiration date 最近的一次记录，
						 	// 如果大于item请求的小时数，则，扣除该小时数，如果小于，
							// 则继续取第二近的compensatory record 进行相同操作
							if(!completeFlag) {
								if(compeninfo.getCompensatoryLeaveLeft() >= item.getAbsenceHours()) {
									compeninfo.setCompensatoryLeaveLeft(compeninfo.getCompensatoryLeaveLeft() - item.getAbsenceHours());	// 扣除相应时间
									// System.out.println("最近一条调休假够用...set flag true, 扣除调休假ID: " + compeninfo.getCompensatoryLeaveId() + "\t" + item.getAbsenceHours() + "小时。");
									completeFlag = true;  // 表示单条compensatory record的剩余调休小时数没有被使用完,
								} else {
									// 该条调休记录的剩余小时数已经不够，需要其他调休记录来弥补
									item.setAbsenceHours(item.getAbsenceHours() - compeninfo.getCompensatoryLeaveLeft()); // 扣除item的小时数
									// System.out.println("最近一条调休假不够用...set flag false， 扣除 item ID: " + item.getItemId() + "\t" + compeninfo.getCompensatoryLeaveLeft() + "小时");
									compeninfo.setCompensatoryLeaveLeft(0.0); // 扣除compensatory record的小时数
									completeFlag = false;  // 单条compensatory record的剩余调休小时数被使用完了还没有覆盖完全item的请假小时数
								}
							}
							compeninfo.setLastUsedDate(date);
							// 保存更新
							// System.out.println("更新调休假记录...");
							compensatoryleaveinfoDAO.saveOrUpdate(compeninfo);
						}
					}
				}
				
				// 记录假期使用记录
				Vacationchangerecord vc = new Vacationchangerecord();
				vc.setEmp(emp);
				vc.setCreateDate(ts);
				vc.setChangeBy(login.getEmp().getEmpLoginId());
				vc.setChangeHours(item.getAbsenceHours());
				vc.setChangeReason(ar.getAbsenceReason() + "\t" + item.getVacationtype().getVacationTypeName() + "\tused: " + item.getAbsenceHours());
				vc.setVacationAddOrMinus(0); // 0表示减少，1表示增加
				vc.setCreateDate(ts);
				vacationchangerecords.add(vc);
			}
			/*// System.out.println("员工: " + emp.getEmpLoginId() + "一共请了: " + annualLeaveUsed + "小时年假。。。");
			emp.setAnnualLeaveLeft(emp.getAnnualLeaveLeft() - annualLeaveUsed);
			// 更新员工信息
			emp.setVacationchangerecords(vacationchangerecords);*/
			empDAO.saveOrUpdate(emp);
		}
		
		return SUCCESS;
	}
	
	/*
	 * Just for test
	 */
	public String test() {
		Map<String, Object> session = getSession();
		/*// System.out.println(request_absence_empLoginId);
		// System.out.println(request_absence_lineManager);
		// System.out.println(request_absence_pm);
		// System.out.println(request_absence_reason);
		// System.out.println(request_absence_types);
		// System.out.println(request_absence_startTimes);
		// System.out.println(request_absence_endTimes);*/
		
		/*String[] types = request_absence_types.split(";");
		String[] startTimes = request_absence_startTimes.split(";");
		String[] endTimes = request_absence_endTimes.split(";");
		// System.out.println("startTimes:");
		for (String start : startTimes) {
			// System.out.println(start);
		}
		
		// System.out.println();
		// System.out.println("endtimes:");
		for (String end : endTimes) {
			// System.out.println(end);
		}
		
		// System.out.println();
		// System.out.println("typs:");
		for (String type : types) {
			// System.out.println(type);
		}*/
		/*// System.out.println("test method");
		Absencerecord ar = new Absencerecord();
		ar.setAbsenceApproverLineManager("JasonL");
		ar.setAbsenceApproverPm("JasonM");
		ar.setAbsenceReason("生病请假");
		ar.setEmpLoginId("JasonZh");
		
		// 创建token
		// System.out.println("创建token...");
		TokenAbsence token = new TokenAbsence();
		token.setTokenState(1);
		token.setTokenExecutor("JaonL");
		token.setAbsencerecord(ar);
		Set<TokenAbsence> tokens = new HashSet<TokenAbsence>();
		tokens.add(token);
		
		ar.setTokenAbsences(tokens);
		
		// 保存
		absencerecordDAO.save(ar);*/
		Absencerecord ar = absencerecordDAO.findById(1);
		Set<Absencerequestitem> ais = ar.getAbsencerequestitems();
		for (Absencerequestitem ai : ais) {
			// System.out.println(ai.getAbsenceStartTime() + "\t" + ai.getVacationtype().getVacationTypeName());
		}
		session.put("testrequestinfo_absencerecord", ar);
		
		return SUCCESS;
	}

}
