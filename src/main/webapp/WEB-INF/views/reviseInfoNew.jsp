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
    
 .heading{
  background-color: #9f0e31;
  color: white;
}
/*.dropdown button {

width: 300px !important;
text-align: left;
background-color: #fadadd !important;


}
*/


</style>
<script type="text/javascript">

function viewAttachment(name){
    		 var url="downloadAttachment?name="+name;
      	    var width = 1100;
      	    var height = 700;
      	    var left = parseInt((screen.availWidth/2) - (width/2));
      	    var top = parseInt((screen.availHeight/2) - (height/2));
      	    var windowFeatures = "width=" + width + ",height=" + height + 
      	    ",status,resizable,left=" + left + ",top=" + top +
      	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
      	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
      	
    }
</script> 

<body>
    <div></div>
    <div>
        <div class="card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >Estimate Details&gt;</a></li>
                    <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-2" aria-selected="false" href="#item-1-2">Comments & Approval History&gt;</a></li>
                    
                    <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab" aria-controls="item-1-3" aria-selected="false" href="#item-1-3">Attachment&gt;</a></li>

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
                                        <td style="font-size: 24px; color: #BC576F;">Estimate Details<br></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Estimate Number:</td>
                                       <td><form:input type="text" path ="pcesthttModel.estimateNo" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Estimate Number"></form:input></td>
                                            <td>Cost Center:</td>
                                       <td><form:input type="text" path ="pcesthttModel.deptId" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Cost Center"></form:input></td>
                                        </tr>
                                        
                                        <tr>
                                        <td>Estimate Date: </td>
                                       <td><form:input type="text" path ="pcesthttModel.etimateDt" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Estimate Date"></form:input></td>
                                        <td>Estimate Categoty:</td>
                                       <td><form:input type="text" path ="pcesthttModel.catCd" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Estimate categoty"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Fund Source:</td>
                                       <td><form:input type="text" path ="pcesthttModel.fundSource" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Fund Source"></form:input></td>
                                        
                                        <td>Fund ID:</td>
                                       <td><form:input type="text" path ="pcesthttModel.fundId" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Fund ID"></form:input></td>
                                        </tr>
                                    <tr>
                                        <td>Rebate:</td>
                                       <td><form:input type="text" path ="pcesthttModel.partialAmt" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Rebate"></form:input></td>
                                        
                                        <td>Total Cost:</td>
                                       <td><form:input type="text" path ="pcesthttModel.stdCost" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Total Cost"></form:input></td>
                                        </tr>
                                        <tr>
                                        <td>Initial Total Cost:</td>
                                       <td><form:input type="text" path ="pcesthttModel.stdCostInitial" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Rebate"></form:input></td>
                                        
                                        <td>Variance:</td>
                                       <td><form:input type="text" path ="pcesthttModel.percentage" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Total Cost"></form:input></td>
                                        </tr>
                                    
                                        <tr>
                                        <td>Description:</td>
                                       <td><form:textarea type="text" path ="pcesthttModel.descr" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Description"></form:textarea></td>
                                        
                                        </tr>
                                    
                                    
                                    
                                        

                </tbody>
                </table>
                
                <div class="table-responsive" style="padding: 47px;">
                            <table class="table table-striped">
                                                              <!--   <tr>
                                        <td style="font-size: 24px;color: rgb(188,87,111);">Estimate Material Details</td>
                                    </tr> -->
                                    
                                    
                               
                                <thead>
                                    <tr style="width:2%" class="heading">
                                     <th>Resource Code</th>  
            
            <th>Resource Name</th>  
             <th>UOM</th>  
            
            <th>Unit Price</th>  
            <th>Estimated Quantity</th>
            
            <th>Estimated Cost</th>
            <th>Rebate Quantity</th>
             <th>Rebate Cost</th>
           <th>Reusable Quantity</th>
           <th>Off Charge Quantity</th>
           </tr>
            </thead>
            <tbody>
           <c:set var="count" value="0" scope="page" />
																
															<c:forEach var="job" items="${model.listPcestdttModel}"  varStatus="status">
															
																<tr>
																<td>${job.resCd}</td> 
											                 	<td>${job.resName}</td> 
											                 	<td>${job.uom}</td>
																
																<td>${job.unitPrice}</td>
																<td>${job.estimateQty}</td>
																<td>${job.estimateCost}</td>
																 <td>${job.rebateQty}</td>
																 <td>${job.rebateCost}</td>
																<td>${job.reusableQty}</td>
																<td>${job.offChargeQty}</td> 
																
																	
																
																									</tr>
									</c:forEach>
		</tbody>
            </table>
            </div>
                
            </div>
        </div>














        <div id="item-1-2" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-2-tab">
            

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
			<tr><td>75 = ES -Modify     44 = ES-Validation   45 = EA-Validation		46 = EE-Approval  		47 = CE-Approval 	48 = DGM - Approval  49 = AGM - Approval </td> </tr>
			
            </tbody>
            </table>
            </div>
                







            </div>














        <div
            id="item-1-3" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-3-tab">
            





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











    <div
        id="item-1-4" class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-4-tab">
        


        </div>











        <div id="item-1-5"
            class="tab-pane fade" role="tabpanel" aria-labelledby="item-1-5-tab">
           










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