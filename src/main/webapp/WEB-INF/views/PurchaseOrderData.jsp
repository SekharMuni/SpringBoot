<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PurchaseOrderData</title>
</head>
<body>
<h1>Welcome To PurchaseOrderData Page!!!</h1>
<table border="1">
<tr>
<th>ID</th><th>OrderCode</th><th>ShipmentMode</th><th>Vendor</th><th>ReffNumber</th><th>QualityCheck</th><th>Status</th><th>Description</th>
<!-- <th>CreatedDate</th><th>LMDate</th> -->
</tr>
<c:forEach items="${plists}" var="p">
<tr>
<td><c:out value="${p.poId}"></c:out></td>
<td><c:out value="${p.orderCode}"></c:out></td>
<td><c:out value="${p.shipmentMode.shipmentCode}"></c:out></td>
<td><c:out value="${p.vendor.whUserCode}"></c:out></td>
<td><c:out value="${p.referenceNumber}"></c:out></td>
<td><c:out value="${p.qualityCheck}"></c:out></td>
<td><c:out value="${p.defaultStatus}"></c:out></td>
<td><c:out value="${p.description}"></c:out></td>
<%-- <td><c:out value="${p.createdDate}"></c:out></td>
<td><c:out value="${p.lastModifiedDate}"></c:out></td> --%>
<c:if test="${'OPEN' eq p.defaultStatus ||'PICKING' eq p.defaultStatus}">
<td><a href="addPoItems?orderId=${p.poId}">Add Items</a></td>
<td><a href="editPurchaseOrder?poId=${p.poId}">Edit Items</a></td>
<td><a href="cancelOrder?poId=${p.poId}">Cancel Order</a></td>
</c:if>
<c:if test="${'ORDERED' eq p.defaultStatus}">
<td><a href="poConfirm?poId=${p.poId}">Confirm (Invoice)</a></td>
<td><a href="cancelOrder?poId=${p.poId}">Cancel Order</a></td>
</c:if>
<c:if test="${'INVOICED' eq p.defaultStatus}">
<td><a href="poInvoiceGen?poId=${p.poId}">Generate Invoice</a></td>
</c:if>
<%-- <td><a href="deletePurchaseOrder?poId=${p.poId}">DELETE</a></td>
<td><a href="editPurchaseOrder?poId=${p.poId}">EDIT</a></td> --%>
</tr>
</c:forEach>
</table>
</body>
</html>