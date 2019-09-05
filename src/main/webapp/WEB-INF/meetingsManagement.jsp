<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 1/18/2019
  Time: 3:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MeetingsManagement</title>
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
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="meeting" items="${requestScope.meetingsList}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/management/meetings/meeting/${meeting.meetingID}"><c:out value="${meeting.name}"/></a> </td>
            <td><c:out value="${meeting.time}"/></td>
            <td><c:forEach var="user" items="${requestScope.usersList}">
                <c:if test="${meeting.organizerID == user.userID}">
                    <c:out value="${user.firstName}"/>
                </c:if>
            </c:forEach></td>
            <form action="meetingManagement" method="post">
                <div class="form-control">
                    <input type="hidden" value="${meeting.meetingID}" name="meetingID">
                </div>
                    <td>
                        <div class="form-control">
                            <a href="${pageContext.request.contextPath}/management/meetings/meeting/${meeting.meetingID}" class="btn btn-primary form-control">Edit</a>
                        </div>
                    </td>
                    <td>
                        <div class="form-control">
                            <button type="submit" name="btnAction" value="deleteMeeting">Delete</button>
                        </div>
                    </td>
            </form>
        </tr>
    </c:forEach>
</table>
<c:forEach var="user" items="${requestScope.usersList}">
    <c:out value="${user.firstName}"/>
</c:forEach>
</body>
</html>
