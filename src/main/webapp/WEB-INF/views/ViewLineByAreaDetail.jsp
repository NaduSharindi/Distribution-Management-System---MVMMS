<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<%@ include file="sections/head.jsp" %>
		
			<script type="text/javascript">

			

				function ConfirmActivate(comid){
					
						alert("hiiii");
						$.ajax
				        ({
				        	
				                type: 'GET',
				                url: "/MMS/viewProvinceNew/"+ comid,
				                data: {},
				                contentType: "application/json; charset=utf-8",
				                success: function(response) 
				                {
				                    alert(response);
				               	 
				                }
				         });
						
					
				}
				 
				 function showProvinces()
					{
							
							 $.ajax
				             ({
				                     type: 'GET',
				                     url: '/MMS/findAllProvinces/',
				                     data: {},
				                     contentType: "application/json; charset=utf-8",
				                     success: function(response) 
				                     {
				                    	 $("#tblProvinces > tbody:last").children().remove();
		
				                    	 //Insert item from the response
				                         for (var i = 0; i < response.length; i++) {
				                             var item = response[i];
											 var comid = item.compId;
				                             
				                             tr = $('<tr/>');
											 tr.append("<td> " + item.compNm + "</td>");
											 tr.append("<td>" + "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"+comid+"')>Go</button>" + "</td>");
											 
				                                
				                                $('#tblProvinces').append(tr);
				                         }
				                         
				                         $('#tblProvinces').dataTable({
				                                'info': false,
				                                'pageLength': 10,
				                                retrieve: true
				                            });
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
				                        <div class="col-lg-9">
				                            <ol class="breadcrumb">
				                                <li><a href="#">Home</a></li>
				                                <li class="active"><span>${dd}</span></li>
				                                <li class="active"><span>${province}</span></li>
				                                <li class="active"><span>${area}</span></li>
				                                <li class="active"><span>TOWER LINE DETAILS</span></li>
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">Tower Line Details</h2>
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	<tr>
			                                                                                                                         
																		<th class="text-center" data-orderable="false">Code</th>
																		<th class="text-center" data-orderable="false">Line Name</th>
																		<th class="text-center" data-orderable="false">Line Type</th>
																		<th class="text-center" data-orderable="false">Length(Km)</th>
																		<th class="text-center" data-orderable="false">No of Towers</th>
																		<th class="text-center" data-orderable="false">No of Poles</th>
																		<th class="text-center" data-orderable="false">Commission Date</th>
																		
																	</tr>
																</thead>
																<tbody>
																		<c:set var="totalLineLength" value="0"/>
																		<c:set var="totalTower" value="0"/>
																		<c:set var="totalPoles" value="0"/>
																		
															<c:forEach var="line" items="${line}" >
															<c:set var="totalLineLength" value="${totalLineLength + line.length}" />
															<c:set var="totalTower" value="${totalTower + line.nooftowers}" />
                											<c:set var="totalPoles" value="${totalPoles + line.noofpoles}" />
                											
                												<tr>
                
                												<td style="text-align:left">${line.code}</td>
                												<td style="text-align:left">${line.lineName}</td>
                												<td><c:if test="${line.lineType==1}">
																Backbone
																</c:if>
																<c:if test="${line.lineType==2}">
																Distributor
																</c:if>
																
																</td>
                												
                												
                												<td>${line.length}</td>
                												<td>${line.nooftowers}</td>
                												<td>${line.noofpoles}</td>
                												<td>${line.comdate}</td>
        
                
                 												</tr>
                 												
            													</c:forEach>
																	<tr>
																	<td></td>
                												<td></td>
                												<td>TOTAL</td>
                 												<td>${totalLineLength}</td>
                 												<td>${totalTower}</td>
                 												<td>${totalPoles}</td>
                												<td></td>
                												
                 												</tr>
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