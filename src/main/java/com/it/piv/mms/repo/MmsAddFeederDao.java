package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddfeeder;

public interface MmsAddFeederDao {
	public String addFeeder(MmsAddfeeder addFeeder);
	public String getNextFeerderId(String appIdPrefix);
	public List<MmsAddfeeder> getFeederByGantryId(String gantryId);
	public List<MmsAddfeeder> getFeederByGantryIdType(String gantryId,String Type);
	
	
	
	public List<MmsAddfeeder> getFeederByGantryId(String gantryId,String status);
	
	public List<Object[]> getFeederByGantryIdNew(String gantryId);
    
    public List<MmsAddfeeder> getFeederData(String feederId);
    public MmsAddfeeder getFeederByFeederId(String feederId);
    public MmsAddfeeder findById(String id);
    public String updateFeeder(MmsAddfeeder addFeeder);
    public List<MmsAddfeeder> findFeederByStatus(String status, String phmBranch);
    
    public List<MmsAddfeeder> getFeederByArea(String area);
	

	

}
