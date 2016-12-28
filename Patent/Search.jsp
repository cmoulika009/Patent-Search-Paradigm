<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="javax.swing.JOptionPane"%>
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
 
<script language="javascript" type="text/javascript">
 var xmlHttp
 var xmlHttp
 function showState(str){

if(null!=str)
	{
if (typeof XMLHttpRequest != "undefined"){
   xmlHttp= new XMLHttpRequest();
       }
       else if (window.ActiveXObject){
   xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
       }
if (xmlHttp==null){
    alert ("Browser does not support XMLHTTP Request")
return;
}
var url="get.jsp";
url += "?count=" +str;
xmlHttp.onreadystatechange = stateChange;
xmlHttp.open("GET", url, true);
xmlHttp.send(null);
}
 }
 function stateChange(){
	 
 if (xmlHttp.readyState==4){
	
	 show=xmlHttp.responseText;
	 
	 
 document.getElementById("batchList").innerHTML=xmlHttp.responseText;
 System.out.println(xmlHttp.responseText);
 var c=document.getElementById("pat").value;
 
 }
 else
	 {
	
	 
	 System.out.println("inside show block");
	 document.getElementById("batchList").innerHTML=show;
	 }
 
/*  else
	 {
	 document.getElementById("batchList").innerHTML=xmlHttp.responseText;
	 } */
 
 
	 
 }
 </script>
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
</div>
		
		
		
                         <%
                            ArrayList al=new ArrayList();
                            HttpSession hs=request.getSession();
                            al=(ArrayList)hs.getAttribute("string");
                        
                            System.out.println("In jsp page  Patent   "+al);
                           // JOptionPane.showMessageDialog(null, "the contents are  :"+al);
                            if(al==null)
                            { %>
                            
                            
        <div id="content_wrapper">
        <div id="content">
        
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                    	<div class="col_550 float_l">
                    	<center><h1 style="color:white; font-style: oblique;">Type your Query</h1></center>
            			<form action="Search" method="post">
                          <input type="text" name="msg" value="" size="50"  onkeyup=" showState(this.value)"  />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Search" value="Search"/>
                         
                          
                          
						</form>
						</div>
                            
                            <%} else {%>                         	
                            	
                            
                            	
                            	
                            	
                          
		<div id="content_wrapper">
        <div id="content">
        
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                    	<div class="col_550 float_l">
                    	<center><h1 style="color:white; font-style: oblique;">Type your Query</h1></center>
            			<form action="Search" method="post">
            			<% String qq=(String)session.getAttribute("EnterQuery"); %>
                          <input type="text" name="msg" value="<%=qq%> " size="50" onkeyup=" showState(this.value)" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Search" value="Search"/>
                    
                          <table border="0">
<tr><td width="8%"></td></tr> 
<%
try
{
	for(int i=0;i<al.size();i++){

	String str_split=(String)al.get(i);
	String[] split_res=str_split.split("\\\\");
	System.out.println("THe path splited     : "+split_res[4]);
	String tittle_txt=split_res[4];
	String[]  fin_tit=tittle_txt.split(".txt");
	System.out.println("Tittle only  :   "+fin_tit[0]);
	
	%>

 <tr><td><a href="GetFileName?filename=<%=al.get(i)%>"><%=fin_tit[0]%></a></td></tr>
 
<% }
}
catch(Exception e)
{
	/* e.printStackTrace(); */
}
%>
   

</table>
                          
						</form>
						</div>
						</div>
    </div>
                        <%} %>
                      <br/><br/><br/>
  <div id="batchList" class="panel">
  <div class="box"> 
  
  </div> 
</div>
                        
			
          </div>
          </div><!-- end of scroll -->
        
        </div> <!-- end of content -->
        </div> <!-- end of content_wrapper -->
        </div>
        </div>
        
    </div>
  
    </div> <!-- end of slider -->
 
</body>
</html>

