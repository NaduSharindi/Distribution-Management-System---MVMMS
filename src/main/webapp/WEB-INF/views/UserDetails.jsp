<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Untitled</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="assets/css/Good-login-dropdown-menu-1.css">
    <link rel="stylesheet" href="assets/css/Good-login-dropdown-menu.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>




<style>
    

/*.dropdown button {

width: 300px !important;
text-align: left;
background-color: #fadadd !important;


}
*/















</style>


<body>
    <div></div>
    <div>
        <div class="card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >User Details&gt;</a></li>
                     <!-- <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-2" aria-selected="false" href="#item-1-2">Tower Line Information&gt;</a></li>
                    <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab" aria-controls="item-1-3" aria-selected="false" href="#item-1-3">Tower Maintenance Conditions&gt;</a></li>
 --></ul>
            </div>






<form:form action="updateUserDetail" class="form" method="post" modelAttribute="usermodel">
		                                    






            <div class="card-body">
                <div id="nav-tabContent" class="tab-content">

                    <div id="item-1-1" class="tab-pane fade show active" role="tabpanel" aria-labelledby="item-1-1-tab">
                        <div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr></tr>
                                    <tr>
                                        <td style="font-size: 24px; color: #BC576F;">User Details<br></td>
                                        <td></td>
                                    </tr>
                                    <tr><td>
														<c:if test="${SUCCESS_MESSAGE != null}">
                     <div class="alert alert-success" id="success-alert">
                     <strong>Success! </strong>${SUCCESS_MESSAGE}
                </div>
        
                </c:if>
                                    
                <c:if test="${ERROR_MESSAGE != null}">
                     <div class="alert alert-warning" id="warning-alert">
                     <strong>Warning! </strong>${ERROR_MESSAGE}
                </div>
                </c:if>
                </td>
                </tr>                   

                                    
                                    <%-- <tr>
												 <td>Tower No</td>
														<td>
														<td><form:input
																path="support.towerNo" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Division" />
														
															</td>
													</tr> 
													<tr>
												 <td>Tower Line Name</td>
														<td>
														<td><form:input
																path="line.lineName" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Division" />
														
															</td>
													</tr> --%>
													<tr>
														<td>User ID</td>
														<td><form:input
																path="usermm.userId" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="User ID" />
															</td>
															</tr>
									 
													<tr>
														<td>User Name</td>
														<td><form:input
																path="usermm.userNm" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="User Name" />
															</td>
															</tr>
									 
                                  	<tr>
														<td>Registered Cost Center</td>
														<td><form:input
																path="usermm.rptUser" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Registered Cost Center" />
															</td>
															</tr>
														<tr>
														<td>User Level</td>
														<td><form:input
																path="usermm.userLevel" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="User Level" />
															</td>
															</tr>
																												
													<tr>
														<td>Telephone Number</td>
														<td><form:input
																path="usermm.telNo" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Telephone Number"  /> 
													</tr>
													<tr>	
														<td>Email</td>
														<td><form:input
																path="usermm.email" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Email"  /> </td>
													
													</tr>
													<tr>
														<td>EPF Number</td>
													<td><form:input
																path="usermm.epfNo" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="EPF Number"  /> 
													</td>
															
														</tr>
														
																		<tr><td>
				<center>
				<input value = "Update" type="submit"  class="form-input" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Email"  /></center></td>
				
</tr>

			
														                </tbody>
 
 
 
 
 
 
 
                </table>
            </div>
        </div>














         <div id="item-1-2" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-2-tab">
             


                <div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Tower Line Details</td>
                                        
                                    </tr>
                                    <tr>
												 <td>Tower Line Name</td>
														<td>
														<td><form:input
																path="line.lineName" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Division" />
														
															</td>
													</tr> 
                                  	

                                </tbody>
                            </table>
                        </div>
 







            </div>














       <div
            id="item-1-3" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-3-tab">
            






<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Tower Maintenance Details</td>
                                    </tr>
<tr>
														<td>Fungus Sets</td>
														<td><form:input
																path="mnt.fungussetno" type="number"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Fungus Sets" />
															</td>
															</tr>
														<tr>
														<td>Flash Over Sets</td>
														<td><form:input
																path="mnt.flashoversetno" type="number"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Flash Over Sets" />
															</td>
															</tr>
																												
													<tr>
														<td>W Pin Sets</td>
														<td><form:input
																path="mnt.wpinset" type="number"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="W Pin Sets"  /> 
													</tr>
													<tr>	
														<td>End Fitting Sets</td>
														<td><form:input
																path="mnt.endfittingset" type="number"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="End Fitting Sets"  /> </td>
													
													</tr>

																									<tr>
														<td>Jumper Status</td>
														<td><form:input
																path="mnt.jumperstatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													
													</td>
															</tr>
															<tr>
														<td>Conductor Condition</td>
													<td><form:input
																path="mnt.conductorstatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>
															
														</tr>
														<tr>
														<td>Earth Conductor Condition</td>
													<td><form:input
																path="mnt.earthconductorstatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>
															
														</tr> 
														<tr>
														<td>Missing Members</td>
													<td><form:input
																path="mnt.noofmissingparts" type="number"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>	
														</tr> 
														<tr>
														<td>Anti Climbing Status</td>
													<td><form:input
																path="mnt.anticlimbingstatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>
													</tr>	                                    
                                    <tr>
														<td>Leg Painting Requirement</td>
													<td><form:input
																path="mnt.legPainting" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td></tr> 
                                    <tr>
														<td>Base Concrete Status</td>
													<td><form:input
																path="mnt.baseconcretestatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>
															
														</tr> 
                                    <tr>
														<td>Way leave status</td>
													<td><form:input
																path="mnt.wayleavestatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>	
														</tr> 
                                    <tr>
														<td>Special Observations</td>
													<td><form:input
																path="mnt.towerspecial" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>	
														</tr> 
                                    <tr>
														<td>Maintenance Attention</td>
													<td><form:input
																path="mnt.attentionstatus" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Jumper Status"  /> 
													</td>	
														</tr> 
                                    <tr>
														<td>Hot Line Possibility</td>
													<td><form:input
																path="mnt.hotpossible" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Hot Line Possibility"  /> 
													</td>	
														</tr>
                                </tbody>
                            </table>
                        </div>























            </div>
 










   <%--  <div
        id="item-1-4" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-4-tab">
        


<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Additional Details </td>
                                        
                                    </tr>
                                    <tr>
                                        <td>Weight of Transformer(Kg) :</td>
                                        <td>

 <form:input path="pcbEquipment.weightTransformer" type="number" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Weight"></form:input>
                                        </td>
                                        <td>Volume of Oil(L) :</td>
                                        <td>

<form:input path="pcbEquipment.volOil" type="number" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Volume of Oil "></form:input>
                                            </td>
                                    </tr>
                                    <tr>
                                        <td>Oil Weight(Kg) :</td>
                                        <td>
<form:input path="pcbEquipment.oilWeight" type="number" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Oil Weight "></form:input>
                                        </td>
                                        <td>Capacity (kVA) :</td>
                                        <td>
<form:input type="number" path="pcbEquipment.capacity" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Capacity "></form:input>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>(Primary/Secondary) Voltage(kV) :</td>
                                        <td>

<form:input type="text" path="pcbEquipment.voltage" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Capacity "></form:input>


                                        </td>
                                        <td>Serial Number :</td>
                                        <td>

<form:input type="text" path="pcbEquipment.serialNo" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Serial Number "></form:input>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td>Photo Taken :</td>
                                        <td>
<form:input path="pcbEquipment.photoTaken" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Photo Taken"></form:input>
  


                                        </td>
                                        <td>Photo Ref 1 :</td>
                                        <td>

<form:input path="pcbEquipment.photoRef" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Photo Ref 1"></form:input>
                                            </td>
                                    </tr>
                                    <tr>
                                        <td>Photo Ref 2 :</td>
                                        <td>
 <form:input path="pcbEquipment.photoRef2" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Photo Ref 2"></form:input>

                                            </td>
                                        <td>Photo Ref 3 :</td>
                                        <td>
 <form:input path="pcbEquipment.photoRef3" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Photo Ref 3"></form:input>
                                            </td>
                                    </tr>
                                                                    </tbody>
                            </table>
                        </div>











        </div>
 --%>










     <%--    <div id="item-1-5"
            class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-5-tab">
           


<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Condition Of The Transformer</td>
                                        
                                    </tr>
                                    <tr>
                                        <td>Oil Leaks Present :</td>
                                        <td>
<form:input path="pcbCondition.oilLeaksPresent" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Oil Leaks Present"></form:input>
 


                                        </td>
                                        <td>Corrosion :</td>
                                        <td>

<form:input path="pcbCondition.corrosion" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Corrosion "></form:input>




                                            </td>
                                    </tr>
                                    <tr>
                                        <td>Burn Marks :</td>
                                        <td>
 
 <form:input path="pcbCondition.burnMask" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Burn Marks "></form:input>

                                            </td>
                                        <td> Terminal/Connection Attention :</td>
                                        <td>
 
<form:input path="pcbCondition.terminalAttention" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Terminal/Connection Attention "></form:input>

                                            </td>
                                    </tr>
                                    <tr>
                                        <td>Overloaded Signs Present :</td>
                                        <td>

 
<form:input path="pcbCondition.overloadPresent" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Overloaded Signs Present "></form:input>

                                        </td>
                                        <td>Earth Connection is Properly Done :</td>
                                        <td>

<form:input path="pcbCondition.earthConnection" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Earth Connection is Properly Done"></form:input>


                                            </td>
                                    </tr>
                                    <tr>
                                        <td>Lighting Arresters Are Properly Done :</td>
                                        <td>

<form:input path="pcbCondition.lightingArrestersDone" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Lighting Arresters Are Properly Done"></form:input>

                                        </td>
                                        <td>Breather is in Good Condition :</td>
                                        <td>
<form:input path="pcbCondition.breatherIsGoodConnection" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Breather is in Good Condition"></form:input>


                                        </td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>










           </div>
 --%>







    <!--     <div id="item-1-6"
            class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-6-tab">
           
<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">PCB Sample Data</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>PBC Screening Instrument Reading :</td>
                                        <td>


                                            <input type="Number" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="PBC Screening Instrument Reading  ">



                                        </td>
                                        <td>PBC Screening Result Aroclor 1260 :</td>
                                        <td>
                                            <input type="Number" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="PBC Screening Result Aroclor 1260 ">



                                            </td>
                                    </tr>
                                    <tr>
                                        <td>EPF Number of The Test Group :</td>
                                        <td>

                                            <input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder=" Enter EPF Number of The Test Group">

 
                                        </td>

                                        <td> EPF Number of The Group :</td>



                                        <td>


                                            <input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder=" Enter EPF Number of The Group">

                                            </td>
 

                                 
                                    </tr>
                                    <tr>
                                        <td>PCB Test Date :</td>
                                        <td>

                                            <input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder=" Enter PCB Test Date">

                                            </td>

 
                                        </td>
                                        <td></td>
                                        <td></td>



                                    </tr>
                                    <tr>
                                        <td>Remarks :</td>
                                        <td>


                                             <textarea  class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" > Enter Remarks</textarea>



                                        </td>

                                        <td>Test Remark :</td>
                                        <td>
                                            <textarea  class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" > Enter Remarks</textarea>





                            </td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>





           </div>
 -->








       <!--   <div id="item-1-7"
            class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-7-tab">
            
<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">ITI</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Sent to ITI :</td>
                                        <td>

<select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected> << Yes/No >> </option>
  <option value="1">Yes</option>
  <option value="2">No</option>
  
</select>


                                        </td>
                                        <td>ITI Results :</td>
                                        <td>
                                            <input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter ITI Results">



                                            </td>
                                    </tr>
                                    <tr>
                                        <td>ITI Confirmed Positive :</td>
                                        <td>


<select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected> << Yes/No >> </option>
  <option value="1">Yes</option>
  <option value="2">No</option>
  
</select>

 
                                        </td>

                                        <td></td>



                                        <td>


                                            </td>
 

                                 
                                    </tr>
                                    <tr>
                                        <td>Completed :</td>
                                        <td>


<select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected> << Yes/No >> </option>
  <option value="1">Yes</option>
  <option value="2">No</option>
  
</select>


                                            

                                            </td>

 
                                        </td>



                                        <td>Test Lab :</td>
                                        <td>

<select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected> << Colombo/Kandy >> </option>
  <option value="1">Colombo</option>
  <option value="2">Kandy</option>
  
</select>

                                            

                                        </td>



                                    
                                    
                                </tbody>
                            </table>
                        </div>



            </div>
 -->


























        </div>
        </div>
        </form:form>
        </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        


    </script>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>