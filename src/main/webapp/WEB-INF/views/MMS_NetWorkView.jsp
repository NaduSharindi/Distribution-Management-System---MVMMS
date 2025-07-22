<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MV-MMS Map</title>
	
	<!-- bootstrap -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"/>
	
	<!-- RTL support - for demo only -->
	<script src="<c:url value="/resources/js/demo-rtl.js"/>">
	</script>
	<!-- 
	If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
	And add "rtl" class to <body> element - e.g. <body class="rtl"> 
	-->
	
	<!-- libraries -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/font-awesome.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/nanoscroller.css"/>"/>

	<!-- global styles -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/compiled/theme_styles.css"/>"/>

	<!-- this page specific styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/fullcalendar.css"/>"/>
    <link rel="stylesheet" type="text/css" media="print" href="<c:url value="/resources/css/libs/fullcalendar.print.css" />"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/compiled/calendar.css" />"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/morris.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/daterangepicker.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>"/>
	
	<!-- Favicon -->
	<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

	<!-- google font libraries -->
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400' rel='stylesheet' type='text/css'>

	<style type="text/css">
	div#map_container{
		width:100%;
		height:1000px;
	}
	
	.modal-title {
    margin: 0;
    line-height: 1.428571429;
    text-align: center;
	}
	</style>

	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c">
	
	</script>
	
	
	<script type="text/javascript">
		
		

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


			function getLine(){
				//var categoryId = $(this).val();
				//alert("hiii");
				var strUser = area.options[area.selectedIndex].value;
				//alert("hiiittt : "+strUser);
				//findAllAreaByProvinceNew

				$.ajax
	             ({
	                     type: 'GET',
	                     url: "/MMS/findLineByArea/" + strUser +"/",
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(data) 
	                     {
	                    	 var slctSubcat=$('#line'), option="<option value='NONE'>ALL</option>";
	                         slctSubcat.empty();
	                         for(var i=0; i<data.length; i++){
	                             option = option + "<option value='"+data[i].code + "'>"+data[i].lineName + "</option>";
	                         }
	                         slctSubcat.append(option);

	                    	 //alert("response.towerNo" + data);	
	                     }
	              });	

				
			}


			function findArea(){
				//var categoryId = $(this).val();
				//alert("hiii");
				var strUser = province.options[province.selectedIndex].value;
				//alert("hiiittt : "+strUser);
				//findAllAreaByProvinceNew

				$.ajax
	             ({
	                     type: 'GET',
	                     url: "/MMS/findAllAreaByProvinceNew/" + strUser,
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(data) 
	                     {
	                    	 var slctSubcat=$('#area'), option="<option value='NONE'>ALL</option>";
	                         slctSubcat.empty();
	                         for(var i=0; i<data.length; i++){
	                             option = option + "<option value='"+data[i].deptId + "'>"+data[i].deptNm + "</option>";
	                         }
	                         slctSubcat.append(option);

	                    	 //alert("response.towerNo" + data);	
	                     }
	              });	

				
			}
	

		
	</script>

</head>
<body>

<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		
		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp" %>
				
				<div id="content-wrapper">
				
				<div class="row">
					<div class="col-lg-12">		                                    
	                        <div class="col-lg-9">
	                            <ol class="breadcrumb">
	                                <li><a href="#">Home</a></li>
	                                <li class="active"><span>Map</span></li>
	                            </ol>
	
	                            <h1>View Map</h1>
	                        </div>
				                                    
							<%@ include file="sections/userDetails.jsp" %> 
						</div>
					</div>
							<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">MAP View   </h2>
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	
																</thead>
																<tbody>
																<form:form  method="post" action="viewSupportByProvince" modelAttribute="model">
																 <table class="table table-responsive" id="tblProvinces">
			
													     	<tr>
																<td width="30%" style="text-align:left">
                												<form:label path="">PROVINCE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select  id="province" path ="glcompmobj.compId" onchange="findArea()">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">AREA</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																
																<form:select  id="area" path ="gldeptobj.deptId" onchange="getLine()">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.areaList}"/>
																</form:select>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">LINE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select  id="line" path ="line.code" onchange="">
                												
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.lineList}"/>
																</form:select>
																
																 </td>   
        														</tr>										
        														<tr>
        														<td  style="text-align:left"   >
        														<td><button type='button' class='btn btn-success' onClick='loadMap()'>View</button>
        														</td>
        														</tr>
        														 </table>
        														</form:form>
        														
        														</tbody>
															</table>
														</div>
														
													</div>
					

					<div class="row">
					<div id="map_container"></div>
						<!-- div class="col-lg-6">
							<div class="main-box">
								<header class="main-box-header clearfix">
									<h2>View Map</h2>
								</header>

								<div class="main-box-body clearfix">
								
									<div id="map_container"></div>
									
								</div>
							</div>
						</div-->

					</div>

					<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
		
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title" id="myModalLabel">View Tower Maintenance Data</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <h6><b>Visit ID</b> : 002</h6>
		        <h6><b>Tower ID</b> : 002A</h6>
		        <h6><b>Dept ID</b> : 501.00</h6>
		        <h6><b>Tappings</b> : 04</h6>
		        <h6><b>Missing Parts</b> : 06</h6>
		        <h6><b>Flash Over Sets</b> : 04</h6>
		        <h6><b>Way leaving Status</b> : Good</h6>
		        <h6><b>Base Concrete Status</b> : Bad</h6>
		        <h6><b>Anti Climbing Status</b> : Lost</h6>
		        <h6><b>Conductor Condition</b> : Danger</h6>
		        <h6><b>Jumper Condition</b> : Good</h6>
		        <h6><b>Earth Conductor Condition</b> : Damage</h6>
		        <h6><b>Maintenance Attention</b> : Urgent</h6>
		        <h6><b>Funguss Set No</b> : 07</h6>
		        <h6><b>WPIN set</b> : 02</h6>
		        <h6><b>End Fitting set</b> : 08</h6>
		        <h6><b>Special Observations</b> : No Observations</h6>
		        <h6><b>LUTD</b> : 2018-03-06T09:23</h6>
		        <h6><b>Maintenance Date</b> : 2018-03-06</h6>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <!-- Project Details Go Here -->
                                <h2>Project - Muthu Tours</h2>
                                <p class="item-intro text-muted"><a href="http://muthutoursmirissa.com"> muthutoursmirissa.com</a></p>
                                
                                <p>This is the initial project completed by teamMoraCodeX. Our task was to create the official
                                    website for a Tourism Service Provider in Mirissa, Sri Lanka. We had the capability of
                                    satisfying our customer by fulfilling his exact demands.</p>
                                <!--<p>
                                    <strong>Want these icons in this portfolio item sample?</strong>You can download 60 of them for free, courtesy of <a href="https://getdpd.com/cart/hoplink/18076?referrer=bvbo4kax5k8ogc">RoundIcons.com</a>, or you can purchase the 1500 icon set <a href="https://getdpd.com/cart/hoplink/18076?referrer=bvbo4kax5k8ogc">here</a>.</p>-->
                                <ul class="list-inline">
                                    <li>Date: May 2017</li><br>
                                    <li>Client: Muthu Tours, Mirissa, Sri Lanka.</li><br>
                                    <li>Category: Web Design</li>
                                </ul>
                                <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Exit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
		
	</body>
</html>