package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MVMMS_CYCLE database table.
 * 
 */
@Embeddable
public class MvmmsCyclePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CYCLE_ID")
	private String cycleId;

	@Column(name="DEPT_ID")
	private String deptId;

	public MvmmsCyclePK() {
	}
	public String getCycleId() {
		return this.cycleId;
	}
	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
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
		if (!(other instanceof MvmmsCyclePK)) {
			return false;
		}
		MvmmsCyclePK castOther = (MvmmsCyclePK)other;
		return 
			this.cycleId.equals(castOther.cycleId)
			&& this.deptId.equals(castOther.deptId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cycleId.hashCode();
		hash = hash * prime + this.deptId.hashCode();
		
		return hash;
	}
}