package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "PCB_Division" database table.
 * 
 */
@Entity
@Table(name="\"PCB_Division\"")
@NamedQuery(name="PCB_Division.findAll", query="SELECT p FROM PCB_Division p")
public class PCB_Division implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	public PCB_Division() {
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

}