package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");//����̹� Ŭ����
		//Connection Ŭ�������� Connection conn= new XXX();
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://blueskii.iptime.org:3306/team3", 
				"team3","123456"
		);//���� �߻��ؼ� Connection conn= null�̸� �ǹ̰� �����ϱ� ��������.
		return conn;
	}

}
