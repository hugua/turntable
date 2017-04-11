<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>连接异常</title>
<script type="text/javascript">
	function back(){
		window.history.go(-1);
	}
</script>
<style type="text/css">
	#back{
		margin: 0 0 0 56%;
		border: 1px solid black;
		border-radius: 10px;
		font-size: 50px;
		padding: 15px 30px 15px 30px;
	}
	#errorImg{
		width:100%; 
		margin: 30% 0 30px 0;
	}
</style>
</head>
<body>
	<img id="errorImg" style="" src="./image/fengkuang.jpg"/>
	<input id="back" type="button" value="返回" onclick="back()"/>
</body>
</html>