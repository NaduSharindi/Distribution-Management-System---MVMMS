<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">

	function findArea(){
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findAllAreaByProvinceNew/" + strUser,
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(data) 
                 {
                	 var slctSubcat=$('#area'), option="<option value='NONE'>ALL</option>";
                     slctSubcat.empty();
                     for(var i=0; i<data.length; i++){
                         option = option + "<option value='"+data[i].deptId + "'>"+data[i].deptNm + "</option>";
                     }
                     slctSubcat.append(option);

                	 //alert("response.towerNo" + data);	
                 }
          });	

		
	}


	function getLine(){
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findLineByArea/" + strUser +"/",
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(data) 
                 {
                	 var slctSubcat=$('#line'), option="<option value='NONE'>ALL</option>";
                     slctSubcat.empty();
                     for(var i=0; i<data.length; i++){
                         option = option + "<option value='"+data[i].code + "'>"+data[i].lineName + "</option>";
                     }
                     slctSubcat.append(option);

                	 //alert("response.towerNo" + data);	
                 }
          });	

		
	}
	</script>
</head>
<body onload="">
<div id="theme-wrapper">
	<%@ include file="sections/PCBheader.jsp" %>
	
		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/PCBuserLevels.jsp" %>
				
				<div id="content-wrapper">
				
				<div class="row">
				<div class="col-lg-12">		                                    
                        <div class="col-lg-9">
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li class="active"><span>Equipment</span></li>
                            </ol>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
					
					
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">Upload Equipment </h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
													
													</thead>
													<tbody>
																<form:form  method="post" action="uploadEqui" enctype="multipart/form-data" modelAttribute="model">
																 <table class="table table-responsive" id="tblProvinces">
																<c:if test="${not empty model.mode}">
																<tr>
																<td colspan="2" class="msgSuccess" align="center">
																<div class="msgSuccess">
																<c:out value="${model.mode}"></c:out>
																</div>
																</tr>
					                                            </c:if>
			
													     	    <tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file">
																</td>
																    
        														</tr>
        														<tr>
        														
        														</tr>
        													  <%-- <tr>
        														
																<td width="30%" style="text-align:left">
                												<label>Name:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="" type="text" name="name"></form:input></td>
																    
        														</tr>  --%>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												<label>Press here to upload the file:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input type="submit" value="Upload"> 
																    </td>
        														</tr>
        														
        														
                                                                        														
        														 </table>
        														 
        														 <table class="table table-responsive" id="tblAdmin">

																<thead>
																	<tr>
																		<th class="text-center">Equipment Number</th>
																		<th class="text-center">Reference Number</th>
																		<th class="text-center">Branch</th>
									</tr>
									</thead>
									<tbody>
															<c:forEach var="pcbModel" items="${model.listPcbModel}">
																<tr>
																<td><a href="<c:url value='/editEquipmentNew?equid=${pcbModel.pcbEquipment.equipmentId}' />" >${pcbModel.pcbEquipment.equipmentId}</a></td>
        
																	<td><input type="text" id="pid" value="${pcbModel.pcbEquipment.equipmentId}"
																		class="form-control" disabled></td>
 															        <td><input type="text" id="prefNo_${pcbModel.pcbEquipment.equipmentId}"
																		value="${pcbModel.pcbEquipment.referenceNo}" class="form-control" disabled></td>
																	<td><input type="text" id="pbranch_${pcbModel.pcbEquipment.equipmentId}"
																		value="${pcbModel.pcbEquipment.branch}" class="form-control" disabled></td>
									</tr>
									</c:forEach>
									</table>
        														 
        														 
        														</form:form>
        														
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