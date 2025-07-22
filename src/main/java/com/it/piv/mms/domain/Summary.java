package com.it.piv.mms.domain;

import java.io.Serializable;


public class Summary implements Serializable {
	
	public Summary(){
		
	}
	private static final long serialVersionUID = 1L;
	
	private String area;
	private String areaName;
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	private int count;
	private double length;
	private double nooftowers;
	private double noofpoles;
	
	private double nofflashoversets;
	public double getNofflashoversets() {
		return nofflashoversets;
	}

	public void setNofflashoversets(double nofflashoversets) {
		this.nofflashoversets = nofflashoversets;
	}
	private double fungussetno;
	public double getFungussetno() {
		return fungussetno;
	}

	public void setFungussetno(double fungussetno) {
		this.fungussetno = fungussetno;
	}
	private double wpinset;
	public double getWpinset() {
		return wpinset;
	}

	public void setWpinset(double wpinset) {
		this.wpinset = wpinset;
	}
	private double endfittingset;
	
	

	
	public double getEndfittingset() {
		return endfittingset;
	}

	public void setEndfittingset(double endfittingset) {
		this.endfittingset = endfittingset;
	}

	public double getNooftowers() {
		return nooftowers;
	}

	public void setNooftowers(double nooftowers) {
		this.nooftowers = nooftowers;
	}
	public double getNoofpoles() {
		return noofpoles;
	}

	public void setNoofpoles(double noofpoles) {
		this.noofpoles = noofpoles;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Summary [area=" + area + ", areaName=" + areaName + ", count="
				+ count + ", length=" + length + ", nooftowers=" + nooftowers
				+ ", noofpoles=" + noofpoles + ", nofflashoversets="
				+ nofflashoversets + ", fungussetno=" + fungussetno
				+ ", wpinset=" + wpinset + ", endfittingset=" + endfittingset
				+ "]";
	}

}
