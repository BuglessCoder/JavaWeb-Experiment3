<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改正确答案页面</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
	<form action="/Jsp-3/AlterRightAnswerServlet" method="post">
		<p>
		<font size="4",font face="微软雅黑">请输入你想要修改答案的试题题号: </font><p>
		<input type="text" name="number"  /><br /> 
		<p>
		<font size="4",font face="微软雅黑">请输入你想要修改该试题的正确答案: </font><p>
		<input type="text" name="rightAnswer"  /><br /> 
		<p>
		<input type="submit" value="确认" class="button rosy bigrounded"/>
	</form>
	<form action="Login.jsp" method="post">
		<p>
		<input type="submit" value="返回登录页面" class="button black bigrounded"/>
	</form>
	
	<input type="button" value="返回上一页" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>

</body>
</html>