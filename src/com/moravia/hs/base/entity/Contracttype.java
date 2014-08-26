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
 * Contracttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "contracttype", catalog = "hr_finance2")
public class Contracttype implements java.io.Serializable {

	// Fields

	private Integer contractTypeId;
	private String contractTypeName;
	private String contractTypeDesc;
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Contracttype() {
	}

	/** minimal constructor */
	public Contracttype(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	/** full constructor */
	public Contracttype(String contractTypeName, String contractTypeDesc,
			Set<Emp> emps) {
		this.contractTypeName = contractTypeName;
		this.contractTypeDesc = contractTypeDesc;
		this.emps = emps;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Contract_Type_ID", unique = true, nullable = false)
	public Integer getContractTypeId() {
		return this.contractTypeId;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	@Column(name = "Contract_Type_Name", nullable = false, length = 50)
	public String getContractTypeName() {
		return this.contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	@Column(name = "Contract_Type_Desc", length = 500)
	public String getContractTypeDesc() {
		return this.contractTypeDesc;
	}

	public void setContractTypeDesc(String contractTypeDesc) {
		this.contractTypeDesc = contractTypeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contracttype")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}