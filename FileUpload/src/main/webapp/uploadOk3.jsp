<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COS라이브러리를 이용한 업로드</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	if (!request.getMethod().equals("POST")) {
		out.println("<script>");
		out.println("alert('파일 전송폼을 이용하여 오세요!!!');");
		out.println("location.href='uploadForm3.jsp';");
		out.println("</script>");
		return;
	}
		// cos-fileupload 라이브러리를 사용하여 파일을 업로드 한다.
		String upload_path = application.getRealPath("upload"); // 업로드할 경로
		int size = 10 * 1024 * 1024; // 업로드 크기 제한
		String filename = "", name = "", note = "";
		int filesize = 0;
		try {
			// 이순간 모든 업로드가 이루어진다.
			MultipartRequest multi = new MultipartRequest(request, upload_path, size, "utf-8", new DefaultFileRenamePolicy());

			// 나머지 필드들과 원본이름/저장이름...을 얻어서 처리하면된다.
			note = multi.getParameter("note"); // 일반 폼 필드 처리
			out.println("설명 : " + note + "<br>");
		      // 파일 처리를 하자
		      Enumeration<String> files = multi.getFileNames(); // 필드명 리스트
		      while(files.hasMoreElements()){
		         String fieldName = files.nextElement();
		         String ofile = multi.getOriginalFileName(fieldName); // 원본 파일   이름
		         filename = multi.getFilesystemName(fieldName); // 저장 파일   이름
		         String contentType = multi.getContentType(fieldName); // 파일 타입
		         File f1 = multi.getFile(fieldName);
		         filesize = (int) f1.length(); // 파일 크기
		         out.println("필드명 : " + fieldName + "<br>");
		         out.println("원본 파일 이름 : " + ofile + "<br>");
		         out.println("저장 파일 이름 : " + filename + "<br>");
		         out.println("파일 크기 : " + filesize + "<br>");
		         out.println("파일 타입 : " + contentType + "<br><hr>");
		      }
		} catch (Exception e) {

		}

	
	%>

</body>
</html>