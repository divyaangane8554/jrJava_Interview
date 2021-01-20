<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Policy Data</h2>
		<form:form method="POST" action="/sdnext/savep.html">
	   		<table>
			    <tr>
			        <td><form:label path="cId">Policy ID:</form:label></td>
			        <td><form:input path="cId" value="${policy.cId}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="cName">Policy Name:</form:label></td>
			        <td><form:input path="cName" value="${policy.cName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="cEmail">Policy Age:</form:label></td>
			        <td><form:input path="cEmail" value="${policy.cEmail}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="cMobNumber">Policy Salary:</form:label></td>
			        <td><form:input path="cMobNumber" value="${policy.cMobNumber}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
		<c:if test="${!empty policys}">
		<h2>List Policys</h2>
	<table align="left" border="1">
		<tr>
			<th>Policy ID</th>
			<th>Policy Name</th>
			<th>Policy Age</th>
			<th>Policy Salary</th>
			<th>Policy Address</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${policys}" var="policy">
			<tr>
				<td><c:out value="${policy.cId}"/></td>
				<td><c:out value="${policy.cName}"/></td>
				<td><c:out value="${policy.cEmail}"/></td>
				<td><c:out value="${policy.cMobNumber}"/></td>
				<td align="center"><a href="editp.html?id=${policy.cId}">Edit</a> | <a href="deletep.html?id=${policy.cId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>