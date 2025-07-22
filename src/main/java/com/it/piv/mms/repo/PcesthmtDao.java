package com.it.piv.mms.repo;


import java.math.BigDecimal;
import java.util.List;

import com.it.piv.mms.domain.Pcestdmt;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.domain.Pcesthtt;

public interface PcesthmtDao {
	
	
	public List<Object[]> getApprovalList(String usrLevel);
	public BigDecimal getTotalCOst(String estimateNo,String deptId);
	public Long getApprovalListCount(String usrLevel,String usrName);
	public List<Pcesthmt> getProjectNoByStatus();
	
	public List<Pcesthmt> findByCostCenterEstimateNo(String CostCenter, String EstimateNo);
	public void update(Pcesthmt obj);
	
	public void updatePcesthmt(String CostCenter, String EstimateNo,String newCostCenter );
	public void jobReopen(String CostCenter, String EstimateNo );
	
	public List<Pcesthmt> getJobNoByStatus(String status,String deptId);
	
	public List<Pcesthmt> getApprovalListAENew(String usrLevel,String usrName,String dept_id);
	public List<Pcesthmt> getApprovalListAENewStatus(String usrLevel,String usrName,String dept_id);
	
	
	public Pcesthmt getPcesthmt(String estimateNo,String deptId);
    
	
}
