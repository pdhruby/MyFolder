<%@page import="kr.human.fileboard.service.FileBoardServiceImpl"%>
<%@page import="kr.human.fileboard.vo.FileBoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 공통코드 삽입 --%>
<%@ include file="include.jsp" %>
<%
	FileBoardVO fileBoardVO = FileBoardServiceImpl.getInstance().selectByIdx(idx);
	if(fileBoardVO==null){
		response.sendRedirect("index.jsp");
		return;
	}
	request.setAttribute("vo", fileBoardVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 삭제하기</title>
<%-- 부트스트랩을 사용하기 위한 준비 시작 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- 부트스트랩을 사용하기 위한 준비 끝 --%>
<%-- 사용자 정의 자바스크립트 함수를 추가한다. --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/commons.js"></script>
<script type="text/javascript">
	
	$(function(){
		$("#password").focus();
	});

	function formCheck(){
		var obj = $("#password");
		if(obj.val()==null || obj.val().trim().length==0){
			alert("비밀번호는 반드시 입력해야 합니다.");
			obj.val("");
			obj.focus();
			return false;
		}
	}
</script>
<style type="text/css">
	table { width: 800px; margin: auto; padding: 5px;}
	th {padding: 5px; border: 1px solid gray; background-color: silver;text-align: center;}
	td {padding: 5px; border: 1px solid gray; }
	.title {border: none; font-size: 20pt; text-align: center;}
	.item { width: 100px; background-color: silver; text-align: right;}
</style>
</head>
<body>
	<form action="updateOk.jsp" enctype="multipart/form-data"  method="post" onsubmit="return formCheck();">
	<%-- 여기에서 몇개를 숨겨서 가지고 가자 --%>
	<input type="hidden" name="p" value="${p }" />
	<input type="hidden" name="s" value="${s }" />
	<input type="hidden" name="b" value="${b }" />
	<input type="hidden" name="idx" value="${idx }" />
	<input type="hidden" name="m" value="3" />
	<table>
		<tr>
			<td colspan="4" class="title">자료실 삭제하기</td>
		</tr>
		<tr>
			<td class="item">이름</td>
			<td>
				<c:out value="${vo.name }"></c:out>
			</td>
			<td class="item">비밀번호</td>
			<td>
				<input type="password" name="password" id="password" required="required" maxlength="30"/>
			</td>
		</tr>
		<tr>
			<td class="item">제목</td>
			<td colspan="3">
				<c:out value="${vo.subject }"></c:out>
			</td>
		</tr>
		<tr>
			<td class="item" valign="top">내용</td>
			<td colspan="3">
				<c:set var="content" value="${vo.content }"/>
				<%-- 태그 무시 --%>
				<c:set var="content" value="${fn:replace(content,'<','&lt;') }"/>
				<%-- \n을 <br>로 변경 --%>
				<c:set var="content" value="${fn:replace(content, newLine, br ) }"/>
				${content }	
			</td>
		</tr>
		<tr>
			<td class="item" valign="top">파일첨부</td>
			<td colspan="3">
				<%-- 첨부 파일 개수를 출력해보자 --%>
				<c:if test="${not empty vo.fileList }">
					 <c:forEach var="f" items="${vo.fileList }">
					 	<i class="axi axi-file"  style="cursor: pointer;"></i>
					 	${f.ofile }
					 	<br />
					 </c:forEach>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" style="border: none;text-align: right;">
				<input type="submit" value="삭제하기" class="btn btn-outline-success btn-sm" />
				<input type="button" class="btn btn-outline-success btn-sm" 
				onclick='sendPost("view.jsp",{"p":${p},"s":${s },"b":${b },"idx":${vo.idx }})' value="내용보기">
				<input type="button" class="btn btn-outline-success btn-sm" 
				onclick='sendPost("index.jsp",{"p":${p},"s":${s },"b":${b }})' value="목록으로">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>