<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체 연습</title>
</head>
<body>
	클라이언트 주소 : <%=request.getRemoteAddr() %> <br />
	
	서버의 절대주소 : <%=request.getRealPath(".") %><br />
	<!--경고 메시지 뜨기떄문에 어플리케이션으로 쓰는게 좋다.  -->
	서버의 절대주소 : <%=application.getRealPath(".") %>
	
	<%=request.getContextPath() %> <br />
	<%=request.getRequestURI() %> <br />
	<%=request.getRequestURL() %> <br />
	<hr />
	서버 정보 <br />
	<%=request.getServerName()%> <br />
	<%=request.getServerPort()%> <br />
	<%=request.getServletPath()%> <br />
	<%=request.getServletContext().getRealPath(".")%> <br /> <%-- application과 같다 --%>
	<hr />
	클라이언트 정보 <br />
	<%=request.getLocalAddr() %> <br />
	<%=request.getLocalName() %> <br />
	<%=request.getLocalPort() %> <br />
	<%=request.getLocale() %> <br />

	
</body>
</html>