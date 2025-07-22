<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	var j = jQuery.noConflict();
    j( function() {
        j("#txtDateAR").datepicker();
    } );
    j( function() {
        j("#txtCDateAR").datepicker();
    } );
    j( function() {
        j("#txtDateAR1").datepicker();
    } );
    j( function() {
        j("#txtCDateAR1").datepicker();
    } );
    j( function() {
        j("#txtDateLBS").datepicker();
    } );
    j( function() {
        j("#txtCDateLBS").datepicker();
    } );
    j( function() {
        j("#txtDateLBS1").datepicker();
    } );
    j( function() {
        j("#txtCDateLBS1").datepicker();
    } );
    j( function() {
        j("#txtDateABS").datepicker();
    } );
    j( function() {
        j("#txtCDateABS").datepicker();
    } );
	</script>
	
<style>
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
	
<script type="text/javascript">
	
function getLineAR() {
		
		var strUser = cmbSelectAreaAR.options[cmbSelectAreaAR.selectedIndex].value;
		

		$.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#cmbSelectLineIdAR'), option = "<option value='NONE'>LINE</option>";
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
	
function getLineLBS() {
	
	var strUser = cmbSelectAreaLBS.options[cmbSelectAreaLBS.selectedIndex].value;
	

	$.ajax({
				type : 'GET',
				url : "/MMS/findLineByArea/" + strUser + "/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#cmbSelectLineIdLBS'), option = "<option value='NONE'>LINE</option>";
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
function getLineABS() {
	
	var strUser = cmbSelectAreaABS.options[cmbSelectAreaABS.selectedIndex].value;
	

	$.ajax({
				type : 'GET',
				url : "/MMS/findLineByArea/" + strUser + "/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#cmbSelectLineIdABS'), option = "<option value='NONE'>LINE</option>";
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
function getLineDDLO() {
	
	var strUser = cmbSelectAreaDDLO.options[cmbSelectAreaDDLO.selectedIndex].value;
	

	$.ajax({
				type : 'GET',
				url : "/MMS/findLineByArea/" + strUser + "/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#cmbSelectLineIdDDLO'), option = "<option value='NONE'>LINE</option>";
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
	
	
function getCSC()

{			
		
	var strUser = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
	//alert(strUser);	
	   $.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findAllCSCByArea/" + strUser + "/",
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(response) 
                 {   //alert("success");
                	 $('#cmbSelectCSC').empty();
                     //Insert item from the response
                     for (var i = 0; i < response.length; i++) {
                         var item = response[i];
                         $('#cmbSelectCSC').append($('<option>').text(item.deptNm).attr('value', item.deptId));
                     }
                 }
          });		
	 
	
}
	
	
	  
	
		
		
        function findAreaAR() {
     		
     		var strUser = cmbSelectProvinceAR.options[cmbSelectProvinceAR.selectedIndex].value;
     		

     		$.ajax({
     					type : 'GET',
     					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						var slctSubcat = $('#cmbSelectAreaAR'), option = "<option value='NONE'>AREA</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < data.length; i++) {
     							option = option
     									+ "<option value='"+data[i].deptId + "'>"
     									+ data[i].deptNm + "</option>";
     						}
     						slctSubcat.append(option);

     						
     					}
     				});

     	}
 function findAreaLBS() {
     		
     		var strUser = cmbSelectProvinceLBS.options[cmbSelectProvinceLBS.selectedIndex].value;
     		

     		$.ajax({
     					type : 'GET',
     					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						var slctSubcat = $('#cmbSelectAreaLBS'), option = "<option value='NONE'>AREA</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < data.length; i++) {
     							option = option
     									+ "<option value='"+data[i].deptId + "'>"
     									+ data[i].deptNm + "</option>";
     						}
     						slctSubcat.append(option);

     						
     					}
     				});

     	} function findAreaABS() {
     		
     		var strUser = cmbSelectProvinceABS.options[cmbSelectProvinceABS.selectedIndex].value;
     		

     		$.ajax({
     					type : 'GET',
     					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						var slctSubcat = $('#cmbSelectAreaABS'), option = "<option value='NONE'>AREA</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < data.length; i++) {
     							option = option
     									+ "<option value='"+data[i].deptId + "'>"
     									+ data[i].deptNm + "</option>";
     						}
     						slctSubcat.append(option);

     						
     					}
     				});

     	} function findAreaDDLO() {
     		
     		var strUser = cmbSelectProvinceDDLO.options[cmbSelectProvinceDDLO.selectedIndex].value;
     		

     		$.ajax({
     					type : 'GET',
     					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						var slctSubcat = $('#cmbSelectAreaDDLO'), option = "<option value='NONE'>AREA</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < data.length; i++) {
     							option = option
     									+ "<option value='"+data[i].deptId + "'>"
     									+ data[i].deptNm + "</option>";
     						}
     						slctSubcat.append(option);

     						
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
 	                         //Insert item from the response
 	                         for (var i = 0; i < response.length; i++) {
 	                             var item = response[i];
 	                             $('#cmbSelectConductorType').append($('<option>').text(item.type).attr('value', item.id));
 	                         }
 	                        
 	                     }
 	              });		
 		}
         
         function getGantryByAreaLineAR()
  		
      	{			
      	var strArea = cmbSelectAreaAR.options[cmbSelectAreaAR.selectedIndex].value;
      	var strLine = cmbSelectLineIdAR.options[cmbSelectLineIdAR.selectedIndex].value;
      				
      			   $.ajax
      	             ({
      	                     type: 'GET',
      	                     url: "/MMS/findGantryByAreaLine/"+strArea+"/"+strLine+"/",
      	                     data: {},
      	                     contentType: "application/json; charset=utf-8",
      	                     success: function(response) 
      	                     {   
     	                         var slctSubcat = $('#cmbSelectGantryAR'), option = "<option value='NONE'>GANTRY</option>";
     	     						slctSubcat.empty();
     	     						for (var i = 0; i < response.length; i++) {
     		                         var item = response[i];
     	     							option = option
     	     									+ "<option value='"+item.id + "'>"
     	     									+ item.code + "</option>";
     	     						}
     	     						slctSubcat.append(option);
     	                         
     	                     }
      	              });		
      			 
      			
      		}
     		
     function getGantryByAreaLineLBS()

     {			
     		
     		
     	var strArea = cmbSelectAreaLBS.options[cmbSelectAreaLBS.selectedIndex].value;
      	var strLine = cmbSelectLineIdLBS.options[cmbSelectLineIdLBS.selectedIndex].value;
      				
      			   $.ajax
      	             ({
      	                     type: 'GET',
      	                     url: "/MMS/findGantryByAreaLine/"+strArea+"/"+strLine+"/",
      	                     data: {},
      	                     contentType: "application/json; charset=utf-8",
      	                     success: function(response) 
      	                     {   
     	                         var slctSubcat = $('#cmbSelectGantryLBS'), option = "<option value='NONE'>GANTRY</option>";
     	     						slctSubcat.empty();
     	     						for (var i = 0; i < response.length; i++) {
     		                         var item = response[i];
     	     							option = option
     	     									+ "<option value='"+item.id + "'>"
     	     									+ item.code + "</option>";
     	     						}
     	     						slctSubcat.append(option);
     	                         
     	                     }
      	              });	
     	 
     	
     }
     function getGantryByAreaLineABS()

     {			
     		
     		
     	var strArea = cmbSelectAreaABS.options[cmbSelectAreaABS.selectedIndex].value;
      	var strLine = cmbSelectLineIdABS.options[cmbSelectLineIdABS.selectedIndex].value;
      				
      			   $.ajax
      	             ({
      	                     type: 'GET',
      	                     url: "/MMS/findGantryByAreaLine/"+strArea+"/"+strLine+"/",
      	                     data: {},
      	                     contentType: "application/json; charset=utf-8",
      	                     success: function(response) 
      	                     {   
     	                         var slctSubcat = $('#cmbSelectGantryABS'), option = "<option value='NONE'>GANTRY</option>";
     	     						slctSubcat.empty();
     	     						for (var i = 0; i < response.length; i++) {
     		                         var item = response[i];
     	     							option = option
     	     									+ "<option value='"+item.id + "'>"
     	     									+ item.code + "</option>";
     	     						}
     	     						slctSubcat.append(option);
     	                         
     	                     }
      	              });		
     	 
     	
     }
     function getGantryByAreaLineDDLO()

     {			
     		
     		
     	var strArea = cmbSelectAreaDDLO.options[cmbSelectAreaDDLO.selectedIndex].value;
      	var strLine = cmbSelectLineIdDDLO.options[cmbSelectLineIdDDLO.selectedIndex].value;
      				
      			   $.ajax
      	             ({
      	                     type: 'GET',
      	                     url: "/MMS/findGantryByAreaLine/"+strArea+"/"+strLine+"/",
      	                     data: {},
      	                     contentType: "application/json; charset=utf-8",
      	                     success: function(response) 
      	                     {   
     	                         var slctSubcat = $('#cmbSelectGantryDDLO'), option = "<option value='NONE'>GANTRY</option>";
     	     						slctSubcat.empty();
     	     						for (var i = 0; i < response.length; i++) {
     		                         var item = response[i];
     	     							option = option
     	     									+ "<option value='"+item.id + "'>"
     	     									+ item.code + "</option>";
     	     						}
     	     						slctSubcat.append(option);
     	                         
     	                     }
      	              });		
     	 
     	
     }

     function getFeederByGantryIdAR()

     {			
     var strGantry = cmbSelectGantryAR.options[cmbSelectGantryAR.selectedIndex].value;
     //alert(strGantry);
     		
     	   $.ajax
              ({
                      type: 'GET',
                      url: "/MMS/findFeederByGantryId/"+strGantry+"/",
                      data: {},
                      contentType: "application/json; charset=utf-8",
                      success: function(response) 
                       {   
                          var slctSubcat = $('#cmbSelectFeederAR'), option = "<option value='NONE'>FEEDER</option>";
      						slctSubcat.empty();
      						for (var i = 0; i < response.length; i++) {
                              var item = response[i];
      							option = option
      									+ "<option value='"+item.id.feederId + "'>"
      									+ item.code + "</option>";
      						}
      						slctSubcat.append(option);
                          
                      }
               });		
     	 
     	
     }

     function getFeederByGantryIdLBS()

     {			
     var strGantry = cmbSelectGantryLBS.options[cmbSelectGantryLBS.selectedIndex].value;
     //alert(strGantry);
     		
     	   $.ajax
              ({
                      type: 'GET',
                      url: "/MMS/findFeederByGantryId/"+strGantry+"/",
                      data: {},
                      contentType: "application/json; charset=utf-8",
                      success: function(response) 
                       {   
                          var slctSubcat = $('#cmbSelectFeederLBS'), option = "<option value='NONE'>FEEDER</option>";
      						slctSubcat.empty();
      						for (var i = 0; i < response.length; i++) {
                              var item = response[i];
      							option = option
      									+ "<option value='"+item.id.feederId + "'>"
      									+ item.code + "</option>";
      						}
      						slctSubcat.append(option);
                          
                      }
               });		
     	 
     	
     }
     function getFeederByGantryIdABS()

     {			
     var strGantry = cmbSelectGantryABS.options[cmbSelectGantryABS.selectedIndex].value;
     //alert(strGantry);
     		
     	   $.ajax
              ({
                      type: 'GET',
                      url: "/MMS/findFeederByGantryId/"+strGantry+"/",
                      data: {},
                      contentType: "application/json; charset=utf-8",
                      success: function(response) 
                       {   
                          var slctSubcat = $('#cmbSelectFeederABS'), option = "<option value='NONE'>FEEDER</option>";
      						slctSubcat.empty();
      						for (var i = 0; i < response.length; i++) {
                              var item = response[i];
      							option = option
      									+ "<option value='"+item.id.feederId + "'>"
      									+ item.code + "</option>";
      						}
      						slctSubcat.append(option);
                          
                      }
               });		
     	 
     	
     }
     function getFeederByGantryIdDDLO()

     {			
     var strGantry = cmbSelectGantryDDLO.options[cmbSelectGantryDDLO.selectedIndex].value;
     //alert(strGantry);
     		
     	   $.ajax
              ({
                      type: 'GET',
                      url: "/MMS/findFeederByGantryId/"+strGantry+"/",
                      data: {},
                      contentType: "application/json; charset=utf-8",
                      success: function(response) 
                       {   
                          var slctSubcat = $('#cmbSelectFeederDDLO'), option = "<option value='NONE'>FEEDER</option>";
      						slctSubcat.empty();
      						for (var i = 0; i < response.length; i++) {
                              var item = response[i];
      							option = option
      									+ "<option value='"+item.id.feederId + "'>"
      									+ item.code + "</option>";
      						}
      						slctSubcat.append(option);
                          
                      }
               });		
     	 
     	
     }

function setType()

{   //alert("sdsd"); 
	document.getElementById("hiddenswitchType").value = 1;
	document.getElementById("hiddenswitchTypeLBS").value = 2;
	document.getElementById("hiddenswitchTypeABS").value = 3;
	document.getElementById("hiddenswitchTypeDDLO").value = 4;
	
}


function getSwitchByFeederIdAR(){
	var strFeeder = cmbSelectFeederAR.options[cmbSelectFeederAR.selectedIndex].value;
	var strType = 1;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findSwitchByFeederId/"+strFeeder+"/"+strType+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
                         var slctSubcat = $('#cmbSelectSwitchAR'), option = "<option value='NONE'>SWITCH</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < response.length; i++) {
                             var item = response[i];
     							option = option
     									+ "<option value='"+item.id.switchId + "'>"
     									+ item.switchName + "</option>";
     						}
     						slctSubcat.append(option);
                         
                     }
	          });	
		   }
		   
function getSwitchByFeederIdLBS(){
	var strFeeder = cmbSelectFeederLBS.options[cmbSelectFeederLBS.selectedIndex].value;
	var strType = 2;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findSwitchByFeederId/"+strFeeder+"/"+strType+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
                         var slctSubcat = $('#cmbSelectSwitchLBS'), option = "<option value='NONE'>SWITCH</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < response.length; i++) {
                             var item = response[i];
     							option = option
     									+ "<option value='"+item.id.switchId + "'>"
     									+ item.switchName + "</option>";
     						}
     						slctSubcat.append(option);
                         
                     }
	          });	
}
function getSwitchByFeederIdABS(){
	var strFeeder = cmbSelectFeederABS.options[cmbSelectFeederABS.selectedIndex].value;
	var strType = 3;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findSwitchByFeederId/"+strFeeder+"/"+strType+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                  {   
                         var slctSubcat = $('#cmbSelectSwitchABS'), option = "<option value='NONE'>SWITCH</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < response.length; i++) {
                             var item = response[i];
     							option = option
     									+ "<option value='"+item.id.switchId + "'>"
     									+ item.switchName + "</option>";
     						}
     						slctSubcat.append(option);
                         
                     }
	          });	
}

function getSwitchByFeederIdDDLO(){
	var strFeeder = cmbSelectFeederDDLO.options[cmbSelectFeederDDLO.selectedIndex].value;
	var strType = 4;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findSwitchByFeederId/"+strFeeder+"/"+strType+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                  {   
                         var slctSubcat = $('#cmbSelectSwitchDDLO'), option = "<option value='NONE'>SWITCH</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < response.length; i++) {
                             var item = response[i];
     							option = option
     									+ "<option value='"+item.id.switchId + "'>"
     									+ item.switchName + "</option>";
     						}
     						slctSubcat.append(option);
                         
                     }
	          });	
}

function loadARData(){
	var strSwitch = cmbSelectSwitchAR.options[cmbSelectSwitchAR.selectedIndex].value;
	//alert(strSwitch);
	 $.ajax
     ({
             type: 'GET',
             url: "/MMS/getSwitch/"+strSwitch+"/",
             data: {},
             contentType: "application/json; charset=utf-8",
             success: function(response) 
             {
                 //Insert item from the response
                 for (var i = 0; i < response.length; i++) {
                     var item = response[i];
                     
                     document.getElementById("txtCodeAR").value = item.switchCode;
                     document.getElementById("txtNameAR").value = item.switchName;
                     document.getElementById("cmbSelectMountingAR").value = item.mounting;
                     document.getElementById("cmbSelectBrandNameAR").value = item.brandName;
                     document.getElementById("txtDateAR").value = dateconvert(item.cpDateManufature);
                     document.getElementById("txtCDateAR").value = dateconvert(item.cpDateCommitioning);
                     document.getElementById("txtModelNumberAR").value = item.cpModelNumber;
                     document.getElementById("txtSerialnumberAR").value = item.cpSerialNo;
                     document.getElementById("txtBatteryCapacityAR").value = item.cpBatteryCapacity;
                     document.getElementById("txtNoofbatteriesAR").value = item.cpNoOfBatteries;
                     document.getElementById("cmbSelectRemoteoperationAR").value = item.cpRemoteOperation;
                     document.getElementById("cmbSelectArrangementAR").value = item.sgArrangement;
                     document.getElementById("txtDateAR1").value = dateconvert(item.sgDateManufature);
                     document.getElementById("txtCDateAR1").value = dateconvert(item.sgDateCommitioning);
                     document.getElementById("txtModelNumberAR1").value = item.sgModelNumber;
                     document.getElementById("txtSerialnumberAR1").value = item.sgSerialNo;
                     document.getElementById("txtRatingAR").value = item.sgRating;
                     document.getElementById("txtSCClevelofequipmentAR").value = item.sgSccLevelOfEquipment;
                     document.getElementById("cmbSelectInsulationmediumAR").value = item.sgInsulationMedium;
                     
                 }
             }
      });
	
	
	
	
}


function dateconvert(date)
{   // alert(date);
	 var str = date;
     var array = str.split("-");
     var mm =array[1];
     var dd =array[2];
     var yy =array[0];
     var cdate = mm+"/"+dd+"/"+yy;
     //alert(cdate);
     return cdate;
	
}

function loadLBSData(){
	var strSwitch = cmbSelectSwitchLBS.options[cmbSelectSwitchLBS.selectedIndex].value;
	
	 $.ajax
     ({
             type: 'GET',
             url: "/MMS/getSwitch/"+strSwitch+"/",
             data: {},
             contentType: "application/json; charset=utf-8",
             success: function(response) 
             {
                 //Insert item from the response
                 for (var i = 0; i < response.length; i++) {
                     var item = response[i];
                     document.getElementById("txtCodeLBS").value = item.switchCode;
                     document.getElementById("txtNameLBS").value = item.switchName;
                     document.getElementById("cmbSelectMountingLBS").value = item.mounting;
                     document.getElementById("cmbSelectBrandNameLBS").value = item.brandName;
                     document.getElementById("txtDateLBS").value = dateconvert(item.cpDateManufature);
                     document.getElementById("txtCDateLBS").value = dateconvert(item.cpDateCommitioning);
                     document.getElementById("txtModelNumberLBS").value = item.cpModelNumber;
                     document.getElementById("txtSerialnumberLBS").value = item.cpSerialNo;
                     document.getElementById("txtBatteryCapacityLBS").value = item.cpBatteryCapacity;
                     document.getElementById("txtNoofbatteriesLBS").value = item.cpNoOfBatteries;
                     document.getElementById("cmbSelectRemoteoperationLBS").value = item.cpRemoteOperation;
                     document.getElementById("cmbSelectArrangementLBS").value = item.sgArrangement;
                     document.getElementById("txtDateLBS1").value = dateconvert(item.sgDateManufature);
                     document.getElementById("txtCDateLBS1").value = dateconvert(item.sgDateCommitioning);
                     document.getElementById("txtModelNumberLBS1").value = item.sgModelNumber;
                     document.getElementById("txtSerialnumberLBS1").value = item.sgSerialNo;
                     document.getElementById("txtRatingLBS").value = item.sgRating;
                     document.getElementById("txtSCClevelofequipmentLBS").value = item.sgSccLevelOfEquipment;
                     document.getElementById("cmbSelectInsulationmediumLBS").value = item.sgInsulationMedium;
                     
                 }
             }
      });
	
	
	
	
}
function loadABSData(){
	var strSwitch = cmbSelectSwitchABS.options[cmbSelectSwitchABS.selectedIndex].value;

	 $.ajax
     ({
             type: 'GET',
             url: "/MMS/getSwitch/"+strSwitch+"/",
             data: {},
             contentType: "application/json; charset=utf-8",
             success: function(response) 
             {
                 //Insert item from the response
                 for (var i = 0; i < response.length; i++) {
                     var item = response[i];
                     document.getElementById("txtCodeABS").value = item.switchCode;
                     document.getElementById("txtNameABS").value = item.switchName;
                     document.getElementById("cmbSelectBrandNameABS").value = item.brandName;
                     document.getElementById("txtDateABS").value = dateconvert(item.cpDateManufature);
                     document.getElementById("txtCDateABS").value = dateconvert(item.cpDateCommitioning);
                     document.getElementById("txtModelNumberABS").value = item.cpModelNumber;
                     document.getElementById("txtSerialnumberABS").value = item.cpSerialNo;
                     document.getElementById("cmbSelectoperationdirectionABS").value = item.operationDirection;
                     document.getElementById("cmbSelectpositionABS").value = item.position;
                     document.getElementById("txtRatingABS").value = item.sgRating;
                     document.getElementById("txtSCClevelofequipmentABS").value = item.sgSccLevelOfEquipment;
             
                     
                 }
             }
      });
	
	
	
	
}

function loadDDLOData(){
	var strSwitch = cmbSelectSwitchDDLO.options[cmbSelectSwitchDDLO.selectedIndex].value;
   // alert(strSwitch);
	 $.ajax
     ({
             type: 'GET',
             url: "/MMS/getSwitch/"+strSwitch+"/",
             data: {},
             contentType: "application/json; charset=utf-8",
             success: function(response) 
             {
                 //Insert item from the response
                 for (var i = 0; i < response.length; i++) {
                     var item = response[i];
                     document.getElementById("txtCodeDDLO").value = item.switchCode;
                     document.getElementById("txtNameDDLO").value = item.switchName;
                     document.getElementById("cmbSelectPositionDDLO").value = item.position;
                     document.getElementById("txtQuantityDDLO").value = item.quantity;
                     document.getElementById("cmbSelectcarriertypeDDLO").value = item.carrierType;
                     document.getElementById("txtRatingDDLO").value = item.sgRating;
                     
                 }
             }
      });
	
	
	
	
}

function getGantryByAreaAR(){
	
	var strArea = cmbSelectAreaAR.options[cmbSelectAreaAR.selectedIndex].value;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findGantryByArea/"+strArea+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
	                     var slctSubcat = $('#cmbSelectGantryAR'), option = "<option value='NONE'>GANTRY</option>";
	 						slctSubcat.empty();
	 						for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	 							option = option
	 									+ "<option value='"+item.id + "'>"
	 									+ item.code + "</option>";
	 						}
	 						slctSubcat.append(option);
	                     
	                 }
	          });		
		 
		
	}
	
function getGantryByAreaLBS(){
	
	var strArea = cmbSelectAreaLBS.options[cmbSelectAreaLBS.selectedIndex].value;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findGantryByArea/"+strArea+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
	                     var slctSubcat = $('#cmbSelectGantryLBS'), option = "<option value='NONE'>GANTRY</option>";
	 						slctSubcat.empty();
	 						for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	 							option = option
	 									+ "<option value='"+item.id + "'>"
	 									+ item.code + "</option>";
	 						}
	 						slctSubcat.append(option);
	                     
	                 }
	          });		
		 
		
	}
	
function getGantryByAreaABS(){
	
	var strArea = cmbSelectAreaABS.options[cmbSelectAreaABS.selectedIndex].value;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findGantryByArea/"+strArea+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
	                     var slctSubcat = $('#cmbSelectGantryABS'), option = "<option value='NONE'>GANTRY</option>";
	 						slctSubcat.empty();
	 						for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	 							option = option
	 									+ "<option value='"+item.id + "'>"
	 									+ item.code + "</option>";
	 						}
	 						slctSubcat.append(option);
	                     
	                 }
	          });		
		 
		
	}
	
function getGantryByAreaDDLO(){
	
	var strArea = cmbSelectAreaDDLO.options[cmbSelectAreaDDLO.selectedIndex].value;
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findGantryByArea/"+strArea+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
	                     var slctSubcat = $('#cmbSelectGantryDDLO'), option = "<option value='NONE'>GANTRY</option>";
	 						slctSubcat.empty();
	 						for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	 							option = option
	 									+ "<option value='"+item.id + "'>"
	 									+ item.code + "</option>";
	 						}
	 						slctSubcat.append(option);
	                     
	                 }
	          });		
		 
		
	}

	
	
		
	</script>
</head>
<body onload="getConductorTypes();setType();">
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
                                <li class="active"><span>Update Switches</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">
								   <c:if test="${SUCCESS_MESSAGE != null}">
                                      <div class="alert alert-success" id="success-alert">
                                       <strong>Success! </strong>${SUCCESS_MESSAGE}
                                    </div>
                                    </c:if>
                                    <script>
                                    setTimeout(function() {
                                        $('#success-alert').fadeOut('fast');
                                    }, 5000);
                                    </script> 
									<div class="tab">
  												<button class="tablinks" onclick="openSwitche(event, 'Auto')">Auto Recloser</button>
  												<button class="tablinks" onclick="openSwitche(event, 'LBS')">LBS</button>
  												<button class="tablinks" onclick="openSwitche(event, 'ABS')">ABS</button>
  												<button class="tablinks" onclick="openSwitche(event, 'DDLO')">DDLO</button>
											</div>

											<div id="Auto" class="tabcontent">
  											<h1>Auto Recloser</h1>
  											<form:form role="form" enctype="multipart/form-data" action="MMSupdateSwitchApprovedData" method="post" modelAttribute="UpdateSwitch">
									       
									         <table class="table table-responsive" id="tblProvinces">
									           <tbody>
									                            <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findAreaAR()" class="form-control" id="cmbSelectProvinceAR" name="cmbSelectProvinceAR">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateSwitch.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvinceAR" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path=""  onchange="getLineAR();getGantryByAreaAR();" class="form-control" id="cmbSelectAreaAR" name="cmbSelectAreaAR">
																     <form:options items="${UpdateSwitch.areaList}" />
																</form:select>
																<span id="spnSelectAreaAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getGantryByAreaLineAR()" class="form-control" id="cmbSelectLineIdAR" name="cmbSelectLineIdAR">
																      <form:options items="${UpdateSwitch.lineList}" />
																</form:select>
																<span id="spnSelectLineIdAR" class="label label-danger"></span>
																</td>
																</tr>  --%>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.gantryId" onchange="getFeederByGantryIdAR()" class="form-control" id="cmbSelectGantryAR" name="cmbSelectGantryAR">
																      
																</form:select>
																<span id="spnSelectGantryAR" class="label label-danger"></span>
																</td>
																</tr> 
																<tr>
                												<td width="30%" style="text-align:left">
                												Feeder
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.feederId" onchange="getSwitchByFeederIdAR()" class="form-control" id="cmbSelectFeederAR" name="cmbSelectFeederAR">
																      
																</form:select>
																<span id="spnSelectFeederAR" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Switch
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.switchId" onchange="loadARData()" class="form-control" id="cmbSelectSwitchAR" name="cmbSelectSwitchAR">
																     
																</form:select>
																<span id="spnSelectSwitchAR" class="label label-danger"></span>
																</td>
																</tr>
																
																
									                           <tr>
                												<td width="30%" style="text-align:left">
                												Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchCode" type="text" class="form-control" id="txtCodeAR" placeholder="Enter Code"/>
																<span id="spnCodeAR" class="label label-danger"></span>
																
																</td>
																</tr> 
        														
        														 <tr>
                												<td width="30%" style="text-align:left">
                												Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchName" type="text" class="form-control" id="txtNameAR" placeholder="Enter Name"/>
																<span id="spnNameAR" class="label label-danger"></span>
																
																</td>
																</tr> 
																<tr>
                												<td width="30%" style="text-align:left">
                												Voltage (V)
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.voltage" type="number" step="any" value ="0" min="0" class="form-control" id="txtIVoltage" placeholder="Enter Name"/>
																<span id="spnIDAR" class="label label-danger"></span>
																
																</td>
																</tr> 
        														
        														
        														<tr>
        														<td width="30%" style="text-align:left">
                												Mounting
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.mounting" class="form-control" id="cmbSelectMountingAR" name="cmbSelectMountingAR">
										                        <form:option value="1">Pole</form:option>
													            <form:option value="2">C channel</form:option>
																</form:select>
																<span id="spnMountingAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Connected Bus
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.connectedBus" class="form-control" id="cmbSelectMountingAR" name="cmbSelectMountingAR">
										                        <form:option value="1">Top</form:option>
													            <form:option value="2">Bottom</form:option>
													            <form:option value="3">Top-Bottom</form:option>
																
																</form:select>
																<span id="spnMountingAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Brand Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.brandName" class="form-control" id="cmbSelectBrandNameAR" name="cmbSelectBrandNameAR">
										                        <form:option value="1">NOJA</form:option>
													            <form:option value="2">ADVC</form:option>
													            <form:option value="3">Jing Kang</form:option>
													            <form:option value="4">Nulec</form:option>
													            <form:option value="5">BN System</form:option>
													            <form:option value="6">Other</form:option>
																</form:select>
																<span id="spnBrandNameAR" class="label label-danger"></span>
																</td>
																</tr>
																
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Location
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.location" class="form-control" id="cmbSelectLocationAR" name="cmbSelectLocationAR">
										                        <form:option value="1">Gantry</form:option>
													            <form:option value="2">Line</form:option>
													            </form:select>
																<span id="spnLocationAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.lineId" onchange="" id="cmbSelectLineIdAR" name="cmbSelectLineIdAR" class="form-control">
																      <form:options items="${UpdateSwitch.lineList}" />
																</form:select>
																<span id="spnSelectLineIdAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
																<td><h3>Controller panel</h3></td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Manufacture
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpDateManufature" type="text" class="form-control" id="txtDateAR"/>
																<span id="spnDateAR" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Commissioning date
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpDateCommitioning" type="text" class="form-control" id="txtCDateAR"/>
																<span id="spnCDateAR" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Model Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpModelNumber" type="text" class="form-control" id="txtModelNumberAR" placeholder="Enter Model Number"/>
																<span id="spnModelNumberAR" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Serial Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpSerialNo" type="text" class="form-control" id="txtSerialnumberAR" placeholder="Enter Serial number"/>
																<span id="spnSerialnumberAR" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Battery Capacity (Ah)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.cpBatteryCapacity" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityAR" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Battery Voltage(V)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.cpBatteryValtage" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityAR" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Auxiliary DC Voltage(V)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.auxiliryDcVolatge" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityAR" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                							                    One Battery Voltage(V)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.oneBatteryVoltage" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityAR" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of batteries
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.cpNoOfBatteries" type="number" value ="0" min="0" class="form-control" id="txtNoofbatteriesAR" placeholder="Enter No of batteries"/>
																<span id="spnNoofbatteriesAR" class="label label-danger"></span>
																</td>    
        														</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Remote operation
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.cpRemoteOperation" class="form-control" id="cmbSelectRemoteoperationAR" name="cmbSelectRemoteoperationAR">
										                        <form:option value="1">Yes</form:option>
													            <form:option value="2">No</form:option>
													            <form:option value="2">None</form:option>
																</form:select>
																<span id="spnRemoteoperationAR" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file1" id="file1"  onchange="show1()">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
																
																
																
																<tr><td><h3>Switch Gear</h3></td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Arrangement
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.sgArrangement" class="form-control" id="cmbSelectArrangementAR" name="cmbSelectArrangementAR">
										                        <form:option value="1">Horizontal</form:option>
													            <form:option value="2">Verticle</form:option>
													            
																</form:select>
																<span id="spnArrangementAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Manufacture
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgDateManufature" type="text" class="form-control" id="txtDateAR1"/>
																<span id="spnDateAR1" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Commissioning date
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgDateCommitioning"  type="text" class="form-control" id="txtCDateAR1"/>
																<span id="spnCDateAR1" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Model Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgModelNumber" type="text" class="form-control" id="txtModelNumberAR1" placeholder="Enter Model Number"/>
																<span id="spnModelNumberAR1" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Serial Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgSerialNo" type="text" class="form-control" id="txtSerialnumberAR1" placeholder="Enter Serial number"/>
																<span id="spnSerialnumberAR1" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Rating(A)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgRating" type="number" value ="0" min="0" class="form-control" id="txtRatingAR" placeholder="Enter Rating"/>
																<span id="spnRatingAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												SCC level of equipment (kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgSccLevelOfEquipment" type="number" step="any" value ="0" min="0" class="form-control" id="txtSCClevelofequipmentAR" placeholder="Enter SCC level of equipment (kA)"/>
																<span id="spnSCClevelofequipmentAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
																<tr>
        														<td width="30%" style="text-align:left">
                												Insulation medium
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.sgInsulationMedium" class="form-control" id="cmbSelectInsulationmediumAR" name="cmbSelectInsulationmediumAR">
										                        <form:option value="1">SF6</form:option>
													            <form:option value="2">Epoxy</form:option>
													            
																</form:select>
																<span id="spnInsulationmediumAR" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file2" id="file2"  onchange="show1()">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
																
																
																<tr>
                												
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchType" type="hidden" class="form-control" id="hiddenswitchType" placeholder="Enter Gantry code"/>
																<span id="spnhiddenswitchType" class="label label-danger"></span>
																</td>
																</tr>
									           
									           </tbody>	
											 </table>
										<div class="form-group">
											<div class="pull-left">
											
												<c:if test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='DEO' }">
					
												<input type="submit" Value="Validate" class="btn btn-success" />
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='EE'}">
					
												<input type="submit" Value="Approve" class="btn btn-success" />
												</c:if>
		
												
											</div>
										</div>

									</form:form> 
									</div>

											<div id="LBS" class="tabcontent">
  											<h1>LBS</h1>
  											<form:form role="form" enctype="multipart/form-data" action="MMSupdateSwitchApprovedData" method="post" modelAttribute="UpdateSwitch">
									       
									         <table class="table table-responsive" id="tblProvinces">
									           <tbody>
									                            <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findAreaLBS()" class="form-control" id="cmbSelectProvinceLBS" name="cmbSelectProvinceLBS">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateSwitch.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvinceLBS" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path=""  onchange="getLineLBS();getGantryByAreaLBS();" class="form-control" id="cmbSelectAreaLBS" name="cmbSelectAreaLBS">
																     <form:options items="${UpdateSwitch.areaList}" />
																</form:select>
																<span id="spnSelectAreaLBS" class="label label-danger"></span>
																</td>
																</tr>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getGantryByAreaLineLBS()" class="form-control" id="cmbSelectLineIdLBS" name="cmbSelectLineIdLBS">
																      <form:options items="${UpdateSwitch.lineList}" />
																</form:select>
																<span id="spnSelectLineIdLBS" class="label label-danger"></span>
																</td>
																</tr> --%> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.gantryId" onchange="getFeederByGantryIdLBS()" class="form-control" id="cmbSelectGantryLBS" name="cmbSelectGantryLBS">
																      
																</form:select>
																<span id="spnSelectGantryLBS" class="label label-danger"></span>
																</td>
																</tr> 
																<tr>
                												<td width="30%" style="text-align:left">
                												Feeder
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.feederId" onchange="getSwitchByFeederIdLBS()" class="form-control" id="cmbSelectFeederLBS" name="cmbSelectFeederLBS">
																      
																</form:select>
																<span id="spnSelectFeederLBS" class="label label-danger"></span>
																</td>
																</tr> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Switch
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.switchId" onchange="loadLBSData()" class="form-control" id="cmbSelectSwitchLBS" name="cmbSelectSwitchLBS">
																      
																</form:select>
																<span id="spnSelectSwitchLBS" class="label label-danger"></span>
																</td>
																</tr>
																
									                           <tr>
                												<td width="30%" style="text-align:left">
                												Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchCode" type="text" class="form-control" id="txtCodeLBS" placeholder="Enter Code"/>
																<span id="spnCodeLBS" class="label label-danger"></span>
																
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchName" type="text" class="form-control" id="txtNameLBS" placeholder="Enter Name"/>
																<span id="spnNameLBS" class="label label-danger"></span>
																
																</td>
																</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Voltage (V)
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.voltage" type="number" step="any" value ="0" min="0" class="form-control" id="txtIVoltage" placeholder="Enter Name"/>
																<span id="spnIDAR" class="label label-danger"></span>
																
																</td>
																</tr> 
        														
        														<tr>
        														<td width="30%" style="text-align:left">
                												Mounting
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.mounting" class="form-control" id="cmbSelectMountingLBS" name="cmbSelectMountingLBS">
										                        <form:option value="1">Pole</form:option>
													            <form:option value="2">C channel</form:option>
																</form:select>
																<span id="spnMountingLBS" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Connected Bus
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.connectedBus" class="form-control" id="cmbSelectMountingAR" name="cmbSelectMountingAR">
										                        <form:option value="1">Top</form:option>
													            <form:option value="2">Bottom</form:option>
													            <form:option value="3">Top-Bottom</form:option>
																
																</form:select>
																<span id="spnMountingAR" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Brand Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.brandName" class="form-control" id="cmbSelectBrandNameLBS" name="cmbSelectBrandNameLBS">
										                        <form:option value="1">NOJA</form:option>
													            <form:option value="2">ADVC</form:option>
													            <form:option value="3">Jing Kang</form:option>
													            <form:option value="4">Nulec</form:option>
													            <form:option value="5">BN System</form:option>
													            <form:option value="6">Other</form:option>
																</form:select>
																<span id="spnBrandNameLBS" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Position
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.position" class="form-control" id="cmbSelectpositionABS" name="cmbSelectpositionABS">
										                        <form:option value="1">Incoming</form:option>
													            <form:option value="2">Outgoing</form:option>
													            <form:option value="3">Line</form:option>
													            <form:option value="4">Bus Coupler</form:option>
													            <form:option value="5">Bus sectionalizer</form:option>
													           
																</form:select>
																<span id="spnpositionABS" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
																<td><h3>Controller panel</h3></td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Manufacture
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpDateManufature" type="text" class="form-control" id="txtDateLBS"/>
																<span id="spnDateLBS" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Commissioning date
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpDateCommitioning" type="text" class="form-control" id="txtCDateLBS"/>
																<span id="spnCDateLBS" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Model Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpModelNumber" type="text" class="form-control" id="txtModelNumberLBS" placeholder="Enter Model Number"/>
																<span id="spnModelNumberLBS" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Serial Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpSerialNo" type="text" class="form-control" id="txtSerialnumberLBS" placeholder="Enter Serial number"/>
																<span id="spnSerialnumberLBS" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Battery Capacity (Ah)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.cpBatteryCapacity" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityLBS" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of batteries
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.cpNoOfBatteries" type="number" value ="0" min="0" class="form-control" id="txtNoofbatteriesLBS" placeholder="Enter No of batteries"/>
																<span id="spnNoofbatteriesLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Auxiliary DC Voltage(V)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.auxiliryDcVolatge" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityAR" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                							                    One Battery Voltage(V)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.oneBatteryVoltage" type="number" value ="0" min="0" class="form-control" id="txtBatteryCapacityAR" placeholder="Enter Battery Capacity"/>
																<span id="spnBatteryCapacityAR" class="label label-danger"></span>
																</td>    
        														</tr>
        														
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Remote operation
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.cpRemoteOperation" class="form-control" id="cmbSelectRemoteoperationLBS" name="cmbSelectRemoteoperationLBS">
										                        <form:option value="1">Yes</form:option>
													            <form:option value="2">No</form:option>
													            <form:option value="2">None</form:option>
																</form:select>
																<span id="spnRemoteoperationLBS" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file1" id="file1"  onchange="show1()">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
																
																
																<tr><td><h3>Switch Gear</h3></td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Arrangement
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.sgArrangement" class="form-control" id="cmbSelectArrangementLBS" name="cmbSelectArrangement">
										                        <form:option value="1">Horizontal</form:option>
													            <form:option value="2">Verticle</form:option>
													            
																</form:select>
																<span id="spnArrangementLBS" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Manufacture
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgDateManufature" type="text" class="form-control" id="txtDateLBS1"/>
																<span id="spnDateLBS1" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Commissioning date
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgDateCommitioning" type="text" class="form-control" id="txtCDateLBS1"/>
																<span id="spnCDateLBS1" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Model Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgModelNumber" type="text" class="form-control" id="txtModelNumberLBS1" placeholder="Enter Model Number"/>
																<span id="spnModelNumberLBS1" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Serial Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.sgSerialNo" type="text" class="form-control" id="txtSerialnumberLBS1" placeholder="Enter Serial number"/>
																<span id="spnSerialnumberLBS1" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Rating(A)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgRating" type="number" value ="0" min="0" class="form-control" id="txtRatingLBS" placeholder="Enter Rating"/>
																<span id="spnRatingLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												SCC level of equipment (kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgSccLevelOfEquipment" type="number" step="any" value ="0" min="0" class="form-control" id="txtSCClevelofequipmentLBS" placeholder="Enter SCC level of equipment (kA)"/>
																<span id="spnSCClevelofequipmentLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
																<tr>
        														<td width="30%" style="text-align:left">
                												Insulation medium
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.sgInsulationMedium" class="form-control" id="cmbSelectInsulationmediumLBS" name="cmbSelectInsulationmediumLBS">
										                        <form:option value="1">SF6</form:option>
													            <form:option value="2">Epoxy</form:option>
													            
																</form:select>
																<span id="spnInsulationmediumLBS" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file2" id="file2"  onchange="show1()">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
																
																
																<tr>
                												
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchType" type="hidden" class="form-control" id="hiddenswitchTypeLBS" placeholder="Enter SwitchType"/>
																<span id="spnhiddenswitchTypeLBS" class="label label-danger"></span>
																</td>
																</tr>
									           
									           </tbody>	
											 </table>
										<div class="form-group">
											<div class="pull-left">
											
												<c:if test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='DEO' }">
					
												<input type="submit" Value="Validate" class="btn btn-success" />
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='EE'}">
					
												<input type="submit" Value="Approve" class="btn btn-success" />
												</c:if>
					
												
											</div>
										</div>

									</form:form>  
								</div>

											<div id="ABS" class="tabcontent">
 											<h1>ABS</h1>
  											<form:form role="form" action="MMSupdateSwitchApprovedData" method="post" modelAttribute="UpdateSwitch">
									       
									         <table class="table table-responsive" id="tblProvinces">
									           <tbody>
									                            <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findAreaABS()" class="form-control" id="cmbSelectProvinceABS" name="cmbSelectProvinceABS">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateSwitch.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvinceABS" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path=""  onchange="getLineABS();getGantryByAreaABS();" class="form-control" id="cmbSelectAreaABS" name="cmbSelectAreaABS">
																     <form:options items="${UpdateSwitch.areaList}" />
																</form:select>
																<span id="spnSelectAreaABS" class="label label-danger"></span>
																</td>
																</tr>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getGantryByAreaLineABS()" class="form-control" id="cmbSelectLineIdABS" name="cmbSelectLineIdABS">
																      <form:options items="${UpdateSwitch.lineList}" />
																</form:select>
																<span id="spnSelectLineIdABS" class="label label-danger"></span>
																</td>
																</tr>  --%>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.gantryId" class="form-control" onchange="getFeederByGantryIdABS()"  id="cmbSelectGantryABS" name="cmbSelectGantryABS">
																      
																</form:select>
																<span id="spnSelectGantryABS" class="label label-danger"></span>
																</td>
																</tr> 
																<tr>
                												<td width="30%" style="text-align:left">
                												Feeder
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.feederId" onchange="getSwitchByFeederIdABS()" class="form-control" id="cmbSelectFeederABS" name="cmbSelectFeederABS">
																      
																</form:select>
																<span id="spnSelectFeederABS" class="label label-danger"></span>
																</td>
																</tr> 
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Switch
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.switchId" onchange="loadABSData()" class="form-control" id="cmbSelectSwitchABS" name="cmbSelectSwitchABS">
																      
																</form:select>
																<span id="spnSelectSwitchABS" class="label label-danger"></span>
																</td>
																</tr>
																
									                            <tr>
                												<td width="30%" style="text-align:left">
                												Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchCode" type="text" class="form-control" id="txtCodeABS" placeholder="Enter Code"/>
																<span id="spnCodeABS" class="label label-danger"></span>
																
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchName" type="text" class="form-control" id="txtNameABS" placeholder="Enter Name"/>
																<span id="spnNameABS" class="label label-danger"></span>
																
																</td>
																</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Voltage (V)
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.voltage" type="number" step="any" value ="0" min="0" class="form-control" id="txtIVoltage" placeholder="Enter Name"/>
																<span id="spnIDAR" class="label label-danger"></span>
																
																</td>
																</tr> 
        														
																<tr>
        														<td width="30%" style="text-align:left">
                												Brand Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.brandName" class="form-control" id="cmbSelectBrandNameABS" name="cmbSelectBrandNameABS">
										                        <form:option value="1">NOJA</form:option>
													            <form:option value="2">ADVC</form:option>
													            <form:option value="3">Jing Kang</form:option>
													            <form:option value="4">Nulec</form:option>
													            <form:option value="5">BN System</form:option>
													            <form:option value="6">Other</form:option>
																</form:select>
																<span id="spnBrandNameABS" class="label label-danger"></span>
																</td>
																</tr>
																
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Manufacture
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpDateManufature" type="text" class="form-control" id="txtDateABS"/>
																<span id="spnDateABS" class="label label-danger"></span>
																
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Commissioning date
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpDateCommitioning" type="text" class="form-control" id="txtCDateABS"/>
																<span id="spnCDateABS" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Serial Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpSerialNo" type="text" class="form-control" id="txtSerialnumberABS" placeholder="Enter Serial number"/>
																<span id="spnSerialnumberABS" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Model Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.cpModelNumber" type="text" class="form-control" id="txtModelNumberABS" placeholder="Enter Model Number"/>
																<span id="spnModelNumberABS" class="label label-danger"></span>
																
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Operation direction 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.operationDirection" class="form-control" id="cmbSelectoperationdirectionABS" name="cmbSelectoperationdirectionABS">
										                        <form:option value="1">Horizontal</form:option>
													            <form:option value="2">Vertical</form:option>
													            
																</form:select>
																<span id="spnoperationdirectionABS" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
        														<td width="30%" style="text-align:left">
                												Position
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.position" class="form-control" id="cmbSelectpositionABS" name="cmbSelectpositionABS">
										                        <form:option value="1">Bypass</form:option>
													            <form:option value="2">Isolation</form:option>
													            <form:option value="3">Bus coupler</form:option>
													            <form:option value="4">Bus section</form:option>
													           
																</form:select>
																<span id="spnpositionABS" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Rating
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgRating" type="number" value ="0" min="0" class="form-control" id="txtRatingABS" placeholder="Enter Rating"/>
																<span id="spnRatingABS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												SCC level of equipment (kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgSccLevelOfEquipment" type="number" value ="0" min="0" class="form-control" id="txtSCClevelofequipmentABS" placeholder="Enter SCC level of equipment (kA)"/>
																<span id="spnSCClevelofequipmentABS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchType" type="hidden" class="form-control" id="hiddenswitchTypeABS" placeholder="Enter SwitchType"/>
																<span id="spnhiddenswitchTypeABS" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Connected Bus
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.connectedBus" class="form-control" id="cmbSelectMountingAR" name="cmbSelectMountingAR">
										                        <form:option value="1">Top</form:option>
													            <form:option value="2">Bottom</form:option>
													            <form:option value="3">Top-Bottom</form:option>
																
																</form:select>
																<span id="spnMountingAR" class="label label-danger"></span>
																</td>
																</tr>
																
																
									           </tbody>	
											 </table>
										<div class="form-group">
											<div class="pull-left">
											
												<c:if test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='DEO' }">
					
												<input type="submit" Value="Validate" class="btn btn-success" />
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='EE'}">
					
												<input type="submit" Value="Approve" class="btn btn-success" />
												</c:if>
		
												
											</div>
										</div>

									</form:form> 
								</div>
											
											<div id="DDLO" class="tabcontent">
 											<h1>DDLO</h1>
  											<form:form role="form" action="MMSupdateSwitchApprovedData" method="post" modelAttribute="UpdateSwitch">
									       
									         <table class="table table-responsive" id="tblProvinces">
									           <tbody>
									                            <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="findAreaDDLO()" class="form-control" id="cmbSelectProvinceDDLO" name="cmbSelectProvinceDDLO">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${UpdateSwitch.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvinceDDLO" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path=""  onchange="getLineDDLO();getGantryByAreaDDLO();" class="form-control" id="cmbSelectAreaDDLO" name="cmbSelectAreaDDLO">
																     <form:options items="${UpdateSwitch.areaList}" />
																</form:select>
																<span id="spnSelectAreaDDLO" class="label label-danger"></span>
																</td>
																</tr>
																
															<%-- 	<tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="" onchange="getGantryByAreaLineDDLO()" class="form-control" id="cmbSelectLineIdDDLO" name="cmbSelectLineIdDDLO">
																      <form:options items="${UpdateSwitch.lineList}" />
																</form:select>
																<span id="spnSelectLineIdDDLO" class="label label-danger"></span>
																</td>
																</tr>  --%>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Gantry
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.gantryId" class="form-control" onchange="getFeederByGantryIdDDLO()" id="cmbSelectGantryDDLO" name="cmbSelectGantryDDLO">
																      
																</form:select>
																<span id="spnSelectGantryDDLO" class="label label-danger"></span>
																</td>
																</tr> 
																<tr>
                												<td width="30%" style="text-align:left">
                												Feeder
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.feederId" onchange="getSwitchByFeederIdDDLO()" class="form-control" id="cmbSelectFeederDDLO" name="cmbSelectFeederDDLO">
																      
																</form:select>
																<span id="spnSelectFeederDDLO" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Switch
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.id.switchId" onchange="loadDDLOData()" class="form-control" id="cmbSelectSwitchDDLO" name="cmbSelectSwitchDDLO">
																      
																</form:select>
																<span id="spnSelectSwitchDDLO" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchCode" type="text" class="form-control" id="txtCodeDDLO" placeholder="Enter Code"/>
																<span id="spnCodeDDLO" class="label label-danger"></span>
																
																</td>
																</tr>
																
        														<tr>
                												<td width="30%" style="text-align:left">
                												Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchName" type="text" class="form-control" id="txtNameDDLO" placeholder="Enter ID"/>
																<span id="spnNameDDLO" class="label label-danger"></span>
																
																</td>
																</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												Voltage (V)
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="switches.voltage" type="number" step="any" value ="0" min="0" class="form-control" id="txtIVoltage" placeholder="Enter Name"/>
																<span id="spnIDAR" class="label label-danger"></span>
																
																</td>
																</tr> 
        														
        														<tr>
        														<td width="30%" style="text-align:left">
                												Position
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.position" class="form-control" id="cmbSelectPositionDDLO" name="cmbSelectPositionDDLO">
										                        <form:option value="1">bypass</form:option>
													            <form:option value="2">isolation </form:option>
																</form:select>
																<span id="spncmbSelectPositionDDLO" class="label label-danger"></span>
																</td>
																</tr>
																		
																<tr>
                												<td width="30%" style="text-align:left">
                												Quantity
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.quantity" type="number" value ="0" min="0" class="form-control" id="txtQuantityDDLO" placeholder="Enter Quantity"/>
																<span id="spnQuantityDDLO" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
        														<td width="30%" style="text-align:left">
                												Carrier Type
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.carrierType" class="form-control" id="cmbSelectcarriertypeDDLO" name="cmbSelectcarriertypeDDLO">
										                        <form:option value="1">fuse</form:option>
													            <form:option value="2">link</form:option>
																</form:select>
																<span id="spncmbSelectcarriertypeDDLO" class="label label-danger"></span>
																</td>
																</tr>
																
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Rating
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="switches.sgRating" type="number" value ="0" min="0" class="form-control" id="txtRatingDDLO" placeholder="Enter Rating"/>
																<span id="spnRatingDDLO" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												
                												<td width="70%" style="text-align:left">
																<form:input path="switches.switchType" type="hidden" class="form-control" id="hiddenswitchTypeDDLO" placeholder="Enter SwitchType"/>
																<span id="spnhiddenswitchTypeDDLO" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Connected Bus
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="switches.connectedBus" class="form-control" id="cmbSelectMountingAR" name="cmbSelectMountingAR">
										                        <form:option value="1">Top</form:option>
													            <form:option value="2">Bottom</form:option>
													            <form:option value="3">Top-Bottom</form:option>
																
																</form:select>
																<span id="spnMountingAR" class="label label-danger"></span>
																</td>
																</tr>
																
																
																
																
									           
									           </tbody>	
											 </table>
										<div class="form-group">
											<div class="pull-left">
											
												<c:if test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='DEO' }">
					
												<input type="submit" Value="Validate" class="btn btn-success" />
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='EE'}">
					
												<input type="submit" Value="Approve" class="btn btn-success" />
												</c:if>
		
												
											</div>
										</div>

									</form:form> 
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