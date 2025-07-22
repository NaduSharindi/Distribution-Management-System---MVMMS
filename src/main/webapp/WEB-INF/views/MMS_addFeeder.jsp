<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
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

	
		
	</script>
</head>
<body onload="getConductorTypes();">
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
                                <li class="active"><span>Add Feeder</span></li>
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
									<form:form role="form" action="MMSaddFeeder" method="post" modelAttribute="SaveFeeder">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		 <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																    <form:option value="province">PROVINCE</form:option>
																   <form:options items="${SaveFeeder.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path=""  onchange="getLine();getGantryByArea();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveFeeder.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getGantryByAreaLine()" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${SaveFeeder.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
																</td>
																</tr> --%> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="feeder.id.gantryId" class="form-control" id="cmbSelectGantry" name="cmbSelectGantry">
																      
																</form:select>
																<span id="spnSelectGantry" class="label label-danger"></span>
																</td>
																</tr> 
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="feeder.typeInOut" class="form-control" id="cmbType" name="cmbSelectType">
										                        <form:option value="1">Incoming</form:option>
													            <form:option value="2">Outgoing</form:option>
																</form:select>
																<span id="spnType" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Bay Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="feeder.code" type="text" class="form-control" id="txtBayNumber" placeholder="Enter Bay Number"/>
																<span id="spnBayNumber" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Description
                												</td>
                												<td width="70%" style="text-align:left">
																<form:textarea path="feeder.name" class="form-control" id="txtDescription" placeholder="Enter Description"/>
																<span id="spnDescription" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Feeder Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="feeder.feederType" class="form-control" id="cmbFeederType" name="cmbSelectFeederType">
										                        <form:option value="1">Overhead</form:option>
													            <form:option value="2">Underground</form:option>
																</form:select>
																<span id="spnFeederType" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Conductor Type
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="feeder.conductor" class="form-control" id="cmbSelectConductorType" name="cmbSelectConductorType">
										
																</form:select>
																<span id="spnConductorType" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of AutoRecloser
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="feeder.noAr" type="number" value ="0" min="0" class="form-control" id="txtnoOfAutoRecloserF" placeholder="Enter No Of AutoRecloser"/>
																<span id="spnNoOfAutoRecloserF" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of LBS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="feeder.noLbs" type="number" value ="0" min="0" class="form-control" id="txtnoOfLBSF" placeholder="Enter No Of LBS"/>
																<span id="spnNoOfLBSF" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of ABS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="feeder.noAbs" type="number" min="0" value ="0" class="form-control" id="txtnoOfABSF" placeholder="Enter No Of ABS"/>
																<span id="spnNoOfABSF" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Surge Arrestors
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="feeder.noSa" type="number" min="0" value ="0" class="form-control" id="txtnoOfSurgeArrestorsF" placeholder="Enter No Of Surge Arrestors"/>
																<span id="spnNoOfSurgeArrestorsF" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Latitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="feeder.gpsLatitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLatitude" placeholder="Enter GPS Latitude"/>
																<span id="spnGPSLatitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Longitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="feeder.gpsLongitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLongitude" placeholder="Enter GPS Longitude"/>
																<span id="spnGPSLongitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
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