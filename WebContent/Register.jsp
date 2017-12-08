<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
<font size="10",font face="微软雅黑">欢迎注册！</font>
	<p>
	<form action="/Jsp-3/RegisterServlet" method="post">
	<p>
		<font size="4",font face="微软雅黑">请输入用户名: </font>
		<input type="text" name="username"  /><br /><p>
		<font size="4",font face="微软雅黑">请输入密&nbsp&nbsp&nbsp码: </font>
		<input type="password" name="password" /><br /><p>
		<p>
		<input type="submit" value="提交" class="button rosy bigrounded" />
	</form>
	
	<form action="Login.jsp" method="post">
		<input type="submit" value="返回登录页面" class="button black bigrounded" />
	</form>
</div>
</body>
</html>