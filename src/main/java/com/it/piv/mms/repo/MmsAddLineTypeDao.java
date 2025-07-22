package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddlinetype;

public interface MmsAddLineTypeDao {
	public String addLineType(MmsAddlinetype lineType);
	public List<MmsAddlinetype> findAll();
	public List<MmsAddlinetype> findActiveTypes();
	
	//edit anushka 2018-12-31---------------------------------------------------------------------------------------------------------------------------
	public void updateLineType (MmsAddlinetype obj);
	//--------------------------------------------------------------------------------------------------------------------------------------------------
}
