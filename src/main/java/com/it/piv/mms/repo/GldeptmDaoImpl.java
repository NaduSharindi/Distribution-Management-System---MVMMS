package com.it.piv.mms.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Gldeptm;

@Transactional
@Repository
public class GldeptmDaoImpl implements GldeptmDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public String getDD(String deptId) {
		try {
			String qryStr = "select a.compId from Gldeptm a where a.deptId =:deptId";
			Query query = em.createQuery(qryStr);
			query.setParameter("deptId",deptId);
			return (String)query.getSingleResult();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Gldeptm> getArea(String deptId) {
		//select dept_id,dept_nm from gldeptm where comp_id in (select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00';
		String qryStr = "";
		deptId = deptId.trim();
		try {
			if(deptId.equals("780.00")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('UVAP','WPSII','SABP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if (deptId.equals("596.00")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NWP2','NWP','NP','NCP','CC') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if (deptId.equals("597.00")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NWP2','NWP','NP','NCP','CC') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if (deptId.equals("972.30")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('SP','WPS1','SP2') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if (deptId.equals("972.20")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('SP','WPS1','SP2') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}
			else{
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP','EP','WPN','CP2') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.deptId";
				
			}
			Query query = em.createQuery(qryStr);
			//query.setParameter("deptId",deptId);
			return query.getResultList();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Gldeptm> getAreaByDisDiv(String dist) {
		//select dept_id,dept_nm from gldeptm where comp_id in (select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00';
		
		try {
			String qryStr = "select a from Gldeptm a where a.compId=:dist  and a.deptId like '%.00' ORDER BY a.compId";
			Query query = em.createQuery(qryStr);
			query.setParameter("dist",dist);
			return query.getResultList();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Gldeptm> getAreaByProvince(String province) {
		// TODO Auto-generated method stub
		try {
			String qryStr = "";
			province =province.trim();
			//List<String> strProvince = new ArrayList<String>();
			//List<String> supplierNames = Arrays.asList(province);
			//System.out.println("hiiii - getAreaByProvince" +province );
			
			
			//qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in (:province) and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
			//qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
			
			if(province.equalsIgnoreCase("CP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00'  and a.deptId NOT IN ('433.00','432.00','431.00','472.00','439.00','556.00') ORDER BY a.compId";
					
			}else {
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}/**else if(province.equalsIgnoreCase("EP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("UVAP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('UVAP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("WPSII")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPSII') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("SABP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('SABP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("NWP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NWP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("NP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("NCP")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NCP') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else if(province.equalsIgnoreCase("CC")){
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CC') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}else{
				qryStr = "select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('TEST') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
				
			}
			*/
			//System.out.println("hiiii - getAreaByProvince");
			Query query = em.createQuery(qryStr);
			//query.setParameter("province",supplierNames);
			//System.out.println("hiiii - getAreaByProvince : " + query.toString());
			
			return query.getResultList();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String getName(String deptId) {
		try {
			String qryStr = "select a.deptNm from Gldeptm a where a.deptId =:deptId";
			Query query = em.createQuery(qryStr);
			query.setParameter("deptId",deptId);
			return (String)query.getSingleResult();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Gldeptm> getCscByArea(String deptId) {
		// TODO Auto-generated method stub
		try {
			String sql = "select a from Gldeptm a, Glcompm b where a.compId=b.compId and a.compId=(select a.compId from Gldeptm a where a.deptId= '"+deptId+"')";
			//System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<String> getAreaByProvinceNew(String province) {
		try {
			String qryStr = "";
			province =province.trim();
			qryStr = "select a.deptId from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
			Query query = em.createQuery(qryStr);
			
			return query.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	
	@Override
	public List<String> getAreaByProvinceNewCC(String province) {
		try {
			String qryStr = "";
			province =province.trim();
			if(province.equals("CP")){
				List<String> supplierNames = Arrays.asList("471.00", "470.00", "474.00","434.00","435.00","437.00","436.00");
return supplierNames;
				
				//qryStr = "select a.deptId from Gldeptm a where a.compId in ('471.00','470.00','474.00','434.00','435.00','437.00','436.00')  ORDER BY a.compId";
				
			}else{
			qryStr = "select a.deptId from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ORDER BY a.compId";
			}
			Query query = em.createQuery(qryStr);
			
			return query.getResultList();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	@Override
	public List<String> getAreaByProvinceNewCP2(String province) {
		
		List<String> supplierNames = Arrays.asList("433.00", "432.00", "431.00","434.00","472.00","439.00","556.00","496.00","492.00","491.00","494.00","493.00","497.00","495.00");
		return supplierNames;
						
		
	}


	@Override
	public List<Gldeptm> getDeptIdByCompId(String phmunit) {
		try {
			String sql = "select a from Gldeptm a where trim(a.compId) =:phmunit";
			Query query = em.createQuery(sql);
			query.setParameter("phmunit",phmunit);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}
