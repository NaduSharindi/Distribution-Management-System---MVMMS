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
                     url: '/MMS/findActiveAreas/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 $('#cmbSelectArea').empty();
                         //Append "None" item
                         $('#cmbSelectArea').append($('<option>').text("<< Select Area >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectArea').append($('<option>').text(item.area).attr('value', item.area));
                         }
                     }
              });		
	}
	
	function showCSC()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllCSC/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 $("#tblCSC > tbody:last").children().remove();

                    	 //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             
                             tr = $('<tr/>');
                                tr.append("<td>" + item.id + "</td>"); 
                                tr.append("<td>" + item.csc + "</td>");
                                tr.append("<td>" + item.area + "</td>");
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

                                $('#tblCSC').append(tr);
                         }
                         
                         $('#tblCSC').dataTable({
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
	    	 
	    	 if (validateEmpty("txtCSCName") == false) {
                 throw 1001;
             }
	    	 
	    	 if (validateList("cmbSelectArea") == false) {
                 throw 1002;
             }
	    	 
	    	 if (validateEmpty("txtStatus") == false) {
                 throw 1003;
             }
	    	 
	    	 enable();
	    	 
	    	 return true;
			
		} catch (e) {
			if (e == 1000) {
                document.getElementById("spnId").innerHTML = "CSC Id is Required !";
                ScrollToElement("spnId");
            }
			
			if (e == 1001) {
                document.getElementById("spnCSCName").innerHTML = "CSC Name is Required !";
                ScrollToElement("spnCSCName");
            }
			
			if (e == 1002) {
                document.getElementById("spnSelectArea").innerHTML = "CSC Area Name is Required !";
                ScrollToElement("spnSelectArea");
            }
			
			if (e == 1003) {
                document.getElementById("spnStatus").innerHTML = "CSC Status is Required !";
                ScrollToElement("spnStatus");
            }
			return false;
			
		}
		
	}
	
	 function clearErrorMessages() {
         document.getElementById('spnId').innerHTML = "";
         document.getElementById('spnCSCName').innerHTML = "";
         document.getElementById('spnSelectArea').innerHTML = "";
         document.getElementById('spnStatus').innerHTML = "";
     }
	 
	 function enable(){
		 document.getElementById("txtDeptId").disabled= false;
	 }
	 
	</script>
</head>
<body onload="getAreas();showCSC();">
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
                                <li class="active"><span>CSC</span></li>
                            </ol>

                            <h1>Add CSC</h1>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form role="form" method="post" action="MMSAddCSC" modelAttribute="CscSave" onsubmit="return validateForm()">
										
										<div class="form-group">
											<label for="txtId">ID :
											<form:input path="id" type="text" class="form-control" id="txtId" placeholder="Enter ID"/>
											<span id="spnId" class="label label-danger"></span></label>
										</div>
										
										<div class="form-group">
											<label for="txtCSCName">CSC :
											<form:input path="csc" type="text" class="form-control" id="txtCSCName" placeholder="Enter CSC"/>
											<span id="spnCSCName" class="label label-danger"></span></label>
										</div>

										<div class="form-group">
											<label>Area :
											<form:select path="area" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
										
											</form:select>
											<span id="spnSelectArea" class="label label-danger"></span></label>
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
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayCSC'">Edit</button>
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
											<h2 class="pull-left">CSC List</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                            					<table class="table table-responsive" id="tblCSC">
													<thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">CSC</th>
															<th class="text-center">Area</th>
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