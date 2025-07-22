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
                                <li class="active"><span>Tower Maintenance</span></li>
                            </ol>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
					
					
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">EDIT Tower Maintenance </h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
													
													</thead>
													<tbody>
																<form:form  method="post" action="viewSupportByProvince" modelAttribute="model">
																 <table class="table table-responsive" id="tblProvinces">
			
			
													     	<tr>
																<td width="30%" style="text-align:left">
                												<form:label path="">Province</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select  id="province" path ="glcompmobj.compId" onchange="findArea()">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">Area</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
																
																<form:select  id="area" path ="gldeptobj.deptId" onchange="getLine()">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.areaList}"/>
																</form:select>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">Line</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select  id="line" path ="line.code" onchange="">
                												
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.lineList}"/>
																</form:select>
																
																 </td>   
        														</tr>	
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">Cycle</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select  id="line" path ="line.code" onchange="">
                												
																<form:option value="201801" label="201801" />
																<form:option value="201802" label="201802" />
																<form:option value="201901" label="201901" />
																<form:option value="201902" label="201902" />
																	</form:select>
																
																 </td>   
        														</tr>									
        															<tr>
                                                            <th class="text-center">Tower No</th>
															<th class="text-center">Tappings</th>
															<th class="text-center">Missing Parts</th>
															<th class="text-center">Flash Over Sets</th>
															<th class="text-center">Way leaving Status</th>
															<th class="text-center">Base Concrete Status</th>
															<th class="text-center">Anti Climbing Status</th>
															<th class="text-center">Conductor Condition</th>
															<th class="text-center">Jumper Condition</th>
															<th class="text-center">Earth Conductor Condition</th>
															<th class="text-center">Maintenance Attention</th>
															<th class="text-center">Funguss Set No</th>
															<th class="text-center">WPIN set</th>
															<th class="text-center">End Fitting set</th>
															<th class="text-center">Special Observations</th>
															<th class="text-center">LUTD</th>
															<th class="text-center">Maintenance Date</th>
															<th class="text-center">Status</th>
															<th class="text-center">Approval Level</th>
															
															
														</tr>
        														<c:forEach var="Support" items="${model.txtMntObj}" >
        														<td></td>
        														
        														
											                <tr> </tr>
											                
											            </c:forEach>
        														 </table>
        														</form:form>
        														
        														</tbody>
												</table>
											</div>
											
											<header class="main-box-header clearfix">
												<button type="button" class="btn btn-info" onclick="window.location.href='#'">Approve Items</button>
											</header>
										
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