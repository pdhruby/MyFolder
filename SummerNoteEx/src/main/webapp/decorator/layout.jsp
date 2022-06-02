<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상단</h1>
<hr />

<%-- 이자리에 내가쓴 본문의 내용이 나타나라 --%>
<sitemesh:write property='body'/>

<hr />
<h1>하단</h1>
</body>
</html>