<%@page import="kr.human.member.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 사용자 아이디를 읽는다.
	String userid = request.getParameter("userid");
	// 서비스를 호출하여 해당 아이디의 use(인증), lev(권한)값을 변경해주고
	boolean isConfirm = false;
	if(userid!=null){
		isConfirm = MemberServiceImpl.getInstance().emailConfirm(userid);
	}
	
%>
<% if(isConfirm){ %>
	<h2>반갑습니다. <%=userid %>님 인증에 성공하셨습니다.</h2>
	<h2>즐거운 시간되시기 바랍니다.</h2>
	<a href="${pageContext.request.contextPath }">홈</a>
	<a href="${pageContext.request.contextPath }/login.jsp">로그인</a>
<% }else{ %>
	<h2><%=userid %>님 인증에 실패하셨습니다.</h2>
	<h2>장난치시면 죽어요~~~~</h2>
	<a href="${pageContext.request.contextPath }">홈</a>
	<a href="${pageContext.request.contextPath }/insertForm.jsp">회원가입</a>
<% } %>
</body>
</html>