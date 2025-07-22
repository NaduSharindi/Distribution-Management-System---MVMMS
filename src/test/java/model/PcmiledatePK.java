package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PCMILEDATES database table.
 * 
 */
@Embeddable
public class PcmiledatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MILE_ID")
	private String mileId;

	@Column(name="PROJECT_NO")
	private String projectNo;

	@Column(name="DEPT_ID")
	private String deptId;

	@Temporal(TemporalType.DATE)
	@Column(name="ENTER_DATE")
	private java.util.Date enterDate;

	public PcmiledatePK() {
	}
	public String getMileId() {
		return this.mileId;
	}
	public void setMileId(String mileId) {
		this.mileId = mileId;
	}
	public String getProjectNo() {
		return this.projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getDeptId() {
		return this.deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public java.util.Date getEnterDate() {
		return this.enterDate;
	}
	public void setEnterDate(java.util.Date enterDate) {
		this.enterDate = enterDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PcmiledatePK)) {
			return false;
		}
		PcmiledatePK castOther = (PcmiledatePK)other;
		return 
			this.mileId.equals(castOther.mileId)
			&& this.projectNo.equals(castOther.projectNo)
			&& this.deptId.equals(castOther.deptId)
			&& this.enterDate.equals(castOther.enterDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mileId.hashCode();
		hash = hash * prime + this.projectNo.hashCode();
		hash = hash * prime + this.deptId.hashCode();
		hash = hash * prime + this.enterDate.hashCode();
		
		return hash;
	}
}