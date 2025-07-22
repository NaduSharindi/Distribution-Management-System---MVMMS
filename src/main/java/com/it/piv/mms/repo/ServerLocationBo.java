package com.it.piv.mms.repo;

import com.it.piv.mms.domain.ServerLocation;

public interface ServerLocationBo {

	ServerLocation getLocation(String ipAddress);

}