<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipment Register Page</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<style type="text/css">
.error{
	color:red
}
</style>
</head>
<body>
<h1>Welcome to Shipment Register Page!!</h1>
<form:form action="insertShipment" method="post" modelAttribute="shipment">
<pre>
Shipment Mode   :<form:select path="shipmentMode">
					<form:option value="">--select--</form:option>
					<c:forEach items="${shipmentModes}" var="s">
					<form:option value="${s}">${s}</form:option>
					</c:forEach>
				 </form:select>
			<form:errors path="shipmentMode" cssClass="error"/><br>
ShipmentCode	:<form:input path="shipmentCode"/>
 		<form:errors path="shipmentCode" cssClass="error"/><br>
Enable Shipment	:<form:checkbox path="shmnt" value="YES"/>YES
 		<form:errors path="shmnt" cssClass="error"/><br>
ShipmentGrade	:<form:radiobuttons path="shipmentGrade" items="${shipmentGrades}"/> 
 			<form:errors path="shipmentGrade" cssClass="error"/><br>
Description	:<form:textarea  path="description"></form:textarea>
 			<form:errors path="description" cssClass="error"/><br>
		 <input type="submit" value="Create Shipment"/>
</pre>
</form:form>
${message}
<br/>     
<a href="getAllShipments">View All Shipments</a>
</body>
