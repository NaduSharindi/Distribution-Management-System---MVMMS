<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;
     
      background-repeat: no-repeat;
      background-size: cover;
      background-color: black;
     
    
    
    }

/* Style the tab */
.tab {
  float: left;
  border: 1px solid maroon;
  background-color: #ffffff;
  opacity: 0.7;
  width: 25%;
  height: 800px;
}
    table, th, td {
  border: 1px solid black;
}
    table2, th, td {
  border: 1px solid black;
}

/* Style the buttons inside the tab */
.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 16px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  background-color: #f1f1f1;
  padding: 0px 12px;
  border: 1px solid maroon;
  width: 75%;
  border-left: none;
  height: 940px;
    
    }
    .user-details .input-box2 input{
  height: 25px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
  
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
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: maroon;
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
  width: 50px;
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
 

.user-details .input-box select{
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
.user-details .input-box select:focus,
.user-details .input-box select:valid{
    
  border-bottom-width: medium;
}
form .button input{
   height: 45px;
   width: 100px;
   border-radius: 5px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, #871b00, #dfe302);
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(135deg, #dfe302, #871b00);
  }
    h2{
        margin: 15px;
        
    }
    
    img{
       flex-wrap: wrap; 
       margin-left: 130px;
        margin-top: 5px;
    }
    
    
    
    
.user-details .input-box2 input{
  height: 27px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;

}
    
   
    
.user-details .table input{
height: 27px;
  width: 200px;
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
    
    
.user-details .table2 input{
height: 27px;
  width: 90px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table2 input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 

   .user-details .table2 select{
  height: 27px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .table2 select:focus,
.user-details .table2 select:valid{
    
  border-bottom-width: medium;
}
    
.user-details .table3 input{
height: 27px;
    position: fixed;
  width: 90px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table3 input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
.user-details[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}  
   
.user-details .input-box2 select{
  height: 27px;
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
    
    
    
    
.user-details .table4 input{
height: 27px;
  width: 90px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table4 input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 

   .user-details .table4 select{
  height: 27px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .table4 select:focus,
.user-details .table4 select:valid{
    
  border-bottom-width: medium;
}    

form .button2 input{
   height: 45px;
   width: 250px;
   border-radius: 5px;
   margin-top: 10px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background:#871b00;
 }
    
   
    
    
    
.collapsible {
  background:linear-gradient(135deg, #dfe302, #871b00); 
  opacity: 0.8;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border-width:1px;
  border-color:aliceblue;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}  
    
   .title{
        background-color: maroon;
        height: 50px;
    }   
   h2{
        color: yellow;
        margin-top:10px;
        margin-left: 550px
    }
    .button3{
        margin-left: 614px;
        margin-top: 5px;
        width:100px;
        height:50px ;
        border-radius: 10px;
        background:linear-gradient(135deg, maroon, #fff);
        font-family: sans-serif;
        font-size: 20px;
        color: aliceblue;
       
    }
    .button3:hover {
  background: linear-gradient(135deg, #fff,maroon );
}
   
    
</style>
</head>
<body>

<div class="title">
<h2>- Meter Testing Report -</h2>
   
    </div>
   
<button type="button" class="collapsible">Meter Master Data</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Area:</span>
              
            <input type="text" placeholder="Auto Get data from relevant order card?" required>
          </div>
          <div class="input-box">
            <span class="details">ECSC</span>
            <input type="text" placeholder="Auto Get data from relevant order card?" required> 
          </div>
          
          <div class="input-box">
            <span class="details">Account No</span>          
            <input type="number" placeholder="Auto Get data from relevant order card?" required>
          </div>
         <div class="input-box2">
            <span class="details">T/F Size:</span>          
            <select class ="drop-down">
                <option value="AAA">Bulk</option>
                <option value="BBB"> BUlk+Dist</option>
                <option value="BBB">Distribution</option>
                <option value="BBB" ><input type="number" placeholder="kVA" required></option> 
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Demand: </span>          
            <input type="number" placeholder="Auto Get data from relevant order card?" required>
          </div>
          <div class="input-box">
            <span class="details">SIN No </span>
            <input type="number" placeholder="Auto Get data from relevant order card?" required>
            </div>
            <div class="input-box">
            <span class="details">Consumer Name </span>
            <input type="text" placeholder="Auto Get data from relevant order card?" required>
            </div>
            <div class="input-box">
            <span class="details">Consumer Address</span>
            <input type="address" placeholder="Auto fill from order card detail?" required>
            </div>
            <div class="input-box">
            <span class="details">Tariff</span>
            <input type="address" placeholder="Auto Get data from relevant order card?" required>
            </div>
            <div class="input-box">
            <span class="details">Telephone No</span>
            <input type="phone number" placeholder="Auto Get data from relevant order card?" required>
            </div>
            <div class="input-box">
            <span class="details">Capacitor Bank Availablity:</span>
            <select class ="drop-down">
                <option value="AAA">Yes</option>
                <option value="BBB"> No</option>
                 
            </select> 
            </div>
            <div class="input-box">
            <span class="details">Backup Generator Availablity:</span>
            <select class ="drop-down">
                <option value="AAA">Yes</option>
                <option value="BBB"> No</option>
                 
            </select> 
            </div>
            <div class="input-box2">
            <span class="details">Capacity</span>
            <input type="text" placeholder="kVA" required>
            <input type="text" placeholder="kW" required>
            </div>
            
        </div>
          
        </form>
</div>
    
 
    
    
    <button type="button" class="collapsible">Data related to meter - testing</button>
<div class="content">
  <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Testing Unit</span>
            <select class ="drop-down">
                <option value="AAA">Eenrgy Management</option>
                <option value="BBB">Energy Purchase</option>
                 <option value="BBB">Meter Lab</option>
                <option value="BBB">Area</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Test Type</span>
            <select class ="drop-down">
                <option value="AAA">MHP</option>
                <option value="BBB">HS</option>
                 <option value="BBB">LT Bulk</option>
                <option value="BBB">3 ph 30A</option>
                <option value="BBB">3 ph 60A</option>
                <option value="BBB">1 ph</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Connection Type </span>
            <select class ="drop-down">
                <option value="AAA">Routine</option>
                <option value="BBB">New connection</option>
                 <option value="BBB">Capacity Augment</option>
                <option value="BBB">Meter change</option>
                <option value="BBB">AEE Request</option>
                <option value="BBB">Audit</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Report Number</span>
            <input type="text" placeholder="Auto generated though system:" required>
          </div>
            <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
              
        </div>
          
        </form>
</div>
    

    
    
    
<button type="button" class="collapsible">Meter Information - Existing</button>
<div class="content">
  <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Meter Type</span>
            <select class ="drop-down">
                <option value="AAA">PPM</option>
                <option value="BBB">Elect</option>
                 <option value="BBB">Mech</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="text" placeholder="____________________"  required>
          </div>
           <div class="input-box">
            <span class="details">Make</span>
            <select class ="drop-down">
                <option value="AAA">Iskra</option>
                <option value="BBB">Edmi</option>
                 <option value="BBB">Secure</option>
                <option value="BBB">Hexin</option>
                 <option value="BBB">Holly</option>
                 <option value="BBB">Bluester</option>
                 <option value="BBB">Other</option>
            </select> 
          </div>
          <div class="input-box2">
            <span class="details">Multification Factor</span>
            <div><input type="text" placeholder="Calculated"  required>
              <input type="text" placeholder="As per bill"  required></div> 
          </div>
          <div class="input-box">
            <span class="details">CEB Serial No</span>
             <input type="number" placeholder="Enter serial No"  required>
          </div>
          <div class="input-box">
            <span class="details">Manufacture Serial No</span>
            <input type="number" placeholder="Enter  Manufacture Serial number" required>
          </div>
          <div class="input-box">
            <span class="details">Meter Constant Reactive</span>
            <input type="number" placeholder="Enter number" required>
          </div>
           <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Multification Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box2">
            <span class="details">Accuracy Class</span>
           <div><input type="text" placeholder="Active"  required>
              <input type="text" placeholder="Reactive"  required></div>
          </div>
          <div class="input-box">
            <span class="details">Meter VT Ratio</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Year of Manufacture</span>
            <input type="year" placeholder="Enter manufacture year" required>
          </div>
             <div class="input-box">
            <span class="details">Meter Constant</span>
            <input type="year" placeholder="Active" required>
          </div>
            <div class="input-box">
            <span class="details">Meter Constant</span>
            <input type="year" placeholder="Reactive" required>
          </div>
         
              
        </div>
          
        </form>
</div>
    
    
<button type="button" class="collapsible">Meter Information - New</button>
<div class="content">
  <form action="#">
      
      <div class="button2">
          <input type="submit" value="Load Existing Meter Detail">
        </div>
      
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Meter Type</span>
            <select class ="drop-down">
                <option value="AAA">PPM</option>
                <option value="BBB">Elect</option>
                 <option value="BBB">Mech</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <div class="input-box">
            <span class="details">Make And Model  No</span>
            <input type="text" placeholder="Enter number"  required>
          </div>
          <div class="input-box2">
            <span class="details">Multification Factor</span>
            <div><input type="text" placeholder="Calculated"  required>
              <input type="text" placeholder="As per bill"  required></div> 
          </div>
          <div class="input-box">
            <span class="details">CEB Serial No</span>
             <input type="number" placeholder="Enter serial No"  required>
          </div>
          <div class="input-box">
            <span class="details">Manufacture Serial No</span>
            <input type="number" placeholder="Enter  Manufacture Serial number" required>
          </div>
          <div class="input-box">
            <span class="details">Meter CT Ratio</span>
            <select class ="drop-down">
                <option value="AAA"></option>
                
            </select> 
          </div>
           <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Multification Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box2">
            <span class="details">Accuracy Class</span>
           <div><input type="text" placeholder="Active"  required>
              <input type="text" placeholder="Reactive"  required></div>
          </div>
          <div class="input-box">
            <span class="details">Meter VT Ratio</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Year of Manufacture</span>
            <input type="year" placeholder="Enter manufacture year" required>
          </div>
             <div class="input-box">
            <span class="details">:Active</span>
            <input type="year" placeholder="Active" required>
          </div>
            <div class="input-box">
            <span class="details">:Reactive</span>
            <input type="year" placeholder="Reactive" required>
          </div>
         
              
        </div>
          
        </form>
</div>

    
    


<button type="button" class="collapsible">Meter Readings Import Existing:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
         
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>           
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
   
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
       
       
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>        
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
               
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
       
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
       
       
        </div>
          
        </form>
    </div>
</div>

    <button type="button" class="collapsible">Meter Readings Export Existing:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
         
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>           
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
   
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
       
       
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>        
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
               
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
       
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
       
       
        </div>
          
        </form>
    </div>
</div>
    
 <button type="button" class="collapsible">Meter Readings Import New:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>          
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
          
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>            
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
    
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
        
        
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>          
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>          
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
                
            </select> 
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
        
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        
        
        </div>
          
        </form>
    </div>
</div>
<button type="button" class="collapsible">Meter Readings Export New:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
         
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>           
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
   
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
       
       
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>        
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
               
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
       
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
       
       
        </div>
          
        </form>
    </div>
</div>   
    
    


    

<button type="button" class="collapsible">Meter Wiring & Testing(Before Correction):</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Phase Sequance</span>
            <select class ="drop-down">
                <option value="volvo">For</option>
                <option value="saab">Rev</option>
                 <option value="opel">Inv</option>
                    
            </select>
          </div>
          <div class="input-box">
            <span class="details">Phase Association</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Wrong</option>
                 
            </select>
          </div>
            
            
            
            
            
            
          <div class="input-box2">
            <span class="details">Color Code</span>         
            <select class ="drop-down">
                <option value="AAA">Ok </option>
                <option value="BBB"> Not Ok</option>
                <option value="BBB" ><input type="text" placeholder="(____/____/____)" required></option> 
            </select> 
          </div>
            
            
            
          <div class="input-box">
            <span class="details">Wire Size & Type</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Terminal Lugs available </span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div> 
          <div class="input-box">
            <span class="details">Properly & Neatly done</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div>
        </div>  
          
        </form>
</div>
    

<button type="button" class="collapsible">Meter Testing (Before Correction):</button>
<div class="content">
  <form action="#">
<div class="user-details">   
<div name="Meter Testing (After Correction) ">     
<table class = "table2" name = "main">
  <tr>
    <th rowspan="2">Ph</th>
    <th colspan="2">Voltage</th>
    <th colspan="2">Current</th>
    <th rowspan="2">Power Factor</th>
    
  </tr>
  <tr>
    <th >PPM</th>
    <th>TI</th>
    <th>PPM</th>
    <th>TI</th>
    
    
  </tr>
  <tr>
     <th >L 1</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
  <tr>
     <th >L 2</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
  </tr>
     <tr>
     <th >L 3</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
  </tr>
    
  <div class="content">
  <form action="#">
<div class="user-details">   
<div name="Meter Testing (After Correction) ">     

    </div>
    
    <div name ="Meter Testing (After Correction)2 ">
        <br><br>
    <table class = "table2" name = "main">
  <tr>
    <th rowspan="2"></th>
    <th colspan="3">Active (kWh)</th>
    <th colspan="3">Reactive (kVArh)</th>
    <th colspan="3">Overall Test</th>
    
  </tr>
  <tr>
    <th >1</th>
    <th>2</th>
    <th>3</th>
      <th>1</th>
     <th>2</th>
    <th>3</th>
     <th>1</th>
    <th>2</th>
     <th>3</th>
   
    
  </tr>
  <tr>
     <th >No.of Pulse</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
  </tr>
  <tr>
     <th >Avg. % error</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
    
  </tr>
</table>
        </div>
      
<div class="register-(dail)-test">
<br> 
<table class = "table2" name ="register(dail)test">
  
  <tr>
     <th colspan="2">Register (Dail) Test</th>
   
    
     
   
    
  </tr>
  <tr>
     <th >Final Reading (Y) </th>
    <td><input type="text" placeholder="" required></td>
    
     
    
    
  </tr>
    <tr>
     <th >Initial Reading (X) </th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     <tr>
     <th>Y - Xl</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     
     <tr>
     <th>Test .... %error</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
  <br><br>  
</table>
        </div>
<div name="load-Condition">
    
<div name="load-Condition">
    <br><br><br>
    <table class = "table2" name ="Load-Condition">
    
  <tr>
     <th colspan="2">Load Condition</th>
    <td><input type="text" placeholder="Active :" required></td>
    <th><input type="text" placeholder="Reactive :" required></th>
     <th><input type="text" placeholder="Dial Test :" required></th>
     
 
  </tr>    
</table>
    
    </div>      
        
    </div>
   
        </div>
          
        </form>
</div>
    
    

<button type="button" class="collapsible">Meter Wiring (After Correction)</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Phase Sequance</span>
            <select class ="drop-down">
                <option value="volvo">For</option>
                <option value="saab">Rev</option>
                 <option value="opel">Inv</option>
                    
            </select>
          </div>
          <div class="input-box">
            <span class="details">Phase Association</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Wrong</option>
                 
            </select>
          </div>
            
            
            
            
            
            
          <div class="input-box2">
            <span class="details">Color Code</span>
            <select class ="drop-down">
                <option value="AAA">Ok </option>
                <option value="BBB"> Not Ok</option>
                <option value="BBB" ><input type="text" placeholder="(____/____/____)" required></option> 
            </select> 
          </div>
            
            
            
          <div class="input-box">
            <span class="details">Wire Size & Type</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Terminal Lugs available </span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div> 
          <div class="input-box">
            <span class="details">Properly & Neatly done</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div>
        </div>
          
          
        </form>
</div>
    
    
<button type="button" class="collapsible">Meter Testing (After Correction)</button>
<div class="content">
  <form action="#">
<div class="user-details">   
<div name="Meter Testing (After Correction) ">     
<table class = "table2" name = "main">
  <tr>
    <th rowspan="2">Ph</th>
    <th colspan="2">Voltage (V)</th>
    <th colspan="3">Current (l)</th>
    <th colspan="2">Power Factor</th>
    
  </tr>
  <tr>
    <th >PPM</th>
    <th>TI</th>
      
    <th>PPM</th>
    <th>TI</th>
    <th>Primary</th>
    <div class="row">
    <td><input type="text" placeholder="" required></td>
        </div>
  </tr>
  <tr>
     <th >L 1</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
     
    
  </tr>
  <tr>
     <th >L 2</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
   
    
    
  </tr>
 <tr>
     <th >L 3</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
  
  </tr>
    
    
  
</table>
    </div>
    
    <div name ="Meter Testing (After Correction)2 ">
        <br><br>
    <table class = "table2" name = "main">
  <tr>
    <th rowspan="2"></th>
    <th colspan="3">Active (kWh)</th>
    <th colspan="3">Reactive (kVArh)</th>
    <th colspan="3">Overall Test</th>
    
  </tr>
  <tr>
    <th >1</th>
    <th>2</th>
    <th>3</th>
      <th>1</th>
     <th>2</th>
    <th>3</th>
     <th>1</th>
    <th>2</th>
     <th>3</th>
   
    
  </tr>
  <tr>
     <th >No.of Pulse</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
  </tr>
  <tr>
     <th >Avg. % error</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
    
  </tr>
</table>
        </div>
    
    
    
    
    
    
    
    
    
    
    
        
       
<div class="register-(dail)-test">
<br> 
<table class = "table2" name ="register(dail)test">
  
  <tr>
     <th colspan="2">Register (Dail) Test</th>
   
    
     
   
    
  </tr>
  <tr>
     <th >Final Reading (Y) </th>
    <td><input type="text" placeholder="" required></td>
    
     
    
    
  </tr>
    <tr>
     <th >Initial Reading (X) </th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     <tr>
     <th>Y - Xl</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     
     <tr>
     <th>Test .... %error</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
  

  <br><br>  
</table>
        </div>
<div name="load-Condition">
    <br><br><br>
    <table class = "table2" name ="Load-Condition">
 

  
  <tr>
     <th colspan="2">Load Condition</th>
    <td><input type="text" placeholder="Active :" required></td>
    <th><input type="text" placeholder="Reactive :" required></th>
     <th><input type="text" placeholder="Dial Test :" required></th>
     
 
  </tr>    
</table>
    
    </div>
   
        </div>
         
        </form>
</div>

    
    
    
    
    

<button type="button" class="collapsible">CT Serial and Sealing data</button>
    <div class="content">
<form action="#">
        <div class="user-details">
            
       
            
            
<table class = "table">
  <tr>
    <th colspan="2"></th>
    <th colspan="2">Old</th>
    <th colspan="2">New</th>
    
  </tr>
  <tr>
    <th colspan="2"  rowspan="2">Meter Seal</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
    
  </tr>
  <tr>
     <td ><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     
   
    
  </tr>
  <tr>
     <th colspan="2">Terminal Cover</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
    
  </tr>
    <tr>
     <th colspan="2">MD Button</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
    
  </tr>
     <tr>
     <th colspan="2">Enclosure/Small Window</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
    
  </tr>
  <tr>
     <th rowspan="3">CT Serial</th>
    <th>R</th>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td> 
      
    
  </tr>
  <tr>
     <th>Y</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
  </tr>
    <tr>
     <th>B</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
       <td><input type="text" placeholder="" required></td>
   
    
  </tr>
      <tr>
     <th colspan="2">Cubicle</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
  </tr>
</table>
            
        </div>
          
        </form>
</div>
    

<button type="button" class="collapsible">Test Instrument Details:</button>
<div class="content">
  <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Make:</span>
            <input type="text" placeholder="____________________"  required> 
          </div>
          <div class="input-box">
            <span class="details">Serial No:</span>
            <input type="number" placeholder="Enter Serial No"  required>
          </div>
          <div class="input-box">
            <span class="details">Accuracy CL:</span>
            <input type="text" placeholder="Enter number"  required>
          </div>
          <div class="input-box">
            <span class="details">Last Calibration Date:</span>
            <div><input type="date" placeholder="Calculated"  required>
              </div> 
          </div>
         
         
              
        </div>
          
        </form>
</div>

    



<button type="button" class="collapsible">CT Ratio Test</button>
<div class="content">
<form action="#">
    <div class="user-details">  
        <span class="details">CT Ratio</span>
       <input type="text" placeholder="" required> 

        <span class="details">CT Accuracy Class</span>
       <input type="text" placeholder="" required>
        <br>
<table class = "table2">
  <tr>
    <th></th>
    <th colspan="3">CT of Phase A</th>
    <th colspan="3">CT of Phase B</th>
    <th colspan="3">CT of Phase C</th>
    
  </tr>
  <tr>
    <th >Phase</th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
    
  </tr>
  <tr>
     <th >Primary Current/A</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
  </tr>
  <tr>
     <th >Secondary Current/A</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td> 
  </tr>
     <tr>
   <th>P1,S2 Direction</th>
   <td colspan="3">          
            <select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
    <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
   <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td> 
  </tr>
  <tr>
     <th>S1,S2 Direction</th>
    <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
    <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
   <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
     
      
    
  </tr>

</table>  
        
        </div>
          
        </form>
</div>


<button type="button" class="collapsible">RMR and Enclosure data</button>
    <div class="content">
 <form action="#">
        <h3>RMR Facility</h3>  
        <div class="user-details">
          <div class="input-box">
            <span class="details">Moderm Serial No:</span>
            <input type="text" placeholder="" required>
          </div>
          <div class="input-box">
            <span class="details">Moderm LED</span>
            <select class ="drop-down">
                <option value="volvo">Blinking</option>
                <option value="saab">Continous ON</option>
                <option value="saab">OFF</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Signal Level:</span>
            <select class ="drop-down">
                <option value="AAA">Ok </option>
                <option value="BBB"> Poer</option>
                <option value="BBB" >No CC3</option> 
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Phone No</span>
             <input type="number" placeholder="" required>
          </div>
          <div class="input-box">
            <span class="details">Sim No </span>
            <input type="number" placeholder="" required>
          </div> 
          <div class="input-box">
            <span class="details">Condition:Antena</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
              </select>
          </div>
          <div class="input-box">
            <span class="details">Condition:Data Cable</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
              </select>
          </div>
          </div>
            </form>
        <form action="#">
            <h3>Enclosure</h3>
         <div class="user-details">
            
         <div class="input-box">
            <span class="details">Available</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
              </select>
          </div>
            <div class="input-box">
            <span class="details">Properly Fixed</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
              </select>
          </div> 
            <div class="input-box">
            <span class="details">Condition</span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderater</option>
                <option value="saab">Not Good</option>
                
              </select>
          </div> 
            <div class="input-box">
            <span class="details">CT Location</span>
            <select class ="drop-down">
                <option value="volvo">CT Outside</option>
                <option value="saab">Inside</option>
              </select>
          </div>
             <div class="input-box">
            <span class="details">Earthing</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
              </select>
          </div>
            </div>
            
            
        </form>
</div>


<button type="button" class="collapsible">Availability Service Providers</button>
<div class="content">
   <form action="#">
    <div class="user-details">
        
   
        
<table class = "table">
  
  <tr>
     <th >Dailog</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
   <tr>
     <th >Mobitel</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
     <tr>
     <th >Etisala</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
      <tr>
     <th >Airtel</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
     
      <tr>
     <th >Hutch</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>


    
</table>
        
        
        
        
        
        
        
        </div>
          
        </form>
         <form action="#">
            <h3>Main Wiring</h3>
         <div class="user-details">
            
         <div class="input-box">
            <span class="details">MCCB</span>
            <input type="text" placeholder="" required>
          </div>
            <div class="input-box">
            <span class="details">Cable Size</span>
            <input type="text" placeholder="" required>
          </div> 
            <div class="input-box">
            <span class="details">Condition</span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderater</option>
                <option value="saab">Not Good</option>
                
              </select>
          </div> 
        </div>    
        </form>
</div>
    
    


    


    



    

<button type="button" class="collapsible">Cubicle:</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Door availability</span>
            <select class ="drop-down">
                <option value="AAA">Yes </option>
                <option value="BBB"> No</option>
                 
            </select> 
          </div>
            
            
            
          <div class="input-box">
            <span class="details">Cleanliness</span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderate </option>
                <option value="volvo">Not Good</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Door Condition </span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderate </option>
                <option value="volvo">Not Good</option>
                 
            </select>
          </div> 
          <div class="input-box">
            <span class="details">Access to Cubicle</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
                 
            </select>
          </div>
            
        </div>
          
          
          
        </form>
        
</div>
    
<button type="button" class="collapsible">Test Report Conclusion - Es</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Action Taken(Changes Done)</span>
              <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
         <div class="input-box">
            <span class="details">Present Condition</span>
              <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
          <div class="input-box">
            <span class="details">Remarks</span>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
          <div class="input-box">
            <span class="details">Tested By</span>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea> 
          </div>
          <div class="input-box">
            <span class="details">Test Date</span>
            <input type="text" placeholder="" required>
          </div>
        </div>
          
          
          
        </form>
        
</div> 
    
<button type="button" class="collapsible"> EE recommendation </button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
         <div class="input-box">
            <span class="details">Note</span>
              <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
        <div>
           <div class="user-details">
              <div class="input-box">
            <span class="details">Date</span>
              <input type="date" placeholder="" required>
          </div>
               <div class="input-box">
            <span class="details">Signature</span>
              <input type="text" placeholder="---------------------" required>
          </div>
              
              </div>
          </div>
        </div>
        </form>
    
        
</div> 
    
    
   
          <input type="submit" class="button3" value="Submit">
        
    

        
    




<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>

</body>
</html>