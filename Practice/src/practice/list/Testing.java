package practice.list;

import java.util.*;
import java.sql.*;

public class Testing {
	static Connection conn = null;

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d?autoReconnect=true&useSSL=false", "root",
					"admin");
		} catch (Exception e) {
			System.out.println("in catch");
			e.printStackTrace();
		}
		System.out.println("Welcome to Employe management app");

		System.out.println("Press 1 to add Employe");
		System.out.println("Press 2 to Terminate Employe");
		System.out.println("Press 3 to Displaye Employes");
		System.out.println("Press 4 to Increment Employe");
		System.out.println("Press 5 to exit");
		while (true) {
			Scanner sc = new Scanner(System.in);
			int c = sc.nextInt();
			sc.nextLine();
			if (c == 1) {

				// Add Person
				System.out.println("Enter Employe name: ");
				String name = sc.nextLine();
				System.out.println("Enter Employe phone: ");
				int phone = sc.nextInt();
				System.out.println("Enter Employe Salary: ");
				int salary = sc.nextInt();
				boolean answer = insertToDB(name, phone, salary);
				if (answer) {
				} else {
					System.out.println("Something went wrong try again");
				}
			}

			if (c == 2) {
				// Delete Person
				boolean answer = delfromDb();
				if (answer) {
					System.out.println("Employe is Terminated sucessfully");
				} else {
					System.out.println("Something went wrong try again");
				}
			} else if (c == 3) {
				// Display students
				boolean answer = showDb();
				if (!answer) {
					System.out.println("!!!!!.....Data Not Found");
				}

			} else if (c == 4) {
				boolean result = incrementEmployee();
				if (result) {
					System.out.println("Employee Salary updated");
				} else {
					System.out.println("Employee not Found");
				}
			} else if (c == 5) {
				// Exit
				break;
			}
		}
		System.out.println("Goodbye");

	}

	public static boolean insertToDB(String name1, int phone1, int salary) throws Exception {
		boolean f = false;
		String temp;
		try {

			System.out.println("Enter Employee ID");
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			Statement pstmt = conn.createStatement();
			temp = "insert into emp_info values(" + id + ",'" + name1 + "', " + phone1 + ", '" + salary + "')";
			pstmt.executeUpdate(temp);
			System.out.println("Employe is added succesfully");
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean delfromDb() throws Exception {
		boolean f = false;
		String temp;
		try {
			System.out.println("Enter Employe ID");
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			// execute
			temp = "delete from emp_info where id=" + id;
			Statement stmt = conn.createStatement();
			int p = stmt.executeUpdate(temp);
			if (p != 0) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean showDb() throws Exception {
		boolean f = false;
		String temp = "";
		try {
			temp = "select * from emp_info";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(temp);
			// System.out.println(""+rs);
			while (rs.next()) {
				String tableName = rs.getString(1); // Assuming the table name is in the first column
				String tableName1 = rs.getString(2);
				String tableName2 = rs.getString(3);
				String tableName3 = rs.getString(4);
				System.out.println("Employee_ID: " + tableName + "  Name: " + tableName1 + "  phone: " + tableName2
						+ "  Salary: " + tableName3);
				f = true;
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean incrementEmployee() throws Exception {
		boolean result = false;
		System.out.println("Enter Employe Id : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("Enter Employe Salary : ");
		int salary = sc.nextInt();

		Statement pstmt = conn.createStatement();
		String temp = "update emp_info set salary=" + salary + " where id=" + id;
		int count = pstmt.executeUpdate(temp);
		if (count != 0) {
			result = true;
		}
		return result;
	}
}
