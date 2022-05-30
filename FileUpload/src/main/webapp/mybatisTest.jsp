<%@page import="kr.human.mybatis.MybatisApp"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
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
		//이모양이 서비스클래스의 메서드의 내용이다.
		SqlSession sqlSession = null;
		try{
				sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
				//==========================================
				// 이 부분만 변경된다.
				String today = sqlSession.selectOne("test.selectToday");
				out.println("DB 날짜 : " + today+"<br><hr>");
				//==========================================		
				sqlSession.commit();
		}catch(Exception e){
				sqlSession.rollback();
				e.printStackTrace();
		}finally{
				sqlSession.close();
		}
	
	%>
</body>
</html>