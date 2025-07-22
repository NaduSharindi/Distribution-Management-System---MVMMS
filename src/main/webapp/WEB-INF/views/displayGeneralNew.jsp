<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
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
  
   <script 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>
  
  <style type="text/css">



div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}
  </style>
  
  
  
	<script>
	var j = jQuery.noConflict();
    j( function() {
        j("#datepicker").datepicker();
    } );
	 
	  </script>
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
			latitude = parseFloat(latitude).toFixed(6);

			longitude = parseFloat(longitude).toFixed(6);

			
		    document.getElementById("txtGPSLatitude").value = latitude;
            document.getElementById("txtGPSLongitude").value = longitude;
          
		    
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
	             
	             
	             //document.getElementById("txtGPSLatitude").value = position.coords.latitude;
	             //document.getElementById("txtGPSLongitude").value = position.coords.longitude;
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

	
function getLine() {
		
		var strUser = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
		

		$.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#cmbSelectLineId'), option = "<option value='NONE'>LINE</option>";
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
	
	
	
//File Remove function
function fileRemove() {
		document.getElementById("file").value = "";
		document.getElementById("spnclosebtn").style.display="none";
	   
}

function fileRemove1() {
		 document.getElementById("file1").value = "";
		 document.getElementById("spnclosebtn1").style.display="none";
	   
}

function fileRemove2() {
		 document.getElementById("file2").value = "";
		 document.getElementById("spnclosebtn2").style.display="none";
	   
}

function fileRemove3() {
		 document.getElementById("file3").value = "";
		 document.getElementById("spnclosebtn3").style.display="none";
	   
}

function fileRemove4() {
		 document.getElementById("file4").value = "";
		 document.getElementById("spnclosebtn4").style.display="none";
	   
}


//show close button
function show() {
	 if (file != null) {
		 document.getElementById("spnclosebtn").style.display="inline";
	 }
}

function show1() {
	 if (file1 != null) {
		 document.getElementById("spnclosebtn1").style.display="inline";
	 }
}

function show2() {
	 if (file3 != null) {
		 document.getElementById("spnclosebtn2").style.display="inline";
	 }
}

function show3() {
	 if (file3 != null) {
		 document.getElementById("spnclosebtn3").style.display="inline";
	 }
}

function show4() {
	 if (file4 != null) {
		 document.getElementById("spnclosebtn4").style.display="inline";
	 }
}


	
function getCSC()

{			
		
	var strUser = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
	//alert(strUser);	
	   $.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findAllCSCByArea/" + strUser + "/",
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(response) 
                 {   //alert("success");
                	 $('#cmbSelectCSC').empty();
                     //Insert item from the response
                     for (var i = 0; i < response.length; i++) {
                         var item = response[i];
                         $('#cmbSelectCSC').append($('<option>').text(item.deptNm).attr('value', item.deptId));
                     }
                 }
          });		
	 
	
}


function openPopupSubmit()
{
      
	//alert(id);
	var id = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	
	var url="downloadSLDGantry?id="+id;
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
}


function openPopupSubmitImg1()
{
	var id = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	
	//alert(id);
	var url="downloadIntImgReq?id="+id+"&seq=2";
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
}

function openPopupSubmitImg2()
{
	var id = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	
	//alert(id);
	var url="downloadIntImgReq?id="+id+"&seq=3";
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
}

function openPopupSubmitImg3()
{
	var id = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	
	//alert(id);
	var url="downloadIntImgReq?id="+id+"&seq=4";
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
}

function openPopupSubmitImg4()
{
	var id = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	 
	//alert(id);
	var url="downloadIntImgReq?id="+id+"&seq=5";
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
}

	
	
	  
	
		
		
         function findArea() {
     		
     		var strUser = cmbSelectProvince.options[cmbSelectProvince.selectedIndex].value;
     		

     		$.ajax({
     					type : 'GET',
     					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						var slctSubcat = $('#cmbSelectArea'), option = "<option value='NONE'>AREA</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < data.length; i++) {
     							option = option
     									+ "<option value='"+data[i].deptId + "'>"
     									+ data[i].deptNm + "</option>";
     						}
     						slctSubcat.append(option);

     						
     					}
     				});

     	}
         

 		

function getGantryByAreaLine()
		
		{			
	var strArea = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
	var strLine = cmbSelectLineId.options[cmbSelectLineId.selectedIndex].value;
				
			   $.ajax
	             ({
	                     type: 'GET',
	                     url: "/MMS/findGantryByAreaLine/"+strArea+"/"+strLine+"/",
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {   
	                         var slctSubcat = $('#cmbSelectGantry'), option = "<option value='NONE'>GANTRY</option>";
	     						slctSubcat.empty();
	     						for (var i = 0; i < response.length; i++) {
		                         var item = response[i];
	     							option = option
	     									+ "<option value='"+item.id + "'>"
	     									+ item.code + "</option>";
	     						}
	     						slctSubcat.append(option);
	                         
	                     }
	              });		
			 
			
		}
		
function getGantryByArea(){
	
var strArea = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
		
	   $.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findGantryForApproval/"+strArea+"/",
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(response) 
                 {   
                     var slctSubcat = $('#cmbSelectGantry'), option = "<option value='NONE'>GANTRY</option>";
 						slctSubcat.empty();
 						for (var i = 0; i < response.length; i++) {
                         var item = response[i];
 							option = option
 									+ "<option value='"+item.id + "'>"
 									+ item.code + "</option>";
 						}
 						slctSubcat.append(option);
                     
                 }
          });		
	 
	
}
		

function loaddata(){
	
	var strCode = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	//alert(strCode);
	 $.ajax
     ({
             type: 'GET',
             url: "/MMS/getGantry/"+strCode+"/",
             data: {},
             contentType: "application/json; charset=utf-8",
             success: function(response) 
             {
                    //Insert item from the response
                 for (var i = 0; i < response.length; i++) {
                     var item = response[i];
                     
                     document.getElementById("txtName").value = item.name;
                     document.getElementById("txtCode").value = item.code;
                     
                     document.getElementById("txtshortcircit").value = item.shortCctCurntCapacity;
                     document.getElementById("txtEarthfault").value = item.earthFaultCurntCapacity;
                     document.getElementById("cmbSelectGantryType").value = item.gantryType;
                     document.getElementById("cmbSelectGantryEleType").value = item.gantryEleType;
                     document.getElementById("txtNoBusBar").value = item.noBusBar;
                     document.getElementById("txtNoBusSec").value = item.noBusSec;
                     document.getElementById("txtNoInBays").value = item.noInBays;
                     document.getElementById("txtnoOutBays").value = item.noOutBays;
                     document.getElementById("txttotalLandArea").value = item.totalLandArea;
                     document.getElementById("txtnoOfAutoRecloser").value = item.noAr;
                     document.getElementById("txtnoOfLBS").value = item.noLbs;
                     document.getElementById("txtnoOfABS").value = item.noAbs;
                     document.getElementById("txtNoBusBar").value = item.noBusBar;
                     document.getElementById("txtnoOfSurgeArrestors").value = item.noSa;
                     document.getElementById("txtnoOfLinks").value = item.noDdloLinks;
                     document.getElementById("txtnoOfDDLOfuses").value = item.noDdloFuses;
                     document.getElementById("txtnoOfInFeeders").value = item.noIncomingFeeder;
                     document.getElementById("txtnoOfOutFeeders").value = item.noOutgoingFeeder;
                     document.getElementById("txtGPSLatitude").value = item.gpsLatitude;
                     document.getElementById("txtGPSLongitude").value = item.gpsLongitude;
                     //document.getElementById("hiddengantrycode").value = item.code;
                     document.getElementById("cmbSelectCSC").value = item.csc;
                     document.getElementById("datepicker").value = dateconvert(item.dateOfComm);
                     
                     
                 }
             }
      });
	
}

function dateconvert(date)
{   // alert(date);
	 var str = date;
     var array = str.split("-");
     var mm =array[1];
     var dd =array[2];
     var yy =array[0];
     var cdate = mm+"/"+dd+"/"+yy;
     //alert(cdate);
     return cdate;
	
}
	
		
	</script>
</head>
<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
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
                                <li class="active"><span>Update General Details</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
								     <c:if test="${SUCCESS_MESSAGE != null}">
                                      <div class="alert alert-success" id="success-alert">
                                       <strong>Success! </strong>${SUCCESS_MESSAGE}
                                    </div>
                                    </c:if>
                                    <script>
                                    setTimeout(function() {
                                        $('#success-alert').fadeOut('fast');
                                    }, 5000);
                                    </script> 
									<form:form role="form" enctype="multipart/form-data" action="MMSupdateGeneral" method="post" modelAttribute="UpdateGeneral">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		<tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateGeneral.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.area"  onchange="getLine();getCSC();getGantryByArea();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${UpdateGeneral.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												CSC
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.csc" class="form-control" id="cmbSelectCSC" name="cmbSelectCSC">
																
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.lineId" onchange="getGantryByAreaLine()" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${UpdateGeneral.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
																</td>
																</tr> --%>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.id" class="form-control" onchange="loaddata()" id="cmbSelectGantry" name="cmbSelectGantry">
																      
																</form:select>
																<span id="spnSelectGantry" class="label label-danger"></span>
																</td>
																</tr> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.code" type="text" class="form-control" id="txtCode" placeholder="Enter Gantry Code"/>
																<span id="spnGantryCode" class="label label-danger"></span>
																</td>
																</tr>
															
																
																
					                                     		<tr>
                												<td width="30%" style="text-align:left">
                												Gantry Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.name" type="text" class="form-control" id="txtName" placeholder="Enter Gantry Name"/>
																<span id="spnGantryName" class="label label-danger"></span>
																</td>
																</tr>
															
																
																
																
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Short circuit current capacity(kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.shortCctCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtshortcircit" placeholder="Enter short circit current capacity(kA)"/>
																<span id="spnShortcircit" class="label label-danger"></span>
																</td>    
        														</tr>
        														<tr>
        														
                												<td width="30%" style="text-align:left">
                												Earth fault current capacity(kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.earthFaultCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtEarthfault" placeholder="Enter earth fault curent capacity(kA)"/>
																<span id="spnEarthfault" class="label label-danger"></span>
																</td>    
        														</tr>
        														
														    	<tr>
                												<td width="30%" style="text-align:left">
                												Date of Commissing 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.dateOfComm" type="text" class="form-control" id="datepicker"/>
																<span id="spnDate" class="label label-danger"></span>
																
																</td>
																</tr>
												
                              									
        														<tr>
        														<td width="30%" style="text-align:left">
                												Gantry Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.gantryType" class="form-control" id="cmbSelectGantryType" name="cmbSelectGantryType">
										                        <form:option value="1">Pole</form:option>
													            <form:option value="2">Structural</form:option>
																</form:select>
																<span id="spnGantryType" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Gantry Electrcial Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.gantryEleType" class="form-control" id="cmbSelectGantryEleType" name="cmbSelectGantryEleType">
										                        <form:option value="1">SBB</form:option>
													            <form:option value="2">DBB</form:option>
																</form:select>
																<span id="spnGantryEleType" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												No of Bus bars
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noBusBar" type="number" value ="0" min="0" class="form-control" id="txtNoBusBar" placeholder="Enter No Of Bus Bar"/>
																<span id="spnNoBusBar" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Bus sections
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noBusSec" type="number" value ="0" min="0" class="form-control" id="txtNoBusSec" placeholder="Enter No Of Bus Sections"/>
																<span id="spnNoBusSec" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of In bays
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noInBays" type="number" value ="0" min="0" class="form-control" id="txtNoInBays" placeholder="Enter No Of In Bays"/>
																<span id="spnNoInBays" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Out bays
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noOutBays" type="number" value ="0" min="0" class="form-control" id="txtnoOutBays" placeholder="Enter No Of Out Bays"/>
																<span id="spnNoOutBays" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Total Land Area (ph)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.totalLandArea" type="number" value ="0" min="0" class="form-control" id="txttotalLandArea" placeholder="Total Land Area"/>
																<span id="spntotalLandArea" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of AutoRecloser
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noAr" type="number" value ="0" min="0" class="form-control" id="txtnoOfAutoRecloser" placeholder="Enter No Of AutoRecloser"/>
																<span id="spnNoOfAutoRecloser" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of LBS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noLbs" type="number" value ="0" min="0" class="form-control" id="txtnoOfLBS" placeholder="Enter No Of LBS"/>
																<span id="spnNoOfLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of ABS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noAbs" type="number" min="0" value ="0" class="form-control" id="txtnoOfABS" placeholder="Enter No Of ABS"/>
																<span id="spnNoOfABS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Surge Arrestors
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noSa" type="number" min="0" value ="0" class="form-control" id="txtnoOfSurgeArrestors" placeholder="Enter No Of Surge Arrestors"/>
																<span id="spnNoOfSurgeArrestors" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of DDLO Links
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noDdloLinks" type="number" min="0" value ="0" class="form-control" id="txtnoOfLinks" placeholder="Enter No Of DDLO Links"/>
																<span id="spnNoOfLinks" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of DDLO fuses
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noDdloFuses" type="number" min="0" value ="0" class="form-control" id="txtnoOfDDLOfuses" placeholder="Enter No Of DDLO fuses"/>
																<span id="spnNoOfDDLOfuses" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Incoming Feeders
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noIncomingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfInFeeders" placeholder="Enter No Of Incomming Feeders"/>
																<span id="spnNoOfInFeeders" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Outgoing Feeders
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noOutgoingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfOutFeeders" placeholder="Enter No Of Outgoing Feeders"/>
																<span id="spnNoOfOutFeeders" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Latitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.gpsLatitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLatitude" placeholder="Enter GPS Latitude"/>
																<span id="spnGPSLatitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Longitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.gpsLongitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLongitude" placeholder="Enter GPS Longitude"/>
																<span id="spnGPSLongitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												Single Line Diagram
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file" id="file"  onchange="show()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove(); return false;">
																	</span>
																</td>
																
																    
        														</tr>
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file1" id="file1"  onchange="show1()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file2" id="file2"  onchange="show2()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn2" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove2(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file3" id="file3"  onchange="show3()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn3" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove3(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file4" id="file4" onchange="show4()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn4" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove4(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														
        														
        														<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit()' class="form-control"> View Single Line Diagram</button></td>
																<td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1()' class="form-control"> View DOC II</button></td>
																<td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2()' class="form-control">View DOC III</button></td></tr>
																<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3()' class="form-control">View DOC IV</button></td>
																<td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4()' class="form-control">View DOC V</button></td></tr>
									
        														
        														
        														<%-- <tr>
                												
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.code" type="hidden" class="form-control" id="hiddengantrycode" placeholder="Enter Gantry code"/>
																<span id="spnhiddengantrycode" class="label label-danger"></span>
																</td>
																</tr>
        														
        														 --%>
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Update" class="btn btn-success" />
												
												<!-- <button type="button" class="btn btn-warning" onclick="window.location.href='displayPole'">Edit</button> -->
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

					

						</div>
					</div>
				</div>
			</div>
			<%@ include file="sections/footer.jsp" %>
		<%@ include file="sections/global_scripts.jsp" %>
</body>
</html>