package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMS_ADDGSSFEEDER database table.
 * 
 */
@Entity
@Table(name="MMS_ADDGSSFEEDER")
@NamedQuery(name="MmsAddgssfeeder.findAll", query="SELECT m FROM MmsAddgssfeeder m")
public class MmsAddgssfeeder implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddgssfeederPK id;

	@Column(name="FEEDER_NAME")
	private String feederName;

	@Column(name="FEEDER_NO")
	private String feederNo;

	@Column(name="LINE_ID")
	private BigDecimal lineId;

	private BigDecimal status;

	public MmsAddgssfeeder() {
	}

	public MmsAddgssfeederPK getId() {
		return this.id;
	}

	public void setId(MmsAddgssfeederPK id) {
		this.id = id;
	}

	public String getFeederName() {
		return this.feederName;
	}

	public void setFeederName(String feederName) {
		this.feederName = feederName;
	}

	public String getFeederNo() {
		return this.feederNo;
	}

	public void setFeederNo(String feederNo) {
		this.feederNo = feederNo;
	}

	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}