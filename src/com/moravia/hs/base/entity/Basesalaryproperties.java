package com.moravia.hs.base.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Basesalaryproperties entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "basesalaryproperties", catalog = "hr_finance2")
public class Basesalaryproperties implements java.io.Serializable {

	// Fields

	private Integer baseConstantId;
	private Date startDate;
	private Date endDate;
	private Double totalWorkHours;
	private Double totalWorkDays;
	private Double baseSalaryHrs;
	private Double dailyMealSubsidy;
	private Double monthlyTransAllowance;
	private Double probationBaseRate;
	private Double minimumWage;
	private Double incomtaxThreshold;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Basesalaryproperties() {
	}

	/** full constructor */
	public Basesalaryproperties(Date startDate, Date endDate,
			Double totalWorkHours, Double totalWorkDays, Double baseSalaryHrs,
			Double dailyMealSubsidy, Double monthlyTransAllowance,
			Double probationBaseRate, Double minimumWage,
			Double incomtaxThreshold, Timestamp createDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalWorkHours = totalWorkHours;
		this.totalWorkDays = totalWorkDays;
		this.baseSalaryHrs = baseSalaryHrs;
		this.dailyMealSubsidy = dailyMealSubsidy;
		this.monthlyTransAllowance = monthlyTransAllowance;
		this.probationBaseRate = probationBaseRate;
		this.minimumWage = minimumWage;
		this.incomtaxThreshold = incomtaxThreshold;
		this.createDate = createDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "baseConstant_ID", unique = true, nullable = false)
	public Integer getBaseConstantId() {
		return this.baseConstantId;
	}

	public void setBaseConstantId(Integer baseConstantId) {
		this.baseConstantId = baseConstantId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "StartDate", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EndDate", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "TotalWorkHours", precision = 22, scale = 0)
	public Double getTotalWorkHours() {
		return this.totalWorkHours;
	}

	public void setTotalWorkHours(Double totalWorkHours) {
		this.totalWorkHours = totalWorkHours;
	}

	@Column(name = "TotalWorkDays", precision = 22, scale = 0)
	public Double getTotalWorkDays() {
		return this.totalWorkDays;
	}

	public void setTotalWorkDays(Double totalWorkDays) {
		this.totalWorkDays = totalWorkDays;
	}

	@Column(name = "Base_Salary_Hrs", precision = 22, scale = 0)
	public Double getBaseSalaryHrs() {
		return this.baseSalaryHrs;
	}

	public void setBaseSalaryHrs(Double baseSalaryHrs) {
		this.baseSalaryHrs = baseSalaryHrs;
	}

	@Column(name = "Daily_MealSubsidy", precision = 22, scale = 0)
	public Double getDailyMealSubsidy() {
		return this.dailyMealSubsidy;
	}

	public void setDailyMealSubsidy(Double dailyMealSubsidy) {
		this.dailyMealSubsidy = dailyMealSubsidy;
	}

	@Column(name = "Monthly_TransAllowance", precision = 22, scale = 0)
	public Double getMonthlyTransAllowance() {
		return this.monthlyTransAllowance;
	}

	public void setMonthlyTransAllowance(Double monthlyTransAllowance) {
		this.monthlyTransAllowance = monthlyTransAllowance;
	}

	@Column(name = "Probation_BaseRate", precision = 22, scale = 0)
	public Double getProbationBaseRate() {
		return this.probationBaseRate;
	}

	public void setProbationBaseRate(Double probationBaseRate) {
		this.probationBaseRate = probationBaseRate;
	}

	@Column(name = "Minimum_Wage", precision = 22, scale = 0)
	public Double getMinimumWage() {
		return this.minimumWage;
	}

	public void setMinimumWage(Double minimumWage) {
		this.minimumWage = minimumWage;
	}

	@Column(name = "Incomtax_Threshold", precision = 22, scale = 0)
	public Double getIncomtaxThreshold() {
		return this.incomtaxThreshold;
	}

	public void setIncomtaxThreshold(Double incomtaxThreshold) {
		this.incomtaxThreshold = incomtaxThreshold;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}