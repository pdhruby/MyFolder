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
	<h2> 초기화 파라메터 읽기</h2>
	<%=application.getInitParameter("db") %><br />
	<%=application.getInitParameter("user") %><br />
	<%=application.getInitParameter("pw") %><br />
	<br />
	${initParam.db } <br />
	${initParam.user } <br />
	${initParam.pw } <br />
	

</body>
</html>