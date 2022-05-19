package kr.human.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.human.board.vo.BoardVO;
import kr.human.jdbc.JDBCUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardDAOImpl implements BoardDAO{
	// 싱글톤으로 작성
	private static BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	@Override
	public int selectCount(Connection conn) throws SQLException {
		log.info("BoardDAO selectCount 호출");
		int count =0;
		String sql = "select count(*) as cnt from board";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		rs.next();
		count = rs.getInt(1);
		//또는 count = rs.getInt("cnt");
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		log.info("BoardDAO selectCount 리턴 : " + count);
		return count;
	}

	@Override
	public BoardVO selectByIdx(Connection conn, int idx) throws SQLException {
		log.info("BoardDAO selectByIdx 호출 :  " + idx);
		BoardVO vo = null;
		String sql = "Select * from board where idx = " + idx;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
				
		if(rs.next()) {
			vo = new BoardVO();
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));
			vo.setSubject(rs.getString("subject"));
			vo.setContent(rs.getString("content"));
			vo.setClickCount(rs.getInt("clickCount"));
			vo.setRegDate(rs.getTimestamp("regDate"));
			vo.setIp(rs.getString("ip"));
			
		}
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		log.info("BoardDAO selectByIdx 리턴 :  " + vo);
				
		return vo;
	}

	@Override
	public List<BoardVO> selectList(Connection conn, int startNo, int pageSize) throws SQLException {
		log.info("BoardDAO selectList 호출 :  " + startNo + " , " + pageSize);
		List<BoardVO> list = null;
		String sql = "select *from board order by idx desc limit ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			list = new ArrayList<>();
			do {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setClickCount(rs.getInt("clickCount"));
				vo.setRegDate(rs.getTimestamp("regDate"));
				vo.setIp(rs.getString("ip"));
				
				list.add(vo);
				
			}while(rs.next());
		}
		JDBCUtil.close(rs);
		JDBCUtil.close(pstmt);
		log.info("BoardDAO selectList 리턴 :  " + list);
		return list;
	}

	@Override
	public void insert(Connection conn, BoardVO vo) throws SQLException {
		log.info("BoardDAO insert 호출 :  " + vo);
		String sql = "insert into board (name,password,subject,content,ip) values (?,password(?),?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getSubject());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getIp());
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);
	}

	@Override
	public void updatge(Connection conn, BoardVO vo) throws SQLException {
		log.info("BoardDAO update 호출 :  " + vo);
		String sql = "update board set subject=?, content=?,regdate=now(), ip=?, where idx =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getSubject());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getIp());
		pstmt.setInt(1, vo.getIdx());
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);		
	}

	@Override
	public void delete(Connection conn, int idx) throws SQLException {
		log.info("BoardDAO delete 호출 :  " + idx);
		String sql = "delete from board where idx =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);				
	}

	@Override
	public void increment(Connection conn, int idx) throws SQLException {
		log.info("BoardDAO increment 호출 :  " + idx);
		String sql = "update board set clickCount = clickCount+1 where idx =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);				
	}
	@Override
	public int pwdCheck(Connection conn, int idx, String password) throws SQLException {
		log.info("BoardDAO pwdCheck 호출 :  " + idx + " , " + password);
		int count = 0;
		String sql ="select count(*) from board where idx=? and password=PASSWORD(?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		count = rs.getInt(1);
		JDBCUtil.close(rs);	
		JDBCUtil.close(pstmt);	
		log.info("BoardDAO pwdCheck 리턴 : " + count);;
		return count;
	}

}
