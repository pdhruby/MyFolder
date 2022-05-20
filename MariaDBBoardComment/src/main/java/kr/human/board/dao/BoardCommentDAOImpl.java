package kr.human.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.human.board.vo.BoardCommentVO;
import kr.human.jdbc.JDBCUtil;

public class BoardCommentDAOImpl implements BoardCommentDAO{
	//-----------------------------------------------------------------------
	// 싱글톤
	private static BoardCommentDAO instance = new BoardCommentDAOImpl();
	private BoardCommentDAOImpl() {}
	public static BoardCommentDAO getInstance() { return instance; }
	//-----------------------------------------------------------------------
	
	@Override
	public int selectCount(Connection conn, int ref) throws SQLException {
		int count = 0;
		String sql = "select count(*) from board_comment where ref=" + ref;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		return count;
	}

	@Override
	public List<BoardCommentVO> selectList(Connection conn, int ref)  throws SQLException{
		List<BoardCommentVO> list = null;
		String sql = "select * from board_comment where ref=" + ref;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			list = new ArrayList<>();
			do {
				BoardCommentVO vo = new BoardCommentVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setRef(rs.getInt("ref"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getTimestamp("regdate"));
				vo.setIp(rs.getString("ip"));
				list.add(vo);
			}while(rs.next());
		}
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		return list;
	}

	@Override
	public BoardCommentVO selectByIdx(Connection conn, int idx)  throws SQLException{
		BoardCommentVO vo = null;
		String sql = "select * from board_comment where idx=" + idx;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			vo = new BoardCommentVO();
			vo.setIdx(rs.getInt("idx"));
			vo.setRef(rs.getInt("ref"));
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));
			vo.setContent(rs.getString("content"));
			vo.setRegDate(rs.getTimestamp("regdate"));
			vo.setIp(rs.getString("ip"));
		}
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		return vo;
	}

	@Override
	public void insert(Connection conn, BoardCommentVO vo) throws SQLException {
		String sql = "insert into board_comment (ref,name,password,content,ip) values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getRef());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getIp());
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);
	}

	@Override
	public void update(Connection conn, BoardCommentVO vo)  throws SQLException{
		String sql = "update board_comment set content=?, regdate=now(), ip=? where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getContent());
		pstmt.setString(2, vo.getIp());
		pstmt.setInt(3, vo.getIdx());
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);
	}

	@Override
	public void delete(Connection conn, int idx) throws SQLException {
		String sql = "delete from board_comment where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);
	}

	@Override
	public void deleteByRef(Connection conn, int ref) throws SQLException {
		String sql = "delete from board_comment where ref=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ref);
		pstmt.executeUpdate();
		JDBCUtil.close(pstmt);
	}

}
