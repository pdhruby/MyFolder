package kr.human.fileboard.service;

import kr.human.fileboard.vo.FileBoardVO;
import kr.human.fileboard.vo.PagingVO;

public interface FileBoardService {
	// 1. 목록보기
	PagingVO<FileBoardVO> selectList(int currentPage, int pageSize, int blockSize);
	// 2. 내용보기
	FileBoardVO selectByIdx(int idx);
	// 3. 저장하기
	void insert(FileBoardVO fileBoardVO);
	// 4. 수정하기
	void update(FileBoardVO fileBoardVO, String path, String[] delfile);
	// 5. 삭제하기
	void delete(FileBoardVO fileBoardVO, String path);
}
