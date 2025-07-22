package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_GANTRYLOC database table.
 * 
 */
@Embeddable
public class MmsGantrylocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GANTRY_ID")
	private long gantryId;

	@Column(name="POINT_ID")
	private long pointId;

	public MmsGantrylocPK() {
	}
	public long getGantryId() {
		return this.gantryId;
	}
	public void setGantryId(long gantryId) {
		this.gantryId = gantryId;
	}
	public long getPointId() {
		return this.pointId;
	}
	public void setPointId(long pointId) {
		this.pointId = pointId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsGantrylocPK)) {
			return false;
		}
		MmsGantrylocPK castOther = (MmsGantrylocPK)other;
		return 
			(this.gantryId == castOther.gantryId)
			&& (this.pointId == castOther.pointId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.gantryId ^ (this.gantryId >>> 32)));
		hash = hash * prime + ((int) (this.pointId ^ (this.pointId >>> 32)));
		
		return hash;
	}
}