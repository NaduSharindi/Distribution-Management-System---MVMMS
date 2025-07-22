<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">

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
                    	 //alert(response);
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

	function showLineByArea(){
		var area = $('#cmbSelectArea').find(":selected").attr("value");
		$.ajax
        ({
                type: 'GET',
                url: '/MMS/findLineByArea/' +area +'/',
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
	
	function showSupport()
			{
                    //alert("hiiii");
					var area = $('#cmbSelectArea').find(":selected").attr("value");
					var lineId = $('#cmbSelectLine').find(":selected").attr("value");
					//alert("hiiii");
					 $.ajax
		             ({
		                     type: 'GET',
		                     url: "/MMS/findSupportByArea/" + area +"/" + lineId,
		                     data: {},
		                     contentType: "application/json; charset=utf-8",
		                     success: function(response) 
		                     {
		                    	// alert("hiiii");
		                    	 $("#tblAreas > tbody:last").children().remove();

		                    	 //Insert item from the response
		                         for (var i = 0; i < response.length; i++) {
		                             var item = response[i];


		                             //alert("ST" + item.supportType);
									 var suType;
		                             if( item.supportType == 1){
		                            	 suType = "Tower";			                             
			                         }else if( item.supportType == 2){
			                        	 suType = "Pole";
				                     }else if( item.supportType == 3){
				                    	 suType = "Both";
				                     }


		                             
									 var ctype;
		                             if(item.conductorType == "1"){
		                            	 ctype = "TLD";			                             
			                         }else if(item.conductorType == "2"){
			                        	 ctype = "Racoon";
				                     }else if(item.conductorType == "3"){
			                        	 ctype = "ELM";
				                     }else if(item.conductorType == "4"){
			                        	 ctype = "Tiger";
				                     }else if(item.conductorType == "5"){
			                        	 ctype = "Dog";
				                     }else if(item.conductorType == "6"){
			                        	 ctype = "Lynx";
				                     }else if(item.conductorType == "7"){
			                        	 ctype = "Copper";
				                     }

		                             var ectype;
		                             if(item.earthConductorType == "1"){
		                            	 ectype = "7/3.25";
			                         }else if(item.earthConductorType == "2"){
			                        	 ectype = "7/0.2";
				                     }else if(item.earthConductorType == "3"){
				                    	 ectype = "No 6";
				                     }else if(item.earthConductorType == "4"){
				                    	 ectype = "None";
				                     }else if(item.earthConductorType == "5"){
				                    	 ectype = "Copper";
				                     }

		                             var towerConf;
		                             if(item.towerConfiguration == "1"){
		                            	 towerConf = "Tension";
			                         }else if(item.towerConfiguration == "2"){
			                        	 towerConf = "Suspension";
				                     }else if(item.towerConfiguration == "3"){
				                    	 towerConf = "Pin";
				                     }

		                             var towerType;
		                             if(item.towerType == "1"){
		                            	 towerType = "TDL";
			                         }else if(item.towerType == "2"){
			                        	 towerType = "TDM";
				                     }else if(item.towerType == "3"){
				                    	 towerType = "TDH";
				                     }else if(item.towerType == "4"){
				                    	 towerType = "TDT";
				                     }else if(item.towerType == "5"){
				                    	 towerType = "MDL";
				                     }else if(item.towerType == "6"){
				                    	 towerType = "MDM";
				                     }else if(item.towerType == "7"){
				                    	 towerType = "MDH";
				                     }else if(item.towerType == "8"){
				                    	 towerType = "MDT";
				                     }else if(item.towerType == "9"){
				                    	 towerType = "TSL";
				                     }else if(item.towerType == "10"){
				                    	 towerType = "TSM";
				                     }else if(item.towerType == "11"){
				                    	 towerType = "TSH";
				                     }else if(item.towerType == "12"){
				                    	 towerType = "TST";
				                     }else if(item.towerType == "13"){
				                    	 towerType = "MSL";
				                     }else if(item.towerType == "14"){
				                    	 towerType = "MSM";
				                     }else if(item.towerType == "15"){
				                    	 towerType = "MSH";
				                     }else if(item.towerType == "16"){
				                    	 towerType = "MST";
				                     }else {
				                    	 towerType = "No Type";
				                     }
		                             

		                             
		                             tr = $('<tr/>');
		                             tr.append("<td>" + item.towerNo + "</td>");
		                             tr.append("<td>" + suType + "</td>"); 
		                                tr.append("<td>" + item.lineName + "</td>");
		                                 tr.append("<td>" + item.area + "</td>");
		                                tr.append("<td>" + item.csc + "</td>");
		                                tr.append("<td>" + ctype + "</td>");
		                                tr.append("<td>" + ectype + "</td>");
		                                tr.append("<td>" + towerType + "</td>");
		                                tr.append("<td>" + towerConf + "</td>");
		                                tr.append("<td>" + item.gpsLatitude + "</td>");
		                                tr.append("<td>" + item.gpsLongitude + "</td>");
		                                tr.append("<td>" + item.noOfCircuits + "</td>");
		                                tr.append("<td>" + item.bodyExtension + "</td>");
		                               
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
		                         
		                         $('#tblAreas').dataTable({
		                                'info': false,
		                                'pageLength': 10,
		                                retrieve: true
		                            });
		                     }
		              });
				
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
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">Support List with Status</h2>
										</header>
										
										
										
										<div class="form-group">
											<label>Area :
											<select class="form-control" id="cmbSelectArea" name="cmbSelectArea"  onchange="showLineByArea()">
										
											</select>
											<span id="spnSelectArea" class="label label-danger"></span></label>
										</div>
										
										<div class="form-group">
											<label>Line :
											<select class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="showSupport()">
										
											</select>
											<span id="spnSelectLine" class="label label-danger"></span></label>
										</div>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
														<tr>                                                             
															<th class="text-center">Tower No</th>
															<th class="text-center">Support Type</th>
															<th class="text-center">Line Name</th>
															<th class="text-center">Area</th>
															<th class="text-center">CSC</th>
															<th class="text-center">Conductor Type</th>
															<th class="text-center">Earth Con: Type</th>
															<th class="text-center">Tower Type</th>
															<th class="text-center">Tower Config:</th>
															<th class="text-center">GPS-Latitude</th>
															<th class="text-center">GPS-Longitude</th>
															<th class="text-center">Circuits</th>
															<th class="text-center">Body Extension</th>
															<th class="text-center">Status</th>
															<th class="text-center">Approval Level</th>
															
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
											
											<header class="main-box-header clearfix">
												<button type="button" class="btn btn-info" onclick="window.location.href='approveSupport'">Approve Items</button>
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