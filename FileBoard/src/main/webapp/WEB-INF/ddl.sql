-- 시퀀스 2개 테이블 2개를 만들자!!!!
DROP SEQUENCE fileBoard_idx_seq;
CREATE SEQUENCE fileBoard_idx_seq;
DROP TABLE fileBoard;
CREATE TABLE fileBoard(
	idx NUMBER PRIMARY KEY,
	name varchar2(100) NOT NULL,
	password varchar2(100) NOT NULL,
	subject varchar2(100) NOT NULL,
	content varchar2(3000) NOT NULL,
	regDate timestamp DEFAULT SYSDATE
);
DROP SEQUENCE upfile_idx_seq;
CREATE SEQUENCE upfile_idx_seq;
DROP TABLE upfile;
CREATE TABLE upfile(
	idx NUMBER PRIMARY KEY,
	ref NUMBER NOT NULL, -- 원본글번호
	ofile varchar2(100) NOT NULL, -- 원본 파일명
	sfile varchar2(100) NOT NULL  -- 저장 파일명
);


SELECT * FROM upfile;
