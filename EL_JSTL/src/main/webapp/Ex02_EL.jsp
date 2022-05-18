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
	<%
		int sum = 0;
		for(int i=1; i<=100;i++) sum +=i;
		request.setAttribute("sum", sum);
		String name = null;
		request.setAttribute("name", name);
		pageContext.setAttribute("age", 5);
		request.setAttribute("age", 10);
		request.setAttribute("age", 20);
		application.setAttribute("age",30);
	%>
	${age}세 ${pageScope.age}세 ${requestScope.age}세 ${sessionScope.age}세 ${applicationScope.age}세
	<h1>1~100까지의 합 : ${sum}</h1>
	<h2> name : <%=name %></h2>
	<h2> name : ${name}</h2>
</body>
</html>