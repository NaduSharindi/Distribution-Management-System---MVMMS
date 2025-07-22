package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_ADDGSSFEEDER database table.
 * 
 */
@Embeddable
public class MmsAddgssfeederPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long id;

	@Column(name="GSS_ID")
	private long gssId;

	public MmsAddgssfeederPK() {
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGssId() {
		return this.gssId;
	}
	public void setGssId(long gssId) {
		this.gssId = gssId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsAddgssfeederPK)) {
			return false;
		}
		MmsAddgssfeederPK castOther = (MmsAddgssfeederPK)other;
		return 
			(this.id == castOther.id)
			&& (this.gssId == castOther.gssId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + ((int) (this.gssId ^ (this.gssId >>> 32)));
		
		return hash;
	}
}