<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OrderMethod Data</title>
</head>
<body>
<h1>OrderMethod Data</h1>
<table border="1">
	<tr>
	<th>OrderMtdId</th><th>OrderMode</th><th>OrderCode</th><th>OrderMtd</th><th>OrderAccept</th><th>CreatedDate</th><th>LastModifiedDate</th><th>Description</th>
	</tr>
	<c:forEach items="${orderMethods}" var="orderMethod">
	<tr>
	<td><c:out value="${orderMethod.orderMethodId}"/></td>
	<td><c:out value="${orderMethod.orderMode}"/></td>
	<td><c:out value="${orderMethod.orderCode}"/></td>
	<td><c:out value="${orderMethod.orderMtd}"/></td>
	<td><c:out value="${orderMethod.orderAccept}"/></td>
	<td><c:out value="${orderMethod.createdDate}"/></td>
	<td><c:out value="${orderMethod.lastModifiedDate}"/></td>
	<td><c:out value="${orderMethod.description}"/></td>
	<td><a href="deleteOrderMethod?orderMethodId=${orderMethod.orderMethodId}">DELETE</a></td>
	<td><a href="editOrderMethod?orderMethodId=${orderMethod.orderMethodId}">EDIT</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>