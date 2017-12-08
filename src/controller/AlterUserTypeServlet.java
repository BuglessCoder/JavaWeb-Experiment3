package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.implement.UserService;

/**
 * Servlet implementation class AlterUserTypeServlet
 */
@WebServlet("/AlterUserTypeServlet")
public class AlterUserTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterUserTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String type = request.getParameter("type");		
		UserService userService = new UserService();
		PrintWriter out = response.getWriter();
		int f = 0;
		ResultSet rs;
		try {
			rs = userService.login();
			while(rs.next()){
				if(name.equals(rs.getString("username")) && (type.equals("normal") || type.equals("admin"))){
					f=1;
					userService.alterUserType(name, type);
					request.getRequestDispatcher("WEB-INF/pages/AlterUserTypeSucceed.jsp").forward(request, response);				
					break;
				}
			}
			if(f == 0){
				request.getRequestDispatcher("WEB-INF/pages/AlterUserTypeFailed.jsp").forward(request, response);	
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		
	}

}
