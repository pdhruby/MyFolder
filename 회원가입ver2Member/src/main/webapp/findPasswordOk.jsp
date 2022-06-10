<%@page import="kr.human.member.vo.MemberVO"%>
<%@page import="kr.human.member.service.MemberServiceImpl"%>
<%@page import="kr.human.member.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getMethod().equals("GET")){
			response.sendRedirect(request.getContextPath());
			return;
		}
		String userid = request.getParameter("userid");
		String phone = request.getParameter("phone");
		
		if(userid!=null && phone!=null){
			// 서비스를 호출하여 해당회원의 정보를 가져온다.
			MemberVO memberVO = MemberServiceImpl.getInstance().searchPassword(userid, phone);
			if(memberVO==null){
				request.setAttribute("error", "잘못된 정보입니다.");
				pageContext.forward("findPassword.jsp");
			}else{
				out.println(userid + "님의 임시비밀번호가 \"" + memberVO.getEmail() + "\"로 발송되었습니다.<br>");
				out.println("<a href='login.jsp'>로그인하러가기</a>");
			}
		}else{
			request.setAttribute("error", "잘못된 정보입니다.");
			pageContext.forward("findPassword.jsp");
			return;
		}
	%>
</body>
</html>