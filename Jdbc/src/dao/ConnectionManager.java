package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
				"user10","12345"
		);//예외 발생해서 Connection conn= null이면 의미가 없으니까 던져버림.
		return conn;
	}

}
