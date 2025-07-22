package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDCONDUCTORTYPE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDCONDUCTORTYPE")
@NamedQuery(name="MmsAddconductortype.findAll", query="SELECT m FROM MmsAddconductortype m")
public class MmsAddconductortype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String status;

	@Column(name="\"TYPE\"")
	private String type;

	public MmsAddconductortype() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}