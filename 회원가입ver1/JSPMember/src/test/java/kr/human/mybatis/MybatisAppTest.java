package kr.human.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import kr.human.member.dao.MemberDAOImpl;

public class MybatisAppTest {
	
	static SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void beforeClass() {
		sqlSessionFactory = MybatisApp.getSqlSessionFactory();
	}
	
	@Test
	public void getSession() {
		assertNotNull(MybatisApp.getSqlSessionFactory());
	}
	
	@Test
	public void selectByIdx() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			assertEquals(MemberDAOImpl.getInstance().selectByIdx(sqlSession, 1).getUserid(), "root");
			//assertEquals(MemberDAOImpl.getInstance().selectByIdx(sqlSession, 3).getName(), "최고관리자");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void selectByUserid() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			assertEquals(MemberDAOImpl.getInstance().selectByUserid(sqlSession, "root").getName(), "최고관리자");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
