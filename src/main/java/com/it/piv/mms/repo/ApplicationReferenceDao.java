package com.it.piv.mms.repo;

import com.it.piv.mms.domain.ApplicationReference;

public interface ApplicationReferenceDao {
	public String save(ApplicationReference apObj);
	public String getNextApplicationNo(String applicationNoPrefix);
}
