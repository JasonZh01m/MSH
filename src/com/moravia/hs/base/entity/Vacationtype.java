package com.moravia.hs.base.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Vacationtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vacationtype", catalog = "hr_finance2")
public class Vacationtype implements java.io.Serializable {

	// Fields

	private Integer vacationTypeId;
	private Integer timeSheetOrderId;
	private String vacationTypeName;
	private Double vacationPaidRate;
	private String vacationTypeDesc;
//	private Set<Absencerequestitem> absencerequestitems = new HashSet<Absencerequestitem>(
//			0);

	// Constructors

	/** default constructor */
	public Vacationtype() {
	}

	/** full constructor */
	/*public Vacationtype(Integer timeSheetOrderId, String vacationTypeName,
			Double vacationPaidRate, String vacationTypeDesc,
			Set<Absencerequestitem> absencerequestitems) {
		this.timeSheetOrderId = timeSheetOrderId;
		this.vacationTypeName = vacationTypeName;
		this.vacationPaidRate = vacationPaidRate;
		this.vacationTypeDesc = vacationTypeDesc;
		this.absencerequestitems = absencerequestitems;
	}*/

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Vacation_Type_ID", unique = true, nullable = false)
	public Integer getVacationTypeId() {
		return this.vacationTypeId;
	}

	public void setVacationTypeId(Integer vacationTypeId) {
		this.vacationTypeId = vacationTypeId;
	}

	@Column(name = "TimeSheetOrderID")
	public Integer getTimeSheetOrderId() {
		return this.timeSheetOrderId;
	}

	public void setTimeSheetOrderId(Integer timeSheetOrderId) {
		this.timeSheetOrderId = timeSheetOrderId;
	}

	@Column(name = "Vacation_Type_Name", length = 50)
	public String getVacationTypeName() {
		return this.vacationTypeName;
	}

	public void setVacationTypeName(String vacationTypeName) {
		this.vacationTypeName = vacationTypeName;
	}

	@Column(name = "Vacation_Paid_Rate", precision = 22, scale = 0)
	public Double getVacationPaidRate() {
		return this.vacationPaidRate;
	}

	public void setVacationPaidRate(Double vacationPaidRate) {
		this.vacationPaidRate = vacationPaidRate;
	}

	@Column(name = "Vacation_Type_Desc", length = 500)
	public String getVacationTypeDesc() {
		return this.vacationTypeDesc;
	}

	public void setVacationTypeDesc(String vacationTypeDesc) {
		this.vacationTypeDesc = vacationTypeDesc;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vacationtype")
	public Set<Absencerequestitem> getAbsencerequestitems() {
		return this.absencerequestitems;
	}

	public void setAbsencerequestitems(
			Set<Absencerequestitem> absencerequestitems) {
		this.absencerequestitems = absencerequestitems;
	}*/

}