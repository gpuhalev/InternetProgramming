$(document).ready(function() {
	'use strict';

	var myButton = $("#myButton");
	var tfield1 = $("#tfield1");
	var tfield2 = $("#tfield2");
	var tfield3 = $("#tfield3");
	var MyURL = "http://172.16.18.80:18080/jsontest/";


	myButton.click(function(){
		if(tfield1.val().length <= 0 || tfield2.val().length <= 0){
			tfield3.text('ERROR: Please, enter key and value');
		}else{
			console.log(MyURL + tfield1.val() + "/" + tfield2.val() + "/?service=echo");
			$.ajax(MyURL + tfield1.val() + "/" + tfield2.val() + "/?service=echo", {
			  	type: "POST",
			  	dataType: 'json',
			  	success: function(postResponse) {
			  		console.log(postResponse);
			  		//var name = Object.keys(postResponse);
			  		//var value = $.map(postResponse, function(val, key) { return val; });
			  		var obj = JSON.stringify(postResponse);
			  		tfield3.text('JSON:' + obj);
			 	}
			});
		}
	});
});