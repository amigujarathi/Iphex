<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ankur
  Date: 14-08-2016
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <c:url value="/login" var="loginProcessingurl"/>
    <form method="post" action="${loginProcessingurl}">
        <p><label for="username">Username <input id="username" name="username"/></label></p>
        <p><label for="password">Password <input id="password" name="password"/></label></p>
        <p><input type="submit" name="submit" id="submit" value="Login" /></p>
    </form>

</body>
</html>
