package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.EstimateReferenceb;

public interface EstimateReferencebDao {
	public String save(EstimateReferenceb obj);
	public List<EstimateReferenceb> findByEstimateNo(String estimateNo,String costCenter);
}
