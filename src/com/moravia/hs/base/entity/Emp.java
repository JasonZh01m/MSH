package com.moravia.hs.base.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emp", catalog = "hr_finance2", uniqueConstraints = @UniqueConstraint(columnNames = "Emp_LoginID"))
public class Emp implements java.io.Serializable {

	// Fields

	private Integer empId;
	private Contracttype contracttype;
	private Mbo mbo;
	private Emp emp;
	private Department department;
	private Costcenter costcenter;
	private Positiontitle positiontitle;
	private Role role;
	private Emptype emptype;
	private String empLoginId;
	private String nameChinese;
	private String nameEnglish;
	private String gender;
	private Date birthday;
	private String address;
	private String mobile;
	private String officePhone;
	private String skype;
	private Date contractStartDate;
	private Date contractEndDate;
	private Integer withProbation;
	private Date porbationStartDate;
	private Date porbationEndDate;
	private Date leaveDate;
	private Date entryDate;
	private String email;
	private Date lineManagerValidate;
	private Integer workingAge;
	private String workplace;
	private Date positionTitleValidate;
	private Date departmentValidate;
	private Double baseSalary;
	private Date baseSalaryValidate;
	private Date mboValidate;
	private Double socialInsurBase;
	private Date socialInsurBaseValidate;
	private Date costCenterValidate;
	private Long creditCardNumber;
	private Double annualLeaveLeft;
	private Integer onJob;
	private Timestamp createDate;
	private String identityCard;
	private Set<Vacationchangerecord> vacationchangerecords = new HashSet<Vacationchangerecord>(
			0);
	private Set<Empchangerecord> empchangerecords = new HashSet<Empchangerecord>(
			0);
	private Set<Department> departments = new HashSet<Department>(0);
//	private Set<Compensatoryleaveinfo> compensatoryleaveinfos = new HashSet<Compensatoryleaveinfo>(
//			0);
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(String empLoginId, String nameEnglish) {
		this.empLoginId = empLoginId;
		this.nameEnglish = nameEnglish;
	}

	/** full constructor */
	/*public Emp(Contracttype contracttype, Mbo mbo, Emp emp,
			Department department, Costcenter costcenter,
			Positiontitle positiontitle, Role role, Emptype emptype,
			String empLoginId, String nameChinese, String nameEnglish,
			String gender, Date birthday, String address, String mobile,
			String officePhone, String skype, Date contractStartDate,
			Date contractEndDate, Integer withProbation,
			Date porbationStartDate, Date porbationEndDate, Date leaveDate,
			Date entryDate, String email, Date lineManagerValidate,
			Integer workingAge, String workplace, Date positionTitleValidate,
			Date departmentValidate, Double baseSalary,
			Date baseSalaryValidate, Date mboValidate, Double socialInsurBase,
			Date socialInsurBaseValidate, Date costCenterValidate,
			Long creditCardNumber, Double annualLeaveLeft, Integer onJob,
			Timestamp createDate, String identityCard,
			Set<Vacationchangerecord> vacationchangerecords,
			Set<Empchangerecord> empchangerecords, Set<Department> departments,
			Set<Compensatoryleaveinfo> compensatoryleaveinfos, Set<Emp> emps) {
		this.contracttype = contracttype;
		this.mbo = mbo;
		this.emp = emp;
		this.department = department;
		this.costcenter = costcenter;
		this.positiontitle = positiontitle;
		this.role = role;
		this.emptype = emptype;
		this.empLoginId = empLoginId;
		this.nameChinese = nameChinese;
		this.nameEnglish = nameEnglish;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.mobile = mobile;
		this.officePhone = officePhone;
		this.skype = skype;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.withProbation = withProbation;
		this.porbationStartDate = porbationStartDate;
		this.porbationEndDate = porbationEndDate;
		this.leaveDate = leaveDate;
		this.entryDate = entryDate;
		this.email = email;
		this.lineManagerValidate = lineManagerValidate;
		this.workingAge = workingAge;
		this.workplace = workplace;
		this.positionTitleValidate = positionTitleValidate;
		this.departmentValidate = departmentValidate;
		this.baseSalary = baseSalary;
		this.baseSalaryValidate = baseSalaryValidate;
		this.mboValidate = mboValidate;
		this.socialInsurBase = socialInsurBase;
		this.socialInsurBaseValidate = socialInsurBaseValidate;
		this.costCenterValidate = costCenterValidate;
		this.creditCardNumber = creditCardNumber;
		this.annualLeaveLeft = annualLeaveLeft;
		this.onJob = onJob;
		this.createDate = createDate;
		this.identityCard = identityCard;
		this.vacationchangerecords = vacationchangerecords;
		this.empchangerecords = empchangerecords;
		this.departments = departments;
		this.compensatoryleaveinfos = compensatoryleaveinfos;
		this.emps = emps;
	}*/

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Emp_ID", unique = true, nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Contract_Type")
	public Contracttype getContracttype() {
		return this.contracttype;
	}

	public void setContracttype(Contracttype contracttype) {
		this.contracttype = contracttype;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MBO")
	public Mbo getMbo() {
		return this.mbo;
	}

	public void setMbo(Mbo mbo) {
		this.mbo = mbo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Line_Manager")
	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Department")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Cost_Center")
	public Costcenter getCostcenter() {
		return this.costcenter;
	}

	public void setCostcenter(Costcenter costcenter) {
		this.costcenter = costcenter;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Position_Title")
	public Positiontitle getPositiontitle() {
		return this.positiontitle;
	}

	public void setPositiontitle(Positiontitle positiontitle) {
		this.positiontitle = positiontitle;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "System_Role")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Emp_Type")
	public Emptype getEmptype() {
		return this.emptype;
	}

	public void setEmptype(Emptype emptype) {
		this.emptype = emptype;
	}

	@Column(name = "Emp_LoginID", unique = true, nullable = false, length = 20)
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

	@Column(name = "Name_English", nullable = false, length = 20)
	public String getNameEnglish() {
		return this.nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	@Column(name = "Gender", length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "Address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Mobile", length = 50)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "Office_Phone", length = 50)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "Skype", length = 50)
	public String getSkype() {
		return this.skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Contract_StartDate", length = 10)
	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Contract_EndDate", length = 10)
	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	@Column(name = "With_Probation")
	public Integer getWithProbation() {
		return this.withProbation;
	}

	public void setWithProbation(Integer withProbation) {
		this.withProbation = withProbation;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Porbation_StartDate", length = 10)
	public Date getPorbationStartDate() {
		return this.porbationStartDate;
	}

	public void setPorbationStartDate(Date porbationStartDate) {
		this.porbationStartDate = porbationStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Porbation_EndDate", length = 10)
	public Date getPorbationEndDate() {
		return this.porbationEndDate;
	}

	public void setPorbationEndDate(Date porbationEndDate) {
		this.porbationEndDate = porbationEndDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Leave_Date", length = 10)
	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Entry_Date", length = 10)
	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "Email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Line_Manager_Validate", length = 10)
	public Date getLineManagerValidate() {
		return this.lineManagerValidate;
	}

	public void setLineManagerValidate(Date lineManagerValidate) {
		this.lineManagerValidate = lineManagerValidate;
	}

	@Column(name = "Working_Age")
	public Integer getWorkingAge() {
		return this.workingAge;
	}

	public void setWorkingAge(Integer workingAge) {
		this.workingAge = workingAge;
	}

	@Column(name = "Workplace", length = 50)
	public String getWorkplace() {
		return this.workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Position_Title_Validate", length = 10)
	public Date getPositionTitleValidate() {
		return this.positionTitleValidate;
	}

	public void setPositionTitleValidate(Date positionTitleValidate) {
		this.positionTitleValidate = positionTitleValidate;
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
	@Column(name = "SocialInsurBase_Validate", length = 10)
	public Date getSocialInsurBaseValidate() {
		return this.socialInsurBaseValidate;
	}

	public void setSocialInsurBaseValidate(Date socialInsurBaseValidate) {
		this.socialInsurBaseValidate = socialInsurBaseValidate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Cost_Center_Validate", length = 10)
	public Date getCostCenterValidate() {
		return this.costCenterValidate;
	}

	public void setCostCenterValidate(Date costCenterValidate) {
		this.costCenterValidate = costCenterValidate;
	}

	@Column(name = "Credit_Card_Number")
	public Long getCreditCardNumber() {
		return this.creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Column(name = "Annual_Leave_Left", precision = 22, scale = 0)
	public Double getAnnualLeaveLeft() {
		return this.annualLeaveLeft;
	}

	public void setAnnualLeaveLeft(Double annualLeaveLeft) {
		this.annualLeaveLeft = annualLeaveLeft;
	}

	@Column(name = "OnJob")
	public Integer getOnJob() {
		return this.onJob;
	}

	public void setOnJob(Integer onJob) {
		this.onJob = onJob;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "Identity_Card", length = 25)
	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
	public Set<Vacationchangerecord> getVacationchangerecords() {
		return this.vacationchangerecords;
	}

	public void setVacationchangerecords(
			Set<Vacationchangerecord> vacationchangerecords) {
		this.vacationchangerecords = vacationchangerecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
	public Set<Empchangerecord> getEmpchangerecords() {
		return this.empchangerecords;
	}

	public void setEmpchangerecords(Set<Empchangerecord> empchangerecords) {
		this.empchangerecords = empchangerecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
//	public Set<Compensatoryleaveinfo> getCompensatoryleaveinfos() {
//		return this.compensatoryleaveinfos;
//	}
//
//	public void setCompensatoryleaveinfos(
//			Set<Compensatoryleaveinfo> compensatoryleaveinfos) {
//		this.compensatoryleaveinfos = compensatoryleaveinfos;
//	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}