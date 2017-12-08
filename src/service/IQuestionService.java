package service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQuestionService {
	
	/**
	 * 获取测试内容
	 * @return 全部试题
	 * @throws SQLException
	 */
	public ResultSet getTest() throws SQLException;
	
	/**
	 * 获取正确答案
	 * @return 正确答案
	 * @throws SQLException
	 */
	public ResultSet getRight() throws SQLException;
	
	/**
	 * 增加试题
	 * @param num
	 * @param question
	 * @param answerA
	 * @param answerB
	 * @param answerC
	 * @param answerD
	 * @param rightAnswer
	 * @throws SQLException
	 */
	public void add(int num,String question,String answerA,String answerB,
			String answerC,String answerD,String rightAnswer) throws SQLException;

	/**
	 * 删除试题
	 * @param num
	 * @throws SQLException
	 */
	public void drop(int num) throws SQLException;
	
	/**
	 * 修改试题的选项
	 * @param num
	 * @param option
	 * @param newAnswer
	 * @throws SQLException
	 */
	public void alterOption(int num,String option,String content) throws SQLException;
	
	/**
	 * 修改试题的正确答案
	 * @param num
	 * @param option
	 * @param rightAnswer
	 * @throws SQLException
	 */
	public void alterRightAnswer(int num,String rightAnswer) throws SQLException;
}
