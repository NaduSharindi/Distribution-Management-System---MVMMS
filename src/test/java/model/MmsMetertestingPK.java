package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MMS_METERTESTING database table.
 * 
 */
@Embeddable
public class MmsMetertestingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORDER_CARD_ID")
	private String orderCardId;

	@Column(name="TESTING_ID")
	private String testingId;

	public MmsMetertestingPK() {
	}
	public String getOrderCardId() {
		return this.orderCardId;
	}
	public void setOrderCardId(String orderCardId) {
		this.orderCardId = orderCardId;
	}
	public String getTestingId() {
		return this.testingId;
	}
	public void setTestingId(String testingId) {
		this.testingId = testingId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MmsMetertestingPK)) {
			return false;
		}
		MmsMetertestingPK castOther = (MmsMetertestingPK)other;
		return 
			this.orderCardId.equals(castOther.orderCardId)
			&& this.testingId.equals(castOther.testingId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderCardId.hashCode();
		hash = hash * prime + this.testingId.hashCode();
		
		return hash;
	}
}