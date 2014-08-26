package com.moravia.hs.base.entity.other;

/**
 * This is an entity for overtime request application's parameters
 * 
 * @author jasonzh
 * 
 */
public class OvertimeRequestEntity {
	// Affairs Related
	private int id;
	private String applicant;	// 申请人
	private double hrs;		//总小时数
	private String stateName;	// 状态
	private String createDate;	//	申请时间
	private String page;	// 请求第几页
	
	// Apply Related
	private String pm; // project manager
	private String gm; // group manager
	private String pcode; // project code
	private String pname; // project name
	private String emps;
	private String startTimes;
	private String endTimes;
	private String comments;
	
	// Overtime Request Handle related
	private String handleflag;	// handle 类型
	private String itemids;	// 所有的item id
	private String costcenter;	// 所有的cost center id
	private String paidrates;	// 所有的paid rates
	private String otherrates;	// 所有的other paid rates
	private String withcompensatorys;	// 所有的with compensatory?
	private String compensatoryhours;	// 所有的compensatory hrs
	private String note;	// PM 和 GM 共用一个note属性
	

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getHandleflag() {
		return handleflag;
	}

	public void setHandleflag(String handleflag) {
		this.handleflag = handleflag;
	}

	public String getItemids() {
		return itemids;
	}

	public void setItemids(String itemids) {
		this.itemids = itemids;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getPaidrates() {
		return paidrates;
	}

	public void setPaidrates(String paidrates) {
		this.paidrates = paidrates;
	}

	public String getOtherrates() {
		return otherrates;
	}

	public void setOtherrates(String otherrates) {
		this.otherrates = otherrates;
	}

	public String getWithcompensatorys() {
		return withcompensatorys;
	}

	public void setWithcompensatorys(String withcompensatorys) {
		this.withcompensatorys = withcompensatorys;
	}

	public String getCompensatoryhours() {
		return compensatoryhours;
	}

	public void setCompensatoryhours(String compensatoryhours) {
		this.compensatoryhours = compensatoryhours;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getGm() {
		return gm;
	}

	public void setGm(String gm) {
		this.gm = gm;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getEmps() {
		return emps;
	}

	public void setEmps(String emps) {
		this.emps = emps;
	}

	public String getStartTimes() {
		return startTimes;
	}

	public void setStartTimes(String startTimes) {
		this.startTimes = startTimes;
	}

	public String getEndTimes() {
		return endTimes;
	}

	public void setEndTimes(String endTimes) {
		this.endTimes = endTimes;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public double getHrs() {
		return hrs;
	}

	public void setHrs(double hrs) {
		this.hrs = hrs;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	

}
