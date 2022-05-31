package kr.human.fileboard.vo;

import lombok.Data;

/*
CREATE TABLE upfile(
	idx NUMBER PRIMARY KEY,
	ref NUMBER NOT NULL, -- 원본글번호
	ofile varchar2(100) NOT NULL, -- 원본 파일명
	sfile varchar2(100) NOT NULL  -- 저장 파일명
);
 */
@Data
public class UpFileVO {
	private int idx;
	private int ref;
	private String ofile;
	private String sfile;
}
