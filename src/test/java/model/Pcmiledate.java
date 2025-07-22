package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PCMILEDATES database table.
 * 
 */
@Entity
@Table(name="PCMILEDATES")
@NamedQuery(name="Pcmiledate.findAll", query="SELECT p FROM Pcmiledate p")
public class Pcmiledate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PcmiledatePK id;

	private double cpercentage;

	@Column(name="MILE_NM")
	private String mileNm;

	private String remarks;

	public Pcmiledate() {
	}

	public PcmiledatePK getId() {
		return this.id;
	}

	public void setId(PcmiledatePK id) {
		this.id = id;
	}

	public double getCpercentage() {
		return this.cpercentage;
	}

	public void setCpercentage(double cpercentage) {
		this.cpercentage = cpercentage;
	}

	public String getMileNm() {
		return this.mileNm;
	}

	public void setMileNm(String mileNm) {
		this.mileNm = mileNm;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}