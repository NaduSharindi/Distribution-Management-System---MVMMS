package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Appestlim;
import com.it.piv.mms.domain.Spstdesthmt;
import com.it.piv.mms.domain.SpstdesthmtPK;
import com.it.piv.util.common.StandardEstimateStatus;

@Transactional
@Repository
public class SpstdesthmtDaoImpl implements SpstdesthmtDao{
	
	@Autowired
	private EntityManager em;
	

	@Override
	public List<Object[]> getApprovalList(String usrName, String usrLevel) {
		// TODO Auto-generated method stub
		
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			status ="40";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			status ="30";
		}else if(usrLevel.equalsIgnoreCase("PCE")){
			status ="35";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			status ="10";
		}else if(usrLevel.equalsIgnoreCase("PE")){
			status ="20";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			status ="44";
		}else{
			
		}
		
		
		
		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			/*if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				System.out.println("authorizedCostCenter : "+authorizedCostCenter);
				qryStr = "select count(a.id.appNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId),a.id.deptId,e.applicationType "+
						"from Spstdesthmt a, Application e where a.assignedto =:assignedto and  a.id.appNo = e.applicationNo and a.status =:status and a.id.deptId IN "+authorizedCostCenter+ " group by a.id.deptId, e.applicationType";
				System.out.println("str :"+qryStr);		
			    query = em.createQuery(qryStr);
			    query.setParameter("status", new BigDecimal(status));
			    query.setParameter("assignedto", usrName);
				
				
			}else{
			*/	//select count(a.app_no),a.dept_id,(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.dept_id) AS name ,e.application_type
				//from spstdesthmt a ,applications e where a.app_no = e.application_no and  a.status = 50 and a.dept_id IN (select s.dept_id from SAUSRDPM s where s.user_id ='DGMWPN')
				//group by a.dept_id,e.application_type

					
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			System.out.println("authorizedCostCenter : "+authorizedCostCenter);
			qryStr = "select count(a.id.appNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId),a.id.deptId,e.applicationType "+
					"from Spstdesthmt a, Application e where a.id.appNo = e.applicationNo and a.status =:status and a.id.deptId IN "+authorizedCostCenter+ " group by a.id.deptId, e.applicationType";
			System.out.println("str :"+qryStr);		
		    query = em.createQuery(qryStr);
		    query.setParameter("status", new BigDecimal(status));
			
		    
		  //  }

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		return null;
	}
	
	
	@Override
	public List<Spstdesthmt> getApprovalListSPS(String usrName, String usrLevel) {
		// TODO Auto-generated method stub
		
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="40";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="30";
		}else if(usrLevel.equalsIgnoreCase("PCE")){
			System.out.println("CE :");

			status ="35";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="10";
		}else if(usrLevel.equalsIgnoreCase("PE")){
			System.out.println("EE :");

			status ="20";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}		System.out.println("status :"+status);

		
		
		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			/*if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				System.out.println("authorizedCostCenter : "+authorizedCostCenter);
				qryStr = "select count(a.id.appNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId),a.id.deptId,e.applicationType "+
						"from Spstdesthmt a, Application e where a.assignedto =:assignedto and  a.id.appNo = e.applicationNo and a.status =:status and a.id.deptId IN "+authorizedCostCenter+ " group by a.id.deptId, e.applicationType";
				System.out.println("str :"+qryStr);		
			    query = em.createQuery(qryStr);
			    query.setParameter("status", new BigDecimal(status));
			    query.setParameter("assignedto", usrName);
				
				
			}else{
			*/	//select count(a.app_no),a.dept_id,(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.dept_id) AS name ,e.application_type
				//from spstdesthmt a ,applications e where a.app_no = e.application_no and  a.status = 50 and a.dept_id IN (select s.dept_id from SAUSRDPM s where s.user_id ='DGMWPN')
				//group by a.dept_id,e.application_type

					
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			System.out.println("authorizedCostCenter : "+authorizedCostCenter);
			qryStr = "select a from Spstdesthmt a  where a.status =:status and a.id.deptId IN "+authorizedCostCenter;
			System.out.println("str :"+qryStr);		
		    query = em.createQuery(qryStr);
		    query.setParameter("status", new BigDecimal(status));
			
		    
		  //  }

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		
		return null;
	}



	@Override
	public Long getApprovalListCount(String usrName, String usrLevel) {
		// TODO Auto-generated method stub
		
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="40";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="30";
		}else if(usrLevel.equalsIgnoreCase("PCE")){
			System.out.println("CE :");

			status ="35";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="10";
		}else if(usrLevel.equalsIgnoreCase("PE")){
			System.out.println("EE :");

			status ="20";
		}else if(usrLevel.equalsIgnoreCase("EA")){
			System.out.println("EA :");

			status ="45";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("ES :");

			status ="44";
		}else{
			
		}
		System.out.println("status :"+status);

		
		System.out.println("status :"+status);

		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			/*if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
						"from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and a.id.deptId IN "+authorizedCostCenter+ " group by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("usrId",usrName );
					
				
				
			}else{
			*/	//select count(a.app_no),a.dept_id,(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.dept_id) AS name ,e.application_type
				//from spstdesthmt a ,applications e where a.app_no = e.application_no and  a.status = 50 and a.dept_id IN (select s.dept_id from SAUSRDPM s where s.user_id ='DGMWPN')
				//group by a.dept_id,e.application_type

					
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			System.out.println("authorizedCostCenter : "+authorizedCostCenter);
			qryStr = "select count(a.id.appNo) from Spstdesthmt a where a.status =:status and a.id.deptId IN "+authorizedCostCenter;
			System.out.println("str :"+qryStr);		
		    query = em.createQuery(qryStr);
		    query.setParameter("status", new BigDecimal(status));
			
		    
		    //}

			return (Long)query.getSingleResult();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		return null;
	}


	@Override
	public List<Object[]> getApprovalDetailList(String usrName, String usrLevel,String type) {
		// TODO Auto-generated method stub
		
		String status="";
		if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status ="49";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="40";
		}else if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="30";
		}else if(usrLevel.equalsIgnoreCase("PCE")){
			System.out.println("CE :");

			status ="35";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("EE :");

			status ="10";
		}else if(usrLevel.equalsIgnoreCase("PE")){
			System.out.println("EE :");

			status ="20";
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
			/*if(usrLevel.equalsIgnoreCase("EE") || usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
						"from Pcesthtt a where a.id.revNo IN (1,2) and trim(a.aprUid5) =:usrId and a.id.deptId IN "+authorizedCostCenter+ " group by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("usrId",usrName );
					
				
				
			}else{
				//select count(a.app_no),a.dept_id,(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.dept_id) AS name ,e.application_type
				//from spstdesthmt a ,applications e where a.app_no = e.application_no and  a.status = 50 and a.dept_id IN (select s.dept_id from SAUSRDPM s where s.user_id ='DGMWPN')
				//group by a.dept_id,e.application_type

*/					
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			System.out.println("authorizedCostCenter : "+authorizedCostCenter);
			qryStr = "select a.id.appNo,a.id.deptId,a.jobname,a.nbtcost,a.rebateCost,a.secdeposit,a.toconpay,a.vatcost,a.cebcost,a.description "+
					"from Spstdesthmt a, Application e where a.id.appNo = e.applicationNo and e.applicationType=:appType and a.status =:status and a.id.deptId IN "+authorizedCostCenter+ " order by a.id.deptId, e.applicationType";
			System.out.println("str :"+qryStr);		
		    query = em.createQuery(qryStr);
		    query.setParameter("status", new BigDecimal(status));
		    query.setParameter("appType",type.trim() );
			
		    
		  //  }

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}

		
		
		

		return null;
	}


	@Override
	public Spstdesthmt findById(SpstdesthmtPK pk) {
		// TODO Auto-generated method stub
		return em.find(Spstdesthmt.class, pk);
	}


	@Override
	public void update(Spstdesthmt pk) {
		// TODO Auto-generated method stub
		em.merge(pk);
	}


	@Override
	public List<Object[]> getApprovalDetailListDmt(String appNo,
			String deptId) {
		
		try{
	    Query query = null;
			
		String qryStr = "select f.id.lineType,f.linedes, f.length, f.lineCost,f.uom,f.estCost,"+
				"( case  when f.id.lineType is null or f.id.lineType like 'OTH%' or f.id.lineType like 'A%' or f.id.lineType like 'B%' or f.id.lineType like 'H%' or f.id.lineType like 'K%' or f.id.lineType like 'L%' or f.id.lineType like 'P%' or f.id.lineType like 'C%' or f.id.lineType like 'D%' or f.id.lineType like 'E%' or f.id.lineType like 'H%' or f.id.lineType like 'S%' then 'OTHER ITEM' "+
				" when f.id.lineType like 'RB%' then 'REBATE ITEM' "+
				" when f.id.lineType like 'CEB%' then 'CEB' "+
				" else 'ITEM' end ) as c7 "+
				" from Spstdesthmt e,Spstdestdmt f "+
				" where e.id.appNo = f.id.appNo and e.id.deptId = f.deptId "+
				" and e.id.deptId=:deptid "+
				" and  trim(e.id.appNo) =:appNo "+
				" Group by  case  when f.id.lineType is null or f.id.lineType like 'OTH%' then '2OTH'"+
				" when f.id.lineType like 'RB%' then '3RB' "+
				" else '1MAT' end ,f.id.lineType,f.linedes, f.length, f.lineCost,f.uom,f.estCost "+
				" Order by c7";
		
		
		query = em.createQuery(qryStr);
		 query.setParameter("deptid", deptId.trim());
		    query.setParameter("appNo",appNo.trim() );
			
	    return query.getResultList();
		}catch(Exception e){
			System.out.println("e :"+e);
		}
		
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Spstdesthmt selectStdNoDeptId(String appNo, String deptid) {
		Query query = null;
		String qryStr ="";
		try {
			qryStr = "select a from Spstdesthmt a where trim(a.id.appNo) =:appNo and trim(a.id.deptId) =:deptid ";
			query = em.createQuery(qryStr);
			query.setParameter("appNo", appNo.trim());
			query.setParameter("deptid", deptid.trim());
			
			List<Spstdesthmt> list = query.getResultList();
			
			
			if(list.size()==0){
				return null;
			}else{
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
	}


	@Override
	public List<Spstdesthmt> getEstimateList(String deptId) {
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select a from Spstdesthmt a  where a.id.deptId =:deptId and (a.id.appNo like '%/21/%' or a.id.appNo like '%/20/%' or a.id.appNo like '%/19/%')";
			System.out.println("str :"+qryStr);		
		    query = em.createQuery(qryStr);
		    query.setParameter("deptId",deptId);
			

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}
	
	@Override
	public List<Spstdesthmt> getEstimateList(String deptId,String status) {
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select a from Spstdesthmt a  where a.status =:status and  a.id.deptId =:deptId and (a.id.appNo like '%/21/%' or a.id.appNo like '%/20/%' or a.id.appNo like '%/19/%')";
			System.out.println("str :"+qryStr);		
		    query = em.createQuery(qryStr);
		    query.setParameter("deptId",deptId);
		    query.setParameter("status",status);
			

			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}



	@Override
	public List<Object[]> getApprovalListDetail(String appNO,String deptID) {
try {

			String qryStr ="";
			Query query = null;
			qryStr = "select f,g,a,d,c,b from WiringLandDetailCon a , ApplicationReference d , WiringLandDetail c , Applicant f ,Application g , Spstdesthmt b where "
		              + " a.id.applicationId = d.id.applicationId and"
		              + " trim(d.applicationNo) = trim(b.id.stdNo) and"
		              + " c.id.applicationId = d.id.applicationId and"
		              + " f.idNo = d.idNo and"
		              + " g.id.applicationId = d.id.applicationId "
		              + " and trim(b.id.appNo) =:appNo";
		    query = em.createQuery(qryStr);
		    query.setParameter("appNo",appNO.trim());
		    return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
		return null;

	}


	

}
