// JavaScript Document
$(document).ready(function() {
	var myServer = "http://jsonplaceholder.typicode.com/posts";
	
	//#2
	console.log($("#footer:first a").attr("title"));	
	
	//#3
	console.log($("#col1 > p").text());
	
	//#4
	var myLink = $(".menu-top-level-menu-container ul").append('<li><a id="myLink" href="#">New Button</a></li>');
	
	//#5
	var e = $('<div></div>');
	$('#footer').prepend(e);    
	e.attr('id', 'dynamiccontent');
	
	//#6
	var myInput = $('<input type="text" id="textinput">').appendTo('#dynamiccontent');
	
	//#7
	var myButton = $('<button type="button" id="addbutton">Click Me!</button>').appendTo('#dynamiccontent');
	
	//#8
	var myUl = $('<ul id="posts"></ul>').appendTo('#dynamiccontent');
	
	//#9
	myLink.click(function(){
  		alert("Hello, World!");
	});
	
	//#10
	myLink.click(function(){
		var col1 = $('#col1');
		var col2 = $('#col2');
		if($("#col1").is(":first-child")){
			col1.before(col2);
		}else{
			col2.before(col1);
		}
	});
	
	//#11
	$.ajax(myServer, {
		method: 'GET'
	}).then(function(data) {
		var i = 1;
		$.each(data, function(key, val) {
			addToUl(val.id, val.title);
			if(i++ >= 5) {
				return false;
			}
		});
	});
	
	function addToUl(id, title){
		var element = $("<li/>").append($("<p/>").text(title));
		myUl.append(element);
	}
	
	//#12.#13,#14
	myButton.click(function(){
		if(!myInput.val()){
			alert("You must enter text");
		}else{
			$.ajax('http://jsonplaceholder.typicode.com/posts', {
				method: 'POST',
				data: {
					title: 'MyInput',
					body:  myInput.val(),
					userId: 1
				}
			}).then(function(data) {
				$.ajax('http://jsonplaceholder.typicode.com/posts/' + data.id, {
  					method: 'GET'
				}).then(function(data) {
  					var element = $("<li/>");
  					element.text(data.title);
  					posts.append(element);
				});
			});
		}
	});
	
	//#17
	var myInput2 = $('<input type="text" id="textinput2">');
	myInput2.before(myUl);
	
	//#18,#19
	myInput2.change(function(){
		var userID = myInput2.val();
		myInput2.val('');
		$.ajax(jsonHost + 'posts?userId=' + userID, {
			method: 'GET'
		}).then(function(data) {
			myUl.empty();
			var element = $("<li/>");
  			element.text(data.title);		
			posts.append(element);
		});	
	});
	
});
