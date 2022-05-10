<%@page import="java.io.File"%>
<%@page import="kr.human.lunar.pollUtil"%>
<%@page import="kr.human.lunar.pollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<% 
String file = request.getParameter("file");
if (file == null || file.trim().length() == 0) {
	file = "poll";
}
String filename = application.getRealPath("/data/" + file + ".json");
// 만약에 넘어온 이름의 파일이 없다면 에러이다~~~
File file2 = new File(filename);
if(!file2.exists()){ //exists() : 파일이 있으면 참! 없으면 거짓
	file = "poll";
	filename = application.getRealPath("/data/" + file + ".json");
}

pollVO pollVO = pollUtil.readPoll(filename);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 설문조사</title>
<!-- Bootstrap과 Jquery사용 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#resultBtn").click(function() {
			location.href = 'poll.jsp?file=<%=file%>'; // 자바스크립트로 페이지 이동하기
		});
	});
</script>

<style type="text/css">
table {
	margin: auto;
	width: 500px;
	border: 1px solid gray;
	padding: 5px;
}

.title {
	font-size: 13pt;
	text-align: center;
	background-color: silver;
	border: 1px solid gray;
}

td {
	padding: 3px;
}
</style>

</head>

<body>
	<form action="pollOk.jsp" method="POST">
		<table>
			<tr>
				<td class="title">온라인 설문조사 Ver 0.009</td>
			</tr>
			<tr>
				<td>제목 : <%=pollVO.getTitle()%></td>
			</tr>
			<%
			for (int i = 0; i < pollVO.getItem().length; i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println("<label>");
				out.println("<input type ='radio' name='poll' value='" + i + "'" + (i == 0 ? "checked='checked' " : "") + ">");
				out.println(pollVO.getItem()[i]);
				out.println("<label>");
				out.println("</td>");
				out.println("</tr>");

			}
			%>
			<tr>
				<td align="center"><input type="submit"
					class="btn btn-sm btn-outline-success" value="투표하기"> <input
					type="button" id="resultBtn" class="btn btn-sm btn-outline-success"
					value="결과보기"></td>
			<tr>
		</table>



	</form>
</body>
</html>