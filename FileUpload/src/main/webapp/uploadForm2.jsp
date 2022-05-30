<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 하기</title>
</head>
<body>
	<%-- 파일을 전송하려면 반드시 form태그의 속성에 enctype="multipart/form-data"를 넣어야 한다. --%>
	<form method="POST" enctype="multipart/form-data" action="uploadOk2.jsp">
		파일: <input type="file" name="upfile"><br /> 
		파일2: <input type="file" name="upfile"><br /> 
		파일3: <input type="file" name="upfile"><br /> 
		설명: <input type="text" name="note"><br /> <br />
		<input type="submit" value="파일업로드"> 
	</form>
</body>
</html>