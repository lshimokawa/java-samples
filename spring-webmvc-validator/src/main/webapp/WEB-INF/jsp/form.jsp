<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>
<link href="${pageContext.request.contextPath}/css/form.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<fieldset class="text">
		<legend>Validator Test</legend>
		<f:form action="${pageContext.request.contextPath}/validator/save.htm"
			method="post" commandName="validatorTestBean">
			<f:label path="notEmpty">notEmpty</f:label>
			<f:input path="notEmpty" />
			<f:errors path="notEmpty" cssClass="error" />
			<br />
			<f:label path="notBlank">notBlank</f:label>
			<f:input path="notBlank" />
			<f:errors path="notBlank" cssClass="error" />
			<br />
			<f:label path="email">email</f:label>
			<f:input path="email" />
			<f:errors path="email" cssClass="error" />
			<br />
			<f:label path="integer">integer</f:label>
			<f:input path="integer" />
			<f:errors path="integer" cssClass="error" />
			<br />
			<input type="submit" />
		</f:form>
	</fieldset>
</body>
</html>