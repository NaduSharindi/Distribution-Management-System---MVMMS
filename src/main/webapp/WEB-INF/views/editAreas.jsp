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
		function LoadAreasToEdit(pid)
		{
			//var data = {id: pid};
			if(document.getElementById("status_"+pid).value == 0 || document.getElementById("status_"+pid).value == 1 || document.getElementById("status_"+pid).value == 4){
				alert("This item is sent for approving or active item or inactive item. You cann't edit this");
			}
			else{
				enable(pid);
			}
			
		}
		
        function disable(pid)
        {
            document.getElementById("area_"+pid).disabled = true;
            document.getElementById("province_"+pid).disabled = true;
            document.getElementById("status_"+pid).disabled = true;
        }
        function enable(pid)
        {
            document.getElementById("area_"+pid).disabled = false;
            document.getElementById("province_"+pid).disabled = false;
            document.getElementById("status_"+pid).disabled = false;
        }
        
       function save(pid) 
        {
    	   var area = document.getElementById("area_"+pid).value;
    	   var province = document.getElementById("province_"+pid).value;
    	   var status = document.getElementById("status_"+pid).value;
    	   var url = "/MMS/updateAreas/"+pid+"/"+province+"/"+area+"/"+status;
    	   
            $.ajax({
            	type: "GET",
                url : url,
                success : function(response) {
                    alert("Areas updated succesfully...");
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
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">List of Areas</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAdmin">

                                                    <thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">Area</th>
															<th class="text-center">Province</th>
															<th class="text-center">Status</th>
															<th class="text-center" data-orderable="false"></th>
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="Area" items="${Area}" >
											                <tr>  
											                <td><input type="text" id="id" value="${Area.id}" class="form-control" disabled></td>
											                <td><input type="text" id="area_${Area.id}" value="${Area.area}" class="form-control" disabled></td>
											                <td><input type="text" id="province_${Area.id}" value="${Area.province}" class="form-control" disabled></td>
											                <td><select id="status_${Area.id}" class="form-control" disabled>
											                	<c:choose>
											                		<c:when test="${Area.status.equals('0')}">
											                			<option value="${Area.status}" selected="selected">Pending</option>
											                		</c:when>
											                		
											                		<c:when test="${Area.status.equals('1')}">
											                			<option value="${Area.status}" selected="selected">Active</option>
											                		</c:when>
											                			
											                		<c:when test="${Area.status.equals('2')}">
											                			<option value="${Area.status}" selected="selected">In bulk</option>
											                			<option value="0">Send for Approval</option>
											                		</c:when>
											                		
											                		<c:when test="${Area.status.equals('4')}">
											                			<option value="${Area.status}" selected="selected">Inactive</option>
											                		</c:when>
											                		
											                		<c:otherwise>
											                			<option value="${Area.status}" selected="selected">Rejected</option>
											                			<option value="0">Send for Approval</option>
											                			<option value="2">Send to bulk</option>
											                		</c:otherwise>
											                	
											                	</c:choose>	
											                </select ></td>
											                
											                <td><button type='button' class='btn btn-warning' onClick='LoadAreasToEdit("${Area.id}")'>Edit</button>&nbsp;
											                <button type='button' class='btn btn-success' onClick='javascript:save("${Area.id}")'>Save</button></td>      
											                </tr>
											                
											            </c:forEach>
													</tbody>
												</table>
											</div>
											
										</div>
										<header class="main-box-header clearfix">
											<button type="button" class="btn btn-info" onclick="window.location.href='addArea'">Back</button>
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