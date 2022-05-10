<%@page import="java.io.PrintWriter"%>
<%@page import="kr.human.lunar.LunarUtil"%>
<%@page import="kr.human.lunar.LunarVO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//서버의 경로 얻기
		String path = application.getRealPath("./data/");
		out.println(path);
		
		// 3년 분량의 음력데이터를 JSON으로 저장해보자
		
		Gson gson = new Gson();
		
		for(int i=2021; i<=2023;i++){
			for(int j = 1; j<=12;j++){
				// 파일이름 만들기 : 202101.json
				String fileNmae = path + String.format("%04d%02d.json", i, j);		
				// 1개월 분량의 음력데이터 읽기
				List<LunarVO> list = LunarUtil.getLunarDate(i, j);
				// 저장 객체 만들기
				PrintWriter pw = new PrintWriter(fileNmae);
				// json형식으로 저장하기
				gson.toJson(list, pw);
				//닫기를 안하면 저장 실패!!!
				pw.close();
			}
		}
	
	%>
</body>
</html>