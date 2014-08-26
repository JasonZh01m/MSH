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
 * Overtimerequestitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "overtimerequestitem", catalog = "hr_finance2")
public class Overtimerequestitem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Overtimerecord overtimerecord;
	private String emploginid;
	private Double hours;
	private Timestamp starttime;
	private Timestamp endtime;
	private String costcenter;
	private Integer otherPaidRate;
	private Double paidRate;
	private Integer withCompensatory;
	private Double compensatoryHours;

	// Constructors

	/** default constructor */
	public Overtimerequestitem() {
	}

	/** full constructor */
	/*public Overtimerequestitem(Overtimerecord overtimerecord,
			String emploginid, Double hours, Timestamp starttime,
			Timestamp endtime, String costcenter, Double paidRate,
			Integer withCompensatory, Double compensatoryHours) {
		this.overtimerecord = overtimerecord;
		this.emploginid = emploginid;
		this.hours = hours;
		this.starttime = starttime;
		this.endtime = endtime;
		this.costcenter = costcenter;
		this.paidRate = paidRate;
		this.withCompensatory = withCompensatory;
		this.compensatoryHours = compensatoryHours;
	}*/

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
	@JoinColumn(name = "overtimeRecord")
	public Overtimerecord getOvertimerecord() {
		return this.overtimerecord;
	}

	public void setOvertimerecord(Overtimerecord overtimerecord) {
		this.overtimerecord = overtimerecord;
	}

	@Column(name = "emploginid", length = 50)
	public String getEmploginid() {
		return this.emploginid;
	}

	public void setEmploginid(String emploginid) {
		this.emploginid = emploginid;
	}

	@Column(name = "hours", precision = 22, scale = 0)
	public Double getHours() {
		return this.hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	@Column(name = "starttime", length = 19)
	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime", length = 19)
	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	@Column(name = "costcenter")
	public String getCostcenter() {
		return this.costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	@Column(name = "paidRate", precision = 22, scale = 0)
	public Double getPaidRate() {
		return this.paidRate;
	}

	public void setPaidRate(Double paidRate) {
		this.paidRate = paidRate;
	}

	@Column(name = "otherpaidrate")
	public Integer getOtherPaidRate() {
		return otherPaidRate;
	}

	public void setOtherPaidRate(Integer otherPaidRate) {
		this.otherPaidRate = otherPaidRate;
	}

	@Column(name = "withCompensatory")
	public Integer getWithCompensatory() {
		return this.withCompensatory;
	}

	public void setWithCompensatory(Integer withCompensatory) {
		this.withCompensatory = withCompensatory;
	}

	@Column(name = "compensatoryHours", precision = 22, scale = 0)
	public Double getCompensatoryHours() {
		return this.compensatoryHours;
	}

	public void setCompensatoryHours(Double compensatoryHours) {
		this.compensatoryHours = compensatoryHours;
	}

}