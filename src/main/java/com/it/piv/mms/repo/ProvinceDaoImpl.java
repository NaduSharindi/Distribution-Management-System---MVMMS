package com.it.piv.mms.repo;

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

import com.it.piv.mms.domain.MmsProvince;

@Transactional
@Repository
public class ProvinceDaoImpl implements ProvinceDao{
	
	@Autowired
	private EntityManager em;
	//@Resource
	//private PlatformTransactionManager txManager; 

	@Override
	public String addProvince(MmsProvince province) {
		
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus status = txManager.getTransaction(def);
	  //  def.setName("SomeTxName");
	  //  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	  //  try {
	    	em.persist(province);
	   // } catch (Exception ex) {
	    	//System.out.println(ex);
	      //  txManager.rollback(status);
	   // }
	 //   txManager.commit(status);
	   

	//em.persist(province);
		
		return null;
	}

	@Override
	public List<MmsProvince> findAll() {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsProvince> criteria = cb.createQuery(MmsProvince.class);
		Root<MmsProvince> province = criteria.from(MmsProvince.class);
		
		criteria.select(province).orderBy(cb.asc(province.get("id")));
		
		return em.createQuery(criteria).getResultList();
		//return null;
	}
	
	
	
	@Override
	public List<MmsProvince> findActiveProvince() {
	    String status = "1";
		TypedQuery<MmsProvince> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsProvince cd "
				+ "WHERE cd.status= :status", MmsProvince.class) ;
					 query.setParameter("status",status.trim()); 
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public void updateProvince(String province,String id,String status) {
	//	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	  //  TransactionStatus sta = txManager.getTransaction(def);
	  //  def.setName("SomeTxName");
	  //  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE MmsProvince mp set mp.province =:province,mp.status =:status " + " WHERE mp.id = :id");
		    query.setParameter("id", id);
		    query.setParameter("province", province);
		    query.setParameter("status", status);
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	        //txManager.rollback(sta);
	    }
	    //txManager.commit(sta);
		
	}
}
