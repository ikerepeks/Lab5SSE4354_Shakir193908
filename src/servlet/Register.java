package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pw = request.getParameter("pw");
		String depart = request.getParameter("depart");
		int[] marks = {Integer.parseInt(request.getParameter("mark1")),Integer.parseInt(request.getParameter("mark2")),Integer.parseInt(request.getParameter("mark3"))};
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC",
				"root", "1234");

			PreparedStatement stmt = conn.prepareStatement("insert into student values (?,?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, depart);
			stmt.setInt(4, marks[0]);
			stmt.setInt(5, marks[1]);
			stmt.setInt(6, marks[2]);
			stmt.executeUpdate();
			response.sendRedirect("/Servlet_Prac/index.jsp");
		}catch (Exception e) {
		 System.out.print(e);	
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
