package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddswitch;
import com.it.piv.mms.domain.MmsAddswitchPK;

public interface MmsAddSwitchDao {
	public String addSwitch(MmsAddswitch addSwitch);
	public String updateSwitch(MmsAddswitch addSwitch);
	public String getNextSwitchId(String appIdPrefix);
	public List<MmsAddswitch> getSwitchData(String switchId);
	public List<MmsAddswitch> getSwitchByFeederId(String feederId,String switchType);
	public List<MmsAddswitch> getSwitchByFeederId(String feederId,String switchType,String status);
	
	public List<MmsAddswitch> getSwitchByGantryId(String gantryId);
	
	public MmsAddswitch findById(MmsAddswitchPK id);
	public List<MmsAddswitch> findSwitchByStatus(String status,String phmBranch);
	public List<MmsAddswitch> findSwitchByswitchTypeStatus(String status,String switchType ,String phmBranch);
	public MmsAddswitch findById(String id);

}
