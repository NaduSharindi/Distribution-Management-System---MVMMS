package com.it.piv.mms.domain;
import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import java.math.BigDecimal;


/**
 * The persistent class for the MMS_ADDFEEDER database table.
 * 
 */
@Entity
@Table(name="MMS_ADDFEEDER")
@NamedQuery(name="MmsAddfeeder.findAll", query="SELECT m FROM MmsAddfeeder m")
public class MmsAddfeeder implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddfeederPK id;

	private String code;
	@Column(name="PHM_BRANCH")
	private String phmBranch;


	public String getPhmBranch() {
		return phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	private BigDecimal conductor;

	@Column(name="FEEDER_TYPE")
	private BigDecimal feederType;

	@Column(name="IS_BY_PASS_AVAI")
	private BigDecimal isByPassAvai;

	private String name;

	
	@Column(name="MAP_ID")
	private BigDecimal mapId;

	public BigDecimal getMapId() {
		return mapId;
	}

	public void setMapId(BigDecimal mapId) {
		this.mapId = mapId;
	}

	@Column(name="NO_ABS")
	private BigDecimal noAbs;

	@Column(name="NO_AR")
	private BigDecimal noAr;

	@Column(name="NO_DDLO")
	private BigDecimal noDdlo;

	@Column(name="NO_LBS")
	private BigDecimal noLbs;

	@Column(name="NO_SA")
	private BigDecimal noSa;

	@Column(name="TYPE_IN_OUT")
	private BigDecimal typeInOut;
	
	
	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	public BigDecimal getGpsLatitude() {
		return gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;


	public BigDecimal getGpsLongitude() {
		return gpsLongitude;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public MmsAddfeeder() {
	}

	public MmsAddfeederPK getId() {
		return this.id;
	}

	public void setId(MmsAddfeederPK id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getConductor() {
		return this.conductor;
	}

	public void setConductor(BigDecimal conductor) {
		this.conductor = conductor;
	}

	public BigDecimal getFeederType() {
		return this.feederType;
	}

	public void setFeederType(BigDecimal feederType) {
		this.feederType = feederType;
	}

	public BigDecimal getIsByPassAvai() {
		return this.isByPassAvai;
	}

	public void setIsByPassAvai(BigDecimal isByPassAvai) {
		this.isByPassAvai = isByPassAvai;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getNoAbs() {
		return this.noAbs;
	}

	public void setNoAbs(BigDecimal noAbs) {
		this.noAbs = noAbs;
	}

	public BigDecimal getNoAr() {
		return this.noAr;
	}

	public void setNoAr(BigDecimal noAr) {
		this.noAr = noAr;
	}

	public BigDecimal getNoDdlo() {
		return this.noDdlo;
	}

	public void setNoDdlo(BigDecimal noDdlo) {
		this.noDdlo = noDdlo;
	}

	public BigDecimal getNoLbs() {
		return this.noLbs;
	}

	public void setNoLbs(BigDecimal noLbs) {
		this.noLbs = noLbs;
	}

	public BigDecimal getNoSa() {
		return this.noSa;
	}

	public void setNoSa(BigDecimal noSa) {
		this.noSa = noSa;
	}

	public BigDecimal getTypeInOut() {
		return this.typeInOut;
	}

	public void setTypeInOut(BigDecimal typeInOut) {
		this.typeInOut = typeInOut;
	}
	
	private BigDecimal status;

	public BigDecimal getStatus() {
	return this.status;
	}

	public void setStatus(BigDecimal status) {
	this.status = status;
	}


}