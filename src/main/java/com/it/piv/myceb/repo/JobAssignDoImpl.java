package com.it.piv.myceb.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
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

import com.it.piv.myceb.domain.CusData;
import com.it.piv.myceb.domain.JobAssign;
import com.it.piv.myceb.domain.JobStatusOm;
import com.it.piv.myceb.domain.JobStatusOmsNew;

@Repository
@Transactional
public class JobAssignDoImpl implements JobAssignDao {
	@Autowired
	private EntityManager em;
	

	@Override
	public List<JobAssign> findComByAcCd(String accessCode) {
		// TODO Auto-generated method stub
		TypedQuery<JobAssign> query =
				em.createQuery
				("SELECT cd "
				+ "FROM JobAssign cd "
				+ "WHERE cd.userLog= :userLog", JobAssign.class) ;
					   
					 query.setParameter("userLog", accessCode); 
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public void addCommet(JobAssign obj) {
		// TODO Auto-generated method stub
		Query  query = em.createQuery("UPDATE JobAssign b set b.commentA =:com "
				+ "WHERE b.complaintid = :comId ");
	    query.setParameter("comId", obj.getComplaintid());
	    query.setParameter("com", obj.getCommentA());
	    query.executeUpdate();
	}
	
	@Override
	public void addCommet(String id,String comment) {
		
		// TODO Auto-generated method stub
		
		 try {
	    	Query  query = em.createQuery("UPDATE JobAssign b set b.commentA =:comment "
					+ "WHERE b.complaintid = :id");
		    query.setParameter("id", id);
		    query.setParameter("comment",comment);
		    query.executeUpdate();
	    } catch (Exception ex) {
	       
	    }
	   
		
		
	}


	@Override
	public List<JobAssign> findComByStatus(String accessCode, String status) {
		// TODO Auto-generated method stub
		
		
		TypedQuery<JobAssign> query =
				em.createQuery
				("SELECT cd "
				+ "FROM JobAssign cd "
				+ "WHERE cd.userLog= :userLog and cd.compStatus =:status", JobAssign.class) ;
					   
					 query.setParameter("userLog", accessCode);
					 query.setParameter("status", status); 
					 System.out.print(query);
					return query.getResultList();
	    
	}


	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		/**DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus stat = txManager.getTransaction(def);
	    def.setName("SomeTxName");
	    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE JobAssign b set b.compStatus =:status ,b.compDate =:compDate  "
					+ "WHERE b.complaintid = :id ");
		    query.setParameter("id", id);
		    query.setParameter("status", status);
		    query.setParameter("compDate", new Date());
		    query.executeUpdate();
	    } catch (Exception ex) {
	       txManager.rollback(stat);
	    }
	   txManager.commit(stat);*/
	   
	   ////////////
	   
	   try {
	    	Query  query = em.createQuery("UPDATE JobAssign b set b.compStatus =:status " + " WHERE b.complaintid = :id");
		    query.setParameter("id", id);
		    query.setParameter("status", status);
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	       
	    }
	   
	}


	@Override
	public List<JobAssign> findJobByJobNum(String jobNo) {
		// TODO Auto-generated method stub
		TypedQuery<JobAssign> query =
				em.createQuery
				("SELECT cd "
				+ "FROM JobAssign cd "
				+ "WHERE cd.jobNo= :jobNo", JobAssign.class) ;
					   
					 query.setParameter("jobNo", jobNo);
					 
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public void statusUpdateForBD(String refNo, String userlog,String status_from, String status_to, String comment,String expTime) {
		// TODO Auto-generated method stub
		/** DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		    TransactionStatus sta = txManager.getTransaction(def);
		    def.setName("SomeTxName");
		    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		    try {
		    	Query  query = em.createQuery("UPDATE JobStatusOm b set b.refferenceNo =:refNo,b.userLog =:userlog,b.statusFrom=:status_from ,b.statusTo=:status_to ,b.commentDes=:comment");
			    query.setParameter("refNo", refNo);
			    query.setParameter("userlog", userlog);
			    query.setParameter("status_from", status_from);
			    query.setParameter("status_to", status_to);
			    query.setParameter("comment", comment);
			    //query.setParameter("userLog", userlog);
			    //query.setParameter("userLog", userlog);
			    System.out.print(query);
			    query.executeUpdate();
		    } catch (Exception ex) {
		        txManager.rollback(sta);
		    }
		    txManager.commit(sta);
		*/
		JobStatusOmsNew obj = new JobStatusOmsNew();
		 try {
	    	//System.out.print("test : ");
	    	//List<String> objStr = getNextVal();
	    	Date ddd = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    	SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
	    	
	    	String startDate = sdf.format(ddd); 
	    	//System.out.print("test : "+objStr);
	        //String.valueOf(sss);
	    	//obj.setId(String.valueOf(getNextVal()));
	        obj.setId(ddd.toString());
	    	obj.setRefferenceNo(refNo);
	    	obj.setUserLog(userlog);
	    	obj.setStatusFrom(status_from);
	    	obj.setStatusTo(status_to);
	    	obj.setOperationTime(startDate);
	    	obj.setCommentDes(comment);
	    	obj.setExpectedDur(expTime);
	    	em.persist(obj);
	    } catch (Exception ex) {
	    	 System.out.print("test : "+ex);
	        
	    }
	    
	   
		
		
	}
	
	public List<String> getNextVal(){
		//String xxx ="";
		//try{
		//	Query query =em.createQuery("select ebms.customer_seq.nextval from dual");
		//	xxx=  (String)query.getSingleResult();
		//}catch(Exception e){
		//	System.out.print("test : "+e);
		//}
		//return xxx;
		
		TypedQuery<String> query =em.createQuery("select CUSTOMER_SEQ.nextval from dual", String.class) ;
		System.out.print(query);
		return query.getResultList();
	}
	
	public String getNextApplicationNo(String applicationNoPrefix, String webAppName) {
		//getEntityManager(webAppName);
		String sequence=null;
    	String like=applicationNoPrefix+"%";
    	String strQuery="select ex.customer_seq.nextval from dual";
    	Query query=em.createNativeQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20
    		sequence=sequence.substring(14);//total 18
    		Integer i=Integer.parseInt(sequence)+1;
    		sequence=i.toString();
    		System.out.println(sequence);
    	}else{
    		sequence="0001";
    		System.out.println(sequence);
    	}
    	if(sequence.length()==1)
    		return "000"+sequence;
    	else if (sequence.length()==2)
    		return "00"+sequence;
    	else if (sequence.length()==3)
    		return "0"+sequence;
    	else return sequence;
	}
	
	 public String getWrh_dept(Connection connection, String costCenter)throws SQLException{
	        Statement statement = null;
	        ResultSet result = null;
	        String xxx = null;
	        try{
	        
	        String command="select wrh_dept from inwrhmap where dept_id='"+costCenter+"'"; 
	        statement=connection.createStatement();
	        result=statement.executeQuery(command);
	        
	        if (result!=null){
	           while(result.next()){;
	           xxx  = result.getString("wrh_dept");
	           }
	        }else{
	          
	        }
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	                if (connection != null) 
	                 {
	                    try 
	                     {
	                        connection.close();
	                        if (statement != null) 
	                          statement.close();
	                        if(result != null)
	                            result .close();
	                      } catch (SQLException ignore) {}
	                  }
	            }

	
	        return xxx;   

}


	@Override
	public List<JobAssign> getAll() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JobAssign> criteria = cb.createQuery(JobAssign.class);
		Root<JobAssign> location = criteria.from(JobAssign.class);

		criteria.select(location).orderBy(cb.asc(location.get("assignedTo")));
		return em.createQuery(criteria).getResultList();
	}


	@Override
	public List<JobAssign> findJobByAreaCode(String area) {
		// TODO Auto-generated method stub
		TypedQuery<JobAssign> query =
				em.createQuery
				("SELECT cd "
				+ "FROM JobAssign cd "
				+ "WHERE cd.areaCode= :areaCode", JobAssign.class) ;
					   
					 query.setParameter("areaCode", area);
					 
					 System.out.print(query);
					return query.getResultList();
	}


	@Override
	public List<JobStatusOmsNew> getAllBreakDownStatus() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JobStatusOmsNew> criteria = cb.createQuery(JobStatusOmsNew.class);
		Root<JobStatusOmsNew> location = criteria.from(JobStatusOmsNew.class);

		criteria.select(location).orderBy(cb.asc(location.get("refferenceNo")));
		return em.createQuery(criteria).getResultList();
	}


	@Override
	public List<JobStatusOmsNew> getAllBreakDownStatus(String refNo) {
		// TODO Auto-generated method stub
		TypedQuery<JobStatusOmsNew> query =
				em.createQuery
				("SELECT cd "
				+ "FROM JobStatusOmsNew cd "
				+ "WHERE cd.refferenceNo= :refferenceNo", JobStatusOmsNew.class) ;
					   
					 query.setParameter("refferenceNo", refNo);
					 
					 System.out.print(query);
					return query.getResultList();	}


	@Override
	public void updateFailureCause(String refNo,String userlog, String action, String cause,String detail, String type,String comment) {
		// TODO Auto-generated method stub
		JobStatusOmsNew obj = new JobStatusOmsNew();
		try {
	    	//System.out.print("test : ");
	    	//List<String> objStr = getNextVal();
	    	Date ddd = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    	SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
	    	
	    	String startDate = sdf.format(ddd); 
	    	//System.out.print("test : "+objStr);
	        //String.valueOf(sss);
	    	//obj.setId(String.valueOf(getNextVal()));
	        obj.setId(ddd.toString());
	    	obj.setRefferenceNo(refNo);
	    	obj.setUserLog(userlog);
	    	//obj.setStatusFrom(status_from);
	    	obj.setStatusTo("F");
	    	obj.setOperationTime(startDate);
	    	obj.setFailureAction(action);
	    	obj.setFailureCause(cause);
	    	obj.setFailureDetail(detail);
	    	obj.setFailureTypes(type);
	    	obj.setCommentDes(comment);
	    	em.persist(obj);
	    } catch (Exception ex) {
	    	 System.out.print("test : "+ex);
	        //txManager.rollback(status);
	    }
	    //txManager.commit(status);
	   
	}
	
	@Override
	public void addComToVehicle(String comNo,String lon, String lat, String userlog,String priority, String comment,String areaCode) {
		// TODO Auto-generated method stub
		JobAssign obj = new JobAssign();
		try {
	    	//System.out.print("test : ");
	    	//List<String> objStr = getNextVal();
	    	Date ddd = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    	SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
	    	
	    	String startDate = sdf.format(ddd); 
	    	//System.out.print("test : "+objStr);
	        //String.valueOf(sss);
	    	//obj.setId(String.valueOf(getNextVal()));
	        obj.setBdid("JOB-" +startDate);
	    	obj.setComplaintid(comNo);
	    	obj.setAreaCode(areaCode);
	    	//obj.setStatusFrom(status_from);
	    	obj.setUserLog(userlog);
	    	obj.setJobNo("JOB-" +startDate);
	    	obj.setPriorityCode(priority);
	    	obj.setCompStatus("N");
	    	obj.setCommentA(comment);
	    	obj.setLatitute(lat);
	    	obj.setLongitute(lon);
	    	
	    	//telephone number
	    	obj.setUnitName("+94771155308");
	    	obj.setContactnum("+94720201642");
	    	//obj.setCommentDes(comment);
	    	em.persist(obj);
	    } catch (Exception ex) {
	    	 System.out.print("test : "+ex);
	        //txManager.rollback(status);
	    }
	   // txManager.commit(status);
	   
	}
	
	
	


	@Override
	public void assignJob(JobAssign obj) {
		// TODO Auto-generated method stub
		  try {
	    	em.persist(obj);
	    } catch (Exception ex) {
	       //txManager.rollback(status);
	    }
	  // txManager.commit(status);
	}


	@Override
	public List<JobStatusOmsNew> getAllBreakDownbyUser(String user) {
		// TODO Auto-generated method stub
		TypedQuery<JobStatusOmsNew> query =
				em.createQuery
				("SELECT cd "
				+ "FROM JobStatusOmsNew cd "
				+ "WHERE cd.refferenceNo= :refferenceNo", JobStatusOmsNew.class) ;
					   
					 query.setParameter("refferenceNo", user);
					 
					 System.out.print(query);
					return query.getResultList();	

	}
	 
}
