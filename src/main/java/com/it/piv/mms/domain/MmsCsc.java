package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_CSC database table.
 * 
 */
@Entity
@Table(name="MMS_CSC")
@NamedQuery(name="MmsCsc.findAll", query="SELECT m FROM MmsCsc m")
public class MmsCsc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String area;

	private String csc;

	@Column(name="DEPT_ID")
	private String deptId;

	private String status;

	public MmsCsc() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}