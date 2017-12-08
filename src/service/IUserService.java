package service;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IUserService {

	/**
	 * 注册服务
	 * @param name
	 * @param password
	 * @throws SQLException
	 */
	public void register(String name,String password) throws SQLException;
	
	/**
	 * 登录服务
	 * @return
	 * @throws SQLException
	 */
	public ResultSet login() throws SQLException;
	
	/**
	 * 删除用户（管理员权限）
	 * @param name
	 * @throws SQLException
	 */
	public void dropUser(String name) throws SQLException;
	
	/**
	 * 修改用户类型（管理员权限）
	 * @param name
	 * @param type
	 * @throws SQLException
	 */
	public void alterUserType(String name,String type) throws SQLException;
	
	
}
