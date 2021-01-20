<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Products</title>
</head>
<body>
<h1>List Products</h1>
<h3><a href="add.html">Add More Product</a></h3>

<c:if test="${!empty products}">
	<table align="left" border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Launch Date</th>
			<th>Product End Date</th>
			<th>Product Details</th>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.pid}"/></td>
				<td><c:out value="${product.pname}"/></td>
				<td><c:out value="${product.plaunchdate}"/></td>
				<td><c:out value="${product.penddate}"/></td>
				<td><c:out value="${product.pedtails}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>