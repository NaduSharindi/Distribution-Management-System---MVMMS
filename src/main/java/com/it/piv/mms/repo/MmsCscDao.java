package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsCsc;

public interface MmsCscDao {
	public String addCsc(MmsCsc csc);
	public List<MmsCsc> findall();
	public List<MmsCsc> findActiveCSC();
	public void updateCSC(String id, String csc,String area,String status);
	
	//public List<Mms>
}
