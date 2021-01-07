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
		
		if(session == null){
			 response.sendRedirect("index.jsp");
		 }else {
		String id = session.getAttribute("id").toString();
		String year = request.getParameter("year");
		String mark1 = request.getParameter("mark1");
		String mark2 = request.getParameter("mark2");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useTimezone=true&serverTimezone=UTC", "root", "1234");
			
			if (year.equals("1styear")) {
				PreparedStatement stmt = conn.prepareStatement("update student set mark11 = ?, mark12 = ? where id = ?;");
				stmt.setInt(1, Integer.parseInt(mark1));
				stmt.setInt(2, Integer.parseInt(mark2));
				stmt.setInt(3, Integer.parseInt(id));
				stmt.executeUpdate();
			} else if (year.equals("2ndyear")) {
				PreparedStatement stmt = conn.prepareStatement("update student set mark21 = ?, mark22 = ? where id = ?;");
				stmt.setInt(1, Integer.parseInt(mark1));
				stmt.setInt(2, Integer.parseInt(mark2));
				stmt.setInt(3, Integer.parseInt(id));
				stmt.executeUpdate();
			} else if (year.equals("3rdyear")) {
				PreparedStatement stmt = conn.prepareStatement("update student set mark31 = ?, mark32 = ? where id = ?;");
				stmt.setInt(1, Integer.parseInt(mark1));
				stmt.setInt(2, Integer.parseInt(mark2));
				stmt.setInt(3, Integer.parseInt(id));
				stmt.executeUpdate();
			}
			
			response.sendRedirect(request.getContextPath() + "/Marks");
			
		}catch(Exception e) {
			System.out.print(e);
		}
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
