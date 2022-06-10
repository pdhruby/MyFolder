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
	<%
		// String 을 날짜 형식으로 변경하여 넣는다.
		String birth = request.getParameter("birth1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		memberVO.setBirth(sdf.parse(birth));
	%>
	<%//=memberVO %>
	<%
		// 서비스를 호출하여 저장을 하고
		String urlAddress = "http://"+request.getServerName()+":" +
	            	request.getServerPort()+ request.getContextPath() + "/confirm.jsp?fdagd=" + UUID.randomUUID();
		MemberServiceImpl.getInstance().insert(memberVO, urlAddress);
		// 어디론가 간다.
		out.println(memberVO.getEmail() + "로 인증메일이 발송되었습니다. 인증을 진행하시고 로그인하시기 바랍니다.<br>");
		out.println("<a href='" + request.getContextPath() + "'>홈으로</a><br>" );
		/*
		out.println(request.getRequestURI() + "<br>" );
		out.println(request.getRequestURL() + "<br>" );
		out.println(request.getContextPath() + "<br>" );
		out.println(request.getServerName() + "<br>" );
		out.println("http://"+request.getServerName()+":" + 
		            request.getServerPort()+ request.getContextPath() + "/confirm.jsp<br>" );
		*/
	%>
</body>
</html>