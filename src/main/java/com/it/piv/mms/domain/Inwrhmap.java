package com.it.piv.mms.domain;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INWRHMAP database table.
 * 
 */
@Entity
@NamedQuery(name="Inwrhmap.findAll", query="SELECT i FROM Inwrhmap i")
public class Inwrhmap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InwrhmapPK id;

	@Column(name="CON_RAT")
	private double conRat;

	private String name;

	public Inwrhmap() {
	}

	public InwrhmapPK getId() {
		return this.id;
	}

	public void setId(InwrhmapPK id) {
		this.id = id;
	}

	public double getConRat() {
		return this.conRat;
	}

	public void setConRat(double conRat) {
		this.conRat = conRat;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}