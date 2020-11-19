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

/**
 * Servlet implementation class Editmarks
 */
@WebServlet("/Editmarks")
public class Editmarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editmarks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		String id = session.getAttribute("id").toString();
		String mark1 = request.getParameter("mark1");
		String mark2 = request.getParameter("mark2");
		String mark3 = request.getParameter("mark3");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			
			PreparedStatement stmt = conn.prepareStatement("update student set mark1 = ?, mark2 = ?, mark3 = ? where id = ?;");
			stmt.setInt(1, Integer.parseInt(mark1));
			stmt.setInt(2, Integer.parseInt(mark2));
			stmt.setInt(3, Integer.parseInt(mark3));
			stmt.setInt(4, Integer.parseInt(id));
			stmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.print(e);
		}
			int[] marks = new int[3];
			marks[0] = Integer.parseInt(mark1);
			marks[1] = Integer.parseInt(mark2);
			marks[2] = Integer.parseInt(mark3);
			session.setAttribute("marks", marks);
			response.sendRedirect("/Servlet_Prac/menu.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
