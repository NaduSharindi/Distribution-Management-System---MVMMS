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

table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}


	.scroll {
	    border-spacing: 0;
	    border: 0px solid black;
	}

	.scroll tbody,
	.scroll thead { 
	display: block;
	width: 100%;
	}
	
	thead tr th { 
	    height: 30px;
	    line-height: 30px;
	    
	}
	
	.scroll tbody {
	    height: 250px;
	    overflow-y: auto;
	    overflow-x: hidden;
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
Collapse


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

	
	




</style>
<html>
<head>
<%@ include file="sections/head.jsp"%>




<script type="text/javascript">

var arrayDataToSave = [];

function editAll(stringIDs) {

	alert("You are going to edit that all Maintenance.. \n" );
	var arrayAllIds = stringIDs.split(",");
	
	var len = arrayAllIds.length

	for (var count = 0; count < len; count++) {
		LoadLineToEdit(arrayAllIds[count]);
	}

}

//edited anushka 2019-01-08------------------------------------------------------------------------------------------------------------------------
function saveAll() {
	var len = arrayDataToSave.length

	for (var count = 0; count < len; count++) {
		var id = arrayDataToSave[count];

		
	//	var conceptCycle = $('#cycle').find(":selected").text();
	//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

        var conceptCycleValue = document.getElementById("cycleno_"+id).value;
    		
		var nooftappings = document.getElementById("nooftappings_" + id).value;
		var pinpole1 = document.getElementById("pinpole1_" + id).value;
		var switchdev1 = document.getElementById("switchdev1_" + id).value;
		var pinpole2 = document.getElementById("pinpole2_" + id).value;
		var switchdev2 = document.getElementById("switchdev2_" + id).value;
		var pinpole3 = document.getElementById("pinpole3_" + id).value;
		var switchdev3 = document.getElementById("switchdev3_" + id).value;
		var noofmissingparts = document
				.getElementById("noofmissingparts_" + id).value;
		var nofflashoversets = document
				.getElementById("nofflashoversets_" + id).value;
		var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
		var baseconcretestatus = document.getElementById("baseconcretestatus_"
				+ id).value;
		var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
				+ id).value;
		var conductorstatus = document.getElementById("conductorstatus_" + id).value;
		var jumperstatus = document.getElementById("jumperstatus_" + id).value;
		var earthconductorstatus = document
				.getElementById("earthconductorstatus_" + id).value;
		var attentionstatus = document.getElementById("attentionstatus_" + id).value;
		var fungussetno = document.getElementById("fungussetno_" + id).value;
		var wpinset = document.getElementById("wpinset_" + id).value;
		var endfittingset = document.getElementById("endfittingset_" + id).value;
		var towerspecial = document.getElementById("towerspecial_" + id).value;
		//var ludt = document.getElementById("ludt_" + id).value;
		var ludt = '2019-02-25';
        		
		var maintenancedate = document.getElementById("maintenancedate_" + id).value;
		var status = document.getElementById("status_" + id).value;
		var approvalLevel = document.getElementById("approvalLevel_" + id).value;
		var hotPossible = document.getElementById("hotpossible_" + id).value;
		var legpainting = document.getElementById("legpainting_" + id).value;
		//var status = document.getElementById("status_" + id).value;
		
		/* var url = "/MMS/updateTowerMaintence/" + conceptCycleValue + "/" + id
				+ "/" + nooftappings + "/" + pinpole1 + "/" + switchdev1 + "/"
				+ pinpole2 + "/" + switchdev2 + "/" + pinpole3 + "/"
				+ switchdev3 + "/" + noofmissingparts + "/" + nofflashoversets
				+ "/" + wayleavestatus + "/" + baseconcretestatus + "/"
				+ anticlimbingstatus + "/" + conductorstatus + "/"
				+ jumperstatus + "/" + earthconductorstatus + "/"
				+ attentionstatus + "/" + fungussetno + "/" + wpinset + "/"
				+ endfittingset + "/" + towerspecial + "/" + ludt + "/"
				+ maintenancedate + "/" + status + "/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";
 */
 
//@RequestMapping(value = "/updateTowerMaintence/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}
	///{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/
	//{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}
	///{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/
	//{hotpossible}/{legPainting}",method = RequestMethod.GET, produces = "application/json")
	
	
 
 var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
	+ "&nooftappings=" + encodeURIComponent(nooftappings) + "&pinpole1=" + encodeURIComponent(pinpole1) + "&switchdev1=" + encodeURIComponent(switchdev1) + "&pinpole2="
	+ encodeURIComponent(pinpole2) + "&switchdev2=" + encodeURIComponent(switchdev2) + "&pinpole3=" + encodeURIComponent(pinpole3) + "&switchdev3="
	+ encodeURIComponent(switchdev3) + "&noofmissingparts=" + encodeURIComponent(noofmissingparts) + "&nofflashoversets=" + encodeURIComponent(nofflashoversets)
	+ "&wayleavestatus=" + encodeURIComponent(wayleavestatus) + "&baseconcretestatus=" + encodeURIComponent(baseconcretestatus) + "&anticlimbingstatus="
	+ encodeURIComponent(anticlimbingstatus) + "&conductorstatus=" + encodeURIComponent(conductorstatus) + "&jumperstatus="
	+ encodeURIComponent(jumperstatus) + "&earthconductorstatus=" + encodeURIComponent(earthconductorstatus) + "&attentionstatus="
	+ encodeURIComponent(attentionstatus) + "&fungussetno=" + encodeURIComponent(fungussetno) + "&wpinset=" + encodeURIComponent(wpinset) + "&endfittingset="
	+ encodeURIComponent(endfittingset) + "&towerspecial=" + encodeURIComponent(towerspecial) + "&ludt=" + encodeURIComponent(ludt) + "&maintenancedate="
	+ encodeURIComponent(maintenancedate) + "&status=" +status + "&approvalLevel="+ encodeURIComponent(approvalLevel) + "&hotpossible=" + encodeURIComponent(hotPossible) + "&legPainting=" +encodeURIComponent(legpainting);


 
 //alert('hiiiii456' + url);
		
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				console.log(response);
				//window.location.reload();
							}
		});
		
		disable(id);

	}
	alert("Tower maintenance updated succesfully...");
}
//-----------------------------------------------------------------------------------------------------------------------------------------------

function approveAllDEO(stringIDs) {
	
	//alert('DEO');
	
	var arrayAllIds = stringIDs.split(",");
	
	var len = arrayAllIds.length

	for (var count = 0; count < len; count++) {
		//LoadLineToEdit(arrayAllIds[count]);
		arrayDataToSave.push(id);
	}

	
	var len = arrayDataToSave.length

	for (var count = 0; count < len; count++) {
		
		//alert('DEO' );
		
		var id = arrayDataToSave[count];

		
	//	var conceptCycle = $('#cycle').find(":selected").text();
	//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

		var conceptCycleValue = document.getElementById("cycleno_"+id).value;
    		
		var nooftappings = document.getElementById("nooftappings_" + id).value;
		var pinpole1 = document.getElementById("pinpole1_" + id).value;
		var switchdev1 = document.getElementById("switchdev1_" + id).value;
		var pinpole2 = document.getElementById("pinpole2_" + id).value;
		var switchdev2 = document.getElementById("switchdev2_" + id).value;
		var pinpole3 = document.getElementById("pinpole3_" + id).value;
		var switchdev3 = document.getElementById("switchdev3_" + id).value;
		var noofmissingparts = document
				.getElementById("noofmissingparts_" + id).value;
		var nofflashoversets = document
				.getElementById("nofflashoversets_" + id).value;
		var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
		var baseconcretestatus = document.getElementById("baseconcretestatus_"
				+ id).value;
		var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
				+ id).value;
		var conductorstatus = document.getElementById("conductorstatus_" + id).value;
		var jumperstatus = document.getElementById("jumperstatus_" + id).value;
		var earthconductorstatus = document
				.getElementById("earthconductorstatus_" + id).value;
		var attentionstatus = document.getElementById("attentionstatus_" + id).value;
		var fungussetno = document.getElementById("fungussetno_" + id).value;
		var wpinset = document.getElementById("wpinset_" + id).value;
		var endfittingset = document.getElementById("endfittingset_" + id).value;
		var towerspecial = document.getElementById("towerspecial_" + id).value;
		//var ludt = document.getElementById("ludt_" + id).value;
		var ludt = '2019-02-25';
        		
		var maintenancedate = document.getElementById("maintenancedate_" + id).value;
		var status = document.getElementById("status_" + id).value;
		var approvalLevel = document.getElementById("approvalLevel_" + id).value;
		var hotPossible = document.getElementById("hotpossible_" + id).value;
		var legpainting = document.getElementById("legpainting_" + id).value;
		//@RequestMapping(value = "/updateTowerMaintence/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}
		///{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/
		//{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}
		///{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/{hotpossible}/{legPainting}",method = RequestMethod.GET, produces = "application/json")
		 
		/* var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
				+ "&nooftappings=" + nooftappings + "&pinpole1=" + pinpole1 + "&switchdev1=" + switchdev1 + "&pinpole2="
				+ pinpole2 + "&switchdev2=" + switchdev2 + "&pinpole3=" + pinpole3 + "&switchdev3="
				+ switchdev3 + "&noofmissingparts=" + noofmissingparts + "&nofflashoversets=" + nofflashoversets
				+ "&wayleavestatus=" + wayleavestatus + "&baseconcretestatus=" + baseconcretestatus + "&anticlimbingstatus="
				+ anticlimbingstatus + "&conductorstatus=" + conductorstatus + "&jumperstatus="
				+ jumperstatus + "&earthconductorstatus=" + earthconductorstatus + "&attentionstatus="
				+ attentionstatus + "&fungussetno=" + fungussetno + "&wpinset=" + wpinset + "&endfittingset="
				+ endfittingset + "&towerspecial=" + towerspecial + "&ludt=" + ludt + "&maintenancedate="
				+ maintenancedate + "/3/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";
 */
		//alert('hiiiii456' + url);
 
 var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
	+ "&nooftappings=" + encodeURIComponent(nooftappings) + "&pinpole1=" + encodeURIComponent(pinpole1) + "&switchdev1=" + encodeURIComponent(switchdev1) + "&pinpole2="
	+ encodeURIComponent(pinpole2) + "&switchdev2=" + encodeURIComponent(switchdev2) + "&pinpole3=" + encodeURIComponent(pinpole3) + "&switchdev3="
	+ encodeURIComponent(switchdev3) + "&noofmissingparts=" + encodeURIComponent(noofmissingparts) + "&nofflashoversets=" + encodeURIComponent(nofflashoversets)
	+ "&wayleavestatus=" + encodeURIComponent(wayleavestatus) + "&baseconcretestatus=" + encodeURIComponent(baseconcretestatus) + "&anticlimbingstatus="
	+ encodeURIComponent(anticlimbingstatus) + "&conductorstatus=" + encodeURIComponent(conductorstatus) + "&jumperstatus="
	+ encodeURIComponent(jumperstatus) + "&earthconductorstatus=" + encodeURIComponent(earthconductorstatus) + "&attentionstatus="
	+ encodeURIComponent(attentionstatus) + "&fungussetno=" + encodeURIComponent(fungussetno) + "&wpinset=" + encodeURIComponent(wpinset) + "&endfittingset="
	+ encodeURIComponent(endfittingset) + "&towerspecial=" + encodeURIComponent(towerspecial) + "&ludt=" + encodeURIComponent(ludt) + "&maintenancedate="
	+ encodeURIComponent(maintenancedate) + "&status=" +status + "&approvalLevel="+ encodeURIComponent(approvalLevel) + "&hotpossible=" + encodeURIComponent(hotPossible) + "&legPainting=" +encodeURIComponent(legpainting);


		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				console.log(response);
				window.location.reload();
				disable(id);
			}
		});
	}
	alert("Tower Maintenance updated succesfully...");
}
	
	
function approveAllDEO(stringIDs) {
	
	//alert('DEO');
	
	var arrayAllIds = stringIDs.split(",");
	
	var len = arrayAllIds.length

	for (var count = 0; count < len; count++) {
		//LoadLineToEdit(arrayAllIds[count]);
		arrayDataToSave.push(id);
	}

	
	var len = arrayDataToSave.length

	for (var count = 0; count < len; count++) {
		
		//alert('DEO' );
		
		var id = arrayDataToSave[count];

		
	//	var conceptCycle = $('#cycle').find(":selected").text();
	//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

		var conceptCycleValue = document.getElementById("cycleno_"+id).value;
    		
		var nooftappings = document.getElementById("nooftappings_" + id).value;
		var pinpole1 = document.getElementById("pinpole1_" + id).value;
		var switchdev1 = document.getElementById("switchdev1_" + id).value;
		var pinpole2 = document.getElementById("pinpole2_" + id).value;
		var switchdev2 = document.getElementById("switchdev2_" + id).value;
		var pinpole3 = document.getElementById("pinpole3_" + id).value;
		var switchdev3 = document.getElementById("switchdev3_" + id).value;
		var noofmissingparts = document
				.getElementById("noofmissingparts_" + id).value;
		var nofflashoversets = document
				.getElementById("nofflashoversets_" + id).value;
		var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
		var baseconcretestatus = document.getElementById("baseconcretestatus_"
				+ id).value;
		var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
				+ id).value;
		var conductorstatus = document.getElementById("conductorstatus_" + id).value;
		var jumperstatus = document.getElementById("jumperstatus_" + id).value;
		var earthconductorstatus = document
				.getElementById("earthconductorstatus_" + id).value;
		var attentionstatus = document.getElementById("attentionstatus_" + id).value;
		var fungussetno = document.getElementById("fungussetno_" + id).value;
		var wpinset = document.getElementById("wpinset_" + id).value;
		var endfittingset = document.getElementById("endfittingset_" + id).value;
		var towerspecial = document.getElementById("towerspecial_" + id).value;
		//var ludt = document.getElementById("ludt_" + id).value;
		var ludt = '2019-02-25';
        		
		var maintenancedate = document.getElementById("maintenancedate_" + id).value;
		var status = document.getElementById("status_" + id).value;
		var approvalLevel = document.getElementById("approvalLevel_" + id).value;
		var hotPossible = document.getElementById("hotpossible_" + id).value;
		var legpainting = document.getElementById("legpainting_" + id).value;
		
		var url = "/MMS/updateTowerMaintence/" + conceptCycleValue + "/" + id
				+ "/" + nooftappings + "/" + pinpole1 + "/" + switchdev1 + "/"
				+ pinpole2 + "/" + switchdev2 + "/" + pinpole3 + "/"
				+ switchdev3 + "/" + noofmissingparts + "/" + nofflashoversets
				+ "/" + wayleavestatus + "/" + baseconcretestatus + "/"
				+ anticlimbingstatus + "/" + conductorstatus + "/"
				+ jumperstatus + "/" + earthconductorstatus + "/"
				+ attentionstatus + "/" + fungussetno + "/" + wpinset + "/"
				+ endfittingset + "/" + towerspecial + "/" + ludt + "/"
				+ maintenancedate + "/4/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";

		//alert('hiiiii456' + url);

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				console.log(response);
				window.location.reload();
				disable(id);
			}
		});
	}
	alert("Tower Maintenance updated succesfully...");
}
	
	function approveAllEE() {
		var arrayAllIds = stringIDs.split(",");
		
		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			//LoadLineToEdit(arrayAllIds[count]);
			arrayDataToSave.push(id);
		}

		
		
		var len = arrayDataToSave.length

		for (var count = 0; count < len; count++) {
			var id = arrayDataToSave[count];

			
		//	var conceptCycle = $('#cycle').find(":selected").text();
		//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

	var conceptCycleValue = document.getElementById("cycleno_"+id).value;
	    		
			var nooftappings = document.getElementById("nooftappings_" + id).value;
			var pinpole1 = document.getElementById("pinpole1_" + id).value;
			var switchdev1 = document.getElementById("switchdev1_" + id).value;
			var pinpole2 = document.getElementById("pinpole2_" + id).value;
			var switchdev2 = document.getElementById("switchdev2_" + id).value;
			var pinpole3 = document.getElementById("pinpole3_" + id).value;
			var switchdev3 = document.getElementById("switchdev3_" + id).value;
			var noofmissingparts = document
					.getElementById("noofmissingparts_" + id).value;
			var nofflashoversets = document
					.getElementById("nofflashoversets_" + id).value;
			var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
			var baseconcretestatus = document.getElementById("baseconcretestatus_"
					+ id).value;
			var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
					+ id).value;
			var conductorstatus = document.getElementById("conductorstatus_" + id).value;
			var jumperstatus = document.getElementById("jumperstatus_" + id).value;
			var earthconductorstatus = document
					.getElementById("earthconductorstatus_" + id).value;
			var attentionstatus = document.getElementById("attentionstatus_" + id).value;
			var fungussetno = document.getElementById("fungussetno_" + id).value;
			var wpinset = document.getElementById("wpinset_" + id).value;
			var endfittingset = document.getElementById("endfittingset_" + id).value;
			var towerspecial = document.getElementById("towerspecial_" + id).value;
			//var ludt = document.getElementById("ludt_" + id).value;
			var ludt = '2019-02-25';
	        		
			var maintenancedate = document.getElementById("maintenancedate_" + id).value;
			var status = document.getElementById("status_" + id).value;
			var approvalLevel = document.getElementById("approvalLevel_" + id).value;
			var hotPossible = document.getElementById("hotpossible_" + id).value;
			var legpainting = document.getElementById("legpainting_" + id).value;
			
			var url = "/MMS/updateTowerMaintence/" + conceptCycleValue + "/" + id
					+ "/" + nooftappings + "/" + pinpole1 + "/" + switchdev1 + "/"
					+ pinpole2 + "/" + switchdev2 + "/" + pinpole3 + "/"
					+ switchdev3 + "/" + noofmissingparts + "/" + nofflashoversets
					+ "/" + wayleavestatus + "/" + baseconcretestatus + "/"
					+ anticlimbingstatus + "/" + conductorstatus + "/"
					+ jumperstatus + "/" + earthconductorstatus + "/"
					+ attentionstatus + "/" + fungussetno + "/" + wpinset + "/"
					+ endfittingset + "/" + towerspecial + "/" + ludt + "/"
					+ maintenancedate + "/1/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";

			//alert('hiiiii456' + url);

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					console.log(response);
					window.location.reload();
					disable(id);
				}
			});
		}
		alert("Tower Maintenance updated succesfully...");
	}







		function LoadLineToEdit(id)
	
		{
			//alert("id:"+id); 
			/* System.out.println("id:"+id); */
		//if(document.getElementById("status_"+id).value == 0 || document.getElementById("status_"+id).value == 1 || document.getElementById("status_"+id).value == 4){
				//alert("This item is sent for approving or active item or inactive item. You cann't edit this");
			//}
			//else{
				enable(id);
				arrayDataToSave.push(id);
			//}
		}
		
        function disable(id)
        {
        	//alert('hiiiii'); 
    		document.getElementById("nooftappings_"+id).disabled = true;
    		document.getElementById("pinpole1_"+id).disabled = true;
    		document.getElementById("switchdev1_"+id).disabled = true;
    		document.getElementById("pinpole2_"+id).disabled = true;
    		document.getElementById("switchdev2_"+id).disabled = true;
    		document.getElementById("pinpole3_"+id).disabled = true;
    		document.getElementById("switchdev3_"+id).disabled = true;
    		document.getElementById("noofmissingparts_"+id).disabled = true;
    		document.getElementById("nofflashoversets_"+id).disabled = true;
    		document.getElementById("wayleavestatus_"+id).disabled = true;
    		document.getElementById("baseconcretestatus_"+id).disabled = true;
    		document.getElementById("anticlimbingstatus_"+id).disabled = true;
    		document.getElementById("conductorstatus_"+id).disabled = true;
    		document.getElementById("jumperstatus_"+id).disabled = true;
    		document.getElementById("earthconductorstatus_"+id).disabled = true;
    		document.getElementById("attentionstatus_"+id).disabled = true;
    		document.getElementById("fungussetno_"+id).disabled = true;
    		document.getElementById("wpinset_"+id).disabled = true;
    		document.getElementById("endfittingset_"+id).disabled = true;
    		document.getElementById("towerspecial_"+id).disabled = true;
    		//document.getElementById("ludt_"+id).disabled = true;
    		document.getElementById("maintenancedate_"+id).disabled = true; 
    		document.getElementById("status_"+id).disabled = true;
    		document.getElementById("approvalLevel_"+id).disabled = true;
    		document.getElementById("hotpossible_"+id).disabled = true;
    		
    		document.getElementById("legpainting_"+id).disabled = true;
        }
        function enable(id)
        {
        	//alert('hiiiii'); 
        	document.getElementById("nooftappings_"+id).disabled =false;
    		document.getElementById("pinpole1_"+id).disabled = false;
    		document.getElementById("switchdev1_"+id).disabled = false;
    		document.getElementById("pinpole2_"+id).disabled = false;
    		document.getElementById("switchdev2_"+id).disabled = false;
    		document.getElementById("pinpole3_"+id).disabled = false;
    		document.getElementById("switchdev3_"+id).disabled = false;
    		document.getElementById("noofmissingparts_"+id).disabled = false;
    		document.getElementById("nofflashoversets_"+id).disabled = false;
    		document.getElementById("wayleavestatus_"+id).disabled = false;
    		document.getElementById("baseconcretestatus_"+id).disabled = false;
    		document.getElementById("anticlimbingstatus_"+id).disabled = false;
    		document.getElementById("conductorstatus_"+id).disabled = false;
    		document.getElementById("jumperstatus_"+id).disabled = false;
    		document.getElementById("earthconductorstatus_"+id).disabled = false;
    		document.getElementById("attentionstatus_"+id).disabled = false;
    		document.getElementById("fungussetno_"+id).disabled = false;
    		document.getElementById("wpinset_"+id).disabled = false;
    		document.getElementById("endfittingset_"+id).disabled = false;
    		document.getElementById("towerspecial_"+id).disabled = false;
    		//document.getElementById("ludt_"+id).disabled = false;
    		document.getElementById("maintenancedate_"+id).disabled = false; 
    		document.getElementById("status_"+id).disabled = false;
    		document.getElementById("approvalLevel_"+id).disabled = false;
    		document.getElementById("hotpossible_"+id).disabled = false;
    		document.getElementById("legpainting_"+id).disabled = false;
    		
        }
        
       function save(id) 
        {
    	 // alert('hiiiii'); 
    	  
    	//var conceptCycle = $('#cycle').find(":selected").text();
  		//var conceptCycleValue = $('#cycle').find(":selected").attr("value");
    	  var conceptCycleValue = document.getElementById("cycleno_"+id).value;
    		
  		//alert('hiiiii'+conceptCycle);
 		//alert('hiiiii'+conceptCycleValue);

  	     
		 
    	  var nooftappings = document.getElementById("nooftappings_"+id).value;
    	// alert('hiiiii'+nooftappings);
    	 var pinpole1 = document.getElementById("pinpole1_"+id).value;
      		//alert('hiiiii'+pinpole1); 
    	 var switchdev1 = document.getElementById("switchdev1_"+id).value;
    	 // alert('hiiiii'+switchdev1); 
    	 var pinpole2 = document.getElementById("pinpole2_"+id).value;
    	  // alert('hiiiii'+pinpole2); 
    	 var switchdev2 = document.getElementById("switchdev2_"+id).value;
    	  // alert('hiiiii'+switchdev2); 
    	 var pinpole3 = document.getElementById("pinpole3_"+id).value;
    	 //  alert('hiiiii'+pinpole3); 
    	 var switchdev3 = document.getElementById("switchdev3_"+id).value;
    	 //  alert('hiiiii'+switchdev3);
    	 var noofmissingparts = document.getElementById("noofmissingparts_"+id).value;
    	  //alert('hiiiii'+noofmissingparts); 
    	 var nofflashoversets = document.getElementById("nofflashoversets_"+id).value;
    	 // alert('hiiiii'+nofflashoversets); 
    	 var wayleavestatus = document.getElementById("wayleavestatus_"+id).value;
    	 // alert('hiiiii'+wayleavestatus); 
    	 var baseconcretestatus = document.getElementById("baseconcretestatus_"+id).value;
    	 // alert('hiiiii'+baseconcretestatus); 
    	 var anticlimbingstatus = document.getElementById("anticlimbingstatus_"+id).value;
    	 // alert('hiiiii'+anticlimbingstatus); 
    	 var conductorstatus = document.getElementById("conductorstatus_"+id).value;
    	 // alert('hiiiii'+conductorstatus);
    	 var jumperstatus = document.getElementById("jumperstatus_"+id).value;
    	  //alert('hiiiii'+jumperstatus);
    	 var earthconductorstatus = document.getElementById("earthconductorstatus_"+id).value;
    	  //alert('hiiiii'+earthconductorstatus);
    	 var attentionstatus = document.getElementById("attentionstatus_"+id).value;
    	  //alert('hiiiii'+attentionstatus); 
    	 var fungussetno = document.getElementById("fungussetno_"+id).value;
    	 // alert('hiiiii'+fungussetno);
    	 var wpinset = document.getElementById("wpinset_"+id).value;
    	 // alert('hiiiii'+wpinset); 
    	 var endfittingset = document.getElementById("endfittingset_"+id).value;
    	 // alert('hiiiii'+endfittingset); 
    	 var towerspecial = document.getElementById("towerspecial_"+id).value;
    	  //alert('hiiiii'+towerspecial);
        // var ludt = document.getElementById("ludt_"+id).value;
        var ludt = '2019-02-25';
        
    	  //alert('hiiiii'+ludt); 
    	 var maintenancedate = document.getElementById("maintenancedate_"+id).value;
    	  //alert('hiiiii'+maintenancedate); 
    	 var status = document.getElementById("status_"+id).value;
    	 // alert('hiiiiii' +status); 
    	 var approvalLevel = document.getElementById("approvalLevel_"+id).value;
    	  // alert('hiiiiii' +approvalLevel);  
    	   var hotPossible = document.getElementById("hotpossible_"+id).value;
    	   var legpainting = document.getElementById("legpainting_" + id).value;
			
    	  /*  alert( "id: " + id + " / nooftappings: " + nooftappings + " / pinpole1: " + pinpole1 + " / switchdev1: " + switchdev1 +
    			   " / pinpole2: " +pinpole2 + " / switchdev2: " + switchdev2 + " / pinpole3: " + pinpole3 + " / switchdev3: " + switchdev3 +
    			   " / noofmissingparts: " + noofmissingparts + " / nofflashoversets: " + nofflashoversets + " / wayleavestatus: " + wayleavestatus + 
    			   " / baseconcretestatus: " + baseconcretestatus + " / anticlimbingstatus: " + anticlimbingstatus + " / conductorstatus: " + conductorstatus + " / jumperstatus: " + jumperstatus
    			   + " / earthconductorstatus: " + earthconductorstatus+ " / attentionstatus: " + attentionstatus+ " / fungussetno: " + fungussetno+ " / wpinset: " + wpinset+ " / endfittingset: " + endfittingset
    			   + " / towerspecial: " + towerspecial+ " / ludt: " + ludt+ " / maintenancedate: " + maintenancedate+ " / status: " + status); */
     	 
     /*  var url = "/MMS/updateTowerMaintence/"+conceptCycleValue+"/"+id+"/"+nooftappings+"/"+pinpole1+"/"+switchdev1+"/"+pinpole2+"/"+
    	   switchdev2+"/"+pinpole3+"/"+switchdev3+"/"+noofmissingparts+"/"+nofflashoversets+"/"+wayleavestatus+"/"+baseconcretestatus+"/"+
    	   anticlimbingstatus+"/"+conductorstatus+"/"+jumperstatus+"/"+earthconductorstatus+"/"+
    	   attentionstatus+"/"+ fungussetno+"/"+ wpinset+"/"+ endfittingset+"/"+towerspecial+"/"+ludt+"/"
    	   +maintenancedate+"/"+status+"/"+approvalLevel+"/"+ hotPossible + "/" +legpainting+"/";
     */			  
     	
     
     var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
 	+ "&nooftappings=" + encodeURIComponent(nooftappings) + "&pinpole1=" + encodeURIComponent(pinpole1) + "&switchdev1=" + encodeURIComponent(switchdev1) + "&pinpole2="
 	+ encodeURIComponent(pinpole2) + "&switchdev2=" + encodeURIComponent(switchdev2) + "&pinpole3=" + encodeURIComponent(pinpole3) + "&switchdev3="
 	+ encodeURIComponent(switchdev3) + "&noofmissingparts=" + encodeURIComponent(noofmissingparts) + "&nofflashoversets=" + encodeURIComponent(nofflashoversets)
 	+ "&wayleavestatus=" + encodeURIComponent(wayleavestatus) + "&baseconcretestatus=" + encodeURIComponent(baseconcretestatus) + "&anticlimbingstatus="
 	+ encodeURIComponent(anticlimbingstatus) + "&conductorstatus=" + encodeURIComponent(conductorstatus) + "&jumperstatus="
 	+ encodeURIComponent(jumperstatus) + "&earthconductorstatus=" + encodeURIComponent(earthconductorstatus) + "&attentionstatus="
 	+ encodeURIComponent(attentionstatus) + "&fungussetno=" + encodeURIComponent(fungussetno) + "&wpinset=" + encodeURIComponent(wpinset) + "&endfittingset="
 	+ encodeURIComponent(endfittingset) + "&towerspecial=" + encodeURIComponent(towerspecial) + "&ludt=" + encodeURIComponent(ludt) + "&maintenancedate="
 	+ encodeURIComponent(maintenancedate) + "&status=" +encodeURIComponent(status) + "&approvalLevel="+ encodeURIComponent(approvalLevel) + "&hotpossible=" + encodeURIComponent(hotPossible) + "&legPainting=" +encodeURIComponent(legpainting);

    			 
     
    // public @ResponseBody void updateTowerMaintenceN(HttpServletRequest request,@RequestParam("visitid") String visitid,@RequestParam("towerid") String towerid,@RequestParam("nooftappings") String nooftappings,@RequestParam("pinpole1") String pinpole1,@RequestParam("switchdev1") String switchdev1,
	//		 @RequestParam("pinpole2") String pinpole2,@RequestParam("switchdev2") String switchdev2,@RequestParam("pinpole3") String pinpole3,
	//		 @RequestParam("switchdev3") String switchdev3,@RequestParam("noofmissingparts") String noofmissingparts,@RequestParam("nofflashoversets") String nofflashoversets,@RequestParam("wayleavestatus") String wayleavestatus,@RequestParam("baseconcretestatus") String baseconcretestatus,@RequestParam("anticlimbingstatus") String anticlimbingstatus,@RequestParam("conductorstatus") String conductorstatus,@RequestParam("jumperstatus")
	// 		String jumperstatus,@RequestParam("earthconductorstatus") String earthconductorstatus,@RequestParam("attentionstatus") String attentionstatus,@RequestParam("fungussetno") String fungussetno,
	// 		@RequestParam("wpinset") String wpinset,@RequestParam("endfittingset") String endfittingset,@RequestParam("towerspecial") String towerspecial,@RequestParam("ludt") String ludt,@RequestParam("maintenancedate") String maintenancedate,@PathVariable("status") String status,@RequestParam("approvalLevel") String approvalLevel,@RequestParam("hotpossible") String hotpossible,@RequestParam("legPainting") String legPainting) {


     	  //alert('hiiiii456' +url);
    	   
            $.ajax({
            	type: "GET",
                url : url,
                success : function(response) {
                    alert("Tower Maintence updated succesfully...");
                    console.log(response);
                    window.location.reload();
                    disable(id);
                } 
         });
    
			
		}
        
	
	function ConfirmActivate(comid) {

		alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				alert(response);

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
						var slctSubcat = $('#line'), option = "<option value='-1'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].id + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
	
	 function sendForValidation()
	    {
	       
			var province = $( '#province' ).find( ":selected" ).attr( "value" );	
	        var area = $( '#area' ).find( ":selected" ).attr( "value" );
			var line = $( '#line' ).find( ":selected" ).attr( "value" );
			var conceptCycleValue = $('#cycle').find(":selected").attr("value");
			
			//alert("cycle: " + conceptCycleValue + "province: " + province + ",  area: " + area + "  ,line: " + line);
			
	        var url = "/MMS/updateTMStatus/" + province + "/" + area + "/" + line +"/" + conceptCycleValue +"/";

			//alert("url :"+url );
	        $.ajax( {
	            type: "GET",
	            url: url,
	            data : {},
				contentType : "application/json; charset=utf-8",
				success: function(data)
	            {
	                alert( "Succesfully approved" );
	                console.log( data );
	                window.location.reload();
	                //disable( id );
	            }
	        } );
	        alert("Tower Maintenance succesfully approved...");
	    }

	
	 function sendNotification()
	    {
	       
			var province = $( '#province' ).find( ":selected" ).attr( "value" );	
	        var area = $( '#area' ).find( ":selected" ).attr( "value" );
			var line = $( '#line' ).find( ":selected" ).attr( "value" );
			var conceptCycleValue = $('#cycle').find(":selected").attr("value");
			
			//alert("cycle: " + conceptCycleValue + "province: " + province + ",  area: " + area + "  ,line: " + line);
			
	        var url = "/MMS/sendNotification/" + province + "/" + area + "/" + line +"/" + conceptCycleValue +"/";

			//alert("url :"+url );
	        $.ajax( {
	            type: "GET",
	            url: url,
	            data : {},
				contentType : "application/json; charset=utf-8",
				success: function(data)
	            {
	                alert("Email-SMS is succesfully sent to relevent Area Engineer " );
	                console.log( data );
	                //window.location.reload();
	                //disable( id );
	            }
	        } );
	        //alert("Tower Maintenance succesfully approved...");
	    }

	 function getImage(id){
			//var id = $('#support').find(":selected").attr("value");
var conceptCycleValue = $('#cycle').find(":selected").attr("value");
			var name = conceptCycleValue+'-'+id;
			
			    var img = document.getElementById("y");
			    img.src = 'viewSupportImage?id='+id+'&cycle='+conceptCycleValue;
			    img.width = 800;
			    img.height = 500;
			    img.alt = 'Support Image';
			    var div = document.getElementById("x");
			    
			    div.appendChild(img);
			
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
									<li class="active"><span>Edit Tower Maintenance </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								
								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="editTMnewS"
													modelAttribute="model">
													<input type="hidden" name="mode" value="${model.mode}" />
													
													<c:if test="${not empty model.error}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${model.error}"></c:out>
									</div>
								
						</tr>	
						</c:if>
													<%-- <c:out value="${model.mode}"></c:out>
													 --%><table class="table table-responsive" id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left">Province</td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()" 
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
															</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left">Area</td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()" 
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left">Line</td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange="" 
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">

																	<form:option value="-1" label="ALL" />
																	<form:options items="${model.lineListLong}" />
																</form:select></td>
														</tr>
														
														<tr>
														
														<td width="30%" style="text-align: left">Cycle</td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
														
														
														
														
														
														<%-- <tr>
														
														
														<td width="30%" style="text-align: left"><form:label
																	path="">CYCLE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycle" onchange="">
																	<option value="201801"> 201801 </option>
													<option value="201802"> 201802 </option>
													<option value="201901"> 201901 </option>
													<option value="201902"> 201902 </option>
													<option value="202001"> 202001 </option>
													<option value="202002"> 202002 </option>

																	
																</form:select></td>
														</tr> --%>
												
																										
															<!--	<td width="30%" style="text-align:left">
                												<form:label path="">LINE TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																     </td>  
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CONDUCTOR TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td> 
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CIRCUIT TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																    </td> 
        														</tr>
        														<tr>
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
														<td style="text-align: left"><a
																href="">
																<input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="GO"></input>
																
														 <%-- <c:choose>
                                                                    <c:when test="${model.mode=='S'}">
                                                                        <input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="GO"></input>

                                                                    </c:when>
                                                                    <c:when test="${model.mode=='A'}">
                                                                    <c:if test="${sessionScope.loggedUserRole=='DEO'}">
                                                                        <input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="Send All for Validation"></input></c:if>
																	<c:if test="${sessionScope.loggedUserRole=='ES'}">
                                                                        <input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="Send All for Validation"></input></c:if>
																	<c:if test="${sessionScope.loggedUserRole=='EE'}">
                                                                        <input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="Approve"></input>
																	</c:if>
																	
																	</c:when>
                                                                    <c:otherwise>

                                                                    </c:otherwise>
                                                                </c:choose>
 --%>														
														</a>
														</td>
														
														
														
														
															<%-- <td style="text-align: left"><a
																href=""> 
																<c:if test="${model.mode=='S'}"><input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="GO"></input></a>
																</c:if>
															 --%>	
													
														</tr>
														
													</table>
													
													
													
													
                                                        <div id="table-scroll" class="table-scroll"> 
                                                        <table class="main-table" id="tblAdmin">

                                                            <thead>
                                                                <tr>
                                                                <th class="text-center">Tower No</th>
                                                                <th>Image</th>
                                                             
                                                             <th class="text-center">Cycle No</th>
															
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
															<!-- <th class="text-center">LUTD</th>
															 --><th class="text-center">Inspected Date</th>
															<th class="text-center">Hot Possible</th>
															<th class="text-center">Leg Painting</th>
															<th class="text-center">Tappings</th>
															<th class="text-center">No Of Pinpoles 1 </th>
															<th class="text-center">Switching Device 1</th>
															<th class="text-center">No Of Pinpoles 2 </th>
															<th class="text-center">Switching Device 2</th>
															<th class="text-center">No Of Pinpoles 3 </th>
															<th class="text-center">Switching Device 3</th>
															
															<th class="text-center">Status</th>
															<th class="text-center">Approval Level</th>
 															<th class="text-center">Edit</th>
                                                            <th class="text-center">Save</th>

                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                            <c:set var="count" value="0" scope="page" />
															
											           <c:forEach var="mmsTxtMnt" items="${model.mmsTxtMntList}"  varStatus="status">
														<tr>
														  <%-- <td  style="text-align:center"   >${status.count}</td> --%>
														   	
														 		
														  <th><input type="text" name = "hotLineMnt" id="hotLineMnt_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.hotLineMnt}" class="form-control" disabled></th>
														  <c:if test="${mmsTxtMnt.flashoversetno != null}">
  														  <td><button type ='button' class='btn' title='View Image' onClick='getImage("${mmsTxtMnt.id.towerid}")'>View</button>
														  </td>
														  </c:if>
														  	
															<c:if test="${mmsTxtMnt.flashoversetno == null}">
  														  <td><button type ='button' class='btn' title='No Image' onClick='getImage("${mmsTxtMnt.id.towerid}")'>No Image</button>
														  </td>
														  </c:if>
														
														    <td><input type="text" name = "" id="cycleno_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.id.visitid}" class="form-control" disabled></td>
														    
															<td><input type="number" id="noofmissingparts_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.noofmissingparts}" class="form-control" disabled></td>
                                                            <td><input type="number" id="nofflashoversets_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.nofflashoversets}" class="form-control" disabled></td>
                                                            <td><input type="text" id="wayleavestatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.wayleavestatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="baseconcretestatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.baseconcretestatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="anticlimbingstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.anticlimbingstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="conductorstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.conductorstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="jumperstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.jumperstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="earthconductorstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.earthconductorstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="attentionstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.attentionstatus}" class="form-control" disabled></td>
                                                            <td><input type="number" id="fungussetno_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.fungussetno}" class="form-control" disabled></td>
                                                            <td><input type="number" id="wpinset_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.wpinset}" class="form-control" disabled></td>
                                                            <td><input type="number" id="endfittingset_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.endfittingset}" class="form-control" disabled></td>
                                                            <td><input type="text" id="towerspecial_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.towerspecial}" class="form-control" disabled></td>
                                                           <%--  <td><input type="text" id="ludt_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.ludt}" class="form-control" disabled></td>
                                                            --%> <td><input type="text" id="maintenancedate_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.insDate}" class="form-control" disabled></td>
														<%-- <td><input type="number" id="hotpossible_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.hotpossible}" class="form-control" disabled></td>
														 --%><td><select id="hotpossible_${mmsTxtMnt.id.towerid}" class="form-control"  disabled>
                                                                                <c:choose>
                                                                                <c:when test="${mmsTxtMnt.hotpossible==1}">
                                                                                        <option value="${mmsTxtMnt.hotpossible}" selected="selected">Possible</option>
                                                                                             <option value="0">Impossible</option>
                                                                                    </c:when>
                                                                                
                                                                                <c:otherwise>
                                                                                       <option value="${mmsTxtMnt.hotpossible}" selected="selected">Impossible</option>
                                                                                             <option value="1">Possible</option>
                                                                                        
                                                                                    </c:otherwise>
                                                                                
                                                                                
                                                                                
                                                                                
                                                               </c:choose>
                                                                                
                                                                                <%-- <option value="${mmsTxtMnt.hotpossible}" selected="selected">${mmsTxtMnt.hotpossible}</option>
                                                                                <option value="1">Possible</option>
                                                                                <option value="0">Impossible</option> --%>
                                                                            </select>
                                                            </td>
                                                             <td><select id="legpainting_${mmsTxtMnt.id.towerid}" class="form-control"  disabled>
                                                                                <c:choose>
                                                                                <c:when test="${mmsTxtMnt.legPainting=='Yes'}">
                                                                                        <option value="${mmsTxtMnt.legPainting}" selected="selected">Yes</option>
                                                                                             <option value="No">No</option>
                                                                                             
                                                                                    </c:when>
                                                                                
                                                                                <c:otherwise>
                                                                                       <option value="${mmsTxtMnt.legPainting}" selected="selected">No</option>
                                                                                             <option value="Yes">Yes</option>
                                                                                        
                                                                                    </c:otherwise>
                                                                                
                                                                                
                                                                                
                                                                                
                                                               </c:choose>
                                                                                
                                                                                <%-- <option value="${mmsTxtMnt.hotpossible}" selected="selected">${mmsTxtMnt.hotpossible}</option>
                                                                                <option value="1">Possible</option>
                                                                                <option value="0">Impossible</option> --%>
                                                                            </select>
                                                            </td>
														 
                                                            
                                                            <td><input type="number" id="nooftappings_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.nooftappings}" class="form-control" disabled></td>
														    
													
														   <td><input type="number" id="pinpole1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole1}" class="form-control" disabled></td>
														   
														   		
														   <td><input type="text" id="switchdev1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev1}" class="form-control" disabled></td>
                                                           <td><input type="number" id="pinpole2_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole2}" class="form-control" disabled></td>
                                                           <td><input type="text" id="switchdev2_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev2}" class="form-control" disabled></td>
                                                       		<td><input type="number" id="pinpole3_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole3}" class="form-control" disabled></td>
                                                            <td><input type="text" id="switchdev3_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev3}" class="form-control" disabled></td>
                                                      
														  <td><select id="status_${mmsTxtMnt.id.towerid}" class="form-control" disabled>
											                   <c:choose>
                                                                                    <c:when test="${sessionScope.loggedUserRole=='DEO'}">
                                                                                        <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">In Bulk</option>
                                                                                             <option value="3">Send for Validation</option>
                                                                                             <option value="0">Inactive</option>
											                			
                                                                                    </c:when>

                                                                                    <c:when test="${sessionScope.loggedUserRole=='ES'}">
                                                                                        <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">Pending</option>
                                                                                             <option value="4">Send for Approval</option>
                                                                                             <option value="0">Inactive</option>
											                			
                                                                                    </c:when>

                                                                                    <c:when test="${sessionScope.loggedUserRole=='EE'}">
                                                                                          <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">Pending</option>
                                                                                             <option value="1">Approve</option>
                                                                                             <option value="0">Inactive</option>
											                								<option value="2">Keep in Bulk</option>
                                                                                    </c:when>


                                                                                    <c:otherwise>
                                                                                        <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">Not Allowed</option>
                                                                                      
                                                                                    </c:otherwise>

                                                                                </c:choose>
											                </select ></td>  
											                <%-- <td><input type="text" id="approvalLevel_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.approvalLevel}" class="form-control" disabled></td> --%>
											            <td><select id="approvalLevel_${mmsTxtMnt.id.towerid}" class="form-control"
                                                                                disabled>
                                                                                <option value="${mmsTxtMnt.approvalLevel}" selected="selected">${mmsTxtMnt.approvalLevel}</option>
                                                                                <option value="60041ES1">60041ES1</option>
                                                                                <option value="60041ES2">60041ES2</option>
                                                                            </select>
                                                                        </td>
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
														
														  <td><button type='button' class='btn btn-warning' onClick='LoadLineToEdit("${mmsTxtMnt.id.towerid}")'>Edit</button></td>  
														
														
											                 <td><button type='button' class='btn btn-success' onClick='javascript:save("${mmsTxtMnt.id.towerid}")'>Save</button></td> 
														
														</tr>
														
												 </c:forEach>
													</tbody>
													
													
													  </table>
													  </div>
													  
													  
													  
													<tr>
<!-- edited anushka 2019-01-08--------------------------------------------------------------------------------------- -->
														<td>
															<button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${model.stringOfMaintenance}")'>Edit
																All</button>
														</td>

														<td>
															<button type='button' class='btn btn-success' onClick='javascript:saveAll()'>Update All</button>
														</td>
														
														</form:form>
												
														
														
														
														<!-- ------
                                                            <td colspan="2">
                                                                <c:if test="${userType =='DEO'}">

                                                                </c:if> <input type="hidden" name="actionButton" value="" />
                                                                <c:choose>
                                                                    <c:when test="${sessionScope.loggedUserRole=='DEO'}">
                                                                        <input id="pivFormBtn" class="btn btn-success"
                                                                            type="submit" name="actionButton" value="Send For Validation" onclick="sendForValidation()"></input>

                                                                    </c:when>
                                                                    <c:when test="${sessionScope.loggedUserRole=='EE'}">
                                                                        <input id="pivFormBtn" class="btn btn-success"
                                                                            type="submit" name="actionButton" value="Approve" onclick="sendForValidation()"></input>

                                                                    </c:when>
                                                                    <c:when test="${sessionScope.loggedUserRole=='ES'}">
                                                                        <input id="pivFormBtn" class="btn btn-success"
                                                                            type="submit" name="actionButton" value="Send For Approval" onclick="sendForValidation()"></input>

                                                                    </c:when>
                                                                    <c:otherwise>

                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                        </tr>
                                                        <!-- edited 2 anushka close 2018-11-30 -->
													 <td colspan="2"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton"
																		value="Send All for Validation"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton" value="Approve"
																		onclick="sendForValidation()"></input>
																		<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton" value="Send Notification"
																		onclick="sendNotification()"></input>
																		

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton"
																		value="Send All for Approval"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
 												<%-- <td width="30%" style="text-align: left"><strong>APPROVAL USER</strong></td>
															<td width="70%" style="text-align: left"><form:select
																	id="userId" path="sauserm.userId" onchange="" style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	<form:options items="${model.saList}" />
																</form:select></td>
												 --%>		
 												
												
											</tbody>
										</table>
										<div id = "x" class="row">
					<img id ="y">
                    </div> 
									</div>

								</div>
							</div>
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