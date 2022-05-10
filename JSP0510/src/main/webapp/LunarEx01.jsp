<%@page import="kr.human.lunar.LunarUtil"%>
<%@page import="kr.human.lunar.LunarVO"%>
<%@page import="java.util.List"%>
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
		//List<LunarVO> list = LunarUtil.getLunarDate(2020, 6);
		List<LunarVO> list = LunarUtil.getLunarDate(2020, 9);
		for(LunarVO vo : list){
				out.println(vo.getSolarDay()+ " : ");
				out.println(vo.getLunarMonth()+ "-"+ vo.getLunarDay()+" : ");
				out.println(vo.getGanjiDayKo() + "("+vo.getGanjiDayCn()+")" + "<br>");
		}
	
	
	%>


</body>
</html>