package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROVINCE_BRANCH database table.
 * 
 */
@Entity
@Table(name="PROVINCE_BRANCH")
@NamedQuery(name="ProvinceBranch.findAll", query="SELECT p FROM ProvinceBranch p")
public class ProvinceBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProvinceBranchPK id;

	@Column(name="BRNACH_NAME")
	private String brnachName;

	@Column(name="COMMERCIAL_ID")
	private String commercialId;

	@Column(name="PARENT_ID")
	private String parentId;

	public ProvinceBranch() {
	}

	public ProvinceBranchPK getId() {
		return this.id;
	}

	public void setId(ProvinceBranchPK id) {
		this.id = id;
	}

	public String getBrnachName() {
		return this.brnachName;
	}

	public void setBrnachName(String brnachName) {
		this.brnachName = brnachName;
	}

	public String getCommercialId() {
		return this.commercialId;
	}

	public void setCommercialId(String commercialId) {
		this.commercialId = commercialId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}