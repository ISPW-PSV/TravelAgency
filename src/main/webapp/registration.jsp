<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%> <%-- Very important attribute!! Without this the "${}" expression is not recognized! --%>
<%-- Use JSTL lib in order to add some useful feature --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Import JAVA classes here --%>
<%@ page import="it.ispw.psv.travelagency.RegistrationForm, org.joda.time.DateTime, org.joda.time.format.DateTimeFormat, org.joda.time.format.DateTimeFormatter, it.ispw.psv.travelagency.PhysicalAddress, it.ispw.psv.travelagency.Login, it.ispw.psv.travelagency.Gender, it.ispw.psv.travelagency.ValidateException,  it.ispw.psv.travelagency.ValidateType" %>

<%-- Prepare ClientBean and set all property from the request (if they are available) --%>
<jsp:useBean id="clientBean" scope="request" class="it.ispw.psv.travelagency.ClientBean" />
<jsp:setProperty name="clientBean" property="*" />

<%-- TODO: improve, not the right way --%>
<%
	if (request.getParameter("registration") != null) {
		//TODO: control if all fields are not null
		
		// Generate birthdate
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/mm/yyyy");
		DateTime birthdate = DateTime.parse(request.getParameter("birthdateString"), dateTimeFormatter);
		// Generate physical address
		PhysicalAddress physicalAddress = new PhysicalAddress(request.getParameter("address"), request.getParameter("number"), request.getParameter("city"), request.getParameter("postalCode"), request.getParameter("province"), request.getParameter("provinceCode"));
		// Generate login
		Login login = new Login(request.getParameter("username"), request.getParameter("password"));
		
		// Set birthdate, physicalAddress and login
		clientBean.setBirthdate(birthdate);
		clientBean.setPhysicalAddress(physicalAddress);
		clientBean.setLogin(login);
		
		// Call controller
		try {
			RegistrationForm.registration(clientBean.getMailAddress(), clientBean.getName(), clientBean.getPhoneNumber(), clientBean.getSurname(), clientBean.getGender(), clientBean.getBirthdate(), clientBean.getPhysicalAddress(), clientBean.getLogin());
		} catch(ValidateException exception) {
			if(exception.getType() == ValidateType.EmailAddress) {
				
			}
		}
	} else {
		
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	   	<meta charset="utf-8">	
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Travel Agency - Registration Form</title>
		
		<!-- Bootstrap -->
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<!-- Datapicker -->
		<link href="<c:url value="/resources/css/bootstrap-datepicker.min.css" />" rel="stylesheet">
	</head>
	<body>
		<!-- jQuery -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <!-- Bootstrap -->
	    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	    <!-- Datapicker -->
	    <script src="<c:url value="/resources/js/bootstrap-datepicker.min.js" />"></script>
	    <script>
		    // Set Datapicker
		    $(document).ready(function() {
		    	$('#datapicker-container input').datepicker({
		    		format: "dd/mm/yyyy",
		    	    startView: 2
		    	});
		    });
		    
		    function getErrorMessage(error) {
		    	return "<div class=\"alert alert-danger\" role=\"alert\"> \  <span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span> \   <span class=\"sr-only\">Error:</span> \ Enter a valid \"" + error + "\"  \ </div>";
		    }
		    
		    // Chech null input required
		    $(document).ready(function() {
		    	$("#registrationForm").on("submit", function(event) {
			        var fields = $("input.required");
			        for(var i = 0; i < fields.length; i++) {
			            if($(fields[i]).val() == '') {
				    		event.preventDefault();
							
				    		var name = $(fields[i]).closest(":has(label)").find("label").text();
				    		
			            	$(fields[i]).closest(":has(span)").find("span").after(getErrorMessage(name));
			            } else {
			            	// TODO: remove
			            }
			        }
		    	});
		    });	    
	        
	        // Check email address
	        $(document).ready(function() {
	        	var mailAddressInput = $("#mailAddress");
	        	
	        	mailAddressInput.change(function(event) {	
	        		var regex = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	       			if (!regex.test(mailAddressInput.val())) {
	       				var name = mailAddressInput.closest(":has(label)").find("label").text();
			    		
	       				mailAddressInput.closest(":has(span)").find("span").after(getErrorMessage(name));
	       			} else {
	       				//TODO: remove
	       			}
	        	});
	        });

		    // Check phone number
	        $(document).ready(function() {
	        	var phoneNumberInput = $("#phoneNumber");
	        	
	        	phoneNumberInput.change(function(event) {	
	        		var fixRegex = new RegExp("^([0-9]*\\-?\\ ?\\/?[0-9]*)$");
	        		var mobileRegex = new RegExp("^([+]39)?((38[{8,9}|0])|(34[{7-9}|0])|(36[6|8|0])|(33[{3-9}|0])|(32[{8,9}]))([\\d]{7})$");
	       			if (!(fixRegex.test(phoneNumberInput.val()) && mobileRegex.test(phoneNumberInput.val()))) {
	       				var name = phoneNumberInput.closest(":has(label)").find("label").text();
			    		
	       				phoneNumberInput.closest(":has(span)").find("span").after(getErrorMessage(name));
	       			} else {
	       				//TODO: remove
	       			}
	        	});
	        });
	        
	        //TODO: check regex birthdate
	    
	    </script> 
	
	    <form class="form-horizontal" action="registration.jsp" id="registrationForm" name="registrationForm" method="POST">
			<fieldset>
				<!-- Form Name -->
				<legend>Registration form</legend>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="name">Name</label>  
				  <div class="col-md-4">
				  	<input id="name" name="name" type="text" placeholder="Name" class="form-control input-md required">
				  	<span class="help-block">Insert your name</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="surname">Surname</label>  
				  <div class="col-md-4">
				  	<input id="surname" name="surname" type="text" placeholder="Surname" class="form-control input-md required">
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
									<input type="radio" name="gender" value="${gender}" class="required">
									${gender}
								</label>
							</div>   
				      </c:forEach>
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="birthdateString">Birthdate</label>  
				  <div class="col-md-4" id="datapicker-container">
				  	<input id="birthdateString" name="birthdateString" type="text" placeholder="01/01/1996" class="form-control required">
				  	<span class="help-block">Insert your birthdate</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="address">Address</label>  
				  <div class="col-md-4">
				  	<input id="address" name="address" type="text" placeholder="Piazza Santa Maria" class="form-control input-md required">
				  	<span class="help-block">Insert your address</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="number">Number</label>  
				  <div class="col-md-4">
				  	<input id="number" name="number" type="text" placeholder="12" class="form-control input-md required">
				  	<span class="help-block">Insert your number</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="city">City</label>  
				  <div class="col-md-4">
				  	<input id="city" name="city" type="text" placeholder="Zagarolo" class="form-control input-md required">
				  	<span class="help-block">Insert your city</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="postalCode">Postal code</label>  
				  <div class="col-md-4">
				  	<input id="postalCode" name="postalCode" type="text" placeholder="00039" class="form-control input-md required">
				  	<span class="help-block">Insert your postal code</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="province">Province</label>  
				  <div class="col-md-4">
				  	<input id="province" name="province" type="text" placeholder="Rome" class="form-control input-md required">
				  	<span class="help-block">Insert your province</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="provinceCode">Province Code</label>  
				  <div class="col-md-4">
				  	<input id="provinceCode" name="provinceCode" type="text" placeholder="RM" class="form-control input-md required">
				  	<span class="help-block">Insert your province code</span>  
				  </div>
				</div>
				
				<!-- Prepended text-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="phoneNumber">Phone Number</label>
				  <div class="col-md-4">
				    <div class="input-group">
				      <span class="input-group-addon">+39</span>
				      <input id="phoneNumber" name="phoneNumber" class="form-control required" placeholder="123456789" type="text">
				    </div>
				    <p class="help-block">Insert your phone number</p>
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="mailAddress">E-mail Address</label>  
				  <div class="col-md-4">
				  	<input id="mailAddress" name="mailAddress" type="text" placeholder="name@example.com" class="form-control input-md required">
				  	<span class="help-block">Insert your e-mail address</span>  
				  </div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="username">Username</label>  
				  <div class="col-md-4">
				  	<input id="username" name="username" type="text" placeholder="Username" class="form-control input-md required">
				  	<span class="help-block">Insert your username</span>  
				  </div>
				</div>
				
				<!-- Password input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="password">Password</label>
				  <div class="col-md-4">
				    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md required">
				    <span class="help-block">Insert your password</span>
				  </div>
				</div>
				
				<!-- Select Basic -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="favouritePayamentMethod">Favourite Payament Method</label>
				  <div class="col-md-4">
				    <select id="favouritePayamentMethod" name="favouritePayamentMethod" class="form-control required">
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