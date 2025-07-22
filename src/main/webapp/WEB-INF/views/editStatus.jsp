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
		function LoadStatusToEdit(ltid)
		{
			if(document.getElementById("ltstatus_"+ltid).value == 0 || document.getElementById("ltstatus_"+ltid).value == 1 || document.getElementById("ltstatus_"+ltid).value == 4){
				alert("This item is sent for approving or active item or inactive item. You can't edit this");
			}
			else{
				enable(ltid);
			}
		}
		
        function disable(ltid)
        {
            document.getElementById("ltname_"+ltid).disabled = true;
            document.getElementById("ltstatus_"+ltid).disabled = true;
        }
        function enable(ltid)
        {
            document.getElementById("ltname_"+ltid).disabled = false;
            document.getElementById("ltstatus_"+ltid).disabled = false;
        }
        
       function save(ltid) 
        {
    	   var ltname = document.getElementById("ltname_"+ltid).value;
    	   var ltstatus = document.getElementById("ltstatus_"+ltid).value;
    	   var url = "/MMS/updateStatus/"+ltname+"/"+ltid+"/"+ltstatus;
    	   
            $.ajax({
            	type: "GET",
                url : url,
                success : function(response) {
                    alert("Status updated succesfully...");
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
											<h2 class="pull-left">List of Status</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAdmin">

                                                    <thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">Type</th>
															<th class="text-center">Name</th>
															<th class="text-center">Status</th>
															<th class="text-center" data-orderable="false"></th>
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="Status" items="${Status}" >
											                <tr>  
											                <td><input type="text" id="ltid" value="${Status.id}" class="form-control" disabled></td>
											                <td><input type="text" id="ltname_${Status.id}" value="${Status.type}" class="form-control" disabled></td>
											                <td><input type="text" id="ltname_${Status.id}" value="${Status.name}" class="form-control" disabled></td>
											                 <td><select id="ltstatus_${Status.id}" class="form-control" disabled>
											                	<c:choose>
											                		<c:when test="${Status.status.equals('0')}">
											                			<option value="${Status.status}" selected="selected">Pending</option>
											                		</c:when>
											                		
											                		<c:when test="${Status.status.equals('1')}">
											                			<option value="${Status.status}" selected="selected">Active</option>
											                		</c:when>
											                			
											                		<c:when test="${Status.status.equals('2')}">
											                			<option value="${Status.status}" selected="selected">In bulk</option>
											                			<option value="0">Send for Approval</option>
											                		</c:when>
											                		
											                		<c:when test="${Status.status.equals('4')}">
											                			<option value="${Status.status}" selected="selected">Inactive</option>
											                		</c:when>
											                		
											                		<c:otherwise>
											                			<option value="${Status.status}" selected="selected">Rejected</option>
											                			<option value="0">Send for Approval</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:otherwise>
											                	
											                	</c:choose>	
											                </select ></td>  
											                <td><button type='button' class='btn btn-warning' onClick='LoadStatusToEdit("${Status.id}")'>Edit</button>&nbsp;
											                <button type='button' class='btn btn-success' onClick='javascript:save("${Status.id}")'>Save</button></td>      
											                </tr>
											                
											            </c:forEach>
													</tbody>
												</table>
											
										</div>
										<header class="main-box-header clearfix">
											<button type="button" class="btn btn-info" onclick="window.location.href='addStatus'">Back</button>
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