package com.moravia.hs.base.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Empchangerecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "empchangerecord", catalog = "hr_finance2")
public class Empchangerecord implements java.io.Serializable {

	// Fields

	private Integer changeRecordId;
	private Emp emp;
	private String empLoginId;
	private String nameChinese;
	private String nameEnglish;
	private String contractType;
	private String empType;
	private Date entryDate;
	private Date leaveDate;
	private String lineManager;
	private Date lineManagerValidate;
	private String workplace;
	private String positionTitleName;
	private Date positionTitleValidate;
	private String departmentName;
	private Date departmentValidate;
	private Double baseSalary;
	private Date baseSalaryValidate;
	private Double mbo;
	private Date mboValidate;
	private Double socialInsurBase;
	private Date socialInsurValidate;
	private String costCenter;
	private Date costCenterValidate;
	private String systemRole;
	private Integer onJob;
	private Date modifyDate;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Empchangerecord() {
	}

	/** full constructor */
	public Empchangerecord(Emp emp, String empLoginId, String nameChinese,
			String nameEnglish, String contractType, String empType,
			Date entryDate, Date leaveDate, String lineManager,
			Date lineManagerValidate, String workplace,
			String positionTitleName, Date positionTitleValidate,
			String departmentName, Date departmentValidate, Double baseSalary,
			Date baseSalaryValidate, Double mbo, Date mboValidate,
			Double socialInsurBase, Date socialInsurValidate,
			String costCenter, Date costCenterValidate, String systemRole,
			Integer onJob, Date modifyDate, Timestamp createDate) {
		this.emp = emp;
		this.empLoginId = empLoginId;
		this.nameChinese = nameChinese;
		this.nameEnglish = nameEnglish;
		this.contractType = contractType;
		this.empType = empType;
		this.entryDate = entryDate;
		this.leaveDate = leaveDate;
		this.lineManager = lineManager;
		this.lineManagerValidate = lineManagerValidate;
		this.workplace = workplace;
		this.positionTitleName = positionTitleName;
		this.positionTitleValidate = positionTitleValidate;
		this.departmentName = departmentName;
		this.departmentValidate = departmentValidate;
		this.baseSalary = baseSalary;
		this.baseSalaryValidate = baseSalaryValidate;
		this.mbo = mbo;
		this.mboValidate = mboValidate;
		this.socialInsurBase = socialInsurBase;
		this.socialInsurValidate = socialInsurValidate;
		this.costCenter = costCenter;
		this.costCenterValidate = costCenterValidate;
		this.systemRole = systemRole;
		this.onJob = onJob;
		this.modifyDate = modifyDate;
		this.createDate = createDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Change_Record_ID", unique = true, nullable = false)
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

	@Column(name = "Emp_LoginID", length = 11)
	public String getEmpLoginId() {
		return this.empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	@Column(name = "Name_Chinese", length = 20)
	public String getNameChinese() {
		return this.nameChinese;
	}

	public void setNameChinese(String nameChinese) {
		this.nameChinese = nameChinese;
	}

	@Column(name = "Name_English", length = 40)
	public String getNameEnglish() {
		return this.nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	@Column(name = "Contract_Type", length = 50)
	public String getContractType() {
		return this.contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	@Column(name = "Emp_Type", length = 50)
	public String getEmpType() {
		return this.empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Entry_Date", length = 10)
	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Leave_Date", length = 10)
	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Column(name = "Line_Manager", length = 40)
	public String getLineManager() {
		return this.lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Line_Manager_Validate", length = 10)
	public Date getLineManagerValidate() {
		return this.lineManagerValidate;
	}

	public void setLineManagerValidate(Date lineManagerValidate) {
		this.lineManagerValidate = lineManagerValidate;
	}

	@Column(name = "Workplace", length = 100)
	public String getWorkplace() {
		return this.workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	@Column(name = "Position_Title_Name", length = 50)
	public String getPositionTitleName() {
		return this.positionTitleName;
	}

	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Position_Title_Validate", length = 10)
	public Date getPositionTitleValidate() {
		return this.positionTitleValidate;
	}

	public void setPositionTitleValidate(Date positionTitleValidate) {
		this.positionTitleValidate = positionTitleValidate;
	}

	@Column(name = "Department_Name", length = 50)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Department_Validate", length = 10)
	public Date getDepartmentValidate() {
		return this.departmentValidate;
	}

	public void setDepartmentValidate(Date departmentValidate) {
		this.departmentValidate = departmentValidate;
	}

	@Column(name = "BaseSalary", precision = 22, scale = 0)
	public Double getBaseSalary() {
		return this.baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BaseSalary_Validate", length = 10)
	public Date getBaseSalaryValidate() {
		return this.baseSalaryValidate;
	}

	public void setBaseSalaryValidate(Date baseSalaryValidate) {
		this.baseSalaryValidate = baseSalaryValidate;
	}

	@Column(name = "MBO", precision = 22, scale = 0)
	public Double getMbo() {
		return this.mbo;
	}

	public void setMbo(Double mbo) {
		this.mbo = mbo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MBO_Validate", length = 10)
	public Date getMboValidate() {
		return this.mboValidate;
	}

	public void setMboValidate(Date mboValidate) {
		this.mboValidate = mboValidate;
	}

	@Column(name = "SocialInsurBase", precision = 22, scale = 0)
	public Double getSocialInsurBase() {
		return this.socialInsurBase;
	}

	public void setSocialInsurBase(Double socialInsurBase) {
		this.socialInsurBase = socialInsurBase;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SocialInsur_Validate", length = 10)
	public Date getSocialInsurValidate() {
		return this.socialInsurValidate;
	}

	public void setSocialInsurValidate(Date socialInsurValidate) {
		this.socialInsurValidate = socialInsurValidate;
	}

	@Column(name = "Cost_Center", length = 100)
	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Cost_Center_Validate", length = 10)
	public Date getCostCenterValidate() {
		return this.costCenterValidate;
	}

	public void setCostCenterValidate(Date costCenterValidate) {
		this.costCenterValidate = costCenterValidate;
	}

	@Column(name = "System_Role", length = 50)
	public String getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

	@Column(name = "OnJob")
	public Integer getOnJob() {
		return this.onJob;
	}

	public void setOnJob(Integer onJob) {
		this.onJob = onJob;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Modify_Date", length = 10)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}