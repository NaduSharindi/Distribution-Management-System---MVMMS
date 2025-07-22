package com.it.piv.mms.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddlinetype;
import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.Summary;
import com.it.piv.mms.repo.ApplicantDao;
import com.it.piv.mms.repo.ApplicationDao;
import com.it.piv.mms.repo.ApprovalDao;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.LoginDao;
import com.it.piv.mms.repo.MmsAddConductorTypeDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsAddLineTypeDao;
import com.it.piv.mms.repo.MmsAddSupportTypeDao;
import com.it.piv.mms.repo.MmsAddmvpoleDao;
import com.it.piv.mms.repo.MmsAreaDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MsttowertypeDao;
import com.it.piv.mms.repo.PcestdttDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.mms.repo.ProvinceDao;
import com.it.piv.mms.repo.SpestedyConDao;



@Controller
public class LineController {
	
	@Autowired
	public MmsAddLineDao  lineDao;
	
	@Autowired
	private MmsAddLineTypeDao mmsLineTypeDao;
	@Autowired
	private ApplicantDao applicantDao;
	@Autowired
	private SecurityDao secDao;
	@Autowired
	private SpestedyConDao spEstDao;
	@Autowired
	private ApplicationDao appDao;
	@Autowired
	private PcestdttDao pcdttDao;
	@Autowired
	private PcesthttDao pcsstDao;
	@Autowired
	private LoginDao login;
	@Autowired
	private MsttowertypeDao towerDao;
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private MmsAreaDao areaDao;
	@Autowired
	private GldeptmDao deptDao;
	@Autowired
	private GlcompmDao glcompmDao;
	@Autowired
	private MmsTowermaintenanceDao towerMaintenance;

	@Autowired
	private MmsTxntowermaintenanceDao towerTxtMaintenance;
	@Autowired
	private MmsAddLineDao addLine;
	@Autowired
	private MmsSupportDao addSupport;

	@Autowired
	private ApprovalDao approval;
	@Autowired
	private MmsAddSupportTypeDao supTypeDao;

	@Autowired
	private GldeptmDao gldeptDao;
	@Autowired
	private MmsAddLineTypeDao lineTypeDao;
	@Autowired
	private MmsAddConductorTypeDao conTypeDao;
	@Autowired
	private MmsAddmvpoleDao mmsAddPoleDao;
	

	@RequestMapping(value = "/findLineByAreaStatus/{area}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> findLineByArea(HttpServletRequest  request,   @PathVariable("area") String area,@PathVariable("status") String status) {
		
		String phmBranch= (String)request.getSession().getAttribute("deptId");
		System.out.println("findLineByAreaddd" +area );
		return lineDao.findLineByAreaEdit(area,status,phmBranch);
		
	}
	
	
	
	@RequestMapping(value = "/updateLineStatus/{area}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineStatus(HttpServletRequest  request,  @PathVariable("area") String area,@PathVariable("status") String status) {
		String phmBranch= (String)request.getSession().getAttribute("deptId");
		System.out.println("updateLineStatus" +area+status+phmBranch );
		try{
			List<MmsAddline> lineList = lineDao.findLineByAreaEdit(area, status, phmBranch);
			System.out.println("updateLineStatus1" +lineList.size() );
			
				if(lineList != null){
				for(int i = 0;i<lineList.size();i++)
					{
						MmsAddline obj = lineList.get(i);
						System.out.println("updateLineStatus2" +obj.getStatus() );
						obj.setStatus(new BigDecimal("3"));
						lineDao.update(obj);
					}
				}
			}catch(Exception e){
			
			}
	}
	
	
	@RequestMapping(value = "/updateLineStatuses/{area}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineStatuses(HttpServletRequest  request,  @PathVariable("area") String area,@PathVariable("status") String status) {
		String phmBranch= (String)request.getSession().getAttribute("deptId");
		System.out.println("updateLineStatus" +area+status+phmBranch );
		try{
			List<MmsAddline> lineList = lineDao.findLineByAreaEdit(area, status, phmBranch);
			System.out.println("updateLineStatus1" +lineList.size() );
			
				if(lineList != null){
				for(int i = 0;i<lineList.size();i++)
					{
						MmsAddline obj = lineList.get(i);
						System.out.println("updateLineStatus2" +obj.getStatus() );
						obj.setStatus(new BigDecimal("4"));
						lineDao.update(obj);
					}
				}
			}catch(Exception e){
			
			}
	}
	
	@RequestMapping(value = "/updateLineStatusee/{area}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineStatusee(HttpServletRequest  request,  @PathVariable("area") String area,@PathVariable("status") String status) {
		
		
		String phmBranch= (String)request.getSession().getAttribute("deptId");
		System.out.println("updateLineStatus" +area+status+phmBranch );
		try{
			List<MmsAddline> lineList = lineDao.findLineByAreaEdit(area, status, phmBranch);
			System.out.println("updateLineStatus1" +lineList.size() );
			
				if(lineList != null){
				for(int i = 0;i<lineList.size();i++)
					{
						MmsAddline obj = lineList.get(i);
						System.out.println("updateLineStatus2" +obj.getStatus() );
						obj.setStatus(new BigDecimal("1"));
						lineDao.update(obj);
					}
				}
			}catch(Exception e){
			
			}
	}
	
	@RequestMapping(value = "/validateLine", method = RequestMethod.GET)
	public ModelAndView validateLine() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewLinesValidate");

		return model;

	}
	
	

	@RequestMapping(value = "/approveLine", method = RequestMethod.GET)
	public ModelAndView approveLine() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewLinesApprove");

		return model;

	}
	
	
	@RequestMapping(value = "/viewLineNew", method = RequestMethod.GET)
	public ModelAndView viewLineNew(HttpServletRequest request) {

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		/*int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}*/

//		int lineLoop = lineObj.size() - 1;
//		for (int i = 0; i <= lineLoop; i++) {
//			//System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
//		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("viewLineNew", "model", model);

	}
	
	@RequestMapping(value = "/viewLineNewSOther")
	public ModelAndView viewLineNewSOther(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		String area = model.getGldeptobj().getDeptId();
		System.out.println("displayLineNewS3"+area);
		
		
		//String line = String.valueOf(model.getLine().getCode());
		//System.out.println("displayLineNewS4"+line);
		//String id = "";
		//if (line.equalsIgnoreCase("NONE")) {
			//id = "NONE";
		//} else {
			//id = addLine.findIdByCode(line.trim());
		//}
		//System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		//System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE") || userLevel.equals("CE") || userLevel.equals("DGM") || userLevel.equals("AGM")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddline> lineListEdit = lineDao.findLineByArea(area);
		System.out.println("dddduuuu :" + lineListEdit.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setLineListEdit(lineListEdit);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		// / PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		
		/*int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line1.get(i);

			//System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		
*/
		Glcompm distDiv1 = glcompmDao.getDistDivision2(province);
		provinceList.put(distDiv1.getCompId(), distDiv1.getCompNm());
		
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv1.getCompId());
		
		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		/*int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		*/model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		
		List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		model.setLinetype(lineType);
		return new ModelAndView("viewLineNewOther", "model", model);
	}

	
	@RequestMapping(value = "/viewLineNewOther", method = RequestMethod.GET)
	public ModelAndView viewLineNewOther(HttpServletRequest request) {

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		
		Glcompm distDiv = glcompmDao.getDistDivision2(province);
		provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
		
		System.out.println("hi2 : " + province);
		//String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		//List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		/*int loop = line.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
*/
		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

//		int lineLoop = lineObj.size() - 1;
//		for (int i = 0; i <= lineLoop; i++) {
//			//System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
//		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("viewLineNewOther", "model", model);

	}

	
	
	
	
	
	
	@RequestMapping(value = "/viewLineNewS")
	public ModelAndView viewLineNewS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		String area = model.getGldeptobj().getDeptId();
		System.out.println("displayLineNewS3"+area);
		
		
		//String line = String.valueOf(model.getLine().getCode());
		//System.out.println("displayLineNewS4"+line);
		//String id = "";
		//if (line.equalsIgnoreCase("NONE")) {
			//id = "NONE";
		//} else {
			//id = addLine.findIdByCode(line.trim());
		//}
		//System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		//System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddline> lineListEdit = lineDao.findLineByArea(area,deptId);
		System.out.println("dddduuuu :" + lineListEdit.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setLineListEdit(lineListEdit);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		// / PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line1.get(i);

			//System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		
		List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		model.setLinetype(lineType);
		return new ModelAndView("viewLineNew", "model", model);
	}
	
	@RequestMapping(value = "/displayLineNew", method = RequestMethod.GET)
	public ModelAndView displayLineNew(HttpServletRequest request) {

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		/*int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}
*/
		/*int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
*/		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		//model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("editLineNewNew", "model", model);

	}
	
	
	
	
	@RequestMapping(value = "/displayLineNewS")
	public ModelAndView displayLineNewS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		String area = model.getGldeptobj().getDeptId();
		System.out.println("displayLineNewS3"+area);
		String province = model.getGlcompmobj().getCompId();
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddline> lineListEdit = lineDao.findLineByAreaEdit(area,status,deptId);
		System.out.println("dddduuuu :" + lineListEdit.size());
		model.setLineListEdit(lineListEdit);
		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		System.out.println("hi1 : " + deptId);
		province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		System.out.println("hi5 : " + model.getGlcompmobj().getCompId());
		
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line1.get(i);

			//System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		/*int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		
		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
*/	//	model.setSupTypeList(supportTypeList);
		
		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		
		
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = lineListEdit.size() - 1;
				String stringOfLineIds = "";

				for (int i = 0; i <= supSize; i++) {
					MmsAddline obj = lineListEdit.get(i);
					if (i != 0) {
						stringOfLineIds = stringOfLineIds + "," + Long.toString(obj.getId());
					} else {
						stringOfLineIds = Long.toString(obj.getId());
					}
				}
				System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

				model.setStringOfLineIds(stringOfLineIds);
				// -------------------------------------------------------------
		
				List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		 model.setLinetype(lineType);
		 List<MmsAddconductortype> conType = conTypeDao.findAll();
		 model.setConTypeList(conType);
		 	       
		return new ModelAndView("editLineNewNew", "model", model);
	}
	
	
	@RequestMapping(value = "/displayLineNewNewS")
	public ModelAndView displayLineNewNewS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		String area = model.getGldeptobj().getDeptId();
		System.out.println("displayLineNewS3"+area);
		String province = model.getGlcompmobj().getCompId();
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddline> lineListEdit = lineDao.findLineByAreaEdit(area,status,deptId);
		System.out.println("dddduuuu :" + lineListEdit.size());
		model.setLineListEdit(lineListEdit);
		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		System.out.println("hi1 : " + deptId);
		province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		System.out.println("hi5 : " + model.getGlcompmobj().getCompId());
		
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line1.get(i);

			//System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		/*int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		
		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
*/	//	model.setSupTypeList(supportTypeList);
		
		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		
		
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = lineListEdit.size() - 1;
				String stringOfLineIds = "";

				for (int i = 0; i <= supSize; i++) {
					MmsAddline obj = lineListEdit.get(i);
					if (i != 0) {
						stringOfLineIds = stringOfLineIds + "," + Long.toString(obj.getId());
					} else {
						stringOfLineIds = Long.toString(obj.getId());
					}
				}
				System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

				model.setStringOfLineIds(stringOfLineIds);
				// -------------------------------------------------------------
		
				List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		 model.setLinetype(lineType);
		 List<MmsAddconductortype> conType = conTypeDao.findAll();
		 model.setConTypeList(conType);
		 	       
		return new ModelAndView("editLineNew", "model", model);
	}

	
	@RequestMapping(value = "/displayLineNewView")
	public ModelAndView displayLineNewView(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		System.out.println("displayLineNewS2");

		String area = model.getGldeptobj().getDeptId();
		System.out.println("displayLineNewS3"+area);
		
		
		//String line = String.valueOf(model.getLine().getCode());
		//System.out.println("displayLineNewS4"+line);
		//String id = "";
		//if (line.equalsIgnoreCase("NONE")) {
			//id = "NONE";
		//} else {
			//id = addLine.findIdByCode(line.trim());
		//}
		//System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		//System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddline> lineListEdit = lineDao.findLineByAreaEdit(area,status,deptId);
		System.out.println("dddduuuu :" + lineListEdit.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setLineListEdit(lineListEdit);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		// / PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line1.get(i);

			//System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		

		return new ModelAndView("editLineNew", "model", model);
	}
	
	@RequestMapping(value = "/updateLineStatusNew/{area}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineStatusNew(HttpServletRequest request,@PathVariable("area") String area) {
		System.out.println("updateLineStatusNew");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("updateLineStatusNew1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("updateLineStatusNew2");
		//String phmBranch = (String) request.getSession().getAttribute("deptId");
		try {
			String status = null;
			String updateStatus = null;

			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
				updateStatus = Util.APPROVAL_EE;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
				updateStatus = Util.APPROVE;
			}
			System.out.println("updateLineStatusNew3");
			List<MmsAddline> line = lineDao.findLineByAreaEdit(area, status, deptId);
			System.out.println("Support :" + line.size());

			if (line != null) {
				for (int i = 0; i < line.size(); i++) {
					MmsAddline obj = line.get(i);
					System.out
							.println("updateSLineStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					System.out.println("addLne6: " );
					lineDao.update(obj);
					System.out.println("addLine5: " );
				}
			}
			System.out.println("addLine54: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	
	@RequestMapping(value = "/displayLineApprove", method = RequestMethod.GET)
	public ModelAndView displayLineApprove(HttpServletRequest request) {

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("editLineApprove", "model", model);

	}
	
	@RequestMapping(value = "/displayLineApproveS")
	public ModelAndView displayLineApproveS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		String area = model.getGldeptobj().getDeptId();
		System.out.println("displayLineNewS3"+area);
		
		
		//String line = String.valueOf(model.getLine().getCode());
		//System.out.println("displayLineNewS4"+line);
		//String id = "";
		//if (line.equalsIgnoreCase("NONE")) {
			//id = "NONE";
		//} else {
			//id = addLine.findIdByCode(line.trim());
		//}
		//System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		//System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}

		List<MmsAddline> lineListEdit = lineDao.findLineByAreaEdit(area,status,deptId);
		System.out.println("dddduuuu :" + lineListEdit.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setLineListEdit(lineListEdit);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		// / PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			//System.out.println(i);
			Glcompm ojb = line1.get(i);

			//System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		model.setLinetype(lineType);
		
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = lineListEdit.size() - 1;
				String stringOfLineIds = "";

				for (int i = 0; i <= supSize; i++) {
					MmsAddline obj = lineListEdit.get(i);
					if (i != 0) {
						stringOfLineIds = stringOfLineIds + "," + Long.toString(obj.getId());
					} else {
						stringOfLineIds = Long.toString(obj.getId());
					}
				}
				System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

				model.setStringOfLineIds(stringOfLineIds);
				// -------------------------------------------------------------
				List<MmsAddconductortype> conType = conTypeDao.findAll();
				 model.setConTypeList(conType);

		return new ModelAndView("editLineApprove", "model", model);
	}
	
	/*// edit anushka 2018-12-31---------------------------------------------------------------------------------------------------------------------------------
		@RequestMapping("/editLineType")
		public ModelAndView editLineType() {
			List<MmsAddlinetype> LineType = lineTypeDao.findAll();
			return new ModelAndView("editLineType", "LineType", LineType);
		}

		@RequestMapping(value = "/updateLineType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateLineType(@PathVariable("name") String name,
				@PathVariable("id") String id, @PathVariable("status") String status) {
			MmsAddlinetype obj = new MmsAddlinetype();
			obj.setLineType(name);
			obj.setId(id);
			obj.setStatus(status);
			lineTypeDao.updateLineType(obj);
		}
		// --------------------------------------------------------------------------------------------------------------------------------------------------------
*/
	
	
	
	
	
	
	
	//edited anushka 2019-01-10 -------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/displayAllLines")
	public ModelAndView displayAllLines(HttpServletRequest request) {

		PivModel model = new PivModel();
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		//String area = model.getGldeptobj().getDeptId();
		//System.out.println("displayLineNewS3" + area);

		// String line = String.valueOf(model.getLine().getCode());
		// System.out.println("displayLineNewS4"+line);
		// String id = "";
		// if (line.equalsIgnoreCase("NONE")) {
		// id = "NONE";
		// } else {
		// id = addLine.findIdByCode(line.trim());
		// }
		// System.out.println("id :" + id);

		//String province = model.getGlcompmobj().getCompId();
		// System.out.println("DisplaySupportNewS : " + area + id + province);
		
		
		String status = null;
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}
		String phmBranch = (String) request.getSession().getAttribute("deptId");
		List<MmsAddline> lineListEdit = lineDao.findLineByStatus(status, phmBranch);
		System.out.println("dddduuuu :" + lineListEdit.size());
		
		
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setLineListEdit(lineListEdit);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		///* String */province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
	//	String distDiv = glcompmDao.getDistDivision(province);
	//	System.out.println("hi3 : " + distDiv);
		// / PivModel model = new PivModel();
	//	List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
	//	List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
	//	List<String> provinces = new ArrayList<String>();
		/*int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			// System.out.println(i);
			Glcompm ojb = line1.get(i);

			// System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}*/

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			// System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		/*int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			// System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}*/

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			// System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);

		// edit anushka 2019-01-08
		// ------------------------------------------------------------------------------------------------------------
		int supSize = lineListEdit.size() - 1;
		String stringOfLineIds = "";

		for (int i = 0; i <= supSize; i++) {
			MmsAddline obj = lineListEdit.get(i);
			if (i != 0) {
				stringOfLineIds = stringOfLineIds + "," + Long.toString(obj.getId());
			} else {
				stringOfLineIds = Long.toString(obj.getId());
			}
		}
		System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

		model.setStringOfLineIds(stringOfLineIds);
		// -------------------------------------------------------------------------------------------------------

		List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		model.setLinetype(lineType);
		return new ModelAndView("displayAllLines", "model", model);
	}
	
	
	
	@RequestMapping(value = "/displayAllLinesView")
	public ModelAndView displayAllLinesView(HttpServletRequest request) {

		PivModel model = new PivModel();
		System.out.println("displayLineNewS");
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("displayLineNewS1");
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		System.out.println("displayLineNewS2");

		//String area = model.getGldeptobj().getDeptId();
		//System.out.println("displayLineNewS3" + area);

		// String line = String.valueOf(model.getLine().getCode());
		// System.out.println("displayLineNewS4"+line);
		// String id = "";
		// if (line.equalsIgnoreCase("NONE")) {
		// id = "NONE";
		// } else {
		// id = addLine.findIdByCode(line.trim());
		// }
		// System.out.println("id :" + id);

		//String province = model.getGlcompmobj().getCompId();
		// System.out.println("DisplaySupportNewS : " + area + id + province);
		
		
		String status = null;
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}
		String phmBranch = (String) request.getSession().getAttribute("deptId");
		List<MmsAddline> lineListEdit = lineDao.findLineByStatus(status, phmBranch);
		System.out.println("dddduuuu :" + lineListEdit.size());
		
		
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setLineListEdit(lineListEdit);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		///* String */province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
	//	String distDiv = glcompmDao.getDistDivision(province);
	//	System.out.println("hi3 : " + distDiv);
		// / PivModel model = new PivModel();
	//	List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
	//	List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
	//	List<String> provinces = new ArrayList<String>();
		/*int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			// System.out.println(i);
			Glcompm ojb = line1.get(i);

			// System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}*/

		int supLoop = supType.size() - 1;
		for (int i = 0; i <= supLoop; i++) {
			// System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());

		}

		/*int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			// System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}*/

		int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			// System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);

		// edit anushka 2019-01-08
		// ------------------------------------------------------------------------------------------------------------
		int supSize = lineListEdit.size() - 1;
		String stringOfLineIds = "";

		for (int i = 0; i <= supSize; i++) {
			MmsAddline obj = lineListEdit.get(i);
			if (i != 0) {
				stringOfLineIds = stringOfLineIds + "," + Long.toString(obj.getId());
			} else {
				stringOfLineIds = Long.toString(obj.getId());
			}
		}
		System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

		model.setStringOfLineIds(stringOfLineIds);
		// -------------------------------------------------------------------------------------------------------

		List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
		model.setLinetype(lineType);
		return new ModelAndView("displayAllLines", "model", model);
	}

	
	
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------------------------
	
	//edited anushka 2019-01-10 -----------------------------------------------------------------------------------------
		@RequestMapping(value = "/updateLineStatusAll", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateLineStatusAll(HttpServletRequest request) {
			System.out.println("updateLineStatusNew");
			String deptId = request.getSession().getAttribute("deptId").toString();
			System.out.println("updateLineStatusNew1");
			String userLevel = request.getSession().getAttribute("loggedUserRole")
					.toString();
			System.out.println("updateLineStatusNew2");
			// String phmBranch = (String)
			// request.getSession().getAttribute("deptId");
			try {
				String status = null;
				String updateStatus = null;

				if (userLevel.equals("DEO")) {
					status = Util.IN_BULK;
					updateStatus = Util.VALIDATION_ES;
				} else if (userLevel.equals("ES")) {
					status = Util.VALIDATION_ES;
					updateStatus = Util.APPROVAL_EE;
				} else if (userLevel.equals("EE")) {
					status = Util.APPROVAL_EE;
					updateStatus = Util.APPROVE;
				}
				System.out.println("updateLineStatusNew3");
				String phmBranch = (String) request.getSession().getAttribute("deptId");
				List<MmsAddline> line = lineDao.findLineByStatus(status, phmBranch);
				System.out.println("Support :" + line.size());

				if (line != null) {
					for (int i = 0; i < line.size(); i++) {
						MmsAddline obj = line.get(i);
						System.out.println("updateSLineStatus2" + obj.getStatus());
						obj.setStatus(new BigDecimal(updateStatus));
						System.out.println("addLne6: ");
						lineDao.update(obj);
						System.out.println("addLine5: ");
					}
				}
				System.out.println("addLine54: ");
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		//-------------------------------------------------------------------------------------------------------------------
		
		
		@RequestMapping(value = "/getTotalofFlashSet/{area}/{line}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody double getTotalofFlashSet(HttpServletRequest  request,  @PathVariable("area") String area,@PathVariable("line") String line) {
			System.out.println("getTotalofFlashSet " );
			Object[] lineList = null;
			double total=0;
			double endfitting = 0;
			double fungussetno = 0;
			double wpinset = 0;
			double nofflashoversets = 0;
			try{
				/*lineList = lineDao.getTotalofFlashSet(area,line);
				if(lineList != null){
					System.out.println("getTotalofFlashSet " + lineList[0]);
					System.out.println("getTotalofFlashSet " + lineList[1]);
					System.out.println("getTotalofFlashSet " + lineList[2]);
					System.out.println("getTotalofFlashSet " + lineList[3]);
					
					
					if(lineList[0] != null){
						endfitting =Double.parseDouble(String.valueOf(lineList[0]));
					}
					if(lineList[1] != null){
						fungussetno =Double.parseDouble(String.valueOf(lineList[1]));
					}
					if(lineList[2] != null){
						wpinset =Double.parseDouble(String.valueOf(lineList[2]));
					}
					if(lineList[3] != null){
						nofflashoversets =Double.parseDouble(String.valueOf(lineList[3]));
					}
					
					for(int i = 0;i<lineList.size();i++)
						{
							Summary obj = lineList.get(i);
							List<String> a = (List<String>) lineList.get(0);
							a.get(0);
							System.out.println("obj.getEndfittingset() : " + a.get(0));
							//System.out.println("obj.getFungussetno() : " + lineList.get(0).getFungussetno());
							//System.out.println("obj.getWpinset() : " + lineList.get(0).getWpinset());
							//System.out.println("obj.getNofflashoversets() : " + lineList.get(0).getNofflashoversets());
						//}
					}*/
				}catch(Exception e){
					System.out.println("error : " + e.getMessage());
				}
			//total= endfitting + fungussetno + wpinset + nofflashoversets;
			return lineDao.getTotalofFlashSet(area,line,"");
		}
		
		@RequestMapping(value = "/MMSAddLineMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddLineMobile(@RequestBody MmsAddline line,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("equipment : " + equipment.getCode());
			try {
				/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				System.out.println("equipment : 1 ");
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				//String insTime = df2.format(today);
				Date insTimeDate=null;
				System.out.println("equipment : 2 ");
				
				//insTimeDate = new SimpleDateFormat("HH-MM-SS").parse(insTime);
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				
			       SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			        String time = localDateFormat.format(new Date());
			        System.out.println(time);

				
				
				System.out.println("equipment : 3 ");
				
				
				line.setEntDate(dateNowNew);
				System.out.println("equipment : 4 ");
				
				line.setEntTime(time);
				System.out.println("equipment : 5 ");
				
*/				
				lineDao.addLine(line);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N" +  e.getMessage() ;
			}

		}

		@RequestMapping(value = "/MMSUpdateLineMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateLineMobile(@RequestBody MmsAddline line,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("equipment : " + equipment.getCode());
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				System.out.println("equipment : 1 ");
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				//String insTime = df2.format(today);
				Date insTimeDate=null;
				System.out.println("equipment : 2 ");
				
				//insTimeDate = new SimpleDateFormat("HH-MM-SS").parse(insTime);
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				
			       SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			        String time = localDateFormat.format(new Date());
			        System.out.println(time);

				
				
				System.out.println("equipment : 3 ");
				
				
				line.setEntDate(dateNowNew);
				System.out.println("equipment : 4 ");
				
				line.setEntTime(time);
				System.out.println("equipment : 5 ");
				
				
				lineDao.update(line);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		
		@RequestMapping(value = "/findLineByAreaStatusNew/{area}/{status}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsAddline> findLineByAreaStatusNew(@PathVariable("area") String area,@PathVariable("status") String status) {
			return lineDao.findLineByAreaStatus(area, status);
			
		}
		

		@RequestMapping(value = "/findLineByIdNew/{id}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody MmsAddline findLineByIdNew(@PathVariable("id") String id) {
			return lineDao.findById(new Long(id));
			
		}
		
		
		@RequestMapping(value = "/lineSummary/{province}/{area}/{line}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Object[]> lineSummary(HttpServletRequest  request,@PathVariable("province") String province,@PathVariable("area") String area,@PathVariable("line") String line) {
			System.out.println(province+area+line);
			String deptId = (String) request.getSession().getAttribute("deptId");
			//String a = deptDao.getDD(deptId);
			//String distDiv = glcompmDao.getDistDivision(a);
			return lineDao.findDDSummary(province,area,line,deptId);
			
		}
		
		
		@RequestMapping(value = "/lineSummaryOther/{province}/{area}/{line}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Object[]> lineSummaryOther(HttpServletRequest  request,@PathVariable("province") String province,@PathVariable("area") String area,@PathVariable("line") String line) {
			System.out.println(province+area+line);
			String deptId = (String) request.getSession().getAttribute("deptId");
			//String a = deptDao.getDD(deptId);
			//String distDiv = glcompmDao.getDistDivision(a);
			return lineDao.findDDSummary(province,area,line);
			
		}
		
		
		@RequestMapping(value = "/lineSummaryNew/{province}/{area}/{line}/{division}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Object[]> lineSummaryNew(HttpServletRequest  request,@PathVariable("province") String province,@PathVariable("area") String area,@PathVariable("line") String line,@PathVariable("division") String division) {
			System.out.println(province+area+line);
			String deptId = (String) request.getSession().getAttribute("deptId");
			//String a = deptDao.getDD(deptId);
			//String distDiv = glcompmDao.getDistDivision(a);
			return lineDao.findDDSummary(province,area,line);
			
		}
		
		
		
		
		
		@RequestMapping(value = "/displayMVPoleNew", method = RequestMethod.GET)
		public ModelAndView displayMVPoleNew(HttpServletRequest request) {

			Map<String, String> lineList = new LinkedHashMap<String, String>();
			System.out.println("hi");
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute(
					"loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			System.out.println("hi1 : " + deptId);
			String province = deptDao.getDD(deptId);
			System.out.println("hi2 : " + province);
			String distDiv = glcompmDao.getDistDivision(province);
			System.out.println("hi3 : " + distDiv);
			PivModel model = new PivModel();
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				//System.out.println(i);
				Glcompm ojb = line.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}

						model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			return new ModelAndView("editMVPoleNew", "model", model);

		}
		
		
		@RequestMapping(value = "/displayMVPoleNewS")
		public ModelAndView displayMVPoleNewS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
			System.out.println("displayLineNewS");
			String deptId = request.getSession().getAttribute("deptId").toString();
			System.out.println("displayLineNewS1");
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			System.out.println("displayLineNewS2");

			String area = model.getGldeptobj().getDeptId();
			System.out.println("displayLineNewS3"+area);
			String province = model.getGlcompmobj().getCompId();
			String status = null;

			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}

			//List<MmsAddmvpole> lineListEdit = mmsAddPoleDao.getMvPoleByArea(area);
			//System.out.println("dddduuuu :" + lineListEdit.size());
			//model.setLineListEdit(lineListEdit);
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			System.out.println("hi");
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			System.out.println("hi1 : " + deptId);
			province = deptDao.getDD(deptId);
			System.out.println("hi2 : " + province);
			String distDiv = glcompmDao.getDistDivision(province);
			System.out.println("hi3 : " + distDiv);
			List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
			System.out.println("hi5 : " + model.getGlcompmobj().getCompId());
			
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
			
			List<String> provinces = new ArrayList<String>();
			int loop = line1.size() - 1;
			for (int i = 0; i <= loop; i++) {
				//System.out.println(i);
				Glcompm ojb = line1.get(i);

				//System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}

						
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				//System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}

			
			
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			List<MmsAddmvpole> listPole = mmsAddPoleDao.getMvPoleByArea(area);
			model.setMvPoleList(listPole);
		// edit anushka 2019-01-08
					// ------------------------------------------------------------------------------------------------------------
					int supSize = listPole.size() - 1;
					String stringOfLineIds = "";

					for (int i = 0; i <= supSize; i++) {
						MmsAddmvpole obj = listPole.get(i);
						if (i != 0) {
							stringOfLineIds = stringOfLineIds + "," + Long.toString(obj.getId());
						} else {
							stringOfLineIds = Long.toString(obj.getId());
						}
					}
					System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

					model.setStringOfLineIds(stringOfLineIds);
					// -------------------------------------------------------------
			
			List<MmsAddlinetype> lineType = lineTypeDao.findActiveTypes();
			 model.setLinetype(lineType);
			 List<MmsAddconductortype> conType = conTypeDao.findAll();
			 model.setConTypeList(conType);
			 	       
			return new ModelAndView("editMVPoleNew", "model", model);
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


	
	
	

}
