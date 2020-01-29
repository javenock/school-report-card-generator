$(document).ready(function(){
	$('.display_table .f3_Btn').on('click',function(event){		
		event.preventDefault();		
		var href = $(this).attr('href');
		$.get(href,function(student,status){
			$('.student_subject #regno').val(student.regno);
			
			$('.student_subject #stream').val(student.stream);			
			});
		$('.student_subject  #exampleModal').modal();
		
	});	
	
});
$(document).ready(function(){
	$("#mytable").DataTable();	
});