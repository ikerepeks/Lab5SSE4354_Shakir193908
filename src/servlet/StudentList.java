package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.List;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/StudentList")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		int i = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			PreparedStatement stmt = conn.prepareStatement("select COUNT(name) as length from student");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String[] name = new String[rs.getInt("length")];
			
			PreparedStatement stmt1 = conn.prepareStatement("select name from student");
			ResultSet rs1 = stmt1.executeQuery();
				
				while (rs1.next()) {
				session.setAttribute("name", name);
				response.sendRedirect(request.getContextPath() + "/Marks");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		
		out.println("<h1></h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Go Post ").append(request.getContextPath());
	}

}
