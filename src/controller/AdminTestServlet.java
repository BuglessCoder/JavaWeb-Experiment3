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

import service.implement.QuestionService;
import service.implement.UserService;

/**
 * Servlet implementation class AdminTestServlet
 */
@WebServlet("/AdminTestServlet")
public class AdminTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTestServlet() {
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
		String adminTest = request.getParameter("adminTest");
		if(adminTest.equals("查看试题")){
			QuestionService questionService = new QuestionService();
			List<Map> list =new ArrayList<Map>();
			try {
				ResultSet rs = questionService.getTest();
				 while (rs.next()){  
					 int number = rs.getInt("number");
					 String question = rs.getString("question");
					 String answerA = rs.getString("answerA");
					 String answerB = rs.getString("answerB");
					 String answerC = rs.getString("answerC");
					 String answerD = rs.getString("answerD");
					 String rightAnswer = rs.getString("rightAnswer");
				
					 Map map = new HashMap();   
		             map.put("number", number);
		             map.put("question", question);
		             map.put("answerA",answerA);
		             map.put("answerB",answerB);
		             map.put("answerC",answerC);
		             map.put("answerD",answerD);
		             map.put("rightAnswer",rightAnswer);
		             list.add(map);
		             request.setAttribute("list",list);
				 }
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.getRequestDispatcher("WEB-INF/pages/ShowTest.jsp").forward(request, response);
		}
		else if(adminTest.equals("新增试题")){
			request.getRequestDispatcher("WEB-INF/pages/InsertQuestion.jsp").forward(request, response);
		}
		else if(adminTest.equals("删除试题")){
			request.getRequestDispatcher("WEB-INF/pages/DeleteQuestion.jsp").forward(request, response);
		}
		else if(adminTest.equals("修改试题选项")){
			request.getRequestDispatcher("WEB-INF/pages/AlterOption.jsp").forward(request, response);
		}
		else if(adminTest.equals("修改正确答案")){
			request.getRequestDispatcher("WEB-INF/pages/AlterRightAnswer.jsp").forward(request, response);
		}
	}

}
