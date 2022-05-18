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
	<h2> format태그</h2>
	<hr />
	<%-- 숫자를 원하는 형식으로 출력해보자  --%>
	<c:set var ="n" value ="123456789.56789"/>
	
	${n } <br />
	<fmt:formatNumber value="${n }"></fmt:formatNumber> <br />
	<fmt:formatNumber value="${n }" groupingUsed="true"/> <br />
	<fmt:formatNumber value="${n }" groupingUsed="false"/> <br />

	<fmt:formatNumber value="${n }" pattern="0.00"/> <br />
	<fmt:formatNumber value="${n }" pattern="0,000.000"/> <br />
	
	<fmt:formatNumber value="${n }" pattern="#.##"/> <br />
	<fmt:formatNumber value="${n }" pattern="#,###.###"/> <br />
	
	
	<%-- 0과 #의 차이는 0은 반드시 그 자릿수 까지 출력해라 --%>
	<fmt:formatNumber value="12.4" pattern="#,###.###"/> <br />
	<fmt:formatNumber value="12.4" pattern="0,000.000"/> <br />
	
	<%-- 화폐단위 출력 --%>
	<fmt:formatNumber value="7689876" type="currency"/> <br />
	<fmt:formatNumber value="7689876" type="currency" currencySymbol="$"/> <br />
	<fmt:formatNumber value="7689876" type="currency" currencySymbol="$" var="pay"/> <br />
	${pay }
	
</body>
</html>