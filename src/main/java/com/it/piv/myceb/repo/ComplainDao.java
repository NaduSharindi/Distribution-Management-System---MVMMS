package com.it.piv.myceb.repo;

import java.util.List;

import com.it.piv.myceb.domain.ComData;

public interface ComplainDao {
	
		public String addComplain(ComData complain);
		public String addComplainByCustomer(String acctno,String complain, String longitute,String latitute);
		public void updateComplain(ComData complain);
		public ComData findById(String id);
		public ComData findByAccNo(String id);
		public ComData findByIdNo(String id);
		public void updateStatus(String status);
		public List<ComData> findByStatus(String status);
		public List<ComData> getAll();

}
