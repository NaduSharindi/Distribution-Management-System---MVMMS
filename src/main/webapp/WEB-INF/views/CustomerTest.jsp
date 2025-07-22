<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MININDU</title>

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


<style>
    

.dropdown button {

width: 300px !important;
text-align: left;
background-color: #fadadd !important;


}



.button{
    background:#922B21;
    border-radius:12px:
    height:40;
    width:120px;
    border: none;
    color: white;
    padding: 5px 15px;
    text-align: center;
     opacity: 0.9;
    transition: 0.3s;

}
.button:hover {opacity: 1}












</style>
</head>

<body>
       <div>
      <div class="card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >Create New Customer</a></li>
                   </ul>
            </div>



























    <div class="card-body">
                <div id="nav-tabContent" class="tab-content">

                <div id="item-1-1" class="tab-pane fade show active" role="tabpanel" aria-labelledby="item-1-1-tab">
                        <div class="table-responsive" style="padding: 47px;">
 
      <form:form action="addCustomerPost" method="post" modelAttribute="Customer"> 

                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr></tr>
                                    <tr>
                                        <td style="font-size: 24px; color: #BC576F;">Create New Customer
                                  <br></td>
                                        <td></td>
                                    </tr>
                                      <tr>
                    <td>Full Name:</td>
                    <td> <form:input path=""  type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Full Name"/></td> 
              
                </tr>
                        <tr>
                            
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="First Name"/></td>
                </tr>
                     <tr>
                    <td>Last Name:</td>
                    <td><form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Last Name"/></td>
                </tr>
             

               <tr>
                    <td>Personal or Cooperate:</td>
                 <td>
                         <select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
 
                        <option value="1">Personal</option>
                       <option value="2">Cooperate</option>

                         </select>
                    </td>
                </tr>
                <tr>
                    <td>ID Type:</td>
                    <td>
                         <select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">
 
            <option value="1">NIC</option>
          <option value="2">Passport</option>
            <option value="3">BUS REG NO</option>
            </select>
             </td>
                </tr>
                <tr>
                    <td>Street Address:</td>
                    <td> <form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Street Address "/></td>
                </tr>

                <tr>
                    <td>Suburb(Line 2):</td>
                     <td> <form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; color: gray; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Suburb"/></td>
                </tr>

  
                <tr>
                    <td>Cost Center Number:</td>
                    <td><form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Cost Center Number"/></td>
                </tr>
                        
                <tr>
                    <td>City(Line 3):</td>
                    <td><form:input path=""  type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="City"/></td>
                </tr>
                      
                <tr>
                    <td>Postal Code:</td>
                    <td><form:input path=""  type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Postal Code"/></td>
                </tr>
                 <tr>
                    <td>Mobile Number:</td>
                    <td><form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Mobile Number"/></td>
                </tr>
                <tr>
                    <td>Land/CDMA :</td>
                    <td><form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Land/CDMA "/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="" type="text" class="form-control" style="width:300px; border-bottom-color: #BC576F; border-bottom-width: 2px; background-color: #FEEFEC;" placeholder="Email"/></td>
                </tr>

                 <tr>
                    <td>Preferred Language:</td>

                     <td>
                         <select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC; ">

                   <option value="1">Sinhala</option>
                   <option value="2">English </option>

                   </select>
                    </td>
                </tr>
                <tr>
                    <td>CEB Employee:</td>
                    <td>
                         <select class="form-select" aria-label="Default select example" style="width:300px;color: gray; border-bottom-color:#BC576F; border-bottom-width: 2px; background-color: #FEEFEC;">
 
                        <option value="1">Yes</option>
                         <option value="2">No</option>

                 </select>
                    </td>
                </tr>
          
        





                </tbody>
                        <tr>
            <td colspan="2"><button class="button" type="submit">Save</button> 
           
            </td>
            </tr>


                </table>
           </form:form>  
                 <br>

               
            </div>
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