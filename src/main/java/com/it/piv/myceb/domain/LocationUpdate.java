package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LOCATION_UPDATE database table.
 * 
 */
@Entity
@Table(name="LOCATION_UPDATE")
@NamedQuery(name="LocationUpdate.findAll", query="SELECT l FROM LocationUpdate l")
public class LocationUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCATION_UPDATE_DEVICEID_GENERATOR", sequenceName="CUSTOMER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATION_UPDATE_DEVICEID_GENERATOR")
	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Column(name="LOCATION_LAT")
	private String locationLat;

	@Column(name="LOCATION_LON")
	private String locationLon;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_TIME")
	private Date updatedTime;

	public LocationUpdate() {
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

}