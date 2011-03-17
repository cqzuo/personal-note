 ǳ��oracleǶ�ױ�
/*
��ǰ���������ʱ��ᾭ���õ�oracle���ڴ��(��ʵ��oracleǶ�ױ�Ĳ��ֹ��ܣ��������±߽���)��������ܡ�
����oracle�ڴ�������ʱ����ͨ��ref cursor������������Ҫ�Ľ������
open cur for select * from table(fun_to_table_rb1_1(cur_qc,cur_qm));
�����ⲿ�ֵ�һЩ���Կ��Բο���http://www.itpub.net/showthread.php?threadid=617298

�����oracleǶ�ױ������������ϸ���˿������˸�������

oracle�ṩ����ʹ��Ƕ�ױ�ķ�����
1�� PL/SQL��������Ϊ��չPL/SQL���ԣ�(�ⲿ�����ݾ����ϱ���˵oracle�ڴ����oracleǶ�ױ�Ĳ��ֹ���)
2�� ��Ϊ����洢���ƣ��Գ־õش洢���ϡ�
*/

--�������Ա�

CREATE TABLE dept
����(deptno NUMBER(2) PRIMARY KEY,
���� dname VARCHAR2(14),
���� loc VARCHAR2(13)
����);
����
CREATE TABLE emp
����(empno NUMBER(4) PRIMARY KEY,
���� ename VARCHAR2(10),
���� job VARCHAR2(9),
���� mgr NUMBER(4) REFERENCES emp,
���� hiredate DATE,
���� sal NUMBER(7,2),
���� comm NUMBER(7,2),
���� deptno NUMBER(2) REFERENCES dept
����);
����
INSERT INTO dept SELECT * FROM scott.dept;
INSERT INTO emp SELECT * FROM scott.emp;
/* 
	����������dept��emp,��scott�еĶ�Ӧ���Ƶ��´����ı���
 */
/*
	����type��ʽ:
	CREATE OR REPLACE TYPE �ֱ���������� AS OBJECT(���ֵ����ݶ�û��Լ��)
*/

CREATE OR REPLACE TYPE emp_type AS OBJECT
����(empno NUMBER(4),
���� ename VARCHAR2(10),
���� job VARCHAR2(9),
���� mgr NUMBER(4),
���� hiredate DATE,
���� sal NUMBER(7,2),
���� comm NUMBER(7,2)
����);
�ǵ÷�
/*
	����һ�������͵����� 
	CREATE OR REPLACE TYPE �������� AS TABLE OF ������;
*/
CREATE OR REPLACE TYPE emp_tab_type AS TABLE OF emp_type;��

--ʹ��Ƕ�ױ�
/*
	�ڸ�����ʹ���Ѿ�����õı�����
	CREATE TABLE ��������
	(
		....
		�ӱ��� ������
	)
	NESTED TALBE �ӱ��� STROE AS �ӱ���_nest;
*/
CREATE TABLE dept_and_emp
����(deptno NUMBER(2) PRIMARY KEY,
���� dname VARCHAR2(14),
���� loc VARCHAR2(13),
���� emps emp_tab_type
����)
����NESTED TABLE emps STORE AS emps_nest;

--������Ƕ�ױ�������Լ��(���������Ȳ�ִ�д˲��裬��������һ�����������ٴ���Լ��)
--ALTER TABLE emps_nt ADD CONSTRAINT emps_empno_unique
--Ƕ�ױ�֧�ֲ���������Լ�������ܲο��κ������������Լ�
--��Ƕ�ױ��������ݣ����ǿ��������ַ�ʽ�Ľ���кβ�ͬ
��ʽ1��
     INSERT INTO dept_and_emp
���� SELECT dept.*, CAST
         (
����		MULTISET(
				 SELECT empno, ename, job, mgr, hiredate, sal, comm 
			    	 FROM emp
���� 			    	 WHERE emp.deptno= dept.deptno
		          ) AS emp_tab_type 
	 )
���� FROM dept;
--Oracleͬ���ṩ����ȥ�����ϵ�Ƕ�ף����ϵ�ͱ�һ�������ܹ���EMPS�е���һ��������Ȼ�����Ҳ���Ҫ������������
SELECT d.deptno, d.dname, emp.* FROM dept_and_emp d, TABLE(d.emps) emp;
--����ִ�п��������14������

delete from dept_and_emp;

��ʽ2��INSERT INTO dept_and_emp
SELECT dept.*, CAST(MULTISET( SELECT empno, ename, job, mgr, hiredate, sal, comm
����FROM
����emp,dept
���� WHERE emp.deptno
����= dept.deptno ) AS emp_tab_type ) from dept;

SELECT d.deptno, d.dname, emp.* FROM dept_and_emp D, TABLE(d.emps) emp;
--����ִ�п��������56�����ݣ���Ȼ�Ǵ����

--��һ���ǰ���where�������������ϵ�ĳһ��dept��emp���������Ϊһ�����ϴ洢�����ڶ���û���κι������������ǰ�����emp������
--ȫ����Ϊһ��dept�����ݴ洢�����д����Ȼ�Ǵ���ģ�������ǰѸղŽ���Լ����Ƕ�ױ���ϣ��Ϳ����𵽷�ֹ���ִ���Ĺ�Ч�ˡ�

--����Լ����ִ�������ϱߵĵڶ���insert��佫�ᱨ��
--���ǰ����ϱߵ�һ��insert���������ݣ����������±ߵĲ��ԡ�

--���ա�ÿ��ʵ����һ�ű���˼�������£�
UPDATE TABLE( SELECT emps FROM dept_and_emp WHERE deptno = 10) SET comm = 100;

--������ɾ�����﷨��
����INSERT INTO TABLE(SELECT emps FROM dept_and_emp WHERE deptno=10)
����VALUES (1234,'NewEmp','Clerk',7782,SYSDATE,1200,NULL);
����
����DELETE FROM TABLE(SELECT emps FROM dept_and_emp WHERE deptno=20)
����WHERE ename='SCOTT';

--һ����ԣ������������ӣ������ܵ�����ѯǶ�ױ���emp_nest���е����ݣ��������ȷʵ��Ҫ���ǿ��Եġ�
--hint NESTED_TABLE_GET_REFS������EXP��IMP����Ƕ�ױ�

����SELECT /*+NESTED_TABLE_GET_REFS+*/ NESTED_TABLE_ID, SYS_NC_ROWINFO$ FROM emps_nest;

--���쿴EMPS_NEST�Ľṹ������NESTED_TABLE_ID,SYS_NC_ROWINFO$���С��Ը���DEPT_AND_EMP��˵NESTED_TABLE_ID��һ�������
--ʹ�����hint�Ϳ���ֱ�Ӳ���Ƕ�ױ��ˣ�
����UPDATE /*+NESTED_TABLE_GET_REFS+*/ emps_nest SET ename=INITCAP(ename);
����
--Ƕ�ױ�Ĵ洢:
--�����У���ʵ���������ű�

����DEPT_AND_EMP
����(deptnob NUMBER(2),
����dname VARCHAR2(14),
����loc VARCHAR2(13),
����SYS_NC0000400005$,
RAW(16))
����
����EMPS_NEST
����(SYS_NC_ROWINFO$,
����NESTED_TABLE_ID,
RAW(16),
����empno NUMBER(4),
����ename VARCHAR2(10),
����job VARCHAR2(9),
����mgr NUMBER(4),
����hiredate DATE,
����sal NUMBER(7,2),
����comm NUMBER(7,2))��
��
--Ĭ������£�ÿ��Ƕ�ױ��ж�����һ�������RAW(16)�����У��������ϴ�����ΨһԼ��������ָ��Ƕ�ױ���Ƕ�ױ���������
--�����У�SYS_NC_ROWINFO$����Ϊһ�����󷵻����б���Ԫ�ص�һ��α�У���һ��NESTED_TABLE_ID�������ָ�򸸱�
--���Կ�����ʵ���룺

����CREATE TABLE DEPT_AND_EMP
����(DEPTNO NUMBER(2,0),
���� DNAME VARCHAR2(14),
���� LOC VARCHAR2(13),
���� EMPS EMP_TAB_TYPE)
����PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
����LOGGING STORAGE(INITIAL 131072 NEXT 131072
����MINEXTENTS 1 MAXEXTENTS 4096
����PCTINCREASE 0 FREELISTS 1 FREELIST GROUP 1
����BUFFER_POOL DEFAULT)
����TABLESPACE USER
����NESTED TABLE EMPS
����STORE AS EMPS_NEST
����RETURN BY VALUE;
����
����RETURN BY VALUE��������Ƕ�ױ���η��ص��ͻ�Ӧ�ó����С�
����NESTED_TABLE_ID�б����������ģ���ô�ϺõĽ���취����ʹ��IOT�洢Ƕ�ױ�
����CREATE TABLE DEPT_AND_EMP
����(DEPTNO NUMBER(2,0),
���� DNAME VARCHAR2(14),
���� LOC VARCHAR2(13),
���� EMPS EMP_TAB_TYPE)
����PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
����LOGGING STORAGE(INITIAL 131072 NEXT 131072
����MINEXTENTS 1 MAXEXTENTS 4096
����PCTINCREASE 0 FREELISTS 1 FREELIST GROUP 1
����BUFFER_POOL DEFAULT) TABLESPACE USER
����NESTED TABLE EMPS
����STORE AS EMPS_NEST
����((empno NOT NULL,
UNIQUE(empno),
PRIMARY KEY(nested_table_id,empno))
����ORGANIZATION
����INDEX COMPRESS 1)
����RETURN BY VALUE;
/*
�������������Ĭ�ϵ�Ƕ�ױ���ȣ�ʹ���˽��ٵĴ洢�ռ䲢������Ҫ��������
������ʹ��Ƕ�ױ���Ϊ���ô洢���Ƶ�ԭ��
����1��������RAW(16)�еĶ��⿪����������ӱ����������������У�
����2����ͨ���Ѿ���ΨһԼ��ʱ�������ϵ�ΨһԼ���Ƕ��⿪����
����3��û��ʹ�ò�֧�ֵĽṹ��NESTED_TABLE_GET_REFS����Ƕ�ױ�����ʹ�á�
����һ���Ƽ��ڱ�̽ṹ����ͼ��ʹ��Ƕ�ױ����Ҫʹ��Ƕ�ױ���Ϊ�洢���ƣ�
ȷ��Ƕ�ױ���IOT���Ա���NESTED_TABLE_ID��Ƕ�ױ����������Ķ��⿪����
*/