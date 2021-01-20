<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC</title>
	</head>
	<body>
		<h2>Add Product Data</h2>
		<form:form method="POST" action="/sdnext/save.html">
	   		<table>
			    <tr>
			        <td><form:label path="pid">Product ID:</form:label></td>
			        <td><form:input path="pid" value="${product.pid}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="pname">Product Name:</form:label></td>
			        <td><form:input path="pname" value="${product.pname}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="plaunchdate">Product Launch Date:</form:label></td>
			        <td><form:input path="plaunchdate" value="${product.plaunchdate}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="penddate">Product End  Date:</form:label></td>
			        <td><form:input path="penddate" value="${product.penddate}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="pdetails">Product Details:</form:label></td>
                    <td><form:input path="pdetails" value="${product.pdetails}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty products}">
		<h2>List Products</h2>
	<table align="left" border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Launch Date</th>
			<th>Product End Date</th>
			<th>Product Details</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.pid}"/></td>
				<td><c:out value="${product.pname}"/></td>
				<td><c:out value="${product.plaunchdate}"/></td>
				<td><c:out value="${product.penddate}"/></td>
				<td><c:out value="${product.pdetails}"/></td>
				<td align="center"><a href="edit.html?id=${product.pid}">Edit</a> | <a href="delete.html?id=${product.pid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>