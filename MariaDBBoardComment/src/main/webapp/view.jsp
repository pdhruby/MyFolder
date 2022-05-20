<%@page import="kr.human.board.service.BoardServiceImpl"%>
<%@page import="kr.human.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
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
		<%-- 댓글 폼을 달자 --%>
		<tr>
			<td colspan="4" style="border: none;text-align:left;">
				<form action="commentUpdate.jsp" method="post" onsubmit="return formCheck();">
					<input type="hidden" name="idx" value="0" id="idx">
					<input type="hidden" name="ref" value="${vo.idx }" id="ref">
					<input type="hidden" name="p" value="${currentPage }" id="p">
					<input type="hidden" name="s" value="${pageSize }" id="s">
					<input type="hidden" name="b" value="${blockSize }" id="b">
					<input type="hidden" name="mode" value="insert" id="mode">
					<input type="hidden" name="click" value="false" id="click">
					<input type="hidden" name="ip" value="${pageContext.request.remoteAddr }">
					<input type="text" name="name" id="name" required="required" placeholder="이름입력"/>
					<input type="password" name="password" id="password" required="required" placeholder="비번입력"/>
					<br />
					<textarea rows="5" cols="120" name="content" id="content" placeholder="내용입력" required="required"></textarea>
					<div style="text-align: right">
					<input type="submit" value="저장" id="submitBtn"/>
					<input type="button" value="취소" id="resetBtn" style="display: none;" onclick="resetForm()"/>
					</div>					
				</form>
			</td>
		</tr>
		<%-- 댓글 목록을 출력하자--%>
		<tr>
			<td colspan="4" style="border: none;">
				<c:if test="${vo.commentCount==0 }">
					<div style="padding:5px; border: 1px solid gray;text-align:center;margin-bottom: 5px;">등록된 댓글이 없습니다.</div>
				</c:if>
				<c:if test="${vo.commentCount>0 }">
					<c:forEach var="cvo" items="${vo.commentList }">
						<div style="padding:5px; border: 1px solid gray;margin-bottom: 5px;">
							<div style="padding:5px; border: 1px solid gray;background-color: silver;text-align:left;">
								<span id="name${cvo.idx }">${cvo.name }</span> 님이 ${cvo.ip }에서
								<fmt:formatDate value="${cvo.regDate }" pattern="yy-MM-dd hh:mm:ss"/>에 남긴글
								<%-- 수정/삭제 버튼 달기 --%>
								<button onclick="updateForm(${cvo.idx})"> 수정 </button>
								<button onclick="deleteForm(${cvo.idx})"> 삭제 </button>
							</div>
							<div style="display: none;" id="content${cvo.idx }">${cvo.content }</div>
							<div style="padding:5px; border: none;text-align:left;">
								<c:set var="c" value="${cvo.content }"/>
								<c:set var="c" value="${fn:replace(c,'<','&lt;') }"/>
								<c:set var="c" value="${fn:replace(c,newLine,br) }"/>
								${c }
							</div>
						</div>
					</c:forEach>
				</c:if>
			</td>		
		</tr>
	</table>
	<script type="text/javascript">
		function updateForm(idx){
			var name = $("#name" + idx).html();
			var content = $("#content" + idx).html();
			// alert(name + "\n" + content);
			$("#resetBtn").css('display','inline'); // 취소버튼 보이고
			$("#submitBtn").val('수정'); // 버튼의 내용을 변경하고
			$("#idx").val(idx)
			$("#mode").val("update");
			$("#name").val(name);
			$("#content").val(content);
			$("#password").focus();
		}
		function deleteForm(idx){
			var name = $("#name" + idx).html();
			var content = $("#content" + idx).html();
			// alert(name + "\n" + content);
			$("#resetBtn").css('display','inline'); // 취소버튼 보이고
			$("#submitBtn").val('삭제'); // 버튼의 내용을 변경하고
			$("#idx").val(idx)
			$("#mode").val("delete");
			$("#name").val(name);
			$("#content").val(content);
			$("#password").focus();
		}
		function resetForm(){
			$("#resetBtn").css('display','none'); // 취소버튼 숨기고
			$("#submitBtn").val('저장'); // 버튼의 내용을 변경하고
			$("#idx").val('0')
			$("#mode").val("insert");
			$("#name").val("");
			$("#content").val("");
			$("#name").focus();
		}
	</script>
</body>
</html>