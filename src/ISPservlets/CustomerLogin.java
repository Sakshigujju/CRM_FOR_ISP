package ISPservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DbConnection.ConnectDB;


/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			doGet(request, response);
			String Cemail = request.getParameter("Cemail");
			String Cpassword = request.getParameter("Cpassword");
			Connection con = ConnectDB.dbCon();
		        
		        PreparedStatement ps = con.prepareStatement("select * from customer where Cemail= ? and Cpassword=?");
		       
				   ps.setString(1,Cemail);
				   ps.setString(2,Cpassword);
				   ResultSet rs= ps.executeQuery();
				   if (rs.next()) {
					   response.sendRedirect("Welcome.html");
					   User.setUemail(Cemail);
				   }
				   else{
					   response.sendRedirect("error.html");
				   }
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
