$(function(){
	$("#province").change(function(){
		var pid=$(this).val();
		$.post("CityServlet",{pid:pid},function(data,status){
			
			$("#city").html("<option value=''>-请选择-");
			$(data).find("city").each(function(){
				var id=$(this).children("id").text();
				var cname=$(this).children("cname").text();
				//alert("id="+id+"cname="+cname);
				$("#city").append("<option value='"+id+"'>"+cname);
			});
		});
	});
});