<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<%@ include file="sections/head.jsp" %>
		
			<script type="text/javascript">
				function validateForm() {
					clearErrorMessages();
					
				    try {
				    	 			    	 
				    	 if (validateEmpty("txtId") == false) {
		                     throw 1000;
		                 }
				    	 
				    	 if (validateEmpty("txtProvince") == false) {
		                     throw 1001;
		                 }
				    	 
				    	 if (validateEmpty("txtStatus") == false) {
		                     throw 1002;
		                 }
				    	 
				    	 enable();
	
				    	 return true;
						
					} catch (e) {
						if (e == 1000) {
		                    document.getElementById("spnId").innerHTML = "Province Id is Required !";
		                    ScrollToElement("spnId");
		                }
						
						if (e == 1001) {
		                    document.getElementById("spnProvince").innerHTML = "Province Name is Required !";
		                    ScrollToElement("spnProvince");
		                }
						
						if (e == 1002) {
		                    document.getElementById("spnStatus").innerHTML = "Province Status is Required !";
		                    ScrollToElement("spnStatus");
		                }
						
						return false;
					}
				}
				
				 function clearErrorMessages() {
		             document.getElementById('spnId').innerHTML = "";
		             document.getElementById('spnProvince').innerHTML = "";
		             document.getElementById('spnStatus').innerHTML = "";
		             
		         }
				 
				 function enable(){
					 document.getElementById("txtDeptId").disabled= false;
				 }
				 
				 
				 function showProvinces()
					{
							
							 $.ajax
				             ({
				                     type: 'GET',
				                     url: '/MMS/findAll/',
				                     data: {},
				                     contentType: "application/json; charset=utf-8",
				                     success: function(response) 
				                     {
				                    	 $("#tblProvinces > tbody:last").children().remove();
		
				                    	 //Insert item from the response
				                         for (var i = 0; i < response.length; i++) {
				                             var item = response[i];
		
				                             
				                             tr = $('<tr/>');
				                                tr.append("<td>" + item.id + "</td>"); 
				                                tr.append("<td>" + item.province + "</td>");
				                                tr.append("<td>" + item.deptId + "</td>");
				                               
				                                if(item.status==0){
				                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
				                                } else if(item.status==1){ 
				                                    tr.append("<td><span class='label label-success'>Active</span></td>"); 
				                                }
				                                else if(item.status==2){ 
				                                    tr.append("<td><span class='label label-default'>In bulk</span></td>"); 
				                                }
				                                else if(item.status==3){ 
				                                    tr.append("<td><span class='label label-danger'>Rejected</span></td>"); 
				                                }
				                                else if(item.status==4){ 
				                                	tr.append("<td><span class='label label-info'>Inactive</span></td>");  
				                                }
				                                //console.log(item);
		
				                                //Show "Edit" and "Delete" buttons
				                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");
		
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
				 
				 
			</script>
	</head>
	<body onload="showProvinces();">
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
				                                <li class="active"><span>Province</span></li>
				                            </ol>
				
				                            <h1>Add Province</h1>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
					
								<div class="row">
									<div class="col-lg-6">
										
										<div class="main-box">
			
											<div class="main-box-body clearfix">
												<form:form method="post" role="form" modelAttribute="ProvinceSave" action="MMSAddProvince" onsubmit="return validateForm()" id="reg">
													
													<div class="form-group">
														<label for="txtId">ID :
														<form:input path="id" type="text" class="form-control" id="txtId" placeholder="Enter ID"/>
														<span id="spnId" class="label label-danger"></span></label>
													</div>
													
													<div class="form-group">
														<label for="txtProvince">Province :
														<form:input path="province" type="text" class="form-control" id="txtProvince" placeholder="Enter Province" />					
														<span id="spnProvince" class="label label-danger"></span></label>
													</div>
													
													<div class="form-group">
														<label for="txtDeptId">Department ID :
														<form:input path="deptId" type="text" value="${sessionScope.deptId}" class="form-control" id="txtDeptId" placeholder="Enter Dept id" disabled="true"/>					
														</label>
													</div>
													
													<div class="form-group">
														<label for="txtStatus">Status :
														<form:select path="status" class="form-control" id="txtStatus" placeholder="Enter Status">
															<form:option value="" selected="selected"> << SELECT >> </form:option>
															<form:option value="0">Send for Approval</form:option>
															<form:option value="2">Keep in Bulk</form:option>
														</form:select>										
														<span id="spnStatus" class="label label-danger"></span></label>
													</div>
													
													<div class="form-group">
														<div class="pull-left">
															<input type="submit" Value="Add" class="btn btn-success" />
															<button type="button" class="btn btn-warning" onclick="window.location.href='displayProvince'">Edit</button>
														</div>
													</div>
												</form:form>
											</div>
										</div>
									</div>
								</div>
									
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">Province Name List</h2>
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	<tr>
			                                                                                                                         
																		<th class="text-center">ID</th>
																		<th class="text-center">Province</th>
																		<th class="text-center">Department ID</th>
																		<th class="text-center">Status</th>
																		<th class="text-center" data-orderable="false"></th>
																		
																	</tr>
																</thead>
																<tbody>
																	
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