package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PCMILESUMARY database table.
 * 
 */
@Entity
@NamedQuery(name="Pcmilesumary.findAll", query="SELECT p FROM Pcmilesumary p")
public class Pcmilesumary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PcmilesumaryPK id;

	private double cpercentage;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_LAST")
	private Date dateLast;

	private BigDecimal status;

	public Pcmilesumary() {
	}

	public PcmilesumaryPK getId() {
		return this.id;
	}

	public void setId(PcmilesumaryPK id) {
		this.id = id;
	}

	public double getCpercentage() {
		return this.cpercentage;
	}

	public void setCpercentage(double cpercentage) {
		this.cpercentage = cpercentage;
	}

	public Date getDateLast() {
		return this.dateLast;
	}

	public void setDateLast(Date dateLast) {
		this.dateLast = dateLast;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}