<%@ page import="com.mail.elmaalmi.billal.model.User" %><%--
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
    <jsp:include page="../WEB-COMPONENTS/Head.jsp"/>
</head>
<body>
<%
    User user = (User)request.getAttribute("user");
%>

</body>
    <jsp:include page="../WEB-COMPONENTS/NavBar.jsp"/>
    <div class="container mt-3">
        <div class="card">
            <form class="form-signin mt-5 mb-5" style="width: 900px" action="update-profile" >
                <h2 class="form-signin-heading text-center">Profile</h2>
                <input type="text" readonly placeholder="Email Address" class="form-control" value="<%=user.getEmail()%>" name="email" required>
                <input type="text" placeholder="nom" class="form-control" name="nom" value="<%=user.getNom()%>" required>
                <input type="text" placeholder="prenom" class="form-control" name="prenom" value="<%=user.getPrenom()%>" required>
                <input type="date" placeholder="date" class="form-control" name="birthday" value="<%=user.getBirthday()%>" required>
                <button class="btn btn-lg btn-primary btn-block">update</button>
            </form>
        </div>
    </div>
</html>
