package com.it.piv.mms.domain;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDSUPPORTTYPE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDSUPPORTTYPE")
@NamedQuery(name="MmsAddsupporttype.findAll", query="SELECT m FROM MmsAddsupporttype m")
public class MmsAddsupporttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String status;

	@Column(name="SUPPORT_TYPE")
	private String supportType;

	public MmsAddsupporttype() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupportType() {
		return this.supportType;
	}

	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}

}