package com.moravia.hs.base.entity.view;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * LoginviewId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "loginview", catalog = "hr_finance2")
public class Loginview implements java.io.Serializable {

	// Fields

	private Integer empId;
	private String nameEnglish;
	private String empLoginId;
	private Integer systemRole;
	private String sysRoleName;
	// Constructors

//	/** default constructor */
//	public LoginviewId() {
//	}
//
//	/** minimal constructor */
//	public LoginviewId(Integer empId) {
//		this.empId = empId;
//	}
//
//	/** full constructor */
//	public LoginviewId(Integer empId, String password, String empLoginId) {
//		this.empId = empId;
//		this.password = password;
//		this.empLoginId = empLoginId;
//	}
	

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
//	@Column(name = "MBO_ID", unique = true, nullable = false)
	@Column(name = "Emp_ID", nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "Name_English", length = 40)
	public String getNameEnglish() {
		return nameEnglish;
	}
	
	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}
	

	@Column(name = "Emp_LoginID", length = 20)
	public String getEmpLoginId() {
		return this.empLoginId;
	}


	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	@Column(name = "SysRole_Name", length = 50)
	public String getSysRoleName() {
		return this.sysRoleName;
	}

	public void setSysRoleName(String sysRoleName) {
		this.sysRoleName = sysRoleName;
	}

	@Column(name = "System_Role")
	public Integer getSystemRole() {
		return this.systemRole;
	}

	public void setSystemRole(Integer systemRole) {
		this.systemRole = systemRole;
	}
	
}