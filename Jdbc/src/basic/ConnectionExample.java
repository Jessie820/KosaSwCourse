package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team3", 
					"team3","123456"
					//tcp�� ����
					);
			
			//DriverManager.getConnection(url, user, password); �������� �ڵ�
			//(url<-���� ���ڿ� �Ǵ� Connection String(Ip, Port, DB), user, password);
			System.out.println("���� ����");
	
	}catch(Exception e){
		System.out.println("���� ����");
	e.printStackTrace();
		
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {}
		}
	}

}

//�� ���� �� ����ϱ�!!!

/*class OracleDriver{

 static {
 //�ڽ��� ��ü�� ����
  OracleDriver driver = new OracleDriver();
  DriverManager.registerDriver(driver)
  	}
  }
 */
