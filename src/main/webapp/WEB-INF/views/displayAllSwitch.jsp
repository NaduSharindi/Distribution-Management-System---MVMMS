<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

thead tr th { 
	    height: 30px;
	    line-height: 30px;
	}
	
	
	tbody { border-top: 0px solid black; }
	
	tbody td, thead th {
	    border-right: 0px solid black;
	}
	
	tbody td:last-child, thead th:last-child {
	    border-right: none;
	}

	
	.table-scroll {
  position: relative;
  width:100%;
  z-index: 1;
  margin: auto;
  overflow: auto;
  height: 350px;
}
.table-scroll table {
  width: 100%;
  min-width: 1280px;
  margin: auto;
  border-collapse: separate;
  border-spacing: 0;
}
.table-wrap {
  position: relative;
}
.table-scroll th,
.table-scroll td {
  padding: 5px 10px;
  border: 0px solid #000;
  background: #f1f3f7;
  vertical-align: top;
}
.table-scroll thead th {
  
  position: -webkit-sticky;
  position: sticky;
  top: 0;
}
/* safari and ios need the tfoot itself to be position:sticky also */
.table-scroll tfoot,
.table-scroll tfoot th,
.table-scroll tfoot td {
  position: -webkit-sticky;
  position: sticky;
  bottom: 0;
  background: #666;
  color: #fff;
  z-index:4;
}

a:focus {
  background: red;
} /* testing links*/

th:first-child {
  position: -webkit-sticky;
  position: sticky;
  left: 0;
  z-index: 2;
  
}
thead th:first-child,
tfoot th:first-child {
  z-index: 5;
}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

.p1{
    font-size: 14px;
}
</style>
<html>
<head>
<%@ include file="sections/head.jsp"%>

<script type="text/javascript">
	
	var arrayARDataToSave = [];
	var arrayLBSDataToSave = [];
	var arrayABSDataToSave = [];
	var arrayDDLODataToSave = [];

	function ConfirmActivate(comid) {

		//alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				//alert(response);

			}
		});

	}

	function showProvinces() {

		$
				.ajax({
					type : 'GET',
					url : '/MMS/findAllProvinces/',
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						$("#tblProvinces > tbody:last").children().remove();

						//Insert item from the response
						for (var i = 0; i < response.length; i++) {
							var item = response[i];
							var comid = item.compId;

							tr = $('<tr/>');
							tr.append("<td> " + item.compNm + "</td>");
							tr
									.append("<td>"
											+ "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"
											+ comid + "')>Go</button>"
											+ "</td>");

							$('#tblProvinces').append(tr);
						}

						$('#tblProvinces').dataTable({
							'info' : false,
							'pageLength' : 10,
							retrieve : true
						});
					}
				});
	}

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].deptId + "'>"
									+ data[i].deptNm + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}

	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
	function getAreas() {
		$.ajax({
			type : 'GET',
			url : '/MMS/findAllAreaNew/',
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				//alert(response);
				$('#cmbSelectArea').empty();
				//Append "None" item
				$('#cmbSelectArea').append(
						$('<option>').text("<< Select Area >>").attr('value',
								""));

				//Insert item from the response
				for (var i = 0; i < response.length; i++) {
					var item = response[i];
					$('#cmbSelectArea').append(
							$('<option>').text(item.deptNm).attr('value',
									item.deptId));
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
                    	 $('#conductor').empty();
                         
                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#conductor').append($('<option>').text(item.type).attr('value', item.id));
                         }
                     }
              });		
	}

	
	function LoadswitchARToEdit(pid) {
		//alert("///"+pid);
		enableAR(pid);
		arrayARDataToSave.push(pid);

		
	}
	
	function LoadswitchLBSToEdit(pid) {
		enableLBS(pid);
		arrayLBSDataToSave.push(pid);

		
	}
	
	function LoadswitchABSToEdit(pid) {
		enableABS(pid);
		arrayABSDataToSave.push(pid);

		
	}
	
	function LoadswitchDDLOToEdit(pid) {
		enableDDLO(pid);
		arrayDDLODataToSave.push(pid);

		
	}

	function editarAll(stringIDs) {
       // alert(stringIDs);
		alert("You are going to edit that all switches.. \n");
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadswitchARToEdit(arrayAllIds[count]);
		}

	}
	
	function editlbsAll(stringIDs) {

		alert("You are going to edit that all switches.. \n");
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadswitchLBSToEdit(arrayAllIds[count]);
		}

	}
	
	function editabsAll(stringIDs) {

		alert("You are going to edit that all switches.. \n");
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadswitchABSToEdit(arrayAllIds[count]);
		}

	}
	
	function editddloAll(stringIDs) {

		alert("You are going to edit that all switches.. \n");
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadswitchDDLOToEdit(arrayAllIds[count]);
		}

	}

	function disableAR(pid) {
		    
			
		//document.getElementById("code_" + pid).disabled = true;
		document.getElementById("name_" + pid).disabled = true;
		document.getElementById("mounting_" + pid).disabled = true;
		document.getElementById("brandName_" + pid).disabled = true;
		document.getElementById("date_" + pid).disabled = true;
		document.getElementById("datec_" + pid).disabled = true;
		document.getElementById("ModelNumber_" + pid).disabled = true;
		document.getElementById("SerialNo_" + pid).disabled = true;
		document.getElementById("BatteryCapacity_" + pid).disabled = true;
		document.getElementById("NoOfBatteries_" + pid).disabled = true;
        document.getElementById("RemoteOperation_" + pid).disabled = true;
		document.getElementById("Arrangement_" + pid).disabled = true;
		document.getElementById("date1_" + pid).disabled = true;
		document.getElementById("datec1_" + pid).disabled = true;
		document.getElementById("ModelNumber1_" + pid).disabled = true;
		document.getElementById("SerialNo1_" + pid).disabled = true;
		document.getElementById("Rating_" + pid).disabled = true;
		document.getElementById("SccLevelOfEquipment_" + pid).disabled = true;
		document.getElementById("InsulationMedium_" + pid).disabled = true;
        document.getElementById("status_" + pid).disabled = true;
			
		arrayARDataToSave = [];
	}
	
	function disableLBS(pid) {
	    
		
		//document.getElementById("codelbs_" + pid).disabled = true;
		document.getElementById("namelbs_" + pid).disabled = true;
		document.getElementById("mountinglbs_" + pid).disabled = true;
		document.getElementById("brandNamelbs_" + pid).disabled = true;
		document.getElementById("datelbs_" + pid).disabled = true;
		document.getElementById("dateclbs_" + pid).disabled = true;
		document.getElementById("ModelNumberlbs_" + pid).disabled = true;
		document.getElementById("SerialNolbs_" + pid).disabled = true;
		document.getElementById("BatteryCapacitylbs_" + pid).disabled = true;
		document.getElementById("NoOfBatterieslbs_" + pid).disabled = true;
        document.getElementById("RemoteOperationlbs_" + pid).disabled = true;
		document.getElementById("Arrangementlbs_" + pid).disabled = true;
		document.getElementById("date1lbs_" + pid).disabled = true;
		document.getElementById("datec1lbs_" + pid).disabled = true;
		document.getElementById("ModelNumber1lbs_" + pid).disabled = true;
		document.getElementById("SerialNo1lbs_" + pid).disabled = true;
		document.getElementById("Ratinglbs_" + pid).disabled = true;
		document.getElementById("SccLevelOfEquipmentlbs_" + pid).disabled = true;
		document.getElementById("InsulationMediumlbs_" + pid).disabled = true;
        document.getElementById("statuslbs_" + pid).disabled = true;
		
	  arrayLBSDataToSave = [];
   }
	
function disableABS(pid) {
	    
		
	//document.getElementById("codeabs_" + pid).disabled = true;
	document.getElementById("nameabs_" + pid).disabled = true;
	document.getElementById("brandNameabs_" + pid).disabled = true;
	document.getElementById("dateabs_" + pid).disabled = true;
	document.getElementById("datecabs_" + pid).disabled = true;
	document.getElementById("ModelNumberabs_" + pid).disabled = true;
	document.getElementById("SerialNoabs_" + pid).disabled = true;
	document.getElementById("operationDirectionabs_" + pid).disabled = true;
	document.getElementById("positionabs_" + pid).disabled = true;
	document.getElementById("Ratingabs_" + pid).disabled = true;
	document.getElementById("SccLevelOfEquipmentabs_" + pid).disabled = true;
	document.getElementById("statusabs_" + pid).disabled = true;
		
	  arrayABSDataToSave = [];
   }
   
function disableDDLO(pid) {
    
	
	//document.getElementById("codeddlo_" + pid).disabled = true;
	document.getElementById("nameddlo_" + pid).disabled = true;
	document.getElementById("positionddlo_" + pid).disabled = true;
	document.getElementById("quantityddlo_" + pid).disabled = true;
	document.getElementById("carrierTypeddlo_" + pid).disabled = true;
	document.getElementById("sgRatingddlo_" + pid).disabled = true;
    document.getElementById("statusddlo_" + pid).disabled = true;
	
  arrayDDLODataToSave = [];
}
	
	

	
	function enableAR(pid) {
		
		//alert(pid);
		//document.getElementById("code_" + pid).disabled = false;
		document.getElementById("name_" + pid).disabled = false;
		document.getElementById("mounting_" + pid).disabled = false;
		document.getElementById("brandName_" + pid).disabled = false;
		document.getElementById("date_" + pid).disabled = false;
		document.getElementById("datec_" + pid).disabled = false;
		document.getElementById("ModelNumber_" + pid).disabled = false;
		document.getElementById("SerialNo_" + pid).disabled = false;
		document.getElementById("BatteryCapacity_" + pid).disabled = false;
		document.getElementById("NoOfBatteries_" + pid).disabled = false;
        document.getElementById("RemoteOperation_" + pid).disabled = false;
		document.getElementById("Arrangement_" + pid).disabled = false;
		document.getElementById("date1_" + pid).disabled = false;
		document.getElementById("datec1_" + pid).disabled = false;
		document.getElementById("ModelNumber1_" + pid).disabled = false;
		document.getElementById("SerialNo1_" + pid).disabled = false;
		document.getElementById("Rating_" + pid).disabled = false;
		document.getElementById("SccLevelOfEquipment_" + pid).disabled = false;
		document.getElementById("InsulationMedium_" + pid).disabled = false;
        document.getElementById("status_" + pid).disabled = false;
		
		
		
	}
	
function enableLBS(pid) {
		
	//alert(pid);	
	//document.getElementById("codelbs_" + pid).disabled = false;
	document.getElementById("namelbs_" + pid).disabled = false;
	document.getElementById("mountinglbs_" + pid).disabled = false;
	document.getElementById("brandNamelbs_" + pid).disabled = false;
	document.getElementById("datelbs_" + pid).disabled = false;
	document.getElementById("dateclbs_" + pid).disabled = false;
	document.getElementById("ModelNumberlbs_" + pid).disabled = false;
	document.getElementById("SerialNolbs_" + pid).disabled = false;
	document.getElementById("BatteryCapacitylbs_" + pid).disabled = false;
	document.getElementById("NoOfBatterieslbs_" + pid).disabled = false;
    document.getElementById("RemoteOperationlbs_" + pid).disabled = false;
	document.getElementById("Arrangementlbs_" + pid).disabled = false;
	document.getElementById("date1lbs_" + pid).disabled = false;
	document.getElementById("datec1lbs_" + pid).disabled = false;
	document.getElementById("ModelNumber1lbs_" + pid).disabled = false;
	document.getElementById("SerialNo1lbs_" + pid).disabled = false;
	document.getElementById("Ratinglbs_" + pid).disabled = false;
	document.getElementById("SccLevelOfEquipmentlbs_" + pid).disabled = false;
	document.getElementById("InsulationMediumlbs_" + pid).disabled = false;
    document.getElementById("statuslbs_" + pid).disabled = false;
		
		
		
	}
function enableABS(pid) {
	
	
	//document.getElementById("codeabs_" + pid).disabled = false;
	document.getElementById("nameabs_" + pid).disabled = false;
	document.getElementById("brandNameabs_" + pid).disabled = false;
	document.getElementById("dateabs_" + pid).disabled = false;
	document.getElementById("datecabs_" + pid).disabled = false;
	document.getElementById("ModelNumberabs_" + pid).disabled = false;
	document.getElementById("SerialNoabs_" + pid).disabled = false;
	document.getElementById("operationDirectionabs_" + pid).disabled = false;
	document.getElementById("positionabs_" + pid).disabled = false;
	document.getElementById("Ratingabs_" + pid).disabled = false;
	document.getElementById("SccLevelOfEquipmentabs_" + pid).disabled = false;
    document.getElementById("statusabs_" + pid).disabled = false;
	
	
}

function enableDDLO(pid) {
	
	
	//document.getElementById("codeddlo_" + pid).disabled = false;
	document.getElementById("nameddlo_" + pid).disabled = false;
	document.getElementById("positionddlo_" + pid).disabled = false;
	document.getElementById("quantityddlo_" + pid).disabled = false;
	document.getElementById("carrierTypeddlo_" + pid).disabled = false;
	document.getElementById("sgRatingddlo_" + pid).disabled = false;
    document.getElementById("statusddlo_" + pid).disabled = false;
	
	
	
}

	
	function saveAllar() {
		
		var len = arrayARDataToSave.length
		for (var count = 0; count < len; count++) {
			var pid = arrayARDataToSave[count];
			
			var gantryId = document.getElementById("gantryId_" + pid).value;
			var feederId = document.getElementById("feederId_" + pid).value;
		    var code = document.getElementById("code_" + pid).value;
			var name = document.getElementById("name_" + pid).value;
			var mounting= document.getElementById("mounting_" + pid).value;
			var brandname = document.getElementById("brandName_" + pid).value;
			var date = document.getElementById("date_" + pid).value;
			var datec = document.getElementById("datec_" + pid).value;
			var modelnumber = document.getElementById("ModelNumber_" + pid).value;
			var serialno = document.getElementById("SerialNo_" + pid).value;
			var batteryCapacity = document.getElementById("BatteryCapacity_" + pid).value;
			var NoOfBatteries = document.getElementById("NoOfBatteries_" + pid).value;
	        var RemoteOperation = document.getElementById("RemoteOperation_" + pid).value;
			var Arrangement =document.getElementById("Arrangement_" + pid).value;
			var date1 = document.getElementById("date1_" + pid).value;
			var datec1 = document.getElementById("datec1_" + pid).value;
			var ModelNumber1 = document.getElementById("ModelNumber1_" + pid).value;
			var SerialNo1 = document.getElementById("SerialNo1_" + pid).value;
			var rating = document.getElementById("Rating_" + pid).value;
			var SccLevelOfEquipment = document.getElementById("SccLevelOfEquipment_" + pid).value;
			var InsulationMedium = document.getElementById("InsulationMedium_" + pid).value;
	        var status = document.getElementById("status_" + pid).value;
	        
	        
	        	
			var url = "/MMS/updateSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + mounting + "/"+ brandname + "/"+ date + "/" + datec + "/" + modelnumber + "/" + serialno + "/"
					+ batteryCapacity + "/" + NoOfBatteries + "/" + RemoteOperation + "/" + Arrangement + "/" + date1 + "/" + datec1 + "/" + ModelNumber1 + "/" + SerialNo1 + "/"
					+ rating + "/" + SccLevelOfEquipment + "/" + InsulationMedium + "/" + status + "/";		


			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					console.log(response);
					window.location.reload();
					disableAR(pid);
				}
			});
		}
		alert("Switch updated succesfully... ");
		
	}
	

	function saveAR(pid) {
		
		var gantryId = document.getElementById("gantryId_" + pid).value;
		var feederId = document.getElementById("feederId_" + pid).value;
	    var code = document.getElementById("code_" + pid).value;
		var name = document.getElementById("name_" + pid).value;
		var mounting= document.getElementById("mounting_" + pid).value;
		var brandname = document.getElementById("brandName_" + pid).value;
		var date = document.getElementById("date_" + pid).value;
		var datec = document.getElementById("datec_" + pid).value;
		var modelnumber = document.getElementById("ModelNumber_" + pid).value;
		var serialno = document.getElementById("SerialNo_" + pid).value;
		var batteryCapacity = document.getElementById("BatteryCapacity_" + pid).value;
		var NoOfBatteries = document.getElementById("NoOfBatteries_" + pid).value;
        var RemoteOperation = document.getElementById("RemoteOperation_" + pid).value;
		var Arrangement =document.getElementById("Arrangement_" + pid).value;
		var date1 = document.getElementById("date1_" + pid).value;
		var datec1 = document.getElementById("datec1_" + pid).value;
		var ModelNumber1 = document.getElementById("ModelNumber1_" + pid).value;
		var SerialNo1 = document.getElementById("SerialNo1_" + pid).value;
		var rating = document.getElementById("Rating_" + pid).value;
		var SccLevelOfEquipment = document.getElementById("SccLevelOfEquipment_" + pid).value;
		var InsulationMedium = document.getElementById("InsulationMedium_" + pid).value;
        var status = document.getElementById("status_" + pid).value;
        
        
        	
		var url = "/MMS/updateSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + mounting + "/" + brandname + "/"+ date + "/" + datec + "/" + modelnumber + "/" + serialno + "/"
				+ batteryCapacity + "/" + NoOfBatteries + "/" + RemoteOperation + "/" + Arrangement + "/" + date1 + "/" + datec1 + "/" + ModelNumber1 + "/" + SerialNo1 + "/"
				+ rating + "/" + SccLevelOfEquipment + "/" + InsulationMedium + "/" + status + "/";		

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("switch updated succesfully...");
				console.log(response);
				window.location.reload();
				disableAR(pid);
			}
		});

	}
	
	
function saveAlllbs() {
		
		var len = arrayLBSDataToSave.length
		for (var count = 0; count < len; count++) {
			var pid = arrayLBSDataToSave[count];
			
			var gantryId = document.getElementById("gantryIdlbs_" + pid).value;
			var feederId = document.getElementById("feederIdlbs_" + pid).value;
		    var code = document.getElementById("codelbs_" + pid).value;
			var name = document.getElementById("namelbs_" + pid).value;
			var mounting= document.getElementById("mountinglbs_" + pid).value;
			var brandname = document.getElementById("brandNamelbs_" + pid).value;
			var date = document.getElementById("datelbs_" + pid).value;
			var datec = document.getElementById("dateclbs_" + pid).value;
			var modelnumber = document.getElementById("ModelNumberlbs_" + pid).value;
			var serialno = document.getElementById("SerialNolbs_" + pid).value;
			var batteryCapacity = document.getElementById("BatteryCapacitylbs_" + pid).value;
			var NoOfBatteries = document.getElementById("NoOfBatterieslbs_" + pid).value;
	        var RemoteOperation = document.getElementById("RemoteOperationlbs_" + pid).value;
			var Arrangement =document.getElementById("Arrangementlbs_" + pid).value;
			var date1 = document.getElementById("date1lbs_" + pid).value;
			var datec1 = document.getElementById("datec1lbs_" + pid).value;
			var ModelNumber1 = document.getElementById("ModelNumber1lbs_" + pid).value;
			var SerialNo1 = document.getElementById("SerialNo1lbs_" + pid).value;
			var rating = document.getElementById("Ratinglbs_" + pid).value;
			var SccLevelOfEquipment = document.getElementById("SccLevelOfEquipmentlbs_" + pid).value;
			var InsulationMedium = document.getElementById("InsulationMediumlbs_" + pid).value;
	        var status = document.getElementById("statuslbs_" + pid).value;
	        
	        
	        	
			var url = "/MMS/updateSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + mounting + "/" + brandname + "/"+ date + "/" + datec + "/" + modelnumber + "/" + serialno + "/"
					+ batteryCapacity + "/" + NoOfBatteries + "/" + RemoteOperation + "/" + Arrangement + "/" + date1 + "/" + datec1 + "/" + ModelNumber1 + "/" + SerialNo1 + "/"
					+ rating + "/" + SccLevelOfEquipment + "/" + InsulationMedium + "/" + status + "/";		


			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					console.log(response);
					window.location.reload();
					disableLBS(pid);
				}
			});
		}
		alert("Switch updated succesfully... ");
		
	}
	

	function saveLBS(pid) {
		
		var gantryId = document.getElementById("gantryIdlbs_" + pid).value;
		var feederId = document.getElementById("feederIdlbs_" + pid).value;
	    var code = document.getElementById("codelbs_" + pid).value;
		var name = document.getElementById("namelbs_" + pid).value;
		var mounting= document.getElementById("mountinglbs_" + pid).value;
		var brandname = document.getElementById("brandNamelbs_" + pid).value;
		var date = document.getElementById("datelbs_" + pid).value;
		var datec = document.getElementById("dateclbs_" + pid).value;
		var modelnumber = document.getElementById("ModelNumberlbs_" + pid).value;
		var serialno = document.getElementById("SerialNolbs_" + pid).value;
		var batteryCapacity = document.getElementById("BatteryCapacitylbs_" + pid).value;
		var NoOfBatteries = document.getElementById("NoOfBatterieslbs_" + pid).value;
        var RemoteOperation = document.getElementById("RemoteOperationlbs_" + pid).value;
		var Arrangement =document.getElementById("Arrangementlbs_" + pid).value;
		var date1 = document.getElementById("date1lbs_" + pid).value;
		var datec1 = document.getElementById("datec1lbs_" + pid).value;
		var ModelNumber1 = document.getElementById("ModelNumber1lbs_" + pid).value;
		var SerialNo1 = document.getElementById("SerialNo1lbs_" + pid).value;
		var rating = document.getElementById("Ratinglbs_" + pid).value;
		var SccLevelOfEquipment = document.getElementById("SccLevelOfEquipmentlbs_" + pid).value;
		var InsulationMedium = document.getElementById("InsulationMediumlbs_" + pid).value;
        var status = document.getElementById("statuslbs_" + pid).value;
        
        
        	
		var url = "/MMS/updateSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + mounting + "/" + brandname + "/"+ date + "/" + datec + "/" + modelnumber + "/" + serialno + "/"
				+ batteryCapacity + "/" + NoOfBatteries + "/" + RemoteOperation + "/" + Arrangement + "/" + date1 + "/" + datec1 + "/" + ModelNumber1 + "/" + SerialNo1 + "/"
				+ rating + "/" + SccLevelOfEquipment + "/" + InsulationMedium + "/" + status + "/";		

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("switch updated succesfully...");
				console.log(response);
				window.location.reload();
				disableLBS(pid);
			}
		});

	}
	
	
function saveAllabs() {
		
		var len = arrayABSDataToSave.length
		for (var count = 0; count < len; count++) {
			var pid = arrayABSDataToSave[count];
			
			var gantryId = document.getElementById("gantryIdabs_" + pid).value;
			var feederId = document.getElementById("feederIdabs_" + pid).value;
		    var code = document.getElementById("codeabs_" + pid).value;
			var name = document.getElementById("nameabs_" + pid).value;
			var brandname = document.getElementById("brandNameabs_" + pid).value;
			var date = document.getElementById("dateabs_" + pid).value;
			var datec = document.getElementById("datecabs_" + pid).value;
			var modelnumber = document.getElementById("ModelNumberabs_" + pid).value;
			var serialno = document.getElementById("SerialNoabs_" + pid).value;
			var operationDirection = document.getElementById("operationDirectionabs_" + pid).value;
			var position = document.getElementById("positionabs_" + pid).value;
			var rating = document.getElementById("Ratingabs_" + pid).value;
			var SccLevelOfEquipment = document.getElementById("SccLevelOfEquipmentabs_" + pid).value;
		    var status = document.getElementById("statusabs_" + pid).value;
	        
	        var url = "/MMS/updateABSSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + brandname + "/"+ date + "/" + datec + "/" + modelnumber + "/" + serialno + "/"
					+ operationDirection + "/" + position + "/" + rating + "/" + SccLevelOfEquipment + "/" + status + "/";		

	        
			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					console.log(response);
					window.location.reload();
					disableABS(pid);
				}
			});
		}
		alert("Switch updated succesfully... ");
		
	}
	

	function saveABS(pid) {
		
		var gantryId = document.getElementById("gantryIdabs_" + pid).value;
		var feederId = document.getElementById("feederIdabs_" + pid).value;
	    var code = document.getElementById("codeabs_" + pid).value;
		var name = document.getElementById("nameabs_" + pid).value;
		var brandname = document.getElementById("brandNameabs_" + pid).value;
		var date = document.getElementById("dateabs_" + pid).value;
		var datec = document.getElementById("datecabs_" + pid).value;
		var modelnumber = document.getElementById("ModelNumberabs_" + pid).value;
		var serialno = document.getElementById("SerialNoabs_" + pid).value;
		var operationDirection = document.getElementById("operationDirectionabs_" + pid).value;
		var position = document.getElementById("positionabs_" + pid).value;
		var rating = document.getElementById("Ratingabs_" + pid).value;
		var SccLevelOfEquipment = document.getElementById("SccLevelOfEquipmentabs_" + pid).value;
	    var status = document.getElementById("statusabs_" + pid).value;
        
        var url = "/MMS/updateABSSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name +"/"+ brandname +"/" + date + "/" + datec + "/" + modelnumber + "/" + serialno + "/"
				+ operationDirection + "/" + position + "/" + rating + "/" + SccLevelOfEquipment + "/" + status + "/";		

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("switch updated succesfully...");
				console.log(response);
				window.location.reload();
				disableABS(pid);
			}
		});

	}
	
function saveAllddlo() {
		
		var len = arrayDDLODataToSave.length
		for (var count = 0; count < len; count++) {
			var pid = arrayDDLODataToSave[count];
			
			var gantryId = document.getElementById("gantryIdddlo_" + pid).value;
			var feederId = document.getElementById("feederIdddlo_" + pid).value;
		    var code = document.getElementById("codeddlo_" + pid).value;
			var name = document.getElementById("nameddlo_" + pid).value;
			var position = document.getElementById("positionddlo_" + pid).value;
			var quantity = document.getElementById("quantityddlo_" + pid).value;
			var carrierType = document.getElementById("carrierTypeddlo_" + pid).value;
			var rating = document.getElementById("sgRatingddlo_" + pid).value;
		    var status = document.getElementById("statusddlo_" + pid).value;
		    
	        
	        var url = "/MMS/updateDDLOSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + position + "/"+ quantity + "/" + carrierType + "/" 
					+ rating + "/" + status + "/";		

	        
			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					console.log(response);
					window.location.reload();
					disableDDLO(pid);
				}
			});
		}
		alert("Switch updated succesfully... ");
		
	}
	

	function saveDDLO(pid) {
		
		var gantryId = document.getElementById("gantryIdddlo_" + pid).value;
		var feederId = document.getElementById("feederIdddlo_" + pid).value;
	    var code = document.getElementById("codeddlo_" + pid).value;
		var name = document.getElementById("nameddlo_" + pid).value;
		var position = document.getElementById("positionddlo_" + pid).value;
		var quantity = document.getElementById("quantityddlo_" + pid).value;
		var carrierType = document.getElementById("carrierTypeddlo_" + pid).value;
		var rating = document.getElementById("sgRatingddlo_" + pid).value;
	    var status = document.getElementById("statusddlo_" + pid).value;
	    
        
        var url = "/MMS/updateDDLOSwitch/" + pid + "/" +gantryId + "/" + feederId+ "/" + code + "/"+ name + "/" + position + "/"+ quantity + "/" + carrierType + "/" 
				+ rating + "/" + status + "/";	
        
        $.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("switch updated succesfully...");
				console.log(response);
				window.location.reload();
				disableDDLO(pid);
			}
		});

	}

	function sendForValidation(switchType) {
		
		//alert(switchType);
        var url = "/MMS/updateSwitchStatusNew/" + switchType + "/";
		
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Succesfully approved...");
				console.log(response);
				window.location.reload();
				//disable( id );
			}
		});
		
		
	}
	
</script>
</head>
<body>
	<div id="theme-wrapper">

		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Edit Switch </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
							   <div class="tab">
  								<button class="tablinks" onclick="openSwitche(event, 'AR')">Auto Recloser</button>
  							    <button class="tablinks" onclick="openSwitche(event, 'LBS')">LBS</button>
  								<button class="tablinks" onclick="openSwitche(event, 'ABS')">ABS</button>
  								<button class="tablinks" onclick="openSwitche(event, 'DDLO')">DDLO</button>
								</div>

								<div id="AR" class="tabcontent">
  								<h1>Auto Recloser</h1>
							
							
								
								<div id="table-responsive" class="table-scroll">
									<div class="table-scroll">
										<table class="table table-responsive" id="tblProvinces">

											<tbody>
												<form:form method="post" action="displayArNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    
															
																<th class="text-center">Code</th>
																<th class="text-center">Name</th>
																<th class="text-center">Mounting</th>
																<th class="text-center">Brand Name</th>
																<th class="text-center">Date of Manufacture</th>
																<th class="text-center">Commissioning date</th>
																<th class="text-center">Model Number</th>
																<th class="text-center">Serial Number</th>
																<th class="text-center">Battery Capacity(A)</th>
																<th class="text-center">No of batteries</th>
																<th class="text-center">Remote operation</th>
																<th class="text-center">Arrangement</th>
																<th class="text-center">Date of Manufacture</th>
																<th class="text-center">Commissioning date</th>
																<th class="text-center">Model Number</th>
																<th class="text-center">Serial Number</th>
																<th class="text-center">Rating</th>
																<th class="text-center">SCC level of equipment (kA)</th>
																<th class="text-center">Insulation medium</th>
																<th class="text-center">Status</th>
																<th></th>
																<th></th>
																<th class="text-center">Edit</th>
																<th class="text-center">Save</th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="switch" items="${model.arListEdit}">
																<tr>
																   
																	<th><input type="text" id="code_${switch.id.switchId}"
																		value="${switch.switchCode}" class="form-control" disabled></th>
																	<td><input type="text" id="name_${switch.id.switchId}"
																		value="${switch.switchName}" class="form-control" disabled></td> 
																		
																	
																	<td><select id="mounting_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.mounting=='1'}">
																					<option value="${switch.mounting}"
																						selected="selected">Pole</option>
																					<option value="2">C channel</option>
																					
																				</c:when>

																				<c:when test="${switch.mounting=='2'}">
																					<option value="${switch.mounting}"
																						selected="selected">C channel</option>
																					<option value="1">Pole</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																		
																	<%-- <td><input type="text" id="brandName_${switch.id.switchId}"
																		value="${switch.brandName}" class="form-control" disabled></td>  --%>
																	 <td><select id="brandName_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.brandName=='1'}">
																					<option value="${switch.brandName}"
																						selected="selected">NOJA</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>

																				<c:when test="${switch.brandName=='2'}">
																					<option value="${switch.brandName}"
																						selected="selected">ADVC</option>
																					<option value="1">NOJA</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>
																				
																				<c:when test="${switch.brandName=='3'}">
																					<option value="${switch.brandName}"
																						selected="selected">Jing Kang</option>
																					<option value="2">ADVC</option>
																					<option value="1">NOJA</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>
																				
																				<c:when test="${switch.brandName=='4'}">
																					<option value="${switch.brandName}"
																						selected="selected">Nulec</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">NOJA</option>
																					<option value="5">BN System</option>
																				</c:when>
																				<c:when test="${switch.brandName=='5'}">
																					<option value="${switch.brandName}"
																						selected="selected">BN System</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">NOJA</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																		
																	<td><input type="text" id="date_${switch.id.switchId}"
																		value="${switch.cpDateManufature}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="datec_${switch.id.switchId}"
																		value="${switch.cpDateCommitioning}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="ModelNumber_${switch.id.switchId}"
																		value="${switch.cpModelNumber}" class="form-control" disabled></td> 	
																		
																	<td><input type="text" id="SerialNo_${switch.id.switchId}"
																		value="${switch.cpSerialNo}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="BatteryCapacity_${switch.id.switchId}"
																		value="${switch.cpBatteryCapacity}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="NoOfBatteries_${switch.id.switchId}"
																		value="${switch.cpNoOfBatteries}" class="form-control" disabled></td>
																		
																		
																	<td><select id="RemoteOperation_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.cpRemoteOperation=='1'}">
																					<option value="${switch.cpRemoteOperation}"
																						selected="selected">Yes</option>
																					<option value="2">No</option>
																					
																				</c:when>

																				<c:when test="${switch.cpRemoteOperation=='2'}">
																					<option value="${switch.cpRemoteOperation}"
																						selected="selected">No</option>
																					<option value="1">Yes</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																		
																	<td><select id="Arrangement_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.sgArrangement=='1'}">
																					<option value="${switch.sgArrangement}"
																						selected="selected">Horizontal</option>
																					<option value="2">Verticle</option>
																					
																				</c:when>

																				<c:when test="${switch.sgArrangement=='2'}">
																					<option value="${switch.sgArrangement}"
																						selected="selected">Verticle</option>
																					<option value="1">Horizontal</option>
																				</c:when>

																			</c:choose>
																	</select></td>  
																		
																	<td><input type="text" id="date1_${switch.id.switchId}"
																		value="${switch.sgDateManufature}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="datec1_${switch.id.switchId}"
																		value="${switch.sgDateCommitioning}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="ModelNumber1_${switch.id.switchId}"
																		value="${switch.sgModelNumber}" class="form-control" disabled></td> 	
																		
																	<td><input type="text" id="SerialNo1_${switch.id.switchId}"
																		value="${switch.sgSerialNo}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="Rating_${switch.id.switchId}"
																		value="${switch.sgRating}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="SccLevelOfEquipment_${switch.id.switchId}"
																		value="${switch.sgSccLevelOfEquipment}" class="form-control" disabled></td> 
																	
																		
																	<td><select id="InsulationMedium_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.sgInsulationMedium=='1'}">
																					<option value="${switch.sgInsulationMedium}"
																						selected="selected">SF6</option>
																					<option value="2">Epoxy</option>
																					
																				</c:when>

																				<c:when test="${switch.sgInsulationMedium=='2'}">
																					<option value="${switch.sgInsulationMedium}"
																						selected="selected">Epoxy</option>
																					<option value="1">SF6</option>
																				</c:when>

																			</c:choose>
																	</select></td>  	 		   		 
																	

																	<td><select id="status_${switch.id.switchId}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${switch.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${switch.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td> 
                                                                    

																	<td><input type="hidden" id="gantryId_${switch.id.switchId}"
																		value="${switch.id.gantryId}" class="form-control" disabled></td>
																		
																	<td><input type="hidden" id="feederId_${switch.id.switchId}"
																		value="${switch.id.feederId}" class="form-control" disabled></td>


																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadswitchARToEdit("${switch.id.switchId}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:saveAR("${switch.id.switchId}")'>Save</button></td>
																</tr>

															</c:forEach>
														</tbody>
													</table>
													
													





												</form:form>

											</tbody>
										</table>

									</div>

								
							</div>
							<div>
							<table class="table-responsive" align="center">
							<tbody>
							<tr style="text-align:center">

														
														<td style="padding-right:10px;">
															<button type='button' class='btn btn-warning'
																onClick='javascript:editarAll("${model.stringOfarSwitchIds}")'>Edit
																All</button>
														</td>

														<td style="padding-right:10px;">
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAllar()'>Update All</button>
														</td>
														

														<td colspan="2" style="padding-right:10px;"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton1" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn1" class="btn btn-success"
																		type="submit" name="actionButton1"
																		value="Send For Validation"
																		onclick='sendForValidation("${model.arListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn1" class="btn btn-success"
																		type="submit" name="actionButton1" value="Approve"
																		onclick='sendForValidation("${model.arListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn1" class="btn btn-success"
																		type="submit" name="actionButton1"
																		value="Send For Approval"
																		onclick='sendForValidation("${model.arListEdit[0].switchType}")'></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
													</tr>
													</tbody>
													</table>
													</div>
							
							
							
							</div>
							<div id="LBS" class="tabcontent">
  								<h1>LBS</h1>
							
							
								
								<div id="table-responsive" class="table-scroll">
									<div class="table-scroll">
										<table class="table table-responsive" id="tblProvinces">

											<tbody>
												<form:form method="post" action="displayLbsNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    
															    <th class="text-center">Code</th>
																<th class="text-center">Name</th>
																<th class="text-center">Mounting</th>
																<th class="text-center">Brand Name</th>
																<th class="text-center">Date of Manufacture</th>
																<th class="text-center">Commissioning date</th>
																<th class="text-center">Model Number</th>
																<th class="text-center">Serial Number</th>
																<th class="text-center">Battery Capacity(A)</th>
																<th class="text-center">No of batteries</th>
																<th class="text-center">Remote operation</th>
																<th class="text-center">Arrangement</th>
																<th class="text-center">Date of Manufacture</th>
																<th class="text-center">Commissioning date</th>
																<th class="text-center">Model Number</th>
																<th class="text-center">Serial Number</th>
																<th class="text-center">Rating</th>
																<th class="text-center">SCC level of equipment (kA)</th>
																<th class="text-center">Insulation medium</th>
																<th class="text-center">Status</th>
																<th></th>
																<th></th>
																<th class="text-center">Edit</th>
																<th class="text-center">Save</th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="switch" items="${model.lbsListEdit}">
																<tr>
																	
																   <th><input type="text" id="codelbs_${switch.id.switchId}"
																		value="${switch.switchCode}" class="form-control" disabled></th>
																	<td><input type="text" id="namelbs_${switch.id.switchId}"
																		value="${switch.switchName}" class="form-control" disabled></td> 
																		
																	<td><select id="mountinglbs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.mounting=='1'}">
																					<option value="${switch.mounting}"
																						selected="selected">Pole</option>
																					<option value="2">C channel</option>
																					
																				</c:when>

																				<c:when test="${switch.mounting=='2'}">
																					<option value="${switch.mounting}"
																						selected="selected">C channel</option>
																					<option value="1">Pole</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																		
																	
																	<td><select id="brandNamelbs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.brandName=='1'}">
																					<option value="${switch.brandName}"
																						selected="selected">NOJA</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>

																				<c:when test="${switch.brandName=='2'}">
																					<option value="${switch.brandName}"
																						selected="selected">ADVC</option>
																					<option value="1">NOJA</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>
																				
																				<c:when test="${switch.brandName=='3'}">
																					<option value="${switch.brandName}"
																						selected="selected">Jing Kang</option>
																					<option value="2">ADVC</option>
																					<option value="1">NOJA</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>
																				
																				<c:when test="${switch.brandName=='4'}">
																					<option value="${switch.brandName}"
																						selected="selected">Nulec</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">NOJA</option>
																					<option value="5">BN System</option>
																				</c:when>
																				<c:when test="${switch.brandName=='5'}">
																					<option value="${switch.brandName}"
																						selected="selected">BN System</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">NOJA</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																		
																	<td><input type="text" id="datelbs_${switch.id.switchId}"
																		value="${switch.cpDateManufature}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="dateclbs_${switch.id.switchId}"
																		value="${switch.cpDateCommitioning}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="ModelNumberlbs_${switch.id.switchId}"
																		value="${switch.cpModelNumber}" class="form-control" disabled></td> 	
																		
																	<td><input type="text" id="SerialNolbs_${switch.id.switchId}"
																		value="${switch.cpSerialNo}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="BatteryCapacitylbs_${switch.id.switchId}"
																		value="${switch.cpBatteryCapacity}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="NoOfBatterieslbs_${switch.id.switchId}"
																		value="${switch.cpNoOfBatteries}" class="form-control" disabled></td>
																		
																	<td><select id="RemoteOperationlbs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.cpRemoteOperation=='1'}">
																					<option value="${switch.cpRemoteOperation}"
																						selected="selected">Yes</option>
																					<option value="2">No</option>
																					
																				</c:when>

																				<c:when test="${switch.cpRemoteOperation=='2'}">
																					<option value="${switch.cpRemoteOperation}"
																						selected="selected">No</option>
																					<option value="1">Yes</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																		
																		
																	<td><select id="Arrangementlbs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.sgArrangement=='1'}">
																					<option value="${switch.sgArrangement}"
																						selected="selected">Horizontal</option>
																					<option value="2">Verticle</option>
																					
																				</c:when>

																				<c:when test="${switch.sgArrangement=='2'}">
																					<option value="${switch.sgArrangement}"
																						selected="selected">Verticle</option>
																					<option value="1">Horizontal</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																	
																		
																	<td><input type="text" id="date1lbs_${switch.id.switchId}"
																		value="${switch.sgDateManufature}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="datec1lbs_${switch.id.switchId}"
																		value="${switch.sgDateCommitioning}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="ModelNumber1lbs_${switch.id.switchId}"
																		value="${switch.sgModelNumber}" class="form-control" disabled></td> 	
																		
																	<td><input type="text" id="SerialNo1lbs_${switch.id.switchId}"
																		value="${switch.sgSerialNo}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="Ratinglbs_${switch.id.switchId}"
																		value="${switch.sgRating}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="SccLevelOfEquipmentlbs_${switch.id.switchId}"
																		value="${switch.sgSccLevelOfEquipment}" class="form-control" disabled></td> 
																		
																	<td><select id="InsulationMediumlbs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.sgInsulationMedium=='1'}">
																					<option value="${switch.sgInsulationMedium}"
																						selected="selected">SF6</option>
																					<option value="2">Epoxy</option>
																					
																				</c:when>

																				<c:when test="${switch.sgInsulationMedium=='2'}">
																					<option value="${switch.sgInsulationMedium}"
																						selected="selected">Epoxy</option>
																					<option value="1">SF6</option>
																				</c:when>

																			</c:choose>
																	</select></td>   	 		   		 
																	

																	<td><select id="statuslbs_${switch.id.switchId}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${switch.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${switch.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td> 

                                                                    <td><input type="hidden" id="gantryIdlbs_${switch.id.switchId}"
																		value="${switch.id.gantryId}" class="form-control" disabled></td>
																		
																	<td><input type="hidden" id="feederIdlbs_${switch.id.switchId}"
																		value="${switch.id.feederId}" class="form-control" disabled></td>
                                                                    
																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadswitchLBSToEdit("${switch.id.switchId}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:saveLBS("${switch.id.switchId}")'>Save</button></td>
																</tr>

															</c:forEach>
														</tbody>
													</table>
													
													





												</form:form>

											</tbody>
										</table>

									</div>

								
							</div>
							<div>
							<table class="table-responsive" align="center">
							<tbody>
							<tr style="text-align:center">

														
														<td style="padding-right:10px;">
															<button type='button' class='btn btn-warning'
																onClick='javascript:editlbsAll("${model.stringOflbsSwitchIds}")'>Edit
																All</button>
														</td>

														<td style="padding-right:10px;">
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAlllbs()'>Update All</button>
														</td>
														

														<td colspan="2" style="padding-right:10px;"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton2" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn2" class="btn btn-success"
																		type="submit" name="actionButton2"
																		value="Send For Validation"
																		onclick='sendForValidation("${model.lbsListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn2" class="btn btn-success"
																		type="submit" name="actionButton2" value="Approve"
																		onclick='sendForValidation("${model.lbsListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn2" class="btn btn-success"
																		type="submit" name="actionButton2"
																		value="Send For Approval"
																		onclick='sendForValidation("${model.lbsListEdit[0].switchType}")'></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
													</tr>
													</tbody>
													</table>
													</div>
							
							</div>
							<div id="ABS" class="tabcontent">
  								<h1>ABS</h1>
							
							
								
								<div id="table-responsive" class="table-scroll">
									<div class="table-scroll">
										<table class="table table-responsive" id="tblProvinces">

											<tbody>
												<form:form method="post" action="displayAbsNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    
															    <th class="text-center">Code</th>
																<th class="text-center">Name</th>
																<th class="text-center">Brand Name</th>
																<th class="text-center">Date of Manufacture</th>
																<th class="text-center">Commissioning date</th>
																<th class="text-center">Model Number</th>
																<th class="text-center">Serial Number</th>
																<th class="text-center">Operation direction</th>
																<th class="text-center">Position</th>
																<th class="text-center">Rating</th>
																<th class="text-center">SCC level of equipment (kA)</th>
																<th class="text-center">Status</th>
																<th></th>
																<th></th> 
																<th class="text-center">Edit</th>
																<th class="text-center">Save</th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="switch" items="${model.absListEdit}">
																<tr>
																	
																    
																	 <th><input type="text" id="codeabs_${switch.id.switchId}"
																		value="${switch.switchCode}" class="form-control" disabled></th>
																	<td><input type="text" id="nameabs_${switch.id.switchId}"
																		value="${switch.switchName}" class="form-control" disabled></td> 
																
																	
																	 <td><select id="brandNameabs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.brandName=='1'}">
																					<option value="${switch.brandName}"
																						selected="selected">NOJA</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>

																				<c:when test="${switch.brandName=='2'}">
																					<option value="${switch.brandName}"
																						selected="selected">ADVC</option>
																					<option value="1">NOJA</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>
																				
																				<c:when test="${switch.brandName=='3'}">
																					<option value="${switch.brandName}"
																						selected="selected">Jing Kang</option>
																					<option value="2">ADVC</option>
																					<option value="1">NOJA</option>
																					<option value="4">Nulec</option>
																					<option value="5">BN System</option>
																				</c:when>
																				
																				<c:when test="${switch.brandName=='4'}">
																					<option value="${switch.brandName}"
																						selected="selected">Nulec</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">NOJA</option>
																					<option value="5">BN System</option>
																				</c:when>
																				<c:when test="${switch.brandName=='5'}">
																					<option value="${switch.brandName}"
																						selected="selected">BN System</option>
																					<option value="2">ADVC</option>
																					<option value="3">Jing Kang</option>
																					<option value="4">Nulec</option>
																					<option value="5">NOJA</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																		
																	<td><input type="text" id="dateabs_${switch.id.switchId}"
																		value="${switch.cpDateManufature}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="datecabs_${switch.id.switchId}"
																		value="${switch.cpDateCommitioning}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="ModelNumberabs_${switch.id.switchId}"
																		value="${switch.cpModelNumber}" class="form-control" disabled></td> 	
																		
																	<td><input type="text" id="SerialNoabs_${switch.id.switchId}"
																		value="${switch.cpSerialNo}" class="form-control" disabled></td> 
																		
																	
																	 <td><select id="operationDirectionabs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.operationDirection=='1'}">
																					<option value="${switch.operationDirection}"
																						selected="selected">Horizontal</option>
																					<option value="2">Vertical</option>
																				</c:when>

																				<c:when test="${switch.operationDirection=='2'}">
																					<option value="${switch.operationDirection}"
																						selected="selected">Vertical</option>
																					<option value="1">Horizontal</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																		
																	
																		
																     <td><select id="positionabs_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.position=='1'}">
																					<option value="${switch.position}"
																						selected="selected">Bypass</option>
																					<option value="2">Isolation</option>
																				</c:when>

																				<c:when test="${switch.position=='2'}">
																					<option value="${switch.position}"
																						selected="selected">Isolation</option>
																					<option value="1">Bypass</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																		
																	<td><input type="text" id="Ratingabs_${switch.id.switchId}"
																		value="${switch.sgRating}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="SccLevelOfEquipmentabs_${switch.id.switchId}"
																		value="${switch.sgSccLevelOfEquipment}" class="form-control" disabled></td> 	   		 
																	

																	<td><select id="statusabs_${switch.id.switchId}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${switch.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${switch.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td> 
																	
																	<td><input type="hidden" id="gantryIdabs_${switch.id.switchId}"
																		value="${switch.id.gantryId}" class="form-control" disabled></td>
																		
																	<td><input type="hidden" id="feederIdabs_${switch.id.switchId}"
																		value="${switch.id.feederId}" class="form-control" disabled></td>

																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadswitchABSToEdit("${switch.id.switchId}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:saveABS("${switch.id.switchId}")'>Save</button></td>
																</tr>

															</c:forEach>
														</tbody>
													</table>
													
													





												</form:form>

											</tbody>
										</table>

									</div>

								
							</div>
							<div>
							<table class="table-responsive" align="center">
							<tbody>
							<tr style="text-align:center">

														
														<td style="padding-right:10px;">
															<button type='button' class='btn btn-warning'
																onClick='javascript:editabsAll("${model.stringOfabsSwitchIds}")'>Edit
																All</button>
														</td>

														<td style="padding-right:10px;">
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAllabs()'>Update All</button>
														</td>
														

														<td colspan="2" style="padding-right:10px;"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton3" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn3" class="btn btn-success"
																		type="submit" name="actionButton3"
																		value="Send For Validation"
																		onclick='sendForValidation("${model.absListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn3" class="btn btn-success"
																		type="submit" name="actionButton3" value="Approve"
																		onclick='sendForValidation("${model.absListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn3" class="btn btn-success"
																		type="submit" name="actionButton3"
																		value="Send For Approval"
																		onclick='sendForValidation("${model.absListEdit[0].switchType}")'></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
													</tr>
													</tbody>
													</table>
													</div>
							
							</div>
							<div id="DDLO" class="tabcontent">
  								<h1>DDLO</h1>
							
							
								
								<div id="table-responsive" class="table-scroll">
									<div class="table-scroll">
										<table class="table table-responsive" id="tblProvinces">

											<tbody>
												<form:form method="post" action="displayDdloNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    
															     <th class="text-center">Code</th>
																<th class="text-center">Name</th>
																<th class="text-center">Position</th>
																<th class="text-center">Quantity</th>
																<th class="text-center">Carrier Type</th>
																<th class="text-center">Rating</th>
																<th class="text-center">Status</th>
																<th></th>
																<th></th>
																<th class="text-center">Edit</th>
																<th class="text-center">Save</th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="switch" items="${model.ddloListEdit}">
																<tr>
																	
																   
																	 <th><input type="text" id="codeddlo_${switch.id.switchId}"
																		value="${switch.switchCode}" class="form-control" disabled></th>
																	<td><input type="text" id="nameddlo_${switch.id.switchId}"
																		value="${switch.switchName}" class="form-control" disabled></td> 
																		
																	 <td><select id="positionddlo_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.position=='1'}">
																					<option value="${switch.position}"
																						selected="selected">Bypass</option>
																					<option value="2">Isolation</option>
																				</c:when>

																				<c:when test="${switch.position=='2'}">
																					<option value="${switch.position}"
																						selected="selected">Isolation</option>
																					<option value="1">Bypass</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																		
																	<td><input type="text" id="quantityddlo_${switch.id.switchId}"
																		value="${switch.quantity}" class="form-control" disabled></td>
																		
																	
																	 <td><select id="carrierTypeddlo_${switch.id.switchId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${switch.carrierType=='1'}">
																					<option value="${switch.carrierType}"
																						selected="selected">Fuse</option>
																					<option value="2">Link</option>
																				</c:when>

																				<c:when test="${switch.carrierType=='2'}">
																					<option value="${switch.carrierType}"
																						selected="selected">Link</option>
																					<option value="1">Fuse</option>
																				</c:when>

																			</c:choose>
																	</select></td> 
																		
																	<td><input type="text" id="sgRatingddlo_${switch.id.switchId}"
																		value="${switch.sgRating}" class="form-control" disabled></td> 
																	 	   		 
																	

																	<td><select id="statusddlo_${switch.id.switchId}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${switch.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${switch.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${switch.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td> 
																	
                                                                    <td><input type="hidden" id="gantryIdddlo_${switch.id.switchId}"
																		value="${switch.id.gantryId}" class="form-control" disabled></td>
																		
																	<td><input type="hidden" id="feederIdddlo_${switch.id.switchId}"
																		value="${switch.id.feederId}" class="form-control" disabled></td>
																		
																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadswitchDDLOToEdit("${switch.id.switchId}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:saveDDLO("${switch.id.switchId}")'>Save</button></td>
																</tr>

															</c:forEach>
														</tbody>
													</table>
													
													





												</form:form>

											</tbody>
										</table>

									</div>

								
							</div>
							     <div>
							<table class="table-responsive" align="center">
							<tbody>
							<tr style="text-align:center">

														
														<td style="padding-right:10px;">
															<button type='button' class='btn btn-warning'
																onClick='javascript:editddloAll("${model.stringOfddloSwitchIds}")'>Edit
																All</button>
														</td>

														<td style="padding-right:10px;">
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAllddlo()'>Update All</button>
														</td>
														

														<td colspan="2" style="padding-right:10px;"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton4" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn4" class="btn btn-success"
																		type="submit" name="actionButton4"
																		value="Send For Validation"
																		onclick='sendForValidation("${model.ddloListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn4" class="btn btn-success"
																		type="submit" name="actionButton4" value="Approve"
																		onclick='sendForValidation("${model.ddloListEdit[0].switchType}")'></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn4" class="btn btn-success"
																		type="submit" name="actionButton4"
																		value="Send For Approval"
																		onclick='sendForValidation("${model.ddloListEdit[0].switchType}")'></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
													</tr>
													</tbody>
													</table>
													</div>
							
							
							</div>
							<script>
												function openSwitche(evt, switcheName) {
  												var i, tabcontent, tablink;
  												tabcontent = document.getElementsByClassName("tabcontent");
  												for (i = 0; i < tabcontent.length; i++) {
    											tabcontent[i].style.display = "none";
 												}
  												tablinks = document.getElementsByClassName("tablinks");
  												for (i = 0; i < tablinks.length; i++) {
    											tablinks[i].className = tablinks[i].className.replace(" active", "");
 												}
  												document.getElementById(switcheName).style.display = "block";
  												evt.currentTarget.className += " active";
												}
											</script>
							
							
							
						</div>
					</div>
					
					

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>