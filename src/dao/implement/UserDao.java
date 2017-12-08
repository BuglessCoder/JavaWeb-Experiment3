package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.IUserDao;
import util.ConnectDB;

public class UserDao implements IUserDao {
	
	/**
	 * IUserDao的实现类
	 * @author lidawei
	 */
	
	Connection con;
	Statement sql;
	ResultSet rs;
	
	ConnectDB connectDB = new ConnectDB();
	
	//增加用户
	@Override
	public void insert(String name,String password) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("insert into t_user values('"+name+"','"+password+"','normal')");
	}
		
	//查找用户
	@Override
	public ResultSet select() throws SQLException{
		sql = connectDB.conSql();
		rs = sql.executeQuery("SELECT * FROM t_user");
		return rs; 
	}
	
	//删除用户
	@Override
	public void delete(String name) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("delete from t_user where username='"+name+"'");
	}
	
	//修改用户类型
	@Override
	public void update(String name,String type) throws SQLException{
		sql = connectDB.conSql();
		sql.executeUpdate("update t_user set type='"+type+"' where username='"+name+"'");
	}
}
