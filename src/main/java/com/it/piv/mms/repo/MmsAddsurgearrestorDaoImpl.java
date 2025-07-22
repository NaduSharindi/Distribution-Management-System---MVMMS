package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddsurgearrestor;
import com.it.piv.mms.domain.MmsAddsurgearrestorPK;

@Transactional
@Repository
public class MmsAddsurgearrestorDaoImpl implements MmsAddsurgearrestorDao {
	@Autowired
	private EntityManager em;
	

	@Override
	public String addSurgeArrestor(MmsAddsurgearrestor obj) {
		em.persist(obj);
		return null;
	}

	@Override
	public String updateSurgeArrestor(MmsAddsurgearrestor obj) {
		em.merge(obj);
		return null;
	}

	@Override
	public MmsAddsurgearrestor findById(MmsAddsurgearrestorPK ojb) {
		return em.find(MmsAddsurgearrestor.class, ojb);
	}

	
	@Override
	public List<MmsAddsurgearrestor> findByGantryId(String gantryId) {
		try {
			String sql = "select a from MmsAddsurgearrestor a where a.id.gantryId= :gantryId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryId",new Long(gantryId));
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNextSurgeArrestorId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.id.feederId from MmsAddsurgearrestor a " +
    			"where a.id.saId like :like ORDER BY 1 DESC";
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

}
