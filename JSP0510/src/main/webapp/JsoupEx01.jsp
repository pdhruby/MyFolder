<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML 파싱하기</title>
</head>
<body>
	<%
		String urlAddress="https://astro.kasi.re.kr/life/pageView/5";
		// 문서 객체 얻기
		Document document = Jsoup.connect(urlAddress).get();
		// html의 title태그의 값을 가져온다.
		out.println(document.title() + "<br>");
		
		Elements elements = document.select("table");
		out.println("테이블 개수 : " + elements.size() + "개<br>");
		
		/*
		// 찾은 요소의 모든 내용 얻기
		out.println("<table border='1'>");
		out.println(elements.get(0).html());
		out.println("</table>");
		*/
		// 테이블 안에있는 tbody태그 밑에 tr들을 얻기
		Elements trs = elements.select("tbody tr");
		out.println("TR 개수(일수) : " + trs.size() + "개<br>");
		
		for(Element tr : trs){
			// out.println(tr.text() + "<br>");
			out.println(tr.select("td").get(0) + "<br>"); // 양력만
		}
	%>
</body>
</html>