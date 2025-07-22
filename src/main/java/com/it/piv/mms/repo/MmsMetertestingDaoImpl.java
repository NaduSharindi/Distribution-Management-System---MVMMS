package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsMetertesting;

@Transactional
@Repository
public class MmsMetertestingDaoImpl implements MmsMetertestingDao {

	@Autowired
	private EntityManager em;

	@Override
	public String add(MmsMetertesting obj) {
		em.persist(obj);return null;
	}

	@Override
	public String update(MmsMetertesting obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return null;
	}
	
	public String getNextTestId(String appIdPrefix,String orderId) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String likeStr=appIdPrefix+"%";
    	try {
			String strQuery="select a.id.testingId from MmsMetertesting a " +
					"where a.id.testingId like :likeStr and a.id.orderCardId =:orderId ORDER BY 1 DESC";
			System.out.println("Hii" + strQuery);
			Query query=null;
			try {
				query = em.createQuery(strQuery);
				query.setParameter("likeStr", likeStr);
				query.setParameter("orderId", orderId);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hiiyyy" + strQuery);
			
			System.out.println("Hiiyyyttt" + strQuery);
			
			System.out.println("Hii" + query);
			
			List<String> list=query.getResultList();
			if (list.size()!=0){
				sequence=query.getResultList().get(0).toString().trim();
				System.out.println(sequence);
				//sequence=sequence.substring(16);//total 20 chars   year 2012
				sequence=sequence.substring(14);//total 18 chars  year 12 
				Integer i=Integer.parseInt(sequence)+1;
				sequence=i.toString();
				System.out.println(sequence);
				System.out.println("Hii" + sequence);
			}else{
				sequence="0001";
				System.out.println("HIIII : "+ sequence);
			}
			if(sequence.length()==1)
				return "000"+sequence;
			else if (sequence.length()==2)
				return "00"+sequence;
			else if (sequence.length()==3)
				return "0"+sequence;
			else return sequence;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}


}
