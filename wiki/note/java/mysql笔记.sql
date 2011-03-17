--在SQL中创建一定大小的数据库
create database info----创建数据库，分配10兆空间，最大可扩展到100兆，并指明存储路径
on primary--指定存放数据文件
(
    name='info_date',--指定数据文件的逻辑名称
    filename='e:\info_date.mdf',--指定数据文件的操作系统文件名
    size=10,--指定文件大小
    maxsize=100,--指定文件最大可增加到大
    filegrowth=5
)
log on--指定存放日志文件
(
     name='info_log',--指定日志文件的逻辑名称
    filename='e:\info_date.ldf',--指定日志文件的操作系统文件名
    size=10,
    maxsize=100,
    filegrowth=5
)
--级连删除,级连更新
create table job
(
    jid int primary key,
    jname varchar(10),
)
go
create table dept
(
    deptid int primary key,
    dname varchar(10),
)
go
create table emp 
(
    eid int primary key,
    ename varchar(10),
    deptid int references dept(deptid) on delete cascade on update no action,--级联删除，不级联更新
    jid int references job(jid) on delete cascade on update cascade ,--级联删除，级联更新
)
--查询本月是什么天
---本月的最后一天
SELECT dateadd(ms,-3,DATEADD(mm, DATEDIFF(m,0,getdate())+1, 0)) 
----上个月的最后一天
SELECT dateadd(ms,-3,DATEADD(mm, DATEDIFF(mm,0,getdate()), 0)) 
--- 本月多少天
SELECT Day(dateadd(ms,-3,DATEADD(mm, DATEDIFF(m,0,getdate())+1, 0))) 
--创建自引用
CREATE TABLE emp_mgr (
   emp char(30) PRIMARY KEY,
    mgr char(30) NULL FOREIGN KEY REFERENCES emp_mgr(emp),
    NoOfReports int DEFAULT 0
)
--作连接右连接
/**//*内联接   仅显示两个联接表中的匹配行的联接*/
select * from g_pINNER JOIN goods on g_p.gid = goods.gid

/**//*左向外联接   
包括第一个命名表（"左"表，出现在 JOIN 子句的最左边）中的所有行。
不包括右表中的不匹配行。*/
select  *  from  g_p   LEFT OUTER JOIN goods   on  g_p.gid = goods.gid

/**//*右向外联接   
包括第二个命名表（"右"表，出现在 JOIN 子句的最右边）中的所有行。
不包括左表中的不匹配行。*/
select  *  from  g_p   right OUTER JOIN goods   on  g_p.gid = goods.gid

/**//*完整外部联接   包括所有联接表中的所有行，不论它们是否匹配.*/
select  *  from  g_p  full OUTER JOIN goods   on  g_p.gid = goods.gid

/**//*交叉联接   在这类联接的结果集内，两个表中每两个可能成对的行占一行。
不论它们是否匹配。*/
select  *  from  g_p CROSS JOIN goods   
--日期函数
********************************************************************************************************
* DATEADD--->DATEADD ( datepart , number, date )--->在向指定日期加上一段时间的基础上，返回新的 datetime 值。
*    select dateadd(month,11,getdate())
********************************************************************************************************* DATEDIFF--->DATEDIFF ( datepart , startdate , enddate ) --->返回跨两个指定日期的日期和时间边界数。 
*    select datediff(day,getdate(),'2006-02-13')
********************************************************************************************************
* DATENAME--->DATENAME ( datepart , date )--->返回代表指定日期的指定日期部分的字符串。
*    select datename(year,getdate())
********************************************************************************************************
* DATEPART--->DATEPART ( datepart , date ) --->返回代表指定日期的指定日期部分的整数。
*    select datepart(yy,getdate())
********************************************************************************************************* DAY--->DAY ( date ) --->返回代表指定日期的天的日期部分的整数。
*     select day(getdate())
********************************************************************************************************* YEAR--->YEAR ( date )--->返回表示指定日期中的年份的整数。
*       select year(getdate())
********************************************************************************************************
* MONTH--->MONTH ( date )--->返回代表指定日期月份的整数。
*    select month(getdate())
********************************************************************************************************
* GETDATE--->GETDATE ( )--->按 datetime 值的 Microsoft? SQL Server? 标准内部格式返回当前系统日期和时间。    
*    select getdate()
********************************************************************************************************
* GETUTCDATE--->GETUTCDATE()--->返回表示当前 UTC 时间（世界时间坐标或格林尼治标准时间）的 datetime 值。当前的 UTC 时间得自当前的本地时间和运行 SQL Server 的计算机操作系统中的时区设置。
*    select getutcdate()
********************************************************************************************************
--字符串函数
********************************************************************************************************
* ASCII--->ASCII ( character_expression ) --->返回字符表达式最左端字符的 ASCII 代码值。
*    select ascii('abcdef')
* CHAR--->CHAR ( integer_expression )--->将 int ASCII 代码转换为字符的字符串函数。
*    SELECT char(97)


4假设现在有表system.table1，表中有三个字段：id(数值型)、name（字符型）、age（数值型）写出SQL语句完成如下功能：在表中查出年龄大于20，且名字以“王”开头的记录，并且按照年龄的倒叙排列出来（年龄大的在前面）。
select * from system.table1 where age>20 and name like '王%' order by age DESC;

5 .创建CUSTOMERS表，字段为：ID：（非空，主键）bigint，NAME：（非空）varchar，AGE：int类型；创建ORDERS表，字段为：ID：（非空，主键，）bigint，ORDER_NUMBER：（非空）varchar，PRICE：double，CUSTOMER_ID ：（外键）bigint，设置级连删除；

create table CUSTOMERS
(
	id bigint not null primary key,
	name varchar(20) ,
	age int
);
create table ORDERS
(
       id bigint not null primary key,
       ORDER_NUMBER varchar( 20),
	PRICE double,
	CUSTOMER_ID
);
alter table ORDERS add constraint ORDERS foreign key (CUSTOMER_ID) references CUSTOMERS (CUSTOMER_ID) on delete cascade;
alter table ORDERS add constraint ORDERS foreign key (CUSTOMER_ID) references CUSTOMERS (CUSTOMER_ID)on delete cascade;
