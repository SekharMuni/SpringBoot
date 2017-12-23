<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ItemDataEdit</title>
<style type="text/css">
.error{
	color:red
}
</style>
</head>
<body>
<h2>ItemDataEdit Page!!!</h2>
<form:form action="updateItem" method="post" modelAttribute="item">
<pre>
Item Id:<form:input path="itemId" readonly="true"/>
	<form:errors path="itemId" cssClass="error"/>
	
Item Code	:<form:input path="itemCode"/>
				<form:errors path="itemCode" cssClass="error"/> <br>
				
Item Dimentions:W:<form:input path="itemWidth"/>	L:<form:input path="itemLength"/>  H:<form:input path="itemHeight"/><br>

Item Base Cost:<form:input path="itemBaseCost"/>
	<form:errors path="itemBaseCost" cssClass="error"/> <br>
	
Item Base Currency:<form:select path="itemBaseCurrency">
		<form:option value="">--select--</form:option>
		<form:options items="${BaseCurrency}"/>
		</form:select>
	<form:errors path="itemBaseCurrency" cssClass="error"/> <br>
	
Item Uom	:<form:select path="itemUom">
			<form:option value="">--select--</form:option>
			<form:options items="${itemUoms}" itemLabel="uomModel" itemValue="uomId"/>
			</form:select><br>
			
OrderMethod(Sale Type):<form:select path="itemSaleOrdeMethod">
			<form:option value="">--select--</form:option>
			<form:options items="${itemSaleMode}" itemLabel="orderCode" itemValue="orderMethodId"/>
			</form:select><br>
			
OrderMethod(Purchase Type):<form:select path="itemPurchaseOrdeMethod">
		<form:option value="">--select--</form:option>
		<form:options items="${itempurchaceMode}" itemLabel="orderCode" itemValue="orderMethodId"/>
</form:select><br>

Item Vendor:<form:select path="itemVendors">
			<form:option value="">--select--</form:option>
			<form:options items="${itemUserVendorList}" itemLabel="whUserCode" itemValue="whUserTypeId"/>
			</form:select><br>
			
Item Customer:<form:select path="itemCustomers">
		<form:option value="">--select--</form:option>
		<form:options items="${itemUserCustomerList}" itemLabel="whUserCode" itemValue="whUserTypeId"/>
		</form:select><br>
		
Description	:<form:textarea path="description"/>
	<form:errors path="description" cssClass="error"/> <br>
		<input type="submit" value="Create Item">
</pre>
</form:form>
</body>
</html>