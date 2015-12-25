<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Your Profile</h1>
<p>
    <c:out value="user name :${spitter.username}"/>
</p>
<h3>
    <c:out value="name      :${spitter.firstName}"/> <c:out value="${spitter.lastName}"/>
</h3>
<c:out value="email     :${spitter.email}"/>
</body>
</html>
