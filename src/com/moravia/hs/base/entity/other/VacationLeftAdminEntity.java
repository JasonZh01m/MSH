package com.moravia.hs.base.entity.other;

import java.util.List;

import com.moravia.hs.base.entity.Compensatoryleaveinfo;

public class VacationLeftAdminEntity {

	private String emploginid;
	private double annualAdd;
	private String annualDesc;
	private double compenAdd;
	private String compenDesc;
	private String compenExpireDate;
	private String isExpired;
	private String operationFlag; // add compensatory or annual
	
	private int totalpage;	// pagination related
	
	private double annualTotalLeft;
	private double compenTotalLeft;
	
	
	private List<String[]> compensatorys;	// 全部compensatory leave 信息
	private List<String[]> histories;	// 分页的历史记录信息

	
	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public String getOperationFlag() {
		return operationFlag;
	}

	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}

	public double getAnnualTotalLeft() {
		return annualTotalLeft;
	}

	public void setAnnualTotalLeft(double annualTotalLeft) {
		this.annualTotalLeft = annualTotalLeft;
	}

	public double getCompenTotalLeft() {
		return compenTotalLeft;
	}

	public void setCompenTotalLeft(double compenTotalLeft) {
		this.compenTotalLeft = compenTotalLeft;
	}

	public String getAnnualDesc() {
		return annualDesc;
	}

	public void setAnnualDesc(String annualDesc) {
		this.annualDesc = annualDesc;
	}

	public String getCompenDesc() {
		return compenDesc;
	}

	public void setCompenDesc(String compenDesc) {
		this.compenDesc = compenDesc;
	}

	public String getCompenExpireDate() {
		return compenExpireDate;
	}

	public void setCompenExpireDate(String compenExpireDate) {
		this.compenExpireDate = compenExpireDate;
	}

	public List<String[]> getHistories() {
		return histories;
	}

	public void setHistories(List<String[]> histories) {
		this.histories = histories;
	}

	public String getEmploginid() {
		return emploginid;
	}

	public void setEmploginid(String emploginid) {
		this.emploginid = emploginid;
	}

	public double getAnnualAdd() {
		return annualAdd;
	}

	public void setAnnualAdd(double annualAdd) {
		this.annualAdd = annualAdd;
	}

	public double getCompenAdd() {
		return compenAdd;
	}

	public void setCompenAdd(double compenAdd) {
		this.compenAdd = compenAdd;
	}

	public String getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}

	public List<String[]> getCompensatorys() {
		return compensatorys;
	}

	public void setCompensatorys(List<String[]> compensatorys) {
		this.compensatorys = compensatorys;
	}
	
	
}
