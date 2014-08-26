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
 * Emptype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emptype", catalog = "hr_finance2")
public class Emptype implements java.io.Serializable {

	// Fields

	private Integer empTypeId;
	private String empTypeName;
	private String empTypeDesc;
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Emptype() {
	}

	/** minimal constructor */
	public Emptype(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	/** full constructor */
	public Emptype(String empTypeName, String empTypeDesc, Set<Emp> emps) {
		this.empTypeName = empTypeName;
		this.empTypeDesc = empTypeDesc;
		this.emps = emps;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Emp_Type_ID", unique = true, nullable = false)
	public Integer getEmpTypeId() {
		return this.empTypeId;
	}

	public void setEmpTypeId(Integer empTypeId) {
		this.empTypeId = empTypeId;
	}

	@Column(name = "Emp_Type_Name", nullable = false, length = 50)
	public String getEmpTypeName() {
		return this.empTypeName;
	}

	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	@Column(name = "Emp_Type_Desc", length = 500)
	public String getEmpTypeDesc() {
		return this.empTypeDesc;
	}

	public void setEmpTypeDesc(String empTypeDesc) {
		this.empTypeDesc = empTypeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emptype")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}