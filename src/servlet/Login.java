package servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String avg = null;
		int[] marks = new int[3];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			PreparedStatement stmt = conn.prepareStatement("select (mark1 + mark2 + mark3)/3 as average, pw, mark1, mark2, mark3 from student where id = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
	
			while (rs.next()) {
				String holder = rs.getString("pw");
				avg = rs.getString("average");
				marks[0] = rs.getInt("mark1");
				marks[1] = rs.getInt("mark2");
				marks[2] = rs.getInt("mark3");
				if (pw.equals(holder)) {
					session.setAttribute("id", id);
					session.setAttribute("pw", pw);
					session.setAttribute("avg", avg);
					session.setAttribute("marks", marks);
					response.sendRedirect("/Servlet_Prac/menu.jsp");
				} else {
					out.print("<h1>Success5</h1>");
					System.out.print(id + pw);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		
		out.println("<h1></h1>");
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
