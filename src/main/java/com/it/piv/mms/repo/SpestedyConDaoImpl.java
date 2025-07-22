package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsInspection;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.PcestdttPK;
import com.it.piv.mms.domain.SpestedyCon;
import com.it.piv.util.common.Format;;

@Transactional
@Repository
public class SpestedyConDaoImpl implements SpestedyConDao{
	
	@Autowired
	private EntityManager em;

	@Override
	public String save(SpestedyCon obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}

	@Override
	public String getNextAppointmentId(String dept_id) {
		// TODO Auto-generated method stub
		String sequence=null;
    	Calendar calendar=Calendar.getInstance();
    	Format format=new Format();
    	String[] s=format.formatDate2(calendar.getTime()).trim().toString().split(" ");
		String prefix=s[0].trim().substring(0, 4)+"/"+s[1].toString()+"/";
		
		String like=prefix+"%";
		//String like="2018/09/"+"%";
		System.out.println(like);
    	String strQuery="select a.id.appointmentId from SpestedyCon a where a.id.deptId =:deptId AND a.id.appointmentId LIKE :like ORDER BY 1 DESC";
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("deptId", dept_id);
    	query.setParameter("like", like);
    	System.out.println("query0"+query);
    	List<String> list=query.getResultList();
    	//System.out.println(list);
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println("^ "+sequence);
    		sequence=sequence.substring(8);
    		System.out.println("* "+sequence);
    		Integer i=Integer.parseInt(sequence)+1;
    		sequence=i.toString();
    		System.out.println("# "+sequence);
    	}else{
    		sequence="001";
    		System.out.println("$ "+sequence);
    		//System.out.println(sequence.substring(4));
    	}
    	if(sequence.length()==1)
    		return prefix+"00"+sequence;
    	else if (sequence.length()==2)
    		return prefix+"0"+sequence;
    	
    	else {
    		System.out.println(prefix+sequence);
    		return prefix+sequence;
    	}
	}

	@Override
	public String getWestimateNo(String referenceNo, String deptId) {
		try{
			String strQuery="select a.westimateNo from SpestedyCon a where a.id.deptId =:deptId AND a.id.appNo =:appNo ";
	    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
	    	query.setParameter("deptId", deptId);
	    	query.setParameter("appNo", referenceNo);
	    	System.out.println("query0"+query);
	    	return (String)query.getSingleResult();
	    	
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	

	

}
