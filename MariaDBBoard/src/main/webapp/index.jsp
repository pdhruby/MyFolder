<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@page import="kr.human.board.service.BoardService"%>
<%@page import="kr.human.board.vo.BoardVO"%>
<%@page import="kr.human.board.vo.PagingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<%
	// 서비스 클래스를 호출하여 결과를 받아 request영역에 넣는다.
	PagingVO<BoardVO> pagingVO = BoardServiceImpl.getInstance().selectList(currentPage, pageSize, blockSize);
	request.setAttribute("pv", pagingVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
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
			<td class="title" colspan="5">자유게시판</td>
		</tr>
		<tr>
			<td class="pageinfo" colspan="5">${pv.pageInfo }</td>
		</tr>
		<tr>
			<th>No</th>
			<th width="60%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${empty pv.list }">
			<tr>
				<td align="center" colspan="5">등록된 글이 없습니다.</td>
			</tr>		
		</c:if>
		<c:if test="${not empty pv.list }">
			<%-- 현재 페이지의 글번호 시작값을 계산한다. --%>
			<c:set var="no" value="${pv.totalCount - (pv.currentPage-1) * pv.pageSize }"></c:set>
			<c:forEach var="vo" items="${pv.list }" varStatus="vs">
				<tr>
					<td>${no - vs.index  }</td>
					<td style="text-align: left;">
						<c:url var="url" value="view.jsp">
							<c:param name="p" value="${pv.currentPage }"/>						
							<c:param name="s" value="${pv.pageSize }"/>						
							<c:param name="b" value="${pv.blockSize }"/>						
							<c:param name="idx" value="${vo.idx }"/>						
							<c:param name="click" value="${true }"/>						
						</c:url>
						<a href="${url }"><c:out value="${vo.subject }" /></a>
					</td>
					<td>
						<c:out value="${vo.name }" />
					</td>
					<td>
						<fmt:formatDate value="${vo.regDate }" pattern="yy-MM-dd"/>
					</td>
					<td>${vo.clickCount }</td>
				</tr>			
			</c:forEach>
			<tr>
				<td class="pageinfo" style="text-align: center;" colspan="5">${pv.pageList }</td>
			</tr>
			<tr>
				<td class="pageinfo" colspan="5">
					<c:url var="url" value="insertForm.jsp">
						<c:param name="p" value="${pv.currentPage }"/>						
						<c:param name="s" value="${pv.pageSize }"/>						
						<c:param name="b" value="${pv.blockSize }"/>						
					</c:url>
					<button onclick="location.href='${url}'">글쓰기</button>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>