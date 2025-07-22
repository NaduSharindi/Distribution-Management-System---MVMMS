<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<title>Insert title here</title>

<style>
* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;
      font-weight: ;
      
      background-image:url(powerplant.jpg);
      background-repeat: no-repeat;
      background-size: cover;
    
    
    
    }

/* Style the tab */

    table, th, td {
  border: 1px solid black;
}

/* Style the buttons inside the tab */

*/

/* Change background color of buttons on hover */

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  background-color: black;
  padding: 0px 12px;
  border: 3px solid maroon;
  width: 100%;
  height: 900px;
  opacity: 0.7;
  color: white;
  
    
    }
    .user-details .input-box2 input{
  height: 25px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  background-color:white;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
  
.user-details .input-box input{
  height: 45px;
  width: 85%;
  outline: none;
  font-size: 16px;
  color: black;
  border-radius: 5px;
  padding-left: 15px;
  background-color:white;
  border: 1px solid maroon;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: maroon;
  border-width: inherit;
  border-bottom-width: medium;
} 
 .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
    
    
    
    <!-- ------------ -->
    .container{
  width: 1000px;
  height: 1200px;
  padding: 25px 30px;
  border-radius: 5px;
  box-shadow: 0 5px 10px rgba(0,0,0,0.15);
}
    
.container .title{
    margin-top: 2%;
  margin-left: 43%;
  font-size: 20px;
  font-weight: 500;
  position: relative;
}
.container .title::before{
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 75px;
  border-radius: 5px;
  background: linear-gradient(135deg, #dfe302, #871b00);
}  
content form .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
form .user-details .input-box{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
}
    
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
form .category{
   display: flex;
   width: 80%;
   margin: 14px 0 ;
   justify-content: space-between;
 }
.user-details .input-box2 select{
  height: 24px;
  width: 85%;
  outline: none;
 color: black;
  font-size: 15px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}  

.user-details .input-box select{
  height: 45px;
  width: 85%;
    color: black;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  background-color: white;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box select:focus,
.user-details .input-box select:valid{
    border-color: maroon;
  border-width: inherit;
  border-bottom-width: medium;
}
form .button input{
   height: 45px;
   margin-left: 70%;
   width: 150px;
   border-radius: 5px;
   border-color: maroon;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, white, #871b00);
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(135deg, #871b00, white);
  border-bottom-width: 5px;
  }
    h2{
        margin: 15px;
        
    }
    
    img{
       flex-wrap: wrap; 
       margin-left: 130px;
        margin-top: 5px;
    }
    
    
    <!-- Half input -->
    
.user-details .input-box input{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box2 input:focus,
.user-details .input-box2 input:valid{
   border-color: maroon;
  border-width: inherit;
  border-bottom-width: medium;
} 
form .input-box2 span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
form .user-details .input-box2{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
} 
.user-details .table input{
height: 27px;
  width: 100px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
   .container .form{
        margin-left:75px;
        
    }
    
    
    

   
   

</style>

</head>
<body>
<div id="Information2" class="tabcontent">
    
 <div class="container">
    <div class="title">Add Plan Details</div>
    <div class="content">
      <form action="#" class="form">
          <div class="user-details" >   
          <div class="input-box">
            <span placeholder="Province" class="details">Province </span>
            <select class ="drop-down">
                <option value="AAA">Province</option>
                <option value="AAA">Central Province</option>
                <option value="AAA">Central2 Province</option>
                <option value="AAA">Eastern Province</option>
                <option value="AAA">Western Province North</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Area </span>
            <select class ="drop-down">
                <option value="AAA"></option>
                <option value="BBB"></option>
                 <option value="BBB"></option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Line</span>
            <select class ="drop-down">
                <option value="AAA"></option>
                <option value="BBB"></option>
                 <option value="BBB"></option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">CSC </span>
            <select class ="drop-down">
                <option value="AAA"></option>
                <option value="BBB"></option>
                 <option value="BBB"></option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Plan Year </span>
            <select class ="drop-down">
                <option value="AAA">2020</option>
                 <option value="BBB">2021</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Maintenance Type </span>
            <select class ="drop-down">
                <option value="AAA">Hot Line Maintaince</option>
                <option value="BBB">Cold Line Maintaince</option>
                 <option value="BBB">Inspection</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Responsible EE </span>
            <select class ="drop-down">
                <option value="AAA">Mr.Udaya</option>
                <option value="BBB">Mr.Ganepola</option>
                 <option value="BBB">Mr.Nihaj</option>
                 <option value="BBB">Mr.Thilanka</option>
                 <option value="BBB">Mr.Eranga Bogahakumbura</option>
            </select> 
          </div>
           <div class="input-box">
            <span class="details">Responsible ES </span>
            <select class ="drop-down">
                <option value="AAA">ENGINEERIMG ASSISTANT-600.41</option>
                <option value="BBB">Mr.Gamage</option>
                 <option value="BBB">Mr.Dananjaya</option>
                <option value="BBB">Mr.Prasantha</option>
                 <option value="BBB">Mr.Sumudu</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Length(Km) </span>
            <input type="number" placeholder="0" required>
          </div>
          <div class="input-box">
            <span class="details">Number of Tower </span>
            <input type="number" placeholder="0" required>
          </div>
          <div class="input-box">
            <span class="details">Number of Pole </span>
            <input type="number" placeholder="0" required>
          </div>
          <div class="input-box">
            <span class="details">Serial Number </span>
            <input type="year" placeholder="Enter Serial Number " required>
          </div>
             <div class="input-box">
            <span class="details">From Date </span>
            <input type="date" placeholder="" required>
          </div>
            <div class="input-box">
            <span class="details">To Date </span>
            <input type="date" placeholder="" required>
          </div>
          <div class="input-box">
            <span class="details">Status</span>
            <select class ="drop-down">
                <option value="AAA">Active</option>
                <option value="BBB">In Active</option>
                 
            </select> 
          </div>
         
              
        </div>
          <div class="button">
          <input type="submit" value="Add">
        </div>
        </form>
        
         </div>
    </div>
    
    
</div>

   
    

<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>


</body>
</html>