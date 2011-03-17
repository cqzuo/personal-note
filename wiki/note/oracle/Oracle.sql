Oracle的历史
  Oracle 神谕
  Larry Ellison创办了Oracle公司

Oracle的安装
  注意防火墙问题干扰安装  
  数据库名称为以后的服务选项
  解锁操作
  口令管理 
    scott去掉解锁勾
    System和sys的密码设置
  em企业管理器(web版管理配置工具)
  两个服务必须启动
    TNSListener监听服务
    service数据库服务

SQLPLUS oracle提供的命令行执行工具
SQLPLUSW 窗口形式启动命令行工具(常用)
     主机字符串 数据库名称,不填是默认服务
设置行长度 set linesize 长度;
设置显示记录长度 set pagesize 每页的行数
ed 文件名称 通过一个sql文件来输入命令行
@文件名称 执行文件中的sql语句 如果文件名是sql,则不需要输入后缀名
@路径/文件名称 @d:\application\demo 

连接数据库
conn system/manager /*不允许用sys登陆*/
conn sys/change_on_install as sysdba /*一定要sys登陆,则以sysdba权限*/

访问别的用户的数据库表内容
 select * form scott.emp; /*表前加上用户名.*/

sqlplusw 查询当前用户
show user;

显示当前用户的数据库中所有表
select * from tab;

查询表结构
desc 表名;

常用数据类型
 NUMBER(4) 表示4位数字
 VARCHAR2(20) 20个长度的字符串
 DATE 日期
 NUMBER(7,2) 2位小数的7位有效数字的数

回显上次命令
/

SQL语句 数据库查询语言
  DML DDL DCL
 简单查询
   查询语句格式
    去除重复的查询列   SELECT DISTINCT 
    别名的使用 SELECT 列名 别名,... from ...
    加入字符串连接 select '标号:' eno||'的薪水是'||salary ...
 限定查询 WHERE 
    查询结果排序   ORDER BY ..,... ASC/ DESC /*默认升序*/
    多个条件排序 ORDER BY .... ASC,....DESC;
 单行函数 function name(columnl expression[args1,args2...])
  字符函数
	大小写 UPPER("..")/LOWER('..')   SELECT UPPER('smith') FROM DUAL;/SELECT * FROM emp where name=LOWER('SMITH');
	首字母大写 INITCAP('')  SELECT INITCAP(NAME) FROM EMP;
	字符串截取 SUBSTR()
	字符串长度 LENGTH()
	内容替换 REPLACE()
            SELECT SUBSTR('HELLOW',1,3) //从0或1都是一样的效果,ORACLE的智能
		   LENGTH('hellow')
		   REPLACE('HELLOW','H','O')
	    FROM DUAL;
	截取前后三个字符 SUBSTR('STRINGS',-3,3)

  数值函数
	四舍五入 ROUND() 
	     SELECT ROUND(1.23) FROM DUAL;//直接取整
	     SELECT ROUND(135.569,3) FROM DUAL; //取3位小数
	     SELECT ROUND(135.569,-3) FROM DUAL; //取3位整数并四舍五入
	截断小数位 TRUNC()
	     SELECT TRUNC(1235.565,2) FROM DUAL; //截取两位小数
	     SELECT TRUNC(1235.565,-2) FROM DUAL; //截取两位整数	
	取余 MOD
	     SELECT MOD(123,12) FROM DUAL; //取余
  日期函数 
	日期-/+函数->日期
	日期-日期->天数
	当前日期 SELECT SYSDATE FROM DUAL; SELECT ROUND((SYSDATE-hiredate)/7) FROM emp;
	指定日期间的月数 MONTHS_BETWEEN()  SELECT MONTHS_BETWEEN(sysdate-hiredate) FROM DUAL;
	指定日期加上月数后的日期 ADD_MONTH()  SELECT ADD_MONTH(hiredate,3) FROM emp;
	下一次给出的日期 NEXT_DAY()  SELECT NEXT_DAY()  SELECT NEXT_DAY(sysdate,'星期一') FROM DUAL;
	最后的日期 LAST_DAY()  SELECT LAST_DAY(SYSDATE) FROM DUAL;
  转换函数
	TO_CHAR  
		SELECT TO_CHAR(sysdate,'yyyy') 年份 TO_CHAR(sysdate,'mm')月份 TO_CHAR('dd')日期 FROM emp;
		SELECT TO_CHAR(sysdate,'yyyy--mm-dd') 日期 FROM emp;
		SELECT TO_CHAR(sysdate,'fmyyyy--mm-dd') 日期 FROM emp; /*消除个位数月份前的0*/
		SELECT TO_CHAR(salary,'$99,9999') 薪水 FROM emp; /*用$99,9999格式显示*/		
		SELECT TO_CHAR(salary,'L99,9999') 薪水 FROM emp; /*用本地货币99,9999格式显示*/
	TO_NUMBER
	TO_DATE   SELECT TO_DATE('2009-12-24','yyyy-mm-dd') FROM DUAL;
  通用函数
	NVL  将NULL转换为指定的值  SELECT NVL(列名,0), (salary+NVL(列名,0))*12 年薪 FROM emp;
	DECODE 相当于 if else语句  SELECT DECODE(1,'我是1',2,'我是2',3,'我是3') FROM DUAL;
        SELECT DECODE(job,'doctor','博士','killer','杀手'....) FROM emp;
判断是否为空 is null;is not null;
两个条件的连接 and or;
条件取反 SELECT .. FROM ... WHERE not(...);
指定范围 
   BETWEEN .. AND ...;
   IN(VALUE1,VALUE2....)
 排除某个范围
   NOT BETWEEN .. AND ...;
   NOT IN(...);          
日期的查询需要输入'' BETWEEN '10-25月 -90' AND '10-25月 -99'
Oracle对大小写敏感
模糊查找  LIKE /*无关键词查询全部*/
  % 任意长度内容
  _一个任意字符
 可以对日期数据进行 LIKE 查找
<> !== 不等于
/***********************************练习习题*************************************/
1.SELECT * 
   FROM emp
   WHERE dep_num==30;
2.SELECT name,id,dep_id
    FROM emp
    WHERE job==UPPER('CLERK');
3.SELECT * 
    FROM emp
    WHERE sary>num;
4.SELECT * 
    FROM emp
    WHERE sary>(num*0.6);
5.SELECT * FROM emp
    WHERE (eid=20 and 'CLERK'=UPPER(job)) 
        OR (eid=30 AND 'MANAGER'=UPPER(job))
        OR (job NOT IN('CLERK','MANAGER')) AND  salary>=5000;
6.SELECT DISTINCT job
    FROM emp
    WHERE salary IS NOT NULL OR salary<2000;
7.SELECT *
    FROM emp
    WHERE (LAST_DAY(hiredate)-hiredate)=2;
8.SELECT *
    FROM emp
    WHERE MONTHS_BETWEEN(sysdate,hiredate)/12>12;
9.SELECT INITCAP(name)
    FROM emp;
10.SELECT *
    FROM emp
    WHERE name LIKE '_____'; /*  WHERE LENGTH(name)=5 */
11.SELECT *
    FROM emp
    WHERE NOT(name LIKE '%R%'); /* WHERE name NOT LIKE '%r%' */
12.SELECT SUBSTR(name,0,3)
    FROM emp;
13.SELECT REPLACE(name,'a','A')
    FROM emp;
14.SELECT *
    FROM emp 
    ORDER BY name DESC;
15.SELECT *
    FROM emp 
    ORDER BY hiredate DESC; //按日期排序，日期越新越靠前
16.SELECT name ,TO_CHAR(hiredate,'mm') 月份,TO_CHAR(hiredate,'yyyy') 年份
    FROM emp
    ORDER BY TO_CHAR(hiredate,'mm'),TO_CHAR(hiredate,'yyyy');
/*******************************************************************************/

多表查询
	SELECT * FROM 表1，表2；
  查询表中的数据数  SELECT COUNT(*) FROM emp;
  
  多表查询会出现笛卡儿积(不建议使用)
  处理方法:使用字段关联操作
	SELECT * FROM 表1，表2 WHERE 表1.字段＝表2.字段；

别名的使用
   SELECT B1.name,B2.id.... FROM 表1 B1，表2 B2 WHERE B1.字段＝B2.字段；

自身关联查询
   SELECT e.ENAME,e.JOB,m.ENAME
   FROM emp e,emp m
   WHERE e.MGR=m.EMPNO
	
   SELECT e.name,e.salary,d.name,s.grade
   FROM emp e,dept d,salgrage s;/*从3张表中查询*/
   WHERE e.id=d.id AND e.salary BETWEEN s.losal AND s.hisal;/*两个关联字段联系3个表*/
 左右连接
   将多个表中的数据组合成一个表
   表名1.字段=表名2.字段(+)  左连接
   表名1.字段(+)=表名2.字段  右连接
   默认左连接
SQL1999对sql的支持
    交叉连接 cross join:(产生笛卡尔积)
             SELECT * FROM emp cross join dept;
    自然连接  natural join 自动关联
              SELECT * FROM emp natural join dept;
    using子句 直接关联  
              SELECT * FROM emp join dept using(deptno) where deptni=30;
    on 子句
              SELECT * FROM emp e join dept d on(e.deptno=d.deptno); 功能同using子句
    左/右连接
         right join 
              SELECT * FROM emp e right outer join dept d on(e.deptno=d.deptno);
         left join
分组统计和分组函数
   COUNT() 求出全部记录数，不是求和
           SELECT COUNT(emp) FROM emp;
   MAX() 最大值
           SELECT MAX(sal) FROM emp;
   MIN() 最小值
           SELECT MIN(sal) FROM emp;
   AVG() 平均值
           SELECT AVG(sal) FORM emp;
   SUM() 求和
           SELECT SUM(sal) FROM emp WHERE deptno=20;
   GROUP BY 语句
         SELECT deptno,COUNT(empno) FROM emp GROUP BY deptno;
         SELECT deptno,AVG(sal) FROM emp GROUP BY deptno;
      查询错误分析:
        程序存在group by，并指定了分组条件，这样可以将分组条件一起查询出来
        如果不使用分组函数，则只能单独的使用分组函数,分组条件和字段不能一起查询
        使用分组函数时不能出现分组函数和分组条件之外的字段
	分组函数不能出现在WHERE语句中,此时必须使用HAVING语句
          SELECT d.name,COUNT(e.empno) FROM dept d,emp e WHERE d.deptno=e.deptno GROUP BY d.dname;
显示非销售人员工作名称以及从事同一工作的雇员每月工资总和,并且要满足从事同一工作的雇员的月工资综合大于5000，结果按工资合计的升序排序
	SELECT job FROM emp WHERE job<>'SALSMEN';
	SELECT SUM(sal) FROM emp GROUP BY job;
	SELECT job,SUM(sal) FROM emp WHERE job<>'SALSMAN' GROUP BY job;
	SELECT job,SUM(sal) su  FROM emp WHERE job<>'SALSMAN' GROUP BY job HAVING SUM(sal)>5000 ORDER BY su ASC;
       分组的原则:
         存在一个以上的重复内容时使用分组
	 分组函数可以嵌套使用,但是在组函数嵌套使用时不能再出现分组条件的查询语句
查询平均工资最高的部门的工资
	 SELECT MAX(SUM(sal)) FROM emp GROUP BY deptno; //ok
	 SELECT deptno,MAX(SUM(sal)) FROM emp GROUP BY deptno; //error
复杂子查询
  在一个查询的内部包含另一个查询
  子查询都在（）中
  分类:
	单列查询 返回一个列的内容
	单行查询 返回多个列的内容
	多行查询 返回多行内容
工资比7653更高的雇员的信息
	SELECT * FROM emp WHERE sal>(SELECT sal FROM emp WHERE deptno=7653);
工资比7652高,并且与7653同一个工作的所有雇员
	SELECT * FROM emp WHERE sal>(SELECT sal FROM emp WHERE deptno=7653) AND job=(SELECT job FROM emp WHERE job='7653');
工资最低的雇员信息
	SELECT name sal FROM emp WHERE sal=(SELECT MIN(sal) FROM emp);
要求查询出部门名称部门的员工数部门的平均工资部门的最低和最高收入雇员的姓名
	SELECT deptno,COUNT(deptno),AVG(sal) FROM dept GROUP BY deptno;
	SELECT d.dname,ed.c,ed.a FROM dept d,(SELECT deptno,COUNT(deptno) c,AVG(sal) a FROM dept GROUP BY deptno) ed WHERE d.deptno=ed.deptno;
	SELECT d.dname,ed.c,ed.a e.name FROM dept d,(SELECT deptno,COUNT(deptno) c,AVG(sal) a, MIN(sal) min FROM dept GROUP BY deptno) ed WHERE d.deptno=ed.deptno AND e.sal=ed.min;
子查询的相关符号
	IN(查询一个范围)  ANY(=ANY相当于 IN;>ANY 比任意一个数值大) ALL(>ALL比其中所有的都大)
查询每个部门的最低工资雇员信息
	SELECT * FROM emp WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);
	SELECT * FROM emp WHERE sal =ANY (SELECT MIN(sal) FROM emp GROUP BY deptno);
数据库的更新
	INSERT UPDATE DELETE(增删改)
 数据库中表的复制
   CREATE TABLE tableName AS SELECT * FROM TargetTable;
 增加数据 INSERT INTO tableName(字段) VALUE(数值);
   数字不用加单引号,但是字符必须加单引号
   缩略写法可以不用写字段名
   缩写时相应位置如果没有数据,可以用null补齐
	INSERT INTO myemp VALUES(123,'你好',null,null,null); 
   插入数据时,日期用TO_DATE('','yyyy-mm-dd')方法转换
 数据修改
   UPDATE 表名 SET 字段名＝值，字段名＝值 WHERE 修改条件;
 修改编号为1的雇员工资为12222；
  UPDATE myemp SET sal=12222 WHERE empno=1;
 取消1 2 3 的工资
 UPDATE myemp SET sal=NULL WHERE empno IN (1,2,3);
删除表
  删除整个表 DELETE FROM 表名；DROP 表名； DROP TABLE 表名；
  删除表  DELETE FROM 表名 WHERE 条件；
事务处理和数据库死锁
创建一个只包含10部门的临时表
 CREATE TABLE emp10 AS SELECT * FROM emp WHERE empno=10;

事务处理 为了保证数据操作的完整性，所有操作要么一起操作成功，要么一起失败
两个事务处理： 
COMMIT;
ROLLBACK; 事务提交后无法回滚；
Oracle的死锁 一个session如果更新类数据库，其他session是无法立刻更新的；一直到对方提交后才能继续提交

练习题
1.部门人数大于1的所有部门编号和人数
 SELECT deptno,COUNT(deptno) FROM emp GROUP BY deptno;//显示所有部门及其人数
 SELECT deptno,COUNT(deptno) FROM emp GROUP BY deptno HAVING COUNT(deptno)>1;
SELECT d.dname,ed.c FROM dept d,(SELECT deptno,COUNT(deptno) c FROM emp GROUP BY deptno HAVING COUNT(deptno)>1) ed WHERE d.deptno=ed.deptno;
2.薪金比 smith 多的所有员工
SELECT e.ename e.sal FROM emp e WHERE e.sal>(SELECT sal FROM emp WHERE emp.name='SMITH'); 
3.列出所有员工的姓名和上级领导姓名
SELECT e.ename,ed.ename FROM emp e,emp ed WHERE e.mgr=ed.ename;
4.列出受雇日期早于其上级领导的员工姓名编号及部门名称
SELECT e.ename,e.empno,d.dname FROM emp e,emp ed,dept d WHERE e.mgr=ed.empno AND e.hiredate<ed.hiredate AND e.deptno=d.deptno;
5.列出部门名称及员工信息 同时列出没有员工的部门
SELECT * FROM emp e,dept d WHERE e.deptno(+)=d.deptno;//左右连接： 不管是否匹配，都将显示(左右端)
6.列出所有 CLERK的名称所在部门名称和部门人数
SELECT d.dname,ed.count FROM emp e,dept d,(SELECT deptno,COUNT(deptno) count FROM emp ORDER BY deptno) ed WHERE e.ename='CLERK' AND e.deptno=d.deptno AND ed.deptno=d.deptno; 
7.列出佣金大于1500的所有工作和部门人数
SELECT job,COUNT(empno) FROM emp e GROUP by job HAVING MIN(sal)>1500;--WHERE语句中要使用分组函数HAVING
8.列出销售部门的所有雇员(假设不知道销售部门的编号)
SELECT * from emp e WHERE e.job LIKE 'SALSMAN';
9.列出薪金高于公司平均水平的所有员工和上级领导和工资等级
SELECT AVG(empno) FROM emp;
SELECT * FROM emp WHERE sal>(SELECT AVG(empno) FROM emp);
SELECT e.*,ed.name FROM emp e,emp ed WHERE sal>(SELECT AVG(empno) FROM emp) AND e.mgr=ed.empno;
SELECT e.*,ed.name,s.grade FROM emp e,emp ed,salgrade s WHERE sal>(SELECT AVG(empno) FROM emp) AND e.mgr=ed.empno AND (sal BETWEEN s.losal AND s.hisal;;
10.
