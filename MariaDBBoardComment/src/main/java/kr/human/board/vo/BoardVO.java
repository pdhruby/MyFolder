package kr.human.board.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

// 테이블과 1:1 대응되게 만든다.
@Data
public class BoardVO {
	private int idx;
	private String name;
	private String password;
	private String subject;
	private String content;
	private Date   regDate;
	private int    clickCount;
	private String ip;
	
	// 수정/삭제/저장 구분
	private String mode;
	
	// 댓글의 정보를 저장할 변수를 추가하자!!!
	private int commentCount; // 목록보기에서는 갯수만 필요
	private List<BoardCommentVO> commentList; // 내용보기에서는 댓글들이 모두 필요
}
