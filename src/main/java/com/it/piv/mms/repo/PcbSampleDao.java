package com.it.piv.mms.repo;
import com.it.piv.mms.domain.PcbSample;

public interface PcbSampleDao{
	public String addInformationReatedSample(PcbSample pcbSample);

	public PcbSample findSampleByEquipmentId(String equipmentId);

	public String addSample(PcbSample pcbSample);

	public String updateSample(PcbSample pcbSample);
}