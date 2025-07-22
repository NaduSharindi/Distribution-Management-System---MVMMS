package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROVINCE_BRANCH_JOBTYPE database table.
 * 
 */
@Embeddable
public class ProvinceBranchJobtypePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DEPT_ID", insertable=false, updatable=false)
	private String deptId;

	@Column(name="BRANCH_CODE")
	private String branchCode;

	private String jobtypecode;

	public ProvinceBranchJobtypePK() {
	}
	public String getDeptId() {
		return this.deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getBranchCode() {
		return this.branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getJobtypecode() {
		return this.jobtypecode;
	}
	public void setJobtypecode(String jobtypecode) {
		this.jobtypecode = jobtypecode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProvinceBranchJobtypePK)) {
			return false;
		}
		ProvinceBranchJobtypePK castOther = (ProvinceBranchJobtypePK)other;
		return 
			this.deptId.equals(castOther.deptId)
			&& this.branchCode.equals(castOther.branchCode)
			&& this.jobtypecode.equals(castOther.jobtypecode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.deptId.hashCode();
		hash = hash * prime + this.branchCode.hashCode();
		hash = hash * prime + this.jobtypecode.hashCode();
		
		return hash;
	}
}