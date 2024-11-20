/* 여러 줄 주석 */
# 한줄 주석
-- 한줄 주석
/*
	[ SQL 작성 또는 실행하는 방법 ]
    1. SQL 문법을 작성한다. show databases
    2. SQL 문장이 끝나면 ;(세미콜론)으로 마친다.
    3. 실행할 명령어 줄에 (마우스)커서를 두고 ctrl+enter
			- ctrl+enter(I있는 번개모양) : 명령어 단위 실행
            - ctrl+shift+enter(그냥 번개 모양) : 현재 sql 파일의 모든 sql 실행
    4. 실행 결과는 하단에 [Result Grid] 창에서 확인 가능
*/
# [1] db server 내 모든 테이블 확인 # 데이터베이스란? 표/테이블 , 기본 테이블 4개의 테이블명이 출력된다.
show databases;
# [2] db server local path 확인
show variables like 'datadir';
# [3] db server 데이터베이스 생성
create database myDBtest1; # DB 생성
# [4] db server 데이터베이스 삭제
drop database myDBtest1; -- ctrl+enter [단위실행]
# [4-2] 만약 데이터베이스가 존재한다면 삭제
drop database if exists myDBtest1;
# [5] db server 에는 여러개 데이터베이스가 존재하므로 사용/활성화할 데이터베이스를 선택
use myDBtest1;

# [실습1] - 아래와 같이 순서대로 SQL문을 작성하여 실행하시오
	-- 1 'test1' 이름의 데이터베이스가 존재하면 삭제하기 SQL 작성
    -- 2 'test2' 이름의 데이터베이스 생성하기 SQL 작성
    -- 3 데이터베이스 목록 확인 SQL 작성
    -- 4 로컬 PC에 데이터베이스가 만들어졌는지 경로확인 SQL 작성
    -- 5 'test1' 이름의 데이터 베이스 사용 활성화하기 SQL 작성

drop database if exists test1;
create database test1;
show databases;
show variables like 'datadir';
use test1;

# 테이블 생성과 타입 관련
# [1] DB 생성
create database mydb1120;
# [2] DB 활성화(사용)
use mydb1120;
# [3] 활성된 DB 내 테이블 생성
create table member(id text,password text,name text);
# [4] 활성화 된 DB 내 테이블의 목록 보기
show tables;
# [5] 테이블 삭제
drop table member;
drop table if exists member; -- 사용 권장

/*
	[용어,관점 차이에 따른 용어]
파일시스템관점	모델링관점	관계형관점
    파일		엔티티	테이블,릴레이션
    레코드	튜플		행(가로)
    필드		속성		열(세로)
    1.테이블(table) : 표 , 릴레이션(Relation) , 엔티티(Entity)
    2. 레코드(Record) : 튜플(tuple) , 행(row),가로 1줄 단위
    3. 필드(Field) : 속성(Attribute) , 열(column) , 세로 1줄 단위

    [테이블 생성시 필드(데이터)타입 = JAVA의 데이터타입 역할이 같다. oracle vs mysql]
		[정수]
			TINYINT	1바이트 -128~127
            SMALLINT 2바이트 +-약 3만
            MEDIUMINT 3바이트 +-약 800만
            INT 4바이트 +-약 21억
            BIGINT 5바이트 +-약 21억 이상
        [실수 = 부동소수점 , 오차 존재]
			FLOAT	4바이트
            DOUBLE	8바이트
		[문자형태로 저장되는 숫자,오차없는 실수 표현]
        DECIMAL
        [날짜]
        DATE 날짜 표현 1000년~9999년 0000-00-00
        DATETIME 날짜와 시간 표현 0000-00-00 00:00:00
        TIME 시간 표현 0000:00:00
        [문자열]
        1.CHAR(문자길이)	: 고정길이 , 최대 1~255글자 char(5) --> "유재석" --> [유][재][석][][]
        2.VARCHAR(문자길이)	: 가변길이 , 최대 1~255글자 vachar(5) --> "유재석" --> [유][재][석] 남은 칸 미사용
        3.TEXT	: 최대 길이 6만개 글자 표현
        4.LONGTEXT	: 최대 길이 42억개 글자표현 (4GB)
        [논리]
			1.BOOL	: true 혹은 false 표현, 실제로는 0 또는 1로 표현
*/

# 테이블 예제1
use mydb1120;
# 게시물 테이블
# 1. 게시물의 내용물은 많은 양의 데이터를 저장할 예정이라서 longtext 타입 선택하고 속성명은 content
# 2. 게시물의 작성자는 아이디이므로 적당한 길이의 최대 30글자로 받을 예정이라서 varchar(30) 타입 선택하고 속성명은 writer
# 3. 게시물의 비밀번호는 숫자로 받을 예정이라서 적당한 정수 타입의 int 타입 속성 선택하고 속성명은 pwd
create table board(content longtext,writer varchar(30),pwd int);
# 테이블 확인
select * from board;
drop table if exists board; # 테이블 삭제

# 테이블 예제2
drop database if exists mydb1120; # 1. 데이터베이스가 존재하면 삭제
create database mydb1120; 		  # 2. 데이터베이스 생성
show databases;					  # 3. 데이터베이스 목록
use mydb1120;					  # 4. 데이터베이스 활성화/사용
drop table if exists member;	  # 5. 테이블이 존재하면 삭제
create table member
(정수필드1 tinyint,정수필드2 smallint,정수필드3 mediumint,정수필드4 int,정수필드5 bigint
,실수필드1 float,실수필드2 double,실수필드3 decimal,날짜필드1 date,날짜시간필드 datetime,시간필드 time
,문자열필드1 char(100),문자열필드2 varchar(100),문자열필드3 text,문자열필드4 longtext,논리필드 bool);

show tables;  # 7.테이블 목록 보기
select * from member; # 8. 지정된 테이블의 레코드 보기 # 현재 레코드가 없고 테이블만 생성된 상태

/* [SQL 과제] 키오스크 개발 - 필요한 데이터베이스 구축하기
	- 요구 사항
		1. 여러 개의 카테고리 중에 하나의 카테고리를 선택하여 카테고리별 제품들을 출력
        2. 해당 제품을 선택하여 수량 입력받아 주문처리 - 단 한번 주문에 여러개 제품을 주문 할 수 있다.
        3. 주문번호를 받아서 대기한다.
    - 메모리 설계 필수 필드 속성
		1.카테고리명 2.제품명 3.가격 4.주문수량 5.주문날짜
	- 핵심 : 여러 테이블을 구성할때는 테이블간의 데이터 중복을 최소화한다.

    - 제출 : 위 주제에 따른 데이터베이스와 테이블 생성을 하기 위한 SQL 제출