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
 * Authority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "authority", catalog = "hr_finance2")
public class Authority implements java.io.Serializable {

	// Fields
	private Integer authorityId;
	private String authorityName;
	private String authorityDesc;
	private Timestamp createDate;
	private Set<Roleauth> roleauths = new HashSet<Roleauth>(0);

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** minimal constructor */
	public Authority(String authorityName) {
		this.authorityName = authorityName;
	}

	/** full constructor */
	public Authority(String authorityName, String authorityDesc,
			Timestamp createDate, Set<Roleauth> roleauths) {
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
		this.createDate = createDate;
		this.roleauths = roleauths;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Authority_ID", unique = true, nullable = false)
	public Integer getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	@Column(name = "Authority_Name", nullable = false, length = 50)
	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Column(name = "Authority_Desc", length = 500)
	public String getAuthorityDesc() {
		return this.authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authority")
	public Set<Roleauth> getRoleauths() {
		return this.roleauths;
	}

	public void setRoleauths(Set<Roleauth> roleauths) {
		this.roleauths = roleauths;
	}

}