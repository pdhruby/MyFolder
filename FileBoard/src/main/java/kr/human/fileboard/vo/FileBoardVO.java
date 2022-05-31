package kr.human.fileboard.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
/*
CREATE TABLE fileBoard(
	idx NUMBER PRIMARY KEY,
	name varchar2(100) NOT NULL,
	password varchar2(100) NOT NULL,
	subject varchar2(100) NOT NULL,
	content varchar2(3000) NOT NULL,
	regDate timestamp DEFAULT SYSDATE
);
 */
@Data
public class FileBoardVO {
	private int idx;
	private String name;
	private String password;
	private String subject;
	private String content;
	private Date   regDate;
	
	private int mode;
	private List<UpFileVO> fileList;
}
