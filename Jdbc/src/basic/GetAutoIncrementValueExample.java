package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAutoIncrementValueExample {

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
			//?,?,?<-�Ű�����ȭ�� sql��
			pstmt = conn.prepareStatement(sql, new String[]{"board_no"});
			//prepareStatement: sql�� �ؼ�
			//new String[]{"board_no"} �迭 �ȿ� ���ο� �迭 ���� ��
			//insert�ϰ� board_no�� ���� �����Ͷ�.
			pstmt.setString(1, "������ ȭ����");//varcharŸ���̴ϱ� string
			pstmt.setString(2, "������ �� ���� ������");
			pstmt.setString(3, "ȫ�浿");
			int row = pstmt.executeUpdate();//DML������ �� ��. ������ insert�� ���� ��. insert���� update, delete � ����.
			//������� �޾ƾ� �ϸ� executeQuery();��
			int boardNo =0;
			if(row ==1){
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					//int boardNo = rs.getInt("board_no"); �̷��� �ص� ������ �÷� �̸� �� �𸦶�
					boardNo = rs.getInt(1);
					
				}
				rs.close();
			}
			System.out.println(boardNo+ "�� �Խù��� �����");
			//������ 1~20���� ����. ���� ���� Ű�� 21���� ����
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}//���������� �ݵ�� ������ ��� �޸𸮸� ������!
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


