package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MMS_TXNTOWERMAINTENANCEMV database table.
 * 
 */
@Entity
@Table(name="MMS_TXNTOWERMAINTENANCEMV")
@NamedQuery(name="MmsTxntowermaintenancemv.findAll", query="SELECT m FROM MmsTxntowermaintenancemv m")
public class MmsTxntowermaintenancemv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsTxntowermaintenancemvPK id;

	@Column(name="CCT_1_1P_SERVICE")
	private BigDecimal cct11pService;

	@Column(name="CCT_1_3P_SERVICE")
	private BigDecimal cct13pService;

	@Column(name="CCT_1_LV_CON_TYPE")
	private BigDecimal cct1LvConType;

	@Column(name="CCT_2_1P_SERVICE")
	private BigDecimal cct21pService;

	@Column(name="CCT_2_3P_SERVICE")
	private BigDecimal cct23pService;

	@Column(name="CCT_2_LV_CON_TYPE")
	private BigDecimal cct2LvConType;

	@Column(name="CCT_3_1P_SERVICE")
	private BigDecimal cct31pService;

	@Column(name="CCT_3_3P_SERVICE")
	private BigDecimal cct33pService;

	@Column(name="CCT_3_LV_CON_TYPE")
	private BigDecimal cct3LvConType;

	@Column(name="CCT_4_1P_SERVICE")
	private BigDecimal cct41pService;

	@Column(name="CCT_4_3P_SERVICE")
	private BigDecimal cct43pService;

	@Column(name="CCT_4_LV_CON_TYPE")
	private BigDecimal cct4LvConType;

	@Column(name="CCT_5_LV_CON_TYPE")
	private BigDecimal cct5LvConType;

	@Column(name="EARTH_DOWN_CONDUCTOR")
	private BigDecimal earthDownConductor;

	@Column(name="HORIZONTAL_EARTH")
	private BigDecimal horizontalEarth;

	@Column(name="HV_BAD_INSULATORS")
	private BigDecimal hvBadInsulators;

	@Column(name="HV_BAD_INSULATORS2")
	private BigDecimal hvBadInsulators2;

	@Column(name="HV_JUMP_TB_CRIMPED")
	private BigDecimal hvJumpTbCrimped;

	@Column(name="HV_SPAN_TB_CRIMPED")
	private BigDecimal hvSpanTbCrimped;

	@Column(name="LV_CCT_1_NAME")
	private String lvCct1Name;

	@Column(name="LV_CCT_1_TYPE")
	private BigDecimal lvCct1Type;

	@Column(name="LV_CCT_2_NAME")
	private String lvCct2Name;

	@Column(name="LV_CCT_2_TYPE")
	private BigDecimal lvCct2Type;

	@Column(name="LV_CCT_3_NAME")
	private String lvCct3Name;

	@Column(name="LV_CCT_3_TYPE")
	private BigDecimal lvCct3Type;

	@Column(name="LV_CCT_4_NAME")
	private String lvCct4Name;

	@Column(name="LV_CCT_4_TYPE")
	private BigDecimal lvCct4Type;

	@Column(name="LV_CCT_5_NAME")
	private String lvCct5Name;

	@Column(name="LV_CCT_5_TYPE")
	private BigDecimal lvCct5Type;

	@Column(name="LV_CRACK_INSULATORS")
	private BigDecimal lvCrackInsulators;

	@Column(name="LV_JUMP_TB_CRIMPED")
	private BigDecimal lvJumpTbCrimped;

	@Column(name="LV_SERVICE_TB_CRIMP")
	private BigDecimal lvServiceTbCrimp;

	@Column(name="LV_SPAN_TB_CRIMPED")
	private BigDecimal lvSpanTbCrimped;

	@Column(name="POLE_ALIGNMENT")
	private BigDecimal poleAlignment;

	@Column(name="POLE_CONDITION")
	private BigDecimal poleCondition;

	private BigDecimal status;

	@Column(name="STAY_REQUIRED")
	private BigDecimal stayRequired;

	private BigDecimal staybad;

	@Column(name="STRUT_BAD")
	private BigDecimal strutBad;

	@Column(name="STRUT_REQUIRED")
	private BigDecimal strutRequired;

	@Column(name="STRUT_STRP")
	private BigDecimal strutStrp;

	public MmsTxntowermaintenancemv() {
	}

	public MmsTxntowermaintenancemvPK getId() {
		return this.id;
	}

	public void setId(MmsTxntowermaintenancemvPK id) {
		this.id = id;
	}

	public BigDecimal getCct11pService() {
		return this.cct11pService;
	}

	public void setCct11pService(BigDecimal cct11pService) {
		this.cct11pService = cct11pService;
	}

	public BigDecimal getCct13pService() {
		return this.cct13pService;
	}

	public void setCct13pService(BigDecimal cct13pService) {
		this.cct13pService = cct13pService;
	}

	public BigDecimal getCct1LvConType() {
		return this.cct1LvConType;
	}

	public void setCct1LvConType(BigDecimal cct1LvConType) {
		this.cct1LvConType = cct1LvConType;
	}

	public BigDecimal getCct21pService() {
		return this.cct21pService;
	}

	public void setCct21pService(BigDecimal cct21pService) {
		this.cct21pService = cct21pService;
	}

	public BigDecimal getCct23pService() {
		return this.cct23pService;
	}

	public void setCct23pService(BigDecimal cct23pService) {
		this.cct23pService = cct23pService;
	}

	public BigDecimal getCct2LvConType() {
		return this.cct2LvConType;
	}

	public void setCct2LvConType(BigDecimal cct2LvConType) {
		this.cct2LvConType = cct2LvConType;
	}

	public BigDecimal getCct31pService() {
		return this.cct31pService;
	}

	public void setCct31pService(BigDecimal cct31pService) {
		this.cct31pService = cct31pService;
	}

	public BigDecimal getCct33pService() {
		return this.cct33pService;
	}

	public void setCct33pService(BigDecimal cct33pService) {
		this.cct33pService = cct33pService;
	}

	public BigDecimal getCct3LvConType() {
		return this.cct3LvConType;
	}

	public void setCct3LvConType(BigDecimal cct3LvConType) {
		this.cct3LvConType = cct3LvConType;
	}

	public BigDecimal getCct41pService() {
		return this.cct41pService;
	}

	public void setCct41pService(BigDecimal cct41pService) {
		this.cct41pService = cct41pService;
	}

	public BigDecimal getCct43pService() {
		return this.cct43pService;
	}

	public void setCct43pService(BigDecimal cct43pService) {
		this.cct43pService = cct43pService;
	}

	public BigDecimal getCct4LvConType() {
		return this.cct4LvConType;
	}

	public void setCct4LvConType(BigDecimal cct4LvConType) {
		this.cct4LvConType = cct4LvConType;
	}

	public BigDecimal getCct5LvConType() {
		return this.cct5LvConType;
	}

	public void setCct5LvConType(BigDecimal cct5LvConType) {
		this.cct5LvConType = cct5LvConType;
	}

	public BigDecimal getEarthDownConductor() {
		return this.earthDownConductor;
	}

	public void setEarthDownConductor(BigDecimal earthDownConductor) {
		this.earthDownConductor = earthDownConductor;
	}

	public BigDecimal getHorizontalEarth() {
		return this.horizontalEarth;
	}

	public void setHorizontalEarth(BigDecimal horizontalEarth) {
		this.horizontalEarth = horizontalEarth;
	}

	public BigDecimal getHvBadInsulators() {
		return this.hvBadInsulators;
	}

	public void setHvBadInsulators(BigDecimal hvBadInsulators) {
		this.hvBadInsulators = hvBadInsulators;
	}

	public BigDecimal getHvBadInsulators2() {
		return this.hvBadInsulators2;
	}

	public void setHvBadInsulators2(BigDecimal hvBadInsulators2) {
		this.hvBadInsulators2 = hvBadInsulators2;
	}

	public BigDecimal getHvJumpTbCrimped() {
		return this.hvJumpTbCrimped;
	}

	public void setHvJumpTbCrimped(BigDecimal hvJumpTbCrimped) {
		this.hvJumpTbCrimped = hvJumpTbCrimped;
	}

	public BigDecimal getHvSpanTbCrimped() {
		return this.hvSpanTbCrimped;
	}

	public void setHvSpanTbCrimped(BigDecimal hvSpanTbCrimped) {
		this.hvSpanTbCrimped = hvSpanTbCrimped;
	}

	public String getLvCct1Name() {
		return this.lvCct1Name;
	}

	public void setLvCct1Name(String lvCct1Name) {
		this.lvCct1Name = lvCct1Name;
	}

	public BigDecimal getLvCct1Type() {
		return this.lvCct1Type;
	}

	public void setLvCct1Type(BigDecimal lvCct1Type) {
		this.lvCct1Type = lvCct1Type;
	}

	public String getLvCct2Name() {
		return this.lvCct2Name;
	}

	public void setLvCct2Name(String lvCct2Name) {
		this.lvCct2Name = lvCct2Name;
	}

	public BigDecimal getLvCct2Type() {
		return this.lvCct2Type;
	}

	public void setLvCct2Type(BigDecimal lvCct2Type) {
		this.lvCct2Type = lvCct2Type;
	}

	public String getLvCct3Name() {
		return this.lvCct3Name;
	}

	public void setLvCct3Name(String lvCct3Name) {
		this.lvCct3Name = lvCct3Name;
	}

	public BigDecimal getLvCct3Type() {
		return this.lvCct3Type;
	}

	public void setLvCct3Type(BigDecimal lvCct3Type) {
		this.lvCct3Type = lvCct3Type;
	}

	public String getLvCct4Name() {
		return this.lvCct4Name;
	}

	public void setLvCct4Name(String lvCct4Name) {
		this.lvCct4Name = lvCct4Name;
	}

	public BigDecimal getLvCct4Type() {
		return this.lvCct4Type;
	}

	public void setLvCct4Type(BigDecimal lvCct4Type) {
		this.lvCct4Type = lvCct4Type;
	}

	public String getLvCct5Name() {
		return this.lvCct5Name;
	}

	public void setLvCct5Name(String lvCct5Name) {
		this.lvCct5Name = lvCct5Name;
	}

	public BigDecimal getLvCct5Type() {
		return this.lvCct5Type;
	}

	public void setLvCct5Type(BigDecimal lvCct5Type) {
		this.lvCct5Type = lvCct5Type;
	}

	public BigDecimal getLvCrackInsulators() {
		return this.lvCrackInsulators;
	}

	public void setLvCrackInsulators(BigDecimal lvCrackInsulators) {
		this.lvCrackInsulators = lvCrackInsulators;
	}

	public BigDecimal getLvJumpTbCrimped() {
		return this.lvJumpTbCrimped;
	}

	public void setLvJumpTbCrimped(BigDecimal lvJumpTbCrimped) {
		this.lvJumpTbCrimped = lvJumpTbCrimped;
	}

	public BigDecimal getLvServiceTbCrimp() {
		return this.lvServiceTbCrimp;
	}

	public void setLvServiceTbCrimp(BigDecimal lvServiceTbCrimp) {
		this.lvServiceTbCrimp = lvServiceTbCrimp;
	}

	public BigDecimal getLvSpanTbCrimped() {
		return this.lvSpanTbCrimped;
	}

	public void setLvSpanTbCrimped(BigDecimal lvSpanTbCrimped) {
		this.lvSpanTbCrimped = lvSpanTbCrimped;
	}

	public BigDecimal getPoleAlignment() {
		return this.poleAlignment;
	}

	public void setPoleAlignment(BigDecimal poleAlignment) {
		this.poleAlignment = poleAlignment;
	}

	public BigDecimal getPoleCondition() {
		return this.poleCondition;
	}

	public void setPoleCondition(BigDecimal poleCondition) {
		this.poleCondition = poleCondition;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getStayRequired() {
		return this.stayRequired;
	}

	public void setStayRequired(BigDecimal stayRequired) {
		this.stayRequired = stayRequired;
	}

	public BigDecimal getStaybad() {
		return this.staybad;
	}

	public void setStaybad(BigDecimal staybad) {
		this.staybad = staybad;
	}

	public BigDecimal getStrutBad() {
		return this.strutBad;
	}

	public void setStrutBad(BigDecimal strutBad) {
		this.strutBad = strutBad;
	}

	public BigDecimal getStrutRequired() {
		return this.strutRequired;
	}

	public void setStrutRequired(BigDecimal strutRequired) {
		this.strutRequired = strutRequired;
	}

	public BigDecimal getStrutStrp() {
		return this.strutStrp;
	}

	public void setStrutStrp(BigDecimal strutStrp) {
		this.strutStrp = strutStrp;
	}

}