 1.���ݿ�Ļ�������
     ���ݿ� (DB)
     ���ݿ����ϵͳ(DBMS)
     ���ݿ����Ա(DBA)
     ���ݿ�ϵͳ(DBS)
     ��ϵ�����ݿ�(RDB)
     ��ϵ�����ݿ����ϵͳ(RDBMS)
     SQL����(Structure Query Language)
            �����ݿ⽻��,�ṩ��ѯ�͹�����
		����ָ��: SELECT INSERT DELETE UPDATE CREATE DROP 
2.���ݿ�������ʷ
      �ֹ�����׶�-�ļ�����׶�-���ݿ����׶�
	�ǹ�ϵ�����ݿ�ϵͳ-��ϵ�����ݿ�ϵͳ-�����ϵ���ݿ�ϵͳ
3.���ݿ����
        ��״���ݿ�   �Լ�¼����Ϊ�ڵ����״����ģ��
	��������ݿ�  ���ģ��ģ����ʵ��������֯����������
	��ϵ�����ݿ� ��ά�ṹ�洢���������,�涨�˱��ںͱ�����ݵ������ϵ
4���ݽ�ģ
      ����ʵ��������ڵ����������ݵ���ʽ�洢���������,�����д���,����Ҫ������з�������,����ȷ�����ݵĽṹ�Լ����ݼ��������ϵ,������̽����ݽ�ģ
	Ҫ��:�Ƚ���ʵģ����ʵ����
	       �������
		 ���˼����ʵ��
	Ҫ��:���ݽṹ
	     ���ݲ���
		 ������Լ��
	��������ģ��(Conceptual Database Model,CDM)
	     ʵ��
	     ʵ�弯
	     ����
	     ��ϵ
	ʵ��-��ϵģ��(Entity-Relationship Model  E-R Model)
	    E-Rģ����Ҫ��
	    ʵ��,��ϵ,����
	    E-Rͼ
	    ʵ��   ����
	    ����  ��Բ
	    ʵ���ϵ ���ο��
	ʵ����ϵ
	    һ��һ
		һ�Զ�
		��Զ�
5.��ϵ�����ݿ��������
        ��ϵ:������ά��
	��ϵ��:�����
	Ԫ��:������
	����:������
	������:������
	����:Ψһȷ��Ԫ���������
	��:����ȡֵ��Χ
	��ϵģ��:��ϵ��(�����б�)
	Լ��: ��������Լ��
	         ʵ��������Լ��
		   ����������Լ��
6.oracle���ݿⰲװ
      ��Ҫ512�ڴ�
	ж��:ֹͣ����
	        ��oracle�Դ�ж�����ж�� 
 		  ɾ����ע����еĺۼ�
		  ɾ��oracleϵͳ����
		  ɾ��oracle��������
		  ɾ������˵����е�oracle�˵�
		  ����ϵͳ��ɾ��oracle������Ŀ¼
7.oracle �Ļ�������
  ���ݿ�:Database �����ϴ洢�����ݵļ���
  ���ݿ�ʵ��:Database Instance ���������ݿ��ļ��ϵ�һ��oracle��̨����/�߳��Լ�һ�������ڴ���,���ݿ������ʵ��װ�غʹ�
  ���������: Net Service Name
  ������: Monitor
  ���ݿ����:�� ��ͼ Լ������ ���� ���� ͬ��� �洢���� ���� ������ ��
  ���ݿⰲȫ:�û� ���� Ȩ�� ��ɫ ��� 
8.Oracle���ݿ�洢�ṹ
   ����洢�ṹ:
     �����ļ� Data File
     ������־�ļ� Redo Log File
     �����ļ� Control File
    �߼��洢�ṹ:
      ��ռ� Tab Space 
      �� Segment 
	��  Extent
	��  Block	
9.oracle�Ļ�������
     ����������   ϵͳ�������̨
     �ͻ��˹���   sql plus   sql plus worksheet isqlplus
--------------------------------------
��Ĵ�����
  create table student
  {
      sno DECIMAL(5) NOT NULL PRIMARY KEY,  
	sname varchar(6) NOT NULL,
	sex CHAR(2)  DEFAULT 'M',
	birthdar DATETIME,
	dno CHAR(3)
  }
�Ǵ������Ĵ�����ʹ��
            ����������create index index_name on table-name(column-name1,column-name2..)
		2.����������ԭ�� select * from table-name order by column-name��column-name2
�������Ĵ�����ʹ��
            ����������create clustered index index_name on table-name(column-name1,column-name2..)
		2.����������ԭ�� select * from table-name order by column-name��column-name2
             ��ͼ�Ĵ�����create view stuents_view as select * from stuents
                                 select * from stuents_view
		 Ϊ�д�����ͼ��create view name_address_view as  select sname,address from stuents
                                   select * from name_address_view
             ������ԭ�ֶβ�ͬ������ͼ��create view name_address_view_test1(����,��ַ)as  select sname,address from stuents
                                                      select * from name_address_view_test1
             ɾ����ͼ��drop view test_demo_view;
             ���������ͼ��create view test_demo_view(����,ϵ��,����)
                                    as
                                    select sname,dname,score
						from stuents,department,recuritinfo
                                    where stuents.ADDRESS=recuritinfo.ADDRESS
                                    and stuents.DNO=department.DNO
            �鿴��ͼ��select * from test_demo_view;
		���Ӳ�ѯ�����ҷ�������500������ϵ��
		create view boy_view --������������������
		as
            select *
            from studentinfo
            where sex='��'
		create view score_view --�������з�������500�Ŀ�������
            as
            select studentinfo.*
            from studentinfo,recuritinfo
            where studentinfo.ADDRESS=recuritinfo.ADDRESS
            and recuritinfo.SCORE>500
		create view boy_score_view ��score_view--�д������з�������500����������������
		create view boy_score_view
		as
            select * 
		from score_view
            where score_view.SNO in
            (select sno from boy_view)
		create view result_view(����,ϵ��)--��boy_score_view��department�д�����������500�����������ֺ�ϵ��
		as
            select boy_score_view.sname,department.DNAME
            from boy_score_view,department
            where boy_score_view.dno=department.dno
	       ������[]���ַ���ͷ�� tname ���ڵ���������
		 select * 
             from teacher
             where tname like '[^��]%'
	���ӷ�
select tname||'�ı����'||cno,'������'||sal,'���ڵ�ϵΪ'||dname from teacher
     ������ѡ��
select tname||'�ı����'||cno as ���,'������'||sal as ����,'���ڵ�ϵΪ'||dname as ϵ�� from teacher    
case ����ʹ�ã�
select tname,
(
 case
   when sal>1000 then 1
   else 2
 end
) as levl
from teacher
      �ַ�������
      select lower(tname) as ���� from teacher;
   
