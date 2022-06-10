<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<c:if test="${empty sessionScope.memberVO }">
		<a href="insertForm.jsp">회원가입</a>  
		<a href="login.jsp">로그인</a>
	</c:if>
	<c:if test="${not empty sessionScope.memberVO }">
		${sessionScope.memberVO.userid }(${sessionScope.memberVO.name })님 반갑습니다 <br>
		
		<a href="updateForm.jsp">정보수정</a> 
		<a href="deleteForm.jsp">회원탈퇴</a> 
		<a href="logout.jsp">로그아웃</a>
	</c:if>
</body>
</html>