<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = request.getParameter("message");
%>
<html>
<head>
    <title>Login</title>
    <jsp:include page="../WEB-COMPONENTS/Head.jsp"/>
</head>
<body>
    <div class="wrapper">
        <form class="form-signin" action="users/login">
            <h2 class="form-signin-heading text-center">Login</h2>
            <% if(err != null){%>
            <div class="alert alert-danger" role="alert">
                <%=err%>
            </div>
            <%}%>
            <input type="text" placeholder="Email Address" class="form-control" name="email" required>
            <input type="password" placeholder="password" class="form-control" name="password" required>
            <button class="btn btn-lg btn-primary btn-block">Login</button>
            <p class="text-center mt-3">if you don't have account ? <a href="signup" class="btn">signup</a></p>
        </form>
    </div>
    <jsp:include page="../WEB-COMPONENTS/Footer.jsp"/>
</body>
</html>
