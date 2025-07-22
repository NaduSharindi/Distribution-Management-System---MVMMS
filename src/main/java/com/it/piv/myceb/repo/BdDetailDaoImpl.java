package com.it.piv.myceb.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.myceb.domain.BdDetail;
import com.it.piv.myceb.domain.ComData;
import com.it.piv.myceb.domain.OMSModel;
import com.it.piv.util.common.Util;

@Transactional
@Repository
public class BdDetailDaoImpl implements BdDetailDao{
	
	@Autowired
	private EntityManager em;


	@Override
	public String save(BdDetail obj) {
		try {
			String sequence="0";
			System.out.println("getNextApplicationNo");
			String strQuery="select a from BdDetail a";
			Query query=em.createQuery(strQuery);
			List<BdDetail> list=query.getResultList();
			System.out.println("getNextApplicationNoList:" + list);
			
			if (list.size()!=0){
				sequence=String.valueOf(list.size());
				System.out.println(sequence);
			}
			
			
			obj.setRefNo(Util.COMPLAIN_CODE +sequence);
			em.persist(obj);
			return obj.getRefNo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "N";
		}
	}


	@Override
	public List<Object[]> getPendingBD(String status) {
		try {
			
			//
			//select a.*,b.*,d.*,c.* from bd_details a ,dm_customerlocation b,cus_data d,mob_users c where a.acct_num = b.acctnumber and d.ACCT_NUMBER=a.ACCT_NUM and c.cc_code=d.area_code;
			//select a.*,b.* from bd_details a ,dm_customerlocation b where a.acct_num = b.acctnumber and a.status ='Pending';
			String strQuery="select a,b,d,c from BdDetail a ,DmCustomerlocation  b ,CusData d,MobUser c  where a.acctNum = b.id.acctnumber and  d.acctNumber =a.acctNum and c.ccCode=d.areaCode and   a.status =:status";
			Query query=em.createQuery(strQuery);
			query.setParameter("status", status);
			return query.getResultList();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void addComplaint(BdDetail applicant) {
		em.persist(applicant);
		
	}
	@Override
	public List<BdDetail> findByAccNo(String accNo) {
		 System.out.print("AccNo "+accNo);
		// TODO Auto-generated method stub
		TypedQuery<BdDetail> query =
				em.createQuery
				("SELECT cd "
				+ "FROM BdDetail cd "
				+ "WHERE cd.acctNum= :acNum", BdDetail.class) ;
					   
					 query.setParameter("acNum", accNo); 
					 System.out.print(query);
					return query.getResultList();
	}
	@Override
	public ComData findById(String id) {
		// TODO Auto-generated method stub
		return em.find(ComData.class, id);
	}


	@Override
	public List<BdDetail> findByStatus(String statu) {
		// TODO Auto-generated method stub
		 System.out.print("statu "+statu);
			// TODO Auto-generated method stub
			TypedQuery<BdDetail> query =
					em.createQuery
					("SELECT cd "
					+ "FROM BdDetail cd "
					+ "WHERE cd.status= :status", BdDetail.class) ;
						   
						 query.setParameter("status",statu ); 
						 System.out.print(query);
						return query.getResultList();
	}
	

}
