package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMS_ADDLVFEEDER database table.
 * 
 */
@Entity
@Table(name="MMS_ADDLVFEEDER")
@NamedQuery(name="MmsAddlvfeeder.findAll", query="SELECT m FROM MmsAddlvfeeder m")
public class MmsAddlvfeeder implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddlvfeederPK id;

	private String area;

	private String code;

	private String name;

	private BigDecimal status;

	public MmsAddlvfeeder() {
	}

	public MmsAddlvfeederPK getId() {
		return this.id;
	}

	public void setId(MmsAddlvfeederPK id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}