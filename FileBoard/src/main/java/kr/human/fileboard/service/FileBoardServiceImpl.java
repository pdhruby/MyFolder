package kr.human.fileboard.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.human.fileboard.dao.FileBoardDAO;
import kr.human.fileboard.dao.FileBoardDAOImpl;
import kr.human.fileboard.dao.UpFileDAO;
import kr.human.fileboard.dao.UpFileDAOImpl;
import kr.human.fileboard.vo.FileBoardVO;
import kr.human.fileboard.vo.PagingVO;
import kr.human.fileboard.vo.UpFileVO;
import kr.human.mybatis.MybatisApp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileBoardServiceImpl implements FileBoardService {
	private static FileBoardService instance = new FileBoardServiceImpl();
	private FileBoardServiceImpl() {}
	public static FileBoardService getInstance() {
		return instance;
	}
	//----------------------------------------------------------------------
	@Override
	public PagingVO<FileBoardVO> selectList(int currentPage, int pageSize, int blockSize) {
		log.info("FileBoardServiceImpl selectList 호출 : " + currentPage + ", " + pageSize + ", " + blockSize);
		PagingVO<FileBoardVO> pagingVO = null;
		SqlSession sqlSession = null;
		FileBoardDAO fileBoardDAO = null;
		UpFileDAO    upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			fileBoardDAO = FileBoardDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 전체 개수를 구한다.
			int totalCount = fileBoardDAO.selectCount(sqlSession);
			// 2. 페이지를 계산한다.
			pagingVO = new PagingVO<FileBoardVO>(totalCount, currentPage, pageSize, blockSize);
			// 3. 글목록을 가져온다.
			HashMap<String, Integer> map = new HashMap<>();
			map.put("startNo", pagingVO.getStartNo());
			map.put("endNo", pagingVO.getEndNo());
			List<FileBoardVO> list = fileBoardDAO.selectList(sqlSession, map);
			// 4. 각각의 글에 대하여 첨부파일 정보를 얻어서 넣자!!!
			if(list!=null) {
				for(FileBoardVO vo : list) {
					List<UpFileVO> fileList = upFileDAO.selectListByRef(sqlSession, vo.getIdx());
					vo.setFileList(fileList);
				}
			}
			// 5. 글의 목록을 pageingVO에 넣어준다.
			pagingVO.setList(list);
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		log.info("FileBoardServiceImpl selectList 리턴 : " + pagingVO);
		return pagingVO;
	}
	@Override
	public FileBoardVO selectByIdx(int idx) {
		log.info("FileBoardServiceImpl selectByIdx 호출 : " + idx);
		FileBoardVO fileBoardVO= null;
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		FileBoardDAO fileBoardDAO = null;
		UpFileDAO    upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			fileBoardDAO = FileBoardDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 해당 글번호의 글을 가져온다.
			fileBoardVO = fileBoardDAO.selectByIdx(sqlSession, idx);
			// 2. 해당글이 존재하면 첨부파일의 정보를 가져온다.
			if(fileBoardVO!=null) {
				List<UpFileVO> fileList = upFileDAO.selectListByRef(sqlSession, idx);
				fileBoardVO.setFileList(fileList);
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------
		log.info("FileBoardServiceImpl selectByIdx 리턴 : " + fileBoardVO);
		return fileBoardVO;
	}
	@Override
	public void insert(FileBoardVO fileBoardVO) {
		log.info("FileBoardServiceImpl insert 호출 : " + fileBoardVO);
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		FileBoardDAO fileBoardDAO = null;
		UpFileDAO    upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			fileBoardDAO = FileBoardDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if(fileBoardVO!=null) {
				// 2. 원본글을 저장한다.
				fileBoardDAO.insert(sqlSession, fileBoardVO);
				
				// 3. 첨부파일을 저장한다.
				if(fileBoardVO.getFileList()!=null) { // 첨부파일이 있다면
					int ref = fileBoardDAO.selectMaxIdx(sqlSession); // 지금 저장한 글의 idx를 읽는다.
					for(UpFileVO vo : fileBoardVO.getFileList()) {
						vo.setRef(ref); // 원본글의 글번호를 넣는다.
						upFileDAO.insert(sqlSession, vo);
					}
				}
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------
	}
	@Override
	public void update(FileBoardVO fileBoardVO, String path, String[] delfile) {
		log.info("FileBoardServiceImpl update 호출 : " + fileBoardVO + ", " + path + ", " + Arrays.toString(delfile));
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		FileBoardDAO fileBoardDAO = null;
		UpFileDAO    upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			fileBoardDAO = FileBoardDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if(fileBoardVO!=null) {
				// 2. DB에서 해당 글번호의 글을 읽어온다.
				FileBoardVO dbVO = fileBoardDAO.selectByIdx(sqlSession, fileBoardVO.getIdx());
				// 3. DB에 글이 있으면서 비번이 일치할때만 수정을 수행한다.
				if(dbVO!=null && dbVO.getPassword().equals(fileBoardVO.getPassword())){
					// 원본글 수정
					fileBoardDAO.update(sqlSession, fileBoardVO);
					// 원본글에 추가로 파일이 첨부가 되었다면 파일을 저장한다.
					if(fileBoardVO.getFileList()!=null) { // 첨부파일이 있다면
						int ref = fileBoardVO.getIdx();
						for(UpFileVO vo : fileBoardVO.getFileList()) {
							vo.setRef(ref); // 원본글의 글번호를 넣는다.
							upFileDAO.insert(sqlSession, vo);
						}
					}
					// 4. 기존파일에 삭제를 선택했다면 기존에 업로드된 파일을 DB와 저장된 파일 자체를 지워준다.
					if(delfile!=null) {
						for(String idx : delfile) {
							try {
								// DB에서 1개를 가져온다.
								UpFileVO dbFileVO = upFileDAO.selectByIdx(sqlSession, Integer.parseInt(idx));
								if(dbFileVO!=null) {
									// DB에서 첨부파일 삭제
									upFileDAO.delete(sqlSession, Integer.parseInt(idx));
									// 서버에서 파일을 삭제
									File file = new File(path + File.separator + dbFileVO.getSfile());
									file.delete();
								}
								
							}catch (Exception e) {
								;
							}
						}
					}
				}
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------			
	}
	@Override
	public void delete(FileBoardVO fileBoardVO, String path) {
		log.info("FileBoardServiceImpl delete 호출 : " + fileBoardVO + ", " + path);
		//------------------------------------------------------------
		SqlSession sqlSession = null;
		FileBoardDAO fileBoardDAO = null;
		UpFileDAO    upFileDAO = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			fileBoardDAO = FileBoardDAOImpl.getInstance();
			upFileDAO = UpFileDAOImpl.getInstance();
			//--------------------------------------------------------------------
			// 1. 원본글이 존재하면
			if(fileBoardVO!=null) {
				// 2. DB에서 해당 글번호의 글을 읽어온다.
				FileBoardVO dbVO = fileBoardDAO.selectByIdx(sqlSession, fileBoardVO.getIdx());
				// 3. DB에 글이 있으면서 비번이 일치할때만 수정을 수행한다.
				if(dbVO!=null && dbVO.getPassword().equals(fileBoardVO.getPassword())){
					
					// 원본글 삭제
					fileBoardDAO.delete(sqlSession, fileBoardVO.getIdx());
					
					// 원본글의 첨부파일 목록을 가져온다.
					List<UpFileVO> fileList = upFileDAO.selectListByRef(sqlSession, fileBoardVO.getIdx());
					// 첨부파일도 삭제해야 한다.
					if(fileList!=null) {
						for(UpFileVO upFileVO : fileList) {
							// DB의 첨부 삭제
							upFileDAO.delete(sqlSession, upFileVO.getIdx());
							// 서버에 저장된 파일 삭제
							File file = new File(path + File.separator + upFileVO.getSfile());
							file.delete();
						}
					}
				}
			}
			//--------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		//----------------------------------------------------------------------------------		
	}
}
