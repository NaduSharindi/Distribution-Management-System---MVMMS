package com.it.piv.myceb.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.myceb.domain.DmUseraccount;
import com.it.piv.myceb.domain.DmUseraccountPK;

@Transactional
@Repository
public class DmUseraccountDaoImpl implements DmUseraccountDao  {
	
	@Autowired
	private EntityManager em;

	@Override
	public String save(DmUseraccount obj) {
		em.persist(obj);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllAccountNumbersByUserName(String userName) {
		// TODO Auto-generated method stub
		try {
			String qryStr = "select a.id.acctnumber from DmUseraccount a where a.id.username =:userName";
			Query query = em.createQuery(qryStr);
			query.setParameter("userName",userName);
			
			List<String> list = query.getResultList();
			System.out.println("list : "+ list);
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String update(DmUseraccount obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return null;
	}

	@Override
	public DmUseraccount findById(DmUseraccountPK id) {
		return em.find(DmUseraccount.class, id);
		
	}

}
