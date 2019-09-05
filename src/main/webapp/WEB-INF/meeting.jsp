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
            <td><c:forEach var="user" items="${sessionScope.usersList}">
                <c:if test="${report.speakerID == user.userID}">
                    <c:out value="${user.firstName} ${user.lastName}"/>
                </c:if>
            </c:forEach></td>
            <td>
                <form action="reportUserActivity" method="POST">
                        <input name="reportID" type="hidden" value="${report.reportID}"/>
                        <c:choose>
                            <c:when test="${sessionScope.userSession.userActivity != '[]'}">
                                <c:set var="flag" value="" scope="page"/> <!--NOT WORKING-->
                                <c:forEach var="userActiv" items="${sessionScope.userSession.userActivity}">
                                    <c:if test="${userActiv.reportRegistered == report.reportID}">
                                        <div class="form-control">
                                            <button type="submit" name="btnAction" value="unRegisterForRep">UnRegister</button>
                                        </div>
                                        <c:set var="flag" value="1" scope="page"/>
                                    </c:if>
                                </c:forEach>
                                <%--<c:if test="${flag.length == 0}"> <!-- flag.length-->
                                            <button type="submit" name="btnAction" value="registerForRep">Register</button>
                                </c:if>--%>
                            </c:when>
                            <c:otherwise>
                                <div class="form-control">
                                    <button type="submit" name="btnAction" value="registerForRep">Register</button>
                                </div>
                            </c:otherwise>
                        </c:choose>
                </form>
            </td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
