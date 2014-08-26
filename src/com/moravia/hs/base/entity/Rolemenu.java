package com.moravia.hs.base.entity;

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
 * Rolemenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rolemenu", catalog = "hr_finance2")
public class Rolemenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Menuinfo menuinfo;

	// Constructors

	/** default constructor */
	public Rolemenu() {
	}

	/** full constructor */
	public Rolemenu(Role role, Menuinfo menuinfo) {
		this.role = role;
		this.menuinfo = menuinfo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleId")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MenuId")
	public Menuinfo getMenuinfo() {
		return this.menuinfo;
	}

	public void setMenuinfo(Menuinfo menuinfo) {
		this.menuinfo = menuinfo;
	}

}