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

import com.it.piv.myceb.domain.CusData;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public String findByAccountNo(String acctNumber) {
		String result="N";
		try {
			
        	String qryStr = "select a  from CusData a where a.acctNumber = :acctNumber";
        	System.out.println(qryStr + acctNumber);
        	Query query = em.createQuery(qryStr);
			query.setParameter("acctNumber", acctNumber);
			String lineId ="";
			List<String> list=query.getResultList();
			if(list != null){
				if (list.size()> 0){
					result ="Y";
		    		
		    	}
			}
	    	
			
        } catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return result;
	}
	
	@Override
	public CusData findById(String id) {
		// TODO Auto-generated method stub
		return em.find(CusData.class, id);
	}

	
	@Override
	@Transactional
	public String addCustomer(CusData customer) {
		// TODO Auto-generated method stub
		//entityManager.getTransaction().begin();
		//entityManager.persist(customer);
		//entityManager.getTransaction().commit();
		
		 try {
	    	em.persist(customer);
	    } catch (Exception ex) {
	       
	    }
	    
	   
		return customer.getAcctNumber();
		
		
		/**entityManager.persist(customer);
		return customer.getAcctNumber();*/
	}

	@Override
	public List<CusData> getAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CusData> criteria = cb.createQuery(CusData.class);
		Root<CusData> location = criteria.from(CusData.class);

		criteria.select(location).orderBy(cb.asc(location.get("idNo")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void updateCustomer(CusData customer) {
		// TODO Auto-generated method stub
		em.merge(customer);
	}

	@Override
	public List<CusData> findByAccNo(String accNo) {
		// TODO Auto-generated method stub
		TypedQuery<CusData> query =
				em.createQuery
				("SELECT cd "
				+ "FROM CusData cd "
				+ "WHERE cd.acctNumber= :acctNumber", CusData.class) ;
					   
					 query.setParameter("acctNumber", accNo); 
					 
					 
					return query.getResultList();
					
					
	}

	@Override
	public CusData findByIdNo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAreaCodeByAccNo(String accNo) {
		/*TypedQuery<CusData> query =
				em.createQuery
				("SELECT cd.areaCode "
				+ "FROM CusData cd "
				+ "WHERE cd.acctNumber= :acctNumber", CusData.class) ;
					   
					 query.setParameter("acctNumber", accNo); 
					 
					 
					return (String)query.getResultList().get(0);
					*/
					try {
			        	String qryStr = "SELECT cd.areaCode FROM CusData cd WHERE cd.acctNumber= :acctNumber";
			        	System.out.println(qryStr + accNo);
			        	Query query = em.createQuery(qryStr);
						query.setParameter("acctNumber", accNo);
						String areaCode ="";
						List<String> list=query.getResultList();
				    	if (list.size()!=0){
				    		areaCode=query.getResultList().get(0).toString().trim();
				    		System.out.println(areaCode);
				    		
				    	}
						return areaCode;
			        } catch (Exception ex) {
						ex.printStackTrace();
						return null;
					}		
					
					
					
	}

	


}
