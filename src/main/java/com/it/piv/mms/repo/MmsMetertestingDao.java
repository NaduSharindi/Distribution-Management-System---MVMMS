package com.it.piv.mms.repo;

import com.it.piv.mms.domain.MmsMetertesting;

public interface MmsMetertestingDao {
	
	public String add(MmsMetertesting obj);
	public String update(MmsMetertesting obj);
	public String getNextTestId(String appIdPrefix,String orderID);
}
