<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页面</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
<font size="10",font face="微软雅黑">欢迎来到后台管理系统！</font>
	<p>
	<form action="/Jsp-3/AdminMainServlet" method="post">
		<p>
		<input type="submit" value="管理用户" name="admin" class="button blue"/>
		<p>
		<input type="submit" value="管理题库" name="admin" class="button blue"/>
	</form>
	
	<input type="button" value="返回上一页" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>
</body>
</html>