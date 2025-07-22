package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsCompletion;
import com.it.piv.mms.domain.MmsCompletionPK;

@Transactional
@Repository
public class MmsCompletionDaoImpl implements MmsCompletionDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public String add(MmsCompletion addLine) {
		// TODO Auto-generated method stub
		em.persist(addLine);
		return null;
	}

	@Override
	public String update(MmsCompletion addLine) {
		// TODO Auto-generated method stub
		try {
			em.merge(addLine);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MmsCompletion findById(MmsCompletionPK comPK) {
		// TODO Auto-generated method stub
		return em.find(MmsCompletion.class, comPK);
		
	}

	@Override
	public List<MmsCompletion> findByAreaCycle(String area, String cycle) {
		try {
			String qryStr = "SELECT s FROM MmsCompletion s WHERE s.area =:area and s.id.cycle=:cycle";
			Query query = em.createQuery(qryStr);
			query.setParameter("cycle", cycle);
			query.setParameter("area", area);
			
			//query.setParameter("appType", appType);
			
			//query.setParameter("approvedBy", userid);
			
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("getPendingReq 1" + e.getMessage());
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;}

	

		
}