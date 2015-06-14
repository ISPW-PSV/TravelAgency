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
		//TODO: call checks from RegistrationForm and if all is correct call validate()
		System.out.println(clientBean.getName());
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Agency - Registration Form</title>
</head>
<body>
	<form action="registration.jsp" name="registrationForm" method="POST">
		First name: 
		<input type="text" name="name">
		<br>
		Last name: 
		<input type="text" name="surname">
		<br>
		E-mail address: 
		<input type="text" name="mailAddress">
		<br>
		Phone number: 
		<input type="text" name="phoneNumber">
		<br>
		Username: 
		<input type="text" name="username">
		<br>
		Password 
		<input type="password" name="password">
		<br>
		Favourite Payament Method:
		<select name="payamentMethod">
			<option value="None">None</option>
			<c:forEach items="<%= it.ispw.psv.travelagency.PaymentMethod.values() %>" var="method"> <%-- TODO: improve, not the right way --%>
	        	<option value="${method}">${method}</option>        
	        </c:forEach>
		</select>
		<br>
		Gender:
		<c:forEach items="<%= it.ispw.psv.travelagency.Gender.values() %>" var="gender">  <%-- TODO: improve, not the right way --%>
			<br><input type="radio" name="gender" value="${gender}">${gender}   
	    </c:forEach>
	    <br>
	    <input name="registration" type="submit" value="Register">
    </form>
</body>
</html>