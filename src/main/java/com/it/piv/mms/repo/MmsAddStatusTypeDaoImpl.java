package com.it.piv.mms.repo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
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

import com.it.piv.mms.domain.MmsAddstatustype;
import com.it.piv.mms.domain.MmsProvince;

@Transactional
@Repository
public class MmsAddStatusTypeDaoImpl implements MmsAddStatusTypeDao{

	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;
	
	@Override
	public String addStatusType(MmsAddstatustype statusType) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	   // def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	   // try {
	    	em.persist(statusType);
	   // } catch (Exception ex) {
	    	//System.out.println(ex);
	        //txManager.rollback(status);
	   // }
	    //txManager.commit(status);
	   

	    //em.persist(statusType);
		return null;
	}

	@Override
	public List<MmsAddstatustype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddstatustype> criteria = cb.createQuery(MmsAddstatustype.class);
		Root<MmsAddstatustype> statusType = criteria.from(MmsAddstatustype.class);
		
		criteria.select(statusType).orderBy(cb.asc(statusType.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}
	
	@Override
	public List<MmsAddstatustype> findActiveStatusTypes() {
	    String status = "1";
		TypedQuery<MmsAddstatustype> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsAddstatustype cd "
				+ "WHERE cd.status= :status", MmsAddstatustype.class) ;
					 query.setParameter("status",status.trim()); 
					 System.out.print(query);
					return query.getResultList();
	}

	//edit anushka 2019-01-01------------------------------------------------------------------------------------------------------
	@Override
	public void updateStatusType(MmsAddstatustype obj) {
		em.merge(obj);		
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------
}
