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
	<%-- Locale : 언어코드_국가코드 --%>
	<jsp:useBean id="date" class="java.util.Date"/>
	<c:set var="num" value="123456789.6789"/>
	<c:set var="lo" value="<%=Locale.getAvailableLocales() %>"></c:set>	
	<h1>전세계 날짜/숫자 표시 형식</h1>
	<c:forEach var="locale" items="${lo }">
		<h2>${locale }</h2>
		<fmt:setLocale value="${locale }"/>
		<fmt:formatDate value="${date }" type="both" dateStyle="long" timeStyle="long"/> <br />
		<fmt:formatNumber value="${num }"/> <br />
		<hr />		
	</c:forEach>

</body>
</html>