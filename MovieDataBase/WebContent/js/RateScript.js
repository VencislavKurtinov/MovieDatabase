$(function() {

	//	
	// .get('Home?rate=' + rate)
	// .then(
	// function(data) {
	//
	// var result = '';
	// for (var index = 0; index <10; index++) {
	// var movie = data[index];
	// result += "<tr>";
	// result += "<td>"+
	// "</td>";
	// result += "<td>" + + "</td>";
	// result += "<td>" + movie.plot;
	// +"</td>";
	// // result += "<td> <span class='delete' id=" +
	// // movie.id
	// // + ">&times;</span> </td>";
	// // result += "</tr>";
	// }
	//
	// $('table > tbody').html(result);

	// $('.delete').on('click', function() {
	// if (confirm('Are you sure?')) {
	// var id = $(this).attr('id');
	// var self = this;
	//
	// $.ajax({
	// url : 'alcohols?id=' + id,
	// type : 'DELETE',
	// success : function(result) {
	// $(self).parent().parent().remove();
	// }
	// });
	// }
	//
	// });
	// });
	// }

	// $('#search').on('click', function() {
	// $('#movie').css('background-color', 'blue');
	// });
	//
	$('#rate').on(
			'click',
			function() {
				var result = "";
				for (var index = 0; index < 10; index++) {

					result += "<a href=\"Rate?with=\"" + index
							+ "\"\"><button>" + index + "</button></a>";
				}
				$('body > h1').html(result);
			});

	// $('#add').on('click', function() {
	// var data = {
	// name: $('#name').val(),
	// price: $('#price').val(),
	// procent: $('#procent').val(),
	// };
	//		
	// $.post('Home', {data: JSON.stringify(data)}).then(function() {
	// loadMovies('');
	// });
	// });

});
