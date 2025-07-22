<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">
	
	
	function unchangeFeederIdentification(){
		$('#otherFeederIdentification').val("");
		document.getElementById("otherFeederIdentification").style.visibility='hidden';
		document.getElementById("btn7").style.visibility='hidden';
		document.getElementById("cmbFeederIdentification").disabled=false;
		document.getElementById("cmbFeederIdentification").selectedIndex = 0;
	}
	
	function changeFeederIdentification()
	{	
		
		 if (document.getElementById("cmbFeederIdentification").value == "") 			 
		 {				 
			$('#otherFeederIdentification').val("");
			document.getElementById("otherFeederIdentification").style.visibility='visible';
			document.getElementById("cmbFeederIdentification").disabled=true;
		    document.getElementById("btn7").style.visibility='visible';			        
	 	 } 
		 
		 else {
	        document.getElementById("cmbFeederIdentification").disable=false;
		 }
	}
	
	
	
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
	                         /* $('#cmbSelectArea').append($('<option>').text("<< Select Area >>").attr('value', ""));
	 */
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
	                         /* $('#cmbSelectLineType').append($('<option>').text("<< Select Line Type >>").attr('value', ""));
	 */
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectLineType').append($('<option>').text(item.lineType).attr('value', item.id));
	                         }
	                     }
	              });		
		}
		
		
		function getConductorTypes()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveConductorTypes/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectConductorType').empty();
	                         //Append "None" item
	                         /* $('#cmbSelectConductorType').append($('<option>').text("<< Select Conductor Type >>").attr('value', ""));
	 */
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectConductorType').append($('<option>').text(item.type).attr('value', item.id));
	                         }
	                     }
	              });		
		}
	
		
	</script>
</head>
<body onload="getAreas();getLineTypes();getConductorTypes();">
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
                                <li class="active"><span>Interruption Request</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
									<form:form role="form" action="addInteruption" method="post" modelAttribute="interuption">
										
										
										<%-- <c:if test="${not empty interuption.name}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${interuption.name}"></c:out>
									</div>
								
						</tr>
					</c:if>
							 --%>	
								
								
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
																<tr>
                												<td width="30%" style="text-align:left">
                												Interruption Request Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="approvalId" type="text" class="form-control" id="txtCode" />
																<span id="spnCode" class="label label-danger"></span>
																
																</td>
																</tr>												
									
																<tr>
                												<td width="30%" style="text-align:left">
                												Permit Number</td>
                												<td width="70%" style="text-align:left">
																<form:input path="permitNo" type="text" value="" class="form-control" id="txtDeptId" placeholder="Enter Dept id" disabled="true"/>					
																</td>
																</tr>	
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Reschedule Date
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="lineName" type="text" class="form-control" id="txtName" placeholder="Enter Name"/>
																<span id="spnName" class="label label-danger"></span>
																</td>
																</tr>	
																
                              									<tr>
                												<td width="30%" style="text-align:left">
                												Alternative Supply Arrangement
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="lineType" class="form-control" id="cmbSelectLineType" name="cmbSelectLineType">
																</form:select>
																<span id="spnSelectLineType" class="label label-danger"></span>
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="length" type="number" step="any" value ="0" class="form-control" id="txtLength" placeholder="Enter Length"/>
																<span id="spnLengths" class="label label-danger"></span>
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Generated Date & Time</td>
                												<td width="70%" style="text-align:left">
                												<form:select path="area" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Forwarded Date & Time
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="noofpoles" type="number" value ="0" class="form-control" id="txtPoles" placeholder="Enter Poles"/>
																<span id="spnPoles" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Section to be interrupted</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="nooftowers" type="number" value ="0" class="form-control" id="txtNoOfTowers" placeholder="Enter Towers"/>
																<span id="spnNoOfTowers" class="label label-danger"></span>
																</td>
                												   
        														</tr>
																
																
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Time Duration</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="comdate" type="date" class="form-control" id="txtComDate" placeholder="Enter ComDate"/>
																<span id="spnComDate" class="label label-danger"></span></td>
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Requested EE/ES
                												</td>
                												<td width="70%" style="text-align:left">
                												<label class="radio-inline">
																<form:radiobutton path="circuitType" value="2" id="radioNoOfCircuits" checked="checked"/>Double
																</label>
																<label class="radio-inline">
																<form:radiobutton path="circuitType" value="1" id="radioNoOfCircuits"/>Single
																</label>
																<label class="radio-inline">
																<form:radiobutton path="circuitType" value="3" id="radioNoOfCircuits"/>Both
																</label>
																</td>    
        														</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Field Work
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="conductorType" class="form-control" id="cmbSelectConductorType" name="cmbSelectConductorType">
										
																</form:select>
																<span id="spnSelectConductorType" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														<tr>
                												<td width="40%" style="text-align:left">
                												Forwarded To
                												</td>
                												<td width="60%" style="text-align:left">
																<form:select path="feederIdentification"  class="form-control" name="cmbFeederIdentification" id="cmbFederIdentification" onchange="changeFeederIdentification()">
													<form:option value="None" selected="selected">None </form:option>
													<form:option value="F01">F01</form:option>
													<form:option value="F02">F02</form:option>
													<form:option value="F03">F03</form:option>
													<form:option value="F04">F04</form:option>
													<form:option value="F04">F04</form:option>
													
													<form:option value="F05">F05</form:option>
													
													<form:option value="F06">F06</form:option>
													
													<form:option value="F07">F07</form:option>
													
													<form:option value="F08">F08</form:option>
													
													<form:option value="F09">F09</form:option>
													<form:option value="F10">F10</form:option>
													
													
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spnFeederIdentification" class="label label-danger"></span>
											<button type="button" id="btn7" class="mybtn" onclick="unchangeFeederIdentification()" style="visibility:hidden;">X</button>
											<form:input path="feederIdentification" type="text" id="otherFeederIdentification" name="otherFeederIdentification" class="form-control" style="visibility:hidden;"/>
											
																</td>
																	    
        														</tr>
        														</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayLine'">Edit</button>
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