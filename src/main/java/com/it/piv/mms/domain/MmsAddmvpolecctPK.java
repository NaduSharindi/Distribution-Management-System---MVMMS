package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The primary key class for the MMS_ADDMVPOLECCT database table.
 * 
 */
@Embeddable
public class MmsAddmvpolecctPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	@Column(name="POLE_ID")
	private long poleId;

	public MmsAddmvpolecctPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getPoleId() {
		return this.poleId;
	}
	public void setPoleId(long poleId) {
		this.poleId = poleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsAddmvpolecctPK)) {
			return false;
		}
		MmsAddmvpolecctPK castOther = (MmsAddmvpolecctPK)other;
		return 
			this.id.equals(castOther.id)
			&& (this.poleId == castOther.poleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + ((int) (this.poleId ^ (this.poleId >>> 32)));
		
		return hash;
	}
	}