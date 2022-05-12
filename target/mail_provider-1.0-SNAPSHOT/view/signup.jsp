<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = request.getParameter("error_msg");
%>
<html>
<head>
  <title>signup</title>
  <jsp:include page="../WEB-COMPONENTS/Head.jsp"/>
</head>
<body>
  <div class="container">
      <div class="wrapper">

          <form class="form-signin" method="get" action="users/signup">
              <h2 class="form-signin-heading text-center">SignUp</h2>
              <% if(err != null){%>
                  <div class="alert alert-danger" role="alert">
                      <%=err%>
                  </div>
              <%}%>
              <input type="text" placeholder="Email" class="form-control" name="email" required>
              <input type="text" placeholder="Nom" class="form-control" name="nom" required>
              <input type="text" placeholder="Prenom" class="form-control" name="prenom" required>
              <input type="date" placeholder="Birth day" class="form-control" name="birthday" required>
              <input type="password" placeholder="password" class="form-control" name="password" required>
              <button class="btn btn-lg btn-primary btn-block">SIGN-UP</button>
              <p class="text-center mt-3">already have account ? <a href="login" class="btn">Login</a></p>
          </form>
      </div>
  </div>
  <jsp:include page="../WEB-COMPONENTS/Footer.jsp"/>
</body>
</html>
