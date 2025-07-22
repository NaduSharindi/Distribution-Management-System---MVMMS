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
				
				
			   $.ajax
	             ({
	                     type: 'GET',
	                     url: "/MMS/findGantryByAreaLine/470.00/9/",
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {   //alert("success");
	                    	 $('#cmbSelectGantry').empty();
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectGantry').append($('<option>').text(item.code).attr('value', item.id));
	                         }
	                         
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
                                <li class="active"><span>Surge Arrestor</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form role="form" action="MMSaddSurgeArrestor" method="post" modelAttribute="SaveSurgeArrestor">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		   <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:options items="${SaveSurgeArrestor.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path=""  onchange="getLine()" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveSurgeArrestor.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getGantryByAreaLine()" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${SaveSurgeArrestor.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
																</td>
																</tr> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" class="form-control" id="cmbSelectGantry" name="cmbSelectGantry">
																      
																</form:select>
																<span id="spnSelectGantry" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Brand
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="" type="text" class="form-control" id="txtBrandSA" placeholder="Enter Brand"/>
																<span id="spnBrandSA" class="label label-danger"></span>
																
																</td>
																</tr>
																 
									                            <tr>
                												<td width="30%" style="text-align:left">
                												Rating
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="" type="number" value ="0" min="0" class="form-control" id="txtRatingSA" placeholder="Enter Rating"/>
																<span id="spnRatingSA" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Date of Manufacture
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="" type="date" class="form-control" id="txtDateSA"/>
																<span id="spnDateSA" class="label label-danger"></span>
																
																</td>
																</tr>
        														
																<tr>
                												<td width="30%" style="text-align:left">
                												Quantity
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="" type="number" value ="0" min="0" class="form-control" id="txtQuantitySA" placeholder="Enter Quantity"/>
																<span id="spnQuantitySA" class="label label-danger"></span>
																</td>    
        														</tr>
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayPole'">Edit</button>
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