package com.it.piv.myceb.repo;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.it.piv.myceb.domain.JobAssign;
import com.it.piv.myceb.domain.JobStatusOmsNew;


public interface JobAssignDao {
	public List<JobAssign> findComByAcCd(String accessCode);
	public List<JobAssign> findComByStatus(String accessCode,String status);
	public List<JobAssign> findJobByJobNum(String jobNo);
	public List<JobAssign> findJobByAreaCode(String area);
	public List<JobAssign> getAll();
	public void addCommet(JobAssign obj);
	public void addCommet(String id,String com);
	public void updateStatus(String id,String status);
	public void statusUpdateForBD(String refNo,String userlog,String status_from,String status_to,String comment,String expTime);
	public void updateFailureCause(String refNo,String userlog,String action,String cause,String detail,String type,String comment);
	public List<JobStatusOmsNew> getAllBreakDownStatus();
	public List<JobStatusOmsNew> getAllBreakDownStatus(String refNo);
	public List<JobStatusOmsNew> getAllBreakDownbyUser(String user);
	public void assignJob(JobAssign obj);
	public void addComToVehicle(String comNo,String lon, String lat, String userlog,String priority, String comment,String areaCode);
		
}
