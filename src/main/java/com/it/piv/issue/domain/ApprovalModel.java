package com.it.piv.issue.domain;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.domain.SausermMm;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PivDetail;
import com.it.piv.mms.domain.Spstdestdmt;
import com.it.piv.mms.domain.SpstdestdmtModel;
import com.it.piv.mms.domain.Spstdesthmt;
import com.it.piv.mms.domain.WiringLandDetail;
import com.it.piv.mms.domain.WiringLandDetailCon;

public class ApprovalModel implements Serializable{
	
private List<ApprovalMm> attachmentList;
private List<ApprovalMm> attachmentListWE;

private long gantryid;

public long getGantryid() {
	return gantryid;
}

public void setGantryid(long gantryid) {
	this.gantryid = gantryid;
}

private MmsAddgantry gantry;

public MmsAddgantry getGantry() {
	return gantry;
}

public void setGantry(MmsAddgantry gantry) {
	this.gantry = gantry;
}

public List<ApprovalMm> getAttachmentListWE() {
	return attachmentListWE;
}

public void setAttachmentListWE(List<ApprovalMm> attachmentListWE) {
	this.attachmentListWE = attachmentListWE;
}

private SpstdesthmtModel spstdesthmtModel;
	
private List<SpstdestdmtModel> spstdestdmtModel;
	
	public List<SpstdestdmtModel> getSpstdestdmtModel() {
	return spstdestdmtModel;
}

public void setSpstdestdmtModel(List<SpstdestdmtModel> spstdestdmtModel) {
	this.spstdestdmtModel = spstdestdmtModel;
}

	public SpstdesthmtModel getSpstdesthmtModel() {
	return spstdesthmtModel;
}

public void setSpstdesthmtModel(SpstdesthmtModel spstdesthmtModel) {
	this.spstdesthmtModel = spstdesthmtModel;
}

	public List<ApprovalMm> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<ApprovalMm> attachmentList) {
		this.attachmentList = attachmentList;
	}

	private List<Approval> approvalHistoryList;
	private List<Approval> approvalHistoryListWE;
	
	
	public List<Approval> getApprovalHistoryListWE() {
		return approvalHistoryListWE;
	}

	public void setApprovalHistoryListWE(List<Approval> approvalHistoryListWE) {
		this.approvalHistoryListWE = approvalHistoryListWE;
	}

	public List<Approval> getApprovalHistoryList() {
		return approvalHistoryList;
	}

	public void setApprovalHistoryList(List<Approval> approvalHistoryList) {
		this.approvalHistoryList = approvalHistoryList;
	}

	
	private String  error;
	
	private WiringLandDetail wlObj;
	private WiringLandDetailCon wlConObj;
	
	private List<Spstdestdmt> spdmtList;
	public List<Spstdestdmt> getSpdmtList() {
		return spdmtList;
	}

	public void setSpdmtList(List<Spstdestdmt> spdmtList) {
		this.spdmtList = spdmtList;
	}

	public WiringLandDetailCon getWlConObj() {
		return wlConObj;
	}

	public void setWlConObj(WiringLandDetailCon wlConObj) {
		this.wlConObj = wlConObj;
	}

	public WiringLandDetail getWlObj() {
		return wlObj;
	}

	public void setWlObj(WiringLandDetail wlObj) {
		this.wlObj = wlObj;
	}

	private Application application;
	
	private List<PivDetail> pivList;
	
	private List<PivDetail> pivEstList;
	
	
	public List<PivDetail> getPivEstList() {
		return pivEstList;
	}

	public void setPivEstList(List<PivDetail> pivEstList) {
		this.pivEstList = pivEstList;
	}

	public List<PivDetail> getPivList() {
		return pivList;
	}

	public void setPivList(List<PivDetail> pivList) {
		this.pivList = pivList;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	private Applicant applicant;
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	private String comment;
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	private String sendforvalidation;

	public String getSendforvalidation() {
		return sendforvalidation;
	}

	public void setSendforvalidation(String sendforvalidation) {
		this.sendforvalidation = sendforvalidation;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	private Spstdestdmt spstdestdmt;
	private MmsAddsupport support;
	private MmsTxntowermaintenance mnt;
	public MmsTxntowermaintenance getMnt() {
		return mnt;
	}

	public void setMnt(MmsTxntowermaintenance mnt) {
		this.mnt = mnt;
	}

	public MmsAddsupport getSupport() {
		return support;
	}

	public void setSupport(MmsAddsupport support) {
		this.support = support;
	}

	private MmsAddline line;
	public MmsAddline getLine() {
		return line;
	}

	public void setLine(MmsAddline line) {
		this.line = line;
	}

	public Spstdestdmt getSpstdestdmt() {
		return spstdestdmt;
	}

	public void setSpstdestdmt(Spstdestdmt spstdestdmt) {
		this.spstdestdmt = spstdestdmt;
	}

	private Spstdesthmt spstdesthmt;
	
	public Spstdesthmt getSpstdesthmt() {
		return spstdesthmt;
	}

	public void setSpstdesthmt(Spstdesthmt spstdesthmt) {
		this.spstdesthmt = spstdesthmt;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private String  success;
	
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	private Sauserm user;
	
	private List<SausermMm> userMm;
	
	
	public List<SausermMm> getUserMm() {
		return userMm;
	}

	public void setUserMm(List<SausermMm> userMm) {
		this.userMm = userMm;
	}

	private List<Sauserm> userList;
	
	
	
	public List<Sauserm> getUserList() {
		return userList;
	}

	public void setUserList(List<Sauserm> userList) {
		this.userList = userList;
	}

	public Sauserm getUser() {
		return user;
	}

	public void setUser(Sauserm user) {
		this.user = user;
	}

	private SausermMm usermm;
	
	
	public SausermMm getUsermm() {
		return usermm;
	}

	public void setUsermm(SausermMm usermm) {
		this.usermm = usermm;
	}

	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	//private List<PcesthttModel> listPcesthmtModel;
	
	
	
	
	private List<PcesthttModel> listPcesthttModel;
	

	public List<PcesthttModel> getListPcesthttModel() {
		return listPcesthttModel;
	}

	public void setListPcesthttModel(List<PcesthttModel> listPcesthttModel) {
		this.listPcesthttModel = listPcesthttModel;
	}

	private List<PcestdttModel> listPcestdttModel;
	
	private PcesthttModel pcesthttModel;
	
	public PcesthttModel getPcesthttModel() {
		return pcesthttModel;
	}

	public void setPcesthttModel(PcesthttModel pcesthttModel) {
		this.pcesthttModel = pcesthttModel;
	}

	public List<PcestdttModel> getListPcestdttModel() {
		return listPcestdttModel;
	}

	public void setListPcestdttModel(List<PcestdttModel> listPcestdttModel) {
		this.listPcestdttModel = listPcestdttModel;
	}

	private List<Object[]> listObject;
	
	public List<Object[]> getListObject() {
		return listObject;
	}

	public void setListObject(List<Object[]> listObject) {
		this.listObject = listObject;
	}

	private Pcesthtt pcesthttObj;
	
	public Pcesthtt getPcesthttObj() {
		return pcesthttObj;
	}

	public void setPcesthttObj(Pcesthtt pcesthttObj) {
		this.pcesthttObj = pcesthttObj;
	}

	private List<ApprovalMm> approvalList;
	
	private List<Pcestdtt> pcestdttList;

private ApprovalMm approvalMmObj;

	public ApprovalMm getApprovalMmObj() {
	return approvalMmObj;
}

public void setApprovalMmObj(ApprovalMm approvalMmObj) {
	this.approvalMmObj = approvalMmObj;
}

	public List<Pcestdtt> getPcestdttList() {
		return pcestdttList;
	}

	public void setPcestdttList(List<Pcestdtt> pcestdttList) {
		this.pcestdttList = pcestdttList;
	}

	public List<ApprovalMm> getApprovalList() {
		return approvalList;
	}

	public void setApprovalList(List<ApprovalMm> approvalList) {
		this.approvalList = approvalList;
	}
	
	
	
	private List<Pcesthtt> pcesthttList;

	private List<Spstdesthmt> stdList;


public List<Spstdesthmt> getStdList() {
		return stdList;
	}

	public void setStdList(List<Spstdesthmt> stdList) {
		this.stdList = stdList;
	}

public List<Pcesthtt> getPcesthttList() {
		return pcesthttList;
	}

	public void setPcesthttList(List<Pcesthtt> pcesthttList) {
		this.pcesthttList = pcesthttList;
	}

private List<Pcesthmt> pcesthmtList;

private List<String> estimateList;
Map<String, String> eeList = new LinkedHashMap<String, String>();
public String mode;
public String getMode() {
	return mode;
}

public void setMode(String mode) {
	this.mode = mode;
}

public Map<String, String> getEeList() {
	return eeList;
}

public void setEeList(Map<String, String> eeList) {
	this.eeList = eeList;
}

private Sauserm sausermEE;
private String ee;


public String getEe() {
	return ee;
}

public void setEe(String ee) {
	this.ee = ee;
}

public Sauserm getSausermEE() {
	return sausermEE;
}

public void setSausermEE(Sauserm sausermEE) {
	this.sausermEE = sausermEE;
}


public List<String> getEstimateList() {
	return estimateList;
}

public void setEstimateList(List<String> estimateList) {
	this.estimateList = estimateList;
}

private String estimateNumber;

private String costCenter;

public String getCostCenter() {
	return costCenter;
}

public void setCostCenter(String costCenter) {
	this.costCenter = costCenter;
}

public String getEstimateNumber() {
	return estimateNumber;
}

public void setEstimateNumber(String estimateNumber) {
	this.estimateNumber = estimateNumber;
}

private String selectedEstimateNumber;


public String getSelectedEstimateNumber() {
	return selectedEstimateNumber;
}

//public String result;
public String rejectReason;
public String getRejectReason() {
	return rejectReason;
}

public void setRejectReason(String rejectReason) {
	this.rejectReason = rejectReason;
}

public String forward;

public String getForward() {
	return forward;
}

public void setForward(String forward) {
	this.forward = forward;
}

public String recommend;
public String getRecommend() {
	return recommend;
}

public void setRecommend(String recommend) {
	this.recommend = recommend;
}

public String reject;


public String getReject() {
	return reject;
}

public void setReject(String reject) {
	this.reject = reject;
}

public String approve;

public String getApprove() {
	return approve;
}

public void setApprove(String approve) {
	this.approve = approve;
}

public void setSelectedEstimateNumber(String selectedEstimateNumber) {
	this.selectedEstimateNumber = selectedEstimateNumber;
}

private List<String> selectedEstimateList;
	
	public List<String> getSelectedEstimateList() {
	return selectedEstimateList;
}

public void setSelectedEstimateList(List<String> selectedEstimateList) {
	this.selectedEstimateList = selectedEstimateList;
}

	
	public List<Pcesthmt> getPcesthmtList() {
		return pcesthmtList;
	}

	public void setPcesthmtList(List<Pcesthmt> pcesthmtList) {
		this.pcesthmtList = pcesthmtList;
	}


	private long vj_approval_count;

	public long getVj_approval_count() {
		return vj_approval_count;
	}

	public void setVj_approval_count(long vj_approval_count) {
		this.vj_approval_count = vj_approval_count;
	}
	
	private long vj_recomendation_count;

	public long getVj_recomendation_count() {
		return vj_recomendation_count;
	}

	public void setVj_recomendation_count(long vj_recomendation_count) {
		this.vj_recomendation_count = vj_recomendation_count;
	}
	
	@Override
	public String toString() {
		return "ApprovalModel [approvalList=" + approvalList
				+ ", vj_approval_count=" + vj_approval_count
				+ ", vj_recomendation_count=" + vj_recomendation_count + "]";
	}
	
	
	


}
