/*
  cafe_db.sql
	데이터베이스 생성 및 지정 
*/
create database IF NOT EXISTS cafe_db;
use cafe_db;

set foreign_key_checks = 0;   -- 외래키 체크하지 않는 것으로 설정
drop table IF EXISTS cafe_info cascade;   -- 기존 테이블 제거  
drop table IF EXISTS cafe_sen cascade;

set foreign_key_checks = 1;   -- 외래키 체크하는 것으로 설정


/*
  테이블 생성
*/

create table cafe_info (
	cafe_id integer not NULL,
	cafe_name varchar(20) NOT NULL, 
	cafe_place varchar(50) NOT NULL, 
	key1 int DEFAULT 0,
    key2 int DEFAULT 0,
    key3 int DEFAULT 0,
    key4 int DEFAULT 0,
    key5 int DEFAULT 0,
    key6 int DEFAULT 0,
	primary key (cafe_id));
    
create table cafe_sen (
	cafe_id integer NOT NULL,
    sen_key varchar(50) NOT NULL,
    key_num int NOT NULL,
	foreign key(cafe_id) references cafe_info(cafe_id));   
    
    
insert into cafe_info 
values(0,'홍대 투썸플레이스', '서울 마포구 월드컵북로2길 57 1층', 30,40,30,24,25,10);
insert into cafe_info 
values(1,'스타벅스 홍대공항철도역점', '서울 마포구 양화로 178', 100,20,40,54,15,10);
insert into cafe_info 
values(2,'엔젤리너스 L7홍대점', '서울 마포구 양화로 141 1, 2F 엔제리너스 L7홍대점', 200,30,30,24,115,120);

insert into cafe_sen
values(0,'엄청 조용해요',0);
insert into cafe_sen
values(0,'공부하기 좋은분위기',1);
insert into cafe_sen
values(0,'콘센트 많아요',2);
insert into cafe_sen
values(0,'책상 편해요',3);
insert into cafe_sen
values(0,'공간 넓어요',4);
insert into cafe_sen
values(0,'크로플 맛집인듯',5);

insert into cafe_sen
values(1,'조용해요',0);
insert into cafe_sen
values(1,'카공족들 많네요',1);
insert into cafe_sen
values(1,'콘센트가 많아 편해요',2);
insert into cafe_sen
values(1,'책상이 넓고 편해요',3);
insert into cafe_sen
values(1,'공간이 매우 넓어요',4);
insert into cafe_sen
values(1,'아아 맛집인듯',5);

insert into cafe_sen
values(2,'다들 조용히 공부하는거같아요',0);
insert into cafe_sen
values(2,'공부하기 딱 좋은 분위기',1);
insert into cafe_sen
values(2,'콘센트가 책상마다 있어요',2);
insert into cafe_sen
values(2,'책상이 넓고 편해요',3);
insert into cafe_sen
values(2,'공간이 생각보다 커요',4);
insert into cafe_sen
values(2,'민초 맛집인듯',5);