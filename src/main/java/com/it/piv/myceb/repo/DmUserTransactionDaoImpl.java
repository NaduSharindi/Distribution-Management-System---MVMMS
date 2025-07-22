package com.it.piv.myceb.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.myceb.domain.DmUseraccount;
import com.it.piv.myceb.domain.DmUserprofile;

@Transactional
@Repository
public class DmUserTransactionDaoImpl implements DmUserTransactionDao  {
	
	@Autowired
	private EntityManager em;
	@Autowired
	private DmUseraccountDao userDao;
	@Autowired
	private DmUserprofileDao userProDao;
	

	@Override
	public String save(DmUseraccount obj,DmUserprofile objPro) {
	     userDao.save(obj);
	     userProDao.save(objPro);
		 // TODO Auto-generated method stub
		 return "Y";
	}
	public String update(DmUseraccount obj,DmUserprofile objPro) {
	     userDao.update(obj);
	     userProDao.update(objPro);
		 // TODO Auto-generated method stub
		 return "Y";
	}


}
