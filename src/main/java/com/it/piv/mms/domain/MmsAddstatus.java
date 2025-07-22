package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDSTATUS database table.
 * 
 */
@Entity
@Table(name="MMS_ADDSTATUS")
@NamedQuery(name="MmsAddstatus.findAll", query="SELECT m FROM MmsAddstatus m")
public class MmsAddstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private String status;

	@Column(name="\"TYPE\"")
	private String type;

	public MmsAddstatus() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}