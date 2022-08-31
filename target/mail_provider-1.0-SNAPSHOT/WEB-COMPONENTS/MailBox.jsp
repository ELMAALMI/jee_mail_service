<%@ page import="java.util.List" %>
<%@ page import="com.mail.elmaalmi.billal.model.Email" %>
<%@ page import="com.mail.elmaalmi.billal.util.DateParser" %>
<%
    List<Email> emails = (List<Email>) request.getAttribute("emails");
    List<Email> sendMails = (List<Email>) request.getAttribute("sendMails");
%>
<div id="loading" class="loading">Loading</div>
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">

                    <div class="row">
                        <!-- Left sidebar -->
                        <div class="col-lg-3 col-md-4">
                            <a href="mail" class="btn btn-danger waves-effect waves-light btn-block">New Mail</a>
                            <div class="card shadow-none mt-3">
                                <div class="list-group shadow-none">
                                    <button id="inbox_mail_btn" class="list-group-item active"><i class="fa fa-inbox mr-2"></i>Inbox <b>(<%=emails.size()%>)</b></button>
                                    <button id="send_mail_btn" class="list-group-item"><i class="fa fa-paper-plane-o mr-2"></i>Sent Mail <b>(<%=sendMails.size()%>)</b> </button>
                                    <!--button id="trash_mail_btn" class="list-group-item"><i class="fa fa-trash-o mr-2"></i>Trash <b>()</b></button -->
                                </div>
                            </div>

                        </div>
                        <!-- End Left sidebar -->

                        <!-- Right Sidebar -->
                        <div class="col-lg-9 col-md-8">
                            <div class="row">
                                <div class="col-lg-8">
                                    <div class="btn-toolbar" role="toolbar">
                                        <div class="btn-group mr-1">
                                            <button type="button" class="btn btn-outline-primary waves-effect waves-light"><i class="fa fa-inbox"></i></button>
                                            <button id="refresh_btn" type="button"  class="btn btn-outline-primary waves-effect waves-light"><i class="fa fa-refresh"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="position-relative has-icon-right">
                                        <input type="text" class="form-control" placeholder="search mail">
                                    </div>
                                </div>
                            </div> <!-- End row -->
                            <div class="card shadow-none mt-3 border border-light">
                                <div class="table-responsive">
                                    <table class="table">
                                        <tbody id="inbox_body_table">
                                        <%
                                            for (Email e:emails){
                                        %>
                                        <tr style="cursor: pointer" onclick="open_model('<%=e.getUuid()%>','re')">
                                            <td class="action"><input type="checkbox" /></td>
                                            <td class="name"><%=e.getFrom()%></td>
                                            <td class="subject">
                                                <a href="read-email?=<%=e.getUuid()%>"><%= e.getSubject()%> </a>
                                            </td>
                                            <td class="time">
                                                <%=DateParser.formate(e.getCreatedAt())%>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                                <!-- card -->
                        </div> <!-- end Col-9 -->

                    </div><!-- End row -->

                </div>
            </div>
        </div>
    </div><!-- End row -->

</div>