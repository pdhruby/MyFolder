<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.io.FileReader"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.human.lunar.LunarUtil"%>
<%@page import="kr.human.lunar.LunarVO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년달력 만들기 01</title>
<%
	// 년도와 월을 받는다.
	int year = LocalDate.now().getYear();
	int month = LocalDate.now().getMonthValue();
	try{
		year = Integer.parseInt(request.getParameter("yy"));
		month = Integer.parseInt(request.getParameter("mm"));
	}catch(Exception e){
		// 넘어온 값이 유효하지 않다면 현재의 년월을 가지자!!!
		year = LocalDate.now().getYear();
		month = LocalDate.now().getMonthValue();
	}
	// 월이 감소하다가 보면 0이하가 된다. 이때는 년도가 1감소하고 월을 12월로 만든다.
	if(month<=0){
		year--;
		month = 12;
	}
	// 월이 증가하다가 보면 13이상이 된다. 이때는 년도가 1증가하고 월을 1월로 만든다.
	if(month>=13){
		year++;
		month = 1;
	}
	
	if(year<=0){
		year = LocalDate.now().getYear();
	}
	
	System.out.println(year + "년 " + month + "월");

	//-----------------------------------------------------------------
	// 음력데이터를 읽어온다.
	//List<LunarVO> list = LunarUtil.getLunarDate(year, month);
	// 인터넷이 아니라 저장된 겨올에서 json파일을 읽어오자.
	String path = application.getRealPath("./data/");
	// 파일이름 만들기 : 202101.json
	String fileNmae = path + String.format("%04d%02d.json", year,month);
	
	//	Gson을 이용하여 읽어오자
	Gson gson = new Gson();
	FileReader fr = new FileReader(fileNmae);
	
	List<LunarVO> list = gson.fromJson(fr, new TypeToken<List<LunarVO>>(){}.getType());
	
	
	
	//-----------------------------------------------------------------------
	int lastDay = list.size(); // 마지막 날짜
	int week = list.get(0).getIntSolarWeek() ; // 1일의 요일 : 0(일요일)
%>
<style type="text/css">
	table {
		width: 700px; margin: auto; border: none;border-spacing: 3px;
	}
	.title {
		font-size: 18pt; text-align: center; border: none; padding: 5px; background-color: white;
	}
	th { background-color: silver; border: 1px solid gray; padding: 5px;}
	td { border: 1px solid gray; padding: 5px; border-radius: 15px; text-align: center; height: 40px;}
	.blank_date {background-color: silver;}
	.lunar { font-size: 8pt; font-weight: bold;}
</style>
</head>
<body>
	<table>
		<tr>
			<th colspan="2" class="title">
				<a href="?yy=<%=year-1 %>&mm=<%=month%>"><img src="./images/prevYear.png" alt="prevYear" /></a> 
				<a href="?yy=<%=year %>&mm=<%=month-1%>"><img src="./images/prevMonth.png" alt="prevMonth" /></a>
			</th>
			<th colspan="3" class="title"><%=year %>년 <%=month %>월</th>
			<th colspan="2" class="title">
				<a href="?yy=<%=year %>&mm=<%=month+1%>"><img src="./images/nextMonth.png" alt="nextMonth" /></a>
				<a href="?yy=<%=year+1 %>&mm=<%=month%>"><img src="./images/nextYear.png" alt="nextYear" /></a>
			</th>
		</tr>
		<tr>
			<th width="100px">일</th>
			<th width="100px">월</th>
			<th width="100px">화</th>
			<th width="100px">수</th>
			<th width="100px">목</th>
			<th width="100px">금</th>
			<th width="100px">토</th>
		</tr>
		<tr>
			<%
				// 1일의 요일을 맞추기 위해 빈칸을 출력한다.
				for(int i=0;i<week;i++){
					out.println("<td class='blank_date'>&nbsp;</td>");
				}
				// 1일부터 마지막 날짜까지 출력한다. 단, 토요일이면 줄바꾼다.
				for(LunarVO vo : list){
					week = vo.getIntSolarWeek() ; // 오늘의 요일 : 0(일요일)
					if(week==6)
						out.println("<td style='background-color:skyblue'>" 
										+ vo.getSolarDay() 
										+ "<div class='lunar'>" + vo.getLunarMonth() + "-" 
										+ vo.getLunarDay() + "("
										+ vo.getGanjiDayCn() + ")"
										+ "</div>"
										+ "</td>");
					else if(week==0){
						out.println("<td style='background-color:pink'>" + vo.getSolarDay() 
									+ "<div class='lunar'>" + vo.getLunarMonth() + "-" 
									+ vo.getLunarDay() + "("
									+ vo.getGanjiDayCn() + ")"
									+ "</div>"
									+ "</td>");
					}else{
						out.println("<td>"+ vo.getSolarDay() 
									+ "<div class='lunar'>" + vo.getLunarMonth() + "-" 
									+ vo.getLunarDay() + "("
									+ vo.getGanjiDayCn() + ")"
									+ "</div>"
									+ "</td>");
					}
					if(week==6){ // 토요일이면
						out.println("</tr>"); // 줄바꿈
						if(Integer.parseInt(vo.getSolarDay()) < lastDay){ // 출력한 날짜가 마지막 날짜가 아니라면 새로운줄 시작
							out.println("<tr>");
						}
					}
				}
				// 토요일로 끝나지 않으면 테이블의 마무리를 한다.
				if(week<6){
					for(int i=week;i<6;i++)out.println("<td class='blank_date'>&nbsp;</td>");
					out.println("</tr>");
				}
			%>
	</table>

</body>
</html>