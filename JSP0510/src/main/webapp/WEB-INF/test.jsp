<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
int poll = Integer.parseInt(request.getParameter("poll"));
	out.println(poll + "<br>");
	
	%>
</body>
</html>