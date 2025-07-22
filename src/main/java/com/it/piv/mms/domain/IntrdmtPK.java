package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INTRDMT database table.
 * 
 */
@Embeddable
public class IntrdmtPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DOC_NO")
	private String docNo;

	@Column(name="DOC_PF")
	private String docPf;

	@Column(name="DEPT_ID")
	private String deptId;

	@Column(name="MAT_CD")
	private String matCd;

	@Column(name="GRADE_CD")
	private String gradeCd;

	public IntrdmtPK() {
	}
	public String getDocNo() {
		return this.docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getDocPf() {
		return this.docPf;
	}
	public void setDocPf(String docPf) {
		this.docPf = docPf;
	}
	public String getDeptId() {
		return this.deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getMatCd() {
		return this.matCd;
	}
	public void setMatCd(String matCd) {
		this.matCd = matCd;
	}
	public String getGradeCd() {
		return this.gradeCd;
	}
	public void setGradeCd(String gradeCd) {
		this.gradeCd = gradeCd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IntrdmtPK)) {
			return false;
		}
		IntrdmtPK castOther = (IntrdmtPK)other;
		return 
			this.docNo.equals(castOther.docNo)
			&& this.docPf.equals(castOther.docPf)
			&& this.deptId.equals(castOther.deptId)
			&& this.matCd.equals(castOther.matCd)
			&& this.gradeCd.equals(castOther.gradeCd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.docNo.hashCode();
		hash = hash * prime + this.docPf.hashCode();
		hash = hash * prime + this.deptId.hashCode();
		hash = hash * prime + this.matCd.hashCode();
		hash = hash * prime + this.gradeCd.hashCode();
		
		return hash;
	}
}