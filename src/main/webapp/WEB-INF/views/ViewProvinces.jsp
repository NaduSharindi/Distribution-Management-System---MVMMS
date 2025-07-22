<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<%@ include file="sections/head.jsp" %>
		
			<script type="text/javascript">
				 
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
				                                <li class="active"><span>Provinces</span></li>
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">Provinces List with Status</h2>
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