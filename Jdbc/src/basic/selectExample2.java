package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectExample2 {

	public static void main(String[] args) {
		
		int pageNo  =1;
		int rowsPerPage = 10;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team0", 
					"team0","123456"

					);
			String sql = "select * from user0_boards order by board_no desc limit ?,?";
			//?,?,?<-매개변수화된 sql문
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*rowsPerPage);
			pstmt.setInt(2, rowsPerPage);
			ResultSet rs = pstmt.executeQuery();//select면 executeQuery!
			//ResultSet의 특징: 첫번째 행과 마지막 행에는 데이터가 없음
			//커서가 있는 그 행의 데이터만 읽을 수 있음
			while(rs.next()){
			
			int boardNo = rs.getInt("board_no");
			String boardTitle=rs.getString("board_title");
			String boardContent=rs.getString("board_content");
			Date boardDate=rs.getDate("board_date");
			String boardWriter=rs.getString("board_writer");
			int boardHitcount=rs.getInt("board_hitcount");
			
			System.out.println(boardNo+"\t"+boardTitle+"\t"+boardContent);
			
			}
			
			rs.close();
			
			//Prepared Statement와 달리 ResultSet은 공용적으로 쓸수 없음. 그래서 보통 resultset은 여기서 close함. 아래가 아니라.
			
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


