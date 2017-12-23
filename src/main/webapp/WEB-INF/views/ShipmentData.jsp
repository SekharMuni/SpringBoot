<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipment Data</title>
</head>
<body>
<h1>Welcome To Shipment Data</h1>
<hr/>
<table border="1">
<tr>
	<th>Shipment Id</th><th>Shipment Mode</th><th>Shipment Code</th><th>Shmnt</th><th>Shipment Grade</th><th>Created Date</th><th>Lastmodified Date</th><th>Description</th>
<tr>
<c:forEach items="${shipments}" var="shipment">
<tr>
	<td><c:out value="${shipment.shipmentId}"/></td>
	<td><c:out value="${shipment.shipmentMode}"/></td>
	<td><c:out value="${shipment.shipmentCode}"/></td>
	<td><c:out value="${shipment.shmnt}"/></td>
	<td><c:out value="${shipment.shipmentGrade}"/></td>
	<td><c:out value="${shipment.createdDate}"/></td>
	<td><c:out value="${shipment.lastmodifiedDate}"/></td>
	<td><c:out value="${shipment.description}"/></td>
	<td><a href="deleteShipment?shipmentId=${shipment.shipmentId}">DELETE</a></td>
	<td><a href="editShipment?shipmentId=${shipment.shipmentId}">EDIT</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>