package com.moravia.hs.base.entity.other;

public class TsSumDiffTime {

	private String loginName;
	private Double sumTime;

	public TsSumDiffTime() {

	}

	public TsSumDiffTime(String loginName, Double sumTime) {
		this.loginName = loginName;
		this.sumTime = sumTime;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Double getSumTime() {
		return sumTime;
	}

	public void setSumTime(Double sumTime) {
		this.sumTime = sumTime;
	}

}
