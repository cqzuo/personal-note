1. 插入操作
//编写查询语句
    private static final String MOTORIST_INSERT = "insert into moterist (id,email,username,password ) value(?,?,?,?)";
//此方法来向数据库插入数据   
 public void saveMotorist(Moterist moterist)
    {
	//定义连接与状态集
	Connection conn = null;
	PreparedStatement ps = null;
	try{
	    //打开连接,准备状态集
	    conn = DataSource.getConnection();
	    ps = conn.prepareStatement(MOTORIST_INSERT);
	    //绑定参数
	    ps.setString(1,"");
	    ps.setString( 2,"");
	    //执行查询语句
	    ps.execute();
	}catch(SQLException e)
	    {
		...
	    }
	//关闭连接与状态集
	finally
	    {
		try{
		    if(ps!=null)
			{
			    ps.close();
			}
		    if(conn!=null)
			{
			    conn.close();
			}
		}catch( SQLException e)
		    {
			...
		    }
	    }
	    
    }
2. 更新数据