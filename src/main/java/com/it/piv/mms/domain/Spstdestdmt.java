package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SPSTDESTDMT database table.
 * 
 */
@Entity
@NamedQuery(name="Spstdestdmt.findAll", query="SELECT s FROM Spstdestdmt s")
public class Spstdestdmt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SpstdestdmtPK id;

	@Column(name="DEPT_ID")
	private String deptId;

	@Column(name="EST_COST")
	private double estCost;

	@Column(name="\"LENGTH\"")
	private double length;

	@Column(name="LINE_COST")
	private double lineCost;

	private String linedes;

	private String uom;

	public Spstdestdmt() {
	}

	public SpstdestdmtPK getId() {
		return this.id;
	}

	public void setId(SpstdestdmtPK id) {
		this.id = id;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public double getEstCost() {
		return this.estCost;
	}

	public void setEstCost(double estCost) {
		this.estCost = estCost;
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getLineCost() {
		return this.lineCost;
	}

	public void setLineCost(double lineCost) {
		this.lineCost = lineCost;
	}

	public String getLinedes() {
		return this.linedes;
	}

	public void setLinedes(String linedes) {
		this.linedes = linedes;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}