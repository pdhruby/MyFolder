<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- c:import : 페이지 실행결과 포함 --%>
	<h1> 여기는 나의 화면</h1>
	<hr />
	<%--
	<c:import url="https://www.naver.com"></c:import>	
	 --%>
	 
	<c:import url="https://search.naver.com/search.naver">
		<c:param name="query" value="JSP"></c:param>
	</c:import>
	<hr />
	<h1> 여기는 나의 화면</h1>

</body>
</html>