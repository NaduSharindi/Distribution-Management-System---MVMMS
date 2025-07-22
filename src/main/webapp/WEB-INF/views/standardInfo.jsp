<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
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
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >Applicant&gt;</a></li>
                    <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-2" aria-selected="false" href="#item-1-2">Application Details&gt;</a></li>
                    
                    <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab" aria-controls="item-1-3" aria-selected="false" href="#item-1-3">PIV Details&gt;</a></li>

                     <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-4" aria-selected="false" href="#item-1-4">Service Details&gt;</a></li>
                      <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-5" aria-selected="false" href="#item-1-5">Estimate Details&gt;</a></li>
                        <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-6" aria-selected="false" href="#item-1-6">Comments & Approval History&gt;</a></li>
                        <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-7" aria-selected="false" href="#item-1-7">Attachment&gt;</a></li>
                 </ul>
            </div>












 <form:form method="post" action=""	modelAttribute="model">
	 


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
                                        <td style="font-size: 24px; color: #BC576F;">Applicant<br></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>NIC/Passport Number/Business Registration</td>
                                       <td><form:input type="text" path ="applicant.idNo" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="NIC/Passport Number/Business Registration"></form:input></td>
                                        </tr>
                                    
                                    <tr>
                                        <td>Full Name/Requested By</td>
                                       <td><form:input type="text" path ="applicant.fullName" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Full Name/Requested By"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>First Name (Initials)/ Company Name/Requested By</td>
                                       <td><form:input type="text" path ="applicant.firstName" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="First Name (Initials)/ Company Name/Requested By"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Last Name</td>
                                       <td><form:input type="text" path ="applicant.lastName" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Last Name"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Street Address</td>
                                       <td><form:input type="text" path ="applicant.streetAddress" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Street Address"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Suburb</td>
                                       <td><form:input type="text" path ="applicant.suburb" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Suburb"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Mobile No</td>
                                       <td><form:input type="text" path ="applicant.mobileNo" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Mobile No"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Email</td>
                                       <td><form:input type="text" path ="applicant.email" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Email"></form:input></td>
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
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Application Details</td>
                                    </tr>
<tr>
                                        <td>Application No</td>
                                       <td><form:input type="text" path ="application.applicationNo" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Application No"></form:input></td>
                                        </tr>
                                    
                                    <tr><td>Application Id/Temporary Id</td>
                                       <td><form:input type="text" path ="application.id.applicationId" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Full Name/Requested By"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Application Type</td>
                                       <td><form:input type="text" path ="application.applicationType" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Application Type"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Description</td>
                                       <td><form:input type="text" path ="application.description" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Description"></form:input></td>
                                        </tr>
                                         <tr>
                                        <td>Demand</td>
                                       <td><form:input type="text" path ="wlObj.demand" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Demand"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Fund Source</td>
                                       <td><form:input type="text" path ="wlConObj.fundSource" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Fund Source"></form:input></td>
                                        </tr>
                                   
                                                                        </tbody>
                            </table>
                        </div>








            </div>














        <div
            id="item-1-3" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-3-tab">
            






<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                                                <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Application PIV Details</td>
                                    </tr>
                                    
                                    
                               
                                <thead>
                                    <tr><th>Number</th>  
             <th>Amount</th>
            
            <th>Type</th> 
            <th>Status</th> 
            
            </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${model.pivList}"  varStatus="status">
			<tr>
			<td>${job.id.pivNo}</td>
		    <td>${job.pivAmount}</td>
			<td>${job.referenceType}</td>
			<td>${job.status}</td>
			</tr>
			<tr><td>C = Confirm     P = Paid  N = New</td> </tr>
			</c:forEach>
            </tbody>
            </table>
            </div>


<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                                                <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Estimate PIV Details</td>
                                    </tr>
                                    
                                    
                               
                                <thead>
                                    <tr><th>Number</th>  
             <th>Amount</th>
            
            <th>Type</th> 
            <th>Status</th> 
            <th>Mark as Paid</th> 
            
            </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${model.pivEstList}"  varStatus="status">
			<tr>
			<td>${job.id.pivNo}</td>
		    <td>${job.pivAmount}</td>
			<td>${job.referenceType}</td>
			<td>${job.status}</td>
			</tr>
			<tr><td>C = Confirm     P = Paid   N = New</td> </tr>
			</c:forEach>
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
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Service Details </td>
                                        
                                    </tr>
                                    <tr>
                                        <td>Service Street Address</td>
                                       <td><form:input type="text" path ="wlObj.serviceStreetAddress" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Service Street Address"></form:input></td>
                                        </tr>
                                    
                                    <tr><td>Service Suburb</td>
                                       <td><form:input type="text" path ="wlObj.serviceSuburb" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Service Suburb"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Service City</td>
                                       <td><form:input type="text" path ="wlObj.serviceCity" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Service City"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Area</td>
                                       <td><form:input type="text" path ="wlConObj.areaCode" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Area"></form:input></td>
                                        </tr>
                                         <tr>
                                        <td>District</td>
                                       <td><form:input type="text" path ="wlObj.serviceDistrict" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="District"></form:input></td>
                                        </tr>
                                         <tr>
                                        <td>Contract Demand</td>
                                       <td><form:input type="text" path ="wlObj.demand" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Contract Demand"></form:input></td>
                                        </tr>
                                        
                                        <tr>
                                        <td>Neighbor Account Number</td>
                                       <td><form:input type="text" path ="wlObj.neighboursAccNo" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Neighbor Account Number"></form:input></td>
                                        </tr>
                                        <%-- <tr>
                                        <td>Type of Supply</td>
                                       <td><form:input type="text" path ="wlObj.demand" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Type of Supply"></form:input></td>
                                        </tr>
                                        
                                        <tr>
                                        <td>Customer Category</td>
                                       <td><form:input type="text" path ="wlObj.customerCategory" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Customer Category"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Customer Type</td>
                                       <td><form:input type="text" path ="wlObj.customerType" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Customer Type"></form:input></td>
                                        </tr>
                                         <tr>
                                        <td>Connection Type</td>
                                       <td><form:input type="text" path ="wlObj.connectionType" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Connection Type"></form:input></td>
                                        </tr> --%>
                                       
                                        
                                        

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
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Estimate Details</td>
                                        
                                    </tr>
                                        <tr>
                                        <td>Power to Supply</td>
                                       <td><form:input type="text" path ="wlObj.serviceStreetAddress" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Power to Supply"></form:input></td>
                                        <td>Full Name/Requested By</td>
                                       <td><form:input type="text" path ="applicant.fullName" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Full Name/Requested By"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Security Deposite</td>
                                       <td><form:input type="text" path ="spstdesthmtModel.secdeposit" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Security Deposite"></form:input></td>
                                       <td>Demand</td>
                                       <td><form:input type="text" path ="wlObj.demand" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Demand"></form:input></td>
                                         </tr>
                                        <tr>
                                        <td>CEB Cost</td>
                                       <td><form:input type="text" path ="spstdesthmtModel.cebcost" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="CEB Cost"></form:input></td>
                                        <td>Rebate Cost</td>
                                       <td><form:input type="text" path ="spstdesthmtModel.rebateCost" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Rebate Cost"></form:input></td>
                                        </tr>
                                        <tr>
                                         <td>Vat Cost</td>
                                       <td><form:input type="text" path ="spstdesthmtModel.vatcost" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Vat Cost"></form:input></td>
                                        <td>NBT Cost</td>
                                       <td><form:input type="text" path ="spstdesthmtModel.nbtcost" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="NBT Cost"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Total Consumer Payable Cost</td>
                                       <td><form:input type="text" path ="spstdesthmtModel.toconpay" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Total Consumer Payable Cost"></form:input></td>
                                        </tr>
                                    
                                                                        </tbody>
                            </table>
                        </div>
                        
            <div class="table-responsive" style="padding: 47px;">
                            <table class="table table-striped">
                                       
                                    
                               
                                <thead>
                                    <tr><th>Code</th>  
             <th>Uom</th>
            
            <th>Description</th> 
            <th>Quantity/Length</th> 
            <th>Standard Rate</th> 
            <th>Cost</th> 
            
            </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${model.spstdestdmtModel}"  varStatus="status">
			<tr>
			<td>${job.lineType}</td>
		    <td>${job.uom}</td>
			<td>${job.linedes}</td>
			<td>${job.length}</td>
			
			<td>${job.lineCost}</td>
			<td>${job.estCost}</td>
			
			</tr>
			</c:forEach>
            </tbody>
            </table>
            </div>                     
                        










           </div>








        <div id="item-1-6"
            class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-6-tab">
           
<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                                                <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Comments & Approval History</td>
                                    </tr>
                                    
                                    
                               
                                <thead>
                                    <tr><th>Action By</th>  
             <th>Action Date</th>
            <th>Action Time</th>
            
            <th>User Level</th> 
            <th>Comments</th> 
            <th>From Status</th> 
            <th>To Status</th> 
            
            </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${model.approvalHistoryList}"  varStatus="status">
			<tr>
			<td>${job.approvedBy}</td>
		    <td>${job.approvedDate}</td>
			<td>${job.approvedTime}</td>
			<td>${job.approvedLevel}</td>
			<td>${job.reason}</td>
			<td>${job.fromStatus}</td>
			
			<td>${job.toStatus}</td>
			
			</tr>
			</c:forEach>
			<tr><td>2 = ES -Modify  5 = Rejected   8 = ES-Validation   10 = Commercial EE-Approval  	20 = Planning EE-Approval 	30 = Commercial CE-Approval  35 = Planning CE-Approval 40 = DGM-Approval 50 = Approved Estimate  </td> </tr>
			
            </tbody>
            </table>
            </div>




           </div>









         <div id="item-1-7"
            class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-7-tab">
            
<div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                                                <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Attachments</td>
                                    </tr>
                                    
                                    
                               
                                <thead>
                                    <tr><th>Uploded By</th>  
             <th>User Level</th> 
            <th>File Name</th> 
            <th><i class="glyphicon glyphicon-folder-open"></i></th> 
            
            </tr>
            </thead>
            <tbody>
            <c:forEach var="job" items="${model.attachmentList}"  varStatus="status">
			<tr>
			<td>${job.approvedBy}</td>
		    <td>${job.approvedLevel}</td>
			<td>${job.filename1}</td>
			<td><button id = "saveBtn_${job.filename1}"  type="button" title='View Attachment' onClick='viewAttachment"${job.filename1}")'><i class="glyphicon glyphicon-folder-open"></i></button></td> 
											                 	
			</tr>
			</c:forEach>
			<!-- <tr><td>75 = Modify     44 = ES-Validation   		46 = EE-Approval  		47 = CE-Approval 	48 = DGM - Approval  49 = AGM - Approval </td> </tr>
			
             --></tbody>
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