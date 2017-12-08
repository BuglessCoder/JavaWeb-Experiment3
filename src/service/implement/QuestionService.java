package service.implement;

import java.sql.ResultSet;

import java.sql.SQLException;

import dao.IQuestionDao;
import dao.implement.QuestionDao;
import service.IQuestionService;

public class QuestionService implements IQuestionService {
	
	private IQuestionDao questionDao = new QuestionDao();
	
	@Override
	public ResultSet getTest() throws SQLException {
		// TODO 自动生成的方法存根
		return questionDao.selectAll();
	}

	@Override
	public ResultSet getRight() throws SQLException {
		// TODO 自动生成的方法存根
		return questionDao.selectRight();
	}

	@Override
	public void add(int num, String question, String answerA, String answerB, String answerC, String answerD,
			String rightAnswer) throws SQLException {
		// TODO 自动生成的方法存根
		questionDao.insert(num, question, answerA, answerB, answerC, answerD, rightAnswer);
	}

	@Override
	public void drop(int num) throws SQLException {
		// TODO 自动生成的方法存根
		questionDao.delete(num);
	}

	@Override
	public void alterOption(int num, String option, String content) throws SQLException {
		// TODO 自动生成的方法存根
		questionDao.updateOption(num, option, content);
	}

	@Override
	public void alterRightAnswer(int num, String rightAnswer) throws SQLException {
		// TODO 自动生成的方法存根
		questionDao.updateRightAnswer(num, rightAnswer);
	}

}
