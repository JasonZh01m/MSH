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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Costcenter entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "costcenter", catalog = "hr_finance2")
public class Costcenter implements java.io.Serializable {

	// Fields

	private Integer costCenterId;
	private String costCenterName;
	private String costCenterParent;
	private String costCenterOwner;
	private String costCenterDesc;
	private Timestamp createDate;
//	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Costcenter() {
	}

	/** minimal constructor */
	public Costcenter(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	/** full constructor */
	/*public Costcenter(String costCenterName, String costCenterParent,
			String costCenterOwner, String costCenterDesc,
			Timestamp createDate) {
		this.costCenterName = costCenterName;
		this.costCenterParent = costCenterParent;
		this.costCenterOwner = costCenterOwner;
		this.costCenterDesc = costCenterDesc;
		this.createDate = createDate;
	}*/

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Cost_Center_ID", unique = true, nullable = false)
	public Integer getCostCenterId() {
		return this.costCenterId;
	}

	public void setCostCenterId(Integer costCenterId) {
		this.costCenterId = costCenterId;
	}

	@Column(name = "Cost_Center_Name", nullable = false, length = 50)
	public String getCostCenterName() {
		return this.costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	@Column(name = "Cost_Center_Parent", length = 50)
	public String getCostCenterParent() {
		return this.costCenterParent;
	}

	public void setCostCenterParent(String costCenterParent) {
		this.costCenterParent = costCenterParent;
	}

	@Column(name = "Cost_Center_Owner", length = 50)
	public String getCostCenterOwner() {
		return this.costCenterOwner;
	}

	public void setCostCenterOwner(String costCenterOwner) {
		this.costCenterOwner = costCenterOwner;
	}

	@Column(name = "Cost_Center_Desc", length = 500)
	public String getCostCenterDesc() {
		return this.costCenterDesc;
	}

	public void setCostCenterDesc(String costCenterDesc) {
		this.costCenterDesc = costCenterDesc;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "costcenter")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}*/

}