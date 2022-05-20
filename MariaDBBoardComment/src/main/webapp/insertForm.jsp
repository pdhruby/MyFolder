<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@page import="kr.human.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
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
		$("#name").focus();
	});
	function formCheck(){
		var value = $("#name").val();
		if(value==null || value.trim().length==0){
			alert('이름은 반드시 입력해야 합니다.');
			$("#name").val("");
			$("#name").focus();
			return false;
		}
		var value = $("#password").val();
		if(value==null || value.trim().length==0){
			alert('비밀번호는 반드시 입력해야 합니다.');
			$("#password").val("");
			$("#password").focus();
			return false;
		}
		var value = $("#subject").val();
		if(value==null || value.trim().length==0){
			alert('제목은 반드시 입력해야 합니다.');
			$("#subject").val("");
			$("#subject").focus();
			return false;
		}
		var value = $("#content").val();
		if(value==null || value.trim().length==0){
			alert('내용은 반드시 입력해야 합니다.');
			$("#content").val("");
			$("#content").focus();
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
			<td class="title" colspan="4">게시판 새글쓰기</td>
		</tr>
		<tr>
			<td>이름</td>
			<td style="text-align: left;"> 
				<input type="text" name="name" id="name" required="required"/>
				<%-- 여기에 몇가지는 숨겨서 가자!!!! --%>
				<input type="hidden" name="p" value="1"/>
				<input type="hidden" name="s" value="${pageSize }"/>
				<input type="hidden" name="b" value="${blockSize }"/>
				<input type="hidden" name="idx" value="0"/>
				<input type="hidden" name="click" value="false"/>
				<input type="hidden" name="mode" value="insert"/>
			</td>
			<td>비밀번호</td>
			<td style="text-align: left;"> <input type="password" name="password" id="password" required="required"/> </td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3" style="text-align: left"> 
				<input type="text" name="subject" id="subject" required="required" size="90"/>
			</td>
		</tr>
		<tr>
			<td valign="top">내용</td>
			<td colspan="3"  style="text-align: left">
				<textarea rows="10" cols="100" name="content" id="content" required="required"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: right;border: none;">
					
					<input type="submit" value=" 저장하기 " />
					
					<c:url var="url" value="index.jsp">
						<c:param name="p" value="${pv.currentPage }"/>						
						<c:param name="s" value="${pv.pageSize }"/>						
						<c:param name="b" value="${pv.blockSize }"/>	
					</c:url>
					<input type="button" onclick="location.href='${url}'" value=" 돌아가기 "/>
			
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>