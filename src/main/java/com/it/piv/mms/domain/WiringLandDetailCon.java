package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;


import java.math.BigDecimal;


/**
 * The persistent class for the WIRING_LAND_DETAIL_CON database table.
 * 
 */
@Entity
@Table(name="WIRING_LAND_DETAIL_CON")
@NamedQuery(name="WiringLandDetailCon.findAll", query="SELECT w FROM WiringLandDetailCon w")
public class WiringLandDetailCon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WiringLandDetailConPK id;

	@Column(name="ACCOUNT_NOS")
	private String accountNos;

	@Column(name="AGA_DIVISION")
	private String agaDivision;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Column(name="CAP_OF_SERVICE")
	private BigDecimal capOfService;

	@Column(name="CON_REF_NO")
	private String conRefNo;

	@Column(name="DES_OF_PREMISES")
	private String desOfPremises;

	@Column(name="DEV_SEC")
	private String devSec;

	private String district;

	private String electorate;

	@Column(name="FUND_SOURCE")
	private String fundSource;

	@Column(name="GS_DIVISION")
	private String gsDivision;

	@Column(name="IS_ELECTRICITY_HAVING")
	private String isElectricityHaving;

	@Column(name="NO_OF_METER_POINT")
	private BigDecimal noOfMeterPoint;

	private String rep2contact;

	private String repcontact;

	private String representative;

	private String representative2;

	@Column(name="SCHEME_NAME")
	private String schemeName;

	@Column(name="SCHEME_NO")
	private String schemeNo;

	private String servicedeponame;

	public WiringLandDetailCon() {
	}

	public WiringLandDetailConPK getId() {
		return this.id;
	}

	public void setId(WiringLandDetailConPK id) {
		this.id = id;
	}

	public String getAccountNos() {
		return this.accountNos;
	}

	public void setAccountNos(String accountNos) {
		this.accountNos = accountNos;
	}

	public String getAgaDivision() {
		return this.agaDivision;
	}

	public void setAgaDivision(String agaDivision) {
		this.agaDivision = agaDivision;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public BigDecimal getCapOfService() {
		return this.capOfService;
	}

	public void setCapOfService(BigDecimal capOfService) {
		this.capOfService = capOfService;
	}

	public String getConRefNo() {
		return this.conRefNo;
	}

	public void setConRefNo(String conRefNo) {
		this.conRefNo = conRefNo;
	}

	public String getDesOfPremises() {
		return this.desOfPremises;
	}

	public void setDesOfPremises(String desOfPremises) {
		this.desOfPremises = desOfPremises;
	}

	public String getDevSec() {
		return this.devSec;
	}

	public void setDevSec(String devSec) {
		this.devSec = devSec;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getElectorate() {
		return this.electorate;
	}

	public void setElectorate(String electorate) {
		this.electorate = electorate;
	}

	public String getFundSource() {
		return this.fundSource;
	}

	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}

	public String getGsDivision() {
		return this.gsDivision;
	}

	public void setGsDivision(String gsDivision) {
		this.gsDivision = gsDivision;
	}

	public String getIsElectricityHaving() {
		return this.isElectricityHaving;
	}

	public void setIsElectricityHaving(String isElectricityHaving) {
		this.isElectricityHaving = isElectricityHaving;
	}

	public BigDecimal getNoOfMeterPoint() {
		return this.noOfMeterPoint;
	}

	public void setNoOfMeterPoint(BigDecimal noOfMeterPoint) {
		this.noOfMeterPoint = noOfMeterPoint;
	}

	public String getRep2contact() {
		return this.rep2contact;
	}

	public void setRep2contact(String rep2contact) {
		this.rep2contact = rep2contact;
	}

	public String getRepcontact() {
		return this.repcontact;
	}

	public void setRepcontact(String repcontact) {
		this.repcontact = repcontact;
	}

	public String getRepresentative() {
		return this.representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getRepresentative2() {
		return this.representative2;
	}

	public void setRepresentative2(String representative2) {
		this.representative2 = representative2;
	}

	public String getSchemeName() {
		return this.schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeNo() {
		return this.schemeNo;
	}

	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}

	public String getServicedeponame() {
		return this.servicedeponame;
	}

	public void setServicedeponame(String servicedeponame) {
		this.servicedeponame = servicedeponame;
	}

}