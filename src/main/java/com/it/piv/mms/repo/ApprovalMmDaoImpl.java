package com.it.piv.mms.repo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.util.common.Format;


@Transactional
@Repository
public class ApprovalMmDaoImpl implements ApprovalMmDao{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public void addApproval(ApprovalMm app) {
			em.persist(app);
	}
	
	public String getNextAppId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.approvalId from ApprovalMm a " +
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
	
	public String getNextAppIdEM(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.approvalId from ApprovalMm a " +
    			"where a.approvalId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
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
	}
	
	
	public String getNextTestIdEM(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.approvalId from ApprovalMm a " +
    			"where a.approvalId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
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
	}



	@Override
	public List<ApprovalMm> getNotReadEmail(String userid, String dept_id) {
		
		System.out.println("getNotReadEmail 6");
		
		try {
			System.out.println("getNotReadEmail 6");
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.deptId=:deptId and s.approvedBy =:approvedBy and s.toStatus =2 order by approvedDate DESC";
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
	public List<ApprovalMm> getNotReadEmailArea(String area) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.referenceNo =:area and s.toStatus =2   ";
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
	public ApprovalMm findByID(String emailid) {
		// TODO Auto-generated method stub
		return em.find(ApprovalMm.class, emailid);
		
	}

	@Override
	public void update(ApprovalMm app) {
		// TODO Auto-generated method stub
		em.merge(app);
	}

	@Override
	public List<ApprovalMm> getPendingReq(String appType, String status) {
		System.out.println("getPendingReq 100");
		
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", status);
			query.setParameter("approvalType", appType);
			System.out.println("getPendingReq 1" + query.getResultList().size());
			
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("getPendingReq 1" + e.getMessage());
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<ApprovalMm> getPendingReq(String area, String status,
			String deptId) {
        System.out.println("getPendingReq 6");
		
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.toStatus =:status and s.deptId =:deptId order by s.approvalId DESC";
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
	public List<ApprovalMm> getAllRequest(String type) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus IN ('6','99','98') order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}

	@Override
	public List<ApprovalMm> getPendingReqByArea(String area, String status,String type) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status and  s.deptId=:area  order by s.approvalId DESC ";
			System.out.println("test : " + qryStr);
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("area", area);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<ApprovalMm> getAllRequestByarea(String area, String type) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and  s.deptId=:area order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("area", area);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getPendingReqNew(String type, String status,
			String phmBranch) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status and  s.phmBranch=:phmBranch  order by s.approvedDate DESC,s.approvedTime DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("phmBranch", phmBranch);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<ApprovalMm> getAllReqForEMBranch(String type, String phmBranch) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and  s.toStatus IN (12,15,11) and s.phmBranch=:phmBranch    order by s.approvedDate DESC,s.approvedTime DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("phmBranch", phmBranch);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ApprovalMm> getAllReqForPhmBranch(String type, String phmBranch) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and  s.phmBranch=:phmBranch    order by s.approvedDate DESC,s.approvedTime DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("phmBranch", phmBranch);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<ApprovalMm> getAllInterruptionReq(String area, String status,
			String type) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status and  s.areaCode=:area    order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("area", area);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	}

	@Override
	public List<ApprovalMm> getAllInterruptionReqForProvince(List<String> areaList,String status, String type) {
		
		
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status and  s.areaCode IN (:area)    order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("area", areaList);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<ApprovalMm> getAllIntRequestByarea(String area, String type) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and  s.areaCode=:area  order by  s.workingDate DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("area", area);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getAllInterruptionReqNew(String area,
			String status, String type, String category) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.fromStatus =:fromstatus and s.toStatus =:status and  s.areaCode=:area    order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("fromstatus", category);
			
			query.setParameter("area", area);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<ApprovalMm> getAllInterruptionReqNew(List<String> areaList,
			String status, String type, String category) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.fromStatus =:fromstatus and s.toStatus =:status and  s.areaCode IN (:area)    order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("fromstatus", category);
			
			query.setParameter("area", areaList);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(List<String> areaList, String status, String type, String category) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.fromStatus =:fromstatus and s.toStatus =:status and  s.areaCode IN (:area)    order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("fromstatus", category);
			
			query.setParameter("area", areaList);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getAllIntProvince(List<String> areaList, String type) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and  s.areaCode IN (:area)    order by s.deptId ASC,s.approvalId DESC, s.workingDate DESC ";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("area", areaList);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getPendingReqByEE(String type, String status,String phmBranch, String ee) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status and  trim(s.phmBranch)=:phmBranch and trim(s.ee) =trim(:resee)   order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("phmBranch", phmBranch.trim());
			query.setParameter("resee", ee.trim());
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ApprovalMm> getPendingReqByES(String type, String status,String phmBranch, String ee) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status and  trim(s.phmBranch)=:phmBranch and trim(s.es) =trim(:resee)   order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("phmBranch", phmBranch.trim());
			query.setParameter("resee", ee.trim());
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ApprovalMm> getPendingReqByESNew(String type, String status, String ee) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.toStatus =:status  and trim(s.es) =trim(:resee)   order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			//query.setParameter("phmBranch", phmBranch);
			query.setParameter("resee", ee);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public String findWorkingDate(String inttruptionNo) {
		// TODO Auto-generated method stub
		try {
				String qryStr = "SELECT s.workingDate FROM ApprovalMm s WHERE s.approvalId =:approvalId";
				Query query = em.createQuery(qryStr);
				query.setParameter("approvalId", inttruptionNo);
				return query.getSingleResult().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		
	}

	@Override
	public List<Object[]> getRequestTypeCount() {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			//"select * from cbpmthtt where apprv_uid1 ='DGMWPN' and status = 3"
			qryStr = "select count(s.approvalId),s.approvalType from ApprovalMm s  group by s.approvalType";
		    query = em.createQuery(qryStr);
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;
	}

	@Override
	public List<Object[]> getRequestStatusCountByType(String type) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select count(s.approvalId),s.approvalType,s.toStatus,s.fromStatus from ApprovalMm s where s.approvalType=:appType  group by s.approvalType,s.toStatus,s.fromStatus";
		    query = em.createQuery(qryStr);
		    query.setParameter("appType", type.trim());
			
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}
	
	
	@Override
	public List<Object[]> getRequestStatusCountByTypeDeptID(String type,String deptId) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select count(s.approvalId),s.approvalType,s.toStatus,s.fromStatus from ApprovalMm s where s.approvalType=:appType and s.deptId =:deptid group by s.approvalType,s.toStatus,s.fromStatus";
		    query = em.createQuery(qryStr);
		    query.setParameter("appType", type.trim());
		    query.setParameter("deptid", deptId.trim());
			
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}

	
	@Override
	public List<Object[]> getRequestStatusCountByTypeES(String type) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select count(s.approvalId),s.es,s.toStatus from ApprovalMm s where s.toStatus IN (12,15) and s.approvalType=:appType  group by s.approvalType,s.es,s.toStatus";
		    query = em.createQuery(qryStr);
		    query.setParameter("appType", type.trim());
			
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}


	@Override
	public List<ApprovalMm> getRequestStatusCountByTypeDetail(String type,String toStatus,String fromStatus) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select s from ApprovalMm s where s.approvalType=:appType and s.toStatus=:tostatus and s.fromStatus=:fromstatus  order by s.approvalType,s.toStatus,s.fromStatus";
		    query = em.createQuery(qryStr);
		    query.setParameter("appType", type.trim());
		    query.setParameter("tostatus", toStatus.trim());
		    query.setParameter("fromstatus", fromStatus.trim());
			
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}

	@Override
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(
			List<String> areaList, List<String> status, String type,
			String category,String fromdate,String todate) {
		
		
		/*case when to_char(to_date(LAST_BD, 'DD-MON-YYYY'), 'D') is null
         then LAST_BD
         else DECODE(to_char(to_date(LAST_BD, 'DD-MON-YYYY') , 'D') -- line 35
                , '6', to_char (to_date(LAST_BD, 'DD-MON-YYYY') - 1, 'DD-MON-YYYY') 
                , '2', to_char (to_date(LAST_BD, 'DD-MON-YYYY') + 1, 'DD-MON-YYYY') 
                     , LAST_BD)
    end as LAST_BD_OF_MONTH
*/
    //TO_DATE((CASE WHEN s.rescheduleDate is null THEN s.workingDate ELSE  to_char (to_date(s.rescheduleDate, 'YYYY-MM-DD')) END ),'YYYY-MM-DD') BETWEEN  :startDate and :endDate
		
		System.out.println("e :"+fromdate);
		System.out.println("e todate :"+todate);
		
		
		
		try {
			
			
			//TypedQuery<ApprovalMm> queryaa = em.
				//(CASE WHEN (s.rescheduleDate IS NULL) THEN (TO_TIMESTAMP(s.workingDate,'YYYY-MM-DD'))	
					
			/*String qryStr = "SELECT s,(CASE WHEN s.rescheduleDate IS NULL THEN s.workingDate ELSE s.rescheduleDate  END) FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
		    "and s.toStatus IN (:status) and  s.areaCode IN (:area) ";
			//"and (CASE WHEN s.rescheduleDate IS NULL THEN s.workingDate ELSE  s.rescheduleDate END)"+
		    //" BETWEEN :startDate and :endDate  order by s.approvalId DESC";
			*/
			//System.out.println("Testtttt :"+fromdate +" " + todate);
			
			//System.out.println("Test :"+Format.StrToDate(fromdate) +" " + Format.StrToDate(todate));
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE (CASE WHEN s.rescheduleDate IS NULL THEN TO_DATE(s.workingDate,'YYYY-MM-DD') ELSE  s.rescheduleDate END) BETWEEN :startDate and  :endDate   and s.approvalType =:approvalType "+
				    "and s.toStatus IN (:status) and  s.areaCode IN (:area) "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("startDate", Format.StrToDate(fromdate));
			query.setParameter("endDate", Format.StrToDate(todate));
			query.setParameter("area", areaList);
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(
			List<String> areaList, List<String> status, String type,
			String category, String fromdate, String todate,
			String responsibleUser) {
		// TODO Auto-generated method stub
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE (CASE WHEN s.rescheduleDate IS NULL THEN TO_DATE(s.workingDate,'YYYY-MM-DD') ELSE  s.rescheduleDate END) BETWEEN :startDate and  :endDate   and s.approvalType =:approvalType "+
				    "and s.toStatus IN (:status) and  s.areaCode IN (:area) and trim(s.ccApprovalUser) = trim(:user) "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			query.setParameter("startDate", Format.StrToDate(fromdate));
			query.setParameter("endDate", Format.StrToDate(todate));
			query.setParameter("user", responsibleUser);
			
			query.setParameter("area", areaList);
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*@Override
	public List<ApprovalMm> getAllInterruptionReqForProvinceNewCycle(List<String> areaList,List<String> status,String type,String category,String responsibleUser,String cycle);
	 {
		// TODO Auto-generated method stub
try {
			
			
	String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
		    "and s.toStatus IN (:status) and s.ccApprovalUser = trim(:user) and s.intCycle=:cycle "+
			"order by s.approvalId DESC";
			Query  query = em.createQuery(qryStr);
	query.setParameter("approvalType", type);
	query.setParameter("status", status);
	//query.setParameter("startDate", Format.StrToDate(fromdate));
	//query.setParameter("endDate", Format.StrToDate(todate));
	query.setParameter("user", responsibleUser);
	
	//query.setParameter("area", areaList);
	System.out.println("e :"+qryStr);
	System.out.println("query :"+query.toString());
	
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
*/

	@Override
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(
			List<String> areaList, List<String> status, String type,
			String category, String responsibleUser) {
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
				    "and s.toStatus IN (:status) and trim(s.ccApprovalUser) = trim(:user) "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			//query.setParameter("startDate", Format.StrToDate(fromdate));
			//query.setParameter("endDate", Format.StrToDate(todate));
			query.setParameter("user", responsibleUser);
			
			//query.setParameter("area", areaList);
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<ApprovalMm> getApprovalIntteruption(List<String> status,
			String type, String category, String responsibleUser) {
		// TODO Auto-generated method stub
		try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
				    "and s.toStatus IN (:status) and trim(s.ccApprovalUser) = trim(:user) "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			//query.setParameter("startDate", Format.StrToDate(fromdate));
			//query.setParameter("endDate", Format.StrToDate(todate));
			query.setParameter("user", responsibleUser);
			
			//query.setParameter("area", areaList);
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<ApprovalMm> getAllInterruptionReqForProvinceNewCycle(
			List<String> areaList, List<String> status, String type,
			String category, String responsibleUser, String cycle) {
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
				    "and s.toStatus IN (:status) and trim(s.ccApprovalUser) = trim(:user) and s.intCycle=:cycle "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			//query.setParameter("startDate", Format.StrToDate(fromdate));
			//query.setParameter("endDate", Format.StrToDate(todate));
			query.setParameter("user", responsibleUser);
			query.setParameter("cycle", cycle);
			
			//query.setParameter("area", areaList);
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getAllInterruptionForCalender(String status,
			String type) {
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
				    "and s.toStatus =:status "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", "INTREQ");
			query.setParameter("status", "51");
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public List<ApprovalMm> getAllInterruptionForCalenderByStatus(String status,String type) {
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
				    "and s.toStatus IN ('96','80') "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", "INTREQ");
			//query.setParameter("status", );
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public List<ApprovalMm> getAllInterruptionForCalenderByArea(String status,String area) {
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.areaCode=:area  "+
				    "and s.toStatus IN ('96','80') "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", "INTREQ");
			query.setParameter("area",area );
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}



	@Override
	public List<ApprovalMm> getAllInterruptionRecommendedList(
			List<String> areaList, List<String> status, String type,
			String category, String cycle) {
		// TODO Auto-generated method stub
		
		
		
try {
			
			
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType "+
				    "and s.toStatus IN (:status) and s.intCycle=:cycle "+
					"order by s.approvalId DESC";
					Query  query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("status", status);
			//query.setParameter("startDate", Format.StrToDate(fromdate));
			//query.setParameter("endDate", Format.StrToDate(todate));
			//query.setParameter("user", responsibleUser);
			query.setParameter("cycle", cycle);
			
			//query.setParameter("area", areaList);
			System.out.println("e :"+qryStr);
			System.out.println("query :"+query.toString());
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

		
	}

	@Override
	public void updateApproval(ApprovalMm app) {
		em.merge(app);
	}

	@Override
	public List<ApprovalMm> getPendingReqByESAll(String type, String phmBranch,
			String ee) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.phmBranch=:phmBranch and trim(s.es) =trim(:resee)   order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("phmBranch", phmBranch);
			query.setParameter("resee", ee);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<ApprovalMm> getPendingReqByEEAll(String type, String phmBranch,
			String ee) {
		try {
			String qryStr = "SELECT s FROM ApprovalMm s WHERE s.approvalType =:approvalType and s.phmBranch=:phmBranch and trim(s.ee) =trim(:resee)   order by s.approvalId DESC";
			Query query = em.createQuery(qryStr);
			query.setParameter("approvalType", type);
			query.setParameter("phmBranch", phmBranch);
			query.setParameter("resee", ee);
			
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApprovalMm> getHistory(String referenceNo) {
		// TODO Auto-generated method stub
				try {
					String qryStr = "SELECT s FROM ApprovalMm s WHERE trim(s.referenceNo) =:referenceNo";
					Query query = em.createQuery(qryStr);
					query.setParameter("referenceNo", referenceNo.trim());
					return query.getResultList();
				} catch (Exception e) {
					System.out.println("getPendingReq 1" + e.getMessage());
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}

	/*@Override
	public List<Object[]> getRequestStatusCountByTypeDeptID(String type,
			String deptId) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	/*private Date StringToDateNew(String str_date) {
		try{
			
			System.out.println("e :"+str_date);
				
	        DateFormat formatter ; 
	        Date date ; 
	        formatter = new SimpleDateFormat("YYYY-MM-DD");
	        date = (Date)formatter.parse(str_date);    
	        return date;
		 } catch (ParseException e) {
			 System.out.println("Exception :"+e);
			 return null;
		}    
		     
	   }
	*/




}
