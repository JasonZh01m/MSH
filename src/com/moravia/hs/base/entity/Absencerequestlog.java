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
 * Absencerequestlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "absencerequestlog", catalog = "hr_finance2")
public class Absencerequestlog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Requeststate requeststate;
	private Absencerecord absencerecord;
	private String logDesc;
	private Timestamp changeDate;
	private String changePeople;

	// Constructors

	/** default constructor */
	public Absencerequestlog() {
	}

	/** full constructor */
	public Absencerequestlog(Requeststate requeststate,
			Absencerecord absencerecord, String logDesc, Timestamp changeDate,
			String changePeople) {
		this.requeststate = requeststate;
		this.absencerecord = absencerecord;
		this.logDesc = logDesc;
		this.changeDate = changeDate;
		this.changePeople = changePeople;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Log_ID", unique = true, nullable = false)
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RequestState")
	public Requeststate getRequeststate() {
		return this.requeststate;
	}

	public void setRequeststate(Requeststate requeststate) {
		this.requeststate = requeststate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AbsenceRecord")
	public Absencerecord getAbsencerecord() {
		return this.absencerecord;
	}

	public void setAbsencerecord(Absencerecord absencerecord) {
		this.absencerecord = absencerecord;
	}

	@Column(name = "Log_Desc")
	public String getLogDesc() {
		return this.logDesc;
	}

	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}

	@Column(name = "ChangeDate", length = 19)
	public Timestamp getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "ChangePeople", length = 50)
	public String getChangePeople() {
		return this.changePeople;
	}

	public void setChangePeople(String changePeople) {
		this.changePeople = changePeople;
	}

}