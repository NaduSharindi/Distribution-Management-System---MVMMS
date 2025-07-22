package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Spnorm;

public interface SpnormDao {
	public String saveForm(Spnorm spnorm);
	public List<Spnorm> findAll();
	public void updateSPNORM (String linesectiontypeid,String uom,double standardcost,String description,String lineparentid);

}
