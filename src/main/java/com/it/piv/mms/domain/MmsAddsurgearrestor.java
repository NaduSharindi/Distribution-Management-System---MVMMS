package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_ADDSURGEARRESTOR database table.
 * 
 */
@Entity
@Table(name="MMS_ADDSURGEARRESTOR")
@NamedQuery(name="MmsAddsurgearrestor.findAll", query="SELECT m FROM MmsAddsurgearrestor m")
public class MmsAddsurgearrestor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddsurgearrestorPK id;

	private String brand;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_MANUFACTURE")
	private Date dateOfManufacture;

	private BigDecimal quantity;

	private String rating;

	private BigDecimal status;

	@Column(name="\"TYPE\"")
	private BigDecimal type;

	public MmsAddsurgearrestor() {
	}

	public MmsAddsurgearrestorPK getId() {
		return this.id;
	}

	public void setId(MmsAddsurgearrestorPK id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getDateOfManufacture() {
		return this.dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

}