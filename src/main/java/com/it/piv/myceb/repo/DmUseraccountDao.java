package com.it.piv.myceb.repo;



import java.util.List;

import com.it.piv.myceb.domain.DmUseraccount;
import com.it.piv.myceb.domain.DmUseraccountPK;

public interface DmUseraccountDao {
	public String save(DmUseraccount obj);
	public List<String> getAllAccountNumbersByUserName(String userName);
	public String update(DmUseraccount obj);
	public DmUseraccount findById(DmUseraccountPK obj);
}
