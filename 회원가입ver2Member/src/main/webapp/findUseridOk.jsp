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
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		if(name!=null && phone!=null){
			// 서비스를 호출하여 해당회원의 정보를 가져온다.
			MemberVO memberVO = MemberServiceImpl.getInstance().searchUserid(name, phone);
			if(memberVO==null){
				request.setAttribute("error", "잘못된 정보입니다.");
				pageContext.forward("findUserid.jsp");
			}else{
				out.println(name + "님의 아이디는 \"" + memberVO.getUserid() + "\"입니다.<br>");
				out.println("<a href='login.jsp'>로그인하러가기</a>");
			}
		}else{
			request.setAttribute("error", "잘못된 정보입니다.");
			pageContext.forward("findUserid.jsp");
			return;
		}
	%>
</body>
</html>