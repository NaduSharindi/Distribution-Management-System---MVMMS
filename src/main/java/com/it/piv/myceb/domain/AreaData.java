package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AREA_DATA database table.
 * 
 */
@Entity
@Table(name="AREA_DATA")
@NamedQuery(name="AreaData.findAll", query="SELECT a FROM AreaData a")
public class AreaData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_DATA_ID_GENERATOR", sequenceName="CUSTOMER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_DATA_ID_GENERATOR")
	private long id;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Column(name="AREA_NAME")
	private String areaName;

	@Column(name="BILL_CYCLE")
	private BigDecimal billCycle;

	@Column(name="PROV_CODE")
	private String provCode;

	private String region;

	public AreaData() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public BigDecimal getBillCycle() {
		return this.billCycle;
	}

	public void setBillCycle(BigDecimal billCycle) {
		this.billCycle = billCycle;
	}

	public String getProvCode() {
		return this.provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}