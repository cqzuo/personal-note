1.sql server ��ϵ���ݿ���
    DBMS ��ϵ���ݹ���ϵͳ��
    �ص㣺
       �ṩ���ݲֿ⹦�ܣ�֧��xml��ǿ��Ļ���Web�ķ�ϴ��֧��OLEDB�Ͷ��ֲ�ѯ��֧�ֲַ�ʽ�ķ�����ͼ��
 2.sql server�İ�װ����
    ���ְ汾�� ��ҵ��(Enterprise Edition)����׼��(Standard Edition)�����˰�(Personal Edition)�������߰�(Developer Edition;)��
    SQL Server2000��6��ϵͳ���ݿ⣺
           Master���ݿ⣬����Ҫ�����ݿ⣻��¼��SQL Serverϵͳ��������Ϣ��
           Model���ݿ⣬�������û����ݿ��Tempdb���ݿ��ģ�����ݿ⣬����Master���ݿ������ϵͳ����Ӽ�
           Msdb���ݿ��Ǵ���������ݿ⣬Ϊ���������·�ͼ�¼�����ṩ�洢�ռ䣻
           Tempdb��һ����ʱ���ݿ⣬��Ϊ���е���ʱ����ʱ�洢���̼�������ʱ�����ṩ�洢�ռ䣻
           Pubs��Northwind���ݿ�������ʵ�����ݿ⣬������SQL SERVER��ѧϰ����
      ϵͳĿ¼������SQL Serverϵͳ�����ݿ⣬������ͼ�������ȶ���Ľṹ��ϵͳ�����
      ������Ҫ��ϵͳ��
           Sysobjects����SQL Server����ϵͳ��sysobjects������ÿ�����ݿ��У�����ÿ�����ݿ������һ�м�¼��
           Syscolumns��    ������master���ݿ��ÿ���û��Զ�������ݿ��У����Ի��������ͼ��ÿ���кʹ洢�����е�ÿ����������һ�м�¼��
           Sysindexs��       ������master���ݿ��ÿ���û��Զ�������ݿ��У�����ÿ��������û�о۴�������ÿ������һ�м�¼�������԰����ı�ͼ�����ݵ�ÿ������һ�м�¼
           Sysuser��          ϵͳ��sysuser������master���ݿ��ÿ���û��Զ�������ݿ��У������������ݿ��е�û���û��û����ɫ����һ�м�¼
           Sysdatabases�� ��sql serverϵͳ�ϵ�ÿ��ϵͳ���ݿ���û��Զ�������ݿ⺬��һ�м�¼����ֻ�Գ�����master���ݿ��У�
           Sysdepends��   ϵͳ��Sysdepends�Ա���ͼ�ʹ洢����֮���ÿ��������ϵ����һ�м�¼����������master���ݿ��ÿ���û��Զ�������ݿ��У�
           Sysconstraints�� ��ʹ�� CREATE TABLE���� ALTER TABLE���Ϊ���ݿ�������ÿ��������Լ������һ�м�¼����������master���ݿ��ÿ���û��Զ�������ݿ��У�
       ������Ҫ���ߣ�
           ��ҵ������ Microsoft Management Console ����ϵͳ�����͹���SQL SERVER������б���ʽ��ʾ����SQL SERVER����
                             ��ִ�в���  �����͹������ݿ⣬������������ͼ�洢���̴��������ɫ����Ĭ��ֵ�����ݶ����û�������������ͣ��������ݿ��������־�����þ������ṩ����������Ϸſ��Ʋ����������û��ʺţ�����Transact-SQL������䣻�������SQL Mail
           ���������  Service Manager ����������ͣ������ֹͣ���ݿ��������ʵʱϵͳ
                             �ṩ�ķ���  sql server/sql server agent/msdtc(microsoft distributed transaction coordianator)
           ��ѯ������  Query Analyzer �����ִ��Transaction-SQL��䣬�鿴��Щ���Ľ�����������ݿ��е�����
           �ֲ�ʽ������Э���� Distributed Transaction Coordinator  �ṩ�͹���ͬ������֮��ķֲ�ʽ������
           ���ܼ�����  Performance Monitor �鿴��ͳ��serverϵͳ���������������Ӱ��ϵͳ���ܵ���Ҫ����
           ����͵������� Imput and Export Data ��OLE DB����Դ֮�临������
           SQL Server������ �ල��¼�ͼ��SQL Server���ݿ��ʹ�����
           ����������ʵ�ù��� ���÷��������������Ӻ�������ز���
           �ͻ�������ʵ�ù��� ���ÿͻ������������Ӻ͹���ⶨ�ͻ���������
3.Transact-SQL���Ե���Ҫ��ɲ���
      ���ݶ������� DDL Data Definition Language
      ���ݲ������� DML Data Manipularion Language
      ���ݿ�������DCL Data Control Language
      ϵͳ�洢���� System Stored Procedure
4.���ݶ�������
      ����͹������ݿ���� CREATE ALTER DROP��
      ��ϵ�������ͼ
      �������ͣ� ����(int 32) ������(smallint 16) ʮ����(dec(m,n)) ������(float 64) �����ַ���(char(n)) �䳤�ַ���(varchar(n)) ����(data) ʱ��(time)
      ������Ψһ�Ĳ����ظ���
      create database test_data_base/*����һ������Ϊtest_data_base�����ݿ�*/
      create table test_table/*����һ��Ĭ����master�µ�һ����ָ������������������*/
      (column1 char(8),column2 int,column3 char(10))
      ���ӣ�create table ��ʦ
                (
                  ��� char(5),���� char(24),�Ա� char(2),���� smallint,ְ�� char(8),primary key(���)
                 );
                 create table ѧ��
                 (
                  ѧ�� smallint not null,���� char(10),�Ա� char(4),���� int,primary key(ѧ��)
                 );
                 create table �γ�
                 (
                  �κ� char(8) not null,�γ� char(10),ѧʱ smallint,ѧ�� smallint,primary key(�κ�)
                 );
                 create table �ɼ�
                 (
                  ѧ�� smallint not null,�κ� char(8),�ɼ� smallint,primary key(ѧ�ţ��κ�),foreign key(ѧ��) references ѧ�� (ѧ��),foreign key(�κ�) references �γ�(�κ�)
                 );
     ����ģʽ�޸�
        alter table [��Ĵ�����.����] add <����> <����>
        alter table  [��Ĵ�����.����] modify(���� ����)
               ���ӣ�
                  alter table ��ʦ add ���� smallint
     ɾ������sql��ɾ��������             
         drop table [��Ĵ�����.����] cascade constrains /*ǿ��ɾ��*/
     ���䶨������
        alter table ���� add primary key(����)
5.ddl���ݶ�������   
   create
     /*��������ӽ�������S��*/
CREATE TABLE S
(
   sno  char(10)  NOT NULL       /*ѧ���ֶ�*/
         CONSTRAINT PK_sno PRIMARY KEY CLUSTERED/*����Լ��*/
         CHECK (sno like '31300501[0-9][0-9]')/*���Լ��*/,
   sname      char(8)     NULL, /*�����ֶ�*/
   sex     char(2)   NULL, /*�Ա��ֶ�*/
   age    int  NULL, /*�����ֶ�*/
   dept   varchar(20)   NULL/*ϵ���ֶ�*/
  )

   drop
    ��3-3��ɾ��S��
�����嵥���£�

   DROP table S

   alter 
     ��3-2 �޸�S������һ�������
�����嵥���£�
ALTER TABLE S 
ADD
CLASS_NO CHAR(6) 
6.dml ���ݲ�������
   select
   insert
     INSERT������������ݿ�������ͼ�м���һ�����ݡ�INSERT�����﷨��ʽ���£�
   INSERT [INTO] table_or_view [(column_list)] VALUES(data_values)
���У�table_or_view��ָҪ�����¼�¼�ı����ͼ��column_list�ǿ�ѡ�ָ����������ݵ��У� VALUES�Ӿ�ָ����������ݵľ���ֵ������������˳��һ��Ҫ�ͱ���ʱ��˳��һ�¡�����ָ��������ʱVALUES�Ӿ�ֵ������˳�������������е���������˳��һ�£�������ȣ���������һһ��Ӧ�� 
     �ڽ������ݲ������ʱ��ע�����¼��㣺
��1�������ö��Ž��������ݷֿ����ַ�������Ҫ�õ�������������
��2��INTO�Ӿ���û��ָ�����������²���ļ�¼������ÿ���������Ͼ���ֵ����VALUES�Ӿ���ֵ������˳��Ҫ�ͱ��и������е�����˳��һ�¡�
��3����VALUES�Ӿ��е�ֵ����INTO�Ӿ���ָ��������˳����뵽���С�
��4������INTO�Ӿ���û�г��ֵ��У����²���ļ�¼����Щ���Ͻ�ȡ��ֵ����������SCORE������ֵ�����ڱ���ʱ��NOT NULLԼ���������в���ȡ��ֵ�� 
  ����
    ��3-5   ����SC��ѧ��ѡ�α�������SC���в���һ��ѡ�μ�¼����S7��,��C1������
�����嵥���£�
CREATE TABLE SC
(
   sno  char(10)  NOT NULL, 
   cno char(2)    NULL, /*�γ̱���ֶ�*/
  score  numerical(4,1) NULL  /*�ɼ��ֶ�*/
  )
          Go
INSERT INTO SC (sno,cno) VALUES ('3130050101', 'c1')
Go
 ��3-6   ʹ�� column_list �� VALUES �б���ʽ��ָ����������ÿ���е�ֵ��
�����嵥���£�
CREATE TABLE T1
 ( column_1 int, 
column_2 varchar(30)) 
Go
INSERT T1 (column_2, column_1) VALUES ('This is a test',1) 
����������ݵ��﷨��ʽΪ��
INSERT INTO table_or_view [(column_list)] �Ӳ�ѯ
��3-7   �����λѧ����ƽ���ɼ����ѽ��������±�AVGSCORE�С�
�����嵥���£�
/*���Ƚ����±�AVGSCORE���������ѧ�ź�ѧ����ƽ���ɼ���*/
CREATE TABLE AVGSCORE
(SNO CHAR(10),
AVGSCORE SMALLINT) 
Go
/*�����Ӳ�ѯ���SC���и�λѧ����ƽ���ɼ����ѽ��������±�AVGSCORE�С�*/
INSERT INTO AVGSCORE
SELECT SNO,AVG(SCORE) 
FROM SC
GROUP BY SNO 


   update
   delete           