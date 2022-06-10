<%@page import="java.util.UUID"%>
<%@page import="kr.human.member.service.MemberServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="memberVO" class="kr.human.member.vo.MemberVO"/>
	<jsp:setProperty property="*" name="memberVO"/>
	<%//=memberVO %>
	<%
		// 서비스를 호출하여 삭제를 하고
		MemberServiceImpl.getInstance().delete(memberVO, session);

		// 어디론가 간다.
		response.sendRedirect(request.getContextPath()); // 홈으로
	%>
</body>
</html>