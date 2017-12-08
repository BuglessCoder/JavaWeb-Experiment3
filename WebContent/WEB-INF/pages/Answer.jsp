<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="service.QuestionService"
    import="java.util.*"
    import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答案页面</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body background="1.png">
<div align="center">
	<%
	String Name = (String)session.getAttribute("Name");
	int questionCount = (int)request.getAttribute("questionCount");
	int rightCount = (int)request.getAttribute("rightCount");
	int score = (int)request.getAttribute("score");
	String errorQues = (String)request.getAttribute("errorQues");
	ArrayList<String> fromRS = (ArrayList<String>)request.getAttribute("fromRS");
	
	out.println(Name + "同学，测试完成！<br />");
	out.println("共有"+questionCount+"道题，每题20分，你答对了"+rightCount+"道题！<br />");
	if(rightCount == questionCount){
		out.println("恭喜你全答对了！<br />");
	}
	else{
		out.println("你答错了第"+errorQues+"题<br />");
		for(int j=0;j<fromRS.size();j++){
			if(errorQues.contains(j+1+"")){
				int k =j+1;
				out.println("第"+k+"题的正确答案为："+fromRS.get(j)+"<br />");	
			}
		}
	}
	out.println("<br>你的得分是：" + score);
	%>
	<form action="Login.jsp" method="post">
		<p>
		<input type="submit" value="返回登录页面" class="button black bigrounded"/>
	</form>
	
	<input type="button" value="返回上一页" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>
</body>
</html>