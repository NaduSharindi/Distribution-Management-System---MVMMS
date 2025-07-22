package com.it.piv.myceb.repo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.it.piv.myceb.domain.JobAssign;
import com.it.piv.myceb.domain.JobStatusOmsNew;
import com.it.piv.myceb.domain.MobUser;

@Repository
@Transactional
public class MobileUserDaoImpl implements MobileUserDao {
	@Autowired
	private EntityManager em;
	
	
	@Override
	public List<MobUser> findById(String id, String password) {
		// TODO Auto-generated method stub
		TypedQuery<MobUser> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MobUser cd "
				+ "WHERE cd.accessCode= :accessCode and cd.password= :password ", MobUser.class) ;
					   
					 query.setParameter("accessCode", id); 
					 query.setParameter("password",password); 
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public List<MobUser> findByArea(String area) {
		// TODO Auto-generated method stub
		TypedQuery<MobUser> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MobUser cd "
				+ "WHERE cd.ccCode= :areaCode ", MobUser.class) ;
					   
					 query.setParameter("areaCode", area); 
					
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public List<MobUser> findByDeviceId(String devID) {
		// TODO Auto-generated method stub
		TypedQuery<MobUser> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MobUser cd "
				+ "WHERE cd.deviceId= :deviceId ", MobUser.class) ;
					   
					 query.setParameter("deviceId", devID); 
					
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public List<MobUser> getAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MobUser> criteria = cb.createQuery(MobUser.class);
		Root<MobUser> location = criteria.from(MobUser.class);

		criteria.select(location).orderBy(cb.asc(location.get("accessCode")));
		return em.createQuery(criteria).getResultList();
	}


	@Override
	public void updateLonLatForGivenID(String devId,String lat,String lon) {
		// TODO Auto-generated method stub
		 try {
	    	Query  query = em.createQuery("UPDATE MobUser b set b.locationLat =:locationLat ,set b.locationLon =:locationLon  " + " WHERE b.deviceId = :deviceId");
		    query.setParameter("locationLat", lat);
		    query.setParameter("locationLon", lon);
		    query.setParameter("deviceId", devId);
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	       
	    }
	   
		
	}

}
