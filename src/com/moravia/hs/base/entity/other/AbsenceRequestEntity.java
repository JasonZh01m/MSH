package com.moravia.hs.base.entity.other;

public class AbsenceRequestEntity {

	private int id;
	private String lm;
	private String pm;
	private String reason;

	private String types; // types
	private String starts; // start times
	private String ends; // end times

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getStarts() {
		return starts;
	}

	public void setStarts(String starts) {
		this.starts = starts;
	}

	public String getEnds() {
		return ends;
	}

	public void setEnds(String ends) {
		this.ends = ends;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
