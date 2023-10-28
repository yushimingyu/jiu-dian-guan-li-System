<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<h1><%=request.getAttribute("errorInfo") %></h1>
	
		<a href="javascript:history.back()">返回</a>
		
	</body>
</html>