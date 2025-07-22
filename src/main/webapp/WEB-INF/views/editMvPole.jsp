<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">

	
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
	                         /* $('#cmbSelectConductorType').append($('<option>').text("<< Select Conductor Type >>").attr('value', ""));
	 */
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectConductorType').append($('<option>').text(item.type).attr('value', item.id));
	                         }
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
		
function getFeederByGantryId()

{			
var strGantry = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
//alert(strGantry);
		
	   $.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findFeederByGantryId/"+strGantry+"/",
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(response) 
                 {   
                     var slctSubcat = $('#cmbSelectFeeder'), option = "<option value='NONE'>FEEDER</option>";
 						slctSubcat.empty();
 						for (var i = 0; i < response.length; i++) {
                         var item = response[i];
 							option = option
 									+ "<option value='"+item.id.feederId + "'>"
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
	                 url: "/MMS/findGantryByArea/"+strArea +"/",
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
	
function getMvPoleByFeederId(){
	
	var strFeeder = cmbSelectFeeder.options[cmbSelectFeeder.selectedIndex].value;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findMvPoleByFeederId/"+strFeeder+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
	                     var slctSubcat = $('#cmbSelectPoleNumber'), option = "<option value='NONE'>MV Pole</option>";
	 						slctSubcat.empty();
	 						for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	 							option = option
	 									+ "<option value='"+item.id + "'>"
	 									+ item.poleNo + "</option>";
	 						}
	 						slctSubcat.append(option);
	                     
	                 }
	          });		
		 
		
	}
	
function loaddata(){
	
	var strId = cmbSelectPoleNumber.options[cmbSelectPoleNumber.selectedIndex].value;
	
	
	 $.ajax
     ({
             type: 'GET',
             url: "/MMS/getMvPoleObj/"+strId+"/",
             data: {},
             contentType: "application/json; charset=utf-8",
             success: function(item) 
             {
            	
                 //Insert item from the response
                 
                     document.getElementById("cmbSelectCSC").value = item.csc;
                     document.getElementById("txtGPSLatitude").value = item.gpsLatitude;
                     document.getElementById("txtGPSLongitude").value = item.gpsLongitude;
                     document.getElementById("poleHeight").value = item.poleHeight;
                     document.getElementById("poleType").value = item.poleType;
                     document.getElementById("cmbSelectWorkingLoad").value = item.workingLoad;
                     document.getElementById("radiohvlvcombinerun").value = item.hvLvCombineRun;
                     document.getElementById("txtNoof33kc").value = item.noOf33Kvcircuits;
                     document.getElementById("txtNoof11kc").value = item.noOf11Kvcircuits;
                     
                     document.getElementById("txtNooflvcct").value = item.noOfLvCct;
                     document.getElementById("cmbSelectConductor33_1").value = item.kv33ConductorCct1;
                     document.getElementById("cmbSelectConductor33_2").value = item.kv33ConductorCct2;
                     document.getElementById("cmbSelectConductor33_3").value = item.kv33ConductorCct3;
                     document.getElementById("cmbSelectConductor11_1").value = item.kv11ConductorCct1;
                     document.getElementById("cmbSelectConductor11_2").value = item.kv11ConductorCct2;
                     document.getElementById("cmbSelectConductor11_3").value = item.kv11ConductorCct3;
                     document.getElementById("radiolvconductortype").value = item.lvConductorType;
                     document.getElementById("radiopinshackle").value = item.pinShackle;
                     
                     document.getElementById("txtstreetlight").value = item.streetLight;
                     document.getElementById("txtNoofstay").value = item.stay;
                     document.getElementById("txtNoofstrut").value = item.strut;
                     document.getElementById("cmbSelectCrossArm").value = item.crossArm;
                     document.getElementById("radioearthconductor").value = item.earthConductor;
                     document.getElementById("radiolineEnd").value = item.lineEnd;
                     
                     document.getElementById("cmbSelect33kcct1ph1").value = item.kv33Cct1Ph1;
                     document.getElementById("cmbSelect33kcct1ph2").value = item.kv33Cct1Ph2;
                     document.getElementById("cmbSelect33kcct1ph3").value = item.kv33Cct1Ph3;
                     document.getElementById("cmbSelect33kcct2ph1").value = item.kv33Cct2Ph1;
                     document.getElementById("cmbSelect33kcct2ph2").value = item.kv33Cct2Ph2;
                     document.getElementById("cmbSelect33kcct2ph3").value = item.kv33Cct2Ph3;
                     document.getElementById("cmbSelect33kcct3ph1").value = item.kv33Cct3Ph1;
                     document.getElementById("cmbSelect33kcct3ph2").value = item.kv33Cct3Ph2;
                     document.getElementById("cmbSelect33kcct3ph3").value = item.kv33Cct3Ph3;
                     
                     
                     
             }
      });
	
}
	
		
	</script>
</head>
<body onload="getConductorTypes();">
<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		 <%-- <jsp:include page="sections/header.jsp" /> --%>
		
		
		<div id="page-wrapper" class="container">
			<div class="row">
			 <%@ include file="sections/userLevels.jsp" %> 
			<%-- <jsp:include page="sections/userLevels.jsp" /> --%>
	 
				<div id="content-wrapper">
				
				<div class="row">
				<div class="col-lg-12">		                                    
                        <div class="col-lg-9">
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li class="active"><span>Update Mv Pole</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
						 <%-- <jsp:include page="sections/userDetails.jsp" /> --%>
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
									<form:form role="form" action="MMSupdateMvPole" method="post" modelAttribute="UpdateMVPole">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		
        														<tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																    <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateMVPole.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.area"  onchange="getGantryByArea();getCSC();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${UpdateMVPole.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												CSC
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.csc" onchange="getFeederByGantryId()" class="form-control" id="cmbSelectCSC" name="cmbSelectCSC">
																      
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getFeederByGantryId()" class="form-control" id="cmbSelectGantry" name="cmbSelectGantry">
																      
																</form:select>
																<span id="spnSelectGantry" class="label label-danger"></span>
																</td>
																</tr>
																 
																<tr>
                												<td width="30%" style="text-align:left">
                												Feeder
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.feederNo" onchange="getMvPoleByFeederId()" class="form-control" id="cmbSelectFeeder" name="cmbSelectFeeder">
																      
																</form:select>
																<span id="spnSelectFeeder" class="label label-danger"></span>
																</td>
																</tr> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Pole Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.id" onchange="loaddata()" class="form-control" id="cmbSelectPoleNumber" name="cmbSelectPoleNumber">
																      
																</form:select>
																<span id="spnSelectPoleNumber" class="label label-danger"></span>
																</td>
																</tr> 
															
																
																<tr>
                												<td width="30%" style="text-align:left">
                												GPS Latitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.gpsLatitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLatitude" placeholder="Enter GPS Latitude"/>
																<span id="spnGPSLatitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Longitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.gpsLongitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLongitude" placeholder="Enter GPS Longitude"/>
																<span id="spnGPSLongitude" class="label label-danger"></span>
																</td>    
        														</tr>
        															
																<tr>
        														<td width="30%" style="text-align:left">
                												Pole Height
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.poleHeight" class="form-control" id="poleHeight" name="cmbSelectpoleHeight">
										                        <form:option value="1">3m</form:option>
													            <form:option value="2">10m</form:option>
													            <form:option value="3">11m</form:option>
													            <form:option value="4">13m</form:option>
																</form:select>
																<span id="spnpoleHeight" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Pole Type
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.poleType" class="form-control" id="poleType" name="cmbSelectpoleType">
										                        <form:option value="1">	Wooden</form:option>
													            <form:option value="2">Steel Tubuler</form:option>
													            <form:option value="3">PG Pole</form:option>
													            <form:option value="4">RC</form:option>
													            <form:option value="5">PS</form:option>
																</form:select>
																<span id="spnpoleType" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Working Load
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.workingLoad" class="form-control" id="cmbSelectWorkingLoad" name="cmbSelectWorkingLoad">
										                        <form:option value="1">225Kg</form:option>
													            <form:option value="2">300Kg</form:option>
													            <form:option value="3">350Kg</form:option>
													            <form:option value="4">850Kg</form:option>
													            <form:option value="5">1200Kg</form:option>
																</form:select>
																<span id="spnWorkingLoad" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												HV LV Combine Run
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="mvpole.hvLvCombineRun" value="1" id="radiohvlvcombinerun" checked="checked"/>Yes
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.hvLvCombineRun" value="2" id="radiohvlvcombinerun"/>No
																</label>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of 33 kV Circuits
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.noOf33Kvcircuits" type="number" value ="0" min="0" class="form-control" id="txtNoof33kc" placeholder=""/>
																<span id="spnnoof33kc" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of 11 kV Circuits
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.noOf11Kvcircuits" type="number" value ="0" min="0" class="form-control" id="txtNoof11kc" placeholder=""/>
																<span id="spnnoof11kc" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of LV cct
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.noOfLvCct" type="number" value ="0" min="0" class="form-control" id="txtNooflvcct" placeholder=""/>
																<span id="spnnooflvcct" class="label label-danger"></span>
																</td>    
        														</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33 kv Conductor cct - 1
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33ConductorCct1" class="form-control" id="cmbSelectConductor33_1" name="cmbSelectConductor33_1">
										                        <form:option value="1">Copper 1</form:option>
													            <form:option value="2">Copper 2</form:option>
													            <form:option value="3">Copper 4</form:option>
													            <form:option value="4">Copper 6</form:option>
													            <form:option value="5">ELM</form:option>
													            <form:option value="6">Weasel</form:option>
													            <form:option value="7">Raccoon</form:option>
													            <form:option value="8">Lynx</form:option>
													            <form:option value="9">Cockroach</form:option>
													            <form:option value="10">ABC 95</form:option>
													            <form:option value="10">ABC 150</form:option>
																</form:select>
																<span id="spnConductor33_1" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33 kv Conductor cct - 2
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33ConductorCct2" class="form-control" id="cmbSelectConductor33_2" name="cmbSelectConductor33_2">
										                        <form:option value="1">Copper 1</form:option>
													            <form:option value="2">Copper 2</form:option>
													            <form:option value="3">Copper 4</form:option>
													            <form:option value="4">Copper 6</form:option>
													            <form:option value="5">ELM</form:option>
													            <form:option value="6">Weasel</form:option>
													            <form:option value="7">Raccoon</form:option>
													            <form:option value="8">Lynx</form:option>
													            <form:option value="9">Cockroach</form:option>
													            <form:option value="10">ABC 95</form:option>
													            <form:option value="10">ABC 150</form:option>
																</form:select>
																<span id="spnConductor33_2" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33 kv Conductor cct - 3
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33ConductorCct3" class="form-control" id="cmbSelectConductor33_3" name="cmbSelectConductor33_3">
										                        <form:option value="1">Copper 1</form:option>
													            <form:option value="2">Copper 2</form:option>
													            <form:option value="3">Copper 4</form:option>
													            <form:option value="4">Copper 6</form:option>
													            <form:option value="5">ELM</form:option>
													            <form:option value="6">Weasel</form:option>
													            <form:option value="7">Raccoon</form:option>
													            <form:option value="8">Lynx</form:option>
													            <form:option value="9">Cockroach</form:option>
													            <form:option value="10">ABC 95</form:option>
													            <form:option value="10">ABC 150</form:option>
																</form:select>
																<span id="spnConductor33_3" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												11 kv Conductor cct - 1
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv11ConductorCct1" class="form-control" id="cmbSelectConductor11_1" name="cmbSelectConductor11_1">
										                        <form:option value="1">Copper 1</form:option>
													            <form:option value="2">Copper 2</form:option>
													            <form:option value="3">Copper 4</form:option>
													            <form:option value="4">Copper 6</form:option>
													            <form:option value="5">ELM</form:option>
													            <form:option value="6">Weasel</form:option>
													            <form:option value="7">Raccoon</form:option>
													            <form:option value="8">Lynx</form:option>
													            <form:option value="9">Cockroach</form:option>
													            <form:option value="10">ABC 95</form:option>
													            <form:option value="10">ABC 150</form:option>
																</form:select>
																<span id="spnConductor11_1" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												11 kv Conductor cct - 2
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv11ConductorCct2" class="form-control" id="cmbSelectConductor11_2" name="cmbSelectConductor11_2">
										                        <form:option value="1">Copper 1</form:option>
													            <form:option value="2">Copper 2</form:option>
													            <form:option value="3">Copper 4</form:option>
													            <form:option value="4">Copper 6</form:option>
													            <form:option value="5">ELM</form:option>
													            <form:option value="6">Weasel</form:option>
													            <form:option value="7">Raccoon</form:option>
													            <form:option value="8">Lynx</form:option>
													            <form:option value="9">Cockroach</form:option>
													            <form:option value="10">ABC 95</form:option>
													            <form:option value="10">ABC 150</form:option>
																</form:select>
																<span id="spnConductor11_2" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												11 kv Conductor cct - 3
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv11ConductorCct3" class="form-control" id="cmbSelectConductor11_3" name="cmbSelectConductor11_3">
										                        <form:option value="1">Copper 1</form:option>
													            <form:option value="2">Copper 2</form:option>
													            <form:option value="3">Copper 4</form:option>
													            <form:option value="4">Copper 6</form:option>
													            <form:option value="5">ELM</form:option>
													            <form:option value="6">Weasel</form:option>
													            <form:option value="7">Raccoon</form:option>
													            <form:option value="8">Lynx</form:option>
													            <form:option value="9">Cockroach</form:option>
													            <form:option value="10">ABC 95</form:option>
													            <form:option value="10">ABC 150</form:option>
																</form:select>
																<span id="spnConductor11_3" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												LV Conductor Type
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="mvpole.lvConductorType" value="1" id="radiolvconductortype" checked="checked"/>Fly
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.lvConductorType" value="2" id="radiolvconductortype"/>Wasp
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.lvConductorType" value="2" id="radiolvconductortype"/>ABC
																</label>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Pin / Shackle
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="mvpole.pinShackle" value="1" id="radiopinshackle" checked="checked"/>Pin
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.pinShackle" value="2" id="radiopinshackle"/>Shackle
																</label>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Street Light
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.streetLight" type="number" value ="0" min="0" class="form-control" id="txtstreetlight" placeholder=""/>
																<span id="spnstreetlight" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Stay
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.stay" type="number" value ="0" min="0" class="form-control" id="txtNoofstay" placeholder=""/>
																<span id="spnnoofstay" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Strut
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="mvpole.strut" type="number" value ="0" min="0" class="form-control" id="txtNoofstrut" placeholder=""/>
																<span id="spnnoofstrut" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
        														<td width="30%" style="text-align:left">
                												Cross Arm
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.crossArm" class="form-control" id="cmbSelectCrossArm" name="cmbSelectCrossArm">
										                        <form:option value="1">Pin</form:option>
													            <form:option value="2">Shackle</form:option>
													            <form:option value="3">Pin Composite</form:option>
																</form:select>
																<span id="spnCrossArm" class="label label-danger"></span>
																</td>
																</tr>
																
															    <tr>
                												<td width="30%" style="text-align:left">
                												Earth Conductor
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="mvpole.earthConductor" value="1" id="radioearthconductor" checked="checked"/>Line Earth
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.earthConductor" value="2" id="radioearthconductor"/>Down Earth
																</label>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Line End
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="mvpole.lineEnd" value="1" id="radiolineEnd" checked="checked"/>Yes
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.lineEnd" value="2" id="radiolineEnd"/>No
																</label>
																</td>
																</tr>
																
        														<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 1 ph 1
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct1Ph1" class="form-control" id="cmbSelect33kcct1ph1" name="cmbSelect33kcct1ph1">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct1ph1" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 1 ph 2
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct1Ph2" class="form-control" id="cmbSelect33kcct1ph2" name="cmbSelect33kcct1ph2">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct1ph2" class="label label-danger"></span>
																</td>
																</tr>
																
        														<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 1 ph 3
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct1Ph3" class="form-control" id="cmbSelect33kcct1ph3" name="cmbSelect33kcct1ph3">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct1ph3" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 2 ph 1
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct2Ph1" class="form-control" id="cmbSelect33kcct2ph1" name="cmbSelect33kcct2ph1">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct2ph1" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 2 ph 2
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct2Ph2" class="form-control" id="cmbSelect33kcct2ph2" name="cmbSelect33kcct2ph2">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct2ph2" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 2 ph 3
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct2Ph3" class="form-control" id="cmbSelect33kcct2ph3" name="cmbSelect33kcct2ph3">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct2ph3" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 3 ph 1
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct3Ph1" class="form-control" id="cmbSelect33kcct3ph1" name="cmbSelect33kcct3ph1">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct3ph1" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 3 ph 2
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct3Ph2" class="form-control" id="cmbSelect33kcct3ph2" name="cmbSelect33kcct3ph2">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct3ph2" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												33kv CCT 3 ph 3
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.kv33Cct3Ph3" class="form-control" id="cmbSelect33kcct3ph3" name="cmbSelect33kcct3ph3">
										                        <form:option value="1">Porecelain</form:option>
													            <form:option value="2">Composite</form:option>
													            <form:option value="3">Polymer</form:option>
													            <form:option value="4">Glass</form:option>
																</form:select>
																<span id="spn33kcct3ph3" class="label label-danger"></span>
																</td>
																</tr>
																
									
																
															    <%-- <tr>
        														<td width="80%" style="text-align:left">
                												MV Switch
                												</td>
                												<td width="90%" style="text-align:left">
																<form:select path="mvpole.mvSwitch" class="form-control" id="cmbSelectmvswitch" name="cmbSelectmvswitch">
										                        <form:option value="1">DDLO</form:option>
													            <form:option value="2">LINK</form:option>
													            <form:option value="3">ABS</form:option>
													            <form:option value="4">LBS</form:option>
										                        <form:option value="5">AR</form:option>
													            <form:option value="6">Sectionalizer</form:option>
													            <form:option value="7">CT/PT</form:option>
													            <form:option value="8">VT</form:option>
																</form:select>
																<span id="spnmvswitch" class="label label-danger"></span>
																</td>
																</tr> 
																
																 <tr>
                												<td width="30%" style="text-align:left">
                												Transformer Type
                												</td>
                												<td width="70%" style="text-align:left">
																<label class="radio-inline">
																<form:radiobutton path="mvpole.transformerType" value="1" id="radioTransformerType" checked="checked"/>D
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.transformerType" value="2" id="radioTransformerType"/>B
																</label>
																<label class="radio-inline">
																<form:radiobutton path="mvpole.transformerType" value="2" id="radioTransformerType"/>D/B
																</label>
																</td>
																</tr>
																
																 <tr>
        														<td width="30%" style="text-align:left">
                												Transformer Capacity
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="mvpole.transformerCapacity" class="form-control" id="cmbSelectTransformerCapacity" name="cmbSelectTransformerCapacity">
										                        <form:option value="1">100 KVA</form:option>
													            <form:option value="2">250 KVA</form:option>
													            <form:option value="3">400 KVA</form:option>
													            <form:option value="4">630 KVA</form:option>
										                        <form:option value="5">800 KVA</form:option>
													            <form:option value="6">1000 KVA</form:option>
													            
																</form:select>
																<span id="spntransformerCapacity" class="label label-danger"></span>
																</td>
																</tr> --%>
        														
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Update" class="btn btn-success" />
												
												<!-- <button type="button" class="btn btn-warning" onclick="window.location.href='displayPole'">Edit</button> -->
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