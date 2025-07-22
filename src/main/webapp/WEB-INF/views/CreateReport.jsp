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

	function downloadReport(){
		alert("hiiii");
		var conceptName = $('#cmbSelectArea').find(":selected").text();
		var conceptNameValue = $('#cmbSelectArea').find(":selected").attr("value");
        var conceptLine = $('#cmbSelectLine').find(":selected").text();
		var conceptLineValue = $('#cmbSelectLine').find(":selected").attr("value");
		alert("hiiii1gggg" + conceptNameValue + "hii :"+conceptLineValue);
		$.ajax
        ({
        	
                type: 'GET',
                url: "/MMS/GenerateReportTM/"+ conceptNameValue + "/" + conceptLineValue,
                data: {},
                contentType: "application/json; charset=utf-8",
                success: function(response) 
                {
                    alert(response);
               	 
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
                                <li class="active"><span>Report</span></li>
                            </ol>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
					
					<div class="form-group">
											<label>Area :
											<select class="form-control" id="cmbSelectArea" name="cmbSelectArea"  onchange="">
										
											</select>
											<span id="spnSelectArea" class="label label-danger"></span></label>
										</div>
										
										<div class="form-group">
											<label>Line :
											<select class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="">
										
											</select>
											<span id="spnSelectLine" class="label label-danger"></span></label>
										</div>
					<div>
				<a href="../MMS/GenerateReportTM?area=431&line=49"><input
					id="pivFormBtn" class="button" name="actionButton" type="submit"
					value="Tower Maintenance Report"></input></a> 

			</div>
				
					
										

					<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
	
	
</body>
</html>