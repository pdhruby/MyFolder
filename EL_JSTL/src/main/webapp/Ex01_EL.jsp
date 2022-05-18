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
	<c:forEach var ="i" begin="0" end="10">
		<c:if test="${i%2==0}">
			${i} <br />
		</c:if>
	</c:forEach>
	<jsp:useBean id="today" class="java.util.Date" scope="request"/>
	<fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일 hh:mm"/><br />
	${fn:toUpperCase("jsp")}
</body>
</html>