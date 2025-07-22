<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">




table, th, td {
    border: 0px solid black;
    align:left;
    text-align:left;
}

</style>
<html>
	<head>
		<%@ include file="sections/head.jsp" %>
		
			<script type="text/javascript">

			

				function ConfirmActivate(comid){
					
					//	alert("hiiii");
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
			                    	 var slctSubcat=$('#line'), option="<option value='-1'>ALL</option>";
			                         slctSubcat.empty();
			                         for(var i=0; i<data.length; i++){
			                             option = option + "<option value='"+data[i].id + "'>"+data[i].lineName + "</option>";
			                         }
			                         slctSubcat.append(option);

			                    	 //alert("response.towerNo" + data);	
			                     }
			              });	

						
					}
					
					function viewPEReport(){
						//
						var strArea = area.options[area.selectedIndex].value;
						//var strLine = line.options[line.selectedIndex].value;
						var strProvince = province.options[province.selectedIndex].value;
						//var lineType = lineType.options[lineType.selectedIndex].value;
						/* var conType = conType.options[conType.selectedIndex].value;
						var cirType = cirType.options[cirType.selectedIndex].value;
						 */
						
						
						var url="PESummaryNew?province="+ strProvince +"&area=" + strArea ;
				 	    var width = 1100;
				 	    var height = 700;
				 	    var left = parseInt((screen.availWidth/2) - (width/2));
				 	    var top = parseInt((screen.availHeight/2) - (height/2));
				 	    var windowFeatures = "width=" + width + ",height=" + height + 
				 	    ",status,resizable,left=" + left + ",top=" + top +
				 	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
				 	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
				 	    
						

					}

					
				 
				 
			</script>
	</head>
	<body>
		<div id="theme-wrapper">
		
			<%@ include file="sections/header.jsp" %>
			
				<div id="page-wrapper" class="container"> 
					<div class="row">
					
						<%@ include file="sections/userLevelsOther.jsp" %>
						
							<div id="content-wrapper">
							
							<div class="row">
								<div class="col-lg-12">		                                    
				                        <div class="col-lg-9">
				                            <ol class="breadcrumb">
				                                <li><a href="#">Home</a></li>
				                                <c:if test="${model.mode =='PELT'}">
				                                 <li class="active"><span>Line Type</span></li>
												</c:if>
				                               <c:if test="${model.mode =='PECONT'}">
				                                 <li class="active"><span>Conductor Type</span></li>
												</c:if>
				                               <c:if test="${model.mode =='PECIRT'}">
				                                 <li class="active"><span>Circuit Type</span></li>
												</c:if>
				                               <c:if test="${model.mode =='PECIRCONT'}">
				                                 <li class="active"><span>Circuit/Conductor Type</span></li>
												</c:if>
				                               
				                            </ol>
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
						
								<div class="row">
											<div class="col-lg-12">
												<div class="main-box clearfix">
													<!-- <header class="main-box-header clearfix">
													
														<h2 class="pull-left">Tower Lines   </h2>
													</header>
													 -->
													<div class="main-box-body clearfix">
														<div class="table-responsive">
			                                              <table class="table table-responsive" id="tblProvinces">
			 <table class="table table-striped table-bordered table-sm " id="tblAdmin">
			
			                                                    <thead>
																	
																</thead>
																<tbody>
																<form:form  method="post" action="PESummary" modelAttribute="model">
																 <table class="table table-responsive" id="tblProvinces">
			<form:hidden path="mode" />
														<c:set var="myVar" value="${model.mode}" />
			
																<tr>
																<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select  id="province" path ="glcompmobj.compId" onchange="findArea()" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td>
																    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																
																<form:select  id="area" path ="gldeptobj.deptId" onchange="getLine()"  style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.areaList}"/>
																</form:select>
																</td>
																    
        														</tr>
        													<%-- 	<tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:select  id="line" path ="line.id" onchange=""  style="width:50%; background-color: #FFFFF; border-radius: 5px;">
                												
																<form:option value="-1" label="ALL" />
																 <form:options items="${model.lineList}"/>
																</form:select>
																
																 </td>   
        														</tr>
        														<c:if test="${myVar =='PELT'}">
																	
        														<tr>
                												<td width="30%" style="text-align:left">
                												Line Type
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="lineType.id" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.lineTypeList}"/>
																</form:select>
																
																     </td>  
        														</tr>
        														</c:if>
        														<c:if test="${myVar=='PECIRCONT'}">
        														<tr>
                												<td width="30%" style="text-align:left">
                												Conductor Type
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="mmsConTypePE.id" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.conTypeListforPE}"/>
																</form:select>
																</td> 
																    
        														</tr>
        													
        														<tr>
                												<td width="30%" style="text-align:left">
                												Circuite Type
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="circuteType" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="ALL" />
																 <form:option value="1" label="Single" />
																 <form:option value="2" label="Double" />
																 
																</form:select>
																
																    </td> 
        														</tr>
        														
        														
        														
        														
        														</c:if>
        														<c:if test="${myVar=='PECONT'}">
        													<tr>
                												<td width="30%" style="text-align:left">
                												Conductor Type
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="mmsConTypePE.id" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.conTypeListforPE}"/>
																</form:select>
																</td> 
																    
        														</tr>
        														
        														</c:if>
        														<c:if test="${myVar=='PECIRT'}">
        														<tr>
                												<td width="30%" style="text-align:left">
                												Circuite Type
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="circuteType" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																<form:option value="NONE" label="ALL" />
																 <form:option value="1" label="Single" />
																 <form:option value="2" label="Double" />
																 
																</form:select>
																
																    </td> 
        														</tr>
        														</c:if> --%>
        														<!-- <tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">SUPPORT TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.supTypeList}"/>
																</form:select>
																
																   </td>  
        														</tr>
        														
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												
                												<form:label path="">TOWER CONFIGURATION</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																  </td>   
        														</tr>-->
        														
        														<tr>
        														<td  style="text-align:left"   >
        														<input class="btn btn-success" type="button" name="actionButton"	onclick="viewPEReport()" value="View"></input>
        														<input class="btn btn-success" type="button" name="actionButton"	value="Exit"></input>
        														
        														</td>
        														</tr>
        														 </table>
        														</form:form>
        														
        														</tbody>
        														</table>
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