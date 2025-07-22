package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MTREQDTT database table.
 * 
 */
@Entity
@NamedQuery(name="Mtreqdtt.findAll", query="SELECT m FROM Mtreqdtt m")
public class Mtreqdtt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MtreqdttPK id;

	private String alert;

	@Column(name="APRVD_UNITS")
	private BigDecimal aprvdUnits;

	@Column(name="ESTIMATE_QTY")
	private BigDecimal estimateQty;

	@Column(name="GRADE_CD")
	private String gradeCd;

	@Column(name="GRN_QTY")
	private BigDecimal grnQty;

	@Column(name="ISSUED_QTY")
	private BigDecimal issuedQty;

	@Column(name="REQ_UNITS")
	private BigDecimal reqUnits;

	@Column(name="RETURNED_QTY")
	private BigDecimal returnedQty;

	private BigDecimal tolerance;

	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;

	@Column(name="UOM_CD")
	private String uomCd;

	public Mtreqdtt() {
	}

	public MtreqdttPK getId() {
		return this.id;
	}

	public void setId(MtreqdttPK id) {
		this.id = id;
	}

	public String getAlert() {
		return this.alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public BigDecimal getAprvdUnits() {
		return this.aprvdUnits;
	}

	public void setAprvdUnits(BigDecimal aprvdUnits) {
		this.aprvdUnits = aprvdUnits;
	}

	public BigDecimal getEstimateQty() {
		return this.estimateQty;
	}

	public void setEstimateQty(BigDecimal estimateQty) {
		this.estimateQty = estimateQty;
	}

	public String getGradeCd() {
		return this.gradeCd;
	}

	public void setGradeCd(String gradeCd) {
		this.gradeCd = gradeCd;
	}

	public BigDecimal getGrnQty() {
		return this.grnQty;
	}

	public void setGrnQty(BigDecimal grnQty) {
		this.grnQty = grnQty;
	}

	public BigDecimal getIssuedQty() {
		return this.issuedQty;
	}

	public void setIssuedQty(BigDecimal issuedQty) {
		this.issuedQty = issuedQty;
	}

	public BigDecimal getReqUnits() {
		return this.reqUnits;
	}

	public void setReqUnits(BigDecimal reqUnits) {
		this.reqUnits = reqUnits;
	}

	public BigDecimal getReturnedQty() {
		return this.returnedQty;
	}

	public void setReturnedQty(BigDecimal returnedQty) {
		this.returnedQty = returnedQty;
	}

	public BigDecimal getTolerance() {
		return this.tolerance;
	}

	public void setTolerance(BigDecimal tolerance) {
		this.tolerance = tolerance;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUomCd() {
		return this.uomCd;
	}

	public void setUomCd(String uomCd) {
		this.uomCd = uomCd;
	}

}