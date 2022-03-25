<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <link rel="stylesheet" href="css/style.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<div class="section"></div>
<main>
  <center>
    <div class="section"></div>

    <h5 class="indigo-text">Please, login into your account</h5>
    <div class="section"></div>

    <div class="container">
      <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

        <form class="col s12" method="post">
          <div class='row'>
            <div class='col s12'>
            </div>
          </div>

          <div class='row'>
            <div class='input-field col s12'>
              <input class='validate' type='email' name='email' id='email' />
              <label for='email'>Entree Votre Nom</label>
            </div>
          </div>
          <div class='row'>
            <div class='input-field col s12'>
              <input class='validate' type='email' name='email' id='email' />
              <label for='email'>Enter your email</label>
            </div>
          </div>
          <div class='row'>
            <div class='input-field col s12'>
              <input class='validate' type='email' name='email' id='email' />
              <label for='email'>Enter your email</label>
            </div>
          </div>
          <div class='row'>
            <div class='input-field col s12'>
              <input class='validate' type='password' name='password' id='password' />
              <label for='password'>Enter your password</label>
            </div>
            <label style='float: right;'>
              <a class='pink-text' href='#!'><b>Forgot Password?</b></a>
            </label>
          </div>

          <br />
          <center>
            <div class='row'>
              <button type='submit' name='btn_login' class='col s12 btn btn-large waves-effect indigo'>Login</button>
            </div>
          </center>
        </form>
      </div>
    </div>
    <a href="/login.jsp">Login</a>
  </center>

  <div class="section"></div>
  <div class="section"></div>
</main>

</body>
</html>
