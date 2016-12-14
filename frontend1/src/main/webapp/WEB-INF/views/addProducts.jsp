<%-- <%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h3>User Information</h3>
<form:form method="POST" action="addproduct" commandName="product" enctype="multipart/form-data">
   <table>
   
    <tr>
        <td><form:label path="prod_name">Product Name</form:label></td>
        <td><form:input path="prod_name" /></td>
    </tr>
    <tr>
        <td><form:label path="quantity">Quantity</form:label></td>
        <td><form:input path="quantity" /></td>
    </tr>
    <tr>
        <td><form:label path="prod_price">Price</form:label></td>
        <td><form:input path="prod_price" /></td>
    </tr>
    <tr><td>File to upload:</td><td><form:input type="file" path="image" /></td></tr>
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
</html>
 --%>
 
<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
	<form:form method="POST" action="addProduct" commandName="product"
		enctype="multipart/form-data">
		<table>
			
			<tr>
				<td>Prod Name</td>
				<td><form:input type="text" path="prod_name" /></td>
			</tr>
						<tr>
				<td>Price</td>
				<td><form:input type="number" path="prod_price" /></td>
			</tr>
			<tr>
				<td> Quantity</td>
				<td><form:input type="number" path="quantity" /></td>
			</tr>
			<tr>
				<td ><form:label path="supplier">
						<spring:message text="Supplier:" />
					</form:label></td>
					
				<td><form:select path="supplier.sup_name" items="${supplierList}"
						itemValue="sup_name" itemLabel="sup_name"></form:select></td>
			</tr>
			<tr>
				<td ><form:label path="category">
						<spring:message text="Category:" />
					</form:label></td>
					
				<td><form:select path="category.catname" items="${categoryList}"
						itemValue="catname" itemLabel="catname"></form:select></td>
			</tr>
			<%-- <tr>
				<td>Category</td>
				<td><form:select path="category.cat_id" items="${categoryList}"
						itemValue="id" itemLabel="id"></form:select></td>
			</tr> --%>
			
			<tr>
				<td>Prod Image</td>
				<td><form:input type="file" path="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <input
					type="submit" value="Cancel" /></td>
			</tr>
		</table>
		<center>
				<c:if test="${!empty product.prod_name}">
						<input id="button" type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if>
					<c:if test="${empty product.prod_name}">
						<input id="button" type="submit" value="<spring:message text="Add Product"/>" />
					</c:if>
			</center>
	</form:form>
<h2>Product List</h2>
<c:if test="${!empty productList}">
	<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>category ID</th>
			<th>Supplier Id</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.prod_id}</td>
				<td>${product.prod_name}</td>
				<td>${product.prod_price}</td>
				<td>${product.quantity}</td>
				<td>${product.category.cat_id}</td>
				<td>${product.supplier.sup_id}</td>
				<td><a href="<c:url value='editProduct${product.prod_id}'/>">Edit</a></td>
				<td><a href="<c:url value='deleteProduct${product.prod_id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>

</html>





