package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsGantryloc;


@Transactional
@Repository
public class MMSAddgantryDaoImpl implements MMSAddgantryDao{

	@Autowired
	private EntityManager em;
	
	
	public String getNextGantryId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.id.feederId from MmsAddgantry a " +
    			"where a.id.feederId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20 chars   year 2012
    		sequence=sequence.substring(2);//total 18 chars  year 12 
    		Integer i=Integer.parseInt(sequence)+1;
    		sequence=i.toString();
    		System.out.println(sequence);
    		System.out.println("Hii" + sequence);
    	}else{
    		sequence="0001";
    		System.out.println("HIIII : "+ sequence);
    	}
    	if(sequence.length()==1)
    		return "000"+sequence;
    	else if (sequence.length()==2)
    		return "00"+sequence;
    	else if (sequence.length()==3)
    		return "0"+sequence;
    	else return sequence;
	}

	
	

	@Override
	public String addGantry(MmsAddgantry addGantry) {
		// TODO Auto-generated method stub
		String result="";
		try {
			em.persist(addGantry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getLocalizedMessage();
		}
		String id = String.valueOf(addGantry.getId());
		return id;
	}

	@Override
	public List<MmsAddgantry> getGantryByLineArea(String line, String area) {
		try {
			String sql = "select a from MmsAddgantry a where a.area= :area and a.lineId=:lineId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("area",area);
			query.setParameter("lineId",new BigDecimal(line));
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public MmsAddgantry findById(long id) {
		// TODO Auto-generated method stub
		return em.find(MmsAddgantry.class, id);
	}

	@Override
	public String updateGantry(MmsAddgantry addLine) {
		// TODO Auto-generated method stub
		em.merge(addLine);
		return null;
	}
	
	public List<MmsAddgantry> getGantryData(String code) {
		try {
			String sql = "select a from MmsAddgantry a where a.id= :code";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("code",new Long(code));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public String addGantryLoc(MmsGantryloc addGantryLoc) {
		em.persist(addGantryLoc);
		return null;
	}


	@Override
	public List<MmsGantryloc> getGantryLocData(String gantryId) {
		try {
			String sql = "select a from MmsGantryloc a where a.id.gantryId= :gantryId order by a.id.pointId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryId",new Long(gantryId));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

@Override
public List<MmsAddgantry> getGantryByArea(String area) {
	
	
try {
	
	/*String sql = "";
	if(area.equalsIgnoreCase("NONE")){
		 sql = "select a from MmsAddgantry a ";
			
	}else{
		 sql = "select a from MmsAddgantry a where a.area= :area";
			
	}*/
	
	String sql = "select a from MmsAddgantry a where a.area= :area and a.status=1";
	System.out.println("sql : "+ sql);
	Query query = em.createQuery(sql);
	//String area1=area+".00";
	query.setParameter("area",area.trim());
	
	
	return query.getResultList();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
return null;
}


public List<MmsAddgantry> getGantryByAreaNew(String area) {
	
	
try {
	
	/*String sql = "";
	if(area.equalsIgnoreCase("NONE")){
		 sql = "select a from MmsAddgantry a ";
			
	}else{
		 sql = "select a from MmsAddgantry a where a.area= :area";
			
	}*/
	
	String sql = "select a from MmsAddgantry a where a.area= :area and a.status = 1";
	System.out.println("sql : "+ sql);
	Query query = em.createQuery(sql);
	//String area1=area+".00";
	query.setParameter("area",area.trim());
	
	
	return query.getResultList();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
return null;
}

public List<MmsAddgantry> getGantryByAreaNewAll(String province,String area) {
	
	
try {
	
	/*String sql = "";
	if(area.equalsIgnoreCase("NONE")){
		 sql = "select a from MmsAddgantry a ";
			
	}else{
		 sql = "select a from MmsAddgantry a where a.area= :area";
			
	}*/
	
	String qryStr = "";
	Query query = null;
	if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE")){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP','CP2','WPN','EP') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}
	else if(area.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") ){
		System.out.println("oooooooooo1"+province);
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province.trim()+"') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}else if (!area.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE")){
		System.out.println("oooooooooo5ssscccccccchhhhhhhhhhhhhhhh" );
		
		qryStr = "select a from MmsAddgantry a where trim(a.area)= trim(:area) and a.status = 1";
		
		query = em.createQuery(qryStr);
		query.setParameter("area", area);
		
	}
	return query.getResultList();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
return null;
}


public List<MmsAddgantry> getGantryByAreaNewAllDivision(String province,String area,String division) {
	
	
try {
	
	/*String sql = "";
	if(area.equalsIgnoreCase("NONE")){
		 sql = "select a from MmsAddgantry a ";
			
	}else{
		 sql = "select a from MmsAddgantry a where a.area= :area";
			
	}*/
	
	String qryStr = "";
	Query query = null;
	if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("NONE")){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.status = 1";
		query = em.createQuery(qryStr);
	}
	else if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO2")){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP','CP2','WPN','EP') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}
	
	else if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO3")){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('SABP','UVAP','WPSII') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}else if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO1")){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NP','NWP','NCP','CC','NWP2') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}else if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO4")){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('SP','WPS1','SP2') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}
	/*else if(area.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
		System.out.println("oooooooooo1");
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP','WPN','EP') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}
	*/else if(area.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") ){
		System.out.println("oooooooooo1"+province);
		qryStr = "select a from MmsAddgantry a where a.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province.trim()+"') and b.lvlNo<60) and a.deptId like '%.00' ) and a.status = 1";
		query = em.createQuery(qryStr);
	}else if (!area.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE")){
		System.out.println("oooooooooo5ssscccccccchhhhhhhhhhhhhhhh" );
		
		qryStr = "select a from MmsAddgantry a where trim(a.area)= trim(:area) and a.status = 1";
		
		query = em.createQuery(qryStr);
		query.setParameter("area", area);
		
	}
	return query.getResultList();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
return null;
}





@Override
public List<MmsAddgantry> findGantryByStatus(String status, String phmbranch) {
	try {
		//System.out.println("status : "+status);
    	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
		String qryStr = "select p from MmsAddgantry p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.id ";
		Query query = em.createQuery(qryStr);
		query.setParameter("status", new BigDecimal(status));
		query.setParameter("phmbranch", phmbranch);
		List<MmsAddgantry> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public List<Object[]> getSummaryGantry(String deptId) {
	try {
		//System.out.println("status : "+status);
    	//String qryStr = "select p from MmsAddline p where trim(p.area) = :area ORDER BY p.area";
		String qryStr = "select count(p),p.province from MmsAddgantry p where p.status = 1 GROUP BY p.province ";
		
		
		Query query = em.createQuery(qryStr);
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public List<MmsAddgantry> getGantryByAreaStatus(String area, String status) {
	try {
		String sql = "select a from MmsAddgantry a where a.area= :area and a.status =:status";
		System.out.println("sql : "+ sql);
		Query query = em.createQuery(sql);
		query.setParameter("area",area.trim());
		query.setParameter("status",new BigDecimal(status));
		
		return query.getResultList();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
return null;
}

@Override
public List<Object[]> getGantryByProvince() {
	// TODO Auto-generated method stub
	//select count(a.id), (select c.comp_nm from GLCOMPM c where c.comp_id= a.province) FROM MMS_ADDGANTRY a where status = 1 group by a.province
	try {
		String sql = "select count(a.id),(select c.compNm from Glcompm c where c.compId= a.province),a.province from MmsAddgantry a where a.status =1 group by a.province";
		System.out.println("sql : "+ sql);
		Query query = em.createQuery(sql);
		
		return query.getResultList();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return null;
}

@Override
public List<Object[]> getGantryByProvinceByArea(String area) {
	// TODO Auto-generated method stub
	//select count(a.id), (select c.dept_Nm from GLDEPTM c where c.dept_id=a.area) FROM MMS_ADDGANTRY a where status = 1 and trim(a.province) = 'WPN' group by a.area

	try {
		String sql = "select count(a.id),(select c.deptNm from Gldeptm c where c.deptId= a.area),a.area from MmsAddgantry a where a.status =1 and trim(a.province)=:province group by a.area";
		System.out.println("sql : "+ sql);
		Query query = em.createQuery(sql);
		query.setParameter("province",area.trim());
		
		return query.getResultList();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return null;
}



}
