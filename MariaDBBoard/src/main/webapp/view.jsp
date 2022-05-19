<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@page import="kr.human.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<%
	// 내용보기 : 글번호를 이용하여 보여줄 글 1개를 가져온다.
	BoardVO boardVO = BoardServiceImpl.getInstance().selectByIdx(idx, isClick);
	if(boardVO==null){ // 글이 없다.
		response.sendRedirect("index.jsp");
		return;
	}
	// EL로 출력하기 위하여 영역에 저장한다.
	request.setAttribute("vo", boardVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/jquery/3.6.0/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.servletContext.contextPath }/webjars/bootstrap/5.1.3/js/bootstrap.min.js" ></script>
<script type="text/javascript">
	$(function(){
		
	});
</script>
<style type="text/css">
	table { width: 900px; margin: auto; border: none;}
	th{ padding: 5px; text-align: center; background-color: silver; border: 1px solid gray;}
	td{ padding: 5px; text-align: center;  border: 1px solid gray;}
	.title{ padding: 5px; text-align: center; border: none; font-size: 18pt;}
	.pageinfo{ padding: 5px; text-align: right; border: none; }
</style>
</head>
<body>
	<table>
		<tr>
			<td class="title" colspan="4">게시판 내용보기</td>
		</tr>
		<tr>
			<td> 이름</td>
			<td> <c:out value="${vo.name }"/> </td>
			<td>IP</td>
			<td> <c:out value="${vo.ip }"/> </td>
		</tr>
		<tr>
			<td>작성일</td>
			<td> <fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd(E) hh:mm"/> </td>
			<td>조회수</td>
			<td> <c:out value="${vo.clickCount }"/> </td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3" style="text-align: left"> <c:out value="${vo.subject }"/> </td>
		</tr>
		<tr>
			<td valign="top">내용</td>
			<td colspan="3"  style="text-align: left">
				<c:set var="c" value="${vo.content }"/>
				<c:set var="c" value="${fn:replace(c,'<','&lt;') }"/>
				<c:set var="c" value="${fn:replace(c,newLine,br) }"/>
				${c }
			</td>

			 <%--
			<td colspan="3"  style="text-align: left;white-space: pre-line; ">${vo.content }</td>
			  --%>
		</tr>
		<tr>
			<td colspan="4" style="text-align: right;border: none;">
					<c:url var="url" value="updateForm.jsp">
						<c:param name="p" value="${pv.currentPage }"/>						
						<c:param name="s" value="${pv.pageSize }"/>						
						<c:param name="b" value="${pv.blockSize }"/>	
						<c:param name="idx" value="${vo.idx }"/>						
						<c:param name="click" value="${false }"/>					
					</c:url>
					<button onclick="location.href='${url}'"> 수정하기 </button>
					
					<c:url var="url" value="deleteForm.jsp">
						<c:param name="p" value="${pv.currentPage }"/>						
						<c:param name="s" value="${pv.pageSize }"/>						
						<c:param name="b" value="${pv.blockSize }"/>	
						<c:param name="idx" value="${vo.idx }"/>						
						<c:param name="click" value="${false }"/>					
					</c:url>
					<button onclick="location.href='${url}'"> 삭제하기 </button>
					
					<c:url var="url" value="index.jsp">
						<c:param name="p" value="${pv.currentPage }"/>						
						<c:param name="s" value="${pv.pageSize }"/>						
						<c:param name="b" value="${pv.blockSize }"/>	
					</c:url>
					<button onclick="location.href='${url}'"> 돌아가기 </button>
			
			</td>
		</tr>		
	</table>
</body>
</html>