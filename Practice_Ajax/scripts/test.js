$(document).ready(function() {
	'use strict';
	var MyURL = "http://jsonplaceholder.typicode.com/posts/";
	function handleError(error) {
		console.error("error", error, arguments);
	}
	
	function appendToList(list, post) {
		var newElement = $("<li/>");
		newElement.text(post.title);
		list.append(newElement);
	}
	function processResponse(response) {
		var list = $("#list1");
		var i = 0;
		$.each(response, function() {
			appendToList(list, this);
			if (++i >= 5) {
				return false;
			}
		});
	}
	
	$.ajax(MyURL, {
	  method: "GET"
	}).then(processResponse, handleError);
	var data =  {
				title: "Input text",
 				body: 'random body',
 				userId: 666
			}

	$.ajax(MyURL, {
	  	type: "POST",
	  	data: data,
	  	success: function(postResponse) {
	  		console.log(postResponse.id);
	  		$.ajax(MyURL + postResponse.id, {
	  			method: "GET"
	  			}).then(apList, handleError);
	 	}
	});

	function apList(response){
		console.log(response);
		var list = $("#list1");	
		appendToList(list, response);
	}

	$.ajax({
		type: "DELETE",
		url: MyURL + '101',
			success: function() { 
				alert('OK');
				var toremove = $("#list1 .pretty");	
				console.log(toremove);
				toremove.remove();
		}
	});
});














