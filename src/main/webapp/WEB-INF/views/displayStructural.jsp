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
		
function loaddata(){
	
	var strCode = cmbSelectGantry.options[cmbSelectGantry.selectedIndex].value;
	
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
                     document.getElementById("txtnoOfPoles").value = item.seNoPoles;
                     document.getElementById("cmbSelectOverheadEarthing").value = item.seOverheadEarthing;
                     document.getElementById("txtGroundRes").value = item.seGroungRes;
                     document.getElementById("txtCuConRes").value = item.seCuConRes;
                     
                    
                     
                    
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
                                <li class="active"><span>Update Structural & Earthing System</span></li>
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
									<form:form role="form" action="MMSupdateStructural" method="post" modelAttribute="UpdateStructural">
										                        
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		
			                                              		<tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateStructural.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.area"  onchange="getLine();getGantryByArea();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${UpdateStructural.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.lineId" onchange="getGantryByAreaLine()" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${UpdateStructural.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
																</td>
																</tr> --%> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.id" onchange="loaddata()" class="form-control" id="cmbSelectGantry" name="cmbSelectGantry">
																      
																</form:select>
																<span id="spnSelectGantry" class="label label-danger"></span>
																</td>
																</tr> 
																
									                            <tr>
                												<td width="30%" style="text-align:left">
                												No Of Poles
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.seNoPoles" type="number" value ="0" min="0" class="form-control" id="txtnoOfPoles" placeholder="Enter No Of Poles"/>
																<span id="spnNoOfPoles" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
        														<td width="30%" style="text-align:left">
                												Overhead Earthing
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.seOverheadEarthing" class="form-control" id="cmbSelectOverheadEarthing" name="cmbSelectOverheadEarthing">
										                             <form:option value="1">Yes</form:option>
										                             <form:option value="2">No</form:option>
																</form:select>
																<span id="spnOverheadEarthing" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Ground Resistance
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.seGroungRes" type="text" class="form-control" id="txtGroundRes" placeholder="Enter Ground Resistance"/>
																<span id="spnGroundRes" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Earthing CU conductor size(sqmm)
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.seCuConRes" type="text" class="form-control" id="txtCuConRes" placeholder="Enter Cu Conductor Resistance"/>
																<span id="spnCuConRes" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Type
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" class="form-control" id="cmbSelectType" name="cmbSelectType">
										                            <form:option value="1">Derp</form:option>
										                            <form:option value="2">Hyundai</form:option>
										                            <form:option value="3">Modified</form:option>
										                            <form:option value="4">Other</form:option>
										                            
																</form:select>
																<span id="spnOverheadEarthing" class="label label-danger"></span>
																</td>
																</tr>
																
        														
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