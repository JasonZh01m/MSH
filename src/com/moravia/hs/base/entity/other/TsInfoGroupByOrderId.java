package com.moravia.hs.base.entity.other;

import org.hibernate.annotations.Entity;

public class TsInfoGroupByOrderId {

	private String loginName;
	private Integer orderId;
	private Double sumDiff;
	private String projectName;
	private String pmName;

	public TsInfoGroupByOrderId() {

	}

	public TsInfoGroupByOrderId(String loginName, Integer orderId, Double sumDiff,
			String projectName, String pmName) {
		this.loginName = loginName;
		this.orderId = orderId;
		this.sumDiff = sumDiff;
		this.projectName = projectName;
		this.pmName = pmName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getSumDiff() {
		return sumDiff;
	}

	public void setSumDiff(Double sumDiff) {
		this.sumDiff = sumDiff;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPmName() {
		return pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}

}
