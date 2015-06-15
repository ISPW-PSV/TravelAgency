<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%> <%-- Very important attribute!! Without this the "${}" expression is not recognized! --%>
<%-- Use JSTL lib in order to add some useful feature --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Import JAVA classes here --%>
<%@ page import="it.ispw.psv.travelagency.RegistrationForm" %>

<%-- Prepare ClientBean and set all property from the request (if they are available) --%>
<jsp:useBean id="clientBean" scope="request" class="it.ispw.psv.travelagency.ClientBean" />
<jsp:setProperty name="clientBean" property="*" />

<%-- TODO: improve, not the right way --%>
<%
	if (request.getParameter("registration") != null) {
		//TODO: control if all field is not null
		RegistrationForm.registration(clientBean.getMailAddress(), clientBean.getName(), clientBean.getPhoneNumber(), clientBean.getSurname(), clientBean.getGender(), request.getParameter("username"), request.getParameter("password"));
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Agency - Registration Form</title>

<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

</head>
<body>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <!-- Include for datapicker -->
    <script src="<c:url value="/resources/js/bootstrap-datepicker.min.js" />"></script>
    <script>$(document).ready(function(){
    	$('#sandbox-container input').datepicker({
    		format: "dd/mm/yyyy",
    	    startView: 2
    	});
    });</script> 

    <form class="form-horizontal" action="registration.jsp" name="registrationForm" method="POST">
	<fieldset>
	
	<!-- Form Name -->
	<legend>Registration form</legend>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="name">Name</label>  
	  <div class="col-md-4">
	  	<input id="name" name="name" type="text" placeholder="Name" class="form-control input-md" required="">
	  	<span class="help-block">Insert your name</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="surname">Surname</label>  
	  <div class="col-md-4">
	  	<input id="surname" name="surname" type="text" placeholder="Surname" class="form-control input-md" required="">
	  	<span class="help-block">Insert your surname</span>  
	  </div>
	</div>
	
	<!-- Multiple Radios -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="Gender">Gender</label>
	  <div class="col-md-4">
		  <c:forEach items="<%= it.ispw.psv.travelagency.Gender.values() %>" var="gender">  <%--TODO: improve, not the right way --%>
				<div class="radio">
					<label for="${gender}">
						<input type="radio" name="gender" value="${gender}">
						${gender}
					</label>
				</div>   
	      </c:forEach>
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="birthdate">Birthdate</label>  
	  <div class="col-md-4" id="sandbox-container">
	  	<input id="birthdate" name="birthdate" type="text" placeholder="01/01/1996" class="form-control" required="">
	  	<span class="help-block">Insert your birthdate</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="address">Address</label>  
	  <div class="col-md-4">
	  	<input id="address" name="address" type="text" placeholder="Piazza Santa Maria" class="form-control input-md" required="">
	  	<span class="help-block">Insert your address</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="number">Number</label>  
	  <div class="col-md-4">
	  	<input id="number" name="number" type="text" placeholder="12" class="form-control input-md">
	  	<span class="help-block">Insert your number</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="city">City</label>  
	  <div class="col-md-4">
	  	<input id="city" name="city" type="text" placeholder="Zagarolo" class="form-control input-md" required="">
	  	<span class="help-block">Insert your city</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="postalCode">Postal code</label>  
	  <div class="col-md-4">
	  	<input id="postalCode" name="postalCode" type="text" placeholder="00039" class="form-control input-md" required="">
	  	<span class="help-block">Insert your postal code</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="province">Province</label>  
	  <div class="col-md-4">
	  	<input id="province" name="province" type="text" placeholder="Rome" class="form-control input-md" required="">
	  	<span class="help-block">Insert your province</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="provinceCode">Province Code</label>  
	  <div class="col-md-4">
	  	<input id="provinceCode" name="provinceCode" type="text" placeholder="RM" class="form-control input-md" required="">
	  	<span class="help-block">Insert your province code</span>  
	  </div>
	</div>
	
	<!-- Prepended text-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="phoneNumber">Phone Number</label>
	  <div class="col-md-4">
	    <div class="input-group">
	      <span class="input-group-addon">+39</span>
	      <input id="phoneNumber" name="phoneNumber" class="form-control" placeholder="123456789" type="text" required="">
	    </div>
	    <p class="help-block">Insert your phone number</p>
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="mailAddress">E-mail Address</label>  
	  <div class="col-md-4">
	  	<input id="mailAddress" name="mailAddress" type="text" placeholder="name@example.com" class="form-control input-md" required="">
	  	<span class="help-block">Insert your e-mail address</span>  
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="username">Username</label>  
	  <div class="col-md-4">
	  	<input id="username" name="username" type="text" placeholder="Username" class="form-control input-md" required="">
	  	<span class="help-block">Insert your username</span>  
	  </div>
	</div>
	
	<!-- Password input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="password">Password</label>
	  <div class="col-md-4">
	    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
	    <span class="help-block">Insert your password</span>
	  </div>
	</div>
	
	<!-- Select Basic -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="favouritePayamentMethod">Favourite Payament Method</label>
	  <div class="col-md-4">
	    <select id="favouritePayamentMethod" name="favouritePayamentMethod" class="form-control">
	      <option value="None">None</option>
			<c:forEach items="<%= it.ispw.psv.travelagency.PaymentMethod.values() %>" var="method"> TODO: improve, not the right way
	        	<option value="${method}">${method}</option>        
	        </c:forEach>
	    </select>
	  </div>
	</div>
	
	<!-- Button -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="registration"></label>
	  <div class="col-md-4">
	   	<button id="registration" name="registration" class="btn btn-success">Register</button>
	  </div>
	</div>
	
	</fieldset>
	</form>
    
    
    
</body>
</html>