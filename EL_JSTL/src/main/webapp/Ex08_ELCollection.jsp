<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL을 사용하려면 태그라이브러리 디렉티브를 써야 한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL에서 배열 다루기</h2>
	
	<%
		String[] names = "한놈,두식이,석삼,너구리,오징어".split(",");
		request.setAttribute("names", names);
		
		List<String> list = Arrays.asList(names);
		request.setAttribute("list", list);
		
		Set<String> set = new TreeSet<>(list);
		request.setAttribute("set", set);
		
		Map<String, String> map = new HashMap<>();
		map.put("name","한사람");
		map.put("age","34");
		map.put("gender","여");
		request.setAttribute("map", map);
		
		
		
		request.setAttribute("date", new Date());
		
	%>
	${date.year+1900 }년 ${date.month+1}월 ${date.date }일
	<br />
	
	${names } <br />
	${names[0] } ${names[1] } <br />
	${names[2] } ${names[3] } <br />
	<hr />
	
	${list } <br />
	${list[0] } <br />
	${list[1] } <br />
	${list[2] } <br />
	
	<hr />
	${set } <br />
	<%--
	${set[0] } <br />
	${set[1] } <br />
	 --%>
	 
	 ${map.name } ${map["name"]}
	
	

</body>
</html>