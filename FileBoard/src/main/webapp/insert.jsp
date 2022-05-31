<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 공통코드 삽입 --%>
<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 새글쓰기</title>
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
		var obj = $("#name");
		if(obj.val()==null || obj.val().trim().length==0){
			alert("이름은 반드시 입력해야 합니다.");
			obj.val("");
			obj.focus();
			return false;
		}
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
	<input type="hidden" name="m" value="1" />
	<table>
		<tr>
			<td colspan="4" class="title">자료실 새글쓰기</td>
		</tr>
		<tr>
			<td class="item">이름</td>
			<td>
				<input type="text" name="name" id="name" required="required" maxlength="30"/>
			</td>
			<td class="item">비밀번호</td>
			<td>
				<input type="password" name="password" id="password" required="required" maxlength="30"/>
			</td>
		</tr>
		<tr>
			<td class="item">제목</td>
			<td colspan="3">
				<input type="text" name="subject" id="subject" required="required" size="90" maxlength="100"/>
			</td>
		</tr>
		<tr>
			<td class="item" valign="top">내용</td>
			<td colspan="3">
				<textarea name="content" id="content" cols="93" rows="10"></textarea>
			</td>
		</tr>
		<tr>
			<td class="item" valign="top">파일첨부</td>
			<td colspan="3">
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
				<input type="submit" value="저장" class="btn btn-outline-success btn-sm" />
				<input type="button" class="btn btn-outline-success btn-sm" 
				onclick='sendPost("index.jsp",{"p":${p},"s":${s },"b":${b }})' value="목록">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>