package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Pcestdmt;
import com.it.piv.mms.domain.PcestdmtPK;
import com.it.piv.mms.domain.Pcesthmt;

@Transactional
@Repository
public class PcestdmtDaoImpl implements PcestdmtDao {
	@Autowired
	private EntityManager em;

	
	@Override
	public void save(Pcestdmt obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pcestdmt findById(PcestdmtPK pkPcestdmt) {
		// TODO Auto-generated method stub
		return em.find(Pcestdmt.class, pkPcestdmt);
	}
	
	@Override
	public List<Pcestdmt> findByCostCenterEstimateNo(String costCenter,
			String estimateNo) {
		try {
			String qryStr = "select p from Pcestdmt p  where p.id.estimateNo =:estimateNo and  p.id.deptId = :deptId";
			Query query = em.createQuery(qryStr);
			query.setParameter("estimateNo", estimateNo);
			query.setParameter("deptId", costCenter);
			
			List<Pcestdmt> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(Pcestdmt obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
	}
	
	@Override
	public void updatePcestdmt(String costCenter, String estimateNo,String newCostCenter) {
		// TODO Auto-generated method stub
		
		System.out.println("costCenter:"+ costCenter);
		System.out.println("estimateNo:"+ estimateNo);
		System.out.println("newCostCenter:"+ newCostCenter);
		
		try {
			String qryStr = "update Pcestdmt p set p.id.deptId =:newCostCenter where trim(p.id.estimateNo) =:estimateNo and  p.id.deptId = :deptId";
			Query query = em.createQuery(qryStr);
			query.setParameter("newCostCenter", newCostCenter.trim());
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", costCenter.trim());
			
			query.executeUpdate();
			} catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}

	
	
	

}
