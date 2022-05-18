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

	Host : <%=request.getHeader("host") %> <br />
	Host : ${header.host }  <br />

	user-agent : <%=request.getHeader("user-agent") %> <br />
	
	<!--  -는 뺴기 기호로 인식하기때문에 밑에처럼 대괄호로 써야한다. -->
	user-agent : ${header.user-agent } <br /> 	
	user-agent : ${header['user-agent']}<br />
	

</body>
</html>