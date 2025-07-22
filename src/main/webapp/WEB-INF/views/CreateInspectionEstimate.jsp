<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">




table, th, td {
    border: 0px solid black;
    align:left;
    text-align:left;
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
						alert("hiii");
						var strUser = province.options[province.selectedIndex].value;
						alert("hiiittt : "+strUser);
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
						alert("hiii");
						var strUser = area.options[area.selectedIndex].value;
						alert("hiiittt : "+strUser);
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
				                                <li class="active"><span>Generate Inspection Estimate   </span></li>
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">Generate Inspection Estimate   </h2>
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	
																</thead>
																<tbody>
																<form:form  method="post" action="GenerateHotLineReport" modelAttribute="model">
																 <table class="table table-responsive" id="tblProvinces">
			
															<!-- 	<tr>
																<td width="30%" style="text-align:left">
                												<form:label path="">PROVINCE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select  id="province" path ="glcompmobj.compId" onchange="findArea()">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td>
																    
        														</tr>-->
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">AREA</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																
																<form:select  id="area" path ="gldeptobj.deptId" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.areaList}"/>
																</form:select>
																</td>
																    
        														</tr>
        														<!-- <tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">LINE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select  id="line" path ="line.code" onchange="">
                												
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.lineList}"/>
																</form:select>
																
																 </td>   
        														</tr>-->
        														<tr>
                											<!--	<td width="30%" style="text-align:left">
                												<form:label path="">LINE TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																     </td>  
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CONDUCTOR TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td> 
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CIRCUIT TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																    </td> 
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">SUPPORT TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.supTypeList}"/>
																</form:select>
																
																   </td>  
        														</tr>
        														
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												
                												<form:label path="">TOWER CONFIGURATION</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																  </td>   
        														</tr>-->
        														
        														<tr>
        														<td  style="text-align:left"   ><a href="../MMS/GenerateReportTM?area=431&line=49">
        														<input class="button" type="submit" name="actionButton"	value="View"></input></a> 
        														</td>
        														</tr>
        														 </table>
        														</form:form>
        														
        														</tbody>
															</table>
														</div>
														
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