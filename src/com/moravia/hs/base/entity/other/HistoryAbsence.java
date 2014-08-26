package com.moravia.hs.base.entity.other;

import java.util.Date;

/**
 * AbsenceRecord for Absence History
 * @author jasonzh
 *
 */
public class HistoryAbsence {
	private int id;
	private String reason;
	private String empLoginId;
	private String lineManager;
	private String pm;
	private double hrs;
	private String stateName;
	private String createDate;
	private String lineManagerNote;
	

	public String getLineManagerNote() {
		return lineManagerNote;
	}

	public void setLineManagerNote(String lineManagerNote) {
		this.lineManagerNote = lineManagerNote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
