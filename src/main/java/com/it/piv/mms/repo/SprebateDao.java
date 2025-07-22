package com.it.piv.mms.repo;

import com.it.piv.mms.domain.Sprebate;
import com.it.piv.mms.domain.SprebatePK;

public interface SprebateDao {
	
	public Sprebate findById(SprebatePK pk);

}
