package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_TOWERMAINTENANCE database table.
 * 
 */
@Entity
@Table(name="MMS_TOWERMAINTENANCE")
@NamedQuery(name="MmsTowermaintenance.findAll", query="SELECT m FROM MmsTowermaintenance m")
public class MmsTowermaintenance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsTowermaintenancePK id;

	@Column(name="ANTI_CLIMBING")
	private String antiClimbing;

	@Column(name="APPROVAL_LEVEL")
	private String approvalLevel;

	private String area;

	@Column(name="BASE_CONCRETE")
	private String baseConcrete;

	@Column(name="CONDUCTOR_CONDITION")
	private String conductorCondition;

	@Column(name="DEPT_ID")
	private String deptId;

	@Column(name="EARTH_CONDUCTOR_CONDITION")
	private String earthConductorCondition;

	@Column(name="ENDFITTING_SET")
	private String endfittingSet;

	@Column(name="FLASH_OVER_SETS")
	private BigDecimal flashOverSets;

	@Column(name="FLASHOVER_NO")
	private BigDecimal flashoverNo;

	@Column(name="FUNGUSS_SETNO")
	private String fungussSetno;

	@Column(name="JUMPER_CONDITION")
	private String jumperCondition;

	private String line;

	@Column(name="LINE_ID")
	private String lineId;

	@Column(name="LINE_NAME")
	private String lineName;
	
	@Column(name="LEG_PAINTING")
	private String legPainting;

	private String lutd;

	@Column(name="MAINTAINACE_ATTENTION")
	private String maintainaceAttention;

	@Temporal(TemporalType.DATE)
	@Column(name="MAINTENANCE_DATE")
	private Date maintenanceDate;

	@Column(name="MISSING_PARTS")
	private BigDecimal missingParts;

	@Column(name="SPECIAL_OBSERVATIONS")
	private String specialObservations;

	private String status;

	private BigDecimal tappings;

	@Column(name="TOWER_NO")
	private String towerNo;

	private String towerspecial;

	@Column(name="WAY_LEAVING")
	private String wayLeaving;

	private String wpinset;

	public MmsTowermaintenance() {
	}

	public MmsTowermaintenancePK getId() {
		return this.id;
	}

	public void setId(MmsTowermaintenancePK id) {
		this.id = id;
	}

	public String getAntiClimbing() {
		return this.antiClimbing;
	}

	public void setAntiClimbing(String antiClimbing) {
		this.antiClimbing = antiClimbing;
	}

	public String getApprovalLevel() {
		return this.approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBaseConcrete() {
		return this.baseConcrete;
	}

	public void setBaseConcrete(String baseConcrete) {
		this.baseConcrete = baseConcrete;
	}

	public String getConductorCondition() {
		return this.conductorCondition;
	}

	public void setConductorCondition(String conductorCondition) {
		this.conductorCondition = conductorCondition;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEarthConductorCondition() {
		return this.earthConductorCondition;
	}

	public void setEarthConductorCondition(String earthConductorCondition) {
		this.earthConductorCondition = earthConductorCondition;
	}

	public String getEndfittingSet() {
		return this.endfittingSet;
	}

	public void setEndfittingSet(String endfittingSet) {
		this.endfittingSet = endfittingSet;
	}

	public BigDecimal getFlashOverSets() {
		return this.flashOverSets;
	}

	public void setFlashOverSets(BigDecimal flashOverSets) {
		this.flashOverSets = flashOverSets;
	}

	public BigDecimal getFlashoverNo() {
		return this.flashoverNo;
	}

	public void setFlashoverNo(BigDecimal flashoverNo) {
		this.flashoverNo = flashoverNo;
	}

	public String getFungussSetno() {
		return this.fungussSetno;
	}

	public void setFungussSetno(String fungussSetno) {
		this.fungussSetno = fungussSetno;
	}

	public String getJumperCondition() {
		return this.jumperCondition;
	}

	public void setJumperCondition(String jumperCondition) {
		this.jumperCondition = jumperCondition;
	}

	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getLineId() {
		return this.lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLutd() {
		return this.lutd;
	}

	public void setLutd(String lutd) {
		this.lutd = lutd;
	}

	public String getMaintainaceAttention() {
		return this.maintainaceAttention;
	}

	public void setMaintainaceAttention(String maintainaceAttention) {
		this.maintainaceAttention = maintainaceAttention;
	}

	public Date getMaintenanceDate() {
		return this.maintenanceDate;
	}

	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public BigDecimal getMissingParts() {
		return this.missingParts;
	}

	public void setMissingParts(BigDecimal missingParts) {
		this.missingParts = missingParts;
	}

	public String getSpecialObservations() {
		return this.specialObservations;
	}

	public void setSpecialObservations(String specialObservations) {
		this.specialObservations = specialObservations;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTappings() {
		return this.tappings;
	}

	public void setTappings(BigDecimal tappings) {
		this.tappings = tappings;
	}

	public String getTowerNo() {
		return this.towerNo;
	}

	public void setTowerNo(String towerNo) {
		this.towerNo = towerNo;
	}

	public String getTowerspecial() {
		return this.towerspecial;
	}

	public void setTowerspecial(String towerspecial) {
		this.towerspecial = towerspecial;
	}

	public String getWayLeaving() {
		return this.wayLeaving;
	}

	public void setWayLeaving(String wayLeaving) {
		this.wayLeaving = wayLeaving;
	}

	public String getWpinset() {
		return this.wpinset;
	}

	public void setWpinset(String wpinset) {
		this.wpinset = wpinset;
	}

}