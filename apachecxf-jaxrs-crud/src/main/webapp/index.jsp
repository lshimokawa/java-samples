<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	$("#myButton").click(function() {
		$.ajax({
			url: '${pageContext.request.contextPath}/services/usuarios/'+$("#username").val(),
			type: 'GET',
			success: function(data) {
				$("#nombre").html(data.usuario.nombre);
			},
			error: function(data) {
				alert("Error");
			}
		});
	});
 });
</script>
</head>
<body>
<h1>Apache CXF JAX-RS - JQuery</h1>
<input id="username" type="text" /><button id="myButton">Find</button><span id="nombre"></span>
</body>
</html>