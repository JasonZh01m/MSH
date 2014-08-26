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
 * Absencerequestitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "absencerequestitem", catalog = "hr_finance2")
public class Absencerequestitem implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Absencerecord absencerecord;
	private Vacationtype vacationtype;
	private String absenceType;
	private Double absenceHours;
	private Timestamp absenceStartTime;
	private Timestamp absenceEndTime;

	// Constructors

	/** default constructor */
	public Absencerequestitem() {
		
	}

	/** full constructor */
	public Absencerequestitem(Absencerecord absencerecord,
			Vacationtype vacationtype, String absenceType, Double absenceHours,
			Timestamp absenceStartTime, Timestamp absenceEndTime) {
		this.absencerecord = absencerecord;
		this.vacationtype = vacationtype;
		this.absenceType = absenceType;
		this.absenceHours = absenceHours;
		this.absenceStartTime = absenceStartTime;
		this.absenceEndTime = absenceEndTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Item_ID", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Related_RequestID")
	public Absencerecord getAbsencerecord() {
		return this.absencerecord;
	}

	public void setAbsencerecord(Absencerecord absencerecord) {
		this.absencerecord = absencerecord;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Type_ID")
	public Vacationtype getVacationtype() {
		return this.vacationtype;
	}

	public void setVacationtype(Vacationtype vacationtype) {
		this.vacationtype = vacationtype;
	}

	@Column(name = "Absence_Type")
	public String getAbsenceType() {
		return this.absenceType;
	}

	public void setAbsenceType(String absenceType) {
		this.absenceType = absenceType;
	}

	@Column(name = "Absence_Hours", precision = 22, scale = 0)
	public Double getAbsenceHours() {
		return this.absenceHours;
	}

	public void setAbsenceHours(Double absenceHours) {
		this.absenceHours = absenceHours;
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

}