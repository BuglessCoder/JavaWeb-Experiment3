package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Question;

public interface IQuestionDao {
	
	/**
	 * 查找全部试题
	 * @return 全部试题
	 * @throws SQLException
	 */
	public ResultSet selectAll() throws SQLException;
	
	/**
	 * 查找正确答案
	 * @return 正确答案
	 * @throws SQLException
	 */
	public ResultSet selectRight() throws SQLException;
	
	/**
	 * 插入试题
	 * @param num
	 * @param question
	 * @param answerA
	 * @param answerB
	 * @param answerC
	 * @param answerD
	 * @param rightAnswer
	 * @throws SQLException
	 */
	public void insert(int num,String question,String answerA,String answerB,
			String answerC,String answerD,String rightAnswer) throws SQLException;
	
	/**
	 * 根据题号删除试题
	 * @param num
	 * @throws SQLException
	 */
	public void delete(int num) throws SQLException;
	
	/**
	 * 根据题号修改选项
	 * @param num
	 * @param option
	 * @param newAnswer
	 * @throws SQLException
	 */
	public void updateOption(int num,String option,String content) throws SQLException;
	
	/**
	 * 根据题号修改正确答案
	 * @param num
	 * @param option
	 * @param rightAnswer
	 * @throws SQLException
	 */
	public void updateRightAnswer(int num,String rightAnswer) throws SQLException;
	
}
