<%-- <%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<center>
	<h1>Registration</h1>
	<p>
	REGISTERED? <a href="login">SIGN IN</a>
	</p>
	<a href="${flowExecutionUrl}&_eventId_home">Home</a>
	<form:form commandName="us">

		<table>
			<tr>
				<td>User Name</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td>Enter Password</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td>Enter Confirmed Password</td>
				<td><form:input type="password" path="confirmpassword" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
			<tr>
				<td>Email Id</td>
				<td><form:input type="email" path="emailid" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td>Phone no.</td>
				<td><form:input type="text" path="phno" /></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('phno')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>


			<tr>
				<td>City</td>
				<td><form:input type="text" path="address" /></td>
			</tr>

			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			</table>

		<br />
		<br />

		<div class="center">
			<input type="submit" name="_eventId_submit" value="submit">
		</div>

	</form:form>
</center>
<br />
<%@ include file="footer.jsp"%>
 --%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
</head>
<body>
<a href="${flowExecutionUrl}&_eventId_home">Home</a>

	<form:form method="POST" commandName="us">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
	
			<tr>
				<td>Contact :</td>
				<td><form:input path="phno" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('phno')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Email :</td>
				<td><form:input path="emailid" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			

			<tr>
				<td>Password :</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
				<td>Confirm Password :</td>
				<td><form:input type="password" path="confirmpassword" /></td>
			</tr>
			<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
			
			<tr>
			</tr>
			
		</table>
		<div class = center>
			<input type="submit" name="_eventId_submit" value="submit" ></div>
			
			</div>
		
		<br>
	</form:form>
</body>
</html>
 