<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="1.png">
<div align="center">
请您先登录!
<br>
(3秒后自动跳转到登录页面)
<%
response.setHeader("Refresh","3;URL=Login.jsp");
%>
</div>
</body>
</html>