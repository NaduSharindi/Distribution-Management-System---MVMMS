<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">
	
	function showAreas()
			{
					
					 $.ajax
		             ({
		                     type: 'GET',
		                     url: '/MMS/findAllLine/',
		                     data: {},
		                     contentType: "application/json; charset=utf-8",
		                     success: function(response) 
		                     {
		                    	 $("#tblAreas > tbody:last").children().remove();

		                    	 //Insert item from the response
		                         for (var i = 0; i < response.length; i++) {
		                             var item = response[i];
		                             var lineType;
		                             if(item.lineType == "1"){
		                            	 lineType = "Backbone";			                             
			                         }else if(item.lineType == "2"){
			                        	 lineType = "Distributor";
				                     }
		                             
		                             tr = $('<tr/>');
		                             	tr.append("<td>" + item.code + "</td>");
		                                tr.append("<td>" + item.lineName + "</td>"); 
		                                tr.append("<td>" + lineType + "</td>");
		                                tr.append("<td>" + item.length + "</td>");
		                                tr.append("<td>" + item.area + "</td>");
		                                tr.append("<td>" + item.deptId + "</td>");
		                                tr.append("<td>" + item.noofpoles + "</td>");
		                                tr.append("<td>" + item.nooftowers + "</td>");
		                                tr.append("<td>" + item.comdate + "</td>");
		                               
		                           /**     if(item.status==0){
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
		                                
		                                tr.append("<td>" + item.approvalLevel + "</td>");*/
		                                //console.log(item);

		                                //Show "Edit" and "Delete" buttons
		                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");

		                                $('#tblAreas').append(tr);
		                         }
		                         
		                         $('#tblAreas').dataTable({
		                                'info': false,
		                                'pageLength': 10,
		                                retrieve: true
		                            });
		                     }
		              });
				
			}
	 
	 
	</script>

</head>
<body onload="showAreas();">
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
                                <li class="active"><span>Line</span></li>
                            </ol>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">Line List with Status</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
														<tr>                                                             
															                                                        
															<th class="text-center">Code</th>
															<th class="text-center">Line Name</th>
															<th class="text-center">Line Type</th>
															<th class="text-center">Length</th>
															<th class="text-center">Area</th>
															<th class="text-center">CSC</th>
															<th class="text-center">No of Poles</th>
															<th class="text-center">No of Towers</th>
															<th class="text-center">COM Date</th>
															
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
											
											<header class="main-box-header clearfix">
												<button type="button" class="btn btn-info" onclick="window.location.href='approveSupport'">Approve Items</button>
											</header>
										
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