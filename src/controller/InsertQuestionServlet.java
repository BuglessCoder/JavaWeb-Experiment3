package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import service.implement.QuestionService;

/**
 * Servlet implementation class InsertQuestionServlet
 */
@WebServlet("/InsertQuestionServlet")
public class InsertQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestionServlet() {
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
		String question = request.getParameter("question");
		String answerA = request.getParameter("answerA");
		String answerB = request.getParameter("answerB");
		String answerC = request.getParameter("answerC");
		String answerD = request.getParameter("answerD");
		String rightAnswer = request.getParameter("rightAnswer");
		QuestionService questionService = new QuestionService();
		PrintWriter out = response.getWriter();
		
		if(isNumeric(number) && isOption(rightAnswer) && !question.equals("")&& !answerA.equals("")&& !answerB.equals("")
				&& !answerC.equals("")&& !answerD.equals("")){
			try {
				int num = Integer.valueOf(number);
				ResultSet rs = questionService.getTest();
				int f = 0;
				while(rs.next()){
					if(num == rs.getInt("number")){
						request.getRequestDispatcher("WEB-INF/pages/InsertQuestionFailed-NumberExists.jsp").forward(request, response);
						f = 1;
					}
				}
				if(f == 0){
					questionService.add(num, question, answerA, answerB, answerC, answerD, rightAnswer);
					request.getRequestDispatcher("WEB-INF/pages/InsertQuestionSucceed.jsp").forward(request, response);
				}
					
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		else{
			request.getRequestDispatcher("WEB-INF/pages/InsertQuestionFailed.jsp").forward(request, response);
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
