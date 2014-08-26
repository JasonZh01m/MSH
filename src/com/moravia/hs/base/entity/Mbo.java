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
 * Mbo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mbo", catalog = "hr_finance2")
public class Mbo implements java.io.Serializable {

	// Fields

	private Integer mboId;
	private Double mboRate;
	private Integer mboPaidPeriod;
	private String mboDesc;
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Mbo() {
	}

	/** minimal constructor */
	public Mbo(Double mboRate) {
		this.mboRate = mboRate;
	}

	/** full constructor */
	public Mbo(Double mboRate, Integer mboPaidPeriod, String mboDesc,
			Set<Emp> emps) {
		this.mboRate = mboRate;
		this.mboPaidPeriod = mboPaidPeriod;
		this.mboDesc = mboDesc;
		this.emps = emps;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MBO_ID", unique = true, nullable = false)
	public Integer getMboId() {
		return this.mboId;
	}

	public void setMboId(Integer mboId) {
		this.mboId = mboId;
	}

	@Column(name = "MBO_Rate", nullable = false, precision = 22, scale = 0)
	public Double getMboRate() {
		return this.mboRate;
	}

	public void setMboRate(Double mboRate) {
		this.mboRate = mboRate;
	}

	@Column(name = "MBO_PaidPeriod")
	public Integer getMboPaidPeriod() {
		return this.mboPaidPeriod;
	}

	public void setMboPaidPeriod(Integer mboPaidPeriod) {
		this.mboPaidPeriod = mboPaidPeriod;
	}

	@Column(name = "MBO_Desc", length = 500)
	public String getMboDesc() {
		return this.mboDesc;
	}

	public void setMboDesc(String mboDesc) {
		this.mboDesc = mboDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mbo")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}