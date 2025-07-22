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
                     var slctSubcat = $('#cmbSelectBusBarCondutor'), option = "<option value='NONE'>Conductor Types</option>";
						slctSubcat.empty();
						for (var i = 0; i < response.length; i++) {
                      var item = response[i];
							option = option
									+ "<option value='"+item.id + "'>"
									+ item.type + "</option>";
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
	                 url: "/MMS/findGantryByArea/"+strArea+"/",
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
                                <li class="active"><span>Add Bus bar & Auxiliary System</span></li>
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
									<form:form role="form" action="MMSaddBusbar" method="post" modelAttribute="SaveBusbar">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		 <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${SaveBusbar.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvinceBA" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.area"  onchange="getLine();getGantryByArea();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveBusbar.areaList}" />
																</form:select>
																<span id="spnSelectAreaBA" class="label label-danger"></span>
																</td>
																</tr>
																
															<%-- 	<tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.lineId" onchange="getGantryByAreaLine()" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${SaveBusbar.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
																</td>
																</tr>  --%>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.id" class="form-control" id="cmbSelectGantry" name="cmbSelectGantry">
																      
																</form:select>
																<span id="spnSelectGantry" class="label label-danger"></span>
																</td>
																</tr> 
																
									                            <tr>
        														<td width="30%" style="text-align:left">
                												Bus Bar Conductor 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.busBarCondutoer" class="form-control" id="cmbSelectBusBarCondutor" name="cmbSelectBusBarCondutor">
										                        
																</form:select>
																<span id="spnBusBarCondutor" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Bus Bar Insulator 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.busBarInsulator" class="form-control" id="cmbSelectBusBarInsulator" name="cmbSelectBusBarInsulator">
										                               <form:option value="1">70 kN Gun</form:option>
										                               <form:option value="2">70 kN Dead End</form:option>
										                               <form:option value="3">120 kN</form:option>
																</form:select>
																<span id="spnBusBarInsulator" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												No Of Transformers
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.busBarNoTranformer" type="number" value ="0" min="0" class="form-control" id="txtnoOftxtnoOfTransformers" placeholder="Enter No Of Transformers"/>
																<span id="spnNoOfTransformers" class="label label-danger"></span>
																</td>    
        														</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												No Of LBS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.busBarLbs" type="number" value ="0" min="0" class="form-control" id="txtnoOfLBS" placeholder="Enter No Of LBS"/>
																<span id="spnNoOfLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of ABS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.busBarAbs" type="number" min="0" value ="0" class="form-control" id="txtnoOfABS" placeholder="Enter No Of ABS"/>
																<span id="spnNoOfABS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of DDLO Sets
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.busBarDdlo" type="number" min="0" value ="0" class="form-control" id="txtnoOfDDLOSets" placeholder="Enter No Of DDLO Sets"/>
																<span id="spnNoOfDDLOSets" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Surge Arrestors
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.busBarSa" type="number" min="0" value ="0" class="form-control" id="txtnoOfSurgeArrestors" placeholder="Enter No Of Surge Arrestors"/>
																<span id="spnNoOfSurgeArrestors" class="label label-danger"></span>
																</td>    
        														</tr>
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												
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