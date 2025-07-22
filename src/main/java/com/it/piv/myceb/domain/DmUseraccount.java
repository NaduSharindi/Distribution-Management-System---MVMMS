package com.it.piv.myceb.domain;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DM_USERACCOUNTS database table.
 * 
 */
@Entity
@Table(name="DM_USERACCOUNTS")
@NamedQuery(name="DmUseraccount.findAll", query="SELECT d FROM DmUseraccount d")
public class DmUseraccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DmUseraccountPK id;

	private String accstatus;

	private String callername;
	
	private String email;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="FIXEDTEL_1")
	private String fixedtel1;

	@Column(name="FIXEDTEL_2")
	private String fixedtel2;

	@Column(name="MOBILETEL_1")
	private String mobiletel1;

	@Column(name="MOBILETEL_2")
	private String mobiletel2;

	@Column(name="MOBILETEL_3")
	private String mobiletel3;

	private String prlocation;

	public DmUseraccount() {
	}

	public DmUseraccountPK getId() {
		return this.id;
	}

	public void setId(DmUseraccountPK id) {
		this.id = id;
	}

	public String getAccstatus() {
		return this.accstatus;
	}

	public void setAccstatus(String accstatus) {
		this.accstatus = accstatus;
	}

	public String getCallername() {
		return this.callername;
	}

	public void setCallername(String callername) {
		this.callername = callername;
	}

	public String getFixedtel1() {
		return this.fixedtel1;
	}

	public void setFixedtel1(String fixedtel1) {
		this.fixedtel1 = fixedtel1;
	}

	public String getFixedtel2() {
		return this.fixedtel2;
	}

	public void setFixedtel2(String fixedtel2) {
		this.fixedtel2 = fixedtel2;
	}

	public String getMobiletel1() {
		return this.mobiletel1;
	}

	public void setMobiletel1(String mobiletel1) {
		this.mobiletel1 = mobiletel1;
	}

	public String getMobiletel2() {
		return this.mobiletel2;
	}

	public void setMobiletel2(String mobiletel2) {
		this.mobiletel2 = mobiletel2;
	}

	public String getMobiletel3() {
		return this.mobiletel3;
	}

	public void setMobiletel3(String mobiletel3) {
		this.mobiletel3 = mobiletel3;
	}

	public String getPrlocation() {
		return this.prlocation;
	}

	public void setPrlocation(String prlocation) {
		this.prlocation = prlocation;
	}

}