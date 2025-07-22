<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ include file="sections/head.jsp"%>

<script type="text/javascript">
	
</script>
</head>
<body onload="">
	<div id="theme-wrapper">
		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<c:if test="${submitType == 'search'}">
										<li class="active"><span>Edit Completion Data</span></li>
									</c:if>
									<c:if test="${submitType == 'update'}">
										<li class="active"><span>Update Completion Data</span></li>
									</c:if>
								</ol>


							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">


									<c:if test="${submitType == 'search'}">

										<c:if test="${not empty success}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: green; font-weight: bold;">
														<c:out value="${success}"></c:out>
													</div>
											</tr>
										</c:if>

										<c:if test="${not empty errormsg}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: red; font-weight: bold;">
														<c:out value="${errormsg}"></c:out>
													</div>
											</tr>
										</c:if>

										<form:form role="form" action="goToUpdateeditCompletionData"
											method="post" modelAttribute="model">
											<h2 class="pull-left">
												<strong>Completion Data</strong>
											</h2>

											<table class="table table-responsive" id="tblEquipment">
												<tbody>

													<tr>
														<td width="50%" style="text-align: left">Tower ID</td>
														<td width="70%" style="text-align: left"><form:input
																path="txtMntObj.id.towerid" type="text"
																class="form-control" id="txtTowerId"
																placeholder="Enter Tower Number" /> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
														<td></td>

														<td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value="Search"
																		class="btn btn-success" />
																</div>
															</div>
														</td>

													</tr>
													
													<tr>
														
														
														<td width="50%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>

												</tbody>
											</table>


											


										</form:form>
									</c:if>



									<c:if test="${submitType == 'update'}">

										<c:if test="${not empty success}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: green; font-weight: bold;">
														<c:out value="${success}"></c:out>
													</div>
											</tr>
										</c:if>
										
										<c:if test="${not empty errormsg}">
											<tr>
												<td colspan="2" class="msgError" align="center">

													<div class="msgSuccess"
														style="color: green; font-weight: bold;">
														<c:out value="${errormsg}"></c:out>
													</div>
											</tr>
										</c:if>
										
										
										
										<form:form role="form" action="goToUpdateCompletion"
											method="post" modelAttribute="model">
											<h2 class="pull-left">
												<strong>Completion Data</strong>
											</h2>

											<table class="table table-responsive" id="tblEquipment">
												<tbody>

													<tr>
														<td width="50%" style="text-align: left">Tower ID</td>
														<td width="70%" style="text-align: left"><form:input
																path="txtMntObj.id.towerid" type="text"
																class="form-control" id="txtTowerId"
																placeholder="Enter Tower Number" /> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
														<td></td>

														<td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value="Search"
																		class="btn btn-success" />
																</div>
															</div>
														</td>

													</tr>
													
													<tr>
														
														
														<td width="50%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>

												</tbody>
											</table>


											


										</form:form>
										

									</c:if>
									<!-- <div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayLine'">Edit</button>
											</div>
										</div> -->


								</div>
							</div>
						</div>

					</div>



				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
</body>
</html>
