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
                    	/*  alert("response.towerNo" + response.towerNo); */	
                         return response.towerNo;
                     }
                     

                    
              });
		
	}
	
	
	function showMntHome()
	{
		alert('hiiii');
       	 $.ajax
             ({
                     type: 'GET',
                     url: "/MMS/findTMALL/",
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
						//alert(response);
                         $("#tblAreas > tbody:last").children().remove();
                         //Insert item from the response
                         var count = 0;
                         countResponseData = response.length;
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             count = count + 1;
                             /* alert(item);
                             alert(item.configuration); */
                             
                             tr = $('<tr/>');
                                tr.append("<td>" + item.id.towerid + "</td>");
                                tr.append("<td> <input type=text id=nooftappings"+item.id.towerid+"  value="+item.nooftappings+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=pinpole1"+item.id.towerid+"  value="+item.pinpole1+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=switchdev1"+item.id.towerid+"  value="+item.switchdev1+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=pinpole2"+item.id.towerid+"  value="+item.pinpole2+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=switchdev2"+item.id.towerid+"  value="+item.switchdev2+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=pinpole3"+item.id.towerid+"  value="+item.pinpole3+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=switchdev3"+item.id.towerid+"  value="+item.switchdev3+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=noofmissingparts"+item.id.towerid+"  value="+item.noofmissingparts+" disabled ></input></td>");
                     			tr.append("<td> <input type=text id=nofflashoversets"+item.id.towerid+"  value="+item.nofflashoversets+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=wayleavestatus"+item.id.towerid+"  value="+item.wayleavestatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=baseconcretestatus"+item.id.towerid+"  value="+item.baseconcretestatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=anticlimbingstatus"+item.id.towerid+"  value="+item.anticlimbingstatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=conductorstatus"+item.id.towerid+"  value="+item.conductorstatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=jumperstatus"+item.id.towerid+"  value="+item.jumperstatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=earthconductorstatus"+item.id.towerid+"  value="+item.earthconductorstatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=attentionstatus"+item.id.towerid+"  value="+item.attentionstatus+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=fungussetno"+item.id.towerid+"  value="+item.fungussetno+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=wpinset"+item.id.towerid+"  value="+item.wpinset+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=endfittingset"+item.id.towerid+"  value="+item.endfittingset+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=towerspecial"+item.id.towerid+"  value="+item.towerspecial+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=ludt"+item.id.towerid+"  value="+item.ludt+" disabled ></input></td>");
                                tr.append("<td> <input type=text id=maintenancedate"+item.id.towerid+"  value="+item.maintenancedate+" disabled ></input></td>"); 
                                
                               /*  tr.append("<td>" + item[0].noofmissingparts + "</td>");
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
                                tr.append("<td>" + item[0].maintenancedate + "</td>"); */
                                
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
                                
                                tr.append("<td><button type='button' class='btn btn-warning' onClick='enable("+item.id.towerid+")'>Edit</button></td>")
                                tr.append("<td><button type='button' class='btn btn-success' onClick='save("+item.id.towerid+")'>Save</button></td>");
                                
                                
                                //console.log(item);

                                //Show "Edit" and "Delete" buttons
                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");

                                $('#tblAreas').append(tr);
                         }

                     }
              });
		
	}


	
	
	
	function enable(id){
		/* alert(id); */
		document.getElementById("nooftappings"+id).disabled = false;
		document.getElementById("pinpole1"+id).disabled = false;
		document.getElementById("switchdev1"+id).disabled = false;
		document.getElementById("pinpole2"+id).disabled = false;
		document.getElementById("switchdev2"+id).disabled = false;
		document.getElementById("pinpole3"+id).disabled = false;
		document.getElementById("switchdev3"+id).disabled = false;
		document.getElementById("noofmissingparts"+id).disabled = false;
		document.getElementById("nofflashoversets"+id).disabled = false;
		document.getElementById("wayleavestatus"+id).disabled = false;
		document.getElementById("baseconcretestatus"+id).disabled = false;
		document.getElementById("anticlimbingstatus"+id).disabled = false;
		document.getElementById("conductorstatus"+id).disabled = false;
		document.getElementById("jumperstatus"+id).disabled = false;
		document.getElementById("earthconductorstatus"+id).disabled = false;
		document.getElementById("attentionstatus"+id).disabled = false;
		document.getElementById("fungussetno"+id).disabled = false;
		document.getElementById("wpinset"+id).disabled = false;
		document.getElementById("endfittingset"+id).disabled = false;
		document.getElementById("towerspecial"+id).disabled = false;
		document.getElementById("ludt"+id).disabled = false;
		document.getElementById("maintenancedate"+id).disabled = false; 
		document.getElementById("status"+id).disabled = false;
	}
	
	function save(id) 
    {
      /*  alert('hiiiii'); */
	   var nooftappings = document.getElementById("nooftappings"+id).value;
	  /*  alert('hiiiii'+nooftappings); */
	   var pinpole1 = document.getElementById("pinpole1"+id).value;
	 /*   alert('hiiiii'+pinpole1); */
	   var switchdev1 = document.getElementById("switchdev1"+id).value;
	  /*  alert('hiiiii'+switchdev1); */
	   var pinpole2 = document.getElementById("pinpole2"+id).value;
	  /*  alert('hiiiii'+pinpole2); */
	   var switchdev2 = document.getElementById("switchdev2"+id).value;
	   /* alert('hiiiii'+switchdev2); */
	   var pinpole3 = document.getElementById("pinpole3"+id).value;
	   /* alert('hiiiii'+pinpole3); */
	   var switchdev3 = document.getElementById("switchdev3"+id).value;
	   /* alert('hiiiii'+switchdev3); */
	   var noofmissingparts = document.getElementById("noofmissingparts"+id).value;
	   /* alert('hiiiii'+noofmissingparts); */
	   var nofflashoversets = document.getElementById("nofflashoversets"+id).value;
	   /* alert('hiiiii'+nofflashoversets); */
	   var wayleavestatus = document.getElementById("wayleavestatus"+id).value;
	   /* alert('hiiiii'+wayleavestatus); */
	   var baseconcretestatus = document.getElementById("baseconcretestatus"+id).value;
	   /* alert('hiiiii'+baseconcretestatus); */
	   var anticlimbingstatus = document.getElementById("anticlimbingstatus"+id).value;
	   /* alert('hiiiii'+anticlimbingstatus); */
	   var conductorstatus = document.getElementById("conductorstatus"+id).value;
	  /*  alert('hiiiii'+conductorstatus); */
	   var jumperstatus = document.getElementById("jumperstatus"+id).value;
	   /* alert('hiiiii'+jumperstatus); */
	   var earthconductorstatus = document.getElementById("earthconductorstatus"+id).value;
	   /* alert('hiiiii'+earthconductorstatus); */
	   var attentionstatus = document.getElementById("attentionstatus"+id).value;
	  /*  alert('hiiiii'+attentionstatus); */
	   var fungussetno = document.getElementById("fungussetno"+id).value;
	   /* alert('hiiiii'+fungussetno); */
	   var wpinset = document.getElementById("wpinset"+id).value;
	  /*  alert('hiiiii'+wpinset); */
	   var endfittingset = document.getElementById("endfittingset"+id).value;
	  /*  alert('hiiiii'+endfittingset); */
	   var towerspecial = document.getElementById("towerspecial"+id).value;
	 /*   alert('hiiiii'+towerspecial);
 */	   var ludt = document.getElementById("ludt"+id).value;
	  /*  alert('hiiiii'+ludt); */
	   var maintenancedate = document.getElementById("maintenancedate"+id).value;
	  /*  alert('hiiiii'+maintenancedate); */
	  /*  disable(id); */
	   var status = document.getElementById("status"+id).value;
	  /*  alert('hiiiiii' +status); */
	  disable(id);
	   
    
	 var url = "/MMS/updateTowerMaintence/"+nooftappings+"/"+pinpole1+"/"+switchdev1+"/"+pinpole2+"/"+switchdev2+"/"+pinpole3+"/"
	 +switchdev3+"/"+noofmissingparts+"/"+nofflashoversets+"/"+wayleavestatus+"/"+"/"+baseconcretestatus+"/"
	 +anticlimbingstatus+"/"+conductorstatus+"/" +jumperstatus+"/"+earthconductorstatus+"/" +attentionstatus+"/"
	 +fungussetno+"/"+wpinset+"/" +endfittingset+"/"+towerspecial+"/"+ludt+"/" +maintenancedate+"/"+status+"/";

	  /*  alert('hiiiii345' +url); */
	   
      $.ajax({
      	type: "GET",
          url : url,
          success : function(response) {
              alert("Line updated succesfully...");
              console.log(response);
              window.location.reload();
              disable(id);
          }
      }); 
    } 
	function disable(id){
		alert(id);
		document.getElementById("nooftappings"+id).disabled = true;
		document.getElementById("pinpole1"+id).disabled = true;
		document.getElementById("switchdev1"+id).disabled = true;
		document.getElementById("pinpole2"+id).disabled = true;
		document.getElementById("switchdev2"+id).disabled = true;
		document.getElementById("pinpole3"+id).disabled = true;
		document.getElementById("switchdev3"+id).disabled = true;
		document.getElementById("noofmissingparts"+id).disabled = true;
		document.getElementById("nofflashoversets"+id).disabled = true;
		document.getElementById("wayleavestatus"+id).disabled = true;
		document.getElementById("baseconcretestatus"+id).disabled = true;
		document.getElementById("anticlimbingstatus"+id).disabled = true;
		document.getElementById("conductorstatus"+id).disabled = true;
		document.getElementById("jumperstatus"+id).disabled = true;
		document.getElementById("earthconductorstatus"+id).disabled = true;
		document.getElementById("attentionstatus"+id).disabled = true;
		document.getElementById("fungussetno"+id).disabled = true;
		document.getElementById("wpinset"+id).disabled = true;
		document.getElementById("endfittingset"+id).disabled = true;
		document.getElementById("towerspecial"+id).disabled = true;
		document.getElementById("ludt"+id).disabled = true;
		document.getElementById("maintenancedate"+id).disabled = true; 
		document.getElementById("status"+id).disabled = true;
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
		                                tr.append("<td> <input type=text id=pinpole1"+item[0].id.towerid+"  value="+item[0].pinpole1+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=switchdev1"+item[0].id.towerid+"  value="+item[0].switchdev1+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=pinpole2"+item[0].id.towerid+"  value="+item[0].pinpole2+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=switchdev2"+item[0].id.towerid+"  value="+item[0].switchdev2+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=pinpole3"+item[0].id.towerid+"  value="+item[0].pinpole3+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=switchdev3"+item[0].id.towerid+"  value="+item[0].switchdev3+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=noofmissingparts"+item[0].id.towerid+"  value="+item[0].noofmissingparts+" disabled ></input></td>");
		                     			tr.append("<td> <input type=text id=nofflashoversets"+item[0].id.towerid+"  value="+item[0].nofflashoversets+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=wayleavestatus"+item[0].id.towerid+"  value="+item[0].wayleavestatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=baseconcretestatus"+item[0].id.towerid+"  value="+item[0].baseconcretestatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=anticlimbingstatus"+item[0].id.towerid+"  value="+item[0].anticlimbingstatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=conductorstatus"+item[0].id.towerid+"  value="+item[0].conductorstatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=jumperstatus"+item[0].id.towerid+"  value="+item[0].jumperstatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=earthconductorstatus"+item[0].id.towerid+"  value="+item[0].earthconductorstatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=attentionstatus"+item[0].id.towerid+"  value="+item[0].attentionstatus+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=fungussetno"+item[0].id.towerid+"  value="+item[0].fungussetno+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=wpinset"+item[0].id.towerid+"  value="+item[0].wpinset+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=endfittingset"+item[0].id.towerid+"  value="+item[0].endfittingset+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=towerspecial"+item[0].id.towerid+"  value="+item[0].towerspecial+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=ludt"+item[0].id.towerid+"  value="+item[0].ludt+" disabled ></input></td>");
		                                tr.append("<td> <input type=text id=maintenancedate"+item[0].id.towerid+"  value="+item[0].maintenancedate+" disabled ></input></td>"); 
		                                
		                                tr.append("<td> <select id=status"+item[0].id.towerid+" disabled >"
		                                		+"<option value="+item[0].status+" selected=selected>Pending</option>"
					                		    +"<option value="+item[0].status+" selected=selected>Active</option>"
					                		    +"<option value="+item[0].status+" selected=selected>In bulk</option>"
					                		    +"<option value="+item[0].status+" selected=selected>Rejected</option>"
					                		    +"<option value="+item[0].status+" selected=selected>Inactive</option>"
					                		    +"</select></td>");
		                       			
		                                
		                                /**if(item[0].status==0){
		                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
		                                }  else if(item[0].status==1){ 
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
		                                } */
		                       			 
		                                //tr.append("<td>" + item[0].approvalLevel + "</td>");
		                                
		                                tr.append("<td><button type='button' class='btn btn-warning' onClick='enable("+item[0].id.towerid+")'>Edit</button></td>");
		                                tr.append("<td><button type='button' class='btn btn-success' onClick='save("+item[0].id.towerid+")'>Save</button></td>");
		                                
		                                
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
		/* alert(conceptCycleValue + "/" + conceptCycleValue); */
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
		/* alert(area); */
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
<!-- <body> -->
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
											<!-- <select class="form-control" id="cmbSelectCycle" name="cmbSelectCycle"  onchange="showMntHome()"> -->
										
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
															<th class="text-center">No Of Pinpoles 1 </th>
															<th class="text-center">Switching Device 1</th>
															<th class="text-center">No Of Pinpoles 2 </th>
															<th class="text-center">Switching Device 2</th>
															<th class="text-center">No Of Pinpoles 3 </th>
															<th class="text-center">Switching Device 3</th>
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
												<!-- <button type="button" class="btn btn-info" onclick="enable()">Edit</button> -->
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