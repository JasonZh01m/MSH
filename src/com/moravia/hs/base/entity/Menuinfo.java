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
 * Menuinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menuinfo", catalog = "hr_finance2")
public class Menuinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menuName;
	private String link;
	private String desc;
	private Set<Rolemenu> rolemenus = new HashSet<Rolemenu>(0);

	// Constructors

	/** default constructor */
	public Menuinfo() {
	}

	/** full constructor */
	public Menuinfo(String menuName, String link, String desc,
			Set<Rolemenu> rolemenus) {
		this.menuName = menuName;
		this.link = link;
		this.desc = desc;
		this.rolemenus = rolemenus;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "MenuName")
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "Link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "Desc")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menuinfo")
	public Set<Rolemenu> getRolemenus() {
		return this.rolemenus;
	}

	public void setRolemenus(Set<Rolemenu> rolemenus) {
		this.rolemenus = rolemenus;
	}

}