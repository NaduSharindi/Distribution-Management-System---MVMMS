package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PCMILEM database table.
 * 
 */
@Entity
@NamedQuery(name="Pcmilem.findAll", query="SELECT p FROM Pcmilem p")
public class Pcmilem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PcmilemPK id;

	@Column(name="MILE_NM")
	private String mileNm;

	private double percentage;

	public Pcmilem() {
	}

	public PcmilemPK getId() {
		return this.id;
	}

	public void setId(PcmilemPK id) {
		this.id = id;
	}

	public String getMileNm() {
		return this.mileNm;
	}

	public void setMileNm(String mileNm) {
		this.mileNm = mileNm;
	}

	public double getPercentage() {
		return this.percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}