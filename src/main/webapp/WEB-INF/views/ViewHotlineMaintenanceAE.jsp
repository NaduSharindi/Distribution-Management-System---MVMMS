<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}

</style>
<html>
<head>
<%@ include file="sections/head.jsp"%>

<script 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>


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
	
	
	/*  var infoWindow = new google.maps.InfoWindow;
	//alert("hhhhhhh");
	$.ajax({
		type : 'GET',
		url : "http://ip-api.com/json/119.235.8.0",
		data : {},
		//contentType : "application/json; charset=utf-8",
		success : function(data) {
			//alert("response.lat" + data.lat + "lon"+data.lon );
			
			var pos = {
		               lat: data.lat,
		               lng: data.lon
		             };
			
			
			infoWindow.setPosition(pos);
		    infoWindow.setContent('Location found.');
		    infoWindow.open(map);
		    map.setCenter(pos);
		        var marker = new google.maps.Marker({
						position: pos,
						map: map,
						icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
						title: "You are here !!!"
				});
		}
	});
	 */
		
	//getLocation();
	/**  if(!!navigator.geolocation) {
				//alert('Support');
									
				navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
		              lat: position.coords.latitude,
		              lng: position.coords.longitude
		        };
				map.setCenter(pos);
		        var marker = new google.maps.Marker({
					position: pos,
					map: map,
					icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
					title: "You are here !!!"
				});
		        });
			}
			else {
				//alert('No Support');
			} */
			
		 var infoWindow = new google.maps.InfoWindow;
			handlePermission();

       if (navigator.geolocation) {
           navigator.geolocation.getCurrentPosition(function(position) {
             var pos = {
               lat: position.coords.latitude,
               lng: position.coords.longitude
             };

             infoWindow.setPosition(pos);
             infoWindow.setContent('Location found.');
             infoWindow.open(map);
             map.setCenter(pos);
             var marker = new google.maps.Marker({
					position: pos,
					map: map,
					icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
					title: "You are here !!!"
				});
		        
             
             
             
           }, function() {
             handleLocationError(true, infoWindow, map.getCenter());
           });
         } else {
           // Browser doesn't support Geolocation
           handleLocationError(false, infoWindow, map.getCenter());
         }
      // }

       function handleLocationError(browserHasGeolocation, infoWindow, pos) {
         infoWindow.setPosition(pos);
         infoWindow.setContent(browserHasGeolocation ?
                               'Error: The Geolocation service failed.' :
                               'Error: Your browser doesn\'t support geolocation.');
         infoWindow.open(map);
       } 
       
	
/* var apiGeolocationSuccess = function(position) {
    alert("API geolocation success!\n\nlat = " + position.coords.latitude + "\nlng = " + position.coords.longitude);
};

var tryAPIGeolocation = function() {
    jQuery.post( "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDCa1LUe1vOczX1hO_iGYgyo8p_jYuGOPU", function(success) {
        apiGeolocationSuccess({coords: {latitude: success.location.lat, longitude: success.location.lng}});
  })
  .fail(function(err) {
    alert("API Geolocation error! \n\n"+err);
  });
};

var browserGeolocationSuccess = function(position) {
    alert("Browser geolocation success!\n\nlat = " + position.coords.latitude + "\nlng = " + position.coords.longitude);
};

var browserGeolocationFail = function(error) {
  switch (error.code) {
    case error.TIMEOUT:
    	
    	if(error.message.indexOf("Only secure origins are allowed") == 0) {
	        tryAPIGeolocation();
	      }
    	break;
    case error.PERMISSION_DENIED:
      if(error.message.indexOf("Only secure origins are allowed") == 0) {
        tryAPIGeolocation();
      }
      break;
    case error.POSITION_UNAVAILABLE:
      //alert("Browser geolocation error !\n\nPosition unavailable.");
      if(error.message.indexOf("Only secure origins are allowed") == 0) {
			tryAPIGeolocation();
	  } else {
			alert("Browser geolocation error !\n\nPosition unavailable.");
	  }
      break;
  }
};

var tryGeolocation = function() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
        browserGeolocationSuccess,
      browserGeolocationFail,
      {maximumAge: 50000, timeout: 20000, enableHighAccuracy: true});
  }
};

tryGeolocation();
*/	


}


function loadMapWayMiss(mode){
	if(mode == "VR"){
		loadMap();
	}else if(mode == "MPL"){
		loadMapMis();
	}
}



function loadMap() {
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
	var strCycle = cycle.options[cycle.selectedIndex].value;
	
	//variables for get the move location
	
	var bounds = new google.maps.LatLngBounds();
	//alert('hiii: ' + strCycle );
	$.ajax
    ({
            type: 'GET',
            url: "/MMS/MapNewAENewNew/" + strArea +"/" + strLine +"/"+strCycle,
             data: {},
            contentType: "application/json; charset=utf-8",
            success : function(json){
            	//alert(json.length);
            	
            		for (var i = 0, length = json.length; i < length; i++) {
    					var data = json[i],
    						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
    						//alert('huuuuuuu');
    						bounds.extend(latLng);
    						//alert('huuuuuuu4');
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
    						  
    						  
    						 
    						  
    						  
    						  var count = 0;
    						  if(data[1]){
        						  if(data[1].wayleavestatus.includes('GOOD')){
        							  count = 0;
        							   //count = count + countGood;
        							  // alert(count);
        						  }
        						  if(data[1].wayleavestatus.includes('Good')){
        							  count = 0;
       							       //count = count + countGood;
       							       //alert(count);
       						  	  }else if(data[1].wayleavestatus.includes('ARROUND')){
      							   	   //var countGood = 1;
      							       count = count + 6;
      							      // alert(count);
      						  	  }else  if(data[1].wayleavestatus.includes('AROUND')){
     							   	   //var countGood = 1;
     							       count = count + 6;
     							      // alert(count);
     						  	  }else if(data[1].wayleavestatus.includes('Along')){
     							   	   //var countGood = 2;
     							       count = count + 6;
     							      // alert(count);
     						  	  }else if(data[1].wayleavestatus.includes('ALONG')){
    							   	   //var countGood = 2;
    							       count = count + 2;
    							      // alert(count);
    						  	  }if(data[1].wayleavestatus.includes('Close')){
   							   	  // var countGood = 3;
   							       count = count + 9;
   							       //alert(count);
   						  	      }if(data[1].wayleavestatus.includes('CLOSE')){
      							   	   //var countGood = 3;
      							       count = count + 9;
      							      // alert(count);
      						  	  }if(data[1].wayleavestatus.includes('DANGER')){
     							   	   //var countGood = 4;
     							       count = count + 9;
     							       
     							      // alert(count);
     						  	  }if(data[1].wayleavestatus.includes('TOUCH')){
     							   	  // var countGood = 5;
     							       count = count + 9;
     							      // alert(count);
     						  	  }if(data[1].wayleavestatus.includes('Tough')){
    							   	   //var countGood = 5;
    							       count = count +5;
    							      // alert(count);
    						  	  }
        						  }
        						  /* if ((data[1].wayleavestatus.indexOf('GOOD')== 0) && (data[1].wayleavestatus.indexOf('ARROUND')== 0) ){
    						  		count = 1;
    						  	  } if ((data[1].wayleavestatus.indexOf('GOOD')== 0) && (data[1].wayleavestatus.indexOf('ALONG')== 0) ){
    						  		count = 2;
    						  	  } */
        						  
      						 //alert("total : " + data[0].towerNo +" : " + count);
      						 
       						 if(count<=2){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
            						/* icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    },
            						 */title: "Click here to view details of Tower ID "+data[0].id + "Weightage :" + count
            						
            					});
								
       						 }
       						 /* else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
            						
            					});
								
       						 } */
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
            						
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
            						
            					});
								
       						 }
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
							}else if(data[0].supportType == 4){
								supType = 'GSS Bay';
							}else if(data[0].supportType == 5){
								supType = 'Line Gantry';
							}else if(data[0].supportType == 6){
								supType = 'Lattice Pole';
							}else if(data[0].supportType == 7){
								supType = 'Switch';
							}else{
								supType = 'NONE';
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
							
							var lineid =data[0].towerNo;
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
							data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
							data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
							supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
							data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
							data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
							data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
							"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
							
							"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
							"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
							"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
							"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
							"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
							"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
							"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
							"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
							"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
							
							/* "<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
							"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
							 */"</table></div>";
							


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
            		
            		
            		//alert("hiiiiiiii");
            		  

            		map.fitBounds(bounds);

            		
            		//var polyline = new GPolyline([
					                       //       new GLatLng(7.3171376, 80.5608933),
					                           //   new GLatLng(7.3205831, 80.5581145)],
					                           //   "#ff0000", 50);
					                         //   map.addOverlay(polyline);

    				
            }
            
            
     });
	
}


function loadMapMis() {
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
	var strCycle = cycle.options[cycle.selectedIndex].value;
	
	//variables for get the move location
	
	var bounds = new google.maps.LatLngBounds();
	//alert('hiii: ' + strCycle );
	$.ajax
    ({
            type: 'GET',
            url: "/MMS/MapNewAENewNew/" + strArea +"/" + strLine +"/"+strCycle,
             data: {},
            contentType: "application/json; charset=utf-8",
            success : function(json){
            	//alert(json.length);
            	
            		for (var i = 0, length = json.length; i < length; i++) {
    					var data = json[i],
    						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
    						//alert('huuuuuuu');
    						bounds.extend(latLng);
    						//alert('huuuuuuu4');
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
    						  
    						  
    						 
    							 if(data[1]){
              						  if(data[1].noofmissingparts == 0){
                   							var marker = new google.maps.Marker({
                        						position: latLng,
                        						map: map,
                        						//icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                        						icon: {
      		        					          path: google.maps.SymbolPath.CIRCLE,
      		        					          scale: 1
      		        					    },
      		        					    title: "Click here to view details of Tower ID "+data[0].id + "Weightage :" + data[1].noofmissingparts
                        						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo 
                        						//	}
                        					});
            								
                   						 }
                   						 else if(data[1].noofmissingparts<=4){
                   							var marker = new google.maps.Marker({
                        						position: latLng,
                        						map: map,
                        						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                        						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + data[1].noofmissingparts
                        						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo
                        						//	}
                        					});
            								
                   						 }
                   						
                   						/*  else if(data[1].noofmissingparts<=8){
                   							var marker = new google.maps.Marker({
                        						position: latLng,
                        						map: map,
                        						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                        						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + data[1].noofmissingparts,
                        						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                        					});
            								
                   						 }
                   						 */ else{
                   							var marker = new google.maps.Marker({
                        						position: latLng,
                        						map: map,
                        						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
                        						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + data[1].noofmissingparts
                        						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo
                        						//	}
                        					});
            								
                   						 }
                      		}
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
							}else if(data[0].supportType == 4){
								supType = 'GSS Bay';
							}else if(data[0].supportType == 5){
								supType = 'Line Gantry';
							}else if(data[0].supportType == 6){
								supType = 'Lattice Pole';
							}else if(data[0].supportType == 7){
								supType = 'Switch';
							}else{
								supType = 'NONE';
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
							
							var lineid =data[0].towerNo;
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
							data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
							data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
							supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
							data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
							data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
							data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
							"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
							
							"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
							"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
							"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
							"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
							"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
							"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
							"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
							"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
							"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
							
							/* "<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
							"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
							 */"</table></div>";
							


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
            		
            		
            		//alert("hiiiiiiii");
            		  

            		map.fitBounds(bounds);

            		
            		//var polyline = new GPolyline([
					                       //       new GLatLng(7.3171376, 80.5608933),
					                           //   new GLatLng(7.3205831, 80.5581145)],
					                           //   "#ff0000", 50);
					                         //   map.addOverlay(polyline);

    				
            }
            
            
     });
	
}





	function ConfirmActivate(comid) {

		//alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				alert(response);

			}
		});

	}

	function showProvinces() {

		$
				.ajax({
					type : 'GET',
					url : '/MMS/findAllProvinces/',
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						$("#tblProvinces > tbody:last").children().remove();

						//Insert item from the response
						for (var i = 0; i < response.length; i++) {
							var item = response[i];
							var comid = item.compId;

							tr = $('<tr/>');
							tr.append("<td> " + item.compNm + "</td>");
							tr
									.append("<td>"
											+ "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"
											+ comid + "')>Go</button>"
											+ "</td>");

							$('#tblProvinces').append(tr);
						}

						$('#tblProvinces').dataTable({
							'info' : false,
							'pageLength' : 10,
							retrieve : true
						});
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
						var slctSubcat = $('#area'), option = "<option value='NONE'>ALL</option>";
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
						var slctSubcat = $('#line'), option = "<option value='-1'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].id + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
	
	function handlePermission() {
		//alert('hiiii');
		  navigator.permissions.query({name:'geolocation'}).then(function(result) {
		    if (result.state == 'granted') {
		    	//alert('hiiii 1');
		    	
		      report(result.state);
		      geoBtn.style.display = 'none';
		    } else if (result.state == 'prompt') {
		    	//alert('hiiii 2');
		    	
		      report(result.state);
		      geoBtn.style.display = 'none';
		      navigator.geolocation.getCurrentPosition(revealPosition,positionDenied,geoSettings);
		    } else if (result.state == 'denied') {
		    	//alert('hiiii 3');
		    	
		      report(result.state);
		      geoBtn.style.display = 'inline';
		    }
		    result.onchange = function() {
		      report(result.state);
		    }
		  });
		}
	
	
	function report(state) {
		  console.log('Permission ' + state);
		}


</script>
</head>
<body onload='myMap(new google.maps.LatLng(7.475214, 80.744077), 7);loadMapWayMiss("${model.mode}");'>
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
									<c:choose>
																	<c:when test="${model.mode=='HOTLINE'}">
																	<li class="active"><span>Hot Line Maintenance</span></li>
																	</c:when>
																	<c:when test="${model.mode=='TTWT'}">
																	<li class="active"><span>Tension Tower Without Tapping</span></li>
																	</c:when>
																	<c:when test="${model.mode=='CLE'}">
																	<li class="active"><span>Cold Line Electrical</span></li>
																	</c:when>
																	<c:when test="${model.mode=='CLC'}">
																	<li class="active"><span>Cold Line Civil</span></li>
																	</c:when>
																	<c:when test="${model.mode=='MW'}">
																	<li class="active"><span>Miscellaneous Works</span></li>
																	</c:when>
																	<c:when test="${model.mode=='EWOP'}">
																	<li class="active"><span>Electrical Works On Poles</span></li>
																	</c:when>
																	<c:when test="${model.mode=='VR'}">
																	<li class="active"><span>Vegetation Schedule</span></li>
																	</c:when>
																	<c:when test="${model.mode=='TP'}">
																	<li class="active"><span>Tapping Detail Report</span></li>
																	</c:when>
																	<c:when test="${model.mode=='MPL'}">
																	<li class="active"><span>Missing Parts Report</span></li>
																	</c:when>
																	
																	<c:when test="${model.mode=='HAR'}">
																	<li class="active"><span>Cycle Wise Data Storage</span></li>
																	</c:when>
																	<c:when test="${model.mode=='HAR2'}">
																	<li class="active"><span>Cycle Wise Data Storage</span></li>
																	</c:when>
																	
																	<c:when test="${model.mode=='CANCEL'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton" value="Reject"></input>

																	</c:when>
																	
																																		

																	<c:otherwise>

																	</c:otherwise>
																</c:choose> 

								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="GenerateProvincialScheduleAE"
													modelAttribute="model">

													<table class="table table-striped table-bordered table-sm" id="tblProvinces">
														<form:hidden path="mode" />
														<c:set var="myVar" value="${model.mode}" />


														<%-- <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Province</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
																</form:select></td>

														</tr> --%>
														<tr>
															<td width="30%" style="text-align: left">Area</td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()"	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<%-- <form:option value="NONE" label="ALL" />
																	 --%><form:options items="${model.areaList}" />
																</form:select></td>

														</tr>
														<c:if test="${model.mode !='HAR' && model.mode !='HAR2'}">
														
														<tr>
															<td width="30%" style="text-align: left">Line</td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange='loadMapWayMiss("${model.mode}")'	style="width:50%; background-color: #FFFFF; border-radius: 5px;">

																	<form:option value="-1" label="ALL" />
																	<form:options items="${model.lineListLong}" />
																</form:select></td>
														</tr>
<tr>
														
														
														<td width="30%" style="text-align: left">Cycle</td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange='loadMapWayMiss("${model.mode}")' style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
														
</c:if>

														<%-- <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="method" path="cycle" onchange="">

																	<form:option value="" label="ALL " />
																	<form:option value="201901" label="201901" />
																	<form:option value="201801" label="201801" />
																
																</form:select></td>
														</tr> --%>
														<!-- 	<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="" for="txtLUTD">From Date :
											</form:label></td>
															<td width="70%" style="text-align: left"><form:input
																	path="" type="datetime-local" class="form-control"
																	id="txtLUTD" placeholder="Date and Time" /> <span
																id="spnLUTD" class="label label-danger"></span></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="" for="txtLUTD">To Date :
											</form:label></td>
															<td width="70%" style="text-align: left"><form:input
																	path="" type="datetime-local" class="form-control"
																	id="txtLUTD" placeholder="Date and Time" /> <span
																id="spnLUTD" class="label label-danger"></span></td>
														</tr>
														<tr>-->
														<!--	<td width="30%" style="text-align:left">
                												<form:label path="">LINE TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																     </td>  
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CONDUCTOR TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td> 
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CIRCUIT TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																    </td> 
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">SUPPORT TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.supTypeList}"/>
																</form:select>
																
																   </td>  
        														</tr>
        														
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												
                												<form:label path="">TOWER CONFIGURATION</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																  </td>   
        														</tr>-->
														<tr>

															<td colspan="2"><c:if test="${myVar =='HOTLINE'}">

																</c:if> <input type="hidden" name="actionButton" value="" /> <c:choose>
																	<c:when test="${model.mode=='HOTLINE'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Hot Line Maintenance "></input>
																			
																	</c:when>
																	<c:when test="${model.mode=='TTWT'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Tension Tower Without Tapping"></input>

																	</c:when>
																	<c:when test="${model.mode=='CLE'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cold Line Electrical"></input>

																	</c:when>
																	<c:when test="${model.mode=='CLC'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cold Line Civil"></input>

																	</c:when>
																	<c:when test="${model.mode=='MW'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Miscellaneous Works"></input>

																	</c:when>
																	<c:when test="${model.mode=='EWOP'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Electrical Works On Poles"></input>

																	</c:when>
																	<c:when test="${model.mode=='VR'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Vegetation Schedule"></input>

																	</c:when>
																	<c:when test="${model.mode=='TP'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Tapping Detail Report"></input>

																	</c:when>
																	<c:when test="${model.mode=='MPL'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Missing Parts Report"></input>

																	</c:when>
																	<c:when test="${model.mode=='HAR'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cycle Wise Data Storage"></input>

																	</c:when>
																	<c:when test="${model.mode=='HAR2'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cycle Wise Data Storage"></input>

																	</c:when>
																	
																	
																	<c:when test="${model.mode=='CANCEL'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton" value="Reject"></input>

																	</c:when>

																	<c:otherwise>

																	</c:otherwise>
																</c:choose> <input id="pivFormBtn" class="btn btn-success"
																type="submit" name="actionButton" value="Exit"></input></td>
														</tr>


														<!-- <tr>
        														<td  style="text-align:left"   ><a href="../MMS/GenerateReportTM?area=431&line=49">
        														<input class="button" type="submit" name="actionButton"	value="View"></input></a> 
        														</td>
        														</tr>-->
													</table>
												</form:form>

											</tbody>
										</table>
										
										
									</div>
									
									<div class="col-sm-12" align="left">
									<div class="row">
									
									

										<div id="map_container"></div>

									</div>
								</div>
									

								</div>
							</div>
						</div>
					</div>

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>