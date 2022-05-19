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


select password('1234') , md5('1234') , sha('1234');

select length(password('1'));
select length(password('1234'));
select length(password('1saddsadasdsa234'));

insert into board 
	(name,password,subject,content,ip)
values
	('한사람',password('1234'),'제목이다 1','내용이당 1','192.168.0.45'),
	('한사람',password('1234'),'제목이다 2','내용이당 2','192.168.0.45'),
	('한사람',password('1234'),'제목이다 3','내용이당 3','192.168.0.45'),
	('한사람',password('1234'),'제목이다 4','내용이당 4','192.168.0.45'),
	('한사람',password('1234'),'제목이다 5','내용이당 5','192.168.0.45');


delete from board where idx=3;