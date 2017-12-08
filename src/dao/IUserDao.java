package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;

public interface IUserDao {
	
	/**
	 * 添加用户
	 * @param name
	 * @param password
	 * @throws SQLException
	 */
	public void insert(String name,String password) throws SQLException;
	
	/**
	 * 查找用户
	 * @return 查到的用户
	 * @throws SQLException
	 */
	public ResultSet select() throws SQLException;
	
	/**
	 * 删除用户
	 * @param name
	 * @throws SQLException
	 */
	public void delete(String name) throws SQLException;
	
	/**
	 * 修改用户类型
	 * @param name
	 * @param type
	 * @throws SQLException
	 */
	public void update(String name,String type) throws SQLException;

}
