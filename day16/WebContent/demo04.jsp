<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">

function load(){
	
	
	
	 $("#text01").load("/day16/DemoServlet02" , function(responseText,statusTXT,xhr){
		
		$("#text01").val(responseText);
	});  
	
}

</script>



</head>
<body>


<h3><input type="button" onclick="load()" value="JQuery方式执行load"></h3>
<input type="text"  id="text01">

</body>
</html>