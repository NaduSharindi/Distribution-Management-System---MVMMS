<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	<script type="text/javascript">
	
	function showInsulatorTypes()
		{
			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllInsulatorTypes/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 $("#tblInsulatorTypes > tbody:last").children().remove();

                    	 //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];

                             
                             tr = $('<tr/>');
                                tr.append("<td>" + item.id + "</td>"); 
                                tr.append("<td>" + item.type + "</td>"); 
                               
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

                                $('#tblInsulatorTypes').append(tr);
                         }
                         
                         $('#tblInsulatorTypes').dataTable({
                                'info': false,
                                'pageLength': 10,
                                retrieve: true
                            });
                     }
              });	
		}
	
		function validateForm() {
			clearErrorMessages();
		    try {
		    	 if (validateEmpty("txtId") == false) {
	                 throw 1000;
	             }
		    	 
		    	 if (validateEmpty("txtInsulatorType") == false) {
	                 throw 1001;
	             }
		    	 
		    	 if (validateEmpty("txtStatus") == false) {
	                 throw 1002;
	             }
		    	 return true;
				
			} catch (e) {
				if (e == 1000) {
	                document.getElementById("spnId").innerHTML = "Insulator Type Id is Required !";
	                ScrollToElement("spnId");
	            }
				
				if (e == 1001) {
	                document.getElementById("spnInsulatorType").innerHTML = "Insulator Type is Required !";
	                ScrollToElement("spnInsulatorType");
	            }
				
				if (e == 1002) {
	                document.getElementById("spnStatus").innerHTML = "Insulator Type Status is Required !";
	                ScrollToElement("spnStatus");
	            }
				return false;
			}
		}
		
		 function clearErrorMessages() {
	         document.getElementById('spnId').innerHTML = "";
	         document.getElementById('spnInsulatorType').innerHTML = "";
	         document.getElementById('spnStatus').innerHTML = "";
	     }
	</script>
	
</head>
<body onload="showInsulatorTypes()">
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
                                <li class="active"><span>Insulator Type</span></li>
                            </ol>

                            <h1>Add Insulator Type</h1>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form role="form" method="post" action="MMSAddInsulatorType" modelAttribute="SaveInsulatorType" onsubmit="return validateForm()">
										
										<div class="form-group">
											<label for="txtId">ID :
											<form:input path="id" type="text" class="form-control" id="txtId" placeholder="Enter ID"/>
											<span id="spnId" class="label label-danger"></span></label>
										</div>
										
										<div class="form-group">
											<label for="txtLineName">Type :
											<form:input path="type" type="text" class="form-control" id="txtInsulatorType" placeholder="Enter Insulator Type"/>
											<span id="spnInsulatorType" class="label label-danger"></span></label>
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
												<button type="button" class="btn btn-warning" onclick="window.location.href='editInsulatorType'">Edit</button>
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
											<h2 class="pull-left">Insulator Types List</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblInsulatorTypes">

                                                    <thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">Insulator Type</th>
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