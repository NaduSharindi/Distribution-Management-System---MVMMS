package com.it.piv.myceb.repo;

import java.util.List;
import com.it.piv.myceb.domain.LocationUpdate;

public interface LocationUpdateDao {
	
	public LocationUpdate findById(String id);
	public List<LocationUpdate>  getAll();
	

}
