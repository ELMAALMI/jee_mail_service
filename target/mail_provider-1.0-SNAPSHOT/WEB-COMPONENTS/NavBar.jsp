<%@ page import="com.mail.elmaalmi.billal.model.User" %><%
    boolean isAdmin = ((User)request.getSession().getAttribute("user")).isAdmin();
%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a href="home" class="navbar-brand">F-MAIL</a>
        <button type="button" class="navbar-toggler collapsed" data-toggle="collapse" data-target="#main-nav">
            <span class="menu-icon-bar"></span>
            <span class="menu-icon-bar"></span>
            <span class="menu-icon-bar"></span>
        </button>
        <div id="main-nav" class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="dropdown">
                    <a href="#" class="nav-item nav-link" data-toggle="dropdown">
                        <i class="fa fa-user"></i>
                    </a>
                    <div class="dropdown-menu">
                        <a href="profile" class="dropdown-item">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            Profile
                        </a>
                        <% if(isAdmin){ %>
                        <a href="admin" class="dropdown-item">
                            <i class="fa fa-building" aria-hidden="true"></i>
                            Admin
                        </a>
                        <%}%>
                        <a href="log-out" class="dropdown-item">
                            <i class="fa fa-sign-out" aria-hidden="true"></i>
                            Logout
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>