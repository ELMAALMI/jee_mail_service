<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Mail</title>
    <jsp:include page="../WEB-COMPONENTS/Head.jsp"/>
</head>
<body>
    <jsp:include page="../WEB-COMPONENTS/NavBar.jsp"/>
    <div class="container" style="display: flex;justify-content: center;align-content: center">
            <form style="width: 640px;padding: 30px;" action="send-mail" method="get">
                <div class="form-group">
                    <label class="col-lg-2 control-label">To</label>
                    <div class="col-lg-12">
                        <input type="text" name="to" placeholder="" id="inputEmail1" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Subject</label>
                    <div class="col-lg-12">
                        <input type="text" name="subject" placeholder="" id="inputPassword1" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Message</label>
                    <div class="col-lg-12">
                        <textarea rows="10" cols="30" class="form-control" id="" name="message"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Send</button>
                </div>
            </form>
        </div>
    <jsp:include page="../WEB-COMPONENTS/Footer.jsp"/>
</body>
</html>
