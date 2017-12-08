<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增试题页面</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
<font size="5",font face="微软雅黑">请输入要添加的试题信息：</font>
<form action="/Jsp-3/InsertQuestionServlet" method="post">
	<p>
		<font size="4",font face="微软雅黑">题号: </font>
		<input type="text" name="number"  /><p>
		<font size="4",font face="微软雅黑">问题: </font>
		<input type="text" name="question"  /><p> 
		<font size="4",font face="微软雅黑">A选项: </font>
		<input type="text" name="answerA"  /><p> 
		<font size="4",font face="微软雅黑">B选项: </font>
		<input type="text" name="answerB"  /><p> 
		<font size="4",font face="微软雅黑">C选项: </font>
		<input type="text" name="answerC"  /><p> 
		<font size="4",font face="微软雅黑">D选项: </font>
		<input type="text" name="answerD"  /><p> 
		<font size="4",font face="微软雅黑">正确答案: </font>
		<input type="text" name="rightAnswer" /><p> 
		
		<p>
		<input type="submit" value="提交" class="button rosy bigrounded"/>
	</form>

	<form action="Login.jsp" method="post">
		<p>
		<input type="submit" value="返回登录页面" class="button black bigrounded"/>
	</form>
	
	<input type="button" value="返回上一页" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>

</body>
</html>