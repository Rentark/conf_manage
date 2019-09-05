<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 12/19/2018
  Time: 1:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="obj" items="${requestScope.meetings}">
    <c:out value="meeting.name"/> <br>
    <c:out value="meeting.time"/> <br>
    <c:out value="${obj.lastName}"/>
    ${obj.login}
</c:forEach>








</body>
</html>
