<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="vo" class="kr.human.board.vo.BoardCommentVO"/>
	<jsp:setProperty property="*" name="vo"/>
	
	<%
		switch(vo.getMode()){
		case "insert":
			BoardServiceImpl.getInstance().commentInsert(vo);	
			break;
		case "update":
			BoardServiceImpl.getInstance().commentUpdate(vo);	
			break;
		case "delete":
			BoardServiceImpl.getInstance().commentDelete(vo);
			break;
		}
		response.sendRedirect("view.jsp?p=" + currentPage + "&s=" + pageSize + "&b=" + blockSize + "&idx=" + vo.getRef() + "&click=false");
	%>
</body>
</html>