<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<c:url value="/resources/css/ebems.css"/>"/>
 <style>
      #map {
        width: 100%;
        height: 400px;
        margin-left:0px;
        margin-right:auto;
      }
      #form {
        width: 400px;
        height: 400px;
        margin-left:0px;
        margin-top:50px;
      }
</style>
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script>
     
      function initAutocomplete() {
    	  var map = new google.maps.Map(document.getElementById('map'), {
    	    center: {lat: -33.8688, lng: 151.2195},
    	    zoom: 13,
    	    mapTypeId: google.maps.MapTypeId.ROADMAP
    	  });

    	  // Create the search box and link it to the UI element.
    	  var input = document.getElementById('pac-input');
    	  var searchBox = new google.maps.places.SearchBox(input);
    	  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    	  // Bias the SearchBox results towards current map's viewport.
    	  map.addListener('bounds_changed', function() {
    	    searchBox.setBounds(map.getBounds());
    	  });

    	  var markers = [];
    	  // Listen for the event fired when the user selects a prediction and retrieve
    	  // more details for that place.
    	  searchBox.addListener('places_changed', function() {
    	    var places = searchBox.getPlaces();

    	    if (places.length == 0) {
    	      return;
    	    }

    	    // Clear out the old markers.
    	    markers.forEach(function(marker) {
    	      marker.setMap(null);
    	    });
    	    markers = [];

    	    // For each place, get the icon, name and location.
    	    var bounds = new google.maps.LatLngBounds();

    	    
    	    places.forEach(function(place) {
    	      var icon = {
    	        url: place.icon,
    	        size: new google.maps.Size(71, 71),
    	        origin: new google.maps.Point(0, 0),
    	        anchor: new google.maps.Point(17, 34),
    	        scaledSize: new google.maps.Size(25, 25)
    	      };

    	      // Create a marker for each place.
    	      markers.push(new google.maps.Marker({
    	        map: map,
    	        icon: icon,
    	        title: place.name,
    	        position: place.geometry.location
    	      }));

    	      if (place.geometry.viewport) {
    	        // Only geocodes have viewport.
    	        bounds.union(place.geometry.viewport);
    	      } else {
    	        bounds.extend(place.geometry.location);
    	      }
    	    });
    	    map.fitBounds(bounds);
    	  });
    	} 
      google.maps.event.addDomListener(window, 'load', initAutocomplete);
    </script>
<title>Electricity Breakdown Evaluation Management System</title>
</head>
<div id="line">
<h2>Electricity Breakdown Evaluation Management System</h2>
</div>
<header align="middle" >
<img align="middle" style="width:100%;height:130px;"  src="<c:url value="/resources/images/Header.png"/>" />
</header>
<div id="line1">
</div>
<ul class="nav">
         <li class="nav li"><a href="<c:url value='/WelcomePage' />">Home</a></li>
         <li class="nav li"><a href="<c:url value='/Customer' />">Customer</a></li>
         <li class="nav li"><a href="<c:url value='/Complain' />">Complain</a></li>
         <li class="nav li"><a href="<c:url value='/Customer' />">Customer</a></li>
         <li class="nav li"><a href="<c:url value='/Complain' />">Complain</a></li>
         <li class="nav li"><a href="<c:url value='/login' />">Login</a></li>
</ul>
<div id="line1">
</div>

<body align="middle">



<form:form method="POST"  commandName="user" id="reg"	action="/User/AddUser" >
	
	<table class ="tableWelcome" border="0">
		    
			<tr>
				<td width="198" align="left">User Name</td>
				<td width="19"><div align="left">:</div></td>
				<td><form:input path="accessCode" /></td>
				<td><form:errors class="invalid" path="accessCode" /></td>
			</tr>
			<tr>
				<td align="left">ID Number</td>
				<td><div align="left">:</div></td>
				<td><form:input path="idNo" /></td>
				<td><button class ="button_small" name="Search" /></td>
				<td><form:errors class="invalid" path="idNo" /></td>
			</tr>
			<!--tr>
				<td align="left">Area Code</td>
				<td><div align="left">:</div></td>
				<td><form:input path="areaCode" /></td>
				<td><form:errors class="invalid" path="areaCode" /></td>
			</tr-->
			<tr>
				<td align="left">First Name</td>
				<td><div align="left">:</div></td>
				<td><form:input path="custFname" /></td>
				<td><form:errors class="invalid" path="custFname" /></td>
			</tr>
			
			<tr>
				<td align="left">Last Name</td>
				<td><div align="left">:</div></td>
				<td><form:input path="custLname" /></td>
				<td><form:errors class="invalid" path="custLname" /></td>
			</tr>
			<tr>
				<td align="left">Address 1</td>
				<td><div align="left">:</div></td>
				<td><form:input path="address1" /></td>
				<td><form:errors class="invalid" path="address1" /></td>
			</tr>
			<tr>
				<td align="left">Address 2</td>
				<td><div align="left">:</div></td>
				<td><form:input path="address2" /></td>
				<td><form:errors class="invalid" path="address2" /></td>
			</tr>
		    <tr>
				<td align="left">Address 3</td>
				<td><div align="left">:</div></td>
				<td><form:input path="address3" /></td>
				<td><form:errors class="invalid" path="address3" /></td>
			</tr>
			<!--tr>
				<td align="left">Type Of ID</td>
				<td><div align="left">:</div></td>
				<td><form:input path="typeOfId" /></td>
				<td><form:errors class="invalid" path="typeOfId" /></td>
			</tr-->
			
			<!-- tr>
				<td align="left">Customer Location</td>
				<td><div align="left">:</div></td>
				<td><form:input path="cusLocation" /></td>
				<td><form:errors class="invalid" path="cusLocation" /></td>
			</tr-->
			<!--tr>
				<td align="left">Grid Sub</td>
				<td><div align="left">:</div></td>
				<td><form:input path="gridSub" /></td>
				<td><form:errors class="invalid" path="gridSub" /></td>
			</tr-->
			<!-- tr>
				<td align="left">Primary Sub</td>
				<td><div align="left">:</div></td>
				<td><form:input path="primarySub" /></td>
				<td><form:errors class="invalid" path="primarySub" /></td>
			</tr-->
			<!--tr>
				<td align="left">Feeder</td>
				<td><div align="left">:</div></td>
				<td><form:input path="feederName" /></td>
				<td><form:errors class="invalid" path="feederName" /></td>
			</tr-->
			<tr>
				<td align="left">Current Depot</td>
				<td><div align="left">:</div></td>
				<td><form:input path="crntDepot" /></td>
				<td><form:errors class="invalid" path="crntDepot" /></td>
			</tr>
			<!-- tr>
				<td align="left">Substation Code</td>
				<td><div align="left">:</div></td>
				<td><form:input path="substnCode" /></td>
				<td><form:errors class="invalid" path="substnCode" /></td>
			</tr>
			<tr>
				<td align="left">Reader Code</td>
				<td><div align="left">:</div></td>
				<td><form:input path="readerCode" /></td>
				<td><form:errors class="invalid" path="readerCode" /></td>
			</tr>
			<tr>
				<td align="left">Dly_Pack_No</td>
				<td><div align="left">:</div></td>
				<td><form:input path="dlyPackNo" /></td>
				<td><form:errors class="invalid" path="dlyPackNo" /></td>
			</tr>
			<tr>
				<td align="left">Walk_Seq</td>
				<td><div align="left">:</div></td>
				<td><form:input path="walkSeq" /></td>
				<td><form:errors class="invalid" path="walkSeq" /></td>
			</tr>
			<tr>
				<td align="left">Pole Number</td>
				<td><div align="left">:</div></td>
				<td><form:input path="poleNo" /></td>
				<td><form:errors class="invalid" path="poleNo" /></td>
			</tr>
			<tr>
				<td align="left">Premium ID</td>
				<td><div align="left">:</div></td>
				<td><form:input path="premId" /></td>
				<td><form:errors class="invalid" path="premId" /></td>
			</tr-->
			<tr>
				<td align="left">Telephone Number 1</td>
				<td><div align="left">:</div></td>
				<td><form:input path="teleNol" /></td>
				<td><form:errors class="invalid" path="teleNol" /></td>
			</tr>
			<tr>
				<td align="left">Telephone Number 2</td>
				<td><div align="left">:</div></td>
				<td><form:input path="teleNom" /></td>
				<td><form:errors class="invalid" path="teleNom" /></td>
			</tr>
			<tr>
				<td align="left">Customer Type</td>
				<td><div align="left">:</div></td>
				<td><form:input path="custType" /></td>
				<td><form:errors class="invalid" path="custType" /></td>
			</tr>
			<tr>
				<td align="left">Longitute</td>
				<td><div align="left">:</div></td>
				<td><form:input path="locLat" /></td>
				<td><form:errors class="invalid" path="locLat" /></td>
			</tr>
			<tr>
				<td align="left">Latitude</td>
				<td><div align="left">:</div></td>
				<td><form:input path="locLon" /></td>
				<td><form:errors class="invalid" path="locLon" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>
					<div align="left">
						<input type="submit" Value="Add" />
						<input type="submit" Value="Modify" />
						<input type="submit" Value="Clear" />
					</div>
				</td>
			</tr>
		</table>


	</form:form>


<div id="footer" >
Copyright © Gayani
</div>
</body>
</html>