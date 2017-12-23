<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <head>
   <title>Application Spring Security</title>
</head>
<body>
 <form action="login" method="post">
   User Name : <input type="text" name="username"/><br>
   Password	 : <input type="password" name="password"/><br>
            	<input type="submit" value="Sign In"/>
</form>
   <c:if test="${param.error}"> Invalid Username and Password....</c:if>
   <c:if test="${param.logout}"> You have been logged out...</c:if>
 </body>