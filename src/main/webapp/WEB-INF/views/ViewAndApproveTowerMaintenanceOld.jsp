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
	
	function enable(id){
		alert(id);
		document.getElementById("nooftappings"+id).disabled = false;
		/* document.getElementById("noofmissingparts"+id).disabled = false; */
	}
	function save(id) 
    {
       alert('hiiiii');
	   var nooftappings = document.getElementById("nooftappings"+id).value;
	   alert('hiiiii'+nooftappings);
	 /*   var nooftappings = document.getElementById("noofmissingparts"+id).value;
	   alert('hiiiii'+noofmissingparts); */
	   disable(id);
	   
    }
	
	function disable(id){
		alert(id);
		document.getElementById("nooftappings"+id).disabled = true;
		/* document.getElementById("noofmissingparts"+id).disabled = true; */
	}
	
	
	function showTM(area,line,cycle)
			{
		       	 // alert ("area"+area + "line"+ line);
		       	  if (area === "" && line === "") {
			       	  alert("empty");
		       	    //...
		       	  }
					 $.ajax
		             ({
		                     type: 'GET',
		                     url: "/MMS/findTmByAreaLineCycle/"+ area + "/" + line + "/"+ cycle,
		                     data: {},
		                     contentType: "application/json; charset=utf-8",
		                     success: function(response) 
		                     {
								alert(response);
                                 $("#tblAreas > tbody:last").children().remove();
                                 //Insert item from the response
                                 var count = 0;
                                 countResponseData = response.length;
		                         for (var i = 0; i < response.length; i++) {
		                             var item = response[i];
		                             count = count + 1;
		                             //alert(item);
		                             tr = $('<tr/>');
		                                tr.append("<td>" + item[1] + "</td>");
		                                tr.append("<td> <input type=text id=nooftappings"+item[0].id.towerid+"  value="+item[0].nooftappings+" disabled ></input></td>");
		                              /*   tr.append("<td> <input type=text id=noofmissingparts"+item[0].id.towerid+"  value="+item[0].noofmissingparts+" disabled ></input></td>"); */
		                                tr.append("<td>" + item[0].noofmissingparts + "</td>");
		                                tr.append("<td>" + item[0].nofflashoversets + "</td>");
		                                tr.append("<td>" + item[0].wayleavestatus + "</td>");
		                                tr.append("<td>" + item[0].baseconcretestatus + "</td>");
		                                tr.append("<td>" + item[0].anticlimbingstatus + "</td>");
		                                tr.append("<td>" + item[0].conductorstatus + "</td>");
		                                tr.append("<td>" + item[0].jumperstatus + "</td>");
		                                tr.append("<td>" + item[0].earthconductorstatus + "</td>");
		                                tr.append("<td>" + item[0].attentionstatus + "</td>");
		                                tr.append("<td>" + item[0].fungussetno + "</td>");
		                                tr.append("<td>" + item[0].wpinset + "</td>");
		                                tr.append("<td>" + item[0].endfittingset + "</td>");
		                                tr.append("<td>" + item[0].towerspecial + "</td>");
		                                tr.append("<td>" + item[0].ludt + "</td>");
		                                tr.append("<td>" + item[0].maintenancedate + "</td>");
		                                
		                                if(item[0].status==0){
		                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
		                                } else if(item[0].status==1){ 
		                                    tr.append("<td><span class='label label-success'>Active</span></td>"); 
		                                }
		                                else if(item[0].status==2){ 
		                                    tr.append("<td><span class='label label-default'>In bulk</span></td>"); 
		                                }
		                                else if(item[0].status==3){ 
		                                    tr.append("<td><span class='label label-danger'>Rejected</span></td>"); 
		                                }
		                                else if(item[0].status==4){ 
		                                    tr.append("<td><span class='label label-info'>Inactive</span></td>"); 
		                                }
		                                
		                                tr.append("<td>" + item[0].approvalLevel + "</td>");
		                                
		                                tr.append("<td><button type='button' class='btn btn-warning' onClick='enable("+item[0].id.towerid+")'>Edit</button>&nbsp;<button type='button' class='btn btn-success' onClick='save("+item[0].id.towerid+")'>Save</button></td>");
		                                
		                                
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
		
		var conceptCycle = $('#cmbSelectCycle').find(":selected").text();
		var conceptCycleValue = $('#cmbSelectCycle').find(":selected").attr("value");
		alert(conceptCycleValue + "/" + conceptCycleValue);
		showTM(conceptNameValue,conceptLineValue,conceptCycleValue);
		


		

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

	function showLineByArea(){
		var area = $('#cmbSelectArea').find(":selected").attr("value");
		alert(area);
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
											<select class="form-control" id="cmbSelectArea" name="cmbSelectArea"  onchange="showLineByArea()">
										
											</select>
											<span id="spnSelectArea" class="label label-danger"></span></label>
										</div>
										
										<div class="form-group">
											<label>Line :
											<select class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="selectTMByArea()">
										
											</select>
											<span id="spnSelectLine" class="label label-danger"></span></label>
										</div>
										<div class="form-group">
											<label>Cycle :
											<select class="form-control" id="cmbSelectCycle" name="cmbSelectCycle"  onchange="selectTMByArea()">
										
													<option value="" selected="selected"> << SELECT >> </option>
													<option value="201801"> 201801 </option>
													<option value="201802"> 201802 </option>
													<option value="201901"> 201901 </option>
													<option value="201902"> 201902 </option>
													<option value="202001"> 202001 </option>
													<option value="202002"> 202002 </option>
												
							
												
											</select>
											<span id="spnSelectCycle" class="label label-danger"></span></label>
										</div>
										
										
										
										
										
										
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">Tower Maintenance List with Status</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
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
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
											
											<header class="main-box-header clearfix">
												<button type="button" class="btn btn-info" onclick="enable()">Edit</button>
												<button type="button" class="btn btn-info" onclick="">Approve Items</button>
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