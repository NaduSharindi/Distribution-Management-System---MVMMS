package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MSTTOWERTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Msttowertype.findAll", query="SELECT m FROM Msttowertype m")
public class Msttowertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String id;

	public Msttowertype() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}