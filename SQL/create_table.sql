CREATE DATABASE IF NOT EXISTS school;
USE school;

DROP TABLE IF EXISTS student;
CREATE TABLE Student
(
	s_id VARCHAR(20) UNIQUE,
	s_name VARCHAR(20) NOT NULL DEFAULT '',
	s_birth VARCHAR(10) NOT NULL DEFAULT '',
	s_sex VARCHAR(10) NOT NULL DEFAULT '',
    PRIMARY KEY(s_id)
)DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS Course;
CREATE TABLE COURSE
(
	c_id VARCHAR(20),
    c_name VARCHAR(20) NOT NULL DEFAULT '',
    t_id VARCHAR(20) NOT NULL,
    PRIMARY KEY(c_id)
)DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS Teacher;
CREATE TABLE Teacher(
t_id VARCHAR(20),
t_name VARCHAR(20) NOT NULL DEFAULT '',
PRIMARY KEY(t_id)
)DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS Score;
CREATE TABLE Score(
s_id VARCHAR(20),
c_id VARCHAR(20),
s_score INT(3),
PRIMARY KEY(s_id, c_id)
)DEFAULT CHARSET=utf8;

-- 插入学生表测试数据
INSERT INTO Student VALUES('01', '赵雷','1990-01-01','男');
INSERT INTO Student VALUES('02', '钱电','1990-12-21','男');
INSERT INTO Student VALUES('03', '孙风','1990-05-20','男');
INSERT INTO Student VALUES('04', '李云','1990-08-06','男');
INSERT INTO Student VALUES('05', '周梅','1991-12-01','女');
INSERT INTO Student VALUES('06', '吴兰','1992-03-01','女');
INSERT INTO Student VALUES('07', '郑竹','1989-07-01','女');
INSERT INTO Student VALUES('08', '王菊','1990-01-20','女');

-- 教师表测试数据
INSERT INTO Teacher VALUES('01', '张三');
INSERT INTO Teacher VALUES('02', '李四');
INSERT INTO Teacher VALUES('03', '王五');

-- 课程表测试数据
insert into Course values('01' , '语文' , '02');
insert into Course values('02' , '数学' , '01');
insert into Course values('03' , '英语' , '03');

-- 成绩表测试数据 
insert into Score values('01' , '01' , 80);
insert into Score values('01' , '02' , 90);
insert into Score values('01' , '03' , 99);
insert into Score values('02' , '01' , 70);
insert into Score values('02' , '02' , 60);
insert into Score values('02' , '03' , 80);
insert into Score values('03' , '01' , 80);
insert into Score values('03' , '02' , 80);
insert into Score values('03' , '03' , 80);
insert into Score values('04' , '01' , 50);
insert into Score values('04' , '02' , 30);
insert into Score values('04' , '03' , 20);
insert into Score values('05' , '01' , 76);
insert into Score values('05' , '02' , 87);
insert into Score values('06' , '01' , 31);
insert into Score values('06' , '03' , 34);
insert into Score values('07' , '02' , 89);
insert into Score values('07' , '03' , 98);
