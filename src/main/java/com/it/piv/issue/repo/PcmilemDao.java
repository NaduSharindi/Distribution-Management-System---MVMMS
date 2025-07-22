package com.it.piv.issue.repo;

import com.it.piv.issue.domain.Pcmiledate;
import com.it.piv.mms.domain.Pcmilem;
import com.it.piv.mms.domain.PcmilemPK;


public interface PcmilemDao {
	
	public void add(Pcmilem progress);
	public void update(Pcmilem progress);
	public void findByID(PcmilemPK pk);
	public Pcmiledate findByPercentage(String percentage,String deptId);
	

}
