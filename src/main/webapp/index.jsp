<%--
 + Realized for the course of ISPW at University of Roma Tor Vergata-
 + Claudio Pastorini, Omar Shalbu and Federico Vagnoni.
 + A.A. 2014/2015
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%> <%-- Very important attribute!! Without this the "${}" expression is not recognized! --%>
<%-- Use JSTL lib in order to add some useful feature --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%-- Prepare ClientBean and set all property from the request (if they are available) --%>
<jsp:useBean id="clientBean" scope="session" class="it.ispw.psv.travelagency.ClientBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta name="description" content="">
	
	    <title>Travel Agency - HomePage</title>
		
        <%@include file="base_header.html" %>
		
	  </head>
	
	  <body>
        <%@include file="navbar.html" %>
	
	    <!-- Main jumbotron for a primary marketing message or call to action -->
	    <div class="jumbotron">
	      <div class="container">
	        <h1>Hello, world!</h1>
	        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
	        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more »</a></p>
	      </div>
	    </div>
	
	    <div class="container">
	      <!-- Example row of columns -->
	      <div class="row">
	        <div class="col-md-4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
	        </div>
	        <div class="col-md-4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
	       </div>
	        <div class="col-md-4">
	          <h2>Heading</h2>
	          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
	          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
	        </div>
	      </div>
	
	      <hr>
	
	      <footer>
			<%@include file="footer.html" %>
	      </footer>
	    </div> <!-- /container -->
	
	    <%@include file="base_scripts.html" %>
	
	</body>
</html>