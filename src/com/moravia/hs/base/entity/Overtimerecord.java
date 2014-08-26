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
 * Overtimerecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "overtimerecord", catalog = "hr_finance2")
public class Overtimerecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Requeststate requeststate;
	private String applicant;
	private String projectcode;
	private String projectname;
	private String comments;
	private Double totalhours;
	private String gm;
	private String gmnote;
	private String pm;
	private String pmnote;
	private Timestamp createdate;
	private Set<TokenOvertime> tokenOvertimes = new HashSet<TokenOvertime>(0);
	private Set<Overtimerequestlog> overtimerequestlogs = new HashSet<Overtimerequestlog>(
			0);
	private Set<Overtimerequestitem> overtimerequestitems = new HashSet<Overtimerequestitem>(
			0);

	// Constructors

	/** default constructor */
	public Overtimerecord() {
	}

	/** full constructor */
	/*public Overtimerecord(Requeststate requeststate, String applicant,
			String projectcode, String projectname, String comments,
			Double totalhours, String gm, String gmnote, String pm,
			String pmnote, Timestamp createdate,
			Set<TokenOvertime> tokenOvertimes,
			Set<Overtimerequestlog> overtimerequestlogs,
			Set<Overtimerequestitem> overtimerequestitems) {
		this.requeststate = requeststate;
		this.applicant = applicant;
		this.projectcode = projectcode;
		this.projectname = projectname;
		this.comments = comments;
		this.totalhours = totalhours;
		this.gm = gm;
		this.gmnote = gmnote;
		this.pm = pm;
		this.pmnote = pmnote;
		this.createdate = createdate;
		this.tokenOvertimes = tokenOvertimes;
		this.overtimerequestlogs = overtimerequestlogs;
		this.overtimerequestitems = overtimerequestitems;
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
	@JoinColumn(name = "requeststate")
	public Requeststate getRequeststate() {
		return this.requeststate;
	}

	public void setRequeststate(Requeststate requeststate) {
		this.requeststate = requeststate;
	}

	@Column(name = "applicant", length = 50)
	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	@Column(name = "projectcode", length = 50)
	public String getProjectcode() {
		return this.projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	@Column(name = "projectname")
	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	@Column(name = "comments")
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "totalhours", precision = 22, scale = 0)
	public Double getTotalhours() {
		return this.totalhours;
	}

	public void setTotalhours(Double totalhours) {
		this.totalhours = totalhours;
	}

	@Column(name = "gm", length = 50)
	public String getGm() {
		return this.gm;
	}

	public void setGm(String gm) {
		this.gm = gm;
	}

	@Column(name = "gmnote")
	public String getGmnote() {
		return this.gmnote;
	}

	public void setGmnote(String gmnote) {
		this.gmnote = gmnote;
	}

	@Column(name = "pm", length = 50)
	public String getPm() {
		return this.pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	@Column(name = "pmnote")
	public String getPmnote() {
		return this.pmnote;
	}

	public void setPmnote(String pmnote) {
		this.pmnote = pmnote;
	}

	@Column(name = "createdate", length = 19)
	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "overtimerecord")
	public Set<TokenOvertime> getTokenOvertimes() {
		return this.tokenOvertimes;
	}

	public void setTokenOvertimes(Set<TokenOvertime> tokenOvertimes) {
		this.tokenOvertimes = tokenOvertimes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "overtimerecord")
	public Set<Overtimerequestlog> getOvertimerequestlogs() {
		return this.overtimerequestlogs;
	}

	public void setOvertimerequestlogs(
			Set<Overtimerequestlog> overtimerequestlogs) {
		this.overtimerequestlogs = overtimerequestlogs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "overtimerecord")
	public Set<Overtimerequestitem> getOvertimerequestitems() {
		return this.overtimerequestitems;
	}

	public void setOvertimerequestitems(
			Set<Overtimerequestitem> overtimerequestitems) {
		this.overtimerequestitems = overtimerequestitems;
	}

}