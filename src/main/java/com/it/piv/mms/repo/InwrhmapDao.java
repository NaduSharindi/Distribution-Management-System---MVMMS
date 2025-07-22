package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Inmatm;

public interface InwrhmapDao {
	
	public List<Object[]> getWareHouse(String dept_id);
	public List<Object[]> getWareHouseDetails(String dept_id);
	public List<Inmatm> getIsulatorList(String dept_id);
		
	

}
