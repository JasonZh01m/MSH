package com.moravia.hs.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Basesocialinsurance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "basesocialinsurance", catalog = "hr_finance2")
public class Basesocialinsurance implements java.io.Serializable {

	// Fields

	private Integer bsiId;
	private String bsiName;
	private Double bsiRate;
	private Double bsiAdditional;
	private String bsiDesc;

	// Constructors

	/** default constructor */
	public Basesocialinsurance() {
	}

	/** full constructor */
	public Basesocialinsurance(String bsiName, Double bsiRate,
			Double bsiAdditional, String bsiDesc) {
		this.bsiName = bsiName;
		this.bsiRate = bsiRate;
		this.bsiAdditional = bsiAdditional;
		this.bsiDesc = bsiDesc;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "bsi_id", unique = true, nullable = false)
	public Integer getBsiId() {
		return this.bsiId;
	}

	public void setBsiId(Integer bsiId) {
		this.bsiId = bsiId;
	}

	@Column(name = "bsi_name", length = 50)
	public String getBsiName() {
		return this.bsiName;
	}

	public void setBsiName(String bsiName) {
		this.bsiName = bsiName;
	}

	@Column(name = "bsi_Rate", precision = 22, scale = 0)
	public Double getBsiRate() {
		return this.bsiRate;
	}

	public void setBsiRate(Double bsiRate) {
		this.bsiRate = bsiRate;
	}

	@Column(name = "bsi_Additional", precision = 22, scale = 0)
	public Double getBsiAdditional() {
		return this.bsiAdditional;
	}

	public void setBsiAdditional(Double bsiAdditional) {
		this.bsiAdditional = bsiAdditional;
	}

	@Column(name = "bsi_desc")
	public String getBsiDesc() {
		return this.bsiDesc;
	}

	public void setBsiDesc(String bsiDesc) {
		this.bsiDesc = bsiDesc;
	}

}