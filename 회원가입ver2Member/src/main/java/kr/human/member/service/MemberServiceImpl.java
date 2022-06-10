package kr.human.member.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.human.member.dao.MemberDAO;
import kr.human.member.dao.MemberDAOImpl;
import kr.human.member.vo.MemberVO;
import kr.human.mybatis.MybatisApp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberService getInstance(){
		return instance;
	}
	//-------------------------------------------------------------------------------
	@Override
	public void insert(MemberVO memberVO, String urlAddress) {
		log.info("MemberServiceImpl의 insert호출 : {}, {}", memberVO, urlAddress);
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(memberVO!=null) {
				// DB에 저장을 하고
				memberDAO.insert(sqlSession, memberVO);
				// 환영이메일 발송
				EmailService.sendMail(memberVO.getEmail(),
						memberVO.getName() + "님 회원가입을 환영합니다.",
						"다음 링크를 클릭하여 인증을 하셔야만 회원 가입이 완료됩니다.<br>"
						+"<a href='" + urlAddress + "&userid=" + memberVO.getUserid()+"'>인증하기</a>");
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}

	}
	@Override
	public void update(MemberVO memberVO, String newPassword, HttpSession httpSession) {
		log.info("MemberServiceImpl의 update호출 : {}, {}", memberVO, newPassword);
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(memberVO!=null) {
				// DB에서 해당 idx을 회원 정보를 가져온다.
				MemberVO dbVO = memberDAO.selectByIdx(sqlSession, memberVO.getIdx());
				// 비번이 같으면
				if(dbVO!=null && dbVO.getPassword().equals(memberVO.getPassword())) {
					// 변경을 수행한다.
					memberVO.setPassword(newPassword); // 새로운 비번으로 바꿔서
					memberDAO.update(sqlSession, memberVO);
					
					// 세션의 값을 변경된 값으로 바꿔준다.
					httpSession.setAttribute("memberVO", memberVO);
					
				}
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}		
	}
	@Override
	public void delete(MemberVO memberVO, HttpSession httpSession) {
		log.info("MemberServiceImpl의 delete호출 : {}", memberVO);
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			if(memberVO!=null) {
				// DB에서 해당 userid의 회원 정보를 가져온다.
				MemberVO dbVO = memberDAO.selectByUserid(sqlSession, memberVO.getUserid());
				// 비번이 같으면
				if(dbVO!=null && dbVO.getPassword().equals(memberVO.getPassword())) {
					// 삭제를 수행한다.
					// DB에서 바로 지우면 않됨
					// use값에 탈퇴라고 저장을 하고 관리자 모드에서 탈퇴하고 6개월이 지나면 일괄 삭제하는
					// 코드를 만들어 주면 된다.
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					map.put("use", 3); // use 0이면 미인증 1이면 인증 2인면 휴면 3이면 탈퇴라고 하자
					map.put("idx", memberVO.getIdx());
					
					memberDAO.updateUse(sqlSession, map);
					
					// 세션의 값을 삭제해 준다.
					httpSession.removeAttribute("memberVO");
					
				}
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}	
	}
	@Override
	public List<MemberVO> selectList() {
		return null;
	}
	@Override
	public MemberVO searchUserid(String name, String phone) {
		log.info("MemberServiceImpl의 searchUserid호출 : {}, {}", name, phone);
		MemberVO memberVO = null;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			List<MemberVO> list = memberDAO.selectByName(sqlSession, name);
			if(list!=null && list.size()>0) {
				for(MemberVO vo : list) {
					if(vo.getPhone().equals(phone)) {
						memberVO = vo;
						break;
					}
				}
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
		log.info("MemberServiceImpl의 searchUserid리턴 : {}", memberVO);
		return memberVO;
	}
	@Override
	public MemberVO searchPassword(String userid, String phone) {
		log.info("MemberServiceImpl의 searchPassword호출 : {}, {}", userid, phone);
		MemberVO memberVO = null;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			memberVO = memberDAO.selectByUserid(sqlSession, userid);
			if(memberVO!=null && memberVO.getPhone().equals(phone)) {
				// 임시비번을 만들어서 
				String newPassword = PasswordService.makeNewPassword();
				// DB의 비번을 변경하고 
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("userid", userid);
				map.put("password", newPassword);
				memberDAO.updatePassword(sqlSession, map);
				// 변경된 비번을 메일로 발송해 준다.
				EmailService.sendMail(memberVO.getEmail(),
						userid + "님의 비밀번호 변경입니다.",
						userid + "님의 임시 비밀번호입니다<br>"+
						"임시비밀번호는 \""+newPassword+"\"입니다. <br>"+
						"로그인 하신후 반드시 변경하시기 바랍니다.");
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
		log.info("MemberServiceImpl의 searchPassword리턴 : {}", memberVO);
		return memberVO;

	}
	@Override
	public boolean login(String userid, String password, HttpSession httpSession) {
		log.info("MemberServiceImpl의 login호출 : {}, {}", userid, password);
		boolean isLogin = false;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			MemberVO memberVO = memberDAO.selectByUserid(sqlSession, userid);
			if(memberVO!=null) { // 해당 아이디의 회원정보가 있다면
				if(memberVO.getPassword().equals(password) && memberVO.getUse()==1) {
					httpSession.setAttribute("memberVO", memberVO);
					isLogin = true;
				}
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
		log.info("MemberServiceImpl의 login리턴 : {}", isLogin);
		return isLogin;
	}
	@Override
	public void logout() {
		
	}
	@Override
	public boolean emailConfirm(String userid) {
		log.info("MemberServiceImpl의 emailConfirm호출 : {}", userid);
		boolean isConfirm = false;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			// 해당 아이디의 회원 정보를 읽어온다
			MemberVO memberVO = memberDAO.selectByUserid(sqlSession, userid);
			if(memberVO!=null) { // 해당 아이디의 회원정보가 있다면
				// 인증값 변경
				// 레벨값 변경
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("use", 1);
				map.put("lev", 1);
				map.put("idx", memberVO.getIdx());
				memberDAO.updateUse(sqlSession, map);
				memberDAO.updateLevel(sqlSession, map);
				isConfirm = true;
			}
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
		log.info("MemberServiceImpl의 emailConfirm리턴 : {}", isConfirm);
		return isConfirm;
	}
	@Override
	public int idCheck(String userid) {
		log.info("MemberServiceImpl의 idCheck호출 : {}", userid);
		int count =0;
		
		SqlSession sqlSession = null;
		MemberDAO memberDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			memberDAO = MemberDAOImpl.getInstance();
			//------------------------------------------------------------------
			count = memberDAO.selectUseridCount(sqlSession, userid);
			//------------------------------------------------------------------
			sqlSession.commit();
		}catch (SQLException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
		log.info("MemberServiceImpl의 idCheck리턴 : {}", count);
		return count;
	}

}
