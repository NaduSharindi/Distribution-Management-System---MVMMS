<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<style>

#newst td,th{
  font-size: 10px;
}

div#map_container {
	width: 100%;
	height: 100%px;
	border-radius: 5px;
}
</style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry&libraries=drawing"></script>

<script type="text/javascript">




function myMap(LatLng, zoom) {
	
	alert("hiii");
	var map = new google.maps.Map(document.getElementById("map_container"),
			{
				//center: new google.maps.LatLng(7.2665013,80.541458),
				center : LatLng,
				zoom : zoom,
				gestureHandling : 'greedy',
				mapTypeId : google.maps.MapTypeId.ROADMAP
			});
	
	     
 
}

</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MV-MMS</title>
</head>
<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">

<div id="map_container"></div>
  

</body>
</html>