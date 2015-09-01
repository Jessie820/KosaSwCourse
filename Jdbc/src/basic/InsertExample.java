package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team3", 
					"team3","123456"

					);
			String sql = "insert into user10_boards(board_title, board_content, board_writer, board_date)values(?,?,?, now())";
			//?,?,?<-매개변수화된 sql문
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "오늘은 화요일");
			pstmt.setString(2, "오늘은 꼭 일찍 가야지");
			pstmt.setString(3, "홍길동");
			pstmt.executeUpdate();//실제로 insert된 행의 수. insert말고 update, delete 등도 받음.
			
			System.out.println("1개의 행이 저장됨");
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


