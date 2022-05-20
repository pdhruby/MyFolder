create table board(
	idx int primary key auto_increment,
	name varchar(30) not null,
	password varchar(50) not null,
	subject varchar(300) not null,
	content text not null,
	regDate timestamp default now(),
	clickCount int(4) default 0,
	ip varchar(20) not null
);

select password('1234'), md5('1234'), sha('1234');

select length(password('1')); 
select length(password('1234')); 

INSERT INTO board 
	(name, password, subject, content, ip)
VALUES
	('한사람',password('1234'),'제목이다 1','내용이당 1','192.168.0.45'),
	('한사람',password('1234'),'제목이다 2','내용이당 2','192.168.0.45'),
	('한사람',password('1234'),'제목이다 3','내용이당 3','192.168.0.45'),
	('한사람',password('1234'),'제목이다 4','내용이당 4','192.168.0.45'),
	('한사람',password('1234'),'제목이다 5','내용이당 5','192.168.0.45');

delete from board where idx=3;


-- 댓글 테이블을 만들자!!!!
create table board_comment(
	idx int primary key auto_increment,
	ref int not null,
	name varchar(30) not null,
	password varchar(50) not null,
	content text not null,
	regDate timestamp default now(),
	ip varchar(20) not null,
	FOREIGN KEY(ref) REFERENCES board(idx)	
);

desc board_comment;
select * from information_schema.table_constraints where table_name = 'board_comment';	-- 테이블 정보확인

-- 댓글을 몇개 추가해보자
select idx from board;

insert into board_comment 
	(ref,name,password,content,ip)
values
	(4,'멍멍이','1234','댓글을 달아보자\n하하하하','192.168.45.67'),
	(4,'멍멍이2','1234','댓글을 달아보자\n하하하하','192.168.45.67'),
	(5,'멍멍이','1234','댓글을 달아보자\n하하하하','192.168.45.67'),
	(6,'멍멍이1','1234','댓글을 달아보자\n하하하하','192.168.45.67'),
	(6,'멍멍이2','1234','댓글을 달아보자\n하하하하','192.168.45.67');


