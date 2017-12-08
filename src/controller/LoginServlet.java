package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.implement.QuestionService;
import service.implement.UserService;
import util.MD5Util;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		UserService userService = new UserService();
		QuestionService questionService = new QuestionService();
		
		String Name = request.getParameter("Name");
		String Password = new MD5Util().MD5(request.getParameter("Password"));
		int flag = 0;

		if (Name != null && Password != null) {
			try {
				ResultSet rs1 = userService.login();
				User user = new User();
				while(rs1.next()){
					user.setUsername(rs1.getString("username"));
					user.setPassword(rs1.getString("password"));
					user.setType(rs1.getString("type"));
					if (Name.equals(user.getUsername()) && Password.equals(user.getPassword())) {
						if(user.getType().equals("admin")){
							request.getRequestDispatcher("WEB-INF/pages/AdminMain.jsp").forward(request, response);
						}
						else{
							ResultSet rs2 = questionService.getTest();
							ArrayList<Integer> number = new ArrayList<Integer>();	//放题号
							ArrayList<String> aStrings = new ArrayList<String>();	//放题目、选项、答案
							int i = 0;
							while(rs2.next()){
								number.add(rs2.getInt(1));
								for(int j=0;j<6;j++){
									aStrings.add(i, rs2.getString(j+2));
									i++;
								}
							}
							request.getSession().setAttribute("Name",Name);
							request.getSession().setAttribute("Number",number);
							request.getSession().setAttribute("Question",aStrings);
							request.getSession().setAttribute("Login","OK");
							
							request.getRequestDispatcher("WEB-INF/pages/Qusetion.jsp").forward(request, response);
						}			
					}
					else{
						flag = 1;
					}
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		if(flag == 1){
			PrintWriter out = response.getWriter();
			out.println("登录失败！<br />");
			out.println("用户名或密码错误，请重新输入！<br />");
			out.println("(3秒后自动跳转到登录页面)");
			response.setHeader("Refresh","3;URL=Login.jsp");
		}
	}
	

}
