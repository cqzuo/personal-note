1.sql server 关系数据库简介
    DBMS 关系数据管理系统；
    特点：
       提供数据仓库功能；支持xml；强大的基于Web的反洗；支持OLEDB和多种查询；支持分布式的分区视图；
 2.sql server的安装配置
    几种版本： 企业版(Enterprise Edition)；标准版(Standard Edition)；个人版(Personal Edition)；开发者版(Developer Edition;)；
    SQL Server2000有6个系统数据库：
           Master数据库，最重要的数据库；记录了SQL Server系统的所有信息；
           Model数据库，是所有用户数据库和Tempdb数据库的模板数据库，含有Master数据库的所有系统表的子集
           Msdb数据库是代理服务数据库，为警报任务调路和记录操作提供存储空间；
           Tempdb是一个临时数据库，它为所有的临时表，临时存储过程及其他临时操作提供存储空间；
           Pubs和Northwind数据库是两个实例数据库，他们是SQL SERVER的学习工具
      系统目录是描述SQL Server系统的数据库，基表，视图和索引等对象的结构的系统表组成
      几个重要的系统表：
           Sysobjects表　　SQL Server的主系统表sysobjects出现在每个数据库中，它对每个数据库对象含有一行记录；
           Syscolumns表    出现在master数据库和每个用户自定义的数据库中，它对基表或者视图的每个列和存储过程中的每个参数含有一行记录；
           Sysindexs表       出现在master数据库和每个用户自定义的数据库中，它对每个索引和没有聚簇索引的每个表含有一行记录，它还对包括文本图像数据的每个表含有一行记录
           Sysuser表          系统表sysuser出现在master数据库和每个用户自定义的数据库中，它对整个数据库中的没有用户用户组角色含有一行记录
           Sysdatabases表 对sql server系统上的每个系统数据库和用户自定义的数据库含有一行记录，它只对出现在master数据库中；
           Sysdepends表   系统表Sysdepends对表视图和存储过程之间的每个依赖关系含有一行记录，它出现在master数据库和每个用户自定义的数据库中；
           Sysconstraints表 对使用 CREATE TABLE或者 ALTER TABLE语句为数据库对象定义的每个完整性约束含有一行记录，它出现在master数据库和每个用户自定义的数据库中；
       几个重要工具：
           企业管理器 Microsoft Management Console 配置系统环境和管理SQL SERVER，层叠列表形式显示所有SQL SERVER对象
                             可执行操作  建立和管理数据库，建立与管理表视图存储过程触发程序角色规则默认值等数据对象；用户定义的数据类型；备份数据库和事务日志；设置警报；提供跨服务器的拖放控制操作；管理用户帐号；建立Transact-SQL命令语句；管理控制SQL Mail
           服务管理器  Service Manager 用来启动暂停继续和停止数据库服务器的实时系统
                             提供的服务  sql server/sql server agent/msdtc(microsoft distributed transaction coordianator)
           查询管理器  Query Analyzer 输入和执行Transaction-SQL语句，查看这些语句的结果，分析数据库中的数据
           分布式事务处理协调器 Distributed Transaction Coordinator  提供和管理不同服务器之间的分布式事务处理
           性能监视器  Performance Monitor 查看和统计server系统的运行情况，查找影响系统性能的主要因素
           导入和导出数据 Imput and Export Data 在OLE DB数据源之间复制数据
           SQL Server分析器 监督记录和检查SQL Server数据库的使用情况
           服务器网络实用工具 配置服务器端网络连接和设置相关参数
           客户器网络实用工具 配置客户器端网络连接和管理测定客户端网络库等
3.Transact-SQL语言的主要组成部分
      数据定义语言 DDL Data Definition Language
      数据操纵语言 DML Data Manipularion Language
      数据控制语言DCL Data Control Language
      系统存储过程 System Stored Procedure
4.数据定义语言
      定义和管理数据库对象 CREATE ALTER DROP等
      关系基表和视图
      数据类型： 整数(int 32) 短整数(smallint 16) 十进制(dec(m,n)) 浮点数(float 64) 定长字符串(char(n)) 变长字符串(varchar(n)) 日期(data) 时间(time)
      主键是唯一的不许重复的
      create database test_data_base/*建立一个名称为test_data_base的数据库*/
      create table test_table/*建立一个默认在master下的一个表，指明了列名及数据类型*/
      (column1 char(8),column2 int,column3 char(10))
      例子：create table 老师
                (
                  编号 char(5),姓名 char(24),性别 char(2),年龄 smallint,职称 char(8),primary key(编号)
                 );
                 create table 学生
                 (
                  学号 smallint not null,姓名 char(10),性别 char(4),年龄 int,primary key(学号)
                 );
                 create table 课程
                 (
                  课号 char(8) not null,课程 char(10),学时 smallint,学分 smallint,primary key(课号)
                 );
                 create table 成绩
                 (
                  学号 smallint not null,课号 char(8),成绩 smallint,primary key(学号，课号),foreign key(学号) references 学生 (学号),foreign key(课号) references 课程(课号)
                 );
     基表模式修改
        alter table [表的创建者.表名] add <列名> <类型>
        alter table  [表的创建者.表名] modify(表名 类型)
               例子：
                  alter table 老师 add 工资 smallint
     删除基表，sql无删除列命令             
         drop table [表的创建者.表名] cascade constrains /*强制删除*/
     补充定义主键
        alter table 表名 add primary key(列名)
5.ddl数据定义语言   
   create
     /*下面的例子将创建表S。*/
CREATE TABLE S
(
   sno  char(10)  NOT NULL       /*学号字段*/
         CONSTRAINT PK_sno PRIMARY KEY CLUSTERED/*主键约束*/
         CHECK (sno like '31300501[0-9][0-9]')/*检查约束*/,
   sname      char(8)     NULL, /*姓名字段*/
   sex     char(2)   NULL, /*性别字段*/
   age    int  NULL, /*年龄字段*/
   dept   varchar(20)   NULL/*系别字段*/
  )

   drop
    例3-3　删除S表
程序清单如下：

   DROP table S

   alter 
     例3-2 修改S表，增加一个班号列
程序清单如下：
ALTER TABLE S 
ADD
CLASS_NO CHAR(6) 
6.dml 数据操纵语言
   select
   insert
     INSERT语句用于向数据库表或者视图中加入一行数据。INSERT语句的语法形式如下：
   INSERT [INTO] table_or_view [(column_list)] VALUES(data_values)
其中，table_or_view是指要插入新记录的表或视图；column_list是可选项，指定待添加数据的列； VALUES子句指定待添加数据的具体值。列名的排列顺序不一定要和表定义时的顺序一致。但当指定列名表时VALUES子句值的排列顺序必须和列名表中的列名排列顺序一致，个数相等，数据类型一一对应。 
     在进行数据插入操作时须注意以下几点：
（1）必须用逗号将各个数据分开，字符型数据要用单引号括起来。
（2）INTO子句中没有指定列名，则新插入的记录必须在每个属性列上均有值，且VALUES子句中值的排列顺序要和表中各属性列的排列顺序一致。
（3）将VALUES子句中的值按照INTO子句中指定列名的顺序插入到表中。
（4）对于INTO子句中没有出现的列，则新插入的记录在这些列上将取空值，如上例的SCORE即赋空值。但在表定义时有NOT NULL约束的属性列不能取空值。 
  例子
    例3-5   创建SC表（学生选课表），并向SC表中插入一条选课记录（’S7’,’C1’）。
程序清单如下：
CREATE TABLE SC
(
   sno  char(10)  NOT NULL, 
   cno char(2)    NULL, /*课程编号字段*/
  score  numerical(4,1) NULL  /*成绩字段*/
  )
          Go
INSERT INTO SC (sno,cno) VALUES ('3130050101', 'c1')
Go
 例3-6   使用 column_list 及 VALUES 列表显式地指定将被插入每个列的值。
程序清单如下：
CREATE TABLE T1
 ( column_1 int, 
column_2 varchar(30)) 
Go
INSERT T1 (column_2, column_1) VALUES ('This is a test',1) 
插入多行数据的语法格式为：
INSERT INTO table_or_view [(column_list)] 子查询
例3-7   求出各位学生的平均成绩，把结果存放在新表AVGSCORE中。
程序清单如下：
/*首先建立新表AVGSCORE，用来存放学号和学生的平均成绩。*/
CREATE TABLE AVGSCORE
(SNO CHAR(10),
AVGSCORE SMALLINT) 
Go
/*利用子查询求出SC表中各位学生的平均成绩，把结果存放在新表AVGSCORE中。*/
INSERT INTO AVGSCORE
SELECT SNO,AVG(SCORE) 
FROM SC
GROUP BY SNO 


   update
   delete           