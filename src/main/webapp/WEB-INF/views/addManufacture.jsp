<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">

 <style>

*{
  margin: 0;
  padding: 0;
}

body{
  background: url("images/light4.jpg");
  background-size: 280%;
  background-position: -400px 0px;
}

div.main{
  margin: 20px 10px -100px 10px;
  padding-top: 20px;
}

#drop{
  padding: 2px 20px;
  cursor: pointer;
  font-size: 12px;
  color: #595656;
}

/*.input_field{
  margin-left: 460px;
}*/

.button {
  border: none;
  color: white;
  padding: 14px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button2{
  width: 110px;
  height: 40px;
  padding: 5px 8px;
  font-size: 14px;
  font-family: sans-serif;
  font-weight: 600;
  background-color: #ffb6c1; 
  color: black; 
  cursor: pointer;
  border: 1px solid rgba255,255,255,0.3;
  box-shadow: 1px 1px 5px rgba(0,0,0,0.3);
  border-radius: 12px;
}

.button2:hover {
  background-color: #fc94af;
  color: white;
  border: 2px solid none;
  font-size: 15px;
}

h2{
  text-align: center;
  padding: 5px;
  margin-bottom: 0px;
  text-align: center;
}

td{
  font-size: 13.5px;
}

th{
  font-size: 14px;
}

h4{
  padding-left: 79px;
  font-size: 18px;
  margin-top: 50px;
}

#mainnw2{
  margin: 150px;
}

div.register{
  background-color: rgba(0,0,0,0.5);
  width: 100%;
  font-size: 16px;
  border-radius: 10px;
}

.heading{
  background-color: #9f0e31;
  color: white;
}

form#register{
  margin: 80px;
}

label{
  font-size: 13px;
}


.wrapper .form .input_field{
  margin-bottom: 10px;
  display: flex;
  align-items: center;
}

.wrapper .form .input_field label{
  width: 170px;
}


input#name{
  width: 250px;
  outline: 0;
  padding: 3px;
}

input#name2{
  width: 50px;

  border-radius: 3px;
  outline: 0;
  padding: 3px;
  background-color: #fff;
}

#btn{
  width: 75px;
  padding: 1px 8px;
  font-size: 13px;
  background-color: #9c9797;
  color: black;
  cursor: pointer;
}

input#btn:hover{
  background-color: black;
  font-size: 13px;
  color: white;
}

.up{
  position: relative;
  bottom: 62px;
}

.upnew{
  position: relative;
  bottom: 58px;
}

.button1{
  height: 10px;
  position: relative;
  margin-left: 20px;
}

.center {
  margin: 0;
  position: absolute;
  top: -1100%;
  left: 20%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-20%, -130%);
}

 .rowt1 {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }

  .rowt {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }


  #headert {
        background-color: #16a085;
        color: #fff;
    }
    
    .rowt:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }

     .rowt1:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }
    
    @media only screen and (max-width: 768px) {
        table {
            width: 90%;
        }
    }

</style>



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
								</ol>

								
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>

					<link rel="stylesheet"
						href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
						integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
						crossorigin="anonymous">



<div class="main">
<div class="upnew">
              <div class="wrapper">
      <div class = "form">
      <form id = "register" method="post">

        <div class = "input_field">
        <label> Manufacture Name: </label>
        <input type="text" name="cost" id="name">
          </div>
              

        <div class = "input_field">
        <label> Remark: </label>
        <textarea id="w3review" name="w3review" rows="3" cols="32" placeholder="Text">
          </textarea>
        </div>

<center>

<button class="button button2" onclick="alert('Details are added')"><b> Save <b></button> 
&nbsp;&nbsp;&nbsp;&nbsp;
<button class="button button2" onclick="alert('Cleared all the details')" ><b> Clear <b></button>

</center>
    <div class="table-responsive">
    <table id="myTable" class="display table" width="100%">
        <thead>  
          <tr style="width:2%" class="heading">  
            <th>No</th>  
            <th>Manufacturer Name</th>  
            <th>Remark</th>
           <th>Edit</th> 
          </tr>  
        </thead>  
        <tbody>  
          <tr>  
            <td>1</td>  
            <td>ABB</td>  
            <td></td>  
      <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>  
          </tr>  
          <tr>  
            <td>2</td>  
            <td>ACTARIS</td>  
            <td></td>  
      <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>  
          </tr>  
          <tr>  
            <td>3</td>  
            <td>ALSTOM</td>  
            <td></td> 
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>  
          </tr>  
           <tr>  
            <td>4</td>  
            <td>CEWE</td>  
            <td></td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
          <tr> 
            <td>5</td>  
            <td>CEWE OLD</td>  
            <td></td> 
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
    <tr>  
            <td>6</td>  
            <td>EDMI</td>  
            <td></td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>7</td>  
            <td>ELSTER</td>  
            <td></td> 
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>   
          </tr>  
<tr>  
            <td>8</td>  
            <td>GCE</td>  
            <td></td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>9</td>  
            <td>ISKRA</td>  
            <td></td>   
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>10</td>  
            <td>Lasdis & Gyr</td>  
            <td> Export </td> 
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>11</td>  
            <td>ABB</td>  
            <td></td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>12</td>  
            <td>DD1</td>  
            <td> </td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>13</td>  
            <td>EE1</td>  
            <td> </td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
        </tbody>  
    </table>
    </div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript"  src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

   <script>
   $(document).ready(function(){
   $('#myTable').dataTable();
   });
   </script
</body>
</html>