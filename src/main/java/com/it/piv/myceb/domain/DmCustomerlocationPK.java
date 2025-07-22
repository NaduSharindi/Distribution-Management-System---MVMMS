package com.it.piv.myceb.domain;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DM_CUSTOMERLOCATION database table.
 * 
 */
@Embeddable
public class DmCustomerlocationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String acctnumber;

	@Column(name="LOCATION_LAT")
	private String locationLat;

	@Column(name="LOCATION_LON")
	private String locationLon;

	public DmCustomerlocationPK() {
	}
	public String getAcctnumber() {
		return this.acctnumber;
	}
	public void setAcctnumber(String acctnumber) {
		this.acctnumber = acctnumber;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DmCustomerlocationPK)) {
			return false;
		}
		DmCustomerlocationPK castOther = (DmCustomerlocationPK)other;
		return 
			this.acctnumber.equals(castOther.acctnumber)
			&& (this.locationLat == castOther.locationLat)
			&& (this.locationLon == castOther.locationLon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.acctnumber.hashCode();
		//hash = hash * prime + ((int) (this.locationLat ^ (this.locationLat >>> 32)));
		//hash = hash * prime + ((int) (this.locationLon ^ (this.locationLon >>> 32)));
		
		return hash;
	}
}