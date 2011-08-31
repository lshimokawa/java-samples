<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	$("#myButton").click(function() {
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
<h1>Apache CXF JAX-RS - JQuery</h1>
<input id="nombre" type="text" /><button id="myButton">Saludar</button><span id="saludo"></span>
</body>
</html>