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
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "hr_finance2")
public class Role implements java.io.Serializable {

	// Fields

	private Integer sysRoleId;
	private String sysRoleName;
	private String sysRoleDesc;
	private Timestamp createDate;
	private Set<Emp> emps = new HashSet<Emp>(0);
	private Set<Roleauth> roleauths = new HashSet<Roleauth>(0);
	private Set<Rolemenu> rolemenus = new HashSet<Rolemenu>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String sysRoleName, String sysRoleDesc, Timestamp createDate,
			Set<Emp> emps, Set<Roleauth> roleauths, Set<Rolemenu> rolemenus) {
		this.sysRoleName = sysRoleName;
		this.sysRoleDesc = sysRoleDesc;
		this.createDate = createDate;
		this.emps = emps;
		this.roleauths = roleauths;
		this.rolemenus = rolemenus;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SysRole_ID", unique = true, nullable = false)
	public Integer getSysRoleId() {
		return this.sysRoleId;
	}

	public void setSysRoleId(Integer sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	@Column(name = "SysRole_Name", length = 50)
	public String getSysRoleName() {
		return this.sysRoleName;
	}

	public void setSysRoleName(String sysRoleName) {
		this.sysRoleName = sysRoleName;
	}

	@Column(name = "SysRole_Desc", length = 500)
	public String getSysRoleDesc() {
		return this.sysRoleDesc;
	}

	public void setSysRoleDesc(String sysRoleDesc) {
		this.sysRoleDesc = sysRoleDesc;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Roleauth> getRoleauths() {
		return this.roleauths;
	}

	public void setRoleauths(Set<Roleauth> roleauths) {
		this.roleauths = roleauths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
	public Set<Rolemenu> getRolemenus() {
		return this.rolemenus;
	}

	public void setRolemenus(Set<Rolemenu> rolemenus) {
		this.rolemenus = rolemenus;
	}

}