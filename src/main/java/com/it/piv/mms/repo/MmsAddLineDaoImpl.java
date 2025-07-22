package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;





















































import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.MmsAddinsulatortype;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.Summary;


@Transactional
@Repository
public class MmsAddLineDaoImpl implements MmsAddLineDao{

	@Autowired
	private EntityManager em;
	
	@Override
	public String addLine(MmsAddline addLine) {
		em.persist(addLine);
	  		return null;
	}

	@Override
	public List<MmsAddline> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddline> criteria = cb.createQuery(MmsAddline.class);
		Root<MmsAddline> insulatorType = criteria.from(MmsAddline.class);
		
		criteria.select(insulatorType).orderBy(cb.asc(insulatorType.get("area")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public MmsAddline findById(String id) {
		return em.find(MmsAddline.class, id);
	}

	@Override
	public String findIdByName(String name) {
		try {
        	String qryStr = "select a.id  from MmsAddline a where a.name = :name";
        	System.out.println(qryStr + name);
        	Query query = em.createQuery(qryStr);
			query.setParameter("name", name);
			String lineId ="";
			List<String> list=query.getResultList();
	    	if (list.size()!=0){
	    		lineId=query.getResultList().get(0).toString().trim();
	    		System.out.println(lineId);
	    		
	    	}
			return lineId;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Summary> findLineSummary(String province) {
		// TODO Auto-generated method stub
		//select Area, count(*) ,sum(length),sum(nooftowers),
		//sum(noofpoles) from MMS_ADDLINE where area IN 
		//(select dept_id from gldeptm where comp_id in 
		//(select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00') GROUP BY Area ORDER BY Area
		//try {
        	//String qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId =:province and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
        	
		province =province.trim();
		String qryStr ="";		
		try {
			System.out.println(qryStr + province);	
					if(province.equalsIgnoreCase("CP")){
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
			        	
					}else if(province.equalsIgnoreCase("CP2")){
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP2') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
			        	
					}else if(province.equalsIgnoreCase("EP")){
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('EP') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
			        	
						
					}else if(province.equalsIgnoreCase("WPN")){
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
			        	
						
					}else{
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where  c.parentId IN ('"+province+"') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
			        	
					}
		        
        	
        	
        	
        	
        	System.out.println(qryStr + qryStr);
        	Query query = em.createQuery(qryStr);
			//query.setParameter("province", province);
			//String lineId ="";
			List<Summary> list=query.getResultList();
	
	    	//if (list.size()!=0){
	    		//lineId=query.getResultList().get(0).toString().trim();
	    		//System.out.println(lineId);
	    		
	    	//}
			
			//TypedQuery<MmsAddline> query =em.createQuery("select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') "
        		//	+ "and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area", MmsAddline.class) ;
			//return query.getResultList();
			
			return list;
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
		
	}

	@Override
	public String findLineSummaryNew(String name) {
		// TODO Auto-generated method stub
				//select Area, count(*) ,sum(length),sum(nooftowers),
				//sum(noofpoles) from MMS_ADDLINE where area IN 
				//(select dept_id from gldeptm where comp_id in 
				//(select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00') GROUP BY Area ORDER BY Area
		
		
		String qryStr ="";		
		try {
			System.out.println(qryStr + name);	
					if(name.equalsIgnoreCase("CP")){
						qryStr = "select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
					}if(name.equalsIgnoreCase("CP2")){
						qryStr = "select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP2') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
					}else if(name.equalsIgnoreCase("EP")){
						qryStr = "select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('EP') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
						
					}else if(name.equalsIgnoreCase("WPN")){
						qryStr = "select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
						
					}else{
						qryStr = "select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('"+name+"') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
					}
		        	//System.out.println(qryStr + name);
		        	Query query = em.createQuery(qryStr);
					//query.setParameter("name", province);
					//String lineId ="";
					List<Summary> list=query.getResultList();
			
			    	//if (list.size()!=0){
			    		//lineId=query.getResultList().get(0).toString().trim();
			    		//System.out.println(lineId);
			    		
			    	//}
					
					//TypedQuery<MmsAddline> query =em.createQuery("select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
		        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') "
		        		//	+ "and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area", MmsAddline.class) ;
					//return query.getResultList();
					
					
					return list.toString();
		        } catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
				
	}

	@Override
	public List<MmsAddline> findLineByArea(String area) {
		// TODO Auto-generated method stub
		try {
			System.out.println("findLineByArea area only : "+area);
			area = area.trim();
        	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
			String qryStr = "select p from MmsAddline p where trim(p.area) =:area and p.status=:status ORDER BY p.lineName ";
			
			
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("status", new BigDecimal("1"));
			List<MmsAddline> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MmsAddline> findLineByAreaList(String area) {
		// TODO Auto-generated method stub
List<String> bigDecimalList = new LinkedList<String>();
		
		String[] stringList = area.split(",");
		System.out.println("oooooooooo stringList"+stringList);
		
		for (String value : stringList) {
			bigDecimalList.add(value);
		}
		

		
		try {
			System.out.println("findLineByArea area only : "+area);
			area = area.trim();
        	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
			String qryStr = "select p from MmsAddline p where trim(p.area) IN (:area) and p.status=:status ORDER BY p.lineName ";
			
			
			Query query = em.createQuery(qryStr);
			query.setParameter("area", bigDecimalList);
			query.setParameter("status", new BigDecimal("1"));
			List<MmsAddline> list = query.getResultList();
			System.out.println("findLineByArea area only : "+list);
			System.out.println("findLineByArea area only : "+query.toString());
			
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public List<MmsAddline> findLineByProvince(String province,String area) {
		// TODO Auto-generated method stub
		//select * from MMS_ADDLINE where area IN (select dept_id from gldeptm where comp_id in (select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00')  ORDER BY Area
		String qryStr ="";	
		province = province.trim();
		area = area.trim();
		Query query =null;
		int areaInt = area.compareTo("NONE");
		System.out.println("areaInt : " + areaInt);
		try {
			System.out.println(province + area);	
					if(province.equalsIgnoreCase("CP") && area.equalsIgnoreCase("NONE")){
						
						System.out.println("province.equalsIgnoreCase(CP) && area.equalsIgnoreCase(NONE)");	
						qryStr = "select a  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
					}else if(province.equalsIgnoreCase("CP2") && area.equalsIgnoreCase("NONE")){
						
						System.out.println("province.equalsIgnoreCase(CP) && area.equalsIgnoreCase(NONE)");	
						qryStr = "select a  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP2') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
					}else if(province.equalsIgnoreCase("EP") && area.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(EP) && area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('EP') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("WPN") && area.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(WPN)&& area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(NONE) && area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN','CP','EP') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("NONE") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("CP") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("CP2") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("EP") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("WPN") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else{
						qryStr = "select a from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('TEST') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}
					System.out.println(qryStr);	
		        	
					List<MmsAddline> list=query.getResultList();
			
			    	
					
					return list;
		        } catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
		
		
	}

	@Override
	public List<Object[]> findLineByProvinceNew(String province, String area) {
		// TODO Auto-generated method stub
		//select * from MMS_ADDLINE where area IN (select dept_id from gldeptm where comp_id in (select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00')  ORDER BY Area
		String qryStr ="";	
		province = province.trim();
		area = area.trim();
		Query query =null;
		int areaInt = area.compareTo("NONE");
		System.out.println("areaInt : " + areaInt);
		try {
			System.out.println(province + area);	
					if(province.equalsIgnoreCase("CP") && area.equalsIgnoreCase("NONE")){
						
						System.out.println("province.equalsIgnoreCase(CP) && area.equalsIgnoreCase(NONE)");	
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
					}else if(province.equalsIgnoreCase("CP2") && area.equalsIgnoreCase("NONE")){
						
						System.out.println("province.equalsIgnoreCase(CP) && area.equalsIgnoreCase(NONE)");	
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP2') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
					}else if(province.equalsIgnoreCase("EP") && area.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(EP) && area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('EP') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("WPN") && area.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(WPN)&& area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(NONE) && area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN','CP','CP2','EP') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("NONE") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("CP") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a.id,b.lineId,a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area=:area GROUP BY a.id,b.lineId,a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType ORDER BY a.id,b.lineId,a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("CP2") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a.id,b.lineId,a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area=:area GROUP BY a.id,b.lineId,a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType ORDER BY a.id,b.lineId,a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("EP") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else if(province.equalsIgnoreCase("WPN") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else{
						qryStr = "select a from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('TEST') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}
					System.out.println(qryStr);	
		        	
					List<Object[]> list=query.getResultList();
			
			    	
					
					return list;
		        } catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
	}
	
	
	
	@Override
	public List<Object[]> findLineByProvinceNew(String province, String area,String line) {
		// TODO Auto-generated method stub
		//select * from MMS_ADDLINE where area IN (select dept_id from gldeptm where comp_id in (select comp_id from glcompm where parent_id in ('CP') and lvl_no<60) and dept_id like '%.00')  ORDER BY Area
		String qryStr ="";	
		province = province.trim();
		area = area.trim();
		line = line.trim();
		Query query =null;
		int areaInt = area.compareTo("NONE");
		int lineInt = line.compareTo("NONE");
		System.out.println("areaInt : " + areaInt);
		try {
			System.out.println(province + area);	
					if(province.equalsIgnoreCase("CP") && area.equalsIgnoreCase("NONE")  && line.equalsIgnoreCase("NONE")){
						
						System.out.println("province.equalsIgnoreCase(CP) && area.equalsIgnoreCase(NONE)");	
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
					}else if(province.equalsIgnoreCase("CP2") && area.equalsIgnoreCase("NONE")  && line.equalsIgnoreCase("NONE")){
						
						System.out.println("province.equalsIgnoreCase(CP) && area.equalsIgnoreCase(NONE)");	
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP2') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
					}else if(province.equalsIgnoreCase("EP") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(EP) && area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId   and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('EP') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("WPN") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(WPN)&& area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a  from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
						System.out.println("province.equalsIgnoreCase(NONE) && area.equalsIgnoreCase(NONE)");	
						
						qryStr = "select a from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN','CP','CP2','EP') and c.lvlNo<60) and b.deptId LIKE '%.00')  ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}else if(province.equalsIgnoreCase("NONE") && (areaInt !=0) && (lineInt !=0) ){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0) && (lineInt !=0");	
						qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId  and a.area=:area and a.code = :line ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						query.setParameter("line", line);
						
					}else if(province.equalsIgnoreCase("CP") && (areaInt !=0) && (lineInt !=0) ){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						//select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
						//qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId  and a.area=:area and a.code = :line ORDER BY a.area";
						qryStr = "select count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a , MmsAddsupport b where  a.id = b.lineId  and a.area=:area and a.code = :line ORDER BY a.area";
						
						
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						query.setParameter("line", line);
						
					}else if(province.equalsIgnoreCase("CP2") && (areaInt !=0) && (lineInt !=0) ){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						//select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
			        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area";
			        	
						//qryStr = "select a.code,a.lineName,a.lineType,a.length,a.nooftowers,a.noofpoles,a.comdate,b.towerNo,b.towerType,b.towerConfiguration,b.supportType,b.noOfCircuits,b.bodyExtension,b.conductorType,b.earthConductorType  from MmsAddline a , MmsAddsupport b where  a.id = b.lineId  and a.area=:area and a.code = :line ORDER BY a.area";
						qryStr = "select count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a , MmsAddsupport b where  a.id = b.lineId  and a.area=:area and a.code = :line ORDER BY a.area";
						
						
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						query.setParameter("line", line);
						
					}else if(province.equalsIgnoreCase("EP") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						//query.setParameter("line", line);
					}else if(province.equalsIgnoreCase("WPN") && (areaInt !=0)){
						System.out.println("province.equalsIgnoreCase(NONE) && (areaInt !=0)");	
						qryStr = "select a from MmsAddline a where a.area=:area ORDER BY a.area";
						System.out.println(qryStr);	
						query = em.createQuery(qryStr);
						query.setParameter("area", area);
						
					}else{
						qryStr = "select a from MmsAddline a where a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('TEST') and c.lvlNo<60) and b.deptId LIKE '%.00') ORDER BY a.area";
						query = em.createQuery(qryStr);
						
					}
					System.out.println(qryStr);	
		        	
					List<Object[]> list=query.getResultList();
			
			    	
					
					return list;
		        } catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
	}

	@Override
	public List<MmsAddline> findLineByStatus(String status,String phmbranch) {
		try {
			System.out.println("status : "+status);
        	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
			String qryStr = "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			
			
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			query.setParameter("phmbranch", phmbranch);
			List<MmsAddline> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String findIdByCode(String code) {
		try {
        	String qryStr = "select a.id  from MmsAddline a where a.code = :code and a.status =:status";
        	System.out.println(qryStr + code);
        	Query query = em.createQuery(qryStr);
			query.setParameter("code", code);
			query.setParameter("status", new BigDecimal("1"));
			
			String lineId ="";
			List<String> list=query.getResultList();
	    	if (list.size()!=0){
	    		lineId=query.getResultList().get(0).toString().trim();
	    		System.out.println(lineId);
	    		
	    	}
			return lineId;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String update(MmsAddline addLine) {
		System.out.println("hi update");
		em.merge(addLine);
		return null;
	}

	@Override
	public List<Summary> findDDSummary(String DD,String dept_id) {
		DD =DD.trim();
				String qryStr ="";
				Query query = null;
				try {
					System.out.println(qryStr + DD + dept_id);	
							if(DD.equalsIgnoreCase("DISCO2")){
								//qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
					        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP','EP','WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
								qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.phmBranch=:dept_id and a.status=1";
								query = em.createQuery(qryStr);
								query.setParameter("dept_id", dept_id);
								
							
							}else if(DD.equalsIgnoreCase("DISCO1")){
								//qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
			        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP','EP','WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
						qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.phmBranch=:dept_id and a.status=1";
						query = em.createQuery(qryStr);
						query.setParameter("dept_id", dept_id);
						
					
					}else if(DD.equalsIgnoreCase("DISCO3")){
						//qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
	        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP','EP','WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
				qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.phmBranch=:dept_id and a.status=1";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				
			
			}else {
								
								qryStr = "select count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
					        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('"+DD+"') and c.lvlNo<60) and b.deptId LIKE '%.00')";
					        	
								
								//qryStr = "select count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
					        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00')";
					        	query = em.createQuery(qryStr);
								//query.setParameter("dept_id", dept_id);
								
							
							}
		        	System.out.println(qryStr + qryStr);
		        	//String lineId ="";
					List<Summary> list = query.getResultList();
			
					
					//TypedQuery<MmsAddline> query =em.createQuery("select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
		        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') "
		        		//	+ "and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area", MmsAddline.class) ;
					//return query.getResultList();
					
					return list;
					
		        } catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
	}

	@Override
	public Object lineSummary(String DD, String dept_id) {
		DD =DD.trim();
		String qryStr ="";		
		try {
			System.out.println(qryStr + DD);	
					if(DD.equalsIgnoreCase("DISCO2")){
						//qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
			        			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP','EP','WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
						qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.phmBranch=:dept_id";
					}
        	
        	
        	
        	
        	System.out.println(qryStr + qryStr);
        	Query query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			//String lineId ="";
			Object list = query.getResultList().get(0);
	
	    	//if (list.size()!=0){
	    		//lineId=query.getResultList().get(0).toString().trim();
	    		//System.out.println(lineId);
	    		
	    	//}
			
			//TypedQuery<MmsAddline> query =em.createQuery("select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') "
        		//	+ "and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area", MmsAddline.class) ;
			//return query.getResultList();
			
			return list;
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public MmsAddline findById(long id) {
		return em.find(MmsAddline.class, id);
	}

	@Override
	public List<MmsAddline> findLineByArea(String area, String deptID) {
		try {
			System.out.println("findLineByArea adn line : "+area);
			area = area.trim();
			List<MmsAddline> list = null;
			if(area.equalsIgnoreCase("NONE")){
				String qryStr = "select p from MmsAddline p where p.phmBranch=:phmBranch ORDER BY p.lineName ";
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				query.setParameter("phmBranch", deptID);
				list = query.getResultList();
				
			}else{
        	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
			String qryStr = "select p from MmsAddline p where p.area =:area and p.phmBranch=:phmBranch ORDER BY p.lineName ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("phmBranch", deptID);
			list = query.getResultList();
			}
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	

	@Override
	public List<Summary> findAreaSummary(String dept_id) {
		String qryStr ="";	
		try {
			qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.area=:dept_id and a.status = 1";
			System.out.println(qryStr + qryStr);
        	Query query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			List<Summary> list = query.getResultList();
			return list;
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Summary> viewLineSummaryforArea(String area) {
		return null;
	}
	
	@Override
	public List<MmsAddline> findLineByAreaEdit(String area, String status,String phmbranch) {
		try {
			System.out.println("findLineByArea adn line : "+area+"/"+ "phmbranch" + phmbranch);
			area = area.trim();
        	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
			String qryStr = "select p from MmsAddline p where p.area =:area and p.phmBranch=:phmBranch and p.status=:status ORDER BY p.lineName ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("phmBranch", phmbranch.trim());
			query.setParameter("status", new BigDecimal (status));
			List<MmsAddline> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Summary> findLineSummaryForEst(String lineids) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public double getTotalofFlashSet(String area, String lineid,String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		cycle = cycle.trim();
		try {
			if(cycle.equals("")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				endfitting =Double.parseDouble(String.valueOf(list[0]));
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
			}
			if(list[3] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[3]));
			}
			
			total= endfitting + fungussetno + wpinset + nofflashoversets;
			return total;
			}
			else if(cycle.equals("201801")){
				
				System.out.println("eeee : "+ cycle);
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				endfitting =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("endfitting : "+ endfitting);
			}
			if(list[1] != null){
				System.out.println("fungussetno : "+ fungussetno);
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
			}
			if(list[2] != null){
				System.out.println("wpinset : "+ wpinset);
				wpinset =Double.parseDouble(String.valueOf(list[2]));
			}
			if(list[3] != null){
				System.out.println("nofflashoversets : "+ nofflashoversets);
				nofflashoversets =Double.parseDouble(String.valueOf(list[3]));
			}
			
			total= endfitting + fungussetno + wpinset + nofflashoversets;
			return total;
			}
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				endfitting =Double.parseDouble(String.valueOf(list[0]));
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
			}
			if(list[3] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[3]));
			}
			
			total= endfitting + fungussetno + wpinset + nofflashoversets;
			return total;
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return 0; 
	}

	@Override
	public double getTotalofOnlyFlashSet(String area, String lineid,String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		cycle = cycle.trim();
		try {
			if(cycle.equals("")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + wpinset;
			return total;
			}	else if(cycle.equals("201801")){
				System.out.println("cycle : "+ cycle);
				//System.out.println("cycle : "+ cycle);
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			

			total= nofflashoversets + wpinset;
			
			return total;
			}
			
			
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + wpinset;
			return total;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return 0; 
	}

	@Override
	public Object[] getTotalofDefectiveInsultorSetForColdLineEst(String area,
			String lineid, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		Object[] list  = null;
		try {
			if(cycle.equals("")){
				/*String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			*/
				/*String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0"+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
				*/
				
				String qryStr = "select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0 and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
				
				
				
				   
				
			//String qryStr = "";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}else if(cycle.equals("201801")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0 and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
			
			
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0 and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return null; 
	}
	
	
	@Override
	public Object[] getTotalofDefectiveInsultorSetForColdLineEstHotPossible(String area,
			String lineid, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		Object[] list  = null;
		try {
			if(cycle.equals("")){
				/*String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			*/
				/*String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0"+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
				*/
				
				String qryStr = "select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
				
				
				
				   
				
			//String qryStr = "";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}else if(cycle.equals("201801")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
							  " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
			
			
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
							  " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets hot : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno hot : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset hot : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting hot : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return null; 
	}

	

	@Override
	public Object[] getTotalofDefectiveInsultorSetForTTWTEst(String area,	String lineid, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower =0;
		Object[] list = null;
		try {
			if(cycle.equals("")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) "+
						   " and b.towerConfiguration=1 "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) )"+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and a.hotpossible =1 and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			else if(cycle.equals("201801")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) "+
						   " and b.towerConfiguration=1 "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) )"+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and a.hotpossible =1 and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) "+
						   " and b.towerConfiguration=1 "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) )"+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and a.hotpossible =1 and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			/*if(list[4] != null){
				tower =Double.parseDouble(String.valueOf(list[4]));
				System.out.println("count : "+ tower);
			}*/
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeeeddddd : "+ e.getMessage());
		}
		return null; 
	}

	

	@Override
	public double getTotalofTotalofSuspensionInsulatorSets(String area,
			String lineid, String cycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalFlashOverSet(String area, String lineid, String cycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalWpin(String area, String lineid, String cycle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalEndFitting(String area, String lineid, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		cycle = cycle.trim();
		try {
			if(cycle.equals("")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= endfitting;
			return total;
			}else if(cycle.equals("201801")){
				System.out.println("cycle : "+ cycle);
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			

			total= endfitting;
			
			return total;
			}
			
			
			
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where b.towerConfiguration=2 and trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id)   and a.nooftappings =0 "+
						   "and a.hotpossible =1 and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   "and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			Object[] list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= endfitting;
			return total;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return 0; 
	}

	@Override
	public double getCountTTWT(String area, String lineid, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower =0;
		int i = 0;
		Object[] list = null;
		try {
			if(cycle.equals("")){
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) "+
						   " and a.nooftappings =0 "+
						   " and b.towerConfiguration=1 "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and a.hotpossible =1 and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
			return tower;
			}
			else if(cycle.equals("201801")){
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) "+
						   " and a.nooftappings =0 "+
						   " and b.towerConfiguration=1 "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and a.hotpossible =1 and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
			return tower;
			}
			
			else{
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) "+
						   " and a.nooftappings =0 "+
						   " and b.towerConfiguration=1 "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and a.hotpossible =1 and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
			return tower;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeeeddddd : "+ e.getMessage());
		}
		return tower; 
	}

	@Override
	public double getCountCL(String area, String lineid, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower = 0;
		Object list  = null;
		int i = 0;
		try {
			if(cycle.equals("")){
				 		  
				/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			*/
			String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
					   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
					   "a.hotpossible =0"+
						" and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
					   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
					   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
					   
			
			
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
			return tower;
			}else if(cycle.equals("201801")){
				/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			*/
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0"+
							" and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
				
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
				
				/*if(list[4] != null){
					tower =Double.parseDouble(String.valueOf(list[4]));
					System.out.println("count : "+ tower);
				}*/
				//total= nofflashoversets + fungussetno + wpinset + endfitting;
				return tower;
			}
			
			
			
			
			else{
				/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			*/
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0"+
							" and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
				
				
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
				return tower;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return tower; 
	}

	@Override
	public Object[] getTotalCLSuspensionISets(String area, String lineid,
			String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		Object[] list  = null;
		try {
			if(cycle.equals("")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (2) and a.nooftappings > 0) OR  (b.towerConfiguration in (2) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}else if(cycle.equals("201801")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (2) and a.nooftappings > 0) OR  (b.towerConfiguration in (2) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
			
			
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (2) and a.nooftappings > 0) OR  (b.towerConfiguration in (2) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return null;
	}

	@Override
	public Object[] getTotalCLTensionISets(String area, String lineid,
			String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		Object[] list  = null;
		try {
			if(cycle.equals("")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}else if(cycle.equals("201801")){
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						    " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
			
			
			
			else{
				String qryStr ="select sum(a.nofflashoversets), sum(a.fungussetno), sum(a.wpinset),sum(a.endfittingset) FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						    " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 list = (Object[]) query.getResultList().get(0);
			if(list[0] != null){
				nofflashoversets =Double.parseDouble(String.valueOf(list[0]));
				System.out.println("nofflashoversets : "+ nofflashoversets);
			}
			if(list[1] != null){
				fungussetno =Double.parseDouble(String.valueOf(list[1]));
				System.out.println("fungussetno : "+ fungussetno);
			}
			if(list[2] != null){
				wpinset =Double.parseDouble(String.valueOf(list[2]));
				System.out.println("wpinset : "+ wpinset);
			}
			if(list[3] != null){
				endfitting =Double.parseDouble(String.valueOf(list[3]));
				System.out.println("endfitting : "+ endfitting);
			}
			
			total= nofflashoversets + fungussetno + wpinset + endfitting;
			return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return null;
		//return null;
	}

	@Override
	public String getNameByCode(String code) {
		try {
        	String qryStr = "select a.lineName  from MmsAddline a where a.code = :code";
        	System.out.println(qryStr + code);
        	Query query = em.createQuery(qryStr);
			query.setParameter("code", code);
			String lineId ="";
			List<String> list=query.getResultList();
	    	if (list.size()!=0){
	    		lineId=query.getResultList().get(0).toString().trim();
	    		System.out.println("line name : " +lineId);
	    		
	    	}
			return lineId;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String getNameById(String id) {
		try {
        	String qryStr = "select a.lineName  from MmsAddline a where a.id =:id";
        	System.out.println(qryStr + id);
        	Query query = em.createQuery(qryStr);
			query.setParameter("id", new Long(id));
			String lineId ="";
			List<String> list=query.getResultList();
	    	if (list.size()!=0){
	    		lineId=query.getResultList().get(0).toString().trim();
	    		System.out.println("line name : " +lineId);
	    		
	    	}
			return lineId;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	}

	@Override
	public List<MmsAddline> findLineByAreaStatus(String area, String status) {
		try {
			String qryStr = "select p from MmsAddline p where p.status =:status and p.area=:area ORDER BY p.lineName ";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			query.setParameter("area", area);
			List<MmsAddline> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Summary> findDDSummaryOther(String DD) {
		DD =DD.trim();
		String qryStr ="";
		Query query = null;
		try {
			//System.out.println(qryStr + DD + dept_id);	
					if(DD.equalsIgnoreCase("DISCO2")){
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP','EP','WPN','CP2') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
						//qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.area a.status=1";
						query = em.createQuery(qryStr);
						//query.setParameter("dept_id", dept_id);
						
					
					}else if(DD.equalsIgnoreCase("DISCO1")){
						qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
	        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('NCP','NWP','NWP 2','CC') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
				//qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.phmBranch=:dept_id and a.status=1";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
				
			
			}else if(DD.equalsIgnoreCase("DISCO3")){
				//qryStr = "select a.area ,b.deptNm,  count(a) ,sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.area = b.deptId and a.area IN (select b.deptId from "
    			//+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP','EP','WPN') and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area,b.deptNm ORDER BY a.area,b.deptNm";
		qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a where a.phmBranch=:dept_id and a.status=1";
		query = em.createQuery(qryStr);
		//query.setParameter("dept_id", dept_id);
		
	
	}else {
						
						qryStr = "select count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        			+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('"+DD+"') and c.lvlNo<60) and b.deptId LIKE '%.00')";
			        	
						
						//qryStr = "select count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles) from MmsAddline a ,Gldeptm b where a.status = 1 and a.area = b.deptId and a.area IN (select b.deptId from "
			        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('WPN') and c.lvlNo<60) and b.deptId LIKE '%.00')";
			        	query = em.createQuery(qryStr);
						//query.setParameter("dept_id", dept_id);
						
					
					}
        	System.out.println(qryStr + qryStr);
        	//String lineId ="";
			List<Summary> list = query.getResultList();
	
			
			//TypedQuery<MmsAddline> query =em.createQuery("select a.area ,count(a),sum(length)  from MmsAddline a where a.area IN (select b.deptId from "
        		//	+ "Gldeptm b where b.compId IN (select c.compId from Glcompm c where c.parentId IN ('CP') "
        		//	+ "and c.lvlNo<60) and b.deptId LIKE '%.00') GROUP BY a.area ORDER BY a.area", MmsAddline.class) ;
			//return query.getResultList();
			
			return list;
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Object[]> findDDSummary(String province, String area, String line,String dept_id) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			if(province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				//select  count(a.id),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.area)
				//from Mms_Addline a,Gldeptm b where a.phm_Branch='600.41' and a.status=1 AND b.dept_Id =a.area  group by a.area;
				//qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.deptNm from Gldeptm b  where b.deptId =a.area) from MmsAddline a,Gldeptm b where a.phmBranch=:dept_id and a.status=1 and b.deptId =a.area  group by a.area";
				qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),c.parentId from MmsAddline a,Gldeptm b,Glcompm c where a.phmBranch=:dept_id and a.status=1 and b.deptId =a.area and c.compId = b.compId group by  c.parentId";

				
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				return query.getResultList();
			
			
			}else if(!province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				//select  count(a.id),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.area)
				//from Mms_Addline a,Gldeptm b,GLCOMPM c where a.phm_Branch='600.41' and a.status=1 AND b.dept_Id =a.area and c.comp_id = b.comp_id and c.parent_id ='CP' group by  a.area;
				System.out.println("province not none"+province+area+line);
				
				qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),b.deptNm from MmsAddline a,Gldeptm b,Glcompm c where a.phmBranch=:dept_id and a.status=1 and b.deptId =a.area and c.compId = b.compId and trim(c.parentId) =:parentid group by b.deptNm";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("parentid", province);
				System.out.println("province not none"+qryStr);
				
				return query.getResultList();

			
			}
			else{
				
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	@Override
	public List<Object[]> findDDSummary(String province, String area, String line) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			if(province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				//select  count(a.id),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.area)
				//from Mms_Addline a,Gldeptm b where a.phm_Branch='600.41' and a.status=1 AND b.dept_Id =a.area  group by a.area;
				//qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.deptNm from Gldeptm b  where b.deptId =a.area) from MmsAddline a,Gldeptm b where a.phmBranch=:dept_id and a.status=1 and b.deptId =a.area  group by a.area";
				qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),c.parentId from MmsAddline a,Gldeptm b,Glcompm c where a.status=1 and b.deptId =a.area and c.compId = b.compId group by  c.parentId";

				
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
				return query.getResultList();
			
			
			}else if(!province.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				//select  count(a.id),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.area)
				//from Mms_Addline a,Gldeptm b,GLCOMPM c where a.phm_Branch='600.41' and a.status=1 AND b.dept_Id =a.area and c.comp_id = b.comp_id and c.parent_id ='CP' group by  a.area;
				System.out.println("province not none"+province+area+line);
				
				qryStr = "select  count(a),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),b.deptNm from MmsAddline a,Gldeptm b,Glcompm c where a.status=1 and b.deptId =a.area and c.compId = b.compId and trim(c.parentId) =:parentid group by b.deptNm";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
				query.setParameter("parentid", province);
				System.out.println("province not none"+qryStr);
				
				return query.getResultList();

			
			}else if(province.equalsIgnoreCase("NONEA") && !area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				//select  count(a.id),sum(a.length), sum(a.nooftowers),sum(a.noofpoles),(select b.dept_Nm from Gldeptm b  where b.dept_Id =a.area)
				//from Mms_Addline a,Gldeptm b,GLCOMPM c where a.phm_Branch='600.41' and a.status=1 AND b.dept_Id =a.area and c.comp_id = b.comp_id and c.parent_id ='CP' group by  a.area;
				System.out.println("............."+province+area+line);
				
				qryStr = "select  a.length,a.nooftowers,a.noofpoles,a.lineName from MmsAddline a where a.status=1 and trim(a.area)=:area group by  a.length,a.nooftowers,a.noofpoles,a.lineName";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				
				return query.getResultList();

			
			}

			else{
				
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public double getCountCL1(String area, String lineid, String cycle) {
		// TODO Auto-generated method stub
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower = 0;
		Object list  = null;
		int i = 0;
		try {
			if(cycle.equals("")){
				 		  
				/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
			*/
			String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
					   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
					   "a.hotpossible =0 and "+
					   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
					   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
					   
			
			
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			 i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
			return tower;
			}else if(cycle.equals("201801")){
				/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
			*/
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0 and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
				
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			//query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
				
				/*if(list[4] != null){
					tower =Double.parseDouble(String.valueOf(list[4]));
					System.out.println("count : "+ tower);
				}*/
				//total= nofflashoversets + fungussetno + wpinset + endfitting;
				return tower;
			}
			
			
			
			
			else{
				/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
						   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
			*/
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "a.hotpossible =0 and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
				
				
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineid));
			query.setParameter("cycle", new Long(cycle));
			//query.setParameter("possible", "Possible");
			i = query.getResultList().size();
			 Double d= new Double(i);
			 tower = d.doubleValue();
				return tower;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return tower; 

	}

	@Override
	public double getCountCL2(String area, String lineid, String cycle) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				double total=0;
				double endfitting = 0;
				double fungussetno = 0;
				double wpinset = 0;
				double nofflashoversets = 0;
				double tower = 0;
				Object list  = null;
				int i = 0;
				try {
					if(cycle.equals("")){
						 		  
						/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
								   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
								   "((b.towerConfiguration in (1,2) and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
								   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
								   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
								   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
					*/
					String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
							   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
							   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
							   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId ";
							   
					
					
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(lineid));
					//query.setParameter("cycle", new Long(cycle));
					//query.setParameter("possible", "Possible");
					 i = query.getResultList().size();
					 Double d= new Double(i);
					 tower = d.doubleValue();
					return tower;
					}else if(cycle.equals("201801")){
						/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
								   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
								   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
								   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
								   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
								   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
					*/
						String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
								   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
								   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
								   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid NOT IN ('201802','201901','201902','202001','202002') ";
						
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(lineid));
					//query.setParameter("cycle", new Long(cycle));
					//query.setParameter("possible", "Possible");
					i = query.getResultList().size();
					 Double d= new Double(i);
					 tower = d.doubleValue();
						
						/*if(list[4] != null){
							tower =Double.parseDouble(String.valueOf(list[4]));
							System.out.println("count : "+ tower);
						}*/
						//total= nofflashoversets + fungussetno + wpinset + endfitting;
						return tower;
					}
					
					
					
					
					else{
						/*String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
								   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
								   "((b.towerConfiguration in (1,2) and a.nooftappings =0 and a.hotpossible =0) OR (b.towerConfiguration in (1,2) and a.nooftappings > 0) OR  (b.towerConfiguration in (1) and a.nooftappings =0 and a.hotpossible =0)) "+
								   " and ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
								   " and ( a.jumperstatus !='Good' or a.jumperstatus !='None' or a.conductorstatus !='Good' or  a.earthconductorstatus  !='Good' or  a.earthconductorstatus  !='None' )" +
								   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
					*/
						String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
								   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
								   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
								   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
						
						
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(lineid));
					query.setParameter("cycle", new Long(cycle));
					//query.setParameter("possible", "Possible");
					i = query.getResultList().size();
					 Double d= new Double(i);
					 tower = d.doubleValue();
						return tower;
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("eeee : "+ e.getMessage());
				}
				return tower; 

	}

	@Override
	public double getDefectiveInsulatorTower(String area, String lineid,String cycle) {
		
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower = 0;
		Object list  = null;
		int i = 0;
		
		try{
			
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and b.lineId =:lineId and a.id.visitid =:cycle ";
				
				
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(lineid));
				query.setParameter("cycle", new Long(cycle));
				i = query.getResultList().size();
				Double d= new Double(i);
				tower = d.doubleValue();
				return tower;
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return tower; 

	}

	@Override
	public double getDefectiveInsulatorTower(String area, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower = 0;
		Object list  = null;
		int i = 0;
		System.out.println("area : "+ area);
		System.out.println("cycle : "+ cycle);
		
		try{
			
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   " ( (a.nofflashoversets > 0)  or ( a.fungussetno > 0) or ( a.wpinset > 0)or ( a.endfittingset > 0) ) "+
						   " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and a.id.visitid =:cycle ";
				
				
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("lineId", new BigDecimal(lineid));
				query.setParameter("cycle", new Long(cycle));
				i = query.getResultList().size();
				Double d= new Double(i);
				tower = d.doubleValue();
				return tower;
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return tower; 
	}

	@Override
	public double getDamageTower(String area, String cycle) {
		double total=0;
		double endfitting = 0;
		double fungussetno = 0;
		double wpinset = 0;
		double nofflashoversets = 0;
		double tower = 0;
		Object list  = null;
		int i = 0;
		System.out.println("area : "+ area);
		System.out.println("cycle : "+ cycle);
		
		try{
			
				String qryStr ="select a FROM MmsTxntowermaintenance  a , MmsAddsupport  b , MmsAddline c "+
						   "where trim(a.id.towerid) = trim(b.id) and  trim(b.lineId)  = trim(c.id) and "+
						   "( a.jumperstatus  not in ( 'Good' ,'None') or a.conductorstatus  not in ( 'Good' ) or  a.earthconductorstatus  not in ( 'Good' ) or a.earthconductorstatus  not in ( 'Good' ) ) "+
							  " and  b.status=1 and  c.status=1 and  a.status=1 and b.area =:area and a.id.visitid =:cycle ";
				
				
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("lineId", new BigDecimal(lineid));
				query.setParameter("cycle", new Long(cycle));
				i = query.getResultList().size();
				Double d= new Double(i);
				tower = d.doubleValue();
				return tower;
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("eeee : "+ e.getMessage());
		}
		return tower; 

	}

}

	





