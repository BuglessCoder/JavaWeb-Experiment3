<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
<font size="10",font face="微软雅黑">欢迎来到在线考试系统</font><p>

	<form action="/Jsp-3/LoginServlet" method="post"><p>
		<font size="4",font face="微软雅黑">用户名: </font>	
		<input type="text" name="Name" placeholder="请输入用户名" /><br /><p>
		<font size="4",font face="微软雅黑">密&nbsp&nbsp&nbsp码: </font>
		<input type="password" name="Password" placeholder="请输入密码"/><br /><p>
		<input type="submit" value="登录" class="button blue bigrounded" />
	
	</form>

	<form action="Register.jsp" method="post"><p>
		<input type="submit" value="注册" class="button rosy bigrounded"/>
	</form>
</div>
</body>
</html>