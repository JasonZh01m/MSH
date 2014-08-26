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
 * Requeststate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "requeststate", catalog = "hr_finance2")
public class Requeststate implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateName;
	private String stateDesc;
//	private Set<Absencerequestlog> absencerequestlogs = new HashSet<Absencerequestlog>(
//			0);
//	private Set<Absencerecord> absencerecords = new HashSet<Absencerecord>(0);

	// Constructors

	/** default constructor */
	public Requeststate() {
		
	}

	/** full constructor */
//	public Requeststate(String stateName, String stateDesc,
//			Set<Absencerequestlog> absencerequestlogs,
//			Set<Absencerecord> absencerecords) {
//		this.stateName = stateName;
//		this.stateDesc = stateDesc;
//		this.absencerequestlogs = absencerequestlogs;
//		this.absencerecords = absencerecords;
//	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "State_ID", unique = true, nullable = false)
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "State_Name", length = 50)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "State_Desc")
	public String getStateDesc() {
		return this.stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "requeststate")
//	public Set<Absencerequestlog> getAbsencerequestlogs() {
//		return this.absencerequestlogs;
//	}
//
//	public void setAbsencerequestlogs(Set<Absencerequestlog> absencerequestlogs) {
//		this.absencerequestlogs = absencerequestlogs;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "requeststate")
//	public Set<Absencerecord> getAbsencerecords() {
//		return this.absencerecords;
//	}
//
//	public void setAbsencerecords(Set<Absencerecord> absencerecords) {
//		this.absencerecords = absencerecords;
//	}

}