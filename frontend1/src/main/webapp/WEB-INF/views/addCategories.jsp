<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
<h3> Category Information</h3>
<title>Spring MVC Form Handling</title>
<form:form method="POST" action="addcategory" commandName="category">
   <table>

<tr>
        <td><form:label path="cat_name">Category Name</form:label></td>
        <td><form:input path="cat_name" /></td>
    </tr>
    
     <tr>
        <td><form:label path="cat_description">Description</form:label></td>
        <td><form:input path="cat_description" /></td>
        </tr>
         <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td colspan="2">
            <input type="reset" value="Cancel"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html> --%>

<%-- <ul>
<form class="bs-example bs-example-form" role="form">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">Go!</button>
							</span>

						</div>
					</div>
				</div>
			</form>
		</ul>

 --%>
 <h1>Add a Category</h1>
<c:url var="addAction" value="/category/add"></c:url>
<form:form action="${addAction}" modelAttribute="category">
	<table class="table table-hover">
		<tr>
			<tr>
			<td><form:label path="catname">
					<spring:message text="Name" />
				</form:label></td>
			<td><form:input path="catname" required="true" /></td>
		</tr>
		<tr>
			<td><form:label path="cat_description">
					<spring:message text="Description" />
				</form:label></td>
			<td><form:input path="cat_description" required="true" /></td>
		</tr>
		<tr>
			<td><c:if test="${!empty category.catname}">
					<input id="button" type="submit"
						value="<spring:message text="Edit Category"/>" />
				</c:if>
				<c:if test="${empty category.catname}">
					<input id="button" type="submit"
						value="<spring:message text="Add Category"/>" />
				</c:if></td>
		</tr>
	</table>
</form:form>
<br>
<%-- <h3>Category List</h3>
<c:if test="${!empty categoryList}">
	<table class="tg">
		<tr>
			<th width="120">Category Name</th>
			<th width="120">Description</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.catname}</td>
				<td>${category.cat_description}</td>
				<td><a
					href="<c:url value='category/edit/${category.cat_id}' />">Edit</a></td>
				<td><a
					href="<c:url value='category/remove/${category.cat_id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if> --%>
<br>