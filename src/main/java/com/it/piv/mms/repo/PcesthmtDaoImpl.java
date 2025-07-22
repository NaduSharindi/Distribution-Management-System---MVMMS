 package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.repo.PcesthmtDao;
import com.it.piv.util.common.EstimateStatus;

@Transactional
@Repository
public class PcesthmtDaoImpl implements PcesthmtDao {
	
	@Autowired
	private EntityManager em;
	

	@Override
	public List<Object[]> getApprovalList(String usrLevel) {
		List<Object[]> list = null;
		try {
			
			String status ="";
			if(usrLevel.equalsIgnoreCase("CE")){
				System.out.println("CE :");

				status ="61";
			}else if(usrLevel.equalsIgnoreCase("DGM")){
				System.out.println("DGM :");

				status ="58";
			}else if(usrLevel.equalsIgnoreCase("EE")){
				System.out.println("DGM :");

				status ="57";
			}

			String qryStr ="";
			Query query = null;
			
			//qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) , a.id.deptId from Pcesthtt a where a.id.revNo IN (1,2) and a.status = 48 and a.id.deptId IN (select s.id.deptId from Sausrdpm s where s.id.userId ='DGMWPN') group by a.id.deptId";
			/*qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) , a.id.deptId "+
			"from Pcesthtt a where a.id.revNo IN (1,2) and a.status = 48 and a.id.deptId IN "+
			"(select s.id.deptId from Sausrdpm s where s.id.userId IN ('DGMWPN')) group by a.id.deptId";
            */
			qryStr = "select count(a.id.estimateNo),(select b.deptNm from Gldeptm b  where b.deptId =a.id.deptId) ,a.id.deptId "+
					"from Pcesthtt a where a.id.revNo IN (1,2) and a.status =:status and a.id.deptId IN (select s.id.deptId from Sausrdpm s where trim(s.id.userId) ='DGMWPN') group by a.id.deptId";
		            
			//qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('UVAP','WPSII','SABP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
			
			
			query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
		    
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
				
				
		return null;

	}


	@Override
	public BigDecimal getTotalCOst(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long getApprovalListCount(String usrName, String usrLevel) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrName=usrName.trim();
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");

			status ="61";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status ="58";
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("DGM :");

			status ="57";
		}else if(usrLevel.equalsIgnoreCase("ES")){
			System.out.println("DGM :");

			status ="5";
		}


		System.out.println("status :"+status);

		usrName = usrName.trim();
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			
			if(usrLevel.equalsIgnoreCase("EE")){
			
				qryStr = "select count(a.id.estimateNo) from Pcesthmt a where trim(a.aprUid5) =:usrId and a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
				
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId", usrName);
					
			}else if(usrLevel.equalsIgnoreCase("ES")){
			
				qryStr = "select count(a.id.estimateNo) from Pcesthmt a where  a.status IN (5,25,41) and a.id.deptId IN "+authorizedCostCenter;
				
			    query = em.createQuery(qryStr);
			    //query.setParameter("statusnew", new BigDecimal(status));
			    //query.setParameter("usrId", usrName);
					
			} else{
			
			qryStr = "select count(a.id.estimateNo) from Pcesthmt a where a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
						
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
	public List<Pcesthmt> getProjectNoByStatus() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Pcesthmt> findByCostCenterEstimateNo(String costCenter,String estimateNo) {
		try {
			String qryStr = "select p from Pcesthmt p  where trim(p.projectNo) =:estimateNo and  trim(p.id.deptId) = :deptId";
			Query query = em.createQuery(qryStr);
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", costCenter.trim());
			
			List<Pcesthmt> list = query.getResultList();
			System.out.println("e :"+list);
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public void update(Pcesthmt obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
	}


	@Override
	public void updatePcesthmt(String costCenter, String estimateNo,String newCostCenter) {
		// TODO Auto-generated method stub
		try {
			String qryStr = "update Pcesthmt p set p.id.deptId =:newCostCenter where trim(p.projectNo) =:estimateNo and  trim(p.id.deptId) = :deptId";
			Query query = em.createQuery(qryStr);
			query.setParameter("newCostCenter", newCostCenter.trim());
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", costCenter.trim());
			
			query.executeUpdate();
			} catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	@Override
	public void jobReopen(String costCenter, String estimateNo) {
		// TODO Auto-generated method stub
		try {
			String qryStr = "update Pcesthmt p set p.status =1 , p.label9='A' where trim(p.projectNo) =:estimateNo and  trim(p.id.deptId) = :deptId";
			Query query = em.createQuery(qryStr);
			//query.setParameter("newCostCenter", newCostCenter.trim());
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", costCenter.trim());
			
			query.executeUpdate();
			} catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	
	@Override
	public List<Pcesthmt> getJobNoByStatus(String status, String deptId) {
		Query query=null;
		try {
			String qryStr ="";
			query = null;
			
			qryStr = "select a from Pcesthmt a where a.status =:statusnew and a.id.deptId=:deptId";
			
			query = em.createQuery(qryStr);
			query.setParameter("statusnew", new BigDecimal(status));
			query.setParameter("deptId", deptId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	    return query.getResultList();
	}
	
	@Override
	public List<Pcesthmt> getApprovalListAENew(String usrLevel, String usrName,
			String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");
			status = EstimateStatus.JOB_APPROVAL_CE;
			//status ="61";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status = EstimateStatus.JOB_APPROVAL_DGM;
		}else if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status = EstimateStatus.JOB_APPROVAL_AGM;
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("AGM :");

			status = EstimateStatus.JOB_APPROVAL_EE;
		}


		System.out.println("status :"+status);

		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select a "+
						" from Pcesthmt a where trim(a.aprUid5) =:usrId and a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else if(usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select a "+
						" from Pcesthmt a where a.status IN (5,25,41) and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    //query.setParameter("statusnew", new BigDecimal(status));
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			qryStr = "select a "+
					" from Pcesthmt a where a.status =:statusnew and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
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
	public List<Pcesthmt> getApprovalListAENewStatus(String usrLevel, String usrName,
			String dept_id) {
		System.out.println("usrLevel :"+usrLevel);
		System.out.println("usrName :"+usrName);
		usrLevel = usrLevel.trim();
		String status="";
		if(usrLevel.equalsIgnoreCase("CE")){
			System.out.println("CE :");
			status = EstimateStatus.JOB_APPROVAL_CE;
			//status ="61";
		}else if(usrLevel.equalsIgnoreCase("DGM")){
			System.out.println("DGM :");

			status = EstimateStatus.JOB_APPROVAL_DGM;
		}else if(usrLevel.equalsIgnoreCase("AGM")){
			System.out.println("AGM :");

			status = EstimateStatus.JOB_APPROVAL_AGM;
		}else if(usrLevel.equalsIgnoreCase("EE")){
			System.out.println("AGM :");

			status = EstimateStatus.JOB_APPROVAL_EE;
		}


		System.out.println("status :"+status);

		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			if(usrLevel.equalsIgnoreCase("EE")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select a "+
						" from Pcesthmt a where trim(a.aprUid5) =:usrId and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    //query.setParameter("statusnew", new BigDecimal(status));
			    query.setParameter("usrId",usrName );
					
			    System.out.println("qryStr :"+qryStr);

				
			}else if(usrLevel.equalsIgnoreCase("ES")){
				String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
				qryStr = "select a "+
						" from Pcesthmt a where a.status IN (5,25,41,1) and trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
							
			    query = em.createQuery(qryStr);
			    //query.setParameter("statusnew", new BigDecimal(status));
			    System.out.println("qryStr :"+qryStr);

				
			}else{
			String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			qryStr = "select a "+
					" from Pcesthmt a where trim(a.id.deptId) IN "+authorizedCostCenter+ " order by a.id.deptId";
						
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

	
	@Override
	public Pcesthmt getPcesthmt(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		try{
		Query query=null;
		BigDecimal totalCost = null;
		String status = null;
		Double dbTotalCost=0.0;
		String qryStr = "SELECT p FROM Pcesthmt p  WHERE TRIM(p.id.estimateNo)=:estimateNo  AND TRIM(p.id.deptId)= :deptId order by p.etimateDt DESC";
				
		query = em.createQuery(qryStr);
		query.setParameter("estimateNo", estimateNo.trim());
		query.setParameter("deptId", deptId);
		return (Pcesthmt)query.getResultList().get(0);
	
		}catch(Exception e){
			
		}
		
		return null;
	}
	


}
