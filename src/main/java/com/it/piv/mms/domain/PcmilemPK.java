package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PCMILEM database table.
 * 
 */
@Embeddable
public class PcmilemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MILE_ID")
	private String mileId;

	@Column(name="DEPT_ID")
	private String deptId;

	public PcmilemPK() {
	}
	public String getMileId() {
		return this.mileId;
	}
	public void setMileId(String mileId) {
		this.mileId = mileId;
	}
	public String getDeptId() {
		return this.deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PcmilemPK)) {
			return false;
		}
		PcmilemPK castOther = (PcmilemPK)other;
		return 
			this.mileId.equals(castOther.mileId)
			&& this.deptId.equals(castOther.deptId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mileId.hashCode();
		hash = hash * prime + this.deptId.hashCode();
		
		return hash;
	}
}