package com.it.piv.mms.domain;

import java.io.Serializable;


public class InsEstimate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String area;
	private String areaName;
	private int count;
	private double length;
	private double nooftowers;
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	
	public double getNooftowers() {
		return nooftowers;
	}

	public void setNooftowers(double nooftowers) {
		this.nooftowers = nooftowers;
	}

	private double noofpoles;
	

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
				+ ", noofpoles=" + noofpoles + "]";
	}

}
