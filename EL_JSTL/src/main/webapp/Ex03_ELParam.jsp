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
	<h2>주소표시줄 뒤에 ? n=12&m=34 를 붙여 실행해보라</h2>
	
	n = ${param.n } <br />
	m = ${param.m } <br />
	
	<c:set var="n" value="${param.n }"/>
	<c:set var="m" value="${param.m }"/>
	
	${n } + ${m } = ${n+m } <br />
	${n } - ${m } = ${n-m } <br />
	${n } * ${m } = ${n*m } <br />
	${n } / ${m } = ${n/m } <br />
	${n } / ${m } = ${n div m } <br />
	${n } % ${m } = ${n%m } <br />
	${n } == ${m } = ${n == m } <br />
	${n } eq ${m } = ${n eq m } <br />
	${n } != ${m } = ${n != m } <br />
	${n } ne ${m } = ${n ne m } <br />
	${n } >= ${m } = ${n >= m } <br />
	${n } ge ${m } = ${n ge m } <br />
	${n } > ${m } = ${n > m } <br />
	${n } gt ${m } = ${n gt m } <br />
	${n } <= ${m } = ${n <= m } <br />
	${n } le ${m } = ${n le m } <br />
	${n } < ${m } = ${n < m } <br />
	${n } lt ${m } = ${n lt m } <br />
</body>
</html>