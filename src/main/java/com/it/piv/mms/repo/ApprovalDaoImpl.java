package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.MmsAddline;

@Transactional
@Repository
public class ApprovalDaoImpl implements ApprovalDao{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public void addApproval(Approval app) {
			em.persist(app);
	}
	
	public String getNextAppId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.approvalId from Approval a " +
    			"where a.approvalId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20 chars   year 2012
    		sequence=sequence.substring(11);//total 18 chars  year 12 
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
	public List<Approval> getNotReadEmail(String userid, String dept_id) {
		
		System.out.println("getNotReadEmail 6");
		
		try {
			System.out.println("getNotReadEmail 6");
			
			String qryStr = "SELECT s FROM Approval s WHERE s.deptId=:deptId and s.approvedBy =:approvedBy and s.toStatus =2 order by approvedDate DESC";
			System.out.println("getNotReadEmail 7" + qryStr);
			
			Query query = em.createQuery(qryStr);
			query.setParameter("deptId", dept_id);
			query.setParameter("approvedBy", userid);
			//query.setParameter("approvalType", "EMAIL");
			System.out.println("getNotReadEmail 8" + qryStr);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Approval> getNotReadEmailArea(String area) {
		try {
			String qryStr = "SELECT s FROM Approval s WHERE s.referenceNo =:area and s.toStatus =2   ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("approvalType", "ËMAIL");
			
			//query.setParameter("approvedBy", userid);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Approval findByID(String emailid) {
		// TODO Auto-generated method stub
		return em.find(Approval.class, emailid);
		
	}

	@Override
	public void update(Approval app) {
		// TODO Auto-generated method stub
		em.merge(app);
	}

	@Override
	public List<Approval> getPendingReq(String appType, String status) {
		System.out.println("getPendingReq 6");
		
		try {
			String qryStr = "SELECT s FROM Approval s WHERE s.toStatus =:status";
			Query query = em.createQuery(qryStr);
			//query.setParameter("area", area);
			query.setParameter("status", status);
			
			//query.setParameter("appType", appType);
			
			//query.setParameter("approvedBy", userid);
			
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("getPendingReq 1" + e.getMessage());
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;}

	@Override
	public List<Approval> getPendingReq(String area, String status,
			String deptId) {
System.out.println("getPendingReq 6");
		
		try {
			String qryStr = "SELECT s FROM Approval s WHERE s.toStatus =:status and s.deptId =:deptId";
			Query query = em.createQuery(qryStr);
			//query.setParameter("area", area);
			query.setParameter("status", status);
			query.setParameter("deptId", deptId);
			
			//query.setParameter("appType", appType);
			
			//query.setParameter("approvedBy", userid);
			
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("getPendingReq 1" + e.getMessage());
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String getNextAppIdEstimate(String appIdPrefix) {
		// TODO Auto-generated method stub
		String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.approvalId from Approval a " +
    			"where a.approvalId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		int strcount = sequence.indexOf("-");
    		sequence = sequence.substring(strcount+1);
    		System.out.println(sequence);
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
	public List<Approval> getHistory(String referenceNo) {
		// TODO Auto-generated method stub
		try {
			String qryStr = "SELECT s FROM Approval s WHERE s.referenceNo =:referenceNo order by s.approvedDate DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("referenceNo", referenceNo);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("getPendingReq 1" + e.getMessage());
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
