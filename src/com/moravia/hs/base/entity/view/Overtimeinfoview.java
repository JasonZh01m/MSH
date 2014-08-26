package com.moravia.hs.base.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Overtimeinfoview entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "overtimeinfoview", catalog = "hr_finance2")
public class Overtimeinfoview implements java.io.Serializable {

	// Fields

	private Integer id;
	private String gm;
	private String pm;
	private Timestamp createdate;
	private String projectcode;
	private String projectname;
	private String applicant;
	private String stateName;
	private String emploginid;
	private Double hours;
	private Timestamp starttime;
	private Timestamp endtime;
	private String costcenter;
	private Integer otherpaidrate;
	private Double paidRate;
	private Integer withCompensatory;
	private Double compensatoryHours;

	// Constructors

	/** default constructor */
	public Overtimeinfoview() {
	}

	/** full constructor */
	public Overtimeinfoview(String gm, String pm, Timestamp createdate,
			String projectcode, String projectname, String applicant,
			String stateName, String emploginid, Double hours,
			Timestamp starttime, Timestamp endtime, String costcenter,
			Integer otherpaidrate, Double paidRate, Integer withCompensatory,
			Double compensatoryHours) {
		this.gm = gm;
		this.pm = pm;
		this.createdate = createdate;
		this.projectcode = projectcode;
		this.projectname = projectname;
		this.applicant = applicant;
		this.stateName = stateName;
		this.emploginid = emploginid;
		this.hours = hours;
		this.starttime = starttime;
		this.endtime = endtime;
		this.costcenter = costcenter;
		this.otherpaidrate = otherpaidrate;
		this.paidRate = paidRate;
		this.withCompensatory = withCompensatory;
		this.compensatoryHours = compensatoryHours;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "gm", length = 50)
	public String getGm() {
		return this.gm;
	}

	public void setGm(String gm) {
		this.gm = gm;
	}

	@Column(name = "pm", length = 50)
	public String getPm() {
		return this.pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	@Column(name = "createdate", length = 19)
	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
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

	@Column(name = "applicant", length = 50)
	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	@Column(name = "State_Name", length = 50)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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

	@Column(name = "otherpaidrate")
	public Integer getOtherpaidrate() {
		return this.otherpaidrate;
	}

	public void setOtherpaidrate(Integer otherpaidrate) {
		this.otherpaidrate = otherpaidrate;
	}

	@Column(name = "paidRate", precision = 22, scale = 0)
	public Double getPaidRate() {
		return this.paidRate;
	}

	public void setPaidRate(Double paidRate) {
		this.paidRate = paidRate;
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