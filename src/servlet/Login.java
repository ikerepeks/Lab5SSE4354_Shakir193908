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
import java.util.Base64;

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
			PreparedStatement stmt = conn.prepareStatement("select pw from student where id = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
	
			while (rs.next()) {
				session.setMaxInactiveInterval(5*60);
				String holder = rs.getString("pw");
				holder = new String(Base64.getDecoder().decode(holder));
				if (pw.equals(holder)) {
					session.setAttribute("id", id);
					session.setAttribute("pw", pw);
					response.sendRedirect(request.getContextPath() + "/StudentList");
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
