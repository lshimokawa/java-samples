<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
<link href="form.css" rel="stylesheet" type="text/css">
</head>
<body>
	<fieldset class="text">
		<legend>Login</legend>
		<html:form action="Login">
			<label for="username">Usuario</label>
			<html:text property="username" />
			<br />
			<label for="password">Password</label>
			<html:password property="password" />
			<br />
			<html:submit value="Login" />
		</html:form>
	</fieldset>
</body>
</html>