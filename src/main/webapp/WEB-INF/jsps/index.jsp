<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ankur
  Date: 14-08-2016
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <h3>Index</h3>
    <c:url value="/login" var="loginPage"/>
    <p><a href="${loginPage}">Login</a> </p>
</body>
</html>
