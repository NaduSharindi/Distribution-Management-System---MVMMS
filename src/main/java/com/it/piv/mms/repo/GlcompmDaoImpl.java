package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.MmsAddearthconductortype;
import com.it.piv.mms.domain.MmsAddsupport;


@Transactional
@Repository
public class GlcompmDaoImpl  implements GlcompmDao{

	@Autowired
	private EntityManager em;

	@Override
	public List<Glcompm> getDistributionDivision() {
		try {
				String qryStr = "select a from Glcompm a where a.parentId = 'DIST' and a.compId like '%DISCO%' ORDER BY a.compId";
				Query query = em.createQuery(qryStr);
				List<Glcompm> list = query.getResultList();
				System.out.println("list : "+ list);
				return list;
				
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<Glcompm> getProvinces(String parentId) {
		// TODO Auto-generated method stub
		//System.out.println("CE CE 6");
		if(parentId.equalsIgnoreCase("DISCO2")){
			
			try {
				TypedQuery<Glcompm> query =
						em.createQuery
						("SELECT cd "
						+ "FROM Glcompm cd "
						+ "WHERE cd.parentId= :parentId  and cd.lvlNo=60 and cd.compId IN ('WPN','CP','CP2','EP') ", Glcompm.class) ;
							 query.setParameter("parentId",parentId.trim()); 
							 //System.out.print(query);
							 //System.out.println("CE CE 7" +parentId);
								
							return query.getResultList();
							
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		}else if(parentId.equalsIgnoreCase("DISCO1")){
			
			try {
				TypedQuery<Glcompm> query =
						em.createQuery
						("SELECT cd "
						+ "FROM Glcompm cd "
						+ "WHERE cd.parentId= :parentId  and cd.lvlNo=60 and cd.compId IN ('NWP','NP','NCP','NWP 2') ", Glcompm.class) ;
							 query.setParameter("parentId",parentId.trim()); 
							 //System.out.print(query);
							 //System.out.println("CE CE 7" +parentId);
								
							return query.getResultList();
							
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		}else if(parentId.equalsIgnoreCase("DISCO3")){
			
			try {
				TypedQuery<Glcompm> query =
						em.createQuery
						("SELECT cd "
						+ "FROM Glcompm cd "
						+ "WHERE cd.parentId= :parentId  and cd.lvlNo=60 and cd.compId IN ('UVAP','WPSII','SABP') ", Glcompm.class) ;
							 query.setParameter("parentId",parentId.trim()); 
							 //System.out.print(query);
							 //System.out.println("CE CE 7" +parentId);
								
							return query.getResultList();
							
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		}else if(parentId.equalsIgnoreCase("DISCO4")){
			
			try {
				TypedQuery<Glcompm> query =
						em.createQuery
						("SELECT cd "
						+ "FROM Glcompm cd "
						+ "WHERE cd.parentId= :parentId  and cd.lvlNo=60 and cd.compId IN ('SP','SP2','WPS1') ", Glcompm.class) ;
							 query.setParameter("parentId",parentId.trim()); 
							 //System.out.print(query);
							 //System.out.println("CE CE 7" +parentId);
								
							return query.getResultList();
							
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		}else{
		try {
			TypedQuery<Glcompm> query =
					em.createQuery
					("SELECT cd "
					+ "FROM Glcompm cd "
					+ "WHERE cd.parentId= :parentId  and cd.lvlNo=60 ", Glcompm.class) ;
						 query.setParameter("parentId",parentId.trim()); 
						 //System.out.print(query);
						 //System.out.println("CE CE 7" +parentId);
							
						return query.getResultList();
						
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		}
		
	}

	@Override
	public List<Glcompm> getArea(String parentId) {
		// TODO Auto-generated method stub
		System.out.println("getArea" + parentId);
		parentId = parentId.trim();
		try {
			TypedQuery<Glcompm> query =
					em.createQuery
					("SELECT cd "
					+ "FROM Glcompm cd "
					+ "WHERE cd.parentId= :parentId  and cd.lvlNo<60 ", Glcompm.class) ;
						 query.setParameter("parentId",parentId.trim()); 
						 System.out.print(query);
						return query.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public Glcompm getDistDivision2(String compId) {
		// TODO Auto-generated method stub
		//System.out.println("getArea" + compId);
		compId = compId.trim();
		try {
			
			
			/*TypedQuery<Glcompm> query =
					em.createQuery
					("SELECT cd "
					+ "FROM Glcompm cd "
					+ "WHERE cd.compId=:compId ", Glcompm.class) ;
						 query.setParameter("compId",compId.trim()); 
						 System.out.print(query);*/
			
			String qryStr = "SELECT a FROM Glcompm a WHERE trim(a.compId)=:compId";
			Query query = em.createQuery(qryStr);
			System.out.println("qryStr" + qryStr);
			query.setParameter("compId",compId);
			//Glcompm obj = (Glcompm)query.getResultList().get(0);
			System.out.println("qryStrquery.getResultList()" + query.getResultList().size());	
			if(query.getResultList().size() >0)
			{
				return (Glcompm) query.getResultList().get(0);
			}else{
									 
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public String getDistDivision(String province) {
		// TODO Auto-generated method stub
		//System.out.println(province +"hi");
		try {
			province =province.trim();
			//if  
			String qryStr = "select a.parentId from Glcompm a where trim(a.compId)=:pro";
			Query query = em.createQuery(qryStr);
			//System.out.println("qryStr1 :"+ qryStr);
			query.setParameter("pro",province.trim());
			//System.out.println("qryStr2 :"+ qryStr);
			//System.out.println("qryStrquery.getResultList()" + query.getResultList().size());	
			
			if(query.getResultList().size() >0)
			{
				
				return (String) query.getResultList().get(0);
			}else{
				return null;					 
			}
			
			
			
			
			//return (String)query.getSingleResult();
			//select parent_Id from Glcompm a where comp_Id='PHMR2'
			//String qryStr = "";
			//if(province.equalsIgnoreCase("PHMR2")){
			//	return "DISCO2";
				
			//}else {
			//	return "";
			//}
			//Query query = em.createQuery(qryStr);
			//query.setParameter("deptId",province);
			//System.out.println("qryStr1 :"+ qryStr);
			//return (String)query.getSingleResult();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
		
		
		
		
	}

	@Override
	public String getProvince(String compID) {
		// TODO Auto-generated method stub
		System.out.println("compID : "+ compID +" m");
		
		try {
			String qryStr = "select a.parentId from Glcompm a where trim(a.compId)=:companyid";
			Query query = em.createQuery(qryStr);
			query.setParameter("companyid",compID.trim());
			
			//String qryStr = "SELECT s FROM Sauserm s WHERE TRIM(s.userId)=:userNm";
			//Query query = em.createQuery(qryStr);
			//query.setParameter("userNm", userName.toUpperCase());
			
			String province =(String) query.getSingleResult();
			System.out.println("province : "+ province);
			return province;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Glcompm getGlcompmByProvince(String compID) {
		
		Glcompm objXXX =  null;
		
		try {
			String qryStr = "select a from Glcompm a where trim(a.compId)=:companyid";
			Query query = em.createQuery(qryStr);
			query.setParameter("companyid",compID.trim());
			System.out.println("province lll : "+ query.getResultList().size());
			
			if(query.getResultList().size() >0)
			{
				objXXX = (Glcompm) query.getResultList().get(0);
			}else{
									 
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return objXXX;
		}
		return objXXX;
	}

	@Override
	public List<Glcompm> getDisDivision() {
		try {
			TypedQuery<Glcompm> query =
					em.createQuery
					("SELECT cd "
					+ "FROM Glcompm cd "
					+ "WHERE cd.status= 2  and cd.lvlNo=70 ", Glcompm.class) ;
						 return query.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Glcompm> getProvincesPCB(String parentId) {
System.out.print("getProvincesgetProvinces : "+ parentId);
		
		parentId = parentId.trim();
		System.out.print("ffff : "+ parentId);
		
		try {
			TypedQuery<Glcompm> query =
					em.createQuery
					("SELECT cd "
					+ "FROM Glcompm cd "
					+ "WHERE trim(cd.parentId)= :parentId  and cd.lvlNo=60 ", Glcompm.class) ;
						 query.setParameter("parentId",parentId.trim()); 
						 System.out.print(query.getResultList().size());
						return query.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	
	
	

}
