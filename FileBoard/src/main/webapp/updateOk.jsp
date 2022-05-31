<%@page import="kr.human.fileboard.service.FileBoardServiceImpl"%>
<%@page import="kr.human.fileboard.vo.FileBoardVO"%>
<%@page import="kr.human.fileboard.vo.UpFileVO"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 공통코드 삽입 --%>
<%-- 파일 첨부가 되므로 request.getParameter를 사용할 수 없다. 그래서 하나 하나 받아줘야 한다.
<%@ include file="include.jsp" %>
--%>
<%-- POST 전송이 아니면 목록으로 보낸다. --%>
<c:if test='${pageContext.request.method!="POST" }'>
	<c:redirect url="index.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- 사용자 정의 자바스크립트 함수를 추가한다. --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/commons.js"></script>
</head>
<body>
	<%-- 넘어온 데이터 받기 --%>
	<%
	// 파일이 넘어오는지 파일 내용이 넘어오는지를 판단해준다. 
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	// 받을 변수를 모두 선언한다.
	int p = 1, s = 10, b = 10, idx = 0, m = 0;
	String name="", password="", subject="", content="";
	List<UpFileVO> fileList = new ArrayList<>();
	FileBoardVO fileBoardVO = null;
	// 수정시 삭제할 파일의 번호를 저장할 배열
	String[] delfile = null;
	
	// 받은 내용 처리
	if(isMultipart){
		// 파일 전송 폼이라면 : enctype="multipart/form-data"이 있느냐?
		// DiskFileItemFactory 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ServletFileUpload 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 업로드 파일 최대 크기 지정 -------- 생략가능
		upload.setSizeMax(1024*1024*10); // 최대 10MB지정
		// 넘어온 모든 정보를 파싱해서 리스트에 넣는다.
		List<FileItem> items = upload.parseRequest(request);	
		
		// 이제 리스트를 반복하며 원하는 처리를 해주면 된다.
		if(items!=null){ // 비어 있지 않다면
			for(FileItem item : items){ // 반복
				if(item.isFormField()){ // 일반폼태그냐?
					String fieldName = item.getFieldName();
					switch(fieldName){
					case "p":
						try{
							p = Integer.parseInt(item.getString("UTF-8"));
						}catch(Exception e){;}
						break;
					case "s":
						try{
							s = Integer.parseInt(item.getString("UTF-8"));
						}catch(Exception e){;}
						break;
					case "b":
						try{
							b = Integer.parseInt(item.getString("UTF-8"));
						}catch(Exception e){;}
						break;
					case "idx":
						try{
							idx = Integer.parseInt(item.getString("UTF-8"));
						}catch(Exception e){;}
						break;
					case "m":
						try{
							m = Integer.parseInt(item.getString("UTF-8"));
						}catch(Exception e){;}
						break;
					case "name":
						name = item.getString("UTF-8");
						break;
					case "password":
						password = item.getString("UTF-8");
						break;
					case "subject":
						subject = item.getString("UTF-8");
						break;
					case "content":
						content = item.getString("UTF-8");
						break;
					case "delfile":
						if(item.getString("UTF-8")!=null && item.getString("UTF-8").trim().length()>0){
							delfile = item.getString("UTF-8").trim().split(" ");
						}
						break;
					}
				}else{ // 파일이냐
					long sizeInBytes = item.getSize();			// 파일 크기 얻기
					if(sizeInBytes>0){ // 파일크기가 있을때만
						String oriName = item.getName();		// 원본 파일 이름
						// IE의 경우 원본파일 이름에 경로가 들어간다. 경로가 있으면 경로를 지워줘야 한다.
						if(oriName.contains(File.separator)){ // 경로 구분자가 있다면
							int index = oriName.lastIndexOf(File.separator); // 뒤에서부터 경로구분자의 위치를 찾는다.
							// 뒷부분만 가지면 된다.
							oriName = oriName.substring(index+1);
						}
						
				        // 경로가 없다면 폴더를 만들어 준다.
						File path = new File(application.getRealPath("/upload/")); 
				        if(!path.exists()){
				        	path.mkdirs();
				        }
						// 파일 저장
				        String saveName = UUID.randomUUID().toString(); // 겹치지않는 ID를 만들어준다. -- 저장파일명으로 쓰자!!
				        item.write(new File(path + File.separator + saveName));
				        
				        // 리스트에 추가
				        UpFileVO boardFileVO = new UpFileVO();
				        boardFileVO.setOfile(oriName);
				        boardFileVO.setSfile(saveName);
				        fileList.add(boardFileVO);
					} // endif
				}// end if
			} // end for
			// 모든것을 다 받았다면 VO에 넣어주자
			fileBoardVO = new FileBoardVO();
			fileBoardVO.setIdx(idx);
			fileBoardVO.setName(name);
			fileBoardVO.setPassword(password);
			fileBoardVO.setSubject(subject);
			fileBoardVO.setContent(content);
			fileBoardVO.setFileList(fileList);
		}// end if
	}else{
		// 일반폼이라면 : enctype="multipart/form-data" 없느냐?
		out.println("<script>alert('파일 전송이 아닙니다. 폼에 enctype속성이 있는지 확인해 주세요!!');</script>");
		out.println("<script>location.href='index.jsp'</script>");
	}
	%>
	<%-- 모드 값에따라 저장/수정/삭제를 서비스 클래스를 불러서 처리하면 된다.  --%>
	<%
		String query = "";
		switch(m){
		case 1: // 저장
			FileBoardServiceImpl.getInstance().insert(fileBoardVO);
			query = "<script>sendPost(\"index.jsp\",{\"p\":1,\"b\":"+b+",\"s\":"+s+"});</script>";
			break;
		case 2: // 수정
			FileBoardServiceImpl.getInstance().update(fileBoardVO, application.getRealPath("/upload/"), delfile);
			query = "<script>sendPost(\"view.jsp\",{\"p\":1,\"b\":"+b+",\"s\":"+s+",\"idx\":"+idx+"});</script>";
			break;
		case 3: // 삭제
			FileBoardServiceImpl.getInstance().delete(fileBoardVO, application.getRealPath("/upload/"));
			query = "<script>sendPost(\"index.jsp\",{\"p\":"+p+",\"b\":"+b+",\"s\":"+s+"});</script>";
			break;
		}
		
		// 위에서 자바스크립트를 사용했기때문에 response.sendRedirect사용 못함
		// 페이지 이동을 자바스크립트로 처리해야 한다.
		out.println(query); // 페이지 이동
	%>
</body>
</html>