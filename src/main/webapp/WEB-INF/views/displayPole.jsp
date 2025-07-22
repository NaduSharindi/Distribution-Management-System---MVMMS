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
		function LoadPoleToEdit(pid)
		{
			if(document.getElementById("pstatus_"+pid).value == 0 || document.getElementById("pstatus_"+pid).value == 1 || document.getElementById("pstatus_"+pid).value == 4){
				alert("This item is sent for approving or active item or inactive item. You cann't edit this");
			}
			else{
				enable(pid);
			}
		}
		
        function disable(pid)
        {   
            
            document.getElementById("poleNo_"+pid).disabled = true;
        	document.getElementById("poleType_"+pid).disabled = true;
        	document.getElementById("poleArea_"+pid).disabled = true;
        	document.getElementById("noOfStay_"+pid).disabled = true;
        	document.getElementById("noOfStruts_"+pid).disabled = true;
        	document.getElementById("conductorType_"+pid).disabled = true;
        	document.getElementById("noOfConsumers1ph_"+pid).disabled = true;
        	document.getElementById("noOfConsumers3ph_"+pid).disabled = true;
        	document.getElementById("gpsLatitude_"+pid).disabled = true;
        	document.getElementById("gpsLongitude_"+pid).disabled = true;
        	document.getElementById("pstatus_"+pid).disabled = true;
        	
        }
        function enable(pid)
        {
        	
        	document.getElementById("poleNo_"+pid).disabled = false;
        	document.getElementById("poleType_"+pid).disabled = false;
        	document.getElementById("poleArea_"+pid).disabled = false;
        	document.getElementById("noOfStay_"+pid).disabled = false;
            document.getElementById("noOfStruts_"+pid).disabled = false;
        	document.getElementById("conductorType_"+pid).disabled = false;
        	document.getElementById("noOfConsumers1ph_"+pid).disabled = false;
        	document.getElementById("noOfConsumers3ph_"+pid).disabled = false;
       		document.getElementById("gpsLatitude_"+pid).disabled = false;
        	document.getElementById("gpsLongitude_"+pid).disabled = false;
        	document.getElementById("pstatus_"+pid).disabled = false;
     
            
        }
        
       function save(pid) 
        {
    	   //alert("called");
    	   var poleNo = document.getElementById("poleNo_"+pid).value;
    	   var poleType = document.getElementById("poleType_"+pid).value;
    	   var poleArea = document.getElementById("poleArea_"+pid).value;
    	   var noOfStay = document.getElementById("noOfStay_"+pid).value;
    	   var noOfStruts = document.getElementById("noOfStruts_"+pid).value;
    	   var conductorType = document.getElementById("conductorType_"+pid).value;
    	   var noOfConsumers1ph = document.getElementById("noOfConsumers1ph_"+pid).value;
    	   var noOfConsumers3ph = document.getElementById("noOfConsumers3ph_"+pid).value;
    	   var gpsLatitude = document.getElementById("gpsLatitude_"+pid).value;
    	   var gpsLongitude = document.getElementById("gpsLongitude_"+pid).value;
    	   var status = document.getElementById("pstatus_"+pid).value;
    	 
    	    var url = "/MMS/updatePole/"+pid+"/"+poleNo+"/"+poleType+"/"+poleArea+"/"+noOfStay+"/"+noOfStruts+"/"+conductorType+"/"+noOfConsumers1ph+"/"+noOfConsumers3ph+"/"+gpsLatitude+"/"+gpsLongitude+"/"+status+"/";
    	   
    	  // alert(url);
    	   
            $.ajax({
            	type: "GET",
                url : url,
                success : function(response) {
                    alert("Pole updated succesfully...");
                    console.log(response);
                    window.location.reload();
                    disable(pid);
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
									
										<header class="main-box-header clearfix">
											<h2 class="pull-left">List of Pole</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAdmin">

                                                    <thead>
														<tr>
                                                            <th class="text-center">ID</th> 
                                                            <th class="text-center">Pole No</th>
															<th class="text-center">Pole Material</th>
															<th class="text-center">Pole Area</th>
															<th class="text-center">No of Stay</th>
															<th class="text-center">No of Strut</th>
															<th class="text-center">Line Details</th>
															 <th class="text-center">No of Consumers(1ph)</th>
															<th class="text-center">No of Consumers(3ph)</th>
															<th class="text-center">Gps Latitude</th>
															<th class="text-center">Gps Longitude</th>
															<th class="text-center">Status</th>
													        <th class="text-center">Edit</th>
															<th class="text-center">Save</th>
															
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="Pole" items="${Pole}" >
											                <tr>
											                
											                <td><input type="text" id="id" value="${Pole.id}" class="form-control" disabled></td>
											                <td><input type="text" id="poleNo_${Pole.id}" value="${Pole.poleNo}" class="form-control" disabled></td>
											                <td><input type="text" id="poleType_${Pole.id}" value="${Pole.poleType}" class="form-control" disabled></td>
											               
                                                      		<td><input type="text" id="poleArea_${Pole.id}" value="${Pole.area}" class="form-control" disabled></td>
											                <td><input type="text" id="noOfStay_${Pole.id}" value="${Pole.noOfStay}" class="form-control" disabled></td>
											                <td><input type="text" id="noOfStruts_${Pole.id}" value="${Pole.noOfStruts}" class="form-control" disabled></td>
											                <td><input type="text" id="conductorType_${Pole.id}" value="${Pole.conductorType}" class="form-control" disabled></td>
											                <td><input type="text" id="noOfConsumers1ph_${Pole.id}" value="${Pole.noOfConsumers1ph}" class="form-control" disabled></td>
											                <td><input type="text" id="noOfConsumers3ph_${Pole.id}" value="${Pole.noOfConsumers3ph}" class="form-control" disabled></td>
											                <td><input type="text" id="gpsLatitude_${Pole.id}" value="${Pole.gpsLatitude}" class="form-control" disabled></td>
											                <td><input type="text" id="gpsLongitude_${Pole.id}" value="${Pole.gpsLongitude}" class="form-control" disabled></td>
											                <td><select id="pstatus_${Pole.id}" class="form-control" disabled>
											                	<c:choose>
											                		<c:when test="${Pole.status==0}">
											                			<option value="${Pole.status}" selected="selected">Pending</option>
											                		</c:when>
											                		
											                		<c:when test="${Pole.status==1}">
											                			<option value="${Pole.status}" selected="selected">Active</option>
											                		</c:when>
											                			
											                		<c:when test="${Pole.status==2}">
											                			<option value="${Pole.status}" selected="selected">In bulk</option>
											                			<option value="0">Send for Approval</option>
											                		</c:when>
											                		
											                		<c:when test="${Pole.status==4}">
											                			<option value="${Pole.status}" selected="selected">Inactive</option>
											                		</c:when>
											                		
											                		<c:otherwise>
											                			<option value="${Pole.status}" selected="selected">Rejected</option>
											                			<option value="0">Send for Approval</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:otherwise>
											                	
											                	</c:choose>	
											                </select ></td>
											                
											                
											                  
											                <td><button type='button' class='btn btn-warning' onClick='LoadPoleToEdit("${Pole.id}")'>Edit</button></td>
											                <td><button type='button' class='btn btn-success' onClick='javascript:save("${Pole.id}")'>Save</button></td>      
											                </tr>
											                
											            </c:forEach>
													</tbody>
												</table>
											
										</div>
										<header class="main-box-header clearfix">
											<button type="button" class="btn btn-info" onclick="window.location.href='addPole'">Back</button>
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