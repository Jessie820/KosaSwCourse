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
			//?,?,?<-매개변수화된 sql문
			pstmt = conn.prepareStatement(sql, new String[]{"board_no"});
			//prepareStatement: sql문 해석
			//new String[]{"board_no"} 배열 안에 새로운 배열 만들 때
			//insert하고 board_no의 값을 가져와라.
			pstmt.setString(1, "오늘은 화요일");//varchar타입이니까 string
			pstmt.setString(2, "오늘은 꼭 일찍 가야지");
			pstmt.setString(3, "홍길동");
			int row = pstmt.executeUpdate();//DML실행할 때 씀. 실제로 insert된 행의 수. insert말고 update, delete 등도 받음.
			//결과값을 받아야 하면 executeQuery();씀
			int boardNo =0;
			if(row ==1){
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					//int boardNo = rs.getInt("board_no"); 이렇게 해도 되지만 컬럼 이름 잘 모를때
					boardNo = rs.getInt(1);
					
				}
				rs.close();
			}
			System.out.println(boardNo+ "번 게시물이 저장됨");
			//시퀀스 1~20까지 소진. 컴터 꼈다 키면 21부터 시작
	
	}catch(Exception e){
	e.printStackTrace();
		
	}finally{
		try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}//실행했으면 반드시 연결을 끊어서 메모리를 비워줘야!
		try {conn.close();} catch (SQLException e) {}
		}
	}

}


