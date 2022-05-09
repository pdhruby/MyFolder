<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- POST전송의 경우 tomcat 9는 한글이 깨진다. 받을때 인코딩을 지정해주어야 한다. --%>
	<%
	
		//POST전송이 아니면 다른곳으로 보내버린다.
		if(!request.getMethod().equals("POST")){
			response.sendRedirect("hello.jsp");
			return;
		}
	
	
		request.setCharacterEncoding("UTF-8");
	
	
	%>

	전송 방식 :
	<%=request.getMethod() %><br />
	<br />

	<%
	
		String name = request.getParameter("name"); //요청 정보를 받는다.(Stirng으로 받음)
		if(name!=null && name.trim().length()>0){
			out.println(name+"님 환영합니다.");
		}else{
			out.println("손님 환영합니다.");
		}
		String hobby = request.getParameter("hobby");
		out.println("<br>취미 : " + hobby + "<br>");
	
		//name속성의 값이 같은것이 여러개 존재하면 배열로 받아야 한다.
		
		String hobbys[] = request.getParameterValues("hobby");
		
		// 꼭넘어온 값이 있는지 확인해서 처리해야 한다.
		if(hobbys!=null && hobbys.length>0){ // 이줄을 생략하면 취미가 없을 경우 예외 발생!!!
			for(String h : hobbys){
				out.print(h + " " );
			}
		}
		
		
	%>
	성별 : <%=request.getParameter("gender") %>
</body>
</html>