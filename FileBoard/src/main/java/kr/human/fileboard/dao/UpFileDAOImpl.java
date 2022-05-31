package kr.human.fileboard.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.fileboard.vo.UpFileVO;

public class UpFileDAOImpl implements UpFileDAO{
	private static UpFileDAO instance = new UpFileDAOImpl();
	private UpFileDAOImpl() {
		;
	}
	public static UpFileDAO getInstance() {
		return instance;
	}
	//----------------------------------------------------------
	@Override
	public int selectCountByRef(SqlSession sqlSession, int ref) throws SQLException {
		return sqlSession.selectOne("upFile.selectCountByRef", ref);
	}
	@Override
	public List<UpFileVO> selectListByRef(SqlSession sqlSession, int ref) throws SQLException {
		return sqlSession.selectList("upFile.selectListByRef", ref);
	}
	@Override
	public void insert(SqlSession sqlSession, UpFileVO upFileVO) throws SQLException {
		sqlSession.insert("upFile.insert", upFileVO);
	}
	@Override
	public void delete(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("upFile.delete", idx);		
	}
	@Override
	public UpFileVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
		return sqlSession.selectOne("upFile.selectByIdx", idx);
	}
	
}
