package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	
	Connection con;
	Statement sql;
	ResultSet rs;
	
	public ConnectDB(){
		
	}
	
	//连接数据库
	public Statement conSql(){	
		try {
			//1.使用MySql的JDBC驱动程序 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2.连接数据库
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lidawei?user=root&password=asdfghjkl;'&useUnicode=true&characterEncoding=utf-8");
			//3.创建Statement对象
			sql = con.createStatement();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return sql;
	}
}
