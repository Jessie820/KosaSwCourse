package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team3", 
					"team3","123456"

					);
			String sql = "update user10_boards set board_title=?, board_content=?, board_writer=? where board_no=?";
			//?,?,?<-매개변수화된 sql문
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "배고프당");
			pstmt.setString(2, "일찍 보내주셔서 감사합니당");
			pstmt.setString(3, "아아아아아아아");
			pstmt.setInt(4, 1);
			int rows = pstmt.executeUpdate();//실제로 insert된 행의 수. insert말고 update, delete 등도 받음.
			
			System.out.println(rows + "개의 행이 수정됨");
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


