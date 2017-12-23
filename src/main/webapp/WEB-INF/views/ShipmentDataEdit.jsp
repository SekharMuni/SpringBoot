<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipment Edit</title>
<style type="text/css">
.error{
  color:red
}
</style>
</head>
<body>
<h1>Welcome to Shipment EDIT Page!!</h1>
<form:form action="updateShipment" method="post" modelAttribute="shipment">
<pre>
ShipmentId		:<form:input path="shipmentId" value="${shipment.shipmentId}" readonly="true"/>
				<form:errors path="shipmentId" cssClass="error"/><br>
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
				<form:errors path="shipmentGrade" cssClass="error"/>
Description	:<form:textarea  path="description"></form:textarea> <br>
				<form:errors path="description" cssClass="error"/>
		 <input type="submit" value="Update Shipment"/>
</pre>
</form:form>
</body>
</html>