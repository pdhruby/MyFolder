package kr.human.fileboard.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.fileboard.vo.UpFileVO;

public interface UpFileDAO {
	int selectCountByRef(SqlSession sqlSession, int ref) throws SQLException;
	List<UpFileVO> selectListByRef(SqlSession sqlSession,int ref) throws SQLException;
	void insert(SqlSession sqlSession,UpFileVO upFileVO) throws SQLException;
	void delete(SqlSession sqlSession, int idx) throws SQLException;
	UpFileVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException;
}
