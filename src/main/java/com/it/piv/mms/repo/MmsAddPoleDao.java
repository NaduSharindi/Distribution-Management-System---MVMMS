package com.it.piv.mms.repo;

import java.util.List;
import com.it.piv.mms.domain.MmsAddpole;


public interface MmsAddPoleDao {
	
	public String addPole(MmsAddpole addPole);
	
	public List<MmsAddpole> findAll();
	public List<MmsAddpole> findPoleByAreaEdit(String area,String status);
	public MmsAddpole findById(long id);
	public String update(MmsAddpole addPole);
	public List<MmsAddpole> findLVPoleByStatus(String status,String phmBranch);
	public List<MmsAddpole> getPoleByArea(String area);

    

}
