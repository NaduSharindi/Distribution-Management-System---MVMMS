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
	<p>&nbsp;</p>
	<h2 align="center" style="color: black">Job Assign </h2>
	<form:form method="POST"  commandName="newAssign" id="reg"	action="/AddJob" >
	<table border="1" align="center" style="width:100%">
            <tr>
                <td align="left">Please select priority:</td>
                <td align="left">
                <form:select path="priorityCode" id="priority" name="priority">
                      <form:option value="U" label="Urgent" />
                      <form:option value="V" label="Very High" />
                      <form:option value="H" label="High" />
                      <form:option value="N" label="Normal" />
                      <form:option value="L" label="Low" />
                       </form:select>
                 </td>
                 
               
            </tr>
            <tr align="left">
                <td align="left">Comment:</td>
                <td align="left" ><form:input style="width:100%" path = "commentA" id="comment" name="comment" type="text" value=""/></td>
               
            </tr>
            <tr>
             <td align="left">Please select user:</td>
                <td align="left"><form:select path ="userLog" id="userLog" name="userLog">
                      <form:option value="C001" label="C001" />
                      <form:option value="C002" label="C002" />
                      <form:option value="C003" label="C003" />
                      <form:option value="C004" label="C004" />
                      <form:option value="C005" label="C005" />
                       </form:select>
                 </td>
                 </tr>
                 <tr>
                 <td>
                 
                 </td>
                 <td align="left">
                 <input type="submit" Value="Assign" />
                 </td>
                 </tr>
                 
      </table>
      </form:form>
	
	<table border="1" align="center" style="width:100%">
        <thead>
        
        
        
        
            <tr>
                <th>REFFERENCE_NO</th>
                <th>USER_LOG</th>

<th>STATUS_FROM</th>
<th>STATUS_TO</th>
<th>CURRENT_STATUS</th>
<th>OPERATION_TIME</th>
<th>EXPECTED_TIME</th>
<th>COMMENT_DES</th>


<th>ASSIGN</th>



</tr>
        </thead>
        <tbody>
           <c:forEach var="users" items="${users}" >
                <tr>
                
                <td>${users.refferenceNo}</td>
                <td>${users.userLog}</td>
				<td>${users.statusFrom}</td>
				<td>${users.statusTo}</td>
				<td>${users.statusTo}</td>
				<td>${users.operationTime}</td>
				<td>${users.expectedDur}</td>
				<td>${users.commentDes}</td>
				
				<td><a href="<c:url value='/Complain/Assign/${users.userLog}'/>">Assign</a></td>

                    				                   
                </tr>
            </c:forEach> 
        </tbody>
    </table>


<div id="footer" >
Copyright © Gayani
</div>
</body>
</html>