package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUS_DATA database table.
 * 
 */
@Entity
@Table(name="CUS_DATA")
@NamedQuery(name="CusData.findAll", query="SELECT c FROM CusData c")
public class CusData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NO")
	private String idNo;

	@Column(name="ACCT_NUMBER")
	private String acctNumber;

	@Column(name="ADDRESS_1")
	private String address1;

	@Column(name="ADDRESS_2")
	private String address2;

	@Column(name="ADDRESS_3")
	private String address3;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Column(name="CRNT_DEPOT")
	private String crntDepot;

	@Column(name="CUS_LOCATION")
	private String cusLocation;

	@Column(name="CUST_FNAME")
	private String custFname;

	@Column(name="CUST_LNAME")
	private String custLname;

	@Column(name="CUST_TYPE")
	private String custType;

	@Column(name="DLY_PACK_NO")
	private String dlyPackNo;

	private String feeder;

	@Column(name="FEEDER_NAME")
	private String feederName;

	@Column(name="GRID_SUB")
	private String gridSub;

	@Column(name="LOC_LAT")
	private String locLat;

	@Column(name="LOC_LON")
	private String locLon;

	@Column(name="POLE_NO")
	private String poleNo;

	@Column(name="PREM_ID")
	private String premId;

	@Column(name="PRIMARY_SUB")
	private String primarySub;

	@Column(name="READER_CODE")
	private String readerCode;

	@Column(name="SUB_CONSUMER")
	private String subConsumer;

	@Column(name="SUB_NAME")
	private String subName;

	@Column(name="SUBSTN_CODE")
	private String substnCode;

	@Column(name="TELE_NOL")
	private String teleNol;

	@Column(name="TELE_NOM")
	private String teleNom;

	@Column(name="TYPE_OF_ID")
	private String typeOfId;

	@Column(name="WALK_SEQ")
	private String walkSeq;

	public CusData() {
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getAcctNumber() {
		return this.acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCrntDepot() {
		return this.crntDepot;
	}

	public void setCrntDepot(String crntDepot) {
		this.crntDepot = crntDepot;
	}

	public String getCusLocation() {
		return this.cusLocation;
	}

	public void setCusLocation(String cusLocation) {
		this.cusLocation = cusLocation;
	}

	public String getCustFname() {
		return this.custFname;
	}

	public void setCustFname(String custFname) {
		this.custFname = custFname;
	}

	public String getCustLname() {
		return this.custLname;
	}

	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getDlyPackNo() {
		return this.dlyPackNo;
	}

	public void setDlyPackNo(String dlyPackNo) {
		this.dlyPackNo = dlyPackNo;
	}

	public String getFeeder() {
		return this.feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public String getFeederName() {
		return this.feederName;
	}

	public void setFeederName(String feederName) {
		this.feederName = feederName;
	}

	public String getGridSub() {
		return this.gridSub;
	}

	public void setGridSub(String gridSub) {
		this.gridSub = gridSub;
	}

	public String getLocLat() {
		return this.locLat;
	}

	public void setLocLat(String locLat) {
		this.locLat = locLat;
	}

	public String getLocLon() {
		return this.locLon;
	}

	public void setLocLon(String locLon) {
		this.locLon = locLon;
	}

	public String getPoleNo() {
		return this.poleNo;
	}

	public void setPoleNo(String poleNo) {
		this.poleNo = poleNo;
	}

	public String getPremId() {
		return this.premId;
	}

	public void setPremId(String premId) {
		this.premId = premId;
	}

	public String getPrimarySub() {
		return this.primarySub;
	}

	public void setPrimarySub(String primarySub) {
		this.primarySub = primarySub;
	}

	public String getReaderCode() {
		return this.readerCode;
	}

	public void setReaderCode(String readerCode) {
		this.readerCode = readerCode;
	}

	public String getSubConsumer() {
		return this.subConsumer;
	}

	public void setSubConsumer(String subConsumer) {
		this.subConsumer = subConsumer;
	}

	public String getSubName() {
		return this.subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getSubstnCode() {
		return this.substnCode;
	}

	public void setSubstnCode(String substnCode) {
		this.substnCode = substnCode;
	}

	public String getTeleNol() {
		return this.teleNol;
	}

	public void setTeleNol(String teleNol) {
		this.teleNol = teleNol;
	}

	public String getTeleNom() {
		return this.teleNom;
	}

	public void setTeleNom(String teleNom) {
		this.teleNom = teleNom;
	}

	public String getTypeOfId() {
		return this.typeOfId;
	}

	public void setTypeOfId(String typeOfId) {
		this.typeOfId = typeOfId;
	}

	public String getWalkSeq() {
		return this.walkSeq;
	}

	public void setWalkSeq(String walkSeq) {
		this.walkSeq = walkSeq;
	}

}