package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.it.piv.mms.domain.ApplicationReference;


@Transactional
@Repository
public class ApplicationReferenceDaoImpl implements ApplicationReferenceDao {
	@Autowired
	private EntityManager em;

	@Override
	public String save(ApplicationReference obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}

	@Override
	public String getNextApplicationNo(String applicationNoPrefix) {
		// TODO Auto-generated method stub
		String sequence=null;
		System.out.println("getNextApplicationNo");
    	String like=applicationNoPrefix+"%";
    	
    	String strQuery="select APPLICATION_NO from APPLICATION_REFERENCE where APPLICATION_NO like '"+like+"' ORDER BY 1 DESC";
    	
    	Query query=em.createNativeQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	List<String> list=query.getResultList();
    	
    	if (list.size()!=0){
    		
    		sequence=query.getResultList().get(0).toString().trim();
    		
    		System.out.println(sequence);
    		
    		//sequence=sequence.substring(16);//total 20
    		//sequence=sequence.substring(14);//total 18
    		//sequence=sequence.substring(13);//total 18
    		//430.25/CNT/13/0073
    		System.out.println("char: " );
    		char deptStr =' ';
    		try{
    			deptStr = sequence.charAt(10);
    		}catch(Exception e){
    			System.out.println("char: " + e);
    		}
    		System.out.println("char: " + deptStr);
    		System.out.println("char: " + sequence);
    		if(deptStr == '/'){
    			sequence=sequence.substring(14);
    		}else{
    			System.out.println("charddd: ");
    			sequence=sequence.substring(13);
    		}
    		
    		
    		Integer i = new Integer(0);
    		
    		i=Integer.parseInt(sequence)+1;
    		
    		sequence=i.toString();
    		
    	}else{
    		sequence="0001";
    		System.out.println(sequence);
    	}
    	System.out.println("getNextApplicationNo : " + sequence);
    	
    	if(sequence.length()==1)
    		return "000"+sequence;
    	else if (sequence.length()==2)
    		return "00"+sequence;
    	else if (sequence.length()==3)
    		return "0"+sequence;
    	else return sequence;
	}

	

	
	
	
}
