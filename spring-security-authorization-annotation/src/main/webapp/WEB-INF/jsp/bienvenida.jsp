<html>
<body>
	<h1>Autorización por anotaciones con Spring Security</h1>
	<ul>
		<li>Usuario obtenido con SecurityContextHolder: ${username}</li>
		<li><a href="${pageContext.request.contextPath}/test-admin.htm">Test
				Admin</a></li>
		<li><a href="${pageContext.request.contextPath}/test-user.htm">Test
				User</a></li>
		<li><a
			href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
		</li>
	</ul>
</body>
</html>