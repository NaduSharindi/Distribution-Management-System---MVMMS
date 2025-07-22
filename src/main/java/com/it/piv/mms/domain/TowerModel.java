package com.it.piv.mms.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class TowerModel implements Serializable{
	
	private MmsTowermaintenance objtm;
	private String towerNo;
	private String area;
	private String csc;
	private String lineCode;
	
	public MmsTowermaintenance getObjtm() {
		return objtm;
	}
	public void setObjtm(MmsTowermaintenance objtm) {
		this.objtm = objtm;
	}
	public String getTowerNo() {
		return towerNo;
	}
	public void setTowerNo(String towerNo) {
		this.towerNo = towerNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCsc() {
		return csc;
	}
	public void setCsc(String csc) {
		this.csc = csc;
	}
	public String getLineCode() {
		return lineCode;
	}
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

}
