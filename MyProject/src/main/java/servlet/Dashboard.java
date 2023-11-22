package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		response.setContentType("text/html");
		response.getWriter().println("<h1>"+"Welcome to Dashboard Mr. "+user+"</h1>");
		response.getWriter().println("<a href=/StudentDatabase/add.html>Add</a>");
		response.getWriter().println("<a href=/StudentDatabase/edit.html>Edit</a>");
		response.getWriter().println("<a href=/StudentDatabase/delet.html>Delete</a>");
		response.getWriter().println("<a href=/StudentDatabase/select.html>Select</a>");
		response.getWriter().println("<a href=/StudentDatabase/Dashboard.html>HOME</a>");
		response.getWriter().println("<a href=/StudentDatabase/login.html>lOGOUT</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
