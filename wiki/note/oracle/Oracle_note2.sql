sql����ʵ��
 ѧ���˶��������Ϣ���ݿ�
������Ϣ:
     1.�˶�Ա sporter(�˶�Ա��� sporterid;�˶�Ա���� sportername;�˶�Ա�Ա� sportersex;�˶�Ա����ϵ���department)
     2.��Ŀ iterm(��Ŀ��� itermid ;��Ŀ���� itermname;��Ŀ�����ص� location)
     3.�ɼ� grade (�˶�Ա���  sporterid;��Ŀ��� itermid;���� mark)
����Ҫ��:
     1.�����������������Լ��
     2.�˶�Ա����������ϵ����Ϊ��
     3.����ҪôΪ��ֵ,ҪôΪ6 4 2 0 �ֱ�����һ�ڶ���������������

CREATE TABLE sporter
(
        sporterid NUMBER(4) PRIMARY KEY NOT NULL,
        sportername VARCHAR2(20) NOT NULL,
        sportersex VARCHAR2(2) NOT NULL,
        department VARCHAR2(30) NOT NULL,
        CONSTARAINT sporter_sex_CK CHECK(sex IN('��','Ů')) 
);

CREATE TABLE iterm
(
        itermid NUMBER(4) PRIMARY KEY NOT NULL,
        itermname VARCHAR2(20) NOT NULL,
        location VARCHAR2(50) NOT NULL
);
CREATE TABLE grade
(
        sporterid NUMBER(4) PRIMARY KEY NOT NULL,
        itermid NUMBER(4) NOT NULL,
        mark NUMBER(3) NOT NULL
);
