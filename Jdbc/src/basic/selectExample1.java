package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectExample1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team3", 
					"team3","123456"

					);
			String sql = "select*from user10_boards where board_content like ?";
			//?,?,?<-�Ű�����ȭ�� sql��
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%����%");
			ResultSet rs = pstmt.executeQuery();//select�� executeQuery!
			//ResultSet�� Ư¡: ù��° ��� ������ �࿡�� �����Ͱ� ����
			//Ŀ���� �ִ� �� ���� �����͸� ���� �� ����
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
			
			//Prepared Statement�� �޸� ResultSet�� ���������� ���� ����. �׷��� ���� resultset�� ���⼭ close��. �Ʒ��� �ƴ϶�.
			
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


