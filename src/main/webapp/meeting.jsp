<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 12/26/2018
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meeting</title>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Time</th>
        <th>Organizer</th>
    </tr>

        <tr>
            <td><c:out value="${requestScope.meetingItemInfo.name}"/> </td>
            <td><c:out value="${requestScope.meetingItemInfo.time}"/></td>
            <td><c:forEach var="user" items="${requestScope.usersList}">
                <c:if test="${requestScope.meetingItemInfo.organizerID == user.userID}">
                    <c:out value="${user.firstName} ${user.lastName}"/>
                </c:if>
                </c:forEach></td>
        </tr>
</table>
<br>
<br>
<br>
<table>
    <tr>
        <th>Title</th>
        <th>Time</th>
        <th>Speaker</th>
        <th>Register</th>
        <th>Attendance</th>
    </tr>
    <c:forEach var="report" items="${requestScope.reportsListForMeeting}">
        <tr>
            <td>report.title</td>
            <td>report.time</td>
            <td><c:forEach var="user" items="${requestScope.usersList}">
                <c:if test="${report.speakerID == user.userID}">
                    <c:out value="${user.firstName} ${user.lastName}"/>
                </c:if>
            </c:forEach></td>
            <c:if test="${sessionScope.userSession.userActivity != null}">
                <c:forEach var="userActiv" items="${sessionScope.userSession.userActivity}">

                    <c:if test="${(userActiv == null) || (userActiv.reportRegistered != report.reportID)}">
                        <td>
                            <form action="itemSubmission"><button type="submit" name="btnAction" value="registerForRep">Register</button></form>
                        </td>
                    </c:if>
                    <c:if test="${userActiv.reportRegistered == report.reportID}">
                        <td>
                            <form  action="itemCancel"><button type="submit" name="btnAction" value="unRegisterForRep">UnRegister</button></form>
                        </td>
                        <c:if test="${userActiv.reportAttendance}">
                            <td>
                                <form action="itemCancel"><button  type="submit" name="btnAction" value="notAttend">Attended</button></form>
                            </td>
                        </c:if>
                        <c:if test="${!userActiv.reportAttendance}">
                            <td>
                                <form action="itemSubmission"><button  type="submit" name="btnAction" value="attended">Not attended</button></form>
                            </td>
                        </c:if>
                    </c:if>

                </c:forEach>
            </c:if>

            <c:if test="${sessionScope.userSession.userActivity == '[]'}">
                <td>
                    <form action="${pageContext.request.contextPath}${report.reportID}/itemSubmission"><button type="submit" name="btnAction" value="registerForRep${report.reportID}">Register</button></form>
                </td>
                <td></td>
            </c:if>


            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
