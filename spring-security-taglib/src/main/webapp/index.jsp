<html>
<head>
<link href="${pageContext.request.contextPath}/css/form.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<fieldset class="text">
		<legend>Login</legend>
		<form
			action="${pageContext.request.contextPath}/j_spring_security_check"
			method="post">
			<label for="username">Usuario</label> <input type="text"
				name="j_username" /> <br /> <label for="password">Password</label>
			<input type="password" name="j_password" /> <br /> <input
				type="submit" />
		</form>
	</fieldset>
</body>
</html>