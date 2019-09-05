<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 1/18/2019
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <form action="meetingManagement" method="POST" class="form-horizontal" style="margin:20px 0 200px 0">
                <fieldset>
                    <legend class="text-center">Meeting Edit</legend>
                    <div class="form-group">
                        <label class="col-md-2 control-label">meetingName</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="meetingName" placeholder="${requestScope.meetingItemInfo.name}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">meetingStartTime</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="password" name="meetingTime" placeholder="${requestScope.meetingItemInfo.time}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">meetingEndTime</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="meetingEndTime" placeholder="${requestScope.meetingItemInfo.endTime}"/>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <label class="col-md-2 control-label">city</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="city" placeholder="${requestScope.meetingItemInfo.venue.city}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">street</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="street" placeholder="${requestScope.meetingItemInfo.venue.street}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">house</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="house" placeholder="${requestScope.meetingItemInfo.venue.house}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">room</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="room" placeholder="${requestScope.meetingItemInfo.venue.room}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3 col-md-offset-2">
                            <input type="hidden" name="meetingID" value="${requestScope.meetingItemInfo.meetingID}">
                            <input type="hidden" name="venueID" value="${requestScope.meetingItemInfo.venue.venueID}">
                            <button type="submit" name="btnAction" value="editMeeting" class="btn btn-primary form-control">Edit</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>
</html>
