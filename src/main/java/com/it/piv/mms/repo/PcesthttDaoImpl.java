package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;


@Transactional
@Repository
public class PcesthttDaoImpl implements PcesthttDao {

	@Autowired
	private EntityManager em;
	@Override
	public String save(Pcesthtt htt) {
		// TODO Auto-generated method stub
		em.persist(htt);
		return null;
	}
	@Override
	public List<Object[]> getApprovalList() {
		// TODO Auto-generated method stub
		//Sausrdpm.java
		//select count(a.estimate_no),a.dept_id,(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.dept_id) from pcesthtt a where a.rev_no IN (1,2) and a.status = 48 and a.dept_id IN (select s.dept_id from SAUSRDPM s where s.user_id ='DGMWPN') group by a.dept_id

		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			//qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) , a.id.deptId from Pcesthtt a where a.id.revNo IN (1,2) and a.status = 48 and a.id.deptId IN (select s.id.deptId from Sausrdpm s where s.id.userId ='DGMWPN') group by a.id.deptId";
			/*qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) , a.id.deptId "+
			"from Pcesthtt a where a.id.revNo IN (1,2) and a.status = 48 and a.id.deptId IN "+
			"(select s.id.deptId from Sausrdpm s where s.id.userId IN ('DGMWPN')) group by a.id.deptId";
            */
			qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
					"from Pcesthtt a where a.id.revNo IN (1,2) and a.status = 48 and a.id.deptId IN (select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='DGMWPN') group by a.id.deptId";
		            
			//qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('UVAP','WPSII','SABP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
			
			
			query = em.createQuery(qryStr);
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
				
				
		return null;
	}
	@Override
	public List<Object[]> getApprovalList(String usrLevel, String usrName) {
		// TODO Auto-generated method stub
		
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);

		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);
		usrName = usrName.trim();
		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
						"from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " group by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
				
				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
			qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
					"from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " group by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		
		return null;
	}
	
	
	@Override
	public List<Object[]> getApprovalListAE(String usrLevel, String usrName) {
		// TODO Auto-generated method stub
		
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);

		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);
		usrName = usrName.trim();
		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
						"from Pcesthtt a where a.id.revNo IN (1,2) and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " group by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			   // query.setParameter("usrId",usrName );
					
				
				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
			qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
					"from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " group by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		
		return null;
	}

	
	
	
	
	
	@Override
	public List<Object[]> getApprovalListDetail(String usrLevel, String usrName) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);

		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		usrName=usrName.trim();
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
				qryStr = "select a.id.estimateNo,(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
						"from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
				
				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
			qryStr = "select a.id.estimateNo,(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
					"from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

return null;
	}
	@Override
	public List<Object[]> getApprovalList(String usrLevel, String usrName,
			String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				//String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				String authorizedCostCenter ="('"+dept_id.trim()+"')";
				
				qryStr = "select distinct a.id.estimateNo,a.id.deptId,a.descr,a.partialAmt,a.stdCost-a.partialAmt,a.catCd,a.fundSource,a.stdCost"+
						" from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			//String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				String authorizedCostCenter ="('"+dept_id.trim()+"')";
					
			qryStr = "select a.id.estimateNo,a.id.deptId,a.descr,a.partialAmt,a.stdCost-a.partialAmt,a.catCd,a.fundSource,a.stdCost"+
					" from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
		    System.out.println("qryStr :"+qryStr);

			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

return null;
	}
	
	
	@Override
	public List<Pcesthtt> getApprovalListNew(String usrLevel, String usrName,
			String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		
		List<Pcesthtt> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				//String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				String authorizedCostCenter ="('"+dept_id.trim()+"')";
				
				qryStr = "select a "+
						" from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				//String authorizedCostCenter ="('"+dept_id.trim()+"')";
					
			qryStr = "select a "+
					" from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
		    System.out.println("qryStr :"+qryStr);

			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

return null;
	}

	
	
	
	
	@Override
	public List<Object[]> getApprovalListAE(String usrLevel, String usrName,
			String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				//String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				String authorizedCostCenter ="('"+dept_id.trim()+"')";
				
				qryStr = "select distinct a.id.estimateNo,a.id.deptId,a.descr,a.partialAmt,a.stdCost-a.partialAmt,a.catCd,a.fundSource"+
						" from Pcesthtt a where a.id.revNo IN (1,2) and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    //query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			//String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				String authorizedCostCenter ="('"+dept_id.trim()+"')";
					
			qryStr = "select a.id.estimateNo,a.id.deptId,a.descr,a.partialAmt,a.stdCost-a.partialAmt,a.catCd,a.fundSource"+
					" from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
		    System.out.println("qryStr :"+qryStr);

			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

return null;
	}

	
	@Override
	public List<Pcesthtt> getApprovalListAENew(String usrLevel, String usrName,
			String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				//String authorizedCostCenter ="('"+dept_id.trim()+"')";
				
				qryStr = "select a "+
						" from Pcesthtt a where a.id.revNo IN (1,2) and  a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    //query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				//String authorizedCostCenter ="('"+dept_id.trim()+"')";
					
			qryStr = "select a "+
					" from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
		    System.out.println("qryStr :"+qryStr);

			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

return null;
	}

	
	@Override
	public List<Object[]> getApprovalListDetailAll(String usrLevel,
			String usrName) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			/*if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId,a.status "+
						"from Pcesthtt a where a.id.revNo IN (1,2) and a.id.deptId IN "+authorizedCostCenter+ " group by a.id.deptId, a.status";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("usrId",usrName );
					
				
				
			}else{
			*/
			
			usrName = usrName.trim();
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='"+usrName+"')";
			qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId,a.status "+
					"from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.id.deptId) IN "+authorizedCostCenter+ " group by a.id.deptId, a.status";
						
		    query = em.createQuery(qryStr);
		    //}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;
	}
	@Override
	public Long getApprovalListCount(String usrLevel, String usrName) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrName=usrName.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		usrName = usrName.trim();
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo) from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and  a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName.trim() );
					
				
				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			qryStr = "select count(a.id.estimateNo) from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
			}

			return (Long)query.getSingleResult();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
// TODO Auto-generated method stub
		
		
		return null;
	}
	
	
	
	
	@Override
	public Long getApprovalListCountAE(String usrLevel, String usrName) {
		//System.out.println("usrLevel :"+usrLevel);
		//System.out.println("usrName :"+usrName);
		usrName=usrName.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			//System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			//System.out.println("DGM :");

			status ="48";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			//System.out.println("CE :");

			status ="47";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			//System.out.println("EE :");

			status ="46";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			//System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			//System.out.println("ES :");

			status ="44";
		}else{
			
		}
		//System.out.println("status :"+status);

		usrName = usrName.trim();
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo) from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    //query.setParameter("usrId",usrName.trim() );
					
				
				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			qryStr = "select count(a.id.estimateNo) from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
			}

			return (Long)query.getSingleResult();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public String approveEstimate(String estimateNo, String deptId,String authorityLevel, String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BigDecimal getTotalCOst(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		try{
		Query query=null;
		BigDecimal totalCost = null;
		String status = null;
		Double dbTotalCost=0.0;
		String qryStr = "SELECT p.stdCost FROM Pcesthtt p  WHERE TRIM(p.id.estimateNo)=:estimateNo  AND TRIM(p.id.deptId)= :deptId";
				
		query = em.createQuery(qryStr);
		query.setParameter("estimateNo", estimateNo.trim());
		query.setParameter("deptId", deptId);
		return (BigDecimal) query.getResultList();
	
		}catch(Exception e){
			
		}
		
		return null;
	}
	
	
	
	@Override
	public Pcesthtt getPcesthtt(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		try{
		Query query=null;
		BigDecimal totalCost = null;
		String status = null;
		Double dbTotalCost=0.0;
		String qryStr = "SELECT p FROM Pcesthtt p  WHERE trim(p.id.estimateNo)=:estimateNo AND p.id.revNo IN (1,2) AND p.id.deptId= :deptId order by p.etimateDt DESC";
				
		query = em.createQuery(qryStr);
		query.setParameter("estimateNo", estimateNo.trim());
		query.setParameter("deptId", deptId.trim());
		return (Pcesthtt)query.getResultList().get(0);
	
		}catch(Exception e){
			
		}
		
		return null;
	}
	
	@Override
	public Pcesthtt findById(PcesthttPK pk) {
		// TODO Auto-generated method stub
		return em.find(Pcesthtt.class, pk);
	}
	@Override
	public String update(Pcesthtt htt) {
		// TODO Auto-generated method stub
		em.merge(htt);
		
		return null;
	}
	@Override
	public List<Object[]> getApprovalListAllDataSet(String deptId, String status) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select distinct a.id.estimateNo,a.id.deptId,a.descr,a.partialAmt,a.stdCost-a.partialAmt,a.catCd,a.fundSource,a.stdCost from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:statusnew and a.id.deptId =:deptId order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
		    query.setParameter("deptId", deptId);
			

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		return null;
	}
	@Override
	public List<Object[]> getDetailList(String estimateNo, String deptId) {
		String qryStr = "";
		if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR") || estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			System.out.println("test");
			
			qryStr ="select T1.id.resCd, "+
					"( CASE  WHEN T1.resType IS NULL OR T1.resType like '%MAT%' THEN '1MAT'"+
					" when T1.resType like 'LABOUR%' then '4LAB'"+
					"when T1.resType like 'WAY%' then '2WAY'"+
					"when T1.resType like 'TRANSPORT%' then '3TRANSPORT'"+
					"when T1.resType like 'SUBSISTANCE%' then '5SUBSISTANCE'"+
					"when T1.resType like 'CONTINGENCIE%' then '6CONTINGENCIE'"+
					"when T1.resType like 'OVERHEAD%' then '7OVERHEAD'"+
					"when T1.resType like 'MACHINE_COST%' then '8MACHINE_COST'"+
					"when T1.resType like 'CONTRACTOR_COST%' then '9CONTRACTOR_COST'"+
					             " else '9OTHER' end ) as c7 ,T1.uom, T1.estimateQty, T1.estimateCost ,T1.unitPrice"+
					"	 from 	  Pcesthtt T2, Pcestdtt T1 "+
					 " where 	T2.id.estimateNo=T1.id.estimateNo and " +
					  " T2.id.deptId=T1.id.deptId and "+
					" T2.id.revNo = 1 and T1.id.revNo = 1  and "+
					" trim(T2.id.estimateNo)=:estimateNo and "+
					" T2.id.deptId=:costCenter    and T1.id.resCd not in ('OTHER-MATERIAL')"+
					" Group by  case  when T1.resType is null or T1.resType like '%MAT%' then '1MAT' "+
					" when T1.resType like 'LABOUR%' then '4LAB' "+
					" when T1.resType like 'WAY%' then '2WAY' "+
					" when T1.resType like 'TRANSPORT%' then '3TRANSPORT'"+
					" when T1.resType like 'SUBSISTANCE%' then '5SUBSISTANCE'"+
					" when T1.resType like 'CONTINGENCIE%' then '6CONTINGENCIE'"+
					" when T1.resType like 'OVERHEAD%' then '7OVERHEAD'"+
					" when T1.resType like 'MACHINE_COST%' then '8MACHINE_COST'"+
					" when T1.resType like 'CONTRACTOR_COST%' then '9CONTRACTOR_COST'"+
					 " else '9OTHER' end ,  T1.id.resCd , T1.uom, T1.estimateQty, T1.estimateCost ,"+
					"T1.unitPrice,T2.id.estimateNo,T2.id.deptId"+
					 " Order by case  when T1.resType is null or T1.resType like '%MAT%' then '1MAT'"+
					 " when T1.resType like 'LABOUR%' then '4LAB'"+
					" when T1.resType like 'WAY%' then '2WAY'"+
					" when T1.resType like 'TRANSPORT%' then '3TRANSPORT'"+
					" when T1.resType like 'SUBSISTANCE%' then '5SUBSISTANCE'"+
					" when T1.resType like 'CONTINGENCIE%' then '6CONTINGENCIE'"+
					" when T1.resType like 'OVERHEAD%' then '7OVERHEAD'"+
					" when T1.resType like 'MACHINE_COST%' then '8MACHINE_COST'"+
					" when T1.resType like 'CONTRACTOR_COST%' then '9CONTRACTOR_COST'"+
					            "  else '9OTHER' end ,2";

		}else{
			qryStr ="select T1.id.resCd, "+
					"( CASE  WHEN T1.resType IS NULL OR T1.resType like '%MAT%' THEN '1MAT'"+
					" when T1.resType like 'LABOUR%' then '4LAB'"+
					"when T1.resType like 'WAY%' then '2WAY'"+
					"when T1.resType like 'TRANSPORT%' then '3TRANSPORT'"+
					"when T1.resType like 'SUBSISTANCE%' then '5SUBSISTANCE'"+
					"when T1.resType like 'CONTINGENCIE%' then '6CONTINGENCIE'"+
					"when T1.resType like 'OVERHEAD%' then '7OVERHEAD'"+
					"when T1.resType like 'MACHINE_COST%' then '8MACHINE_COST'"+
					"when T1.resType like 'CONTRACTOR_COST%' then '9CONTRACTOR_COST'"+
					             " else '9OTHER' end ) as c7 ,T1.uom, T1.estimateQty, T1.estimateCost ,T1.unitPrice"+
					"	 from 	  Pcesthtt T2, Pcestdtt T1 "+
					 " where 	T2.id.estimateNo=T1.id.estimateNo and " +
					  " T2.id.deptId=T1.id.deptId and "+
					" T2.id.revNo = 2 and T1.id.revNo = 2  and "+
					" trim(T2.id.estimateNo)=:estimateNo and "+
					" T2.id.deptId=:costCenter    and T1.id.resCd not in ('OTHER-MATERIAL')"+
					" Group by  case  when T1.resType is null or T1.resType like '%MAT%' then '1MAT' "+
					" when T1.resType like 'LABOUR%' then '4LAB' "+
					" when T1.resType like 'WAY%' then '2WAY' "+
					" when T1.resType like 'TRANSPORT%' then '3TRANSPORT'"+
					" when T1.resType like 'SUBSISTANCE%' then '5SUBSISTANCE'"+
					" when T1.resType like 'CONTINGENCIE%' then '6CONTINGENCIE'"+
					" when T1.resType like 'OVERHEAD%' then '7OVERHEAD'"+
					" when T1.resType like 'MACHINE_COST%' then '8MACHINE_COST'"+
					" when T1.resType like 'CONTRACTOR_COST%' then '9CONTRACTOR_COST'"+
					 " else '9OTHER' end ,  T1.id.resCd , T1.uom, T1.estimateQty, T1.estimateCost ,"+
					"T1.unitPrice,T2.id.estimateNo,T2.id.deptId"+
					 " Order by case  when T1.resType is null or T1.resType like '%MAT%' then '1MAT'"+
					 " when T1.resType like 'LABOUR%' then '4LAB'"+
					" when T1.resType like 'WAY%' then '2WAY'"+
					" when T1.resType like 'TRANSPORT%' then '3TRANSPORT'"+
					" when T1.resType like 'SUBSISTANCE%' then '5SUBSISTANCE'"+
					" when T1.resType like 'CONTINGENCIE%' then '6CONTINGENCIE'"+
					" when T1.resType like 'OVERHEAD%' then '7OVERHEAD'"+
					" when T1.resType like 'MACHINE_COST%' then '8MACHINE_COST'"+
					" when T1.resType like 'CONTRACTOR_COST%' then '9CONTRACTOR_COST'"+
					            "  else '9OTHER' end ,2";

		}
		
		 
		List<Object[]> list = null;
		try {
			
			Query query = null;
			query = em.createQuery(qryStr);
		    query.setParameter("estimateNo", estimateNo);
		    query.setParameter("costCenter", deptId);
			

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Pcesthtt> getApprovalListES(String dept_id, String status) {


		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select a "+
					" from Pcesthtt a where a.id.revNo IN (1,2) and  a.status =:statusnew and trim(a.id.deptId) =:dept_id order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    query.setParameter("statusnew", new BigDecimal(status));
		    query.setParameter("dept_id",dept_id );
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		
		return null;
	}
	
	@Override
	public List<Pcesthtt> getApprovalListESSFV(String dept_id,String userName,String status) {


		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			//qryStr = "select a "+
				//	" from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.entBy) =:usrId and  a.status =:status and trim(a.id.deptId) =:dept_id order by a.id.deptId";
			qryStr = "select a "+
						" from Pcesthtt a , SpestedyCon b  where a.id.revNo IN (1,2) and trim(b.allocatedTo) =:usrId and  a.status =:status and trim(a.id.estimateNo) = trim(b.westimateNo)";
								
		    query = em.createQuery(qryStr);
		   query.setParameter("status", new BigDecimal(status));
		   // query.setParameter("dept_id",dept_id );
		    query.setParameter("usrId",userName.trim() );
			   
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		
		return null;
	}
	@Override
	public Pcesthtt getPcesthttForIntialCost(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		try{
			Query query=null;
			BigDecimal totalCost = null;
			String status = null;
			Double dbTotalCost=0.0;
			String qryStr = "SELECT min(p.id.revNo) FROM Pcesthtt p  WHERE TRIM(p.id.estimateNo)=:estimateNo  AND TRIM(p.id.deptId)= :deptId order by p.etimateDt DESC";
			query = em.createQuery(qryStr);
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", deptId.trim());
			long minRevNo = (Long)query.getSingleResult();
		
			System.out.print("minRevNo : "+ minRevNo);
			//String qryStrNew = "SELECT p FROM Pcesthtt p  WHERE TRIM(p.id.estimateNo)=:estimateNo AND trim(p.id.revNo) =trim(:minRevNo) AND TRIM(p.id.deptId)= :deptId order by p.etimateDt DESC";
			String qryStrNew = "SELECT p FROM Pcesthtt p  WHERE TRIM(p.id.estimateNo)=:estimateNo AND TRIM(p.id.deptId)= :deptId order by p.id.revNo ASC";
			
			System.out.print("minRevNo : "+ qryStrNew);
				
			query = em.createQuery(qryStrNew);
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", deptId.trim());
			//query.setParameter("revNo", minRevNo);
			System.out.print("minRevNo : "+ (Pcesthtt)query.getResultList().get(0));
			
			return (Pcesthtt)query.getResultList().get(0);
		
			}catch(Exception e){
				System.out.print("error : "+ e);
				
			}
			
			return null;	}
	@Override
	public List<Pcesthtt> getAllEstimate(String dept_id, List<String> status) {
try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select a "+
					" from Pcesthtt a where a.id.revNo IN (1,2) and  a.status IN (:statusList) and trim(a.id.deptId) =:dept_id order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		   // query.setParameter("statusnew", new BigDecimal(status));
		    query.setParameter("dept_id",dept_id );
		    query.setParameter("statusList",status);
		    
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;
	}
	@Override
	public List<Pcesthtt> getApprovalListNewStatus(String usrLevel,String usrName, String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			if(usrLevel.equalsIgnoreCase("ES")){
				
				qryStr = "select a from Pcesthtt a where  a.id.revNo IN (1,2) and a.id.deptId =:dept_id and a.status IN (75,46,47,48,49,31)   order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("dept_id", dept_id);
			    //query.setParameter("usrName", usrName);

				
			}
			else if(usrLevel.equalsIgnoreCase("EE")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				//String authorizedCostCenter ="('"+dept_id.trim()+"')";
				
				qryStr = "select a "+
						" from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			   // query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				//String authorizedCostCenter ="('"+dept_id.trim()+"')";
					
			qryStr = "select a "+
					" from Pcesthtt a where a.id.revNo IN (1,2) and a.status IN (75,44,46,47,48,49,31) and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
		    query = em.createQuery(qryStr);
		    //query.setParameter("statusnew", new BigDecimal(status));
		    System.out.println("qryStr :"+qryStr);

			}

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

return null;
	}


}
