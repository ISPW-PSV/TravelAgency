<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     isELIgnored="false"%> <%-- Very important attribute!! Without this the "${}" expression is not recognized! --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="clientBean" scope="request" class="it.ispw.psv.travelagency.ClientBean" />
<jsp:setProperty name="clientBean" property="*" />

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
		First name: <input type="text" name="name"><br>
		Last name: <input type="text" name="surname"><br>
		<select name="payamentMethod">
			<option value="None">None</option>
			<c:forEach items="<%= it.ispw.psv.travelagency.PaymentMethod.values() %>" var="method">
	        	<option value="${method}">${method}</option>        
	        </c:forEach>
		</select>
		<br>
		<c:forEach items="<%= it.ispw.psv.travelagency.Gender.values() %>" var="gender">
			<input type="radio" name="gender" value="${gender}">${gender}<br>   
	    </c:forEach>
	    <input name="registration" type="submit" value="Register">
    </form>
</body>
</html>