package com.it.piv.myceb.repo;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.it.piv.myceb.domain.ComData;
import com.it.piv.myceb.domain.JobAssign;
import com.it.piv.myceb.domain.JobStatusOmsNew;

@Repository
@Transactional
public class ComplainDaoImpl implements ComplainDao {
	

	@Autowired
	private EntityManager entityManager;

	@Override
	public String addComplain(ComData complain) {
		// TODO Auto-generated method stub
		  try {
	    	entityManager.persist(complain);
	    } catch (Exception ex) {
	       
	    }
	    
	   
		return complain.getComplaintNo();
	}

	@Override
	public void updateComplain(ComData complain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ComData findById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(ComData.class, id);
	}

	@Override
	public ComData findByAccNo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComData findByIdNo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComData> getAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ComData> criteria = cb.createQuery(ComData.class);
		Root<ComData> location = criteria.from(ComData.class);

		criteria.select(location).orderBy(cb.asc(location.get("complaintNo")));
		return entityManager.createQuery(criteria).getResultList();
	}

	
	@Override
	public String addComplainByCustomer(String acctno, String complain,
			String longitute, String latitute) {
		// TODO Auto-generated method stub
		
		ComData obj = new ComData();
		   try {
	    	//System.out.print("test : ");
	    	//List<String> objStr = getNextVal();
	    	Date ddd = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    	SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
	    	
	    	String startDate = sdf.format(ddd); 
	    	//String starttime = time.parse(ddd.toString()); 
	    	//System.out.print("test : "+objStr);
	        //String.valueOf(sss);
	    	//obj.setId(String.valueOf(getNextVal()));
	        obj.setComplaintNo("COM-"+startDate);
	    	obj.setAcctNum(acctno);
	    	String area = acctno.substring(0,2);
	    	obj.setAreaCode(area);
	    	obj.setComments(complain);
	    	obj.setLongitute(longitute);
	    	obj.setLatitude(latitute);
	    	obj.setStatus("N");
	    	obj.setDateTime(startDate);
	    	//obj.setBdTime(new SimpleDateFormat("hh-mm-ss").parse(ddd.toString()));
	    	entityManager.persist(obj);
	    } catch (Exception ex) {
	    	System.out.print("test : "+ex);
	       
	    }
	   
		return null;
	}

	@Override
	public List<ComData> findByStatus(String status) {
		// TODO Auto-generated method stub
		TypedQuery<ComData> query =
				entityManager.createQuery
				("SELECT cd "
				+ "FROM ComData cd "
				+ "WHERE cd.status= :status", ComData.class) ;
					   
					 query.setParameter("status", status); 
					 System.out.print(query);
					return query.getResultList();
	}

	@Override
	public void updateStatus(String comId) {
		// TODO Auto-generated method stub
		
		    try {
	    	Query  query = entityManager.createQuery("UPDATE ComData cd set cd.status =:status " + " WHERE cd.complaintNo = :comId");
		    query.setParameter("comId", comId);
		    query.setParameter("status", "A");
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	       
	    }
	    
		 
	}

	
}
