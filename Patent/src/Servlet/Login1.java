package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import DB.Dbclass;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * Servlet implementation class Login1
 */
public class Login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String n=request.getParameter("uname");
		String p=request.getParameter("upass");
		PrintWriter out = response.getWriter();
	    out.print("Hi");
	    Dbclass db=new Dbclass();
	    int t=db.login(n, p);
	    if(t==1)
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
	    	rd.forward(request, response);
	    	
	    }
	    else
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
	    	rd.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
