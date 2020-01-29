 /**
 * 
 */

$(document).ready(function(){
	$('.display .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(student,status){
					$('.myForm #regno').val(student.regno);
					
					$('.myForm #fname').val(student.fname);
					
					$('.myForm #sirname').val(student.sirname);
				});
		
		$('.myForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .engBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.engmyForm #regno').val(formonemarks.regno);
					
					$('.engmyForm #eng').val(formonemarks.eng);
					
					});
		
		$('.engmyForm  #exampleModal').modal();
	});	
});
$(document).ready(function(){
	$('.display .kisBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.kismyForm #regno').val(formonemarks.regno);
					
					$('.kismyForm #kis').val(formonemarks.kis);
					
					});
		
		$('.kismyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .mathBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.mathmyForm #regno').val(formonemarks.regno);
					
					$('.mathmyForm #math').val(formonemarks.math);
					
					});
		
		$('.mathmyForm  #exampleModal').modal();
	});	
});
$(document).ready(function(){
	$('.display .bioBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.biomyForm #regno').val(formonemarks.regno);
					
					$('.biomyForm #bio').val(formonemarks.bio);
					
					});
		
		$('.biomyForm  #exampleModal').modal();
	});	
});
$(document).ready(function(){
	$('.display .chemBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.chemmyForm #regno').val(formonemarks.regno);
					
					$('.chemomyForm #chem').val(formonemarks.chem);
					
					});
		
		$('.chemmyForm  #exampleModal').modal();
	});	
});
$(document).ready(function(){
	$('.display .phyBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.phymyForm #regno').val(formonemarks.regno);
					
					$('.phymyForm #phy').val(formonemarks.phy);
					
					});
		
		$('.phymyForm  #exampleModal').modal();
	});	
});
$(document).ready(function(){
	$('.display .geoBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.geomyForm #regno').val(formonemarks.regno);
					
					$('.geomyForm #geo').val(formonemarks.geo);
					
					});
		
		$('.geomyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .hisBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.hismyForm #regno').val(formonemarks.regno);
					
					$('.hismyForm #his').val(formonemarks.his);
					
					});
		
		$('.hismyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .creBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.cremyForm #regno').val(formonemarks.regno);
					
					$('.cremyForm #cre').val(formonemarks.cre);
					
					});
		
		$('.cremyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .agricBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.agricmyForm #regno').val(formonemarks.regno);
					
					$('.agricmyForm #agric').val(formonemarks.agric);
					
					});
		
		$('.agricmyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .bizBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.bizmyForm #regno').val(formonemarks.regno);
					
					$('.bizmyForm #biz').val(formonemarks.biz);
					
					});
		
		$('.bizmyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .compBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.compmyForm #regno').val(formonemarks.regno);
					
					$('.compmyForm #comp').val(formonemarks.comp);
					
					});
		
		$('.compmyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .homBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.hommyForm #regno').val(formonemarks.regno);
					
					$('.hommyForm #hom').val(formonemarks.hom);
					
					});
		
		$('.hommyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$("#mytable").DataTable();	
});


function isNumberKey(evt){
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if(charCode > 31 && (charCode < 48 || charCode > 57)){
		alert("Please Provide Numerics Only");
		return false;
	}
	return true;
}






