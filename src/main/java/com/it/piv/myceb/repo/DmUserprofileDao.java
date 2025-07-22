package com.it.piv.myceb.repo;

import com.it.piv.myceb.domain.DmUserprofile;

public interface DmUserprofileDao {
	
	public String findByUser(String user,String passwd);
	public String save(DmUserprofile obj);
	public String update(DmUserprofile obj);
}
