create table tbl_user(
   user_no char(6) primary key,
   user_name varchar(30) not null,
   user_pwd char(6) not null,
   create_time timestamp not null
);


create table tbl_survey_subject(
   subject_id int primary key auto_increment,
   subject_name varchar(100) not null,
   subject_ticket_cnt int default 0 not null,
   create_time datetime default now()
);

create table tbl_survey_item(
   item_id int primary key auto_increment,
   item_content varchar(100) not null,
   item_ticket_cnt int default 0 not null,
   create_time datetime default now(),
   subject_id int not null,
   constraint FK_SUBJECT_ITEM FOREIGN KEY (subject_id) references tbl_survey_subject(subject_id)
)

create table tbl_survey_log(
   log_id int primary key auto_increment,
   ip_addr varchar(30) not null,
   item_id int not null,
   create_time datetime default now(),
   constraint FK_ITEM_LOG FOREIGN KEY (item_id) references tbl_survey_item(item_id)  
)


