sql建表实例
 学生运动会比赛信息数据库
建表信息:
     1.运动员 sporter(运动员编号 sporterid;运动员姓名 sportername;运动员性别 sportersex;运动员所在系编号department)
     2.项目 iterm(项目编号 itermid ;项目名称 itermname;项目比赛地点 location)
     3.成绩 grade (运动员编号  sporterid;项目编号 itermid;积分 mark)
功能要求:
     1.定义各个表的主键外键约束
     2.运动员姓名和所属系别不能为空
     3.积分要么为空值,要么为6 4 2 0 分别代表第一第二第三和其他名次

CREATE TABLE sporter
(
        sporterid NUMBER(4) PRIMARY KEY NOT NULL,
        sportername VARCHAR2(20) NOT NULL,
        sportersex VARCHAR2(2) NOT NULL,
        department VARCHAR2(30) NOT NULL,
        CONSTARAINT sporter_sex_CK CHECK(sex IN('男','女')) 
);

CREATE TABLE iterm
(
        itermid NUMBER(4) PRIMARY KEY NOT NULL,
        itermname VARCHAR2(20) NOT NULL,
        location VARCHAR2(50) NOT NULL
);
CREATE TABLE grade
(
        sporterid NUMBER(4) PRIMARY KEY NOT NULL,
        itermid NUMBER(4) NOT NULL,
        mark NUMBER(3) NOT NULL
);
