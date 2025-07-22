package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsInspection;


@Transactional
@Repository
public class MmsInspectionDaoImpl implements MmsInspectionDao {

	
	@Autowired
	private EntityManager em;

	@Override
	public String add(MmsInspection addLine) {
		// TODO Auto-generated method stub
		em.persist(addLine);
		return null;
	}

	@Override
	public String update(MmsInspection addLine) {
		// TODO Auto-generated method stub
		em.merge(addLine);
		return null;
	}

	@Override
	public String getNextINsEstimate(String appIdPrefix) {
		String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.inspectionId from MmsInspection a " +
    			"where a.inspectionId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20 chars   year 2012
    		sequence=sequence.substring(17);//total 18 chars  year 12 
    		Integer i=Integer.parseInt(sequence)+1;
    		sequence=i.toString();
    		System.out.println(sequence);
    		System.out.println("Hii" + sequence);	
    	}
    	else{
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
	public List<MmsInspection> getInsListByTypeDeptId(String type, String deptId,String status) {
try {
			
			
			String qryStr = "SELECT s FROM MmsInspection s WHERE s.type =:type "+
				    "and s.comStatus =:status and s.phmBranch =:phmBranch "+
					"order by s.type,s.inspectionId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("type", type);
			query.setParameter("status", status);
			query.setParameter("phmBranch", deptId);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<MmsInspection> getInsListByTypeDeptIdEE(String type, String deptId,String status,String ee) {
try {
			
			
			String qryStr = "SELECT s FROM MmsInspection s WHERE s.type =:type "+
				    "and s.comStatus =:status and s.phmBranch =:phmBranch and s.ee =:ee "+
					"order by s.type,s.inspectionId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("type", type);
			query.setParameter("status", status);
			query.setParameter("phmBranch", deptId);
			query.setParameter("ee", ee);
			
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	@Override
	public List<MmsInspection> getInsListByTypeDeptIdEs(String type, String deptId,String status,String es) {
try {
			
			
			String qryStr = "SELECT s FROM MmsInspection s WHERE s.type =:type "+
				    "and s.comStatus =:status and s.phmBranch =:phmBranch and s.inspectionBy =:es "+
					"order by s.type,s.inspectionId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("type", type);
			query.setParameter("status", status);
			query.setParameter("phmBranch", deptId);
			query.setParameter("es", es);
			
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public MmsInspection findByID(String id) {
		// TODO Auto-generated method stub
		return em.find(MmsInspection.class, id);
	}

}
