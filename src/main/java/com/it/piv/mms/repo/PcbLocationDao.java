package com.it.piv.mms.repo;
import java.util.List;

import com.it.piv.mms.domain.PcbLocation;

public interface PcbLocationDao{
	
	public PcbLocation findLocationByEquipmentId(String equipmentId);

	public String addLocation(PcbLocation pcbLocation);

	public String updateLocation(PcbLocation pcbLocation);
	public List<PcbLocation> findLocationByArea(String area);

}