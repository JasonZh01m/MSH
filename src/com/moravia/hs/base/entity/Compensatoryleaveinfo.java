package com.moravia.hs.base.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Compensatoryleaveinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "compensatoryleaveinfo", catalog = "hr_finance2")
public class Compensatoryleaveinfo implements java.io.Serializable {

	// Fields

	private Integer compensatoryLeaveId;
	private Emp emp;
	private Double compensatoryLeaveLeft;
	private Date lastUsedDate;
	private Date expirationDate;
	private String compensatoryLeaveDesc;
	private Date createDate;

	// Constructors

	/** default constructor */
	public Compensatoryleaveinfo() {
	}

	/** full constructor */
	public Compensatoryleaveinfo(Emp emp, Double compensatoryLeaveLeft,
			Date lastUsedDate, Date expirationDate,
			String compensatoryLeaveDesc, Date createDate) {
		this.emp = emp;
		this.compensatoryLeaveLeft = compensatoryLeaveLeft;
		this.lastUsedDate = lastUsedDate;
		this.expirationDate = expirationDate;
		this.compensatoryLeaveDesc = compensatoryLeaveDesc;
		this.createDate = createDate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Compensatory_Leave_ID", unique = true, nullable = false)
	public Integer getCompensatoryLeaveId() {
		return this.compensatoryLeaveId;
	}

	public void setCompensatoryLeaveId(Integer compensatoryLeaveId) {
		this.compensatoryLeaveId = compensatoryLeaveId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Emp_ID")
	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Column(name = "Compensatory_Leave_Left", precision = 22, scale = 0)
	public Double getCompensatoryLeaveLeft() {
		return this.compensatoryLeaveLeft;
	}

	public void setCompensatoryLeaveLeft(Double compensatoryLeaveLeft) {
		this.compensatoryLeaveLeft = compensatoryLeaveLeft;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Last_Used_Date", length = 10)
	public Date getLastUsedDate() {
		return this.lastUsedDate;
	}

	public void setLastUsedDate(Date lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Expiration_Date", length = 10)
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "Compensatory_Leave_Desc", length = 200)
	public String getCompensatoryLeaveDesc() {
		return this.compensatoryLeaveDesc;
	}

	public void setCompensatoryLeaveDesc(String compensatoryLeaveDesc) {
		this.compensatoryLeaveDesc = compensatoryLeaveDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Create_Date", length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}