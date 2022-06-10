<%@page import="kr.human.member.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
String userid = request.getParameter("userid");
int count = MemberServiceImpl.getInstance().idCheck(userid);
out.println(count);
%>