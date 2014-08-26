package com.moravia.hs.base.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Absenceinfoview entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "absenceinfoview", catalog = "hr_finance2")
public class Absenceinfoview implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private String stateName;
	private String empLoginId;
	private String absenceApproverPm;
	private String absenceApproverLineManager;
	private Timestamp absenceStartTime;
	private Timestamp absenceEndTime;
	private Double absenceHours;
	private Integer typeId;
	private Integer timeSheetOrderId;
	private Double vacationPaidRate;
	private String vacationTypeName;

	// Constructors

	/** default constructor */
	public Absenceinfoview() {
	}

	/** full constructor */
	/*public Absenceinfoview(String stateName, String empLoginId,
			String absenceApproverPm, String absenceApproverLineManager,
			Timestamp absenceStartTime, Timestamp absenceEndTime,
			Double absenceHours, Integer typeId, Integer timeSheetOrderId,
			Double vacationPaidRate, String vacationTypeName) {
		this.stateName = stateName;
		this.empLoginId = empLoginId;
		this.absenceApproverPm = absenceApproverPm;
		this.absenceApproverLineManager = absenceApproverLineManager;
		this.absenceStartTime = absenceStartTime;
		this.absenceEndTime = absenceEndTime;
		this.absenceHours = absenceHours;
		this.typeId = typeId;
		this.timeSheetOrderId = timeSheetOrderId;
		this.vacationPaidRate = vacationPaidRate;
		this.vacationTypeName = vacationTypeName;
	}*/

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Item_ID", nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "State_Name", length = 50)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "Emp_LoginID", length = 50)
	public String getEmpLoginId() {
		return this.empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	@Column(name = "Absence_Approver_PM", length = 50)
	public String getAbsenceApproverPm() {
		return this.absenceApproverPm;
	}

	public void setAbsenceApproverPm(String absenceApproverPm) {
		this.absenceApproverPm = absenceApproverPm;
	}

	@Column(name = "Absence_Approver_LineManager", length = 50)
	public String getAbsenceApproverLineManager() {
		return this.absenceApproverLineManager;
	}

	public void setAbsenceApproverLineManager(String absenceApproverLineManager) {
		this.absenceApproverLineManager = absenceApproverLineManager;
	}

	@Column(name = "Absence_StartTime", length = 19)
	public Timestamp getAbsenceStartTime() {
		return this.absenceStartTime;
	}

	public void setAbsenceStartTime(Timestamp absenceStartTime) {
		this.absenceStartTime = absenceStartTime;
	}

	@Column(name = "Absence_EndTime", length = 19)
	public Timestamp getAbsenceEndTime() {
		return this.absenceEndTime;
	}

	public void setAbsenceEndTime(Timestamp absenceEndTime) {
		this.absenceEndTime = absenceEndTime;
	}

	@Column(name = "Absence_Hours", precision = 22, scale = 0)
	public Double getAbsenceHours() {
		return this.absenceHours;
	}

	public void setAbsenceHours(Double absenceHours) {
		this.absenceHours = absenceHours;
	}

	@Column(name = "Type_ID")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "TimeSheetOrderID")
	public Integer getTimeSheetOrderId() {
		return this.timeSheetOrderId;
	}

	public void setTimeSheetOrderId(Integer timeSheetOrderId) {
		this.timeSheetOrderId = timeSheetOrderId;
	}

	@Column(name = "Vacation_Paid_Rate", precision = 22, scale = 0)
	public Double getVacationPaidRate() {
		return this.vacationPaidRate;
	}

	public void setVacationPaidRate(Double vacationPaidRate) {
		this.vacationPaidRate = vacationPaidRate;
	}

	@Column(name = "Vacation_Type_Name", length = 50)
	public String getVacationTypeName() {
		return this.vacationTypeName;
	}

	public void setVacationTypeName(String vacationTypeName) {
		this.vacationTypeName = vacationTypeName;
	}

}