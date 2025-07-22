package com.it.piv.myceb.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.it.piv.myceb.domain.LocationUpdate;

@Repository
@Transactional
public class LocationUpdateDaoImpl implements LocationUpdateDao  {
	
	
		@Autowired
		private EntityManager em;

		@Override
		public LocationUpdate findById(String id) {
			// TODO Auto-generated method stub
			return em.find(LocationUpdate.class, id);
		}

		@Override
		public List<LocationUpdate> getAll() {
			try {
	        	String qryStr = "select a from LocationUpdate a";
	        	Query query = em.createQuery(qryStr);
				return query.getResultList();
		    	
	        } catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

		
		
		

}
