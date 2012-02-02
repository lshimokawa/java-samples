<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.3.0/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	$.ajax({
		url: '${pageContext.request.contextPath}/services/books',
		type: 'GET',
		success: function(data) {
			$.each(data, function(i, book){
				$('#list').append(
					'<li>' + book.title + ' by ' + book.author + '</li>'
				);
			});
		},
		error: function(data) {
			alert("Error");
		}
	});
 });
</script>
</head>
<body>
	<div class="container">
		<div class="content">
			<div class="page-header">
				<h1>Bookshelf</h1>
			</div>
			<ul id="list"></ul>
		</div>
	</div>
</body>
</html>