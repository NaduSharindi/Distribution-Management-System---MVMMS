package com.it.piv.mms.domain;
import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDPPOLETYPE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDPOLETYPE")
@NamedQuery(name="MmsAddpoletype.findAll", query="SELECT m FROM MmsAddpoletype m")
public class MmsAddpoletype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="POLE_TYPE")
	private String poleType;

	private String status;

	public MmsAddpoletype() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPoleType() {
		return this.poleType;
	}

	public void setPoleType(String poleType) {
		this.poleType = poleType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
