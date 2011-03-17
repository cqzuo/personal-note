视图的作用和定义
	封装了一条复杂的查询语句:CREATE OR REPLACE VIEW 视图名称 AS 查询语句
	删除VIEM:DROP VIEW 视图名称
	更新视图: UPDATE 视图名称 SET 字段=值 WHERE 查询条件
	创建一个不允许更改数据的视图:
	    ...WITH READ ONLY;--让视图只读,无法更改
		...WITH CHECK OPTION; --不允许更改创建视图的查询条件
例子: 创建一个部门20的所有成员的视图
CREATE OR REPLACE VIEW empv20 AS SELECT * FROM emp WHERE deptno=20;
	可以使用视图来封装一个查询
序列的使用 SEQUENCE
	实现在ORACLE中的自动增长列
	创建SEQUENCE: CREATE SEQUENCE 序列名
	序列中有两种操作来实现序列的自动增长功能
		currVal 当前取内容
		nextVal 下一个内容
例子:验证SEQUENCE的自动增长
CREATE SEQUENCE myseq;
CREATE TABLE testseq( curr NUMBER,nex NUMBER);
INSERT INTO testseq(curr,nex) VALUES(myseq.currVal,myseq.nextVal);
       设置自动增长的幅度: INCREMENT BY 幅度;
CREATE SEQUENCE myseq INCREMENT BY 3;
       删除序列: DROP SEQUENCE 序列名
       从指定数值开始增长:CREATE SEQUENCE 序列名 BY 增长幅度 START WITH 开始数值;
       循环序列: CREATE SEQUENCE 序列名 MAXVALUE 最大数值 INCREMENT BY 增长幅度  START WITH 开始数 CACHE 2 CYCLE;
POWERDESIGNER设计工具的使用 
同义词
	方便用户以一个名称来访问不同用户的表:CREATE SYNONYM 同义词 FOR 用户名.表名称;
例子:建立一个emp的同义词
CREATE SYNONYM emp FOR scott.emp;
       删除同义词:DROP SYNONYM emp;
用户管理
用超级管理员用户登陆 CONNECT scott/tiger AS sysdba;
   对用户进行建立和授权操作
	建立用户:CREATE USER 用户名  IDENTIFIED BY 密码;
	赋予用户session权限: GRANT CREATE SESSION TO 用户名;
	语法:GRANT 权限 TO 用户名;
   角色: 将多个权限赋予给一组用户
   	 CONNECT, RESOURCE
GRANT CONNECT,RESOURCE TO test;
       更改用户的密码: ALTER USER 用户名 IDENTIFIED BY 新密码;
       让用户失效: ALTER USER 用户名 PASSWORD EXPIRE;--让下一次用户在登陆系统时重新设定密码 
       锁定用户不让登陆: ALTER USER 用户名 ACCOUNT LOCK;
       为已锁定用户解锁: ACCOUNT USER 用户名 ACCOUNT UNLOCK;
       将访问某张表的权限赋予给用户: GRANT SELECT,DELETE ON 要访问的表名 TO 用户名称;]
       收回访问某张表的权限: REVOKE SELECT,DELETE ON 要访问的表名 FROM 用户名称;
数据库的备份
 新建一个目录文件-->进入目录-->输入命令:exp/imp 来开始备份或恢复备份
	EXP
	IMP	
嵌套表和人可变数组
	嵌套表:表中含有一个字表
例子: 先建立主表,再建立副表
CREATE TABLE delpartment
(
	deptno VARCHAR2(4) PRIMARY KEY NOT NULL,
	deptname VARCHAR2(20) not null
);
CREATE TABLE project
(
	proid VARCHAR2(4) PRIMARY KEY NOT NULL,
	proname VARCHAR2(20) NOT NULL,
	prodate DATE NOT NULL,
	deptno VARCHAR2(4),
	CONSTRAINT delpartment_project_deptno_fk FOREIGN KEY(deptno) ON DELETE CASCADE
);
常用的通常数据库建立方法
可以将子数据库作为一个主数据库的字段来实现数据库的嵌套
	1.创建数据库的类型:CREATE TYPE 数据类型表 AS OBJECT()
CREATE TYPE project_ty AS OBJECT
(
	proid VARCHAR2(4),
	proname VARCHAR2(20),
	prodate DATE,
	deptno VARCHAR2(4)
);
/
	2.建立数据类型的名称: CREATE TYPE 数据类型名称 AS TABLE OF 数据类型表
CREATE TYPE project_nt AS TABLE OF project_ty;--用project_nt表示数据类型project_ty
/
       3.使用嵌套表
CREATE TABLE department
{
	deptno VARCHAR2(4) PRIMARY KEY NOT NULL,
	deptname VARCHAR2(20) NOT NULL,
	projects project_nt
}NESTED  TABLE projects STORE AS project_nt_tab_temp;
	 对于插入数据需要制定每一个子表的字段
INSERT INTO department VALUES
(1,'技术部',project_nt
	(
		project_ty(001,'oa',SYSDATE),
		project_ty(002,'ORM',SYSDATE)
	)
);
	查询可以返回所有子表的信息
SELECT * FROM TABLE
(
	SELECT * FROM projects FROM department WHERE deptno=1
)

--创建测试表：

CREATE TABLE dept
　　(deptno NUMBER(2) PRIMARY KEY,
　　 dname VARCHAR2(14),
　　 loc VARCHAR2(13)
　　);
　　
CREATE TABLE emp
　　(empno NUMBER(4) PRIMARY KEY,
　　 ename VARCHAR2(10),
　　 job VARCHAR2(9),
　　 mgr NUMBER(4) REFERENCES emp,
　　 hiredate DATE,
　　 sal NUMBER(7,2),
　　 comm NUMBER(7,2),
　　 deptno NUMBER(2) REFERENCES dept
　　);
　　
INSERT INTO dept SELECT * FROM scott.dept;
INSERT INTO emp SELECT * FROM scott.emp;
/* 
	创建两个表dept和emp,将scott中的对应表复制到新创建的表中
 */
/*
	创建type格式:
	CREATE OR REPLACE TYPE 字表的类型名称 AS OBJECT(此种的数据都没有约束)
*/

CREATE OR REPLACE TYPE emp_type AS OBJECT
　　(empno NUMBER(4),
　　 ename VARCHAR2(10),
　　 job VARCHAR2(9),
　　 mgr NUMBER(4),
　　 hiredate DATE,
　　 sal NUMBER(7,2),
　　 comm NUMBER(7,2)
　　);
非得分
/*
	创建一个表类型的名称 
	CREATE OR REPLACE TYPE 表类型名 AS TABLE OF 表类型;
*/
CREATE OR REPLACE TYPE emp_tab_type AS TABLE OF emp_type;就

--使用嵌套表
/*
	在父表中使用已经定义好的表类型
	CREATE TABLE 父表名称
	(
		....
		子表名 表类型
	)
	NESTED TALBE 子表名 STROE AS 子表名_nest;
*/
CREATE TABLE dept_and_emp
　　(deptno NUMBER(2) PRIMARY KEY,
　　 dname VARCHAR2(14),
　　 loc VARCHAR2(13),
　　 emps emp_tab_type
　　)
　　NESTED TABLE emps STORE AS emps_nest;

--可以在嵌套表上增加约束(这里我们先不执行此步骤，等做完下一步测试我们再创建约束)
--ALTER TABLE emps_nt ADD CONSTRAINT emps_empno_unique
--嵌套表不支持参照完整性约束，不能参考任何其他表甚至自己
--给嵌套表增加数据，我们看看这两种方式的结果有何不同
方式1：
     INSERT INTO dept_and_emp
　　 SELECT dept.*, CAST
         (
　　		MULTISET(
				 SELECT empno, ename, job, mgr, hiredate, sal, comm 
			    	 FROM emp
　　 			    	 WHERE emp.deptno= dept.deptno
		          ) AS emp_tab_type 
	 )
　　 FROM dept;
--Oracle同样提供方法去掉集合的嵌套，像关系型表一样处理（能够将EMPS列当作一个表，并自然连接且不需要连接条件）：
SELECT d.deptno, d.dname, emp.* FROM dept_and_emp d, TABLE(d.emps) emp;
--这里执行看到结果是14条数据

delete from dept_and_emp;

方式2：INSERT INTO dept_and_emp
SELECT dept.*, CAST(MULTISET( SELECT empno, ename, job, mgr, hiredate, sal, comm
　　FROM
　　emp,dept
　　 WHERE emp.deptno
　　= dept.deptno ) AS emp_tab_type ) from dept;

SELECT d.deptno, d.dname, emp.* FROM dept_and_emp D, TABLE(d.emps) emp;
--这里执行看到结果是56条数据，显然是错误的

--第一个是按照where等连接条件符合的某一个dept的emp表的数据作为一个集合存储，而第二个没有任何关联条件，就是把所有emp的数据
--全部作为一个dept的数据存储，这个写法显然是错误的，如果我们把刚才讲的约束给嵌套表加上，就可以起到防止这种错误的功效了。

--增加约束再执行我们上边的第二个insert语句将会报错
--我们按照上边第一个insert语句插入数据，继续我们下边的测试。

--按照“每行实际是一张表”的思想来更新：
UPDATE TABLE( SELECT emps FROM dept_and_emp WHERE deptno = 10) SET comm = 100;

--插入与删除的语法：
　　INSERT INTO TABLE(SELECT emps FROM dept_and_emp WHERE deptno=10)
　　VALUES (1234,'NewEmp','Clerk',7782,SYSDATE,1200,NULL);
　　
　　DELETE FROM TABLE(SELECT emps FROM dept_and_emp WHERE deptno=20)
　　WHERE ename='SCOTT';

--一般而言，必须总是连接，而不能单独查询嵌套表（如emp_nest）中的数据，但是如果确实需要，是可以的。
数据库的设计范式
  第一范式: 数据表中的字段都是单一的不可再分的基本类型组成(整型实数字符型逻辑型日期型)
  第二范式:数据库中不存在非关键字段对任一关键字段的部分函数依赖