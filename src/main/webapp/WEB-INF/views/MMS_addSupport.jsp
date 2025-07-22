<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<style type="text/css">
		.mybtn{
			background-color: #e74c3c;
			padding: 1px 4px;
			display: inline-block;
			text-align: center;
			font-weight: 800;
			touch-action: manipulation;
			background-image: none;
			white-space: nowrap;
			font-size: 20px;
			float: right;
		
		}
	
	</style>
	
	 <script 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>
  
  <style type="text/css">



div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}
  </style>
	
	
	<script type="text/javascript">

	function getLine()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllLineByStatusNew/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                         //alert(response);
                    	 $('#cmbSelectLine').empty();
                         //Append "None" item
                         $('#cmbSelectLine').append($('<option>').text("<< Select Line >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectLine').append($('<option>').text(item.lineName).attr('value', item.id));
                         }
                     }
              });		
	}
	
		function getAreas()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findAllAreaNew/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectArea').empty();
	                         //Append "None" item
	                         $('#cmbSelectArea').append($('<option>').text("<< Select Area >>").attr('value', ""));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectArea').append($('<option>').text(item.deptNm).attr('value', item.deptId));
	                         }
	                     }
	              });		
		}
		
		function getCsc()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveCSC/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectCsc').empty();
	                         //Append "None" item
	                         $('#cmbSelectCsc').append($('<option>').text("<< Select CSC >>").attr('value', ""));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectCsc').append($('<option>').text(item.csc).attr('value', item.csc));
	                         }
	                     }
	              });		
		}
		
		function getConductorTypes()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveConductorTypes/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectConductorType').empty();
	                         //Append "None" item
	                         $('#cmbSelectConductorType').append($('<option>').text("<< Select Conductor Type >>").attr('value', ""));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectConductorType').append($('<option>').text(item.type).attr('value', item.type));
	                         }
	                     }
	              });		
		}
		
		function getEarthConductorTypes()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveEarthTypes/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectEarthConductorType').empty();
	                         //Append "None" item
	                         $('#cmbSelectEarthConductorType').append($('<option>').text("<< Select Earth Conductor Type >>").attr('value', ""));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectEarthConductorType').append($('<option>').text(item.type).attr('value', item.type));
	                         }
	                     }
	              });		
		}
		
		function getTowerConfig()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveTowerConfig/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectTowerConfiguration').empty();
	                         //Append "None" item
	                         $('#cmbSelectTowerConfiguration').append($('<option>').text("<< Select Tower Configuration >>").attr('value', "-"));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectTowerConfiguration').append($('<option>').text(item.name).attr('value', item.id));
	                         }
	                     }
	              });		
		}

		function getTowerType()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findAllTowerType/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectTowerType').empty();
	                         //Append "None" item
	                         $('#cmbSelectTowerType').append($('<option>').text("<< Select Tower Type >>").attr('value', "-"));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectTowerType').append($('<option>').text(item.name).attr('value', item.id));
	                         }
	                     }
	              });		
		}


		function getApprovalLevel()
		{			

//alert('ddd: ' + ${deptid} + ' cccc: '+${loggedUserRole});
			 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/getApprovalUsers/' +${deptid} +'/'+${loggedUserRole} +'/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbapprovalLevel').empty();
	                         //Append "None" item
	                         $('#cmbapprovalLevel').append($('<option>').text("<< Select Approval Level >>").attr('value', "-"));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbapprovalLevel').append($('<option>').text(item.userNm).attr('value', item.userId));
	                         }
	                     }
	              });		
		}
		

		
		
		function changeTowerType(){
			if (document.getElementById("cmbtowerType").value == "") 			 
			 {				 
				$('#otherTowerType').val("");
				document.getElementById("otherTowerType").style.visibility='visible';
				document.getElementById("cmbtowerType").disabled=true;
			    document.getElementById("btn1").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbtowerType").disable=false;
			 }
		}
		
		function unchangeTowerType(){
			$('#otherTowerType').val("");
			document.getElementById("otherTowerType").style.visibility='hidden';
			document.getElementById("btn1").style.visibility='hidden';
			document.getElementById("cmbtowerType").disabled=false;
			document.getElementById("cmbtowerType").selectedIndex = 0;
		}

		function showLineByArea(){
			var area = $('#cmbSelectArea').find(":selected").attr("value");
			$.ajax
	        ({
	                type: 'GET',
	                url: '/MMS/findLineByArea/' +area +'/',
	                data: {},
	                contentType: "application/json; charset=utf-8",
	                success: function(response) 
	                {
	                    //alert(response);
	               	 $('#cmbSelectLine').empty();
	                    //Append "None" item
	                    $('#cmbSelectLine').append($('<option>').text("<< Select Line >>").attr('value', ""));

	                    //Insert item from the response
	                    for (var i = 0; i < response.length; i++) {
	                        var item = response[i];
	                        $('#cmbSelectLine').append($('<option>').text(item.lineName).attr('value', item.id));
	                    }
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
			
			function saveFeederLoc(id){
				//var strFeeder = feeder.options[feeder.selectedIndex].value;
				
				//alert(strFeeder);
				// var y = document.getElementById("feederobj").value;
				//alert(y);			
				//alert(id);
				var n = id.indexOf(",");
				var length = id.length;
				var latitude = id.substring(1, n);
				var longitude = id.substring(n+1, length-1);
				
				//value = parseFloat(value).toFixed(2);
				latitude = parseFloat(latitude).toFixed(6);

				longitude = parseFloat(longitude).toFixed(6);

				
			    document.getElementById("txtGPSLatitude").value = latitude;
	            document.getElementById("txtGPSLongitude").value = longitude;
	          
			    
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
			
			
					
				 var infoWindow = new google.maps.InfoWindow;
					handlePermission();

		       if (navigator.geolocation) {
		           navigator.geolocation.getCurrentPosition(function(position) {
		             var pos = {
		               lat: position.coords.latitude,
		               lng: position.coords.longitude
		             };
		             
		             
		            latitude = parseFloat(position.coords.latitude).toFixed(6);

		 			longitude = parseFloat(position.coords.longitude).toFixed(6);

		             
		             document.getElementById("txtGPSLatitude").value = latitude;
		             document.getElementById("txtGPSLongitude").value = longitude;
		             infoWindow.setPosition(pos);
		             infoWindow.setContent('Location found.' + position.coords.latitude + " " + position.coords.longitude);
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
		       
		       map.addListener('click', function(mapsMouseEvent) {
			          // Close the current InfoWindow.
			          infoWindow.close();
			          
			         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
			       "<tr><td><input type='button' id='myBtn' value='Get Location' onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'></button></td></tr> "+
			           "</table></div>";


			          // Create a new InfoWindow.
			          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
			          infoWindow.setContent(insDetailTable);
			          infoWindow.open(map);
			        });


		       



		}

		
		
		
		
		
		
		
		
		
		
		
		
		
			
	</script>
</head>
<body onload="getTowerType();getAreas();getCsc();getConductorTypes();getEarthConductorTypes();getTowerConfig();myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
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
	                                <li class="active"><span>Add Support</span></li>
	                            </ol>
	
	                            
	                        </div>
				                                    
							<%@ include file="sections/userDetails.jsp" %> 
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form method="post" action="MMSaddSupport" modelAttribute="pivModel" role="form">
										
										<c:if test="${not empty pivModel.message}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${pivModel.message}"></c:out>
									</div>
								
						</tr>
					</c:if>
										
										
							<!--  			<div class="form-group">
											<label>Support Type : </label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.supportType" value="1" id="radioSupportType" checked="checked"/>Tower
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.supportType" value="2" id="radioSupportType"/>Pole
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.supportType" value="3" id="radioSupportType"/>Gantry Bay
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.supportType" value="4" id="radioSupportType"/>GSS Bay
											</label>
										</div>-->
										
										
									
						
			                                              <table class="table table-striped table-bordered table-sm " id="tblProvinces">
			                                              <tbody>
																<tr>
                												<td width="30%" style="text-align:left">
                												Support Type
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="1" id="radioSupportType" checked="checked"/>Tower
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="2" id="radioSupportType"/>Pole
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="3" id="radioSupportType"/>Gantry Bay
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="4" id="radioSupportType"/>GSS Bay
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="5" id="radioSupportType"/>Line Gantry
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="6" id="radioSupportType"/>Lattice Pole
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="7" id="radioSupportType"/>Switch
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.supportType" value="8" id="radioSupportType"/>PSS
																</label>
																
																
																</td>
																    
        														</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Support No
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input  path="supportObj.towerNo" type="text" class="form-control" id="txtTowerNo" placeholder="Enter Tower number"/>
																<span id="spnTowerNo" class="label label-danger"></span>
																
																</td>
																    
        														</tr>												
									
																<tr>
                												<td width="30%" style="text-align:left">
                												Area 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="supportObj.area" class="form-control" id="cmbSelectArea" name="cmbSelectArea" onchange="showLineByArea()">
										
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																    
        														</tr>	
        														
        														<%-- <tr>
                												<td width="30%" style="text-align:left">
                												CSC 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="supportObj.area" class="form-control" id="cmbSelectArea" name="cmbSelectArea" onchange="showLineByArea()">
										
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																    
        														</tr>	
										 --%>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Line 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="supportObj.lineId" class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="">
										
																</form:select>
																<span id="spnSelectLine" class="label label-danger"></span>
																</td>
																    
        														</tr>	
																
                              									<tr>
                												<td width="30%" style="text-align:left">
                												Conductor Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="supportObj.conductorType" class="form-control" id="cmbSelectConductorType" name="cmbSelectConductorType">
										
																</form:select>
																<span id="spnSelectConductorType" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Tower Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select path="supportObj.towerType" class="form-control" id="cmbSelectTowerType" name="cmbSelectTowerType">
										
																</form:select>
																<span id="spnSelectTowerType" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Tower Configuration
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select path="supportObj.towerConfiguration" class="form-control" id="cmbSelectTowerConfiguration" name="cmbSelectTowerConfiguration">
										
																</form:select>
																<span id="spnSelectTowerConfiguration" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS -Latitude 
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="supportObj.gpsLatitude" type="number" value ="0" class="form-control" id="txtGPSLatitude" step="any"/>
																<span id="spnGPSLatitude" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS -Longitude 
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="supportObj.gpsLongitude" type="number" value ="0" class="form-control" id="txtGPSLongitude" step="any"/>
																<span id="spnGPSLongitude" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Tapping 
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="supportObj.tapping" type="number" value ="0" class="form-control" id="txtTapping" step="any"/>
																<span id="spnTapping" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Map Id 
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="supportObj.mapId" type="number" value ="0" class="form-control" id="txtMapId" step="any"/>
																<span id="spnMapId" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												CSC
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input  path="supportObj.csc" type="text" value ="000.00"class="form-control" id="txtCsc" placeholder="Enter Tower number"/>
																<span id="spnCsc" class="label label-danger"></span>
																
																</td>
																    
        														</tr>												
									
        														<tr>
                												<td width="30%" style="text-align:left">
                												Number of circuits 
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<label class="radio-inline">
																<form:radiobutton path="supportObj.noOfCircuits" value="2" id="radioNoOfCircuits" checked="checked"/>Double
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.noOfCircuits" value="1" id="radioNoOfCircuits"/>Single
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.noOfCircuits" value="3" id="radioNoOfCircuits"/>Both
																</label>
																</td>    
        														</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Body Extention &emsp;&nbsp;
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<label class="radio-inline">
																<form:radiobutton path="supportObj.bodyExtension" value="0" id="radioBodyExtension" checked="checked"/>0
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.bodyExtension" value="3+" id="radioBodyExtension"/>3+
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.bodyExtension" value="5+" id="radioBodyExtension"/>5+
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.bodyExtension" value="6+" id="radioBodyExtension"/>6+
																</label>
																<label class="radio-inline">
																<form:radiobutton path="supportObj.bodyExtension" value="9+" id="radioBodyExtension"/>9+
																</label></td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Status
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select path="supportObj.status" class="form-control" id="txtStatus" placeholder="Enter Status">
																<form:option value="2" selected="selected">Keep in Bulk</form:option>
											    				<form:option value="3">Send for Approval</form:option>
																</form:select>										
																<span id="spnStatus" class="label label-danger"></span></td>
																    
        														</tr>
        														
        														<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Approval Level
                												
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select  id="userId" path ="supportObj.approvalLevel" onchange="">
																 <form:options items="${pivModel.saList}"/>
																</form:select>
																<span id="spncmbapprovalLevel" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														 --%>
        														
																
																</tbody>	
																</table>
					
																
																
																
																			
									<!-- 	<div class="form-group">
											<label>Area :
											<form:select path="supportObj.area" class="form-control" id="cmbSelectArea" name="cmbSelectArea" onchange="showLineByArea()">
										
											</form:select>
											<span id="spnSelectArea" class="label label-danger"></span></label>
										</div>
										
										
										<div class="form-group">
											<label>Line :
											<form:select path="supportObj.lineId" class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="">
										
											</form:select>
											<span id="spnSelectLine" class="label label-danger"></span></label>
										</div>
									

										<div class="form-group">
											<label>Conductor Type :
											<form:select path="supportObj.conductorType" class="form-control" id="cmbSelectConductorType" name="cmbSelectConductorType">
										
											</form:select>
											<span id="spnSelectConductorType" class="label label-danger"></span></label>
										</div>
										
										

										<div class="form-group">
											<label>Tower Type :
											<form:select path="supportObj.towerType" class="form-control" id="cmbSelectTowerType" name="cmbSelectTowerType">
										
											</form:select>
											<span id="spnSelectTowerType" class="label label-danger"></span></label>
										</div>


										
										
										<div class="form-group">
											<label>Tower Configuration :
											<form:select path="supportObj.towerConfiguration" class="form-control" id="cmbSelectTowerConfiguration" name="cmbSelectTowerConfiguration">
										
											</form:select>
											<span id="spnSelectTowerConfiguration" class="label label-danger"></span></label>
										</div>

										<div class="form-group">
											<label for="txtGPSLatitude">GPS - Latitude :
											<form:input path="supportObj.gpsLatitude" type="number" class="form-control" id="txtGPSLatitude" step="any"/>
											<span id="spnGPSLatitude" class="label label-danger"></span></label>
										</div>

										<div class="form-group">
											<label for="txtGPSLongitude">GPS - Longitude :
											<form:input path="supportObj.gpsLongitude" type="number" class="form-control" id="txtGPSLongitude" step="any"/>
											<span id="spnGPSLongitude" class="label label-danger"></span></label>
										</div>
										
										 -->
									
				
													
										
										

									<!--  	<div class="form-group">
											<label>Number of circuits : </label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.noOfCircuits" value="2" id="radioNoOfCircuits" checked="checked"/>Double
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.noOfCircuits" value="1" id="radioNoOfCircuits"/>Single
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.noOfCircuits" value="3" id="radioNoOfCircuits"/>Both
											</label>
										</div>

										<div class="form-group">
											<label>Body Extention &emsp;&nbsp; : </label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.bodyExtension" value="0" id="radioBodyExtension" checked="checked"/>0
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.bodyExtension" value="3+" id="radioBodyExtension"/>3+
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.bodyExtension" value="5+" id="radioBodyExtension"/>5+
											</label>
											<label class="radio-inline">
												<form:radiobutton path="supportObj.bodyExtension" value="6+" id="radioBodyExtension"/>6+
											</label>
										</div>
										
										<div class="form-group">
											<label for="txtStatus">Status :
											<form:select path="supportObj.status" class="form-control" id="txtStatus" placeholder="Enter Status">
												<form:option value="2" selected="selected">Keep in Bulk</form:option>
											    <form:option value="0">Send for Approval</form:option>
												</form:select>										
											<span id="spnStatus" class="label label-danger"></span></label>
										</div>
										<div class="form-group">
											<label>Approval Level :
											<form:select  id="userId" path ="supportObj.approvalLevel" onchange="">
																 <form:options items="${pivModel.saList}"/>
																</form:select>
															
											<span id="spncmbapprovalLevel" class="label label-danger"></span></label>
										</div>
										
-->

										<div class="form-group">
											<div class="pull-center">
												<input type="submit" Value="Add" class="btn btn-success" />
												<button type="button" class="btn btn-warning" onclick="window.location.href='editSupoortByAreaLine'">Edit</button>
											</div>
										</div>
										
										
										<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
										
									</form:form>
								</div>
							</div>
						</div>

					</div>

					<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
		
	</body>
</html>