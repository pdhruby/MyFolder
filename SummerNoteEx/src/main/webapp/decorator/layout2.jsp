<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-=[{ <sitemesh:write property='title'/> }]=-</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<!-- 언어 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>

<sitemesh:write property='head'/>
<style type="text/css">
	#footer {
		padding: 10px; font-size: 13pt; text-align: center;
		border: 1px solid gray; margin-top: 20px;
	}
</style>
</head>
<body>
	<h1>상단에 메뉴......</h1>
	<hr />
	<sitemesh:write property='body'/>
	
	<div id="footer">저작권이 어쩌구저쩌구....</div>
</body>
</html>