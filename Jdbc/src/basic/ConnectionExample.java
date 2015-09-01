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
					//tcp로 접근
					);
			
			//DriverManager.getConnection(url, user, password); 독립적인 코드
			//(url<-연결 문자열 또는 Connection String(Ip, Port, DB), user, password);
			System.out.println("연결 성공");
	
	}catch(Exception e){
		System.out.println("연결 실패");
	e.printStackTrace();
		
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {}
		}
	}

}

//이 구조 꼭 기억하기!!!

/*class OracleDriver{

 static {
 //자신의 객체를 생성
  OracleDriver driver = new OracleDriver();
  DriverManager.registerDriver(driver)
  	}
  }
 */
