package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_ADDFEEDER database table.
 * 
 */
@Embeddable
public class MmsAddfeederPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FEEDER_ID")
	private String feederId;

	@Column(name="GANTRY_ID")
	private long gantryId;

	public MmsAddfeederPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsAddfeederPK)) {
			return false;
		}
		MmsAddfeederPK castOther = (MmsAddfeederPK)other;
		return 
			(this.feederId == castOther.feederId)
			&& (this.gantryId == castOther.gantryId);
	}

	/*public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.feederId ^ (this.feederId >>> 32)));
		hash = hash * prime + ((int) (this.gantryId ^ (this.gantryId >>> 32)));
		
		return hash;
	}*/
}