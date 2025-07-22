package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDLINETYPE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDLINETYPE")
@NamedQuery(name="MmsAddlinetype.findAll", query="SELECT m FROM MmsAddlinetype m")
public class MmsAddlinetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="LINE_TYPE")
	private String lineType;

	private String status;

	public MmsAddlinetype() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLineType() {
		return this.lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}