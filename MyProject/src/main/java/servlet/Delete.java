package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.data.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String delete  = "delete from student where id=?";
		  int id = Integer.parseInt(request.getParameter("id"));
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");
	        

	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "dombale123");
	        Student student = new Student();
			student.setId(id);
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(delete);
	        	preparedStatement.setInt(1, student.getId());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	           preparedStatement.executeUpdate();
	           connection.close();
				 preparedStatement.close();
	   		response.setContentType("text/html");
			response.getWriter().println("<h1>" + "Data Deleted" + "</h1>");
			response.getWriter().println("<a href=/StudentDatabase/add.html>Add</a>");
			response.getWriter().println("<a href=/StudentDatabase/edit.html>Edit</a>");
			response.getWriter().println("<a href=/StudentDatabase/delet.html>Delete</a>");
			response.getWriter().println("<a href=/StudentDatabase/select.html>Select</a>");
			response.getWriter().println("<a href=/StudentDatabase/Dashboard.html>HOME</a>");
			response.getWriter().println("<a href=/StudentDatabase/login.html>lOGOUT</a>");

	        } catch (Exception e) {
	        	response.setContentType("text/html");
				response.getWriter().println("<h1>" + "Error found" + "</h1>");
				response.getWriter().println("<a href=/StudentDatabase/add.html>Add</a>");
				response.getWriter().println("<a href=/StudentDatabase/edit.html>Edit</a>");
				response.getWriter().println("<a href=/StudentDatabase/delet.html>Delete</a>");
				response.getWriter().println("<a href=/StudentDatabase/select.html>Select</a>");
				response.getWriter().println("<a href=/StudentDatabase/Dashboard.html>HOME</a>");
				response.getWriter().println("<a href=/StudentDatabase/login.html>lOGOUT</a>");
	        	e.printStackTrace();
	        }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
