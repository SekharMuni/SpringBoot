<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WhUserType Data Edit</title>
<style type="text/css">
.error{
color:red
}
</style>
</head>
<body>
<h1>Welcome To WhUserType Edit Page!!! </h1>
<form:form action="updateWhUserType" method="post" modelAttribute="whUserType">
<pre>
WhUserTypeId:<form:input path="whUserTypeId" readonly="true"/>
User Type	:<form:radiobuttons path="userType" items="${whUserTypes}"/>
<form:errors path="userType" cssClass="error"/>
User Code	:<form:input path="whUserCode"/>
<form:errors path="whUserCode" cssClass="error"/>
User For	:<form:input path="whUserFor"/>
<form:errors path="whUserFor" cssClass="error"/>
UserMail	:<form:input path="whUserMail"/>
<form:errors path="whUserMail" cssClass="error"/>
UserContact	:<form:input path="whUserContact"/>
<form:errors path="whUserContact" cssClass="error"/>
UserIdType	:<form:select path="whUserIdType">
			<form:option value="">--select--</form:option>
			<form:options items="${whUserIdTypes}"/>
			</form:select>
			<form:errors path="whUserIdType" cssClass="error"/>
UserIdOther	:<form:input path="whUserIdOther"/>
<form:errors path="whUserIdOther" cssClass="error"/>
UserIdNumber :<form:input path="whUserIdNumber"/>
<form:errors path="whUserIdNumber" cssClass="error"/>
<input type="submit" value="Create User">
</pre>
</form:form>
<br>
</body>
</html>