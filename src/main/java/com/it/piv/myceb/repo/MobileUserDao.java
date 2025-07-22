package com.it.piv.myceb.repo;

import java.util.List;

import com.it.piv.myceb.domain.MobUser;

public interface MobileUserDao {
	public List<MobUser> findById(String id,String password);
	public List<MobUser> findByArea(String area);
	public List<MobUser> findByDeviceId(String devID);
	public List<MobUser> getAll();
	public void updateLonLatForGivenID(String devId,String lat,String lon);

}
