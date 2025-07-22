package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEST_FORM database table.
 * 
 */
@Entity
@Table(name="TEST_FORM")
@NamedQuery(name="TestForm.findAll", query="SELECT t FROM TestForm t")
public class TestForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	
	public TestForm(String id,String name) {
		super();
		this.id = id;
		this.name = name;
		
	}


	public TestForm() {
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