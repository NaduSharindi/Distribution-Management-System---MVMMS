package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROVINCE_BRANCH database table.
 * 
 */
@Embeddable
public class ProvinceBranchPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DEPT_ID", insertable=false, updatable=false)
	private String deptId;

	@Column(name="BRANCH_CODE")
	private String branchCode;

	public ProvinceBranchPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProvinceBranchPK)) {
			return false;
		}
		ProvinceBranchPK castOther = (ProvinceBranchPK)other;
		return 
			this.deptId.equals(castOther.deptId)
			&& this.branchCode.equals(castOther.branchCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.deptId.hashCode();
		hash = hash * prime + this.branchCode.hashCode();
		
		return hash;
	}
}