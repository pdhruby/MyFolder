<%@page import="java.util.Locale"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>format태그</h2>
	<hr />
	<%-- TimeZone : 시간대 변경 --%>
	<jsp:useBean id="date" class="java.util.Date"/>
	<c:set var="num" value="123456789.6789"/>
	
	<fmt:formatDate value="${date }" type="date" dateStyle="full"/> <br />
	<fmt:formatDate value="${date }" type="time" timeStyle="full"/> <br />
	<hr />
	<%-- fmt:timeZone : 태그 안에서만 유효 --%>
	<%-- fmt:setTimeZone : 선언 이후 유효 --%>
	<fmt:timeZone value="Ameria/New_York">
		<fmt:formatDate value="${date }" type="date" dateStyle="full"/> <br />
		<fmt:formatDate value="${date }" type="time" timeStyle="full"/> <br />
	</fmt:timeZone>
	<hr />
	<fmt:timeZone value="Asia/Hong_Kong">
		<fmt:formatDate value="${date }" type="date" dateStyle="full"/> <br />
		<fmt:formatDate value="${date }" type="time" timeStyle="full"/> <br />
	</fmt:timeZone>
</body>
</html>