 1.数据库的基本概念
     数据库 (DB)
     数据库管理系统(DBMS)
     数据库管理员(DBA)
     数据库系统(DBS)
     关系型数据库(RDB)
     关系型数据库管理系统(RDBMS)
     SQL语言(Structure Query Language)
            和数据库交互,提供查询和管理功能
		常用指令: SELECT INSERT DELETE UPDATE CREATE DROP 
2.数据库管理的历史
      手工管理阶段-文件管理阶段-数据库管理阶段
	非关系型数据库系统-关系型数据库系统-对象关系数据库系统
3.数据库分类
        网状数据库   以记录类型为节点的网状数据模型
	层次型数据库  层次模型模拟现实世界层次组织起来的事物
	关系型数据库 二维结构存储与管理数据,规定了表内和表间数据的依存关系
4数据建模
      将现实世界里存在的事物以数据的形式存储到计算机中,并进行处理,就需要对其进行分析处理,进而确定数据的结构以及数据间的内在联系,这个过程叫数据建模
	要求:比较真实模拟现实世界
	       容易理解
		 便宜计算机实现
	要素:数据结构
	     数据操作
		 完整性约束
	概念数据模型(Conceptual Database Model,CDM)
	     实体
	     实体集
	     属性
	     关系
	实体-关系模型(Entity-Relationship Model  E-R Model)
	    E-R模型三要素
	    实体,关系,属性
	    E-R图
	    实体   矩形
	    属性  椭圆
	    实体关系 菱形框表
	实体间关系
	    一对一
		一对多
		多对多
5.关系型数据库基本术语
        关系:整个二维表
	关系名:表格名
	元组:行数据
	属性:列数据
	属性名:列名称
	主键:唯一确定元组的属性组
	域:属性取值范围
	关系模型:关系名(属性列表)
	约束: 域完整性约束
	         实体完整性约束
		   参照完整性约束
6.oracle数据库安装
      需要512内存
	卸载:停止服务
	        用oracle自带卸载软件卸载 
 		  删除在注册表中的痕迹
		  删除oracle系统变量
		  删除oracle环境变量
		  删除程序菜单项中的oracle菜单
		  重启系统后删除oracle工作主目录
7.oracle 的基本术语
  数据库:Database 磁盘上存储的数据的集合
  数据库实例:Database Instance 运行在数据库文件上的一组oracle后台进程/线程以及一个共享内存区,数据库可以由实例装载和打开
  网络服务名: Net Service Name
  监听器: Monitor
  数据库对象:表 视图 约束条件 索引 序列 同义词 存储过程 函数 触发器 包
  数据库安全:用户 方案 权限 角色 配额 
8.Oracle数据库存储结构
   物理存储结构:
     数据文件 Data File
     重做日志文件 Redo Log File
     控制文件 Control File
    逻辑存储结构:
      表空间 Tab Space 
      段 Segment 
	区  Extent
	块  Block	
9.oracle的基本工具
     服务器工具   系统管理控制台
     客户端工具   sql plus   sql plus worksheet isqlplus
--------------------------------------
表的创建：
  create table student
  {
      sno DECIMAL(5) NOT NULL PRIMARY KEY,  
	sname varchar(6) NOT NULL,
	sex CHAR(2)  DEFAULT 'M',
	birthdar DATETIME,
	dno CHAR(3)
  }
非簇索引的创建和使用
            创建索引：create index index_name on table-name(column-name1,column-name2..)
		2.按索引排列原表： select * from table-name order by column-name，column-name2
簇索引的创建和使用
            创建索引：create clustered index index_name on table-name(column-name1,column-name2..)
		2.按索引排列原表： select * from table-name order by column-name，column-name2
             视图的创建：create view stuents_view as select * from stuents
                                 select * from stuents_view
		 为列创建视图：create view name_address_view as  select sname,address from stuents
                                   select * from name_address_view
             创建和原字段不同名的视图：create view name_address_view_test1(姓名,地址)as  select sname,address from stuents
                                                      select * from name_address_view_test1
             删除视图：drop view test_demo_view;
             创建多表视图：create view test_demo_view(姓名,系名,分数)
                                    as
                                    select sname,dname,score
						from stuents,department,recuritinfo
                                    where stuents.ADDRESS=recuritinfo.ADDRESS
                                    and stuents.DNO=department.DNO
            查看视图；select * from test_demo_view;
		复杂查询：查找分数大于500的男生系名
		create view boy_view --创建所有男生的资料
		as
            select *
            from studentinfo
            where sex='男'
		create view score_view --创建所有分数大于500的考生资料
            as
            select studentinfo.*
            from studentinfo,recuritinfo
            where studentinfo.ADDRESS=recuritinfo.ADDRESS
            and recuritinfo.SCORE>500
		create view boy_score_view 从score_view--中创建所有分数大于500的男生的所有资料
		create view boy_score_view
		as
            select * 
		from score_view
            where score_view.SNO in
            (select sno from boy_view)
		create view result_view(姓名,系名)--从boy_score_view何department中创建分数大于500的男生的名字和系名
		as
            select boy_score_view.sname,department.DNAME
            from boy_score_view,department
            where boy_score_view.dno=department.dno
	       查找以[]内字符开头的 tname 所在的所有数据
		 select * 
             from teacher
             where tname like '[^张]%'
	连接符
select tname||'的编号是'||cno,'工资是'||sal,'所在的系为'||dname from teacher
     别名的选择：
select tname||'的编号是'||cno as 编号,'工资是'||sal as 工资,'所在的系为'||dname as 系名 from teacher    
case 语句的使用：
select tname,
(
 case
   when sal>1000 then 1
   else 2
 end
) as levl
from teacher
      字符函数：
      select lower(tname) as 姓名 from teacher;
   
