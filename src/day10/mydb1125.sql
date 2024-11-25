# 데이터베이스 생성
create database mydb1125; # db 생성
show databases; # db 목록 보기

# [TABLE]
use mydb1125; # 데이터베이스 활성화
drop table if exists board; # 만일 지정한 테이블이 존재하면 테이블 삭제
create table board(
	num int unsigned auto_increment , # 게시물의 번호. int 이용한 정수를 저장할 수 있다.
    content longtext, # 게시물의 내용, long text 이용한 최대 4G까지 저장할 수 있다.
    writer varchar(100) not null, # 게시물의 작성자, varchar(100) 이용한 최대 100글자까지 저장할 수 있다.
    pwd int, # 게시물의 비밀번호 , int 이용한 정수를 저장할 수 있다.
    primary key(num) # 기본키 지정
    );
show tables; # 모든 테이블 보기
select * from board;

# select :

# [게시물 등록 샘플 SQL]
# insert into 테이블명(필드명1,필드명2,필드명3)values(값1,값2,값3);
insert into board(content,writer,pwd)values('안녕','유재석','1234'); # SQL 작성
insert into board(content,writer,pwd)values(?,?,?); # JDBC에서 SQL 작성