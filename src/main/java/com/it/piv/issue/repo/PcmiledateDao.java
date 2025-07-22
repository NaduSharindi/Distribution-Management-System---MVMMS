package com.it.piv.issue.repo;

import com.it.piv.issue.domain.Pcmiledate;
import com.it.piv.issue.domain.PcmiledatePK;


public interface PcmiledateDao   {
	
	public void add(Pcmiledate progress);
	public void update(Pcmiledate progress);
	public void findByID(PcmiledatePK pk);
	

}
