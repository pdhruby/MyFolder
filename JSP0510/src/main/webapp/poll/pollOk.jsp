<%@page import="kr.human.lunar.pollUtil"%>
<%@page import="kr.human.lunar.pollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%

	
	// POST전송일떄만 처리하자!!!
	if (request.getMethod().equals("GET")) {
		//투표하기 폼으로 보내버리자!!
		response.sendRedirect("poll.jsp");
		return;
	}

	// 값 받고 
	int poll = Integer.parseInt(request.getParameter("poll"));
	out.println(poll + "<br>");
	
	//읽어서 숫자를 변경하고 다시 저장하고
	String filename = application.getRealPath("/data/poll.json");
	pollVO pollVO = pollUtil.readPoll(filename);
	out.println(pollVO + "<br>");
	
	//투표한 항목만 증가
	pollVO.getItemCount()[poll]++;
	
	//다시저장
	pollUtil.savePoll(filename, pollVO);
	out.println(pollVO + "<br>");
	
	// 결과보기로 가자
	response.sendRedirect("pollResult.jsp");
	
	// 만약에 넘어온 이름의 파일이 없다면 에러이다~~~

	%>


</body>
</html>