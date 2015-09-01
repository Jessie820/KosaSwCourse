package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");//드라이버 클래스
		//Connection 클래스에서 Connection conn= new XXX();
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://blueskii.iptime.org:3306/team3", 
				"team3","123456"
		);//예외 발생해서 Connection conn= null이면 의미가 없으니까 던져버림.
		return conn;
	}

}
