package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Spstdesthmt;
import com.it.piv.mms.domain.SpstdesthmtPK;

public interface SpstdesthmtDao {
	
	public List<Object[]> getApprovalList(String usrName,String usrLevel);
	public List<Spstdesthmt> getApprovalListSPS(String usrName,String usrLevel);
	public List<Spstdesthmt> getEstimateList(String deptId);
	public List<Spstdesthmt> getEstimateList(String deptId,String status);
	
	public Long getApprovalListCount(String usrName,String usrLevel);
	public List<Object[]> getApprovalDetailList(String usrName,String usrLevel,String type);
	public Spstdesthmt findById(SpstdesthmtPK pk);
	public Spstdesthmt selectStdNoDeptId(String appNo,String deptid);
	
	public void update(Spstdesthmt pk);

	public List<Object[]> getApprovalDetailListDmt(String appNo,String deptId);
	public List<Object[]> getApprovalListDetail(String appNO,String deptId);


}
