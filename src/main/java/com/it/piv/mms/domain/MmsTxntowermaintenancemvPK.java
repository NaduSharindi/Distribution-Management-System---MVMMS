package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_TXNTOWERMAINTENANCEMV database table.
 * 
 */
@Embeddable
public class MmsTxntowermaintenancemvPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long visitid;

	private long poleid;

	public MmsTxntowermaintenancemvPK() {
	}
	public long getVisitid() {
		return this.visitid;
	}
	public void setVisitid(long visitid) {
		this.visitid = visitid;
	}
	public long getPoleid() {
		return this.poleid;
	}
	public void setPoleid(long poleid) {
		this.poleid = poleid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsTxntowermaintenancemvPK)) {
			return false;
		}
		MmsTxntowermaintenancemvPK castOther = (MmsTxntowermaintenancemvPK)other;
		return 
			(this.visitid == castOther.visitid)
			&& (this.poleid == castOther.poleid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.visitid ^ (this.visitid >>> 32)));
		hash = hash * prime + ((int) (this.poleid ^ (this.poleid >>> 32)));
		
		return hash;
	}
}