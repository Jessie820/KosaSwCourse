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
		);//���� �߻��ؼ� Connection conn= null�̸� �ǹ̰� �����ϱ� ��������.
		return conn;
	}

}
