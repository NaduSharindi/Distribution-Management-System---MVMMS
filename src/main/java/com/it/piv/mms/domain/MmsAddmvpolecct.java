package com.it.piv.mms.domain;


import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

import com.it.piv.mms.domain.MmsAddmvpolecctPK;


/**
 * The persistent class for the MMS_ADDMVPOLECCT database table.
 * 
 */
@Entity
@Table(name="MMS_ADDMVPOLECCT")
@NamedQuery(name="MmsAddmvpolecct.findAll", query="SELECT m FROM MmsAddmvpolecct m")
public class MmsAddmvpolecct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddmvpolecctPK id;

	@Column(name="CCT_CONDUCTOR_I")
	private BigDecimal cctConductorI;

	@Column(name="CCT_CONDUCTOR_II")
	private BigDecimal cctConductorIi;

	@Column(name="CCT_CONDUCTOR_III")
	private BigDecimal cctConductorIii;

	@Column(name="CCT_CROSS_ARM_TYPE")
	private BigDecimal cctCrossArmType;

	@Column(name="CCT_CROSS_ARM_TYPE_2")
	private BigDecimal cctCrossArmType2;

	@Column(name="CCT_CROSS_ARM_VOLTAGE")
	private BigDecimal cctCrossArmVoltage;

	@Column(name="CCT_CROSS_ARM_VOLTAGE_2")
	private BigDecimal cctCrossArmVoltage2;

	@Column(name="CCT_FORMATION")
	private BigDecimal cctFormation;

	@Column(name="CCT_INSULATOR_TYPE_I")
	private BigDecimal cctInsulatorTypeI;

	@Column(name="CCT_INSULATOR_TYPE_I_2")
	private BigDecimal cctInsulatorTypeI2;

	@Column(name="CCT_INSULATOR_TYPE_I_3")
	private BigDecimal cctInsulatorTypeI3;

	@Column(name="CCT_INSULATOR_TYPE_I_4")
	private BigDecimal cctInsulatorTypeI4;

	@Column(name="CCT_INSULATOR_TYPE_II")
	private BigDecimal cctInsulatorTypeIi;

	@Column(name="CCT_INSULATOR_TYPE_II_2")
	private BigDecimal cctInsulatorTypeIi2;

	@Column(name="CCT_INSULATOR_TYPE_II_3")
	private BigDecimal cctInsulatorTypeIi3;

	@Column(name="CCT_INSULATOR_TYPE_II_4")
	private BigDecimal cctInsulatorTypeIi4;

	@Column(name="CCT_INSULATOR_VOLTAGE")
	private BigDecimal cctInsulatorVoltage;

	@Column(name="CCT_INSULATOR_VOLTAGE_2")
	private BigDecimal cctInsulatorVoltage2;

	@Column(name="CCT_INSULATOR_VOLTAGE_3")
	private BigDecimal cctInsulatorVoltage3;

	@Column(name="CCT_INSULATOR_VOLTAGE_4")
	private BigDecimal cctInsulatorVoltage4;

	@Column(name="CCT_SOURCE")
	private String cctSource;

	@Column(name="CCT_VERTICLE_POSITION")
	private BigDecimal cctVerticlePosition;

	@Column(name="FEEDER_ID")
	private String feederId;

	@Column(name="GANTRY_ID")
	private BigDecimal gantryId;

	@Column(name="INS_PHASE")
	private BigDecimal insPhase;

	@Column(name="INS_PHASE_2")
	private BigDecimal insPhase2;

	@Column(name="INS_PHASE_3")
	private BigDecimal insPhase3;

	@Column(name="INS_PHASE_4")
	private BigDecimal insPhase4;

	private BigDecimal status;

	public MmsAddmvpolecct() {
	}

	public MmsAddmvpolecctPK getId() {
		return this.id;
	}

	public void setId(MmsAddmvpolecctPK id) {
		this.id = id;
	}

	public BigDecimal getCctConductorI() {
		return this.cctConductorI;
	}

	public void setCctConductorI(BigDecimal cctConductorI) {
		this.cctConductorI = cctConductorI;
	}

	public BigDecimal getCctConductorIi() {
		return this.cctConductorIi;
	}

	public void setCctConductorIi(BigDecimal cctConductorIi) {
		this.cctConductorIi = cctConductorIi;
	}

	public BigDecimal getCctConductorIii() {
		return this.cctConductorIii;
	}

	public void setCctConductorIii(BigDecimal cctConductorIii) {
		this.cctConductorIii = cctConductorIii;
	}

	public BigDecimal getCctCrossArmType() {
		return this.cctCrossArmType;
	}

	public void setCctCrossArmType(BigDecimal cctCrossArmType) {
		this.cctCrossArmType = cctCrossArmType;
	}

	public BigDecimal getCctCrossArmType2() {
		return this.cctCrossArmType2;
	}

	public void setCctCrossArmType2(BigDecimal cctCrossArmType2) {
		this.cctCrossArmType2 = cctCrossArmType2;
	}

	public BigDecimal getCctCrossArmVoltage() {
		return this.cctCrossArmVoltage;
	}

	public void setCctCrossArmVoltage(BigDecimal cctCrossArmVoltage) {
		this.cctCrossArmVoltage = cctCrossArmVoltage;
	}

	public BigDecimal getCctCrossArmVoltage2() {
		return this.cctCrossArmVoltage2;
	}

	public void setCctCrossArmVoltage2(BigDecimal cctCrossArmVoltage2) {
		this.cctCrossArmVoltage2 = cctCrossArmVoltage2;
	}

	public BigDecimal getCctFormation() {
		return this.cctFormation;
	}

	public void setCctFormation(BigDecimal cctFormation) {
		this.cctFormation = cctFormation;
	}

	public BigDecimal getCctInsulatorTypeI() {
		return this.cctInsulatorTypeI;
	}

	public void setCctInsulatorTypeI(BigDecimal cctInsulatorTypeI) {
		this.cctInsulatorTypeI = cctInsulatorTypeI;
	}

	public BigDecimal getCctInsulatorTypeI2() {
		return this.cctInsulatorTypeI2;
	}

	public void setCctInsulatorTypeI2(BigDecimal cctInsulatorTypeI2) {
		this.cctInsulatorTypeI2 = cctInsulatorTypeI2;
	}

	public BigDecimal getCctInsulatorTypeI3() {
		return this.cctInsulatorTypeI3;
	}

	public void setCctInsulatorTypeI3(BigDecimal cctInsulatorTypeI3) {
		this.cctInsulatorTypeI3 = cctInsulatorTypeI3;
	}

	public BigDecimal getCctInsulatorTypeI4() {
		return this.cctInsulatorTypeI4;
	}

	public void setCctInsulatorTypeI4(BigDecimal cctInsulatorTypeI4) {
		this.cctInsulatorTypeI4 = cctInsulatorTypeI4;
	}

	public BigDecimal getCctInsulatorTypeIi() {
		return this.cctInsulatorTypeIi;
	}

	public void setCctInsulatorTypeIi(BigDecimal cctInsulatorTypeIi) {
		this.cctInsulatorTypeIi = cctInsulatorTypeIi;
	}

	public BigDecimal getCctInsulatorTypeIi2() {
		return this.cctInsulatorTypeIi2;
	}

	public void setCctInsulatorTypeIi2(BigDecimal cctInsulatorTypeIi2) {
		this.cctInsulatorTypeIi2 = cctInsulatorTypeIi2;
	}

	public BigDecimal getCctInsulatorTypeIi3() {
		return this.cctInsulatorTypeIi3;
	}

	public void setCctInsulatorTypeIi3(BigDecimal cctInsulatorTypeIi3) {
		this.cctInsulatorTypeIi3 = cctInsulatorTypeIi3;
	}

	public BigDecimal getCctInsulatorTypeIi4() {
		return this.cctInsulatorTypeIi4;
	}

	public void setCctInsulatorTypeIi4(BigDecimal cctInsulatorTypeIi4) {
		this.cctInsulatorTypeIi4 = cctInsulatorTypeIi4;
	}

	public BigDecimal getCctInsulatorVoltage() {
		return this.cctInsulatorVoltage;
	}

	public void setCctInsulatorVoltage(BigDecimal cctInsulatorVoltage) {
		this.cctInsulatorVoltage = cctInsulatorVoltage;
	}

	public BigDecimal getCctInsulatorVoltage2() {
		return this.cctInsulatorVoltage2;
	}

	public void setCctInsulatorVoltage2(BigDecimal cctInsulatorVoltage2) {
		this.cctInsulatorVoltage2 = cctInsulatorVoltage2;
	}

	public BigDecimal getCctInsulatorVoltage3() {
		return this.cctInsulatorVoltage3;
	}

	public void setCctInsulatorVoltage3(BigDecimal cctInsulatorVoltage3) {
		this.cctInsulatorVoltage3 = cctInsulatorVoltage3;
	}

	public BigDecimal getCctInsulatorVoltage4() {
		return this.cctInsulatorVoltage4;
	}

	public void setCctInsulatorVoltage4(BigDecimal cctInsulatorVoltage4) {
		this.cctInsulatorVoltage4 = cctInsulatorVoltage4;
	}

	public String getCctSource() {
		return this.cctSource;
	}

	public void setCctSource(String cctSource) {
		this.cctSource = cctSource;
	}

	public BigDecimal getCctVerticlePosition() {
		return this.cctVerticlePosition;
	}

	public void setCctVerticlePosition(BigDecimal cctVerticlePosition) {
		this.cctVerticlePosition = cctVerticlePosition;
	}

	public String getFeederId() {
		return this.feederId;
	}

	public void setFeederId(String feederId) {
		this.feederId = feederId;
	}

	public BigDecimal getGantryId() {
		return this.gantryId;
	}

	public void setGantryId(BigDecimal gantryId) {
		this.gantryId = gantryId;
	}

	public BigDecimal getInsPhase() {
		return this.insPhase;
	}

	public void setInsPhase(BigDecimal insPhase) {
		this.insPhase = insPhase;
	}

	public BigDecimal getInsPhase2() {
		return this.insPhase2;
	}

	public void setInsPhase2(BigDecimal insPhase2) {
		this.insPhase2 = insPhase2;
	}

	public BigDecimal getInsPhase3() {
		return this.insPhase3;
	}

	public void setInsPhase3(BigDecimal insPhase3) {
		this.insPhase3 = insPhase3;
	}

	public BigDecimal getInsPhase4() {
		return this.insPhase4;
	}

	public void setInsPhase4(BigDecimal insPhase4) {
		this.insPhase4 = insPhase4;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}