<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入试题失败页面——题号存在</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
新增试题失败！
<br />
输入的题号已存在！
<br />
	<form action="Login.jsp" method="post">
		<p>
		<input type="submit" value="返回登录页面" class="button black bigrounded"/>
	</form>
<input type="button" value="返回新增试题页面" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>
</body>
</body>
</html>