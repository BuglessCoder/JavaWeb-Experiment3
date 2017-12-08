<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息页面</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<style>  
th, tr, td, table {  
    border: 1px solid red;  
}  
</style> 
<body background="1.png">
<div align="center">
<%
	List<Map> list = (List<Map>)request.getAttribute("list");
%>
<table border="2">  
		<tr>  
            <th>用户名</th>  
            <th>用户类型</th>  
        </tr>  
  
        <c:forEach items="${list}" var="usr" varStatus="idx">
       		<tr>  
                <td>${usr.name}</td>
                <td>${usr.type}</td>
        	</tr>  
        </c:forEach>  
</table>
<form action="Login.jsp" method="post">
		<p>
		<input type="submit" value="返回登录页面" class="button black bigrounded"/>
</form>
	
<input type="button" value="返回上一页" onclick="javascript:history.back(-1);" class="button black bigrounded"/>
</div>  
</body>
</html>