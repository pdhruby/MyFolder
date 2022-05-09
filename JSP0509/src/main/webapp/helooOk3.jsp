<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- POST전송의 경우 tomcat 9는 한글이 깨진다. 받을때 인코딩을 지정해주어야 한다. --%>
	<%
	request.setCharacterEncoding("UTF-8");
	//POST전송이 아니면 다른곳으로 보내버린다.
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("hello3.jsp");
		return;
	}
	// Map으로 모두 얻기
	Map<String, String[]> map = request.getParameterMap(); // (키값,넘어온값들의배열)

	if (map != null) {
		for (String name : map.keySet()) { // 키를 Set으로 얻기
			out.println(name + " : ");
			String[] values = map.get(name); // 값얻기
			//값 출력
			if (values != null && values.length > 0) {
		for (String value : values) {
			out.println(value + "  ");
		}
		out.println("<br>");
			}
		}
	}
	%>
</body>
</html>