package com.it.piv.mms.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


/**
 * The persistent class for the PCB_CONDITION database table.
 * 
 */
@Entity
@Table(name="PCB_CONDITION")
@NamedQuery(name="PcbCondition.findAll", query="SELECT p FROM PcbCondition p")
public class PcbCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIPMENT_ID")
	private String equipmentId;

	@Column(name="BREATHER_IS_GOOD_CONNECTION")
	private String breatherIsGoodConnection;

	@Column(name="BURN_MASK")
	private String burnMask;

	private String corrosion;

	@Column(name="EARTH_CONNECTION")
	private String earthConnection;
	
	@Column(name="ENTERED_DATE")
	private Date enteredDate;

	@Column(name="LIGHTING_ARRESTERS_DONE")
	private String lightingArrestersDone;

	@Column(name="OIL_LEAKS_PRESENT")
	private String oilLeaksPresent;

	@Column(name="OVERLOAD_PRESENT")
	private String overloadPresent;

	@Column(name="TERMINAL_ATTENTION")
	private String terminalAttention;
	
	
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public PcbCondition() {
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getBreatherIsGoodConnection() {
		return this.breatherIsGoodConnection;
	}

	public void setBreatherIsGoodConnection(String breatherIsGoodConnection) {
		this.breatherIsGoodConnection = breatherIsGoodConnection;
	}

	public String getBurnMask() {
		return this.burnMask;
	}

	public void setBurnMask(String burnMask) {
		this.burnMask = burnMask;
	}

	public String getCorrosion() {
		return this.corrosion;
	}

	public void setCorrosion(String corrosion) {
		this.corrosion = corrosion;
	}

	public String getEarthConnection() {
		return this.earthConnection;
	}

	public void setEarthConnection(String earthConnection) {
		this.earthConnection = earthConnection;
	}

	public String getLightingArrestersDone() {
		return this.lightingArrestersDone;
	}

	public void setLightingArrestersDone(String lightingArrestersDone) {
		this.lightingArrestersDone = lightingArrestersDone;
	}

	public String getOilLeaksPresent() {
		return this.oilLeaksPresent;
	}

	public void setOilLeaksPresent(String oilLeaksPresent) {
		this.oilLeaksPresent = oilLeaksPresent;
	}

	public String getOverloadPresent() {
		return this.overloadPresent;
	}

	public void setOverloadPresent(String overloadPresent) {
		this.overloadPresent = overloadPresent;
	}

	public String getTerminalAttention() {
		return this.terminalAttention;
	}

	public void setTerminalAttention(String terminalAttention) {
		this.terminalAttention = terminalAttention;
	}

	@Override
	public String toString() {
		return "PcbCondition [equipmentId=" + equipmentId
				+ ", breatherIsGoodConnection=" + breatherIsGoodConnection
				+ ", burnMask=" + burnMask + ", corrosion=" + corrosion
				+ ", earthConnection=" + earthConnection + ", enteredDate="
				+ enteredDate + ", lightingArrestersDone="
				+ lightingArrestersDone + ", oilLeaksPresent="
				+ oilLeaksPresent + ", overloadPresent=" + overloadPresent
				+ ", terminalAttention=" + terminalAttention + ", updatedDate="
				+ updatedDate + "]";
	}
	
	

}