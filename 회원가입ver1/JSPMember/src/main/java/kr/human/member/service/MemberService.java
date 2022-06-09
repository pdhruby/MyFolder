package kr.human.member.service;
import java.util.List;

import kr.human.member.vo.MemberVO;

public interface MemberService {

	//저장(회원가입)
	void insert(MemberVO memberVO);
	
	//수정(정보수정)
	void update(MemberVO memberVO);
	//삭제(회원탈퇴)
	void delete(MemberVO memberVO);
	//목록보기(관리자)
	List<MemberVO> selectList();
	//아이디 찾기
	MemberVO searchUserid(String name, String email);
	//비밀번호 찾기
	MemberVO searchPassword(String userid, String email);
	
	//로그인
	boolean login(String userid, String password);
	//로그아웃
	void logout();
	//인증하기
	boolean emailConfirm(String userid, String password);
	
	
	
}
