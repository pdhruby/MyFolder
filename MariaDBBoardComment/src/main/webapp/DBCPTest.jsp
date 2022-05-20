<%@page import="kr.human.jdbc.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		Connection conn = null;
		Statement  stmt = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		try{
			// 1. 연결 얻기
			conn = JDBCUtil.getConnection();
			// 트랜젝션 시작(자동커밋 취소)
			conn.setAutoCommit(false);
			// --------------------------------------------------------------------
			// 2. 사용 (이부분만 변경된다.)
			out.println("연결 성공 : " + conn + "<br>");
			
			
			// --------------------------------------------------------------------
			// 에러가 없으면  DB에 적용해라.
			conn.commit();
		}catch(Exception e){
			// 에러가 있으면 모든 명령을 취소한다.
			JDBCUtil.rollback(conn);
			e.printStackTrace();
		}finally{
			// 3. 닫기
			JDBCUtil.close(rs);
			JDBCUtil.close(stmt);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
	%>
</body>
</html>