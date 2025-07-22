package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.ApprovalModel;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.domain.PoleModel;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsAddearthconductortype;
import com.it.piv.mms.domain.MmsAddfeeder;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddlinetype;
import com.it.piv.mms.domain.MmsAddlvfeeder;
import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddmvpolecct;
import com.it.piv.mms.domain.MmsAddmvpolecctPK;
import com.it.piv.mms.domain.MmsAddpole;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MmsAddsurgearrestor;
import com.it.piv.mms.domain.MmsAddsurgearrestorPK;
import com.it.piv.mms.domain.MmsAddswitch;
import com.it.piv.mms.domain.MmsAddswitchPK;
import com.it.piv.mms.domain.MmsAddtowerconfiguration;
import com.it.piv.mms.domain.MmsAddtransformer;
import com.it.piv.mms.domain.MmsAddtransformerPK;
import com.it.piv.mms.domain.MmsArea;
import com.it.piv.mms.domain.MmsGantryloc;
import com.it.piv.mms.domain.MmsGantrylocPK;
import com.it.piv.mms.domain.MmsInspection;
import com.it.piv.mms.domain.MmsTowermaintenance;
import com.it.piv.mms.domain.MmsTowermaintenancePK;
import com.it.piv.mms.domain.MmsTowertype;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.domain.MmsTxntowermaintenancemv;
import com.it.piv.mms.domain.MmsTxntowermaintenancemvPK;
import com.it.piv.mms.domain.Msttowertype;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.PcestdttPK;
import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;
import com.it.piv.mms.domain.Summary;
import com.it.piv.mms.domain.TowerModel;
import com.it.piv.mms.repo.ApplicantDao;
import com.it.piv.mms.repo.ApplicationDao;
import com.it.piv.mms.repo.ApprovalDao;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.LoginDao;
import com.it.piv.mms.repo.MMSAddgantryDao;
import com.it.piv.mms.repo.MmsAddConductorTypeDao;
import com.it.piv.mms.repo.MmsAddEarthConductorTypeDao;
import com.it.piv.mms.repo.MmsAddFeederDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsAddLineTypeDao;
import com.it.piv.mms.repo.MmsAddPoleDao;
import com.it.piv.mms.repo.MmsAddSupportTypeDao;
import com.it.piv.mms.repo.MmsAddSwitchDao;
import com.it.piv.mms.repo.MmsAddTowerConfigDao;
import com.it.piv.mms.repo.MmsAddlvfeederDao;
import com.it.piv.mms.repo.MmsAddmvpoleDao;
import com.it.piv.mms.repo.MmsAddmvpolecctDao;
import com.it.piv.mms.repo.MmsAddsurgearrestorDao;
import com.it.piv.mms.repo.MmsAddtransformerDao;
import com.it.piv.mms.repo.MmsAreaDao;
import com.it.piv.mms.repo.MmsGantrylocDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermaintenancemvDao;
import com.it.piv.mms.repo.MsttowertypeDao;
import com.it.piv.mms.repo.MvmmsCycleDao;
import com.it.piv.mms.repo.PcestdttDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.mms.repo.SpestedyConDao;
import com.it.piv.mms.domain.MmsProvince;
import com.it.piv.mms.repo.ProvinceDao;
import com.it.piv.util.common.Format;
import com.it.piv.util.common.PathMMS;
import com.it.piv.mms.domain.SpestedyCon;
import com.it.piv.mms.domain.SpestedyConPK;
import com.it.piv.mms.domain.MmsAddgantry;

;

@Controller
public class SupportController {
	
	
	
	@Autowired
	private MMSAddgantryDao gantryDao;
	
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
	private MsttowertypeDao towerTypeDao;
	@Autowired
	private MmsAddConductorTypeDao conTypeDao;
	@Autowired
	private MmsAddEarthConductorTypeDao earthConTypeDao;
	
	
	@Autowired 
	private MmsAddTowerConfigDao  towerConfig;
	
	@Autowired
	private MvmmsCycleDao cycleDao;
	
	@Autowired
	private MmsGantrylocDao gantryLocDao;
	
	@Autowired
	private MmsAddFeederDao feederDao;
	
	
	@Autowired
	private MmsAddSwitchDao SwitchDao;
	
	@Autowired
	private MmsAddPoleDao poleDao;
	
	@Autowired
	private MmsAddmvpoleDao poleMvDao;
	
	@Autowired
	private MmsAddmvpolecctDao poleMvCctDao;
	
	
	@Autowired
	private MmsTxntowermaintenancemvDao mvMntDao;
	
	@Autowired
	private MmsAddmvpoleDao addMvPole;
	
	@Autowired
	private MmsAddsurgearrestorDao saDao;
	
	@Autowired
	private MmsAddtransformerDao trDao;
	@Autowired
	private MmsAddlvfeederDao lvFeaderDao;
	

	private static final DateFormat sdf = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	private static final DateFormat dateNow = new SimpleDateFormat("yyyy-MM-dd");

	// edit anushka begin 2018-11-28
	// ----------------------------------------------------------------------------------------------------------------------------

	@RequestMapping("/viewSupportNewS")
	public ModelAndView viewSupportNewS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();

		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id = "";
		if (line.equalsIgnoreCase("NONE")) {
			id = "NONE";
		} else {
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		
		List<MmsAddsupport> Support = addSupport.findByArea(area,String.valueOf(id), province, deptId);
		System.out.println("dddduuuu :" + Support.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setSupport(Support);
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
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = line1.get(i);

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
		 List<MmsAddtowerconfiguration> activeConfigurations = towerConfig.findActiveConfigurations();
	        model.setActiveConfigurations(activeConfigurations);
	        List<MmsTowertype> towerTypeList = towerTypeDao.findAll();
	        List<MmsAddconductortype> conType = conTypeDao.findAll();
	        model.setConTypeList(conType);
	        model.setTowerType(towerTypeList);
	        List<MmsAddearthconductortype> earthConType = earthConTypeDao.findAll();
	        model.setErthConTypeList(earthConType);
	        List<MmsAddsupporttype> supTypeList = supTypeDao.findAll();
	        model.setsTypeList(supTypeList);
	        System.out.println("size:"+supTypeList.size());
		return new ModelAndView("viewSupportNew", "model", model);
	}

	
	@RequestMapping(value = "/viewSupportNew", method = RequestMethod.GET)
	public ModelAndView viewSupportNew(HttpServletRequest request) {

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

		/*int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}*/

		/*int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}*/
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("viewSupportNew", "model", model);

	}
	
	
	@RequestMapping("/viewSupportNewSOther")
	public ModelAndView viewSupportNewSOther(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();

		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id = "";
		if (line.equalsIgnoreCase("NONE")) {
			id = "NONE";
		} else {
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE") || userLevel.equals("CE") || userLevel.equals("DGM") || userLevel.equals("AGM")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddsupport> Support = addSupport.findByAreaOther(area,String.valueOf(id), province);
		System.out.println("dddduuuu :" + Support.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setSupport(Support);
		// pivModel.setProvinceList(pivModel.getProvinceList());

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute(
				"loggedUser");
		/*// / String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		 String province = deptDao.getDD(deptId);
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
			System.out.println(i);
			Glcompm ojb = line1.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		
		
*/
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		
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

		
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		 List<MmsAddtowerconfiguration> activeConfigurations = towerConfig.findActiveConfigurations();
	        model.setActiveConfigurations(activeConfigurations);
	        List<MmsTowertype> towerTypeList = towerTypeDao.findAll();
	        List<MmsAddconductortype> conType = conTypeDao.findAll();
	        model.setConTypeList(conType);
	        model.setTowerType(towerTypeList);
	        List<MmsAddearthconductortype> earthConType = earthConTypeDao.findAll();
	        model.setErthConTypeList(earthConType);
	        List<MmsAddsupporttype> supTypeList = supTypeDao.findAll();
	        model.setsTypeList(supTypeList);
	        System.out.println("size:"+supTypeList.size());
		return new ModelAndView("viewSupportNewOther", "model", model);
	}

	
	
	@RequestMapping(value = "/viewSupportNewOther", method = RequestMethod.GET)
	public ModelAndView viewSupportNewOther(HttpServletRequest request) {

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
		}*/

		/*int lineLoop = lineObj.size() - 1;
		for (int i = 0; i <= lineLoop; i++) {
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		}*/
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("viewSupportNewOther", "model", model);

	}

	
	@RequestMapping(value = "/displaySupportNew", method = RequestMethod.GET)
	public ModelAndView displaySupportNew(HttpServletRequest request) {

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
			lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		// model.setMode(mode);
		return new ModelAndView("editSupportNew", "model", model);

	}
	
	@RequestMapping(value = "/displaySupportApprove", method = RequestMethod.GET)
	public ModelAndView displaySupportApprove(HttpServletRequest request) {

		
		//String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
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
		/*String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}
		
		List<MmsAddsupport> Support = addSupport.findByStatus(status);
		System.out.println("dddduuuu :" + Support.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setSupport(Support);
*/
		
		
		
		
		return new ModelAndView("editSupportApprove", "model", model);

	}
	
	@RequestMapping("/displaySupportApproveS")
	public ModelAndView displaySupportApproveS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();

		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id = "";
		if (line.equalsIgnoreCase("NONE")) {
			id = "NONE";
		} else {
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}

		List<MmsAddsupport> Support = addSupport.findBySupportStatus(area,
				String.valueOf(id), province, deptId, status);
		System.out.println("dddduuuu :" + Support.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setSupport(Support);
		// pivModel.setProvinceList(pivModel.getProvinceList());
		
		//edit anushka 2019-01-03------------------------------------------------------------------------------------------------------------

				int supSize = Support.size() - 1;
				String stringOfSupportIds = "";
				
				for (int i = 0; i <= supSize; i++) {
					MmsAddsupport obj = Support.get(i);
					if(i != 0){
						stringOfSupportIds = stringOfSupportIds + "," + Long.toString(obj.getId());
					}else{
						stringOfSupportIds = Long.toString(obj.getId());
					}
				}
				System.out.println("-------------------> stringOfSupportIds: "+stringOfSupportIds);
				
				model.setStringOfSupportIds(stringOfSupportIds);
				//-----------------------------------------------------------------------------------------------------------------------------------
				
		
		

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		System.out.println("hi");
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
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
			System.out.println(i);
			Glcompm ojb = line1.get(i);

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
		List<MmsAddtowerconfiguration> activeConfigurations = towerConfig.findActiveConfigurations();
        model.setActiveConfigurations(activeConfigurations);
        List<MmsTowertype> towerTypeList = towerTypeDao.findAll();
        List<MmsAddconductortype> conType = conTypeDao.findAll();
        model.setConTypeList(conType);
        model.setTowerType(towerTypeList);
        List<MmsAddearthconductortype> earthConType = earthConTypeDao.findAll();
        model.setErthConTypeList(earthConType);
        List<MmsAddsupporttype> supTypeList = supTypeDao.findAll();
        model.setsTypeList(supTypeList);
		return new ModelAndView("editSupportApprove", "model", model);
	}


	@RequestMapping("/displaySupportNewS")
	public ModelAndView displaySupportNewS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();

		String area = model.getGldeptobj().getDeptId();
		//String line = String.valueOf(model.getLine().getCode());
		String id = String.valueOf(model.getLine().getId());
		//if (line.equalsIgnoreCase("NONE")) {
			//id = "NONE";
		//} else {
			//id = addLine.findIdByCode(line.trim());
		//}
		System.out.println("id :" + id);

		String province = model.getGlcompmobj().getCompId();
		System.out.println("DisplaySupportNewS : " + area + id + province);
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddsupport> Support = addSupport.findBySupportStatus(area,
				String.valueOf(id), province, deptId, status);
		System.out.println("dddduuuu :" + Support.size());
		// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		// List<LinkedHashMap> Support=restTemplate.getForObject(url,
		// List.class);
		model.setSupport(Support);
		// pivModel.setProvinceList(pivModel.getProvinceList());
		//edit anushka 2019-01-03------------------------------------------------------------------------------------------------------------

		int supSize = Support.size() - 1;
		String stringOfSupportIds = "";
		
		for (int i = 0; i <= supSize; i++) {
			MmsAddsupport obj = Support.get(i);
			if(i != 0){
				stringOfSupportIds = stringOfSupportIds + "," + Long.toString(obj.getId());
			}else{
				stringOfSupportIds = Long.toString(obj.getId());
			}
		}
		System.out.println("-------------------> stringOfSupportIds: "+stringOfSupportIds);
		
		model.setStringOfSupportIds(stringOfSupportIds);
		//----------------------------------------------------
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
			System.out.println(i);
			Glcompm ojb = line1.get(i);

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
			lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		}
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		 List<MmsAddtowerconfiguration> activeConfigurations = towerConfig.findActiveConfigurations();
	        model.setActiveConfigurations(activeConfigurations);
	        List<MmsTowertype> towerTypeList = towerTypeDao.findAll();
	        List<MmsAddconductortype> conType = conTypeDao.findAll();
	        model.setConTypeList(conType);
	        model.setTowerType(towerTypeList);
	        List<MmsAddearthconductortype> earthConType = earthConTypeDao.findAll();
	        model.setErthConTypeList(earthConType);
	        List<MmsAddsupporttype> supTypeList = supTypeDao.findAll();
	        model.setsTypeList(supTypeList);
	        System.out.println("size:"+supTypeList.size());
		return new ModelAndView("editSupportNew", "model", model);
	}

	@RequestMapping(value = "/updateSupportStatus/{province}/{area}/{line}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineStatusee(HttpServletRequest request,
			@PathVariable("province") String province,
			@PathVariable("area") String area, @PathVariable("line") String line) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String phmBranch = (String) request.getSession().getAttribute("deptId");
		System.out.println("updateLineStatus" + province + area + phmBranch
				+ line);

		String id = "";
		//if (line.equalsIgnoreCase("NONE")) {
			//id = "NONE";
		//} else {
			//id = addLine.findIdByCode(line.trim());
		//}
		System.out.println("id :" + id);

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

			List<MmsAddsupport> Support = addSupport.findBySupportStatus(area,
					String.valueOf(line), province, deptId, status);
			System.out.println("Support :" + Support.size());

			if (Support != null) {
				for (int i = 0; i < Support.size(); i++) {
					MmsAddsupport obj = Support.get(i);
					System.out
							.println("updateSupportStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					System.out.println("addSupport6: " );
					addSupport.update(obj);
					System.out.println("addSupport5: " );
				}
			}
			System.out.println("addSupport4: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	@RequestMapping(value = "/updateSupportStatusApprove/{province}/{area}/{line}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupportStatusApprove(HttpServletRequest request,
			@PathVariable("province") String province,
			@PathVariable("area") String area, @PathVariable("line") String line) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String phmBranch = (String) request.getSession().getAttribute("deptId");
		System.out.println("updateLineStatus" + province + area + phmBranch
				+ line);

		String id = "";
		if (line.equalsIgnoreCase("NONE")) {
			id = "NONE";
		} else {
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);

		try {
			String status = null;
			String updateStatus = null;

			/*if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
				updateStatus = Util.APPROVAL_EE;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
				updateStatus = Util.APPROVE;
			}*/
			
			status = Util.APPROVE;
			updateStatus = Util.APPROVE;

			List<MmsAddsupport> Support = addSupport.findBySupportStatus(area,
					String.valueOf(id), province, deptId, status);
			System.out.println("Support :" + Support.size());

			if (Support != null) {
				for (int i = 0; i < Support.size(); i++) {
					MmsAddsupport obj = Support.get(i);
					System.out
							.println("updateSupportStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					System.out.println("addSupport6: " );
					addSupport.update(obj);
					System.out.println("addSupport5: " );
				}
			}
			System.out.println("addSupport4: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	//edited anushka 2019-01-10 ---------------------------------------------------------------------------------------------------------------------------------
		@RequestMapping("/displayAllSupports")
		public ModelAndView displayAllSupports(HttpServletRequest request) {

			PivModel model = new PivModel();
			String deptId = request.getSession().getAttribute("deptId").toString();
			String userLevel = request.getSession().getAttribute("loggedUserRole")
					.toString();

			String status = null;

			//find all supports according to status
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
	        List<MmsAddsupport> Support = addSupport.findByStatus(status,deptId);
			model.setSupport(Support);
			

			//set the string of selected all support ids
			int supSize = Support.size() - 1;
			String stringOfSupportIds = "";

			for (int i = 0; i <= supSize; i++) {
				MmsAddsupport obj = Support.get(i);
				if (i != 0) {
					stringOfSupportIds = stringOfSupportIds + ","
							+ Long.toString(obj.getId());
				} else {
					stringOfSupportIds = Long.toString(obj.getId());
				}
			}
			System.out.println("-------------------> stringOfSupportIds: " + stringOfSupportIds);
			model.setStringOfSupportIds(stringOfSupportIds);
			
			

			Map<String, String> lineList = new LinkedHashMap<String, String>();
			System.out.println("hi");
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute(
					"loggedUser");

			System.out.println("hi1 : " + deptId);
			
			List<MmsAddsupporttype> supType = supTypeDao.findAll();

			int supLoop = supType.size() - 1;
			for (int i = 0; i <= supLoop; i++) {
				// System.out.println(i);
				MmsAddsupporttype ojb = supType.get(i);
				supportTypeList.put(ojb.getId(), ojb.getSupportType());

			}

			model.setSupTypeList(supportTypeList);
			
			List<MmsAddtowerconfiguration> activeConfigurations = towerConfig
					.findActiveConfigurations();
			model.setActiveConfigurations(activeConfigurations);
			List<MmsTowertype> towerTypeList = towerTypeDao.findAll();
			List<MmsAddconductortype> conType = conTypeDao.findAll();
			model.setConTypeList(conType);
			model.setTowerType(towerTypeList);
			List<MmsAddearthconductortype> earthConType = earthConTypeDao.findAll();
			model.setErthConTypeList(earthConType);
			List<MmsAddsupporttype> supTypeList = supTypeDao.findAll();
			model.setsTypeList(supTypeList);
			System.out.println("size:" + supTypeList.size());
			return new ModelAndView("displayAllSupports", "model", model);
		}
		//-----------------------------------------------------------------------------------------------------------------------------------------------------


		
		//edited anushka 2019-01-10 ---------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/updateSupportAllApprove", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateSupportAllApprove(HttpServletRequest request) {

			String deptId = request.getSession().getAttribute("deptId").toString();
			String userLevel = request.getSession().getAttribute("loggedUserRole")
					.toString();
			String phmBranch = (String) request.getSession().getAttribute("deptId");
			

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

				List<MmsAddsupport> Support = addSupport.findByStatus(status);
				System.out.println("Support :" + Support.size());

				if (Support != null) {
					for (int i = 0; i < Support.size(); i++) {
						MmsAddsupport obj = Support.get(i);
						System.out
								.println("updateSupportStatus2" + obj.getStatus());
						obj.setStatus(new BigDecimal(updateStatus));
						System.out.println("addSupport6: ");
						addSupport.update(obj);
						System.out.println("addSupport5: ");
					}
				}
				System.out.println("addSupport4: ");
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		//----------------------------------------------------------------------------------------------------------------------------------
		
		
		@RequestMapping(value = "/displaySupportTapping", method = RequestMethod.GET)
		public ModelAndView displaySupportTapping(HttpServletRequest request) {

			
			//String deptId = request.getSession().getAttribute("deptId").toString();
			String userLevel = request.getSession().getAttribute("loggedUserRole")
					.toString();
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
			/*String status = null;

			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVE;
			}
			
			List<MmsAddsupport> Support = addSupport.findByStatus(status);
			System.out.println("dddduuuu :" + Support.size());
			// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
			// List<LinkedHashMap> Support=restTemplate.getForObject(url,
			// List.class);
			model.setSupport(Support);
	*/
			
			
			
			
			return new ModelAndView("editSupportTapping", "model", model);

		}
		
		@RequestMapping("/displaySupportTappingS")
		public ModelAndView displaySupportTappingS(HttpServletRequest request,
				@ModelAttribute("model") PivModel model) {

			String deptId = request.getSession().getAttribute("deptId").toString();
			String userLevel = request.getSession().getAttribute("loggedUserRole")
					.toString();

			String area = model.getGldeptobj().getDeptId();
			String line = String.valueOf(model.getLine().getCode());
			String id = "";
			if (line.equalsIgnoreCase("NONE")) {
				id = "NONE";
			} else {
				id = addLine.findIdByCode(line.trim());
			}
			System.out.println("id :" + id);

			String province = model.getGlcompmobj().getCompId();
			System.out.println("DisplaySupportNewS : " + area + id + province);
			String status = null;

			/*if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
			*/	status = Util.APPROVE;
			//}

			List<MmsAddsupport> Support = addSupport.findBySupportStatus(area,
					String.valueOf(id), province, deptId, status);
			System.out.println("dddduuuu :" + Support.size());
			// String url=Util.STR_SER+"findAllSupportByStatus?status=2";
			// List<LinkedHashMap> Support=restTemplate.getForObject(url,
			// List.class);
			model.setSupport(Support);
			// pivModel.setProvinceList(pivModel.getProvinceList());
			
			//edit anushka 2019-01-03------------------------------------------------------------------------------------------------------------

					int supSize = Support.size() - 1;
					String stringOfSupportIds = "";
					
					for (int i = 0; i <= supSize; i++) {
						MmsAddsupport obj = Support.get(i);
						if(i != 0){
							stringOfSupportIds = stringOfSupportIds + "," + Long.toString(obj.getId());
						}else{
							stringOfSupportIds = Long.toString(obj.getId());
						}
					}
					System.out.println("-------------------> stringOfSupportIds: "+stringOfSupportIds);
					
					model.setStringOfSupportIds(stringOfSupportIds);
					//-----------------------------------------------------------------------------------------------------------------------------------
					
					
			

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
				System.out.println(i);
				Glcompm ojb = line1.get(i);

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
			List<MmsAddtowerconfiguration> activeConfigurations = towerConfig.findActiveConfigurations();
	        model.setActiveConfigurations(activeConfigurations);
	        List<MmsTowertype> towerTypeList = towerTypeDao.findAll();
	        List<MmsAddconductortype> conType = conTypeDao.findAll();
	        model.setConTypeList(conType);
	        model.setTowerType(towerTypeList);
	        List<MmsAddearthconductortype> earthConType = earthConTypeDao.findAll();
	        model.setErthConTypeList(earthConType);
	        List<MmsAddsupporttype> supTypeList = supTypeDao.findAll();
	        model.setsTypeList(supTypeList);
			return new ModelAndView("editSupportTapping", "model", model);
		}
		
		
		@RequestMapping(value = "/MMSAddSupportMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddSupportMobile(@RequestBody MmsAddsupport support,
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
				
				
				support.setEntDate(dateNowNew);
				System.out.println("equipment : 4 ");
				
				support.setEntTime(time);
				System.out.println("equipment : 5 ");
				
*/				
				addSupport.addSupport(support);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N" + e.getMessage();
			}

		}
		
		
		@RequestMapping(value = "/MMSUpdateSupportMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateSupportMobile(@RequestBody MmsAddsupport support,
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
				
				
				support.setEntDate(dateNowNew);
				System.out.println("equipment : 4 ");
				
				support.setEntTime(time);
				System.out.println("equipment : 5 ");
				
				
				addSupport.update(support);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}

		
		
		@RequestMapping(value = "/MMSAddGantryMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddGantryMobile(@RequestBody MmsAddgantry gantry,
				HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("MMSAddGantryMobile : " + gantry.getCode());
			String test = "";
			String test1 = "";
			String re = "";
			try {
				/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				Date insTimeDate=null;
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			    String time = localDateFormat.format(new Date());
			    gantry.setEntDate(dateNowNew);
				gantry.setEntTime(time);
				*/
				test = "test";
				gantry.setStatus(new BigDecimal("2"));
				re = gantryDao.addGantry(gantry);
				
				
				
				
				
				
				test1 = "test1";
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N" + re + e.getMessage()+"---------" +test+ "-----------" + test1  +"------"+gantry.getCode();
			}

		}
		
		
		@RequestMapping(value = "/MMSAddGantryLocMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddGantryLocMobile(@RequestBody MmsGantryloc gantry,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("MMSAddGantryMobile : " + gantry.getCode());
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				Date insTimeDate=null;
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			    String time = localDateFormat.format(new Date());
			    gantry.setEntDate(dateNowNew);
				gantry.setEntTime(time);
				gantryLocDao.addGantyLoc(gantry);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N" + e.getMessage();
			}

		}
		
		
		@RequestMapping(value = "/MMSAddFeederMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddFeederMobile(@RequestBody MmsAddfeeder feeder,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("MMSAddGantryMobile : " + gantry.getCode());
			try {
				/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				Date insTimeDate=null;
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			    String time = localDateFormat.format(new Date());
			    feederDao.setEntDate(dateNowNew);
			    feederDao.setEntTime(time);
				*/feederDao.addFeeder(feeder);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		
		@RequestMapping(value = "/MMSUpdateFeederMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateFeederMobile(@RequestBody MmsAddfeeder feeder,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("MMSAddGantryMobile : " + gantry.getCode());
			try {
				/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				Date insTimeDate=null;
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			    String time = localDateFormat.format(new Date());
			    feederDao.setEntDate(dateNowNew);
			    feederDao.setEntTime(time);
				*/feederDao.updateFeeder(feeder);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}



		@RequestMapping(value = "/getLatestMaintenanceNew", method = RequestMethod.GET)
		public @ResponseBody MmsTxntowermaintenance getLatestMaintenance(@RequestParam("towerid") String towerid,@RequestParam("area") String area){
			System.out.println("getLatestMaintenance");
			MmsTxntowermaintenance objMnt = null;	
			String cycle= cycleDao.findLatestCycle();
			List<Long> cycleList = cycleDao.fineMntAvailCycle(area);
			
			
			System.out.println("getLatestMaintenance : " +cycle);
			System.out.println("getLatestMaintenance towerid: " +towerid);
			
				MmsTxntowermaintenancePK objMNT = new MmsTxntowermaintenancePK();
				objMNT.setTowerid(new Long(towerid));
				objMNT.setVisitid(new Long(cycleList.get(0)));
				objMnt = towerTxtMaintenance.findByID(objMNT);
				if(objMnt == null){
					objMnt = towerTxtMaintenance.findByTowerId(new Long(towerid));
				}
				return objMnt;
				
        }
		
		
		
		@RequestMapping(value = "/getLatestMaintenance/{towerid}", method = RequestMethod.GET)
		public @ResponseBody MmsTxntowermaintenance getLatestMaintenance(@PathVariable("towerid") String towerid){
			System.out.println("getLatestMaintenance");
			MmsTxntowermaintenance objMnt = null;	
			String cycle= cycleDao.findLatestCycle();
			
			System.out.println("getLatestMaintenance : " +cycle);
			System.out.println("getLatestMaintenance towerid: " +towerid);
			
				MmsTxntowermaintenancePK objMNT = new MmsTxntowermaintenancePK();
				objMNT.setTowerid(new Long(towerid));
				objMNT.setVisitid(new Long(cycle));
				objMnt = towerTxtMaintenance.findByID(objMNT);
				if(objMnt == null){
					objMnt = towerTxtMaintenance.findByTowerId(new Long(towerid));
				}
				return objMnt;
				
        }
		

		@RequestMapping(value = "/findGantryById/{id}", method = RequestMethod.GET)
		public @ResponseBody MmsAddgantry findGantryById(@PathVariable("id") String id){
			return gantryDao.findById(new Long(id));
				
        }
		
		@RequestMapping(value = "/viewGantry", method = RequestMethod.GET)
		public ModelAndView viewGantry(@RequestParam("id") String id){
			MmsAddgantry obj = gantryDao.findById(new Long(id));
			ApprovalModel model = new ApprovalModel();
			model.setGantry(obj);
			return new ModelAndView("gantryInfo", "model", model);	
        }
		
		
		@RequestMapping(value = "/findFeederyById/{id}", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddfeeder> findFeederyById(@PathVariable("id") String id){
			return feederDao.getFeederByGantryId(id);
				
        }
		
		
		@RequestMapping(value = "/findLocationById/{gantryid}/{pointid}", method = RequestMethod.GET)
		public @ResponseBody MmsGantryloc findLocationById(@PathVariable("gantryid") String gantryid,@PathVariable("pointid") String pointid){
			MmsGantrylocPK gantryPk = new MmsGantrylocPK();
			gantryPk.setGantryId(new Long(gantryid));
			gantryPk.setPointId(new Long(pointid));
			return gantryLocDao.findById(gantryPk);
				
        }
		
		@RequestMapping(value = "/findSwitchById/{feederId}/{gantryId}/{switchId}", method = RequestMethod.GET)
		public @ResponseBody MmsAddswitch findSwitchById(@PathVariable("feederId") String feederId,@PathVariable("gantryId") String gantryId,@PathVariable("switchId") String switchId){
			MmsAddswitchPK objSwitch = new MmsAddswitchPK();
			objSwitch.setGantryId(new Long(gantryId));
			objSwitch.setFeederId(feederId);
			objSwitch.setSwitchId(switchId);
			
			return SwitchDao.findById(objSwitch);
				
        }
		
		
		@RequestMapping(value = "/findFeederById/{feederId}", method = RequestMethod.GET)
		public @ResponseBody MmsAddfeeder findFeederById(@PathVariable("feederId") String feederId){
			return feederDao.getFeederByFeederId(feederId);
				
        }
		
		@RequestMapping(value = "/MMSUpdateGantryMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateGantryMobile(@RequestBody MmsAddgantry gantry,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//System.out.println("MMSAddGantryMobile : " + gantry.getCode());
			try {
				/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				Date dateNowNew=null;
				
				DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
				Date insTimeDate=null;
				dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
				
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
			    String time = localDateFormat.format(new Date());
			    gantry.setEntDate(dateNowNew);
				gantry.setEntTime(time);
				*/gantryDao.updateGantry(gantry);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		@RequestMapping(value = "/MMSUpdateGantryLocMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateGantryLocMobile(@RequestBody MmsGantryloc gantryLoc,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				gantryLocDao.updateGantyLoc(gantryLoc);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}

		
		
		
		@RequestMapping(value = "/MMSAddSwitcheMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddSwitcheMobile(@RequestBody MmsAddswitch switchObj,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				SwitchDao.addSwitch(switchObj);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		@RequestMapping(value = "/MMSUpdateSwitcheMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateSwitcheMobile(@RequestBody MmsAddswitch switchObj,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				SwitchDao.updateSwitch(switchObj);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}


		@RequestMapping(value = "/getTower/{towerNo}", method = RequestMethod.GET)
		public @ResponseBody MmsAddsupport getTower(@PathVariable("towerNo") String towerNO) throws Exception {
			try {
				return addSupport.getTowerByTowerNo(towerNO);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		
		
		@RequestMapping(value = "/MMSAddPoleMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddPoleMobile(@RequestBody MmsAddpole pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				String id = poleDao.addPole(pole);
				
				/*MmsAddsupport objSupport = new MmsAddsupport();
				//objSupport.setLineId(pole.);
				objSupport.setStatus(new BigDecimal("1"));
				objSupport.setSupportType(new BigDecimal("9"));
				objSupport.setGpsLatitude(pole.getGpsLatitude());
				objSupport.setGpsLongitude(pole.getGpsLongitude());
				objSupport.setPhmBranch(pole.getDpetId());
				objSupport.setGantryId(new BigDecimal(id));
				objSupport.setArea(pole.getArea());
				objSupport.setTowerNo(pole.getPoleNo());
				objSupport.setConductorType(new BigDecimal("6"));
				objSupport.setEarthConductorType(new BigDecimal("1"));
				objSupport.setTowerType(new BigDecimal("1"));
				objSupport.setTowerConfiguration(new BigDecimal("1"));
				
				addSupport.addSupport(objSupport);
				
				*/
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N" + e.getMessage();
			}

		}
		
		
		
		@RequestMapping(value = "/MMSUpdatePoleMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdatePoleMobile(@RequestBody MmsAddpole pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				poleDao.update(pole);
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}



		@RequestMapping(value = "/MMSAddPoleMVMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddPoleMVMobile(@RequestBody MmsAddmvpole pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				String id = poleMvDao.addPole(pole);
				
				MmsAddsupport objSupport = new MmsAddsupport();
				//objSupport.setLineId(pole.);
				objSupport.setStatus(new BigDecimal("1"));
				objSupport.setSupportType(new BigDecimal("8"));
				objSupport.setGpsLatitude(pole.getGpsLatitude());
				objSupport.setGpsLongitude(pole.getGpsLongitude());
				objSupport.setGantryId(new BigDecimal(id));
				objSupport.setArea(pole.getArea());
				objSupport.setTowerNo(pole.getPoleNo());
				objSupport.setConductorType(new BigDecimal("6"));
				objSupport.setEarthConductorType(new BigDecimal("1"));
				objSupport.setTowerType(new BigDecimal("1"));
				objSupport.setTowerConfiguration(new BigDecimal("1"));
				
				addSupport.addSupport(objSupport);
				
				
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N" + e.getMessage();
			}

		}
		
		@RequestMapping(value = "/MMSAddPoleMVMobileNew", method = RequestMethod.POST)
		public @ResponseBody String MMSAddPoleMVMobileNew(@RequestBody PoleModel pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			int length = 0;
			String nextId = "";
			String error = "";
			try {
				
				
				String id = poleMvDao.addPole(pole.getMvPole());
				if(pole.getMvPoleCctList()!=null){
					
					length = pole.getMvPoleCctList().size();
					
					for(int i = 0;i<length;i++){
						MmsAddmvpolecct obj = pole.getMvPoleCctList().get(i);
						nextId = poleMvCctDao.getNextPoleId("C_");
						System.out.println(nextId);
						String poleId = "C_"+nextId;
						MmsAddmvpolecctPK objPK = new MmsAddmvpolecctPK();
						objPK.setId(poleId);
						objPK.setPoleId(new Long(id));
						obj.setId(objPK);
						try {
							poleMvCctDao.addCct(obj);
							error = "N";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							error = "Y" + e.getMessage();
						}
					}
				}
				
				return "Y L :" + length + "next ID : " + nextId +" error : "+error;
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N " + e.getMessage() + " L : " + length + " next ID : " + nextId + "error : "+ error;
			}

		}
		
		@RequestMapping(value = "/MMSModifyPoleMVMobileNew", method = RequestMethod.POST)
		public @ResponseBody String MMSModifyPoleMVMobileNew(@RequestBody PoleModel pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			int length = 0;
			String nextId = "";
			String error = "";
			try {
				
				
				String id = poleMvDao.update(pole.getMvPole());
				if(pole.getMvPoleCctList()!=null){
					
					length = pole.getMvPoleCctList().size();
					
					for(int i = 0;i<length;i++){
						MmsAddmvpolecct obj = pole.getMvPoleCctList().get(i);
						if(obj.getId() == null){
							nextId = poleMvCctDao.getNextPoleId("C_");
							System.out.println(nextId);
							String poleId = "C_"+nextId;
							MmsAddmvpolecctPK objPK = new MmsAddmvpolecctPK();
							objPK.setId(poleId);
							objPK.setPoleId(new Long(id));
							obj.setId(objPK);
							poleMvCctDao.addCct(obj);
							
						}else{
							poleMvCctDao.update(obj);
							error = "N";
						}
						try {
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							error = "Y" + e.getMessage();
						}
					}
				}
				
				return "Y L :" + length + "next ID : " + nextId +" error : "+error;
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N " + e.getMessage() + " L : " + length + " next ID : " + nextId + "error : "+ error;
			}

		}


		
		
		
		@RequestMapping(value = "/MMSUpdatePoleMVMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdatePoleMVMobile(@RequestBody MmsAddmvpole pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				poleMvDao.update(pole);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		@RequestMapping(value = "/MMSAddPoleMntMvMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddPoleMntMvMobile(@RequestBody MmsTxntowermaintenancemv mnt,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				mvMntDao.addTowerMaintananceData(mnt);
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		
		@RequestMapping(value = "/MMSUpdatePoleMntMVMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdatePoleMntMVMobile(@RequestBody MmsTxntowermaintenancemv mnt,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				mvMntDao.update(mnt);
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		@RequestMapping(value = "/findMVPoleById/{visitid}/{poleid}", method = RequestMethod.GET)
		public @ResponseBody MmsTxntowermaintenancemv findMVPoleById(@PathVariable("visitid") String visitid,@PathVariable("poleid") String poleid ) throws Exception {
			try {
				
				MmsTxntowermaintenancemvPK objPK = new MmsTxntowermaintenancemvPK();
				objPK.setPoleid(new Long(poleid));
				objPK.setVisitid(new Long(visitid));
				
				return mvMntDao.findById(objPK);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return null;
			}

		}

		
		@RequestMapping(value = "/MMSAddSaMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddSaMobile(@RequestBody MmsAddsurgearrestor sa,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				saDao.addSurgeArrestor(sa);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		@RequestMapping(value = "/MMSUpdateSaMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateSaMobile(@RequestBody MmsAddsurgearrestor sa,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				saDao.updateSurgeArrestor(sa);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		@RequestMapping(value = "/findSaByGantryId/{gantryId}", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddsurgearrestor> findSaByGantryId(@PathVariable("gantryId") String gantryId) throws Exception {
			try {
				return saDao.findByGantryId(gantryId);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		
		@RequestMapping(value = "/findSaByGantryIdSaId/{gantryId}/{saId}", method = RequestMethod.GET)
		public @ResponseBody MmsAddsurgearrestor findSaByGantryIdSaId(@PathVariable("gantryId") String gantryId ,@PathVariable("saId") String saId) throws Exception {
			MmsAddsurgearrestorPK objPk = new MmsAddsurgearrestorPK();
			objPk.setGantryId(new Long(gantryId));
			objPk.setSaId(saId);
			
			try {
				return saDao.findById(objPk);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		
		
		
		
		@RequestMapping(value = "/findSupportById/{id}", method = RequestMethod.GET)
		public @ResponseBody MmsAddsupport findSupportById(@PathVariable("id") String id) throws Exception {
			try {
				return addSupport.findById(new Long(id));
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		
		
		@RequestMapping(value = "/findSupportByAreaLineStatus/{area}/{line}/{status}", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddsupport> findSupportByAreaLineStatus(@PathVariable("area") String area,@PathVariable("line") String line,@PathVariable("status") String status) throws Exception {
			try {
				return addSupport.findByAreaLineStatus(area, line, status);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		

		
		


		@RequestMapping(value = "/MMSAddTransformerMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddTransformerMobile(@RequestBody MmsAddtransformer tr,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				trDao.addTransformer(tr);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		@RequestMapping(value = "/MMSUpdateTransformerMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateSaMobile(@RequestBody MmsAddtransformer sa,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				trDao.updateTransformer(sa);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		@RequestMapping(value = "/findTrByGantryId/{gantryId}", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddtransformer> findTrByGantryId(@PathVariable("gantryId") String gantryId) throws Exception {
			try {
				return trDao.findByGantryId(gantryId);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		
		@RequestMapping(value = "/findTrByGantryIdTrId/{gantryId}/{saId}", method = RequestMethod.GET)
		public @ResponseBody MmsAddtransformer findTrByGantryIdTrId(@PathVariable("gantryId") String gantryId ,@PathVariable("saId") String saId) throws Exception {
			MmsAddtransformerPK objPk = new MmsAddtransformerPK();
			objPk.setGantryId(new Long(gantryId));
			objPk.setTrId(saId);
			
			try {
				return trDao.findById(objPk);
				
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				
			}
			return null;
		}
		
		
		
		@RequestMapping(value = "/addMVPole", method = RequestMethod.GET)
		public ModelAndView MMSaddMVPole(HttpServletRequest request,@ModelAttribute("SaveMVPole") PivModel newmodel) {
			Map<String, String> lineList = new LinkedHashMap<String, String>();
            Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(province);
			PivModel model = new PivModel();
			List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
			
			
			List<String> provinces = new ArrayList<String>();
			int loop = province1.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = province1.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			
			// ModelAndView model = new ModelAndView();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			return new ModelAndView("MMS_addMVPole", "SaveMVPole", model);
			

		}



//add mv pole
			
			
			@RequestMapping(value = "/MMSaddmvpole", method = RequestMethod.POST)
			 public ModelAndView addFeeder(@ModelAttribute("SaveMVPole")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
				String deptId = (String) request.getSession().getAttribute("deptId");
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userRole = (String) request.getSession().getAttribute("loggedUserRole");
				String message = "Welcome to Spring 4.0 !";
				System.out.println("mvpole");
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		        String status = null;
				if (userLevel.equals("DEO")) {
					status = Util.IN_BULK;
				} else if (userLevel.equals("ES")) {
					status = Util.VALIDATION_ES;
				} else if (userLevel.equals("EE")) {
					status = Util.APPROVAL_EE;
				}
				model.getMvpole().setStatus(new BigDecimal(status));				
				Map<String, String> lineList = new LinkedHashMap<String, String>();
		        Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				try{
					System.out.println("poleid :" + model.getMvpole().getId());
					System.out.println("////////////////////////////////////");
					String resultobj = addMvPole.addPole(model.getMvpole());
					System.out.println("success");
					modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
				}
				catch(Exception e)
				{   System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
					System.out.print(e.getMessage());
				}
				
				PivModel newModel = new PivModel();
				//newModel.addAttribute("serverError", " saved Successfully !"); 
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				newModel.setProvinceList(provinceList);
				newModel.setAreaList(areaList);
				newModel.setLineList(lineList);
				
				
				
				return new ModelAndView("MMS_addMVPole", "SaveMVPole", newModel);
			}
			

		@RequestMapping(value = "/displayMVPolesNew", method = RequestMethod.GET)
			public ModelAndView displayGeneralNew(HttpServletRequest request,@ModelAttribute("UpdateMVPole") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("editMvPole", "UpdateMVPole", model);
				

			}

		@RequestMapping(value = "/findMvPoleByFeederId/{feederId}/",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsAddmvpole> getMvPoleByFeederId(@PathVariable("feederId") String feederId) {
			System.out.println("feederId ------>>>>>>> "+feederId);
			return addMvPole.getMvPoleByFeederId(feederId);
	}
		
		@RequestMapping(value = "/getMvPoleObj/{id}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody MmsAddmvpole findMvPoleById(@PathVariable("id") String id){
			return addMvPole.findById(id);
				
	    }
		
		
		
		@RequestMapping(value = "/MMSupdateMvPole", method = RequestMethod.POST)
		 public ModelAndView updateMvPole(@ModelAttribute("UpdateMVPole")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
			String deptId = (String) request.getSession().getAttribute("deptId");
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			String message = "Welcome to Spring 4.0 !";
			System.out.println("poleID "+ model.getMvpole().getId());
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	        String status = null;
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
			model.getMvpole().setStatus(new BigDecimal(status));
			try{
				MmsAddmvpole obj = new MmsAddmvpole();
				obj = addMvPole.findById(String.valueOf(model.getMvpole().getId()));
				System.out.println(obj.getPoleNo()+"]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
				model.getMvpole().setPoleNo(obj.getPoleNo());
				String resultobj = addMvPole.update(model.getMvpole());
				modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			Map<String, String> lineList = new LinkedHashMap<String, String>();
	        Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			
			
			PivModel newModel = new PivModel();
			//newModel.addAttribute("serverError", " saved Successfully !"); 
			String province = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(province);
			List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
			
			
			List<String> provinces = new ArrayList<String>();
			int loop = province1.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = province1.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			
			// ModelAndView model = new ModelAndView();
			newModel.setProvinceList(provinceList);
			newModel.setAreaList(areaList);
			newModel.setLineList(lineList);
			System.out.println("success");
			
			
			return new ModelAndView("editMvPole", "UpdateMVPole", newModel);
		}
		
		
		
		@RequestMapping(value = "/MMSAddLvFeederMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSAddLvFeederMobile(@RequestBody MmsAddlvfeeder lvFeader,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				lvFeaderDao.addFeeder(lvFeader);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		@RequestMapping(value = "/MMSUpdateLvFeederMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdateLvFeederMobile(@RequestBody MmsAddlvfeeder lvFeader,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				lvFeaderDao.updateFeeder(lvFeader);
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		@RequestMapping(value = "/getNextLVFeederId", method = RequestMethod.GET)
		public @ResponseBody String getNextFeederId(){
			String nextId = lvFeaderDao.getNextFeerderId("L_");
			System.out.println(nextId);
			String feederId = "L_"+nextId;
			return feederId;
		}
		
		
		@RequestMapping(value = "/getSummaryGantry", method = RequestMethod.GET)
		public @ResponseBody List<Object[]> getSummaryGantry(HttpServletRequest request){
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			return gantryDao.getSummaryGantry(deptId);
			
		}
		
		@RequestMapping(value = "/uploadSupportImage", method = RequestMethod.GET)
		public ModelAndView uploadSupportImage(HttpServletRequest request) {

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
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
			}
			
			Map<String,String> cycle = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
			int cycleLisuCount = cycleList.size()-1;
			for(int i=0;i<=cycleLisuCount;i++){ 
				//System.out.println(i);
				MvmmsCycle ojb = cycleList.get(i);
				cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
		      
		    } 
			model.setCycleList(cycle);
			
			model.setSupTypeList(supportTypeList);
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			// model.setMode(mode);
			return new ModelAndView("uploadSupportImage", "model", model);

		}

		
		
		@RequestMapping(value = "/uploadSupportImageS", method = RequestMethod.POST)
		public ModelAndView uploadSupportImageS(HttpServletRequest request,@RequestParam("file1") MultipartFile file,@ModelAttribute("SaveGeneral")  PivModel model, BindingResult bindingResult, HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap) {
			System.out.println("hii : "+ model);
			System.out.println("hii2 : "+ model.getSupportObj());
			System.out.println("hii3 : "+ model.getSupportObj().getId());
			System.out.println("file : "+ file.getOriginalFilename());
			
			System.out.println("file : "+ file.getOriginalFilename());
			
			String path = PathMMS.getReportPath();
    		File dir = new File(path + File.separator + "EmailAttachment");
    		if (!dir.exists())
    			dir.getParentFile().mkdirs(); 
				//dir.mkdirs();
    		String name = "";
    		String cyclex= "";
			File serverFile = null;
    		if (!file.isEmpty()) {
				try {
					name = file.getOriginalFilename();
					System.out.println("file name : "+ name );
					
					byte[] bytes = file.getBytes();
					String extension = Util.getSubStringLastPart(name,".");

					cyclex=model.getCycleObj().getId().getCycleId();
					
					name = cyclex +"-"+model.getSupportObj().getId()+extension ;
					//appr.setFilename1(name);
					
					//dir.getParentFile().mkdirs(); 
					serverFile = new File(dir.getAbsolutePath()+ File.separator + name);

					serverFile.getParentFile().mkdirs(); 
					serverFile.createNewFile();

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
					
					
					
					
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		
    		

    		MmsAddsupport obj =  addSupport.findById(model.getSupportObj().getId());
    		if(obj != null){
    			obj.setFilepath(name);
    			addSupport.update(obj);
    		}
    		
    		System.out.println("cyclex :"+cyclex);
    		
    		System.out.println("id :"+model.getSupportObj().getId());
    		
    		MmsTxntowermaintenancePK objMntPK = new MmsTxntowermaintenancePK();
    		objMntPK.setTowerid(model.getSupportObj().getId());
    		objMntPK.setVisitid(new Long(cyclex));
    		MmsTxntowermaintenance objMnt = towerTxtMaintenance.findByID(objMntPK);
    		System.out.println("objMnt :"+objMnt);
    		if(objMnt != null){
    			objMnt.setFlashoversetno(name);
    			towerTxtMaintenance.update(objMnt);
    		}
    		Map<String, String> lineList = new LinkedHashMap<String, String>();
			System.out.println("hi");
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> support = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			System.out.println("hi1 : " + deptId);
			String province = deptDao.getDD(deptId);
			System.out.println("hi2 : " + province);
			String distDiv = glcompmDao.getDistDivision(model.getGlcompmobj().getCompId());
			System.out.println("hi3 : " + distDiv);
			PivModel modelobj = new PivModel();
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			List<Gldeptm> deptTm = gldeptDao.getArea(model.getGlcompmobj().getCompId());
			List<MmsAddsupporttype> supType = supTypeDao.findAll();
			List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
			List<MmsAddsupport> supportList = addSupport.findByArea(String.valueOf(model.getGldeptobj().getDeptId()),String.valueOf(model.getLine().getId()));
			
			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				//System.out.println(i);
				Glcompm ojb = line.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

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
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
			}
			
			int supLoop = supportList.size() - 1;
			for (int i = 0; i <= supLoop; i++) {
				//System.out.println(i);
				MmsAddsupport ojb = supportList.get(i);
				support.put(String.valueOf(ojb.getId()), ojb.getTowerNo());
			}
			
			Map<String,String> cycle = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
			int cycleLisuCount = cycleList.size()-1;
			for(int i=0;i<=cycleLisuCount;i++){ 
				//System.out.println(i);
				MvmmsCycle ojb = cycleList.get(i);
				cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
		      
		    } 
			model.setCycleList(cycle);
			
			
			
			
			//model.setSupTypeList(model.getSupTypeList());
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSupportList(support);
			model.setMode("Successfully Uploaded");
			
			modelmap.addAttribute("SUCCESS_MESSAGE", "Uploaded Successfully");
			return new ModelAndView("uploadSupportImage", "model", model);
			//modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
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