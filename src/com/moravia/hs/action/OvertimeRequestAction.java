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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moravia.hs.base.dao.CompensatoryleaveinfoDAO;
import com.moravia.hs.base.dao.CostcenterDAO;
import com.moravia.hs.base.dao.EmpDAO;
import com.moravia.hs.base.dao.OvertimerecordDAO;
import com.moravia.hs.base.dao.OvertimerequestlogDAO;
import com.moravia.hs.base.dao.RequeststateDAO;
import com.moravia.hs.base.dao.TokenOvertimeDAO;
import com.moravia.hs.base.entity.Compensatoryleaveinfo;
import com.moravia.hs.base.entity.Costcenter;
import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Overtimerecord;
import com.moravia.hs.base.entity.Overtimerequestitem;
import com.moravia.hs.base.entity.Overtimerequestlog;
import com.moravia.hs.base.entity.Requeststate;
import com.moravia.hs.base.entity.TokenOvertime;
import com.moravia.hs.base.entity.other.Login;
import com.moravia.hs.base.entity.other.OvertimeRequestEntity;
import com.moravia.hs.base.entity.other.PageBean;
import com.moravia.hs.base.entity.other.RequestHistoryOvertimeDetails;
import com.moravia.hs.base.entity.other.RequestHistoryTrack;
import com.moravia.hs.util.SendNotificationMail;

@Controller("overtimeRequestAction")
public class OvertimeRequestAction extends BaseAction {

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
	private OvertimerequestlogDAO overtimerequestlogDAO;
	
	@Autowired
	private CompensatoryleaveinfoDAO compensatoryleaveinfoDAO;
	
	
	private String overtimeHistoryPage;	// overtime history page;
	
	private OvertimeRequestEntity overtimeRequestEntity;
	
	private List<OvertimeRequestEntity> overtimeEntities;
	
	private List<OvertimeRequestEntity> overtimeHistories;
	
	private String overtimeRequestRecordId;
	
	private RequestHistoryOvertimeDetails historyOvertimeDetails;	// History Overtime details
	
	private String historyOvertimeRecordId;	// History overtime details request id;
	
	private List<RequestHistoryTrack> requestHistoryTracks;	// History Overtime Track(log)
	
	private int affairsNum;
	
//	private static Requeststate inprogState = requeststateDAO.findByStateName("InProg");
//	private static Requeststate doneState = requeststateDAO.findByStateName("Done");
//	private static Requeststate rejectedState = requeststateDAO.findByStateName("Rejected");
	
	public List<RequestHistoryTrack> getRequestHistoryTracks() {
		return requestHistoryTracks;
	}

	public int getAffairsNum() {
		return affairsNum;
	}

	public void setAffairsNum(int affairsNum) {
		this.affairsNum = affairsNum;
	}

	public void setRequestHistoryTracks(
			List<RequestHistoryTrack> requestHistoryTracks) {
		this.requestHistoryTracks = requestHistoryTracks;
	}

	public String getHistoryOvertimeRecordId() {
		return historyOvertimeRecordId;
	}

	public void setHistoryOvertimeRecordId(String historyOvertimeRecordId) {
		this.historyOvertimeRecordId = historyOvertimeRecordId;
	}

	public RequestHistoryOvertimeDetails getHistoryOvertimeDetails() {
		return historyOvertimeDetails;
	}

	public void setHistoryOvertimeDetails(
			RequestHistoryOvertimeDetails historyOvertimeDetails) {
		this.historyOvertimeDetails = historyOvertimeDetails;
	}

	public String getOvertimeRequestRecordId() {
		return overtimeRequestRecordId;
	}

	public void setOvertimeRequestRecordId(String overtimeRequestRecordId) {
		this.overtimeRequestRecordId = overtimeRequestRecordId;
	}

	public String getOvertimeHistoryPage() {
		return overtimeHistoryPage;
	}

	public void setOvertimeHistoryPage(String overtimeHistoryPage) {
		this.overtimeHistoryPage = overtimeHistoryPage;
	}

	public List<OvertimeRequestEntity> getOvertimeHistories() {
		return overtimeHistories;
	}

	public void setOvertimeHistories(List<OvertimeRequestEntity> overtimeHistories) {
		this.overtimeHistories = overtimeHistories;
	}

	public List<OvertimeRequestEntity> getOvertimeEntities() {
		return overtimeEntities;
	}

	public void setOvertimeEntities(List<OvertimeRequestEntity> overtimeEntities) {
		this.overtimeEntities = overtimeEntities;
	}

	public OvertimeRequestEntity getOvertimeRequestEntity() {
		return overtimeRequestEntity;
	}

	public void setOvertimeRequestEntity(OvertimeRequestEntity overtimeRequestEntity) {
		this.overtimeRequestEntity = overtimeRequestEntity;
	}
	
	
	

	public String overtimeRequestApply() throws ParseException {
		System.out.println("进入...overtimeRequestApply方法");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");	// date format
		DecimalFormat df = new DecimalFormat("#.0");	// 四舍五入
		
		// 启动Token
		TokenOvertime token = new TokenOvertime();
		
		Overtimerecord or = new Overtimerecord();
		token.setTokenState(1);
		token.setOvertimerecord(or);	// token 关联 or
		token.setTokenExecutor(overtimeRequestEntity.getPm());	// 先由PM通过，再由GM通过
//		tokenOvertimeDAO.save(token);
		Set<TokenOvertime> tokenOvertimes = new HashSet<TokenOvertime>();
		tokenOvertimes.add(token);
		
		or.setApplicant(login.getEmp().getEmpLoginId());
		or.setComments(overtimeRequestEntity.getComments());
		or.setCreatedate(ts);
		or.setGm(overtimeRequestEntity.getGm());
		or.setPm(overtimeRequestEntity.getPm());
		or.setProjectcode(overtimeRequestEntity.getPcode());
		or.setProjectname(overtimeRequestEntity.getPname());
		or.setTokenOvertimes(tokenOvertimes);	// or 关联tokens
		
		Requeststate rs = requeststateDAO.findByStateName("Inprog");	// 设置RequestState
		or.setRequeststate(rs);
		
		String[] startTimes = overtimeRequestEntity.getStartTimes().split(";");
		String[] endTimes = overtimeRequestEntity.getEndTimes().split(";");
		String[] loginIds = overtimeRequestEntity.getEmps().split(";");
		
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
		olog.setLogDesc(login.getEmp().getEmpLoginId() + " applied a overtime request."); 	// 描述
		Set<Overtimerequestlog> ologs = new HashSet<Overtimerequestlog>();
		ologs.add(olog);
		
		or.setOvertimerequestlogs(ologs);	// or 关联 log
		
		
		//发邮件 提醒 
		String fromStr = login.getEmp().getEmpLoginId();
		Emp toEmp = empDAO.findByLoginName(or.getPm());
		String toStr = toEmp.getEmail();
		
		SendNotificationMail snm = new SendNotificationMail();
		snm.setFrom(fromStr);
		snm.setTo(toStr);
		snm.setSubject(fromStr + " has sent an overtime request to you.");
		snm.setTriggerBy(fromStr);
		snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
		snm.setLinkText("Link to Request Page.");
		snm.setType("Overtime Request");
		snm.setRequestState(or.getRequeststate().getStateName());
		snm.setTitle("You have an Overtime Reques from " + fromStr);
		snm.sendMail();
		// 发邮件提醒
		
		overtimerecordDAO.save(or);

		return SUCCESS;
	}
	
	/**
	 * Overtime Affairs
	 */
	public String overtimeAffaris() {
		 System.out.println("进入 overtimeAffaris方法。。。");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			/*session.put("globalError", "请先登录");
			return ERROR;*/
			System.out.println("##### Error && 请先登录！ ######");
		}
		
		// pageSize login 中默认pageSize 为10？
		int pageSize = login.getPageBean().getPageSize();
		
		// page 
		if(overtimeRequestEntity.getPage() == null) {
//			session.put("globalError", "overtimeRequestEntity.page 为空值");
//			return ERROR;
			System.out.println("##### Error && overtimeAffaris() ###### overtimeRequestEntity.getPage() is null!");
		}
		int page = Integer.parseInt(overtimeRequestEntity.getPage().trim());
		
		PageBean pageBean = tokenOvertimeDAO.findByExecutorWithPageSize(login.getEmp().getEmpLoginId(), 1, pageSize, page);
		
		List<TokenOvertime> tokens = pageBean.getList();
		System.out.println("tokens.size(): " + tokens.size());
		
		affairsNum = pageBean.getAllRow();
		
		overtimeEntities = new ArrayList<OvertimeRequestEntity>();
		OvertimeRequestEntity oe = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (TokenOvertime token : tokens) {
			Overtimerecord or = token.getOvertimerecord();
			oe = new OvertimeRequestEntity();
			oe.setApplicant(or.getApplicant());	//  申请人
			oe.setId(or.getId());
			oe.setPm(or.getPm());
			oe.setGm(or.getGm());
			oe.setPcode(or.getProjectcode());
			oe.setPname(or.getProjectname());
			oe.setHrs(or.getTotalhours());
			oe.setStateName(or.getRequeststate().getStateName());
			oe.setComments(or.getComments());
			oe.setCreateDate(sdf.format(or.getCreatedate()));
			overtimeEntities.add(oe);
		}
		
		System.out.println("overtimeEntities.size(): " + overtimeEntities.size());
		
		return SUCCESS;
	}
	
	
	/**
	 * Overtime History
	 */
	public String getOvertimeHistoryInfo() {
		System.out.println("进入 getOvertimeHistoryInfo方法内部。。。。");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
			/*session.put("globalError", "请先登录");
			return ERROR;*/
			System.out.println("##### Error && 请先登录！ ######");
		}
		
		// pageSize
		int pageSize = login.getOvertimeHistoryPageBean().getPageSize();
		// 为了防止影响 struts.xml 中  getOvertimeRequestRecord action 以dispatcher方式转发
		// 将pageSize设置为10
//		int pageSize = 10;
		
		// page 
		if(overtimeHistoryPage == null || overtimeHistoryPage == "") {
//			session.put("globalError", "overtimeRequestEntity.page 为空值");
//			return ERROR;
			System.out.println("##### Error && getOvertimeHistoryInfo() ###### overtimeHistoryPage is empty!");
		}
		
		int page = Integer.parseInt(overtimeHistoryPage.trim());
		
		PageBean overtimeHistoryPageBean = overtimerecordDAO.findByApplicant(login.getEmp().getEmpLoginId(), pageSize, page);
		
		List<Overtimerecord> list = overtimeHistoryPageBean.getList();
		
		System.out.println("overtime histories list.size() : " + list.size());
		
		
		overtimeHistories = new ArrayList<OvertimeRequestEntity>();
		
		OvertimeRequestEntity oe = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Overtimerecord or : list) {
			// System.out.println(or.getId() + "\t" + or.getComments());
			oe = new OvertimeRequestEntity();
			oe.setApplicant(or.getApplicant());	//  申请人
			oe.setId(or.getId());
			oe.setPm(or.getPm());
			oe.setGm(or.getGm());
			oe.setPcode(or.getProjectcode());
			oe.setPname(or.getProjectname());
			oe.setHrs(or.getTotalhours());
			oe.setStateName(or.getRequeststate().getStateName());
			oe.setComments(or.getComments());
			oe.setCreateDate(sdf.format(or.getCreatedate()));
			overtimeHistories.add(oe);
		}
		
		 System.out.println("overtimeHistories.size(): " + overtimeHistories.size());
		
		return SUCCESS;
	}
	
	/**
	 * Query for single overtime request record for handle
	 * @return
	 */
	public String overtimeRequestRecord() {
		System.out.println("进入...overtimeRequestRecord方法");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(overtimeRequestRecordId == null || overtimeRequestRecordId == "") {
			session.put("globalError", "overtimeRequestRecordId 值为空");
			return ERROR;
		}
		
		System.out.println("overtimeRequestRecordId: " + overtimeRequestRecordId);
		int id = Integer.parseInt(overtimeRequestRecordId.trim());
		Overtimerecord or = overtimerecordDAO.findById(id);
		
		Set<Overtimerequestitem> items = or.getOvertimerequestitems();
		
		for (Overtimerequestitem item : items) {
			System.out.println(item.getEmploginid() + "\t" + item.getHours());
		}
		
		List<Costcenter> costcenterList = costcenterDAO.findAll();
		session.put("costcenterList", costcenterList);
		session.put("request_overtimerecord", or);
		return SUCCESS;
	}
	
	/**
	 * Overtime Request Handle method
	 * @return
	 */
	public String overtimeRequestHandle() {
		System.out.println("进入 getOvertimeHistoryInfo方法内部。。。。");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(overtimeRequestEntity == null) {
			session.put("globalError", "overtimeRequestEntity 为空");
			return ERROR;
		}
		
		int orid = overtimeRequestEntity.getId();
		System.out.println("orid: " + orid);
		
		Overtimerecord or = overtimerecordDAO.findById(orid);	// 得到overtimeRecord
		Overtimerequestlog log = new Overtimerequestlog();
		Set<Overtimerequestlog> logs = new HashSet<Overtimerequestlog>();
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		if(overtimeRequestEntity.getHandleflag().equals("Agree")) {
			
			String entity_itemids = overtimeRequestEntity.getItemids();
			String entity_costcenters = overtimeRequestEntity.getCostcenter();
			String entity_paidrates = overtimeRequestEntity.getPaidrates();
			String entity_otherrates = overtimeRequestEntity.getOtherrates();
			String entity_withcomp = overtimeRequestEntity.getWithcompensatorys();
			String entity_compenhrs = overtimeRequestEntity.getCompensatoryhours();
			
			//  判断是PM 的操作还是 GM 的操作
			if(or.getPm().equals(login.getEmp().getEmpLoginId())) {
				// PM 操作。。。
				or.setPmnote(overtimeRequestEntity.getNote());	// 设置PM note
				// or 状态不变 Token发生变化(token executor变化，状态不变)
				Set<TokenOvertime> tokens = or.getTokenOvertimes();
				// agree 的情况下将token 传递给 GM
				for (TokenOvertime token : tokens) {
					token.setTokenExecutor(or.getGm());
				}

				// 设置log
				log.setChangePeople(or.getPm());
				log.setChangeDate(ts);
				log.setLogDesc("PM: " + or.getPm() + " has agreed a overtime request, ID: " + or.getId());
				log.setOvertimerecord(or);
				log.setRequeststate(requeststateDAO.findByStateName("InProg"));
				logs.add(log);
				
				//发邮件 提醒 GM
				String fromStr = login.getEmp().getEmpLoginId();
				Emp toEmp = empDAO.findByLoginName(or.getGm());	// 发邮件给GM
				String toStr = toEmp.getEmail();
				
				SendNotificationMail snm = new SendNotificationMail();
				snm.setFrom(fromStr);
				snm.setTo(toStr);
				snm.setSubject(fromStr + " has sent an overtime request to you.");
				snm.setTriggerBy(fromStr);
				snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm.setLinkText("Link to Request Page.");
				snm.setType("Overtime Request");
				snm.setRequestState(or.getRequeststate().getStateName());
				snm.setTitle("You have an Overtime Reques from " + fromStr);
				snm.sendMail();
				// 发邮件提醒
				
				
				//发邮件 提醒 Applicant
				String fromStr2 = login.getEmp().getEmpLoginId();
				Emp toEmp2 = empDAO.findByLoginName(or.getApplicant());	// 发邮件给Applicant
				String toStr2 = toEmp2.getEmail();
				
				SendNotificationMail snm2 = new SendNotificationMail();
				snm2.setFrom(fromStr2);
				snm2.setTo(toStr2);
				snm2.setSubject(fromStr2 + " has approved your overtime request.");
				snm2.setTriggerBy(fromStr2);
				snm2.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm2.setLinkText("Link to Request Page.");
				snm2.setType("Overtime Request");
				snm2.setRequestState(or.getRequeststate().getStateName());
				snm2.setTitle("Your Overtime Request has been approved by " + fromStr2);
				snm2.sendMail();
				// 发邮件提醒
				
			}
			
			if(or.getGm().equals(login.getEmp().getEmpLoginId())) {
				// 如果是GM 操作。。。。
				or.setGmnote(overtimeRequestEntity.getNote());	// 设置GM note
				// or 状态变为Done
				or.setRequeststate(requeststateDAO.findByStateName("Done"));
				// token 状态变为0
				Set<TokenOvertime> tokens = or.getTokenOvertimes();
				for (TokenOvertime token : tokens) {
					token.setTokenState(0);
				}
				
				// 看看item里面有没有给调休假之类的信息，给相关人员添加调休假,有效期为加班日期半年内
				Set<Overtimerequestitem> items = or.getOvertimerequestitems();
				for (Overtimerequestitem item : items) {
					if(item.getWithCompensatory() != null && item.getWithCompensatory() > 0) {
						if(item.getCompensatoryHours() != null && item.getCompensatoryHours() > 0) {
//							Timestamp startts = item.getStarttime();
							Date dateTs = item.getStarttime();
							Calendar cal = Calendar.getInstance();
							cal.setTime(dateTs);
							cal.add(Calendar.MONTH, 6);
							Date expiredDate = cal.getTime();

							// 添加调休假记录
							Emp emp2 = empDAO.findByLoginName(item.getEmploginid());
							Compensatoryleaveinfo com = new Compensatoryleaveinfo();
							com.setEmp(emp2);
							com.setExpirationDate(expiredDate);
							com.setCompensatoryLeaveLeft(item.getCompensatoryHours());
							com.setCompensatoryLeaveDesc("SYSTEM: Compensatory for Overtime.");
							com.setCreateDate(ts);
							compensatoryleaveinfoDAO.save(com);
						}
					}
					
					
					
				}
				
				
				// 设置log
				log.setChangePeople(or.getGm());
				log.setChangeDate(ts);
				log.setLogDesc("GM: " + or.getGm() + " has agreed an overtime request, ID: " + or.getId());
				log.setOvertimerecord(or);
				log.setRequeststate(requeststateDAO.findByStateName("Done"));
				logs.add(log);
				
				
				//发邮件 提醒 PM
				String fromStr = login.getEmp().getEmpLoginId();
				Emp toEmp = empDAO.findByLoginName(or.getPm());	// 发邮件给PM
				String toStr = toEmp.getEmail();
				
				SendNotificationMail snm = new SendNotificationMail();
				snm.setFrom(fromStr);
				snm.setTo(toStr);
				snm.setSubject(fromStr + " has agreed " + or.getApplicant() + "'s overtime request.");
				snm.setTriggerBy(fromStr);
				snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm.setLinkText("Link to Request Page.");
				snm.setType("Overtime Request");
				snm.setRequestState(or.getRequeststate().getStateName());
				snm.setTitle(or.getApplicant() + "'s Overtime Request has beed agreed by " + fromStr);
				snm.sendMail();
				// 发邮件提醒
				
				
				//发邮件 提醒 Applicant
				String fromStr2 = login.getEmp().getEmpLoginId();
				Emp toEmp2 = empDAO.findByLoginName(or.getApplicant());	// 发邮件给Applicant
				String toStr2 = toEmp2.getEmail();
				
				SendNotificationMail snm2 = new SendNotificationMail();
				snm2.setFrom(fromStr2);
				snm2.setTo(toStr2);
				snm2.setSubject(fromStr2 + " has approved your overtime request.");
				snm2.setTriggerBy(fromStr2);
				snm2.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm2.setLinkText("Link to Request Page.");
				snm2.setType("Overtime Request");
				snm2.setRequestState(or.getRequeststate().getStateName());
				snm2.setTitle("Your Overtime Request has been approved by " + fromStr2);
				snm2.sendMail();
				// 发邮件提醒
				
			}
			
			or.setOvertimerequestlogs(logs);	// or 关联 logs
			
			String[] itemids = entity_itemids.split(";");
			String[] costcenters = entity_costcenters.split(";");
			String[] paidrates = entity_paidrates.split(";");
			String[] otherrates = entity_otherrates.split(";");
			String[] withcomp = entity_withcomp.split(";");
			String[] compenhrs = entity_compenhrs.split(";");
			
			Set<Overtimerequestitem> items = or.getOvertimerequestitems();
			int size = items.size();
			
			if(itemids.length != size || costcenters.length != size || paidrates.length != size
					|| otherrates.length != size || withcomp.length != size || compenhrs.length != size) {
				session.put("globalError", "数组length不一样。。。");
				return ERROR;
			}
			
			
			// 修改overtimerequestItem
			for (int i = 0; i < itemids.length; i++) {
				for (Overtimerequestitem item : items) {
					if(item.getId().toString().equals(itemids[i])) {
						item.setCostcenter(costcenters[i]);	// item 的 cost center
						if(!paidrates[i].equals("others")) {
							item.setOtherPaidRate(0); // Set other paid rate 0, 不等于others
							item.setPaidRate(Double.parseDouble(paidrates[i]));	// item 的 paid rates
						} else if (!otherrates[i].equals("null")) {	// 等于others 又不等于null 的情况
							item.setOtherPaidRate(1);	// Set other paid rate 0
							item.setPaidRate(Double.parseDouble(otherrates[i]));	// paid rate 选择了others, 则填入other rate
						} else {
							System.out.println("otherrates[itemid].equals(\"null\")");
							System.out.println("不设置paid rates");
						}
						
						if(withcomp[i].equals("true")) {	// withCompensatory 为 true
							item.setWithCompensatory(1);
							if(!compenhrs[i].equals("null")) {	// compensatory hours 不为null
								item.setCompensatoryHours(Double.parseDouble(compenhrs[i]));
							} else {	// compensatory hours 为null
								System.out.println("withCompensatory 为true但是compensatoryhours 为 null!");
							}
						} else if (withcomp[i].equals("false")) {	// withCompensatory 为 false
							item.setWithCompensatory(0);
						}
					}
				}
			}
			
			overtimerecordDAO.saveOrUpdate(or);
			
		} else if(overtimeRequestEntity.getHandleflag().equals("Reject")) {
			System.out.println("overtimeRequestEntity.getHandleflag() is: " + overtimeRequestEntity.getHandleflag());
			// or 状态变为Rejected
			Requeststate rs = requeststateDAO.findByStateName("Rejected");
			or.setRequeststate(rs);
			
			//  判断是PM 的操作还是 GM 的操作
			if(or.getPm().equals(login.getEmp().getEmpLoginId())) {
				// PM 操作。。。
				or.setPmnote(overtimeRequestEntity.getNote());	// 设置PM note

				// 设置log
				log.setChangePeople(or.getPm());
				log.setChangeDate(ts);
				log.setLogDesc("PM: " + or.getPm() + " has Rejected a overtime request, ID: " + or.getId());
				log.setOvertimerecord(or);
				log.setRequeststate(rs);
				logs.add(log);
				
				//发邮件 提醒 Applicant
				String fromStr2 = login.getEmp().getEmpLoginId();
				Emp toEmp2 = empDAO.findByLoginName(or.getApplicant());	// 发邮件给Applicant
				String toStr2 = toEmp2.getEmail();
				
				SendNotificationMail snm = new SendNotificationMail();
				snm.setFrom(fromStr2);
				snm.setTo(toStr2);
				snm.setSubject(fromStr2 + " has rejected your overtime request.");
				snm.setTriggerBy(fromStr2);
				snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm.setLinkText("Link to Request Page.");
				snm.setType("Overtime Request");
				snm.setRequestState(or.getRequeststate().getStateName());
				snm.setTitle("Your Overtime Request has been rejected by " + fromStr2);
				snm.sendMail();
				// 发邮件提醒
				
			}
			
			if(or.getGm().equals(login.getEmp().getEmpLoginId())) {
				// 如果是GM 操作。。。。
				or.setGmnote(overtimeRequestEntity.getNote());	// 设置GM note
				
				// 设置log
				log.setChangePeople(or.getGm());
				log.setChangeDate(ts);
				log.setLogDesc("GM: " + or.getGm() + " has Rejected a overtime request, ID: " + or.getId());
				log.setOvertimerecord(or);
				log.setRequeststate(requeststateDAO.findByStateName("Rejected"));
				logs.add(log);
				
				
				//发邮件 提醒 Applicant
				String fromStr = login.getEmp().getEmpLoginId();
				Emp toEmp = empDAO.findByLoginName(or.getApplicant());	// 发邮件给Applicant
				String toStr = toEmp.getEmail();
				
				SendNotificationMail snm = new SendNotificationMail();
				snm.setFrom(fromStr);
				snm.setTo(toStr);
				snm.setSubject(fromStr + " has rejected your overtime request.");
				snm.setTriggerBy(fromStr);
				snm.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm.setLinkText("Link to Request Page.");
				snm.setType("Overtime Request");
				snm.setRequestState(or.getRequeststate().getStateName());
				snm.setTitle("Your Overtime Request has been rejected by " + fromStr);
				snm.sendMail();
				// 发邮件提醒
				
				
				//发邮件 提醒 PM
				String fromStr2 = login.getEmp().getEmpLoginId();
				Emp toEmp2 = empDAO.findByLoginName(or.getPm());	// 发邮件给PM
				String toStr2 = toEmp2.getEmail();
				
				SendNotificationMail snm2 = new SendNotificationMail();
				snm2.setFrom(fromStr2);
				snm2.setTo(toStr2);
				snm2.setSubject(fromStr2 + " has rejected " + or.getApplicant() + "'s overtime request.");
				snm2.setTriggerBy(fromStr2);
				snm2.setLink("http://10.20.10.118:8080/MSH/login.jsp?redirectlink=redirectaction");
				snm2.setLinkText("Link to Request Page.");
				snm2.setType("Overtime Request");
				snm2.setRequestState(or.getRequeststate().getStateName());
				snm2.setTitle(or.getApplicant() + "'s Overtime Request has been rejected by " + fromStr2);
				snm2.sendMail();
				// 发邮件提醒
			}
			
			or.setOvertimerequestlogs(logs);	// or 关联 logs
			
			// or 状态不变 Token发生变化(token executor变化，状态不变)
			Set<TokenOvertime> tokens = or.getTokenOvertimes();
			// Reject 的情况下将token 传递给 Applicant
			for (TokenOvertime token : tokens) {
				// 将 token 传递给 申请人
				// for jasondev01
				token.setTokenExecutor(or.getApplicant());
			}
			
			overtimerecordDAO.saveOrUpdate(or);
			System.out.println("成功reject...");
		}
		
		return SUCCESS;
	}
	
	/**
	 * Overtime History Details
	 * @return
	 */
	public String getOvertimeHistoryDetails() {
		System.out.println("进入 getOvertimeHistoryDetails方法内部。。。。");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
//			session.put("globalError", "请先登录");
			System.out.println("请先登录!");
//			return ERROR;
		}
		
		if(historyOvertimeRecordId == null) {
//			session.put("globalError", "historyOvertimeDetails 为空");
			System.out.println("historyOvertimeRecordId 为空");
//			return ERROR;
		}
		
		int id = Integer.parseInt(historyOvertimeRecordId.trim());
		
		System.out.println("historyOvertimeRecordId: " + id);
		
		Overtimerecord or = overtimerecordDAO.findById(id);
		System.out.println("or.getApplicant(): " + or.getApplicant());
		Set<Overtimerequestitem> items = or.getOvertimerequestitems();
		
		historyOvertimeDetails = new RequestHistoryOvertimeDetails();
		
		historyOvertimeDetails.setPcode(or.getProjectcode());
		historyOvertimeDetails.setPmnote(or.getPmnote() == null ? "" : or.getPmnote()); 	// pm note
		historyOvertimeDetails.setGmnote(or.getGmnote() == null ? "" : or.getGmnote());	// gm note
		
		System.out.println("historyOvertimeDetails.getPmnote(): " + historyOvertimeDetails.getPmnote());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<String[]> list = new ArrayList<String[]>();
		
		for (Overtimerequestitem item : items) {
			System.out.println("item.getId(): " + item.getId());
			String[] arr = new String[7];
			arr[0] = item.getId().toString();	// id
			arr[1] = item.getEmploginid();	// login id
			arr[2] = item.getHours().toString();	// hours
			arr[3] = sdf.format(item.getStarttime());	// start time
			arr[4] = sdf.format(item.getEndtime()); 	// end time
			arr[5] = item.getPaidRate() == null ? "" :item.getPaidRate().toString();	// paid Rate
			
			arr[6] = item.getCompensatoryHours() == null ? "0" : item.getCompensatoryHours().toString();	// compensatory hours
			
			System.out.println("arr[1]: " + arr[1]);
			list.add(arr);
		}
		historyOvertimeDetails.setList(list);
		
		return SUCCESS;
	}
	
	
	/**
	 * Overtime History Track
	 * @return
	 */
	public String getOvertimeHistoryTrack() {
		System.out.println("进入 getOvertimeHistoryDetails方法内部。。。。");
		Map<String, Object> session = getSession();
		Login login = (Login) session.get("login");
		
		if(login == null) {
//			session.put("globalError", "请先登录");
			System.out.println("请先登录!");
//			return ERROR;
		}
		
		if(historyOvertimeRecordId == null) {
//			session.put("globalError", "historyOvertimeDetails 为空");
			System.out.println("historyOvertimeRecordId 为空");
//			return ERROR;
		}
		
		int id = Integer.parseInt(historyOvertimeRecordId.trim());
		Overtimerecord or = overtimerecordDAO.findById(id);
		List<Overtimerequestlog> logs = overtimerequestlogDAO.findByOvertimeRecordId(or.getId());
		
		requestHistoryTracks = new ArrayList<RequestHistoryTrack>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (Overtimerequestlog log : logs) {
			RequestHistoryTrack track = new RequestHistoryTrack();
			track.setId(log.getId());
			track.setDesc(log.getLogDesc());
			track.setDate(sdf.format(log.getChangeDate()));
			track.setPerson(log.getChangePeople());
			track.setState(log.getRequeststate().getStateName());
			requestHistoryTracks.add(track);
		}
		return SUCCESS;
	}
	
}
