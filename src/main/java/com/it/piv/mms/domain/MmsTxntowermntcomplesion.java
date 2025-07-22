package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_TXNTOWERMNTCOMPLESION database table.
 * 
 */
@Entity
@Table(name="MMS_TXNTOWERMNTCOMPLESION")
@NamedQuery(name="MmsTxntowermntcomplesion.findAll", query="SELECT m FROM MmsTxntowermntcomplesion m")
public class MmsTxntowermntcomplesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsTxntowermntcomplesionPK id;

	private String anticlimbingstatus;

	@Column(name="APPROVAL_LEVEL")
	private String approvalLevel;

	private String attentionstatus;

	private String baseconcretestatus;

	private String comments;

	private String conductorstatus;

	@Column(name="\"CYCLE\"")
	private String cycle;

	private String earthconductorstatus;

	private BigDecimal endfittingset;

	private String flashoversetno;

	private BigDecimal fungussetno;

	@Column(name="HOT_LINE_MNT")
	private String hotLineMnt;

	private BigDecimal hotpossible;

	@Temporal(TemporalType.DATE)
	@Column(name="INS_DATE")
	private Date insDate;

	private String jumperstatus;

	@Column(name="LEG_PAINTING")
	private String legPainting;

	@Temporal(TemporalType.DATE)
	private Date ludt;

	@Temporal(TemporalType.DATE)
	private Date maintenancedate;

	private BigDecimal nofflashoversets;

	private BigDecimal noofmissingparts;

	private BigDecimal nooftappings;

	private BigDecimal pinpole1;

	private BigDecimal pinpole2;

	private BigDecimal pinpole3;

	private BigDecimal status;

	private String switchdev1;

	private String switchdev2;

	private String switchdev3;

	private String towerspecial;

	private String wayleavestatus;

	private BigDecimal wpinset;
	
	@Column(name="PHM_BRANCH")
	private String phmBranch;


	public MmsTxntowermntcomplesion() {
	}

	public MmsTxntowermntcomplesionPK getId() {
		return this.id;
	}

	public void setId(MmsTxntowermntcomplesionPK id) {
		this.id = id;
	}
	
	
	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}



	public String getAnticlimbingstatus() {
		return this.anticlimbingstatus;
	}

	public void setAnticlimbingstatus(String anticlimbingstatus) {
		this.anticlimbingstatus = anticlimbingstatus;
	}

	public String getApprovalLevel() {
		return this.approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getAttentionstatus() {
		return this.attentionstatus;
	}

	public void setAttentionstatus(String attentionstatus) {
		this.attentionstatus = attentionstatus;
	}

	public String getBaseconcretestatus() {
		return this.baseconcretestatus;
	}

	public void setBaseconcretestatus(String baseconcretestatus) {
		this.baseconcretestatus = baseconcretestatus;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getConductorstatus() {
		return this.conductorstatus;
	}

	public void setConductorstatus(String conductorstatus) {
		this.conductorstatus = conductorstatus;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getEarthconductorstatus() {
		return this.earthconductorstatus;
	}

	public void setEarthconductorstatus(String earthconductorstatus) {
		this.earthconductorstatus = earthconductorstatus;
	}

	public BigDecimal getEndfittingset() {
		return this.endfittingset;
	}

	public void setEndfittingset(BigDecimal endfittingset) {
		this.endfittingset = endfittingset;
	}

	public String getFlashoversetno() {
		return this.flashoversetno;
	}

	public void setFlashoversetno(String flashoversetno) {
		this.flashoversetno = flashoversetno;
	}

	public BigDecimal getFungussetno() {
		return this.fungussetno;
	}

	public void setFungussetno(BigDecimal fungussetno) {
		this.fungussetno = fungussetno;
	}

	public String getHotLineMnt() {
		return this.hotLineMnt;
	}

	public void setHotLineMnt(String hotLineMnt) {
		this.hotLineMnt = hotLineMnt;
	}

	public BigDecimal getHotpossible() {
		return this.hotpossible;
	}

	public void setHotpossible(BigDecimal hotpossible) {
		this.hotpossible = hotpossible;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getJumperstatus() {
		return this.jumperstatus;
	}

	public void setJumperstatus(String jumperstatus) {
		this.jumperstatus = jumperstatus;
	}

	public String getLegPainting() {
		return this.legPainting;
	}

	public void setLegPainting(String legPainting) {
		this.legPainting = legPainting;
	}

	public Date getLudt() {
		return this.ludt;
	}

	public void setLudt(Date ludt) {
		this.ludt = ludt;
	}

	public Date getMaintenancedate() {
		return this.maintenancedate;
	}

	public void setMaintenancedate(Date maintenancedate) {
		this.maintenancedate = maintenancedate;
	}

	public BigDecimal getNofflashoversets() {
		return this.nofflashoversets;
	}

	public void setNofflashoversets(BigDecimal nofflashoversets) {
		this.nofflashoversets = nofflashoversets;
	}

	public BigDecimal getNoofmissingparts() {
		return this.noofmissingparts;
	}

	public void setNoofmissingparts(BigDecimal noofmissingparts) {
		this.noofmissingparts = noofmissingparts;
	}

	public BigDecimal getNooftappings() {
		return this.nooftappings;
	}

	public void setNooftappings(BigDecimal nooftappings) {
		this.nooftappings = nooftappings;
	}

	public BigDecimal getPinpole1() {
		return this.pinpole1;
	}

	public void setPinpole1(BigDecimal pinpole1) {
		this.pinpole1 = pinpole1;
	}

	public BigDecimal getPinpole2() {
		return this.pinpole2;
	}

	public void setPinpole2(BigDecimal pinpole2) {
		this.pinpole2 = pinpole2;
	}

	public BigDecimal getPinpole3() {
		return this.pinpole3;
	}

	public void setPinpole3(BigDecimal pinpole3) {
		this.pinpole3 = pinpole3;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getSwitchdev1() {
		return this.switchdev1;
	}

	public void setSwitchdev1(String switchdev1) {
		this.switchdev1 = switchdev1;
	}

	public String getSwitchdev2() {
		return this.switchdev2;
	}

	public void setSwitchdev2(String switchdev2) {
		this.switchdev2 = switchdev2;
	}

	public String getSwitchdev3() {
		return this.switchdev3;
	}

	public void setSwitchdev3(String switchdev3) {
		this.switchdev3 = switchdev3;
	}

	public String getTowerspecial() {
		return this.towerspecial;
	}

	public void setTowerspecial(String towerspecial) {
		this.towerspecial = towerspecial;
	}

	public String getWayleavestatus() {
		return this.wayleavestatus;
	}

	public void setWayleavestatus(String wayleavestatus) {
		this.wayleavestatus = wayleavestatus;
	}

	public BigDecimal getWpinset() {
		return this.wpinset;
	}

	public void setWpinset(BigDecimal wpinset) {
		this.wpinset = wpinset;
	}

}