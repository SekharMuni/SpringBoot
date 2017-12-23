<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OrderMethodEdit Page</title>
</head>
<body>
<h1>OrderMethod EditPage!!!</h1>
<form:form action="updateOrderMethod" method="post" modelAttribute="orderMethod">
<pre>
OrderMethodId:<form:input path="orderMethodId" readonly="true"/>
<form:errors path="orderMethodId" cssClass="error"/>
Order Mode  :<form:radiobuttons path="orderMode" items="${orderModes}"/>
<form:errors path="orderMode" cssClass="error"/>
Order Code  :<form:input path="orderCode"/>
<form:errors path="orderCode" cssClass="error"/>
Order Method:<form:select path="orderMtd">
	<form:option value="">--select</form:option>
	<form:options items="${orderMethods}"/>
</form:select>
<form:errors path="orderMtd" cssClass="error"/>
Order Accept:<form:checkboxes items="${orderAccepts}" path="orderAccept"/>
<form:errors path="orderAccept" cssClass="error"/>
Description :<form:textarea path="description"/>
<form:errors path="description" cssClass="error"/>
   <input type="submit" value="Update Order Method">
</pre>
</form:form>
</body>
</html>