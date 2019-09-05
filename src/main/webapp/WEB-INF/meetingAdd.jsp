<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 1/18/2019
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meeting Add</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <form action="management/meetingManagement" method="POST" class="form-horizontal" style="margin:20px 0 200px 0">
                <fieldset>
                    <legend class="text-center">Meeting Add</legend>
                    <div class="form-group">
                        <label class="col-md-2 control-label">meetingName</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="meetingName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">meetingStartTime</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="password" name="meetingTime"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">meetingEndTime</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="meetingEndTime"/>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <label class="col-md-2 control-label">city</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="city"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">street</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="street"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">house</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="house"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">room</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="room"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3 col-md-offset-2">
                            <button type="submit" name="btnAction" class="btn btn-primary form-control">Add</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>
</html>
