package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROVINCE_BRANCH_JOBTYPE database table.
 * 
 */
@Entity
@Table(name="PROVINCE_BRANCH_JOBTYPE")
@NamedQuery(name="ProvinceBranchJobtype.findAll", query="SELECT p FROM ProvinceBranchJobtype p")
public class ProvinceBranchJobtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProvinceBranchJobtypePK id;

	@Column(name="ESTIMATE_TYPE")
	private String estimateType;

	private String jobtype;

	public ProvinceBranchJobtype() {
	}

	public ProvinceBranchJobtypePK getId() {
		return this.id;
	}

	public void setId(ProvinceBranchJobtypePK id) {
		this.id = id;
	}

	public String getEstimateType() {
		return this.estimateType;
	}

	public void setEstimateType(String estimateType) {
		this.estimateType = estimateType;
	}

	public String getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

}