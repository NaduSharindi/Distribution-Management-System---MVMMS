<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">
	
	function getAreas()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllAreaNew/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 $('#cmbSelectPoleArea').empty();
                         //Append "None" item
                         $('#cmbSelectPoleArea').append($('<option>').text("<< Select Area >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectPoleArea').append($('<option>').text(item.deptNm).attr('value', item.deptId));
                         }
                     }
              });		
	}
	
	
	   function selectPhase(){
            var x = cmbSelectNoOfConsumers.value;
            switch(cmbSelectNoOfConsumers.value){
                case "1":
                	 txtNoOfConsumers1ph.readOnly =false;
                     txtNoOfConsumers3ph.readOnly = true;
                     break;
                case "2":
                     txtNoOfConsumers1ph.readOnly=true;
                     txtNoOfConsumers3ph.readOnly=false;
                     break;
            }
        }
        
         function predisable(){
            txtNoOfConsumers1ph.readOnly=false;
            txtNoOfConsumers3ph.readOnly=true;

           
        }
	
	
		
		
		function getPoleTypes()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActivePoleTypes/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectPoleType').empty();
	                         //Append "None" item
	                         /* $('#cmbSelectLineType').append($('<option>').text("<< Select Line Type >>").attr('value', ""));
	 */
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectPoleType').append($('<option>').text(item.poleType).attr('value', item.id));
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
		
		function getCSC()

		{			
				
			var strUser = cmbSelectPoleArea.options[cmbSelectPoleArea.selectedIndex].value;
			
			   $.ajax
		         ({
		                 type: 'GET',
		                 url: "/MMS/findAllCSCByArea/" + strUser + "/",
		                 data: {},
		                 contentType: "application/json; charset=utf-8",
		                 success: function(data) 
		                 {  
		                     var slctSubcat = $('#cmbSelectcsc'), option = "<option value='NONE'>CSC</option>";
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
			
			
	
		
	</script>
</head>
<body onload="getPoleTypes();getConductorTypes();predisable();getAreas();">
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
                                <li class="active"><span>Add Pole</span></li>
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
								  
									<form:form role="form" action="MMSaddPole" method="post" modelAttribute="SavePole">
										                        
										
<!--                                                                 <p id="demo"></p> -->
								
								
								
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Pole Id
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="id" type="text" class="form-control" id="txtPoleId" placeholder="Enter Pole Id"/>
																<span id="spnPoleId" class="label label-danger"></span>
																
																</td>
																</tr> --%>
			                                              		
			                                              		<tr>
                												<td width="30%" style="text-align:left">
                												Pole No
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="poleNo" type="text" class="form-control" id="txtPoleNo" placeholder="Enter Pole No"/>
																<span id="spnPoleNo" class="label label-danger"></span>
																
																</td>
																</tr>
												
                              									<tr>
                												<td width="30%" style="text-align:left">
                												Pole Material
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="poleType" class="form-control" id="cmbSelectPoleType" name="cmbSelectPoleType">
																
																</form:select>
																<span id="spnSelectPoleType" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Pole Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="area" class="form-control" onchange="getCSC()" id="cmbSelectPoleArea" name="cmbSelectPoleArea">
																
																</form:select>
																<span id="spnSelectPoleArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												CSC
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="csc" class="form-control" id="cmbSelectcsc" name="cmbSelectcsc">
																
																</form:select>
																<span id="spnSelectcsc" class="label label-danger"></span>
																</td>
																</tr>
        														

        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Stay
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="noOfStay" type="number" value ="0" min="0" class="form-control" id="txtNoOfStay" placeholder="Enter No Of Stay"/>
																<span id="spnNoOfStay" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Strut
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="noOfStruts" type="number" value ="0" min="0" class="form-control" id="txtNoOfStruts" placeholder="Enter No Of Struts"/>
																<span id="spnNoOfStruts" class="label label-danger"></span>
																</td>
                												   
        														</tr>
																
																
        														

																<tr>
                												<td width="30%" style="text-align:left">
                												Line Details
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="conductorType" class="form-control" id="cmbSelectConductorType" name="cmbSelectConductorType">
										
																</form:select>
																<span id="spnConductorType" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														<tr>
        														<td width="30%" style="text-align:left">
                												Consumer Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" class="form-control" id="cmbSelectNoOfConsumers" name="cmbSelectNoOfConsumers" onchange="selectPhase()">
										                        <form:option value="1">Single Phase</form:option>
													            <form:option value="2">Three Phase</form:option>
																</form:select>
																<span id="spnNoOfConsumers" class="label label-danger"></span>
																</td>
																<tr>
																
                												<td width="30%" style="text-align:left">
                												No of Consumers (1ph)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="noOfConsumers1ph" type="number" value ="0" min="0" class="form-control" id="txtNoOfConsumers1ph"  placeholder="Enter No Of Consumers" />
																<span id="spnNoOfConsumers1ph" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														<tr>
																
                												<td width="30%" style="text-align:left">
                												No of Consumers (3ph)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="noOfConsumers3ph" type="number" value ="0" min="0" class="form-control" id="txtNoOfConsumers3ph"  placeholder="Enter No Of Consumers" />
																<span id="spnNoOfConsumers3ph" class="label label-danger"></span>
																</td>
																    
        														</tr>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Gps Latitude
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gpsLatitude" type="text" class="form-control" id="txtGpsLatitude" placeholder=""/>
																<span id="spnGpsLatitude" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Gps Longitude
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gpsLongitude" type="text" class="form-control" id="txtGpsLongitude" placeholder=""/>
																<span id="spnGpsLongitude" class="label label-danger"></span>
																
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