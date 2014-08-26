package com.moravia.hs.base.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Vacationchangerecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vacationchangerecord", catalog = "hr_finance2")
public class Vacationchangerecord implements java.io.Serializable {

	// Fields

	private Integer changeRecordId;
	private Emp emp;
	private Vacationtype vacationtype;
	private Absencerecord absencerecord;
//	private Timestamp changeDate;
	private Integer vacationAddOrMinus;
	private Double changeHours;
	private String changeBy;
	private String changeReason;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Vacationchangerecord() {
		
	}


	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ChangeRecord_ID", unique = true, nullable = false)
	public Integer getChangeRecordId() {
		return this.changeRecordId;
	}

	public void setChangeRecordId(Integer changeRecordId) {
		this.changeRecordId = changeRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Emp_ID")
	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VacationType")
	public Vacationtype getVacationtype() {
		return this.vacationtype;
	}

	public void setVacationtype(Vacationtype vacationtype) {
		this.vacationtype = vacationtype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ReleatedAbsenceRecord")
	public Absencerecord getAbsencerecord() {
		return this.absencerecord;
	}

	public void setAbsencerecord(Absencerecord absencerecord) {
		this.absencerecord = absencerecord;
	}

	/*@Column(name = "ChangeDate", length = 19)
	public Timestamp getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}*/

	@Column(name = "VacationAddOrMinus")
	public Integer getVacationAddOrMinus() {
		return this.vacationAddOrMinus;
	}

	public void setVacationAddOrMinus(Integer vacationAddOrMinus) {
		this.vacationAddOrMinus = vacationAddOrMinus;
	}

	@Column(name = "ChangeHours", precision = 22, scale = 0)
	public Double getChangeHours() {
		return this.changeHours;
	}

	public void setChangeHours(Double changeHours) {
		this.changeHours = changeHours;
	}
	
	@Column(name = "ChangeBy")
	public String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}


	@Column(name = "Change_Reason")
	public String getChangeReason() {
		return this.changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}