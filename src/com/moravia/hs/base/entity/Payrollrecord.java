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
 * Payrollrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "payrollrecord", catalog = "hr_finance2")
public class Payrollrecord implements java.io.Serializable {

	// Fields

	private Integer payrollId;
	private String empEmpLoginId;
	private Integer month;
	private Date startDate;
	private Date endDate;
	private Double baseSalary;
	private Double quartBonus;
	private Double postAllowance;
	private Double transportAllowance;
	private Double bonus;
	private Double mealSubsidy;
	private Double totalTimeSheetHrs;
	private Double totalWorkHrs;
	private Double overtime;
	private Double overtimePay;
	private Double pensionPersonal;
	private Double pensionCompany;
	private Double medicalPersonal;
	private Double medicalCompany;
	private Double accumFundPersonal;
	private Double accumFundCompany;
	private Double unempInsuPersonal;
	private Double unempInsuCompany;
	private Double incomeTax;
	private Double occupInjureMaternity;
	private Double mboMonthlyPortion;
	private Double annualBonusMonthlyPortion;
	private String departmentName;
	private String costCenterName;
	private Date payDate;
	private Double otherPay;
	private String payrollNote;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Payrollrecord() {
	}

	/** minimal constructor */
	public Payrollrecord(Date startDate, Date endDate, Double baseSalary,
			Double quartBonus, Double postAllowance, Double transportAllowance,
			Double bonus, Double mealSubsidy, Double overtimePay,
			Double pensionPersonal, Double pensionCompany,
			Double medicalPersonal, Double medicalCompany,
			Double accumFundPersonal, Double accumFundCompany,
			Double unempInsuPersonal, Double unempInsuCompany,
			Double incomeTax, Double occupInjureMaternity,
			Double mboMonthlyPortion, Double annualBonusMonthlyPortion,
			Double otherPay) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.baseSalary = baseSalary;
		this.quartBonus = quartBonus;
		this.postAllowance = postAllowance;
		this.transportAllowance = transportAllowance;
		this.bonus = bonus;
		this.mealSubsidy = mealSubsidy;
		this.overtimePay = overtimePay;
		this.pensionPersonal = pensionPersonal;
		this.pensionCompany = pensionCompany;
		this.medicalPersonal = medicalPersonal;
		this.medicalCompany = medicalCompany;
		this.accumFundPersonal = accumFundPersonal;
		this.accumFundCompany = accumFundCompany;
		this.unempInsuPersonal = unempInsuPersonal;
		this.unempInsuCompany = unempInsuCompany;
		this.incomeTax = incomeTax;
		this.occupInjureMaternity = occupInjureMaternity;
		this.mboMonthlyPortion = mboMonthlyPortion;
		this.annualBonusMonthlyPortion = annualBonusMonthlyPortion;
		this.otherPay = otherPay;
	}

	/** full constructor */
	public Payrollrecord(String empEmpLoginId, Integer month, Date startDate,
			Date endDate, Double baseSalary, Double quartBonus,
			Double postAllowance, Double transportAllowance, Double bonus,
			Double mealSubsidy, Double totalTimeSheetHrs, Double totalWorkHrs,
			Double overtime, Double overtimePay, Double pensionPersonal,
			Double pensionCompany, Double medicalPersonal,
			Double medicalCompany, Double accumFundPersonal,
			Double accumFundCompany, Double unempInsuPersonal,
			Double unempInsuCompany, Double incomeTax,
			Double occupInjureMaternity, Double mboMonthlyPortion,
			Double annualBonusMonthlyPortion, String departmentName,
			String costCenterName, Date payDate, Double otherPay,
			String payrollNote, Timestamp createDate) {
		this.empEmpLoginId = empEmpLoginId;
		this.month = month;
		this.startDate = startDate;
		this.endDate = endDate;
		this.baseSalary = baseSalary;
		this.quartBonus = quartBonus;
		this.postAllowance = postAllowance;
		this.transportAllowance = transportAllowance;
		this.bonus = bonus;
		this.mealSubsidy = mealSubsidy;
		this.totalTimeSheetHrs = totalTimeSheetHrs;
		this.totalWorkHrs = totalWorkHrs;
		this.overtime = overtime;
		this.overtimePay = overtimePay;
		this.pensionPersonal = pensionPersonal;
		this.pensionCompany = pensionCompany;
		this.medicalPersonal = medicalPersonal;
		this.medicalCompany = medicalCompany;
		this.accumFundPersonal = accumFundPersonal;
		this.accumFundCompany = accumFundCompany;
		this.unempInsuPersonal = unempInsuPersonal;
		this.unempInsuCompany = unempInsuCompany;
		this.incomeTax = incomeTax;
		this.occupInjureMaternity = occupInjureMaternity;
		this.mboMonthlyPortion = mboMonthlyPortion;
		this.annualBonusMonthlyPortion = annualBonusMonthlyPortion;
		this.departmentName = departmentName;
		this.costCenterName = costCenterName;
		this.payDate = payDate;
		this.otherPay = otherPay;
		this.payrollNote = payrollNote;
		this.createDate = createDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Payroll_ID", unique = true, nullable = false)
	public Integer getPayrollId() {
		return this.payrollId;
	}

	public void setPayrollId(Integer payrollId) {
		this.payrollId = payrollId;
	}

	@Column(name = "Emp_empLoginID")
	public String getEmpEmpLoginId() {
		return this.empEmpLoginId;
	}

	public void setEmpEmpLoginId(String empEmpLoginId) {
		this.empEmpLoginId = empEmpLoginId;
	}

	@Column(name = "Month")
	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "StartDate", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EndDate", nullable = false, length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "Base_Salary", nullable = false, precision = 22, scale = 0)
	public Double getBaseSalary() {
		return this.baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Column(name = "Quart_Bonus", nullable = false, precision = 22, scale = 0)
	public Double getQuartBonus() {
		return this.quartBonus;
	}

	public void setQuartBonus(Double quartBonus) {
		this.quartBonus = quartBonus;
	}

	@Column(name = "Post_Allowance", nullable = false, precision = 22, scale = 0)
	public Double getPostAllowance() {
		return this.postAllowance;
	}

	public void setPostAllowance(Double postAllowance) {
		this.postAllowance = postAllowance;
	}

	@Column(name = "Transport_Allowance", nullable = false, precision = 22, scale = 0)
	public Double getTransportAllowance() {
		return this.transportAllowance;
	}

	public void setTransportAllowance(Double transportAllowance) {
		this.transportAllowance = transportAllowance;
	}

	@Column(name = "Bonus", nullable = false, precision = 22, scale = 0)
	public Double getBonus() {
		return this.bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	@Column(name = "Meal_Subsidy", nullable = false, precision = 22, scale = 0)
	public Double getMealSubsidy() {
		return this.mealSubsidy;
	}

	public void setMealSubsidy(Double mealSubsidy) {
		this.mealSubsidy = mealSubsidy;
	}

	@Column(name = "TotalTimeSheetHrs", precision = 22, scale = 0)
	public Double getTotalTimeSheetHrs() {
		return this.totalTimeSheetHrs;
	}

	public void setTotalTimeSheetHrs(Double totalTimeSheetHrs) {
		this.totalTimeSheetHrs = totalTimeSheetHrs;
	}

	@Column(name = "TotalWorkHrs", precision = 22, scale = 0)
	public Double getTotalWorkHrs() {
		return this.totalWorkHrs;
	}

	public void setTotalWorkHrs(Double totalWorkHrs) {
		this.totalWorkHrs = totalWorkHrs;
	}

	@Column(name = "Overtime", precision = 22, scale = 0)
	public Double getOvertime() {
		return this.overtime;
	}

	public void setOvertime(Double overtime) {
		this.overtime = overtime;
	}

	@Column(name = "Overtime_Pay", nullable = false, precision = 22, scale = 0)
	public Double getOvertimePay() {
		return this.overtimePay;
	}

	public void setOvertimePay(Double overtimePay) {
		this.overtimePay = overtimePay;
	}

	@Column(name = "Pension_Personal", nullable = false, precision = 22, scale = 0)
	public Double getPensionPersonal() {
		return this.pensionPersonal;
	}

	public void setPensionPersonal(Double pensionPersonal) {
		this.pensionPersonal = pensionPersonal;
	}

	@Column(name = "Pension_Company", nullable = false, precision = 22, scale = 0)
	public Double getPensionCompany() {
		return this.pensionCompany;
	}

	public void setPensionCompany(Double pensionCompany) {
		this.pensionCompany = pensionCompany;
	}

	@Column(name = "Medical_Personal", nullable = false, precision = 22, scale = 0)
	public Double getMedicalPersonal() {
		return this.medicalPersonal;
	}

	public void setMedicalPersonal(Double medicalPersonal) {
		this.medicalPersonal = medicalPersonal;
	}

	@Column(name = "Medical_Company", nullable = false, precision = 22, scale = 0)
	public Double getMedicalCompany() {
		return this.medicalCompany;
	}

	public void setMedicalCompany(Double medicalCompany) {
		this.medicalCompany = medicalCompany;
	}

	@Column(name = "Accum_Fund_Personal", nullable = false, precision = 22, scale = 0)
	public Double getAccumFundPersonal() {
		return this.accumFundPersonal;
	}

	public void setAccumFundPersonal(Double accumFundPersonal) {
		this.accumFundPersonal = accumFundPersonal;
	}

	@Column(name = "Accum_Fund_Company", nullable = false, precision = 22, scale = 0)
	public Double getAccumFundCompany() {
		return this.accumFundCompany;
	}

	public void setAccumFundCompany(Double accumFundCompany) {
		this.accumFundCompany = accumFundCompany;
	}

	@Column(name = "Unemp_Insu_Personal", nullable = false, precision = 22, scale = 0)
	public Double getUnempInsuPersonal() {
		return this.unempInsuPersonal;
	}

	public void setUnempInsuPersonal(Double unempInsuPersonal) {
		this.unempInsuPersonal = unempInsuPersonal;
	}

	@Column(name = "Unemp_Insu_Company", nullable = false, precision = 22, scale = 0)
	public Double getUnempInsuCompany() {
		return this.unempInsuCompany;
	}

	public void setUnempInsuCompany(Double unempInsuCompany) {
		this.unempInsuCompany = unempInsuCompany;
	}

	@Column(name = "Income_Tax", nullable = false, precision = 22, scale = 0)
	public Double getIncomeTax() {
		return this.incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}

	@Column(name = "OccupInjure_Maternity", nullable = false, precision = 22, scale = 0)
	public Double getOccupInjureMaternity() {
		return this.occupInjureMaternity;
	}

	public void setOccupInjureMaternity(Double occupInjureMaternity) {
		this.occupInjureMaternity = occupInjureMaternity;
	}

	@Column(name = "MBO_MonthlyPortion", nullable = false, precision = 22, scale = 0)
	public Double getMboMonthlyPortion() {
		return this.mboMonthlyPortion;
	}

	public void setMboMonthlyPortion(Double mboMonthlyPortion) {
		this.mboMonthlyPortion = mboMonthlyPortion;
	}

	@Column(name = "AnnualBonus_MonthlyPortion", nullable = false, precision = 22, scale = 0)
	public Double getAnnualBonusMonthlyPortion() {
		return this.annualBonusMonthlyPortion;
	}

	public void setAnnualBonusMonthlyPortion(Double annualBonusMonthlyPortion) {
		this.annualBonusMonthlyPortion = annualBonusMonthlyPortion;
	}

	@Column(name = "Department_Name")
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Column(name = "CostCenter_Name")
	public String getCostCenterName() {
		return this.costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Pay_Date", length = 10)
	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Column(name = "Other_Pay", nullable = false, precision = 22, scale = 0)
	public Double getOtherPay() {
		return this.otherPay;
	}

	public void setOtherPay(Double otherPay) {
		this.otherPay = otherPay;
	}

	@Column(name = "PayrollNote", length = 500)
	public String getPayrollNote() {
		return this.payrollNote;
	}

	public void setPayrollNote(String payrollNote) {
		this.payrollNote = payrollNote;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}