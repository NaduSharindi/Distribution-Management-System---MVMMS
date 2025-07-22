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
				                                <li class="active"><span>Area</span></li>
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">CEB Area</h2>
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	<tr>
			                                                                                                                         
																		<th class="text-center"></th>
																		<th class="text-center" data-orderable="false"></th>
																		
																	</tr>
																</thead>
																<tbody>
																
																<c:forEach var="province" items="${province}" >
                												<tr>
                													<td  style="text-align:left"   ><a href="<c:url value='/viewProvinceNew/${province.compId}' />" >${province.compNm}</a></td>
        														</tr>
            													</c:forEach> 
																	
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