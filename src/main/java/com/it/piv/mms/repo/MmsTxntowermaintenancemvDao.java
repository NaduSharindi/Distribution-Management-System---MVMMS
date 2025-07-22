package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsTxntowermaintenancemv;
import com.it.piv.mms.domain.MmsTxntowermaintenancemvPK;


public interface MmsTxntowermaintenancemvDao {
	public String addTowerMaintananceData(MmsTxntowermaintenancemv towermaintenance);
	public String update(MmsTxntowermaintenancemv towermaintenance);
	public MmsTxntowermaintenancemv findById(MmsTxntowermaintenancemvPK towermaintenance);
	

}
