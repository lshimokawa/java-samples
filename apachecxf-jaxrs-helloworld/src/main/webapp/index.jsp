<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$.ajax({
				url: '${pageContext.request.contextPath}/services/rest/helloworld/saludar/'+$("#nombre").val(),
				type: 'GET',
				success: function(data) {
					$("#saludo").html(data);
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
<h1>Apache CXF JAX-RS</h1>
<input id="nombre" type="text" /><button>Saludar</button><span id="saludo"></span>
</body>
</html>