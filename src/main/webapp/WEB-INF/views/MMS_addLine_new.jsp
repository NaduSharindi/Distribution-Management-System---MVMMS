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
	                     url: '/MMS/findAllAreaNew/',
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
	                             $('#cmbSelectArea').append($('<option>').text(item.deptNm).attr('value', item.deptId));
	                         }
	                     }
	              });		
		}
		
		function getLineTypes()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveLineTypes/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectLineType').empty();
	                         //Append "None" item
	                         $('#cmbSelectLineType').append($('<option>').text("<< Select Line Type >>").attr('value', ""));
	
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectLineType').append($('<option>').text(item.lineType).attr('value', item.id));
	                         }
	                     }
	              });		
		}
		
	</script>
</head>
<body onload="getAreas();getLineTypes();">
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
                                <li class="active"><span>Add Line</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form role="form" action="NewMMSaddLine" method="post" modelAttribute="SaveLine">
										
										
										<c:if test="${not empty SaveLine.name}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${SaveLine.name}"></c:out>
									</div>
								
						</tr>
					</c:if>
								
								
								
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
																<tr>
                												<td width="30%" style="text-align:left">
                												Line Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="code" type="text" class="form-control" id="txtCode" placeholder="Enter Code"/>
																<span id="spnCode" class="label label-danger"></span>
																</td>
																</tr>												
									
																<tr>
                												<td width="30%" style="text-align:left">
                												Department ID 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="phmBranch" type="text" value="${sessionScope.deptId}" class="form-control" id="txtDeptId" placeholder="Enter Dept id" disabled="true"/>					
																</td>
																</tr>	
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Line Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="lineName" type="text" class="form-control" id="txtName" placeholder="Enter Name"/>
																<span id="spnName" class="label label-danger"></span>
																</td>
																</tr>	
																
                              									<tr>
                												<td width="30%" style="text-align:left">
                												Line Type
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="lineType" class="form-control" id="cmbSelectLineType" name="cmbSelectLineType">
																</form:select>
																<span id="spnSelectLineType" class="label label-danger"></span>
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Length
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="length" type="number" class="form-control" id="txtLength" placeholder="Enter Length"/>
																<span id="spnLength" class="label label-danger"></span>
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Line Area
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select path="area" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Poles
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="noofpoles" type="number" class="form-control" id="txtPoles" placeholder="Enter Poles"/>
																<span id="spnPoles" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Towers
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="nooftowers" type="number" class="form-control" id="txtNoOfTowers" placeholder="Enter Poles"/>
																<span id="spnNoOfTowers" class="label label-danger"></span>
																</td>
                												   
        														</tr>
																
																
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Com Date
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="comdate" type="date" class="form-control" id="txtComDate" placeholder="Enter ComDate"/>
																<span id="spnComDate" class="label label-danger"></span></td>
																    
        														</tr>
        														
        														
        														
        														
																
																</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											<c:if test="${mode=='ADD'}">
												<input type="submit" Value="Add" class="btn btn-success" />
												</c:if>
												<c:if test="${mode=='MODIFY'}">
												<input type="submit" Value="Modify" class="btn btn-success" />
												</c:if>
												
											</div>
										</div>

									</form:form>
								</div>
							</div>
						</div>

					</div>

					

						</div>
					</div>
				</div>
			</div>
			<%@ include file="sections/footer.jsp" %>
		<%@ include file="sections/global_scripts.jsp" %>
</body>
</html>