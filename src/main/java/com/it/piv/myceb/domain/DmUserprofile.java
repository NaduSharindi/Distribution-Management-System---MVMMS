package com.it.piv.myceb.domain;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DM_USERPROFILE database table.
 * 
 */
@Entity
@Table(name="DM_USERPROFILE")
@NamedQuery(name="DmUserprofile.findAll", query="SELECT d FROM DmUserprofile d")
public class DmUserprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uesrname;

	private String userpwd;

	private String userstatus;

	public DmUserprofile() {
	}

	public String getUesrname() {
		return this.uesrname;
	}

	public void setUesrname(String uesrname) {
		this.uesrname = uesrname;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

}