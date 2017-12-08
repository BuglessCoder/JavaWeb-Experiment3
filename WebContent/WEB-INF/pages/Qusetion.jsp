<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
<%
	ArrayList<Integer> Number = (ArrayList<Integer>)session.getAttribute("Number");
	ArrayList<String> aStrings = (ArrayList<String>)session.getAttribute("Question");
	String Name = (String)session.getAttribute("Name");
	out.println(Name + "同学，欢迎登录在线考试系统！");	
%>
	
	<form action="/Jsp-3/QuestionServlet" method="post">
		<p>
			<% for(int i=0;i<Number.size();i++){
				out.println(Number.get(i) + "." + aStrings.get(i*5+i)+"<br/>");%>

				A.<input type="radio" name="<%=i+1%>" value="A"/><%=aStrings.get(i*5+i+1)%>&nbsp;&nbsp;&nbsp;&nbsp;
				B.<input type="radio" name="<%=i+1%>" value="B"/><%=aStrings.get(i*5+i+2)%>&nbsp;&nbsp;&nbsp;&nbsp;
				C.<input type="radio" name="<%=i+1%>" value="C"/><%=aStrings.get(i*5+i+3)%>&nbsp;&nbsp;&nbsp;&nbsp;
				D.<input type="radio" name="<%=i+1%>" value="D"/><%=aStrings.get(i*5+i+4)%>&nbsp;&nbsp;&nbsp;&nbsp;
				<p>
			<%}%>
			<p><input type="submit" name="submit" value="提交" class="button rosy bigrounded">
	</form>
	
	<form action="Login.jsp" method="post" name=form>
		<input type="submit" name="back" value="返回" class="button black bigrounded">
	</form>
</div>
</body>
</html>