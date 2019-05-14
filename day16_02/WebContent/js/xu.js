
$(function(){
	$("#word").keyup(function(){
		var word=$(this).val();
		
		if (word=="") {
			$("#div01").hide();
		} else {
			$.post("FindWordsServlet",{word:word},function(data,status){
				$("#div01").show();
				$("#div01").html(data);
				
			});
		}
		
	})
})