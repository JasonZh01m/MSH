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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Positiontitle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "positiontitle", catalog = "hr_finance2")
public class Positiontitle implements java.io.Serializable {

	// Fields

	private Integer positionTitleId;
	private String positionTitleName;
	private String positionTitleDesc;
	private Timestamp createDate;
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Positiontitle() {
	}

	/** minimal constructor */
	public Positiontitle(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}

	/** full constructor */
	public Positiontitle(String positionTitleName, String positionTitleDesc,
			Timestamp createDate, Set<Emp> emps) {
		this.positionTitleName = positionTitleName;
		this.positionTitleDesc = positionTitleDesc;
		this.createDate = createDate;
		this.emps = emps;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Position_Title_ID", unique = true, nullable = false)
	public Integer getPositionTitleId() {
		return this.positionTitleId;
	}

	public void setPositionTitleId(Integer positionTitleId) {
		this.positionTitleId = positionTitleId;
	}

	@Column(name = "Position_Title_Name", nullable = false, length = 50)
	public String getPositionTitleName() {
		return this.positionTitleName;
	}

	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}

	@Column(name = "Position_Title_Desc", length = 500)
	public String getPositionTitleDesc() {
		return this.positionTitleDesc;
	}

	public void setPositionTitleDesc(String positionTitleDesc) {
		this.positionTitleDesc = positionTitleDesc;
	}

	@Column(name = "Create_Date", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "positiontitle")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}