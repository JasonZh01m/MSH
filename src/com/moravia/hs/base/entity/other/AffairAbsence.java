package com.moravia.hs.base.entity.other;

/**
 * Request Affairs, Absence Request Info
 * 
 * @author jasonzh
 * 
 */
public class AffairAbsence {
	private int id;
	private String empLoginId;
	private String lineManager;
	private String pm;
	private double hrs;
	private String stateName;
	private String createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpLoginId() {
		return empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
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

}
