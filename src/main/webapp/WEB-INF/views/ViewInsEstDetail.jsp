<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width:80%;
    
}
tr:nth-child(even) {
    background-color: #dddddd;
    hight:20%;
}


table, th, td {
    border: 0px solid black;
    align:left;
    text-align:left;
    hight:15%;
    
}


</style>
<html>
	<head>
		<%@ include file="sections/head.jsp" %>
		
			<script type="text/javascript">

			

				function ConfirmActivate(comid){
					
						alert("hiiii");
						$.ajax
				        ({
				        	
				                type: 'GET',
				                url: "/MMS/viewProvinceNew/"+ comid,
				                data: {},
				                contentType: "application/json; charset=utf-8",
				                success: function(response) 
				                {
				                    alert(response);
				               	 
				                }
				         });
						
					
				}
				 
				 function showProvinces()
					{
							
							 $.ajax
				             ({
				                     type: 'GET',
				                     url: '/MMS/findAllProvinces/',
				                     data: {},
				                     contentType: "application/json; charset=utf-8",
				                     success: function(response) 
				                     {
				                    	 $("#tblProvinces > tbody:last").children().remove();
		
				                    	 //Insert item from the response
				                         for (var i = 0; i < response.length; i++) {
				                             var item = response[i];
											 var comid = item.compId;
				                             
				                             tr = $('<tr/>');
											 tr.append("<td> " + item.compNm + "</td>");
											 tr.append("<td>" + "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"+comid+"')>Go</button>" + "</td>");
											 
				                                
				                                $('#tblProvinces').append(tr);
				                         }
				                         
				                         $('#tblProvinces').dataTable({
				                                'info': false,
				                                'pageLength': 10,
				                                retrieve: true
				                            });
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
				                                <li class="active"><span>Inspection Estimate </span></li>
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 style="font-family:verdana;"><font color="#000000"><strong>INSPECTION ESTIMATE FOR THE :  ${area}</strong></font> </h2>
														
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	
																</thead>
																<tbody>
																<form:form  method="post" action="saveSPS" modelAttribute="pivModel">
																
																 <table class="table table-responsive" id="tblProvinces">
																 
																 <c:if test="${not empty pivModel.message}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${pivModel.message}"></c:out>
									</div>
								
						</tr>
					</c:if>
																
															<!-- 	<tr>
																<td width="30%" style="text-align:left">
                												<form:label path="">PROVINCE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select  id="province" path ="glcompmobj.compId" onchange="findArea()">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${pivModel.provinceList}"/>
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
																 <form:options items="${pivModel.areaList}"/>
																</form:select>
																</td>
																    
        														</tr>-->
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Electrical Superintendent
                												</td>
                												<td width="70%" style="text-align:left">
																
																<form:select  id="userId" path ="sauserm.userId" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${pivModel.saList}"/>
																</form:select>
																</td>
																    
        														</tr>
																	<tr>
                												<td width="30%" style="text-align:left">
                												Applicant
                												</td>
                												<td width="70%" style="text-align:left">
																
																<form:select  id="userId" path ="applicant.idNo" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${pivModel.appList}"/>
																</form:select>
																</td>
																    
        														</tr>
																
																
																
        														<tr>
        														
        														<td width="40%" style="text-align:left">
									Total Line Length in Area
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.totalLineLength" value ="${inspection.totalLineLength}" readonly="true"></form:input>
								
								</td>
        							</tr>
        							<tr>
        							<td width="40%" style="text-align:left">
									Total Number of Towers in Area
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.totalNoTowers" value ="${inspection.totalNoTowers}" readonly="true"></form:input>
								
								</td>
        							</tr>
        								<tr>
        							<td width="40%" style="text-align:left">
									Number of days for the Inspection (C) 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.noDaysForTheIns" value ="${inspection.noDaysForTheIns}" readonly="true"></form:input>
								
								</td>
        							</tr>
        							<tr>
        							<td width="40%" style="text-align:left">
									Labour Hours for the Estimate (D 1) 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.labourHoursForEst" value ="${inspection.labourHoursForEst}" readonly="true"></form:input>
								
								</td>
        							</tr>
        								<tr>
        							<td width="40%" style="text-align:left">
									Labour value for the Estimate (D) LKR 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.labourValueForEst" value ="${inspection.labourValueForEst}" readonly="true"></form:input>
								
								</td>
        							</tr>						
        							<tr>
        							<td width="40%" style="text-align:left">
									Subsistance (E) LKR 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.subsistance" value ="${inspection.subsistance}" readonly="true"></form:input>
								
								</td>
        							</tr>
        								<tr>
        							<td width="40%" style="text-align:left">
									Hot line Allowance (F) LKR 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.hotLineAllowances" value ="${inspection.hotLineAllowances}" readonly="true"></form:input>
								
								</td>
        							</tr>	
        							<tr>
        							<td width="40%" style="text-align:left">
									Temporarly site cost LKR (minimum 30,000) 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.temporarySiteCost" value ="${inspection.temporarySiteCost}" readonly="true"></form:input>
								
								</td>
        							</tr>	
        							
        								<tr>
        							<td width="40%" style="text-align:left">
									Transport Cost 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.transport" value ="${inspection.transport}" readonly="true"></form:input>
								
								</td>
        							</tr>
        								<tr>
        							<td width="40%" style="text-align:left">
									Total Inspection Estimate 
									</td>
									<td width="60%" style="text-align:left">
																
									<form:input path="inspection.tatalCost" value ="${inspection.tatalCost}" readonly="true"></form:input>
								
								</td>
        							</tr>		
        								
        												
        														<tr>
        														<td  style="text-align:left"   >
        														<input class="btn btn-success" type="submit" name="actionButton"	value="Save"></input> 
        														</td>
        														</tr>
        														 </table>
        														</form:form>
        														
        														</tbody>
															</table>
															<h3><strong>Inception Estimate for the Area</strong></h3>
<table>
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
    <td>Yoshi Tannamuri</td>
    
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
</table>
														</div>
														
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