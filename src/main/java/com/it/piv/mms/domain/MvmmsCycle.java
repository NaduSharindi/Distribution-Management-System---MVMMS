package com.it.piv.mms.domain;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MVMMS_CYCLE database table.
 * 
 */
@Entity
@Table(name="MVMMS_CYCLE")
@NamedQuery(name="MvmmsCycle.findAll", query="SELECT m FROM MvmmsCycle m")
public class MvmmsCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MvmmsCyclePK id;

	@Column(name="CYCLE_NAME")
	private String cycleName;

	@Column(name="CYCLE_ORDER")
	private BigDecimal cycleOrder;

	private BigDecimal status;

	public MvmmsCycle() {
	}

	public MvmmsCyclePK getId() {
		return this.id;
	}

	public void setId(MvmmsCyclePK id) {
		this.id = id;
	}

	public String getCycleName() {
		return this.cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

	public BigDecimal getCycleOrder() {
		return this.cycleOrder;
	}

	public void setCycleOrder(BigDecimal cycleOrder) {
		this.cycleOrder = cycleOrder;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}