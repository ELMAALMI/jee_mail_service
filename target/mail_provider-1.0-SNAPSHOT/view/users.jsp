<%@ page import="java.util.List" %>
<%@ page import="com.mail.gl.mail_provider.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--
  Created by IntelliJ IDEA.
  User: EL MAALMI
  Date: 20/04/2022
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <jsp:include page="../WEB-COMPONENTS/Head.jsp"/>
</head>
<%
    List<User> users = (ArrayList)request.getAttribute("users");
%>
<body>
    <jsp:include page="../WEB-COMPONENTS/NavBar.jsp"/>
    <div class="container">
        <div class="card shadow-none mt-3 border border-light">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Email</th>
                        <th>Active</th>
                        <th>Admin</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (User u:users){
                    %>
                    <tr>
                        <th> <%=u.getId()%> </th>
                        <th> <%=u.getNom()%> </th>
                        <th> <%=u.getPrenom()%> </th>
                        <th> <%=u.getEmail()%> </th>
                        <th>
                            <span class="badge <%= u.isActive()?"bg-success":"bg-danger"%>">
                                <i class="fa fa-flash"></i>
                            </span>
                        </th>
                        <th>
                            <span class="badge <%= u.isAdmin()?"bg-success":"bg-danger"%>">
                                <i class="fa fa-flash"></i>
                            </span>
                        </th>
                        <th>
                            <div class="d-md-flex justify-content-md-end">
                                <a href="<%=u.getId()%>" class="btn btn-primary mr-2" type="button">
                                    <i class="fa fa-pencil"></i>
                                </a>
                                <a href="<%=u.getId()%>" class="btn btn-primary" type="button">
                                    <i class="fa fa-trash"></i>
                                </a>
                            </div>
                        </th>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
