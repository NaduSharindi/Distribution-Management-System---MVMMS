package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;


























import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.controller.Util;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.ApplicationReference;
import com.it.piv.mms.domain.ApplicationReferencePK;
import com.it.piv.mms.domain.EstimateReferenceb;
import com.it.piv.mms.domain.EstimateReferencebPK;
import com.it.piv.mms.domain.MmsInspection;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.PcestdttPK;
import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;
import com.it.piv.mms.domain.SpestedyCon;
import com.it.piv.mms.domain.SpestedyConPK;
import com.it.piv.mms.domain.Spstdesthmt;
import com.it.piv.mms.domain.WiringLandDetail;
import com.it.piv.mms.domain.WiringLandDetailCon;
import com.it.piv.mms.domain.WiringLandDetailConPK;
import com.it.piv.mms.domain.WiringLandDetailPK;
import com.it.piv.util.common.Format;

@Transactional
@Repository
public class ApplicationDaoImpl implements ApplicationDao{

	
	@Autowired
	private EntityManager em;
	
	
	@Autowired
	ApplicationReferenceDao appRefDao;
	
	@Autowired
	EstimateReferencebDao estRefDao;
	
	
	@Autowired
	SpestedyConDao spestDao;
	
	@Autowired
	PcesthttDao pchttDao;
	
	@Autowired
	PcestdttDao pcdttDao;
	
	@Autowired
	WiringLandDetailDao wiLaDeDao;
	
	@Autowired
	WiringLandDetailConDao wiLaDeConDao;
	
	
	
	@Override
	public String save(Application obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}
	
	public String getNextAppId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.id.applicationId from Application a " +
    			"where a.id.applicationId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20 chars   year 2012
    		sequence=sequence.substring(14);//total 18 chars  year 12 
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
	public String saveSPS(String deptId,String userName,String alocated_To,Application application, PivModel pivModel) {
		save(application);
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DateFormat df = new SimpleDateFormat("yy");
		String formattedDate = df.format(Calendar.getInstance().getTime());
		System.out.println(formattedDate);
		int year = cal.get(Calendar.YEAR);
		String applicationIdPrefix =deptId + "/PH/" + formattedDate +"/";
		System.out.println("applicationIdPrefix :" + applicationIdPrefix);
		String nextsquence=appRefDao.getNextApplicationNo(applicationIdPrefix);
		System.out.println("nextsquence"+nextsquence);
		String nextApplicationNo=applicationIdPrefix+nextsquence;
		System.out.println("nextApplicationNo"+nextApplicationNo);
		application.setApplicationNo(nextApplicationNo);
		
		ApplicationReference appReference=new ApplicationReference();
		ApplicationReferencePK id=new ApplicationReferencePK();
		id.setApplicationId(application.getId().getApplicationId());
		id.setDeptId(application.getId().getDeptId());
		appReference.setId(id);
		appReference.setApplicationNo(nextApplicationNo);
		appReference.setIdNo(application.getIdNo());//Identity Card No
		System.out.println("appReference %%%%%%%%%%%%%%%%%%%%%%%%%%% "+appReference);
		appRefDao.save(appReference);
		
		updateApplication(application);
		////
		/*WiringLandDetail obj = new WiringLandDetail();
		WiringLandDetailPK objPk = new WiringLandDetailPK();
		objPk.setApplicationId(application.getId().getApplicationId());
		objPk.setDeptId(application.getId().getDeptId());
		obj.setId(objPk);
		obj.setServiceStreetAddress(" ");
		obj.setServiceSuburb(" ");
		obj.setServiceCity(" ");
		obj.setOwnership(" ");
		obj.setOwnership(" ");
		
		//obj.setAreaCode(pivModel.getGldeptobj().getDeptId());
		
		//obj.setPhase(new B);
		wiLaDeDao.save(obj);
		*/
		System.out.println("test 2 : gayani ");
		
		/////
		WiringLandDetailCon objCon = new WiringLandDetailCon();
		WiringLandDetailConPK objConPk = new WiringLandDetailConPK();
		objConPk.setApplicationId(application.getId().getApplicationId());
		objConPk.setDeptId(application.getId().getDeptId());
		objCon.setId(objConPk);
		if(pivModel.getGldeptobj() != null){
			objCon.setAreaCode(pivModel.getGldeptobj().getDeptId());
			
		}
		wiLaDeConDao.save(objCon);
		System.out.println("test 1 : gayani ");
		
		
		
		addAppointment(application.getId().getDeptId(),userName.trim(),alocated_To.trim(),nextApplicationNo,pivModel);
		EstimateReferencebPK esPk = new EstimateReferencebPK();
		esPk.setDeptId(application.getId().getDeptId());
		System.out.println("agayani "+nextApplicationNo);
		
		esPk.setSestimateNo(nextApplicationNo);
		String westimate_no = nextApplicationNo+"/1";
		esPk.setWestimateNo(nextApplicationNo+"/1");
		EstimateReferenceb esObjEstimateReferenceb = new EstimateReferenceb();
		esObjEstimateReferenceb.setId(esPk);
		esObjEstimateReferenceb.setEntryBy(userName);
		estRefDao.save(esObjEstimateReferenceb);
		populatePceshtts(westimate_no,userName,application.getId().getDeptId(),pivModel);
		populatePcestdtts(westimate_no,application.getId().getDeptId(), pivModel.getInspection());
		//pchttDao.save(pcesthtt);
		//int count = pcestdtt.size();
		//for (int i=0;i<count;i++){
			//Pcestdtt obj = pcestdtt.get(i);
			//pcdttDao.save(obj);
		//}
		
		// TODO Auto-generated method stub
		return westimate_no;
	}
	
	
	@Override
	public String saveSPSBreakDown(String deptId,String userName,String alocated_To,Application application, PivModel pivModel) {
		save(application);
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DateFormat df = new SimpleDateFormat("yy");
		String formattedDate = df.format(Calendar.getInstance().getTime());
		System.out.println(formattedDate);
		int year = cal.get(Calendar.YEAR);
		String applicationIdPrefix =deptId + "/PH/" + formattedDate +"/";
		System.out.println("applicationIdPrefix :" + applicationIdPrefix);
		String nextsquence=appRefDao.getNextApplicationNo(applicationIdPrefix);
		System.out.println("nextsquence"+nextsquence);
		String nextApplicationNo=applicationIdPrefix+nextsquence;
		System.out.println("nextApplicationNo"+nextApplicationNo);
		application.setApplicationNo(nextApplicationNo);
		
		ApplicationReference appReference=new ApplicationReference();
		ApplicationReferencePK id=new ApplicationReferencePK();
		id.setApplicationId(application.getId().getApplicationId());
		id.setDeptId(application.getId().getDeptId());
		appReference.setId(id);
		appReference.setApplicationNo(nextApplicationNo);
		appReference.setIdNo(application.getIdNo());//Identity Card No
		System.out.println("appReference %%%%%%%%%%%%%%%%%%%%%%%%%%% "+appReference);
		appRefDao.save(appReference);
		
		updateApplication(application);
		////
		/*WiringLandDetail obj = new WiringLandDetail();
		WiringLandDetailPK objPk = new WiringLandDetailPK();
		objPk.setApplicationId(application.getId().getApplicationId());
		objPk.setDeptId(application.getId().getDeptId());
		obj.setId(objPk);
		obj.setServiceStreetAddress(" ");
		obj.setServiceSuburb(" ");
		obj.setServiceCity(" ");
		obj.setOwnership(" ");
		obj.setOwnership(" ");
		
		//obj.setAreaCode(pivModel.getGldeptobj().getDeptId());
		
		//obj.setPhase(new B);
		wiLaDeDao.save(obj);
		*/
		System.out.println("test 2 : gayani ");
		
		/////
		WiringLandDetailCon objCon = new WiringLandDetailCon();
		WiringLandDetailConPK objConPk = new WiringLandDetailConPK();
		objConPk.setApplicationId(application.getId().getApplicationId());
		objConPk.setDeptId(application.getId().getDeptId());
		objCon.setId(objConPk);
		if(pivModel.getGldeptobj() != null){
			objCon.setAreaCode(pivModel.getGldeptobj().getDeptId());
			
		}
		wiLaDeConDao.save(objCon);
		System.out.println("test 1 : gayani ");
		
		
		
		addAppointment(application.getId().getDeptId(),userName.trim(),alocated_To.trim(),nextApplicationNo,pivModel);
		EstimateReferencebPK esPk = new EstimateReferencebPK();
		esPk.setDeptId(application.getId().getDeptId());
		System.out.println("agayani "+nextApplicationNo);
		
		esPk.setSestimateNo(nextApplicationNo);
		String westimate_no = nextApplicationNo+"/1";
		esPk.setWestimateNo(nextApplicationNo+"/1");
		EstimateReferenceb esObjEstimateReferenceb = new EstimateReferenceb();
		esObjEstimateReferenceb.setId(esPk);
		esObjEstimateReferenceb.setEntryBy(userName);
		estRefDao.save(esObjEstimateReferenceb);
		//populatePceshtts(westimate_no,userName,application.getId().getDeptId(),pivModel);
		//populatePcestdtts(westimate_no,application.getId().getDeptId(), pivModel.getInspection());
	///pchttDao.save(pcesthtt);
		//int count = pcestdtt.size();
		//for (int i=0;i<count;i++){
			//Pcestdtt obj = pcestdtt.get(i);
			//pcdttDao.save(obj);
		//}
		
		// TODO Auto-generated method stub
		return westimate_no;
	}
	
	
	
	
	public SpestedyCon addAppointment(String deptId,String userId,String allocatedTo,String applicationNo,PivModel pivModel){
		SpestedyCon spestedy =null;
		try{
 			Format format=new Format();
 			spestedy = new SpestedyCon();
			SpestedyConPK id= new SpestedyConPK();
			//DW
			id.setDeptId(deptId);
			System.out.println("appReference %%%%%%%%%%%%%%%%%%%%%%%%%%% "+spestDao.getNextAppointmentId(deptId));
			
			id.setAppointmentId(spestDao.getNextAppointmentId(deptId));
			spestedy.setId(id);	
			Calendar calandar= Calendar.getInstance();
			spestedy.setAppointmentDate(calandar.getTime());
			String des = pivModel.getSpsdescription();
			
			if(pivModel.getIntRequestObj() != null){
				/*if(deptId.equals("600.41")){
					des = pivModel.getIntRequestObj().getReason();
					
				}else{
					des = pivModel.getIntRequestObj().getReferenceNo() + " : " + pivModel.getIntRequestObj().getReason();
					
				}
				*/	
					
				spestedy.setDescription(des);
				spestedy.setAllocatedTo(userId);	
				spestedy.setAllocatedBy(pivModel.getIntRequestObj().getApprovedBy());
				
				
			}else{
				spestedy.setDescription(des);
				spestedy.setAllocatedTo(allocatedTo);	
				
			}
			//spestedy.setTimeSession(sessionName);
			spestedy.setAllocatedDate(calandar.getTime());
			spestedy.setAllocatedTime(format.FormatTime());
			spestedy.setAppoinmentType("ES.VISIT");
			spestedy.setStatus("A");
			spestedy.setReferenceNo(applicationNo);
			spestedy.setWestimateNo(applicationNo+"/1");
			
			spestDao.save(spestedy);
			
			
			
 		}catch(Exception ex){
 			System.out.println("The eror is...................:"+ex.getMessage());
 			//return "error";
 			
 		}
 		return spestedy;
 		
 	}
 

	@Override
	public String updateApplication(Application application) {
		// TODO Auto-generated method stub
		em.merge(application);
		return null;
	}
	
private Pcestdtt populatePcestdtts(String westimate_no,String costCenter,MmsInspection inspectionn){
		
	//System.out.println("getTransport" + inspectionn.getTransport() +(inspectionn.getTransport().doubleValue() > 0));
	    //if(inspectionn.getHotLineAllowances())
	 	Long revNo = 2l;
        String genRes = "F";
        String normDefault = "F";
        List<Pcestdtt> pcestdttList = new ArrayList<Pcestdtt>();
	       
		try {
			if(inspectionn.getLabourValueForEst() != null && inspectionn.getLabourValueForEst().doubleValue() > 0){
				System.out.println("getLabourValueForEst");
			Pcestdtt pcestdtt = new Pcestdtt();
			PcestdttPK pcestdttPk = new PcestdttPK();
			pcestdttPk.setDeptId(costCenter);
			pcestdttPk.setEstimateNo(westimate_no);
			pcestdttPk.setResCd("LABOUR");
			pcestdttPk.setRevNo(revNo);
					
			pcestdtt.setId(pcestdttPk);
			pcestdtt.setResCat(new BigDecimal(2));
			pcestdtt.setEstimateCost(inspectionn.getLabourValueForEst());
			pcestdtt.setEstimateQty(inspectionn.getLabourValueForEst());
			pcestdtt.setResType("LABOUR-COST");
			pcestdtt.setUom("NO");
			System.out.println("Hi unit price");
			pcestdtt.setUnitPrice(new BigDecimal(1));
			pcestdtt.setNormDefault(normDefault);
			pcestdtt.setGenRes(genRes);
			pcdttDao.save(pcestdtt);
			}
			
			if(inspectionn.getTransport() != null && inspectionn.getTransport().doubleValue() > 0){
				System.out.println("getTransport");
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("TRANSPORT");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(2));
					pcestdtt.setEstimateCost(inspectionn.getTransport());
					pcestdtt.setEstimateQty(inspectionn.getTransport());
					pcestdtt.setResType("TRANSPORT-COST");
					pcestdtt.setUom("NO");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(1));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}

			if(inspectionn.getHotLineAllowances() != null && inspectionn.getHotLineAllowances().doubleValue() > 0){
				System.out.println("getHotLineAllowances");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("HOT_LINE_ALLOWANCE");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(2));
					pcestdtt.setEstimateCost(inspectionn.getHotLineAllowances());
					pcestdtt.setEstimateQty(inspectionn.getHotLineAllowances());
					pcestdtt.setResType("SUBSISTANCE-COST");
					pcestdtt.setUom("NO");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(1));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}
      if(inspectionn.getSubsistance() != null && inspectionn.getSubsistance().doubleValue() > 0){
				System.out.println("getSubsistance");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("SUBSISTANCE");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(2));
					pcestdtt.setEstimateCost(inspectionn.getSubsistance());
					pcestdtt.setEstimateQty(inspectionn.getSubsistance());
					pcestdtt.setResType("SUBSISTANCE-COST");
					pcestdtt.setUom("NO");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(1));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}
			if(inspectionn.getTemporarySiteCost() != null && inspectionn.getTemporarySiteCost().doubleValue() > 0){
				System.out.println("getTemporarySiteCost");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("HOUSE_RENT");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(2));
					pcestdtt.setEstimateCost(inspectionn.getTemporarySiteCost());
					pcestdtt.setEstimateQty(inspectionn.getTemporarySiteCost());
					pcestdtt.setResType("OTHER-COST");
					pcestdtt.setUom("NO");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(1));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
					System.out.println("getTemporarySiteCostendd");
			}     
			System.out.println("C0138" + inspectionn.getMatC0138());
			
			if(inspectionn.getMatC0138() != null && inspectionn.getMatC0138().doubleValue() > 0){
				System.out.println("C0138");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("C0138");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(1));
					pcestdtt.setEstimateCost(inspectionn.getMatC0138());
					double quantity = inspectionn.getMatC0138().doubleValue()/Util.CO138; 
					pcestdtt.setEstimateQty(new BigDecimal(quantity));
					pcestdtt.setResType("MAT-COST");
					pcestdtt.setUom("NO.");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(Util.CO138));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}       
			
			if(inspectionn.getMatC0143() != null && inspectionn.getMatC0143().doubleValue() > 0){
				System.out.println("C0143");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("C0143");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(1));
					pcestdtt.setEstimateCost(inspectionn.getMatC0143());
					double quantity = inspectionn.getMatC0143().doubleValue()/Util.CO143; 
					pcestdtt.setEstimateQty(new BigDecimal(quantity));
					pcestdtt.setResType("MAT-COST");
					pcestdtt.setUom("NO.");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(Util.CO143));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}if(inspectionn.getMatC0190() != null && inspectionn.getMatC0190().doubleValue() > 0){
				System.out.println("C0190");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("C0190");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(1));
					pcestdtt.setEstimateCost(inspectionn.getMatC0190());
					double quantity = inspectionn.getMatC0190().doubleValue()/Util.CO190; 
					pcestdtt.setEstimateQty(new BigDecimal(quantity));
					pcestdtt.setResType("MAT-COST");
					pcestdtt.setUom("NO.");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(Util.CO190));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}if(inspectionn.getMatC0180() != null && inspectionn.getMatC0180().doubleValue() > 0){
				System.out.println("C0180");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("C0180");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(1));
					pcestdtt.setEstimateCost(inspectionn.getMatC0180());
					double quantity = inspectionn.getMatC0180().doubleValue()/Util.CO180; 
					pcestdtt.setEstimateQty(new BigDecimal(quantity));
					pcestdtt.setResType("MAT-COST");
					pcestdtt.setUom("NO.");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(Util.CO180));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}if(inspectionn.getMatC0140()!= null && inspectionn.getMatC0140().doubleValue() > 0){
				System.out.println("C0140");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("C0140");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(1));
					pcestdtt.setEstimateCost(inspectionn.getMatC0140());
					double quantity = inspectionn.getMatC0140().doubleValue()/Util.CO140; 
					pcestdtt.setEstimateQty(new BigDecimal(quantity));
					pcestdtt.setResType("MAT-COST");
					pcestdtt.setUom("NO.");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(Util.CO140));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}if(inspectionn.getMatW1246()!= null && inspectionn.getMatW1246().doubleValue() > 0){
				System.out.println("C0140");
				
				  Pcestdtt pcestdtt = new Pcestdtt();
					PcestdttPK pcestdttPk = new PcestdttPK();
					pcestdttPk.setDeptId(costCenter);
					pcestdttPk.setEstimateNo(westimate_no);
					pcestdttPk.setResCd("W1246");
					pcestdttPk.setRevNo(revNo);
							
					pcestdtt.setId(pcestdttPk);
					pcestdtt.setResCat(new BigDecimal(1));
					pcestdtt.setEstimateCost(inspectionn.getMatW1246());
					double quantity = inspectionn.getMatW1246().doubleValue()/Util.W1246; 
					pcestdtt.setEstimateQty(new BigDecimal(quantity));
					pcestdtt.setResType("MAT-COST");
					pcestdtt.setUom("NO.");
					System.out.println("Hi unit price");
					pcestdtt.setUnitPrice(new BigDecimal(Util.W1246));
					pcestdtt.setNormDefault(normDefault);
					pcestdtt.setGenRes(genRes);
					pcdttDao.save(pcestdtt);
			}else{
				 
			}
			
			
			 /*Pcestdtt pcestdtt = new Pcestdtt();
				PcestdttPK pcestdttPk = new PcestdttPK();
				pcestdttPk.setDeptId(costCenter);
				pcestdttPk.setEstimateNo(westimate_no);
				pcestdttPk.setResCd("MAT");
				pcestdttPk.setRevNo(revNo);
						
				pcestdtt.setId(pcestdttPk);
				pcestdtt.setResCat(new BigDecimal(1));
				pcestdtt.setEstimateCost(new BigDecimal("0"));
				//double quantity = inspectionn.getMatC0180().doubleValue()/Util.CO180; 
				pcestdtt.setEstimateQty(new BigDecimal("0"));
				pcestdtt.setResType("MAT");
				pcestdtt.setUom("NO.");
				System.out.println("Hi unit price");
				pcestdtt.setUnitPrice(new BigDecimal("0"));
				pcestdtt.setNormDefault(normDefault);
				pcestdtt.setGenRes(genRes);
				pcdttDao.save(pcestdtt);
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return null;
	}

private Pcesthtt populatePceshtts(String westimate_no,String userName,String costCenter,PivModel pivModel){
	
	PcesthttPK pcesthttPK = new PcesthttPK();
	pcesthttPK.setEstimateNo(westimate_no);
	pcesthttPK.setDeptId(costCenter);
	pcesthttPK.setRevNo(2);//for new methods-
	
	Pcesthtt pcesthtt = new Pcesthtt();
	pcesthtt.setId(pcesthttPK);
	System.out.println("test : 7" );
	pcesthtt.setPartialPmt("F");
	pcesthtt.setNormDefault(new BigDecimal(1));
	pcesthtt.setSubCont("T");
	pcesthtt.setControlled("T");
	pcesthtt.setPriority(new BigDecimal(0));
	pcesthtt.setAllocPaid(new BigDecimal(0));
	pcesthtt.setEstType("2");
	System.out.println("test : 8" );
	pcesthtt.setAllocSettle(new BigDecimal(0)); 
	pcesthtt.setPartialAmt(new BigDecimal(0));
		
	System.out.println("test : 9" );
	pcesthtt.setEtimateDt(new java.util.Date());
	pcesthtt.setStatus(new BigDecimal("75"));
	pcesthtt.setEntBy(userName);
	pcesthtt.setEntDt(new java.util.Date());
	if(costCenter.equalsIgnoreCase("596.00")){
		pcesthtt.setCatCd("MAINTENANCE-JOB");
		
	}else{
		pcesthtt.setCatCd("CAP_HT");
	}
	System.out.println("test : 10" );
	//pcesthtt.set
	//Format format=new Format();
	
	pcesthtt.setConfDt(new java.util.Date());
	pcesthtt.setAprDt1(new java.util.Date());
	pcesthtt.setAprDt2(new java.util.Date());
	pcesthtt.setAprDt3(new java.util.Date());
	pcesthtt.setAprDt4(new java.util.Date());
	pcesthtt.setAprDt5(new java.util.Date());
	pcesthtt.setRejctDt(new java.util.Date());
	pcesthtt.setReviseDt(new java.util.Date());
	System.out.println("test test :" + pivModel.getInspection());
	System.out.println("test test 1 :" + pivModel.getSpsdescription());
	System.out.println("pivModel.getCycle() :" + pivModel.getCycle());
	
	if(pivModel.getInspection() != null){
		/*if(pivModel.getEstimateType().equalsIgnoreCase("INS")){
	pcesthtt.setDescr("This estimate is created for the Hot line Inspection of " + pivModel.getInspection().getDescription() +" No of tower : "+pivModel.getInspection().getTotalNoTowers() +" Total line length : " + pivModel.getInspection().getTotalLineLength() +" Total labour hours :"+
	pivModel.getInspection().getLabourHoursForEst() + " No of days for the inspection : " + pivModel.getInspection().getNoDaysForTheIns());
	pcesthtt.setStdCost(pivModel.getInspection().getTatalCost());
		}else if(pivModel.getEstimateType().equalsIgnoreCase("HOT")){
			pcesthtt.setDescr("This estimate is created for the the Hot line Maintenance of " + pivModel.getInspection().getDescription() +" No of tower : "+pivModel.getInspection().getTotalNoTowers() +" Total line length : " + pivModel.getInspection().getTotalLineLength() +" Total labour hours :"+
					pivModel.getInspection().getLabourHoursForEst() + " No of days for the inspection : " + pivModel.getInspection().getNoDaysForTheIns());
					pcesthtt.setStdCost(pivModel.getInspection().getTatalCost());
					
		}else if(pivModel.getEstimateType().equalsIgnoreCase("COLD")){
			pcesthtt.setDescr("This estimate is created for the the Cold line Maintenance of " + pivModel.getInspection().getDescription() +" No of tower : "+pivModel.getInspection().getTotalNoTowers() +" Total line length : " + pivModel.getInspection().getTotalLineLength() +" Total labour hours :"+
					pivModel.getInspection().getLabourHoursForEst() + " No of days for the inspection : " + pivModel.getInspection().getNoDaysForTheIns());
					pcesthtt.setStdCost(pivModel.getInspection().getTatalCost());
					
		}else if(pivModel.getEstimateType().equalsIgnoreCase("CIVIL")){
			pcesthtt.setDescr( pivModel.getInspection().getDescription() );
					
		}*/
		if(pivModel.getEstimateType().equalsIgnoreCase("INS")){
			pcesthtt.setDescr("This estimate is created for the Hot line Inspection of " + pivModel.getInspection().getDescription());
			pcesthtt.setStdCost(pivModel.getInspection().getTatalCost());
				}else if(pivModel.getEstimateType().equalsIgnoreCase("HOT")){
					pcesthtt.setDescr("This estimate is created for the the Hot line Maintenance of " + pivModel.getInspection().getDescription());
							pcesthtt.setStdCost(pivModel.getInspection().getTatalCost());
							
				}else if(pivModel.getEstimateType().equalsIgnoreCase("COLD")){
					pcesthtt.setDescr("This estimate is created for the the Cold line Maintenance of " + pivModel.getInspection().getDescription());
							pcesthtt.setStdCost(pivModel.getInspection().getTatalCost());
							
				}else if(pivModel.getEstimateType().equalsIgnoreCase("CIVIL")){
					pcesthtt.setDescr( pivModel.getInspection().getDescription() );
							
				}
	
	}else if(pivModel.getSpsdescription() != null && pivModel.getSpsdescription().equalsIgnoreCase("")){
		
		pcesthtt.setDescr(pivModel.getSpsdescription());
	}else{
		/*if(pivModel.getError1() != null){
			if(pivModel.getError1().equalsIgnoreCase("CIVIL")){
				pcesthtt.setDescr(pivModel.getError());
				pcesthtt.setStdCost(new BigDecimal("0"));
			}
		}else{
			pcesthtt.setDescr("MMS");
			pcesthtt.setStdCost(new BigDecimal("0"));
		}*/
		
		pcesthtt.setDescr("This estimate is generated through the MVMMS");
		pcesthtt.setStdCost(new BigDecimal("0"));
	}
	//pcesthtt.setStdCost(pivModel.getInspection().getTatalCost() != null ? pivModel.getInspection().getTatalCost()  : "0");
	
	System.out.println("test : 11" );
	if(costCenter.equalsIgnoreCase("596.00")){
		pcesthtt.setFundSource("REH");
		pcesthtt.setFundId("REH");
		
	}else{
		pcesthtt.setFundSource("CP");
		pcesthtt.setFundId("CP");
	}
	pchttDao.save(pcesthtt);
	
return null;
}

@Override
public Application findById(ApplicationPK objPk) {
	return em.find(Application.class, objPk);
	}

@Override
public Application findByAppDeptId(String appNo, String deptid) {
	Query query = null;
	String qryStr ="";
	try {
		qryStr = "select a from Application a where a.applicationNo =:appNo and a.id.deptId =:deptid ";
		query = em.createQuery(qryStr);
		query.setParameter("appNo", appNo.trim());
		query.setParameter("deptid", deptid.trim());
		
		List<Application> list = query.getResultList();
		
		
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


}
