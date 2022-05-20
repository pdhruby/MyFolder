package kr.human.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.human.board.vo.BoardCommentVO;

public interface BoardCommentDAO {
	// 지정 번호의 댓글의 개수 구하기
	int selectCount(Connection conn, int ref) throws SQLException;
	// 지정 번호의 댓글 리스트 구하기
	List<BoardCommentVO> selectList(Connection conn, int ref) throws SQLException;
	// 1개얻기
	BoardCommentVO selectByIdx(Connection conn, int idx) throws SQLException;
	// 저장
	void insert(Connection conn, BoardCommentVO vo) throws SQLException;
	// 수정
	void update(Connection conn, BoardCommentVO vo) throws SQLException;
	// 삭제
	void delete(Connection conn, int idx) throws SQLException;
	// 지정 번호의 댓글 모두 지우기
	void deleteByRef(Connection conn, int ref) throws SQLException;
}
