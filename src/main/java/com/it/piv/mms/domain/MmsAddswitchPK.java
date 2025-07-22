package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_ADDSWITCHES database table.
 * 
 */
@Embeddable
public class MmsAddswitchPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FEEDER_ID")
	private String feederId;

	@Column(name="GANTRY_ID")
	private long gantryId;

	@Column(name="SWITCH_ID")
	private String switchId;

	public MmsAddswitchPK() {
	}
	public String getFeederId() {
		return this.feederId;
	}
	public void setFeederId(String feederId) {
		this.feederId = feederId;
	}
	public long getGantryId() {
		return this.gantryId;
	}
	public void setGantryId(long gantryId) {
		this.gantryId = gantryId;
	}
	public String getSwitchId() {
		return this.switchId;
	}
	public void setSwitchId(String switchId) {
		this.switchId = switchId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsAddswitchPK)) {
			return false;
		}
		MmsAddswitchPK castOther = (MmsAddswitchPK)other;
		return 
			this.feederId.equals(castOther.feederId)
			&& (this.gantryId == castOther.gantryId)
			&& this.switchId.equals(castOther.switchId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.feederId.hashCode();
		hash = hash * prime + ((int) (this.gantryId ^ (this.gantryId >>> 32)));
		hash = hash * prime + this.switchId.hashCode();
		
		return hash;
	}
}