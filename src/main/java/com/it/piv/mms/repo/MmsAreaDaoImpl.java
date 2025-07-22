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

import com.it.piv.mms.domain.MmsArea;

@Transactional
@Repository
public class MmsAreaDaoImpl implements MmsAreaDao{
	
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager; 

	@Override
	public String addArea(MmsArea area) {
		System.out.println("Show_id = " + area.getId());
		System.out.println("Show_Province = " + area.getProvince());
		System.out.println("Show_Area = " + area.getArea());
		
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus status = txManager.getTransaction(def);
	   // def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	  //  try {
	    	em.persist(area);
	  //  } catch (Exception ex) {
	    //	System.out.println(ex);
	      //  txManager.rollback(status);
	   // }
	  //  txManager.commit(status);
	   

	//em.persist(area);
		
		return null;
	}

	@Override
	public List<MmsArea> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsArea> criteria = cb.createQuery(MmsArea.class);
		Root<MmsArea> area = criteria.from(MmsArea.class);
		criteria.select(area).orderBy(cb.asc(area.get("id")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsArea> findActiveAreas() {
		
		TypedQuery<MmsArea> query =null;
		try{
		System.out.print("xxxxxxxxxxxxxx");
		String status = "1";
		/**TypedQuery<MmsArea> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsArea cd "
				+ "WHERE cd.status= :status", MmsArea.class) ;
					 query.setParameter("status","1"); 
					 System.out.print(query +" T "+ query.getResultList().size() );
					return query.getResultList();*/
		
		
		query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsArea cd ", MmsArea.class) ;
					 System.out.print(query +" T "+ query.getResultList().size() );
					
		}catch(Exception e){
			System.out.print(" T "+ e.getMessage() );
		}
		return query.getResultList();
	}

	@Override
	public void updateArea(String id, String province, String area,String status) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus sta = txManager.getTransaction(def);
	    def.setName("SomeTxName");
	    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE MmsArea mp set mp.province =:province,mp.area =:area,mp.status =:status " + " WHERE mp.id = :id");
		    query.setParameter("id", id);
		    query.setParameter("province", province);
		    query.setParameter("area", area);
		    query.setParameter("status", status);
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	        txManager.rollback(sta);
	    }
	    txManager.commit(sta);
		
	}
	
}
