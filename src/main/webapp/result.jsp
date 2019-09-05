<%--
  Created by IntelliJ IDEA.
  User: temp
  Date: 12/18/2018
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>heck</title>
</head>
<body>
<%
    PrintWriter outt = response.getWriter();
    if ((boolean)request.getAttribute("user")) {
        outt.println("success");
    } else outt.println("shit");
%>

</body>
</html>
