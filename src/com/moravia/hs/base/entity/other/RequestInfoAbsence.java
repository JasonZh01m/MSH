package com.moravia.hs.base.entity.other;

import java.util.ArrayList;
import java.util.List;

import com.moravia.hs.base.entity.Absencerequestitem;

public class RequestInfoAbsence {

	private int requestId;
	// emp loginid
	private String empLoginId;
	// departmen
	private String department;
	// line manager
	private String lineManager;
	// pm
	private String pm;
	// reason
	private String reason;
	
	private List requestItems;
	
	public List getRequestItems() {
		return requestItems;
	}

	public void setRequestItems(List requestItems) {
		this.requestItems = requestItems;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getEmpLoginId() {
		return empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
