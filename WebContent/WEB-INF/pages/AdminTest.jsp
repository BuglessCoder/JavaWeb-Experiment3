<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理题库页面</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
<font size="10",font face="微软雅黑">欢迎来到题库管理系统！</font>
<p>
	<form action="/Jsp-3/AdminTestServlet" method="post">
	<p>
		<input type="submit" value="查看试题" name='adminTest' class="button blue"/>
		<input type="submit" value="新增试题" name='adminTest' class="button blue"/>
		<input type="submit" value="删除试题" name='adminTest' class="button blue"/>
		<input type="submit" value="修改试题选项" name='adminTest' class="button blue"/>
		<input type="submit" value="修改正确答案" name='adminTest' class="button blue"/>
	</form>
	<form action="Login.jsp" method="post">
		<p>
		<input type="submit" value="返回登录页面" class="button black bigrounded"/>
	</form>
	
	<input type="button" value="返回上一页" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>
</body>
</html>