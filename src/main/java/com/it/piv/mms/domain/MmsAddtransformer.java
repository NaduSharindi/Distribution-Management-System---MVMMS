package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_ADDTRANSFORMER database table.
 * 
 */
@Entity
@Table(name="MMS_ADDTRANSFORMER")
@NamedQuery(name="MmsAddtransformer.findAll", query="SELECT m FROM MmsAddtransformer m")
public class MmsAddtransformer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddtransformerPK id;

	@Column(name="BRAND_NAME")
	private BigDecimal brandName;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_COMMISSIONING")
	private Date dateOfCommissioning;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_MANUFACTURING")
	private Date dateOfManufacturing;

	private BigDecimal kva;

	private BigDecimal model;

	@Column(name="SERIAL_NO")
	private String serialNo;

	private BigDecimal status;

	@Column(name="VOLTAGE_RATIO")
	private BigDecimal voltageRatio;

	public MmsAddtransformer() {
	}

	public MmsAddtransformerPK getId() {
		return this.id;
	}

	public void setId(MmsAddtransformerPK id) {
		this.id = id;
	}

	public BigDecimal getBrandName() {
		return this.brandName;
	}

	public void setBrandName(BigDecimal brandName) {
		this.brandName = brandName;
	}

	public Date getDateOfCommissioning() {
		return this.dateOfCommissioning;
	}

	public void setDateOfCommissioning(Date dateOfCommissioning) {
		this.dateOfCommissioning = dateOfCommissioning;
	}

	public Date getDateOfManufacturing() {
		return this.dateOfManufacturing;
	}

	public void setDateOfManufacturing(Date dateOfManufacturing) {
		this.dateOfManufacturing = dateOfManufacturing;
	}

	public BigDecimal getKva() {
		return this.kva;
	}

	public void setKva(BigDecimal kva) {
		this.kva = kva;
	}

	public BigDecimal getModel() {
		return this.model;
	}

	public void setModel(BigDecimal model) {
		this.model = model;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getVoltageRatio() {
		return this.voltageRatio;
	}

	public void setVoltageRatio(BigDecimal voltageRatio) {
		this.voltageRatio = voltageRatio;
	}

}