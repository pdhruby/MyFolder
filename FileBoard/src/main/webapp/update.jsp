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
<title>자료실 수정하기</title>
<%-- axicon 사용하기 --%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/axicon/axicon.min.css" />
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
	// 최대개수 : 10개
	// 최소개수 :  1개
	var maxCount = 10;
	var minCount = 1;
	var count = 1;
	
	$(function(){
		$("#password").focus();	
	});
	// 첨부파일 개수 늘리기
	function appendFile(){
		if(count==maxCount){
			alert("첨부 파일은 최대 " + maxCount + "개까지만 가능합니다.");
			return;
		}
		count++;
		$("#fileBox").append($('<div id="file'+count+'"> <input type="file" name="file" id="file'+count+'" /> </div>'));
	}
	// 첨부파일 개수 줄이기
	function removeFile(){
		if(count==minCount){
			alert("첨부 파일은 최소 " + minCount + "개는 있어야 합니다.");
			return;
		}
		$("#file"+count).remove();
		count--;
	}
	

	function formCheck(){
		var obj = $("#password");
		if(obj.val()==null || obj.val().trim().length==0){
			alert("비밀번호는 반드시 입력해야 합니다.");
			obj.val("");
			obj.focus();
			return false;
		}
		var obj = $("#subject");
		if(obj.val()==null || obj.val().trim().length==0){
			alert("제목은 반드시 입력해야 합니다.");
			obj.val("");
			obj.focus();
			return false;
		}
		var obj = $("#content");
		if(obj.val()==null || obj.val().trim().length==0){
			alert("내용은 반드시 입력해야 합니다.");
			obj.val("");
			obj.focus();
			return false;
		}
	}
	// 기존의 첨부파일 삭제 여부 지정하기
	function deleteFile(obj, idx){
		// alert(typeof $(obj).css('color'));
		if($(obj).css('color')=='rgb(0, 0, 0)'){
			$(obj).css('color','red');
			$("#delfile").val($("#delfile").val() + " " + idx);
		}else{
			$(obj).css('color','black');
			$("#delfile").val($("#delfile").val().replace(" " + idx, ""));
		}
	}
</script>
<style type="text/css">
	table { width: 800px; margin: auto; padding: 5px;}
	th {padding: 5px; border: 1px solid gray; background-color: silver;text-align: center;}
	td {padding: 5px; border: 1px solid gray; }
	.title {border: none; font-size: 20pt; text-align: center;}
	.item { width: 100px; background-color: silver; text-align: right;}
	/* 링크의 모양을 변경한다. */
	a:link 		{ color: black; text-decoration: none;} /* 링크가 걸린모양 */
	a:visited 	{ color: black; text-decoration: none;} /* 방문했던 링크 */
	a:hover 	{ color: black; text-decoration: none; font-weight: bold;} /* 마우스오버시 모양 */
	a:active 	{ color: orange; text-decoration: none;} /* 마우스 클릭시 모양 */
	
</style>
</head>
<body>
	<form action="updateOk.jsp" enctype="multipart/form-data"  method="post" onsubmit="return formCheck();">
	<%-- 여기에서 몇개를 숨겨서 가지고 가자 --%>
	<input type="hidden" name="p" value="${p }" />
	<input type="hidden" name="s" value="${s }" />
	<input type="hidden" name="b" value="${b }" />
	<input type="hidden" name="idx" value="${idx }" />
	<input type="hidden" name="m" value="2" />
	<table>
		<tr>
			<td colspan="4" class="title">자료실 수정하기</td>
		</tr>
		<tr>
			<td class="item">이름</td>
			<td>
				<input type="text" name="name" id="name" readonly="readonly" maxlength="30" value="${vo.name }"/>
			</td>
			<td class="item">비밀번호</td>
			<td>
				<input type="password" name="password" id="password" required="required" maxlength="30"/>
			</td>
		</tr>
		<tr>
			<td class="item">제목</td>
			<td colspan="3">
				<input type="text" name="subject" id="subject" required="required" size="90" maxlength="100" value="${vo.subject }"/>
			</td>
		</tr>
		<tr>
			<td class="item" valign="top">내용</td>
			<td colspan="3">
				<textarea name="content" id="content" cols="93" rows="10">${vo.content }</textarea>
			</td>
		</tr>
		<tr>
			<td class="item" valign="top">파일첨부</td>
			<td colspan="3">
				<%-- 이미 첨부된 파일 목록을 보여주기 시작 --%>
				<%-- 첨부 파일 개수를 출력해보자 --%>
				<c:if test="${not empty vo.fileList }">
					<%-- 기존 첨부파일 삭제할 글번호들 --%>
					 <input type="hidden" name="delfile" id="delfile" />
					 <c:forEach var="f" items="${vo.fileList }">
					 	<i class="axi axi-file"  style="cursor: pointer;"></i>
					 	${f.ofile }
					 	<%-- 파일 삭제 --%>
					 	<a href="#" onclick="deleteFile(this,${f.idx})">
					 		<i class="axi axi-delete2" style="font-size: 20pt;"></i>
					 	</a>
					 	<br />
					 </c:forEach>
				</c:if>
				<br />
				<%-- 이미 첨부된 파일 목록을 보여주기 종료 --%>
				<div style="margin-bottom: 5px;">
					<input type="button" value="   +   " onclick="appendFile()"  class="btn btn-outline-danger btn-sm"/>
					<input type="button" value="   -   " onclick="removeFile()"  class="btn btn-outline-danger btn-sm"/>
				</div>
				<div id="fileBox">
					<div id="file1"> <input type="file" name="file" id="file1" /> </div>				
				</div>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" style="border: none;text-align: right;">
				<input type="submit" value="수정하기" class="btn btn-outline-success btn-sm" />
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