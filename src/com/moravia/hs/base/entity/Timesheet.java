package com.moravia.hs.base.entity;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Timesheet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "timesheet", catalog = "hr_finance2")
public class Timesheet implements java.io.Serializable {

	// Fields

	private Integer tsId;
	private String loginName;
	private Date date;
	private Time start;
	private Time stop;
	private Double diffTime;
	private Integer orderId;
	private String projectName;
	private String pmName;
	private String language;
	private String type;
	private String activityGroup;
	private String invoicingIndicator;
	private String role;
	private String position;
	private String tool;
	private String task;
	private String custom;
	private String note;
	private String tsLock;

	// Constructors

	/** default constructor */
	public Timesheet() {
	}

	/** full constructor */
	public Timesheet(String loginName, Date date, Time start, Time stop,
			Double diffTime, Integer orderId, String projectName,
			String pmName, String language, String type, String activityGroup,
			String invoicingIndicator, String role, String position,
			String tool, String task, String custom, String note, String tsLock) {
		this.loginName = loginName;
		this.date = date;
		this.start = start;
		this.stop = stop;
		this.diffTime = diffTime;
		this.orderId = orderId;
		this.projectName = projectName;
		this.pmName = pmName;
		this.language = language;
		this.type = type;
		this.activityGroup = activityGroup;
		this.invoicingIndicator = invoicingIndicator;
		this.role = role;
		this.position = position;
		this.tool = tool;
		this.task = task;
		this.custom = custom;
		this.note = note;
		this.tsLock = tsLock;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ts_ID", unique = true, nullable = false)
	public Integer getTsId() {
		return this.tsId;
	}

	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}

	@Column(name = "LoginName", length = 50)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "Start", length = 8)
	public Time getStart() {
		return this.start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	@Column(name = "Stop", length = 8)
	public Time getStop() {
		return this.stop;
	}

	public void setStop(Time stop) {
		this.stop = stop;
	}

	@Column(name = "DiffTime", precision = 22, scale = 0)
	public Double getDiffTime() {
		return this.diffTime;
	}

	public void setDiffTime(Double diffTime) {
		this.diffTime = diffTime;
	}

	@Column(name = "OrderID")
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "Project_Name", length = 100)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "PM_Name", length = 50)
	public String getPmName() {
		return this.pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}

	@Column(name = "Language", length = 20)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "Type", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "Activity_Group", length = 50)
	public String getActivityGroup() {
		return this.activityGroup;
	}

	public void setActivityGroup(String activityGroup) {
		this.activityGroup = activityGroup;
	}

	@Column(name = "Invoicing_Indicator", length = 50)
	public String getInvoicingIndicator() {
		return this.invoicingIndicator;
	}

	public void setInvoicingIndicator(String invoicingIndicator) {
		this.invoicingIndicator = invoicingIndicator;
	}

	@Column(name = "Role", length = 100)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "Position", length = 100)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "Tool", length = 100)
	public String getTool() {
		return this.tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	@Column(name = "Task", length = 300)
	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Column(name = "Custom", length = 100)
	public String getCustom() {
		return this.custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	@Column(name = "Note", length = 500)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "ts_lock", length = 10)
	public String getTsLock() {
		return this.tsLock;
	}

	public void setTsLock(String tsLock) {
		this.tsLock = tsLock;
	}

}