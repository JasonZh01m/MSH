package com.moravia.hs.base.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Absencerecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "absencerecord", catalog = "hr_finance2")
public class Absencerecord implements java.io.Serializable {

	// Fields

	private Integer absenceRecordId;
	private Requeststate requeststate;
	private String empLoginId;
	private String absenceReason;
	private Double absenceTotalHours;
	private String absenceApproverPm;
	private String absenceApproverLineManager;
	private String absenceNoteLineManager;
	private Timestamp createDate;
	private Set<TokenAbsence> tokenAbsences = new HashSet<TokenAbsence>(0);
	private Set<Absencerequestitem> absencerequestitems = new HashSet<Absencerequestitem>(
			0);
	private Set<Vacationchangerecord> vacationchangerecords = new HashSet<Vacationchangerecord>(
			0);
	private Set<Absencerequestlog> absencerequestlogs = new HashSet<Absencerequestlog>(
			0);

	// Constructors

	/** default constructor */
	public Absencerecord() {
	}

	/** full constructor */
	public Absencerecord(Requeststate requeststate, String empLoginId,
			String absenceReason, Double absenceTotalHours,
			String absenceApproverPm, String absenceApproverLineManager,
			String absenceNoteLineManager, Timestamp createDate,
			Set<TokenAbsence> tokenAbsences,
			Set<Absencerequestitem> absencerequestitems,
			Set<Vacationchangerecord> vacationchangerecords,
			Set<Absencerequestlog> absencerequestlogs) {
		this.requeststate = requeststate;
		this.empLoginId = empLoginId;
		this.absenceReason = absenceReason;
		this.absenceTotalHours = absenceTotalHours;
		this.absenceApproverPm = absenceApproverPm;
		this.absenceApproverLineManager = absenceApproverLineManager;
		this.absenceNoteLineManager = absenceNoteLineManager;
		this.createDate = createDate;
		this.tokenAbsences = tokenAbsences;
		this.absencerequestitems = absencerequestitems;
		this.vacationchangerecords = vacationchangerecords;
		this.absencerequestlogs = absencerequestlogs;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Absence_Record_ID", unique = true, nullable = false)
	public Integer getAbsenceRecordId() {
		return this.absenceRecordId;
	}

	public void setAbsenceRecordId(Integer absenceRecordId) {
		this.absenceRecordId = absenceRecordId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RequestState")
	public Requeststate getRequeststate() {
		return this.requeststate;
	}

	public void setRequeststate(Requeststate requeststate) {
		this.requeststate = requeststate;
	}

	@Column(name = "Emp_LoginID", length = 50)
	public String getEmpLoginId() {
		return this.empLoginId;
	}

	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}

	@Column(name = "Absence_Reason", length = 500)
	public String getAbsenceReason() {
		return this.absenceReason;
	}

	public void setAbsenceReason(String absenceReason) {
		this.absenceReason = absenceReason;
	}

	@Column(name = "Absence_TotalHours", precision = 22, scale = 0)
	public Double getAbsenceTotalHours() {
		return this.absenceTotalHours;
	}

	public void setAbsenceTotalHours(Double absenceTotalHours) {
		this.absenceTotalHours = absenceTotalHours;
	}

	@Column(name = "Absence_Approver_PM", length = 50)
	public String getAbsenceApproverPm() {
		return this.absenceApproverPm;
	}

	public void setAbsenceApproverPm(String absenceApproverPm) {
		this.absenceApproverPm = absenceApproverPm;
	}

	@Column(name = "Absence_Approver_LineManager", length = 50)
	public String getAbsenceApproverLineManager() {
		return this.absenceApproverLineManager;
	}

	public void setAbsenceApproverLineManager(String absenceApproverLineManager) {
		this.absenceApproverLineManager = absenceApproverLineManager;
	}

	@Column(name = "Absence_Note_LineManager", length = 500)
	public String getAbsenceNoteLineManager() {
		return this.absenceNoteLineManager;
	}

	public void setAbsenceNoteLineManager(String absenceNoteLineManager) {
		this.absenceNoteLineManager = absenceNoteLineManager;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "absencerecord")
	public Set<TokenAbsence> getTokenAbsences() {
		return this.tokenAbsences;
	}

	public void setTokenAbsences(Set<TokenAbsence> tokenAbsences) {
		this.tokenAbsences = tokenAbsences;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "absencerecord")
	public Set<Absencerequestitem> getAbsencerequestitems() {
		return this.absencerequestitems;
	}

	public void setAbsencerequestitems(
			Set<Absencerequestitem> absencerequestitems) {
		this.absencerequestitems = absencerequestitems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "absencerecord")
	public Set<Vacationchangerecord> getVacationchangerecords() {
		return this.vacationchangerecords;
	}

	public void setVacationchangerecords(
			Set<Vacationchangerecord> vacationchangerecords) {
		this.vacationchangerecords = vacationchangerecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "absencerecord")
	public Set<Absencerequestlog> getAbsencerequestlogs() {
		return this.absencerequestlogs;
	}

	public void setAbsencerequestlogs(Set<Absencerequestlog> absencerequestlogs) {
		this.absencerequestlogs = absencerequestlogs;
	}

}