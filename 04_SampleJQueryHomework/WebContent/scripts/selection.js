$(document).ready(function(){
	//1
	$("a").attr("href", "");
	
	//2
	$("#header ul li a").mouseover(function() {
		if(($(this).css("background"))=="rgb(255, 0, 0)"){
			$(this).css( "background", "#ABEE11" );
		}else{
			$(this).css( "background", "#FF0000" );
		}
	});
	
	//3
	$("p").click(function(){
		$( this ).css( "color", "green" );
	});
	
	//4
	$("#col1 p a").mouseover(function(){
		$( this ).css( "color", "white" );
		$( this ).css( "background", "black" );
	});
	
	//5
	$("#col2 .latest").children().mouseover(function(){
		console.log("mouse over children of #col2 .latest");
	});
	
	//6
	$("#col3").mouseover(function(){
		var kids = $("#col3").children().length;
		console.log("#col3 has " + (kids+1) + " children");
	});
	
	//7
	$("#mc-embedded-subscribe").click(function(){
		$('#mc-embedded-subscribe-form').attr('action', '');
	});
	
	//8
	$("#mc_embed_signup form div:first-child label").mouseover(function(){
		console.log("over first label");
	});
	
	//9
	console.log($("#header #submit"));
	
	//10
	console.log($("#home .inscreen #col2 p a"));
	
	//11
	console.log($("html"));
	
	//12
	console.log($("#footer"));
	
	//13
	$("body").click(function(){
		$('body').css('background', '#000 url(http://doge2048.com/meta/doge-600.png)');
	});
	
	//14
	$("form").attr("action", "");
	
	//15
	$("a.tu").mouseover(function(){
		console.log($(this));
		$(this).css('display', 'none');
		alert("Over that small pic down there :D");
	});
});