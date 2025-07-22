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
		    width: 100%;
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
		function LoadLineTypesToEdit(ltid)
		{
			
				enable(ltid);
			
		}
		
        function disable(ltid)
        {
            document.getElementById("ltname_"+ltid).disabled = true;
            document.getElementById("ltstatus_"+ltid).disabled = true;
            document.getElementById("ltorder"+ltid).disabled = true;
        }
        function enable(ltid)
        {
            document.getElementById("ltname_"+ltid).disabled = false;
            document.getElementById("ltstatus_"+ltid).disabled = false;
            document.getElementById("ltorder_"+ltid).disabled = false;
            
        }
        
       function save(ltid) 
        {
    	   var ltname = document.getElementById("ltname_"+ltid).value;
    	   var ltorder = document.getElementById("ltorder_"+ltid).value;
    	   var ltstatus = document.getElementById("ltstatus_"+ltid).value;
    	   
    	   
    	   var url = "/MMS/updatecycle/"+ltid+"/"+ltname+"/"+ltorder+"/"+ltstatus;
    	   //alert(url);
            $.ajax({
            	type: "GET",
                url : url,
                success : function(response) {
                    alert("Cycle updated succesfully...");
                    console.log(response);
                    window.location.reload();
                    disable(ltid);
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
											<h2 class="pull-left">List of Cycle</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAdmin">

                                                    <thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">Name</th>
															<th class="text-center">Order</th>
															<th class="text-center">Status</th>
															<th class="text-center" data-orderable="false"></th>
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="cycle" items="${cycle}" >
											                <tr>  
											                <td><input type="text" id="ltid" value="${cycle.id.cycleId}" class="form-control" disabled></td>
											                <td><input type="text" id="ltname_${cycle.id.cycleId}" value="${cycle.cycleName}" class="form-control" disabled></td>
											                 <td><input type="text" id="ltorder_${cycle.id.cycleId}" value="${cycle.cycleOrder}" class="form-control" disabled></td>
											                
											                 <td><select id="ltstatus_${cycle.id.cycleId}" class="form-control" disabled>
											                	<c:choose>
											                		<c:when test="${cycle.status==4}">
											                			<option value="${cycle.status}" selected="selected">Inactive</option>
											                			<option value="1">Active</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:when>
											                		
											                		<c:when test="${cycle.status==1}">
											                			<option value="${cycle.status}" selected="selected">Active</option>
											                			<option value="4">Inactive</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:when>
											                			
											                		<c:when test="${cycle.status==2}">
											                			<option value="${cycle.status}" selected="selected">In bulk</option>
											                			<option value="0">Inactive</option>
											                			<option value="1">Active</option>
											                			
											                		</c:when>
											                		
											                		<c:when test="${cycle.status==0}">
											                			<option value="${cycle.status}" selected="selected">Inactive</option>
											                			<option value="1">Send for Approval</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:when>
											                		
											                		<c:otherwise>
											                			<option value="${cycle.status}" selected="selected">Rejected</option>
											                			<option value="0">Inactive</option>
											                			<option value="1">Send for Approval</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:otherwise>
											                		</c:choose>	
											                </select ></td>  
											                <td><button type='button' class='btn btn-warning' onClick='LoadLineTypesToEdit("${cycle.id.cycleId}")'>Edit</button>&nbsp;
											                <button type='button' class='btn btn-success' onClick='javascript:save("${cycle.id.cycleId}")'>Save</button></td>      
											                </tr>
											                
											            </c:forEach>
													</tbody>
												</table>
											
										</div>
										<header class="main-box-header clearfix">
											<button type="button" class="btn btn-info" onclick="window.location.href='addLineType'">Back</button>
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