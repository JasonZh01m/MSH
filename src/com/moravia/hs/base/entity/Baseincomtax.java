package com.moravia.hs.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Baseincomtax entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "baseincomtax", catalog = "hr_finance2")
public class Baseincomtax implements java.io.Serializable {

	// Fields

	private Integer incomtaxId;
	private Double incomtaxValue;
	private Double incomtaxRate;
	private String incomtaxDesc;

	// Constructors

	/** default constructor */
	public Baseincomtax() {
	}

	/** full constructor */
	public Baseincomtax(Double incomtaxValue, Double incomtaxRate,
			String incomtaxDesc) {
		this.incomtaxValue = incomtaxValue;
		this.incomtaxRate = incomtaxRate;
		this.incomtaxDesc = incomtaxDesc;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Incomtax_id", unique = true, nullable = false)
	public Integer getIncomtaxId() {
		return this.incomtaxId;
	}

	public void setIncomtaxId(Integer incomtaxId) {
		this.incomtaxId = incomtaxId;
	}

	@Column(name = "Incomtax_value", precision = 22, scale = 0)
	public Double getIncomtaxValue() {
		return this.incomtaxValue;
	}

	public void setIncomtaxValue(Double incomtaxValue) {
		this.incomtaxValue = incomtaxValue;
	}

	@Column(name = "Incomtax_Rate", precision = 22, scale = 0)
	public Double getIncomtaxRate() {
		return this.incomtaxRate;
	}

	public void setIncomtaxRate(Double incomtaxRate) {
		this.incomtaxRate = incomtaxRate;
	}

	@Column(name = "Incomtax_desc")
	public String getIncomtaxDesc() {
		return this.incomtaxDesc;
	}

	public void setIncomtaxDesc(String incomtaxDesc) {
		this.incomtaxDesc = incomtaxDesc;
	}

}