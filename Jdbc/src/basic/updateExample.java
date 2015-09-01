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
			//?,?,?<-�Ű�����ȭ�� sql��
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "�������");
			pstmt.setString(2, "���� �����ּż� �����մϴ�");
			pstmt.setString(3, "�ƾƾƾƾƾƾ�");
			pstmt.setInt(4, 1);
			int rows = pstmt.executeUpdate();//������ insert�� ���� ��. insert���� update, delete � ����.
			
			System.out.println(rows + "���� ���� ������");
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


