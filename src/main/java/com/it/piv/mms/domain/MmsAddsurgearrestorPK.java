package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_ADDSURGEARRESTOR database table.
 * 
 */
@Embeddable
public class MmsAddsurgearrestorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SA_ID")
	private String saId;

	@Column(name="GANTRY_ID")
	private long gantryId;

	public MmsAddsurgearrestorPK() {
	}
	public String getSaId() {
		return this.saId;
	}
	public void setSaId(String saId) {
		this.saId = saId;
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
		if (!(other instanceof MmsAddsurgearrestorPK)) {
			return false;
		}
		MmsAddsurgearrestorPK castOther = (MmsAddsurgearrestorPK)other;
		return 
			this.saId.equals(castOther.saId)
			&& (this.gantryId == castOther.gantryId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.saId.hashCode();
		hash = hash * prime + ((int) (this.gantryId ^ (this.gantryId >>> 32)));
		
		return hash;
	}
}