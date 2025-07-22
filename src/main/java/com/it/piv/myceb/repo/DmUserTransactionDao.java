package com.it.piv.myceb.repo;

import com.it.piv.myceb.domain.DmUseraccount;
import com.it.piv.myceb.domain.DmUserprofile;

public interface DmUserTransactionDao {
	public String save(DmUseraccount obj,DmUserprofile objPro);
	public String update(DmUseraccount obj,DmUserprofile objPro);	

}
