package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;

public interface PcesthttDao {
	public String save(Pcesthtt htt);
	public String update(Pcesthtt htt);
	
	public List<Object[]> getApprovalList();
	public List<Object[]> getApprovalList(String usrLevel,String usrName);
	public List<Object[]> getApprovalListAE(String usrLevel,String usrName);
	
	public List<Object[]> getApprovalList(String usrLevel,String usrName,String dept_id);
	public List<Pcesthtt> getApprovalListNew(String usrLevel,String usrName,String dept_id);
	public List<Pcesthtt> getApprovalListNewStatus(String usrLevel,String usrName,String dept_id);
	
	public List<Object[]> getApprovalListAE(String usrLevel,String usrName,String dept_id);
	public List<Pcesthtt> getApprovalListAENew(String usrLevel,String usrName,String dept_id);
	public List<Pcesthtt> getApprovalListES(String dept_id,String status);
	public List<Pcesthtt> getApprovalListESSFV(String dept_id,String userName,String status);
	
	public List<Pcesthtt> getAllEstimate(String dept_id,List<String> status);
	
	public Long getApprovalListCount(String usrLevel,String usrName);
	
	public Long getApprovalListCountAE(String usrLevel,String usrName);
	
	
	public List<Object[]> getApprovalListDetail(String usrLevel,String usrName);
	public List<Object[]> getApprovalListDetailAll(String usrLevel,String usrName);
	
	public String approveEstimate(String estimateNo, String deptId,	String authorityLevel, String userName);
    public BigDecimal getTotalCOst(String estimateNo,String deptId);
    
    public Pcesthtt getPcesthtt(String estimateNo,String deptId);
    
    public Pcesthtt getPcesthttForIntialCost(String estimateNo,String deptId);
    
    
    
    public Pcesthtt findById(PcesthttPK pk);
    
    
    public List<Object[]> getApprovalListAllDataSet(String deptId,String status);
    public List<Object[]> getDetailList(String estimateNo,String deptId);
	
	

}
