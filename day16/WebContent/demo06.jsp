<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">

	function post(){
		$.post("/day16/DemoServlet02",{name:"zhangsan",age:18}  ,function(data,status){
			
			alert("结果是"+data);
			$("#div01").html(data);
		});
		
	}

</script>
</head>
<body>

<h3><input type="button" onclick="post()" value="JQuery方式执行post"></h3>

<div id="div01" style=" width:100px;height:100px;border: 1px solid blue;" >

</div>

</body>
</html>