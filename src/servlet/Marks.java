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
 * Servlet implementation class Marks
 */
@WebServlet("/Marks")
public class Marks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Marks() {
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
			
			String id = session.getAttribute("id").toString();
			int[] marks = new int[6];
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC", "root", "1234");
				PreparedStatement stmt = conn.prepareStatement("select mark11, mark12, mark21, mark22, mark31, mark32 from student where id = ?");
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
		
				while (rs.next()) {
					marks[0] = rs.getInt("mark11");
					marks[1] = rs.getInt("mark12");
					marks[2] = rs.getInt("mark21");
					marks[3] = rs.getInt("mark22");
					marks[4] = rs.getInt("mark31");
					marks[5] = rs.getInt("mark32");
				}	
					session.setAttribute("marks", marks);
					System.out.println(id);
					response.sendRedirect("/Servlet_Prac/marks.jsp");
						
			} catch (Exception e) {
				System.out.println(e);
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
