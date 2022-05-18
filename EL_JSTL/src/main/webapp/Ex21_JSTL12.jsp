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
	<jsp:useBean id="date" class="java.util.Date" />
	<c:set var="num" value="123456789.6789" />

	${date }
	<br /> ${num }
	<br />
	<hr />
	<fmt:formatDate value="${date }" type="both" dateStyle="long"
		timeStyle="long" />
	<br />
	<fmt:formatNumber value="${num }" />
	<br />
	<hr />
	<h1>한국</h1>
	<fmt:setLocale value="ko_kr" />
	<fmt:formatDate value="${date }" type="both" dateStyle="long"
		timeStyle="long" />
	<br />
	<fmt:formatNumber value="${num }" />
	<br />
	<h1>미국</h1>
	<fmt:setLocale value="en_us" />
	<fmt:formatDate value="${date }" type="both" dateStyle="long"
		timeStyle="long" />
	<br />
	<fmt:formatNumber value="${num }" />
	<br />
	<h1>일본</h1>
	<fmt:setLocale value="ja_jp" />
	<fmt:formatDate value="${date }" type="both" dateStyle="long"
		timeStyle="long" />
	<br />
	<fmt:formatNumber value="${num }" />
	<br />
	<h1>독일</h1>
	<fmt:setLocale value="de_DE" />
	<fmt:formatDate value="${date }" type="both" dateStyle="long"
		timeStyle="long" />
	<br />
	<fmt:formatNumber value="${num }" />
	<br />
	<h1>프랑스</h1>
	<fmt:setLocale value="fr_FR" />
	<fmt:formatDate value="${date }" type="both" dateStyle="long"
		timeStyle="long" />
	<br />
	<fmt:formatNumber value="${num }" />
	<br />

</body>
</html>