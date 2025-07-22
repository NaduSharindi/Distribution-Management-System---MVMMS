package com.it.piv.issue.repo;

import com.it.piv.issue.domain.Pcmilesumary;
import com.it.piv.issue.domain.PcmilesumaryPK;


public interface PcmilesumaryDao {
	
	public void add(Pcmilesumary progress);
	public void update(Pcmilesumary progress);
	public void findByID(PcmilesumaryPK pk);
	

}
