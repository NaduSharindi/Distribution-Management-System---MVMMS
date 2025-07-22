package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_AREA database table.
 * 
 */
@Entity
@Table(name="MMS_AREA")
@NamedQuery(name="MmsArea.findAll", query="SELECT m FROM MmsArea m")
public class MmsArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String area;

	@Column(name="DEPT_ID")
	private String deptId;

	private String province;

	private String status;

	public MmsArea() {
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

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}