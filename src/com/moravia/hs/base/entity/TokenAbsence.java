package com.moravia.hs.base.entity;

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
 * TokenAbsence entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "token_absence", catalog = "hr_finance2")
public class TokenAbsence implements java.io.Serializable {

	// Fields

	private Integer tokenId;
	private Absencerecord absencerecord;
	private String tokenExecutor;
	private Integer tokenState;

	// Constructors

	/** default constructor */
	public TokenAbsence() {
	}

	/** full constructor */
	public TokenAbsence(Absencerecord absencerecord, String tokenExecutor,
			Integer tokenState) {
		this.absencerecord = absencerecord;
		this.tokenExecutor = tokenExecutor;
		this.tokenState = tokenState;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Token_ID", unique = true, nullable = false)
	public Integer getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AbsenceRequestID")
	public Absencerecord getAbsencerecord() {
		return this.absencerecord;
	}

	public void setAbsencerecord(Absencerecord absencerecord) {
		this.absencerecord = absencerecord;
	}

	@Column(name = "Token_Executor", length = 100)
	public String getTokenExecutor() {
		return this.tokenExecutor;
	}

	public void setTokenExecutor(String tokenExecutor) {
		this.tokenExecutor = tokenExecutor;
	}

	@Column(name = "Token_State")
	public Integer getTokenState() {
		return this.tokenState;
	}

	public void setTokenState(Integer tokenState) {
		this.tokenState = tokenState;
	}

}