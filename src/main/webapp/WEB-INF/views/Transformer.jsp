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
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >Equipment Data&gt;</a></li>
                    <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-2" aria-selected="false" href="#item-1-2">Location Details&gt;</a></li>
                    <!-- <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab" aria-controls="item-1-3" aria-selected="false" href="#item-1-3">Information Related to Sampling&gt;</a></li>
 -->
                     <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-4" aria-selected="false" href="#item-1-4">Additional Details&gt;</a></li>
                      <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-5" aria-selected="false" href="#item-1-5">Condition of the Transformer&gt;</a></li>
                      <!--  <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-6" aria-selected="false" href="#item-1-6">PCB Sample Data&gt;</a></li>
                        <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-7" aria-selected="false" href="#item-1-7">ITI&gt;</a></li>
                 --></ul>
            </div>






<form:form role="form" action="MMSaddEquipmentnew" method="post"
										modelAttribute="SaveEquipment">
                                    






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
                                        <td style="font-size: 24px; color: #BC576F;">Equipment Data<br></td>
                                        <td></td>
                                    </tr>
                                    
                                  	<%-- <tr>
												 <td>Division</td>
														<td>
														<td><form:input
																path="pcbEquipment.divison" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Division" />
														
															</td>
													</tr> --%>
 <tr>
														<td>Province</td>
														<td><form:input
																path="pcbEquipment.branch" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Province" />
															</td>
															
														
														<td>Area</td>
														<td><form:input
																path="pcbEquipment.unit" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Province" />
															</td>
															</tr>
																												
													<tr>
														<td>Reference No</td>
														<td><form:input
																path="pcbEquipment.referenceNo" type="text"  class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtEquipmentId"
																placeholder="Reference No"  /> 
														
														<td>Type</td>
														<td><form:select
																path="pcbEquipment.type" class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																
																id="txtType" placeholder="<< Select Type >>">
																<form:option value="-1"><< Select Type >></form:option>
																<form:option value="TR">Transformer</form:option>
																<form:option value="SB">Single Barrel</form:option>
																<form:option value="BL">Barrel Lot</form:option>
															</form:select> </td>

													</tr>

																									<tr>
														<td>Condition</td>
														<td><form:select
																path="pcbEquipment.condition" class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																
																id="txtStatus" placeholder="<< Select Condition >>">
																<form:option value="In Use">In Use</form:option>
																<form:option value="Abandoned">Abandoned</form:option>
																<form:option value="Spare">Spare</form:option>
															
															</form:select> <span id="spnStatus" class="label label-danger"></span></td>
															
															
                                        <td>Manufacturer Year :</td>
                                        <td>
                                            <form:input path="pcbEquipment.year" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Manufacturer Year"></form:input>
                                        </td>
                                        <td><br></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Manufacturer LTL ? :<br></td>
                                        <td>
                                         <form:input path="pcbEquipment.manufactureLtl" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Manufacturer LTL"></form:input>
                                        

                                        </td>
                                        <td>Manufacturer Brand :<br></td>
                                        <td>

                                                <form:input path="pcbEquipment.manufactureBrand" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Manufacturer Brand"></form:input>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Seal Type :</td>
                                        <td>
                                   <form:input path="pcbEquipment.seriaType" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Seal Type"></form:input>
                                                 


  

                                        </td>
                                        <td>Primary Sub :</td>
                                        <td>
                                        
  <form:input path="pcbEquipment.primarySub" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Primary Sub"></form:input>
                                 

                                        </td>
                                    </tr>
                                    <tr>
														<td>Status</td>
													<td><form:select
																path="pcbEquipment.status" class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="2">Active</form:option>
															<form:option value="3">In Active</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															
														
														<td>Sin No</td>
													<td><form:input class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; "
																path="pcbEquipment.sinNo" type="text" 
																 id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr> 
                                    
                                    
                                    
                                    <!-- <tr>
                                        <td>Division :</td>
                                        <td>

  <select class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected>Division</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>
                        
                        </td>
                        </tr>
                        <tr>
                            <td>Province :</td>
                            <td>
                                  <select class="form-select" aria-label="Default select example" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color:#FEEFEC; ">
  <option selected>Division</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>
                    </td>
                    </tr>
                    <tr>
                        <td>Area :</td>
                        <td>
                            
  <select class="form-select" aria-label="Default select example" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected>Division</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>


                </td>
                </tr>
                <tr>
                    <td>Reference No :</td>
                    <td><input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Reference No"></td>
                </tr>
                <tr>
                    <td>Type :</td>
                    <td>
                        


  <select class="form-select" aria-label="Default select example" style="width:300px; color: gray; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected>Division</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>


                    </td>
                </tr>
                <tr>
                    <td>Condition :</td>
                    <td>
                         <select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected>In Use</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>
                    </td>
                </tr>
                <tr>
                    <td>Status :</td>
                    <td>
                        

  <select class="form-select" aria-label="Default select example" style="width:300px; border-bottom-color:#BC576F;color: gray; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected>Division</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>


                    </td>
                </tr>
                <tr>
                    <td>Sin No :</td>
                     <td> <input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Reference No"></td>
                </tr>
 -->                </tbody>
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
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Location Details</td>
                                        
                                    </tr>
                                    <tr>
                                        <td>Location Description :</td>
                                        <td><form:input path="pcbLocation.locationDescription" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Location Description"></form:input></td>
                                        <td>Mounting(Pole/Plinth/Ground) :</td>
                                        <td>

                                            <form:select path="pcbLocation.mounting"  class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <form:option value="1">One</form:option>
  <form:option value="2">Two</form:option>
  <form:option value="3">Three</form:option>
</form:select>



                                        </td>
                                    </tr>
                                    <tr>
                                        <td>GPS Location(Latitude) :</td>

                                        <td><form:input type="text" path="pcbLocation.gpsLatitude"  class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="GPS Location"></form:input></td>

                                        <td>GPS Location(Longitude) :</td>

                                        <td> <form:input path="pcbLocation.gpsLongitude" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="GPS Location"></form:input></td>
                                    </tr>
                                    <tr>
                                        <td>Type of Located :</td>
                                        <td>
                                            

<form:input path="pcbLocation.typeOfLocated" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Type of Located :"></form:input></td>
                                    
  

                                        <td></td>
                                        <td></td>
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
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Informatin Related to Sampling</td>
                                    </tr>
                                    <tr>
                                        <td>Manufacturer Year :</td>
                                        <td>
                                            <form:input path="pcbEquipment.year" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Manufacturer Year"></form:input>
                                        </td>
                                        <td><br></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Manufacturer LTL ? :<br></td>
                                        <td>
                                         <form:input path="pcbEquipment.manufactureLtl" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Manufacturer LTL"></form:input>
                                        

                                        </td>
                                        <td>Manufacturer Brand :<br></td>
                                        <td>

                                                <form:input path="pcbEquipment.manufactureBrand" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Manufacturer Brand"></form:input>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Seal Type :</td>
                                        <td>
                                   <form:input path="pcbEquipment.seriaType" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Seal Type"></form:input>
                                                 


  

                                        </td>
                                        <td>Primary Sub :</td>
                                        <td>
                                        
  <form:input path="pcbEquipment.primarySub" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Primary Sub"></form:input>
                                 

                                        </td>
                                    </tr>
<%--                                     <tr>
                                        <td>Sampling Port :</td>
                                        <td>
                                            



<form:input path="pcbSample.samplingPort" class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  
</form:input>

                                        </td>
                                        <td>Extracted From Top :</td>
                                        <td>
                                    




<form:input path="pcbSample.extractedTop" class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  
</form:input>


                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Sampling Logic Satisfied :</td>
                                        <td>
                                            



<select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
  <option selected> << Yes/No >> </option>
  <option value="1">Yes</option>
  <option value="2">No</option>
  
</select>

                                        </td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Sampling Number :</td>
                                        <td><input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Sampling Number"></td>
                                        <td>Sample Date :</td>
                                        <td><input type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Enter Sample Date"></td>
                                    </tr> --%>
                                </tbody>
                            </table>
                        </div>























            </div>











    <div
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











        <div id="item-1-5"
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








        <div id="item-1-6"
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









         <div id="item-1-7"
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