<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<%-- TimeZone.getAvailableIDs() : 세계 타임존을 모두 구한다. --%>
	<c:set var="tz" value="<%=TimeZone.getAvailableIDs() %>"></c:set>
	<c:forEach var="t" items="${tz }">
		<fmt:timeZone value="${t }">
			<h2>${t }</h2>
			<fmt:formatDate value="${date }" type="date" dateStyle="full"/> <br />
			<fmt:formatDate value="${date }" type="time" timeStyle="full"/> <br />
		</fmt:timeZone>
		<hr />
	</c:forEach>	
	
</body>
</html>