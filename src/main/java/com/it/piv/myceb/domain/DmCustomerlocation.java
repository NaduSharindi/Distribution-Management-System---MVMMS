package com.it.piv.myceb.domain;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DM_CUSTOMERLOCATION database table.
 * 
 */
@Entity
@Table(name="DM_CUSTOMERLOCATION")
@NamedQuery(name="DmCustomerlocation.findAll", query="SELECT d FROM DmCustomerlocation d")
public class DmCustomerlocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DmCustomerlocationPK id;

	public DmCustomerlocation() {
	}

	public DmCustomerlocationPK getId() {
		return this.id;
	}

	public void setId(DmCustomerlocationPK id) {
		this.id = id;
	}

}