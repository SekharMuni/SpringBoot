<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
	<style type="text/css">
	.errors{
		color:red;
	}
	</style>
</head>
<body>
<h1>Welcome To EDIT Page</h1>
<fm:form action="updateUom" method="post" modelAttribute="uom">
<pre>
  ID	:<fm:input path="uomId" value="${uom.uomId}" readonly="readonly"/> <br>
Type	:<fm:select path="uomType">
			<fm:option value="">-select-</fm:option>
				<c:forEach items="${uomTypes}" var="ob">
					<c:choose>
						<c:when test="${uom.uomType eq ob.key}">
							<fm:option value="${ob.key}" selected="selected">${ob.value}</fm:option>
						</c:when>
						<c:otherwise>
							<fm:option value="${ob.key}">${ob.value}</fm:option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</fm:select><fm:errors path="uomType" cssClass="errors"/> <br>
Model	:<fm:input path="uomModel" value="${uom.uomModel}"/> <fm:errors path="uomModel" cssClass="errors"/> <br>
<%-- Created	:<fm:input path="createdDate" value="${uom.createdDate}" readonly="readonly"/> <br> --%>
Note	:<textarea name="description">${uom.description}</textarea> <fm:errors path="description" cssClass="errors"/> <br>
		  <input type="submit" value="Update"/>
</pre>
</fm:form>
</body>
</html>