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
 * Overtimerequestlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "overtimerequestlog", catalog = "hr_finance2")
public class Overtimerequestlog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Requeststate requeststate;
	private Overtimerecord overtimerecord;
	private String logDesc;
	private Timestamp changeDate;
	private String changePeople;

	// Constructors

	/** default constructor */
	public Overtimerequestlog() {
	}

	/** full constructor */
	public Overtimerequestlog(Requeststate requeststate,
			Overtimerecord overtimerecord, String logDesc,
			Timestamp changeDate, String changePeople) {
		this.requeststate = requeststate;
		this.overtimerecord = overtimerecord;
		this.logDesc = logDesc;
		this.changeDate = changeDate;
		this.changePeople = changePeople;
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
	@JoinColumn(name = "requestState")
	public Requeststate getRequeststate() {
		return this.requeststate;
	}

	public void setRequeststate(Requeststate requeststate) {
		this.requeststate = requeststate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "overtimeRecord")
	public Overtimerecord getOvertimerecord() {
		return this.overtimerecord;
	}

	public void setOvertimerecord(Overtimerecord overtimerecord) {
		this.overtimerecord = overtimerecord;
	}

	@Column(name = "logDesc")
	public String getLogDesc() {
		return this.logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}

	@Column(name = "changeDate", length = 19)
	public Timestamp getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "changePeople", length = 50)
	public String getChangePeople() {
		return this.changePeople;
	}

	public void setChangePeople(String changePeople) {
		this.changePeople = changePeople;
	}

}