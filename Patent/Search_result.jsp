<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.HashMap"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PATENT SEARCH</title>
<meta name="keywords" content="wall shelf, free css templates, one page, full site, CSS, HTML" />
<meta name="description" content="Wall Shelf is a free CSS template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/coda-slider.css" type="text/css" media="screen" title="no title" charset="utf-8" />
 

</head>
<body>
	
   
    	<% String ClickeLink=null; %>
       <div id="slider">
    	
        <div id="header_wrapper">
            <div id="header">
                <a href="#home"><img src="images/aa.jpg" alt="Wall Shelf" /></a>
            </div>
		</div>
        
        <div id="menu_wrapper">
            <div id="menu">
                <ul class="navigation">
                    <li><a href="LoginPage.jsp" >Home</a></li>
                    <li><a href="Register.jsp">Registration<span class="ui_icon aboutus"></span></a></li>
                    <li><a href="Search.jsp">Search<span class="ui_icon aboutus"></span></a></li>
                    <li><a href="LoginPage.jsp">Logout<span class="ui_icon services"></span></a></li>
                    <li><a href="#">About Us<span class="ui_icon contactus"></span></a></li>
                </ul>
            </div>
		</div>
                       
                            
                            
                            <div id="content_wrapper">
        <div id="content">
        
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                    	<div class="col_550 float_l">
                    	<center><h1 style="color:white; font-style: oblique;">Type your Query</h1></center>
            			<form action="Search" method="post">
            			<%String qq=(String)session.getAttribute("EnterQuery"); %>
                          <input type="text" name="msg" value="<%=qq %>" size="50"  />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Search" value="Search"/>
                         
                          
                          
						</form><br/>
						<h2 style="color: orange;font-size: large;"><u>Results:</u></h2>
						<br/><br/>
						<textarea rows="10" cols="50" style="color:blue; font-style:inherit; text-align:left;">
						<%

HttpSession result=request.getSession();
						
String P_res=(String)result.getAttribute("pat_rescontent");
System.out.println("Inside result"+"\n"+P_res);

%>
						<%=P_res %>
						</textarea>
						</div>
                            
                            
                            	
                            	
                            
                            	
                            	
                            	
                          
		<!-- <div id="content_wrapper">
        <div id="content">
        
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                    	<div class="col_550 float_l">
                    	<center><h1 style="color:white; font-style: oblique;">Type your Query</h1></center>
            			<form action="Search" method="post">
                          <input type="text" name="msg" value="" size="50"  />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Search" value="Search"/>
                         
                          <table border="0">
<tr><td width="8%"></td></tr>
 -->

 

</table>
                          
						</form>
						</div>
                       
			
          </div>
          </div><!-- end of scroll -->
        
        </div> <!-- end of content -->
        </div> <!-- end of content_wrapper -->
        </div>
        </div>
    
    </div> <!-- end of slider -->
 
</body>
</html>

