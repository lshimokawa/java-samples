<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/dojo/1.6.1/dojo/dojo.xd.js"
	type="text/javascript"></script>
<script>
	dojo.ready(function() {
		myButton = dojo.byId("myButton");
		dojo.connect(myButton, "onclick", function(evt) {
			dojo.xhrGet({
				url : "services/rest/helloworld/saludar/"
						+ dojo.byId("nombre").value,
				headers : {
					"Content-Type" : "text/plain"
				},
				load : function(data) {
					dojo.byId("saludo").innerHTML = data;
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Apache CXF JAX-RS - Dojo</h1>
	<input id="nombre" type="text" />
	<button id="myButton">Saludar</button>
	<span id="saludo"></span>
</body>
</html>