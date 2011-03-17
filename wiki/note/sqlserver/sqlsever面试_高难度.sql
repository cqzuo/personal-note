Question 1：Can you use a batch SQL or store procedure to calculating the Number of Days in a Month
Answer 1：找出当月的天数
select datepart(dd,dateadd(dd,-1,dateadd(mm,1,cast(cast(year(getdate()) as varchar)+'-'+cast(month(getdate()) as varchar)+'-01' as datetime))))

Question2：Can you use a SQL statement to calculating it!
How can I print "10 to 20" for books that sell for between $10 and $20，"unknown" for books whose price is null, and "other" for all other prices?
Answer 2：
select bookid,bookname,price=case when price is null then 'unknown' 
       when  price between 10 and 20 then '10 to 20' else price end
from books

Question3：Can you use a SQL statement to finding duplicate values!
How can I find authors with the same last name?
You can use the table authors in datatabase pubs. I want to get the result as below:
Output:
au_lname                                 number_dups 
---------------------------------------- ----------- 
Ringer                                   2
(1 row(s) affected) 
Answer 3
select au_lname,number_dups=count(1) from authors group by au_lname

Question4：Can you create a cross-tab report in my SQL Server!
How can I get the report about sale quality for each store and each quarter and the total sale quality for each quarter at year 1993?
You can use the table sales and stores in datatabase pubs. 
Table Sales record all sale detail item for each store. Column store_id is the id of each store, ord_date is the order date of each sale item, and column qty is the sale qulity. Table stores record all store information.
I want to get the result look like as below:
Output:
stor_name                                Total       Qtr1        Qtr2        Qtr3        Qtr4        
---------------------------------------- ----------- ----------- ----------- ----------- ----------- 
Barnum's                                 50          0           50          0           0
Bookbeat                                 55          25          30          0           0
Doc-U-Mat: Quality Laundry and Books     85          0           85          0           0
Fricative Bookshop                       60          35          0           0           25
Total                                    250         60          165         0           25 

Answer 4：用动态SQL实现

Question5: The Fastest Way to Recompile All Stored Procedures
I have a problem with a database running in SQL Server 6.5 (Service Pack 4). We moved the database (object transfer) from one machine to another last night, and an error (specific to a stored procedure) is cropping up. However, I can't tell which procedure is causing it. Permissions are granted in all of our stored procedures; is there a way from the isql utility to force all stored procedures to recompile?

Tips: sp_recompile can recomplie a store procedure each time
Answer 5：在执行存储过程时,使用 with recompile 选项强制编译新的计划；使用sp_recompile系统存储过程强制在下次运行时进行重新编译

Question6: How can I add row numbers to my result set?
In database pubs, have a table titles , now I want the result shown as below,each row have a row number, how can you do that?
Result:
line-no     title_id 
----------- -------- 
1           BU1032
2           BU1111
3           BU2075
4           BU7832
5           MC2222
6           MC3021
7           MC3026
8           PC1035
9           PC8888
10          PC9999
11          PS1372
12          PS2091
13          PS2106
14          PS3333
15          PS7777
16          TC3218
17          TC4203
18          TC7777
 
Answer 6：
--SQL 2005的写法
select row_number() as line_no ,title_id from titles
--SQL 2000的写法
select line_no identity(int,1,1),title_id into #t from titles
select * from #t
drop table #t

Question 7: Can you tell me what the difference of two SQL statements at performance of execution?
Statement 1:
if NOT EXISTS ( select * from publishers where state = 'NY') 
begin
SELECT 'Sales force needs to penetrate New York market'
end
else
begin
SELECT 'We have publishers in New York'
end
Statement 2:
if EXISTS ( select * from publishers where state = 'NY') 
begin
SELECT 'We have publishers in New York'
end
else
begin
SELECT 'Sales force needs to penetrate New York market'
end
Answer 7：不同点:执行时的事务数,处理时间,从客户端到服务器端传送的数据量大小

Question8: How can I list all California authors regardless of whether they have written a book?
In database pubs, have a table authors and titleauthor , table authors has a column state, and titleauhtor have books each author written. 
CA behalf of california in table authors.
Answer 8：
select * from  authors where state='CA'

Question9: How can I get a list of the stores that have bought both 'bussiness' and 'mod_cook' type books?
In database pubs, use three table stores,sales and titles to implement this requestment.
Now I want to get the result as below:
stor_id stor_name                                
------- ---------------------------------------- 
...
7896    Fricative Bookshop
...
...
...
Answer 9：
select distinct a.stor_id, a.stor_name from stores a,sales b,titles c 
where a.stor_id=b.stor_id and b.title_id=c.title_id and c.type='business' and 
exists(select 1 from sales k,titles g where stor_id=b.stor_id 
and k.title_id=g.title_id and g.type='mod_cook')    
 


Question10: How can I list non-contignous data?
In database pubs, I create a table test using statement as below, and I insert several row as below
create table test
( id int primary key )
go

insert into test values (1 )
insert into test values (2 )
insert into test values (3 )
insert into test values (4 )
insert into test values (5 )
insert into test values (6 )
insert into test values (8 )
insert into test values (9 )
insert into test values (11)
insert into test values (12)
insert into test values (13)
insert into test values (14)
insert into test values (18)
insert into test values (19)
go

Now I want to list the result of the non-contignous row as below,how can I do it?
Missing after Missing before 
------------- -------------- 
6             8
9             11
...

 


Answer 10：
select id from test t where not exists(select 1 from test where id=t.id+1) 
or not exists(select 1 from test where id=t.id-1)

Question11: How can I list all book with prices greather than the average price of books of the same type?
In database pubs, have a table named titles , its column named price mean the price of the book, and another named type mean the type of books.
Now I want to get the result as below:
type         title                                                                            price                 
------------ -------------------------------------------------------------------------------- --------------------- 
business     The Busy Executive's Database Guide                                              19.9900
...
...
...
...
 
Answer 11：
select a.type,a.title,a.price from titles a,
(select type,price=avg(price) from titles group by type)b
where a.type=b.type and a.price>b.price

      试题点评：通览整个试题，我们不难发现，这份试题是针对SQL Server数据库人员的。而从难度分析上来看，这份试题也属于同类试题中比较难的了。之所以说它难，首先是限定时间的全英文试题；其次，尽管这份试题主要是考核开发能力，但却涉及到了算法的选择和性能的调优；最后，这份试题还夹进了SQL Server数据库的升级问题。因此，综上所述，我们估计这是一家从事程序外包工作的外企招聘后台开发或与后台开发相关的SQL Server高级程序员的试题。

