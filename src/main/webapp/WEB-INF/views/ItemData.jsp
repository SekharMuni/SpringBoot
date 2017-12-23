<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Data</title>
</head>
<body>
<h1>Item Data Page!!!</h1>
<table border="1">
 <tr>
	<th>Id</th><th>Code</th><th>Width</th><th>Length</th>
	<th>Height</th><th>BaseCost</th><th>BaseCurrency</th>
	<th>ItemUom</th><th>ItemSale</th><th>ItemPurchase</th>
	<th>itemVendor</th><th>itemCustomer</th><th>description</th>
	<th>CrtdDate</th><th>LastMfdDate</th>
 </tr>
   <c:forEach items="${items}" var="i">
   	<tr>
	<td><c:out value="${i.itemId}"/></td>
	<td><c:out value="${i.itemCode}"/></td>
	<td><c:out value="${i.itemWidth}"/></td>
	<td><c:out value="${i.itemLength}"/></td>
	<td><c:out value="${i.itemHeight}"/></td>
	<td><c:out value="${i.itemBaseCost}"/></td>
	<td><c:out value="${i.itemBaseCurrency}"/></td>
	<td><c:out value="${i.itemUom.uomModel}"/></td>
	<td><c:out value="${i.itemSaleOrdeMethod.orderCode}"/></td>
	<td><c:out value="${i.itemPurchaseOrdeMethod.orderCode}"/></td>
	<td>
	<c:forEach items="${i.itemVendors}" var="v">
		<c:out value="${v.whUserCode}"/> &nbsp;
	</c:forEach>
	</td>
	<td>
	<c:forEach items="${i.itemCustomers}" var="wv">
		<c:out value="${wv.whUserCode}"/> &nbsp;
	</c:forEach>
	</td>
	<td><c:out value="${i.description}"/></td>
	<td><c:out value="${i.createdDate}"/></td>
	<td><c:out value="${i.lastModifiedDate}"/></td>
	
	<td><a href="deleteItem?itemId=${i.itemId}">DELETE</a></td>
	<td><a href="editItem?itemId=${i.itemId}">EDIT</a></td>
  	</tr>
	</c:forEach>
</table>
</body>
</html>