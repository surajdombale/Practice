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
import java.sql.ResultSet;

public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet result = null;
		String select = "select id, studentname, gender, marks, address from student where id=?;";
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "dombale123");

			Student student = new Student();
			student.setId(id);
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setInt(1, student.getId());

			System.out.println(preparedStatement);
			result = preparedStatement.executeQuery();

			System.out.println("connection is been made");
			while (result.next()) {
				response.setContentType("text/html");

				response.getWriter().println("<h1>" + "we are in select page" + "</h1>");
				response.getWriter().println("<a>" + "Student ID :" + result.getInt(1) + "</a><br>");
				response.getWriter().println("<a>" + "Student Name :" + result.getString(2) + "</a><br>");
				response.getWriter().println("<a>" + "Student Gender :" + result.getString(3) + "</a><br>");
				response.getWriter().println("<a>" + "Student Marks :" + result.getString(4) + "</a><br>");
				response.getWriter().println("<a>" + "Student Address :" + result.getString(5) + "</a><br>");
			}
			result.close();
			connection.close();
			preparedStatement.close();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
