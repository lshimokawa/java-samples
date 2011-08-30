<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<body>
	<h1>Autorización por taglib con Spring Security</h1>
	<ul>
		<li>Usuario <sec:authentication property="principal.username" />
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li>Soy administrador</li>
			</sec:authorize> <sec:authorize access="hasRole('ROLE_USER')">
				<li>Soy usuario</li>
			</sec:authorize>
	</ul>
</body>
</html>