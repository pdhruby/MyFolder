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
	<%-- c:url : URL주소를 만들어 준다. --%>
	<c:url var="url" value="https://search.naver.com/search.naver">
		<c:param name="query" value="JSP"></c:param>
		<c:param name="query" value="한글"></c:param>
	</c:url>
	<hr />
	${url}<br />
	<hr />
	<a href="${url}">네이버 검색하기</a>
</body>
</html>