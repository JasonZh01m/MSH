package com.moravia.hs.base.entity.other;

import java.util.Date;

/*员工每月的请假信息，对应日期以及每天总的请假小时数*/
public class TsMonthlyAbsenceInfo {

	private Integer orderId;
	private Double sumDiff;
	private Date date;

	public TsMonthlyAbsenceInfo() {

	}
	
	public TsMonthlyAbsenceInfo(Integer orderId, Double sumDiff, Date date) {
		this.orderId = orderId;
		this.sumDiff = sumDiff;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
