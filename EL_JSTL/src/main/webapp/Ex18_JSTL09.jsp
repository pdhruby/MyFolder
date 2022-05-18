<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<jsp:useBean id="today" class="java.util.Date"/>
	${today} <br />
	<fmt:formatDate value="${today }"/> <br />
	<fmt:formatDate value="${today }"  type="date"/> <br />
	<fmt:formatDate value="${today }"  type="time"/> <br />
	<fmt:formatDate value="${today }"  type = "both"/> <br />
	<hr />
	<fmt:formatDate value="${today }"  type="date" dateStyle="full"/> <br />
	<fmt:formatDate value="${today }"  type="time" dateStyle="long"/> <br />
	<fmt:formatDate value="${today }"  type = "both" dateStyle="medium"/> <br />
	<fmt:formatDate value="${today }"  type = "both" dateStyle="short"/> <br />
	<hr />
	
	
	<fmt:formatDate value="${today }"  type="time" timeStyle="full"/> <br />
	<fmt:formatDate value="${today }"  type="time" timeStyle="long"/> <br />
	<fmt:formatDate value="${today }"  type = "time" timeStyle="medium"/> <br />
	<fmt:formatDate value="${today }"  type = "time" timeStyle="short"/> <br />
	<hr />
	<fmt:formatDate value="${today }"  type = "both" dateStyle="short" timeStyle="short"/> <br />
	<%-- 내가 모양 지정해서 출력 --%>
	<fmt:formatDate value="${today }"  pattern="MM-dd(E) hh:mm"/> <br />
	<fmt:formatDate value="${today }"  pattern="MM-dd(E) hh:mm" var = "date"/>
	${date}
	 <br />
	
</body>
</html>