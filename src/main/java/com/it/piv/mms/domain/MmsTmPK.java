package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_TM database table.
 * 
 */
@Embeddable
public class MmsTmPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TOWER_ID")
	private String towerId;

	@Column(name="VISIT_ID")
	private long visitId;

	public MmsTmPK() {
	}
	public String getTowerId() {
		return this.towerId;
	}
	public void setTowerId(String towerId) {
		this.towerId = towerId;
	}
	public long getVisitId() {
		return this.visitId;
	}
	public void setVisitId(long visitId) {
		this.visitId = visitId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsTmPK)) {
			return false;
		}
		MmsTmPK castOther = (MmsTmPK)other;
		return 
			this.towerId.equals(castOther.towerId)
			&& (this.visitId == castOther.visitId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.towerId.hashCode();
		hash = hash * prime + ((int) (this.visitId ^ (this.visitId >>> 32)));
		
		return hash;
	}
}