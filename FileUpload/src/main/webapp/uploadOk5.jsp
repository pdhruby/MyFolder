<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.UUID"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 업로드된 파일을 처리하자 --%>
	<%
	
	request.setCharacterEncoding("UTF-8"); // 이것으로 한글을 받을 수 없다.
	
	//파일전송인지 일반메세지 전송인지를 판단해 준다.
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (!isMultipart) { // 파일전송이 아니면 폼으로 이동
		response.sendRedirect("uploadForm1.jsp");
		return;
	}

	// 여기까지 왔다는것은 파일 내용이 넘어 왔다는 것이다.
	//  1. 파일을 받기 위하여 DiskFileItemFactory 객체를 생성한다.
	DiskFileItemFactory factory = new DiskFileItemFactory();

	// 밑3줄은 생략가능하다
	// 시스템의 임시 폴더를 임시폴더로 지정한다.
	ServletContext servletContext = this.getServletConfig().getServletContext(); // 서버 application객체 얻기
	File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir"); // 임시 폴더 얻기
	factory.setRepository(repository); // 임시폴더 지정

	// 2.실제 업로드를 처리하기 위한 ServletFileUpload를 생성한다.
	ServletFileUpload upload = new ServletFileUpload(factory);

	// 3.업로드된 모든 내용을 리스트로 받는다.
	List<FileItem> items = upload.parseRequest(request);
	
	
	// 4.모든내용을 리스트로 받은후 1개씩 처리한다.
	if(items != null && items.size() >0){ // 주의!! 데이터가 있다면======================================
		for(FileItem item : items){ // 반복한다.
			if (item.isFormField()) { // 일반 폼필드라면 ===================================== 폼/파일인지 구분
			    String name = item.getFieldName(); // 필드네임(name속성값)
			    String value = item.getString("UTF-8"); // 입력값 : 인코딩을 지정해야 한글을 정확하게 받을 수 있다!!
				out.println(name+ " :  " + value + " <br>");
			}else{ // 파일이라면
				if(item.getSize() >0 ){ // 파일이 넘어 왔을때만!!! =========================== 파일이 비었는지 판단해줘야 에러가 안난다
			    String fieldName = item.getFieldName();// 필드네임(name속성값)
			    String fileName = item.getName();// 파일이름
			    // 인터넷익스플로러로 실행할경우에는 D:\1차프로젝트_3조\오후\mainbanner (4).jpg 알려준다.
			    // 나는 mainbanner (4).jpg만 필요하다.
			    if(fileName.lastIndexOf(File.separator) != 1){ // 폴더를 구분하는 문자가 있을경우
			    	// 폴더를 구분하는 문자 다음부터 끝까지만 가져온다.
			    	fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
			    	
			    }
			    
			    
			    
			    String contentType = item.getContentType(); //파일종류
			    boolean isInMemory = item.isInMemory(); // 메모리 저장여부
			    long sizeInBytes = item.getSize(); // 파일 크기
				out.println("fieldName : "+ fieldName + " <br>");
				out.println("filName : "+ fileName + " <br>");
				out.println("contentType : "+ contentType + " <br>");
				out.println("isInMemory : "+ isInMemory + " <br>");
				out.println("sizeInBytes : "+ sizeInBytes + " <br>");
			
				String savePath = application.getRealPath("/upload/");
				
				// 두가지 방법으로 쓴다. 파일의 중복을 막아줌.
				//String saveFile = System.nanoTime()+"";
				String saveFile = UUID.randomUUID().toString();
				
				//실제 자신의 폴더로 파일을 옮겨줘야 한다.
				
			    File uploadedFile = new File(savePath + saveFile); // 파일객체 만들기
			    item.write(uploadedFile); // 저장
			    
			    //파일 자체를 링크로 걸면 브라우저가 해석 가능하면 해석해서 보여주고
			    //해석이 불가능하면 저장할것인지 연결프로그램을 선택할것인지를 물어보게된다.
			    out.println("저장 : "+ savePath + saveFile+ " <br><hr>");
			    out.println("<a href='" + savePath + saveFile+ "'>"+saveFile+"다운로드</a><hr>");
			 // 모든 파일을 다운로드 가능하게 하려면 다음과 같이 해야 한다.
			    String of = URLEncoder.encode(fileName,"UTF-8");
			    String sf = URLEncoder.encode(saveFile,"UTF-8");
			    out.println("<a href='download.jsp?of="+of+"&sf="+sf+"'>" +fileName + "</a><br><hr>");	
				}
			}
		}
		
	}
	
	
	%>


</body>
</html>