package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Pcestdmt;
import com.it.piv.mms.domain.PcestdmtPK;
import com.it.piv.mms.domain.Pcesthmt;

public interface PcestdmtDao{
	
	public void save(Pcestdmt obj);
    public Pcestdmt findById(PcestdmtPK pkPcestdmt);
    public List<Pcestdmt> findByCostCenterEstimateNo(String CostCenter, String EstimateNo);
    public void update(Pcestdmt obj);
    public void updatePcestdmt(String costCenter, String estimateNo,String newCostCenter);
    	
	
}
