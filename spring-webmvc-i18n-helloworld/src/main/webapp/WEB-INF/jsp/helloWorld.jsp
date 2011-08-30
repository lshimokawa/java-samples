<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
	<h1>Spring MVC</h1>
	<a href="?lang=en">en</a> |
	<a href="?lang=es">es</a>
	<p>
		<spring:message code="hello.message" />
	</p>
</body>
</html>
