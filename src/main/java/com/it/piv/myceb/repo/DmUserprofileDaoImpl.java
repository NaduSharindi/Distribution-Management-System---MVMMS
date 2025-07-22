package com.it.piv.myceb.repo;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.myceb.domain.DmUserprofile;

@Transactional
@Repository
public class DmUserprofileDaoImpl implements DmUserprofileDao  {
	
	@Autowired
	private EntityManager em;

	@Override
	public String findByUser(String user, String passwd) {
		try {
			String qryStr = "select a from DmUserprofile a where a.uesrname=:user  and a.userpwd=:passwd";
			Query query = em.createQuery(qryStr);
			query.setParameter("user",user);
			query.setParameter("passwd",passwd);
			
			DmUserprofile obj= (DmUserprofile)query.getResultList().get(0);
			System.out.println("obj : "+ obj);
			//return list.get(0);
			if(obj!=null){
				return "Y";
			}else{
				return "N";
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return "N";
		}
		
	}

	@Override
	public String save(DmUserprofile obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}

	@Override
	public String update(DmUserprofile obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return null;
	}
}
