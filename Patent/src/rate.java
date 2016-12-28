


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class rate
 */
public class rate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ser(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ser(request,response);
	}
	
	public void ser(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("inside rate.java11111111111111111111111111111111111111111");
			/*String FileName=request.getParameter("filename");
			System.out.println("<><><><>><><>"+FileName);*/
			HttpSession hs=request.getSession();
			String s=(String)hs.getAttribute("filename");
			
			System.out.println("The string is:  "+s+"    the patt:  "+s1);	
			
			HttpSession ht=request.getSession();
			String se=(String)ht.getAttribute("1");
			System.out.println("smotvellllll:     "+se);		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	static String s1;
	public static void aa(String sr)
	{
		s1=sr;
		System.out.println(s1+"   "+sr);
	}

}
