package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_TOWERTYPE database table.
 * 
 */
@Entity
@Table(name="MMS_TOWERTYPE")
@NamedQuery(name="MmsTowertype.findAll", query="SELECT m FROM MmsTowertype m")
public class MmsTowertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String name;

	public MmsTowertype() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}