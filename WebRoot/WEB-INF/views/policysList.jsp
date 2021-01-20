<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List Policys</h1>
<h3><a href="addp.html">Add More Policies</a></h3>

<c:if test="${!empty policys}">
	<table align="left" border="1">
		<tr>
			<th>Policy ID</th>
			<th>Policy Name</th>
			<th>Policy Age</th>
			<th>Policy Salary</th>
		</tr>

		<c:forEach items="${policys}" var="policy">
			<tr>
				<td><c:out value="${policy.cId}"/></td>
				<td><c:out value="${policy.cName}"/></td>
				<td><c:out value="${policy.cEmail}"/></td>
				<td><c:out value="${policy.cMobNumber}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>