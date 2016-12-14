<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  </head> 
   <body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">Gifts to shop Now</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home">Home</a></li>
        <li><a href="AboutUs">AboutUs</a></li>
        <li><a href="Products">Products</a></li>
       
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
      
							<c:choose>
								<c:when test="${empty loggedInUser}">

									<li><a href="#"><span
											class="glyphicon glyphicon-search"></span> search</a></li>
									<li><a href="signup"><span
											class="glyphicon glyphicon-user"></span> Sign Up</a></li>
									<li><a href="login"><span
											class="glyphicon glyphicon-log-in"></span> Login</a></li>

								</c:when>
								<c:when test="${not empty loggedInUser}">
									<td>Welcome ${loggedInUser}</td>
									<li><a href="perform_logout"><span
											class="glyphicon glyphicon-log-out"></span> Logout</a></li>
								</c:when>
							</c:choose>
							</ul>
		</div>
      
    </div>
  </nav>
 