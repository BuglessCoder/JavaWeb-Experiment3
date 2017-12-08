package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.implement.UserService;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
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
		String adminUser = request.getParameter("adminUser");
		
		if(adminUser.equals("查看所有用户")){
			UserService userService = new UserService();
			List<Map> list =new ArrayList<Map>();
			try {
				ResultSet rs = userService.login();
				 while (rs.next()){  
					 String name = rs.getString("username");
					 String type = rs.getString("type");
					 Map map = new HashMap();   
		             map.put("name", name);
		             map.put("type", type);
		             list.add(map);
		             request.setAttribute("list",list);
				 }
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.getRequestDispatcher("WEB-INF/pages/ShowUser.jsp").forward(request, response);
		}
		else if(adminUser.equals("删除用户")){
			request.getRequestDispatcher("WEB-INF/pages/DeleteUser.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("WEB-INF/pages/AlterUserType.jsp").forward(request, response);
		}
	}

}
