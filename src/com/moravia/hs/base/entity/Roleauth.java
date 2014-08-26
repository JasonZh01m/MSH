package com.moravia.hs.base.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Roleauth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roleauth", catalog = "hr_finance2")
public class Roleauth implements java.io.Serializable {

	// Fields

	private Integer raId;
	private Role role;
	private Authority authority;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Roleauth() {
	}

	/** full constructor */
	public Roleauth(Role role, Authority authority, Timestamp createDate) {
		this.role = role;
		this.authority = authority;
		this.createDate = createDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RA_ID", unique = true, nullable = false)
	public Integer getRaId() {
		return this.raId;
	}

	public void setRaId(Integer raId) {
		this.raId = raId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleID")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AuthorityID")
	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}