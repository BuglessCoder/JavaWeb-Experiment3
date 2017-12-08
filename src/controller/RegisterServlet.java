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

import dao.implement.UserDao;
import service.implement.UserService;
import util.MD5Util;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String Name = request.getParameter("username");
		String Password = request.getParameter("password");
		Password = new MD5Util().MD5(Password);
		PrintWriter out = response.getWriter();
		UserService userService = new UserService();
		
		try {
			ResultSet rs = userService.login();
			if(Name.equals("") || Password.equals("")){
				out.println("注册失败！<br />");
				out.println("请输入合法的用户名或密码!<br />");
				out.println("(3秒后自动跳转到注册页面)");
				response.setHeader("Refresh","3;URL=Register.jsp");
			}
			else{
				int f = 0;
				while(rs.next()){
					if(Name.equals(rs.getString("username"))){
						out.println("注册失败！<br />");
						out.println("该用户名已存在!<br />");
						out.println("(3秒后自动跳转到注册页面)");
						response.setHeader("Refresh","3;URL=Register.jsp");
						f = 1;
					}
				}
				if(f == 0){
					userService.register(Name, Password);
					out.println("注册成功！");
					out.println("(3秒后自动跳转到登录页面)");
					response.setHeader("Refresh","3;URL=Login.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
				
	}
}
