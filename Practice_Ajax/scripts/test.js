$(document).ready(function() {
	'use strict';
	var MyURL = "http://jsonplaceholder.typicode.com/posts";
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

	$.ajax(MyURL, {
	  	type: "POST",
	  	data: "My Name Is Slim Shady",
	  	success: function(postResponse) {
	  		var newUrl = MyURL + postResponse.id;
	  		$.ajax(newUrl, {
	  			method: "GET"
	  			}).then(apList, handleError);
	 	}
	});

	function apList(response){
		var list = $("#list1");
		appendToList(list, this);
		alert('appending to list');
	}
});














