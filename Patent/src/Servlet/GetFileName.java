package Servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.Dbclass;

/**
 * Servlet implementation class GetFileName
 */
public class GetFileName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFileName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int t=0;
		System.out.println("skkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk=");
		String s=request.getParameter("filename").toString();
		System.out.println("Path of file from getfile_servlet"+s);
		File f=new File(s);
		FileInputStream fis=new FileInputStream(f);
		byte content[]=new byte[fis.available()];
		fis.read(content);
		String Con_pat=new String(content);
		System.out.println("readed content\n"+Con_pat);
		Dbclass db=new Dbclass();
		 t=db.rank_update(s);
		
		System.out.println("Success count updated in db"+t);
		
		HttpSession pat_res_ses=request.getSession();
		pat_res_ses.setAttribute("pat_rescontent", Con_pat);
		RequestDispatcher rd_res=request.getRequestDispatcher("Search_result.jsp");
		rd_res.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
