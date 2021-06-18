CREATE SEQUENCE board_seq
increment by 1
start with 1
nocycle;

CREATE SEQUENCE group_seq
increment by 1
start with 1
nocycle;

CREATE TABLE board(
 idx NUMBER,
 writer VARCHAR2(100) NOT NULL,
 title VARCHAR2(100) NOT NULL,
 content CLOB,
 pwd VARCHAR2(20) NOT NULL,
 hit NUMBER NOT NULL,
 groups NUMBER NOT NULL,
 step NUMBER NOT NULL,
 lev NUMBER NOT NULL,
 regdate date NOT NULL,
 file_name VARCHAR2(50),
 CONSTRAINT board_pk PRIMARY KEY (idx)
);

 
