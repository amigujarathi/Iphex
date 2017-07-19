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
    <title>Access</title>
</head>
<body>
    <h3>Access</h3>
    <c:url value="/logout" var="logoutUrl"/>
    <p><a href="${logoutUrl}">Logout</a> </p>
</body>
</html>
