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
	height: 500px;
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



	function viewComplain() {

		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		
		$.ajax
        ({
                type: 'GET',
                url: '/MMS/Complain/getNewComaplin/',
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
						alert('hiiii');
						alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],

        					
        						latLng = new google.maps.LatLng(data[1].id.locationLat, data[1].id.locationLon);
        						latLng2 = new google.maps.LatLng(data[3].locationLat, data[3].locationLon);


        						

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

									
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	            						title: "Complaint Number : "+data[0].complaintNo
	            					});

	            					var marker = new google.maps.Marker({
	            						position: latLng2,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
	            						title: "Crew Name : "+data[3].crewName
	            					});
									
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			    //path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				        //  strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      //  flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {

        						google.maps.event.addListener(marker, "click", function(e) {
        							infoWindow.setContent("<table><tr>Breakdown Detail :</tr>"
                					+"<tr><td>Acct Number : </td><td>"+data[0].acctNum+"</td></tr>"
                					+"<tr><td>Area Code : </td><td>"+data[2].areaCode+"</td></tr>"
                					+"<tr><td>BD Date : </td><td>"+data[0].bdDate+"</td></tr>"
                					+"<tr><td>BD Time : </td><td>"+data[0].bdTime+"</td></tr>"
                					+"<tr><td>Complain No : </td><td>"+data[0].complaintNo+"</td></tr>"
                					+"<tr><td>Ref No : </td><td>"+data[0].refNo+"</td></tr>"
                					+"<tr><td>Status : </td><td>"+data[0].status+"</td></tr>"
                					+"<tr><td><a href='<c:url value="/addSupportNew?id=9999999999"/>'>Job Assign</a></td><td></td></tr>"+
            								
                					+"</table>");
        							infoWindow.open(map, marker);
        						});


        					})(marker, data);


        					/* (function(marker1, data) {

        						google.maps.event.addListener(marker1, "click", function(e) {
        							infoWindow.setContent("<table><tr>Breakdown Crew Detail :</tr>"
                					+"<tr><td>Access Code : </td><td>"+data[3].accessCode+"</td></tr>"
                					+"<tr><td>Crew name : </td><td>"+data[3].crewName+"</td></tr>"
                					+"<tr><td>Area Code : </td><td>"+data[3].ccCode+"</td></tr>"
                					+"</table>");
        							infoWindow.open(map, marker1);
        						});


        					})(marker1, data); */

        				}
                		map.fitBounds(bounds);
        				
                }
                
         });
	}



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
			loadMap(new google.maps.LatLng(7.475214, 80.744077), 7);
		}else{
			loadNetwork();
		}
		
	}

	function loadMap(LatLng, zoom){
		alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"),
				{
					//center: new google.maps.LatLng(7.475214, 80.744077),
					center : LatLng,
					zoom : zoom,
					gestureHandling : 'greedy',
					mapTypeId : google.maps.MapTypeId.ROADMAP
				});
		alert('hiii2');
		
		

		
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
		<%@ include file="sections/headerOMS.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevelsPNG.jsp"%>

				<div id="content-wrapper">
					<div class="row">


						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Dashboard</span></li>
								</ol>

								
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


								<div class="col-sm-2" align="left">
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
																<form:option value="NONE" label="CSC" />
																<form:options items="${model.cscList}" />
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
																onClick='viewComplain()'>View</button>
														</div>
													</div>
												</div>

											</div>
										</form:form>
									</div>
								</div>

								<div class="col-sm-10" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>

							</div>
						</div>
					</div>



					<div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">

									<div class="col-lg-4 col-sm-6 col-xs-12">
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
												<div style="height: 220px">
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
																				<td><strong>Lines</strong></td>
																				<td><strong>${summary[0]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Line length</strong></td>
																				<td><strong>${summary[1]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Towers</strong></td>
																				<td><strong>${summary[2]}</strong></td>
																			</tr>
																			<tr>
																				<td><strong>Poles</strong></td>
																				<td><strong>${summary[3]}</strong></td>
																			</tr>

																		</c:forEach>																	</table>
																</div>
															</div>
														</div>
													</div>
												</div>

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
													<a href="ViewDataAssetInfo"><center>
															<strong>Asset Information</strong>
														</center></a>
												</h4>
												<div style="height: 220px">
													<h4>
														<strong>Summary</strong>
													</h4>

													<div style="overflow-x: auto;">
														<div class="card card-plain">
															<div class="card-body">
																<div class="table-responsive">
																	<table class="table table-hover"
																		style="border: 2px solid #809c79; background-color: #d6e3c1; width: 100%;">

																		<tr>
																			<td><a href="<c:url value='/viewLinetypes' />"><center>
																						<strong>View Line Master Data</strong>
																					</center></a></td>

																		</tr>
																		<tr>
																			<td><a href="<c:url value='/viewLine' />"><center>
																						<strong>View Line & Support</strong>
																					</center></a></td>

																		</tr>
																		<tr>
																			<td><a
																				href="<c:url value='/viewTowerMaintenance' />"><center>
																						<strong>View Maintenance Data</strong>
																					</center></a></td>
																		</tr>
																		<tr>
																			<td><a href="<c:url value='/viewDataMV' />"><center>
																						<strong>P & E Summary</strong>
																					</center></a></td>
																		</tr>

																	</table>
																</div>
															</div>
														</div>
													</div>

												</div>

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
													<i class="fa fa-cogs" style="color: #008080"></i>
												</center>
												<h4>
													<a href=""><center>
															<strong>Maintenance Planning</strong>
														</center></a>
												</h4>
												<div style="height: 220px">
													<h4>
														<strong>Summary</strong>
													</h4>

													<div style="overflow-x: auto;">
														<div class="card card-plain">
															<div class="card-body">
																<div class="table-responsive">
																	<table class="table table-hover"
																		style="border: 2px solid #809c79; background-color: #d6e3c1; width: 100%;">

																		<tr>
																			<td><a href=""><center>
																						<strong>Approve Data</strong>
																					</center></a></td>

																		</tr>
																		<tr>
																			<td><a href=""><center>
																						<strong>Work Estimates</strong>
																					</center></a></td>

																		</tr>
																		<tr>
																			<td><a href=""><center>
																						<strong>Inprogress</strong>
																					</center></a></td>
																		</tr>
																		<tr>
																			<td><a href=""><center>
																						<strong>History Analysis</strong>
																					</center></a></td>
																		</tr>

																	</table>
																</div>
															</div>
														</div>
													</div>

												</div>

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
													<i class="fa fa-user-plus" style="color: #008080"></i>
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

									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0">
												<center>
													<i class="fa fa-window-restore" style="color: #008080"></i>
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
													<i class="fa fa-list-alt" style="color: #008080"></i>
												</center>
												<h4>
													<a href=""><center>
															<strong>P&E Summary</strong>
														</center></a>
												</h4>
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
</body>
</html>