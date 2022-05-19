<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@page import="kr.human.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<%
	// 삭제할 글을 가져온다.
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
		$("#password").focus();
	});
	function formCheck(){
		var value = $("#password").val();
		if(value==null || value.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
	}
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
	<form action="updateOk.jsp" method="post" onsubmit="return formCheck()">
	<table>
		<tr>
			<td class="title" colspan="4">게시판 삭제하기</td>
		</tr>
		<tr>
			<td>이름</td>
			<td style="text-align: left;"> 
				<input type="text" name="name" value="${vo.name }" readonly="readonly"/>
				<%-- 여기에 몇가지는 숨겨서 가자!!!! --%>
				<input type="hidden" name="p" value="${currentPage }"/>
				<input type="hidden" name="s" value="${pageSize }"/>
				<input type="hidden" name="b" value="${blockSize }"/>
				<input type="hidden" name="idx" value="${vo.idx }"/>
				<input type="hidden" name="click" value="false"/>
				<input type="hidden" name="mode" value="delete"/>
			</td>
			<td>비밀번호</td>
			<td style="text-align: left;"> <input type="password" name="password" id="password" required="required"/> </td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3" style="text-align: left"> 
				<input type="text" name="subject" readonly="readonly" size="90" value="${vo.subject }"/>
			</td>
		</tr>
		<tr>
			<td valign="top">내용</td>
			<td colspan="3"  style="text-align: left">
				<textarea rows="10" cols="100" name="content" readonly="readonly">${vo.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: right;border: none;">
					
					<input type="submit" value=" 삭제하기 " />
					
					<c:url var="url" value="view.jsp">
						<c:param name="p" value="${currentPage }"/>						
						<c:param name="s" value="${pageSize }"/>						
						<c:param name="b" value="${blockSize }"/>	
						<c:param name="idx" value="${vo.idx }"/>	
						<c:param name="click" value="false"/>	
					</c:url>
					<input type="button" onclick="location.href='${url}'" value=" 돌아가기 "/>
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>