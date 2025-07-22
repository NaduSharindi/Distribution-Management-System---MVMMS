<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MV-MMS</title>
		<%@ include file="sections/headEdit.jsp" %>
		
		<style type="text/css">
			.form-control {
		    display: inline-block;
		    width: -webkit-fill-available;
		    height: 34px;
		    font-size: 12px;
		    color: #0f1893;
		    border-color: #095f9f;
		    background-color: #fff;
		    font-weight: 800;
		    border-radius: 4px;
			}
			
		</style>
	
	<script type="text/javascript">
		function LoadSupportToEdit(pid)
		{
			
				enable(pid);
		}
		
        function disable(pid)
        {
            document.getElementById("a1_"+pid).disabled = true;
        	document.getElementById("b2_"+pid).disabled = true;
        	document.getElementById("c3_"+pid).disabled = true;
        	document.getElementById("d4_"+pid).disabled = true;
        	document.getElementById("e5_"+pid).disabled = true;
        	document.getElementById("f6_"+pid).disabled = true;
        	document.getElementById("g7_"+pid).disabled = true;
        	document.getElementById("h8_"+pid).disabled = true;
        	document.getElementById("i9_"+pid).disabled = true;
        	document.getElementById("j10_"+pid).disabled = true;
        	document.getElementById("k11_"+pid).disabled = true;
        	document.getElementById("l12_"+pid).disabled = true;
        	document.getElementById("m13_"+pid).disabled = true;
        	document.getElementById("pstatus_"+pid).disabled = true;
        	document.getElementById("n14_"+pid).disabled = true;
        }
        function enable(pid)
        {
        	document.getElementById("a1_"+pid).disabled = false;
        	document.getElementById("b2_"+pid).disabled = false;
        	document.getElementById("c3_"+pid).disabled = false;
        	document.getElementById("d4_"+pid).disabled = false;
        	document.getElementById("e5_"+pid).disabled = false;
        	document.getElementById("f6_"+pid).disabled = false;
        	document.getElementById("g7_"+pid).disabled = false;
        	document.getElementById("h8_"+pid).disabled = false;
        	document.getElementById("i9_"+pid).disabled = false;
        	document.getElementById("j10_"+pid).disabled = false;
        	document.getElementById("k11_"+pid).disabled = false;
        	document.getElementById("l12_"+pid).disabled = false;
        	document.getElementById("m13_"+pid).disabled = false;
        	document.getElementById("pstatus_"+pid).disabled = false;
        	document.getElementById("n14_"+pid).disabled = false;
            
        }
        
       function save(pid) 
        {
    	   alert("called");
    	   var aaa = document.getElementById("a1_"+pid).value;
    	   var bbb = document.getElementById("b2_"+pid).value;
    	   var ccc = document.getElementById("c3_"+pid).value;
    	   var ddd = document.getElementById("d4_"+pid).value;
    	   var eee = document.getElementById("e5_"+pid).value;
    	   var fff = document.getElementById("f6_"+pid).value;
    	   var ggg = document.getElementById("g7_"+pid).value;
    	   var hhh = document.getElementById("h8_"+pid).value;
    	   var iii = document.getElementById("i9_"+pid).value;
    	   var jjj = document.getElementById("j10_"+pid).value;
    	   var kkk = document.getElementById("k11_"+pid).value;
    	   var lll = document.getElementById("l12_"+pid).value;
    	   var mmm = document.getElementById("m13_"+pid).value;
    	   var status = document.getElementById("pstatus_"+pid).value;
    	   var nnn = document.getElementById("n14_"+pid).value;
    	   
    	   var url = "/MMS/updateSupport/"+aaa+"/"+bbb+"/"+pid+"/"+ccc+"/"+ddd+"/"+eee+"/"+fff+"/"+ggg+"/"+hhh+"/"+iii+"/"+jjj+"/"+kkk+"/"+lll+"/"+mmm+"/"+status+"/"+nnn;
    	   
            $.ajax({
            	type: "GET",
                url : url,
                success : function(response) {
                    alert("Support updated succesfully...");
                    console.log(response);
                    saveApprove(pid);
                }
            });
            
            
    
			
		}
       
       function saveApprove(pid){
    	   alert("work");
    	   var towerNo = document.getElementById("c3_"+pid).value;
    	   var deptId = ${sessionScope.deptId};
    	   var approveLevel = ${sessionScope.loggedUserRole}; 
    	   var approveBy = ${sessionScope.loggedUser};
    	   var toStatus = document.getElementById("pstatus_"+pid).value;
    	   
    	   alert(towerNo);
    	   alert(deptId);
    	   alert(approveLevel);
    	   alert(approveBy);
    	   alert(toStatus);
    	   
    	   var save =  "/MMS/saveApprove/"+towerNo+"/"+deptId+"/"+approveLevel+"/"+approveBy+"/"+toStatus;
    	   alert(save);
    	   
    	   $.ajax({
           	type: "GET",
               url : save,
               success : function(response) {
                   alert("Approved saved succesfully...");
                   console.log(response);
                   disable(pid);
                   window.location.reload();
               }
           });
       }
        
	</script>
</head>

<body>
<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		
		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp" %>
				<div id="content-wrapper">
					
					<div class="row">
					<div class="col-lg-12">		                                    
                                               
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
								<div class="col-lg-12">
									
										<header class="main-box-header clearfix">
											<h2 class="pull-left">List of Support</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive" style="overflow-x:auto;">
                                              <table class="table table-responsive" id="tblAdmin">

                                                    <thead>
														<tr>
                                                            <th class="text-center">ID</th>                                                            
															<th class="text-center">Support Type</th>
															<th class="text-center">Line Name</th>
															<th class="text-center">Tower No</th>
															<th class="text-center">Area</th>
															<th class="text-center">CSC</th>
															<th class="text-center">Conductor Type</th>
															<th class="text-center">Earth Con: Type</th>
															<th class="text-center">Tower Type</th>
															<th class="text-center">Tower Config:</th>
															<th class="text-center">GPS-Latitude</th>
															<th class="text-center">GPS-Longitude</th>
															<th class="text-center">Circuits</th>
															<th class="text-center">Body Extension</th>
															<th class="text-center">Status</th>
															<th class="text-center">Approval Level</th>
															<th class="text-center">Edit</th>
															<th class="text-center">Save</th>
															
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="Support" items="${Support}" >
											                <tr>
											                
											                <td><input type="text" id="id" value="${Support.id}" class="form-control" disabled></td>
											                
											                <td><select id="a1_${Support.id}" class="form-control" disabled>
											                	<c:choose>
											                		<c:when test="${Support.supportType.equals('Tower')}">
											                			<option value="${Support.supportType}" selected="selected">Tower</option>
											                			<option value="Line Number">Line Number</option>
											                		</c:when>
											                		
											                		<c:otherwise>
											                			<option value="${Support.supportType}" selected="selected">Line Number</option>
											                			<option value="Tower">Tower</option>
											                		</c:otherwise>
											                	</c:choose>
											                	</select>
											                </td> 
											               
											                <td><input type="text" id="b2_${Support.id}" value="${Support.lineName}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="c3_${Support.id}" value="${Support.towerNo}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="d4_${Support.id}" value="${Support.area}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="e5_${Support.id}" value="${Support.csc}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="f6_${Support.id}" value="${Support.conductorType}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="g7_${Support.id}" value="${Support.earthConductorType}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="h8_${Support.id}" value="${Support.towerType}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="i9_${Support.id}" value="${Support.towerConfiguration}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="j10_${Support.id}" value="${Support.gpsLatitude}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="k11_${Support.id}" value="${Support.gpsLongitude}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="l12_${Support.id}" value="${Support.noOfCircuits}" class="form-control" disabled></td>
											                
											                <td><input type="text" id="m13_${Support.id}" value="${Support.bodyExtension}" class="form-control" disabled></td>
											                
											                <td><select id="pstatus_${Support.id}" class="form-control" disabled>
											                			<option value="${Support.status}" selected="selected">Pending</option>
											                			<option value="1">Approve</option>
											                			<option value="3">Reject</option>
											                </select ></td>
											                
											                 <td><select id="n14_${Support.id}" class="form-control" disabled>
											                			<option value="${Support.approvalLevel}" selected="selected">${Support.approvalLevel}</option>
											                	</select>
											                </td> 
											                  
											                <td><button type='button' class='btn btn-warning' onClick='LoadSupportToEdit("${Support.id}")'>Edit</button></td>
											                <td><button type='button' class='btn btn-success' onClick='javascript:save("${Support.id}")'>Save</button></td>      
											                </tr>
											                
											            </c:forEach>
													</tbody>
												</table>
											
										</div>
										<header class="main-box-header clearfix">
											<button type="button" class="btn btn-info" onclick="window.location.href='viewSupport'">Back</button>
										</header>
										
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