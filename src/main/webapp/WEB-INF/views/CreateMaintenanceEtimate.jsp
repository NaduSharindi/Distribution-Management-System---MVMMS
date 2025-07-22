<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">

	function getTowerNo(towerId)
	{
		alert("towerId" + towerId);	
			 $.ajax
             ({
                     type: 'GET',
                     url: "/MMS/findSupoortById/" + towerId,
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) {
                    	 alert("response.towerNo" + response.towerNo);	
                         return response.towerNo;
                     }
                     

                    
              });
		
	}

	
	function showTM(area,line)
			{
		       	 // alert ("area"+area + "line"+ line);
		       	  if (area === "" && line === "") {
			       	  alert("empty");
		       	    //...
		       	  }
					 $.ajax
		             ({
		                     type: 'GET',
		                     url: "/MMS/findTowerMntByAreaLine/"+ area + "/" + line,
		                     data: {},
		                     contentType: "application/json; charset=utf-8",
		                     success: function(response) 
		                     {

                                 $("#tblAreas > tbody:last").children().remove();
                                 //Insert item from the response
		                         for (var i = 0; i < response.length; i++) {
		                             var item = response[i];
		                             tr = $('<tr/>');
		                                tr.append("<td>" + item.id.visitId + "</td>"); 
		                                tr.append("<td>" + item.id.towerId + "</td>");
		                                tr.append("<td>" + item.towerNo+ "</td>");
		                                tr.append("<td>" + item.area+ "</td>");
		                                tr.append("<td>" + item.line+ "</td>");
		                                tr.append("<td>" + item.lineName+ "</td>");
			                            tr.append("<td>" + item.deptId + "</td>");
		                                tr.append("<td>" + item.tappings + "</td>");
		                                tr.append("<td>" + item.missingParts + "</td>");
		                                tr.append("<td>" + item.flashOverSets + "</td>");
		                                tr.append("<td>" + item.wayLeaving + "</td>");
		                                tr.append("<td>" + item.baseConcrete + "</td>");
		                                tr.append("<td>" + item.antiClimbing + "</td>");
		                                tr.append("<td>" + item.conductorCondition + "</td>");
		                                tr.append("<td>" + item.jumperCondition + "</td>");
		                                tr.append("<td>" + item.earthConductorCondition + "</td>");
		                                tr.append("<td>" + item.maintainaceAttention + "</td>");
		                                tr.append("<td>" + item.fungussSetno + "</td>");
		                                tr.append("<td>" + item.wpinset + "</td>");
		                                tr.append("<td>" + item.endfittingSet + "</td>");
		                                tr.append("<td>" + item.specialObservations + "</td>");
		                                tr.append("<td>" + item.lutd + "</td>");
		                                tr.append("<td>" + item.maintenanceDate + "</td>");
		                               
		                                if(item.status==0){
		                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
		                                } else if(item.status==1){ 
		                                    tr.append("<td><span class='label label-success'>Active</span></td>"); 
		                                }
		                                else if(item.status==2){ 
		                                    tr.append("<td><span class='label label-default'>In bulk</span></td>"); 
		                                }
		                                else if(item.status==3){ 
		                                    tr.append("<td><span class='label label-danger'>Rejected</span></td>"); 
		                                }
		                                else if(item.status==4){ 
		                                    tr.append("<td><span class='label label-info'>Inactive</span></td>"); 
		                                }
		                                
		                                tr.append("<td>" + item.approvalLevel + "</td>");
		                                //console.log(item);

		                                //Show "Edit" and "Delete" buttons
		                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");

		                                $('#tblAreas').append(tr);
		                         }

		                     }
		              });
				
			}

	function selectTMByArea(){
		
		var conceptName = $('#cmbSelectArea').find(":selected").text();
		var conceptNameValue = $('#cmbSelectArea').find(":selected").attr("value");

		var conceptLine = $('#cmbSelectLine').find(":selected").text();
		var conceptLineValue = $('#cmbSelectLine').find(":selected").attr("value");
		//alert(conceptNameValue + "/" + conceptLineValue);
		showTM(conceptNameValue,conceptLineValue);
		


		

		}
	


	function getAreas()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllAreas/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 //alert(response);
                    	 $('#cmbSelectArea').empty();
                         //Append "None" item
                         $('#cmbSelectArea').append($('<option>').text("<< Select Area >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectArea').append($('<option>').text(item.area).attr('value', item.id));
                         }
                     }
              });		
	}

	function getLine()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllLine/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                         //alert(response);
                    	 $('#cmbSelectLine').empty();
                         //Append "None" item
                         $('#cmbSelectLine').append($('<option>').text("<< Select Line >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectLine').append($('<option>').text(item.lineName).attr('value', item.id));
                         }
                     }
              });		
	}

	function showTM()
	{
		alert ("hiiiiii");
		var area = $('#cmbSelectArea').find(":selected").attr("value");
      	 $.ajax
             ({
                     type: 'GET',
                     url: "/MMS/findTowerMnByArea/"+ area,
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {

                    	 $("#tblTM > tbody:last").children().remove();
                    	 tr = $('<tr/>');
                         tr.append("<td style="text-align:right">" + "No of Tower : " + response.length+ "</td>"); 
                         
                         $('#tblTM').append(tr);
                         tr = $('<tr/>');
                         tr.append("<td>" + "No of Days for the inspection : " + roundUp(response.length/27,2)+ "</td>"); 
                         $('#tblTM').append(tr);

                         $('#tblTM').append(tr);
                         tr = $('<tr/>');
                         tr.append("<td>" + "Labour cost for the estimate  : " + roundUp( 9 * (response.length/27) *9 * 348 , 2) + "</td>"); 
                         $('#tblTM').append(tr);

                         tr = $('<tr/>');
                         tr.append("<td>" + "Subsistance for the estimate  : " + roundUp( (9 * ((response.length/27) *9 * 348)*400)/9 , 2) + "</td>"); 
                         $('#tblTM').append(tr);

                         tr = $('<tr/>');
                         tr.append("<td>" + "Hot line allownces  : " + roundUp( (response.length/27) *18000 , 2) + "</td>"); 
                         $('#tblTM').append(tr);
                         $("#tblAreas > tbody:last").children().remove();
                         //Insert item from the response
                         var tapping =0;
                         var mising_part =0;
                         var flash_over_set=0;
                         var fungus_set_no=0;
                         var wpin_set = 0;
                         var endfitting_set = 0;
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             tr = $('<tr/>');
                                tr.append("<td>" + item.id.visitId + "</td>"); 
                                tr.append("<td>" + item.id.towerId + "</td>");
                                tr.append("<td>" + item.towerNo+ "</td>");
                                tr.append("<td>" + item.area+ "</td>");
                                tr.append("<td>" + item.line+ "</td>");
                                tr.append("<td>" + item.lineName+ "</td>");
	                            tr.append("<td>" + item.deptId + "</td>");
                                tr.append("<td>" + item.tappings + "</td>");
                                tapping = tapping + item.tappings; 
                                tr.append("<td>" + item.missingParts + "</td>");
                                mising_part = mising_part + item.missingParts;
                                tr.append("<td>" + item.flashOverSets + "</td>");
                                flash_over_set = flash_over_set + item.flashOverSets;
                                tr.append("<td>" + item.wayLeaving + "</td>");
                                tr.append("<td>" + item.baseConcrete + "</td>");
                                tr.append("<td>" + item.antiClimbing + "</td>");
                                tr.append("<td>" + item.conductorCondition + "</td>");
                                tr.append("<td>" + item.jumperCondition + "</td>");
                                tr.append("<td>" + item.earthConductorCondition + "</td>");
                                tr.append("<td>" + item.maintainaceAttention + "</td>");
                                tr.append("<td>" + item.fungussSetno + "</td>");
                                fungus_set_no =fungus_set_no + item.fungussSetno;
                                tr.append("<td>" + item.wpinset + "</td>");
                                wpin_set = wpin_set + item.wpinset;
                                tr.append("<td>" + item.endfittingSet + "</td>");
                                endfitting_set = endfitting_set  + parseFloat(item.endfittingSet);
                                tr.append("<td>" + item.specialObservations + "</td>");
                                tr.append("<td>" + item.lutd + "</td>");
                                tr.append("<td>" + item.maintenanceDate + "</td>");
                               
                                if(item.status==0){
                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
                                } else if(item.status==1){ 
                                    tr.append("<td><span class='label label-success'>Active</span></td>"); 
                                }
                                else if(item.status==2){ 
                                    tr.append("<td><span class='label label-default'>In bulk</span></td>"); 
                                }
                                else if(item.status==3){ 
                                    tr.append("<td><span class='label label-danger'>Rejected</span></td>"); 
                                }
                                else if(item.status==4){ 
                                    tr.append("<td><span class='label label-info'>Inactive</span></td>"); 
                                }
                                
                                tr.append("<td>" + item.approvalLevel + "</td>");
                                //console.log(item);

                                //Show "Edit" and "Delete" buttons
                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");

                                $('#tblAreas').append(tr);
                         }
                         //alert (tapping);
                         //tr = $('<tr/>');
                         //tr.append("<td>" + "Tapping : " + roundUp( tapping , 2) + "</td>"); 
                         //$('#tblTM').append(tr);
                         //tr = $('<tr/>');
                         //tr.append("<td>" + "Missing Part : " + roundUp( mising_part , 2) + "</td>"); 
                         //$('#tblTM').append(tr);
                         //tr = $('<tr/>');
                         //tr.append("<td>" + "Flash Over Set : " + roundUp( flash_over_set , 2) + "</td>"); 
                         //$('#tblTM').append(tr);
                         //tr = $('<tr/>');
                         //tr.append("<td>" + "Fungus Set No : " + roundUp( fungus_set_no , 2) + "</td>"); 
                         //$('#tblTM').append(tr);
                         //tr = $('<tr/>');
                         //tr.append("<td>" + "Wpin Set No : " + roundUp( wpin_set , 2) + "</td>"); 
                         //$('#tblTM').append(tr);
                         //tr = $('<tr/>');
                         //tr.append("<td>" + "Endfitting Set: " + roundUp( endfitting_set , 2) + "</td>"); 
                         //$('#tblTM').append(tr);
                         

                     }
              });
		
	}

	function roundUp(num, precision) {
		  precision = Math.pow(10, precision)
		  return Math.ceil(num * precision) / precision
	}
	
	
	 
	 
	</script>

</head>
<body onload="getAreas();getLine();">
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
                                <li class="active"><span>Support</span></li>
                            </ol>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
					
					<div class="form-group">
											<label>Area :
											<select class="form-control" id="cmbSelectArea" name="cmbSelectArea"  onchange="showTM()">
										
											</select>
											<span id="spnSelectArea" class="label label-danger"></span></label>
										</div>
										
										<div class="form-group">
											<label>Line :
											<select class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="">
										
											</select>
											<span id="spnSelectLine" class="label label-danger"></span></label>
										</div>
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">Inspection Estimate for the Area</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
											<table class="table table-responsive" id="tblTM">
											</table>
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
														<tr>                                                             
															<th class="text-center">Visit ID</th>                                                            
															<th class="text-center">Tower ID</th>
															<th class="text-center">Tower No</th>
															<th class="text-center">Area</th>
															<th class="text-center">Line</th>
															<th class="text-center">Line Name</th>
															<th class="text-center">Dept ID</th>
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
													</thead>
													<tbody>
														
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