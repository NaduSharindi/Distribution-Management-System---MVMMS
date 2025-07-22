package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.asn1.x509.UserNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.ApprovalModel;
import com.it.piv.issue.domain.PcestdttModel;
import com.it.piv.issue.domain.PcesthttModel;
import com.it.piv.issue.domain.SpstdesthmtModel;
import com.it.piv.mms.domain.Appestlim;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.EstimateReferenceb;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;
import com.it.piv.mms.domain.PivDetail;
import com.it.piv.mms.domain.Speststd;
import com.it.piv.mms.domain.SpeststdPK;
import com.it.piv.mms.domain.Sprebate;
import com.it.piv.mms.domain.SprebatePK;
import com.it.piv.mms.domain.Spstdestdmt;
import com.it.piv.mms.domain.SpstdestdmtModel;
import com.it.piv.mms.domain.Spstdesthmt;
import com.it.piv.mms.domain.WiringLandDetail;
import com.it.piv.mms.domain.WiringLandDetailCon;
import com.it.piv.mms.repo.AppestlimDao;
import com.it.piv.mms.repo.ApplicantDao;
import com.it.piv.mms.repo.ApplicationDao;
import com.it.piv.mms.repo.ApprovalDao;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.EstimateReferencebDao;
import com.it.piv.mms.repo.InmatmDao;
import com.it.piv.mms.repo.PcestdttDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.mms.repo.PivDetailDao;
import com.it.piv.mms.repo.SpestedyConDao;
import com.it.piv.mms.repo.SpeststdDao;
import com.it.piv.mms.repo.SprebateDao;
import com.it.piv.mms.repo.SpstdestdmtDao;
import com.it.piv.mms.repo.SpstdesthmtDao;
import com.it.piv.mms.repo.WiringLandDetailConDao;
import com.it.piv.mms.repo.WiringLandDetailDao;
import com.it.piv.util.common.EstimateStatus;
import com.it.piv.util.common.Format;
import com.it.piv.util.common.PathMMS;
import com.it.piv.mms.domain.Pcestdmt;
import com.it.piv.mms.repo.PcestdmtDao;
import com.it.piv.mms.repo.PcesthmtDao;

@Controller
public class ApprovalController {
	
	
	@Autowired 	
	private SpstdestdmtDao spDmtDao;
	
	
	@Autowired 	
	private WiringLandDetailDao wlDao;
	
	@Autowired 	
	private WiringLandDetailConDao wlConDao;
	
	@Autowired 	
	private PivDetailDao pivDetailDao;
	
	@Autowired 	
	private ApplicantDao applicantDao;
	
	@Autowired 	
	private ApplicationDao applicantionDao;
	
	@Autowired
	private ApprovalDao approvalDao;
	
	@Autowired
	private ApprovalMmDao approvalMm;
	@Autowired 	
	private EstimateReferencebDao estRefDao;
	
	@Autowired 	
	private PcesthmtDao pchmtDao;
	@Autowired 	
	private PcestdmtDao pchmtDttDao;
	@Autowired 	
	private SecurityDao secDao;
	@Autowired 	
	private SpstdesthmtDao stdDao;
	
	
	@Autowired 	
	private PcesthttDao pcestDao;
	@Autowired 	
	private PcestdttDao pcestDttDao;
	@Autowired 	
	private InmatmDao inmatmDao;
	@Autowired 	
	private SprebateDao rebateDao;
	@Autowired
	public AppestlimDao appEstLimDao; 
	@Autowired
	public SpeststdDao spestDao; 
	@Autowired
	private ApprovalDao approval;
	
	@Autowired
	private SpestedyConDao spestedyConDao;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/countValueJournalNew" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String countValueJournalNew(HttpServletRequest request) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/ceb_ptl/api/MitfinUser/GetApprovalCountByMitfinUser?user="+userName.trim();    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				System.out.println("countValueJournal : "+ valueJurnal);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return valueJurnal;
	       
	}
	
	
	
	/*@RequestMapping(value = "/estApprovalNew")
	public ModelAndView estApprovalNew(HttpServletRequest request) {
		ApprovalModel model = new ApprovalModel();
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		List<Pcesthmt>  pcesthmtList =null;
		pcesthmtList = pcestDao.getJobNoByStatus("1", deptId);

		//ModelAndView pcesthmtList = new ModelAndView();
		model.setPcesthmtList(pcesthmtList);
		
		return new ModelAndView("JobCompletion", "model", model);
		
	
	}
*/	
	
	 @RequestMapping(value = "/estApprovalCommercial",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalCommercial(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Spstdesthmt>  pcesthttList =null;
		 
		 List<Spstdesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= stdDao.getApprovalListSPS(usrName.trim(), usrRole.trim());
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Spstdesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Spstdesthmt obj = pcesthttList.get(i);
				 String estimateNo = obj.getId().getAppNo().trim();
				 PcesthttModel pcmodel = new PcesthttModel();
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 String ss = df2.format(obj.getToconpay().doubleValue());
				 if(usrRole.equals("DGM")){
					 if(obj.getToconpay().doubleValue() > 50000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getToconpay().doubleValue() > 25000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getToconpay().doubleValue() > 5000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setBalCapacity(new BigDecimal("0"));
					 
				 }else if(usrRole.equals("PE") && estimateNo.contains("PL")){
					 if(obj.getToconpay().doubleValue() > 5000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("PE") && !estimateNo.contains("PL")){
					 	 obj.setBalCapacity(new BigDecimal("1"));
					 
				 }else if(usrRole.equals("PCE") && estimateNo.contains("PL")){
					 if(obj.getToconpay().doubleValue() > 25000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("PCE") && !estimateNo.contains("PL")){
					 	 obj.setBalCapacity(new BigDecimal("1"));
					 
				 }
				 pcmodel.setEstimateNo(obj.getId().getAppNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescription());
				 pcmodel.setNormDefault(obj.getBalCapacity());


				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setStdList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalCom", "model", model);
			
	 }
	 
	 
	 @RequestMapping(value = "/estApprovalCommercialStatus",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalCommercialStatus(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Spstdesthmt>  pcesthttList =null;
		 
		 List<Spstdesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= stdDao.getEstimateList(deptId);
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Spstdesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Spstdesthmt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 String ss = Util.getFromattedValue(obj.getToconpay().doubleValue());
				 pcmodel.setEstimateNo(obj.getId().getAppNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescription());
				 pcmodel.setNormDefault(obj.getBalCapacity());
				 pcmodel.setStrStatus(Util.searchStatusStd(obj.getStatus().intValue()));
				 pcesthttModelListNew.add(i, pcmodel);
				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setStdList(pcesthttListNew);
		 model.setResult(null);
		 return new ModelAndView("estApprovalComStatus", "model", model);
			
	 }
	 
	 @RequestMapping(value = "/stdConfirmPIV",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView stdConfirmPIV(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Spstdesthmt>  pcesthttList =null;
		 
		 List<Spstdesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= stdDao.getEstimateList(deptId);
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Spstdesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Spstdesthmt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 String ss = Util.getFromattedValue(obj.getToconpay().doubleValue());
				 pcmodel.setEstimateNo(obj.getId().getAppNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescription());
				 pcmodel.setNormDefault(obj.getBalCapacity());
				 pcmodel.setStrStatus(Util.searchStatusStd(obj.getStatus().intValue()));
				 pcesthttModelListNew.add(i, pcmodel);
				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setStdList(pcesthttListNew);
		 model.setResult(null);
		 return new ModelAndView("estApprovalComStatus", "model", model);
			
	 }



	
	 @RequestMapping(value = "/estApprovalNew",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNew(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333");
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= pcestDao.getApprovalListNew(usrRole.trim(),usrName.trim(),deptId.trim());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333yyyyyyyyyyyy" +pcesthttList );
			
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 System.out.println("rrrrrrrrrrr"+ count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
					
				 System.out.println("rrrrrrrrrrr tttt"+ count);
					
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 
				 //df2.setRoundingMode(RoundingMode.CEILING);

				 System.out.println("ttttttttt 111   ");
				 //double roundOff = Math.round(a * 100.0) / 100.0;
				 String ss = df2.format(obj.getStdCost().doubleValue());

				System.out.println("rrrrrrrrrrr ggg"+ count);
				 
				 if(usrRole.equals("DGM")){
					 if(obj.getStdCost().doubleValue() > 50000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getStdCost().doubleValue() > 25000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getStdCost().doubleValue() > 5000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setNormDefault(new BigDecimal("0"));
					 
				 }
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setNormDefault(obj.getNormDefault());


				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalNew", "model", model);
			
	 }
	 
	 
	 @RequestMapping(value = "/estApprovalNewStatus",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNewStatus(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= pcestDao.getApprovalListNewStatus(usrRole.trim(),usrName.trim(),deptId.trim());
			
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 String resEE = "";
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 if(obj.getAprUid5() != null){
				 Sauserm mm = secDao.getSauserm(obj.getAprUid5());
				 if(mm != null){
					 resEE= mm.getUserNm();
					  
				 }
				 }
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 String ss = "";
				 if(obj.getStdCost() != null){
					 ss = df2.format(obj.getStdCost().doubleValue());
				 }
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setEtimateDt(obj.getEtimateDt());
				 pcmodel.setStrStatus(Util.searchStatus(obj.getStatus().intValue()));
				 pcmodel.setEeName(resEE);
				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 return new ModelAndView("estApprovalNewStatus", "model", model);
			
	 }

	 
	 
	 @RequestMapping(value = "/estApprovalNewRecommend",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNewRecommend(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333");
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= pcestDao.getApprovalListNew(usrRole.trim(),usrName.trim(),deptId.trim());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333yyyyyyyyyyyy" +pcesthttList );
			
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 System.out.println("rrrrrrrrrrr"+ count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
					
				 System.out.println("rrrrrrrrrrr tttt"+ count);
					
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 
				 //df2.setRoundingMode(RoundingMode.CEILING);

				 System.out.println("ttttttttt 111   ");
				 //double roundOff = Math.round(a * 100.0) / 100.0;
				 String ss = df2.format(obj.getStdCost().doubleValue());

				System.out.println("rrrrrrrrrrr ggg"+ count);
				 
				 if(usrRole.equals("DGM")){
					 if(obj.getStdCost().doubleValue() > 50000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getStdCost().doubleValue() > 25000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getStdCost().doubleValue() > 5000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setNormDefault(new BigDecimal("0"));
					 
				 }
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setNormDefault(obj.getNormDefault());


				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalNewRecommend", "model", model);
			
	 }

	 
	 
	 @RequestMapping(value = "/estApprovalNewESDA",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNewESDA(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 Map<String, String> eeList = new LinkedHashMap<String, String>();
			
		 List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "EE");
		 
		 	
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					System.out.println("rrrrrrrrrrr"+ objUser.getUserId());
					 
					eeList.put(objUser.getUserId(),objUser.getUserNm());
					
				}
			}
		pcesthttList= pcestDao.getApprovalListES(deptId, "46");
		 
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 				 String ss ="0";
				 if(obj.getStdCost() != null){
					ss = df2.format(obj.getStdCost().doubleValue());

				 }
				 
				 String eeName="";
				 Sauserm saObj=null;
				 if(obj.getAprUid5() != null){
					 saObj= secDao.getSauserm(obj.getAprUid5().trim());
					 if(saObj != null){
						 eeName = saObj.getUserNm();
					 }
				 }
				
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setEeName(eeName);

				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			model.setEeList(eeList);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalNewESDA", "model", model);
			
	 }
	 
	 
	 
	 	 
	 
	 
	 @RequestMapping(value = "/estApprovalNewES",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNewES(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 Map<String, String> eeList = new LinkedHashMap<String, String>();
			
		 List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "EE");
		 
		 	
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					System.out.println("rrrrrrrrrrr"+ objUser.getUserId());
					 
					eeList.put(objUser.getUserId(),objUser.getUserNm());
					
				}
			}
			
			//List<String> status = new ArrayList<String>();
			//status[0].add();
		pcesthttList= pcestDao.getApprovalListESSFV(deptId,usrName,"75");
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 				 String ss ="0";
				 if(obj.getStdCost() != null){
					ss = df2.format(obj.getStdCost().doubleValue());

				 }
				 
				 String eeName="";
				 Sauserm saObj=null;
				 if(obj.getAprUid5() != null){
					 saObj= secDao.getSauserm(obj.getAprUid5().trim());
					 if(saObj != null){
						 eeName = saObj.getUserNm();
					 }
				 }
				
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setEeName(eeName);
pcmodel.setEtimateDt(obj.getEtimateDt());
				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			model.setEeList(eeList);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalNewES", "model", model);
			
	 }
	 
	 
	 @RequestMapping(value = "/estApprovalNewESSearch",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNewESSearch(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 Map<String, String> eeList = new LinkedHashMap<String, String>();
			
		 List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "EE");
		 
		 	
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					System.out.println("rrrrrrrrrrr"+ objUser.getUserId());
					 
					eeList.put(objUser.getUserId(),objUser.getUserNm());
					
				}
			}
			
			//List<String> status = new ArrayList<String>();
			//status[0].add();
		pcesthttList= pcestDao.getApprovalListESSFV(deptId,usrName,"75");
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 				 String ss ="0";
				 if(obj.getStdCost() != null){
					ss = df2.format(obj.getStdCost().doubleValue());

				 }
				 
				 String eeName="";
				 Sauserm saObj=null;
				 if(obj.getAprUid5() != null){
					 saObj= secDao.getSauserm(obj.getAprUid5().trim());
					 if(saObj != null){
						 eeName = saObj.getUserNm();
					 }
				 }
				
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setEeName(eeName);

				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			model.setEeList(eeList);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalNewES", "model", model);
			
	 }

	 
	 
	
	 
	 
	 
	 @RequestMapping(value = "/estApprovalNewAE",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView estApprovalNewAE(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<String>  estimateNoList =null;
		 
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= pcestDao.getApprovalListAENew(usrRole.trim(),usrName.trim(),deptId.trim());
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 String ss = Util.getFromattedValue(obj.getStdCost().doubleValue());
				 if(obj.getStdCost() != null){
	
				 if(usrRole.equals("DGM")){
					 if(obj.getStdCost().doubleValue() > 50000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getStdCost().doubleValue() > 25000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getStdCost().doubleValue() > 5000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setNormDefault(new BigDecimal("0"));
					 
				 }else{
					 obj.setNormDefault(new BigDecimal("0"));
					 
				 }
}else{
	obj.setNormDefault(new BigDecimal("0"));
	 
}
pcmodel.setEstimateNo(obj.getId().getEstimateNo());
pcmodel.setDeptId(obj.getId().getDeptId());
pcmodel.setStdCost(ss);
pcmodel.setDescr(obj.getDescr());
pcmodel.setNormDefault(obj.getNormDefault());


pcesthttModelListNew.add(i, pcmodel);
				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 
			model.setListPcesthttModel(pcesthttModelListNew);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 return new ModelAndView("estApprovalNew", "model", model);
			
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	    
	 @RequestMapping(value = "/viewInfo",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView viewInfo(@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter){
		 ApprovalModel model = new ApprovalModel();
		 PcesthttPK pk = new PcesthttPK();
		 pk.setDeptId(costCenter.trim());
		 pk.setEstimateNo(estimateNo.trim());
		 pk.setRevNo(new Long("2"));
		 Pcesthtt obj = new Pcesthtt();
		 List<Pcestdtt> objDmt = null;
		 List<PcestdttModel> objDmtModel = null;
		 List<EstimateReferenceb> estReferenceBS = null;
		 List<Approval> approval = null;
		 List<ApprovalMm> approvalMmObj = null;
		 
		 approval = approvalDao.getHistory(estimateNo.trim());
		 approvalMmObj = approvalMm.getHistory(estimateNo.trim());	
		 
		 obj = pcestDao.getPcesthtt(estimateNo.trim(),costCenter.trim());
		 objDmt = pcestDttDao.getPcestdtt(estimateNo.trim(),costCenter.trim());
		 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
				
		 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
		 }
		 /*estReferenceBS = estRefDao.findByEstimateNo(estimateNo.trim(), costCenter.trim());
		 if(estReferenceBS != null){
			 EstimateReferenceb estRef = estReferenceBS.get(0);
			 
		 }
		*/ DecimalFormat df2 = new DecimalFormat("###,###,###.##");
		 //System.out.println("ttttttttt 111   ");
		 String ss ="";
		 if(obj.getStdCost() != null){
         ss = df2.format(obj.getStdCost().doubleValue());
		 }
		 String rebateCost = "";
		 if(obj.getPartialAmt() != null){
	         rebateCost = df2.format(obj.getPartialAmt().doubleValue());
		}
			 
		 
		 //obj.setStdCost(new BigDecimal(df2.format(obj.getStdCost().doubleValue())));
		 
		 obj.setStdCost(obj.getStdCost());
		 
		 //System.out.println("ttttttttt   ");
		 
		 /*DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		 DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		 symbols.setGroupingSeparator(',');
		 formatter.setDecimalFormatSymbols(symbols);
*/

		 /*DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		 DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		 symbols.setGroupingSeparator(',');
		 formatter.setDecimalFormatSymbols(symbols);
		 System.out.println("ttttttttt   "+formatter.format(obj.getStdCost().longValue()));

		 System.out.println("ttttttttt 111  "+df2.format(obj.getStdCost().longValue()));
*/
		 
		 //System.out.println("countValueJournal1"+obj);	 
		 if(objDmt != null){
			int count = objDmt.size();
			objDmtModel = new ArrayList<PcestdttModel>(count);
			for(int i= 0 ; i<count ; i++){
				PcestdttModel objModel = new PcestdttModel();
				Pcestdtt newObj = objDmt.get(i);
				//System.out.println("rescd"+newObj.getId().getResCd());	 
				 if(newObj.getResType().trim().equals("MAT-COST")){
					 String code=inmatmDao.getName(newObj.getId().getResCd().trim());
					 
					 //System.out.println("code"+code);	 
						
					 objModel.setResCd(objDmt.get(i).getId().getResCd());
					 objModel.setResName(code);
						
				 }else{
					 objModel.setResCd(objDmt.get(i).getId().getResCd());
					 objModel.setResName(objDmt.get(i).getId().getResCd());
				 }
				 
				 objModel.setUom(objDmt.get(i).getUom());
				 objModel.setUnitPrice(objDmt.get(i).getUnitPrice());
				 objModel.setEstimateQty(objDmt.get(i).getEstimateQty());
				 String sss = df2.format(objDmt.get(i).getEstimateCost());
				 
				 objModel.setEstimateCost(sss);
				 
				 
				 SprebatePK spRebatePK = new SprebatePK();
				 spRebatePK.setDeptId(objDmt.get(i).getId().getDeptId());
				 spRebatePK.setEstimateNo(objDmt.get(i).getId().getEstimateNo());
				 spRebatePK.setResCd(objDmt.get(i).getId().getResCd());
				 Sprebate rebate = rebateDao.findById(spRebatePK);
				 if(rebate != null){
					 objModel.setRebateQty(rebate.getRebateQty());
					 String ssss = df2.format(rebate.getRebateCost());
						
					 objModel.setRebateCost(ssss);
					 objModel.setOffChargeQty(rebate.getOffchargeQty());
					 objModel.setReusableQty(rebate.getReusableQty());
							 
				 }
				 objDmtModel.add(i, objModel);
				
				
				
			}
		}
		 
		 PcesthttModel modelPcesthtt = new PcesthttModel();
		 if(obj != null){
			 modelPcesthtt.setEstimateNo(obj.getId().getEstimateNo());
			 modelPcesthtt.setDeptId(obj.getId().getDeptId());
			 modelPcesthtt.setEtimateDt(obj.getEtimateDt());
			 modelPcesthtt.setCatCd(obj.getCatCd());
			 modelPcesthtt.setFundSource(obj.getFundSource());
			 modelPcesthtt.setFundId(obj.getFundId());
			 modelPcesthtt.setPartialAmt(rebateCost);
			 modelPcesthtt.setStdCost(ss);
			 modelPcesthtt.setDescr(obj.getDescr());
			 
			 
		 }
		 model.setPcesthttModel(modelPcesthtt);
		 model.setApprovalHistoryList(approval);
		 model.setAttachmentList(approvalMmObj);
		 
		//model.setPcesthttObj(obj);
		 model.setListPcestdttModel(objDmtModel);
		 return new ModelAndView("estimateInfoNew","model", model);
			
	 }
	

	

	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullException(NullPointerException ex) {

	//ModelAndView model = new ModelAndView();
	//model.setViewName("MMS_Login");

	//model.addObject("errMsg", "this is null Exception.class");
	System.out.println("Exception occured3.........");
	//return model;
	return "MMS_Login";
	} 
	
	/*@ExceptionHandler(HttpSessionRequiredException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="The session has expired"))
	public String handleSessionExpired(){
	  return "sessionExpired";
	}
*/
	
	@RequestMapping(value = "/estApprovalNewTest")
	public ModelAndView estApprovalNewTest(HttpServletRequest request) {
				
		return new ModelAndView("NewFile");
		
	
	}
	
	
	@RequestMapping(value = "/approveEstimateMMSES",method = RequestMethod.POST, produces = "application/json")
	 public ModelAndView approveEstimateMMSES(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel,@RequestParam("file") MultipartFile file){
		
		 System.out.println("approveEstimateMMSES");
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		 String comment =apModel.getComment();
		 
		 System.out.println("approveEstimateMMSES comment"+comment);
			
		 //MultipartFile file = apModel.getFile();
		 String ee =apModel.getEe();
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 Calendar calendar = Calendar.getInstance();
		 Format format=new Format();
		 upload(file, costCenter,  estimateNo,usrRole,usrName);
		 
		 Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
		 Approval approvalObj=new Approval();
		 String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
 		 approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
 		 	
			approvalObj.setReferenceNo(estimateNo.trim());
			approvalObj.setDeptId(costCenter);
			approvalObj.setApprovalType("EST_FWRD");
			approvalObj.setApprovedLevel(usrRole);
			approvalObj.setApprovedBy(usrName);
			approvalObj.setApprovedDate(calendar.getTime());
			approvalObj.setApprovedTime(format.FormatTime());
			approvalObj.setReason(comment);
			
				pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_APPROVAL_EE));
				pcesthtt.setAprDt5(calendar.getTime());
				pcesthtt.setAprUid5(ee);
     			
     			approvalObj.setFromStatus("75");
     			approvalObj.setToStatus(EstimateStatus.EST_APPROVAL_EE);
     			pcestDao.update(pcesthtt);
     			approval.addApproval(approvalObj);
     			System.out.println("Successfully Forwarded");
 				String result = "Successfully Forwarded";
		
		
		
		ApprovalModel model = new ApprovalModel();
		 
		List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 Map<String, String> eeList = new LinkedHashMap<String, String>();
			
		 List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "EE");
		 
		 	
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					eeList.put(objUser.getUserId(),objUser.getUserNm());
					
				}
			}
		 pcesthttList= pcestDao.getApprovalListESSFV(deptId,usrName,"75");
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 String eeName="";
				 Sauserm saObj=null;
				 if(obj.getAprUid5() != null){
					 saObj= secDao.getSauserm(obj.getAprUid5().trim());
					 if(saObj != null){
						 eeName = saObj.getUserNm();
					 }
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 				 String ss ="0";
				 if(obj.getStdCost() != null){
					ss = df2.format(obj.getStdCost().doubleValue());

				 }
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setEtimateDt(obj.getEtimateDt());
				 
				 pcmodel.setEeName(eeName);

				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 model.setEeList(eeList);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(result);
		 return new ModelAndView("estApprovalNewES", "model", model);

	}
	
	@RequestMapping(value = "/approveEstimateMMSESDA",method = RequestMethod.POST, produces = "application/json")
	 public ModelAndView approveEstimateMMSESDA(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel){
		
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		 String ee =apModel.getEe();
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 Calendar calendar = Calendar.getInstance();
		 Format format=new Format();
			
		 Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
		 Approval approvalObj=new Approval();
		 String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
		 approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
		 	
			approvalObj.setReferenceNo(estimateNo.trim());
			approvalObj.setDeptId(costCenter);
			approvalObj.setApprovalType("EST_APRV");
			approvalObj.setApprovedLevel(usrRole);
			approvalObj.setApprovedBy(usrName);
			approvalObj.setApprovedDate(calendar.getTime());
			approvalObj.setApprovedTime(format.FormatTime());
			approvalObj.setReason("SPSNEW");
			
				pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_APPROVAL_EE));
				pcesthtt.setAprDt5(calendar.getTime());
				pcesthtt.setAprUid5(ee);
    			
    			approvalObj.setFromStatus("75");
    			approvalObj.setToStatus(EstimateStatus.EST_APPROVAL_EE);
    			pcestDao.update(pcesthtt);
    			approval.addApproval(approvalObj);
    			System.out.println("Successfully Forwarded");
				String result = "Successfully De-Allocated";
		
		
		
		ApprovalModel model = new ApprovalModel();
		 
		List<Pcesthtt>  pcesthttList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 Map<String, String> eeList = new LinkedHashMap<String, String>();
			
		 List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "EE");
		 
		 	
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					eeList.put(objUser.getUserId(),objUser.getUserNm());
					
				}
			}
		 pcesthttList= pcestDao.getApprovalListES(deptId, "46");
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthtt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthtt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 String eeName="";
				 Sauserm saObj=null;
				 if(obj.getAprUid5() != null){
					 saObj= secDao.getSauserm(obj.getAprUid5().trim());
					 if(saObj != null){
						 eeName = saObj.getUserNm();
					 }
				 }
				 
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 				 String ss ="0";
				 if(obj.getStdCost() != null){
					ss = df2.format(obj.getStdCost().doubleValue());

				 }
				 pcmodel.setEstimateNo(obj.getId().getEstimateNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescr());
				 pcmodel.setEeName(eeName);

				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			model.setEeList(eeList);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(result);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("estApprovalNewESDA", "model", model);

	}

	
	@RequestMapping(value = "/approveEstimateMMS",method = RequestMethod.POST, produces = "application/json")
	 public ModelAndView approveEstimateMMS(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 String estNumber = (String) request.getSession().getAttribute("estimateNo");
		 //String dId = (String) request.getSession().getAttribute("deptId");
		 System.out.println("estNumber: " + estNumber);
		 //System.out.println("deptId :" + dId);
		 
		 String result="";
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getSelectedEstimateNumber());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getApprove());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getReject());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getRecommend());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getRejectReason());
		 System.out.println("estimateNumber" + apModel.getEstimateNumber());
		 System.out.println("costNumber" + apModel.getCostCenter());
			
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		/* if(apModel.getSelectedEstimateNumber() != null){
			 String[] ss = apModel.getSelectedEstimateNumber().split(",");
			 System.out.println("rrrrrrrrrrrr  " + ss[0]);
			 System.out.println("rrrrrrrrrrrr  " + ss[1]);
			 estimateNo = ss[0];
			 costCenter = ss[1];
			 
			 estimateNo = estimateNo.trim();
			 costCenter = costCenter.trim();
		 }
		*/ 
		 //estimateNo = 
			
	/*if(apModel.getApprove()== null){
		apModel.setApprove("");
	}else if(apModel.getRecommend()== null){
		apModel.setRecommend("");
	}else if(apModel.getReject()== null){
			apModel.setReject("");
	}else{
		
	}
	*/if(apModel.getApprove()!= null && apModel.getApprove().equals("Approve")){
		 if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_APPROVED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_APPROVED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("Successfully Approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully Forwarded to next level";
			        			
			        		}else{
			        			result ="This estimate can not be approved!!!";
			        		}
						
						}else{
							result ="The estimate total cost can not be zero";
						}
						}else{
							result ="The estimate total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_APPROVED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_APPROVED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("Successfully Approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully forwarded to next level";
			        			
			        		}else{
			        			result ="The estimate number can not be approved!!!!!";
			        		}
						
						}else{
							result ="The estimate total cost can not be empty";
						}
						}else{
							result ="The estimatet total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("Approve my job : "+usrRole +" usrName : "+usrName);
				
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter.trim(), "DES", "DE", usrRole.trim());
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo,costCenter);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully forwarded to next level";
			        			
			        		}else{
			        			result ="The estimate can not approved.Please contact IT Branch";
			        		}
						
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

	}else if(apModel.getRecommend() != null && apModel.getRecommend().equals("Recommend")){
		
		if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "DES", "DE", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Estimate can not approved.Please contact IT Branch";
			        		}*/
						
						}else{
							result ="The total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

		
		
	}else if(apModel.getForward() != null && apModel.getForward().equals("Forward")){
		
		if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "DES", "DE", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Estimate can not approved.Please contact IT Branch";
			        		}*/
						
						}else{
							result ="The total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	else if(apModel.getReject() != null && apModel.getReject().equals("Reject")){
		
		System.out.println("Reject");
		PcesthttPK pk = new PcesthttPK();
		Pcesthtt pcesthtt = null;
		
		pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
		if(pcesthtt != null){
			BigDecimal totalCost = pcesthtt.getStdCost();
			
			//Approvals
			Calendar calendar = Calendar.getInstance();
			Format format=new Format();
			Approval approvalObj=new Approval();
			
		String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
   		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
   		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
			
			approvalObj.setReferenceNo(estimateNo.trim());
			approvalObj.setDeptId(costCenter);
			approvalObj.setApprovalType("EST_REJC");
			approvalObj.setApprovedLevel(usrRole);
			approvalObj.setApprovedBy(usrName);
			approvalObj.setApprovedDate(calendar.getTime());
			approvalObj.setApprovedTime(format.FormatTime());
			approvalObj.setDetailedCost(totalCost);
			approvalObj.setReason("SPSNEW");
			
				
				    approvalObj.setFromStatus(pcesthtt.getStatus().toString());
   			    pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_REJECTED));
   			    pcesthtt.setRejectReason(apModel.getRejectReason());
       			approvalObj.setToStatus(EstimateStatus.EST_REJECTED);
       			pcestDao.update(pcesthtt);
       			approval.addApproval(approvalObj);
       			System.out.println("successfully Rejected");
   				
       			result = "Successfully Rejected";
			
					
		}else{
			result ="The estimate number can not be found";
		}

		
		
		
	}else{
		
	}
	
		 
		 
		 
		 
		 
		 
		// String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			//String deptId = request.getSession().getAttribute("deptId").toString();
			ApprovalModel model = new ApprovalModel();
			
			List<Pcesthtt>  pcesthttList =null;
			 
			 List<Pcesthtt>  pcesthttListNew =null;
			 
			 List<String>  estimateNoList =null;
			 
			 
			 List<PcesthttModel>  pcesthttModelListNew =null;
			 
			 
			 pcesthttList= pcestDao.getApprovalListAENew(usrRole.trim(),usrName.trim(),deptId.trim());
			 //System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333yyyyyyyyyyyy" +pcesthttList );
				
			 if(pcesthttList != null){
				 int count = pcesthttList.size();
				 pcesthttListNew = new ArrayList<Pcesthtt>(count);
				 //estimateNoList = new ArrayList<String>(count);
				 
				// System.out.println("rrrrrrrrrrr"+ count);
				 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
				 
				 //pcesthttList= new ArrayList<Pcesthtt>(count);
				 for(int i=0 ; i < count ; i ++){
					 Pcesthtt obj = pcesthttList.get(i);
					 //estimateNoList.add(i, obj.getId().getEstimateNo());
					 PcesthttModel pcmodel = new PcesthttModel();
					// System.out.println("rrrrrrrrrrr tttt"+ count);
						
					 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
						 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
							
					 }
					// obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
					 //System.out.println("rrrrrrrrrrr ggg"+ count);
					 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
					 
					 //df2.setRoundingMode(RoundingMode.CEILING);

					 //System.out.println("ttttttttt 111   ");
					 //double roundOff = Math.round(a * 100.0) / 100.0;
					 String ss = df2.format(obj.getStdCost().doubleValue());
					 
					 //System.out.println("ttttttttt 111   " + ss);
					 
					 try {
						//obj.setStdCost(new BigDecimal(ss));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 if(obj.getStdCost() != null){
		
					 if(usrRole.equals("DGM")){
						 if(obj.getStdCost().doubleValue() > 50000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("CE")){
						 if(obj.getStdCost().doubleValue() > 25000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("EE")){
						 if(obj.getStdCost().doubleValue() > 5000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("AGM")){
						 	 obj.setNormDefault(new BigDecimal("0"));
						 
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
						 
					 }
	}else{
		obj.setNormDefault(new BigDecimal("0"));
		 
	}
	pcmodel.setEstimateNo(obj.getId().getEstimateNo());
	pcmodel.setDeptId(obj.getId().getDeptId());
	pcmodel.setStdCost(ss);
	pcmodel.setDescr(obj.getDescr());
	pcmodel.setNormDefault(obj.getNormDefault());


	pcesthttModelListNew.add(i, pcmodel);
					 pcesthttListNew.add(i, obj);		
				 }
			 }
			 
			 
			 
			 
				model.setListPcesthttModel(pcesthttModelListNew);
			 model.setPcesthttList(pcesthttListNew);
model.setResult(result);
			 return new ModelAndView("estApprovalNew", "model", model);
			
	 }
	
	@RequestMapping(value = "/recomendEstimateMMS",method = RequestMethod.POST, produces = "application/json")
	 public ModelAndView recomendEstimateMMS(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 String estNumber = (String) request.getSession().getAttribute("estimateNo");
		 //String dId = (String) request.getSession().getAttribute("deptId");
		 System.out.println("estNumber: " + estNumber);
		 //System.out.println("deptId :" + dId);
		 
		 String result="";
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getSelectedEstimateNumber());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getApprove());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getReject());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getRecommend());
		 System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333" + apModel.getRejectReason());
		 System.out.println("estimateNumber" + apModel.getEstimateNumber());
		 System.out.println("costNumber" + apModel.getCostCenter());
			
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		/* if(apModel.getSelectedEstimateNumber() != null){
			 String[] ss = apModel.getSelectedEstimateNumber().split(",");
			 System.out.println("rrrrrrrrrrrr  " + ss[0]);
			 System.out.println("rrrrrrrrrrrr  " + ss[1]);
			 estimateNo = ss[0];
			 costCenter = ss[1];
			 
			 estimateNo = estimateNo.trim();
			 costCenter = costCenter.trim();
		 }
		*/ 
		 //estimateNo = 
			
	/*if(apModel.getApprove()== null){
		apModel.setApprove("");
	}else if(apModel.getRecommend()== null){
		apModel.setRecommend("");
	}else if(apModel.getReject()== null){
			apModel.setReject("");
	}else{
		
	}
	*/if(apModel.getApprove()!= null && apModel.getApprove().equals("Approve")){
		 if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_APPROVED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_APPROVED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("Successfully Approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully Forwarded to next level";
			        			
			        		}else{
			        			result ="This estimate can not be approved!!!";
			        		}
						
						}else{
							result ="The estimate total cost can not be zero";
						}
						}else{
							result ="The estimate total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_APPROVED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_APPROVED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("Successfully Approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully forwarded to next level";
			        			
			        		}else{
			        			result ="The estimate number can not be approved!!!!!";
			        		}
						
						}else{
							result ="The estimate total cost can not be empty";
						}
						}else{
							result ="The estimatet total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("Approve my job : "+usrRole +" usrName : "+usrName);
				
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter.trim(), "DES", "DE", usrRole.trim());
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo,costCenter);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully forwarded to next level";
			        			
			        		}else{
			        			result ="The estimate can not approved.Please contact IT Branch";
			        		}
						
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

	}else if(apModel.getRecommend() != null && apModel.getRecommend().equals("Recommend")){
		
		if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setStandardCost(totalCostDetailCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "DES", "DE", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						approvalObj.setReason("SPSNEW");
						
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Estimate can not approved.Please contact IT Branch";
			        		}*/
						
						}else{
							result ="The total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

		
		
	}else if(apModel.getReject() != null && apModel.getReject().equals("Reject")){
		
		System.out.println("Reject");
		PcesthttPK pk = new PcesthttPK();
		Pcesthtt pcesthtt = null;
		
		pcesthtt = pcestDao.getPcesthtt(estimateNo, costCenter);
		if(pcesthtt != null){
			BigDecimal totalCost = pcesthtt.getStdCost();
			
			//Approvals
			Calendar calendar = Calendar.getInstance();
			Format format=new Format();
			Approval approvalObj=new Approval();
			
		String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
  		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
  		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
			
			approvalObj.setReferenceNo(estimateNo.trim());
			approvalObj.setDeptId(costCenter);
			approvalObj.setApprovalType("EST_REJC");
			approvalObj.setApprovedLevel(usrRole);
			approvalObj.setApprovedBy(usrName);
			approvalObj.setApprovedDate(calendar.getTime());
			approvalObj.setApprovedTime(format.FormatTime());
			approvalObj.setDetailedCost(totalCost);
			approvalObj.setReason("SPSNEW");
			
				
				    approvalObj.setFromStatus(pcesthtt.getStatus().toString());
  			    pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_REJECTED));
  			    pcesthtt.setRejectReason(apModel.getRejectReason());
      			approvalObj.setToStatus(EstimateStatus.EST_REJECTED);
      			pcestDao.update(pcesthtt);
      			approval.addApproval(approvalObj);
      			System.out.println("successfully Rejected");
  				
      			result = "Successfully Rejected";
			
					
		}else{
			result ="The estimate number can not be found";
		}

		
		
		
	}else{
		
	}
	
		 
		 
		 
		 
		 
		 
		// String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			//String deptId = request.getSession().getAttribute("deptId").toString();
			ApprovalModel model = new ApprovalModel();
			
			List<Pcesthtt>  pcesthttList =null;
			 
			 List<Pcesthtt>  pcesthttListNew =null;
			 
			 List<String>  estimateNoList =null;
			 
			 
			 List<PcesthttModel>  pcesthttModelListNew =null;
			 
			 
			 pcesthttList= pcestDao.getApprovalListAENew(usrRole.trim(),usrName.trim(),deptId.trim());
			 //System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333yyyyyyyyyyyy" +pcesthttList );
				
			 if(pcesthttList != null){
				 int count = pcesthttList.size();
				 pcesthttListNew = new ArrayList<Pcesthtt>(count);
				 //estimateNoList = new ArrayList<String>(count);
				 
				// System.out.println("rrrrrrrrrrr"+ count);
				 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
				 
				 //pcesthttList= new ArrayList<Pcesthtt>(count);
				 for(int i=0 ; i < count ; i ++){
					 Pcesthtt obj = pcesthttList.get(i);
					 //estimateNoList.add(i, obj.getId().getEstimateNo());
					 PcesthttModel pcmodel = new PcesthttModel();
					// System.out.println("rrrrrrrrrrr tttt"+ count);
						
					 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
						 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
							
					 }
					// obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
					 //System.out.println("rrrrrrrrrrr ggg"+ count);
					 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
					 
					 //df2.setRoundingMode(RoundingMode.CEILING);

					 //System.out.println("ttttttttt 111   ");
					 //double roundOff = Math.round(a * 100.0) / 100.0;
					 String ss = df2.format(obj.getStdCost().doubleValue());
					 
					 //System.out.println("ttttttttt 111   " + ss);
					 
					 try {
						//obj.setStdCost(new BigDecimal(ss));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 if(obj.getStdCost() != null){
		
					 if(usrRole.equals("DGM")){
						 if(obj.getStdCost().doubleValue() > 50000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("CE")){
						 if(obj.getStdCost().doubleValue() > 25000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("EE")){
						 if(obj.getStdCost().doubleValue() > 5000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("AGM")){
						 	 obj.setNormDefault(new BigDecimal("0"));
						 
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
						 
					 }
	}else{
		obj.setNormDefault(new BigDecimal("0"));
		 
	}
	pcmodel.setEstimateNo(obj.getId().getEstimateNo());
	pcmodel.setDeptId(obj.getId().getDeptId());
	pcmodel.setStdCost(ss);
	pcmodel.setDescr(obj.getDescr());
	pcmodel.setNormDefault(obj.getNormDefault());


	pcesthttModelListNew.add(i, pcmodel);
					 pcesthttListNew.add(i, obj);		
				 }
			 }
			 
			 
			 
			 
				model.setListPcesthttModel(pcesthttModelListNew);
			 model.setPcesthttList(pcesthttListNew);
model.setResult(result);
			 return new ModelAndView("estApprovalNewRecommend", "model", model);
			
	 }



	 @RequestMapping(value = "/reviseApprovalNewAE",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView reviseApprovalNewAE(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthmt>  pcesthttList =null;
		 
		 List<Pcesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= pchmtDao.getApprovalListAENew(usrRole.trim(),usrName.trim(),deptId.trim());
		 String reponsibleEEName="";
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthmt obj = pcesthttList.get(i);
				 if(obj.getAprUid5() != null){
					 Sauserm mm = secDao.getSauserm(obj.getAprUid5());
					 if(mm != null){
						 reponsibleEEName = mm.getUserNm();
							 
					 }
					 
				 }
				 PcesthttModel pcmodel = new PcesthttModel();
					
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 String ss = df2.format(obj.getStdCost().doubleValue());
				 try {
					//obj.setStdCost(new BigDecimal(ss));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 if(obj.getStdCost() != null){
	
				 if(usrRole.equals("DGM")){
					 if(obj.getStdCost().doubleValue() > 50000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getStdCost().doubleValue() > 25000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getStdCost().doubleValue() > 5000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setNormDefault(new BigDecimal("0"));
					 
				 }else{
					 obj.setNormDefault(new BigDecimal("0"));
					 
				 }
}else{
	obj.setNormDefault(new BigDecimal("0"));
	 
}
obj.setNormDefault(new BigDecimal("0"));
pcmodel.setEstimateNo(obj.getId().getEstimateNo());
pcmodel.setProjectNo(obj.getProjectNo());
pcmodel.setEeName(reponsibleEEName);
pcmodel.setDeptId(obj.getId().getDeptId());
pcmodel.setStdCost(ss);
pcmodel.setDescr(obj.getDescr());
pcmodel.setNormDefault(obj.getNormDefault());


pcesthttModelListNew.add(i, pcmodel);
				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 
			model.setListPcesthttModel(pcesthttModelListNew);
		 model.setPcesthmtList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("reviseApprovalNew", "model", model);
			
	 }

	 @RequestMapping(value = "/reviseApprovalNewAEStatus",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView reviseApprovalNewAEStatus(HttpServletRequest request){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		String usrName = request.getSession().getAttribute("loggedUser").toString();
		 List<Pcesthmt>  pcesthttList =null;
		 
		 List<Pcesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= pchmtDao.getApprovalListAENewStatus(usrRole.trim(),usrName.trim(),deptId.trim());
		 String reponsibleEEName="";
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Pcesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Pcesthmt obj = pcesthttList.get(i);
				 if(obj.getAprUid5() != null){
					 Sauserm mm = secDao.getSauserm(obj.getAprUid5());
					 if(mm != null){
						 reponsibleEEName = mm.getUserNm();
							 
					 }
					 
				 }
				 PcesthttModel pcmodel = new PcesthttModel();
					
				 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
					 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
						
				 }
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 String ss = df2.format(obj.getStdCost().doubleValue());
				 try {
					//obj.setStdCost(new BigDecimal(ss));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 if(obj.getStdCost() != null){
	
				 if(usrRole.equals("DGM")){
					 if(obj.getStdCost().doubleValue() > 50000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getStdCost().doubleValue() > 25000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getStdCost().doubleValue() > 5000000){
						 //recommend
						 obj.setNormDefault(new BigDecimal("1"));
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setNormDefault(new BigDecimal("0"));
					 
				 }else{
					 obj.setNormDefault(new BigDecimal("0"));
					 
				 }
}else{
	obj.setNormDefault(new BigDecimal("0"));
	 
}
obj.setNormDefault(new BigDecimal("0"));
pcmodel.setEstimateNo(obj.getId().getEstimateNo());
pcmodel.setProjectNo(obj.getProjectNo());
pcmodel.setEeName(reponsibleEEName);
pcmodel.setDeptId(obj.getId().getDeptId());
pcmodel.setStdCost(ss);
pcmodel.setStrStatus(Util.searchStatus(obj.getStatus().intValue()));

pcmodel.setDescr(obj.getDescr());
pcmodel.setNormDefault(obj.getNormDefault());


pcesthttModelListNew.add(i, pcmodel);
				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 
			model.setListPcesthttModel(pcesthttModelListNew);
		 model.setPcesthmtList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("reviseApprovalNewStatus", "model", model);
			
	 }


	 @RequestMapping(value = "/reviseApproveEstimateMMS",method = RequestMethod.POST, produces = "application/json")
	 public ModelAndView reviseApproveEstimateMMS(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 
		 String result="";
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		if(apModel.getApprove()!= null && apModel.getApprove().equals("Approve")){
		 if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "JOB", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "JOB", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "JOB", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthmt pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
					
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("JOB_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
								if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
									pcesthtt.setStatus(new BigDecimal(EstimateStatus.JOB_ONGOING));
									approvalObj.setToStatus(EstimateStatus.JOB_ONGOING);
				        			
								}else{
									pcesthtt.setStatus(new BigDecimal("60"));
									approvalObj.setToStatus("60");
				        			
								}
			        			approvalObj.setFromStatus(statusFrom);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully Forwarded to next level";
			        			
			        		}else{
			        			result ="This estimate can not be approved,Please contact IT Branch";
			        		}
						
						}else{
							result ="The estimate total cost can not be zero,Please contact IT Branch";
						}
						}else{
							result ="The estimate total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "JOB", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "JOB", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "JOB", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthmt pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(costCenter);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("JOB_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
								if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
									pcesthtt.setStatus(new BigDecimal(EstimateStatus.JOB_ONGOING));
									approvalObj.setToStatus(EstimateStatus.JOB_ONGOING);
				        			
								}else{
									pcesthtt.setStatus(new BigDecimal("60"));
									approvalObj.setToStatus("60");
				        			
								}
			        			
			        			//pcesthtt.setStatus(new BigDecimal(EstimateStatus.JOB_ONGOING));
			        			approvalObj.setFromStatus(statusFrom);
			        			//approvalObj.setToStatus(EstimateStatus.JOB_ONGOING);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully forwarded to next level";
			        			
			        		}else{
			        			result ="The estimate number can not be approved,Please contact IT Branch";
			        		}
						
						}else{
							result ="The estimate total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The estimatet total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level,Please contact IT Branch";
			 }

		 }else{
		 
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("Approve my job : "+usrRole +" usrName : "+usrName);
				
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter.trim(), "JOB", "DE", usrRole.trim());
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "JOB", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "JOB", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthmt pcesthtt = pchmtDao.getPcesthmt(estimateNo,costCenter);
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(pcesthtt.getStdCost() != null && pcesthtt.getPartialAmt() != null){
							pcesthtt.setStdCost(new BigDecimal(pcesthtt.getStdCost().doubleValue()-pcesthtt.getPartialAmt().doubleValue()));
								
						 }
						
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("JOB_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.JOB_ONGOING));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.JOB_ONGOING);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			result = "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully forwarded to next level";
			        			
			        		}else{
			        			result ="The estimate can not approved.Please contact IT Branch";
			        		}
						
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

	}else if(apModel.getRecommend() != null && apModel.getRecommend().equals("Recommend")){
		
		if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "JOB", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "JOB", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthmt pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(deptId);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("JOB_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level,Please contact IT Branch";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(costCenter, "JOB", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "JOB", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "JOB", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthmt pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
					
					/*SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(deptId);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					*/
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						/*if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						*/
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(costCenter);
						approvalObj.setApprovalType("JOB_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
						}else{
							result ="The total cost can not be empty,Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found,Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level,Please contact IT Branch";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "JOB", "DE", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "JOB", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("100.00", "JOB", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					
					pk.setDeptId(costCenter);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthmt pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("JOB_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
							/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pchmtDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			result =  "Successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Estimate can not approved.Please contact IT Branch";
			        		}*/
						
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="The estimate total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="The estimate number can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approval limits for your user Level.Please contact IT Branch";
			 }

			 
		 }

		
		
	}else if(apModel.getReject() != null && apModel.getReject().equals("Reject")){
		
		System.out.println("Reject");
		PcesthttPK pk = new PcesthttPK();
		Pcesthmt pcesthtt = null;
		pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
		
		
		
		
		//Pcesthtt pcesthtt = pcestDao.getPcesthtt(estimateNo,costCenter);
		if(pcesthtt != null){
			BigDecimal totalCost = pcesthtt.getStdCost();
			
			//Approvals
			Calendar calendar = Calendar.getInstance();
			Format format=new Format();
			Approval approvalObj=new Approval();
			
			String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
   		    approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
   		    System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
			
			approvalObj.setReferenceNo(estimateNo.trim());
			approvalObj.setDeptId(costCenter);
			approvalObj.setApprovalType("JOB_REJC");
			approvalObj.setApprovedLevel(usrRole);
			approvalObj.setApprovedBy(usrName);
			approvalObj.setApprovedDate(calendar.getTime());
			approvalObj.setApprovedTime(format.FormatTime());
			approvalObj.setDetailedCost(totalCost);
				
				    approvalObj.setFromStatus(pcesthtt.getStatus().toString());
   			    pcesthtt.setStatus(new BigDecimal(EstimateStatus.JOB_RIVISION));
   			    pcesthtt.setRejectReason(apModel.getRejectReason());
       			approvalObj.setToStatus(EstimateStatus.JOB_RIVISION);
       			pchmtDao.update(pcesthtt);
       			approval.addApproval(approvalObj);
       			System.out.println("successfully Rejected");
   				
       			result = "Successfully Rejected";
			
					
		}else{
			result ="The estimate number can not be found,Please contact IT Branch";
		}

		
		
		
	}else if(apModel.getSendforvalidation()!= null && apModel.getSendforvalidation().equals("Forward")){
		
		System.out.println("Send");
		PcesthttPK pk = new PcesthttPK();
		Pcesthmt pcesthtt = null;
		pcesthtt = pchmtDao.getPcesthmt(estimateNo, costCenter);
		if(pcesthtt != null){
			BigDecimal totalCost = pcesthtt.getStdCost();
			
			//Approvals
			Calendar calendar = Calendar.getInstance();
			Format format=new Format();
			Approval approvalObj=new Approval();
			
			String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
   		    approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
   		    System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
			
			approvalObj.setReferenceNo(estimateNo.trim());
			approvalObj.setDeptId(costCenter);
			approvalObj.setApprovalType("JOB_VLDT");
			approvalObj.setApprovedLevel(usrRole);
			approvalObj.setApprovedBy(usrName);
			approvalObj.setApprovedDate(calendar.getTime());
			approvalObj.setApprovedTime(format.FormatTime());
			approvalObj.setDetailedCost(totalCost);
				
				    approvalObj.setFromStatus(pcesthtt.getStatus().toString());
   			    pcesthtt.setStatus(new BigDecimal(EstimateStatus.JOB_APPROVAL_EE));
   			    pcesthtt.setRejectReason(apModel.getRejectReason());
       			approvalObj.setToStatus(EstimateStatus.JOB_APPROVAL_EE);
       			pchmtDao.update(pcesthtt);
       			approval.addApproval(approvalObj);
       			System.out.println("successfully Forward");
   				
       			result = "Successfully Forwarded";
			
					
		}else{
			result ="The estimate number can not be found,Please contact IT Branch";
		}


	}
		
	
		 
		 
		 
		 
		 
		 
		// String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			//String deptId = request.getSession().getAttribute("deptId").toString();
			ApprovalModel model = new ApprovalModel();
			
			List<Pcesthmt>  pcesthttList =null;
			 
			 List<Pcesthmt>  pcesthttListNew =null;
			 
			 List<String>  estimateNoList =null;
			 
			 
			 List<PcesthttModel>  pcesthttModelListNew =null;
			 
			 
			 pcesthttList= pchmtDao.getApprovalListAENew(usrRole.trim(),usrName.trim(),deptId.trim());
			 //System.out.println("rrrrrrrrrrrrrrrrrrrr3333333333yyyyyyyyyyyy" +pcesthttList );
				
			 if(pcesthttList != null){
				 int count = pcesthttList.size();
				 pcesthttListNew = new ArrayList<Pcesthmt>(count);
				 //estimateNoList = new ArrayList<String>(count);
				 
				// System.out.println("rrrrrrrrrrr"+ count);
				 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
				String resEE=""; 
				 //pcesthttList= new ArrayList<Pcesthtt>(count);
				 for(int i=0 ; i < count ; i ++){
					 Pcesthmt obj = pcesthttList.get(i);
					 Sauserm mm = secDao.getSauserm(obj.getAprUid5());
					 resEE= mm.getUserNm();
					 //estimateNoList.add(i, obj.getId().getEstimateNo());
					 PcesthttModel pcmodel = new PcesthttModel();
					// System.out.println("rrrrrrrrrrr tttt"+ count);
						
					 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
						 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
							
					 }
					// obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
					 //System.out.println("rrrrrrrrrrr ggg"+ count);
					 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
					 
					 //df2.setRoundingMode(RoundingMode.CEILING);

					 //System.out.println("ttttttttt 111   ");
					 //double roundOff = Math.round(a * 100.0) / 100.0;
					 String ss = df2.format(obj.getStdCost().doubleValue());
					 
					 //System.out.println("ttttttttt 111   " + ss);
					 
					 try {
						//obj.setStdCost(new BigDecimal(ss));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 if(obj.getStdCost() != null){
		
					 if(usrRole.equals("DGM")){
						 if(obj.getStdCost().doubleValue() > 50000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("CE")){
						 if(obj.getStdCost().doubleValue() > 25000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("EE")){
						 if(obj.getStdCost().doubleValue() > 5000000){
							 //recommend
							 obj.setNormDefault(new BigDecimal("1"));
						 }else{
							 obj.setNormDefault(new BigDecimal("0"));
						 }
					 }else if(usrRole.equals("AGM")){
						 	 obj.setNormDefault(new BigDecimal("0"));
						 
					 }else{
						 obj.setNormDefault(new BigDecimal("0"));
						 
					 }
	}else{
		obj.setNormDefault(new BigDecimal("0"));
		 
	}
	pcmodel.setEstimateNo(obj.getId().getEstimateNo());
	pcmodel.setProjectNo(obj.getProjectNo());
	
	pcmodel.setDeptId(obj.getId().getDeptId());
	pcmodel.setStdCost(ss);
	pcmodel.setDescr(obj.getDescr());
	pcmodel.setNormDefault(obj.getNormDefault());
pcmodel.setEeName(resEE);

	pcesthttModelListNew.add(i, pcmodel);
					 pcesthttListNew.add(i, obj);		
				 }
			 }
			 
			 
			 
			 
				model.setListPcesthttModel(pcesthttModelListNew);
			 model.setPcesthmtList(pcesthttListNew);
model.setResult(result);
			 return new ModelAndView("reviseApprovalNew", "model", model);
			
	 }


	 
	 
	 @RequestMapping(value = "/viewReviseInfo",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView viewReviseInfo(@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter){
		 ApprovalModel model = new ApprovalModel();
		 PcesthttPK pk = new PcesthttPK();
		 pk.setDeptId(costCenter.trim());
		 pk.setEstimateNo(estimateNo.trim());
		 pk.setRevNo(new Long("2"));
		 List<Pcesthmt> listObj = null;
		 Pcesthmt obj = null;
		 
		 List<Pcestdmt> objDmt = null;
		 List<PcestdttModel> objDmtModel = null;
		 String initialEstCost= "";
		 Pcesthtt pcesthttMaxRev = pcestDao.getPcesthttForIntialCost(estimateNo,costCenter);
		 	
			BigDecimal totalCostMaxRev = new BigDecimal("0");
			if(pcesthttMaxRev != null){
				totalCostMaxRev = pcesthttMaxRev.getStdCost();
				DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				
				initialEstCost = df2.format(totalCostMaxRev.doubleValue());
				if(pcesthttMaxRev.getStdCost() != null && pcesthttMaxRev.getPartialAmt() != null){
					pcesthttMaxRev.setStdCost(new BigDecimal(pcesthttMaxRev.getStdCost().doubleValue()-pcesthttMaxRev.getPartialAmt().doubleValue()));
					 if(pcesthttMaxRev.getStdCost() != null){
						 initialEstCost = df2.format(pcesthttMaxRev.getStdCost().doubleValue());
					 }
					 	
				 }
				
			}
		 obj = pchmtDao.getPcesthmt(estimateNo, costCenter);
		 objDmt = pchmtDttDao.findByCostCenterEstimateNo(costCenter, estimateNo);
		 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
			 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
		 }
		 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
		 String ss ="";
		 if(obj.getStdCost() != null){
         ss = df2.format(obj.getStdCost().doubleValue());
		 }
		 String rebateCost = "";
		 if(obj.getPartialAmt() != null){
	         rebateCost = df2.format(obj.getPartialAmt().doubleValue());
		}
		 obj.setStdCost(obj.getStdCost());
		if(objDmt != null){
			int count = objDmt.size();
			objDmtModel = new ArrayList<PcestdttModel>(count);
			for(int i= 0 ; i<count ; i++){
				PcestdttModel objModel = new PcestdttModel();
				Pcestdmt newObj = objDmt.get(i);
				 if(newObj.getResType().trim().equals("MAT-COST")){
					 String code=inmatmDao.getName(newObj.getId().getResCd().trim());
					  objModel.setResCd(objDmt.get(i).getId().getResCd());
					 objModel.setResName(code);
						
				 }else{
					 objModel.setResCd(objDmt.get(i).getId().getResCd());
					 objModel.setResName(objDmt.get(i).getId().getResCd());
				 }
				 
				 objModel.setUom(objDmt.get(i).getUom());
				 objModel.setUnitPrice(objDmt.get(i).getUnitPrice());
				 objModel.setEstimateQty(objDmt.get(i).getEstimateQty());
				 String sss = df2.format(objDmt.get(i).getEstimateCost());
				 
				 objModel.setEstimateCost(sss);
				 
				 
				 SprebatePK spRebatePK = new SprebatePK();
				 spRebatePK.setDeptId(objDmt.get(i).getId().getDeptId());
				 spRebatePK.setEstimateNo(objDmt.get(i).getId().getEstimateNo());
				 spRebatePK.setResCd(objDmt.get(i).getId().getResCd());
				 Sprebate rebate = rebateDao.findById(spRebatePK);
				 if(rebate != null){
					 objModel.setRebateQty(rebate.getRebateQty());
					 String ssss = df2.format(rebate.getRebateCost());
						
					 objModel.setRebateCost(ssss);
					 objModel.setOffChargeQty(rebate.getOffchargeQty());
					 objModel.setReusableQty(rebate.getReusableQty());
							 
				 }
				 objDmtModel.add(i, objModel);
				
				
				
			}
		}
		String perStr ="";
		if(obj.getStdCost() != null && pcesthttMaxRev.getStdCost() != null){
			double variance = obj.getStdCost().doubleValue() - pcesthttMaxRev.getStdCost().doubleValue();
			double percentage = variance / obj.getStdCost().doubleValue();
			percentage = Math.round(percentage * 100.0) / 100.0;
			perStr = df2.format(percentage);

			perStr = perStr +"%";
		}
		 
		 PcesthttModel modelPcesthtt = new PcesthttModel();
		 if(obj != null){
			 modelPcesthtt.setEstimateNo(obj.getId().getEstimateNo());
			 modelPcesthtt.setProjectNo(obj.getProjectNo());
			 
			 modelPcesthtt.setDeptId(obj.getId().getDeptId());
			 modelPcesthtt.setEtimateDt(obj.getEtimateDt());
			 modelPcesthtt.setCatCd(obj.getCatCd());
			 modelPcesthtt.setFundSource(obj.getFundSource());
			 modelPcesthtt.setFundId(obj.getFundId());
			 modelPcesthtt.setPartialAmt(rebateCost);
			 modelPcesthtt.setStdCost(ss);
			 modelPcesthtt.setDescr(obj.getDescr());
			 modelPcesthtt.setStdCostInitial(initialEstCost);
			 modelPcesthtt.setPercentage(perStr);
		 }
		 model.setPcesthttModel(modelPcesthtt);
		 model.setListPcestdttModel(objDmtModel);
		 return new ModelAndView("reviseInfoNew","model", model);
			
	 }
 
	 @RequestMapping(value = "/standardInfo",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView standardInfo(@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter){
		 ApprovalModel model = new ApprovalModel();
		 Spstdesthmt  spstdesthmt = stdDao.selectStdNoDeptId(estimateNo, costCenter);
		 ApplicationPK appPK = new ApplicationPK();
		 appPK.setApplicationId(estimateNo);
		 appPK.setDeptId(costCenter);
		 Applicant applicant = null;
		 //Application  application =  applicantionDao.findByAppDeptId(estimateNo, costCenter);
		 Application  application = null;
		 Spstdesthmt sphmt =null;
				 
		 List<Object[]> objList = stdDao.getApprovalListDetail(estimateNo, costCenter);
		 if(objList != null){
			 application = (Application)objList.get(0)[1];
			 sphmt = (Spstdesthmt)objList.get(0)[5];
			 
					 
		 }
		 List<PivDetail> pivDetail =null;
		 List<PivDetail> pivEstDetail =null;
		 List<Spstdestdmt> dmtDetail =null;
		 List<SpstdestdmtModel> dmtDetailModel =null;
		 List<Approval> approval = null;
		 List<ApprovalMm> approvalMmObj = null;
		 
		 approval = approvalDao.getHistory(estimateNo.trim());
		 approvalMmObj = approvalMm.getHistory(estimateNo.trim());	
		 
		 //Spstdesthmt sphmt = stdDao.selectStdNoDeptId(estimateNo, costCenter);
		 SpstdesthmtModel sphmtModel = CreateSpstdesthmtModel(sphmt);
		 dmtDetail = spDmtDao.selectStdNoDeptId(estimateNo, costCenter);
		 dmtDetailModel=CreateSpstdestdmtModel(dmtDetail);
		 
		 WiringLandDetail wlObj = null;
		 WiringLandDetailCon wlConObj = null;
		 PivDetail piv = null;
		 if(application != null){
			 //applicant = applicantDao.findById(application.getIdNo());
			 applicant = (Applicant)objList.get(0)[0];
			 pivDetail = pivDetailDao.findByReferenceNo(application.getId().getApplicationId(), costCenter);
			 //piv =(PivDetail)objList.get(0)[6];
			 //pivDetail = new ArrayList<PivDetail>(1);
			 //pivDetail.add(piv);
			 //pivEstDetail = pivDetailDao.findByReferenceNo(estimateNo, costCenter);
			// wlObj = wlDao.selectStdNoDeptId(application.getId().getApplicationId(), costCenter);
			 //wlConObj = wlConDao.selectStdNoDeptId(application.getId().getApplicationId(), costCenter);
			 wlObj = (WiringLandDetail)objList.get(0)[4];
			 wlConObj = (WiringLandDetailCon)objList.get(0)[2];
			 
		 }
		 model.setApplicant(applicant);
		 model.setApplication(application);
		 model.setPivList(pivDetail);
		 model.setPivEstList(pivEstDetail);
		 model.setWlObj(wlObj);
		 model.setWlConObj(wlConObj);
		 model.setSpstdesthmt(sphmt);
		 model.setSpstdesthmtModel(sphmtModel);
		 model.setSpdmtList(dmtDetail);
		 model.setSpstdestdmtModel(dmtDetailModel);
		 model.setApprovalHistoryList(approval);
		 model.setAttachmentList(approvalMmObj);
		 
		 return new ModelAndView("standardInfo","model", model);
			
	 }
	 
	 
	 @RequestMapping(value = "/standardInfoS",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView standardInfoS(@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter){
		 ApprovalModel model = new ApprovalModel();
		 Spstdesthmt  spstdesthmt = stdDao.selectStdNoDeptId(estimateNo, costCenter);
		 ApplicationPK appPK = new ApplicationPK();
		 appPK.setApplicationId(estimateNo);
		 appPK.setDeptId(costCenter);
		 Applicant applicant = null;
		 //Application  application =  applicantionDao.findByAppDeptId(estimateNo, costCenter);
		 Application  application = null;
		 Spstdesthmt sphmt =null;
				 
		 List<Object[]> objList = stdDao.getApprovalListDetail(estimateNo, costCenter);
		 if(objList != null){
			 application = (Application)objList.get(0)[1];
			 sphmt = (Spstdesthmt)objList.get(0)[5];
			 
					 
		 }
		 List<PivDetail> pivDetail =null;
		 List<PivDetail> pivEstDetail =null;
		 List<Spstdestdmt> dmtDetail =null;
		 List<SpstdestdmtModel> dmtDetailModel =null;
		 List<Approval> approval = null;
		 List<ApprovalMm> approvalMmObj = null;
		 
		 approval = approvalDao.getHistory(estimateNo.trim());
		 approvalMmObj = approvalMm.getHistory(estimateNo.trim());	
		 
		 //Spstdesthmt sphmt = stdDao.selectStdNoDeptId(estimateNo, costCenter);
		 SpstdesthmtModel sphmtModel = CreateSpstdesthmtModel(sphmt);
		 dmtDetail = spDmtDao.selectStdNoDeptId(estimateNo, costCenter);
		 dmtDetailModel=CreateSpstdestdmtModel(dmtDetail);
		 
		 WiringLandDetail wlObj = null;
		 WiringLandDetailCon wlConObj = null;
		 PivDetail piv = null;
		 if(application != null){
			 //applicant = applicantDao.findById(application.getIdNo());
			 applicant = (Applicant)objList.get(0)[0];
			 pivDetail = pivDetailDao.findByReferenceNo(application.getId().getApplicationId(), costCenter);
			 //piv =(PivDetail)objList.get(0)[6];
			 //pivDetail = new ArrayList<PivDetail>(1);
			 //pivDetail.add(piv);
			 pivEstDetail = pivDetailDao.findByReferenceNo(estimateNo, costCenter);
			 //wlObj = wlDao.selectStdNoDeptId(application.getId().getApplicationId(), costCenter);
			 //wlConObj = wlConDao.selectStdNoDeptId(application.getId().getApplicationId(), costCenter);
			 wlObj = (WiringLandDetail)objList.get(0)[4];
			 wlConObj = (WiringLandDetailCon)objList.get(0)[2];
			 
		 }
		 model.setApplicant(applicant);
		 model.setApplication(application);
		 model.setPivList(pivDetail);
		 model.setPivEstList(pivEstDetail);
		 model.setWlObj(wlObj);
		 model.setWlConObj(wlConObj);
		 model.setSpstdesthmt(sphmt);
		 model.setSpstdesthmtModel(sphmtModel);
		 model.setSpdmtList(dmtDetail);
		 model.setSpstdestdmtModel(dmtDetailModel);
		 model.setApprovalHistoryList(approval);
		 model.setAttachmentList(approvalMmObj);
		 
		 return new ModelAndView("standardInfo","model", model);
			
	 }
	
	 
	 @RequestMapping(value = "/standardInfoStatus",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView standardInfoStatus(@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter){
		 ApprovalModel model = new ApprovalModel();
		 Spstdesthmt  spstdesthmt = stdDao.selectStdNoDeptId(estimateNo, costCenter);
		 ApplicationPK appPK = new ApplicationPK();
		 appPK.setApplicationId(estimateNo);
		 appPK.setDeptId(costCenter);
		 Applicant applicant = null;
		 Application  application =  applicantionDao.findByAppDeptId(estimateNo, costCenter);
		 List<PivDetail> pivDetail =null;
		 List<PivDetail> pivEstDetail =null;
		 List<Spstdestdmt> dmtDetail =null;
		 List<SpstdestdmtModel> dmtDetailModel =null;
		 List<Approval> approval = null;
		 List<ApprovalMm> approvalMmObj = null;
		 
		 
		 approval = approvalDao.getHistory(estimateNo.trim());
		 approvalMmObj = approvalMm.getHistory(estimateNo.trim());	
		 
		 Spstdesthmt sphmt = stdDao.selectStdNoDeptId(estimateNo, costCenter);
		 SpstdesthmtModel sphmtModel = CreateSpstdesthmtModel(sphmt);
		 dmtDetail = spDmtDao.selectStdNoDeptId(estimateNo, costCenter);
		 dmtDetailModel=CreateSpstdestdmtModel(dmtDetail);
		 
		 WiringLandDetail wlObj = null;
		 WiringLandDetailCon wlConObj = null;
		 if(application != null){
			 applicant = applicantDao.findById(application.getIdNo());
			 pivDetail = pivDetailDao.findByReferenceNo(application.getId().getApplicationId(), costCenter);
			 pivEstDetail = pivDetailDao.findByReferenceNo(estimateNo, costCenter);
			 wlObj = wlDao.selectStdNoDeptId(application.getId().getApplicationId(), costCenter);
			 wlConObj = wlConDao.selectStdNoDeptId(application.getId().getApplicationId(), costCenter);
			 
		 }
		 
		 //Estimate
		 
		 String westimateNo = spestedyConDao.getWestimateNo(estimateNo.trim(), costCenter);
		 Pcesthtt obj = new Pcesthtt();
		 List<Pcestdtt> objDmt = null;
		 List<PcestdttModel> objDmtModel = null;
		 List<EstimateReferenceb> estReferenceBS = null;
		 List<Approval> approvalWestimate = null;
		 List<ApprovalMm> approvalMmObjWestimate = null;
		 
		 approvalWestimate = approvalDao.getHistory(estimateNo.trim());
		 approvalMmObjWestimate = approvalMm.getHistory(estimateNo.trim());	
		 
		 String costCenterWestimate="";
		 costCenterWestimate = westimateNo.substring(0, 5);
		 System.out.println("costCenterWestimate :"+ costCenterWestimate);
		 obj = pcestDao.getPcesthtt(westimateNo.trim(),costCenterWestimate.trim());
		 objDmt = pcestDttDao.getPcestdtt(estimateNo.trim(),costCenter.trim());
		 if(obj.getStdCost() != null && obj.getPartialAmt() != null){
				
		 obj.setStdCost(new BigDecimal(obj.getStdCost().doubleValue()-obj.getPartialAmt().doubleValue()));
		 }
		 String ss ="";
		 ss = Util.getFromattedValue(obj.getStdCost().doubleValue());
		 
		 String rebateCost = "";
		 rebateCost = Util.getFromattedValue(obj.getPartialAmt().doubleValue());
		 obj.setStdCost(obj.getStdCost());
		 if(objDmt != null){
			int count = objDmt.size();
			objDmtModel = new ArrayList<PcestdttModel>(count);
			for(int i= 0 ; i<count ; i++){
				PcestdttModel objModel = new PcestdttModel();
				Pcestdtt newObj = objDmt.get(i);
				//System.out.println("rescd"+newObj.getId().getResCd());	 
				 if(newObj.getResType().trim().equals("MAT-COST")){
					 String code=inmatmDao.getName(newObj.getId().getResCd().trim());
					 objModel.setResCd(objDmt.get(i).getId().getResCd());
					 objModel.setResName(code);
						
				 }else{
					 objModel.setResCd(objDmt.get(i).getId().getResCd());
					 objModel.setResName(objDmt.get(i).getId().getResCd());
				 }
				 
				 objModel.setUom(objDmt.get(i).getUom());
				 objModel.setUnitPrice(objDmt.get(i).getUnitPrice());
				 objModel.setEstimateQty(objDmt.get(i).getEstimateQty());
				 String sss = Util.getFromattedValue(objDmt.get(i).getEstimateCost());
				 objModel.setEstimateCost(sss);
				 SprebatePK spRebatePK = new SprebatePK();
				 spRebatePK.setDeptId(objDmt.get(i).getId().getDeptId());
				 spRebatePK.setEstimateNo(objDmt.get(i).getId().getEstimateNo());
				 spRebatePK.setResCd(objDmt.get(i).getId().getResCd());
				 Sprebate rebate = rebateDao.findById(spRebatePK);
				 if(rebate != null){
					 objModel.setRebateQty(rebate.getRebateQty());
					 String ssss = Util.getFromattedValue(rebate.getRebateCost());
						
					 objModel.setRebateCost(ssss);
					 objModel.setOffChargeQty(rebate.getOffchargeQty());
					 objModel.setReusableQty(rebate.getReusableQty());
							 
				 }
				 objDmtModel.add(i, objModel);
				
				
				
			}
		}
		 
		 PcesthttModel modelPcesthtt = new PcesthttModel();
		 if(obj != null){
			 modelPcesthtt.setEstimateNo(obj.getId().getEstimateNo());
			 modelPcesthtt.setDeptId(obj.getId().getDeptId());
			 modelPcesthtt.setEtimateDt(obj.getEtimateDt());
			 modelPcesthtt.setCatCd(obj.getCatCd());
			 modelPcesthtt.setFundSource(obj.getFundSource());
			 modelPcesthtt.setFundId(obj.getFundId());
			 modelPcesthtt.setPartialAmt(rebateCost);
			 modelPcesthtt.setStdCost(ss);
			 modelPcesthtt.setDescr(obj.getDescr());
			 
			 
		 }
		 model.setPcesthttModel(modelPcesthtt);
		 model.setApprovalHistoryListWE(approvalWestimate);
		 model.setAttachmentListWE(approvalMmObjWestimate);
		 model.setListPcestdttModel(objDmtModel);
		 model.setApplicant(applicant);
		 model.setApplication(application);
		 model.setPivList(pivDetail);
		 model.setPivEstList(pivEstDetail);
		 model.setWlObj(wlObj);
		 model.setWlConObj(wlConObj);
		 model.setSpstdesthmt(sphmt);
		 model.setSpstdesthmtModel(sphmtModel);
		 model.setSpdmtList(dmtDetail);
		 model.setSpstdestdmtModel(dmtDetailModel);
		 model.setApprovalHistoryList(approval);
		 model.setAttachmentList(approvalMmObj);
		 
		 return new ModelAndView("standardInfoStatus","model", model);
			
	 }


	 @RequestMapping(value = "/reAllocateResponsibleEE",method = RequestMethod.GET, produces = "application/json")
	 public ModelAndView reAllocateResponsibleEE(HttpServletRequest request,@RequestParam("mode") String mode){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalModel model = new ApprovalModel();
		String userLevel = (String) request.getSession().getAttribute("loggedUserRole");
		String userName = (String) request.getSession().getAttribute("loggedUser");
		
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 //List<ApprovalMm>  approvalList =null;
		 
		 List<Pcesthtt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 Map<String, String> eeList = new LinkedHashMap<String, String>();
			
		 List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "EE");
		 
		 	
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					eeList.put(objUser.getUserId(),objUser.getUserNm());
					
				}
			}
			
			//List<String> status = new ArrayList<String>();
			//status[0].add();
		//pcesthttList= pcestDao.getApprovalListESSFV(deptId);
		List<ApprovalMm>  listApprovalUnread =null;
		if(mode.equalsIgnoreCase("INS")){
			//listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
			listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
	            
			
            
		}else if(mode.equalsIgnoreCase("INT")){
			if(userLevel.equals("ES")){
				listApprovalUnread = approvalMm.getPendingReqByESAll("INTREQ",  deptId, userName);
			}else if(userLevel.equals("EE")){
				listApprovalUnread = approvalMm.getPendingReqByEEAll("INTREQ",  deptId, userName);
			}else{
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("INTREQ", deptId);
	            
			}
		}else if(mode.equalsIgnoreCase("MNT")){
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("MNTREQ", deptId);
	            
			
		}else{
			
		} if(listApprovalUnread != null){
			 int count = listApprovalUnread.size();
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 
			 //pcesthttList= new ArrayList<Pcesthtt>(count);
			 for(int i=0 ; i < count ; i ++){
				 ApprovalMm obj = listApprovalUnread.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 String eeName="";
				 Sauserm saObj=null;
				 if(obj.getEe() != null){
					 saObj= secDao.getSauserm(obj.getEe().trim());
					 if(saObj != null){
						 eeName = saObj.getUserNm();
					 }
				 }
				
				 pcmodel.setEstimateNo(obj.getApprovalId());
				 pcmodel.setEeName(eeName);
				 pcmodel.setDescr(obj.getEe());

				 pcesthttModelListNew.add(i, pcmodel);

				 	
			 }
		 }
		 
		 
		 
			model.setEeList(eeList);
		 model.setPcesthttList(pcesthttListNew);
		 model.setResult(null);
		 System.out.println("rrrrrrrrrrrrrrrrrrrr");
		 return new ModelAndView("reAllocateResponsibleEE", "model", model);
			
	 }
	 
	 public String upload(MultipartFile file,String dept_id,String estimateNo,String AppLevl,String appBy){
			
			System.out.println("approveEstimateMMSES 1");
			 
			ApprovalMm appr = new ApprovalMm();
			String path = PathMMS.getReportPath();
			System.out.println("approveEstimateMMSES 2");
			
			File dir = new File(path + File.separator + "SPSAttachment");
			if (!dir.exists())
				dir.mkdirs();
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			Date today = new Date();
			String subject_str = subject_str_fm.format(today);
			
			String nextNumver = approvalMm.getNextAppId(estimateNo);
			System.out.println("nextNumver 5 "+ nextNumver );
			
			String approval_id = estimateNo + "-" + nextNumver;
			
			// Create the file on server
			File serverFile = null;
			    		
			if (!file.isEmpty()) {
				try {
					String name = file.getOriginalFilename();
					
					String extension = Util.getSubStringLastPart(name,".");
					name = dept_id + "-" +subject_str+ extension;
					byte[] bytes = file.getBytes();
					System.out.println("approveEstimateMMSES 3"+bytes );
					
					serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
							

					appr.setApprovalId(approval_id);
					appr.setReferenceNo(estimateNo);
					appr.setApprovalType("EST_UPLD");
					appr.setApprovedLevel(AppLevl);
					appr.setApprovedBy(appBy);
					appr.setFromStatus("00");
					appr.setToStatus("00");
					
					appr.setDeptId(dept_id);
					appr.setFilename1(name);
					approvalMm.addApproval(appr);
					
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
			}

			return null;
		}
	 
	 private SpstdesthmtModel CreateSpstdesthmtModel(Spstdesthmt spstdesthmt){
		 SpstdesthmtModel model = new SpstdesthmtModel();
		 model.setAppNo(spstdesthmt.getId().getAppNo());
		 model.setStdNo(spstdesthmt.getId().getStdNo());
		 model.setDeptId(spstdesthmt.getId().getDeptId());
		 model.setDeptId(spstdesthmt.getId().getDeptId());
		 model.setSecdeposit(Util.getFromattedValue(spstdesthmt.getSecdeposit()));
		 model.setToconpay(Util.getFromattedValue(spstdesthmt.getToconpay()));
		 model.setCebcost(Util.getFromattedValue(spstdesthmt.getCebcost()));
		 model.setNbtcost(Util.getFromattedValue(spstdesthmt.getNbtcost()));
		 model.setVatcost(Util.getFromattedValue(spstdesthmt.getVatcost()));
		 model.setVatcost(Util.getFromattedValue(spstdesthmt.getVatcost()));
		 model.setRebateCost(Util.getFromattedValue(spstdesthmt.getRebateCost()));
		 
		 return model;
	 }
	 
	 private List<SpstdestdmtModel> CreateSpstdestdmtModel(List<Spstdestdmt> dmtList){
		 List<SpstdestdmtModel> model = null;
		 
		 if(dmtList != null){
			 int count = dmtList.size();
			 model = new ArrayList<SpstdestdmtModel>(count);
			 for(int i = 0 ; i < count ; i ++){
				 Spstdestdmt obj = dmtList.get(i); 
				 SpstdestdmtModel modelObj = new SpstdestdmtModel();
				 modelObj.setLinedes(obj.getLinedes());
				 modelObj.setLineType(obj.getId().getLineType());
				 modelObj.setLineCost(Util.getFromattedValue(obj.getLineCost()));
				 modelObj.setEstCost(Util.getFromattedValue(obj.getEstCost()));
				 modelObj.setUom(obj.getUom());
				 modelObj.setLength(Util.getFromattedValue(obj.getLength()));
				 
				 model.add(i, modelObj);
			 }
			 
		 }
		 
		 return model;
	 }



	
}


