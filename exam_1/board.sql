﻿create table tbl_member (
 userid varchar(50) not null,
 userpw varchar(50) not null,
 username varchar(50) not null,
 email varchar(100),
 regdate timestamp default now(),
 updatedate timestamp default now(),
 primary key(userid)
);

drop table tbl_member;

delete from tbl_member;

select * from tbl_member;

show tables