package com.it.piv.mms.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsAddearthconductortype;
import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsAddinsulatortype;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddlinetype;
import com.it.piv.mms.domain.MmsAddstatus;
import com.it.piv.mms.domain.MmsAddstatustype;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MmsAddtowerconfiguration;
import com.it.piv.mms.domain.MmsAddtowerinsulator;
import com.it.piv.mms.domain.MmsTowertype;
import com.it.piv.mms.domain.Msttowertype;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.domain.MvmmsCyclePK;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.MMSAddgantryDao;
import com.it.piv.mms.repo.MmsAddConductorTypeDao;
import com.it.piv.mms.repo.MmsAddEarthConductorTypeDao;
import com.it.piv.mms.repo.MmsAddInsulatorTypeDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsAddLineTypeDao;
import com.it.piv.mms.repo.MmsAddStatusDao;
import com.it.piv.mms.repo.MmsAddStatusTypeDao;
import com.it.piv.mms.repo.MmsAddSupportTypeDao;
import com.it.piv.mms.repo.MmsAddTowerConfigDao;
import com.it.piv.mms.repo.MmsAddTowerInsulatorDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MsttowertypeDao;
import com.it.piv.mms.repo.MvmmsCycleDao;

@Controller
public class MmsLineMasterDataController {

	@Autowired
	private MmsAddLineTypeDao lineType;
	@Autowired
	private MmsAddSupportTypeDao supportType;
	@Autowired
	private MmsAddConductorTypeDao conductorType;
	@Autowired
	private MmsAddEarthConductorTypeDao earthConType;
	@Autowired
	private MmsAddInsulatorTypeDao insulatorType;
	@Autowired
	private MmsAddTowerConfigDao towerConfig;
	@Autowired
	private MmsAddTowerInsulatorDao towerInsulator;
	@Autowired
	private MmsAddStatusTypeDao statusType;
	@Autowired
	private MmsAddStatusDao status;

	@Autowired
	private MmsAddLineDao line;
	
	
	@Autowired
	private MmsSupportDao support;

	@Autowired
	private GldeptmDao gldeptDao;

	@Autowired
	private MsttowertypeDao towerTypeDao;
	
	@Autowired
	private MvmmsCycleDao mvmmsCycleDao;
	
	@Autowired
	private MMSAddgantryDao gantryDao;

	// add Line Type

	@RequestMapping(value = "/addLineType", method = RequestMethod.GET)
	public ModelAndView MMSAddLineType(
			@ModelAttribute("MmsAddlinetype") MmsAddlinetype newLineType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addLineType", "message", message);
	}

	@RequestMapping(value = "/MMSAddLinetype", method = RequestMethod.POST)
	public ModelAndView AddLineType(
			@ModelAttribute("MmsAddlinetype") MmsAddlinetype newLineType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = lineType.addLineType(newLineType);

			return new ModelAndView("MMS_addLineType", "message", message);
		} else {

			return new ModelAndView("MMS_addLineType", "message", message);
		}
	}

	@RequestMapping(value = "/findAllLineTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddlinetype> getLinetypes() {
		return lineType.findAll();
	}

	@RequestMapping(value = "/findActiveLineTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddlinetype> getActiveLinetypes() {
		// MMSaddLine
		return lineType.findActiveTypes();
	}

	// add Support Type

	@RequestMapping(value = "/addSupportType", method = RequestMethod.GET)
	public ModelAndView MMSAddSupportType(
			@ModelAttribute("SaveSupportType") MmsAddsupporttype newSupportType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addSupportType", "message", message);
	}

	@RequestMapping(value = "/MMSAddSupportType", method = RequestMethod.POST)
	public ModelAndView AddSupportType(
			@ModelAttribute("SaveSupportType") MmsAddsupporttype newSupportType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = supportType.addSupportType(newSupportType);

			return new ModelAndView("MMS_addSupportType", "message", message);
		} else {

			return new ModelAndView("MMS_addSupportType", "message", message);
		}
	}

	@RequestMapping(value = "/findAllSupportTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupporttype> getSupportTypes() {
		return supportType.findAll();
	}

	// add Conductor Type

	@RequestMapping(value = "/addConductorType", method = RequestMethod.GET)
	public ModelAndView MMSAddConductorType(
			@ModelAttribute("SaveConductorType") MmsAddconductortype newConductorType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addConductorType", "message", message);
	}

	@RequestMapping(value = "/MMSAddConductorType", method = RequestMethod.POST)
	public ModelAndView AddConductorType(
			@ModelAttribute("SaveConductorType") MmsAddconductortype newConductorType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = conductorType.addConductorType(newConductorType);

			return new ModelAndView("MMS_addConductorType", "message", message);
		} else {

			return new ModelAndView("MMS_addConductorType", "message", message);
		}
	}

	@RequestMapping(value = "/findAllConductorTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddconductortype> getConductorTypes() {
		return conductorType.findAll();
	}

	@RequestMapping(value = "/findAllTowerType", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsTowertype> findAllTowerType() {
		return towerTypeDao.findAll();
	}

	@RequestMapping(value = "/findActiveConductorTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddconductortype> getActiveConductorTypes() {
		return conductorType.findActiveConductorTypes();
	}

	// add Earth Conductor Type

	@RequestMapping(value = "/addEarthConType", method = RequestMethod.GET)
	public ModelAndView MMSAddEarthConductorType(
			@ModelAttribute("SaveEarthConType") MmsAddearthconductortype newEarthConType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addEarthConType", "message", message);
	}

	@RequestMapping(value = "/MMSAddEarthConType", method = RequestMethod.POST)
	public ModelAndView AddEarthConductorType(
			@ModelAttribute("SaveEarthConType") MmsAddearthconductortype newEarthConType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = earthConType.addEarthConType(newEarthConType);

			return new ModelAndView("MMS_addEarthConType", "message", message);
		} else {

			return new ModelAndView("MMS_addEarthConType", "message", message);
		}
	}

	@RequestMapping(value = "/findAllEarthConductorTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddearthconductortype> getEarthConductorTypes() {
		return earthConType.findAll();
	}

	@RequestMapping(value = "/findActiveEarthTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddearthconductortype> getActiveEarthTypes() {
		return earthConType.findActiveEarth();
	}

	// add Insulator Type

	@RequestMapping(value = "/addInsulatorType", method = RequestMethod.GET)
	public ModelAndView MMSAddInsulatorType(
			@ModelAttribute("SaveInsulatorType") MmsAddinsulatortype newInsulator,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addInsulator", "message", message);
	}

	@RequestMapping(value = "/MMSAddInsulatorType", method = RequestMethod.POST)
	public ModelAndView AddInsulatorType(
			@ModelAttribute("SaveInsulatorType") MmsAddinsulatortype newInsulator,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = insulatorType.addInsulatorType(newInsulator);

			return new ModelAndView("MMS_addInsulator", "message", message);
		} else {

			return new ModelAndView("MMS_addInsulator", "message", message);
		}
	}

	@RequestMapping(value = "/findAllInsulatorTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddinsulatortype> getInsulatorTypes() {
		return insulatorType.findAll();
	}

	// add Tower Configuration

	@RequestMapping(value = "/addTowerConfig", method = RequestMethod.GET)
	public ModelAndView MMSAddTowerConfig(
			@ModelAttribute("SaveTowerConfig") MmsAddtowerconfiguration towerCon,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addTowerConfiguration", "message", message);
	}

	@RequestMapping(value = "/MMSAddTowerConfig", method = RequestMethod.POST)
	public ModelAndView AddTowerConfig(
			@ModelAttribute("SaveTowerConfig") MmsAddtowerconfiguration towerCon,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = towerConfig.addTowerConfiguration(towerCon);

			return new ModelAndView("MMS_addTowerConfiguration", "message",
					message);
		} else {

			return new ModelAndView("MMS_addTowerConfiguration", "message",
					message);
		}
	}

	@RequestMapping(value = "/findAllTowerConfig", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddtowerconfiguration> getTowerConfig() {
		return towerConfig.findAll();
	}

	@RequestMapping(value = "/findActiveTowerConfig", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddtowerconfiguration> getActiveTowerConfig() {
		return towerConfig.findActiveConfigurations();
	}

	// add Tower Insulator

	@RequestMapping(value = "/addTowerInsulator", method = RequestMethod.GET)
	public ModelAndView MMSAddTowerInsulator(
			@ModelAttribute("SaveTowerInsulator") MmsAddtowerinsulator towerIns,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addTowerInsulator", "message", message);
	}

	@RequestMapping(value = "/MMSAddTowerInsulator", method = RequestMethod.POST)
	public ModelAndView AddTowerInsulator(
			@ModelAttribute("SaveTowerInsulator") MmsAddtowerinsulator towerIns,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = towerInsulator.addTowerInsulator(towerIns);

			return new ModelAndView("MMS_addTowerInsulator", "message", message);
		} else {

			return new ModelAndView("MMS_addTowerInsulator", "message", message);
		}
	}

	@RequestMapping(value = "/findAllTowerInsulators", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddtowerinsulator> getTowerInsulators() {
		return towerInsulator.findAll();
	}

	// add Status Type

	@RequestMapping(value = "/addStatusType", method = RequestMethod.GET)
	public ModelAndView MMSAddStatusType(
			@ModelAttribute("SaveStatusType") MmsAddstatustype statustype,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addStatusType", "message", message);
	}

	@RequestMapping(value = "/MMSAddStatusType", method = RequestMethod.POST)
	public ModelAndView AddStatusType(
			@ModelAttribute("SaveStatusType") MmsAddstatustype statustype,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = statusType.addStatusType(statustype);

			return new ModelAndView("MMS_addStatusType", "message", message);
		} else {

			return new ModelAndView("MMS_addStatusType", "message", message);
		}
	}

	@RequestMapping(value = "/findAllStatusTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddstatustype> getStatusTypes() {
		return statusType.findAll();
	}

	@RequestMapping(value = "/findActiveStatusTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddstatustype> getActiveStatusTypes() {
		return statusType.findActiveStatusTypes();
	}

	// add Status

	@RequestMapping(value = "/addStatus", method = RequestMethod.GET)
	public ModelAndView MMSAddStatus(
			@ModelAttribute("SaveStatus") MmsAddstatus addstatus,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addStatus", "message", message);
	}

	@RequestMapping(value = "/MMSAddStatus", method = RequestMethod.POST)
	public ModelAndView AddStatus(
			@ModelAttribute("SaveStatus") MmsAddstatus addstatus,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {

			String resultobj = status.addStatus(addstatus);

			return new ModelAndView("MMS_addStatus", "message", message);
		} else {

			return new ModelAndView("MMS_addStatus", "message", message);
		}
	}

	@RequestMapping(value = "/findAllStatus", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddstatus> getStatus() {
		return status.findAll();
	}

	@RequestMapping(value = "/findAllLine", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> getLineFromLine(
			HttpServletRequest request) {
		String deptId = (String) request.getSession().getAttribute("deptId");

		return line.findAll();
	}

	@RequestMapping(value = "/findAllLineByStatus", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> findAllLineByStatus(
			@RequestParam("status") String status, HttpServletRequest request) {
		System.out.println("ddddd");
		String deptId = (String) request.getSession().getAttribute("deptId");

		return line.findLineByStatus(status, deptId);
	}
	
	@RequestMapping(value = "/findAllLineByStatusNew", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> findAllLineByStatusNew(HttpServletRequest request) {
		System.out.println("ddddd");
		String deptId = (String) request.getSession().getAttribute("deptId");

		return line.findLineByStatus("1", deptId);
	}
	
	@RequestMapping(value = "/findAllLineMobile/{phmbranch}/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> findAllLineMobile(@RequestParam("phmbranch") String phmbranch) {
		System.out.println("ddddd");
		//String deptId = (String) request.getSession().getAttribute("deptId");

		return line.findLineByStatus("1", phmbranch);
	}

	
	


	@RequestMapping(value = "/findLineById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsAddline findLineById(@PathVariable("id") String id) {
		return line.findById(id);
	}

	@RequestMapping(value = "/findSupoortById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsAddsupport findSupportById(
			@PathVariable("id") long id) {
		return support.findById(id);
	}

	@RequestMapping(value = "/findAllAreaByProvince", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gldeptm> findAllArea() {
		String deptid = "";
		return gldeptDao.getArea(deptid);
	}

	@RequestMapping(value = "/findAllAreaByProvinceNew/{province}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gldeptm> findAllArea(
			@PathVariable("province") String province) {
		String deptid = "";
		return gldeptDao.getAreaByProvince(province);
	}
	
	@RequestMapping(value = "/findAllAreaByProvinceNewNew/{province}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gldeptm> findAllAreaByProvinceNewNew(
			@PathVariable("province") String province) {
		String deptid = "";
		return gldeptDao.getAreaByProvince(province);
	}


	// edit anushka 2018-12-31---------------------------------------------------------------------------------------------------------------------------------
	
	//edit line type
	@RequestMapping("/editLineType")
	public ModelAndView editLineType() {
		List<MmsAddlinetype> LineType = lineType.findAll();
		return new ModelAndView("editLineType", "LineType", LineType);
	}
	
	
	
	//update line type
	@RequestMapping(value = "/updateLineType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddlinetype obj = new MmsAddlinetype();
		obj.setLineType(name);
		obj.setId(id);
		obj.setStatus(status);
		lineType.updateLineType(obj);
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------------------

	// edit anushka 2019-01-01---------------------------------------------------------------------------------------------------------------------------------
	
	//edit support types
	@RequestMapping("/editSupportType")
	public ModelAndView editSupportType() {
		List<MmsAddsupporttype> SupportType = supportType.findAll();
		return new ModelAndView("editSupportType", "SupportType", SupportType);
	}
	//update support type
	@RequestMapping(value = "/updateSupportType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupportType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddsupporttype obj = new MmsAddsupporttype();
		obj.setSupportType(name);
		obj.setId(id);
		obj.setStatus(status);
		supportType.updateSupportType(obj);
	}
	
	//edit conductor type
	@RequestMapping("/editConductorType")
	public ModelAndView editConductorType() {
		List<MmsAddconductortype> ConductorType = conductorType.findAll();
		return new ModelAndView("editConductorType", "ConductorType", ConductorType);
	}
	//update conductor type
	@RequestMapping(value = "/updateConductorType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateConductorType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddconductortype obj = new MmsAddconductortype();
		obj.setType(name);
		obj.setId(id);
		obj.setStatus(status);
		conductorType.updateConductorType(obj);
	}
	
	//edit earth conductor type
	@RequestMapping("/editEarthConductorType")
	public ModelAndView editEarthConductorType() {
		List<MmsAddearthconductortype> EarthConductorType = earthConType.findAll();
		return new ModelAndView("editEarthConductorType", "EarthConductorType", EarthConductorType);
	}
	//update earth conductor type
	@RequestMapping(value = "/updateEarthConductorType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateEarthConductorType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddearthconductortype obj = new MmsAddearthconductortype();
		obj.setType(name);
		obj.setId(id);
		obj.setStatus(status);
		earthConType.updateEarthConductorType(obj);
	}
	
	//edit insulator type
	@RequestMapping("/editInsulatorType")
	public ModelAndView editInsulatorType() {
		List<MmsAddinsulatortype> InsulatorType = insulatorType.findAll();
		return new ModelAndView("editInsulatorType", "InsulatorType", InsulatorType);
	}
	//update insulator type
	@RequestMapping(value = "/updateInsulatorType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateInsulatorType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddinsulatortype obj = new MmsAddinsulatortype();
		obj.setType(name);
		obj.setId(id);
		obj.setStatus(status);
		insulatorType.updateInsulatorType(obj);
	}
	
	//edit tower configuration type
	@RequestMapping("/editTowerConfigurationType")
	public ModelAndView editTowerConfigurationType() {
		List<MmsAddtowerconfiguration> TowerConfigurationType = towerConfig.findAll();
		return new ModelAndView("editTowerConfigurationType", "TowerConfigurationType", TowerConfigurationType);
	}
	//update tower configuration type
	@RequestMapping(value = "/updateTowerConfigurationType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateTowerConfigurationType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddtowerconfiguration obj = new MmsAddtowerconfiguration();
		obj.setName(name);
		obj.setId(id);
		obj.setStatus(status);
		towerConfig.updateTowerConfigurationType(obj);
	}
	
	//edit tower insulator type
	@RequestMapping("/editTowerInsulatorType")
	public ModelAndView editTowerInsulatorType() {
		List<MmsAddtowerinsulator> TowerInsulatorType = towerInsulator.findAll();
		return new ModelAndView("editTowerInsulatorType", "TowerInsulatorType", TowerInsulatorType);
	}
	//update tower insulator type
	@RequestMapping(value = "/updateTowerInsulatorType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateTowerInsulatorType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddtowerinsulator obj = new MmsAddtowerinsulator();
		obj.setName(name);
		obj.setId(id);
		obj.setStatus(status);
		towerInsulator.updateTowerInsulatorType(obj);
	}
	
	//edit status type
	@RequestMapping("/editStatusType")
	public ModelAndView editStatusType() {
		List<MmsAddstatustype> StatusType = statusType.findAll();
		return new ModelAndView("editStatusType", "StatusType", StatusType);
	}
	//update status type
	@RequestMapping(value = "/updateStatusType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateStatusType(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String status) {
		MmsAddstatustype obj = new MmsAddstatustype();
		obj.setType(name);
		obj.setId(id);
		obj.setStatus(status);
		statusType.updateStatusType(obj);
	}
	
	//edit status
	@RequestMapping("/editStatus")
	public ModelAndView editStatus() {
		List<MmsAddstatus> Status = status.findAll();
		return new ModelAndView("editStatus", "Status", Status);
	}
	//update status
	@RequestMapping(value = "/updateStatus/{name}/{id}/{status}/{type}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateStatus(@PathVariable("name") String name,
			@PathVariable("id") String id, @PathVariable("status") String statuss, @PathVariable("type") String type) {
		MmsAddstatus obj = new MmsAddstatus();
		obj.setType(type);
		obj.setId(id);
		obj.setStatus(statuss);
		obj.setName(name);
		status.updateStatus(obj);
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/addCycle", method = RequestMethod.GET)
	public ModelAndView addCycle(
			@ModelAttribute("MmsCycle") MvmmsCycle cycle,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addCycle", "message", message);
	}
	
	@RequestMapping(value = "/addIntCycle", method = RequestMethod.GET)
	public ModelAndView addIntCycle(
			@ModelAttribute("MmsCycle") MvmmsCycle cycle,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addIntCycle", "message", message);
	}
	
	
	@RequestMapping(value = "/MMSAddCycle", method = RequestMethod.POST)
	public ModelAndView MMSAddCycle(
			@ModelAttribute("MmsCycle") MvmmsCycle newCycle,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {
			String deptId = (String) request.getSession().getAttribute("deptId");
			newCycle.getId().setDeptId(deptId);
			mvmmsCycleDao.addCycle(newCycle);
			return new ModelAndView("MMS_addCycle", "message", message);
		} else {

			return new ModelAndView("MMS_addCycle", "message", message);
		}
	}
	
	
	@RequestMapping(value = "/MMSAddIntCycle", method = RequestMethod.POST)
	public ModelAndView MMSAddIntCycle(
			@ModelAttribute("MmsCycle") MvmmsCycle newCycle,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		if (!bindingResult.hasErrors()) {
			String deptId = (String) request.getSession().getAttribute("deptId");
			newCycle.getId().setDeptId(deptId);
			mvmmsCycleDao.addCycle(newCycle);
			return new ModelAndView("MMS_addIntCycle", "message", message);
		} else {

			return new ModelAndView("MMS_addIntCycle", "message", message);
		}
	}

	
	
	@RequestMapping(value = "/findAllCycle", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MvmmsCycle> findAllCycle(	HttpServletRequest request) {
		String deptId = (String) request.getSession().getAttribute("deptId");
		
		return mvmmsCycleDao.findAllActiveCycle(deptId);
	}
	
	@RequestMapping(value = "/findAllCycleMobile", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MvmmsCycle> findAllCycleMobile(HttpServletRequest request,@RequestParam("deptid") String dpId) {
		//String deptId = (String) request.getSession().getAttribute("deptId");
		
		return mvmmsCycleDao.findAllActiveCycle(dpId.trim());
	}
	
	
	//edit line type
		@RequestMapping("/editCycle")
		public ModelAndView editCycle(HttpServletRequest request) {
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			List<MvmmsCycle> cycle = mvmmsCycleDao.findAllActiveCycle(deptId);
			return new ModelAndView("editCycle", "cycle", cycle);
		}
		
		@RequestMapping("/editIntCycle")
		public ModelAndView editIntCycle(HttpServletRequest request) {
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			List<MvmmsCycle> cycle = mvmmsCycleDao.findAllActiveCycle(deptId);
			return new ModelAndView("editIntCycle", "cycle", cycle);
		}
		
		@RequestMapping(value = "/updatecycle/{id}/{name}/{order}/{status}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updatecycle(HttpServletRequest request,@PathVariable("id") String id,@PathVariable("name") String name,@PathVariable("order") String order, @PathVariable("status") String status) {
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			try {
				MvmmsCycle obj = new MvmmsCycle();
				MvmmsCyclePK objPK = new MvmmsCyclePK();
				objPK.setCycleId(id);
				objPK.setDeptId(deptId);
				obj.setId(objPK);
				obj.setCycleName(name);
				obj.setCycleOrder(new BigDecimal(order));
				obj.setStatus(new BigDecimal(status));
				mvmmsCycleDao.update(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		@RequestMapping(value = "/findAllCSCByArea/{area}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Gldeptm> findAllCSCByArea(@PathVariable("area") String area) {
			System.out.println("area :" + area);
			return gldeptDao.getCscByArea(area);
		}
		
		@RequestMapping(value = "/findGantryByAreaLine/{area}/{line}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsAddgantry> findGantryByAreaLine(@PathVariable("area") String area,@PathVariable("line") String line) {
			System.out.println("area :" + area);
			return gantryDao.getGantryByLineArea(line, area);
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
