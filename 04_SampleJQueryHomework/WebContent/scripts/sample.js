$(document).ready(function(){
	$("#button").click(function(){
		var name = $("#name").val();
		if (name.length > 0) {
			$("#list1").append("<li class='pretty'>"+name+"</li>");
		}else{
			alert("Please, input a valid name for list element");
		}
	});
});