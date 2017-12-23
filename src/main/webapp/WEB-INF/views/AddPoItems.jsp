<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PurchaseOrder Item Page</title>
</head>
<body>
<h1>Welcome To PurchaseOrder Item Page!!!!</h1>
<form:form action="poItemAdd" method="post" modelAttribute="poDtl">
<form:hidden path="poHdrId" readonly="true"/>
<table border="1">
<tr>
 <td colspan="2">Order Code:<input type="text" value="${po.orderCode}" readonly="readonly"/></td>
</table>
<br/>
<table border="1">
<tr>
	<th>SlNo</th><th>Select Items</th><th>Quantity</th>
</tr>
<tr>
<td><form:input path="slno" readonly="true" size="2"/></td>
<td><form:select path="itemDetails" items="${venItems}" itemLabel="itemCode" itemValue="itemId"></form:select></td>
<td><form:input path="itemsQty"/></td>
<td><input type="submit" name="itmOpr" value="Add Item"></td>
</tr>
</table>
<br/>
<hr/>
<table border="1">
<tr>
	<th>Sl No</th><th>Items</th><td>Base Cost</td><th>Quantity</th>
</tr>
<c:forEach items="${po.details}" var="p">
<tr>
<td>${p.slno}</td>
<td>${p.itemDetails.itemCode}</td>
<td>${p.itemDetails.itemBaseCost}</td>
<td>${p.itemsQty}</td>
<td><a href="removeItem?slno=${p.slno}&orderId=${p.poHdrId}">Remove Item</a></td>
</tr>
</c:forEach>
</table>
<br/><br/>
<c:if test="${!empty po.details}">
<input type="submit" name="itmOpr" value="Save And Continue"/>
</c:if>
</form:form>
</body>
</html>