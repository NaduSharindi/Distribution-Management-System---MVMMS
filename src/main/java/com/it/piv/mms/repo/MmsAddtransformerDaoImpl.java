package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddtransformer;
import com.it.piv.mms.domain.MmsAddtransformerPK;

@Transactional
@Repository
public class MmsAddtransformerDaoImpl implements MmsAddtransformerDao {
	
	@Autowired
	private EntityManager em;
	

	@Override
	public String addTransformer(MmsAddtransformer obj) {
		em.persist(obj);
		return null;
	}

	@Override
	public String updateTransformer(MmsAddtransformer obj) {
		em.merge(obj);
		return null;
	}

	@Override
	public MmsAddtransformer findById(MmsAddtransformerPK obj) {
		// TODO Auto-generated method stub
		return em.find(MmsAddtransformer.class, obj);
	}

	@Override
	public List<MmsAddtransformer> findByGantryId(String gantryId) {
		try {
			String sql = "select a from MmsAddtransformer a where a.id.gantryId= :gantryId";
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
	public String getNextTransformerId(String appIdPrefix) {
		//getEntityManager(webAppName);
		System.out.println("Transformer");
		
		String sequence=null;
		
    	try {
			String like=appIdPrefix+"%";
			String strQuery="select a.id.trId from MmsAddtransformer a " +
					"where a.id.trId like :like ORDER BY 1 DESC";
			System.out.println("Hii" + strQuery);
			Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
			query.setParameter("like", like);
			List<String> list=query.getResultList();
			System.out.println("Transformer 1");
			
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
				System.out.println("Transformer 2");
				
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
    	return sequence;
	}

}
