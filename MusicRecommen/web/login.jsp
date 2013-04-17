<%
       boolean passed= "ok".equals(session.getAttribute("login"));
       if (passed) response.sendRedirect("home.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" >

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs" >
<head>

  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>He Thong Tu Van Am Nhac V1.0</title>
  
  <!-- Free google font -->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300,600' rel='stylesheet' type='text/css' />
  <link href="css/form-style.css" rel="stylesheet" type="text/css" />
  
  <script src="js/jquery.js"></script>
  <script src="js/script.js"></script>
  
  <!-- CSS code for IE Browser -->
  <!--[if lt IE 10]>
    <link href="css/form-style-ie.css" rel="stylesheet" type="text/css" />  
  <![endif]-->
  
  </head>
  <body>
  
    <!-- If you don't want a logo, delete all of these code -->
    <div class='logo'>
      <a href='#'><img src='design/your_logo.png' class='logo' alt='logo' /></a>
    </div>
    <!-- Till here -->
    
    <div class='form'>
      <h1>Sign in</h1>
      <div class='line'></div>
      
      <!-- If you don't want a social buttons, delete all of these code -->
        <a class='btn-facebook' href='#'>Connect with Facebook</a>
        <a class='btn-twitter' href='#'>Connect with Twitter</a>
      <!-- Till here -->
      
      
      <!-- Span class ie-placeholder is there for IE browser. IE doesn't support placeholder attribute -->
      <form class='input-form' id='sign-in-form' method='post' action='verifyUser.jsp'>
        <span class='ie-placeholders'>Login:</span><input type='text' id='ipt-login' name='login' placeholder='Login' />
        <span class='ie-placeholders'>Password:</span><input type='password' id='ipt-password' name='password' placeholder='Password' />
        <a class='forgotten-password-link' href='#'>Forgotten password</a>
        <input type='submit' class='btn-sign-in btn-orange' value='Sign in' />
      </form>
      
      <!-- FORGOTTEN PASSWORD -->
      <div class='forgotten-password-box'>
        <form class='input-form' id='forgotten-password-form' action='#'>
          <span class='ie-placeholders'>Email:</span><input type='text' id='ipt-fp-email' class='forgotten-password-email' placeholder='E-mail' />
          <input type='submit' class='btn-orange' value='Send' /><br /><br />
          We'll send you e-mail with password reset.
        </form>
      </div>
      
      <!-- ERROR STATE -->
      <div class='error-box red'>
        <span class='error-message'>Incorrect login or password.</span>
      </div>
           
      <div class='sign-link'>
        Don't have an account? <a href='registration.jsp'>Sign up</a>
      </div> 
    </div>
    
  </body>
</html>