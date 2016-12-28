package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.Dbclass;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String query=request.getParameter("msg");
		System.out.println("Message  :"+query);
		HttpSession hs1=request.getSession();
		hs1.setAttribute("EnterQuery",query);
		String[] a=query.split(" ");
		System.out.println(a[0]+"     "+a[1]);
		//rate r=new rate();
		//r.aa(query);
		Dbclass db=new Dbclass();
		ArrayList ali=db.retw(a[0], a[1]);
		System.out.println("arrylist contents are:     "+ali);
		//ArrayList al=db.ret(query);
		//System.out.println("arrayList is:   "+al);
		HttpSession hs=request.getSession();
		hs.setAttribute("string",ali);
		RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
		rd.forward(request, response);
		System.out.println("Leaving search.java");
		
	}

}
