<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.3.0/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	$("#find").click(function() {
		$.ajax({
			url: '${pageContext.request.contextPath}/services/books/'+$("#isbn").val(),
			type: 'GET',
			success: function(data) {
				$("#datos").html(data.book.title + ' by ' + data.book.author);
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
	<div class="container">
		<div class="content">
			<div class="page-header">
				<h1>Apache CXF JAX-RS - JQuery</h1>
			</div>
			ISBN: <input id="isbn" type="text" value="0201699699" />
			<button id="find" class="btn primary">Find</button>
			<p>
				<span id="datos"></span>
			</p>
		</div>
	</div>
</body>
</html>