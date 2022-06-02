<%@page import="java.util.UUID"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
request.setCharacterEncoding("UTF-8");
// 이미지를 업로드하여 서버에 저장하고 서버에 저장된 이미지 경로를 출력해주면 된다.
String saveName="";
// 이미지 업로드
// 1) 서버에 저장할 경로가 없으면 경로를 만들어 준다.
File file = new File(application.getRealPath("/summernote/"));
if(!file.exists()){
	file.mkdirs();
}
String realPath = application.getRealPath("/summernote/"); // 서버 절대 경로
// 2) 이미지를 업로드 한다.
boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if(isMultipart){
	DiskFileItemFactory factory = new DiskFileItemFactory(); // DiskFileItemFactory 객체 생성
	ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload 객체 생성
	upload.setSizeMax(1024*1024*10); // 최대 10MB지정
	List<FileItem> items = upload.parseRequest(request); // 파싱
	if(items!=null && items.size()>0){ // 파일이 있다면
		for(FileItem item : items){ // 반복
			if(item!=null && item.getSize()>0){ // 파일의 크기가 0보다 크다면
				String originalFileName = item.getName(); // 원본이름
			
				// IE의 경우 원본파일 이름에 경로가 들어간다. 경로가 있으면 경로를 지워줘야 한다.
				if(originalFileName.contains(File.separator)){ // 경로 구분자가 있다면
					int index = originalFileName.lastIndexOf(File.separator); // 뒤에서부터 경로구분자의 위치를 찾는다.
					// 뒷부분만 가지면 된다.
					originalFileName = originalFileName.substring(index+1);
				}
			
				// 겹치지않는 ID를 만들어준다. -- 저장파일명으로 쓰자!!
				String saveFilleName = UUID.randomUUID().toString() + "_" + originalFileName; 
		        item.write(new File(realPath + File.separator + saveFilleName)); // 파일 저장
		        
		        // 리턴할 파일이름을 만들어 주어야 한다
		        saveName = request.getContextPath() + "/summernote/" + saveFilleName;
			}
		}
	}
}
// 서버에 저장된 이미지 경로를 리턴해준다.
out.print(saveName);
%>