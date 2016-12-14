package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecServlet
 */
@WebServlet("/SecServlet")
public class SecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession s=request.getSession(false);
		String str=(String)s.getAttribute("id");
		PrintWriter out=response.getWriter();
		out.println("Session in second servlet is "+str);
		out.println("<br>"+s.getId()+"<br>");
		out.println("Timeout period "+s.getMaxInactiveInterval()+"<br>");
		Cookie [] CookieArray=request.getCookies();
		for(int x=0;x<CookieArray.length;x++)
		{
		if(CookieArray[x].getName().equals("MyCookie"))
		{
			out.print(CookieArray[x].getValue());
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
