package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implement.QuestionDao;
import service.implement.QuestionService;
import util.ConnectDB;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	
	ConnectDB connectDB = new ConnectDB();
	Statement sql;
	ResultSet rs;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
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
		String Login = (String)request.getSession().getAttribute("Login");
		QuestionService questionService = new QuestionService();
		if(Login!= null && Login.equals("OK")){
			int sum = 0;
			int score = 0;
			String errorQues = "";
			ArrayList<String> strings = new ArrayList<String>();
			ArrayList<String> fromRS = new ArrayList<String>();
			ArrayList<Integer> number = (ArrayList<Integer>)request.getSession().getAttribute("Number");
			for(int i=1;i<=number.size();i++){
				strings.add(i-1,request.getParameter(i+""));
				if(strings.get(i-1).equals("")){
					strings.set(i-1,"");
				}
			}
			try {
				ResultSet rs = questionService.getRight();
				int i = 0;
				while(rs.next()){
					fromRS.add(i, rs.getString(1));
					i++;
				}
				for(int j=0;j<fromRS.size();j++){
					if (strings.get(j).equals(fromRS.get(j))){
						sum++;
						score+=20;
					}else{
						errorQues+=j+1+",";
					}
				}
				if(sum!=strings.size()){
					errorQues = errorQues.substring(0,errorQues.length()-1);
				}
			}catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			request.setAttribute("errorQues",errorQues);
			request.setAttribute("rightCount",sum);
			request.setAttribute("score",score);
			request.setAttribute("questionCount",strings.size());
			request.setAttribute("question",strings);
			request.setAttribute("fromRS",fromRS);
		
			request.getRequestDispatcher("WEB-INF/pages/Answer.jsp").forward(request, response);
			
		}
		else{	
			request.getRequestDispatcher("/LoginCheck.jsp").forward(request, response);
		}	
	}

}
