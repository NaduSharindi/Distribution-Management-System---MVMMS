package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddfeeder;
import com.it.piv.mms.domain.MmsAddlvfeeder;


@Repository
@Transactional
public class MmsAddlvfeederDaoImpl implements MmsAddlvfeederDao{
	
	@Autowired
	private EntityManager em;
	

	@Override
	public String addFeeder(MmsAddlvfeeder addFeeder) {
		em.persist(addFeeder);
		return null;
	}

	@Override
	public String getNextFeerderId(String appIdPrefix) {
		String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.id.feederId from MmsAddlvfeeder a " +
    			"where a.id.feederId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20 chars   year 2012
    		sequence=sequence.substring(2);//total 18 chars  year 12 
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
	}

	@Override
	public String updateFeeder(MmsAddlvfeeder addFeeder) {
		em.merge(addFeeder);
		return null;
	}

	@Override
	public List<MmsAddlvfeeder> findLvFeederByAreaStatus(String status,String area) {
		try {
			System.out.println("status : "+status);
			String qryStr = "select p from MmsAddlvfeeder p where p.status =:status and p.area =:area ORDER BY p.id.feederId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			List<MmsAddlvfeeder> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
