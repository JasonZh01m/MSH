package com.moravia.hs.base.entity.other;

public class VacationUsedInfo {
	
	private double annualLeave;		// 已请年假
	private double compensatory;	// 已请调休假
	private double personalLeave;	// 已请事假
	private double longSickMarriageLeave;	// 长病假，婚假，丧假
	private double sickMateryBreaveLeave;	// 病/产/男方护理假
	
	public double getAnnualLeave() {
		return annualLeave;
	}
	public void setAnnualLeave(double annualLeave) {
		this.annualLeave = annualLeave;
	}
	public double getCompensatory() {
		return compensatory;
	}
	public void setCompensatory(double compensatory) {
		this.compensatory = compensatory;
	}
	public double getPersonalLeave() {
		return personalLeave;
	}
	public void setPersonalLeave(double personalLeave) {
		this.personalLeave = personalLeave;
	}
	
	public double getLongSickMarriageLeave() {
		return longSickMarriageLeave;
	}
	public void setLongSickMarriageLeave(double longSickMarriageLeave) {
		this.longSickMarriageLeave = longSickMarriageLeave;
	}
	public double getSickMateryBreaveLeave() {
		return sickMateryBreaveLeave;
	}
	public void setSickMateryBreaveLeave(double sickMateryBreaveLeave) {
		this.sickMateryBreaveLeave = sickMateryBreaveLeave;
	}
	
	

}
