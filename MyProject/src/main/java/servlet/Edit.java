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

/**
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String edit = "UPDATE student SET studentname=? ,gender=? , marks =? ,address=? WHERE id=?";
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String marks = request.getParameter("marks");
		String address = request.getParameter("address");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root",
					"dombale123");
			// Step 2:Create a statement using connection object
			Student student = new Student();
			student.setId(id);
			student.setGender(gender);
			student.setAddress(address);
			student.setMarks(marks);
			student.setStudentname(name);
			PreparedStatement preparedStatement = connection.prepareStatement(edit);;
			preparedStatement.setString(1, student.getStudentname());
			preparedStatement.setString(2, student.getGender());
			preparedStatement.setString(3, student.getMarks());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setInt(5, student.getId());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
		 preparedStatement.executeUpdate();
		 connection.close();
		 preparedStatement.close();
		 response.setContentType("text/html");
			response.getWriter().println("<h1>" + "Edited" + "</h1>");
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
