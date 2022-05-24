-- 실습을 해보자!!

--제 1장 데이터 조회하기 : SELECT 
--=======================================================
-- 사원 테이블 -- 한글1글자가 3바이트이다.
CREATE TABLE TEMP (
 EMP_ID      NUMBER NOT NULL PRIMARY KEY,
 EMP_NAME    VARCHAR2(10) NOT NULL,
 BIRTH_DATE  DATE,
 DEPT_CODE   VARCHAR2(06) NOT NULL,
 EMP_TYPE    VARCHAR2(06),
 USE_YN      VARCHAR2(01) NOT NULL,
 TEL         VARCHAR2(15),
 HOBBY       VARCHAR2(30),
 SALARY      NUMBER,
 LEV         VARCHAR2(06)
);


-- 부서 테이블
CREATE TABLE TDEPT (
 DEPT_CODE   VARCHAR2(06) NOT NULL PRIMARY KEY,
 DEPT_NAME   VARCHAR2(20) NOT NULL,
 PARENT_DEPT VARCHAR2(06) NOT NULL,
 USE_YN      VARCHAR2(01) NOT NULL,
 AREA        VARCHAR2(10),
 BOSS_ID     NUMBER
);


INSERT INTO TEMP VALUES (19970101,'김길동',TO_DATE('19740125','YYYYMMDD'),'AA0001','정규','Y','','등산',100000000,'부장');
INSERT INTO TEMP VALUES (19960101,'홍길동',TO_DATE('19730322','YYYYMMDD'),'AB0001','정규','Y','','낚시',72000000,'과장');
INSERT INTO TEMP VALUES (19970201,'박문수',TO_DATE('19750415','YYYYMMDD'),'AC0001','정규','Y','','바둑',50000000,'과장');
INSERT INTO TEMP VALUES (19930331,'정도령',TO_DATE('19760525','YYYYMMDD'),'BA0001','정규','Y','','노래',70000000,'차장');
INSERT INTO TEMP VALUES (19950303,'이순신',TO_DATE('19730615','YYYYMMDD'),'BB0001','정규','Y','','',56000000,'대리');
INSERT INTO TEMP VALUES (19966102,'지문덕',TO_DATE('19720705','YYYYMMDD'),'BC0001','정규','Y','','',45000000,'과장');
INSERT INTO TEMP VALUES (19930402,'강감찬',TO_DATE('19720815','YYYYMMDD'),'CA0001','정규','Y','','',64000000,'차장');
INSERT INTO TEMP VALUES (19960303,'설까치',TO_DATE('19710925','YYYYMMDD'),'CB0001','정규','Y','','',35000000,'사원');
INSERT INTO TEMP VALUES (19970112,'연흥부',TO_DATE('19761105','YYYYMMDD'),'CC0001','정규','Y','','',45000000,'대리');
INSERT INTO TEMP VALUES (19960212,'배뱅이',TO_DATE('19721215','YYYYMMDD'),'CD0001','정규','Y','','',39000000,'과장');
--
INSERT INTO TDEPT VALUES ('AA0001','경영지원','AA0001','Y','서울',19940101);
INSERT INTO TDEPT VALUES ('AB0001','재무','AA0001','Y','서울',19960101);
INSERT INTO TDEPT VALUES ('AC0001','총무','AA0001','Y','서울',19970201);
INSERT INTO TDEPT VALUES ('BA0001','기술지원','BA0001','Y','인천',19930301);
INSERT INTO TDEPT VALUES ('BB0001','H/W지원','BA0001','Y','인천',19950303);
INSERT INTO TDEPT VALUES ('BC0001','S/W지원','BA0001','Y','인천',19966102);
INSERT INTO TDEPT VALUES ('CA0001','영업','CA0001','Y','본사',19930402);
INSERT INTO TDEPT VALUES ('CB0001','영업기획','CA0001','Y','본사',19950103);
INSERT INTO TDEPT VALUES ('CC0001','영업1','CA0001','Y','본사',19970112);
INSERT INTO TDEPT VALUES ('CD0001','영업2','CA0001','Y','본사',19960212);
--
COMMIT;

SELECT * FROM TEMP;
SELECT * FROM tdept;

-- select 필드명.... from 테이블명.... where 조건 order by 정렬필드.....
SELECT
	E.EMP_ID  사번, E.EMP_NAME AS 이름 
FROM 
	temp E;

-------------------------
SELECT
	* 
FROM 
	temp E;

-----연봉을 이용하여 월급을 계산해 보자!!!

SELECT EMP_ID 사번, EMP_NAME 이름, ROUND(SALARY/13) 연봉  FROM temp;

SELECT EMP_ID 사번, EMP_NAME 이름, ROUND(SALARY/13,2) 연봉  FROM temp;

SELECT EMP_ID 사번, EMP_NAME 이름, ROUND(SALARY/13,-2) 연봉  FROM temp;

-- 짝수달에는 연봉의 2/18을 홀수달에는 연봉의 1/18을 지급된다.
--- 별칭에 공백을 포함하려면 쌍따옴표로 감싸줘야 한다.
SELECT EMP_ID 사번, EMP_NAME 이름 , SALARY 연봉, ROUND(SALARY/18-2) "홀수달 월급", ROUND(SALARY/18*2-2) "짝수달 월급"
FROM
	temp;


SELECT EMP_ID 사번, EMP_NAME 이름 , SALARY 연봉, ROUND(SALARY/18-2)+100000 "홀수달 월급", ROUND(SALARY/18*2-2)200000 "짝수달 월급"
FROM
	temp;

-- NULL의 사용
SELECT * FROM TEMP t;
SELECT EMP_NAME , HOBBY  FROM TEMP t;

-- NVL함수 : NVL(값, 값이 NULL일경우 표시할 내용)
SELECT EMP_NAME , NVL(HOBBY,'없다')  FROM TEMP t;
---NVL2함수 : NVL(값, 값이 있을때 나타낼값, 값이 NULL일경우 표시할 내용)
SELECT EMP_NAME , NVL2(HOBBY,HOBBY,'없다')  FROM TEMP t;
SELECT EMP_NAME , NVL2(HOBBY,'있다','없다')  FROM TEMP t;

-- NULL 값이 제외된다.
SELECT EMP_NAME ,HOBBY  FROM TEMP t WHERE HOBBY = '등산';
SELECT EMP_NAME ,HOBBY  FROM TEMP t WHERE HOBBY <> '등산';

-- 아래는 아무것도 나오지 않는다.
SELECT EMP_NAME ,HOBBY  FROM TEMP t WHERE HOBBY !=  NULL;
SELECT EMP_NAME ,HOBBY  FROM TEMP t WHERE HOBBY =  NULL;


-- 반드시 NULL의 비교는 is null 또는 is not null을 이용해야 한다.
SELECT EMP_NAME ,HOBBY  FROM TEMP t WHERE HOBBY IS NULL;
SELECT EMP_NAME ,HOBBY  FROM TEMP t WHERE HOBBY IS not NULL;

-- 취미가 NULL인 사원의 취미를 등산으로 해서 취미가 등산인 사원 목록을 조회하시오.

SELECT EMP_NAME, nvl(hobby,'등산') FROM TEMP WHERE nvl(hobby,'등산') = '등산';

---- 이름과 부서코드,부서명을 조회하시오

SELECT * FROM TDEPT t;
SELECT * FROM TEMP t;

SELECT 
	EMP_NAME ,  e.DEPT_CODE ,dept_name 
FROM 
	temp e , TDEPT d
WHERE 
	e.DEPT_CODE  = d.DEPT_CODE;
	
--- 성명을 보일떄 ()안에 직급을 넣어서 보여주시오.
-- CONCAT 함수 : 문자열 연결 함수 : CONCAT(문자열1, 문자열2)
SELECT 
	EMP_NAME || '(' || LEV || ')', CONCAT(CONCAT(CONCAT(EMP_NAME,'('),LEV),')') 
FROM 
	TEMP t;
	


-- 작은 따옴표 자체를 출력하고 싶다.''''를 연달아 써야한다.
SELECT 
	EMP_NAME || ''' || LEV || ''',
	EMP_NAME || '"' || LEV || '"',
	EMP_NAME || '''' || LEV || ''''
FROM 
	TEMP t;

SELECT 
	*
FROM 
	USER_OBJECTS; -- 사용자가 가지고 있는 객체의 목록을 보여준다.
				  -- 기본 키를 지정하면 자동으로 인덱스가 생성된다.

	
-- 테이블 목록 조회하기	
SELECT 
	OBJECT_NAME
FROM 
	USER_OBJECTS WHERE OBJECT_TYPE='TABLE';	

SELECT * FROM tab;


-- 모든 테이블을 지우는 명령을 만드는 명령 
SELECT 
	'drop ' || OBJECT_TYPE || ' ' || OBJECT_NAME || ';'
FROM 
	USER_OBJECTS;

-- 문자열과 숫자의 연결 

SELECT 
	'11' || 11 "문자와 숫자의 결합",
	'12' * '2' "문자를 연산자로 결합",
	'12' + 6 "연산자로 결합"	
FROM 
	dual;

SELECT 
EMP_ID,EMP_NAME ,SUBSTR(EMP_ID,1,4) 
FROM 
	TEMP t
WHERE 
	SUBSTR(EMP_ID,1,4)*1 = '1997'; 


-- 오더바이절에서 1,2는 1은 첫번째 먼저 비교 같다면 2번째비교
SELECT 
	LEV, EMP_ID ,EMP_NAME 
FROM 
	TEMP t
ORDER BY
	1,2 DESC;



SELECT 
	SALARY / 12 , SALARY / 18
FROM 

TEMP t

ORDER BY
	SALARY/12;
	

SELECT 
	SALARY / 12 , SALARY / 18
FROM 

TEMP t

ORDER BY
	1; -- 정렬할 필드에 연산식이 있는 경우는 필드명보다 숫자가 편리하다.
	
-- LIKE 절  (  _ 한글자 , % 모든것)
SELECT 
	DEPT_CODE 
FROM 
	TEMP 
WHERE 
	DEPT_CODE LIKE '_A%'; -- 부서코드의 두번째 글자가 A인 부서
	
SELECT 
	DEPT_CODE 
FROM 
	TEMP 
WHERE 
	DEPT_CODE LIKE '%A%'; -- 부서코드의 A글자가 포함된 부서
	
SELECT 
	DEPT_CODE 
FROM 
	TEMP 
WHERE 
	DEPT_CODE LIKE '%1'; -- 부서코드가 1로끝나는  부서
	
	
SELECT 
	EMP_ID , EMP_NAME  
FROM 
	TEMP 
WHERE 
	EMP_NAME  LIKE '%동%'; -- 이름이 동이 들어가는것 출력
	
	
-- 1997년에 입사한 사원의 목록을 조회하시오.
SELECT EMP_ID , EMP_NAME FROM TEMP t WHERE SUBSTR(EMP_ID,1,4) = 1997; 
SELECT EMP_ID , EMP_NAME FROM TEMP t WHERE EMP_ID >= 1997001 AND EMP_ID <= 19979999;
SELECT EMP_ID , EMP_NAME FROM TEMP t WHERE EMP_ID BETWEEN 1997001 AND 19979999;


-- IN , NOT IN  (OR 연산자와 같다.)
-- 과장과 부장,차장을 조회하시오
SELECT EMP_NAME ,LEV FROM TEMP t WHERE LEV='과장' OR LEV='부장' OR LEV='차장';
SELECT EMP_NAME ,LEV FROM TEMP t WHERE LEV IN('과장','부장','차장');
SELECT EMP_NAME ,LEV FROM TEMP t WHERE LEV NOT IN('과장','부장','차장');

-- group by ~ having
-- 그룹함수 MAX, MIN, SUM, AVG, COUNT

-- 직급별 최대 연봉, 최소 연봉
SELECT MAX(SALARY) 최대연봉 , MIN(SALARY) 최소연봉 FROM TEMP t GROUP BY LEV;
SELECT lev , MAX(SALARY) 최대연봉 , MIN(SALARY) 최소연봉 FROM TEMP t GROUP BY LEV;

-- 직급별 최대 연봉이 7000이상인 직급을 조회
SELECT lev , MAX(SALARY) 최대연봉 FROM TEMP t GROUP BY LEV WHERE MAX(SALARY) >= 70000000; -- 에러

SELECT lev , MAX(SALARY) 최대연봉 FROM TEMP t WHERE MAX(SALARY) >= 70000000 GROUP BY LEV ; -- 에러

--그룹지어서 할떄는 GROUP BY ~ HAVING(조건)을 사용해야한다.
SELECT lev , MAX(SALARY) 최대연봉 FROM TEMP t GROUP BY LEV HAVING  MAX(SALARY) >= 70000000; 

-- 직급만 중복없이 보고 싶다.
SELECT LEV FROM TEMP t;
SELECT DISTINCT  LEV FROM TEMP t;  -- 중복 제거


SELECT * FROM TDEPT t;


--- 직급별 막둥이 중에서 1997년 입사한 사람
SELECT * FROM TEMP t;
SELECT 
	LEV , MAX(EMP_ID)
FROM
	TEMP t 
GROUP BY
	LEV, EMP_ID 
HAVING 
	MAX(EMP_ID) LIKE '1997%';