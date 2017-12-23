<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WhUserType Data</title>
</head>
<body>
<h1>WhUserType Date Page!!!</h1>
<table border="1">
<tr>
<th>WhUserTypeId</th><th>UserType</th><th>WhUserCode</th><th>WhUserFor</th><th>WhUserMail</th>
<th>WhUserContact</th><th>WhUserIdType</th><th>WhUserIdOther</th><th>WhUserIdNumber</th>
<th>CreatedDate</th><th>lastModifiedDate</th>
</tr>

<c:forEach items="${whUserTypes}" var="s">
<tr>
	<td><c:out value="${s.whUserTypeId}"></c:out></td>
	<td><c:out value="${s.userType}"></c:out></td>
	<td><c:out value="${s.whUserCode}"></c:out></td>
	<td><c:out value="${s.whUserFor}"></c:out></td>
	<td><c:out value="${s.whUserMail}"></c:out></td>
	<td><c:out value="${s.whUserContact}"></c:out></td>
	<td><c:out value="${s.whUserIdType}"></c:out></td>
	<td><c:out value="${s.whUserIdOther}"></c:out></td>
	<td><c:out value="${s.whUserIdNumber}"></c:out></td>
	<td><c:out value="${s.createdDate}"></c:out></td>
	<td><c:out value="${s.lastModifiedDate}"></c:out></td>
	<td><a href="deleteWhUserType?whUserTypeId=${s.whUserTypeId}">DELETE</a></td>
	<td><a href="editWhUserType?whUserTypeId=${s.whUserTypeId}">EDIT</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>