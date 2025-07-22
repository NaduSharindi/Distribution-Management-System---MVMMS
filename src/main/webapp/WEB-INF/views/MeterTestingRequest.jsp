<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}
</style>




<html>

<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>MV-MMS</title>
<%@ include file="sections/headEdit.jsp"%>

<style type="text/css">

div#map_container {
	width: 100%;
	height: 250px;
	border-radius: 5px;
}

.modal-title {
	margin: 0;
	line-height: 1.428571429;
	text-align: center;
}


.dropbtn1 {
	background-color: #eee;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	width: 100%;
	height: 40px;
}

.dropbtn {
	background-color: #eee;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	width: 100%;
	height: 50px;
	
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	width: 100%;
	text-align: left;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #66CDAA;
}
</style>


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
	//getLocation();
	 if(!!navigator.geolocation) {
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
			}
	

}

function myMapTransformer(LatLng, zoom,lat,lon,sin) {
	//alert(sin);
	//alert(lat);
	//alert(lon);
	
	var map = new google.maps.Map(document.getElementById("map_container"),
			{
				//center: new google.maps.LatLng(7.2665013,80.541458),
				center : LatLng,
				zoom : zoom,
				gestureHandling : 'greedy',
				mapTypeId : google.maps.MapTypeId.ROADMAP
			});
	var latLng = new google.maps.LatLng(lat,lon);
	var marker = new google.maps.Marker({
		position: latLng,
		map: map,
		icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>',
		title: "The transformer location of sin :"+ sin
		});

	
	//getLocation();
	/*  if(!!navigator.geolocation) {
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
			}
	 */
	  /* var latLng = new google.maps.LatLng(lat,lon);
	  var marker = new google.maps.Marker({
			position: latLng,
			map: map,
			icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>',
			title: "The transformer location of sin :"+ sin
			});
	 */
}



function transformerLocation(latitude,longitude) {
	var map = new google.maps.Map(document.getElementById("map_container"),
			{
				center: new google.maps.LatLng(7.2665013,80.541458),
				zoom : 12,
				gestureHandling : 'greedy',
				mapTypeId : google.maps.MapTypeId.ROADMAP
			});
	//getLocation();
	 if(!!navigator.geolocation) {
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
			}
	 
	 var bounds = new google.maps.LatLngBounds();
		
	 var latLng = new google.maps.LatLng(latitude,longitude);
	 bounds.extend(latLng);
		
	 var marker = new google.maps.Marker({
			position: latLng,
			map: map,
			icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>'
			});
	 map.fitBounds(bounds);

	 
}






	var checkBoxSelected = [];

	function addCheckedToArray(id) {
		var checkBox = document.getElementById("cb_" + id);
		if (checkBox.checked == true) {
			checkBoxSelected.push(id);
		} else {
			checkBoxSelected = arrayRemove(checkBoxSelected, id);
		}
		alert(checkBoxSelected);
	}

	function arrayRemove(arr, value) {

		return arr.filter(function(ele) {
			return ele != value;
		});

	}

	function goToEstimate() {

		var str = "";
		for (var i = 0; i < checkBoxSelected.length; i++) {
			if (i != 0) {
				str = str + "," + checkBoxSelected[i];
			} else {
				str = checkBoxSelected[0];
			}
		}
		alert(str);

		$.ajax({
			type : "GET",
			url : "/MMS/goToEstimate/" + str,
			success : function(response) {
				alert(response);
				console.log(response);
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
									+ "<option value='" + data[ i ].deptId + "'>"
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
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='" + data[ i ].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}

	function ConfirmActivate(comid) {

		alert("hiiii");
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
	
	function viewMapByMode(){
		var viewMode = modeType.options[modeType.selectedIndex].value;
		//alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMapWithoutMnt();
		}else if(viewMode=='NETWORK'){
			loadNetwork();
		}else{
			//loadNetwork();
		}
		
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
		//var strProvince = province.options[province.selectedIndex].value;
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/AEMapINTNew/" + strArea +"/" + strLine + "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){

                	
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],

        					
        					latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        					bounds.extend(latLng);
    						

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


								if(data[0].supportType == 3){
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
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
	            					});
							  }else{
								//alert("data.tapping");
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://www.google.com/mapfiles/topbar.png',
	            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
	            					});
							  }



								

								

								
        						
							}else{


								if(data[0].supportType == 3){
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
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
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
		        					          scale: 1
		        					    }
		        					});
							  }




								
        						
                		}
        					//data.gpsLatitude, data.gpsLongitude
        					//	alert('ID : ' + json[i].id +'next id: ' + json[i+1].id);
        					
        					var towerid = data[0].id;
        					var lineid = data[0].lineId;
        					//alert('towerid:' +towerid + 'line id: '+ lineid);
        					var firstObj = json[i];
        					var secondObj = json[i+1];

        					if(secondObj){
        					if(firstObj[0].lineId == secondObj[0].lineId){
        						 var flightPlanCoordinates = [
            					                              {lat: firstObj[0].gpsLatitude, lng: firstObj[0].gpsLongitude},
            					                              {lat: secondObj[0].gpsLatitude, lng: secondObj[0].gpsLongitude}
            					                              
            					                            ];
        						 var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 2.0,
		                              strokeWeight: 4
		                            });
           						flightPath.setMap(map);

		                            
            				}
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
								       						       
								var contentString = "<div style='float:right; padding: 10px;'><table id ='ss'>"+
								"<tr><td><button type='button' id='myBtn'  onClick='viewFrom(\"" + data[0].towerNo + "\")'>From</button></td><td><button type='button' id='myBtn'  onClick='viewTo(\"" + data[0].towerNo + "\")'>To</button></td></tr> "+
								
								"<th>Line Info</th></tr><tr><td>Line Code : </td><td>"+
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
                		map.fitBounds(bounds);

                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
         });
	}

	

	function viewFrom(towerNo){
		document.getElementById("from").value=towerNo;
		
		
	}
	function viewTo(towerNo){
		document.getElementById("to").value=towerNo;
		
		
	}
	
	
	function loadMapWithoutMnt() {
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
		//var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewWOMNTAE/" + strArea +"/" + strLine,
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
								  if(data[0].supportType == 1){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }
								  else if(data[0].supportType == 2){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#5DADE2', fontWeight: 'bold', fontSize: '12px', text: 'P' }
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
								  }else if(data[0].supportType == 4){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
    	            					});
								  }else if(data[0].supportType == 5){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LG' }
    	            					});
								  }else if(data[0].supportType == 6){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LP' }
    	            					});
								  }else if(data[0].supportType == 7){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
								  }
								  
								  if(!!navigator.geolocation) {
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
        					
        					
        					var firstObj = json[i];
	        				var secondObj = json[i+1]; 
	        				
        					
        					(function(marker, data) {

        						
	        					
							/*  if(firstObj[0].lineId == secondObj[0].lineId){
								//var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	var distance = calcDistance(p1, p2);
   							    totalLength = distance + distance;
   							 	alert("hiiii2" + totalLength );
   							 	//var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	//alert("hiiii2 : " + calcDistance(p1, p2));
   							 	/* function calcDistance(p1, p2){
   								  alert("hiiii5");
   								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
   							 	} 

		   							
   							 }  */

							/* function calcDistance(p1, p2){
   								if(firstObj[0].lineId == secondObj[0].lineId){
        							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
        						}
 								  //alert("hiiii5");
 								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
 							} */
//alert(i);
        						function calcDistance(){
        							//alert("hiiii2 : " + i + secondObj[0]);
            						//if(!secondObj[0]){
            						
            						if(secondObj){
       								if(firstObj[0].lineId == secondObj[0].lineId){
            							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
            							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
            							// return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
            							return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2)).toFixed(2);
                 						  
                						}
       								else{
           								return '0';
           								}
            						}else{
           								return '0';
       								}
     								  //alert("hiiii5");
     								  // }
     							}

            					
        						//alert("hiiii3 : " + i + calcDistance());	
								
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
						/* 		var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Area : </td><td>"+
								
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
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
								"</table></div>"; */


								/* var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Area : </td><td>"+
								
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1]+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
							
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"</table></div>"; */
								
	var lineType;
								
								if(data[3].lineType == 1){
									lineType = 'Backbone';
								}else{
									lineType = 'Distributor';
								}
								
								
								var noOfCiur;
								
								if(data[0].noOfCircuits == 1){
									noOfCiur = 'Single';
								}else if (data[0].noOfCircuits == 2){
									noOfCiur = 'Double';
								}else{
									noOfCiur = 'Both';
								}
								
								var towerNo = data[0].towerNo;
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr>"+
								"<tr><td><button type='button' id='myBtn'  onClick='viewFrom(\"" + data[0].towerNo + "\")'>From</button></td><td><button type='button' id='myBtn'  onClick='viewTo(\"" + data[0].towerNo + "\")'>To</button></td></tr> "+
								
								"<tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr><td>Line Name : </td><td>"+
								
								data[3].lineName+"</td></tr><tr><td>Line Length(km) : </td><td>"+
								
								data[3].length+"</td></tr><tr><td>Line Type : </td><td>"+
								
								lineType+"</td></tr><tr><td>No. of Towers : </td><td>"+
								
								data[3].nooftowers+"</td></tr><tr><td>No. of Poles : </td><td>"+
								
								data[3].noofpoles+"</td></tr><tr><td>Area : </td><td>"+
								
								data[5]+"</td></tr><tr><th>Technical Detail</th></tr>"+
								"</tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[1]+"</td></tr>"+
								"<tr><td>No. of Circuits :  </td><td>"+noOfCiur+"</td></tr>"+
								"<tr><td>Tower Conf :  </td><td>"+								
								data[4]+"</td></tr>"+
								"<tr><td>Tappings :</td><td>"+data[0].tapping+"</td></tr>"+
								/* "<tr><td><button type='button' onclick='window.location.href='addProvince''>Back</button></td></tr> "+
								 *//* "<tr><td><a href='<c:url value="/editCompletionData"> <c:param name='towerNo'>${towerNO}</c:param></c:url>'>Add Completion Data</a></td><td></td></tr>"+
								 */"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								/* "<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								 */"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
									/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								 */"</table></div>";


								
								
								
								/* function showMore(id) {
					                  alert('my id is ' + id);
					            }
								 function showShops() {
								 var  content=document.createElement('div'),
					              button;
					              content.innerHTML='some text<br/>';
					              button=content.appendChild(document.createElement('input'));
					              button.type='button';
					              button.value='click me!'
					              google.maps.event.addDomListener(button,'click', function(){
					                                                                 showMore('1');})
								
								 }
	 */
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
	            							document.getElementById("mailContent2").value=towerNo;
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
                
         });
		
	}


	
	function view(id){
		//alert(id);	
		
		var strUser = id;
		//var strUser = 3550;
		//3550
		

		$.ajax({
					type : 'GET',
					url : "/MMS/getLatestMaintenance/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						
		
						 
						 var y = document.getElementById("fungussets");
						 var z = document.getElementById("flashoversets");
						 var w = document.getElementById("wpinsets");
						 var v = document.getElementById("endfittingsets");
						 var a = document.getElementById("jumperstatus");
						 var b = document.getElementById("conductorcondition");
						 var c = document.getElementById("earthconductorcondition");
						 var d = document.getElementById("missingmembers");
						 var e = document.getElementById("anticlimbingstatus");
						 var f = document.getElementById("legpaintingrequirement");
						 var g = document.getElementById("baseconcretestatus");
						 var h = document.getElementById("wayleavestatus");
						 var i = document.getElementById("specialobservations");
						 var j = document.getElementById("maintenanceattention");
						 var k = document.getElementById("hotlinepossibility");
						 	
						 	
						 	
						 	if (y.innerHTML === "fungussets") { 
				                y.innerHTML = data.fungussetno; 
				            }
						 	
						 	if (z.innerHTML === "flashoversets") { 
				                z.innerHTML = data.nofflashoversets; 
				            }
						 	
						 	if (w.innerHTML === "wpinsets") { 
				                w.innerHTML = data.wpinset; 
				            }
						 	
						 	if (v.innerHTML === "endfittingsets") { 
				                v.innerHTML = data.endfittingset; 
				            }
						 	
						 	if (a.innerHTML === "jumperstatus") { 
				                a.innerHTML = data.jumperstatus; 
				            }
						 	
						 	if (b.innerHTML === "conductorcondition") { 
				                b.innerHTML = data.conductorstatus; 
				            }
						 	
						 	if (c.innerHTML === "earthconductorcondition") { 
				                c.innerHTML = data.earthconductorstatus; 
				            }
						 	
						 	if (d.innerHTML === "missingmembers") { 
				                d.innerHTML = data.noofmissingparts; 
				           }
						 	
						 	if (e.innerHTML === "anticlimbingstatus") { 
				                e.innerHTML = data.anticlimbingstatus; 
				            }
						 	
				            if(f.innerHTML === "legpaintingrequirement"){
				               f.innerHTML = data.legPainting;
				            }
				            
				            if(g.innerHTML === "baseconcretestatus"){
				               g.innerHTML = data.baseconcretestatus;
				            }
				            
				            if(h.innerHTML === "wayleavestatus"){
				               h.innerHTML = data.wayleavestatus;
				            }
				            
				            if(i.innerHTML === "specialobservations"){
				               i.innerHTML = data.comments;
				            }
				            
				            if(j.innerHTML === "maintenanceattention"){
				               j.innerHTML = data.attentionstatus;
				            }
				            
				            if(k.innerHTML === "hotlinepossibility"){
				               k.innerHTML = data.hotpossible;
				               
				               if(data.hotpossible == 1){
				            	   k.innerHTML = "Possible";
				               }
				            	   else{
				            		   k.innerHTML = "Impossible";
				               }
				            }
				            
						
						 
										
				
						
						}
				});

		
		
	}	
	
	
	
	function validateFormNew()
	{
		//alert('hiiiiiiiiiiii');
		var empt = document.getElementById("from").value;
		var emptTo = document.getElementById("to").value;
		//var mailContent1 = document.getElementById("mailContent1").value;
		var mailContent2 = document.getElementById("mailContent2").value;
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		
		
		/* if (empt === "")
		{
			alert("From may not be empty");
			event.preventDefault();
			return false;
		}else if (emptTo === ""){
			alert("To may not be empty");
			event.preventDefault();
			return false;
		}else if (mailContent1 === ""){
			alert("Requirement may not be empty");
			event.preventDefault();
			return false;
		} else if (mailContent2 === ""){
			alert("Requirement may not be empty");
			event.preventDefault();
			return false;
		}else */ if (strArea === "NONE"){
			alert("Area may not be empty");
			event.preventDefault();
			return false;
		}else if (strLine === "NONE"){
			alert("Line may not be empty");
			event.preventDefault();
			return false;
		}else if (strLine === "LINE"){
			alert("Line may not be empty");
			event.preventDefault();
			return false;
		}/* else if(empt.length > 200){
			alert("Maximum Length Exceeded");
			event.preventDefault();
			return false;

		} */else{
			return true;
		}
		return true;
	
	}
	
	function getCSC()

	{			
			
		var strUser = area.options[area.selectedIndex].value;
		//alert(strUser);	
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findAllCSCByArea/" + strUser + "/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   //alert("success");
	                	 $('#csc').empty();
	                     //Insert item from the response
	                     for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	                         $('#csc').append($('<option>').text(item.deptNm).attr('value', item.deptId));
	                     }
	                 }
	          });		
		 
		
	}
	
	function getSinNumber()

	{			
			
		var strUser = area.options[area.selectedIndex].value;
		//alert(strUser);	
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findSinNoByArea/" + strUser + "/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(data) 
	                 {   //alert("success");
	                	 var slctSubcat = $('#sinnumber'), option = "<option value='NONE' selected='selected'>Please select</option>";
							
	                	 slctSubcat.empty();
	                     //Insert item from the response
	                     /* for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	                         slctSubcat.append($('<option>').text(item.sinNo).attr('value', item.sinNo));
	                     }
	                      */
	                     
	                     for (var i = 0; i < data.length; i++) {
								option = option
										+ "<option value='"+data[i].sinNo + "'>"
										+ data[i].sinNo + "</option>";
							}
							slctSubcat.append(option);

	                 }
	          });		
		 
		
	}
	
	
	function getSinLocation()

	{			
			
		var sinNo = sinnumber.options[sinnumber.selectedIndex].value;
		//alert(strUser);	
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findPCBModelBySinNo/" + sinNo + "/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   document.getElementById("locationsin").value = response[1].locationDescription;
	                	 document.getElementById("demand").value = response[0].capacity;
	                	 myMapTransformer(new google.maps.LatLng(7.475214, 80.744077), 7,response[1].gpsLatitude,response[1].gpsLongitude,response[0].sinNo);
	                 }
	          });		
		 
		
	}
	
	function findAccountNo()

	{			
			
		var accountNo = document.getElementById("accountnumber").value;
		
		$.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/getAccountNoDetail?account_no="+accountNo,
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 { if(response.customer){
	                	 document.getElementById("locationsin").value = response.customer.name + '-' + response.customer.address_1 + '-'+response.customer.address_2;
	                	 document.getElementById("tariff").value = response.customer.tariff;
	                	 document.getElementById("contact").value = response.customer.mobile_no;
	                	 document.getElementById("demand").value = response.customer.cntr_dmnd;
				             
	                 }else{
	                	 document.getElementById("locationsin").value = '';
	                	 document.getElementById("tariff").value = '';
	                	 document.getElementById("contact").value = '';
	                	 document.getElementById("demand").value = '';
			              
	                	 alert('Account number not found');
	                 }
	                	 
	                 }
	          });		
		 
		
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
										<li class="active"><span>METER REQUEST</span></li>
									
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					
										

					<div class="row">
					<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
					</div>
 --> 					
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<div class="main-box-body clearfix">
									<!-- <div class="table-responsive">
									 -->	<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" enctype="multipart/form-data" action="MeterTestingRequestS"	modelAttribute="model">
													<form:hidden path="mode" />
														
													<c:set var="myVar" value="${model.mode}" />
													
													<c:if test="${not empty model.message}">
												<tr>
												<td colspan="2" class="msgSuccess" align="center">
										
												<div class="msgSuccess">
													<c:out value="${model.message}"></c:out>
												</div>
								
												</tr>
												</c:if>
					
					<c:if test="${not empty model.error}">
										<tr>
										<td colspan="2" class="msgError" align="center">
										
									<div class="msgError">
										<c:out value="${model.error}"></c:out>
									</div>
								
						</tr>
					</c:if>
					
					<tr>
															<td width="20%" style="text-align: left">Area</td>
															<td width="80%" style="text-align: left"><form:select id="area" path="area"
																onchange="getCSC();getSinNumber();" class="form-control">
																<form:option value="NONE">Please select....</form:option>
																	
																<form:options items="${model.areaList}" />
															</form:select></td>
														</tr>
<tr>
															<td width="20%" style="text-align: left">CSC</td>
															<td width="80%" style="text-align: left"><form:select id="csc" path="csc"
																onchange="" class="form-control">
																<form:options items="${model.cscList}" />
															</form:select></td>
														</tr>

 													 <tr>
															<td width="20%" style="text-align: left">Locational Details of the substation/customer</td>
															<td width="70%" style="text-align: left"><form:input path="locationsin" id ="locationsin" class="form-control"/></td>
															
														</tr>
														
														<tr>
															<td width="20%" style="text-align: left">Sin Number</td>
															<td width="80%" style="text-align: left"><form:select id="sinnumber" path="sinnumber"
																onchange="getSinLocation()" class="form-control">
																<form:option value="NONE">Please select....</form:option>
																
																
																<form:options items="${model.sinList}" />
															</form:select></td>
														</tr>
														<tr>
															<td width="20%" style="text-align: left">Account Number</td>
															<td width="70%" style="text-align: left"><form:input path="accountnumber" id ="accountnumber" class="form-control"/><input
																	class="btn btn-success" type="button"
																	name="actionButton" value="Find" onclick="findAccountNo()" class="form-control"></input>
														</td>
															
														</tr>
 													<tr>
															<td width="20%" style="text-align: left">Tariff</td>
															<td width="70%" style="text-align: left"><form:input path="tariff" id ="tariff" class="form-control"/></td>
															
														</tr>
														<tr>
															<td width="20%" style="text-align: left">Demand</td>
															<td width="70%" style="text-align: left"><form:input path="demand" id ="demand" class="form-control"/></td>
															
														</tr>
 													
 														<tr>
															<td width="20%" style="text-align: left">Contact Details</td>
															<td width="70%" style="text-align: left"><form:input path="contact" id ="contact" class="form-control"/></td>
															
														</tr>
														
														<tr>
															<td width="20%" style="text-align: left">CT Ratio:</td>
															<td width="80%" style="text-align: left"><form:select
																	id="ctratio" path="ctratio" onchange=""  class="form-control">
																	<form:option value="50/5">50/5</form:option>
																	<form:option value="100/5">100/5</form:option>
																	
																	
																	<form:option value="200/5">200/5</form:option>
																	<form:option value="400/5">400/5</form:option>
																	<form:option value="600/5">600/5</form:option>
																	
																	<form:option value="800/5">800/5</form:option>
																	<form:option value="1000/5">1000/5</form:option>
																	<form:option value="1200/5">1200/5</form:option>
																	<form:option value="1600/5">1600/5</form:option>
																	
																	<form:option value="Other">Other</form:option>
																	</form:select></td>

														</tr>
														
 													
 													<tr>
															<td width="20%" style="text-align: left">Order</td>
															<td width="80%" style="text-align: left"><form:select multiple="true"
																	id="order" path="order" onchange=""  class="form-control">
																	<form:option value="Test the meter">Test the meter</form:option>
																	<form:option value="Fix a new meter">Fix a new meter</form:option>
																	<form:option value="Remove the meter">Remove the meter</form:option>
																	<form:option value="Change the meter">Change the meter</form:option>
																	<form:option value="Connect the supply">Connect the supply</form:option>
																	<form:option value="Disconnect the supply">Disconnect the supply</form:option>
																	<form:option value="Insert new sim">Insert new sim</form:option>
																	<form:option value="Change CT">Change CT</form:option>
																	<form:option value="Test CT">Test CT</form:option>
																	<form:option value="Rearrange wiring">Rearrange wiring</form:option>
																	<form:option value="Check RMR">Check RMR</form:option>
																	<form:option value="Harmonic test - Bulk">Harmonic test - Bulk</form:option>
																	<form:option value="New meter Installation - Solar - NetPlus">New meter Installation - Solar - NetPlus</form:option>
																	
																	                                        
																	</form:select></td>

														</tr>
 													
 													
 							<tr>
																<td width="30%" style="text-align: left">Additional work</td>
																<td width="70%" style="text-align: left"><form:textarea path="additionalwork" rows="5" cols="60" id ="additionalwork" class="form-control"/></td>
																
																</tr>
																																	
														<%--  <tr>
															<td width="20%" style="text-align: left">Responsible ES</td>
															<td width="80%" style="text-align: left"><form:select
																	id="userIdEE" path="sausermEE.userId" onchange=""  class="form-control">
																	
																	<form:options items="${model.esList}" />
																</form:select></td>

														</tr>
 --%>														 
														 		
																<tr>
																<td width="20%" style="text-align:left">
                												File to upload:
                												</td>
                												<td width="80%" style="text-align:left">
																<input  type="file" name="file" class="form-control">
																</td>
																    
        														
        														        														<tr>
															<td style="text-align: left"><a
																href=""> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Create" onclick="" class="form-control"></input></a></td>
														</tr>
														
														
														
        														
															
												</form:form>

											</tbody>
										</table>
									<!-- </div> -->
								</div>
							</div>
						</div>
					</div>



<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>





					<!-- <div class="row">
                            <div class="col-lg-12">

                                 <header class="main-box-header clearfix">
                                    <h2 class="pull-left">List of Support</h2>
                                </header>

                                
                            </div>
                        </div> -->


					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title" id="myModalLabel">View Tower Maintenance Data</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		      </div>
		       <div class="modal-content">
                                <label>Maintenance Details</label><br>
                                <p1>Fungus Sets:<label id="fungussets">fungussets</label></p1><br>
                                <p1>Flash Over Sets:<label id="flashoversets">flashoversets</label></p1><br>
                                <p1>W Pin Sets:<label id="wpinsets">wpinsets</label></p1><br>
                                <p1>End Fitting Sets:<label id="endfittingsets">endfittingsets</label></p1><br>
                                <p1>Jumper Status:<label id="jumperstatus">jumperstatus</label></p1><br>
                                <p1>Conductor Condition:<label id="conductorcondition">conductorcondition</label></p1><br>
                                <p1>Earth Conductor Condition:<label id="earthconductorcondition">earthconductorcondition</label></p1><br>
                                <p1>Missing Members:<label id="missingmembers">missingmembers</label></p1><br>
                                <p1>Anti Climbing Status:<label id="anticlimbingstatus">anticlimbingstatus</label></p1><br>
                                <p1>Leg Painting Requirement:<label id="legpaintingrequirement">legpaintingrequirement</label></p1><br>
                                <p1>Base Concrete Status:<label id="baseconcretestatus">baseconcretestatus</label></p1><br>
                                <p1>Way leave status:<label id="wayleavestatus">wayleavestatus</label></p1><br>
                                <p1>Special Observations:<label id="specialobservations">specialobservations</label></p1><br>
                                <p1>Maintenance Attention:<label id="maintenanceattention">maintenanceattention</label></p1><br>
                                <p1>Hot Line Possibility:<label id="hotlinepossibility">hotlinepossibility</label></p1><br>
                                
                             </div>

		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>


</body>

</html>
