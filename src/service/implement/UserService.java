package service.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IUserDao;
import dao.implement.UserDao;
import service.IUserService;

public class UserService implements IUserService {
	
	private IUserDao userDao = new UserDao();

	@Override
	public void register(String name, String password) throws SQLException {
		// TODO 自动生成的方法存根
		userDao.insert(name, password);
	}

	@Override
	public ResultSet login() throws SQLException {
		// TODO 自动生成的方法存根
		return userDao.select();
	}

	@Override
	public void dropUser(String name) throws SQLException {
		// TODO 自动生成的方法存根
		userDao.delete(name);
	}

	@Override
	public void alterUserType(String name, String type) throws SQLException {
		// TODO 自动生成的方法存根
		userDao.update(name, type);
	}
	
	

}
