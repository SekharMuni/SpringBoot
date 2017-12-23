<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uom Data</title>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script> 
</head>
<body>
<h1>Welcome to UOM Data Page!!</h1>
<hr/>
Search Screen
<fm:form action="getAllUoms" method="get" modelAttribute="uom">
<table>
<tr>
<td>UOM Type 	:<fm:select path="uomType">
			<fm:option value="">--select--</fm:option>
			<fm:option value="PACK">PACKING</fm:option>
			<fm:option value="NOPACK">NO PACKING</fm:option>
			<fm:option value="NA">-NA-</fm:option>
			</fm:select>
</td>
<td>UOM Model  :<fm:input type="text" path="uomModel"/></td>
<td>Description:<fm:textarea path="description"></fm:textarea></td>
<td><input type="submit" value="SEARCH"/></td>
</tr>
</table>
</fm:form>

<hr/>
<div class="container">
 <c:if test="${!empty uoms}">
 <table class="table table-striped table-bordered table-hover table-striped">
 <thead class="thead-dark">
<tr>
 
	<th>ID</th><th>TYPE</th><th>UOM</th><th>Created</th><th>Last Modified</th><th>Notes</th>
</tr>
</thead>
 <tbody>
<c:forEach items="${uoms}" var="uom">
<tr>
<td><c:out value="${uom.uomId}"/></td>
<td><c:out value="${uom.uomType}"/></td>
<td><c:out value="${uom.uomModel}"/></td>
<td><c:out value="${uom.createdDate}"/></td>
<td><c:out value="${uom.lastModifiedDate}"/></td>
<td><c:out value="${uom.description}"/></td>
<td><a href="deleteUom?uomId=${uom.uomId}">DELETE</a></td>
<td><a href="editUom?uomId=${uom.uomId}">EDIT</a></td>
</tr>
</tbody>
</c:forEach>
</table>
</div>

  <c:if test="${!uomPage.isFirst()}">
	<a href="getAllUoms?page=0">First</a>&nbsp;
  </c:if>
  
  <c:if test="${uomPage.hasPrevious()}">
	<a href="getAllUoms?page=${uomPage.getNumber()-1}">Previous</a>&nbsp;
  </c:if>
  
  <c:forEach begin="0" end="${uomPage.getTotalPages()-1}" var="i">
	<c:choose>
		<c:when test="${uomPage.getNumber()eq i}">
		<c:out value="${i+1}"/>&nbsp;
		</c:when>
		<c:otherwise>
			<a href="getAllUoms?page${i}"><c:out value="${i+1}"/></a>&nbsp;
		</c:otherwise>
	</c:choose>
 </c:forEach>
 
 <c:if test="${uomPage.hasNext()}">
   <a href="getAllUoms?page=${uomPage.getNumber()+1}">Next</a>&nbsp;
 </c:if>
 
 <c:if test="${uomPage.isLast()}">
    <a href="getAllUoms?page=${uomPage.getNumber()-1}">Last</a>&nbsp;
 </c:if>
 </c:if>
 <c:if test="${empty uoms}">
 <h2>NO RECORDS FOUND</h2>
 </c:if>
</body>
</html>