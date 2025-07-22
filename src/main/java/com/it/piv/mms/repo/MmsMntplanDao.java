package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsMntplan;

public interface MmsMntplanDao {
	
	public String save(MmsMntplan obj);
	public List<MmsMntplan> getActiveList(String year,String deptId);


}
