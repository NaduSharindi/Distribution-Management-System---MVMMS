package com.it.piv.issue.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PCMILESUMARY database table.
 * 
 */
@Embeddable
public class PcmilesumaryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DEPT_ID")
	private String deptId;

	@Column(name="PROJECT_NO")
	private String projectNo;

	@Column(name="MILE_ID")
	private String mileId;

	public PcmilesumaryPK() {
	}
	public String getDeptId() {
		return this.deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getProjectNo() {
		return this.projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getMileId() {
		return this.mileId;
	}
	public void setMileId(String mileId) {
		this.mileId = mileId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PcmilesumaryPK)) {
			return false;
		}
		PcmilesumaryPK castOther = (PcmilesumaryPK)other;
		return 
			this.deptId.equals(castOther.deptId)
			&& this.projectNo.equals(castOther.projectNo)
			&& this.mileId.equals(castOther.mileId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.deptId.hashCode();
		hash = hash * prime + this.projectNo.hashCode();
		hash = hash * prime + this.mileId.hashCode();
		
		return hash;
	}
}