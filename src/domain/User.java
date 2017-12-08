package domain;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * @author lidawei
	 * 用户bean
	 */
	
	private String username;	//用户名
	private String password;	//密码
	private String type; 		//用户类型
	
	public User() {
		
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
}
