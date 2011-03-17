 浅析oracle嵌套表
/*
以前在做报表的时候会经常用到oracle的内存表(其实是oracle嵌套表的部分功能，这里在下边介绍)来提高性能。
利用oracle内存表进行临时运算通过ref cursor来返回我们想要的结果集。
open cur for select * from table(fun_to_table_rb1_1(cur_qc,cur_qm));
关于这部分的一些测试可以参看：http://www.itpub.net/showthread.php?threadid=617298

最近把oracle嵌套表的其他功能仔细看了看并做了个简单整理。

oracle提供两种使用嵌套表的方法：
1． PL/SQL代码中作为扩展PL/SQL语言；(这部分内容就是上边所说oracle内存表是oracle嵌套表的部分功能)
2． 作为物理存储机制，以持久地存储集合。
*/

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
--hint NESTED_TABLE_GET_REFS被用于EXP和IMP处理嵌套表。

　　SELECT /*+NESTED_TABLE_GET_REFS+*/ NESTED_TABLE_ID, SYS_NC_ROWINFO$ FROM emps_nest;

--而察看EMPS_NEST的结构看不到NESTED_TABLE_ID,SYS_NC_ROWINFO$两列。对父表DEPT_AND_EMP来说NESTED_TABLE_ID是一个外键。
--使用这个hint就可以直接操作嵌套表了：
　　UPDATE /*+NESTED_TABLE_GET_REFS+*/ emps_nest SET ename=INITCAP(ename);
　　
--嵌套表的存储:
--上例中，现实产生了两张表：

　　DEPT_AND_EMP
　　(deptnob NUMBER(2),
　　dname VARCHAR2(14),
　　loc VARCHAR2(13),
　　SYS_NC0000400005$,
RAW(16))
　　
　　EMPS_NEST
　　(SYS_NC_ROWINFO$,
　　NESTED_TABLE_ID,
RAW(16),
　　empno NUMBER(4),
　　ename VARCHAR2(10),
　　job VARCHAR2(9),
　　mgr NUMBER(4),
　　hiredate DATE,
　　sal NUMBER(7,2),
　　comm NUMBER(7,2))　
　
--默认情况下，每个嵌套表列都产生一个额外的RAW(16)隐藏列，并在其上创建了唯一约束，用以指向嵌套表。而嵌套表中有两个
--隐藏列：SYS_NC_ROWINFO$是作为一个对象返回所有标量元素的一个伪列；另一个NESTED_TABLE_ID的外键回指向父表。
--可以看到真实代码：

　　CREATE TABLE DEPT_AND_EMP
　　(DEPTNO NUMBER(2,0),
　　 DNAME VARCHAR2(14),
　　 LOC VARCHAR2(13),
　　 EMPS EMP_TAB_TYPE)
　　PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
　　LOGGING STORAGE(INITIAL 131072 NEXT 131072
　　MINEXTENTS 1 MAXEXTENTS 4096
　　PCTINCREASE 0 FREELISTS 1 FREELIST GROUP 1
　　BUFFER_POOL DEFAULT)
　　TABLESPACE USER
　　NESTED TABLE EMPS
　　STORE AS EMPS_NEST
　　RETURN BY VALUE;
　　
　　RETURN BY VALUE用来描述嵌套表如何返回到客户应用程序中。
　　NESTED_TABLE_ID列必须是索引的，那么较好的解决办法就是使用IOT存储嵌套表。
　　CREATE TABLE DEPT_AND_EMP
　　(DEPTNO NUMBER(2,0),
　　 DNAME VARCHAR2(14),
　　 LOC VARCHAR2(13),
　　 EMPS EMP_TAB_TYPE)
　　PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
　　LOGGING STORAGE(INITIAL 131072 NEXT 131072
　　MINEXTENTS 1 MAXEXTENTS 4096
　　PCTINCREASE 0 FREELISTS 1 FREELIST GROUP 1
　　BUFFER_POOL DEFAULT) TABLESPACE USER
　　NESTED TABLE EMPS
　　STORE AS EMPS_NEST
　　((empno NOT NULL,
UNIQUE(empno),
PRIMARY KEY(nested_table_id,empno))
　　ORGANIZATION
　　INDEX COMPRESS 1)
　　RETURN BY VALUE;
/*
　　这样与最初默认的嵌套表相比，使用了较少的存储空间并有最需要的索引。
　　不使用嵌套表作为永久存储机制的原因
　　1．增加了RAW(16)列的额外开销，父表和子表都将增加这个额外的列；
　　2．当通常已经有唯一约束时，父表上的唯一约束是额外开销；
　　3．没有使用不支持的结构（NESTED_TABLE_GET_REFS），嵌套表不容易使用。
　　一般推荐在编程结构和视图中使用嵌套表。如果要使用嵌套表作为存储机制，
确保嵌套表是IOT，以避免NESTED_TABLE_ID和嵌套表本身中索引的额外开销。
*/