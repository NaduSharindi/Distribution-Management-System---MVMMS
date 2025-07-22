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
				                                <li class="active"><span>TOWER LINE SUMMARY</span></li>
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<header class="main-box-header clearfix">
														<h2 class="pull-left">Tower Line Summary</h2>
													</header>
													
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			
			                                                    <thead>
																	<tr>
			                                                                                                                         
																		<th class="text-center" data-orderable="false">No</th>
																		<th class="text-center" data-orderable="false">Area</th>
																		<th class="text-center" data-orderable="false">No of Lines</th>
																		<th class="text-center" data-orderable="false">Line Length(Km)</th>
																		<th class="text-center" data-orderable="false">No of tower</th>
																		<th class="text-center" data-orderable="false">No of poles</th>
																		
																	</tr>
																</thead>
																<tbody>
																<c:set var="totalLine" value="0"/>
																<c:set var="totalLineLength" value="0"/>
																<c:set var="totalTower" value="0"/>
																<c:set var="totalPole" value="0"/>
																
																<c:set var="count" value="0" scope="page" />
																<c:forEach var="summary" items="${summary}" varStatus="status" >
																 <c:set var="totalLine" value="${totalLine + summary[2]}" />
																 <c:set var="totalLineLength" value="${totalLineLength + summary[3]}" />
                												<c:set var="totalTower" value="${totalTower + summary[4]}" />
                												<c:set var="totalPole" value="${totalPole + summary[5]}" />
                												
                												<tr>
                													<td  style="text-align:center"   >${status.count}</td>
        														<td  style="text-align:left"   ><a href="<c:url value='/viewLineDetailNew?id=${summary[0]}&dd=${dd}&province=${province}&area=${summary[1]}' />" >${summary[1]}</a></td>
        														<td  style="text-align:center"   >${summary[2]}</td>
        														<td  style="text-align:center"   >${summary[3]}</td>
        														<td  style="text-align:center"   >${summary[4]}</td>
        														<td  style="text-align:center"   >${summary[5]}</td>
        														</tr>
            													</c:forEach> 
            													<tr>
            													<td  style="text-align:center"   ></td>
            													<td  style="text-align:center"   >TOTAL</td>
            													<td  style="text-align:center"   >${totalLine}</td>
        														<td  style="text-align:center"   >${totalLineLength}</td>
        														<td  style="text-align:center"   >${totalTower}</td>
        														<td  style="text-align:center"   >${totalPole}</td>
        														
            													</tr>
																
																
																
																		<!-- 	<c:forEach var="dist" items="${dist}" >
                												<tr>
                
                												<td><a href="<c:url value='/viewProvinceNew/${dist.compId}' />" >${dist.compNm}</a></td>
        
               
                
                 												</tr>
            													</c:forEach> -->
																	
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