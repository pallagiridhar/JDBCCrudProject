package com.techaplle.jdbc;
import java.sql.*;
public class StudentService {
	private static Connection cn=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static Connection myConnection() throws ClassNotFoundException, SQLException
	{
		//step 1:Load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2:Establish the connection
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Giri@226");
		
		//return connection
		return cn;
	}
	//final write this
	//read the all data from table
	public static void reading()
	{
		try 
		{
			cn=myConnection();
			stm=cn.createStatement();
			String qry="select*from Student";
			rs=stm.executeQuery(qry);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email")+ "\n");
				
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stm!=null)
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try 
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	//Fourth write this code...
	//update the data
	public static void updating(int sno,String sub,String email)
	{
	 try 
	 {
		cn= myConnection();
		String qry="update Student set sub=?,email=? where sno=?";
		ps=cn.prepareStatement(qry);
		ps.setString(1,sub);   //Follow the qry parameters order
		ps.setString(2, email); // upto
		ps.setInt(3,sno);       // here
		ps.executeUpdate();
		
	 }
	 catch (ClassNotFoundException | SQLException e)
	 {
		e.printStackTrace();
	}
	 finally
		{
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
 }
	//Third write this code...
	//delete the row
	public static void deleting(int sno)
	{
		try
		{
			cn= myConnection();
			
			String qry="delete from Student where sno= ?";
			ps=cn.prepareStatement(qry);
			ps.setInt(1,sno);
				
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
				e.printStackTrace();
		}
		finally
		{
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
	}
//Second write this....
	//inserting method
	public static void inserting(String name,String sub,String email)
	{
		try
		{
			cn= myConnection();
			
			String qry="insert into Student(sname,sub,email) values(?,?,?)";
			ps=cn.prepareStatement(qry);
			ps.setString(1,name);
			ps.setString(2,sub);
			ps.setString(3,email);
				
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
				e.printStackTrace();
		}
		finally
		{
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
  //First write..creating method
	public static void creating()
	{
		try
		{
			cn= myConnection();
			
			String qry="create table Student(sno int primary key auto_increment,sname varchar(200),sub varchar(200),email varchar(200) unique)";
			
			stm=cn.createStatement();//it will not take any parameters
			
			stm.executeUpdate(qry);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
				e.printStackTrace();
		}
		finally
		{
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stm!=null)
			{
				try 
				{
					stm.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
