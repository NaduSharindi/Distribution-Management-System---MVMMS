package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_ADDLVFEEDER database table.
 * 
 */
@Embeddable
public class MmsAddlvfeederPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FEEDER_ID")
	private String feederId;

	@Column(name="SUB_ID")
	private String subId;

	public MmsAddlvfeederPK() {
	}
	public String getFeederId() {
		return this.feederId;
	}
	public void setFeederId(String feederId) {
		this.feederId = feederId;
	}
	public String getSubId() {
		return this.subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsAddlvfeederPK)) {
			return false;
		}
		MmsAddlvfeederPK castOther = (MmsAddlvfeederPK)other;
		return 
			this.feederId.equals(castOther.feederId)
			&& (this.subId == castOther.subId);
	}

	/*public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.feederId.hashCode();
		hash = hash * prime + ((int) (this.subId ^ (this.subId >>> 32)));
		
		return hash;
	}*/
}