package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_COMPLETION database table.
 * 
 */
@Embeddable
public class MmsCompletionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long lineid;

	@Column(name="\"CYCLE\"")
	private String cycle;

	public MmsCompletionPK() {
	}
	public long getLineid() {
		return this.lineid;
	}
	public void setLineid(long lineid) {
		this.lineid = lineid;
	}
	public String getCycle() {
		return this.cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsCompletionPK)) {
			return false;
		}
		MmsCompletionPK castOther = (MmsCompletionPK)other;
		return 
			(this.lineid == castOther.lineid)
			&& this.cycle.equals(castOther.cycle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.lineid ^ (this.lineid >>> 32)));
		hash = hash * prime + this.cycle.hashCode();
		
		return hash;
	}
}