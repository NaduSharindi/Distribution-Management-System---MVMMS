package com.it.piv.mms.repo;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
import com.it.piv.mms.domain.ServerLocation;

@Component
public class ServerLocationBoImpl implements ServerLocationBo {

	@Override
	public ServerLocation getLocation(String ipAddress) {
		
		File file = new File("F:/" +"GeoLiteCity"+ ".dat");
		String dataFile = file.getAbsolutePath();
		return getLocation(ipAddress, dataFile);

	}

	private ServerLocation getLocation(String ipAddress, String locationDataFile) {

		ServerLocation serverLocation = null;

		//URL url = getClass().getClassLoader().getResource(locationDataFile);
		//String filename = getClass().getResource("/GeoIP.dat").toExternalForm().substring(6);
		
		if (locationDataFile == null) {
			System.err.println("location database is not found - "+ locationDataFile);
		}else {

			try {

				serverLocation = new ServerLocation();
				System.err.println("ddd: " +locationDataFile);
				LookupService lookup = new LookupService(locationDataFile,
						LookupService.GEOIP_MEMORY_CACHE);
				Location locationServices = lookup.getLocation(ipAddress);

				serverLocation.setCountryCode(locationServices.countryCode);
				serverLocation.setCountryName(locationServices.countryName);
				serverLocation.setRegion(locationServices.region);
				serverLocation.setRegionName(regionName.regionNameByCode(
						locationServices.countryCode, locationServices.region));
				serverLocation.setCity(locationServices.city);
				serverLocation.setPostalCode(locationServices.postalCode);
				serverLocation.setLatitude(String
						.valueOf(locationServices.latitude));
				serverLocation.setLongitude(String
						.valueOf(locationServices.longitude));

			} catch (IOException e) {

				System.err.println(e.getMessage());

			}

		}

		return serverLocation;

	}
}