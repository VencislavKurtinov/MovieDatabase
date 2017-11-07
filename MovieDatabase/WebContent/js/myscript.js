$(function() {

	function loadMovies(query) {
		$
				.get('Home?query=' + query)
				.then(
						function(data) {

							var result = '';
							for (var index = 0; index < data.length; index++) {
								var movie = data[index];
								result += "<tr>";
								result += "<td>"
										+ "<img src=\""
										+ movie.photo
										+ "\" alt=\"This Movie pic come soon\" width=\"100\" height=\"100\">"

										+ "</td>";
								result += "<td>" + "<a href=\"Load?name="
										+ movie.name + "&id=" + movie.id
										+ "\"><button>" + movie.name
										+ "</button></a>" + "</td>";
								result += "<td>" + movie.plot;
								+"</td>";

							}

							$('table > tbody').html(result);

						});
	}

	$('#movie').on('keyup', function() {
		var text = this.value;
		loadMovies(text);

		$.get('Home?query=' + text).then(function(data) {
			var result = '';
			for (var index = 0; index < data.length; index++) {
				var moviel = data[index];
				result += "<option>" + movie.name + "</option>";
			}

			$('#movies_list').html(result);
		});
	});

	loadMovies('');
});
