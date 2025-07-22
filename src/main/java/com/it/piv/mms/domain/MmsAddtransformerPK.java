package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_ADDTRANSFORMER database table.
 * 
 */
@Embeddable
public class MmsAddtransformerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TR_ID")
	private String trId;

	@Column(name="GANTRY_ID")
	private long gantryId;

	public MmsAddtransformerPK() {
	}
	public String getTrId() {
		return this.trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
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
		if (!(other instanceof MmsAddtransformerPK)) {
			return false;
		}
		MmsAddtransformerPK castOther = (MmsAddtransformerPK)other;
		return 
			this.trId.equals(castOther.trId)
			&& (this.gantryId == castOther.gantryId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.trId.hashCode();
		hash = hash * prime + ((int) (this.gantryId ^ (this.gantryId >>> 32)));
		
		return hash;
	}
}