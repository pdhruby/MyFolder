package kr.human.fileboard.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.fileboard.vo.FileBoardVO;

public interface FileBoardDAO {
	int selectCount(SqlSession sqlSession) throws SQLException;
	FileBoardVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException;
	List<FileBoardVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException;
	void insert(SqlSession sqlSession, FileBoardVO fileBoardVO) throws SQLException;
	void update(SqlSession sqlSession, FileBoardVO fileBoardVO) throws SQLException;
	void delete(SqlSession sqlSession, int idx) throws SQLException;
	int selectMaxIdx(SqlSession sqlSession) throws SQLException;
}
