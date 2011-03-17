1. 解释冷备份和热备份的不同点以及各自的优点
解答：热备份针对归档模式的数据库，在数据库仍旧处于工作状态时进行备份。而冷备份指在数据库关闭后，进行备份，适用于所有模式的数据库。热备份的优点在于当备份时，数据库仍旧可以被使用并且可以将数据库恢复到任意一个时间点。冷备份的优点在于它的备份和恢复操作相当简单，并且由于冷备份的数据库可以工作在非归档模式下,数据库性能会比归档模式稍好。（因为不必将archive log写入硬盘）

2.  你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？
解答：重建控制文件，用带backup control file 子句的recover 命令恢复
数据库。 

3.  如何转换init.ora到spfile?
解答：使用create spfile from pfile 命令

4.  解释data block , extent 和 segment的区别（这里建议用英文术语） 
解答：data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一个数据库对象

拥有的所有extents被称为该对象的segment.


5.  给出两个检查表结构的方法
解答：1。DESCRIBE命令 
2． DBMS_METADATA.GET_DDL 包

6.    怎样查看数据库引擎的报错
解答：alert log.

7.    比较truncate和delete 命令
解答：两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要 rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.

8.    使用索引的理由
解答：快速访问表中的data block

9.    给出在STAR SCHEMA中的两种表及它们分别含有的数据
解答：Fact tables 和dimension tables.  fact table 包含大量的主要的信息而 dimension tables 存放对fact table 某些属性描述的信息

10.  FACT Table上需要建立何种索引？
解答：位图索引 （bitmap index）

11. 给出两种相关约束?
解答：主键和外键

12. 如何在不影响子表的前提下，重建一个母表
解答：子表的外键强制实效，重建母表，激活外键

13. 解释归档和非归档模式之间的不同和它们各自的优缺点
解答：归档模式是指你可以备份所有的数据库 transactions并恢复到任意一个时间点。非归档模式则相反，不能恢复到任意一个时间点。但是非归档模式可以带来数据库性能上的少许提高

14. 如何建立一个备份控制文件？
解答：Alter database backup control file to trace.

15. 给出数据库正常启动所经历的几种状态 ?
解答：
STARTUP NOMOUNT – 数据库实例启动
STARTUP MOUNT      -  数据库装载
STARTUP OPEN          – 数据库打开

16. 哪个column可以用来区别V$视图和GV$视图?
解答： INST_ID 指明集群环境中具体的 某个instance 。

17. 如何生成explain plan?
解答： 
运行utlxplan.sql. 建立plan 表
针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table
运行utlxplp.sql 或 utlxpls.sql察看explain plan

18. 如何增加buffer cache的命中率？
解答：在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice . 如果有必要更改，可以使用 alter system set db_cache_size 命令


19. ORA-01555的应对方法？
解答：具体的出错信息是snapshot too old within rollback seg , 通常可以通过
增大rollback seg来解决问题。当然也需要察看一下具体造成错误的SQL文本

20. 解释$ORACLE_HOME和$ORACLE_BASE的区别？
解答：ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品
的目录。

21. 如何判断数据库的时区？
解答：SELECT DBTIMEZONE FROM DUAL;

22. 解释GLOBAL_NAMES设为TRUE的用途
解答：GLOBAL_NAMES指明联接数据库的方式。如果这个参数设置为TRUE,
在建立数据库链接时就必须用相同的名字连结远程数据库

23。如何加密PL/SQL程序？
解答：WRAP

24. 解释FUNCTION,PROCEDURE和PACKAGE区别
解答：function 和procedure是PL/SQL代码的集合，通常为了完成
一个任务。procedure 不需要返回任何值而function将返回一个值
在另一方面，Package是为了完成一个商业功能的一组function和proceudre
的集合

25. 解释TABLE Function的用途
解答：TABLE Function是通过PL/SQL逻辑返回一组纪录，用于
普通的表/视图。他们也用于pipeline和ETL过程。

26.  举出3种可以收集three advisory statistics
解答：Buffer Cache Advice, Segment Level Statistics,  Timed Statistics

27.  Audit trace 存放在哪个oracle目录结构中?
解答：unix $ORACLE_HOME/rdbms/audit
Windows the event viewer

28.  解释materialized views的作用
解答：Materialized views 用于减少那些汇总，集合和分组的
信息的集合数量。它们通常适合于数据仓库和DSS系统。

29.  当用户进程出错，哪个后台进程负责清理它
解答： PMON

30.  哪个后台进程刷新materialized views?
解答：The Job Queue Processes.

31.  如何判断哪个session正在连结以及它们等待的资源？
解答：V$SESSION / V$SESSION_WAIT

32.  描述什么是 redo logs
解答：Redo Logs 是用于存放数据库数据改动状况的物理和逻辑结构。
可以用来修复数据库.

33.  如何进行强制LOG SWITCH?
解答：ALTER SYSTEM SWITCH LOGFILE;

34. 举出两个判断DDL改动的方法？
解答：你可以使用 Logminer 或 Streams

35.  Coalescing做了什么？
解答：Coalescing针对于字典管理的tablespace进行碎片整理，将
临近的小extents合并成单个的大extent.

36.  TEMPORARY tablespace和PERMANENT tablespace 的区别是？
解答：A temporary tablespace 用于临时对象例如排序结构而 permanent tablespaces
用来存储那些'真实'的对象(例如表，回滚段等）

37.  创建数据库时自动建立的tablespace名称？
解答：SYSTEM tablespace.

38.  创建用户时，需要赋予新用户什么权限才能使它联上数据库。
解答：CONNECT

39.  如何在tablespace里增加数据文件？
解答：ALTER TABLESPACE ADD DATAFILE SIZE 

40.  如何变动数据文件的大小？
解答：ALTER DATABASE DATAFILE RESIZE ;

41.  哪个VIEW用来检查数据文件的大小？
解答： DBA_DATA_FILES

42.  哪个VIEW用来判断tablespace的剩余空间
解答：DBA_FREE_SPACE

43.  如何判断谁往表里增加了一条纪录？
解答：auditing

44. 如何重构索引？
解答： ALTER INDEX REBUILD;

45. 解释什么是Partitioning（分区） 以及它的优点。
解答：Partition将大表和索引分割成更小，易于管理的分区。

46.  你刚刚编译了一个PL/SQL Package但是有错误报道，如何显示出错信息？
解答：SHOW ERRORS

47.  如何搜集表的各种状态数据？
解答： ANALYZE
The ANALYZE command.

48. 如何启动SESSION级别的TRACE
解答:  DBMS_SESSION.SET_SQL_TRACE
ALTER SESSION SET SQL_TRACE = TRUE;

49.  IMPORT和SQL*LOADER 这2个工具的不同点
解答：这两个ORACLE工具都是用来将数据导入数据库的。
区别是：IMPORT工具只能处理由另一个ORACLE工具EXPORT生成
的数据。而SQL*LOADER可以导入不同的ASCII格式的数据源

50。 用于网络连接的2个文件？
解答： TNSNAMES.ORA and SQLNET.ORA


---------------------------------------------
1、表：table1(FId,Fclass,Fscore),用最高效最简单的SQL列出各班成绩最高的列表，显示班级，成绩两个字段。 

select fclass,max(fscore) from table1 group by fclass,fid

2、有一个表table1有两个字段FID，Fno，字都非空，写一个SQL语句列出该表中一个FID对应多个不同的Fno的纪录。  

类如： 
101a1001 
101a1001 
102a1002 
102a1003 
103a1004 
104a1005 
104a1006 
105a1007 
105a1007 
105a1007 
结果： 
102a1002 
102a1003 
104a1005 
104a1006 

select t2.* from table1 t1, table1 t2 where t1.fid = t2.fid and t1.fno <> t2.fno;

3、有员工表empinfo 
( 
Fempno varchar2(10) not null pk, 
Fempname varchar2(20) not null, 
Fage number not null, 
Fsalary number not null 
); 
假如数据量很大约1000万条；写一个你认为最高效的SQL，用一个SQL计算以下四种人： 
fsalary>9999 and fage > 35 
fsalary>9999 and fage < 35 
fsalary <9999 and fage > 35 
fsalary <9999 and fage < 35 
每种员工的数量； 
select sum(case when fsalary > 9999 and fage > 35
then 1
else 0end) as "fsalary>9999_fage>35",
sum(case when fsalary > 9999 and fage < 35
then 1
else 0
end) as "fsalary>9999_fage<35",
sum(case when fsalary < 9999 and fage > 35
then 1
else 0
end) as "fsalary<9999_fage>35",
sum(case when fsalary < 9999 and fage < 35
then 1
else 0
end) as "fsalary<9999_fage<35"
from empinfo;
4、表A字段如下 
month person income 
月份 人员 收入 
要求用一个SQL语句（注意是一个）的处所有人（不区分人员）每个月及上月和下月的总收入 
要求列表输出为 
月份 当月收入 上月收入 下月收入 
MONTHS PERSON INCOME
---------- ---------- ----------200807 mantisXF 5000200806 mantisXF2 3500200806 mantisXF3 3000200805 mantisXF1 2000200805 mantisXF6 2200200804 mantisXF7 1800200803 8mantisXF 4000200802 9mantisXF 4200200802 10mantisXF 3300200801 11mantisXF 4600200809 11mantisXF 6800
11 rows selected
select months, max(incomes), max(prev_months), max(next_months)
from (select months,
incomes,
decode(lag(months) over(order by months),
to_char(add_months(to_date(months, 'yyyymm'), -1), 'yyyymm'), lag(incomes) over(order by months), 0) as prev_months, decode(lead(months) over(order by months), to_char(add_months(to_date(months, 'yyyymm'), 1), 'yyyymm'), lead(incomes) over(order by months), 0) as next_months from (select months, sum(income) as incomes from a group by months) aa) aaagroup by months;

MONTHS MAX(INCOMES) MAX(PREV_MONTHS) MAX(NEXT_MONTHS)---------- ------------ ---------------- ----------------200801 4600 0 7500200802 7500 4600 4000200803 4000 7500 1800200804 1800 4000 4200200805 4200 1800 6500200806 6500 4200 5000200807 5000 6500 0200809 6800 0 0

5，表B 
C1 c2 
2005-01-01 1 
2005-01-01 3 
2005-01-02 5 

要求的处数据 
2005-01-01 4 
2005-01-02 5 
合计 9 
试用一个Sql语句完成。 

 

select nvl(to_char(t02,'yyyy-mm-dd'),'合计'),sum(t01)from test 
group by rollup(t02)

6，数据库1，2，3 范式的概念与理解。 

7，简述oracle行触发器的变化表限制表的概念和使用限制，行触发器里面对这两个表有什么限制。 

8、oracle临时表有几种。 
临时表和普通表的主要区别有哪些，使用临时表的主要原因是什么？ 

9，怎么实现：使一个会话里面执行的多个过程函数或触发器里面都可以访问的全局变量的效果，并且要实现会话间隔离？ 

10，aa，bb表都有20个字段，且记录数量都很大，aa，bb表的X字段（非空）上有索引， 
请用SQL列出aa表里面存在的X在bb表不存在的X的值，请写出认为最快的语句，并解译原因。 

11，简述SGA主要组成结构和用途？ 

12什么是分区表？简述范围分区和列表分区的区别，分区表的主要优势有哪些？ 

13，背景：某数据运行在archivelog，且用rman作过全备份和数据库的冷备份， 
且所有的归档日志都有，现控制文件全部损坏，其他文件全部完好，请问该怎么恢复该数据库，说一两种方法。 

14，用rman写一个备份语句：备份表空间TSB，level 为2的增量备份。 

 

15，有个表a(x number(20),y number(20))用最快速高效的SQL向该表插入从1开始的连续的1000万记录。


1、表：table1(FId,Fclass,Fscore),用最高效最简单的SQL列出各班成绩最高的列表，显示班级，成绩两个字段。 

2、有一个表table1有两个字段FID，Fno，字都非空，写一个SQL语句列出该表中一个FID对应多个不同的Fno的纪录。 
类如： 
101 a1001 
101 a1001 
102 a1002 
102 a1003 
103 a1004 
104 a1005 
104 a1006 
105 a1007 
105 a1007 
105 a1007 
结果： 
102 a1002 
102 a1003 
104 a1005 
104 a1006 

3、有员工表empinfo 
( 
Fempno varchar2(10) not null pk, 
Fempname varchar2(20) not null, 
Fage number not null, 
Fsalary number not null 
); 
假如数据量很大约1000万条；写一个你认为最高效的SQL，用一个SQL计算以下四种人： 
fsalary>9999 and fage > 35 
fsalary>9999 and fage < 35 
fsalary<9999 and fage > 35 
fsalary<9999 and fage < 35 
每种员工的数量； 

4、表A字段如下 
month person income 
月份 人员 收入 
要求用一个SQL语句（注意是一个）的处所有人（不区分人员）每个月及上月和下月的总收入 
要求列表输出为 
月份 当月收入 上月收入 下月收入 


5，表B 
C1 c2 
2005-01-01 1 
2005-01-01 3 
2005-01-02 5 

要求的处数据 
2005-01-01 4 
2005-01-02 5 
合计 9 
试用一个Sql语句完成。 


6，数据库1，2，3 范式的概念与理解。 

7，简述oracle行触发器的变化表限制表的概念和使用限制，行触发器里面对这两个表有什么限制。 

8、oracle临时表有几种。 
临时表和普通表的主要区别有哪些，使用临时表的主要原因是什么？ 

9，怎么实现：使一个会话里面执行的多个过程函数或触发器里面都可以访问的全局变量的效果，并且要实现会话间隔离？ 

10，aa，bb表都有20个字段，且记录数量都很大，aa，bb表的X字段（非空）上有索引， 
请用SQL列出aa表里面存在的X在bb表不存在的X的值，请写出认为最快的语句，并解译原因。 

11，简述SGA主要组成结构和用途？ 

12什么是分区表？简述范围分区和列表分区的区别，分区表的主要优势有哪些？ 

13，背景：某数据运行在archivelog，且用rman作过全备份和数据库的冷备份， 
且所有的归档日志都有，现控制文件全部损坏，其他文件全部完好，请问该怎么恢复该数据库，说一两种方法。 

14，用rman写一个备份语句：备份表空间TSB，level 为2的增量备份。 

15，有个表a(x number(20),y number(20))用最快速高效的SQL向该表插入从1开始的连续的1000万记录。 


答案：
1、select Fclass,max(Fscore) from table1 group by Fclass
2、select * from table1 where FID in (select FID from table1 group by FID having (count(Distinct Fno))>=2)
3、select sum(case when fsalary>9999 and fage>35 then 1 else 0 end),
sum(case when fsalary>9999 and fage<35 then 1 else 0 end),
sum(case when fsalary<9999 and fage>35 then 1 else 0 end),
sum(case when fsalary<9999 and fage<35 then 1 else 0 end) from empinfo
4、 
Select (Select Month From Table Where Month = To_Char(Sysdate, 'mm')) 月份,
(Select Sum(Income) From Table Where Month = To_Char(Sysdate, 'mm')) 当月收入,
(Select Sum(Income) From Table Where To_Number(Month) = To_Number(Extract(Month From Sysdate)) - 1) 上月收入,
(Select Sum(Income) From Table Where To_Number(Month) = To_Number(Extract(Month From Sysdate)) + 1) 下月收入
From Dual

5、select nvl(c1,'合计'),sum(c2) from B group by rollup(c1)
6.
关系数据库设计之时是要遵守一定的规则的。尤其是数据库设计范式 
简单介绍1NF（第一范式），2NF（第二范式），3NF（第三范式），
第一范式（1NF）：在关系模式R中的每一个具体关系r中，如果每个属性值 都是不可再分的最小数据单位，则称R是第一范式的关系。
例：如职工号，姓名，电话号码组成一个表（一个人可能有一个办公室电话 和一个家里电话号码） 规范成为1NF有三种方法： 
　　一是重复存储职工号和姓名。这样，关键字只能是电话号码。 
　　二是职工号为关键字，电话号码分为单位电话和住宅电话两个属性 
　　三是职工号为关键字，但强制每条记录只能有一个电话号码。 
　　以上三个方法，第一种方法最不可取，按实际情况选取后两种情况。 
　第二范式（2NF）：如果关系模式R（U，F）中的所有非主属性都完全依赖于任意一个候选关键字，则称关系R 是属于第二范式的。 
　　例：选课关系 SCI（SNO，CNO，GRADE，CREDIT）其中SNO为学号， CNO为课程号，GRADEGE 为成绩，CREDIT 为学分。 由以上 
条件，关键字为组合关键字（SNO，CNO） 
　　在应用中使用以上关系模式有以下问题： 
　　a.数据冗余，假设同一门课由40个学生选修，学分就 重复40次。 
　　b.更新异常，若调整了某课程的学分，相应的元组CREDIT值都要更新，有可能会出现同一门课学分不同。 
　　c.插入异常，如计划开新课，由于没人选修，没有学号关键字，只能等有人选修才能把课程和学分存入。 
　　d.删除异常，若学生已经结业，从当前数据库删除选修记录。某些门课程新生尚未选修，则此门课程及学分记录无法保存。 
　　原因：非关键字属性CREDIT仅函数依赖于CNO，也就是CREDIT部分依赖组合关键字（SNO，CNO）而不是完全依赖。 
　　解决方法：分成两个关系模式 SC1（SNO，CNO，GRADE），C2（CNO，CREDIT）。新关系包括两个关系模式，它们之间通过SCN中
的外关键字CNO相联系，需要时再进行自然联接，恢复了原来的关系 
　第三范式（3NF）：如果关系模式R（U，F）中的所有非主属性对任何候选关键字都不存在传递信赖，则称关系R是属于第三范式的。 
　　例：如S1（SNO，SNAME，DNO，DNAME，LOCATION） 各属性分别代表学号， 
　　姓名，所在系，系名称，系地址。 
　　关键字SNO决定各个属性。由于是单个关键字，没有部分依赖的问题，肯定是2NF。但这关系肯定有大量的冗余，有关学生所在的几个
属性DNO，DNAME，LOCATION将重复存储，插入，删除和修改时也将产生类似以上例的情况。 
　　原因：关系中存在传递依赖造成的。即SNO -> DNO。 而DNO -> SNO却不存在，DNO -> LOCATION, 因此关键辽 SNO 对 LOCATIO
N 函数决定是通过传递依赖 SNO -> LOCATION 实现的。也就是说，SNO不直接决定非主属性LOCATION。 
　　解决目地：每个关系模式中不能留有传递依赖。 
　　解决方法：分为两个关系 S（SNO，SNAME，DNO），D（DNO，DNAME，LOCATION） 
　　注意：关系S中不能没有外关键字DNO。否则两个关系之间失去联系。

7.
变化表mutating table
被DML语句正在修改的表
需要作为DELETE CASCADE参考完整性限制的结果进行更新的表也是变化的

限制:对于Session本身，不能读取正在变化的表

限制表constraining table
需要对参考完整性限制执行读操作的表 

限制:如果限制列正在被改变，那么读取或修改会触发错误，但是修改其它列是允许的。

8.
在Oracle中，可以创建以下两种临时表： 
a。会话特有的临时表 
CREATE GLOBAL TEMPORARY ( ) 
ON COMMIT PRESERVE ROWS； 

b。事务特有的临时表 
CREATE GLOBAL TEMPORARY ( ) 
ON COMMIT DELETE ROWS； 
CREATE GLOBAL TEMPORARY TABLE MyTempTable 
所建的临时表虽然是存在的，但是你试一下insert 一条记录然后用别的连接登上去select，记录是空的，明白了吧。
下面两句话再贴一下： 
--ON COMMIT DELETE ROWS 说明临时表是事务指定，每次提交后ORACLE将截断表（删除全部行） 
--ON COMMIT PRESERVE ROWS 说明临时表是会话指定，当中断会话时ORACLE将截断表。

9.--个人理解就是建立一个包,将常量或所谓的全局变量用包中的函数返回出来就可以了,摘抄一短网上的解决方法
Oracle数据库程序包中的变量，在本程序包中可以直接引用，但是在程序包之外，则不可以直接引用。对程序包变量的存取，可以为每个变量配套相应的存储过程<用于存储数据>和函数<用于读取数据>来实现。 
　　
　　3.2 实例 
　　--定义程序包 
　　create or replace package PKG_System_Constant is 
　　
　　　 C_SystemTitle nVarChar2(100):='测试全局程序变量';　--定义常数 
　　　 --获取常数<系统标题> 
　　　 Function FN_GetSystemTitle 
　　　　　Return nVarChar2; 
　　
　　　 G_CurrentDate Date:=SysDate; --定义全局变量 
　　　 --获取全局变量<当前日期> 
　　　 Function FN_GetCurrentDate 
　　　　　Return Date; 
　　　 --设置全局变量<当前日期> 
　　　 Procedure SP_SetCurrentDate 
　　　　　(P_CurrentDate In Date); 
　　End PKG_System_Constant; 
　　/ 
　　create or replace package body PKG_System_Constant is 
　　　 --获取常数<系统标题> 
　　　 Function FN_GetSystemTitle 
　　　　　Return nVarChar2 
　　　　　Is 
　　　　　Begin 
　　　　　　 Return C_SystemTitle; 
　　　　　End FN_GetSystemTitle; 
　　
　　　 --获取全局变量<当前日期> 
　　　 Function FN_GetCurrentDate 
　　　　　Return Date 
　　　　　Is 
　　　　　Begin 
　　　　　　 Return G_CurrentDate; 
　　　　　End FN_GetCurrentDate; 
　　　 --设置全局变量<当前日期> 
　　　 Procedure SP_SetCurrentDate 
　　　　　(P_CurrentDate In Date) 
　　　　　Is 
　　　　　Begin 
　　　　　　 G_CurrentDate:=P_CurrentDate; 
　　　　　End SP_SetCurrentDate; 
　　End PKG_System_Constant; 
　　/ 
　　　　
　　3.3 测试 
　　--测试读取常数 
　　Select PKG_System_Constant.FN_GetSystemTitle From Dual;　　　 
　　--测试设置全局变量 
　　Declare　
　　Begin 
　　　 PKG_System_Constant.SP_SetCurrentDate(To_Date('2001.01.01','yyyy.mm.dd')); 
　　End; 
　　/ 
　　--测试读取全局变量 
　　Select PKG_System_Constant.FN_GetCurrentDate From Dual;

10.
select aa.x from aa
where not exists (select 'x' from bb where aa.x = bb.x) ;
以上语句同时使用到了aa中x的索引和的bb中x的索引

11
SGA是Oracle为一个实例分配的一组共享内存缓冲区，它包含该实例的数据和控制信息。SGA在实例启动时被自动分配，当实例关闭时被收回。数据库的所有数据操作都要通过SGA来进行。 
SGA中内存根据存放信息的不同，可以分为如下几个区域：
a.Buffer Cache：存放数据库中数据库块的拷贝。它是由一组缓冲块所组成，这些缓冲块为所有与该实例相链接的用户进程所共享。缓冲块的数目由初始化参数DB_BLOCK_BUFFERS确定，缓冲块的大小由初始化参数DB_BLOCK_SIZE确定。大的数据块可提高查询速度。它由DBWR操作。 
b. 日志缓冲区Redo Log Buffer：存放数据操作的更改信息。它们以日志项（redo entry）的形式存放在日志缓冲区中。当需要进行数据库恢复时，日志项用于重构或回滚对数据库所做的变更。日志缓冲区的大小由初始化参数LOG_BUFFER确定。大的日志缓冲区可减少日志文件I/O的次数。后台进程LGWR将日志缓冲区中的信息写入磁盘的日志文件中，可启动ARCH后台进程进行日志信息归档。 
c. 共享池Shared Pool：包含用来处理的SQL语句信息。它包含共享SQL区和数据字典存储区。共享SQL区包含执行特定的SQL语句所用的信息。数据字典区用于存放数据字典，它为所有用户进程所共享。 

12.
使用分区方式建立的表叫分区表

范围分区 
每个分区都由一个分区键值范围指定（对于一个以日期列作为分区键的表，“2005 年 1 月”分区包含分区键值为从“2005 年 1 月 1 日” 
到“2005 年 1 月 31 日”的行）。 

列表分区 
每个分区都由一个分区键值列表指定（对于一个地区列作为分区键的表，“北美”分区可能包含值“加拿大”“美国”和“墨西哥”）。 

分区功能通过改善可管理性、性能和可用性，从而为各式应用程序带来了极大的好处。通常，分区可以使某些查询以及维护操作的性能大大提高。此外,分区还可以极大简化常见的管理任务。通过分区,数据库设计人员和管理员能够解决前沿应用程序带来的一些难题。分区是构建千兆字节数据系统或超高可用性系统的关键工具。


13
回复的方法:
一.使用冷备份,直接将冷备份的文件全部COPY到原先的目录下,在从新启动数据库就可以
二.使用归档日志,
1.启动数据库NOMOUNT
2.创建控制文件,控制文件指定数据文件和重做日志文件的位置.
3.使用RECOVER DATABASE using backup controlfile until cancel 命令回复数据库,这时可以使用归档日志
4.ALETER DATABASE OPEN RESETLOGS;
5.重新备份数据库和控制文件

14的话参考RMAN的使用手册

