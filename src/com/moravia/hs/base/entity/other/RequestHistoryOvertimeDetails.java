package com.moravia.hs.base.entity.other;

import java.util.List;

public class RequestHistoryOvertimeDetails {
	
	private int id;
	private String pcode;
	private String pmnote;
	private String gmnote;
	
	private List<String[]> list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPmnote() {
		return pmnote;
	}

	public void setPmnote(String pmnote) {
		this.pmnote = pmnote;
	}

	public String getGmnote() {
		return gmnote;
	}

	public void setGmnote(String gmnote) {
		this.gmnote = gmnote;
	}

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}
	
}
