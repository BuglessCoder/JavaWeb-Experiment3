package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IQuestionDao;
import util.ConnectDB;

public class QuestionDao implements IQuestionDao{
	Connection con;
	Statement sql;
	ResultSet rs;
	
	ConnectDB connectDB = new ConnectDB();
	
	//获取测试内容:查找试题
	@Override
	public ResultSet selectAll() throws SQLException{
		sql = connectDB.conSql();
		rs = sql.executeQuery("SELECT * FROM t_test");
		return rs; 
	}
		
	//判断正误:查找正确答案
	@Override
	public ResultSet selectRight() throws SQLException{
		sql = connectDB.conSql();
		rs = sql.executeQuery("SELECT rightAnswer FROM t_test");
		return rs;
	}
				
	//增加试题
	@Override
	public void insert(int num,String question,String answerA,String answerB,
		String answerC,String answerD,String rightAnswer) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("insert into t_test values("+num+",'"+question+"','"+answerA+"','"+answerB+"','"
				+answerC+"','"+answerD+"','"+rightAnswer+"')");
	}
				
	//根据题号删除试题
	@Override
	public void delete(int num) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("delete from t_test where number=" + num);
	}
				
	//根据题号修改选项的内容：修改试题
	@Override
	public void updateOption(int num,String option,String content) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("update t_test set answer"+option+"='"+content+"' where number="+num);
	}
		
	//根据题号修改正确答案：修改试题
	@Override
	public void updateRightAnswer(int num,String rightAnswer) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("update t_test set rightAnswer='"+rightAnswer+"' where number="+num);
	}
}
