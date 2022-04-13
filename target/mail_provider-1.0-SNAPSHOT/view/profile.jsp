<%@ page import="com.mail.gl.mail_provider.model.User" %><%--
  Created by IntelliJ IDEA.
  User: EL MAALMI
  Date: 12/04/2022
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%
    User user = (User)request.getAttribute("user");
%>

</body>
<h1><%=user.getEmail()%></h1>
</html>
