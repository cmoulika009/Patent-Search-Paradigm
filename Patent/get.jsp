<%@page import="java.util.ArrayList"%>
<%@page language="java" import ="java.sql.*" %>
 <%
 String name=request.getParameter("count");
 System.out.println("name is "+name);
 ArrayList li=new ArrayList();
 ArrayList li2=new ArrayList();
 String buffer1=null;
 String buffer="<div id='pat'>";
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
 Connection con = DriverManager.getConnection("Jdbc:Odbc:Patent");
 Statement stmt = con.createStatement();
 ResultSet rs = stmt.executeQuery("Select * from sugg");
   while(rs.next()){
       li.add(rs.getString(2).toString().trim());
  
   }
  
   //System.out.println("list is:   "+li);
   
 for(Object s:li)
 {
     String xyz=s.toString().trim();
     
     System.out.println("XYZ string "+xyz);
     int j=xyz.indexOf(name);
 //   System.out.println( "First chararcter"+name.charAt(0));
     if(name=="")
     {
    	 
             buffer="<br>";
     buffer=buffer+"</div>";
     
     
             }
    	 else
    	 {
    	 
     if(name.charAt(0)==xyz.charAt(0))
     {
   //  if(j>-1)
       
    	
         buffer=buffer+xyz+"<br>";
 buffer=buffer+"</div>";
 System.out.println("in condition........"+buffer);
 buffer1=buffer;
    	}

          
    
     
    	 }
        
     }

     
 

 response.getWriter().println(buffer);
 %>