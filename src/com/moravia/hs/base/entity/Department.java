package com.moravia.hs.base.entity;

import java.sql.Timestamp;
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
import org.hibernate.annotations.GenericGenerator;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "department", catalog = "hr_finance2")
public class Department implements java.io.Serializable {

	// Fields

	private Integer departId;
	private Emp emp;
	private String departName;
	private String departDesc;
	private Timestamp createDate;
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String departName) {
		this.departName = departName;
	}

	/** full constructor */
	public Department(Emp emp, String departName, String departDesc,
			Timestamp createDate, Set<Emp> emps) {
		this.emp = emp;
		this.departName = departName;
		this.departDesc = departDesc;
		this.createDate = createDate;
		this.emps = emps;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Depart_ID", unique = true, nullable = false)
	public Integer getDepartId() {
		return this.departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Depart_Manager")
	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Column(name = "Depart_Name", nullable = false, length = 50)
	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	@Column(name = "Depart_Desc", length = 500)
	public String getDepartDesc() {
		return this.departDesc;
	}

	public void setDepartDesc(String departDesc) {
		this.departDesc = departDesc;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}