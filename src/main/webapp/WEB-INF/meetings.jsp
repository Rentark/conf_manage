<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 12/26/2018
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meetings</title>
</head>
<body>

<c:if test="${sessionScope.userSession.role == 'admin' || sessionScope.userSession.role == 'moderator'}">
    <a href="${pageContext.request.contextPath}/management/meetings"><c:out value="ManageMeetings"/></a> <br>
    <a href="${pageContext.request.contextPath}/management/users"><c:out value="ManageUsers"/></a> <br>
</c:if>

<table>
    <tr>
        <th>Name</th>
        <th>Time</th>
        <th>Organizer</th>
        <th>Venue</th>
    </tr>
    <c:forEach var="meeting" items="${requestScope.meetingsList}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/meetings/meeting/${meeting.meetingID}"><c:out value="${meeting.name}"/></a> </td>
            <td><c:out value="${meeting.time}"/></td>
            <td><c:forEach var="user" items="${sessionScope.usersList}">
                <c:if test="${meeting.organizerID == user.userID}">
                    <c:out value="${user.firstName}"/>
                </c:if>
            </c:forEach></td>
            <td>
                <c:out value="${meeting.venue.venueID}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<c:forEach var="user" items="${requestScope.usersList}">
        <c:out value="${user.firstName}"/>
</c:forEach>
</body>
</html>
