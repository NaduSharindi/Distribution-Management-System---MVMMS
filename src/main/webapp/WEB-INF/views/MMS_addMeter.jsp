<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>



<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>



<style type="text/css">



div#map_container {
	width: 100%;
	height: 500px;
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

.google-visualization-table-td {
text-align: center !important;
}

.container{
	max-width: 100%;
    
}

/* html, body {
    max-width: 100%;
    overflow-x: hidden;
}
 */


</style>

<script
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>



<script type="text/javascript">


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
             
             
             document.getElementById("txtGpsLatitude").value = position.coords.latitude;
             document.getElementById("txtGpsLongitude").value = position.coords.longitude;
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
	
	document.getElementById("txtGpsLatitude").value = latitude;
    document.getElementById("txtGpsLongitude").value = longitude;
    
}




function findArea() {
	//var categoryId = $(this).val();
	//alert("hiii");
	var strUser = province.options[province.selectedIndex].value;
	/* if(strUser == "DD1"){
		strUser = "DISCO1";
	}else if(strUser == "DD2"){
		strUser = "DISCO2";
	}
	 *///alert("hiiittt : "+strUser);
	//findAllAreaByProvinceNew

	$.ajax({
				type : 'GET',
				url : "/MMS/findAllAreaByProvinceNew/" + strUser,
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#area'), option = "<option value='NONE'>AREA</option><option value='ST'>STORES</option>";
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

function findProvinceByDivision() {
	//var categoryId = $(this).val();
	//alert("hiii");
	var division = divison.options[divison.selectedIndex].value;
	
	//alert(division);
	
	//alert("hiiittt : "+strUser);
	//findAllAreaByProvinceNew

	$.ajax({
				type : 'GET',
				url : "/MMS/findAllProvincs/" + division,
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#province'), option = "<option value='NONE'>PROVINCE</option>";
					slctSubcat.empty();
					for (var i = 0; i < data.length; i++) {
						option = option
								+ "<option value='"+data[i].compId + "'>"
								+ data[i].compNm + "</option>";
					}
					slctSubcat.append(option);

					//alert("response.towerNo" + data);	
				}
			});

}

function viewLTL(){
	
	
	var strUser = txtManufactureLtl.options[txtManufactureLtl.selectedIndex].value;
	if(strUser=="Yes"){
		document.getElementById("txtManufactureBrand").value = "LTL";
	}else{
		document.getElementById("txtManufactureBrand").value = "";
	}
	
	//alert("hiiii");
}

function cal1(){

	if(document.getElementById("txtOilWeight").value != null){

	var wei = document.getElementById("txtOilWeight").value;
	var vol = wei / 0.86;
	var vol2 = vol.toFixed(2);
	alert("Volume of Oil : " + vol2);
	document.getElementById("txtVolumeOfOil").value=vol2;

	}
	}

	function cal2(){

	if(document.getElementById("txtVolumeOfOil").value != null){

	var volum =  document.getElementById("txtVolumeOfOil").value;
	var weig = volum * 0.86;
	var weig2 = weig.toFixed(2);
	alert("Oil Weight : " + weig2);
	document.getElementById("txtOilWeight").value=weig2;

	}

	}


	function viewResult(){

	var pcbRes =document.getElementById("txtPcbTestResults").value;
	var res = ((pcbRes * pcbRes ) * (-0.0004)) + ((3.4523 * pcbRes) - 9.2363);
	//var a1 = (pcbRes * pcbRes);
	//var a2 = a1 * -0.0004;
	//var a3 = 3.4523 * pcbRes;
	//var a4 = a3 - 9.2363;
	//var res = a2 + a4;
	var res2 = res.toFixed(2);
	//var res = pcbRes;
	alert("PCB Screening Result Aroclor 1260 : " + res2);
	document.getElementById("txtPcbAroclor").value=res2;

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
									<li class="active"><span>Add Meter</span></li>
								</ol>


							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-8">
							<div class="main-box">

								<div class="main-box-body clearfix">

									<c:if test="${not empty success}">
										<tr>
											<td colspan="2" class="msgSuccess" align="center">

												<div class="msgSuccess"
													style="color: green; font-weight: bold;">
													<c:out value="${success}"></c:out>
												</div>
										</tr>
									</c:if>


									<form:form role="form" action="addMeterS" method="post"
										modelAttribute="SaveEquipment">

										<table class="table table-striped table-bordered table-sm " id="tblEquipment">
											<tbody>
												<!-- <h2 class="pull-left">
													<strong>Equipment Data</strong>
												</h2>
												 --><tr><td>
												Meter Data</td>
												</tr>
												
												<tr>
												 <td width="30%" style="text-align: left">Division</td>
														<td width="70%" style="text-align: left">
														<form:select id="divison" path="pcbEquipment.divison"
																onchange="findProvinceByDivision()" class="form-control">
																<form:option value="NONE" label="DIVISION" />
																<form:options items="${SaveEquipment.divList}" />
															</form:select>
															</td>
													</tr>
<tr>
														<td width="30%" style="text-align: left">Province</td>
														<td width="70%" style="text-align: left"><form:select id="province" path="pcbEquipment.branch"
																onchange="findArea()" class="form-control">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${model.provinceList}" />
															</form:select>
															</td>
															</tr>
														<tr>
														<td width="30%" style="text-align: left">Area</td>
														<td width="70%" style="text-align: left"><form:select id="area" path="pcbEquipment.unit" class="form-control">
																<form:option value="NONE" label="AREA" />
																
																<form:option value="ST" label="STORES" />
																<form:options items="${model.areaList}" />
															</form:select>
															</td>
															</tr>
														
												
												
												
												
												
												

											
														
														<!--  <td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value=">>"
																		class="btn btn-success" />
																</div>
															</div>
														</td>
														 --> 

													

														

													<tr>
														<td width="50%" style="text-align: left">CEB Serial No</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.serialNo" type="text" 
																class="form-control" id="txtEquipmentId"
																placeholder="Enter CEB Serial No" readonly="false" /> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
													
													</tr>
													<tr>	
														<td width="30%" style="text-align: left">Meter Type</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.type" class="form-control" 
																
																id="txtType" >
																<form:option value="BS">Bulk Meter</form:option>
																<form:option value="MH">MHP Meter</form:option>
																<form:option value="30">3ph-30 Meter</form:option>
																<form:option value="60">3ph-60 Meter</form:option>
																<form:option value="DM">Distribution Transformer Meter</form:option>
																
																<form:option value="GS">GSS Meter</form:option>
																<form:option value="PS">PSS Meter</form:option>
																
																<form:option value="FM">Feeder Meter</form:option>
																<form:option value="BM">Boundary  Meter</form:option>
																
															<form:option value="SM">Solar Energy Meters - In</form:option>
															<form:option value="WM">Wind/Other Energy Meters - In</form:option>
															
															</form:select> <span id="spnType" class="label label-danger"></span></td>

													</tr>

													<%-- <tr>
														<td width="30%" style="text-align: left">Branch</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.branch" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtBranch"
																placeholder="Enter Brnach" /> <span id="spnBranch"
															class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Unit</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.unit" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtUnit"
																placeholder="Enter Unit" /> <span id="spnUnit"
															class="label label-danger"></span></td>
													</tr>
 --%>
													<tr>
														<td width="30%" style="text-align: left">Make</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.meterMake" type="text" 
																class="form-control" id="txtEquipmentId"
																placeholder="Enter Make" readonly="false" /> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
														
															</tr>
															<tr>
														<td width="30%" style="text-align: left">Status</td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.status" class="form-control" style="background-color: #FFFFF; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="4">Active</form:option>
															<form:option value="5">In Active</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															
														</tr>
														<tr>
														<td width="30%" style="text-align: left">Manufacture serial No</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.mSerialNo" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
														<tr>
														<td width="30%" style="text-align: left">Meter CT Ratio</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.mCtRatio" class="form-control" style="background-color: #FFFFF; border-radius: 5px;"
																
																id="txtStatus" placeholder="<< Select Condition >>">
																<form:option value="In Use">200/5</form:option>
																<form:option value="Abandoned"> 400/5</form:option>
																<form:option value="Spare">800/5</form:option>
															<form:option value="Spare">1000/5</form:option>
															<form:option value="Spare">Other</form:option>
															
															</form:select> <span id="spnStatus" class="label label-danger"></span></td>
															</tr>
															
															<tr>
														<td width="30%" style="text-align: left">Meter VT Ratio</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.mVtRatio" class="form-control" style="background-color: #FFFFF; border-radius: 5px;"
																
																id="txtStatus" placeholder="<< Select Condition >>">
																<form:option value="In Use">1/1</form:option>
																<form:option value="Spare">Other</form:option>
															
															</form:select> <span id="spnStatus" class="label label-danger"></span></td>
															</tr>
															<tr>
														<td width="30%" style="text-align: left">Meter Constant Active</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.mConstantActive" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
														<td width="30%" style="text-align: left">Meter Constant Reactive</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.mConstantReactive" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
													
													<tr>
														<td width="30%" style="text-align: left">Scaling Factor</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.scalingFactor" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
														
													<tr>
														<td width="30%" style="text-align: left">Multification Factor</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.multificationFactor" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
													
												<tr>
														<td width="30%" style="text-align: left">Accuracy Class - Active</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.aClassActive" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
														<tr>
														<td width="30%" style="text-align: left">Accuracy Class - Reactive</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.aClassReactive" type="text" 
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
												<tr>
													<td width="30%" style="text-align: left">Manufacture
															Brand</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.manufactureBrand" type="text" 
																
																class="form-control" id="txtManufactureBrand"
																placeholder="Enter Manufacture Barnd" /> <span
															id="spnManufactureBrand" class="label label-danger"></span></td>
													<tr>
													
													<tr>
												<td width="30%" style="text-align: left">Manufacture
															Year</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.year" type="text" 
																
																class="form-control" id="txtManufactureDate"
																placeholder="Select Manufacture Year" /> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
														
												</tr>
												
														
												
														</tbody>
														</table>
														
														
														<!-- Location Details data -------------------------------------------------------------------------------------->
											<br>
											<!-- <h2 class="pull-left">
												<strong>Location Details</strong>
											</h2>
 -->
											
											<table class="table table-striped table-bordered table-sm " id="tblPcbLocation">
												<tbody>
												<tr><td>Customer & Location  data</td></tr>
													<tr>
														<td width="30%" style="text-align: left">Area
												</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.cusArea" type="text" 	id="txtCusArea"		class="form-control" 
																placeholder="Enter Area" /> <span
															id="spnLocationDescription" class="label label-danger"></span></td>
														
														<td width="30%" style="text-align: left">CSC</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.cusCsc" type="text" 
																class="form-control" id="txtCusCsc"
																placeholder="Enter CSC" /> <span
															id="spnGpsLatitude" class="label label-danger"></span></td>
													
													
													 
													 </tr>
													<tr>
														
														<td width="30%" style="text-align: left">Account Number</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.accountNumber" type="text" 
																class="form-control" id="txtAccountNumber"
																placeholder="Enter Account Number" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>
<td width="30%" style="text-align: left">Customer Name</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.cusName" type="text" 
																class="form-control" id="txtCusName"
																placeholder="Enter GPS location (Longitude)" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

													</tr>



													<tr>
														<td width="30%" style="text-align: left">Customer Address</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.cusAddress" type="text" 
																class="form-control" id="txtCusAddress"
																placeholder="Enter Customer Address" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>
<td width="30%" style="text-align: left">Customer Location</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.cusLocation" type="text" 
																class="form-control" id="txtGpsLongitude"
																placeholder="Enter Customer Location" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

</tr>
<tr>
														<td width="30%" style="text-align: left">Contract Demand</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.contractDemand" type="text" 
																class="form-control" id="txtContractDemand"
																placeholder="Enter Contract Demand" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>
<td width="30%" style="text-align: left">Tariff</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.tariff" type="text" 
																class="form-control" id="txtTariff"
																placeholder="Enter Tariff" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

</tr>
<tr>
														<td width="30%" style="text-align: left">SIN Number</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.cusSinNumber" type="text" 
																class="form-control" id="txtCusSinNumber"
																placeholder="Enter SIN Number" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

</tr>




												</tbody>
											</table>
											
											<table class="table table-striped table-bordered table-sm " id="tblPcbLocation">
												<tbody>
												<tr><td>Location Details</td></tr>
													<tr>
														<td width="30%" style="text-align: left">Location
															Description</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.locationDescription" type="text" 																class="form-control" id="txtLocationDescription"
																placeholder="Enter Location Description" /> <span
															id="spnLocationDescription" class="label label-danger"></span></td>
														
														
													 
													 </tr>
													<tr>
													<td width="30%" style="text-align: left">GPS location
															(Latitude)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.gpsLatitude" type="text" 
																class="form-control" id="txtGpsLatitude"
																placeholder="Enter GPS location (Latitude)" /> <span
															id="spnGpsLatitude" class="label label-danger"></span></td>
													
														
														<td width="30%" style="text-align: left">GPS
																location (Longitude)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.gpsLongitude" type="text" 
																class="form-control" id="txtGpsLongitude"
																placeholder="Enter GPS location (Longitude)" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

													</tr>



													<tr>
														<td width="30%" style="text-align: left">Type of
															Located</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbLocation.typeOfLocated" class="form-control" 
																id="txtTypeOfLocated"
																placeholder="<< Select Seal Type >>">
																<form:option value="-1"><< Select Type of Located  >></form:option>
																<form:option value="Indoor">Indoor</form:option>
																<form:option value="Outdoor">Outdoor</form:option>
															</form:select> <span id="spnTypeOfLocated" class="label label-danger"></span></td>
														</tr>


												</tbody>
											</table>
											<br>
											
											<table class="table table-striped table-bordered table-sm " id="tblEquipment5">
												<tbody>
												<tr><td>New CT Details</td></tr>
												<tr>
												<td width="30%" style="text-align: left">R</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.year" type="text" 
																
																class="form-control" id="txtManufactureDate"
																placeholder="Select Manufacture Year" /> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
														
												</tr>
												<tr>
													
													<td width="30%" style="text-align: left">Y</td>
														<td width="70%" style="text-align: left"><form:select onchange="viewLTL()"
																path="pcbEquipment.manufactureLtl" class="form-control" 
																
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														
														<td width="30%" style="text-align: left">B</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.manufactureBrand" type="text" 
																
																class="form-control" id="txtManufactureBrand"
																placeholder="Enter Manufacture Barnd" /> <span
															id="spnManufactureBrand" class="label label-danger"></span></td>
														
														
														<%-- <td width="70%" style="text-align: left"><form:input
															path="photoTaken" type="text" class="form-control"
															id="txtPhotoTaken" placeholder="Enter Photo Taken" /> <span
														id="spnPhotoTaken" class="label label-danger"></span></td> --%>
													</tr>
												<tr>
																								
											</tbody>
											</table>
											
											
											
											
											<!-- <h2 class="pull-left">
												<strong>Information Related to Sampling</strong>
											</h2>
											 -->	<table class="table table-striped table-bordered table-sm " id="tblEquipment5">
												<tbody>
												<tr><td>Information Related to Testing</td></tr>
												<tr>
													
													<td width="30%" style="text-align: left">Testing Unit
												</td>
														<td width="70%" style="text-align: left"><form:select onchange="viewLTL()"
																path="pcbEquipment.manufactureLtl" class="form-control" 
																
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Select Testing Unit >></form:option>
																<form:option value="Yes">Eenrgy Management</form:option>
																<form:option value="No">Meter Lab</form:option>
																<form:option value="No">Area</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														
														
														
														<%-- <td width="70%" style="text-align: left"><form:input
															path="photoTaken" type="text" class="form-control"
															id="txtPhotoTaken" placeholder="Enter Photo Taken" /> <span
														id="spnPhotoTaken" class="label label-danger"></span></td> --%>
													</tr>
												<tr>
													
													<td width="30%" style="text-align: left">Connection Type
												</td>
														<td width="70%" style="text-align: left"><form:select onchange="viewLTL()"
																path="pcbEquipment.manufactureLtl" class="form-control" 
																
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Select Testing Unit >></form:option>
																<form:option value="Yes">MHP</form:option>
																<form:option value="No">LT Bulk</form:option>
																<form:option value="No">3 ph 30A</form:option>
																
																<form:option value="No">3 ph 60 A</form:option>
																<form:option value="No">1 ph</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														
														
														
														<%-- <td width="70%" style="text-align: left"><form:input
															path="photoTaken" type="text" class="form-control"
															id="txtPhotoTaken" placeholder="Enter Photo Taken" /> <span
														id="spnPhotoTaken" class="label label-danger"></span></td> --%>
													</tr>
																								
												<tr>
												<td width="30%" style="text-align: left">Test Report Number</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.year" type="text" 
																
																class="form-control" id="txtManufactureDate"
																placeholder="Select Manufacture Year" /> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
														
												</tr>
												<tr>
												<td width="30%" style="text-align: left">Test Date</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.year" type="text" 
																
																class="form-control" id="txtManufactureDate"
																placeholder="Select Manufacture Year" /> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
														
												</tr>
												
												<tr>
													
													<td width="30%" style="text-align: left">Testing Basis 
												</td>
														<td width="70%" style="text-align: left"><form:select onchange="viewLTL()"
																path="pcbEquipment.manufactureLtl" class="form-control" 
																
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Select Testing Basis >></form:option>
																<form:option value="Yes">New connection</form:option>
																<form:option value="No">Capacity Augment</form:option>
																<form:option value="No">Meter change</form:option>
																
																<form:option value="No">AEE Request</form:option>
																<form:option value="No">Audit</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														
														
														
														<%-- <td width="70%" style="text-align: left"><form:input
															path="photoTaken" type="text" class="form-control"
															id="txtPhotoTaken" placeholder="Enter Photo Taken" /> <span
														id="spnPhotoTaken" class="label label-danger"></span></td> --%>
													</tr>
												
												
												
											</tbody>
											</table>
											
														
														<br>
											<!-- <h2 class="pull-left">
												<strong>Additional Details</strong>
											</h2>
											 -->			
														
														
														<table class="table table-striped table-bordered table-sm " id="tblEquipment1">
												<tbody>
												<tr><td>Meter Readings - Existing meter - Import</td></tr>
											
														<tr>
														<td width="30%" style="text-align: left">Act. Total (kWh/MWh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" 
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Act. Rate 1 (kWh/MWh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" 																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
														<td width="30%" style="text-align: left">Act. Rate 2 (kWh/MWh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" 
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Act. Rate 3 (kWh/MWh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" 																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
														<td width="30%" style="text-align: left">Re. Total (kVarh/MVarh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" 
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Re. Rate 1 (kVarh/MVarh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" 																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
														<td width="30%" style="text-align: left">Re. Rate 2 (kVarh/MVarh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" 
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Re. Rate 3 (kVarh/MVarh)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" 																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
														<td width="30%" style="text-align: left">MD in kVA / MVA</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" 
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">D & T of Last MD</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" 																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
														<td width="30%" style="text-align: left">History 1 MD</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" 
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Last Billing Reset</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" 																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													
													
													
													
													
													
													
													<!-- <tr>
													 -->	<%-- <td width="50%" style="text-align: left">Category</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.divison" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtDivison" placeholder="<< Select Division >>">


																<c:choose>

																	<c:when
																		test="${EditEquipment.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${EditEquipment.divisionList}">
																			<c:if
																				test="${divisionList.id == EditEquipment.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${EditEquipment.divisionList}">
																	<c:if
																		test="${divisionList.id != EditEquipment.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>


															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														<!-- <td></td>
 -->
														<%-- <td width="30%" style="text-align: left"><strong>Primary
																Sub</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.primarySub" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtPrimarySub" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnPrimarySub" class="label label-danger"></span></td>
													</tr>

 --%>													<tr>
 
  
														
														
													</tr>

																									</tbody>
											</table>






										



										<div class="form-group">
											<div class="pull-left">

												<input type="submit" Value="Add" class="btn btn-success" />

												<button type="button" class="btn btn-warning"
													onclick="window.location.href='editEquipment'">Edit
													</button>
											</div>
										</div>
										
										
<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>



									</form:form>
									<!-- <div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayLine'">Edit</button>
											</div>
										</div> -->


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
