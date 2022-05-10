<%@page import="com.google.gson.Gson"%>
<%@page import="kr.human.lunar.pollVO"%>
<%@page import="java.io.FileFilter"%>
<%@page import="java.io.FileReader"%>
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
	
		String filename = application.getRealPath("./data/poll.json");
		
		FileReader fr = new FileReader(filename);
		
		Gson gson = new Gson();
		
		pollVO pollVO = gson.fromJson(fr, pollVO.class);
		
		out.println("설문제목 : "+ pollVO.getTitle() +"<br>");
		
		for(int i=0; i<pollVO.getItem().length;i++){
			out.println("<input type='radio' value ='"+ i+ "'name='poll'>");
			out.println(pollVO.getItem()[i] + "<br>");
		}
	
	
	%>


</body>
</html>