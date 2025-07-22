<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
   <head>
      
     
     
       <style>
       
       *{
margin: 0;
padding: 0;
}
body{
background-image: url(1.jpg);  
background-size:cover;
background-size:cover;
background-position: center center;
height: 100vh;
}

.wrapper{
width: 880px; 
margin-left:250px;
   
}
.wrapper ul{
list-style: none;
margin-top: 2%;
margin-left: 20%;
}
.wrapper ul li {
background: maroon;
width: 170px;
border: 1px solid #fff;
height: 50px;
line-height: 50px;
text-align: center;
float: left;
color: #fff;
font-size: 10px;
position: relative;
font-family: poppins;
text-transform: uppercase;
font-weight: bold;
}
.wrapper ul li:hover{
background:#f1ce0b; 
}

.wrapper ul ul{
display: none;
}
.wrapper ul li:hover > ul{
display: block;
}
.wrapper ul ul ul{
margin-left: 170px;
top: 0;
position: absolute;
}
#imag{
    margin-left: 375px
               
           }
           h3{
               margin-left: 400px
           }

             
       
       
       </style>
       
       
       
   </head>
   <body>

       
      
            
  <div class="wrapper">
      
      <div id ="imag">
      <img  src="logo_ko.png" width="120" height="120">
          
          </div>
      <h3>MV-MMS</h3>
    <ul>
      <li>Data related to meter 
        <ul>
           <li>Testing unit
                <ul>
                      <li>Eenrgy Management</li>
                      <li>Energy Purchase</li>
                      <li>Meter Lab</li>
                      <li>Area</li>
                </ul>
           </li> 
           <li>Connection Type
                <ul>
                      <li>MHP</li>
                      <li>HS</li>
                      <li>LT Bulk</li>
                      <li>3 ph 30A</li>
                      <li>3 ph 60A</li>
                      <li>1 ph</li>
                </ul>
           </li> 
           <li>Test Report Number</li>
           <li>Test Date</li>
           <li>Testing Basis
                <ul>
                      <li>Routine</li>
                      <li>New connection</li>
                      <li>Capacity Augment</li>
                      <li>Meter change</li>
                      <li>AEE Request</li>
                      <li>Audit</li>
                </ul>
           </li>
        </ul> 
      </li>
      <li>New Meter details
            <ul>
                  <li>Make</li>
                  <li>CEB Serial No</li>
                   <li>Manufacture serial No</li>
                   <li>Meter CT Ratio 
                        <ul>
                           <li>200/5</li>
                           <li>400/5</li>
                           <li>800/5</li>
                           <li>1000/5</li>
                           <li>Other - text enter</li>
                        </ul>
                   </li>
                    <li>Meter VT Ratio
                        <ul>
                           <li>1/1</li>
                           <li>Other - text enter</li>
                        </ul>
                    </li>
                    <li>Meter Constant Active</li>
                    <li>Meter Constant Reactive</li>
                   <li>Scaling Factor</li>
                   <li>Multification Factor</li>
                   <li>Accuracy Class- Active</li>
                   <li>Accuracy Class- Reactive</li>
                   <li>Year of Manufacture</li>
          
            </ul>
      </li>
      <li>New CT detail
            <ul>
                <li> R</li>
                <li> Y </li>
                <li> B </li>
            </ul>
      
        
      </li>
      
    </ul>
      
   </body>
</html>