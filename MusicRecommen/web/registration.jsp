<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" >

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="cs" lang="cs" >
<head>

  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>Clean CSS Form</title>
  
  <!-- Free google font -->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,300,600' rel='stylesheet' type='text/css'>
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
      <h1>Registration</h1>
      <div class='line'></div>
      
      <!-- If you don't want a social buttons, delete all of these code -->
        <a class='btn-facebook' href='#'>Connect with Facebook</a>
        <a class='btn-twitter' href='#'>Connect with Twitter</a>
      <!-- Till here -->
      
      <form class='input-form' id='registration-form' method='post' action='registrationac.jsp'>
        <span class='ie-placeholders'>Name:</span><input type='text' name='login' placeholder='Login' id='ipt-login' />
        <span class='ie-placeholders'>E-mail:</span><input type='text' name='email' placeholder='E-mail' id='ipt-email' />
		<span class='ie-placeholders'>Age:</span><input type='text' name='age' placeholder='Age' id='ipt-age' />
        <span class='ie-placeholders'>Password:</span><input type='password' name='password' placeholder='Password' id='ipt-password' />
        <span class='ie-placeholders'>Retype Pass:</span><input type='password' placeholder='Retype password' id='ipt-repassword' /><br />
        <input type='checkbox' id='tac-checkbox' /><label for='tac-checkbox'>I agree with <a href='#'>terms and conditions</a></label>
        <input type='submit' class='btn-register btn-orange' value='Register' />
      </form>
      
      <!-- ERROR STATE -->
      <div class='error-box red'>
        <span class='error-message'>Please, fill all informations.</span>
      </div>
      
      <div class='sign-link'>
        Already have an account? <a href='login.jsp'>Sign in</a>
      </div>
    </div>
    
  </body>
</html>