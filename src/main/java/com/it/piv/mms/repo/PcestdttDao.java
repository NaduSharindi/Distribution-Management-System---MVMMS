package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.Pcesthtt;

public interface PcestdttDao {
	public void save(Pcestdtt obj);
	public void save(List<Pcestdtt> obj);
	public List<Pcestdtt> getPcestdtt(String estimateNo,String deptId);
	public List<Object[]> getPcestdttNew(String estimateNo,String deptId);
    
	//public String save(List<Pcestdtt> obj);
	

}
