package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.implement.QuestionService;

/**
 * Servlet implementation class AlterOptionServlet
 */
@WebServlet("/AlterOptionServlet")
public class AlterOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterOptionServlet() {
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
		String number = request.getParameter("number");
		String option = request.getParameter("option");
		String content = request.getParameter("content");
		QuestionService questionService = new QuestionService();
		int f = 0;
		if(isNumeric(number) && isOption(option) && (!content.equals(""))){
			try {
				ResultSet rs = questionService.getTest();
				int num = Integer.valueOf(number);
				while(rs.next()){
					if(num == rs.getInt("number")){
						f=1;
						questionService.alterOption(num, option, content);
						request.getRequestDispatcher("WEB-INF/pages/AlterOptionSucceed.jsp").forward(request, response);
					}
				}
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(f== 0){
			request.getRequestDispatcher("WEB-INF/pages/AlterOptionFailed.jsp").forward(request, response);
		}
		
	}
	
	public boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
		    return false; 
		} 
		return true; 
	}
	
	public boolean isOption(String str){ 
		Pattern pattern = Pattern.compile("[A-D]"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
		    return false; 
		} 
		return true; 
	}

}
