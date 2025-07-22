<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">
	function searchProvinces()
	{
			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findActiveProvince/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 $('#cmbSelectProvince').empty();
                         //Append "None" item
                         $('#cmbSelectProvince').append($('<option>').text("<< Select Province >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectProvince').append($('<option>').text(item.province).attr('value', item.province));
                         }
                     }
              });
                     

		
	}
	
	function validateForm() {
		clearErrorMessages();
	    try {
	    	
	    	enable();
	    	
	    	 if (validateEmpty("txtId") == false) {
                 throw 1000;
             }
	    	 
	    	 if (validateList("cmbSelectProvince") == false) {
                 throw 1001;
             }
	    	 
	    	 if (validateEmpty("txtAreaName") == false) {
                 throw 1002;
             }
	    	 
	    	 if (validateEmpty("txtStatus") == false) {
                 throw 1003;
             }
	    	 return true;
			
		} catch (e) {
			if (e == 1000) {
                document.getElementById("spnId").innerHTML = "Area Id is Required !";
                ScrollToElement("spnId");
            }
			
			if (e == 1001) {
                document.getElementById("spnProvince").innerHTML = "Province Name is Required !";
                ScrollToElement("spnProvince");
            }
			
			if (e == 1002) {
                document.getElementById("spnAreaName").innerHTML = "Area Name is Required !";
                ScrollToElement("spnAreaName");
            }
			
			if (e == 1003) {
                document.getElementById("spnStatus").innerHTML = "Area Status is Required !";
                ScrollToElement("spnStatus");
            }
			return false;
		}
	}
	
	function enable(){
		 document.getElementById("txtDeptId").disabled= false;
	 }
	
	 function clearErrorMessages() {
         document.getElementById('spnId').innerHTML = "";
         document.getElementById('spnProvince').innerHTML = "";
         document.getElementById('spnAreaName').innerHTML = "";
         document.getElementById('spnStatus').innerHTML = "";
     }
	
	function showAreas()
			{
					
					 $.ajax
		             ({
		                     type: 'GET',
		                     url: '/MMS/findAllAreas/',
		                     data: {},
		                     contentType: "application/json; charset=utf-8",
		                     success: function(response) 
		                     {
		                    	 $("#tblAreas > tbody:last").children().remove();

		                    	 //Insert item from the response
		                         for (var i = 0; i < response.length; i++) {
		                             var item = response[i];

		                             
		                             tr = $('<tr/>');
		                                tr.append("<td>" + item.id + "</td>"); 
		                                tr.append("<td>" + item.area + "</td>");
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
<body onload="searchProvinces();showAreas();">
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
                                <li class="active"><span>Area</span></li>
                            </ol>

                            <h1>Add Area</h1>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
				
					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form method="post" role="form" modelAttribute="SaveArea" action="MMSAddArea" onsubmit="return validateForm()" id="reg">
										
										<div class="form-group">
											<label for="txtId">ID :
											<form:input path="id" type="text" class="form-control" id="txtId" placeholder="Enter ID"/>
											<span id="spnId" class="label label-danger"></span></label>								
										</div>

										<div class="form-group">
											<label for="cmbSelectProvince">Province :
											<form:select path="province" class="form-control" id="cmbSelectProvince">
												
											</form:select>
											<span id="spnProvince" class="label label-danger"></span></label>
										</div>

										<div class="form-group">
											<label for="txtAreaName">Area :
											<form:input path="area" type="text" class="form-control" id="txtAreaName" placeholder="Enter Area"/>										
											<span id="spnAreaName" class="label label-danger"></span></label>
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
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayAreas'">Edit</button>
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
											<h2 class="pull-left">Area Name List</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">Name</th>
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