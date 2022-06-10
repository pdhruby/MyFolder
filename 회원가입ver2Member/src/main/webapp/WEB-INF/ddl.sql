CREATE SEQUENCE member_idx_seq;

CREATE TABLE member(
	idx NUMBER PRIMARY KEY,
	userid varchar2(100) NOT NULL UNIQUE,
	password varchar2(100) NOT NULL,
	name varchar2(50) NOT NULL,
	birth DATE NOT NULL,
	gender char(1) check(gender IN ('M','F')),
	email varchar2(100) NOT NULL,
	phone varchar2(20) NOT NULL,
	postcode varchar2(10) NOT NULL,
	addr1 varchar2(200) NOT NULL,
	addr2 varchar2(200) NOT NULL,
	use NUMBER check(use IN (0,1,2,3,4,5,6,7,8,9)),
	lev NUMBER check(lev IN (0,1,2,3,4,5,6,7,8,9))
);
INSERT INTO MEMBER VALUES 
(member_idx_seq.nextval,'root','1234','최고관리자','1988-09-05','M'
,'ithuman202204@gmail.com','010-1234-5678',' ',' ',' ',1, 9);
INSERT INTO MEMBER VALUES 
(member_idx_seq.nextval,'admin','1234','최고관리자','1988-09-05','M'
,'ithuman202204@gmail.com','010-1234-5678',' ',' ',' ',1, 9);
INSERT INTO MEMBER VALUES 
(member_idx_seq.nextval,'master','1234','최고관리자','1988-09-05','M'
,'ithuman202204@gmail.com','010-1234-5678',' ',' ',' ',1, 9);
INSERT INTO MEMBER VALUES 
(member_idx_seq.nextval,'webmaster','1234','최고관리자','1988-09-05','M'
,'ithuman202204@gmail.com','010-1234-5678',' ',' ',' ',1, 9);
INSERT INTO MEMBER VALUES 
(member_idx_seq.nextval,'system','1234','최고관리자','1988-09-05','M'
,'ithuman202204@gmail.com','010-1234-5678',' ',' ',' ',1, 9);
INSERT INTO MEMBER VALUES 
(member_idx_seq.nextval,'sys','1234','최고관리자','1988-09-05','M'
,'ithuman202204@gmail.com','010-1234-5678',' ',' ',' ',1, 9);

SELECT * FROM MEMBER;
