<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#formlogin').validate({
			rules:{
				userId:{
					required:true
				},
				password:{
					required:true
		}
			}
		})
	});
</script>
</head>
<body>
<div align=center>
		<h1>User Login</h1>
<form method="post" action="loginProcess.jsp" id="formlogin">
	<label for="username">User Name:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <input type="submit" value="Login">
</form>
	
</body>
</html>