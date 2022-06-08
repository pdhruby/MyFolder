<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> 
<%
	// 아이디를 중복체크하는 방법 
	// 나중에 DB에서 같은 아이디의 갯수를 세어서 리턴하도록 변환하면 된다.
	String[] userid = "admin,root,administrator,human,master,webmaster".split(",");
	String id = request.getParameter("userid");
	if(id==null || id.trim().length()==0){
		return;
	}
	int count = 0;
	for(String t : userid){
		if(t.equals(id)) {
			count++;
			break;
		}
	}
	out.println(count);
%>