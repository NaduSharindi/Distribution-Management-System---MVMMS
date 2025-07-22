<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<style type="text/css">



div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}
	</style>
	
	<script type="text/javascript">
	
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
                                <li class="active"><span>Add General Details</span></li>
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
									<form:form role="form" action="MMSaddGeneral" method="post" modelAttribute="SaveGeneral">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		<tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:options items="${SaveGeneral.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.area"  onchange="getLine();getCSC();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveGeneral.areaList}" />
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
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.lineId" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${SaveGeneral.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
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
                												Gantry Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.code" type="text" class="form-control" id="txtCode" placeholder="Enter Gantry Code"/>
																<span id="spnGantryCode" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Short circuit current capacity(kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.shortCctCurntCapacity" type="number" value ="0" min="0" class="form-control" id="txtshortcircit" placeholder="Enter short circit current capacity(kA)"/>
																<span id="spnShortcircit" class="label label-danger"></span>
																</td>    
        														</tr>
        														<tr>
        														
                												<td width="30%" style="text-align:left">
                												Earth fault current capacity(kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.earthFaultCurntCapacity" type="number" value ="0" min="0" class="form-control" id="txtEarthfault" placeholder="Enter earth fault curent capacity(kA)"/>
																<span id="spnEarthfault" class="label label-danger"></span>
																</td>    
        														</tr>
        														
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Commissing 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.dateOfComm" type="date" class="form-control" id="txtDate"/>
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
                												Total Land Area
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
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
										
											</div>
										</div>
										<br>
										
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