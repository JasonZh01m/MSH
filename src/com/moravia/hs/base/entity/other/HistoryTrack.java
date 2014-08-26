package com.moravia.hs.base.entity.other;

import java.util.Date;

/**
 * @author jasonzh
 * This entity is used to represent a record by history track for HR employee history track.
 * For position_title_name, depart_name and lineManager	
 */
public class HistoryTrack {

	private String section_Name;
	private Date validateDate;

	public String getSection_Name() {
		return section_Name;
	}

	public void setSection_Name(String section_Name) {
		this.section_Name = section_Name;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

}
