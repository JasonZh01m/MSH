package com.moravia.hs.action.test;

import java.sql.Timestamp;

import com.moravia.hs.base.entity.Requeststate;

public class AbsenceRecord2 {

	private Integer absenceRecordId;
	private Requeststate requeststate;
	private String empLoginId;
	private String applicant;
	private String absenceReason;
	private Double absenceTotalHours;
	private String absenceApproverPm;
	private String absenceApproverLineManager;
	private String absenceNoteLineManager;

	public Integer getAbsenceRecordId() {
		return absenceRecordId;
	}

	public void setAbsenceRecordId(Integer absenceRecordId) {
		this.absenceRecordId = absenceRecordId;
	}

	public Requeststate getRequeststate() {
		return requeststate;
	}

	public void setRequeststate(Requeststate requeststate) {
		this.requeststate = requeststate;
	}

	public String getEmpLoginId() {
		return empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getAbsenceReason() {
		return absenceReason;
	}

	public void setAbsenceReason(String absenceReason) {
		this.absenceReason = absenceReason;
	}

	public Double getAbsenceTotalHours() {
		return absenceTotalHours;
	}

	public void setAbsenceTotalHours(Double absenceTotalHours) {
		this.absenceTotalHours = absenceTotalHours;
	}

	public String getAbsenceApproverPm() {
		return absenceApproverPm;
	}

	public void setAbsenceApproverPm(String absenceApproverPm) {
		this.absenceApproverPm = absenceApproverPm;
	}

	public String getAbsenceApproverLineManager() {
		return absenceApproverLineManager;
	}

	public void setAbsenceApproverLineManager(String absenceApproverLineManager) {
		this.absenceApproverLineManager = absenceApproverLineManager;
	}

	public String getAbsenceNoteLineManager() {
		return absenceNoteLineManager;
	}

	public void setAbsenceNoteLineManager(String absenceNoteLineManager) {
		this.absenceNoteLineManager = absenceNoteLineManager;
	}

}
