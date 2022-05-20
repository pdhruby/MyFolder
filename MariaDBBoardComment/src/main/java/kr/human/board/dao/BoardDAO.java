package kr.human.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.human.board.vo.BoardVO;

public interface BoardDAO {
	// 전체 개수 얻기
	public int selectCount(Connection conn) throws SQLException;
	
	// 1개 얻기
	public BoardVO selectByIdx(Connection conn, int idx ) throws SQLException;
	
	// 1페이지분량 얻기
	public List<BoardVO> selectList(Connection conn,int startNo, int pageSize) throws SQLException;
	
	//저장
	public void insert(Connection conn, BoardVO vo) throws SQLException; 
	
	
	//수정
	public void update(Connection conn, BoardVO vo) throws SQLException; 
	
	//삭제
	public void delete(Connection conn, int idx) throws SQLException; 
	
	// 조회수 증가
	public void increment(Connection conn, int idx) throws SQLException; 
	
	// 비밀번호 일치여부 판단
	int pwdCheck(Connection conn, int idx, String password) throws SQLException;
	
}
