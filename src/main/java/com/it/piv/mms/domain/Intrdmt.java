package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INTRDMT database table.
 * 
 */
@Entity
@NamedQuery(name="Intrdmt.findAll", query="SELECT i FROM Intrdmt i")
public class Intrdmt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IntrdmtPK id;

	@Column(name="ACPTD_QTY")
	private BigDecimal acptdQty;

	@Column(name="ISS_QTY")
	private BigDecimal issQty;

	@Column(name="MAT_VAL")
	private BigDecimal matVal;

	@Column(name="ORDER_QTY")
	private BigDecimal orderQty;

	@Column(name="QTY_ON_HAND")
	private BigDecimal qtyOnHand;

	@Column(name="RECPT_QTY")
	private BigDecimal recptQty;

	@Column(name="REQ_QTY")
	private BigDecimal reqQty;

	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;

	@Column(name="UOM_CD")
	private String uomCd;

	public Intrdmt() {
	}

	public IntrdmtPK getId() {
		return this.id;
	}

	public void setId(IntrdmtPK id) {
		this.id = id;
	}

	public BigDecimal getAcptdQty() {
		return this.acptdQty;
	}

	public void setAcptdQty(BigDecimal acptdQty) {
		this.acptdQty = acptdQty;
	}

	public BigDecimal getIssQty() {
		return this.issQty;
	}

	public void setIssQty(BigDecimal issQty) {
		this.issQty = issQty;
	}

	public BigDecimal getMatVal() {
		return this.matVal;
	}

	public void setMatVal(BigDecimal matVal) {
		this.matVal = matVal;
	}

	public BigDecimal getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(BigDecimal orderQty) {
		this.orderQty = orderQty;
	}

	public BigDecimal getQtyOnHand() {
		return this.qtyOnHand;
	}

	public void setQtyOnHand(BigDecimal qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	public BigDecimal getRecptQty() {
		return this.recptQty;
	}

	public void setRecptQty(BigDecimal recptQty) {
		this.recptQty = recptQty;
	}

	public BigDecimal getReqQty() {
		return this.reqQty;
	}

	public void setReqQty(BigDecimal reqQty) {
		this.reqQty = reqQty;
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