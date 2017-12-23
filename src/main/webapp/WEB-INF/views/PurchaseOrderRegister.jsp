<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Order Register</title>
</head>
<body>
<h1>Welcome to Purchase Order Register Page!!</h1>
<form:form action="insertPurchaseOrder" method="post" modelAttribute="po">
<pre>
Order Code : <form:input path="orderCode"/>
<form:errors path="orderCode" cssClass="error"/>

Shipment Code:<form:select path="shipmentMode">
	<form:option value="">--select--</form:option>
	<form:options items="${shipmentModes}" itemLabel="shipmentCode" itemValue="shipmentId"/>
</form:select>
	<form:errors path="orderCode" cssClass="error"/><br>
	
Vendor:<form:select path="vendor">
	<form:option value="">--select--</form:option>
	<form:options items="${vendors}" itemLabel="whUserCode" itemValue="whUserTypeId"/>
</form:select>
	<form:errors path="orderCode" cssClass="error"/><br>

Reference Number : <form:input path="referenceNumber"/>
<form:errors path="referenceNumber" cssClass="error"/>
Quality Check : <form:radiobuttons path="qualityCheck" items="${qualityChecks}"/>
<form:errors path="qualityCheck" cssClass="error"/>

Default Status : <form:input path="defaultStatus" readonly="true"/>
<form:errors path="defaultStatus" cssClass="error"/>

Description : <form:textarea path="description"/>
<form:errors path="description" cssClass="error"/>

 <input type="submit" value="Place Order"/>

</pre>
</form:form>
${message}
<h1><a href="getAllPurchaseOrders">Get All PurchaseOreders</a></h1>
</body>
</html>