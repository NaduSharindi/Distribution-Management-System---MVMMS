<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>

<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<!-- bootstrap -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>" />

<!-- RTL support - for demo only -->
<script src="<c:url value="/resources/js/demo-rtl.js"/>">
	
</script>
<!-- 
	If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
	And add "rtl" class to <body> element - e.g. <body class="rtl"> 
	-->

<!-- libraries -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/font-awesome.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/nanoscroller.css"/>" />

<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/compiled/theme_styles.css"/>" />

<!-- this page specific styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/fullcalendar.css"/>" />
<link rel="stylesheet" type="text/css" media="print"
	href="<c:url value="/resources/css/libs/fullcalendar.print.css" />" />
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/compiled/calendar.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/morris.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/daterangepicker.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>" />

<!-- Favicon -->
<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

<!-- google font libraries -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'
	rel='stylesheet' type='text/css'>

<style type="text/css">
div#map_container {
	width: 100%;
	height: 400px;
}

.modal-title {
	margin: 0;
	line-height: 1.428571429;
	text-align: center;
}
</style>

<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c">
	
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap"></script>

<script type="text/javascript">
	function myMap(LatLng, zoom) {
		var map = new google.maps.Map(document.getElementById("map_container"),
				{
					//center: new google.maps.LatLng(7.2665013,80.541458),
					center : LatLng,
					zoom : zoom,
					gestureHandling : 'greedy',
					mapTypeId : google.maps.MapTypeId.ROADMAP
				});
	}

	function viewMapByMode(){
		var viewMode = mode.options[mode.selectedIndex].value;
		alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMap();
		}else{
			loadNetwork();
		}
		
	}

	function loadMap() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNew/" + strArea +"/" + strLine + "/" +strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        						//alert(data[4].lineName);
							
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						  };
								  if(data[0].supportType == 1){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_white.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towerMarker.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
									  }
								  else if(data[0].supportType == 2){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/poleMarker.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#5DADE2', fontWeight: 'bold', fontSize: '12px', text: 'P' }
    	            					});
									  }
								  else if(data[0].supportType == 3){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: 'GSSB' }
	            					});
								  }
							
        					//data.gpsLatitude, data.gpsLongitude
        					
        					// var flightPlanCoordinates = [
        					                       //       {lat: json[i].gpsLatitude, lng: json[i].gpsLongitude},
        					                       //       {lat: json[i+1].gpsLatitude, lng: json[i+1].gpsLongitude}
        					                              
        					                         //   ];
        					                          //  var flightPath = new google.maps.Polyline({
        					                             // path: flightPlanCoordinates,
        					                             // geodesic: true,
        					                              //strokeColor: '#FF0000',
        					                              //strokeOpacity: 1.0,
        					                             // strokeWeight: 2
        					                           // });

        					                           // flightPath.setMap(map);
        					
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {
									
								
//alert('' + data[0].supportType);
								var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else{
									supType = 'GSS Bay';
								} 
								 var conType;
								 if(data.conductorType == 1){
									 conType = 'TDL';
								 }else if(data.conductorType == 2){
									 conType = 'Racoon';
								 }else if(data.conductorType == 3){
									 conType = 'ELM';
								 }else if(data.conductorType == 4){
									 conType = 'Tiger';
								 }else if(data.conductorType == 5){
									 conType = 'Dog';
								 }else if(data.conductorType == 6){
									 conType = 'Lynx';
								 }else if(data.conductorType == 7){
									 conType = 'COPPER';
								 }else if(data.conductorType == 8){
									 conType = 'Catmion coper';
								 }else if(data.conductorType == 9){
									 conType = 'Coyote';
								 }else{
									 conType = 'Other';
								 }
								       						       
								//var contentString = "<div style='float:left'><img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'></div>";
								//var genInformation ="<div style='float:right; padding: 10px;'><b></b><br/><b>Tower Number:  </b>"+
								//data[0].towerNo+"</br>"+"<b>Area : </b>"+
								//data[0].area+"</br>"+"<b>Support type : </b>"+
    							//supType+"</br>"+"<b>Latitude : </b>"+
    							//data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
    							//data[0].gpsLongitude+"</br></div>";

    							//var techDetail ="<div style='float:right; padding: 10px;'><b>Technical Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";

								//var insDetail ="<div style='float:right; padding: 10px;'><b>Inspection Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr><div style='float:left'><img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'></div></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td></td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td><a href='<c:url value="/addSupportNew?id=49"/>'>Add New Support</a></td><td></td></tr>"+
								"<tr><td><a href='<c:url value="/addSupportNew?id=49"/>'>Add Maintenance Data</a></td><td></td></tr>"+
												
								"</table></div>";
								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							//infoWindow.setContent("<b>Tower Number:  </b>"+
        								//	data[0].towerNo+"</br>"+"<b>Area : </b>"+
        								//	data[0].area+"</br>"+"<b>Support type : </b>"+
	            						//	supType+"</br>"+"<b>Latitude : </b>"+
	            						//	data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
	            						//	data[0].gpsLongitude+"</br>"+"<b>Conductor Type :</b>"+
	            						//	conType+"</br>"+"<b>Tappings : </b>"+
	            							//data[1].nooftappings+"</br>"+"<b>Tower Type : </b>"+
	            							//data[0].towerType+"</br>"+"<b>Latest Inspection Data : </b>"+
	            							//data[0].towerType+"</br>"+"<b>WayLeaves: </b>"+
	            							//data[1].wayleavestatus+"</br>"+"<b>Base Concrete : </b>"+
	            							//data[1].baseconcretestatus+"</br>"+"<b>Conductor Status : </b>"+
	            							//data[1].conductorstatus+"</br>"+"<b>Jumper Status : </b>"+
	            							//data[1].jumperstatus+"</br>"+"<b>Missing Parts : </b>"+
	            							//data[1].noofmissingparts+
	            							
	            							
	            							//"</br>"+"" +contentString + insDetailTable );
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}



                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
         });
	}


	function loadNetwork() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNew/" + strArea +"/" + strLine +"/"+strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){

                	
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],

        					
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        					    
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						  };

								//	var marker = new google.maps.Marker({
            					//	position: latLng,
            						//map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						//icon: 'http://maps.google.com/mapfiles/ms/icons/purple-dot.png',
            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
            						//title: "Click here to view details of Tower ID "+data.towerNo
            					//});
							
							
								//alert("data.tapping : "+ data.tapping);
							if(data[1].nooftappings > 0 ){

								//alert("data.tapping");
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						icon: 'http://www.google.com/mapfiles/topbar.png',
            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
            					});
							}else{
        					var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: 'http://www.google.com/mapfiles/dsliderbarshadow.png',
        						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id,
        						icon: {
        					          path: google.maps.SymbolPath.CIRCLE,
        					          scale: 0
        					    }
        					});
                		}
        					//data.gpsLatitude, data.gpsLongitude
        					//	alert('ID : ' + json[i].id +'next id: ' + json[i+1].id);
        					
        					var towerid = data[0].id;
        					var lineid = data[0].lineId;
        					//alert('towerid:' +towerid + 'line id: '+ lineid);
        					var firstObj = json[i];
        					var secondObj = json[i+1];

        					if(firstObj[0].lineId == secondObj[0].lineId){
        						 var flightPlanCoordinates = [
            					                              {lat: firstObj[0].gpsLatitude, lng: firstObj[0].gpsLongitude},
            					                              {lat: secondObj[0].gpsLatitude, lng: secondObj[0].gpsLongitude}
            					                              
            					                            ];
        						 var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 1.0,
		                              strokeWeight: 2
		                            });
           						flightPath.setMap(map);

		                            
            				}
        		

        					                            
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {
									
								
var lineType;
if(data[4].lineType ==1){
lineType ='Backbone';
}else{
lineType ='Distributors';
}
        						var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else{
									supType = 'GSS Bay';
								} 
								 var conType;
								 if(data.conductorType == 1){
									 conType = 'TDL';
								 }else if(data.conductorType == 2){
									 conType = 'Racoon';
								 }else if(data.conductorType == 3){
									 conType = 'ELM';
								 }else if(data.conductorType == 4){
									 conType = 'Tiger';
								 }else if(data.conductorType == 5){
									 conType = 'Dog';
								 }else if(data.conductorType == 6){
									 conType = 'Lynx';
								 }else if(data.conductorType == 7){
									 conType = 'COPPER';
								 }else if(data.conductorType == 8){
									 conType = 'Catmion coper';
								 }else if(data.conductorType == 9){
									 conType = 'Coyote';
								 }else{
									 conType = 'Other';
								 }
								       						       
								var contentString = "<div style='float:right; padding: 10px;'><table id ='ss'><tr><div style='float:left'><img src='<c:url value="/resources/img/CEBImages/line.png"/>'></div><tr><th>Line Info</th></tr><tr><td>Line Code : </td><td>"+
								data[4].code+"</td></tr><tr><td>Area : </td><td>"+
								data[4].area+"</td></tr><tr><td>Com Date :  </td><td>"+
								data[4].comdate+"</td></tr><tr><td>Length :  </td><td>"+
								data[4].length+"</td></tr><tr><td>Line Name :  </td><td>"+
								data[4].lineName+"</td></tr>"+
								"<tr><td>Line Type :  </td><td>"+lineType+"</td></tr>"+
								"<tr><td>No of Poles :  </td><td>"+data[4].noofpoles+"</td></tr>"+
								"<tr><td>No of Towers :  </td><td>"+data[4].nooftowers+"</td></tr>"+
								"</tr><tr><th>Tapping Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td></td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td><a href='<c:url value="/addSupportNew?id=49"/>'>Add New Support</a></td><td></td></tr>"+
								
								"</table></div>";

	
        						google.maps.event.addListener(marker, "click", function(e) {

        							infoWindow.setContent(contentString);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
         });
	}

	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>LINE</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>AREA</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].deptId + "'>"
									+ data[i].deptNm + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}

	// the smooth zoom function
	function smoothZoom(map, max, cnt) {
		if (cnt >= max) {
			return;
		} else {
			z = google.maps.event.addListener(map, 'zoom_changed', function(
					event) {
				google.maps.event.removeListener(z);
				smoothZoom(map, max, cnt + 1);
			});
			setTimeout(function() {
				map.setZoom(cnt)
			}, 80); // 80ms is what I found to work well on my system -- it might not work well on all systems
		}
	}
</script>

</head>

<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
	<div id="theme-wrapper">
		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">
					<div class="row">


						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Dashboard</span></li>
								</ol>

								<h1>Dashboard - ${sessionScope.loggedUser}</h1>
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>

					<link rel="stylesheet"
						href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
						integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
						crossorigin="anonymous">

					<div class="container">

						<div class="jumbotron">

							<div class="row ">


								<div class="col-xs-2" align="left">
									<div class="row">
										<form:form method="post" action="viewSupportByProvince"
											modelAttribute="model">

											<div class="col-lg-12">

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="province" path="glcompmobj.compId"
																onchange="findArea()"
																style="width:100%; background-color: #8187ff; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${model.provinceList}" />
															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="area" path="gldeptobj.deptId"
																onchange="getLine()"
																style="width:100%; background-color: #94cb71; border-radius: 5px;">
																<form:option value="NONE" label="AREA" />
																<form:options items="${model.areaList}" />
															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="line" path="line.code" onchange=""
																style="width:100%; background-color: #dac698; border-radius: 5px;">
																<form:option value="NONE" label="LINE" />
																<form:options items="${model.lineList}" />
															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="mode" path="" onchange=""
																style="width:100%; background-color: #fff981; border-radius: 5px;">
																<form:option value="MAP" label="MAP VIEW" />
																<form:option value="NETWORK" label="NETWORK VIEW" />

															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div align="right" style="padding-right: 10px">
															<button type='button' class='btn btn-success'
																onClick='viewMapByMode()'>View</button>
														</div>
													</div>
												</div>

											</div>
										</form:form>
									</div>
								</div>

								<div class="col-xs-10" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>

							</div>



							<!-- 
								<div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
									<iframe
										src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2800.42512224691!2d-75.68248158397887!3d45.42093097910055!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cce050a6db98d73%3A0x1b0e6fa213d4aaeb!2sUniversity+Of+Ottawa!5e0!3m2!1sen!2sca!4v1452963363617"
										width="350px" height="280px" frameborder="4" style="border: 3"
										marginheight="3px" allowfullscreen>
									</iframe>
								</div>
								-->




							<!-- <div class="col-md-6" align="right">
										<div class="card card-plain">
											<div class="card-body">
												<div class="table-responsive">
													<table class="table table-hover" style="background: white">

														<thead class=" text-primary">
															<th>Tower</th>
															<th>Line Details</th>
														</thead>

														<tbody>

															<tr>
																<td>Noaf Line</td>
																<td>133</td>
															</tr>

															<tr>
																<td>Line levy</td>
																<td>1038</td>
															</tr>

															<tr>
																<td>Noaf Tower</td>
																<td>251</td>
															</tr>

														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div> -->




							<!-- <div class="col-md-4" style="background: #B0C4DE">
										<table align="right">
											<div style="overflow-x: auto;">
												<table class="table table-responsive">
													<tr>
														<th><i class="fa fa-bars"
															style="font-size: 36px; color: red;"></i></th>
														<th>Tower Line</th>
														<th>Details</th>

													</tr>
													<tr>
														<td><i class="fa fa-calendar-o"
															style="font-size: 36px; color: red;"></i></td>
														<td>Noaf Line</td>
														<td>50</td>

													</tr>
													<tr>
														<td><i class="fa fa-calendar-o"
															style="font-size: 36px; color: red;"></i></td>
														<td>Line Levy</td>
														<td>50</td>
													</tr>
													<tr>
														<td><i class="fa fa-cny"
															style="font-size: 36px; color: black;"></i></td>
														<td>Tower Line</td>
														<td>94</td>

													</tr>
													

												</table>
											</div>
										</table>
									</div> -->

						</div>
					</div>


					<div class="container">
						<div class="raw ">

							<div class="col-xs-1" align="left"></div>

							<div class="col-xs-10" align="center">
								<div class="card card-plain">
									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-hover"
												style="border: 2px solid #809c79; background-color: #d6e3c1; width: 100%;">

												<c:set var="count" value="0" scope="page" />
												<c:forEach var="summary" items="${model.summaryList}"
													varStatus="status">


													<tr>
														<th>Tower Lines Summary</th>
														<td>Lines</td>
														<td>Line length</td>
														<td>Towers</td>
														<td>Poles</td>
													</tr>
													<tr>
														<th>Total</th>
														<td>${summary[0]}</td>
														<td>${summary[1]}</td>
														<td>${summary[2]}</td>
														<td>${summary[3]}</td>
													</tr>
												</c:forEach>
												<tr>

													<td
														style="font-size: 14px; text-align: left; text-color: #1d8b24"><a
														href="viewDD"><strong> View More Divisional
																Information >> </strong></a></td>

												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>

							<div class="col-xs-1" align="right"></div>

						</div>
					</div>



					<div class="container">

						<div class="jumbotron">

							<div class="row">
								<div class="col-lg-12">

									<div class="row">

										<div class="col-lg-4 col-sm-6 col-xs-12">
											<div class="wrimagecard wrimagecard-topimage">
												<div class="wrimagecard-topimage_header"
													style="background-color: rgba(0, 255, 0, 0.3)">
													<center>
														<i class="fa fa-cubes" style="color: #008080"></i>
													</center>
													<h4>
														<a href="ViewDataAssetInfo"><center>
																<strong>Asset Information</strong>
															</center></a>
													</h4>
												</div>
												<div class="wrimagecard-topimage_title">
													<div class="pull-right badge" id="WrControls"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-4 col-sm-6 col-xs-12">
											<div class="wrimagecard wrimagecard-topimage">
												<div class="wrimagecard-topimage_header"
													style="background-color: #a1d0d0">
													<center>
														<i class="fa fa-table" style="color: #008080"></i>
													</center>
													<h4>
														<a href="viewTLMaintenance"><center>
																<strong>Schedules and Reports</strong>
															</center></a>
													</h4>
												</div>
												<div class="wrimagecard-topimage_title">
													<div class="pull-right badge" id="WrControls"></div>
												</div>
											</div>
										</div>

										<div class="col-lg-4 col-sm-6 col-xs-12">
											<div class="wrimagecard wrimagecard-topimage">
												<div class="wrimagecard-topimage_header"
													style="background-color: rgba(0, 255, 0, 0.3)">
													<center>
														<i class="fa fa-info-circle" style="color: #008080"></i>
													</center>
													<h4>
														<a href="MMS_Map"><center>
																<strong>Activity Request</strong>
															</center></a>
													</h4>
												</div>
												<div class="wrimagecard-topimage_title">
													<div class="pull-right badge" id="WrControls"></div>
												</div>
											</div>
										</div>

										<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
											<div class="wrimagecard wrimagecard-topimage">
												<div class="wrimagecard-topimage_header"
													style="background-color: #a1d0d0">
													<center>
														<i class="fa fa-cubes" style="color: #008080"></i>
													</center>
													<h4>
														<a href="viewDD"><center>
																<strong>Divisional Information</strong>
															</center></a>
													</h4>

													<h4>
														<strong>Summary</strong>
													</h4>

													<div style="overflow-x: auto;">
														<div class="card card-plain">
															<div class="card-body">
																<div class="table-responsive">
																	<table class="table table-hover"
																		style="border: 2px solid #809c79; background-color: #d6e3c1; width: 100%;">

																		<c:set var="count" value="0" scope="page" />
																		<c:forEach var="summary" items="${model.summaryList}"
																			varStatus="status">

																			<tr>
																				<th>Tower Lines Summary</th>
																				<th>Total</th>

																			</tr>
																			<tr>
																				<td>Lines</td>
																				<td>${summary[0]}</td>

																			</tr>
																			<tr>
																				<td>Line length</td>
																				<td>${summary[1]}</td>

																			</tr>
																			<tr>
																				<td>Towers</td>
																				<td>${summary[2]}</td>
																			</tr>
																			<tr>
																				<td>Poles</td>
																				<td>${summary[3]}</td>
																			</tr>

																		</c:forEach>
																	</table>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="wrimagecard-topimage_title">
													<div class="pull-right badge" id="WrControls"></div>
												</div>
											</div>
										</div> --%>



										<!--                                     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-table  black-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewDataMV">P&E Summary</a>
                                                            </span>
                                                    </div>
                                            </div>
                                                     
                                                     
                                                     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-table  black-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewTLMaintenance">Schedules and Reports</a>
                                                            </span>
                                                    </div>
                                            </div> -->
										<!--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-cubes  emerald-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewDD">Units</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-table  black-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewDataMV">Data(MV)</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            
                                                
                                        </div>
                                        
                                </div>

                            </div>-->

										<!--  <div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row"> 
                                          <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewSupportByProvince">Map View</a>
                                                            </span>
                                                    </div>
                                            </div>-->
										<!--    <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-info-circle  emerald-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Activity Request</a>
                                                            </span>
                                                    </div>
                                            </div>-->

										<!--     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-retweet  purple-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewLine">Tower Line</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-retweet  green-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewSupport">Support</a>
                                                            </span>
                                                    </div>
                                            </div>    
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="addLine">Add Line</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="addSupport">Add Support</a>
                                                            </span>
                                                    </div>
                                            </div>   -->
										<!--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  yellow-bg"></i>
                                                            <span class="headline">View Tower </span>
                                                            <span class="value">
                                                                <a href="viewTowerMaintenance">Maintenance</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o lightsteelblue-bg"></i>
                                                            <span class="headline">Create Maintenance</span>
                                                            <span class="value">
                                                                <a href="#">Estimate</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline">View Google </span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Map</a>
                                                            </span>
                                                    </div>
                                            </div>-->





										<!-- 
						<div class="row">

							<div class="col-lg-12">

								<div class="row">

									<div class="col-lg-3 col-sm-6 col-xs-12">
										<div class="main-box infographic-box">
											<i class="fa fa-cubes  emerald-bg"></i> <span
												class="headline"></span> <span class="value"> <a
												href="viewDD">Divisional Information</a>
											</span>
										</div>
									</div>

									<div class="col-lg-3 col-sm-6 col-xs-12">
										<div class="main-box infographic-box">
											<i class="fa fa-table  black-bg"></i> <span class="headline"></span>
											<span class="value"> <a href="ViewDataAssetInfo">Asset Information</a>
											</span>
										</div>
									</div>

									<div class="col-lg-3 col-sm-6 col-xs-12">
										<div class="main-box infographic-box">
											<i class="fa fa-table  black-bg"></i> <span class="headline"></span>
											<span class="value"> <a href="viewTLMaintenance">Schedules and Reports</a>
											</span>
										</div>
									</div>
									
 -->




										<!--   <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-retweet  purple-bg"></i>
                                                            <span class="headline">View Line</span>
                                                            <span class="value">
                                                                <a href="viewLine">Data</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-retweet  green-bg"></i>
                                                            <span class="headline">View Support</span>
                                                            <span class="value">
                                                                <a href="viewSupport">Data</a>
                                                            </span>
                                                    </div>
                                            </div>-->




										<!--
								</div>

							</div>

						</div>

						<div class="row">

							<div class="col-lg-12">

								<div class="row">

									<div class="col-lg-3 col-sm-6 col-xs-12">
										<div class="main-box infographic-box">
											<i class="fa fa-pencil-square-o lightsteelblue-bg"></i> <span
												class="headline"></span> <span class="value"> <a
												href="#">Maintenance Planning</a>
											</span>
										</div>
									</div>

									<div class="col-lg-3 col-sm-6 col-xs-12">
										<div class="main-box infographic-box">
											<i class="fa fa-map-marker  red-bg"></i> <span
												class="headline"></span> <span class="value"> <a
												href="viewNewMap">Map View</a>
											</span>
										</div>
									</div>

									<div class="col-lg-3 col-sm-6 col-xs-12">
										<div class="main-box infographic-box">
											<i class="fa fa-info-circle  emerald-bg"></i> <span
												class="headline"></span> <span class="value"> <a
												href="MMS_Map">Activity Request</a>
											</span>
										</div>
									</div>

								</div>

							</div>

						</div>

					</div>
-->





										<%@ include file="sections/footer.jsp"%>


									</div>
								</div>
							</div>
						</div>

						<%@ include file="sections/global_scripts.jsp"%>
</body>
</html>