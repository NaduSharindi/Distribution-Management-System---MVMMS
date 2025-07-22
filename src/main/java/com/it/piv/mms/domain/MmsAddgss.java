package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMS_ADDGSS database table.
 * 
 */
@Entity
@Table(name="MMS_ADDGSS")
@NamedQuery(name="MmsAddgss.findAll", query="SELECT m FROM MmsAddgss m")
public class MmsAddgss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String area;

	private String code;

	private String csc;

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;

	private String name;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	private String province;

	private BigDecimal status;

	public MmsAddgss() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public BigDecimal getGpsLatitude() {
		return this.gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public BigDecimal getGpsLongitude() {
		return this.gpsLongitude;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}