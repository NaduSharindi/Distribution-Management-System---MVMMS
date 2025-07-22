package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.TrippingData;

@Transactional
@Repository
public class TrippingDataDaoImpl implements TrippingDataDao{
	@Autowired
	private EntityManager em;

	@Override
	public void save(TrippingData obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
	}

	@Override
	public void update(TrippingData obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
	}

	@Override
	public List<TrippingData> findAll() {
		 try {
			 	String qryStr = "select a from TrippingData a WHERE a.toStatus = 2 ORDER BY a.trippingDate  ";
			 	Query  query = em.createQuery(qryStr);
			 	return query.getResultList();
		     }catch (Exception ex) {
		     	System.out.println("TrippingData : " +ex);
		 }
		 return null;
	}

	
	@Override
	public List<Object[]> findAllTrippingDataByLine(String lineID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inactiveRecord(String id) {
		try {
	    	Query  query = em.createQuery("UPDATE TrippingData mp set mp.toStatus =3" + " WHERE mp.trippingId =:id");
		    query.setParameter("id", new Long(id));
		    query.executeUpdate();
	    } catch (Exception ex) {
	    	System.out.println("TrippingData : " +ex);
	    }
		
	}


}
