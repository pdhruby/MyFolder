<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@page import="kr.human.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 데이터 받기 --%>
	<jsp:useBean id="vo" class="kr.human.board.vo.BoardVO"/>
	<jsp:setProperty property="*" name="vo"/>
	<%-- IP는 수동으로 넣어주자 --%>
	<jsp:setProperty property="ip" name="vo" value="${pageContext.request.remoteAddr }"/>
	
	<%
		switch(vo.getMode()){
		case "insert":
			BoardServiceImpl.getInstance().insert(vo);
			response.sendRedirect("index.jsp?p="+currentPage+"&s="+pageSize+"&b=" + blockSize);
			return;
		case "update":
			BoardServiceImpl.getInstance().update(vo);
			response.sendRedirect("view.jsp?p="+currentPage+"&s="+pageSize+"&b=" + blockSize 
					               + "&idx=" + idx + "&click=false");
			return;
		case "delete":
			BoardServiceImpl.getInstance().delete(vo);
			response.sendRedirect("index.jsp?p="+currentPage+"&s="+pageSize+"&b=" + blockSize);
			return;
		}
	
	%>
</body>
</html>