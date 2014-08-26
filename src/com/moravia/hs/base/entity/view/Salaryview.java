package com.moravia.hs.base.entity.view;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SalaryviewId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "salaryview", catalog = "hr_finance2")
public class Salaryview implements java.io.Serializable {

	// Fields

	private Integer empId;
	private String empLoginId;
	private Double baseSalary;
	private Integer mbo;
	private Double socialInsurBase;
	private Integer costCenter;
	private Long creditCardNumber;

	// Constructors

	/** default constructor */
	public Salaryview() {
	}

//	/** minimal constructor */
//	public SalaryviewId(Integer empId, String empLoginId) {
//		this.empId = empId;
//		this.empLoginId = empLoginId;
//	}
//
//	/** full constructor */
//	public SalaryviewId(Integer empId, String empLoginId, Double baseSalary,
//			Integer mbo, Double socialInsurBase, Integer costCenter,
//			Long creditCardNumber) {
//		this.empId = empId;
//		this.empLoginId = empLoginId;
//		this.baseSalary = baseSalary;
//		this.mbo = mbo;
//		this.socialInsurBase = socialInsurBase;
//		this.costCenter = costCenter;
//		this.creditCardNumber = creditCardNumber;
//	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Emp_ID", nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "Emp_LoginID", nullable = false, length = 20)
	public String getEmpLoginId() {
		return this.empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	@Column(name = "BaseSalary", precision = 22, scale = 0)
	public Double getBaseSalary() {
		return this.baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Column(name = "MBO")
	public Integer getMbo() {
		return this.mbo;
	}

	public void setMbo(Integer mbo) {
		this.mbo = mbo;
	}

	@Column(name = "SocialInsurBase", precision = 22, scale = 0)
	public Double getSocialInsurBase() {
		return this.socialInsurBase;
	}

	public void setSocialInsurBase(Double socialInsurBase) {
		this.socialInsurBase = socialInsurBase;
	}

	@Column(name = "Cost_Center")
	public Integer getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	@Column(name = "Credit_Card_Number")
	public Long getCreditCardNumber() {
		return this.creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}