<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Register</title>
<style type="text/css">
.errors{
	color:red;
}
</style>
</head>
<body>
<h1>Welcome to UOM Register Page</h1>
<fm:form action="insertUom" method="post" modelAttribute="uom">
<pre>
UOM Type   :<fm:select path="uomType">
			<fm:option value="">--select--</fm:option>
			<fm:option value="PACK">PACKING</fm:option>
			<fm:option value="NOPACK">NO PACKING</fm:option>
			<fm:option value="NA">-NA-</fm:option>  
			</fm:select> <fm:errors path="uomType" cssClass="errors"/> <br>
UOM Model  :<fm:input path="uomModel"/> <fm:errors path="uomModel" cssClass="errors"/> <br>
Description:<fm:textarea path="description"></fm:textarea> <fm:errors path="description" cssClass="errors"/> <br>
	        <input type="submit" value="Create UOM"/>
</pre>
</fm:form>
${message}
<br/>
<a href="getAllUoms">View All UOMs</a>
</body>
</html>



