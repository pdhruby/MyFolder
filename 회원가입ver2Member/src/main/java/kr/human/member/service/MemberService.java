package kr.human.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.human.member.vo.MemberVO;

public interface MemberService {
	// 저장(회원가입)
	void insert(MemberVO memberVO, String urlAddress);
	// 수정(정보수정)
	void update(MemberVO memberVO, String newPassword, HttpSession httpSession);
	// 삭제(회원탈퇴)
	void delete(MemberVO memberVO, HttpSession httpSession);
	// 목록보기(관리자)
	List<MemberVO> selectList();
	// 아이디 찾기
	MemberVO searchUserid(String name, String phone); 
	// 비번 찾기
	MemberVO searchPassword(String userid, String phone); 
	// 로그인
	boolean login(String userid, String password, HttpSession httpSession);
	// 로그아웃
	void logout();
	// 인증하기
	boolean emailConfirm(String userid);
	// 아이디 중복확인
	int idCheck(String userid);
}
