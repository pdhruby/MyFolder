<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 파일 업로드된 경로
	String path = application.getRealPath("./upload/");
	// 서버에 실제 저장된 파일명
	String sf = request.getParameter("sf");
	// 실제 내보낼 파일명
	String of = request.getParameter("of");
	InputStream in = null;
	OutputStream os = null;
	File file = null;
	boolean skip = false; // 존재하지않는 파일일경우 패스
	String client = "";
	try {
		// 파일을 읽어 스트림에 담기
		try {
			file = new File(path, sf);
			in = new FileInputStream(file);
		} catch (FileNotFoundException fe) {
			skip = true;
		}
		// 파일 다운로드 헤더 지정
		response.reset();
		response.setContentType("application/octet-stream"); // 현재 데이터가 스트림이다라고 알려준다.
		// response.setHeader("Content-Description", "JSP Generated Data");
		if (!skip) { // 파일이 존재 한다면
			// 한글 파일명 처리
			// 브라우져 종류
			client = request.getHeader("User-Agent");
			if (client.indexOf("Trident") == -1) { // IE
					of = new String(of.getBytes("utf-8"), "iso-8859-1");
			} else { // IE ext
					of = URLEncoder.encode(of, "UTF-8").replaceAll("\\+", "%20");
			}
			
			response.setHeader("Content-Disposition", "attachment; filename=\"" + of + "\"");
			response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
			response.setHeader("Content-Length", "" + file.length());
			// 출력스트림 얻기
			// getOutputStream() has already been called for this response - error!!!
			// JSP에서는 SERVLET으로 변환될 때 내부적으로 out 객체가 자동으로 생성하기 때문에
			// out객체를 만들면 충돌이 일어나서 저런 메시지가 뜨는 것이다.
			// 그래서 먼저 out를 초기화하고 생성하면 된다.
			out.clear();
			out = pageContext.pushBody();
			os = response.getOutputStream();
			// 복사
			byte b[] = new byte[(int) file.length()]; // 파일 크기만큼 배열선언
			int leng = 0;
			while ((leng = in.read(b)) > 0) { // 읽기
				os.write(b, 0, leng); // 쓰기
				os.flush();
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>alert('파일을 찾을 수 없습니다');history.back();</script>");
		}
		in.close();
		os.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>