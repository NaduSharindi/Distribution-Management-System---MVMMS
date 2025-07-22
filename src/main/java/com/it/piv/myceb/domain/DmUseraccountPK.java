package com.it.piv.myceb.domain;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DM_USERACCOUNTS database table.
 * 
 */
@Embeddable
public class DmUseraccountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String username;

	private String acctnumber;

	public DmUseraccountPK() {
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAcctnumber() {
		return this.acctnumber;
	}
	public void setAcctnumber(String acctnumber) {
		this.acctnumber = acctnumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DmUseraccountPK)) {
			return false;
		}
		DmUseraccountPK castOther = (DmUseraccountPK)other;
		return 
			this.username.equals(castOther.username)
			&& this.acctnumber.equals(castOther.acctnumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.username.hashCode();
		hash = hash * prime + this.acctnumber.hashCode();
		
		return hash;
	}
}