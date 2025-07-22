package com.it.piv.mms.repo;

import java.util.List;



import com.it.piv.mms.domain.MmsTowertype;


public interface MsttowertypeDao {
	
	public String addTowerTypw(MmsTowertype towerType);
	public List<MmsTowertype> findAll();
	
}
