$(document).ready(function(){
	$('.nBtn, .display .new_f3_Btn').on('click',function(event){		
		event.preventDefault();		
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text == 'Edit'){
		$.get(href,function(student,status){
			$('.update_student #regno').val(student.regno);			
			$('.update_student #fname').val(student.fname);
			$('.update_student #kcpemarks').val(student.kcpemarks);
			});
		$('.update_student  #exampleModal').modal();	
	}
	else{
		$('.new_student #regno').val('');		
		$('.new_student #fname').val('');
		$('.new_student #kcpemarks').val('');
		$('.new_student  #exampleModal').modal();
	}
});
	$('.display .delBtn').on('click',function(event){		
		event.preventDefault();		
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();
		
});
});
function isNumberKey(evt){
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if(charCode > 31 && (charCode < 48 || charCode > 57)){
		alert("Please Provide Numerics Only");
		return false;
	}
	return true;
}
$(document).ready(function(){
	$("#mytable").DataTable();	
});

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




