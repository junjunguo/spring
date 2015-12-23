<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  This file is part of spring_on_web
  Created by <a href="http://junjunguo.com">GuoJunjun</a> on December 23, 2015.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/spittles" />">Spittles</a> |
<a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>
