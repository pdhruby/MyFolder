<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- c:out : 값을 인코딩해서 출력한다. --%>
	<c:set var="str" value="나의 이름은 <u><i><b>홍길동</b></i></u>"/>
	
	${str } <br />
	<c:out value="${str} "/> <br />
	<c:out value="${str} " escapeXml="true"/> <br />
	<c:out value="${str} " escapeXml="false"/> <br />
	
		<h2>format 태그</h2>
	<%-- 날짜를 원하는 형식으로 출력해보자 --%>
		
</body>
</html>