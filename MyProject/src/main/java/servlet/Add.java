package servlet;

import student.data.Student;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Servletconfig
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) {
		System.out.println("in init");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String marks = request.getParameter("marks");
		String address = request.getParameter("address");
		String add = "INSERT INTO student (studentname, gender, marks, address) VALUES ( ?, ?, ?, ? );";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root",
					"admin");
			
			Student student =new Student();
			student.setGender(gender);
			student.setAddress(address);
			student.setMarks(marks);
			student.setStudentname(name);
			String a =student.getAddress();
			String b =student.getMarks();
			String c=student.getStudentname();
			String d=student.getGender();
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			PreparedStatement preparedStatement = connection.prepareStatement(add);
			preparedStatement.setString(1, student.getStudentname());
			preparedStatement.setString(2, student.getGender());
			preparedStatement.setString(3, student.getMarks());
			preparedStatement.setString(4, student.getAddress());
			
			System.out.println(preparedStatement);
			 preparedStatement.executeUpdate();
			System.out.println("connection is been made");
			connection.close();
			 preparedStatement.close();
			 response.setContentType("text/html");
				response.getWriter().println("<h1>"+"Student Data added in database"+"</h1>");
				response.getWriter().println("<a href=/StudentDatabase/add.html>Add</a>");
				response.getWriter().println("<a href=/StudentDatabase/edit.html>Edit</a>");
				response.getWriter().println("<a href=/StudentDatabase/delet.html>Delete</a>");
				response.getWriter().println("<a href=/StudentDatabase/select.html>Select</a>");
				response.getWriter().println("<a href=/StudentDatabase/Dashboard.html>HOME</a>");
				response.getWriter().println("<a href=/StudentDatabase/login.html>lOGOUT</a>");
		} catch (Exception e) {
			response.setContentType("text/html");
			response.getWriter().println("<h1>"+"Error Found"+"</h1>");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
