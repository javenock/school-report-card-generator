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
										
					$('.engmyForm #kis').val(formonemarks.kis);
					
					$('.engmyForm #math').val(formonemarks.math);
					});
		
		$('.engmyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .sciBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.scimyForm #regno').val(formonemarks.regno);
					
					$('.scimyForm #bio').val(formonemarks.bio);
					
					$('.scimyForm #chem').val(formonemarks.chem);
					
					$('.scimyForm #phy').val(formonemarks.phy);
					
					});
		
		$('.scimyForm  #exampleModal').modal();
	});	
});

$(document).ready(function(){
	$('.display .humBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.hummyForm #regno').val(formonemarks.regno);
					
					$('.hummyForm #geo').val(formonemarks.geo);
					
					$('.hummyForm #his').val(formonemarks.his);
					
					$('.hummyForm #cre').val(formonemarks.cre);
					
					});
		
		$('.hummyForm  #exampleModal').modal();
	});	
});
$(document).ready(function(){
	$('.display .techBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
				
				$.get(href,function(formonemarks,status){
					$('.techmyForm #regno').val(formonemarks.regno);
					
					$('.techmyForm #agric').val(formonemarks.agric);
					
					$('.techmyForm #biz').val(formonemarks.biz);
					
					$('.techmyForm #comp').val(formonemarks.comp);
					
					$('.techmyForm #hom').val(formonemarks.hom);
					
					});
		
		$('.techmyForm  #exampleModal').modal();
	});	
});


$(document).ready(function(){
	$("#mytable").DataTable();	
});

function myFunction() {
	  var x = document.getElementById("myTopnavi");
	  if (x.className === "topnavi") {
	    x.className += " responsive";
	  } else {
	    x.className = "topnavi";
	  }
	} 




function isNumberKey(evt){
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if(charCode > 31 && (charCode < 48 || charCode > 57)){
		alert("Please Provide Numerics Only");
		return false;
	}
	return true;
}
