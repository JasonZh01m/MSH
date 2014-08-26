package com.moravia.hs.base.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 * AbstractTokenOvertime entity provides the base persistence definition of the
 * TokenOvertime entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractTokenOvertime implements java.io.Serializable {

	// Fields

	private Integer tokenId;
	private Overtimerecord overtimerecord;
	private String tokenExecutor;
	private Integer tokenState;

	// Constructors

	/** default constructor */
	public AbstractTokenOvertime() {
	}

	/** full constructor */
	public AbstractTokenOvertime(Overtimerecord overtimerecord,
			String tokenExecutor, Integer tokenState) {
		this.overtimerecord = overtimerecord;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "overtimerecord")
	public Overtimerecord getOvertimerecord() {
		return this.overtimerecord;
	}

	public void setOvertimerecord(Overtimerecord overtimerecord) {
		this.overtimerecord = overtimerecord;
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