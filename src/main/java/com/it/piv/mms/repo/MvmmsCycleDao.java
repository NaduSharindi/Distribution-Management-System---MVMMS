package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MvmmsCycle;



public interface MvmmsCycleDao {
	public void addCycle(MvmmsCycle cycle);
	public void update(MvmmsCycle cycle);
	public List<MvmmsCycle> findAllCycle(String dept_id);
	public List<MvmmsCycle> findAllCycle();
	public List<MvmmsCycle> findAllActiveCycle(String dept_id);
	public String findLatestCycle();
	public List<Long> findAllActiveCycleString();
	public List<Long>  fineMntAvailCycle(String area);
	
		
	
}
