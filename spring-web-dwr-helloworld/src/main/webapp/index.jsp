<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/spring-web-dwr-helloworld/dwr/interface/helloWorld.js"></script>
<script type="text/javascript" src="/spring-web-dwr-helloworld/dwr/engine.js"></script>
<script>
	$(document).ready(function() {
		$("#boton").click(function() {
			helloWorld.saludar($("#nombre").val(), {
				callback : function(data) {
					$("#saludo").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<input id="nombre" type="text" />
	<button id="boton">Saludar con DWR</button>
	<div id="saludo"></div>
</body>
</html>