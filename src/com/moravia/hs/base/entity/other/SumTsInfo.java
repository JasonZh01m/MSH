package com.moravia.hs.base.entity.other;

public class SumTsInfo {
	private String loginId;		//login id
	private Double tsHrs;   //Time sheet hours
	private Double notPaidHrs; // not paid hours
	private Double paidHrs;   //Paid hours
	private Double absenceHrs;	//Absence hours
	private Double overTime;  //over time hours

	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public Double getTsHrs() {
		return tsHrs;
	}
	public void setTsHrs(Double tsHrs) {
		this.tsHrs = tsHrs;
	}
	public Double getNotPaidHrs() {
		return notPaidHrs;
	}
	public void setNotPaidHrs(Double notPaidHrs) {
		this.notPaidHrs = notPaidHrs;
	}
	public Double getPaidHrs() {
		return paidHrs;
	}
	public void setPaidHrs(Double paidHrs) {
		this.paidHrs = paidHrs;
	}
	public Double getAbsenceHrs() {
		return absenceHrs;
	}
	public void setAbsenceHrs(Double absenceHrs) {
		this.absenceHrs = absenceHrs;
	}
	public Double getOverTime() {
		return overTime;
	}
	public void setOverTime(Double overTime) {
		this.overTime = overTime;
	}
	

}
