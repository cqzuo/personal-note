1. �����䱸�ݺ��ȱ��ݵĲ�ͬ���Լ����Ե��ŵ�
����ȱ�����Թ鵵ģʽ�����ݿ⣬�����ݿ��Ծɴ��ڹ���״̬ʱ���б��ݡ����䱸��ָ�����ݿ�رպ󣬽��б��ݣ�����������ģʽ�����ݿ⡣�ȱ��ݵ��ŵ����ڵ�����ʱ�����ݿ��Ծɿ��Ա�ʹ�ò��ҿ��Խ����ݿ�ָ�������һ��ʱ��㡣�䱸�ݵ��ŵ��������ı��ݺͻָ������൱�򵥣����������䱸�ݵ����ݿ���Թ����ڷǹ鵵ģʽ��,���ݿ����ܻ�ȹ鵵ģʽ�Ժá�����Ϊ���ؽ�archive logд��Ӳ�̣�

2.  ��������ñ��ݻָ����ݿ⣬������û�п����ļ�������ν�������أ�
����ؽ������ļ����ô�backup control file �Ӿ��recover ����ָ�
���ݿ⡣ 

3.  ���ת��init.ora��spfile?
���ʹ��create spfile from pfile ����

4.  ����data block , extent �� segment���������ｨ����Ӣ����� 
���data block�����ݿ�����С���߼��洢��Ԫ�������ݿ�Ķ�����Ҫ���������洢�ռ�ʱ��������data block�������extent . һ�����ݿ����

ӵ�е�����extents����Ϊ�ö����segment.


5.  ������������ṹ�ķ���
���1��DESCRIBE���� 
2�� DBMS_METADATA.GET_DDL ��

6.    �����鿴���ݿ�����ı���
���alert log.

7.    �Ƚ�truncate��delete ����
������߶���������ɾ���������еļ�¼���������ڣ�truncate��DDL���������ƶ�HWK������Ҫ rollback segment .��Delete��DML����, ��Ҫrollback segment �һ��ѽϳ�ʱ��.

8.    ʹ������������
��𣺿��ٷ��ʱ��е�data block

9.    ������STAR SCHEMA�е����ֱ����Ƿֱ��е�����
���Fact tables ��dimension tables.  fact table ������������Ҫ����Ϣ�� dimension tables ��Ŷ�fact table ĳЩ������������Ϣ

10.  FACT Table����Ҫ��������������
���λͼ���� ��bitmap index��

11. �����������Լ��?
������������

12. ����ڲ�Ӱ���ӱ��ǰ���£��ؽ�һ��ĸ��
����ӱ�����ǿ��ʵЧ���ؽ�ĸ���������

13. ���͹鵵�ͷǹ鵵ģʽ֮��Ĳ�ͬ�����Ǹ��Ե���ȱ��
��𣺹鵵ģʽ��ָ����Ա������е����ݿ� transactions���ָ�������һ��ʱ��㡣�ǹ鵵ģʽ���෴�����ָܻ�������һ��ʱ��㡣���Ƿǹ鵵ģʽ���Դ������ݿ������ϵ��������

14. ��ν���һ�����ݿ����ļ���
���Alter database backup control file to trace.

15. �������ݿ����������������ļ���״̬ ?
���
STARTUP NOMOUNT �C ���ݿ�ʵ������
STARTUP MOUNT      -  ���ݿ�װ��
STARTUP OPEN          �C ���ݿ��

16. �ĸ�column������������V$��ͼ��GV$��ͼ?
��� INST_ID ָ����Ⱥ�����о���� ĳ��instance ��

17. �������explain plan?
��� 
����utlxplan.sql. ����plan ��
����ض�SQL��䣬ʹ�� explain plan set statement_id = 'tst1' into plan_table
����utlxplp.sql �� utlxpls.sql�쿴explain plan

18. �������buffer cache�������ʣ�
��������ݿ�Ϸ�æʱ������buffer cache advisory ���ߣ���ѯv$db_cache_advice . ����б�Ҫ���ģ�����ʹ�� alter system set db_cache_size ����


19. ORA-01555��Ӧ�Է�����
��𣺾���ĳ�����Ϣ��snapshot too old within rollback seg , ͨ������ͨ��
����rollback seg��������⡣��ȻҲ��Ҫ�쿴һ�¾�����ɴ����SQL�ı�

20. ����$ORACLE_HOME��$ORACLE_BASE������
���ORACLE_BASE��oracle�ĸ�Ŀ¼��ORACLE_HOME��oracle��Ʒ
��Ŀ¼��

21. ����ж����ݿ��ʱ����
���SELECT DBTIMEZONE FROM DUAL;

22. ����GLOBAL_NAMES��ΪTRUE����;
���GLOBAL_NAMESָ���������ݿ�ķ�ʽ����������������ΪTRUE,
�ڽ������ݿ�����ʱ�ͱ�������ͬ����������Զ�����ݿ�

23����μ���PL/SQL����
���WRAP

24. ����FUNCTION,PROCEDURE��PACKAGE����
���function ��procedure��PL/SQL����ļ��ϣ�ͨ��Ϊ�����
һ������procedure ����Ҫ�����κ�ֵ��function������һ��ֵ
����һ���棬Package��Ϊ�����һ����ҵ���ܵ�һ��function��proceudre
�ļ���

25. ����TABLE Function����;
���TABLE Function��ͨ��PL/SQL�߼�����һ���¼������
��ͨ�ı�/��ͼ������Ҳ����pipeline��ETL���̡�

26.  �ٳ�3�ֿ����ռ�three advisory statistics
���Buffer Cache Advice, Segment Level Statistics,  Timed Statistics

27.  Audit trace ������ĸ�oracleĿ¼�ṹ��?
���unix $ORACLE_HOME/rdbms/audit
Windows the event viewer

28.  ����materialized views������
���Materialized views ���ڼ�����Щ���ܣ����Ϻͷ����
��Ϣ�ļ�������������ͨ���ʺ������ݲֿ��DSSϵͳ��

29.  ���û����̳����ĸ���̨���̸���������
��� PMON

30.  �ĸ���̨����ˢ��materialized views?
���The Job Queue Processes.

31.  ����ж��ĸ�session���������Լ����ǵȴ�����Դ��
���V$SESSION / V$SESSION_WAIT

32.  ����ʲô�� redo logs
���Redo Logs �����ڴ�����ݿ����ݸĶ�״����������߼��ṹ��
���������޸����ݿ�.

33.  ��ν���ǿ��LOG SWITCH?
���ALTER SYSTEM SWITCH LOGFILE;

34. �ٳ������ж�DDL�Ķ��ķ�����
��������ʹ�� Logminer �� Streams

35.  Coalescing����ʲô��
���Coalescing������ֵ�����tablespace������Ƭ������
�ٽ���Сextents�ϲ��ɵ����Ĵ�extent.

36.  TEMPORARY tablespace��PERMANENT tablespace �������ǣ�
���A temporary tablespace ������ʱ������������ṹ�� permanent tablespaces
�����洢��Щ'��ʵ'�Ķ���(������ع��εȣ�

37.  �������ݿ�ʱ�Զ�������tablespace���ƣ�
���SYSTEM tablespace.

38.  �����û�ʱ����Ҫ�������û�ʲôȨ�޲���ʹ���������ݿ⡣
���CONNECT

39.  �����tablespace�����������ļ���
���ALTER TABLESPACE ADD DATAFILE SIZE 

40.  ��α䶯�����ļ��Ĵ�С��
���ALTER DATABASE DATAFILE RESIZE ;

41.  �ĸ�VIEW������������ļ��Ĵ�С��
��� DBA_DATA_FILES

42.  �ĸ�VIEW�����ж�tablespace��ʣ��ռ�
���DBA_FREE_SPACE

43.  ����ж�˭������������һ����¼��
���auditing

44. ����ع�������
��� ALTER INDEX REBUILD;

45. ����ʲô��Partitioning�������� �Լ������ŵ㡣
���Partition�����������ָ�ɸ�С�����ڹ���ķ�����

46.  ��ոձ�����һ��PL/SQL Package�����д��󱨵��������ʾ������Ϣ��
���SHOW ERRORS

47.  ����Ѽ���ĸ���״̬���ݣ�
��� ANALYZE
The ANALYZE command.

48. �������SESSION�����TRACE
���:  DBMS_SESSION.SET_SQL_TRACE
ALTER SESSION SET SQL_TRACE = TRUE;

49.  IMPORT��SQL*LOADER ��2�����ߵĲ�ͬ��
���������ORACLE���߶������������ݵ������ݿ�ġ�
�����ǣ�IMPORT����ֻ�ܴ�������һ��ORACLE����EXPORT����
�����ݡ���SQL*LOADER���Ե��벻ͬ��ASCII��ʽ������Դ

50�� �����������ӵ�2���ļ���
��� TNSNAMES.ORA and SQLNET.ORA


---------------------------------------------
1����table1(FId,Fclass,Fscore),�����Ч��򵥵�SQL�г�����ɼ���ߵ��б���ʾ�༶���ɼ������ֶΡ� 

select fclass,max(fscore) from table1 group by fclass,fid

2����һ����table1�������ֶ�FID��Fno���ֶ��ǿգ�дһ��SQL����г��ñ���һ��FID��Ӧ�����ͬ��Fno�ļ�¼��  

���磺 
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
����� 
102a1002 
102a1003 
104a1005 
104a1006 

select t2.* from table1 t1, table1 t2 where t1.fid = t2.fid and t1.fno <> t2.fno;

3����Ա����empinfo 
( 
Fempno varchar2(10) not null pk, 
Fempname varchar2(20) not null, 
Fage number not null, 
Fsalary number not null 
); 
�����������ܴ�Լ1000������дһ������Ϊ���Ч��SQL����һ��SQL�������������ˣ� 
fsalary>9999 and fage > 35 
fsalary>9999 and fage < 35 
fsalary <9999 and fage > 35 
fsalary <9999 and fage < 35 
ÿ��Ա���������� 
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
4����A�ֶ����� 
month person income 
�·� ��Ա ���� 
Ҫ����һ��SQL��䣨ע����һ�����Ĵ������ˣ���������Ա��ÿ���¼����º����µ������� 
Ҫ���б����Ϊ 
�·� �������� �������� �������� 
MONTHS PERSON INCOME
---------- ---------- ----------200807 mantisXF 5000200806 mantisXF2 3500200806 mantisXF3 3000200805 mantisXF1 2000200805 mantisXF6 2200200804 mantisXF7 1800200803 8mantisXF 4000200802 9mantisXF 4200200802 10mantisXF 3300200801 11mantisXF 4600200809 11mantisXF 6800
11 rows selected
select months, max(incomes), max(prev_months), max(next_months)
from (select months,
incomes,
decode(lag(months) over(order by months),
to_char(add_months(to_date(months, 'yyyymm'), -1), 'yyyymm'), lag(incomes) over(order by months), 0) as prev_months, decode(lead(months) over(order by months), to_char(add_months(to_date(months, 'yyyymm'), 1), 'yyyymm'), lead(incomes) over(order by months), 0) as next_months from (select months, sum(income) as incomes from a group by months) aa) aaagroup by months;

MONTHS MAX(INCOMES) MAX(PREV_MONTHS) MAX(NEXT_MONTHS)---------- ------------ ---------------- ----------------200801 4600 0 7500200802 7500 4600 4000200803 4000 7500 1800200804 1800 4000 4200200805 4200 1800 6500200806 6500 4200 5000200807 5000 6500 0200809 6800 0 0

5����B 
C1 c2 
2005-01-01 1 
2005-01-01 3 
2005-01-02 5 

Ҫ��Ĵ����� 
2005-01-01 4 
2005-01-02 5 
�ϼ� 9 
����һ��Sql�����ɡ� 

 

select nvl(to_char(t02,'yyyy-mm-dd'),'�ϼ�'),sum(t01)from test 
group by rollup(t02)

6�����ݿ�1��2��3 ��ʽ�ĸ�������⡣ 

7������oracle�д������ı仯�����Ʊ�ĸ����ʹ�����ƣ��д��������������������ʲô���ơ� 

8��oracle��ʱ���м��֡� 
��ʱ�����ͨ�����Ҫ��������Щ��ʹ����ʱ�����Ҫԭ����ʲô�� 

9����ôʵ�֣�ʹһ���Ự����ִ�еĶ�����̺����򴥷������涼���Է��ʵ�ȫ�ֱ�����Ч��������Ҫʵ�ֻỰ����룿 

10��aa��bb����20���ֶΣ��Ҽ�¼�������ܴ�aa��bb���X�ֶΣ��ǿգ����������� 
����SQL�г�aa��������ڵ�X��bb�����ڵ�X��ֵ����д����Ϊ������䣬������ԭ�� 

11������SGA��Ҫ��ɽṹ����;�� 

12ʲô�Ƿ�����������Χ�������б���������𣬷��������Ҫ��������Щ�� 

13��������ĳ����������archivelog������rman����ȫ���ݺ����ݿ���䱸�ݣ� 
�����еĹ鵵��־���У��ֿ����ļ�ȫ���𻵣������ļ�ȫ����ã����ʸ���ô�ָ������ݿ⣬˵һ���ַ����� 

14����rmanдһ��������䣺���ݱ�ռ�TSB��level Ϊ2���������ݡ� 

 

15���и���a(x number(20),y number(20))������ٸ�Ч��SQL��ñ�����1��ʼ��������1000���¼��


1����table1(FId,Fclass,Fscore),�����Ч��򵥵�SQL�г�����ɼ���ߵ��б���ʾ�༶���ɼ������ֶΡ� 

2����һ����table1�������ֶ�FID��Fno���ֶ��ǿգ�дһ��SQL����г��ñ���һ��FID��Ӧ�����ͬ��Fno�ļ�¼�� 
���磺 
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
����� 
102 a1002 
102 a1003 
104 a1005 
104 a1006 

3����Ա����empinfo 
( 
Fempno varchar2(10) not null pk, 
Fempname varchar2(20) not null, 
Fage number not null, 
Fsalary number not null 
); 
�����������ܴ�Լ1000������дһ������Ϊ���Ч��SQL����һ��SQL�������������ˣ� 
fsalary>9999 and fage > 35 
fsalary>9999 and fage < 35 
fsalary<9999 and fage > 35 
fsalary<9999 and fage < 35 
ÿ��Ա���������� 

4����A�ֶ����� 
month person income 
�·� ��Ա ���� 
Ҫ����һ��SQL��䣨ע����һ�����Ĵ������ˣ���������Ա��ÿ���¼����º����µ������� 
Ҫ���б����Ϊ 
�·� �������� �������� �������� 


5����B 
C1 c2 
2005-01-01 1 
2005-01-01 3 
2005-01-02 5 

Ҫ��Ĵ����� 
2005-01-01 4 
2005-01-02 5 
�ϼ� 9 
����һ��Sql�����ɡ� 


6�����ݿ�1��2��3 ��ʽ�ĸ�������⡣ 

7������oracle�д������ı仯�����Ʊ�ĸ����ʹ�����ƣ��д��������������������ʲô���ơ� 

8��oracle��ʱ���м��֡� 
��ʱ�����ͨ�����Ҫ��������Щ��ʹ����ʱ�����Ҫԭ����ʲô�� 

9����ôʵ�֣�ʹһ���Ự����ִ�еĶ�����̺����򴥷������涼���Է��ʵ�ȫ�ֱ�����Ч��������Ҫʵ�ֻỰ����룿 

10��aa��bb����20���ֶΣ��Ҽ�¼�������ܴ�aa��bb���X�ֶΣ��ǿգ����������� 
����SQL�г�aa��������ڵ�X��bb�����ڵ�X��ֵ����д����Ϊ������䣬������ԭ�� 

11������SGA��Ҫ��ɽṹ����;�� 

12ʲô�Ƿ�����������Χ�������б���������𣬷��������Ҫ��������Щ�� 

13��������ĳ����������archivelog������rman����ȫ���ݺ����ݿ���䱸�ݣ� 
�����еĹ鵵��־���У��ֿ����ļ�ȫ���𻵣������ļ�ȫ����ã����ʸ���ô�ָ������ݿ⣬˵һ���ַ����� 

14����rmanдһ��������䣺���ݱ�ռ�TSB��level Ϊ2���������ݡ� 

15���и���a(x number(20),y number(20))������ٸ�Ч��SQL��ñ�����1��ʼ��������1000���¼�� 


�𰸣�
1��select Fclass,max(Fscore) from table1 group by Fclass
2��select * from table1 where FID in (select FID from table1 group by FID having (count(Distinct Fno))>=2)
3��select sum(case when fsalary>9999 and fage>35 then 1 else 0 end),
sum(case when fsalary>9999 and fage<35 then 1 else 0 end),
sum(case when fsalary<9999 and fage>35 then 1 else 0 end),
sum(case when fsalary<9999 and fage<35 then 1 else 0 end) from empinfo
4�� 
Select (Select Month From Table Where Month = To_Char(Sysdate, 'mm')) �·�,
(Select Sum(Income) From Table Where Month = To_Char(Sysdate, 'mm')) ��������,
(Select Sum(Income) From Table Where To_Number(Month) = To_Number(Extract(Month From Sysdate)) - 1) ��������,
(Select Sum(Income) From Table Where To_Number(Month) = To_Number(Extract(Month From Sysdate)) + 1) ��������
From Dual

5��select nvl(c1,'�ϼ�'),sum(c2) from B group by rollup(c1)
6.
��ϵ���ݿ����֮ʱ��Ҫ����һ���Ĺ���ġ����������ݿ���Ʒ�ʽ 
�򵥽���1NF����һ��ʽ����2NF���ڶ���ʽ����3NF��������ʽ����
��һ��ʽ��1NF�����ڹ�ϵģʽR�е�ÿһ�������ϵr�У����ÿ������ֵ ���ǲ����ٷֵ���С���ݵ�λ�����R�ǵ�һ��ʽ�Ĺ�ϵ��
������ְ���ţ��������绰�������һ����һ���˿�����һ���칫�ҵ绰 ��һ������绰���룩 �淶��Ϊ1NF�����ַ����� 
����һ���ظ��洢ְ���ź��������������ؼ���ֻ���ǵ绰���롣 
��������ְ����Ϊ�ؼ��֣��绰�����Ϊ��λ�绰��סլ�绰�������� 
��������ְ����Ϊ�ؼ��֣���ǿ��ÿ����¼ֻ����һ���绰���롣 
��������������������һ�ַ������ȡ����ʵ�����ѡȡ����������� 
���ڶ���ʽ��2NF���������ϵģʽR��U��F���е����з������Զ���ȫ����������һ����ѡ�ؼ��֣���ƹ�ϵR �����ڵڶ���ʽ�ġ� 
��������ѡ�ι�ϵ SCI��SNO��CNO��GRADE��CREDIT������SNOΪѧ�ţ� CNOΪ�γ̺ţ�GRADEGE Ϊ�ɼ���CREDIT Ϊѧ�֡� ������ 
�������ؼ���Ϊ��Ϲؼ��֣�SNO��CNO�� 
������Ӧ����ʹ�����Ϲ�ϵģʽ���������⣺ 
����a.�������࣬����ͬһ�ſ���40��ѧ��ѡ�ޣ�ѧ�־� �ظ�40�Ρ� 
����b.�����쳣����������ĳ�γ̵�ѧ�֣���Ӧ��Ԫ��CREDITֵ��Ҫ���£��п��ܻ����ͬһ�ſ�ѧ�ֲ�ͬ�� 
����c.�����쳣����ƻ����¿Σ�����û��ѡ�ޣ�û��ѧ�Źؼ��֣�ֻ�ܵ�����ѡ�޲��ܰѿγ̺�ѧ�ִ��롣 
����d.ɾ���쳣����ѧ���Ѿ���ҵ���ӵ�ǰ���ݿ�ɾ��ѡ�޼�¼��ĳЩ�ſγ�������δѡ�ޣ�����ſγ̼�ѧ�ּ�¼�޷����档 
����ԭ�򣺷ǹؼ�������CREDIT������������CNO��Ҳ����CREDIT����������Ϲؼ��֣�SNO��CNO����������ȫ������ 
��������������ֳ�������ϵģʽ SC1��SNO��CNO��GRADE����C2��CNO��CREDIT�����¹�ϵ����������ϵģʽ������֮��ͨ��SCN��
����ؼ���CNO����ϵ����Ҫʱ�ٽ�����Ȼ���ӣ��ָ���ԭ���Ĺ�ϵ 
��������ʽ��3NF���������ϵģʽR��U��F���е����з������Զ��κκ�ѡ�ؼ��ֶ������ڴ�����������ƹ�ϵR�����ڵ�����ʽ�ġ� 
����������S1��SNO��SNAME��DNO��DNAME��LOCATION�� �����Էֱ����ѧ�ţ� 
��������������ϵ��ϵ���ƣ�ϵ��ַ�� 
�����ؼ���SNO�����������ԡ������ǵ����ؼ��֣�û�в������������⣬�϶���2NF�������ϵ�϶��д��������࣬�й�ѧ�����ڵļ���
����DNO��DNAME��LOCATION���ظ��洢�����룬ɾ�����޸�ʱҲ����������������������� 
����ԭ�򣺹�ϵ�д��ڴ���������ɵġ���SNO -> DNO�� ��DNO -> SNOȴ�����ڣ�DNO -> LOCATION, ��˹ؼ��� SNO �� LOCATIO
N ����������ͨ���������� SNO -> LOCATION ʵ�ֵġ�Ҳ����˵��SNO��ֱ�Ӿ�����������LOCATION�� 
�������Ŀ�أ�ÿ����ϵģʽ�в������д��������� 
���������������Ϊ������ϵ S��SNO��SNAME��DNO����D��DNO��DNAME��LOCATION�� 
����ע�⣺��ϵS�в���û����ؼ���DNO������������ϵ֮��ʧȥ��ϵ��

7.
�仯��mutating table
��DML��������޸ĵı�
��Ҫ��ΪDELETE CASCADE�ο����������ƵĽ�����и��µı�Ҳ�Ǳ仯��

����:����Session�������ܶ�ȡ���ڱ仯�ı�

���Ʊ�constraining table
��Ҫ�Բο�����������ִ�ж������ı� 

����:������������ڱ��ı䣬��ô��ȡ���޸Ļᴥ�����󣬵����޸�������������ġ�

8.
��Oracle�У����Դ�������������ʱ�� 
a���Ự���е���ʱ�� 
CREATE GLOBAL TEMPORARY ( ) 
ON COMMIT PRESERVE ROWS�� 

b���������е���ʱ�� 
CREATE GLOBAL TEMPORARY ( ) 
ON COMMIT DELETE ROWS�� 
CREATE GLOBAL TEMPORARY TABLE MyTempTable 
��������ʱ����Ȼ�Ǵ��ڵģ���������һ��insert һ����¼Ȼ���ñ�����ӵ���ȥselect����¼�ǿյģ������˰ɡ�
�������仰����һ�£� 
--ON COMMIT DELETE ROWS ˵����ʱ��������ָ����ÿ���ύ��ORACLE���ضϱ�ɾ��ȫ���У� 
--ON COMMIT PRESERVE ROWS ˵����ʱ���ǻỰָ�������жϻỰʱORACLE���ضϱ�

9.--���������ǽ���һ����,����������ν��ȫ�ֱ����ð��еĺ������س����Ϳ�����,ժ��һ�����ϵĽ������
Oracle���ݿ������еı������ڱ�������п���ֱ�����ã������ڳ����֮�⣬�򲻿���ֱ�����á��Գ���������Ĵ�ȡ������Ϊÿ������������Ӧ�Ĵ洢����<���ڴ洢����>�ͺ���<���ڶ�ȡ����>��ʵ�֡� 
����
����3.2 ʵ�� 
����--�������� 
����create or replace package PKG_System_Constant is 
����
������ C_SystemTitle nVarChar2(100):='����ȫ�ֳ������';��--���峣�� 
������ --��ȡ����<ϵͳ����> 
������ Function FN_GetSystemTitle 
����������Return nVarChar2; 
����
������ G_CurrentDate Date:=SysDate; --����ȫ�ֱ��� 
������ --��ȡȫ�ֱ���<��ǰ����> 
������ Function FN_GetCurrentDate 
����������Return Date; 
������ --����ȫ�ֱ���<��ǰ����> 
������ Procedure SP_SetCurrentDate 
����������(P_CurrentDate In Date); 
����End PKG_System_Constant; 
����/ 
����create or replace package body PKG_System_Constant is 
������ --��ȡ����<ϵͳ����> 
������ Function FN_GetSystemTitle 
����������Return nVarChar2 
����������Is 
����������Begin 
������������ Return C_SystemTitle; 
����������End FN_GetSystemTitle; 
����
������ --��ȡȫ�ֱ���<��ǰ����> 
������ Function FN_GetCurrentDate 
����������Return Date 
����������Is 
����������Begin 
������������ Return G_CurrentDate; 
����������End FN_GetCurrentDate; 
������ --����ȫ�ֱ���<��ǰ����> 
������ Procedure SP_SetCurrentDate 
����������(P_CurrentDate In Date) 
����������Is 
����������Begin 
������������ G_CurrentDate:=P_CurrentDate; 
����������End SP_SetCurrentDate; 
����End PKG_System_Constant; 
����/ 
��������
����3.3 ���� 
����--���Զ�ȡ���� 
����Select PKG_System_Constant.FN_GetSystemTitle From Dual;������ 
����--��������ȫ�ֱ��� 
����Declare��
����Begin 
������ PKG_System_Constant.SP_SetCurrentDate(To_Date('2001.01.01','yyyy.mm.dd')); 
����End; 
����/ 
����--���Զ�ȡȫ�ֱ��� 
����Select PKG_System_Constant.FN_GetCurrentDate From Dual;

10.
select aa.x from aa
where not exists (select 'x' from bb where aa.x = bb.x) ;
�������ͬʱʹ�õ���aa��x�������͵�bb��x������

11
SGA��OracleΪһ��ʵ�������һ�鹲���ڴ滺��������������ʵ�������ݺͿ�����Ϣ��SGA��ʵ������ʱ���Զ����䣬��ʵ���ر�ʱ���ջء����ݿ���������ݲ�����Ҫͨ��SGA�����С� 
SGA���ڴ���ݴ����Ϣ�Ĳ�ͬ�����Է�Ϊ���¼�������
a.Buffer Cache��������ݿ������ݿ��Ŀ�����������һ�黺�������ɣ���Щ�����Ϊ�������ʵ�������ӵ��û�������������������Ŀ�ɳ�ʼ������DB_BLOCK_BUFFERSȷ���������Ĵ�С�ɳ�ʼ������DB_BLOCK_SIZEȷ����������ݿ����߲�ѯ�ٶȡ�����DBWR������ 
b. ��־������Redo Log Buffer��������ݲ����ĸ�����Ϣ����������־�redo entry������ʽ�������־�������С�����Ҫ�������ݿ�ָ�ʱ����־�������ع���ع������ݿ������ı������־�������Ĵ�С�ɳ�ʼ������LOG_BUFFERȷ���������־�������ɼ�����־�ļ�I/O�Ĵ�������̨����LGWR����־�������е���Ϣд����̵���־�ļ��У�������ARCH��̨���̽�����־��Ϣ�鵵�� 
c. �����Shared Pool���������������SQL�����Ϣ������������SQL���������ֵ�洢��������SQL������ִ���ض���SQL������õ���Ϣ�������ֵ������ڴ�������ֵ䣬��Ϊ�����û����������� 

12.
ʹ�÷�����ʽ�����ı�з�����

��Χ���� 
ÿ����������һ��������ֵ��Χָ��������һ������������Ϊ�������ı���2005 �� 1 �¡���������������ֵΪ�ӡ�2005 �� 1 �� 1 �ա� 
����2005 �� 1 �� 31 �ա����У��� 

�б���� 
ÿ����������һ��������ֵ�б�ָ��������һ����������Ϊ�������ı����������������ܰ���ֵ�����ô󡱡��������͡�ī���硱���� 

��������ͨ�����ƿɹ����ԡ����ܺͿ����ԣ��Ӷ�Ϊ��ʽӦ�ó�������˼���ĺô���ͨ������������ʹĳЩ��ѯ�Լ�ά�����������ܴ����ߡ�����,���������Լ���򻯳����Ĺ�������ͨ������,���ݿ������Ա�͹���Ա�ܹ����ǰ��Ӧ�ó��������һЩ���⡣�����ǹ���ǧ���ֽ�����ϵͳ�򳬸߿�����ϵͳ�Ĺؼ����ߡ�


13
�ظ��ķ���:
һ.ʹ���䱸��,ֱ�ӽ��䱸�ݵ��ļ�ȫ��COPY��ԭ�ȵ�Ŀ¼��,�ڴ����������ݿ�Ϳ���
��.ʹ�ù鵵��־,
1.�������ݿ�NOMOUNT
2.���������ļ�,�����ļ�ָ�������ļ���������־�ļ���λ��.
3.ʹ��RECOVER DATABASE using backup controlfile until cancel ����ظ����ݿ�,��ʱ����ʹ�ù鵵��־
4.ALETER DATABASE OPEN RESETLOGS;
5.���±������ݿ�Ϳ����ļ�

14�Ļ��ο�RMAN��ʹ���ֲ�

