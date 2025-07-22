package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ESTIMATE_REFERENCEBS database table.
 * 
 */
@Embeddable
public class EstimateReferencebPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SESTIMATE_NO")
	private String sestimateNo;

	@Column(name="WESTIMATE_NO")
	private String westimateNo;

	@Column(name="DEPT_ID")
	private String deptId;

	public EstimateReferencebPK() {
	}
	public String getSestimateNo() {
		return this.sestimateNo;
	}
	public void setSestimateNo(String sestimateNo) {
		this.sestimateNo = sestimateNo;
	}
	public String getWestimateNo() {
		return this.westimateNo;
	}
	public void setWestimateNo(String westimateNo) {
		this.westimateNo = westimateNo;
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
		if (!(other instanceof EstimateReferencebPK)) {
			return false;
		}
		EstimateReferencebPK castOther = (EstimateReferencebPK)other;
		return 
			this.sestimateNo.equals(castOther.sestimateNo)
			&& this.westimateNo.equals(castOther.westimateNo)
			&& this.deptId.equals(castOther.deptId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sestimateNo.hashCode();
		hash = hash * prime + this.westimateNo.hashCode();
		hash = hash * prime + this.deptId.hashCode();
		
		return hash;
	}
}