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

import com.it.piv.mms.domain.MmsCsc;

@Transactional
@Repository
public class MmsCscDaoImpl implements MmsCscDao{
	
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager; 

	@Override
	public String addCsc(MmsCsc csc) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	  //  try {
	    	em.persist(csc);
	  //  } catch (Exception ex) {
	    	//System.out.println(ex);
	      //  txManager.rollback(status);
	   // }
	  //  txManager.commit(status);
	   
	//em.persist(csc);
		return null;
	}

	@Override
	public List<MmsCsc> findall() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsCsc> criteria = cb.createQuery(MmsCsc.class);
		Root<MmsCsc> csc = criteria.from(MmsCsc.class);
		
		criteria.select(csc).orderBy(cb.asc(csc.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsCsc> findActiveCSC() {
		String status = "1";
		TypedQuery<MmsCsc> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsCsc cd "
				+ "WHERE cd.status= :status", MmsCsc.class) ;
					 query.setParameter("status",status.trim()); 
					 System.out.print(query);
					return query.getResultList();
	}

	@Override
	public void updateCSC(String id, String csc, String area,String status) {
	//	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	 //   TransactionStatus sta = txManager.getTransaction(def);
	  //  def.setName("SomeTxName");
	  //  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE MmsCsc mp set mp.csc =:csc,mp.area =:area,mp.status =:status " + " WHERE mp.id = :id");
		    query.setParameter("id", id);
		    query.setParameter("csc", csc);
		    query.setParameter("area", area);
		    query.setParameter("status", status);
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	       // txManager.rollback(sta);
	    }
	   // txManager.commit(sta);
		
	}

}
