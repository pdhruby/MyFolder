package kr.human.member.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.member.vo.MemberVO;

public interface MemberDAO {
	// 저장
	void insert(SqlSession sqlSession, MemberVO memberVO) throws SQLException;
	// 수정
	void update(SqlSession sqlSession, MemberVO memberVO) throws SQLException;
	// 삭제
	void delete(SqlSession sqlSession, int idx) throws SQLException;
	// 1개얻기(idx로 얻기)
	MemberVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException;
	// 1개얻기(userid로 얻기)
	MemberVO selectByUserid(SqlSession sqlSession, String userid) throws SQLException;
	// 모두얻기(관리자)
	List<MemberVO> selectList(SqlSession sqlSession) throws SQLException;
	// 동일한 아이디 개수 얻기(중복확인)
	int selectUseridCount(SqlSession sqlSession, String userid) throws SQLException;
	
	
	//인증정보 변경
	void updateUse(SqlSession sqlSession,HashMap<String, Integer> map) throws SQLException;
	//레벨 변경
	void updateLevel(SqlSession sqlSession,HashMap<String, Integer> map) throws SQLException;
	
}
