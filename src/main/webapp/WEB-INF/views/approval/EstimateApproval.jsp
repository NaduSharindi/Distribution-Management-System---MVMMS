<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


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

<div class="main">
<div class="upnew">
              <div class="wrapper">
      <div class = "form">
      <form id = "register" method="post">

       
    <div class="table-responsive">
    <table id="myTable" class="display table" width="100%">
        <thead>  
          <tr style="width:2%" class="heading">  
            <th>Estimate Number</th>  
            <th>Department Id</th>  
            <th>Description</th>
           <th>Total Cost</th> 
           <th>Approve</th>
          </tr>  
        </thead>  
        <tbody>  
          <tr>  
            <td>501.20/BS/21/0001/1</td>  
            <td>501.20</td>  
            <td>test estimate 1</td> 
            <td>5000</td>  
            
      <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td>  
          </tr>  
          <tr>  
            <td>501.20/BS/21/0001/2</td>  
            <td>501.20</td>  
            <td>test estimate 2</td> 
            <td>5000</td>  
              
      <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td>  
          </tr>  
          <tr>  
            <td>501.20/BS/21/0001/3</td>  
            <td>501.20</td>  
            <td>test estimate 3</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td>  
          </tr>  
           <tr>  
            <td>501.20/BS/21/0001/4</td>  
            <td>501.20</td>  
            <td>test estimate 4</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
          <tr> 
            <td>501.20/BS/21/0001/5</td>  
            <td>501.20</td>  
            <td>test estimate 5</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
    <tr>  
            <td>501.20/BS/21/0001/6</td>  
            <td>501.20</td>  
            <td>test estimate 6</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>501.20/BS/21/0001/7</td>  
            <td>501.20</td>  
            <td>test estimate 7</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td>   
          </tr>  
<tr>  
            <td>501.20/BS/21/0001/8</td>  
            <td>501.20</td>  
            <td>test estimate 8</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>501.20/BS/21/0001/9</td>  
            <td>501.20</td>  
            <td>test estimate 9</td> 
            <td>5000</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
<tr>  
           <td>501.20/BS/21/0001/10</td>  
            <td>501.20</td>  
            <td>test estimate 10</td> 
            <td>5000</td>  
             <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>501.20/BS/21/0001/11</td>  
            <td>501.20</td>  
            <td>test estimate 11</td> 
            <td>5000</td>  
           <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>501.20/BS/21/0001/12</td>  
            <td>501.20</td>  
            <td>test estimate 12</td> 
            <td>5000</td>  
           <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>501.20/BS/21/0001/13</td>  
            <td>501.20</td>  
            <td>test estimate 13</td> 
            <td>5000</td>  
           <td><a href="#">
          <span class="glyphicon glyphicon-ok"></span>
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
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript"  src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

   <script>
   $(document).ready(function(){
   $('#myTable').dataTable();
   });
   </script>



</body>
</html>