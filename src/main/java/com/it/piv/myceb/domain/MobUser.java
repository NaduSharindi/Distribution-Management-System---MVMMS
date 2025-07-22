package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MOB_USERS database table.
 * 
 */
@Entity
@Table(name="MOB_USERS")
@NamedQuery(name="MobUser.findAll", query="SELECT m FROM MobUser m")
public class MobUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCESS_CODE")
	private String accessCode;

	@Column(name="CC_CODE")
	private String ccCode;

	@Column(name="CREW_NAME")
	private String crewName;

	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="IS_ACTIVE")
	private BigDecimal isActive;

	@Column(name="LOCATION_LAT")
	private String locationLat;

	@Column(name="LOCATION_LON")
	private String locationLon;

	private String password;

	@Column(name="UNIT_CODE")
	private String unitCode;

	public MobUser() {
	}

	public String getAccessCode() {
		return this.accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getCcCode() {
		return this.ccCode;
	}

	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}

	public String getCrewName() {
		return this.crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public BigDecimal getIsActive() {
		return this.isActive;
	}

	public void setIsActive(BigDecimal isActive) {
		this.isActive = isActive;
	}

	public String getLocationLat() {
		return this.locationLat;
	}

	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}

	public String getLocationLon() {
		return this.locationLon;
	}

	public void setLocationLon(String locationLon) {
		this.locationLon = locationLon;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

}