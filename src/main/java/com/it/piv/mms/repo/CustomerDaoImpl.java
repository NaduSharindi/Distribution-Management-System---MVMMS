package com.it.piv.mms.repo;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.it.piv.mms.domain.Customer;

public  class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private EntityManager em;
	@Override
	 public String add(Customer customer){
	 em.persist(customer);
	 return null;
}
	@Override 
	 public String update(Customer customer){
		 em.merge(customer);
		 return null;

}
}