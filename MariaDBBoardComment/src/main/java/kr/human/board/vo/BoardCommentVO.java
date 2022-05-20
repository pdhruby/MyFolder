package kr.human.board.vo;

import java.util.Date;

import lombok.Data;

// 테이블과 1:1 대응되게 만든다.
@Data
public class BoardCommentVO {
	private int idx;
	private int ref;
	private String name;
	private String password;
	private String content;
	private Date   regDate;
	private String ip;
	
	// 수정/삭제/저장 구분
	private String mode;
}
