package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SPNORMS database table.
 * 
 */
@Entity
@Table(name="SPNORMS")
@NamedQuery(name="Spnorm.findAll", query="SELECT s FROM Spnorm s")
public class Spnorm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String linesectiontypeid;

	private String description;

	private String lineparentid;

	private double standardcost;

	private String uom;

	public Spnorm() {
	}

	public String getLinesectiontypeid() {
		return this.linesectiontypeid;
	}

	public void setLinesectiontypeid(String linesectiontypeid) {
		this.linesectiontypeid = linesectiontypeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLineparentid() {
		return this.lineparentid;
	}

	public void setLineparentid(String lineparentid) {
		this.lineparentid = lineparentid;
	}

	public double getStandardcost() {
		return this.standardcost;
	}

	public void setStandardcost(double standardcost) {
		this.standardcost = standardcost;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}