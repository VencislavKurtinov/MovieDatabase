$(function() {

							function loadMovies(query) {
									$.get('Home?query=' + query).then(
											function(data) {
								
					var result = '';
					for (var index = 0; index < data.length; index++) {
						var movie = data[index];

						result += "<tr>";
						result += "<td>" + movie.photo;   
						+"</td>";
						result += "<td>" + movie.name;
						+"</td>";
						result += "<td>" + movie.plot;
						+"</td>";
//						result += "<td> <span class='delete' id=" + movie.id
//								+ ">&times;</span> </td>";
//						result += "</tr>";
					}

					$('table > tbody').html(result);

//					$('.delete').on('click', function() {
//						if (confirm('Are you sure?')) {
//							var id = $(this).attr('id');
//							var self = this;
//
//							$.ajax({
//								url : 'alcohols?id=' + id,
//								type : 'DELETE',
//								success : function(result) {
//									$(self).parent().parent().remove();
//								}
//							});
//						}
//
//					});
										});
							}

//	 $('#search').on('click', function() {
//	 $('#movie').css('background-color', 'blue');
//	 });
//
							$('#movie').on('keyup', function() {
								var text = this.value; // $(this).val()
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
	
//	$('#add').on('click', function() {
//		var data  = {
//			name: $('#name').val(),
//			price: $('#price').val(),
//			procent: $('#procent').val(),
//		}; 
//		
//		$.post('Home', {data: JSON.stringify(data)}).then(function() {
//			loadMovies('');
//		});
//							});
	                                  loadMovies('');
});
