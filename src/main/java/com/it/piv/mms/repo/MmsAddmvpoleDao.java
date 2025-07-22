package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddmvpole;


public interface MmsAddmvpoleDao {
	public String addPole(MmsAddmvpole addPole);
	public String update(MmsAddmvpole addPole);
    
	public List<MmsAddmvpole> getPoleByAreaFeeder(String area,String feeder);
	public MmsAddmvpole findById(long id);
	public MmsAddmvpole findByPoleNo(String poleNo);
	
	public List<MmsAddmvpole> findMVPoleByStatus(String status,String phmBranch);
	public MmsAddmvpole findById(String id);
	public List<MmsAddmvpole> getMvPoleByFeederId(String feederId);
	public List<MmsAddmvpole> getMvPoleByArea(String area);
	public List<Object[]> findMVPoleByPoleClass();
	
    
}
