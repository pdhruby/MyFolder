package kr.human.member.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	public static MemberDAO getInstance(){
		return instance;
	}
	//-------------------------------------------------------------------------------
	@Override
	public void insert(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
		sqlSession.insert("member.insert", memberVO);
	}
	@Override
	public void update(SqlSession sqlSession, MemberVO memberVO) throws SQLException {
		sqlSession.update("member.update", memberVO);
	}
	@Override
	public void delete(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("member.delete", idx);
	}
	@Override
	public MemberVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
		return sqlSession.selectOne("member.selectByIdx", idx);
	}
	@Override
	public MemberVO selectByUserid(SqlSession sqlSession, String userid) throws SQLException {
		return sqlSession.selectOne("member.selectByUserid", userid);
	}
	@Override
	public List<MemberVO> selectList(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectList("member.selectList");
	}
	@Override
	public int selectUseridCount(SqlSession sqlSession, String userid) throws SQLException {
		return sqlSession.selectOne("member.selectUseridCount", userid);
	}
	@Override
	public void updateUse(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		sqlSession.update("member.updateUse", map);
	}
	@Override
	public void updateLevel(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		sqlSession.update("member.updateLevel", map);
	}
	@Override
	public List<MemberVO> selectByName(SqlSession sqlSession, String name) throws SQLException {
		return sqlSession.selectList("member.selectByName", name);
	}
	@Override
	public void updatePassword(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		sqlSession.update("member.updatePassword", map);
	}
	
}
