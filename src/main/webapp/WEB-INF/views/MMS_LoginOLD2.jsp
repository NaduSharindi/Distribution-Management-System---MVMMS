<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="style.css">
  <!-- global styles -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/compiled/theme_styles.css"/>"/>
  
  <title>MMS Login</title>
    <style>
    * {
        
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  
}
.huuu {
background-color: #e8cc3f;
border: none;
color: #5e0303;
padding: 13px 125px;
text-align: center;
text-decoration: none;
display: inline-block;
font-size: 16px;
margin: 4px 2px;
cursor: pointer;
    
}

.huuu:hover {
background-color: #5e0303;
color:#e8cc3f;
}        
        
.login-wrapper {
  height: 100vh;
  width: 100vw;
  display: flex;
  justify-content: center;
  align-items: center;
}
.form {
  position: relative;
  width: 100%;
  max-width: 380px;
  padding: 80px 40px 40px;
  background: rgba(0,0,0,0.8);
  border-radius: 10px;
  color: #fff;
  box-shadow: 0 15px 25px rgba(0,0,0,0.5);
}
.form::before {
  content:'';
  position: absolute;
  top: 0;
  left: 0;
  width: 50%;
  height: 100%;
  background: rgba(255,255,255, 0.08);
  transform: skewX(-26deg);
  transform-origin: bottom left;
  border-radius: 10px;
  pointer-events: none;
}
.form img {
  position: absolute;
  top: 5px;
  left: calc(50% - 50px);
  width: 100px;
  background: rgba(255,255,255, 0.8);
  border-radius: 50%;
}
.form h2 {
  text-align: center;
  margin-top: 30px;
  letter-spacing: 1px;
  margin-bottom: 2rem;
  font-family: sans-serif;
  color: yellow;
  
}
.form .input-group {
  position: relative;
}
.form .input-group input {
  width: 100%;
  padding: 10px 0;
  font-size: 1rem;
  letter-spacing: 1px;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background-color: transparent;
  color: inherit;
}
.form .input-group span {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 1rem;
  pointer-events: none;
  transition: .3s ease-out;
}
.form .input-group input:focus + span,
.form .input-group input:valid + span {
  transform: translateY(-18px);
  color: yellow;
  font-size: .8rem;
}
.submit-btn {
  display: block;
  margin-left: auto;
  border: none;
  outline: none;
  background: #630303;
  font-size: 1rem;
  text-transform: uppercase;
  letter-spacing: 1px;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}
.submit-btn:hover{
        background-color: yellow;
        transform: scale(1.02);
        box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px rgba(0, 0, 0, 0.2);    
        } 

.forgot-pw {
  color: inherit;
}

#forgot-pw {
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  top: 0;
  left: 0;
  right: 0;
  height: 0;
  z-index: 1;
  background: #fff;
  opacity: 0;
  transition: 0.6s;
}
#forgot-pw:target {
  height: 100%;
  opacity: 1;
}
.close {
  position: absolute;
  right: 1.5rem;
  top: 0.5rem;
  font-size: 2rem;
  font-weight: 900;
  text-decoration: none;
  color: inherit;
}
        

    </style>
    
<title>MV - MMS Login</title>
<!-- bootstrap -->

<!-- RTL support - for demo only -->
<script src="<c:url value="/resources/js/demo-rtl.js"/>">
</script>
<!--
If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
And add "rtl" class to <body> element - e.g. <body class="rtl">
-->
<!-- libraries -->

 <!-- global styles -->

 <!-- this page specific styles -->

 <!-- google font libraries -->
<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'>
<!-- Favicon -->
<link type="image/x-icon" rel="shortcut icon" href="favicon.png" />

 <!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
function formSubmit()
{
document.loginForm.submit();
//document.getElementById("un").innerHTML = ${message};
//ScrollToElement("un");
}
</script>
    
</head>
<body>
    <div id="login-full-wrapper">
  <div class="login-wrapper">
    <form:form role="form" name="loginForm" class="form" method="POST" action="login">
      <img src="<c:url value="/resources/img/CEBImages/logo_newnew.png"/>" alt="">
      <h2>MAINTENANCE MANAGEMENT SYSTEM</h2>
      <div class="input-group">
        <input name="loginUser" class="form-control" type="text" placeholder="User Name">
       <span class="label label-danger">${errUser}</span>
      </div>
        
        
      <div class="input-group"> 
        <input name="loginPassword" type="password" class="form-control" placeholder="Password">
         <span class="label label-danger">${errPassword}</span>
      </div>
     <div id="remember-me-wrapper">   
     <div class="row">
      <div class="col-xs-6">  
        <div class="checkbox-nice">
        <input type="checkbox" id="remember-me" checked="checked" />
		<label for="remember-me">
		Remember me
		</label>
		</div>
        </div>
        
        <a href="index.html">
      <input type="Submit" value="Login" class="submit-btn" href="javascript:formSubmit()">
        </a>
      <a href="http://help.mms.ceb/" id="login-forget-link" class="col-xs-6">
          Need Help?
        </a>
         </div>
         </div>
    </form:form>
  </div>
    <!-- global scripts -->
<script src="<c:url value="/resources/js/demo-skin-changer.js"/>"> </script> <!-- only for demo -->
<script src="<c:url value="/resources/js/jquery.js"/>"> </script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"> </script>
<script src="<c:url value="/resources/js/jquery.nanoscroller.min.js"/>"> </script>
<script src="<c:url value="/resources/js/demo.js"/>"> </script> <!-- only for demo -->
<!-- this page specific scripts -->

<!-- theme scripts -->
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<!-- this page specific inline scripts -->
</div>
</body>
</html>