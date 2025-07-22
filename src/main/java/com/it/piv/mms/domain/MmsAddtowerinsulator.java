package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDTOWERINSULATOR database table.
 * 
 */
@Entity
@Table(name="MMS_ADDTOWERINSULATOR")
@NamedQuery(name="MmsAddtowerinsulator.findAll", query="SELECT m FROM MmsAddtowerinsulator m")
public class MmsAddtowerinsulator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private String status;

	public MmsAddtowerinsulator() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}