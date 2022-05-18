<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 예외처리 --%>
	<c:catch var = "e">
		<%=12/3 %> 
	</c:catch>
	<hr />
	<c:catch var = "e">
		<%=12/0 %>
	</c:catch>

	<c:if test="${not empty e}">
		에러가 발생했습니다. ${e } : ${e.message }
	</c:if>
	<hr />
	
	<!--  EL에서 정수 연산시 실수의 결과가 나온다. 아래의 식은 예외가 아니라 결과가
	      12/0 Infinity
	 -->
	<c:catch var = "e">
		12 / 0 = ${12/0 } <br />
		10/3  = ${10/3 }<br />
	</c:catch>

	<c:if test="${not empty e}">
		에러가 발생했습니다. ${e } : ${e.message }
	</c:if>

</body>
</html>