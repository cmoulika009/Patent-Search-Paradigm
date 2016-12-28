package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Dbclass
{
	Connection con=null;
	PreparedStatement ps_reg,ps2,ps3;
	Statement stmt_login;
	ResultSet rs_login,rs2;
	static String de;
	 static Dbclass db=new Dbclass();
	public Connection connect() throws Exception 
	{
	try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:Patent");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	
	}
	public int  login(String username,String password)
	{
		int t=0;
	try {
		con=db.connect();
		stmt_login=con.createStatement();
		rs_login=stmt_login.executeQuery("select * from registration where loginname='"+username+"' and pasword='"+password+"' ");
	while(rs_login.next())
	{
		rs_login.getString(1).toString().trim();
		rs_login.getString(2).toString().trim();
		t=1;
	}
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return t;
		
	}
	
	public int register(String name,String loginname,String password,String repassword,String gender,String mob,String email)
	{
		int t=0;
		try {
			con=db.connect();
			ps_reg=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?)" );
			ps_reg.setString(1, name);
			ps_reg.setString(2, loginname);
			ps_reg.setString(3, password);
			ps_reg.setString(4, repassword);
			ps_reg.setString(5, gender);
			ps_reg.setString(6,mob);
			ps_reg.setString(7, email);
			ps_reg.executeUpdate();
			con.close();
			System.out.println("Registered");
			t=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	public int rank_update(String rank_update)
	{
		int result = 0;
		int count=0;
		System.out.println("print in db--------"+rank_update+"   Table name "+de);
		try
		{
			Statement st=connect().createStatement();
			ResultSet rs=st.executeQuery("select rank_count from "+de+" where con_path='"+rank_update+"' ");
			while(rs.next())
			{
				count=rs.getInt(1);
				
			}
			count=count+1;
			System.out.println("Count incremented-----"+count);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("print in db--------"+rank_update+"   Table name "+de);
		try {
			
			//PreparedStatement pst=connect().prepareStatement("update "+de+"set rank_count=rank_count+1 where con_path='"+rank_update+"' ");
			PreparedStatement pst=connect().prepareStatement("update "+de+" set rank_count='"+count+"' where con_path='"+rank_update+"' ");
			result=pst.executeUpdate();
			
			System.out.println("RAnk count block");
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	ArrayList al=new ArrayList();
	public ArrayList ret(String str)
	{
		try{
			Statement st=connect().createStatement();
			ResultSet rs=st.executeQuery("select * from pat_det");
			String str1=str.toLowerCase();
			while(rs.next())
			{
				if((str1.equalsIgnoreCase(rs.getString(1))))
				{
					al.add(rs.getString(2));
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("hhhhhhhhhhhhhhh"+al);
		return al;
	}
	
	public static void main(String[] a)
	{
		Dbclass db=new Dbclass();
		ArrayList all=new ArrayList();
		//ArrayList al=db.ret("bike");
		//System.out.println("resultent arrayList:   "+al);
		all=db.retw("yamaha", "boat");
		System.out.println("the result element are :"+all);
	}
	
	ArrayList aq=new ArrayList();
	public ArrayList retw(String a1,String a2)
	{
		try
		{
			Statement ser=connect().createStatement();
			ResultSet rs12=ser.executeQuery("select * from "+a1);
			while (rs12.next())
			{
				if(a2.equalsIgnoreCase(rs12.getString(3)))		
				{
					Statement stm1=connect().createStatement();
					 de=a1+"_"+a2;
					System.out.println("The table name in DB is    "+de);
					ResultSet rs2=stm1.executeQuery("select * from "+de+" order by rank_count desc");
					
					while(rs2.next())
					{
						aq.add(rs2.getString(2));
						System.out.println("the elements are :"+aq);
					}
				}
			}
			System.out.println("From query retrival by ranking");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return aq;
	}
	
}
