package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Appestlim;

import javax.persistence.Query;


@Transactional
@Repository
public class AppestlimDaoImpl implements AppestlimDao {
	@Autowired
	private EntityManager em;
	

	@Override
	public Appestlim findAppEstLimits(String costCenterNo, String approvalType,
			String applicationType, String userLevel) {
		// TODO Auto-generated method stub
				System.out.println("hiiiiihy");
				System.out.println(costCenterNo + "  approvalType : " + approvalType +"   userLevel  : "+userLevel + "  applicationType  : "+ applicationType);
				StringBuffer buff = new StringBuffer();
				System.out.println("hiiiiihy2");
				buff.append("SELECT g  FROM Appestlim g where  g.id.deptId = :deptId ");
				if(applicationType != null){
					buff.append("AND g.id.applicationType = :applicationType ");
				}
				System.out.println("hiiiiihy3");
				buff.append(" AND g.id.approvalType = :approvalType AND g.id.userLevel = :userLevel ");
				Query query = em.createQuery(buff.toString());
				query.setParameter("deptId", costCenterNo);
				if(applicationType != null){
					query.setParameter("applicationType", applicationType);
				}
				System.out.println("hiiiiihy4");
				query.setParameter("approvalType", approvalType);
				query.setParameter("userLevel", userLevel);
				
				List<Appestlim> list = query.getResultList();
				System.out.println("hiiiiihy4 : " +list );
			
				
				if(list.size()==0){
					return null;
				}else{
					return list.get(0);
				}
				
		
		
	}

}
