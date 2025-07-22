package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.PivDetail;

public interface PivDetailDao {
	
	public List<PivDetail> findByReferenceNo(String referenceNo,String deptId);

}
