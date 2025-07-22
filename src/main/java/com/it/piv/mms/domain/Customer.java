package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String cebemptype;

	private String city3;

	private String costcenno;

	private String customername;

	private String email;

	private String firstname;

	private String idtype;

	private String lancdma;

	private String lastname;

	private String mobileno;

	private String pcode;

	private String personalcop;

	private String preflang;

	private String saddressl1;

	private String suburb;

	public Customer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCebemptype() {
		return this.cebemptype;
	}

	public void setCebemptype(String cebemptype) {
		this.cebemptype = cebemptype;
	}

	public String getCity3() {
		return this.city3;
	}

	public void setCity3(String city3) {
		this.city3 = city3;
	}

	public String getCostcenno() {
		return this.costcenno;
	}

	public void setCostcenno(String costcenno) {
		this.costcenno = costcenno;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getIdtype() {
		return this.idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getLancdma() {
		return this.lancdma;
	}

	public void setLancdma(String lancdma) {
		this.lancdma = lancdma;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPcode() {
		return this.pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPersonalcop() {
		return this.personalcop;
	}

	public void setPersonalcop(String personalcop) {
		this.personalcop = personalcop;
	}

	public String getPreflang() {
		return this.preflang;
	}

	public void setPreflang(String preflang) {
		this.preflang = preflang;
	}

	public String getSaddressl1() {
		return this.saddressl1;
	}

	public void setSaddressl1(String saddressl1) {
		this.saddressl1 = saddressl1;
	}

	public String getSuburb() {
		return this.suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

}