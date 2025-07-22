package com.it.piv.mms.repo;


import com.it.piv.admin.domain.Sauserm;

public interface LoginDao {
	Boolean validateLogin(String userName, String password) throws Exception;
	Boolean validateLoginOMS(String userName, String password) throws Exception;
	Sauserm getSauserm(String userName);
	String getPassword(String userName);
}
