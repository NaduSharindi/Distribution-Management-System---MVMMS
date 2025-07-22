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


.form-control {
	display: inline-block;
	width: -webkit-fill-available;
	height: 34px;
	font-size: 12px;
	color: #0f1893;
	border-color: #095f9f;
	background-color: #fff;
	font-weight: 800;
	border-radius: 4px;
}


.msgSuccess {
	color: green;
	font-family: "Verdana", Times, serif;
	font-size: 15px;
	font-weight: bold;
	text-align: left;
}

.msgError {
	color: red;
	font-family: "Verdana", Times, serif;
	font-size: 15px;
	font-weight: bold;
	text-align: left;
}

</style>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
	
</script>


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
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
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
	
	function viewMapByMode(){
		var viewMode = mode.options[mode.selectedIndex].value;
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
                url: "/MMS/AEMapNew/" + strArea +"/" + strLine + "/",
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
								       						       
								var contentString = "<div style='float:right; padding: 10px;'><table id ='ss'><th>Line Info</th></tr><tr><td>Line Code : </td><td>"+
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
        						//bounds.extend(latLng);
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
								
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
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
								"<tr><td>Tappings :  </td><td></td></tr>"+
								/* "<tr><td><button type='button' onclick='window.location.href='addProvince''>Back</button></td></tr> "+
								 *//* "<tr><td><a href='<c:url value="/editCompletionData"> <c:param name='towerNo'>${towerNO}</c:param></c:url>'>Add Completion Data</a></td><td></td></tr>"+
								 */
								 "</table></div>";

								
								
								
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
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		//map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
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
									<c:if test="${type == 'INS'}">
										<li class="active"><span>INSPECTION REQUEST</span></li>
									</c:if>
									<c:if test="${type == 'MNT'}">
										<li class="active"><span>MAINTENANCE REQUEST</span></li>
									</c:if>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					
					<div class="col-sm-10" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
					</div>
					

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<!-- <header class="main-box-header clearfix">
								<h2 class="pull-left">
									<strong>COLD LINE ESTIMATE</strong>
								</h2>
								</header>
								 -->
																

								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" enctype="multipart/form-data" action="goToInsMntRequestSMNT"	modelAttribute="model">
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


													<%-- <table class="table table-responsive" id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Province</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Area</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()"
																	style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left"><strong>Electrical
																	Superintendent</strong></td>
															<td width="70%" style="text-align: left"><form:select
																	id="userId" path="sauserm.userId" onchange="" style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.saList}" />
																</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left"><strong>Applicant</strong></td>
															<td width="70%" style="text-align: left"><form:select
																	id="userId" path="applicant.idNo" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.appList}" />
																</form:select></td>

														</tr>
														
														<tr>
														
														
														<td width="30%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="" label="ALL" />
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
														
														
														
														
														
														
<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="method" path="cycle" onchange="" style="width:50%; background-color: #8187ff; border-radius: 5px;">

																	<form:option value="" label="ALL " />
																	<form:option value="201901" label="201901" />
																	<form:option value="201801" label="201801" />
																
																</form:select></td>
														</tr>



														<!-- <tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="GO"></input></a></td>
														</tr> -->

													</table>

 --%>





													<c:if test="${canGO =='1'}">
														<br>
														<%-- <c:if test="${type == 'INS'}">
										<h2 class="pull-left">
															<strong>Select Lines to Generate Inspection Request</strong>
														</h2>
														</c:if>
									<c:if test="${type == 'MNT'}">
										<h2 class="pull-left">
															<strong>Select Lines to Generate Maintenance Request</strong>
														</h2>
														</c:if>
														 --%>
														
														<br>
														<br>
														<table class="table table-responsive" id="tblAdmin">
															<%-- <thead>
																<tr>
																	<th class="text-center">Select</th>
																	<th class="text-center">Line Name</th>
																	<th class="text-center">Line Length</th>
																	<th class="text-center">No Of Poles</th>
																	<th class="text-center">No Of Towers</th>
																</tr>
															</thead>
															<tbody>

																<tr>
																	<td><form:label path="">line</form:label></td>

																	<td><form:checkboxes items="${model.listOfLines}"
																			path="selectedLines" /></td>
																	<td></td>
																</tr>


																<c:forEach var="Line" items="${model.lineListEdit}">
																	<tr>
																	<input type="hidden" id="id_${Line.id}"
																			value="${Line.id}" class="form-control" disabled>
																		<td><form:checkbox id="cb_${Line.id}" onclick=""
																				path="selectedLines" value="${Line.id}" /></td>
																		<td><input type="text" id="na_${Line.id}"
																			value="${Line.lineName}" class="form-control"
																			disabled></td>
																		<td><input type="text" id="ll_${Line.id}"
																			value="${Line.length}" class="form-control" disabled></td>
																		<td><input type="text" id="np_${Line.id}"
																			value="${Line.noofpoles}" class="form-control"
																			disabled></td>
																		<td><input type="text" id="nt_${Line.id}"
																			value="${Line.nooftowers}" class="form-control"
																			disabled></td>
																	</tr>
																</c:forEach>
																<tr>
 --%>
 <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">View</form:label></td>
															<td width="70%" style="text-align: left"><form:select id="mode" path="" onchange="viewMapByMode()"
																style="width:100%; background-color: #fff981; border-radius: 5px;">
																<form:option value="-1" label="Please select" />
																
																<form:option value="MAP" label="MAP VIEW" />
																<form:option value="NETWORK" label="NETWORK VIEW" />

															</form:select>


</td>
														</tr>
														
														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Area</form:label></td>
															<td width="70%" style="text-align: left"><form:select id="area" path="gldeptobj.deptId"
																onchange="getLine()"
																style="width:100%; background-color: #94cb71; border-radius: 5px;">
																<form:options items="${model.areaList}" />
															</form:select></td>
														</tr>
														
 																
 
 <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Line</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.code" onchange="viewMapByMode()"
																	style="width:100%; background-color: #8187ff; border-radius: 5px;">
																	<form:option value="NONE" label="All" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr>
 
																<td width="30%" style="text-align: left"><form:label
																	path="">Requirement</form:label></td>
																<td width="70%" style="text-align: left"><form:textarea path="mailContent" rows="5" cols="60" /></td>
																<td width="30%" style="text-align: left"><form:label
																	path="">Requesting section/s to be inspected</form:label></td>
																	<td width="70%" style="text-align: left"><form:textarea path="mailContent2" rows="5" cols="60" /></td>
																
																</tr>
																<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file">
																</td>
																    
        														</tr>
        														<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file1">
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file2">
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file3">
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file4">
																</td>
																    
        														</tr>
        														
        														
															</tbody>
														</table>
													</c:if>





													<c:if test="${canGO =='3'}">
														<br>
														<h2 class="pull-left">
															<strong>COLD LINE ESTIMATE</strong>
														</h2>
														<br>
														<br>
														<table class="table table-responsive" id="tblAdmin">
															<tbody>
																<tr>

																	<td width="40%" style="text-align: left">Total
																		Line Length</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.totalLineLength"
																			value="${inspection.totalLineLength}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Total
																		Number of Towers</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.totalNoTowers"
																			value="${inspection.totalNoTowers}" readonly="true"></form:input>

																	</td>
																</tr>
																<%-- <tr>
																	<td width="40%" style="text-align: left">Number of
																		days for the Inspection (C)</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.noDaysForTheIns"
																			value="${inspection.noDaysForTheIns}" readonly="true"></form:input>

																	</td>
																</tr> --%>
																<tr>
																	<td width="40%" style="text-align: left">Labour
																		Hours for the Estimate (D 1)</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.labourHoursForEst"
																			value="${inspection.labourHoursForEst}"
																			readonly="true"></form:input></td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Labour
																		value for the Estimate (D) LKR</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.labourValueForEst"
																			value="${inspection.labourValueForEst}"
																			readonly="true"></form:input></td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Subsistance
																		(E) LKR</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.subsistance"
																			value="${inspection.subsistance}" readonly="true"></form:input>

																	</td>
																</tr>
																<%-- <tr>
																	<td width="40%" style="text-align: left">Hot line
																		Allowance (F) LKR</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.hotLineAllowances"
																			value="${inspection.hotLineAllowances}"
																			readonly="true"></form:input></td>
																</tr>
																 --%><tr>
																	<td width="40%" style="text-align: left">Temporarily
																		site cost LKR </td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.temporarySiteCost"
																			value="${inspection.temporarySiteCost}"
																			readonly="true"></form:input></td>
																</tr>

																<tr>
																	<td width="40%" style="text-align: left">Transport
																		Cost</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.transport"
																			value="${inspection.transport}" readonly="true"></form:input>

																	</td>
																</tr>
																	<tr>
																	<td width="40%" style="text-align: left">Material
																		Cost -C0138</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.matC0138"
																			value="${inspection.matC0138}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Material
																		Cost -C0190</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.matC0190"
																			value="${inspection.matC0190}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Material
																		Cost -C0180</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.matC0180"
																			value="${inspection.matC0180}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Material
																		Cost -C0143</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.matC0143"
																			value="${inspection.matC0143}" readonly="true"></form:input>

																	</td>
																</tr>
																
																
																
																
																<tr>
																	<td width="40%" style="text-align: left">Total </td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.tatalCost"
																			value="${inspection.tatalCost}" readonly="true"></form:input>

																	</td>
																</tr>


																<!-- <tr>
															<td style="text-align: left"><input
																class="btn btn-success" type="submit"
																name="actionButton" value="Save"></input></td>
														</tr> -->

															</tbody>
														</table>
														
																													
														
														
													</c:if>

													<c:if test="${canGO =='1'}">
														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Generate"></input></a></td>
														</tr>
													</c:if>
													<c:if test="${canGO =='2'}">
														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Go To Estimate"></input></a></td>
														</tr>
													</c:if>
													 <c:if test="${canGO =='3'}">
													 <table>
														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Save"></input></a></td>
														</tr>
														
														
			<!-- <tr>
			<td>Inception Estimate for the Area</td>
			
			</tr>																									
 <tr>
    <td>Total Line Length in Area</td>
    <td>A</td>
   
  </tr>
  <tr>
    <td>Total Number of Towers in Area</td>
    <td>B</td>
    
  </tr>
  <tr>
    <td>Number of days for the Inspection(C)</td>
    <td>B/27</td>
    
  </tr>
  <tr>
    <td>Labour Hours for the Estimate(D1)</td>
    <td>9*C*9</td>
 
  </tr>
  <tr>
    <td>Labour value for the Estimate(D)LKR</td>
    <td></td>
    
  </tr>
  <tr>
    <td>Subsistance(E)LKR</td>
    <td>D1*400/9*(30/22)</td>
   
  </tr>
  <tr>
    <td>Hot line Allowance(f)LKR</td>
    <td>16000*C</td>
   
  </tr>
  <tr>
    <td>Hot line Allowance(f)LKR</td>
    <td>16000*C</td>
   
  </tr>
  <tr>
    <td>Transport (Manual input -province -"X")(g)  </td>
    <td>B*"X"</td>
   </tr>
   <tr>
    <td>Transport Cost  </td>
    <td>G*45+G*55</td>
   </tr>
   <tr>
    <td>Temporarly site cost LKR(Minimum 30,000)  </td>
    <td>B*"X"</td>
   </tr>
   <tr>
    <td>Total Inspection Estimate   </td>
    <td></td>
   </tr>
  
</table>
<br>
<table >
  <tr>
    <th>Province</th>
    <th>Km</th>
  </tr>
  <tr>
    <td>WPN</td>
    <td>4</td>
  </tr>
   <tr>
    <td>CP</td>
    <td>8</td>
  </tr>
   <tr>
    <td>EP</td>
    <td>8</td>
  </tr>
  <br>
  <tr>
    <td>27 Towers/Day will be inspected</td>
  </tr>
  <tr>
    <td>3 people per group and 3 Group will be there</td>
  </tr>
   <tr>
    <td>9 Hours per day will be working.</td>
  </tr>
</table> -->
														
														
														
														</c:if>

														
														
													
													<%-- <c:if test="${canGO =='true'}">
														<tr>
															<td colspan="2"><button type="button"
																	class="btn btn-success"
																	onclick="window.location.href=<c:url value='/ViewInsEstDetail?nooftower=${summary[4]}&lineLength=${summary[3]}&id=${summary[0]}&dd=${dd}&province=${province}&area=${summary[1]}' />">Go
																	To Estimate</button></td>
														</tr>
														<!-- <tr>
															<td colspan="2"><button type="button"
																	class="btn btn-success"
																	onclick="window.location.href='ViewInsEstDetailNew'">Go
																	To Estimate</button></td>
														</tr> -->
														
													</c:if> --%>

												</form:form>

											</tbody>
										</table>
									</div>
								</div>
							</div>
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


</body>

</html>
