-- 한줄 주석
# 한줄 주석
/* 여러 주석 */

-- 명령어(;)단위 실행 : 커서두고 ctrl+enter
-- 전체명령어 실행 : ctrl+shift+enter

drop table board;
# 1. 데이터베이스 생성 -> 데이터(자료)들의 모임 , 데이터를 저장하기 위해서 사용
create database mydb1122;
# 2. 모든 데이터베이스 목록 확인
show databases;
# 3. 데이터베이스 활성화(여러 데이터베이스 중에 사용할 db를 선택)
use mydb1122;
# 4. 활성화된 데이터베이스에 테이블 생성
create table board(
	bnopk int unsigned auto_increment, # bno 게시물번호
    # bno 게시물번호 -> 숫자 -> 숫자중에 적절한 타입 -> int
    # auto_increment -> 레코드 삽입 시 자동으로 번호 순차적으로 할당 키워드
    # unsigned -> 부호가 없다 -> int(+-21억) 정도 -> 42억 정도
    bcontent varchar(100) not null,
    # longtext -> 긴 텍스트
    # not null -> 게시물 등록 시 게시물 내용은 꼭 공백이 아니면 좋을것 같아서
    bwriter varchar(100) not null, # varchar -> 작성자는 적절하게 100글자까지 입력받을 수 있게 선택
    bpwd int not null,
    primary key(bnopk)
    # primary key이란? 기본(식별)키 , 여러개의 필드 중에서 식별 가능한 필드, 중복x
	# 게시물번호를 pk로 사용하는 이유 -> 게시물 내용,작성자,비밀번호는 중복이 생길수도 있으니까.
    # 관례적(무조건x)으로 테이블마다 1개 이상의 pk(기본키) 필수,
);

# 5. DML : 데이터 조작어,코딩테스트,면접 <-

# 1. select : 레코드 조회 SQL

# select * form 테이블명; 				: 지정한 테이블의 모든 레코드 조회/검색
# select 필드명1,필드명2 from 테이블명;		: 지정한 테이블의 특정 필드의 레코드 조회/검색
select * from board;					# 지정한 테이블의 모든 필드 조회/검색
select bcontent,bwriter from board; 	# 지정한 테이블의 'bcontent'와 'bwriter' 필드들의 레코드 조회/검색

# 2. insert : 레코드 삽입/추가 SQL

# insert into 테이블명 values(값1,값2,값3); 전체 필드의 값 삽입시 삽입할 필드명을 생략해도 된다.
# insert into 테이블명([값1]필드명1,[값2]필드명2,[값3]필드명3) values(값1,값2,값3); : 특정 필드의 값만 삽입시 삽입할 필드명을 명시해야한다.
# board 테이블에 필드선언 순서대로 'bno'에는 1, 'bcontent'에는 안녕하세요, 'bwriter'에는 유재석,'bpwd'에는 1234 삽입
insert into board values(1,'안녕하세요','유재석',1234); # 1번 실행
# insert into board values('그래 안녕','강호동',4567); # 오류 발생,필드 개수와 데이터의 개수가 일치하지 않음.
insert into board(bcontent,bwriter,bpwd) values('그래안녕','강호동',4567); # 1번 실행

# 3. update : 특정 레코드의 필드값 수정 SQL

# update 테이블명 set 수정할 필드명 = 새로운값 where 조건필드 = 조건값
update board set bwriter = '신동엽' where bnopk = 1;
# 레코드 조건이 없으면 전체 수정

# 4. delete : 특정 레코드 삭제 SQL (한줄)

# 1. 지정한 테이블의 전체 레코드 삭제
# 	delete from 테이블명;
# 2. 지정한 테이블의 특정 조건을 충족하는 레코드만 삭제
#	delete from 테이블명 where 조건필드 = 조건값;
delete from board where bnopk = 1; # 만약 게시물번호가 1이면 데이터를 삭제
select * from board;

# [실습]
/*
[문제1] product 테이블에 새로운 제품을 추가하기
product_id : 201
product_name : 'wireless mouse'
category : 'Electronics'
price : 29.99
stock_quantity : 150
*/

insert into product value(201,'Wireless mouse','Electronics',29.99,150);

select first_name , email from employees;
select product_name , price from products where price = 1000;

update employees set employee_email = 'john.doe@company.com' where employee_id = 101;
update products set price= 24.99 where product_id = 201;

delete from employees where employee_id = 101;
delete from products where product_id = 201;