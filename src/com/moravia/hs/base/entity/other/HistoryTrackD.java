package com.moravia.hs.base.entity.other;

import java.util.Date;

/**
 * @author jasonzh This entity is used to represent a record by history track
 *         for HR employee history track. For baseSalary, SocialIns and MBO
 */
public class HistoryTrackD {

	private Double value;
	private Date validateDate;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

}
